package cn.com.allinpay.wechatcard.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * 我的卡包dao.
 * 
 * @version V1.00.
 * 
 */
public interface WEC0030Dao {

	/**
	 * 获取会员卡信息dao
	 * 
	 * @param paraMap
	 * @return
	 */
	public List<Map<String, Object>> get_card(Map<String, Object> paramMap);
	
	/**
	 * 获取会员优惠券信息dao
	 * 
	 * @param paraMap
	 * @return
	 */
	public List<Map<String, Object>> get_coupon(Map<String, Object> paramMap);

}
