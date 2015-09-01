package cn.com.allinpay.wechatcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.model.BaseModel;
import cn.com.allinpay.frame.util.WebConstantUrlValue;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.WebJsonUtil;
import cn.com.allinpay.frame.util.WebUtil;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0035Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 修改卡密码Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0035Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0035_VIEW = "wec_0035/wec_0035";

	/** 修改卡密码service. */
	@Autowired
	private IWEC0035Service wec0035Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 修改卡密码URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0035_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {
		// 返回值
		ModelAndView mv = new ModelAndView();

		try {
			String dzcardno = super.request.getParameter("dzcardno");
			mv.addObject("dzcardno", dzcardno);
			// 返回修改手机号页面
			mv.setViewName(WEC0035_VIEW);
		} catch (Exception e) {
			logger.info("异常：\n" + e.getMessage());
			mv.addObject("errmsg", "打开页面时异常");
			mv.setViewName(WebConstantUrlValue.WEC_ERROR);
		}

		// 返回
		return mv;
	}

	/**
	 * 修改卡密码
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0035_CHANGE_PASS, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String change_pass(WEC0010View memberView) {
		logger.info("========================Controller change_pass Start==========================");
		logger.info(memberView);
		BaseModel resultModel = new BaseModel();
		try {
			memberView.setMemberid(WebUtil.getUUID());
			// 调用修改密码的service
			resultModel = wec0035Service.change_pass(memberView);
		} catch (Exception e) {
			logger.info("========================Exception change_pass Start==========================");
			e.printStackTrace();
			
			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller change_pass End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
