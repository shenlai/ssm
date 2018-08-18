package com.sl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sl.dto.ComResponse;
import com.sl.dto.DataResponse;
import com.sl.entity.ProductCategory;
import com.sl.service.IProductCategoryService;

@Controller
@RequestMapping("/productcategory")
public class ProductCategoryMgtController {

	@Autowired
	private IProductCategoryService productCategoryService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String ProductCategoryList() {

		return "shop/productcategorymanage";
	}

	@RequestMapping(value = "getlistbyhopId", method = RequestMethod.GET)
	@ResponseBody
	public DataResponse<List<ProductCategory>> getProductCategoryList(int shopId) {
		if (shopId > 0) {
			List<ProductCategory> list = productCategoryService.getProductCategoryByShopId(shopId);
			return new DataResponse<List<ProductCategory>>(true, list);
		} else {
			return new DataResponse<List<ProductCategory>>(false, 0, "参数shopId错误");
		}
	}

	@RequestMapping(value = "/addproductcategorys", method = RequestMethod.POST)
	@ResponseBody
	private ComResponse addProductCategory(@RequestBody List<ProductCategory> productCategoryList,
			HttpServletRequest request) {
		if (productCategoryList == null || productCategoryList.size() == 0) {
			return new ComResponse(false, 0, "参数productCategoryList不能为空");
		}

		// temp 临时处理shopId
		for (ProductCategory pc : productCategoryList) {
			pc.setShopId(20L);
		}

		ComResponse response = productCategoryService.batchInsertProductCategory(productCategoryList);

		return response;
	}

	@RequestMapping(value = "/removeproductcategory", method = RequestMethod.POST)
	@ResponseBody
	private ComResponse removeProductCategory(Long productCategoryId) {
		if (productCategoryId != null && productCategoryId > 0) {

			int count = productCategoryService.deleteProductCategory(productCategoryId);
			if (count == 1) {
				return new ComResponse();
			} else {
				return new ComResponse(false, 0, "找不到productCategoryId为：" + productCategoryId + "的商品类别");
			}
		} else {
			return new ComResponse(false, 0, "参数productCategoryId不能小于0");
		}

	}

}
