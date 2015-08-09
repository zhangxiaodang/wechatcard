package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 
 * 注册service
 * 
 * @version V1.00.
 * 
 */
public interface IWEC0010Service {
	
	/**
	 * 注册的service
	 * @param memberView
	 * @return
	 */
	public WEC0010Model regist(WEC0010View memberView) throws Exception;
	
	/**
	 * 获取验证码service
	 * @param memberView
	 * @return
	 */
	public WEC0010Model getYzm(WEC0010View memberView) throws Exception;
}
