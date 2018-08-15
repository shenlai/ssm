package com.sl.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sl.BaseTest;
import com.sl.dto.ShopDto;
import com.sl.entity.Area;
import com.sl.entity.Shop;
import com.sl.entity.ShopCategory;
import com.sl.enums.ShopStateEnum;
import com.sl.service.impl.ShopService;

public class ShopServiceTest extends BaseTest{
	
	//注意错误：
	/*
	 * Caused by: org.springframework.beans.factory.BeanNotOfRequiredTypeException: 
Bean named 'shopService' is expected to be of type 'com.sl.service.impl.ShopService' but was actually of type 'com.sun.proxy.$Proxy31'
	 * 
	 * ShopService使用了注解 @Transactional  应该是只能使用jdk动态，下面如果使用cglib代,则冲突
	 * */
	@Autowired
	private IShopService shopService;  //  jdk动态代理注入
	//private ShopService shopService;  // 类注入 必须使用cglib代理
	
	
	@Test
	public void testAddShop() throws Exception {
		Shop shop = new Shop();
		shop.setOwnerId(8L);
		Area area = new Area();
		area.setAreaId(3);
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(10L);
		shop.setShopName("琶洲国际23131");
		shop.setShopDesc("暂无描述131414");
		shop.setShopAddr("大广州");
		shop.setPhone("13701846199");
		shop.setShopImg("xxx.jpg");
		shop.setLongitude(1D);
		shop.setLatitude(1D);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		shop.setArea(area);
		shop.setShopCategory(sc);
		
		//File shopImg = new File("D:/images/new书房1.jpg");
		//DiskFileItem fileItem = new DiskFileItem("file", "text/plain", false, file.getName(), (int) file.length(), file.getParentFile());
		//fileItem.getOutputStream();
		//CommonsMultipartFile multipartFile = new CommonsMultipartFile(fileItem);
		
		ShopDto se = shopService.addShop(shop,null);
		
		assertEquals(se.getState(),ShopStateEnum.CHECK.getState());
	}
	

}
