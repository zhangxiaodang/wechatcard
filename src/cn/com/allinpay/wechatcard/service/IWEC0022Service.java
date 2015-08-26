package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 绑定旧卡Service.
 */
public interface IWEC0022Service {
	
	
	/**
	 * 绑定旧卡service
	 * @param memberView
	 * @return
	 */
	public WEC0010Model bindingOldCard(WEC0010View memberView) throws Exception;
}
