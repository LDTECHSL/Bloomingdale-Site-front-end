package com.cmjd.bloomingdales.repo;

import com.cmjd.bloomingdales.entity.Women;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface WomenRepo extends JpaRepository<Women,String> {
    @Query(value = "SELECT * FROM WOMEN WHERE ID=?1",nativeQuery = true)
    Women getWomenByWomenId(String WomenId);

    @Query(value = "SELECT * FROM WOMEN WHERE name LIKE %?1%",
            nativeQuery = true)
    Page<Women> getAll(String searchText, Pageable of);

    @Query(value = "SELECT COUNT(id) FROM WOMEN WHERE name LIKE %?1%",
            nativeQuery = true)
    Long getAllCount(String searchText);
}
