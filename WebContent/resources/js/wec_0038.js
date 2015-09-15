$(function () {
    
    /**
     * 提交按钮.
     */
    $("#tijiao").click(function() {
    	
    	var param = {};
    	// 卡号
    	param.dzcardno = $("#cardno").val();
    	// 密码
    	param.passwd = $("#passwd").val();
    	// 开始日期
    	param.date_start = $("#date_start").val();
    	// 结束日期
    	param.date_end = $("#date_end").val();
    	
    	if(!check_pass(param.passwd)) {
	        $.mAlert("密码只能为6位数字！");
	        return;
	    }
    	
    	if("" == param.date_start) {
    		$.mAlert("开始日期不能为空！");
	        return;
    	}
    	
    	if(!check_date(param.date_start)) {
    		$.mAlert("开始日期格式不正确！");
	        return;
    	}
    	
    	if("" == param.date_end) {
    		$.mAlert("结束日期不能为空！");
	        return;
    	}
    	
    	if(!check_date(param.date_end)) {
    		$.mAlert("结束日期格式不正确！");
	        return;
    	}
    	
    	$.post("wec0038/check", param, function (data) {
	        data = JSON.parse(data);
	        $.mAlert( data.msg );
	        if(data.state === '000000') {
	            // 成功后跳转到查询结果页面
	        	window.location.href = 'wec0036?dzcardno='+dzcardno+'&date_start='+param.date_start+'&date_end='+param.date_end;
	        }
	    })
    });
});