package cn.com.allinpay.wechatcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.util.WebConstantUrlValue;
import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0042Service;
import cn.com.allinpay.wechatcard.view.WEC0041View;

/**
 * 优惠券领取完毕Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0042Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0042_VIEW = "wec_0042/wec_0042";

	/** 优惠券领取service. */
	@Autowired
	private IWEC0042Service wec0042Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 注册页面URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0042_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {
		ModelAndView mv = new ModelAndView();
		// 获取手机号
		try {

			String couponid = super.request.getParameter("couponid");
			// urlFlag
			String strUrlFlag = (String)super.session.getAttribute(SESSION_KEY_URLFLAG);
			// OpenID
			String strOpenID = (String)super.session.getAttribute(SESSION_KEY_OPENID);
			WEC0041View wec0041View = new WEC0041View();
			wec0041View.setUrlflag(strUrlFlag);
			wec0041View.setOpenid(strOpenID);
			wec0041View.setCouponid(couponid);
			WEC0034Model coupon = wec0042Service.get_coupon(wec0041View);
			
			mv.addObject("coupon", coupon);
			mv.setViewName(WEC0042_VIEW);
		} catch (Exception e) {
			logger.info("异常：\n" + e.getMessage());
			mv.addObject("errmsg", "打开页面时异常");
			mv.setViewName(WebConstantUrlValue.WEC_ERROR);
		}
		// 返回
		return mv;
	}
}
