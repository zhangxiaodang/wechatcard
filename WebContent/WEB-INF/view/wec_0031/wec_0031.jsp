<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>会员卡详细</title>
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
    <script src="resources/js/public/qrcode.js"></script>
    <script src="resources/js/public/jquery-barcode-1.3.3.js"></script>
    
    <script src="resources/js/wec_0031.js"></script>
    <script type="text/javascript">
    	var cardno = "${membercard.card_info.cardno}";
    	var dzcardno = "${membercard.card_info.dzcardno}";
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">

            <header id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="${membercard.card_info.merbercardimg}" />
                        <div class="kh">NO.<span>${membercard.card_info.dzcardno}</span></div>
                    </div>
                </div>
                <div class="show2">
                    <img class="click2" src="resources/images/hand.png" />
                    <span>点击卡片展示二维码</span>
                </div>
                <div class="hy">
                    <div class="row">
                        <div class="col-xs-4 col-md-4">
                            <div><strong>会员等级</strong></div>
                            <div>微信会员卡</div>
                        </div>
                        <div class="col-xs-4 col-md-4">
                            <div><strong>储值</strong></div>
                            <div>${membercard.card_info.money}</div>
                        </div>
                        <div class="col-xs-4 col-md-4">
                            <div><strong>积分</strong></div>
                            <div>0.00</div>
                        </div>
                    </div>
                </div>
            </header>

        </div>
    </div>

    <div class="modal bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">


                <!--<div class="modal-header">-->
                    <!--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>-->
                    <!--<h4 class="modal-title" id="gridSystemModalLabel">将本页面展示给店员即可使用</h4>-->
                <!--</div>-->
                <div class="modal-body">
                    <div class="jumbotron">
                        <ul class="list-group" id="txm">
                            <li class="list-group-item">
                                <img src="../images/txm.png" alt=""/>
                            </li>
                            <li class="list-group-item">
                                99062547
                            </li>
                            <li class="list-group-item">
                                <img src="../images/ewm.jpg" />
                            </li>
                        </ul>
                    </div>
                </div>


            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <ul id="list" class="list-group">
                <li class="list-group-item" id="change_pass">
                    <img class="list-img-left" src="resources/images/carddetail/modifypassword.png" alt=""/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卡密码修改
                    <img class="list-img-right" src="resources/images/char-more.png" alt=""/>
                </li>
                <li class="list-group-item" id="chongzhi_pass">
                    <img class="list-img-left" src="resources/images/carddetail/memberAddValue.png" alt=""/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我要充值
                    <img class="list-img-right" src="resources/images/char-more.png" alt=""/>
                </li>
                <!-- <li class="list-group-item" id="mycoupon">
                    <img src="resources/images/char-more.png" alt=""/>
                    我的优惠券
                </li> -->
                <li class="list-group-item" id="recharge">
                    <img class="list-img-left" src="resources/images/carddetail/valueRecord.png" alt=""/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;充值记录
                    <img class="list-img-right" src="resources/images/char-more.png" alt=""/>
                </li>
                <li class="list-group-item" id="consume">
                    <img class="list-img-left" src="resources/images/carddetail/consume.png" alt=""/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;消费记录
                    <img class="list-img-right" src="resources/images/char-more.png" alt=""/>
                </li>
                <li class="list-group-item">
                    <img class="list-img-left" src="resources/images/carddetail/myCoupon.png" alt=""/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卡说明
                    <img class="list-img-right" src="resources/images/char-more.png" alt=""/>
                </li>
                <li class="list-group-item">
                	<img class="list-img-left" src="resources/images/carddetail/tel.png" alt=""/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="tel://400 800 920">服务电话：400 800 920</a>
                    <img class="list-img-right" src="resources/images/char-more.png" alt=""/>
                </li>
            </ul>

        </div>
    </div>
</div>

</body>
</html>