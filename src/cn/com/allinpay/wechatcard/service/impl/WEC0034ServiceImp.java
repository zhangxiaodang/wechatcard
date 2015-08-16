package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.dao.WEC0034Dao;
import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.service.IWEC0034Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 
 * 会员卡信息serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0034ServiceImp extends BaseService implements IWEC0034Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0034ServiceImp.class);

	/** 优惠券详细dao **/
	@Autowired
	private WEC0034Dao wec_0034_Dao;

	/**
	 * 优惠券的service
	 */
	@Override
	public WEC0034Model get_coupon(WEC0010View memberView) throws Exception {
		logger.info("========================Service get_coupon Start==========================");
		memberView.setMemberid("0612db1f7f744b1ba11cf9b136381e29");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BEAN, memberView);
		// 获取优惠券信息
		Map<String, Object> card_list = wec_0034_Dao.get_coupon(paramMap);
		
		// 返回前台提示信息
		WEC0034Model resultModel = new WEC0034Model();
		
		resultModel.setCoupon_list(card_list);
		
		resultModel.setState(WebConstantValue.HTTP_OK);

		logger.info("========================Service get_coupon End==========================");
		return resultModel;
	}
}
