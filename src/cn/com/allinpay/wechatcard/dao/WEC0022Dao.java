package cn.com.allinpay.wechatcard.dao;

import java.util.Map;

/**
 * 
 * 绑定旧卡dao.
 * 
 * @version V1.00.
 * 
 */
public interface WEC0022Dao {

	/**
	 * 绑定旧卡dao
	 * 
	 * @param paraMap
	 * @return
	 */
	public void binding_card(Map<String, Object> paramMap);

	public int getCardNoCnt(Map<String, String> paramMap);
}
