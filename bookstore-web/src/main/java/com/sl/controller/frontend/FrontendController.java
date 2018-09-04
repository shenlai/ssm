package com.sl.controller.frontend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sl.dto.PageResponse;
import com.sl.entity.Area;
import com.sl.entity.HeadLine;
import com.sl.entity.Shop;
import com.sl.entity.ShopCategory;
import com.sl.service.IAreaService;
import com.sl.service.IHeadLineService;
import com.sl.service.IProductService;
import com.sl.service.IShopCategoryService;
import com.sl.service.IShopService;
import com.sl.util.HttpServletRequestUtil;

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
	 * 店铺列表
	 */
	@RequestMapping(value = "/shoplist", method = RequestMethod.GET)
	private String shopList() {
		return "frontend/shoplist";
	}
	
	/**
	 * 首页数据
	 */
	@RequestMapping(value = "/listmainpageinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listShopCategory() {
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
	
	
	/**
	 * 首页-按分类获取店铺列表-搜索条件框
	 * @throws IOException 
	 * @throws JsonProcessingException 
	 */
	@RequestMapping(value = "/listshopspageinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> listshopspageinfo(HttpServletRequest request) throws JsonProcessingException, IOException{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		long parentId = HttpServletRequestUtil.getLong(request, "parentId");
		List<ShopCategory> shopCategoryList = null;
		if(parentId!=-1) {
			shopCategoryList = shopCategoryService.getShopCategoryList(parentId);
		}else{
			shopCategoryList = shopCategoryService.getFirstLevelShopCategoryList();
		}
		modelMap.put("shopCategoryList", shopCategoryList);
		List<Area> areaList  = areaService.getAreaList();
		modelMap.put("areaList", areaList);
		modelMap.put("success", true);
		return modelMap;
	}
	
	
	/**
	 * 首页-按分类获取店铺列表
	 */
	@RequestMapping(value="/getshoplist",method=RequestMethod.GET)
	@ResponseBody
	private PageResponse<Shop> getShopList(HttpServletRequest request){
		PageResponse<Shop> response = null;
		int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
		int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
		if(pageIndex>=0 &&pageSize>0) {
			long parentId = HttpServletRequestUtil.getLong(request, "parentId");
			long shopCategoryId = HttpServletRequestUtil.getLong(request, "shopCategoryId");
			int areaId = HttpServletRequestUtil.getInt(request, "areaId");
			
			String shopName = HttpServletRequestUtil.getString(request, "shopName");
			
			Shop shopCondition = compactShopConditionSearch(parentId,shopCategoryId, areaId, shopName);
			response = shopService.getShopList(shopCondition, pageIndex, pageSize);
		}else {
			response = new PageResponse<Shop>(false,0,"参数错误");
		}
		return response;
	}
	
	private Shop compactShopConditionSearch(long parentId,
			long shopCategoryId, int areaId, String shopName) {
		Shop shopCondition = new Shop();
		if (parentId != -1L) {
			ShopCategory parentCategory = new ShopCategory();
			parentCategory.setShopCategoryId(parentId);
			shopCondition.setParentCategory(parentCategory);
		}
		if (shopCategoryId != -1L) {
			//ShopCategory shopCategory = new ShopCategory();
			//shopCategory.setShopCategoryId(shopCategoryId);
			//shopCondition.setShopCategory(shopCategory);
			shopCondition.setShopCategoryId(shopCategoryId);
		}
		if (areaId != -1L) {
			Area area = new Area();
			area.setAreaId(areaId);
			shopCondition.setArea(area);
		}

		if (shopName != null) {
			shopCondition.setShopName(shopName);
		}
		shopCondition.setEnableStatus(1);
		return shopCondition;
	}
}
