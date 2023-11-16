package com.cmjd.bloomingdales.repo;

import com.cmjd.bloomingdales.entity.Men;
import com.cmjd.bloomingdales.entity.Women;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface MenRepo extends JpaRepository<Men,String> {
    @Query(value = "SELECT * FROM MEN WHERE ID=?1",nativeQuery = true)
    Men getMenByMenId(String MenId);

    @Query(value = "SELECT * FROM MEN WHERE name LIKE %?1%",
            nativeQuery = true)
    Page<Men> getAll(String searchText, Pageable of);

    @Query(value = "SELECT COUNT(id) FROM MEN WHERE name LIKE %?1%",
            nativeQuery = true)
    Long getAllCount(String searchText);
}
