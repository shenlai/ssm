package com.sl.dao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sl.BaseTest;
import com.sl.entity.Area;
import com.sl.entity.ProductCategory;

public class ProductCategoryDaoTest extends BaseTest{
	
	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Test
	@Ignore
	public void testQueryArea() throws Exception {
		List<ProductCategory> list =productCategoryDao.queryByShopId(20L);
		for(ProductCategory item:list){
			System.out.println(item.toString());
		}
		assertTrue(list.size()>0);
	}
	
	
	@Test
	public void testBatchInsertProductCategory() throws Exception {
		List<ProductCategory> list = new ArrayList<ProductCategory>();
		
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("商品类别1");
		productCategory.setProductCategoryDesc("测试商品类别");
		productCategory.setPriority(1);
		productCategory.setCreateTime(new Date());
		productCategory.setLastEditTime(new Date());
		productCategory.setShopId(20L);
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setProductCategoryName("商品类别2");
		productCategory2.setProductCategoryDesc("测试商品类别2");
		productCategory2.setPriority(2);
		productCategory2.setCreateTime(new Date());
		productCategory2.setLastEditTime(new Date());
		productCategory2.setShopId(20L);
		list.add(productCategory);
		list.add(productCategory2);
		
		int effectedNum = productCategoryDao
				.batchInsertProductCategory(list);
		assertEquals(2, effectedNum);
	}

}