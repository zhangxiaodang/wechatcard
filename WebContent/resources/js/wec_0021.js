$(function () {

	// 获取验证码
    $("#get_code").touchClick(function(){
        var mobile = $("#mobile").val();
        if (!mobile.isPhone()) {
            $.mAlert("请输入有效的手机号码");
            return;
        }
        
        // 清空验证码
        $("#txtYzmHide").val("");

        $("#get_code>button").dxlCountdown({
            firstText: "发送验证码",
            sendText: "重新发送",
            waitText: "秒",
            memberphone: $("#mobile"),
            sendAction: function() {
                sendCode($("#mobile").val(), $("#yzm"));
            },
            sendError: function() {
                $.mAlert("请输入有效的手机号码");
            }
        });
    });

    // 提交按钮
    $('#tijiao').on('click', function (evt) {
        var param = {};
        var _this = this;
        var new_card_psd1 = $('#new_card_psd1').val();
        var new_card_psd2 = $('#new_card_psd2').val();
        param.memberphone = $("#mobile").val();
        param.memberyzm = $("#yzm").val();
        // 后台验证码
        param.yzmhide = $('#txtYzmHide').val();

        if (!param.memberphone.isPhone()) {
            $.mAlert("请输入有效的手机号码");
            return;
        }

        if (!param.memberyzm || param.memberyzm.length != 6 || param.memberyzm != param.yzmhide) {
            $.mAlert("验证码错误");
            return;
        }
        
        if(!check_pass(new_card_psd1)) {
            $.mAlert("请输入6位数字开卡密码！");
            return;
        }
        if(!check_pass(new_card_psd2)) {
            $.mAlert("请输入6位数字开卡确认密码！");
            return;
        }
        if(new_card_psd1 != new_card_psd2) {
            $.mAlert("两次密码输入必须相同");
            return;
        }

        param.password = new_card_psd1;

        if (!param.password.isPassword()) {
            $.mAlert("密码错误");
            return;
        }

        $(_this).text("申请中...").prop('disabled', true);

        $.post("applyNewCard", param, function (data) {
        	data = JSON.parse(data);
            $(_this).text("提交").prop('disabled', false);
            if(data.state === '000000') {
                // 注册成功，跳转页面
                window.location.href = 'wec0031?membercardid='+data.membercardid;
            } else {
                $.mAlert( data['msg'] );
            }
        })
    });

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


});