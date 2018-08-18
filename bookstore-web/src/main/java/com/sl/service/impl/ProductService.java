package com.sl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.dao.ProductDao;
import com.sl.dto.PageResponse;
import com.sl.dto.ShopDto;
import com.sl.entity.Product;
import com.sl.entity.Shop;
import com.sl.enums.ShopStateEnum;
import com.sl.service.IProductService;

@Service("productService")
public class ProductService implements IProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public PageResponse<Product> getProductList(Product productCondition, int pageIndex, int pageSize) {

		int rowIndex = pageIndex > 0 ? (pageIndex - 1) * pageSize : 0;
		List<Product> list = productDao.queryProductList(productCondition, rowIndex, pageSize);
		int count = productDao.queryProductCount(productCondition);

		return new PageResponse(count, list);
	}

	/*
	 * @Override public List<Product> selectAllProductByPage(Map map) {
	 * List<Product> list = productDao.selectAllProductByPage(map);
	 * 
	 * return list; }
	 * 
	 * @Override public List<Product> selectAllProduct() { List<Product> list =
	 * productDao.selectAllProduct();
	 * 
	 * return list; }
	 */

}
