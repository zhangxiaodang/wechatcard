$(function() {
	// 验证账户
    $("#get_code").touchClick(function(){
        var mobile = $("#mobile").val();
        if (!mobile.isPhone()) {
            $.mAlert("请输入有效的手机号码");
            return;
        }

        $("#get_code>button").dxlCountdown({
            firstText: "发送验证码",
            sendText: "重新发送",
            waitText: "s",
            mobile: $("#mobile"),
            sendAction: function() {
                sendCode($("#mobile").val(), $("#yzm"));
            },
            sendError: function() {
                $.mAlert("请输入有效的手机号码");
            }
        });
    });
    
	$('#tijiao').on('click', function(evt) {
		var param = {};
		var old_mobile = $("#old_mobile").val();
		param.newphone = $("#newphone").val();
		param.yzm = $("#yzm").val();
		
		if ('' === param.newphone) {
			$.mAlert("手机号不可为空！");
			return;
		}
		
		if (!param.newphone.isPhone()) {
            $.mAlert("请输入有效的手机号码");
            return;
        }
		
		if (old_mobile === param.newphone) {
			$.mAlert("原手机号和新手机号相同！");
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
				$('#old_mobile').val(param.newphone);
				$("#newphone").val('');
				$("#yzm").val('');
			}
		})
	})
})