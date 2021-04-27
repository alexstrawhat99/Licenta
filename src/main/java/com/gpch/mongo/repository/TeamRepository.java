package com.gpch.mongo.repository;


import com.gpch.mongo.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepository extends CrudRepository<Team, String> {

//        List<Player> findByRatingAsc(String Rating); //Ordonam dupa rating
//        List<Player> findByRating(String Rating);

}

//The repository a