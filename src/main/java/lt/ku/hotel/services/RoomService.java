package lt.ku.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ku.hotel.entities.Room;
import lt.ku.hotel.repositories.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	
	public List<Room> getAllRooms(){
		return roomRepository.findAll();
	}
	public List<Room> getAllUnreservedRooms(){
		return roomRepository.findAllUnreservedRooms();
	}
	public Room getRoom(Integer id) {
		return roomRepository.getById(id);
	}
	public Room addRoom(Room room) {
		return roomRepository.save(room);
	}
	
	public Room updateRoom(Room room) {
		Room old = roomRepository.getById(room.getId());
		old.setDescription(room.getDescription());
		old.setGuest_limit(room.getGuest_limit());
		old.setIs_reserved(room.isIs_reserved());
		old.setPrice(room.getPrice());
		old.setRoom_size(room.getRoom_size());
		old.setThumbnail(room.getThumbnail());
		
		return old;
	}
	
	public void deleteRoom(Integer id) {
		roomRepository.deleteById(id);
	}
	
}
