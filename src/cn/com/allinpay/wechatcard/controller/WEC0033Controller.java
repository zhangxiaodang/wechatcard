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
import cn.com.allinpay.wechatcard.model.WEC0033Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0033Service;
import cn.com.allinpay.wechatcard.view.WEC0033View;

/**
 * 消费记录Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0033Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0033_VIEW = "wec_0033/wec_0033";

	private static String SESSION_CARDNO = "dzcardno";

	private static String SESSION_DATE_START = "date_start";

	private static String SESSION_DATE_END = "date_end";

	/** 消费记录的service. */
	@Autowired
	private IWEC0033Service wec0033Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 消费记录URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0033_INDEX, method = RequestMethod.GET)
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
		mv.setViewName(WEC0033_VIEW);
		mv.addObject("dzcardno", dzcardno);
		// 返回
		return mv;
	}

	/**
	 * 获取我的消费记录.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0033_GET_CONSUME, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String get_consume(WEC0033View wec0033View) {
		logger.info("========================Controller get_consume Start==========================");
		logger.info(wec0033View);
		WEC0033Model resultModel = new WEC0033Model();
		try {
			// urlFlag
			String strUrlFlag = (String) super.session
					.getAttribute(SESSION_KEY_URLFLAG);
			// OpenID
			String strOpenID = (String) super.session
					.getAttribute(SESSION_KEY_OPENID);
			wec0033View.setOpenid(strOpenID);
			wec0033View.setUrlflag(strUrlFlag);
			// 调用注册的service
			resultModel = wec0033Service.get_consume(wec0033View);
		} catch (Exception e) {
			logger.info("========================Exception get_consume Start==========================");
			e.printStackTrace();

			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller get_consume End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
