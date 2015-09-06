package cn.com.allinpay.wechatcard.dao;

import java.util.Map;

/**
 * 共通Service.
 */

public interface CommonDao {

	public Map<String, String> getAppInfo(String urlFlag);

	public int getRegister(Map<String, String> paramMap);
	
	public Map<String, String> getMemberIDByOpenID(Map<String, String> paramMap);
	
	public Map<String, String> getMerchantInfoByUrlFlag(String urlflag);
	
	public Map<String, String> getParametersByMerchantid(String merchantid);
	
	public String getOrderIdByDual(String id);
}
