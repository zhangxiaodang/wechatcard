package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0036Model;
import cn.com.allinpay.wechatcard.view.WEC0036View;

/**
 * 获取充值记录Service.
 */
public interface IWEC0036Service {
	
	
	/**
	 * 获取充值记录service
	 * @param memberView
	 * @return
	 */
	public WEC0036Model get_recharge(WEC0036View wec0036View) throws Exception;
}
