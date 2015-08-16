package cn.com.allinpay.wechatcard.dao;

import java.util.Map;

/**
 * 
 * 会员卡详情dao.
 * 
 * @version V1.00.
 * 
 */
public interface WEC0031Dao {

	/**
	 * 获取会员卡信息dao
	 * 
	 * @param paraMap
	 * @return
	 */
	public Map<String, Object> get_card(Map<String, Object> paramMap);

}
