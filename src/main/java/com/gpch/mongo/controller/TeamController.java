package com.gpch.mongo.controller;//package com.gpch.mongo.controller;
//
//public class TeamController {
//}

import com.gpch.mongo.model.Team;
import com.gpch.mongo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping("/teams")
    public Iterable<Team> getAllTeams() {

        return teamService.getAllTeams();
    }
}