package cn.com.allinpay.wechatcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.util.WebConstantUrlValue;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.WebJsonUtil;
import cn.com.allinpay.frame.util.WebUtil;
import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0010Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 会员注册Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0010Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0010_VIEW = "wec_0010/wec_0010";

	/** 注册的service. */
	@Autowired
	private IWEC0010Service registerService;

	@Autowired
	private ICommonService commonService;

	/**
	 * 注册页面URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0010_INDEX, method = RequestMethod.GET)
	public String getPageIndex() {

		// 取得OpenID
//		String strOpenID = this.commonService.getOpenID(
//				super.request.getParameter(KEY_URL_FLAG),
//				this.request.getParameter(KEY_CODE));
//		// 放到Session中
//		this.session.setAttribute(SESSION_KEY_OPENID, strOpenID);

		// 返回
		return WEC0010_VIEW;
	}

	/**
	 * 注册.
	 */
	@RequestMapping(value = WebConstantUrlValue.REGISTER, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String register(WEC0010View memberView) {
		logger.info("========================Controller register Start==========================");
		logger.info(memberView);
		WEC0010Model resultModel = new WEC0010Model();
		try {
			memberView.setMemberid(WebUtil.getUUID());
			// 调用注册的service
			resultModel = registerService.regist(memberView);
		} catch (Exception e) {
			logger.info("========================Exception register Start==========================");
			e.printStackTrace();

			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller register End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}

	/**
	 * 获取短信验证码.
	 */
	@RequestMapping(value = WebConstantUrlValue.GETYZM, produces = WebConstantValue.PRODUCE_TEXT, method = RequestMethod.POST)
	@ResponseBody
	public String getYzm(WEC0010View memberView) {
		logger.info("========================Controller getYzm Start==========================");
		logger.info(memberView);
		WEC0010Model resultModel = new WEC0010Model();
		try {
			// 获取验证码
			resultModel = registerService.getYzm(memberView);
		} catch (Exception e) {
			logger.info("========================Exception  getYzm Start==========================");
			e.printStackTrace();

			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller getYzm End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
