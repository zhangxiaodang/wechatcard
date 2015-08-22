package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0031Model;

/**
 * 会员卡信息Service.
 */
public interface IWEC0031Service {
	
	
	/**
	 * 会员卡信息service
	 * @param memberView
	 * @return
	 */
	public WEC0031Model get_card_info(String membercardid) throws Exception;
}
