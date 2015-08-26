$(function () {

	$('#tijiao').on('click', function (evt) {
		var param = {};
		
		param.password = $("#password").val();
	    param.confirmpassword = $("#confirmpassword").val();
	    param.oldpassword = $("#oldpassword").val();
	    
	    if('' === param.oldpassword) {
	        $.mAlert("原密码不可为空！");
	        return;
	    }
	    if('' === param.password) {
	        $.mAlert("新密码不可为空！");
	        return;
	    }
	    if('' === param.confirmpassword) {
	        $.mAlert("确认密码不可为空！");
	        return;
	    }
	    if(param.password != param.confirmpassword) {
	        $.mAlert("两次密码输入必须相同");
	        return;
	    }
	    
		$.post("change_pass", param, function (data) {
	        data = JSON.parse(data);
	        $.mAlert( data.msg );
	        if(data.state === '000000') {
	            // 修改成功，跳转页面到卡详情页面。返回历史即可。
	        	window.history.go(-1);
	        }
	    })
	})
})