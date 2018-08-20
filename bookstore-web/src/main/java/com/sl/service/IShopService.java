package com.sl.service;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sl.dto.PageResponse;
import com.sl.dto.ShopDto;
import com.sl.entity.Product;
import com.sl.entity.Shop;

public interface IShopService {
	
	Shop getByShopId(long shopId);

	ShopDto addShop(Shop shop, CommonsMultipartFile shopImg);
	
	
	PageResponse<Shop> getShopList(Shop shopCondition, int pageIndex, int pageSize);
}
