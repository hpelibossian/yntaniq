package com.yntaniq.dao.jpa;

import com.yntaniq.domain.Harazatner;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;


//@Transactional
public interface HarazatnerRepository extends PagingAndSortingRepository<Harazatner, Long> {

    Harazatner findByAnun(String anun);

    Harazatner findById(Long id);

    Collection<Harazatner> findAll();
    //public List<Yntaniq> findAll();
    //Page findAll(Pageable pageable);
}
