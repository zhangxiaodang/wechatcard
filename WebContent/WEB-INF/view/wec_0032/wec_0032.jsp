<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我要充值</title>
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <link href="resources/css/public/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/wec_0060.css" rel="stylesheet">
    <link href="resources/css/public/m.css" rel="stylesheet">
    <link href="resources/css/public/mobiscroll.css" rel="stylesheet">

    <script src="resources/js/public/jquery.min.js"></script>
    <script src="resources/js/public/bootstrap.min.js"></script>
    <script src="resources/js/public/mobiscroll.js"></script>
    <script src="resources/js/public/common.js"></script>
    <script src="resources/js/public/m.js"></script>
    <script src="resources/js/wec_0032.js"></script>
    
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" id="user-reg">
                <div class="input-group">
                    <span class="input-group-addon" for="old_mobile"><span class="red-text">* </span>卡号：</span>
                    <input type="text" id="old_mobile" class="form-control" readonly="readonly" value="${cardno}" placeholder="手机号不可为空" aria-describedby="basic-addon1">
                </div>
                
                <div class="input-group">
                    <span class="input-group-addon" for="newphone"><span class="red-text">* </span>金额：</span>
                    <input type="text" id="money" class="form-control" value="" placeholder="金额不可为空" aria-describedby="basic-addon1" maxlength="11">
                </div>

                <div class="form-group">
                    <div class="col-sm-12 tijiao">
                        <button id="tijiao" type="button" class="btn btn-primary btn-lg">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>