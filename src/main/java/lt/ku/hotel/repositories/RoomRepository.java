package lt.ku.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.ku.hotel.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{

}
