package com.sl.service;

import java.util.List;

import com.sl.entity.ShopCategory;
public interface IShopCategoryService {
	
	List<ShopCategory> getShopCategoryList(Long parentId);
}
