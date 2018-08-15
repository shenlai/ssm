package com.sl.dao;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sl.BaseTest;
import com.sl.entity.ShopCategory;

public class ShopCategoryTest extends BaseTest{
	
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	@Test
	public void testQueryArea() throws Exception {
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(null);
		System.out.println(shopCategoryList.size());
		assertTrue(shopCategoryList.size()>0);
		
		ShopCategory testCategory = new ShopCategory();
		testCategory.setParentId(10L);
		 shopCategoryList = shopCategoryDao.queryShopCategory(testCategory);
		System.out.println(shopCategoryList.size());
		assertTrue(shopCategoryList.size()>0);
		
		
		
	}

	
}
