package lt.ku.hotel.controller;

import javax.validation.Valid;

import lt.ku.hotel.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import lt.ku.hotel.services.UserService;


@Controller
public class RegisterController {
	
	@Autowired
	UserService clientService;
	

	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/register")
	public String newClient(
			@Valid
			@ModelAttribute User user,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			return "register";
		}
		clientService.addUser(user);
		return "redirect:/";
	}
	
	
}
