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
	
	/**
	 * 判断手机号再商户下是否注册过
	 * 
	 * @param paraMap
	 *            参数.
	 * 
	 * @return 注册个数.
	 */
	public int phone_is_regist(Map<String, Object> paramMap);
}
