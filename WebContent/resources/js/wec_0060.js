$(function() {
	// 验证账户
	$("#get_code").touchClick(function(){
        var newphone = $("#newphone").val();

        if (!newphone.isPhone()) {
            $.mAlert("请输入有效的新手机号");
            return;
        }

        $("#get_code>button").dxlCountdown({
            firstText: "发送验证码",
            sendText: "重新发送",
            waitText: "秒",
            mobile: $("#newphone"),
            sendAction: function() {
                sendCode($("#newphone").val(), $("#yzm"));
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
	// 发送短信验证码
    function sendCode(mobile, $focusDom) {
        var getCodeBtn = $("#get_code>button");
        getCodeBtn.prop('disabled', true);
        $.dxlSmsSend({
            mobile: mobile
        }, function (data) {
            if (data.code == 1) {
                $.mAlert("验证码已发送，请注意查收");
                $focusDom.focus();
                setTimeout(function() {
                    getCodeBtn.prop('disabled', false);
                }, 60 * 1000);
            } else {
                $.mAlert( data['msg'] );
            }
        });
    }
})