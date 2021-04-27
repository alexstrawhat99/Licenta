package com.gpch.mongo.controller;

import com.gpch.mongo.model.Legend;
import com.gpch.mongo.service.LegendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//import javax.validation.Valid;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LegendThymeleafController {

    private final LegendService legendService;
//    private Model Rating;

    @Autowired
    public LegendThymeleafController(LegendService legendService) {
        this.legendService = legendService;
    }




    @GetMapping("/legends-ui")
    public String legends(Model model) {
        model.addAttribute("legends", legendService.getAllLegends());
        return "legends";
    }



    @GetMapping("/delete-legend/{id}")
    public String removeLegend(@PathVariable("id") String id, Model model) {
        legendService.deleteLegendsById(id);
        model.addAttribute("legends", legendService.getAllLegends());
        return "legends";
    }

    @GetMapping(value = {"/edit-add-legend/{id}", "/edit-add-legend"})
    public String editLegend(@PathVariable("id") Optional<String> id, Model model) {
        Legend legend = id.isPresent() ?
                legendService.findLegendsById(id.get()).get() : new Legend();
        model.addAttribute("legend", legend);
        return "add-edit-legend";
    }

    @PostMapping("/save-legend")
    public String editLegend(@ModelAttribute("legend") @Valid Legend legend,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-edit-legend";
        }
        legendService.saveLegend(legend);
        return "redirect:legends-ui";
    }
}