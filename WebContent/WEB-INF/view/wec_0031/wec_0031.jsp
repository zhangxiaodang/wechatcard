<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>林清轩会员卡储值卡</title>
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <link href="resources/css/public/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/wec_0031.css" rel="stylesheet">
    <link href="resources/css/public/m.css" rel="stylesheet">

    <script src="resources/js/public/jquery.min.js"></script>
    <script src="resources/js/public/bootstrap.min.js"></script>
    <script src="resources/js/public/m.js"></script>
    <script src="resources/js/wec_0031.js"></script>
    <script type="text/javascript">
    	var membercard = ${membercard};
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">

            <header class="jumbotron">
                <img src="resources/images/u5_normal.jpg" alt=""/>
                <h1>798.41</h1>
                <p >卡号： ${membercard.card_info.dzcardno}</p>
            </header>

        </div>
    </div>

    <div class="row">
        <div class="col-md-12">

            <div id="txm" class="panel panel-default">
                <div class="panel-body">
                    <img src="resources/images/txm.png" alt=""/>
                    <p>使用时向店员展示</p>
                </div>
            </div>

        </div>
    </div>

    <div class="row">
        <div class="col-md-12">

            <ul id="list" class="list-group">
                <li class="list-group-item" id="change_pass">
                    <img src="resources/images/char-more.png" alt=""/>
                    卡密码修改
                </li>
                <li class="list-group-item">
                    <img src="resources/images/char-more.png" alt=""/>
                    我要充值
                </li>
                <li class="list-group-item">
                    <img src="resources/images/char-more.png" alt=""/>
                    充值记录
                </li>
                <li class="list-group-item">
                    <img src="resources/images/char-more.png" alt=""/>
                    消费记录
                </li>
                <li class="list-group-item">
                    <img src="resources/images/char-more.png" alt=""/>
                    卡说明
                </li>
                <li class="list-group-item">
                    <img src="resources/images/char-more.png" alt=""/>
                    使用门店
                </li>
                <li class="list-group-item">
                    <img src="resources/images/char-more.png" alt=""/>
                    我要销卡
                </li>
                <li class="list-group-item">
                    服务电话：400 800 920
                </li>
            </ul>

        </div>
    </div>
</div>

</body>
</html>