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

        if('' === old_card_psd) {
            $.mAlert("密码不可为空！");
            return;
        }

        param.password = $("#old_card_psd").val();
        param.cardno = $("#old_card_code").val();

        $(_this).text("申请中...").prop('disabled', true);

        $.post("http://localhost:8080/wechatcard/register", param, function (data) {
            $(_this).text("提交").prop('disabled', false);
            if(data.state === '000000') {
                // 注册成功，跳转页面
                window.location.href = '../html/wec_0010.html';
            } else {
                $.mAlert( data['msg'] );
            }
        })
    });


});