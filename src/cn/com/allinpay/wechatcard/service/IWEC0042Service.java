package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.view.WEC0041View;

/**
 * 优惠券信息Service.
 */
public interface IWEC0042Service {
	
	
	/**
	 * 优惠券信息service
	 * @param memberView
	 * @return
	 */
	public WEC0034Model get_coupon(WEC0041View wec0041View) throws Exception;
	
}
