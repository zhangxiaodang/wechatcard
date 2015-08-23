package cn.com.allinpay.wechatcard.dao;

import java.util.Map;

/**
 * 
 * 优惠券领取dao.
 * 
 * @version V1.00.
 * 
 */
public interface WEC0041Dao {

	/**
	 * 获取优惠券信息dao
	 * 
	 * @param paraMap
	 * @return
	 */
	public Map<String, Object> get_coupon(Map<String, Object> paramMap);
	
	/**
	 * 优惠券领取dao
	 * 
	 * @param paraMap
	 * @return
	 */
	public void collect_coupon(Map<String, Object> paramMap);

}
