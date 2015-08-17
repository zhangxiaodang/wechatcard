package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.view.WEC0020View;

/**
 * 
 * 会员卡注册service
 * 
 * @version V1.00.
 * 
 */
public interface IWEC0020Service {
	
	/**
	 * 注册的service
	 * @param memberView
	 * @return
	 */
	public int phone_is_rigist(WEC0020View memberView) throws Exception;
	
}
