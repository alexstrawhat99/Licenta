package com.gpch.mongo.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//@Builder
@Document(collection = "photos")
public class Photo {

    @Id
    private String id;

    private String title;

    private String about;
    private Binary image;

    public Photo(String title, String about) {
        this.title = title;
        this.about = about;
    }

//    public Photo(String s, String title) {
//        super();
//        this.title = title;
//
//    }

//    public void About(String s, String about) {
//
//       this.title = title;
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Photo [id=" + id + ", title=" + title + ", about=" + about + ",  image=" + image + "]";
    }

}