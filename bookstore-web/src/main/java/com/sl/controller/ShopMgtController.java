package com.sl.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.dto.DataResponse;
import com.sl.dto.PageResponse;
import com.sl.dto.ShopDto;
import com.sl.entity.Area;
import com.sl.entity.PersonInfo;
import com.sl.entity.Product;
import com.sl.entity.Shop;
import com.sl.entity.ShopCategory;
import com.sl.enums.ShopStateEnum;
import com.sl.service.IAreaService;
import com.sl.service.IProductService;
import com.sl.service.IShopCategoryService;
import com.sl.service.IShopService;
import com.sl.util.CodeUtil;
import com.sl.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/shop")
public class ShopMgtController {

	@Autowired
	private IShopService shopService;

	@Autowired
	private IShopCategoryService shopCategoryService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IProductService productService;

	
	@RequestMapping(value = "/shopoperation", method = RequestMethod.GET)
	private String shopEdit() {
		return "shop/shopoperation";
	}

	@RequestMapping(value = "/shoplist", method = RequestMethod.GET)
	private String shopList() {
		return "shop/shoplist";

	}

	@RequestMapping(value = "/shopmanage", method = RequestMethod.GET)
	private String shopManage() {
		return "shop/shopmanage";

	}

	@RequestMapping(value = "/productlist", method = RequestMethod.GET)
	private String productList() {
		return "shop/productlist";

	}
	
	@RequestMapping(value = "/productedit", method = RequestMethod.GET)
	private String productEdit() {
		return "shop/productedit";
	}

	@RequestMapping(value = "/getproductbyid", method = RequestMethod.GET)
	@ResponseBody
	private DataResponse<Product> getProductbyId(long productId){
		if(productId<=0) {
			return new DataResponse<Product>(false,0,"参数小于0");
		}else{
			Product product = productService.getProductByProductId(productId);
			return new DataResponse<Product>(true,product);
		}
	}
	
	/**
	 * 产品列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getproductlist", method = RequestMethod.GET)
	@ResponseBody
	private PageResponse<Product> getProductList(HttpServletRequest request) {
		PageResponse<Product> response = new PageResponse<Product>();
		
		int pageIndex = HttpServletRequestUtil.getInt(request, "page");
		int pageSize = HttpServletRequestUtil.getInt(request, "rows");
		Long shopId = HttpServletRequestUtil.getLong(request, "shopId");
		pageIndex = pageIndex <= 0 ? 1 : pageIndex;
		pageSize = pageSize <= 0 ? 20 : pageSize;
		if (pageIndex > 0 && pageSize > 0) {
			
			Product productCondition = new Product();
			productCondition.setShopId(shopId);
			response = productService.getProductList(productCondition, pageIndex, pageSize);
		
		} else {
			response = new PageResponse<Product>(false,0,"参数错误");
		}
		return response;
	}

	
	/**
	 * 店铺列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getshoplist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listShops(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		PageResponse<Shop> shopListResponse = new PageResponse<Shop>();
		int pageIndex = HttpServletRequestUtil.getInt(request, "page");
		int pageSize = HttpServletRequestUtil.getInt(request, "rows");
		pageIndex = pageIndex <= 0 ? 1 : pageIndex;
		pageSize = pageSize <= 0 ? 20 : pageSize;
		if (pageIndex > 0 && pageSize > 0) {
			Shop shopCondition = new Shop();
			//设置用户信息，获取当前用户的店铺
			//shopCondition.setOwnerId(12L);
			int enableStatus = HttpServletRequestUtil.getInt(request, "enableStatus");
			if (enableStatus >= 0) {
				shopCondition.setEnableStatus(enableStatus);
			}
			long shopCategoryId = HttpServletRequestUtil.getLong(request, "shopCategoryId");
			if (shopCategoryId > 0) {
				ShopCategory sc = new ShopCategory();
				sc.setShopCategoryId(shopCategoryId);
				shopCondition.setShopCategory(sc);
			}
			String shopName = HttpServletRequestUtil.getString(request, "shopName");
			if (shopName != null) {
				try {
					shopCondition.setShopName(URLDecoder.decode(shopName, "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					modelMap.put("success", false);
					modelMap.put("errMsg", e.toString());
				}
			}
			try {
				shopListResponse = shopService.getShopList(shopCondition, pageIndex, pageSize);
			} catch (Exception e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}
			if (shopListResponse.getDataList() != null) {
				modelMap.put("rows", shopListResponse.getDataList());
				modelMap.put("total", shopListResponse.getTotalCount());
				//将当前用户的店铺列表存入session
				request.getSession().setAttribute("shopList", shopListResponse.getDataList());
				modelMap.put("success", true);
			} else {
				modelMap.put("rows", new ArrayList<Shop>());
				modelMap.put("total", 0);
				modelMap.put("success", true);
			}
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "空的查询信息");
			return modelMap;
		}
	}

	@RequestMapping(value = "/getshopinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getShopInfo(int shopId,HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();

		if (shopId <= 0) {
			
			//Object currentShop =  request.getSession().getAttribute("currentShop");
			modelMap.put("success", false);
			modelMap.put("errMsg", "shopId不能小于0");
		}
		Shop shop = new Shop();
		List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
		List<Area> areaList = new ArrayList<Area>();
		try {
			shopCategoryList = shopCategoryService.getShopCategoryList((long) shopId);
			areaList = areaService.getAreaList();
			shop = shopService.getByShopId(shopId);

			modelMap.put("shop", shop);
			modelMap.put("success", true);
			modelMap.put("areaList", areaList);
			modelMap.put("shopCategoryList", shopCategoryList);
			
			//设置session
			request.getSession().setAttribute("currentShop", shop);
		} catch (Exception e) {
			modelMap.put("success", true);
			modelMap.put("errMsg", e.getMessage());
		}
		return modelMap;
	}

	// 创建店铺
	@RequestMapping(value = "/registershop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (!CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码");
			return modelMap;
		}

		Shop shop = null;
		// 1.接收并转换参数
		try {
			String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
			ObjectMapper mapper = new ObjectMapper();
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errrMsg", e.getMessage());
			return modelMap;
		}

		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		if (commonsMultipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
		} else {
			modelMap.put("success", false);
			modelMap.put("errrMsg", "上传图片不能为空");
			return modelMap;
		}

		// 2.注册店铺
		if (shop != null && shopImg != null) {
			// Session TODO
			PersonInfo owner = new PersonInfo();
			owner.setUserId(8L);
			shop.setOwnerId(8L);
			ShopDto shopDto = shopService.addShop(shop, shopImg);
			if (shopDto.getState() == ShopStateEnum.CHECK.getState()) {
				modelMap.put("success", true);
			} else {
				modelMap.put("success", false);
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errrMsg", "请输入店铺信息");
			return modelMap;
		}

		return modelMap;
	}

}
