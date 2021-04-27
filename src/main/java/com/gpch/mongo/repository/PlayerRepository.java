package com.gpch.mongo.repository;

import com.gpch.mongo.model.Player;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//        import java.util.List;
//crudrepository
@Repository
public interface PlayerRepository extends CrudRepository<Player, String> {

//    Sort sort = new Sort(Sort.Direction.ASC, "DEVID").and(new Sort(Sort.Direction.ASC, "TIME"));//Multi-condition DEVID, time
//    Criteria criteria = Criteria.where("CHECK").is(0);//Query conditions


//    void findByNameAndTeam(String name, String team);
}

//The repository allows us to store/access the information stored in the Mongo database.