package com.gpch.mongo.controller;
//pus

import com.gpch.mongo.model.Legend;
import com.gpch.mongo.service.LegendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LegendController {

    private final LegendService legendService;

    @Autowired
    public LegendController(LegendService legendService) {
        this.legendService = legendService;
    }


    @GetMapping("/legends")
    public Iterable<Legend> getAllLegends() {
        return legendService.getAllLegends();
    }
}