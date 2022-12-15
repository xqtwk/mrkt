package lt.ku.hotel.entities;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
