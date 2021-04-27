package com.gpch.mongo.repository;


import com.gpch.mongo.model.Legend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//        import java.util.List;

@Repository
public interface LegendRepository extends CrudRepository<Legend, String> {

//        List<Player> findByRatingAsc(String Rating); //Ordonam dupa rating
//        List<Player> findByRating(String Rating);

}

