package com.sl.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sl.BaseTest;
import com.sl.entity.Product;

public class ProductDaoTest extends BaseTest{
	
	@Autowired
	private ProductDao productDao;
	
	@Test
	public void testqueryProductList() throws Exception {
		
		Product productCondition = new Product();
		productCondition.setShopId(20L);
		List<Product> productList = productDao.queryProductList(productCondition, 2, 5);
		
		int count = productDao.queryProductCount(productCondition);
		
		assertEquals(5, productList.size());
	}

}
