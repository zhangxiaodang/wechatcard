package cn.com.allinpay.wechatcard.dao;

import java.util.Map;

/**
 * 共通Service.
 */

public interface CommonDao {

	public Map<String, String> getAppInfo(String urlFlag);

	public int getRegister(Map<String, String> paramMap);
}
