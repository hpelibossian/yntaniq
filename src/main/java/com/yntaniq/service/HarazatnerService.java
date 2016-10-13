package com.yntaniq.service;

import com.yntaniq.dao.jpa.HarazatnerRepository;
import com.yntaniq.domain.Harazatner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;


/**
 * Created by pelibossian on 10/10/16.
 */
@Service
public class HarazatnerService {
    private static final Logger log = LoggerFactory.getLogger(HarazatnerService.class);

    @Autowired
    private HarazatnerRepository harazatnerRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public HarazatnerService() {
    }

    public Harazatner createHarazatner(Harazatner harazatner) {
        return harazatnerRepository.save(harazatner);
    }

    public Harazatner getHarazatner(long id) {
        return harazatnerRepository.findOne(id);
    }

    public void updateHarazatner(Harazatner harazatner) {
        harazatnerRepository.save(harazatner);
    }

    public void deleteHarazatner(Long id) {
        harazatnerRepository.delete(id);
    }

    public Collection<Harazatner> getAllHarazatner(){
        return harazatnerRepository.findAll();
    }

    public Page<Harazatner> getAllHarazatnerPages(Integer page, Integer size) {
        Page pageOfHotels = harazatnerRepository.findAll(new PageRequest(page, size));
        // example of adding to the /metrics
        if (size > 50) {
            counterService.increment("harazatnerService.getAll.largePayload");
        }
        return pageOfHotels;
    }

}
