package com.sl.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sl.BaseTest;
import com.sl.entity.Area;
import com.sl.entity.Shop;
import com.sl.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
	
	@Autowired
	private ShopDao shopDao;
	
	@Test
	@Ignore
	public void testAInsertShop() throws Exception {
		Shop shop = new Shop();
		shop.setOwnerId(8L);
		Area area = new Area();
		area.setAreaId(3);
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(10L);
		shop.setShopName("琶洲国际");
		shop.setShopDesc("暂无描述");
		shop.setShopAddr("广州");
		shop.setPhone("13701846199");
		shop.setShopImg("xxx.jpg");
		shop.setLongitude(1D);
		shop.setLatitude(1D);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		shop.setArea(area);
		shop.setShopCategory(sc);
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}
	
	@Test
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(30L);
		shop.setShopName("上海南京东路");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}
	

}
