package com.ntt.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ntt.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	//Product findBySubCategoryId(long id);
	
	Page<Product> findAll(Pageable pageable);

}
