$(function() {

	$('#tijiao').on('click', function(evt) {

		var regex = /^([+-]?)((\d{1,3}(,\d{3})*)|(\d+))(\.\d{2})?$/;
		var money = $("#money").val();

		if ('' === money) {
			$.mAlert("金额不可为空！");
			return;
		}

		if (!regex.test(this.value)) {
			$.mAlert("金额输入不正确！");
			return;
		}

		// $.post("wec0060/change_phone", param, function(data) {
		// data = JSON.parse(data);
		// $.mAlert(data.msg);
		// if (data.state === '000000') {
		// }
		// })
	})

})