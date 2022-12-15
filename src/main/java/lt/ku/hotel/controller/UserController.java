package lt.ku.hotel.controller;

import lt.ku.hotel.entities.User;
import lt.ku.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public String index(Model model){
        model.addAttribute("users", userService.getAllUsers()); // for if in thymeleaf
        return "users";
    }
    @GetMapping("/new")
    public String userNew(Model model){
        model.addAttribute(model.addAttribute("user", new User()));
        return "new_user";
    }
    @PostMapping("/new")
    public String addUser(@Valid @ModelAttribute(value = "user") User user, BindingResult result, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email,
                            @RequestParam("phone")String phone){
        if (result.hasErrors()){
            //model.addAttribute(model.addAttribute("user", new User()));
            //model.addAttribute("user", userService.getUser(user.getId()));
            return "new_user";
        }else{
            user.setName(name);
            user.setPhone(phone);
            user.setEmail(email);
            user.setSurname(surname);
            //User c = new User(name,surname,email,phone);
            userService.addUser(user);
            return "redirect:/user/";}
    }
    @GetMapping("/update")
    public String userNew(@RequestParam("id") Integer id, Model model){
        model.addAttribute("user",userService.getUsers(id));
        return "edit_user";
    }
    @PostMapping("/update")
    public String userUpdate(@ModelAttribute User c){
        userService.updateUsers(c);
        return "redirect:/users";
    }
    @GetMapping("/delete")
    public String userDelete(Model model, @RequestParam("id") Integer id){
        userService.deleteUsers(id);
        return "redirect:/users";
    }



}
