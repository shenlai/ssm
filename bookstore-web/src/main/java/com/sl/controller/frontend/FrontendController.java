package com.sl.controller.frontend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sl.entity.HeadLine;
import com.sl.entity.ShopCategory;
import com.sl.service.IAreaService;
import com.sl.service.IHeadLineService;
import com.sl.service.IProductService;
import com.sl.service.IShopCategoryService;
import com.sl.service.IShopService;

@Controller
@RequestMapping("/frontend")
public class FrontendController {
	
	@Autowired
	private IHeadLineService headLineService;
	
	@Autowired
	private IShopService shopService;

	@Autowired
	private IShopCategoryService shopCategoryService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IProductService productService;
	
	/**
	 * 首页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	private String index() {
		return "frontend/index";
	}
	
	/**
	 * 首页数据
	 */
	@RequestMapping(value = "/listmainpageinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> list1stShopCategory() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
		try {
			shopCategoryList = shopCategoryService.getFirstLevelShopCategoryList();
			modelMap.put("shopCategoryList", shopCategoryList);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", "获取店铺类别失败");
			return modelMap;
		}
		List<HeadLine> headLineList = new ArrayList<HeadLine>();
		try {
			HeadLine headLineCondition = new HeadLine();
			headLineCondition.setEnableStatus(1);
			headLineList = headLineService.getHeadLineList(headLineCondition);
			modelMap.put("headLineList", headLineList);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", "获取类别失败");
			return modelMap;
		}
		modelMap.put("success", true);
		return modelMap;
	}
	
}
