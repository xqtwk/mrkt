package lt.ku.hotel.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import lt.ku.hotel.entities.SearchForm;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("searchForm", new SearchForm());
		return "home";
	}
	@PostMapping("/")
	public String submitForm(
			@Valid 
			@ModelAttribute SearchForm searchForm,
			BindingResult result,
			Model model,
			 final RedirectAttributes redirectAttrs) {
		if(result.hasErrors()) {
			model.addAttribute("search", new SearchForm());
			System.out.println(result.toString());
			return "home";
		}
		String url = UriComponentsBuilder.fromUriString("/rooms")
				.queryParam("arrival", searchForm.getArrivalDate())
				.queryParam("departure", searchForm.getDepartureDate())
				.queryParam("guestCount", searchForm.getGuestCount().toString())
				.build().toUriString();
		return "redirect:"+url;
	}
}
