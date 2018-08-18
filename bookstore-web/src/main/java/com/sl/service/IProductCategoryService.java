package com.sl.service;

import java.util.List;

import com.sl.dto.ComResponse;
import com.sl.entity.ProductCategory;

public interface IProductCategoryService {
	
	
	List<ProductCategory> getProductCategoryByShopId(long shopId);
	
	
	ComResponse batchInsertProductCategory(List<ProductCategory> productCategoryList);
	
	int deleteProductCategory(long productCategoryId);
	
	
}
