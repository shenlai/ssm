package com.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/index") // 处理URL路径中以/index开头的所有请求： 包括 /index/* 和 /index.html
	public ModelAndView helloWorld() {
		System.out.print("1212");
		String message = "Hello Spring MVC";
		return new ModelAndView("home", "message", message);
	}

}
