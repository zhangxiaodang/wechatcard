$(function () {
	
	$("#change_pass").on('click', function (evt) {
    	window.location.href = 'wec0035?dzcardno='+dzcardno;
    });
    
    
    $("#mycoupon").on('click', function (evt) {
    	window.location.href = 'wec0040';
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
    