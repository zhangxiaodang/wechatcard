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
import cn.com.allinpay.wechatcard.dao.WEC0040Dao;
import cn.com.allinpay.wechatcard.model.WEC0040Model;
import cn.com.allinpay.wechatcard.service.IWEC0040Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 
 * 获取未领取的优惠券serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0040ServiceImp extends BaseService implements IWEC0040Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0040ServiceImp.class);

	/** 优惠券详细dao **/
	@Autowired
	private WEC0040Dao wec_0040_Dao;

	/**
	 * 获取未领取的优惠券service
	 */
	@Override
	public WEC0040Model get_coupon(WEC0010View memberView) throws Exception {
		logger.info("========================Service get_coupon Start==========================");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BEAN, memberView);
		// 获取优惠券信息
		List<Map<String, Object>> coupon_info = wec_0040_Dao.get_coupon(paramMap);
		// todo-zhangxd
		// 如果有空图片地址的话，给一个默认的图片地址。
		coupon_info = WebUtil.test_set_null_coupon_img(coupon_info);
		// 返回前台提示信息
		WEC0040Model resultModel = new WEC0040Model();
		
		resultModel.setCoupon_list(coupon_info);
		resultModel.setState(WebConstantValue.HTTP_OK);
		if(coupon_info.size() == 0){
			resultModel.setMsg(WebConstantValue.NULL_COUPON);
		}

		logger.info("========================Service get_coupon End==========================");
		return resultModel;
	}
}
