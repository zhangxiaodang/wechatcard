<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>优惠券详情</title>
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width">
    <link href="resources/css/public/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/wec_0034.css" rel="stylesheet">
    <link href="resources/css/public/m.css" rel="stylesheet">

    <script src="resources/js/public/jquery.min.js"></script>
    <script src="resources/js/public/bootstrap.min.js"></script>
    <script src="resources/js/public/m.js"></script>
    <script src="resources/js/public/qrcode.js"></script>
    <script src="resources/js/wec_0034.js"></script>
    <script type="text/javascript">
    	var couponid = "${coupon.coupon_info.couponid}";
    	var coupno = "${coupon.coupon_info.merchantcouponid}";
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
        	<!--
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
             -->

            <div class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                    	<!-- 
                        <img src="${coupon.coupon_info.couponcode}" />
                         -->
                        <div align="center" id="qrcode" style="margin-top: 10px;"></div>
                    </div>
                    <h2>券号：${coupon.coupon_info.merchantcouponid}</h2>
                    <!--
                    <h3>将本页面展示给店员即可使用</h3>
                    -->
                </div>
            </div>

            <h1>${coupon.coupon_info.couponname}</h1>
            <p>有限期：${coupon.coupon_info.starttime}至${coupon.coupon_info.endtime}</p>
            <p>${coupon.coupon_info.couponcontent}</p>
        </div>
    </div>
</div>

</body>
</html>