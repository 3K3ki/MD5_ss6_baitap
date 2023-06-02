package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.model.enttity.Picture;
import ra.model.service.IPictureService;

import java.util.List;

@Controller
public class PictureController {
@Autowired
private IPictureService pictureService;
//@PostMapping("/createP")
//    public String createP(@RequestParam("mark")int mark, @RequestParam("author")String author, @RequestParam("feedback")String feedback, Model model){
//    Picture p = new Picture(mark,author,feedback);
//    pictureService.save(p);
//    return "redirect:";
//}
//@GetMapping("/listPicture")
//public String showForm(Model model){
//    List<Picture> list = pictureService.findAll();
//    model.addAttribute("list",list);
//    return "/pictureView";
//}
}
