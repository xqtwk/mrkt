package lt.ku.hotel.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.ku.hotel.services.RoomService;

@Controller
public class RoomsController {
	@Autowired
	RoomService roomService;
	
	
	@GetMapping("/rooms*")
	public String allUnreservedRoomsList(Model model,
			@RequestParam(required = false) String arrival,
			@RequestParam(required = false) String departure,
			@RequestParam(required = false) String guestCount) {
		if(arrival == null || departure == null || guestCount == null) {
			return "redirect:/";
		}
		model.addAttribute("rooms", roomService.getAllUnreservedRooms(arrival, departure, guestCount));
		
		return "room_list";
	}
}
