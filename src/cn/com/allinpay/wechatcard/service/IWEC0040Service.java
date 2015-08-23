package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0040Model;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 未领取的优惠券Service.
 */
public interface IWEC0040Service {
	
	
	/**
	 * 查询未领取的优惠券service
	 * @param memberView
	 * @return
	 */
	public WEC0040Model get_coupon(WEC0010View memberView) throws Exception;
}
