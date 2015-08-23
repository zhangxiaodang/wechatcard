$(function () {
    $.post('wec0040/my_coupon',function(data) {
        if(data.state === '000000') {
            var coupon_list = data['coupon_list'] || [];
            var $quan = $("#quan");
            var quan_html = '';
            var quan_len = coupon_list.length;
            if(quan_len < 1){
            	$.mAlert( data['msg'] );
            	$quan.empty().append( data['msg'] );
            }
            if(quan_len) {
                for(var i = 0; i < quan_len; i++) {
                    quan_html += '<a href="#" class="list-group-item active" id="coupon_'+ coupon_list[i]['couponid'] +'">' +
                        '<div>' +
                        '<img src="'+ coupon_list[i]['couponimg'] +'" alt=""/>' +
                        '<h4 class="list-group-item-heading">'+ coupon_list[i]['couponname'] +'</h4>' +
                        '<p class="list-group-item-text" style="color:black;">'+ coupon_list[i]['starttime'] +'至'+ coupon_list[i]['endtime'] +'</p>' +
                        '</div>' +
                        '</a>';
                }

                $quan.empty().append( quan_html );
            }
            
            $("#quan [id^=coupon_]").click(function(){
            	var id = this.id.split("_")[1];
            	card_click(id);
            })
        } else {
            $.mAlert( data['msg'] );
        }
    },"json");
    
    function card_click(id){
    	window.location.href = 'wec0041?couponid='+id;
    }

});