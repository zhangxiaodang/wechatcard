package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0043Model;
import cn.com.allinpay.wechatcard.view.WEC0043View;

/**
 * 未领取的优惠券Service.
 */
public interface IWEC0043Service {
	
	
	/**
	 * 查询未领取的优惠券service
	 * @param memberView
	 * @return
	 */
	public WEC0043Model get_merchantcoupon(WEC0043View wec0043View) throws Exception;
}
