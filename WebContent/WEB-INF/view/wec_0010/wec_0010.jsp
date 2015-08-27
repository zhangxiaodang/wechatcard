<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>会员注册</title>
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <link href="resources/css/public/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/wec_0010.css" rel="stylesheet">
    <link href="resources/css/public/m.css" rel="stylesheet">
    <link href="resources/css/public/mobiscroll.css" rel="stylesheet">

    
    <script src="resources/js/public/jquery.min.js"></script>
    <script src="resources/js/public/bootstrap.min.js"></script>
    <script src="resources/js/public/mobiscroll.js"></script>
    <script src="resources/js/public/common.js"></script>
    <script src="resources/js/public/m.js"></script>
    <script src="resources/js/wec_0010.js"></script>
</head>
<body>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <form class="form-horizontal" id="user-reg">
                    <div class="input-group">
                        <span class="input-group-addon" for="mobile"><span class="red-text">* </span>手机号：</span>
                        <input type="text" id="mobile" class="form-control" value="" placeholder="手机号不可为空" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group">
                        <div class="input-group">
                            <span class="input-group-addon" for="yzm"><span class="red-text">* </span>验证码：</span>
                            <input type="text" id="yzm" class="form-control" placeholder="验证码不可为空"  aria-describedby="basic-addon1">
                        </div>
                    </div>
                    <div id="get_code"><button type="button" class="btn btn-info">获取验证码</button></div>
                    <div class="input-group">
                        <span class="input-group-addon" for="name"><span class="red-text">* </span>姓名：</span>
                        <input type="text" id="name" class="form-control" placeholder="姓名不可为空"  aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon" for="xingbie"><span class="red-text">* </span>性别：</span>
                        <select id="xingbie" class="form-control" aria-describedby="basic-addon1">
                            <option value="">请选择</option>
                            <option value="1">男</option>
                            <option value="2">女</option>
                        </select>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon" for="shengri"><span class="red-text">* </span>生日：</span>
                        <input type="text" id="shengri" class="form-control" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon" for="kaleixing"><span class="red-text">* </span>卡类型：</span>
                        <select id="kaleixing" class="form-control" aria-describedby="basic-addon1">
                            <option value="01">申请新卡</option>
                            <option value="02">绑定旧卡</option>
                            <option value="03">暂不开卡</option>
                        </select>
                    </div>

                    <!-- 申请新卡界面 -->
                    <div id="new_card" class="input-group">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">申请新卡</h3>
                            </div>
                            <div class="panel-body">
                                <h4>请输入6位开卡密码</h4>
                                <div class="input-group">
                                    <span class="input-group-addon" for="new_card_psd1"><span class="red-text">* </span>密码：</span>
                                    <input type="password" id="new_card_psd1" class="form-control" aria-describedby="basic-addon1" maxlength="6">
                                </div>
                                <div class="input-group">
                                    <span class="input-group-addon" for="new_card_psd2"><span class="red-text">* </span>确认密码：</span>
                                    <input type="password" id="new_card_psd2" class="form-control" aria-describedby="basic-addon1" maxlength="6">
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- 申请新卡界面 -->
                    <div id="old_card" class="input-group">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">绑定旧卡</h3>
                            </div>
                            <div class="panel-body">
                                <div class="input-group">
                                    <span class="input-group-addon" for="new_card_psd1"><span class="red-text">* </span>卡号：</span>
                                    <input type="text" id="old_card_code" class="form-control" aria-describedby="basic-addon1" maxlength="19">
                                </div>
                                <div class="input-group">
                                    <span class="input-group-addon" for="new_card_psd2"><span class="red-text">* </span>密码：</span>
                                    <input type="password" id="old_card_psd" class="form-control" aria-describedby="basic-addon1" maxlength="6">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-12 tijiao">
                            <button id="tijiao" type="button" class="btn btn-primary btn-lg">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>