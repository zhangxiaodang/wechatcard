<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>错误</title>
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <link href="resources/css/public/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/wec_error.css" rel="stylesheet">
    <link href="resources/css/public/m.css" rel="stylesheet">

    <script src="resources/js/public/jquery.min.js"></script>
    <script src="resources/js/public/bootstrap.min.js"></script>
    <script src="resources/js/public/m.js"></script>
    
    <script src="resources/js/wec_error.js"></script>
    
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" id="user-reg">
                <div class="input-group">
                    <span class="input-group-addon red-text" for="new_card_psd1">${errmsg}</span>
                </div>

                <div class="form-group">
                    <div class="col-sm-12 tijiao">
                        <button id="btnClose" type="button" class="btn btn-primary btn-lg">关闭</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>