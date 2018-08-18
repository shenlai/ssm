package com.sl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sl.entity.ProductCategory;

public interface ProductCategoryDao {

	List<ProductCategory> queryByShopId(long shopId);
	
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);

	int deleteProductCategory(@Param("productCategoryId") long productCategoryId);

}
