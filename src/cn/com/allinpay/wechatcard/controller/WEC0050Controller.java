package cn.com.allinpay.wechatcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.util.WebConstantUrlValue;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0050Service;

/**
 * 我要付款Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0050Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0050_VIEW = "wec_0050/wec_0050";

	/** 我要付款service. */
	@Autowired
	private IWEC0050Service wec0050Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 注册页面URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0050_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName(WEC0050_VIEW);
		} catch (Exception e) {
			logger.info("异常：\n" + e.getMessage());
			mv.addObject("errmsg", "打开页面时异常");
			mv.setViewName(WebConstantUrlValue.WEC_ERROR);
		}
		// 返回
		return mv;
	}
}
