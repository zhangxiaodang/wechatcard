$(function () {

    // 领取优惠券
    $('#tijiao').on('click', function (evt) {
        // 优惠券id
        $.post('wec0041/collect_coupon', { couponid: couponid }, function (data) {
            if(data.state === '000000') {
                // 领取完毕后，展示优惠券详情页0042
            	$.mAlert( data['msg'] );
            } else {
                $.mAlert( data['msg'] );
            }
        },'json')
    });

});