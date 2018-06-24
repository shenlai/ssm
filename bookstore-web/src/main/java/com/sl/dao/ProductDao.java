package com.sl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sl.po.Product;

@Repository("productDao")
public interface ProductDao {

	List<Product> selectAllProductByPage(Map map);
	
	List<Product> selectAllProduct();
}
