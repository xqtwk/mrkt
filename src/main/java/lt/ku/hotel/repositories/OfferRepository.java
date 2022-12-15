package lt.ku.hotel.repositories;

import lt.ku.hotel.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

}
