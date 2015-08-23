package cn.com.allinpay.wechatcard.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * 未领取的优惠券dao.
 * 
 * @version V1.00.
 * 
 */
public interface WEC0040Dao {

	/**
	 * 获取未领取的优惠券dao
	 * 
	 * @param paraMap
	 * @return
	 */
	public List<Map<String, Object>> get_coupon(Map<String, Object> paramMap);

}
