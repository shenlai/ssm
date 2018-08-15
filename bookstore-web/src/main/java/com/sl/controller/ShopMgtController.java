package com.sl.controller;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.dto.ShopDto;
import com.sl.entity.Area;
import com.sl.entity.PersonInfo;
import com.sl.entity.Shop;
import com.sl.entity.ShopCategory;
import com.sl.enums.ShopStateEnum;
import com.sl.service.IAreaService;
import com.sl.service.IShopCategoryService;
import com.sl.service.IShopService;
import com.sl.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/shopadmin")
public class ShopMgtController {
	
	@Autowired
	private IShopService shopService;
	
	@Autowired
	private IShopCategoryService shopCategoryService;
	
	@Autowired
	private IAreaService areaService; 
	
	
	@RequestMapping(value = "/shopoperation", method = RequestMethod.GET)
	private String shopEdit() {
		return "shop/shopoperation";
	}
	
	@RequestMapping(value = "/getshopinfo", method = RequestMethod.GET)
	@ResponseBody
	private  Map<String,Object> getShopInfo(){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
		List<Area> areaList =new ArrayList<Area>();
		try {
			shopCategoryList = shopCategoryService.getShopCategoryList(10L);
			areaList = areaService.getAreaList();
			
			modelMap.put("success",true);
			modelMap.put("areaList", areaList);
			modelMap.put("shopCategoryList", shopCategoryList);
		}catch(Exception e) {
			modelMap.put("success",true);
			modelMap.put("errMsg",e.getMessage());
		}
		return modelMap;
	}
	
	
	
	
	@RequestMapping(value = "/registershop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request,String key) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Shop shop =null;
		//1.接收并转换参数
		try {
			String shopStr= HttpServletRequestUtil.getString(request, "shopStr");
			ObjectMapper mapper = new ObjectMapper();
			shop = mapper.readValue(shopStr,Shop.class);
		}catch(Exception e) {
			modelMap.put("success", false);
			modelMap.put("errrMsg", e.getMessage());
			return modelMap;
		}
		
		CommonsMultipartFile shopImg=null;
		
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		
		if(commonsMultipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartHttpServletRequest =(MultipartHttpServletRequest)request;
			shopImg = (CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");
		}else {
			modelMap.put("success", false);
			modelMap.put("errrMsg", "上传图片不能为空");
			return modelMap;
		}
		
		
		//2.注册店铺
		if(shop!=null && shopImg!=null) {
			PersonInfo owner = new PersonInfo();
			owner.setUserId(8L);
			shop.setOwnerId(8L);
			ShopDto shopDto = shopService.addShop(shop, shopImg);
			if(shopDto.getState()==ShopStateEnum.CHECK.getState()) {
				modelMap.put("success", true);
			}else {
				modelMap.put("success", false);
			}
		}else {
			modelMap.put("success", false);
			modelMap.put("errrMsg", "请输入店铺信息");
			return modelMap;
		}
		
		return modelMap;
	}

	
	

}
