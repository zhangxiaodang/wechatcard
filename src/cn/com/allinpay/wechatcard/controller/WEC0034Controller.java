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
import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0034Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 优惠券信息Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0034Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0034_VIEW = "wec_0034/wec_0034";

	/** 优惠券详情service. */
	@Autowired
	private IWEC0034Service wec0034Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 注册页面URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0034_INDEX, method = RequestMethod.GET)
	public String getPageIndex() {
		
		// 返回
		return WEC0034_VIEW;
	}

	/**
	 * 优惠券信息.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0031_GET_COUPON, method = RequestMethod.GET, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String get_coupon(WEC0010View memberView) {
		logger.info("========================Controller get_coupon Start==========================");
		logger.info(memberView);
		WEC0034Model resultModel = new WEC0034Model();
		try {
			// 调用注册的service
			resultModel = wec0034Service.get_coupon(memberView);
		} catch (Exception e) {
			logger.info("========================Exception get_coupon Start==========================");
			e.printStackTrace();
			
			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller get_coupon End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
