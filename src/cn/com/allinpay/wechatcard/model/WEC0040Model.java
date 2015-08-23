package cn.com.allinpay.wechatcard.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.allinpay.frame.model.BaseModel;

/**
 * 
 * 会员卡包Model.
 * 
 * @version V1.00.
 * 
 */
public class WEC0040Model extends BaseModel{

	// 优惠券
	private List<Map<String, Object>> coupon_list = new ArrayList<Map<String, Object>>();

	public List<Map<String, Object>> getCoupon_list() {
		return coupon_list;
	}

	public void setCoupon_list(List<Map<String, Object>> coupon_list) {
		this.coupon_list = coupon_list;
	}
}
