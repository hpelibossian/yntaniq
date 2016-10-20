package com.yntaniq.mysql.repository;

import com.yntaniq.mysql.domain.Ynkerner;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;


//@Transactional
public interface YnkernerRepository extends PagingAndSortingRepository<Ynkerner, Long> {

    Ynkerner findByAnun(String anun);

    Ynkerner findById(Long id);

    Collection<Ynkerner> findAll();
    //public List<Yntaniq> findAll();
    //Page findAll(Pageable pageable);
}
