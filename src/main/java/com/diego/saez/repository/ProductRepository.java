package com.diego.saez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.saez.model.Product;

/**
 * @author diegosaez
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
