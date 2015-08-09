!(function ( $ ) {

    $.extend(String.prototype,{
        'isPhone': function() {return Regular.call(this,/^(?:(?:1(?:3[4-9]|5[012789]|8[78])\d{8}|1(?:3[0-2]|5[56]|8[56])\d{8}|18[0-9]\d{8}|1[35]3\d{8})|14[57]\d{8}|170[059]\d{7}|17[678]\d{8})$/);},
        'isMail': function() {return Regular.call(this,/^([_a-zA-Z\d\-\.])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/);},
        'isPassword': function() {return Regular.call(this,/^[a-zA-Z0-9_-]{6,18}$/);},
        'isName': function() {return Regular.call(this,/^[a-z0-9_-]{6,18}$/);},
        'isMoney': function() {return Regular.call(this,/^[1-9]\d*$/);},
        'isNull': function() {return $.trim(this) == "" ? false : true;},
        'isShengRi': function() {return Regular.call(this, /\d{4}-\d{2}-\d{2}/)}
    });
    function Regular(z){return (new RegExp(z).test(this));}

    $.fn.extend({
        "dxlLayerFixedShow":function(position){
            var _this = $(this);
            var _position = position;
            $(window).on("resize.dxlsc",function(){_this._dxlLayerFixedShow(_position);}).resize();
        },
        "_dxlLayerFixedShow":function(position){
            var _this = $(this);
            var def = {
                w:$(window).width()/2,
                h:($(window).height()/2) - 40,
                obj_w:_this.width()/2,
                obj_h:_this.height()/2,
                top:"auto",
                left:"auto",
                right:"auto",
                bottom:"auto"
            }
            if(_this.parent().css("position") == "relative"){
                var _thisRelative = _this.parent();

                    def.w = _thisRelative.offset().left + (_thisRelative.width()/2);
            }
            _this.css("position","fixed");
            def.top = def.h - def.obj_h;
            def.top <= 0 ? def.top = 0 : "";
            def.left = def.w - def.obj_w;
            switch(position){
                case "top":def.top = 0;break
                case "left":def.left = 0;break
                case "right":def.left = "auto";def.right = 0;break
                case "bottom":def.top = "auto";def.bottom = 0;break
            }
            _this.css({"left":def.left,"top":def.top,"right":def.right,"bottom":def.bottom});
            return _this;
        },
        "dxlLayerFixedHide":function(){
            var _this = $(this);
            _this.css("position","static");
            $(window).off("resize.dxlsc");
        },
        "dxlCountdown":function(p){
            var _this = $(this);
            var _jsObj = "";
            var _jsNum = 60;
            var par = {
                djsObj:_this,				//显示对象
                djsNum:_jsNum,				//读秒
                firstText:"",
                sendText:"重新发送验证码",
                waitText:"秒后重新发送",
                classText:"cur",
                mobile:"dxlPhone",
                sendError:"dxlPhone",				//手机号验证失败
                sendAction:""				//发送验证码回调
            }
            par = $.extend(par,p);
            _this.on("click",thisClick);
            par.firstText == "" ? thisClick() : par.djsObj.text(par.firstText);
            function thisClick(){

                if(par.mobile != "dxlPhone" && !par.mobile.val().isPhone()){
                    par.djsObj.text(par.sendText);
                    $.isFunction(par.sendError) ? par.sendError() : "";
                    return false;
                }
                _this.off("click");
                par.djsObj.text(par.djsNum + par.waitText);
                _this.addClass(par.classText);
                $.isFunction(par.sendAction) ? par.sendAction() : "";
                _jsObj = window.setInterval(function(){
                    par.djsNum--;
                    if(par.djsNum >= 0){
                        par.djsObj.text(par.djsNum + par.waitText);
                    }else{
                        par.djsNum = _jsNum;
                        par.djsObj.text(par.sendText);
                        clearInterval(_jsObj);
                        _this.on("click",thisClick);
                        _this.removeClass(par.classText);
                    }
                },1000)
            }
        },
        "touchClick":function(select,callback){   //移动端 点击事件
            var se = (select != "" && !$.isFunction(select)) ? select : "";
            var cb = $.isFunction(select) ? select : callback;
            $(this).each(function(index, element) {
                var tc = false;
                $(this).on({
                    "touchstart":function(){tc = true;},
                    "touchmove":function(){tc = false;},
                    "touchend":function(event){
                        event.index = index;
                        tc ? $.isFunction(cb) ? cb.call(element, event) : "" : "";
                    }
                },se);
            });
        }
    });

    $.extend({
        //模拟原生alert提示  自动关闭
        "mAlert":function(msg,callback){
            if($("#mAlert").size() == 0){   //避免重复添加
                var str = '<div id="mAlert"><div class="mAlertBox">' +
                    '<div class="alertContent"></div>' +
                    '</div></div>';
                $("body").append(str);
            }
            var myDialog = $("#mAlert");

            myDialog.find(".alertContent").text( msg );
            myDialog.dxlLayerFixedShow();

            setTimeout(toCloseAlert,1800);  //自动关闭

            function toCloseAlert(){//关闭弹出层
                myDialog.fadeOut(800,function(){
                    myDialog.remove();
                });
                $.isFunction(callback) ? callback() : "";
            }
        },
        "dxlSmsSend":function(par,callback){
            var json = {
                "mobile": ""
            };
            json = $.extend(json,par);
            $.post("http://localhost:8080/wechatcard/register", json,function(data){
                $.isFunction(callback) ? callback( data ) : "";
            });
        }
    });

})( jQuery );