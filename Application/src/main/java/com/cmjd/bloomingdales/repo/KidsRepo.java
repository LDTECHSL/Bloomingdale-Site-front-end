package com.cmjd.bloomingdales.repo;

import com.cmjd.bloomingdales.entity.Kids;
import com.cmjd.bloomingdales.entity.Women;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface KidsRepo extends JpaRepository<Kids,String> {
    @Query(value = "SELECT * FROM KIDS WHERE ID=?1",nativeQuery = true)
    Kids getKidsByKidsId(String KidsId);

    @Query(value = "SELECT * FROM KIDS WHERE name LIKE %?1%",
            nativeQuery = true)
    Page<Kids> getAll(String searchText, Pageable of);

    @Query(value = "SELECT COUNT(id) FROM KIDS WHERE name LIKE %?1%",
            nativeQuery = true)
    Long getAllCount(String searchText);
}
