$(function() {
	var shopId = getQueryString("shopId");
	var shopInfoUrl = '/shop/shopoperation?shopId='+shopId;
	var productListUrl = '/shop/productlist?shopId='+shopId;
	$("#shopInfo").attr('href',shopInfoUrl);
	$("#productList").attr('href',productListUrl);
	
	
})