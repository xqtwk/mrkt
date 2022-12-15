package lt.ku.hotel.services;


import lt.ku.hotel.entities.Game;
import lt.ku.hotel.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    public List<Game> getGame(){
        return gameRepository.findAll();
    }
    public Game getGame(Integer id){
        return gameRepository.getById(id);
    }
    public Game add(Game registration){
        return gameRepository.save(registration);
    }
    public Game update(Game game){
        Game old = this.getGame(game.getId());
        gameRepository.save(old);
        return old;
    }
    public void delete(Integer id){
        gameRepository.deleteById(id);
    }
}