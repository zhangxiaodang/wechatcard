$(function () {
//	if (ly_zt === '已领用'){
//		$('#tijiao').attr('disabled','disabled');
//	}
    // 领取优惠券
    $('#tijiao').on('click', function (evt) {
        // 优惠券id
        $.post('wec0041/collect_coupon', { couponid: couponid }, function (data) {
            if(data.state === '000000') {
                // 领取完毕后，展示优惠券详情页0042
            	window.location.href = 'wec0042?couponid='+data.coupon_id;
            } else {
                $.mAlert( data['msg'] );
            }
        },'json')
    });

    // 二维码
    var qrcode = new QRCode(document.getElementById("qrcode"), {
        width : 300,
        height : 300
    });
    
    qrcode.makeCode(coupno);
});