package com.gpch.mongo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class PageController {
//pus de mn



    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping("/homepage")
    public ModelAndView homepage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homepage");

        return modelAndView;
    }


    @RequestMapping("/about")
    public ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("about");
        return modelAndView;
    }



    @RequestMapping("/players")
    public ModelAndView players() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("players");
        return modelAndView;
    }


    @RequestMapping("/logout")
    public ModelAndView logout() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logout");
        return modelAndView;
    }










}
