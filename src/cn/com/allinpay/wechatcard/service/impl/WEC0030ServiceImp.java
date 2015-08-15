package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.dao.WEC0030Dao;
import cn.com.allinpay.wechatcard.model.WEC0030Model;
import cn.com.allinpay.wechatcard.service.IWEC0030Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;
import cn.com.allinpay.wechatcard.view.WEC0021View;

/**
 * 
 * 获取会员的卡和优惠券信息serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0030ServiceImp extends BaseService implements IWEC0030Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0030ServiceImp.class);

	/** 注册的dao **/
	@Autowired
	private WEC0030Dao wec_0030_Dao;

	/**
	 * 注册的service
	 */
	@Override
	public WEC0030Model get_card_coupon(WEC0010View memberView) throws Exception {
		logger.info("========================Service get_card_voucher Start==========================");
		memberView.setMemberid("0612db1f7f744b1ba11cf9b136381e29");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BEAN, memberView);
		// 获取会员卡信息
		Map<String, Object> card_list = wec_0030_Dao.get_card(paramMap);
		
		// 获取会员的优惠券信息
		//List<CouponView> coupons_list = wec_0030_Dao.get_coupon(paramMap);
		
		// 返回前台提示信息
		WEC0030Model resultModel = new WEC0030Model();
		
		resultModel.setCard_list(card_list);
		//resultModel.setCoupon_list(coupons_list);
		
		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.APPLY_CARD_SUCCESS);

		logger.info("========================Service get_card_voucher End==========================");
		return resultModel;
	}
}
