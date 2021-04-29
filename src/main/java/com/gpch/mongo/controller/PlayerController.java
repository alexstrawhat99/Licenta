package com.gpch.mongo.controller;
//pus
import com.gpch.mongo.model.Player;
import com.gpch.mongo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("/players")
    public Iterable<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }


    //pus
//    @GetMapping("/players")
//    public Iterable<Player> findByNameAndTeam() {
//        return playerService.getAllPlayers();
//    }







//display the data in raw format (json format)


}