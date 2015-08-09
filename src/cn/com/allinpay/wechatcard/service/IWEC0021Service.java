package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 
 * 申请新卡service
 * 
 * 
 * @version V1.00.
 */
public interface IWEC0021Service {
	
	/**
	 * 申请新卡service
	 * @param memberView
	 * @return
	 */
	public WEC0010Model applyNewCard(WEC0010View memberView) throws Exception;
}
