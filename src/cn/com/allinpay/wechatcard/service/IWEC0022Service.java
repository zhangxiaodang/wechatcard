package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.frame.model.BaseModel;
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
	public BaseModel bindingOldCard(WEC0010View memberView) throws Exception;
}
