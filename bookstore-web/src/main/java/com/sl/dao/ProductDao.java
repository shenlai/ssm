package com.sl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sl.entity.Product;
import com.sl.entity.Shop;

@Repository("productDao")
public interface ProductDao {

	//List<Product> selectAllProductByPage(Map map);
	
	//List<Product> selectAllProduct();
	
	List<Product> queryProductList(@Param("productCondition") Product productCondition, @Param("rowIndex")int rowIndex,@Param("pageSize")int pageSize);

	int queryProductCount(@Param("productCondition") Product productCondition);
	
	Product queryProductByProductId(long productId);
}
