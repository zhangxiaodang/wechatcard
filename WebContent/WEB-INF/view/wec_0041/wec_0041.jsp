<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>优惠券领取</title>
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width">
    <link href="resources/css/public/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/wec_0041.css" rel="stylesheet">
    <link href="resources/css/public/m.css" rel="stylesheet">

    <script src="resources/js/public/jquery.min.js"></script>
    <script src="resources/js/public/bootstrap.min.js"></script>
    <script src="resources/js/public/m.js"></script>
    <script src="resources/js/wec_0041.js"></script>
    <script type="text/javascript">
    	var couponid = "${coupon.coupon_info.couponid}";
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="${coupon.coupon_info.couponimg}" />
                    </div>
                </div>
            </div>

            <h1>${coupon.coupon_info.couponname}</h1>
            <p>${coupon.coupon_info.bz}</p>
            <p>有限期：${coupon.coupon_info.starttime}至${coupon.coupon_info.endtime}</p>
            <p>适用门店：全国各门店</p>

            <div class="form-group">
                <div class="col-sm-12 tijiao">
                    <button id="tijiao" type="button" class="btn btn-primary btn-lg">领取</button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>