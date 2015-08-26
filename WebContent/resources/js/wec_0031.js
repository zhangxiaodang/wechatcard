$(function () {
	
	$("#change_pass").on('click', function (evt) {
    	window.location.href = 'wec0035';
    })
    
    
    $("#mycoupon").on('click', function (evt) {
    	window.location.href = 'wec0040';
    })
    
    $("header>img").on('click', function (evt) {
        $.dxlBackgroundShow();
        $("#ersanwei").show().dxlLayerFixedShow();
    });

    $("#ersanwei").on('click', function (evt) {
        $.dxlBackgroundHide();
        $("#ersanwei").hide();
    })
})
    