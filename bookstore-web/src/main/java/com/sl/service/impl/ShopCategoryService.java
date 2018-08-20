package com.sl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.dao.ShopCategoryDao;
import com.sl.entity.ShopCategory;
import com.sl.service.IShopCategoryService;

@Service
public class ShopCategoryService implements IShopCategoryService {

	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	
	@Override
	public List<ShopCategory> getShopCategoryList(Long parentId) {
		ShopCategory condition = new ShopCategory();
		condition.setParentId(parentId);
		
		return shopCategoryDao.queryShopCategory(condition);
	}


	@Override
	public List<ShopCategory> getFirstLevelShopCategoryList() {
		
		ShopCategory shopCategoryCondition = new ShopCategory();
		
		// 当shopCategoryId不为空的时候，查询的条件会变为 where parent_id is null
		shopCategoryCondition.setShopCategoryId(-1L);
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(shopCategoryCondition);
		
		return shopCategoryList;
	}
	

}
