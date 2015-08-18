$(function() {
	if (phone_is_used == true || phone_is_used == 'true'){
		$("#btnNewCard").attr('disabled','disabled');
	}

	/**
	 * 申请新卡按钮.
	 */
	$('#btnNewCard').on('click', function(evt) {
		window.location.href = 'wec0021';
	});

	$('#btnOldCard').on('click', function(evt) {
		window.location.href = 'wec0022';
	});
});