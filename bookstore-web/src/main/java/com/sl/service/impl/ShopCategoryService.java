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
	

}
