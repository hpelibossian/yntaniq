package com.yntaniq.mongodb.repository;

import com.yntaniq.mongodb.domain.YntaniqMongo;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface YntaniqMongoRepository extends CrudRepository<YntaniqMongo, String>{
    public YntaniqMongo findByAnun(String anun);
    public YntaniqMongo findById(Long id);
    public Collection<YntaniqMongo> findAll();
}
