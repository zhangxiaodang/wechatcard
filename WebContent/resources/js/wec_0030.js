$(function () {

    $("#old_card_bind").on('click', function (evt) {
    	window.location.href = 'wec0022';
    });

    
    $.post('get_card_coupon',function(data) {
        if(data.state === '000000') {
            var card_list = data['card_list'] || [];
            var coupon_list = data['coupon_list'] || [];
            var $ka = $("#ka_list");
            var $quan = $("#quan");
            var ka_html = '';
            var quan_html = '';
            var ka_len = card_list.length;
            var quan_len = coupon_list.length;

            if(ka_len) {
                for(var i = 0; i < ka_len; i++) {
                    ka_html += '<a href="#" class="list-group-item1 active" id="card_'+ card_list[i]['merbercardid'] +'">' +
                        '<div>' +
                        '<img src="'+ card_list[i]['merbercardimg'] +'" alt=""/>' +
                        //'<h4 class="list-group-item-heading">No.'+ card_list[i]['dzcardno'] +'</h4>' +
                        '<h4 class="list-group-cardno">No.'+ card_list[i]['dzcardno'] +'</h4>' +
                        //'<p class="list-group-item-text">'+card_list[i]['cardname']+'</p>' +
                        '</div>' +
                        '<em><font color="#000000">会员储值卡，会员专享活动</font></em>' +
                    '</a>';
                }

                $ka.append( ka_html );
            }

            if(quan_len) {
                for(var i = 0; i < quan_len; i++) {
                    quan_html += '<a href="#" class="list-group-item active" id="coupon_'+ coupon_list[i]['couponid'] +'">' +
                        '<div>' +
                        '<img src="'+ coupon_list[i]['couponimg'] +'" alt=""/>' +
                        '<h4 class="list-group-item-heading">'+ coupon_list[i]['couponname'] +'</h4>' +
                        '<p class="list-group-item-text">'+ coupon_list[i]['starttime'] +'至'+ coupon_list[i]['endtime'] +'</p>' +
                        '</div>' +
                        '</a>';
                }

                $quan.empty().append( quan_html );
            }
            
            $("#ka [id^=card_]").click(function(){
            	var id = this.id.split("_")[1];
            	card_click(id);
            })
            $("#quan [id^=coupon_]").click(function(){
            	var id = this.id.split("_")[1];
            	coupon_click(id);
            })
        } else {
            $.mAlert( data['msg'] );
        }
    },"json");
    
    function card_click(id){
    	window.location.href = 'wec0031?membercardid='+id;
    }
    function coupon_click(id){
    	window.location.href = 'wec0034?couponid='+id;
    }
});