package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    Iterable<Product> findProductByName(String name);

    Page<Product> findAll(Pageable pageable);
    @Query("select c from Product c where c.name like ?1")

    Iterable<Product> findAllByNameContaining(String name);
}
