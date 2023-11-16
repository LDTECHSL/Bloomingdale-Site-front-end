package com.cmjd.bloomingdales.repo;

import com.cmjd.bloomingdales.entity.Jewellery;
import com.cmjd.bloomingdales.entity.Women;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface JewelleryRepo extends JpaRepository<Jewellery,String> {
    @Query(value = "SELECT * FROM JEWELLERY WHERE ID=?1",nativeQuery = true)
    Jewellery getJewelleryByJewelleryId(String JewelleryId);

    @Query(value = "SELECT * FROM JEWELLERY WHERE name LIKE %?1%",
            nativeQuery = true)
    Page<Jewellery> getAll(String searchText, Pageable of);

    @Query(value = "SELECT COUNT(id) FROM JEWELLERY WHERE name LIKE %?1%",
            nativeQuery = true)
    Long getAllCount(String searchText);
}
