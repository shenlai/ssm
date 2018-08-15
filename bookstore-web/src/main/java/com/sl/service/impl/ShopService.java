package com.sl.service.impl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sl.dao.ShopDao;
import com.sl.dto.ShopDto;
import com.sl.entity.Shop;
import com.sl.enums.ShopStateEnum;
import com.sl.exception.ShopOperationException;
import com.sl.service.IShopService;
import com.sl.util.ImageUtil;
import com.sl.util.PathUtil;


@Service
public class ShopService implements IShopService {

	@Autowired
	private ShopDao shopDao;
	
	@Override
	@Transactional
	public ShopDto addShop(Shop shop, CommonsMultipartFile shopImg) {
		if(shop==null) {
			return new ShopDto(ShopStateEnum.NULL_SHOP_INFO);
		}
		
		try {
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			int count = shopDao.insertShop(shop);
			if(count<=0) {
				throw new ShopOperationException("shop创建失败");   //RuntimeException  事务会执行回滚
			}else {
				if(shopImg!=null) {
					try {
						addShopImg(shop,shopImg);
					}catch(Exception e) {
						throw new ShopOperationException("addShopImg error:"+e.getMessage());
					}
					
					//更新图片地址
					count = shopDao.updateShop(shop);
					if(count<=0) {
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
			
		}catch(Exception e) {
			throw new ShopOperationException("addShop error:"+e.getMessage());
		}
		
		//success
		return new ShopDto(ShopStateEnum.CHECK,shop);
	}
	
	
	private void addShopImg(Shop shop,CommonsMultipartFile shopImg) {
		//获取shop图片目录相对值路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.genetateThumbnail(shopImg, dest);
		shop.setShopImg(shopImgAddr);
		}

	
}
