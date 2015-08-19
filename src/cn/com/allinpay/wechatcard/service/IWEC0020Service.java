package cn.com.allinpay.wechatcard.service;

import org.springframework.web.servlet.ModelAndView;

import cn.com.allinpay.wechatcard.view.WEC0020View;

/**
 * 
 * 会员卡注册service
 * 
 * @version V1.00.
 * 
 */
public interface IWEC0020Service {
	
	/**
	 * 注册的service
	 * @param memberView
	 * @return
	 */
	public int phone_is_rigist(WEC0020View memberView) throws Exception;
	
	/**
	 * 获取用户级别和用户的是否申请过新卡，10和20中都使用到了。
	 * 
	 * @param openID 
	 * @param urlFlag
	 */
	public ModelAndView getMemberCardInfo(String strOpenID, String strUrlFlag) throws Exception;
	
}
