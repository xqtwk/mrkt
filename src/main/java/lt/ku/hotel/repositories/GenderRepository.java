package lt.ku.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.ku.hotel.entities.Gender;

public interface GenderRepository extends JpaRepository<Gender, Integer>{

}
