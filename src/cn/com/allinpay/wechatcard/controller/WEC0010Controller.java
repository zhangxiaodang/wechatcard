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
			// 测试使用
//			if(strUrlFlag == null){
//				strUrlFlag = "121";
//			}
			// 放到session中
			super.session.setAttribute(SESSION_KEY_URLFLAG, strUrlFlag);

			// 从session中取得openid
			strOpenID = super.session.getAttribute(SESSION_KEY_OPENID)
					.toString();
			// 从其它页面跳转过来时
			if (strOpenID == null || strOpenID.isEmpty()) {
				// 取得OpenID
				strOpenID = this.commonService.getOpenID(strUrlFlag, strCode);
				strOpenID = "oA36ajksXyuTmcVCO6EI-jWhQp2o";
			}

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
					// 返回会员卡页面
					mv.setViewName("wec_0020/wec_0020");
				} else {
					// 返回注册页面
					mv.setViewName(WEC0010_VIEW);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("异常：\n" + e.getMessage());
			mv.addObject("errmsg", "打开页面时异常");
			mv.setViewName(WebConstantUrlValue.WEC_ERROR);
		}

		// 返回
		return mv;
	}

	/**
	 * 注册.
	 */
	@RequestMapping(value = WebConstantUrlValue.REGISTER, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String register(WEC0010View memberView) {
		logger.info("========================Controller register Start==========================");

		WEC0010Model resultModel = new WEC0010Model();
		try {
			// urlFlag
			String strUrlFlag = super.session.getAttribute(SESSION_KEY_URLFLAG)
					.toString();
			// OpenID
			String strOpenID = super.session.getAttribute(SESSION_KEY_OPENID)
					.toString();

			// URLFlag
			memberView.setUrlflag(strUrlFlag);
			// OpenID
			memberView.setMemberid(WebUtil.getUUID());
			memberView.setMemberopenid(strOpenID);
			
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
