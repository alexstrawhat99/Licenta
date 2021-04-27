//package com.gpch.mongo.service;
//
//public class LegendService {
//}

package com.gpch.mongo.service;

import com.gpch.mongo.model.Legend;
import com.gpch.mongo.repository.LegendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegendService{


    private final LegendRepository legendRepository;

    @Autowired
    public LegendService(LegendRepository legendRepository) {
        this.legendRepository = legendRepository;
    }

    public void saveLegend(Legend legend){
        legendRepository.save(legend);
    }

    public Iterable<Legend> getAllLegends(){
//
        return legendRepository.findAll();
    }

    public void deleteAllLegends(){
        legendRepository.deleteAll();
    }

    public void deleteLegendsById(String id){
        legendRepository.deleteById(id);
    }

    public Optional<Legend> findLegendsById(String id){
        return legendRepository.findById(id);
    }

    public void saveAll(List<String> legends) {
    }


}