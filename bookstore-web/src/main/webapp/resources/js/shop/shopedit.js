$(function() {
	
	var shopId = getQueryString('shopId');
	var shopInfoUrl = "/shop/getshopinfo?shopId=" + shopId;
	var registerShopUrl = "/shop/registershop";
	getShopInitInfo();
	
	function getShopInitInfo() {
		$.getJSON(shopInfoUrl, function(data) {
			if (data.success) {
				var shop = data.shop;
				$('#shop-name').val(shop.shopName);
				$('#shop-addr').val(shop.shopAddr);
				$('#shop-phone').val(shop.phone);
				$('#shop-desc').val(shop.shopDesc);
				
				var shopCategoryHtml = "";
				var tempAreaHtml = "";
				data.shopCategoryList.map(function(item, index) {
					shopCategoryHtml += '<option data-id="' + item.shopCategoryId
							+ '">' + item.shopCategoryName + '</option>';
				});

				data.areaList.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">'
							+ item.areaName + '</option>';
				});
				$('#shop-category').html(shopCategoryHtml);
				$('#shop-category').attr('disabled', 'disabled');
				$('#area').html(tempAreaHtml);
				//$('#area').attr('data-id', shop.areaId);
			}
		})
	}
	;

	$("#submit").click(function() {
		var shop = {};
		shop.shopName = $("#shop-name").val();
		shop.shopAddr = $('#shop-addr').val();
		shop.phone = $('#shop-phone').val();
		shop.shopDesc = $('#shop-desc').val();

		shop.shopCategory = {
			shopCategoryId : $('#shop-category').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
		shop.area = {
			areaId : $('#area').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};

		var shopImg = $("#shop-img")[0].files[0];
		var formData = new FormData();
		formData.append('shopImg', shopImg);
		formData.append('shopStr', JSON.stringify(shop));
		
		var verifyCodeActual = $('#j_captcha').val();
		if (!verifyCodeActual) {
			$.toast('请输入验证码！');
			return;
		}
		formData.append("verifyCodeActual", verifyCodeActual);
		$.ajax({
			url : registerShopUrl,
			type : 'POST',
			// contentType: "application/x-www-form-urlencoded; charset=utf-8",
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					$.toast('提交成功！');
					if (isEdit) {
						$('#captcha_img').click();
					} else {
						window.location.href = "/shop/shoplist";
					}
				} else {
					$.toast('提交失败！');
				}
				$("#captcha_img").click();
			}
		});
	});

})