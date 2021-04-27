package com.gpch.mongo.service;

import com.gpch.mongo.model.Team;
import com.gpch.mongo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService{


    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void saveTeam(Team team){
        teamRepository.save(team);
    }

    public Iterable<Team> getAllTeams(){
//
        return teamRepository.findAll();
    }

    public void deleteAllTeams(){
        teamRepository.deleteAll();
    }

    public void deleteTeamsById(String id){
       teamRepository.deleteById(id);
    }

    public Optional<Team>findTeamsById(String id){
        return teamRepository.findById(id);
    }

    public void saveAll(List<String> teams) {
    }


}