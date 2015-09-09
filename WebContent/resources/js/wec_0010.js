$(function () {
	// 设置日期的年-月-日
	// 设置日期的年-月-日
    var currYear = (new Date()).getFullYear();
    var opt={};
    opt.date = {preset : 'date'};
    opt.datetime = {preset : 'datetime'};
    opt.time = {preset : 'time'};
    opt.default = {
        theme: 'android-ics light', //皮肤样式
        display: 'modal', //显示方式
        mode: 'scroller', //日期选择模式
        lang:'zh',
        startYear:currYear - 10, //开始年份
        endYear:currYear + 10 //结束年份
    };

    $('#shengri').val('').scroller('destroy').scroller($.extend(opt['date'], opt['default']));
    $("#new_card").show();

    // 卡类型值变化
    $("#kaleixing").on('change', function (evt) {
        var _this = this;
        switch ($(_this).val()) {
            case '01':
                $("#old_card").hide();
                $("#new_card").show();
                break;
            case '02':
                $("#new_card").hide();
                $("#old_card").show();
                break;
            default:
                $("#new_card").hide();
                $("#old_card").hide();
                break;
        }
    });

    // 验证账户
    $("#get_code").touchClick(function(){
    //$("#get_code").click(function(){
        var mobile = $("#mobile").val();
        if (!mobile.isPhone()) {
            $.mAlert("请输入有效的手机号码");
            return;
        }

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
        param.memberphone = $("#mobile").val();
        param.memberyzm = $("#yzm").val();
        param.cardmode = $("#kaleixing").val();
        param.membername = $('#name').val();
        param.membersex = $("#xingbie").val();
        // 默认为空
        param.password = "";
        param.memberbirthday = $("#shengri").val();

        if (!param.memberphone.isPhone()) {
            $.mAlert("请输入有效的手机号码");
            return;
        }

        if (!param.memberyzm || param.memberyzm.length != 6) {
            $.mAlert("验证码错误");
            return;
        }

        if( '' === $.trim( param.membername ) ) {
            $.mAlert("姓名不可为空！");
            return;
        }
        
        if( '' == param.membersex ) {
        	$.mAlert("请选择性别！");
            return;
        }
        
        if( '' == param.membersex ) {
        	$.mAlert("请选择性别！");
            return;
        }

        if (param.memberbirthday == '' || param.memberbirthday == null) {
            $.mAlert("生日不可为空！");
            return;
        }

        if(!param.cardmode) {
            $.mAlert("请选择卡类型");
            return;
        }

        // 卡类型验证
        if(param.cardmode === '01') {

            var new_card_psd1 = $('#new_card_psd1').val();
            var new_card_psd2 = $('#new_card_psd2').val();
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

        }

        if(param.cardmode === '02') {

            var old_card_psd = $("#old_card_psd").val();
            var old_card_code = $("#old_card_code").val();
            if('' === old_card_code) {
                $.mAlert("卡号不可为空！");
                return;
            }
            if(!check_card(old_card_code)) {
                $.mAlert("卡号只能为数字！");
                return;
            }

            if(!check_pass(old_card_psd)) {
                $.mAlert("请输入6位数字密码！");
                return;
            }

            param.password = $("#old_card_psd").val();
            param.cardno = $("#old_card_code").val();
        }
        // 如果不是【暂不开卡】的话，需要校验密码位数。
        if (param.cardmode != '03'){
        	if (!param.password.isPassword()) {
                $.mAlert("密码必须是6到18位之间！");
                return;
            }
        }

        $(_this).text("注册中...").prop('disabled', true);

        $.post("wec0010/register", param, function (data) {
            $(_this).text("提交").prop('disabled', false);
            data = JSON.parse(data);
            if(data.state === '000000') {
            	// 如果选择的是【暂不开卡】，跳转到申请会员卡界面。
            	if(param.cardmode === '03'){
            		window.location.href = 'wec0020'
            	}else{
            		// 注册成功，跳转页面
                    window.location.href = 'wec0031?membercardid='+data.membercardid;
            	}
            } else {
            	$.mAlert( data.msg );
            	// 如果手机号已经被注册了。
            	if(data.phone_is_regist){
            		window.location.href = 'wec0023?member_phone='+data.member_phone;
            	}
                
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
                $.mAlert("验证码已发送，请注意查收!");
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