//package com.gpch.mongo.controller;
//
//public class TeamThymeleafController {
//}


package com.gpch.mongo.controller;

import com.gpch.mongo.model.Team;
import com.gpch.mongo.service.TeamService;
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
public class TeamThymeleafController {

    private final TeamService teamService;
//    private Model Rating;

    @Autowired
    public TeamThymeleafController(TeamService teamService) {
        this.teamService = teamService;
    }




    @GetMapping("/teams-ui")
    public String teams(Model model) {
        model.addAttribute("teams", teamService.getAllTeams());
        return "teams";
    }



    @GetMapping("/delete-team/{id}")
    public String removeTeam(@PathVariable("id") String id, Model model) {
        teamService.deleteTeamsById(id);
        model.addAttribute("teams", teamService.getAllTeams());
        return "teams";
    }

    @GetMapping(value = {"/edit-add-team/{id}", "/edit-add-team"})
    public String editTeam(@PathVariable("id") Optional<String> id, Model model) {
       Team team = id.isPresent() ?
               teamService.findTeamsById(id.get()).get() : new Team();
        model.addAttribute("team", team);
        return "add-edit-team";
    }

    @PostMapping("/save-team")
    public String editTeam(@ModelAttribute("team") @Valid Team team,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-edit-team";
        }
        teamService.saveTeam(team);
        return "redirect:teams-ui";
    }
}
