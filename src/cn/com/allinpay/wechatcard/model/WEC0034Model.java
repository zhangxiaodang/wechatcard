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
	
	// 优惠券id
	private String coupon_id = "";
	
	// 优惠券信息
	private Map<String, Object> coupon_info = new HashMap<String, Object>();

	public Map<String, Object> getCoupon_info() {
		return coupon_info;
	}

	public void setCoupon_info(Map<String, Object> coupon_info) {
		this.coupon_info = coupon_info;
	}

	public String getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}
}
