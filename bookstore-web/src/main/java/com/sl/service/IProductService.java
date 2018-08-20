package com.sl.service;

import com.sl.dto.PageResponse;
import com.sl.entity.Product;


public interface IProductService {
	
	//List<Product> selectAllProductByPage(Map map);
	
	//List<Product> selectAllProduct();
	
	PageResponse<Product> getProductList(Product productCondition, int pageIndex, int pageSize);
	
	Product getProductByProductId(long productId);
}
