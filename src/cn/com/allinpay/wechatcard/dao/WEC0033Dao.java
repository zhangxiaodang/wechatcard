package cn.com.allinpay.wechatcard.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * 我的消费记录dao.
 * 
 * @version V1.00.
 * 
 */
public interface WEC0033Dao {

	/**
	 * 获取消费记录dao
	 * 
	 * @param paraMap
	 * @return
	 */
	public List<Map<String, Object>> get_consume(Map<String, Object> paramMap);

}
