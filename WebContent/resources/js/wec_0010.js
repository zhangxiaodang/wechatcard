$(function () {

    // 设置日期的年-月-日 shengri_year shengri_month shengri_day

    // 只计算出年 从今年开始的近50年
    var year_all = '';
    var year = (new Date()).getFullYear();
    for(var i = year; i > year - 50; i--) {
        year_all += '<option value="' + i + '">' + i + '</option>';
    }
    $('#shengri_year').append( year_all );

    var month = ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'];

    $("#shengri_year").on('change', function (evt) {
        var _this = this;
        var month_str = '<option value="">月</option>';
        if('' !== $(_this).val()) {
            for(var i = 0; i < month.length; i++) {
                month_str += '<option value="' + month[i] + '">' + month[i] + '</option>';
            }
        }
        $('#shengri_day').empty().append( '<option value="">日</option>' );
        $('#shengri_month').empty().append( month_str );
    });

    $('#shengri_month').on('change', function (evt) {
        var _this = this;
        var day_str = '<option value="">日</option>';
        var year = $("#shengri_year").val();
        var month = $(_this).val();
        var day = getDay(year, month);

        if('' !== $(_this).val()) {
            for(var i = 0; i < day.length; i++) {
                day_str += '<option value="' + day[i] + '">' + day[i] + '</option>';
            }
        }

        $('#shengri_day').empty().append( day_str );
    });

    function getDay(year, month) {
        var month_num = new Date(year, month, 0).getDate();
        var month_arr = [];
        for(var i = 1; i <= month_num; i++) {
            month_arr.push( i<9 ? '0' + i: i );
        }
        return month_arr;
    }


    // 通过年月计算出日

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

    // 提交按钮
    $('#tijiao').on('click', function (evt) {
        var param = {};
        var _this = this;
        param.memberphone = $("#mobile").val();
        param.memberyzm = $("#yzm").val();
        param.cardmode = $("#kaleixing").val();
        param.membername = $('#name').val();
        param.membersex = $("#xingbie").val();
        param.memberbirthday = $("#shengri_year").val() + '-' + $("#shengri_month").val() + '-' + $("#shengri_day").val();



        if (!param.memberphone.isPhone()) {
            $.mAlert("请输入有效的手机号码");
            return;
        }

//        if (!param.memberyzm || param.memberyzm.length != 6) {
//            $.mAlert("验证码错误");
//            return;
//        }

        if( '' === $.trim( param.membername ) ) {
            $.mAlert("姓名不可为空！");
            return;
        }

        if (param.memberbirthday && !param.memberbirthday.isShengRi()) {
            $.mAlert("生日格式错误");
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
            if('' === new_card_psd1) {
                $.mAlert("密码不可为空！");
                return;
            }
            if('' === new_card_psd2) {
                $.mAlert("确认密码不可为空！");
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

            if('' === old_card_psd) {
                $.mAlert("密码不可为空！");
                return;
            }

            param.password = $("#old_card_psd").val();
            param.cardno = $("#old_card_code").val();
        }

        if (!param.password.isPassword()) {
            $.mAlert("密码错误");
            return;
        }

        $(_this).text("注册中...").prop('disabled', true);

        $.post("wec0010/register", param, function (data) {
            $(_this).text("提交").prop('disabled', false);
            data = JSON.parse(data);
            if(data.state === '000000') {
                // 注册成功，跳转页面
                window.location.href = 'wec0020';
            } else {
            	$.mAlert( data.msg );
            	// 如果手机号已经被注册了。
            	if(data.phone_is_regist){
            		window.location.href = 'wec0060';
            	}
                
            }
        })
    });

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
                $.mAlert( data.msg );
            }
        });
    }


});