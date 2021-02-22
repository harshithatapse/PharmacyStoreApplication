package com.ntt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ntt.model.Category;
import com.ntt.model.SubCategory;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findById(long id);
	
}
