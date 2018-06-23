package com.sl.test;

import com.sl.po.Product;
import com.sl.service.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext-dao.xml" })
public class ProductServiceTest {

	@Autowired
	IProductService productService;

	@Test
	public void selectAllProducts() {
		List<Product> list = productService.selectAllProduct();

		for (Product product : list) {

			System.out.println(product);
		}

	}
}
