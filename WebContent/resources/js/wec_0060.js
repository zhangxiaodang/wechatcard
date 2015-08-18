$(function () {

	$('#tijiao').on('click', function (evt) {
		var param = {};
		
	    param.memberphone = $("#memberphone").val();
	    param.yzm = $("#yzm").val();
	    
	    if('' === param.phone) {
	        $.mAlert("手机号不可为空！");
	        return;
	    }
	    if('' === param.password) {
	        $.mAlert("验证码不可为空！");
	        return;
	    }
	    
		$.post("change_phone", param, function (data) {
	        data = JSON.parse(data);
	        $.mAlert( data.msg );
	        if(data.state === '000000') {
	            // 修改成功，跳转页面
	            window.location.href = 'wec0031';
	        }
	    })
	})
})