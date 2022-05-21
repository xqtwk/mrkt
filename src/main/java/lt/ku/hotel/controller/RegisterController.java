package lt.ku.hotel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.ku.hotel.entities.Client;
import lt.ku.hotel.services.CityService;
import lt.ku.hotel.services.ClientService;
import lt.ku.hotel.services.GenderService;

@Controller
public class RegisterController {
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	CityService cityService;
	
	@Autowired
	GenderService genderService;
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("cities", cityService.getAllCities());
		model.addAttribute("genders", genderService.getAllGenders());
		return "register";
	}
	@PostMapping("/register")
	public String newClient(
			@Valid
			@ModelAttribute Client client,
			BindingResult result,
			@RequestParam("cityId") Integer cityId,
			@RequestParam("genderId") Integer genderId,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("cities", cityService.getAllCities());
			model.addAttribute("genders", genderService.getAllGenders());
			return "register";
		}
		client.setCity(cityService.getCity(cityId));
		client.setGender(genderService.getGender(genderId));
		clientService.addClient(client);
		return "redirect:/";
	}
	
	
}
