package cn.com.allinpay.wechatcard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.util.WebConstantUrlValue;

/**
 * 绑定旧卡页面Controller.
 **/

@Controller
public class WEC0022Controller extends BaseController {

	/** 页面URL */
	private static String WEC0022_VIEW = "wec_0022/wec_0022";

	/**
	 * 申请会员卡页面URL.
	 * 
	 * @return 申请会员卡页面
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0022_INDEX, method = RequestMethod.GET)
	public String getPageIndex() {

		// 返回
		return WEC0022_VIEW;
	}
}
