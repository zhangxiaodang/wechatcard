$(function() {

	$('#tijiao').on('click', function(evt) {

		var regex = /^[0-9]*(\.[0-9]{1,2})?$/;
		var money = $("#money").val();

		if ('' === money) {
			$.mAlert("金额不可为空！");
			return;
		}

		if (!regex.test(money)) {
			$.mAlert("金额输入不正确！");
			return;
		}

		$.post("wec0032/chongzhi", {
			cardno : $("#cardno").val(),
			money : money
		}, function(data) {
			data = JSON.parse(data);
			$.mAlert(data.msg);
			if (data.state === '000000') {
				$.mAlert("充值成功！");
				$("#money").val('');
			} else {
				$.mAlert("充值失败，请重试！");
			}
		})
	})

})