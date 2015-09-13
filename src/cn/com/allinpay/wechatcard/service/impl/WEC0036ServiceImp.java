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
import cn.com.allinpay.wechatcard.dao.WEC0036Dao;
import cn.com.allinpay.wechatcard.model.WEC0036Model;
import cn.com.allinpay.wechatcard.service.IWEC0036Service;
import cn.com.allinpay.wechatcard.view.WEC0036View;

/**
 * 
 * 获获取充值记录serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0036ServiceImp extends BaseService implements IWEC0036Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0036ServiceImp.class);

	/** 优惠券详细dao **/
	@Autowired
	private WEC0036Dao wec_0036_Dao;

	/**
	 * 获取我的充值记录service
	 */
	@Override
	public WEC0036Model get_recharge(WEC0036View wec0036View) throws Exception {
		logger.info("========================Service get_recharge Start==========================");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// todo-zhangxd
		wec0036View.setDzcardno("18363017058");
		paramMap.put(BEAN, wec0036View);
		// 获取充值信息
		List<Map<String, Object>> consume_list = wec_0036_Dao.get_recharge(paramMap);
		// 如果图片为空的话设置默认图片
		WebUtil.test_set_null_card_img(consume_list);
		
		// 返回前台提示信息
		WEC0036Model resultModel = new WEC0036Model();
		
		resultModel.setRows(consume_list);
		resultModel.setState(WebConstantValue.HTTP_OK);
		if(consume_list.size() == 0){
			resultModel.setMsg(WebConstantValue.NULL_RECHARGE);
		}

		logger.info("========================Service get_recharge End==========================");
		return resultModel;
	}
}
