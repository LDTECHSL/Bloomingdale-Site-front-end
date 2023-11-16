package com.cmjd.bloomingdales.repo;

import com.cmjd.bloomingdales.entity.Shoes;
import com.cmjd.bloomingdales.entity.Women;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ShoesRepo extends JpaRepository<Shoes,String> {
    @Query(value = "SELECT * FROM SHOES WHERE ID=?1",nativeQuery = true)
    Shoes getShoesByShoesId(String ShoesId);

    @Query(value = "SELECT * FROM SHOES WHERE name LIKE %?1%",
            nativeQuery = true)
    Page<Shoes> getAll(String searchText, Pageable of);

    @Query(value = "SELECT COUNT(id) FROM SHOES WHERE name LIKE %?1%",
            nativeQuery = true)
    Long getAllCount(String searchText);
}
