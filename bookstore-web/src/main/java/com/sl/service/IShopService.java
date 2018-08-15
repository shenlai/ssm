package com.sl.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sl.dto.ShopDto;
import com.sl.entity.Shop;

public interface IShopService {
	

	ShopDto addShop(Shop shop, CommonsMultipartFile shopImg);

}
