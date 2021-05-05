package com.gpch.mongo.service;
import com.gpch.mongo.model.Player;
import com.gpch.mongo.repository.PlayerRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {


    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void savePlayer(Player player){
        playerRepository.save(player);
    }

    public Iterable<Player> getAllPlayers(){
//
        return playerRepository.findAll();
    }

    public void deleteAllPlayers(){
        playerRepository.deleteAll();
    }

    public void deletePlayerById(String id){

        playerRepository.deleteById(id);
    }

    public Optional<Player> findPlayerById(String id){
        return playerRepository.findById(id);
    }

    public void saveAll(List<String> players) {
    }

//    public Iterable<Player> findByNameAndTeam(){
//       return playerRepository.findAll();
//    }

    




}