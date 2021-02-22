package com.ntt.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.OrderDTO;
import com.ntt.dtoConverter.DTOToEntityProduct;
import com.ntt.entityConverter.DTOUtil;
import com.ntt.entityConverter.DTOUtilOrderProductOrders;
import com.ntt.exception.CategoryNotFoundException;
import com.ntt.exception.OrderNotFoundException;
import com.ntt.model.Category;
import com.ntt.model.Order;
import com.ntt.model.ProductOrders;
import com.ntt.repository.CategoryRepository;
import com.ntt.repository.OrderRepository;
import com.ntt.repository.ProductOrdersRepository;
import com.ntt.service.AdminOperationsService;

@Service
public class AdminOperationsServiceImpl implements AdminOperationsService {
	
	@Autowired
	private ProductOrdersRepository productOrdersRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	Logger log = LoggerFactory.getLogger(AdminOperationsServiceImpl.class);

	@Override
	public List<ProductOrders> getAllProductOrders() {
		return productOrdersRepository.findAll();
	}

	@Override
	public OrderDTO getOrderById(long id) {
		OrderDTO orderDTO= new OrderDTO();
		log.info("AdminOperationsServiceImpl:getOrderById for " +id);
		Order order=orderRepository.findByOrderId(id); 
		if(Objects.isNull(order))
		{
			log.error(" Error : Enter correct Order Id");
			throw new OrderNotFoundException("Order not found for this Order Id :: " + id);
		}
		return modelMapper.map(order, OrderDTO.class);
		//return DTOUtilOrderProductOrders.buildOrderDTO(order);
	}

	@Override
	public CategoryDTO insertCatSubCatAndProducts(CategoryDTO categoryDTO) {
		log.info("AdminOperationsServiceImpl:insertCatSubCatAndProducts for " +categoryDTO.getCategoryId());
		Category category = modelMapper.map(categoryDTO, Category.class);
		//Category category = DTOToEntityProduct.buildCategoryEntity(categoryDTO);
		Category category1 = categoryRepository.save(category);
		if(Objects.isNull(category1))
		{
			log.error(" Error : Error in inserting the values for Category Id " + category1.getCategoryId());
			throw new OrderNotFoundException("Error in inserting the values for Category Id :: " + category1.getCategoryId());
		}
		return modelMapper.map(category1, CategoryDTO.class);
		//return DTOUtil.buildCategoryDTO(categoryRepository.save(category));
	}

}
