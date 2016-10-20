package com.yntaniq.mysql.service;

import com.yntaniq.mysql.repository.YnkernerRepository;
import com.yntaniq.mysql.domain.Ynkerner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class YnkernerService {
    private static final Logger log = LoggerFactory.getLogger(YnkernerService.class);

    @Autowired
    private YnkernerRepository ynkernerRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public YnkernerService() {
    }

    public Ynkerner createYnkerner(Ynkerner ynkerner) {
        return ynkernerRepository.save(ynkerner);
    }

    public Ynkerner getYnkerner(long id) {
        return ynkernerRepository.findOne(id);
    }

    public void updateYnkerner(Ynkerner ynkerner) {
        ynkernerRepository.save(ynkerner);
    }

    public void deleteYnkerner(Long id) {
        ynkernerRepository.delete(id);
    }

    public Collection<Ynkerner> getAllYnkerner(){
        return ynkernerRepository.findAll();
    }

    public Page<Ynkerner> getAllYnkernerPages(Integer page, Integer size) {
        Page pageOf = ynkernerRepository.findAll(new PageRequest(page, size));
        // example of adding to the /metrics
        if (size > 50) {
            counterService.increment("ynkernerService.getAll.largePayload");
        }
        return pageOf;
    }

}
