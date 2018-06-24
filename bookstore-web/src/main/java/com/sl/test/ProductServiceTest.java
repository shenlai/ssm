package com.sl.test;

import com.sl.po.Product;
import com.sl.service.*;
import com.sl.util.MapUtils;
import com.sl.util.PagerBean;

import java.util.List;
import java.util.Map;

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
		//List<Product> list = productService.selectAllProduct();
		
		//
		PagerBean pagebean = new PagerBean();
		pagebean.setPageNumber(2);
		pagebean.setPageSize(4);
		
		pagebean.setRecordCount(11);
		pagebean.setData(11);
		
		Map pager = MapUtils.returnMap(pagebean);
		pager.putAll(pager);
		List<Product> list = productService.selectAllProductByPage(pager);

		for (Product product : list) {

			System.out.println(product);
		}

	}
}
