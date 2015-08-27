/**
 * 判断密码是否是6位数字
 **/

function check_pass(password){
	if (password.length != 6){
		return false;
	}
	var re = /^[0-9]*$/;
	return re.test(password);
}

/**
 * 判断会员卡合法性
 **/

function check_card(password){
	var re = /^[0-9]*$/;
	return re.test(password);
}