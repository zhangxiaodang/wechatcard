package cn.com.weixin.api.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import cn.com.weixin.api.result.OAuthCodeResult;

/**
 * 微信应用共通方法类.
 */
public class WeixinMsgCommonUtil {

	/** properties配置文件名. */
	private static final String WEIXIN_PROPERTIES = "weixin-msg";

	/** logger. */
	private static final Logger logger = Logger
			.getLogger(WeixinMsgCommonUtil.class);

	/**
	 * 网页安全认证,通过code获取关注这的用户的信息
	 * 
	 * @param code
	 *            微信认证的code,用来换取用户的信息
	 * @return 认证结果含有用户的信息
	 */
	public static OAuthCodeResult getOpenIDByOAuth(String code) {

		// 返回值
		OAuthCodeResult result = null;

		try {
			// 开发者凭据
			String strAppid = "";
			String strAppSecret = "";

			// 通过code换取网页授权access_token URL
			String strUrl = WeixinMsgCommonUtil
					.getPropertiesValue(WeixinMsgConstValue.URL_GET_OAUTH);
			strUrl = MessageFormat.format(strUrl, strAppid, strAppSecret, code);

			// 通过HTTP GET方式取得openID
			result = WeixinMsgJsonUtil.json2Bean(
					WeixinMsgHttpUtil.getResponseWithGET(strUrl),
					OAuthCodeResult.class);
		} catch (Exception e) {
			// 异常
			e.printStackTrace();
		}

		// 返回
		return result;
	}

	/**
	 * 根据key取得weixin.properties配置文件中的值.
	 * 
	 * @param pstrKey
	 * 
	 * @return value
	 */
	public static String getPropertiesValue(String pstrKey) {

		// 返回值
		String strValue = "";

		try {
			// 读取weixin.properties配置文件
			ResourceBundle res = ResourceBundle.getBundle(WEIXIN_PROPERTIES);

			strValue = res.getString(pstrKey);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 返回
		return strValue;
	}

}
