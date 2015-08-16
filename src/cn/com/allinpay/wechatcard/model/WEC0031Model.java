package cn.com.allinpay.wechatcard.model;

import java.util.HashMap;
import java.util.Map;

import cn.com.allinpay.frame.model.BaseModel;

/**
 * 
 * 会员卡信息Model.
 * 
 * @version V1.00.
 * 
 */
public class WEC0031Model extends BaseModel{
	
	// 会员卡
	private Map<String, Object> card_info = new HashMap<String, Object>();

	public Map<String, Object> getCard_info() {
		return card_info;
	}

	public void setCard_info(Map<String, Object> card_info) {
		this.card_info = card_info;
	}
	
}
