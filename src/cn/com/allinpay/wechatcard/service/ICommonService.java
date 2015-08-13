package cn.com.allinpay.wechatcard.service;

/**
 * 共通Service.
 */

public interface ICommonService {

	/**
	 * 取得用户OpenID.
	 * 
	 * @param urlFlag
	 *            商户标识.
	 * 
	 * @param code
	 *            网页code.
	 * 
	 * @return openid.
	 */
	public String getOpenID(String urlFlag, String code);

	/**
	 * 判断微信用户是否注册.
	 * 
	 * @param urlFlag
	 *            商户标识.
	 * 
	 * @param openid
	 *            微信用户openid.
	 * @return true:已注册 false:未注册
	 */
	public boolean isRegister(String urlFlag, String openid);
}
