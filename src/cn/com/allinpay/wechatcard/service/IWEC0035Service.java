package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.frame.model.BaseModel;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 会员卡修改密码Service.
 */
public interface IWEC0035Service {
	
	
	/**
	 * 会员卡修改密码service
	 * @param memberView
	 * @return
	 */
	public BaseModel change_pass(WEC0010View memberView) throws Exception;
}
