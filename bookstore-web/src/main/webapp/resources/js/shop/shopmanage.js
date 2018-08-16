$(function() {
	var shopId = getQueryString("shopId");
	var shopInfoUrl = '/shop/shopoperation?shopId='+shopId;
	$("#shopInfo").attr('href',shopInfoUrl);
	
	
})