package cn.com.allinpay.wechatcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.model.BaseModel;
import cn.com.allinpay.frame.util.WebConstantUrlValue;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.WebJsonUtil;
import cn.com.allinpay.frame.util.WebUtil;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0060Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 修改手机号Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0060Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0036_VIEW = "wec_0036/wec_0036";

	/** 修改手机号service. */
	@Autowired
	private IWEC0060Service wec0036Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 修改卡密码URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0036_INDEX, method = RequestMethod.GET)
	public String getPageIndex() {
		
		// 返回
		return WEC0036_VIEW;
	}

	/**
	 * 修改手机号
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0035_CHANGE_PHONE, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String change_phone(WEC0010View memberView) {
		logger.info("========================Controller change_phone Start==========================");
		logger.info(memberView);
		BaseModel resultModel = new BaseModel();
		try {
			memberView.setMemberid(WebUtil.getUUID());
			// 调用修改密码的service
			resultModel = wec0036Service.change_phone(memberView);
		} catch (Exception e) {
			logger.info("========================Exception change_phone Start==========================");
			e.printStackTrace();
			
			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller change_phone End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
