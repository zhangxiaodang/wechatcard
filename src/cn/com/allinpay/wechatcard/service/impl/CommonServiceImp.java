package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.wechatcard.dao.CommonDao;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.weixin.api.util.WeixinMsgCommonUtil;

@Service
public class CommonServiceImp extends BaseService implements ICommonService {

	/** 注册的dao **/
	@Autowired
	private CommonDao dao;

	@Override
	public String getOpenID(String urlFlag, String code) {

		// OpenID
		String strOpenId = "";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BEAN, urlFlag);

		Map<String, String> appInfo = this.dao.getAppInfo(urlFlag);

		// 根据Code取得openID
		strOpenId = WeixinMsgCommonUtil.getOpenIDByOAuth(code,
				appInfo.get("appid"), appInfo.get("appsecret")).getOpenid();

		// 返回
		return strOpenId;
	}
}
