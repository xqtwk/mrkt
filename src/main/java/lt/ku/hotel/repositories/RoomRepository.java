package lt.ku.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lt.ku.hotel.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
	@Query("SELECT r FROM Room r WHERE r.is_reserved = 0")
	List<Room> findAllUnreservedRooms();
	
}
