<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的卡包</title>
    <meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1; user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-touch-fullscreen" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width">
    <link href="resources/css/public/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/wec_0030.css" rel="stylesheet">
    <link href="resources/css/public/m.css" rel="stylesheet">

    <script src="resources/js/public/jquery.min.js"></script>
    <script src="resources/js/public/bootstrap.min.js"></script>
    <script src="resources/js/public/m.js"></script>
    <script src="resources/js/wec_0030.js"></script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">

            <div id="my-card">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#ka" aria-controls="ka" role="tab" data-toggle="tab">卡</a></li>
                    <li role="presentation"><a href="#quan" aria-controls="quan" role="tab" data-toggle="tab">券</a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="ka">
                        <div class="form-group">
                            <div class="col-sm-12 old_card_bind">
                                <button id="old_card_bind" type="button" class="btn btn-primary btn-lg">绑定旧卡</button>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="quan">
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>