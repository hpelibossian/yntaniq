package com.yntaniq.service;

import com.yntaniq.domain.Yntaniq;
import com.yntaniq.dao.jpa.YntaniqRepository;
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
public class YntaniqService {
    private static final Logger log = LoggerFactory.getLogger(YntaniqService.class);

    @Autowired
    private YntaniqRepository yntaniqRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public YntaniqService() {
    }

    public Yntaniq createYntaniq(Yntaniq yntaniq) {
        return yntaniqRepository.save(yntaniq);
    }

    public Yntaniq getYntaniq(long id) {
        return yntaniqRepository.findOne(id);
    }

    public void updateYntaniq(Yntaniq yntaniq) {
        yntaniqRepository.save(yntaniq);
    }

    public void deleteYntaniq(Long id) {
        yntaniqRepository.delete(id);
    }

    public Collection<Yntaniq> getAllYntaniq(){
        return yntaniqRepository.findAll();
    }

    public Page<Yntaniq> getAllYntaniqPages(Integer page, Integer size) {
        Page pageOf = yntaniqRepository.findAll(new PageRequest(page, size));
        // example of adding to the /metrics
        if (size > 50) {
            counterService.increment("YntaniqService.getAll.largePayload");
        }
        return pageOf;
    }

}
