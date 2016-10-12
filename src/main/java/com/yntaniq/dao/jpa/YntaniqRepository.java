package com.yntaniq.dao.jpa;

import com.yntaniq.domain.Yntaniq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;


//@Transactional
public interface YntaniqRepository extends PagingAndSortingRepository<Yntaniq, Long> {

    Yntaniq findByAnun(String anun);

    Yntaniq findById(Long id);

    Collection<Yntaniq> findAll();
    //public List<Yntaniq> findAll();
    //Page findAll(Pageable pageable);
}
