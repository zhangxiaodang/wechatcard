<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我要付款</title>
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width">
    <link href="resources/css/public/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/wec_0050.css" rel="stylesheet">
    <link href="resources/css/public/m.css" rel="stylesheet">

    <script src="resources/js/public/jquery.min.js"></script>
    <script src="resources/js/public/bootstrap.min.js"></script>
    <script src="resources/js/public/m.js"></script>
    <script src="resources/js/wec_0050.js"></script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" id="user-reg">
                <div class="input-group">
                    <span class="input-group-addon" for="kahao"><span class="red-text">* </span>卡号：</span>

                    <div class="input-group" id="kahao_group">
                        <input type="text" id="kahao" class="form-control" value="" placeholder="" aria-describedby="basic-addon1">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">选择 <span class="caret"></span></button>
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li><a href="#">13213213213213123</a></li>
                                <li><a href="#">79879879798797465</a></li>
                                <li><a href="#">65712331974156646</a></li>
                            </ul>
                        </div>
                    </div>


                </div>
                <div class="input-group">
                    <span class="input-group-addon" for="jiner"><span class="red-text">* </span>金额：</span>
                    <input type="text" id="jiner" class="form-control" aria-describedby="basic-addon1">
                    <span class="input-group-addon">元</span>
                </div>
                <div class="input-group choiceYhjC">
                    <button class="btn btn-info choiceYhj" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                        选择优惠券
                    </button>
                    <div class="collapse" id="collapseExample">
                        <div class="well">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="yhq"  value="1" checked>
                                    优惠券名称优惠券名称优惠券名称
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="yhq"  value="2">
                                    优惠券名称优惠券名称优惠券名称
                                </label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="yfje">
                    <div><span>应付金额：</span><strong>xxx</strong> 元</div>
                </div>
                <div class="input-group">
                    <span class="input-group-addon" for="bz"><span class="red-text">* </span>备注：</span>
                    <input type="text" id="bz" class="form-control" aria-describedby="basic-addon1">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" for="psd"><span class="red-text">* </span>密码：</span>
                    <input type="password" id="psd" class="form-control" aria-describedby="basic-addon1">
                </div>

                <div class="form-group">
                    <div class="col-sm-12 tijiao">
                        <button id="tijiao" type="button" class="btn btn-primary btn-lg">确认付款</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>