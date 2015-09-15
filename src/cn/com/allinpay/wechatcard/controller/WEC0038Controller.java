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
import cn.com.allinpay.wechatcard.model.WEC0038Model;
import cn.com.allinpay.wechatcard.service.IWEC0038Service;
import cn.com.allinpay.wechatcard.view.WEC0038View;

/**
 * 充值记录查询Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0038Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0038_VIEW = "wec_0038/wec_0038";

	@Autowired
	private IWEC0038Service service;

	/**
	 * 充值记录查询URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0038_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {

		String dzcardno = super.request.getParameter("dzcardno");
		ModelAndView mv = new ModelAndView();
		mv.setViewName(WEC0038_VIEW);
		// 卡号
		mv.addObject("dzcardno", dzcardno);

		// 返回
		return mv;
	}

	/**
	 * 消费记录查询校验.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0038_CHECK, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String get_recharge(WEC0038View view) {
		logger.info("========================Controller get_recharge Start==========================");

		// 返回值
		WEC0038Model resultModel = new WEC0038Model();

		try {
			// 调用Service检验密码
			resultModel = this.service.checkPasswd(view);

		} catch (Exception e) {
			logger.info("========================Exception get_recharge Start==========================");
			e.printStackTrace();

			// 返回错误
			return WebJsonUtil.bean2Json(getSysErrorModel());
		}

		logger.info("========================Controller get_recharge End==========================");

		// 返回
		return WebJsonUtil.bean2Json(resultModel);
	}
}
