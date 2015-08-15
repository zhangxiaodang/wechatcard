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
import cn.com.allinpay.wechatcard.model.WEC0030Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0030Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 我的卡包Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0030Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0010_VIEW = "wec_0030/wec_0030";

	/** 卡包的service. */
	@Autowired
	private IWEC0030Service wec0030Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 注册页面URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0030_INDEX, method = RequestMethod.GET)
	public String getPageIndex() {
		
		// 返回
		return WEC0010_VIEW;
	}

	/**
	 * 注册.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0030_CARD_VOUCHER, method = RequestMethod.GET, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String get_card_voucher(WEC0010View memberView) {
		logger.info("========================Controller get_card_voucher Start==========================");
		logger.info(memberView);
		WEC0030Model resultModel = new WEC0030Model();
		try {
			memberView.setMemberid(WebUtil.getUUID());
			// 调用注册的service
			resultModel = wec0030Service.get_card_coupon(memberView);
		} catch (Exception e) {
			logger.info("========================Exception get_card_voucher Start==========================");
			e.printStackTrace();

			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller get_card_voucher End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
