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


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}
	@PostMapping("/")
	public String submitForm(){

		return "index";
	}
}
