package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0033Model;
import cn.com.allinpay.wechatcard.view.WEC0033View;

/**
 * 获取消费记录Service.
 */
public interface IWEC0033Service {
	
	
	/**
	 * 获取消费记录service
	 * @param memberView
	 * @return
	 */
	public WEC0033Model get_consume(WEC0033View wec0030View) throws Exception;
}
