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
    <link href="resources/css/wec_0060.css" rel="stylesheet">
    <link href="resources/css/public/m.css" rel="stylesheet">

    <script src="resources/js/public/jquery.min.js"></script>
    <script src="resources/js/public/bootstrap.min.js"></script>
    <script src="resources/js/public/m.js"></script>
    <script src="resources/js/wec_0060.js"></script>
</head>
<body>

<div class="container-fluid">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <form class="form-horizontal" id="user-reg">
                	<div class="input-group">
                        <span class="input-group-addon" for="mobile">原手机号：</span>
                        <input type="text" id="mobile" class="form-control" value="18363016696"  disabled="disabled" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon" for="mobile"><span class="red-text">* </span>手机号：</span>
                        <input type="text" id="memberphone" class="form-control" value="" placeholder="手机号不可为空" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group"> 
                        <div class="input-group">
                            <span class="input-group-addon" for="yzm"><span class="red-text">* </span>验证码：</span>
                            <input type="text" id="yzm" class="form-control" placeholder="验证码不可为空"  aria-describedby="basic-addon1">
                        </div>
                    </div>
                    <div id="get_code"><button type="button" class="btn btn-info">获取验证码</button></div>
                </form>
            </div>
        </div>
    </div>
    <div class="form-group" style="margin-top:40px;">
        <div class="col-sm-12">
            <button id="tijiao" type="button" class="btn btn-primary btn-lg btn-block">确定修改</button>
        </div>
    </div>
</div>

</body>
</html>