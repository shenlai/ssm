package com.sl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sl.po.Product;
import com.sl.service.IProductService;
import com.sl.util.MapUtils;
import com.sl.util.PagerBean;

@Controller
@RequestMapping("/home")
public class HomeController {

	
	@Autowired
	IProductService productService;
	
	//http://localhost:8020/home/index?page=1
	@RequestMapping("/index") // 处理URL路径中以/index开头的所有请求： 包括 /index/* 和 /index.html
	public ModelAndView home(int page) {
		PagerBean pagebean = new PagerBean();
		pagebean.setPageNumber(page);
		pagebean.setPageSize(4);
		
		pagebean.setRecordCount(11);
		pagebean.setData(11);
		
		Map pager = MapUtils.returnMap(pagebean);
		pager.putAll(pager);
		//List<Product> list = productService.selectAllProductByPage(pager);
		List<Product> list = new ArrayList<Product>();
		String message = "Hello Spring MVC";
		return new ModelAndView("home", "list", list);
	}

}
