package lt.ku.hotel.services;

import lt.ku.hotel.entities.User;
import lt.ku.hotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        user.setPassword((new BCryptPasswordEncoder()).encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User updateUsers(User user){
        User old = userRepository.getById(user.getId());
        old.setName(user.getName());
        old.setSurname(user.getSurname());
        old.setEmail(user.getEmail());
        old.setPhone(user.getPhone());
        userRepository.save(old);
        return old;
    }
    public void deleteUsers( Integer id){
        userRepository.deleteById(id);
    }
    public User getUsers(Integer id){
        return userRepository.getById(id);
    }
    public List<User> getAllUsers() { return userRepository.findAll(); }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user ==null) {
            throw new UsernameNotFoundException("Vartotojas nerastas");
        }
        return user;
    }
}
