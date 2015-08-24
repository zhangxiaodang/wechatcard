$(function () {

    $("#kahao_group").on('click', 'ul.dropdown-menu a', function (evt) {
        var _this = $(evt.target);
        $("#kahao").val( _this.text() );
    });

    $("#tijiao").on('click', function (evt) {
        var param = {};
        var _this = this;

        param.kahao = $("#kahao").val();
        param.jiner = $("#jiner").val();
        param.yhq = $("#collapseExample").find("input[name='yhq']:checked").attr("value");
        param.bz = $("#bz").val();
        param.psd = $("#psd").val();

        if('' === param.kahao) {
            $.mAlert("卡号不可为空！");
            return;
        }

        if('' === param.jiner) {
            $.mAlert("金额不可为空！");
            return;
        }

        if('' === param.yhq) {
            $.mAlert("优惠券不可为空！");
            return;
        }

        if('' === param.bz) {
            $.mAlert("备注不可为空！");
            return;
        }

        if('' === param.psd) {
            $.mAlert("密码不可为空！");
            return;
        }

        $(_this).text("正在付款中...").prop('disabled', true);

        $.post("http://localhost:8080/wechatcard/register", param, function (data) {
            $(_this).text("确认付款").prop('disabled', false);
            if(data.state === '000000') {
                // 注册成功，跳转页面
                window.location.href = '../html/wec_0010.html';
            } else {
                $.mAlert( data.msg );
            }
        })

    })

});