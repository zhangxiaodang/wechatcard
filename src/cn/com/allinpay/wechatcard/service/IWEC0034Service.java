package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 优惠券信息Service.
 */
public interface IWEC0034Service {
	
	
	/**
	 * 优惠券信息service
	 * @param memberView
	 * @return
	 */
	public WEC0034Model get_coupon(WEC0010View memberView) throws Exception;
}
