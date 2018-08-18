package com.sl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sl.dao.ProductCategoryDao;
import com.sl.dto.ComResponse;
import com.sl.entity.ProductCategory;
import com.sl.service.IProductCategoryService;

@Service
public class ProductCategoryService implements IProductCategoryService {

	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Override
	public List<ProductCategory> getProductCategoryByShopId(long shopId) {
		List<ProductCategory> list = productCategoryDao.queryByShopId(shopId);
		return list;
	}

	@Override
	@Transactional
	public ComResponse batchInsertProductCategory(List<ProductCategory> productCategoryList) {

		if (productCategoryList != null && productCategoryList.size() > 0) {
			try {
				int count = productCategoryDao.batchInsertProductCategory(productCategoryList);
				if (count <= 0) {
					throw new RuntimeException("插入产品类别失败");
				} else {
					return new ComResponse();
				}
			} catch (Exception e) {
				throw new RuntimeException("batchAddProductCategory error: " + e.getMessage());
			}
		} else {
			return new ComResponse(false, 0, "productCategoryList不能为空");
		}

	}

	@Override
	public int deleteProductCategory(long productCategoryId) {
		int count = productCategoryDao.deleteProductCategory(productCategoryId);
		return count;
	}

}
