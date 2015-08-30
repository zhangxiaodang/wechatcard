package cn.com.allinpay.wechatcard.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.allinpay.frame.model.BaseModel;

/**
 * 
 * 商家优惠券Model.
 * 
 * @version V1.00.
 * 
 */
public class WEC0043Model extends BaseModel{

	// 优惠券
	private List<Map<String, Object>> merchantcoupon_list = new ArrayList<Map<String, Object>>();

	public List<Map<String, Object>> getMerchantcoupon_list() {
		return merchantcoupon_list;
	}

	public void setMerchantcoupon_list(List<Map<String, Object>> merchantcoupon_list) {
		this.merchantcoupon_list = merchantcoupon_list;
	}
}
