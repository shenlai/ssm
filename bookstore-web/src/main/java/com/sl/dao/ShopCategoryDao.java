package com.sl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.sl.entity.ShopCategory;

public interface ShopCategoryDao {
	
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
