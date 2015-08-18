package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.frame.model.BaseModel;
import cn.com.allinpay.wechatcard.view.WEC0060View;

/**
 * 修改手机号Service.
 */
public interface IWEC0060Service {

	/**
	 * 取得会员现有手机号.
	 * 
	 * @param merchantflag
	 *            商户URL Flag.
	 * 
	 * @param opendid
	 *            会员Openid.
	 * 
	 * @return 手机号.
	 */
	public String getCurrentPhonum(String merchantflag, String opendid);

	/**
	 * 修改手机号
	 * 
	 * @param memberView
	 *            参数.
	 * 
	 * @return 结果.
	 */
	public BaseModel change_phone(WEC0060View view) throws Exception;
}
