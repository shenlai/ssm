package com.sl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sl.entity.Shop;

public interface ShopDao {
	
	Shop queryShopById(long shopId);
	
	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex")int rowIndex,@Param("pageSize")int pageSize);
	
	int queryShopCount(@Param("shopCondition") Shop shopCondition);
	
	int insertShop(Shop shop);
	
	
	int updateShop(Shop shop);
}
