$(function () {
	param = {};
	param.member_phone = member_phone;
    // 提交按钮
    $('#tijiao').on('click', function (evt) {
    	$.post("wec0023/change_openid", param, function (data) {
    		alert();
            data = JSON.parse(data);
            if(data.state === '000000') {
                // 注册成功，跳转页面
                window.location.href = 'wec0020';
            } else {
                $.mAlert( data.msg );
            }
        })
    });
});