package lt.ku.hotel.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import lt.ku.hotel.entities.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{

}
