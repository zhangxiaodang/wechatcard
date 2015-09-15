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
import cn.com.allinpay.wechatcard.model.WEC0030Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0030Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 我的卡包Controller.
 */

@Controller
@Scope(value = "prototype")
public class WEC0030Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0030_VIEW = "wec_0030/wec_0030";

	/** 卡包的service. */
	@Autowired
	private IWEC0030Service wec0030Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 注册页面URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0030_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {

		// 商户标识
		String strUrlFlag = "";
		// 网页Code
		String strCode = "";
		// openid
		String strOpenID = "";
		// 返回值
		ModelAndView mv = new ModelAndView();

		try {
			strUrlFlag = super.request.getParameter(KEY_URL_FLAG);
			strCode = super.request.getParameter(KEY_CODE);
			super.logger.info("获取网页code：" + strCode);

			// 放到session中
			super.session.setAttribute(SESSION_KEY_URLFLAG, strUrlFlag);

			// 从session中取得openid
			strOpenID = (String) super.session.getAttribute(SESSION_KEY_OPENID);
			// 从其它页面跳转过来时
			if (strOpenID == null || strOpenID.isEmpty()) {
				// 取得OpenID
				strOpenID = this.commonService.getOpenID(strUrlFlag, strCode);
			}

			// todo-zhangxd
			// strOpenID = WebConstantValue.TESTOPENID;

			// 未获取openid时
			if (strOpenID == null || strOpenID.isEmpty()) {
				logger.info("未获取到openid!");
				mv.addObject("errmsg", "未获取到openid!");
				mv.setViewName(WebConstantUrlValue.WEC_ERROR);
			} else {
				// 放到Session中
				super.session.setAttribute(SESSION_KEY_OPENID, strOpenID);
				logger.info("用户openid:" + strOpenID);

				// 是否注册
				boolean isRegister = this.commonService.isRegister(strUrlFlag,
						strOpenID);

				// 已注册时
				if (isRegister) {
					boolean isNewCard = this.commonService.isNewCard(strOpenID);

					if (isNewCard) {
						mv.addObject("newcardflag", "01");
					} else {
						mv.addObject("newcardflag", "02");
					}

					// 返回我的卡包页面
					mv.setViewName(WEC0030_VIEW);
				} else {
					// 返回注册页面
					mv.setViewName("wec_0061/wec_0061");
				}
			}
		} catch (Exception e) {
			logger.info("异常：\n" + e.getMessage());
			mv.addObject("errmsg", "打开页面时异常");
			mv.setViewName(WebConstantUrlValue.WEC_ERROR);
		}

		// 返回
		return mv;
	}

	/**
	 * 获取会员卡和会员的优惠券.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0030_CARD_COUPON, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String get_card_coupon(WEC0010View memberView) {
		logger.info("========================Controller get_card_coupon Start==========================");
		logger.info(memberView);
		WEC0030Model resultModel = new WEC0030Model();
		try {
			// urlFlag
			String strUrlFlag = (String) super.session
					.getAttribute(SESSION_KEY_URLFLAG);
			// OpenID
			String strOpenID = (String) super.session
					.getAttribute(SESSION_KEY_OPENID);
			memberView.setOpenid(strOpenID);
			memberView.setUrlflag(strUrlFlag);
			// 调用注册的service
			resultModel = wec0030Service.get_card_coupon(memberView);
		} catch (Exception e) {
			logger.info("========================Exception get_card_coupon Start==========================");
			e.printStackTrace();

			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller get_card_coupon End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
