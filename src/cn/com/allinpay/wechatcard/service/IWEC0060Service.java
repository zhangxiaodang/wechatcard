package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.frame.model.BaseModel;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 修改手机号Service.
 */
public interface IWEC0060Service {
	
	
	/**
	 * 修改手机号service
	 * @param memberView
	 * @return
	 */
	public BaseModel change_phone(WEC0010View memberView) throws Exception;
}
