$(function() {

	// 提交按钮
	$('#btnClose').on('click', function(evt) {
		window.opener = null;
		window.open('', '_self');
		window.close()
	});

});