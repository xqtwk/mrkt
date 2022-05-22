package lt.ku.hotel.controller;

import lt.ku.hotel.entities.Client;
import lt.ku.hotel.entities.Room;
import lt.ku.hotel.services.BookingService;
import lt.ku.hotel.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookingController {
	@Autowired
	RoomService roomService;
	
	
	@Autowired
	BookingService bookingService;
	//@RequestMapping(value="room", method = RequestMethod.GET)
	@GetMapping("/reserve")
	public String getReservation(Model model,
			@RequestParam(required = false, value = "roomId") Integer roomId,
			@RequestParam(required = false, value = "arrivalDate") String arrival,
			@RequestParam(required = false, value = "departureDate") String departure,
			@RequestParam(required = false, value = "guestCount") Integer guestCount){
		try {
			if(roomId == null || arrival == null || departure == null || guestCount == null) {
				return "redirect:/";
				}
			boolean isReserved = roomService.isRoomReserved(roomId, arrival, departure, guestCount);
			if(isReserved) return "redirect:/";
			Room room = roomService.getRoom(roomId);
			model.addAttribute("roomId", roomId);
			model.addAttribute("roomPrice", room.getPrice());
			model.addAttribute("arrivalDate", arrival);
			model.addAttribute("departureDate", departure);
			model.addAttribute("guestCount", guestCount);
			long noOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.parse(arrival), LocalDate.parse(departure));
			model.addAttribute("dayCount", noOfDaysBetween);
			
			return "reservation";
		}catch(DateTimeParseException e) {
			return "redirect:/";
		}
		
	}
	@PostMapping("/reserve")
	public String addReservation(Model model,
			@RequestParam(required = false, value = "roomId") Integer roomId,
			@RequestParam(required = false, value = "arrivalDate") String arrival,
			@RequestParam(required = false, value = "departureDate") String departure,
			@RequestParam(required = false, value = "guestCount") Integer guestCount) {
		try {
			System.out.println(roomId + ' ' + arrival);
			if(roomId == null || arrival == null || departure == null || guestCount == null) {
			return "redirect:/";
			}
			boolean isReserved = roomService.isRoomReserved(roomId, arrival, departure, guestCount);
			if(isReserved) return "redirect:/";
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			//Client client = (Client) authentication.getPrincipal(); //atkomentuoti jei yra norima gaut PRISIJUNGUSIO kliento id
			//Integer userId = client.getId();
			
			return "redirect:/";
			
		}catch(DateTimeParseException e) {
			return "redirect:/";
		}
		
		
		
	}
	@GetMapping("/reservations")
	public String getReservations(Model model){
		return "reservations";
	}
}
