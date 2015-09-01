<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>密码修改</title>
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <link href="resources/css/public/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/wec_0035.css" rel="stylesheet">
    <link href="resources/css/public/m.css" rel="stylesheet">

    <script src="resources/js/public/jquery.min.js"></script>
    <script src="resources/js/public/bootstrap.min.js"></script>
    <script src="resources/js/public/m.js"></script>
    <script src="resources/js/public/common.js"></script>
    <script src="resources/js/wec_0035.js"></script>
</head>
<body>

<div class="container-fluid">
    <div class="panel-body">
        <div class="input-group">
            <span class="input-group-addon" for="new_card_psd1"><span class="red-text">* </span>卡&nbsp;&nbsp;&nbsp;号：</span>
            <input type="text" id="new_card_psd1" class="form-control" disabled="disabled" aria-describedby="basic-addon1" value="${dzcardno}">
        </div>
        <div class="input-group" style="margin-top:20px;">
            <span class="input-group-addon" for="oldpassword"><span class="red-text">* </span>原密码：</span>
            <input type="password" id="oldpassword" class="form-control" aria-describedby="basic-addon1" maxlength="6">
        </div>
        <div style="margin-top:20px;">请输入六位数字密码</div>
        <div class="input-group" style="margin-top:20px;">
            <span class="input-group-addon" for="password"><span class="red-text">* </span>新&nbsp;密&nbsp;码&nbsp;：</span>
            <input type="password" id="password" class="form-control" aria-describedby="basic-addon1" maxlength="6">
        </div>
        <div class="input-group" style="margin-top:20px;">
            <span class="input-group-addon" for="confirmpassword"><span class="red-text">* </span>确认密码：</span>
            <input type="password" id="confirmpassword" class="form-control" aria-describedby="basic-addon1" maxlength="6">
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