package com.gpch.mongo.controller;

import com.gpch.mongo.model.Manager;
import com.gpch.mongo.service.ManagerService;
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
public class ManagerThymeleafController {

    private final ManagerService managerService;
//    private Model Rating;

    @Autowired
    public ManagerThymeleafController(ManagerService managerService) {
        this.managerService = managerService;
    }




    @GetMapping("/managers-ui")
    public String managers(Model model) {
        model.addAttribute("managers", managerService.getAllManagers());
        return "managers";
    }



    @GetMapping("/delete-manager/{id}")
    public String removeManager(@PathVariable("id") String id, Model model) {
        managerService.deleteManagersById(id);
        model.addAttribute("managers", managerService.getAllManagers());
        return "managers";
    }

    @GetMapping(value = {"/edit-add-manager/{id}", "/edit-add-manager"})
    public String editManager(@PathVariable("id") Optional<String> id, Model model) {
        Manager manager = id.isPresent() ?
                managerService.findManagersById(id.get()).get() : new Manager();
        model.addAttribute("manager", manager);
        return "add-edit-manager";
    }

    @PostMapping("/save-manager")
    public String editManager(@ModelAttribute("manager") @Valid Manager manager,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-edit-manager";
        }
       managerService.saveManager(manager);
        return "redirect:managers-ui";
    }
}