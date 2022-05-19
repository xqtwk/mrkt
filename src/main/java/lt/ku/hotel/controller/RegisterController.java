package lt.ku.hotel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.ku.hotel.entities.Client;
import lt.ku.hotel.services.ClientService;

@Controller
public class RegisterController {
	
	@Autowired
	ClientService clientService;
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("client", new Client());
		return "register";
	}
	@PostMapping("/register")
	public String newClient(
			@Valid
			@ModelAttribute Client client,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			return "register";
		}
		clientService.addClient(client);
		return "redirect:/";
	}
	
	
}
