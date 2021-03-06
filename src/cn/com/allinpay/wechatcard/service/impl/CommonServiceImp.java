package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.wechatcard.dao.CommonDao;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.weixin.api.result.OAuthCodeResult;
import cn.com.weixin.api.util.WeixinMsgCommonUtil;

/**
 * 共通Service实现类.
 */

@Service
public class CommonServiceImp extends BaseService implements ICommonService {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(CommonServiceImp.class);

	/** 共通dao **/
	@Autowired
	private CommonDao dao;

	@Override
	public String getOpenID(String urlFlag, String code) {

		// OpenID
		String strOpenId = "";

		// 根据商户标识取得商户微信服务号的appid和appsecrt
		Map<String, String> appInfo = this.dao.getAppInfo(urlFlag);
		logger.info("appid=" + appInfo.get("appid") + ",appsecret="
				+ appInfo.get("appsecret"));

		// 根据Code取得openID
		OAuthCodeResult result = WeixinMsgCommonUtil.getOpenIDByOAuth(code,
				appInfo.get("appid"), appInfo.get("appsecret"));

		// 成功时
		if (result != null && result.getErrmsg().equals("")) {
			strOpenId = result.getOpenid();
		} else {
			// 失败时
			logger.info("取得用户openid失败,errcode:" + result.getErrcode()
					+ ",errmsg:" + result.getErrmsg());
		}

		// 返回
		return strOpenId;
	}

	@Override
	public boolean isRegister(String urlFlag, String openid) {

		Map<String, String> paramMap = new HashMap<String, String>();
		// urlflag
		paramMap.put("urlflag", urlFlag);
		// openid
		paramMap.put("openid", openid);

		// 查询是否注册
		int result = this.dao.getRegister(paramMap);

		// 返回
		return result == 0 ? false : true;
	}

	@Override
	public Map<String, String> getMemberIDByOpenID(String openid) {
		Map<String, String> paramMap = new HashMap<String, String>();
		// openid
		paramMap.put("openid", openid);

		// 查询是否注册
		Map<String, String> result = this.dao.getMemberIDByOpenID(paramMap);
		return result;
	}

	@Override
	public Map<String, String> getMerchantInfoByUrlFlag(String urlflag) {

		// 根据urlFlag查询商户的信息
		Map<String, String> result = this.dao.getMerchantInfoByUrlFlag(urlflag);

		return result;
	}

	@Override
	public Map<String, String> getParametersByMerchantid(String merchantid) {
		// TODO Auto-generated method stub
		Map<String, String> result = this.dao
				.getParametersByMerchantid(merchantid);
		return result;
	}

	@Override
	public String getOrderIdByDual(String id) {
		// TODO Auto-generated method stub
		String result = this.dao.getOrderIdByDual(id);
		return result;
	}

	@Override
	public boolean isNewCard(String openid) {

		// 查询
		int intResult = this.dao.isNewCardFlag(openid);

		// 判断结果
		if (intResult > 0) {
			return true;
		} else {
			return false;
		}
	}
}
