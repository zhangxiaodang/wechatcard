$(function () {
	
	/**
	 * 卡密码修改.
	 */
	$("#change_pass").on('click', function (evt) {
    	window.location.href = 'wec0035?dzcardno='+dzcardno;
    });
    
    
    $("#mycoupon").on('click', function (evt) {
    	window.location.href = 'wec0040';
    });
    
    /**
     * 消费记录
     */
    $("#consume").on('click', function (evt) {
    	window.location.href = 'wec0033?dzcardno='+dzcardno;
    });
    
    /**
    * 充值记录
    */
   $("#recharge").on('click', function (evt) {
   		window.location.href = 'wec0036?dzcardno='+dzcardno;
   });
    
    /**
     * 我要充值.
     */
    $("#chongzhi_pass").on('click', function (evt) {
    	window.location.href = 'wec0032?cardno='+cardno;
    });
    // 整个头部都可以点击
    $("header.carousel").click(function(evt) {
        $(".bs-example-modal-lg").modal('show');
    });

    $(".bs-example-modal-lg").click(function (evt) {
        $(this).modal('hide');
    });
    // 条形码
    $("#bcTarget").empty().barcode(dzcardno, "code11",{barWidth:1, barHeight:50});
    
    // 二维码
    var qrcode = new QRCode(document.getElementById("qrcode"), {
        width : 150,
        height : 150
    });
    
    qrcode.makeCode(cardno);
});
    