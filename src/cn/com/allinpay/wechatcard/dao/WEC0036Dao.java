package cn.com.allinpay.wechatcard.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * 我的充值记录dao.
 * 
 * @version V1.00.
 * 
 */
public interface WEC0036Dao {

	/**
	 * 获取充值记录dao
	 * 
	 * @param paraMap
	 * @return
	 */
	public List<Map<String, Object>> get_recharge(Map<String, Object> paramMap);

}
