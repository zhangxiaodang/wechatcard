package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.WebUtil;
import cn.com.allinpay.wechatcard.dao.WEC0033Dao;
import cn.com.allinpay.wechatcard.model.WEC0033Model;
import cn.com.allinpay.wechatcard.service.IWEC0033Service;
import cn.com.allinpay.wechatcard.view.WEC0033View;

/**
 * 
 * 获获取消费记录serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0033ServiceImp extends BaseService implements IWEC0033Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0033ServiceImp.class);

	/** 优惠券详细dao **/
	@Autowired
	private WEC0033Dao wec_0033_Dao;

	/**
	 * 获取我的消费记录service
	 */
	@Override
	public WEC0033Model get_consume(WEC0033View wec0033View) throws Exception {
		logger.info("========================Service get_coupon Start==========================");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// todo-zhangxd
		wec0033View.setDzcardno("18363017058");
		paramMap.put(BEAN, wec0033View);
		// 获取优惠券信息
		List<Map<String, Object>> consume_list = wec_0033_Dao.get_consume(paramMap);
		// 如果图片为空的话设置默认图片
		WebUtil.test_set_null_card_img(consume_list);
		
		// 返回前台提示信息
		WEC0033Model resultModel = new WEC0033Model();
		
		resultModel.setRows(consume_list);
		resultModel.setState(WebConstantValue.HTTP_OK);
		if(consume_list.size() == 0){
			resultModel.setMsg(WebConstantValue.NULL_CONSUME);
		}

		logger.info("========================Service get_coupon End==========================");
		return resultModel;
	}
}
