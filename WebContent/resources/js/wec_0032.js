$(function() {
    
	$('#tijiao').on('click', function(evt) {
		var param = {};
		param.money = $("#money").val();
		
		if ('' === param.money) {
			$.mAlert("金额不可为空！");
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