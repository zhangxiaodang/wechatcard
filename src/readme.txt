上线之前要注意的事情：
1.将获取openID的代码放开
2.和通联  联调。
3.一级页面从commonservice中取。
5.二级页面从session取。
6.把测试使用的代码都删除掉。
7.common.xml中getMemberIDByOpenID使用了limit，这个是mysql的要换成oracle的方式
8.wec0030Mapper.xml中使用了格式化时间的
9.优惠券的二维码图片和卡的图片都是写死的。
10.将数据的字段都检查一遍。所有的字段必须是大写，要不然查询报错