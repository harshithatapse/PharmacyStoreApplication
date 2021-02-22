package com.ntt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ntt.model.Order;
import com.ntt.model.ProductOrders;

@Repository
public interface ProductOrdersRepository extends JpaRepository<ProductOrders, Long>{

	void save(Order order1);
	
	/*
	 * @Modifying
	 * 
	 * @Query("INSERT INTO PRODUCTORDERS (ORDERID,PRODUCTID,QUANTITY) select :orderId,:productId,:quantity from ProductOrders"
	 * ) public int modifyingQueryInsertProductOrders(@Param("orderId")int
	 * orderId, @Param("productId")int productId, @Param("quantity")int quantity);
	 */

}
