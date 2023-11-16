package com.cmjd.bloomingdales.repo;

import com.cmjd.bloomingdales.entity.Order;
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
public interface OrderRepo extends JpaRepository<Order,String> {

    @Query(value = "SELECT * FROM ORDER WHERE name LIKE %?1%",
            nativeQuery = true)
    Page<Order> getAll(String searchText, Pageable of);

    @Query(value = "SELECT COUNT(id) FROM ORDER WHERE name LIKE %?1%",
            nativeQuery = true)
    Long getAllCount(String searchText);
}
