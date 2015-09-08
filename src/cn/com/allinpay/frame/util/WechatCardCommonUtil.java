package cn.com.allinpay.frame.util;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * 配置文件
 */
public class WechatCardCommonUtil {

	/** properties配置文件名. */
	private static final String WECHARTCARD_PROPERTIES = "wechatcard";

	/** logger. */
	private static final Logger logger = Logger.getLogger(WechatCardCommonUtil.class);

	public static String getBefUrl() {
		String strUrl = WechatCardCommonUtil.getPropertiesValue("befurl");
		System.out.println("getBefUrl=" + strUrl);
		logger.info("getBefUrl=" + strUrl);
		return strUrl;
	}

	public static String getSendVerifyUrl() {
		String strUrl = WechatCardCommonUtil.getPropertiesValue("sendVervifyUrl");
		logger.info("sendVervifyUrl=" + strUrl);
		System.out.println("sendVervifyUrl=" + strUrl);

		return strUrl;
	}

	/**
	 * 根据key取得wechatcard.properties配置文件中的值.
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
			ResourceBundle res = ResourceBundle.getBundle(WECHARTCARD_PROPERTIES);
			strValue = res.getString(pstrKey);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 返回
		return strValue;
	}

}
