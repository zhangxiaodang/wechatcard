<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>充值记录</title>
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width">
    <link href="resources/css/public/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/wec_0036.css" rel="stylesheet">
    <link href="resources/css/public/m.css" rel="stylesheet">

    <script src="resources/js/public/jquery.min.js"></script>
    <script src="resources/js/public/bootstrap.min.js"></script>
    <script src="resources/js/public/m.js"></script>
    <script src="resources/js/wec_0036.js"></script>
</head>
<script type="text/javascript">
	var dzcardno = "${dzcardno}";
</script>
<body>

<div class="heading">
	<span>充值记录</span>
	<hr style="border:none;border-top:1.5px solid #000;width:98%;margin-top:3px;" />
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="list-group" id="list">
                
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12 jzgd">
            <p>没有更多了哦</p>
            <button id="jzgd" type="button" class="btn btn-primary btn-lg">加载更多</button>
        </div>
    </div>
</div>

</body>
</html>