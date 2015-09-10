$(function () {

    // 清空列表
    //$('#list').empty();
    var pageNum = 0;

    function listPage() {
        $.post('wec0033/get_consume?dzcardno='+dzcardno, {
        	page_num: pageNum,
            rows: 10
        }, function (data) {
            if(data.state == '000000') {
            	if(data.rows.length < 1){
            		$.mAlert( data['msg'] );
            	}
                $("#jzgd").text("加载更多").prop('disabled', false);
                // pageNum = data.page;
                var dataList = data.rows;
                var a = '';
                if(!dataList.length) {
                    $("#jzgd").hide().prev().show();
                    return false;
                }
                for(var i = 0, len = dataList.length; i < len; i++) {
                    a += '<a href="#" class="list-group-item active">'+
                    '<div>' +
                    '<img src="'+ dataList[i]['merbercardimg'] +'" alt=""/>'+
                    '<h4 class="list-group-item-heading">'+ dataList[i]['consumenr'] +'</h4>'+
                    '<p class="list-group-item-text">消费时间：'+ dataList[i]['consumesj'] +'</p>'+
                    '<p class="list-group-item-text">消费门店：'+ dataList[i]['merchantaddr'] +'</p>'+
                    '<p class="list-group-item-text">消费金额：￥'+ dataList[i]['consumenum'] +'</p>'+
                    '</div>'+
                    '</a>';
                }
                $('#list').append( a );
            }else{
            	$.mAlert( data['msg'] );
            }
            pageNum += 1;
        },'json');
    }

    listPage();

    // 点击加载更多
    $("#jzgd").on('click', function (evt) {
        $("#jzgd").text("加载中...").prop('disabled', true);
        listPage();
    });
});