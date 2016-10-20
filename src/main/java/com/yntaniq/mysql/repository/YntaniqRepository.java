package com.yntaniq.mysql.repository;

import com.yntaniq.mysql.domain.Yntaniq;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;


//@Transactional
public interface YntaniqRepository extends PagingAndSortingRepository<Yntaniq, Long> {

    Yntaniq findByAnun(String anun);

    Yntaniq findById(Long id);

    Collection<Yntaniq> findAll();
    //public List<Yntaniq> findAll();
    //Page findAll(Pageable pageable);
}
