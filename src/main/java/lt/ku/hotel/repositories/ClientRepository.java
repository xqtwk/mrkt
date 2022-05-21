package lt.ku.hotel.repositories;

import lt.ku.hotel.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
    
}
