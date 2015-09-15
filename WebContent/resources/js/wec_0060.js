$(function() {
	// 获取验证码
	$("#get_code").touchClick(function(){
	//$("#get_code").click(function(){
        var newphone = $("#newphone").val();

        if (!newphone.isPhone()) {
            $.mAlert("请输入有效的新手机号");
            return;
        }
        
        // 清空验证码
        $("#txtYzmHide").val("");

        $("#get_code>button").dxlCountdown({
            firstText: "发送验证码",
            sendText: "重新发送",
            waitText: "秒",
            memberphone: $("#newphone"),
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
		param.oldphone = $("#old_mobile").val();
		param.newphone = $("#newphone").val();
		param.passwd = $("#password").val();
		param.yzm = $("#yzm").val();
        // 后台验证码
        param.yzmhide = $('#txtYzmHide').val();
        
        if('' == param.passwd) {
        	$.mAlert("卡密码不可为空！");
        	return;
        }
		
		if ('' === param.newphone) {
			$.mAlert("手机号不可为空！");
			return;
		}
		
		if (!param.newphone.isPhone()) {
            $.mAlert("请输入有效的手机号码");
            return;
        }
		
		if (param.oldphone === param.newphone) {
			$.mAlert("原手机号和新手机号相同！");
			return;
		}

		if ('' === param.yzm) {
			$.mAlert("验证码不可为空！");
			return;
		}
		
		if (param.yzm.length != 6 || param.yzm != param.yzmhide) {
            $.mAlert("验证码错误！");
            return;
        }

		$.post("wec0060/change_phone", param, function(data) {
			data = JSON.parse(data);
			$.mAlert(data.msg);
			if (data.state === '000000') {
				setTimeout(function() {
					window.location.href = 'wec0060';
                }, 3 * 1000);
//				$('#old_mobile').val(param.newphone);
//				$("#newphone").val('');
//				$("#password").val('');
//				$("#yzm").val('');
//				$("#txtYzmHide").val('');
			}
		})
	})
	// 发送短信验证码
    function sendCode(mobile, $focusDom) {
        var getCodeBtn = $("#get_code>button");
        getCodeBtn.prop('disabled', true);
        $.dxlSmsSend({
        	memberphone: mobile
        }, function (data) {
        	// 转为JSON
        	data = JSON.parse(data);
        	
            if (data.state == '000000') {
                $.mAlert("验证码已发送，请注意查收");
                // 保存验证码
                $('#txtYzmHide').val(data.yzm);
                $focusDom.focus();
                setTimeout(function() {
                    getCodeBtn.prop('disabled', false);
                }, 60 * 1000);
            } else {
            	$.mAlert( data.msg );
            }
        });
    }
})