package cn.com.allinpay.wechatcard.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.util.WebConstantUrlValue;

/**
 * 申请会员卡页面Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0020Controller extends BaseController {

	/** 页面URL */
	private static String WEC0020_VIEW = "wec_0020/wec_0020";

	/**
	 * 申请会员卡页面URL.
	 * 
	 * @return 申请会员卡页面
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0020_INDEX, method = RequestMethod.GET)
	public String getPageIndex() {

		super.session.setAttribute("key", "test");
		// 获取会员的信息，级别，卡片信息。

		// 返回
		return WEC0020_VIEW;
	}
}