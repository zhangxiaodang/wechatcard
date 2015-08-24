package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.dao.WEC0041Dao;
import cn.com.allinpay.wechatcard.dao.WEC0042Dao;
import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.service.IWEC0042Service;
import cn.com.allinpay.wechatcard.view.WEC0041View;

/**
 * 
 * 优惠券领取完毕serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0042ServiceImp extends BaseService implements IWEC0042Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0042ServiceImp.class);

	/** 优惠券领取完毕dao **/
	@Autowired
	private WEC0042Dao wec_0042_Dao;

	/**
	 * 优惠券的service
	 */
	@Override
	public WEC0034Model get_coupon(WEC0041View wec0041View) throws Exception {
		logger.info("========================Service get_coupon Start==========================");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BEAN, wec0041View);
		// 获取优惠券信息
		Map<String, Object> coupon_info = wec_0042_Dao.get_coupon(paramMap);
		
		// 返回前台提示信息
		WEC0034Model resultModel = new WEC0034Model();
		
		resultModel.setCoupon_info(coupon_info);
		resultModel.setState(WebConstantValue.HTTP_OK);

		logger.info("========================Service get_coupon End==========================");
		return resultModel;
	}
	
}
