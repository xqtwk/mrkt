package lt.ku.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ku.hotel.entities.Gender;
import lt.ku.hotel.repositories.GenderRepository;

@Service
public class GenderService {

	@Autowired
	GenderRepository genderRepository;
	
	public List<Gender> getAllGenders(){
		return genderRepository.findAll();
	}
	
	public Gender getGender(Integer id) {
		return genderRepository.getById(id);
	}
	
	public void deleteGender(Integer id) {
		genderRepository.deleteById(id);
	}
	
	public Gender addGender(Gender gender) {
		return genderRepository.save(gender);
	}
	public Gender updateGender(Gender gender) {
		Gender old = genderRepository.getById(gender.getId());
		old.setName(gender.getName());
		return old;
	}
}
