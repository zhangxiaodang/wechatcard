package cn.com.allinpay.wechatcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.util.WebConstantUrlValue;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.WebJsonUtil;
import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0041Service;
import cn.com.allinpay.wechatcard.view.WEC0041View;

/**
 * 优惠券领取Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0041Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0041_VIEW = "wec_0041/wec_0041";

	/** 优惠券领取service. */
	@Autowired
	private IWEC0041Service wec0041Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 优惠券领取URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0041_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {
		ModelAndView mv = new ModelAndView();
		// 优惠券id
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
			WEC0034Model coupon = wec0041Service.get_coupon(wec0041View);
			
			mv.addObject("coupon", coupon);
			mv.setViewName(WEC0041_VIEW);
		} catch (Exception e) {
			logger.info("异常：\n" + e.getMessage());
			mv.addObject("errmsg", "打开页面时异常");
			mv.setViewName(WebConstantUrlValue.WEC_ERROR);
		}
		// 返回
		return mv;
	}

	/**
	 * 优惠券领取.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0041_COLLECT_COUPON, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String collect_coupon(WEC0041View wec0041View) {
		logger.info("========================Controller collect_coupon Start==========================");
		logger.info(wec0041View);
		WEC0034Model resultModel = new WEC0034Model();
		try {
			// urlFlag
			String strUrlFlag = (String)super.session.getAttribute(SESSION_KEY_URLFLAG);
			String strOpenID = (String)super.session.getAttribute(SESSION_KEY_OPENID);
			wec0041View.setUrlflag(strUrlFlag);
			wec0041View.setOpenid(strOpenID);
			// 领取会员优惠券
			resultModel = wec0041Service.collect_coupon(wec0041View);
		} catch (Exception e) {
			logger.info("========================Exception collect_coupon Start==========================");
			e.printStackTrace();
			
			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller collect_coupon End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
