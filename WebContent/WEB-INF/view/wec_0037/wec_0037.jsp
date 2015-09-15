<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>消费记录查询</title>
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width">
    <link href="resources/css/public/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/wec_0037.css" rel="stylesheet">
    <link href="resources/css/public/m.css" rel="stylesheet">

    <script src="resources/js/public/jquery.min.js"></script>
    <script src="resources/js/public/bootstrap.min.js"></script>
    <script src="resources/js/public/m.js"></script>
    <script src="resources/js/public/common.js"></script>
    <script src="resources/js/wec_0037.js"></script>
</head>
<script type="text/javascript">
	var dzcardno = "${dzcardno}";
</script>
<body>

<div id="search" class="container-fluid">
    <div class="panel-body">
        <div class="input-group">
            <span class="input-group-addon" for="cardno"><span class="red-text">* </span>卡号：</span>
            <input type="text" id="cardno" class="form-control" readonly="readonly"  aria-describedby="basic-addon1" value="${dzcardno}">
        </div>
        <div class="input-group" style="margin-top:20px;">
            <span class="input-group-addon" for="oldpassword"><span class="red-text">* </span>密码：</span>
            <input type="password" id="passwd" class="form-control" aria-describedby="basic-addon1" maxlength="6">
        </div>
        <div style="margin-top:20px;">密码应为6位数字</div>
        <div style="margin-top:0px;">时间格式为年月日，例如:20150701</div>
        <div style="margin-top:0px;">日期间隔不能超过3个月</div>
        
        <div class="input-group" style="margin-top:20px;">
            <span class="input-group-addon" for="password"><span class="red-text">* </span>开始日期：</span>
            <input type="text" id="date_start" class="form-control" aria-describedby="basic-addon1" maxlength="8">
        </div>
        <div class="input-group" style="margin-top:20px;">
            <span class="input-group-addon" for="confirmpassword"><span class="red-text">* </span>结束日期：</span>
            <input type="text" id="date_end" class="form-control" aria-describedby="basic-addon1" maxlength="8">
        </div>
    </div>
    <div class="form-group" style="margin-top:40px;">
        <div class="col-sm-12">
            <button id="tijiao" type="button" class="btn btn-primary btn-lg btn-block">提交</button>
        </div>
    </div>
</div>

</body>
</html>