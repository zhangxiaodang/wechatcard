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
	 * 获取手机号对应的实体卡号
	 * 
	 * @param paramMap
	 * @return
	 */
	public String getCardnoFromDzcardno(Map<String, String> paramMap);

	/**
	 * 修改手机号dao
	 * 
	 * @param paraMap
	 *            参数.
	 * 
	 * @return
	 */
	public int updatePhoneNum(Map<String, String> paramMap);

	/**
	 * 更换手机号 电子卡号替换 成新手机号
	 * 
	 * @param paramMap
	 * @return
	 */
	public int updateDzcardno(Map<String, String> paramMap);
}
