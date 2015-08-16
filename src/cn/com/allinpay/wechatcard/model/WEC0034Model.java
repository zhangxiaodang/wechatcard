package cn.com.allinpay.wechatcard.model;

import java.util.HashMap;
import java.util.Map;

import cn.com.allinpay.frame.model.BaseModel;

/**
 * 
 * 优惠券信息信息Model.
 * 
 * @version V1.00.
 * 
 */
public class WEC0034Model extends BaseModel{
	
	// 优惠券信息
	private Map<String, Object> coupon_list = new HashMap<String, Object>();

	public Map<String, Object> getCoupon_list() {
		return coupon_list;
	}

	public void setCoupon_list(Map<String, Object> coupon_list) {
		this.coupon_list = coupon_list;
	}
}
