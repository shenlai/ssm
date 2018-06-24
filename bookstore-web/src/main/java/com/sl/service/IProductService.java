package com.sl.service;

import java.util.List;
import java.util.Map;

import com.sl.po.Product;

public interface IProductService {
	
	List<Product> selectAllProductByPage(Map map);
	
	List<Product> selectAllProduct();
}
