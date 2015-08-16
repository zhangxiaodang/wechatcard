package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.dao.WEC0031Dao;
import cn.com.allinpay.wechatcard.model.WEC0031Model;
import cn.com.allinpay.wechatcard.service.IWEC0031Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 
 * 会员卡信息serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0031ServiceImp extends BaseService implements IWEC0031Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0031ServiceImp.class);

	/** 注册的dao **/
	@Autowired
	private WEC0031Dao wec_0031_Dao;

	/**
	 * 注册的service
	 */
	@Override
	public WEC0031Model get_card_info(WEC0010View memberView) throws Exception {
		logger.info("========================Service get_card_info Start==========================");
		memberView.setMemberid("0612db1f7f744b1ba11cf9b136381e29");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BEAN, memberView);
		// 获取会员卡信息
		Map<String, Object> card_list = wec_0031_Dao.get_card(paramMap);
		
		// 返回前台提示信息
		WEC0031Model resultModel = new WEC0031Model();
		
		resultModel.setCard_list(card_list);
		
		resultModel.setState(WebConstantValue.HTTP_OK);

		logger.info("========================Service get_card_info End==========================");
		return resultModel;
	}
}
