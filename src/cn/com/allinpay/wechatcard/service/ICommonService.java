package cn.com.allinpay.wechatcard.service;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

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

	/**
	 * 获取登陆用户的信息
	 * 根据OpenID取得会员信息.
	 * 
	 * @param openid
	 *            openid.
	 * 
	 * return map  用户信息
	 */
	public Map<String, String> getMemberIDByOpenID(String openid);

	/**
	 * 根据URL Flag取得商户信息.
	 * 
	 * @param urlflag
	 *            商户标识.
	 * 
	 * @return 商户信息.
	 */
	public Map<String, String> getMerchantInfoByUrlFlag(String urlflag);
	
}
