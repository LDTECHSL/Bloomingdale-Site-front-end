package com.cmjd.bloomingdales.repo;

import com.cmjd.bloomingdales.entity.Handbags;
import com.cmjd.bloomingdales.entity.Women;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface HandbagsRepo extends JpaRepository<Handbags,String> {
    @Query(value = "SELECT * FROM HANDBAGS WHERE ID=?1",nativeQuery = true)
    Handbags getHandbagsByHandbagsId(String HandbagsId);

    @Query(value = "SELECT * FROM HANDBAGS WHERE name LIKE %?1%",
            nativeQuery = true)
    Page<Handbags> getAll(String searchText, Pageable of);

    @Query(value = "SELECT COUNT(id) FROM HANDBAGS WHERE name LIKE %?1%",
            nativeQuery = true)
    Long getAllCount(String searchText);
}
