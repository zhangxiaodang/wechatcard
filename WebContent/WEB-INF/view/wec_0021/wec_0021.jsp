<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>申请新卡</title>
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <link href="../css/public/bootstrap.min.css" rel="stylesheet">
    <link href="../css/wec_0021.css" rel="stylesheet">
    <link href="../css/public/m.css" rel="stylesheet">

    <script src="../js/public/jquery.min.js"></script>
    <script src="../js/public/bootstrap.min.js"></script>
    <script src="../js/public/m.js"></script>
    <script src="../js/wec_0021.js"></script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" id="user-reg">
                <div class="input-group">
                    <span class="input-group-addon" for="mobile"><span class="red-text">* </span>手机号：</span>
                    <input type="text" id="mobile" class="form-control" readonly="readonly" value="18678399534" placeholder="手机号不可为空" aria-describedby="basic-addon1">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" for="yzm"><span class="red-text">* </span>验证码：</span>
                    <input type="text" id="yzm" class="form-control" aria-describedby="basic-addon1">
                </div>
                <div id="get_code"><button type="button" class="btn btn-info">获取验证码</button></div>
                <h4>请输入6位开卡密码</h4>
                <div class="input-group">
                    <span class="input-group-addon" for="new_card_psd1"><span class="red-text">* </span>密码：</span>
                    <input type="text" id="new_card_psd1" class="form-control" aria-describedby="basic-addon1">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" for="new_card_psd2"><span class="red-text">* </span>确认密码：</span>
                    <input type="text" id="new_card_psd2" class="form-control" aria-describedby="basic-addon1">
                </div>

                <div class="form-group">
                    <div class="col-sm-12 tijiao">
                        <button id="tijiao" type="button" class="btn btn-primary btn-lg">申请</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>