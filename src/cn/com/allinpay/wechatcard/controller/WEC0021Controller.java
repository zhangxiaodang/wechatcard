package cn.com.allinpay.wechatcard.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.util.WebConstantUrlValue;

/**
 * 申请新卡页面Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0021Controller extends BaseController {

	/** 页面URL */
	private static String WEC0021_VIEW = "wec_0021/wec_0021";

	/**
	 * 申请会员卡页面URL.
	 * 
	 * @return 申请会员卡页面
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0021_INDEX, method = RequestMethod.GET)
	public String getPageIndex() {

		super.logger.info(super.session.getAttribute("key"));

		// 返回
		return WEC0021_VIEW;
	}
}
