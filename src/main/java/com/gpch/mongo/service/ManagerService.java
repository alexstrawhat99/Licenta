//package com.gpch.mongo.service;
//
//public class ManagerService {
//}
package com.gpch.mongo.service;
// Service layer use the ReservationRepository.

import com.gpch.mongo.model.Manager;
import com.gpch.mongo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService{


    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public void saveManager(Manager manager){
        managerRepository.save(manager);
    }

    public Iterable<Manager> getAllManagers(){
//
        return managerRepository.findAll();
    }

    public void deleteAllManagers(){
        managerRepository.deleteAll();
    }

    public void deleteManagersById(String id){
        managerRepository.deleteById(id);
    }

    public Optional<Manager> findManagersById(String id){
        return managerRepository.findById(id);
    }

    public void saveAll(List<String> managers) {
    }


}