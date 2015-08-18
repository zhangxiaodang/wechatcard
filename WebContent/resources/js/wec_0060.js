$(function() {

	$('#tijiao').on('click', function(evt) {
		var param = {};

		param.newphone = $("#newphone").val();
		param.yzm = $("#yzm").val();

		if ('' === param.newphone) {
			$.mAlert("手机号不可为空！");
			return;
		}

		if ('' === param.yzm) {
			$.mAlert("验证码不可为空！");
			return;
		}

		$.post("wec0060/change_phone", param, function(data) {
			data = JSON.parse(data);
			$.mAlert(data.msg);
			if (data.state === '000000') {
				// 修改成功，跳转页面
				alter('更新成功');
			}
		})
	})
})