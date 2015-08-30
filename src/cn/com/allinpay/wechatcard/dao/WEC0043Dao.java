package cn.com.allinpay.wechatcard.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * 商家优惠券优惠券dao.
 * 
 * @version V1.00.
 * 
 */
public interface WEC0043Dao {

	/**
	 * 获取商家优惠券dao
	 * 
	 * @param paraMap
	 * @return
	 */
	public List<Map<String, Object>> get_merchantcoupon(Map<String, Object> paramMap);

}
