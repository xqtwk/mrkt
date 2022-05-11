package lt.ku.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ku.hotel.entities.RoomType;
import lt.ku.hotel.repositories.RoomTypeRepository;

@Service
public class RoomTypeService {
	@Autowired
	RoomTypeRepository roomTypeRepository;
	
	public List<RoomType> getRoomTypes(){
		return roomTypeRepository.findAll();
	}
	
	public RoomType getRoomType(Integer id) {
		return roomTypeRepository.getById(id);
	}
	
	public RoomType addRoomType(RoomType roomType) {
		return roomTypeRepository.save(roomType);
	}
	
	public void deleteRoomType(Integer id) {
		roomTypeRepository.deleteById(id);
	}
	
	public RoomType updateRoomType(RoomType roomType) {
		RoomType old = this.getRoomType(roomType.getId());
		old.setType(roomType.getType());
		return roomTypeRepository.save(old);
	}
}
