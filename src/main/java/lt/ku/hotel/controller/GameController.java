package lt.ku.hotel.controller;

import lt.ku.hotel.entities.Game;
import lt.ku.hotel.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/games")
public class GameController {
    @Autowired
    GameService gameService;
    @GetMapping("/")
    public String game(Model model){
        model.addAttribute("games", gameService.getGame());
        return "games";
    }
    @GetMapping("/new")
    public String gameNew(Model model){
        return "new_game";
    }
    @PostMapping("/new")
    public String addGame(
            @RequestParam("name") String name){
        Game c = new Game(name);
        c = gameService.add(c);
        return "redirect:/games/";
    }
    @GetMapping("/update/{id}")
    public String gameNew(@PathVariable("id") Integer id, Model model){
        model.addAttribute("game",gameService.getGame(id));
        return "update_game";
    }
    @PostMapping("/update/{id}")
    public String gameUpdate(@PathVariable("id") Integer id, @ModelAttribute Game c){
        gameService.update(c);
        return "redirect:/games/";
    }
    @GetMapping("/delete/{id}")
    public String gameDelete(@PathVariable("id") Integer id){
        gameService.delete(id);
        return "redirect:/games/";
    }
}
