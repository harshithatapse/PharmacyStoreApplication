package com.ntt.service;

import java.util.List;
import java.util.Optional;

import com.ntt.dto.CategoryDTO;
import com.ntt.entityConverter.DTOUtil;
import com.ntt.model.Category;
import com.ntt.model.Product;
import com.ntt.model.SubCategory;

public interface UserOperationsService {

	//CategoryDTO getSubCatById(long id);

	//List<SubCategory> getProductsById(long id);

	CategoryDTO getAllCombinedByCatId(long id);

	//CategoryDTO insertCatSubCatAndProducts(CategoryDTO categoryDTO);


}
