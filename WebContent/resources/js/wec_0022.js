$(function () {

    // 提交按钮
    $('#tijiao').on('click', function (evt) {
        var param = {};
        var _this = this;

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

        $(_this).text("申请中...").prop('disabled', true);

        $.post("bindingOldCard", param, function (data) {
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


});