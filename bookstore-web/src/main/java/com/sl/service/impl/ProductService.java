package com.sl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.dao.ProductDao;
import com.sl.po.Product;
import com.sl.service.IProductService;

@Service("productService")
public class ProductService implements IProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> selectAllProductByPage(Map map) {
		List<Product> list = productDao.selectAllProductByPage(map);

		return list;
	}

	@Override
	public List<Product> selectAllProduct() {
		List<Product> list = productDao.selectAllProduct();

		return list;
	}

}
