package com.gpch.mongo.controller;

import java.io.IOException;
import java.util.Base64;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.gpch.mongo.model.Photo;
import com.gpch.mongo.service.PhotoService;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/photos/{id}")
    public String getPhoto(@PathVariable String id, Model model) {
        Photo photo = photoService.getPhoto(id);
        model.addAttribute("title", photo.getTitle());
        model.addAttribute("about", photo.getAbout());
        model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
        return "photos";
    }

    @GetMapping("/photos/upload")
    public String uploadPhoto(Model model) {
        model.addAttribute("message", "hello");
        return "uploadPhoto";
    }


//    @GetMapping("/players")
//    public Iterable<Player> getAllPlayers() {
//        return playerService.getAllPlayers();
//    }






    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("title") String title,@RequestParam("about") String about, @RequestParam("image") MultipartFile image, Model model) throws IOException {
        String id = photoService.addPhoto(title, about, image);
        return "redirect:/photos/" + id;

    }


//    @GetMapping("/photos")
//        public String viewAllPhotos(Model model) throws IOException {
//            model.addAttribute("photos",photoService.getAllPhotos());
//            return "photos";
//
//    }

    @GetMapping("/allphotos")
    public String viewAllPhotos(Model model) throws IOException {
        model.addAttribute("photos",photoService.getAllPhotos());
        return "allphotos";

    }




    @GetMapping("/delete-photo/{id}")
    public String removePhoto(@PathVariable("id") String id, Model model) {
        photoService.deletePhotoById(id);
        model.addAttribute("photos", photoService.getAllPhotos());
        return "allphotos";
    }



//    @PostMapping("/photos/add")
//    public String addPhoto(@ModelAttribute("photo") @Valid Photo photo,
//                             BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "uploadPhoto";
//        }
//        photoService.savePhoto(photo);
//        return "redirect:photos";
//    }

}