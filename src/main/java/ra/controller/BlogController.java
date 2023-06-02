package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.model.enttity.Blog;
import ra.model.service.IBlogService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/blog")
@CrossOrigin(origins = "*")
public class BlogController {
    @Autowired
    public IBlogService blogService;

    //    @GetMapping("/")
//    public String showList(Model model){
//        List<Blog> blogs=blogService.findAll();
//        model.addAttribute("list",blogs);
//        return "/index";
//    }
    @GetMapping
    public ResponseEntity<List<Blog>> findAll() {
        List<Blog> list = (List<Blog>) blogService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/formCreate")
    public String formCreate(Model model) {
        Blog b = new Blog();
        model.addAttribute("b", b);
        return "/createBlog";
    }

    //    @PostMapping("/create")
//    public String create(@ModelAttribute("b")Blog b){
//        blogService.save(b);
//        return "redirect:/";
//    }
    @PostMapping("/create")
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        Blog s = blogService.save(blog);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Long id) {
        Optional<Blog> studentOptional = blogService.findById(id);
        if (studentOptional.isPresent()) {
            blogService.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        Blog b = blogService.findById(id);
//        model.addAttribute("b", b);
//        return "/edit";
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable("id") Long id) {
        Optional<Blog> studentOptional = blogService.findById(id);
        if (studentOptional.isPresent()) {
            return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> update(@PathVariable("id") Long id, @RequestBody Blog blog) {
        Optional<Blog> studentOptional = blogService.findById(id);
        if (studentOptional.isPresent()) {
            blog.setId(id);
            blogService.save(blog);
            return new ResponseEntity<>(blog, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("searchByPicId/{id}")
    public ResponseEntity<List<Blog>> searchByCatalogId(@PathVariable("id") Long id){
        List<Blog> list = (List<Blog>) blogService.searchByCatalogId(id);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
}
