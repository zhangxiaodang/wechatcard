package cn.com.allinpay.wechatcard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.util.WebConstantUrlValue;
/**
 * 
 * 申请会员卡页面controller
 * 
 * @version V1.00.
 * 
 **/
@Controller
public class WEC0020Controller extends BaseController{
	private static String WEC0020_VIEW = "wec_0020/wec_0020";
	/**
	 * 申请会员卡页面URL.
	 * 
	 * @return 申请会员卡页面
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0020_INDEX)
	public String getPageIndex() {
		// 返回
		return WEC0020_VIEW;
	}
}