package com.gpch.mongo.controller;

import com.gpch.mongo.model.Player;
import com.gpch.mongo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PlayerThymeleafController {

    private final PlayerService playerService;
//    private Model Rating;

    @Autowired
    public PlayerThymeleafController(PlayerService playerService) {
        this.playerService = playerService;
    }




    @GetMapping("/players-ui")
    public String players(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "players";
    }



    @GetMapping("/delete-player/{id}")
    public String removePlayer(@PathVariable("id") String id, Model model) {
        playerService.deletePlayerById(id);
        model.addAttribute("players", playerService.getAllPlayers());
        return "players";
    }

    @GetMapping(value = {"/edit-add-player/{id}", "/edit-add-player"})
    public String editPlayer(@PathVariable("id") Optional<String> id, Model model) {
        Player player = id.isPresent() ?
                playerService.findPlayerById(id.get()).get() : new Player();
        model.addAttribute("player", player);
        return "add-edit";
    }

    @PostMapping("/save-player")
    public String editPlayer(@ModelAttribute("player") @Valid Player player,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-edit";
        }
        playerService.savePlayer(player);
        return "redirect:players-ui";
    }
}
//display the UI (Thymeleaf)