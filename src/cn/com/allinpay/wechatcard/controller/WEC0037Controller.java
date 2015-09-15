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
import cn.com.allinpay.wechatcard.model.WEC0037Model;
import cn.com.allinpay.wechatcard.service.IWEC0037Service;
import cn.com.allinpay.wechatcard.view.WEC0037View;

/**
 * 消费记录查询Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0037Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0037_VIEW = "wec_0037/wec_0037";

	@Autowired
	private IWEC0037Service service;

	/**
	 * 充值记录查询URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0037_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {

		String dzcardno = super.request.getParameter("dzcardno");
		ModelAndView mv = new ModelAndView();
		mv.setViewName(WEC0037_VIEW);
		// 卡号
		mv.addObject("dzcardno", dzcardno);

		// 返回
		return mv;
	}

	/**
	 * 消费记录查询校验.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0037_CHECK, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String get_recharge(WEC0037View view) {
		logger.info("========================Controller get_recharge Start==========================");

		// 返回值
		WEC0037Model resultModel = new WEC0037Model();

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
