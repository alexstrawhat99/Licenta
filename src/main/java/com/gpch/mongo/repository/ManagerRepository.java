package com.gpch.mongo.repository;


import com.gpch.mongo.model.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//        import java.util.List;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, String> {

//        List<Player> findByRatingAsc(String Rating); //Ordonam dupa rating
//        List<Player> findByRating(String Rating);

}

//The repository allows us to store/access the information stored in the Mongo database.