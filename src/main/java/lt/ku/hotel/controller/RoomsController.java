package lt.ku.hotel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.ku.hotel.services.RoomService;
@RequestMapping("/rooms")
@Controller
public class RoomsController {
	@Autowired
	RoomService roomService;
	
	
	@GetMapping("/")
	public String allUnreservedRoomsList(Model model) {
		model.addAttribute("rooms", roomService.getAllUnreservedRooms());
		return "room_list";
	}
}
