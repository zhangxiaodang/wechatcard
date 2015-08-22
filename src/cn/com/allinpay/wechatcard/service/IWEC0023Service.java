package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.frame.model.BaseModel;
import cn.com.allinpay.wechatcard.view.WEC0023View;

/**
 * 重新绑定Service.
 */
public interface IWEC0023Service {
	
	
	/**
	 * 重新绑定service
	 * @param memberView
	 * @return
	 */
	public BaseModel change_openid(WEC0023View wec0023View) throws Exception;
}
