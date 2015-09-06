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
import cn.com.allinpay.wechatcard.model.WEC0032Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0032Service;
import cn.com.allinpay.wechatcard.view.WEC0032View;

/**
 * 我要充值Controller.
 */

@Controller
@Scope(value = "prototype")
public class WEC0032Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0032_VIEW = "wec_0032/wec_0032";

	/** 我要充值service. */
	@Autowired
	private IWEC0032Service wec0032Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 我要充值URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0032_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {

		// 商户标识
		String strUrlFlag = "";
		// openid
		String strOpenID = "";
		// 卡号
		String strCardNo = "";
		// 返回值
		ModelAndView mv = new ModelAndView();

		try {
			strUrlFlag = String.valueOf(super.session
					.getAttribute(SESSION_KEY_URLFLAG));
			strOpenID = String.valueOf(super.session
					.getAttribute(SESSION_KEY_URLFLAG));
			strCardNo = super.request.getParameter("cardno");

			super.logger.info("zhangxd==session urlflag：" + strUrlFlag);
			super.logger.info("zhangxd==session openid：" + strOpenID);
			super.logger.info("zhangxd==卡号 strCardNo：" + strCardNo);

			// todo-zhangxd
//			 strOpenID = "asdfasdfoo";

			// 卡号
			mv.addObject("cardno", strCardNo);
			mv.setViewName(WEC0032_VIEW);
		} catch (Exception e) {
			logger.info("异常：\n" + e.getMessage());
			mv.addObject("errmsg", "打开页面时异常");
			mv.setViewName(WebConstantUrlValue.WEC_ERROR);
		}

		// 返回
		return mv;
	}

	/**
	 * 充值.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0032_CHONGZHI, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String chongzhi(WEC0032View wec0032View) {
		logger.info("========================Controller chongzhi==========================");

		WEC0032Model resultModel = new WEC0032Model();

		try {
			// urlFlag
			String strUrlFlag = (String) super.session
					.getAttribute(SESSION_KEY_URLFLAG);
			// OpenID
			String strOpenID = (String) super.session
					.getAttribute(SESSION_KEY_OPENID);

			wec0032View.setOpenid(strOpenID);
			wec0032View.setUrlflag(strUrlFlag);
			// 调用注册的service
			resultModel = this.wec0032Service.chongzhi_ser(wec0032View);
		} catch (Exception e) {
			logger.info("========================Exception chongzhi==========================");
			e.printStackTrace();

			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller chongzhi End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
