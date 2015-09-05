package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0032Model;
import cn.com.allinpay.wechatcard.view.WEC0032View;

/**
 * 我要充值Service.
 */
public interface IWEC0032Service {

	/**
	 * 修改手机号
	 * 
	 * @param memberView
	 *            参数.
	 * 
	 * @return 结果.
	 */
	public WEC0032Model chongzhi_ser(WEC0032View view) throws Exception;
}
