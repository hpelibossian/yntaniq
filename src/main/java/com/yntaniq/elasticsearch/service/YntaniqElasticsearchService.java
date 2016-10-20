package com.yntaniq.elasticsearch.service;

import com.yntaniq.elasticsearch.domain.YntaniqElasticsearch;
import com.yntaniq.elasticsearch.repository.YntaniqElasticsearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class YntaniqElasticsearchService {

    @Autowired
    private YntaniqElasticsearchRepository yntaniqElasticsearchRepository;

    public YntaniqElasticsearchService() {
    }

    public Collection< YntaniqElasticsearch > findByAnun(String anun){
        return yntaniqElasticsearchRepository.findByAnun(anun);
    }
    public Collection<YntaniqElasticsearch > findById(String id){
        return yntaniqElasticsearchRepository.findByAnun(id);
    }
    public Collection < YntaniqElasticsearch> findAll() {
        return yntaniqElasticsearchRepository.findAll();
    }
    public YntaniqElasticsearch add(YntaniqElasticsearch yntaniqElasticsearch) {
        return yntaniqElasticsearchRepository.save(yntaniqElasticsearch);
    }

}
