package com.gpch.mongo.repository;


//package com.djamware.springbootmongodbsecurity.repository;

import com.gpch.mongo.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}