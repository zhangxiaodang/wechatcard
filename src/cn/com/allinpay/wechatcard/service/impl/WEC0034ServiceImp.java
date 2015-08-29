package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.WebUtil;
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
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BEAN, memberView);
		// 获取优惠券信息
		Map<String, Object> coupon_info = wec_0034_Dao.get_coupon(paramMap);
		// todo-zhangxd
		// 如果有空图片地址的话，给一个默认的图片地址。
		coupon_info = WebUtil.test_set_null_coupon_img_map(coupon_info);
		
		// 返回前台提示信息
		WEC0034Model resultModel = new WEC0034Model();
		
		resultModel.setCoupon_info(coupon_info);
		
		resultModel.setState(WebConstantValue.HTTP_OK);

		logger.info("========================Service get_coupon End==========================");
		return resultModel;
	}
}
