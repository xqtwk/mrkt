package lt.ku.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt.ku.hotel.entities.City;

public interface CityRepository extends JpaRepository<City, Integer>{
	@Query("SELECT c from City c ORDER BY c.name ASC")
	List<City> findAllCitiesByAsc();
}
