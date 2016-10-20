package com.yntaniq.elasticsearch.repository;

import com.yntaniq.elasticsearch.domain.YntaniqElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Collection;


public interface YntaniqElasticsearchRepository extends ElasticsearchRepository<YntaniqElasticsearch, Long > {

    public Collection< YntaniqElasticsearch > findByAnun(String anun);
    public Collection < YntaniqElasticsearch> findAll();

}
