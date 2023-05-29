package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.model.enttity.Blog;
import ra.model.service.IBlogService;
import java.util.List;


@Controller
public class BlogController {
    @Autowired
    public IBlogService blogService;
    @GetMapping("/")
    public String showList(Model model){
        List<Blog> blogs=blogService.findAll();
        model.addAttribute("list",blogs);
        return "/index";
    }
    @GetMapping("/formCreate")
    public String formCreate(Model model){
        Blog b = new Blog();
        model.addAttribute("b",b);
        return "/createBlog";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("b")Blog b){
        blogService.save(b);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id){
        blogService.remove(id);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id")Long id,Model model){
        Blog b = blogService.findById(id);
        model.addAttribute("b",b);
        return "/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("b")Blog b){
        blogService.save(b);
        return "redirect:/";
    }
}
