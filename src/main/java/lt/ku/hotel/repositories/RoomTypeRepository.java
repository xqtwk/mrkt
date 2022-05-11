package lt.ku.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.ku.hotel.entities.RoomType;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer>{
	List<RoomType> findAllById(Integer id);
}
