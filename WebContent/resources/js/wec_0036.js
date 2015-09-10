$(function () {

    // 清空列表
    //$('#list').empty();
    var pageNum = 0;

    function listPage() {
        $.post('wec0036/get_recharge?dzcardno='+dzcardno, {
        	page_num: pageNum,
            rows: 10
        }, function (data) {
            if(data.state == '000000') {
            	if(data.rows.length < 1){
            		$.mAlert( data['msg'] );
            	}
                $("#jzgd").text("加载更多").prop('disabled', false);
                //pageNum = data.page;
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
                    '<h4 class="list-group-item-heading">'+ dataList[i]['dzcardno'] +'</h4>'+
                    '<p class="list-group-item-text">充值时间：'+ dataList[i]['rechargesj'] +'</p>'+
                    '<p class="list-group-item-text">充值状态：'+ dataList[i]['rechargecode'] +'</p>'+
                    '<p class="list-group-item-text">充值金额：￥'+ dataList[i]['rechargenum'] +'</p>'+
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