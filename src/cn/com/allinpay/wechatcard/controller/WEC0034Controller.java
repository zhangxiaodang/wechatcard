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
import cn.com.allinpay.wechatcard.service.IWEC0034Service;
import cn.com.allinpay.wechatcard.view.CouponView;

/**
 * 优惠券信息Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0034Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0034_VIEW = "wec_0034/wec_0034";

	/** 优惠券详情service. */
	@Autowired
	private IWEC0034Service wec0034Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 注册页面URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0034_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {
		// 商户标识
		String strUrlFlag = "";
		// openid
		String strOpenID = "";
		// 返回值
		ModelAndView mv = new ModelAndView();
		CouponView coupon = new CouponView();
		try {
			String couponid = super.request.getParameter("couponid");
			// urlFlag
			strUrlFlag = (String) super.session
					.getAttribute(SESSION_KEY_URLFLAG);
			// OpenID
			strOpenID = (String) super.session
					.getAttribute(SESSION_KEY_OPENID);
			// URLFlag
			coupon.setUrlflag(strUrlFlag);
			coupon.setOpenid(strOpenID);
			coupon.setCouponid(couponid);
			// 调用注册的service
			WEC0034Model resultModel = wec0034Service.get_coupon(coupon);
			mv.addObject("coupon", resultModel);
			
			mv.setViewName(WEC0034_VIEW);
		} catch (Exception e) {
			logger.info("异常：\n" + e.getMessage());
			mv.addObject("errmsg", "打开页面时异常");
			mv.setViewName(WebConstantUrlValue.WEC_ERROR);
		}
		// 返回
		return mv;
	}
}
