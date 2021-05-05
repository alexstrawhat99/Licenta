package com.gpch.mongo.service;


import java.io.IOException;
import java.util.List;


import com.gpch.mongo.model.Player;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gpch.mongo.repository.PhotoRepository;
import com.gpch.mongo.model.Photo;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepo;

    public Photo getPhoto(String id) {
        return photoRepo.findById(id).get();
    }

    public String addPhoto(String title, String about, MultipartFile file) throws IOException {
        Photo photo = new Photo(title, about);
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = photoRepo.insert(photo);
        return photo.getId();
    }

    public Iterable<Photo> getAllPhotos(){
//
        return photoRepo.findAll();
    }

    public void savePhoto(Photo photo){
        photoRepo.save(photo);
    }


    public void saveAll(List<String> photos) {
    }

    public void deletePhotoById(String id) {
        photoRepo.deleteById(id);
    }



}