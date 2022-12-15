package lt.ku.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class AdminPanelController {
    @GetMapping("/admin")
    public String adminPanel(Model model) {

        return "admin";
    }
    @PostMapping("/admin")
    public String submitForm(){

        return "admin";
    }

}
