package lt.ku.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {
	
	@GetMapping("/reserve")
	public String getReservation(Model model) {
		return "reservation";
	}
}
