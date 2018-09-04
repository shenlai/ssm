package com.sl.interceptor;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sl.entity.Shop;

/**
 * 操作自己的店铺
 * @author SL
 *
 */
public class ShopPermissionInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//从session中获取当前选择的店铺
		Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
		
		//可操作店铺列表
		List<Shop> shopList = (List<Shop>) request.getSession().getAttribute("shopList");
		if (currentShop != null && shopList != null) {
			for (Shop shop : shopList) {
				if (shop.getShopId() == currentShop.getShopId()) {
					return true;
				}
			}
		}
		
		return false;
	}
		
		
		
	
	
	

}
