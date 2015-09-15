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
import cn.com.allinpay.wechatcard.model.WEC0036Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0036Service;
import cn.com.allinpay.wechatcard.view.WEC0036View;

/**
 * 充值记录Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0036Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0036_VIEW = "wec_0036/wec_0036";

	private static String SESSION_CARDNO = "dzcardno";

	private static String SESSION_DATE_START = "date_start";

	private static String SESSION_DATE_END = "date_end";

	/** 充值记录的service. */
	@Autowired
	private IWEC0036Service wec0036Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 充值记录URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0036_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {

		// 卡号
		String dzcardno = super.request.getParameter(SESSION_CARDNO);
		String date_start = super.request.getParameter(SESSION_DATE_START);
		String date_end = super.request.getParameter(SESSION_DATE_END);

		// 放入session中
		super.session.setAttribute(SESSION_CARDNO, dzcardno);
		super.session.setAttribute(SESSION_DATE_START, date_start);
		super.session.setAttribute(SESSION_DATE_END, date_end);

		ModelAndView mv = new ModelAndView();
		mv.setViewName(WEC0036_VIEW);
		mv.addObject("dzcardno", dzcardno);

		// 返回
		return mv;
	}

	/**
	 * 获取我的充值记录.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0036_GET_RECHARGE, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String get_recharge(WEC0036View wec0036View) {
		logger.info("========================Controller get_recharge Start==========================");
		logger.info(wec0036View);
		WEC0036Model resultModel = new WEC0036Model();
		try {
			// urlFlag
			String strUrlFlag = (String) super.session
					.getAttribute(SESSION_KEY_URLFLAG);
			// OpenID
			String strOpenID = (String) super.session
					.getAttribute(SESSION_KEY_OPENID);
			wec0036View.setOpenid(strOpenID);
			wec0036View.setUrlflag(strUrlFlag);
			// 调用注册的service
			resultModel = wec0036Service.get_recharge(wec0036View);
		} catch (Exception e) {
			logger.info("========================Exception get_recharge Start==========================");
			e.printStackTrace();

			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller get_recharge End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
