package lt.ku.hotel.entities;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 64)
    private String name;
    @Column(nullable = false, length = 64)
    private String offer_date;
    @Column(length = 64)
    private String telegram;
    @Column(length = 1024)
    private String description;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public Offer(){}

    public Offer(String name, String date, Integer places, Game game) {
        this.name = name;
        this.offer_date = date;
    }
    public Offer(String name, Game game, String telegram) {
        this.name = name;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.offer_date = dateFormat.format(date);
        this.telegram = telegram;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getOffer_date() {
        return offer_date;
    }

    public void setOffer_date() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.offer_date = dateFormat.format(date);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public Game getGame() {
        return game;
    }
}
