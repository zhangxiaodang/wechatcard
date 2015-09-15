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

/**
 * 检验日期格式是否为YYYYMMDD
 * @param param_date
 */
function check_date(param_date) {
	
	if (param_date.length != 8){
		return false;
	}
	
	var re = /^[0-9]{4}[0-1]?[0-9]{1}[0-3]?[0-9]{1}$/;
	return re.test(param_date);
}