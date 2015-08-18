package cn.com.allinpay.wechatcard.dao;

import java.util.Map;

/**
 * 
 * 会员注册dao.
 * 
 * @version V1.00.
 * 
 */
public interface WEC0010Dao {

	/**
	 * 会员注册dao.
	 * 
	 * @param paraMap
	 *            参数.
	 * 
	 * @return 影响行数.
	 */
	public void regist(Map<String, Object> paramMap);
}
