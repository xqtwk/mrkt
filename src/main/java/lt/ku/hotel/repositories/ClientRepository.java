package lt.ku.hotel.repositories;

<<<<<<< HEAD
public interface ClientRepository {
=======
import lt.ku.hotel.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> f0ee823e4232831e526817dfd45baca12ba78e00

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByUsername(String username);
}
