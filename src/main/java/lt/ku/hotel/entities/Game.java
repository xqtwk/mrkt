package lt.ku.hotel.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 64)
    private String name;
    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Offer> offers;
    public Game() {}

    public Game(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setGame(String name) {
        this.name = name;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}