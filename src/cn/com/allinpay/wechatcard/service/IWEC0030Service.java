package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0030Model;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 我的卡包Service.
 */
public interface IWEC0030Service {
	
	
	/**
	 * 查询会员卡包和优惠券的信息service
	 * @param memberView
	 * @return
	 */
	public WEC0030Model get_card_coupon(WEC0010View memberView) throws Exception;
}
