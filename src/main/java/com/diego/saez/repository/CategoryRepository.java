package com.diego.saez.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.saez.model.Category;

/**
 * 
 * Repository to manage operations on the {@link Category} entity
 * 
 * @author diegosaez
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
