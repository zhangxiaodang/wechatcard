$(function () {

	$('#tijiao').on('click', function (evt) {
		var param = {};
		
		param.password = $("#password").val();
	    param.confirmpassword = $("#confirmpassword").val();
	    param.oldpassword = $("#oldpassword").val();
	    param.cardno = $("#cardno").val();
	    
	    if(!check_pass(param.oldpassword)) {
	        $.mAlert("原密码只能为6位数字！");
	        return;
	    }
	    if(!check_pass(param.password)) {
	        $.mAlert("新密码只能为6位数字！");
	        return;
	    }
	    if(!check_pass(param.confirmpassword)) {
	        $.mAlert("确认密码只能为6位数字！");
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