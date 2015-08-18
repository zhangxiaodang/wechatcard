package cn.com.allinpay.wechatcard.dao;

import java.util.Map;

/**
 * 修改手机号dao.
 */

public interface WEC0060Dao {

	/**
	 * 取得会员现有手机号.
	 * 
	 * @param paramMap
	 *            参数.
	 * 
	 * @return 手机号
	 */
	public String getCurrentPhoneNum(Map<String, String> paramMap);

	/**
	 * 修改手机号dao
	 * 
	 * @param paraMap
	 *            参数.
	 * 
	 * @return
	 */
	public int updatePhoneNum(Map<String, String> paramMap);
}
