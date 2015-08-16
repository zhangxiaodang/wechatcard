package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0031Model;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 会员卡信息Service.
 */
public interface IWEC0031Service {
	
	
	/**
	 * 会员卡信息service
	 * @param memberView
	 * @return
	 */
	public WEC0031Model get_card_info(WEC0010View memberView) throws Exception;
}
