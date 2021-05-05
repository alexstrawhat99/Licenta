package com.gpch.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gpch.mongo.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {

}