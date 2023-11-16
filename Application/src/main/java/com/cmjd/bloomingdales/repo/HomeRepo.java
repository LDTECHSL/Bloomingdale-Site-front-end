package com.cmjd.bloomingdales.repo;

import com.cmjd.bloomingdales.entity.Home;
import com.cmjd.bloomingdales.entity.Women;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface HomeRepo extends JpaRepository<Home,String> {
    @Query(value = "SELECT * FROM HOME WHERE ID=?1",nativeQuery = true)
    Home getHomeByHomeId(String HomeId);

    @Query(value = "SELECT * FROM HOME WHERE name LIKE %?1%",
            nativeQuery = true)
    Page<Home> getAll(String searchText, Pageable of);

    @Query(value = "SELECT COUNT(id) FROM HOME WHERE name LIKE %?1%",
            nativeQuery = true)
    Long getAllCount(String searchText);
}
