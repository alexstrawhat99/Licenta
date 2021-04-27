package com.gpch.mongo.controller;

import com.gpch.mongo.model.Manager;
import com.gpch.mongo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }


    @GetMapping("/managers")
    public Iterable<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }


}