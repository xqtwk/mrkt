package lt.ku.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.ku.hotel.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
}
