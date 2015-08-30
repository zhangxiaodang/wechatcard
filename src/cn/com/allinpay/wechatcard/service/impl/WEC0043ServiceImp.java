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
import cn.com.allinpay.wechatcard.dao.WEC0030Dao;
import cn.com.allinpay.wechatcard.dao.WEC0043Dao;
import cn.com.allinpay.wechatcard.model.WEC0043Model;
import cn.com.allinpay.wechatcard.service.IWEC0043Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;
import cn.com.allinpay.wechatcard.view.WEC0043View;

/**
 * 
 * 获取商家的优惠券serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0043ServiceImp extends BaseService implements IWEC0043Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0043ServiceImp.class);

	/** 优惠券详细dao **/
	@Autowired
	private WEC0043Dao wec_0043_Dao;
	
	@Autowired
	private WEC0030Dao wec_0030_Dao;
	/**
	 * 获取未领取的优惠券service
	 */
	@Override
	public WEC0043Model get_merchantcoupon(WEC0043View wec0043View) throws Exception {
		logger.info("========================Service get_merchantcoupon Start==========================");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 获取用户已有的优惠券
		Map<String, Object> user_coupon_param = new HashMap<String, Object>();
		WEC0010View memberView = new WEC0010View();
		memberView.setUrlflag(wec0043View.getUrlflag());
		memberView.setOpenid(wec0043View.getOpenid());
		user_coupon_param.put(BEAN, memberView);
		paramMap.put(BEAN, wec0043View);
		// 获取优惠券信息
		List<Map<String, Object>> coupon_info = wec_0043_Dao.get_merchantcoupon(paramMap);
		// 获取用户已经有的优惠券
		List<Map<String, Object>> user_coupon = wec_0030_Dao.get_coupon(user_coupon_param);
		
		// 循环商家的优惠券，来标识出哪些别用户领取了。
		for(int i = 0; i < coupon_info.size(); i++){
			coupon_info.get(i).put("ly_zt","未领用");
			for(int j = 0; j < user_coupon.size(); j++){
				if(coupon_info.get(i).get("merchantcouponid").equals(user_coupon.get(j).get("merchantcouponid"))){
					coupon_info.get(i).put("ly_zt","已领用");
				}
			}
		}
		// todo-zhangxd
		// 如果有空图片地址的话，给一个默认的图片地址。
		coupon_info = WebUtil.test_set_null_coupon_img(coupon_info);
		// 返回前台提示信息
		WEC0043Model resultModel = new WEC0043Model();
		
		resultModel.setMerchantcoupon_list(coupon_info);
		resultModel.setState(WebConstantValue.HTTP_OK);
		if(coupon_info.size() == 0){
			resultModel.setMsg(WebConstantValue.NULL_MERCHANTCOUPON);
		}

		logger.info("========================Service get_merchantcoupon End==========================");
		return resultModel;
	}
}
