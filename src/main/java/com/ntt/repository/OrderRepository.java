package com.ntt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ntt.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	Order findByOrderId(long id); 
}
