$(function() {

	// 提交按钮
	$('#btnClose').on('click', function(evt) {
		// window.opener = null;
		// window.open('', '_self');
		// window.close();
		
		// 微信浏览器关闭
		try {
			WeixinJSBridge.call('closeWindow');
		} catch (err) {
			alert(err.message)
		}
	});

});