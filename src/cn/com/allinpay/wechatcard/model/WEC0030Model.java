package cn.com.allinpay.wechatcard.model;

import java.util.HashMap;
import java.util.Map;

import cn.com.allinpay.frame.model.BaseModel;
import cn.com.allinpay.wechatcard.view.CouponView;

/**
 * 
 * 会员卡包Model.
 * 
 * @version V1.00.
 * 
 */
public class WEC0030Model extends BaseModel{
	// 会员卡
	private Map<String, Object> card_list = new HashMap<String, Object>();
	
	// 优惠券
	private CouponView coupon_list = new CouponView();

	public Map<String, Object> getCard_list() {
		return card_list;
	}

	public void setCard_list(Map<String, Object> card_list) {
		this.card_list = card_list;
	}

	public CouponView getCoupon_list() {
		return coupon_list;
	}

	public void setCoupon_list(CouponView coupon_list) {
		this.coupon_list = coupon_list;
	}

	
}
