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
import cn.com.allinpay.wechatcard.model.WEC0031Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0031Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 会员卡信息Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0031Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0031_VIEW = "wec_0031/wec_0031";

	/** 会员卡详情service. */
	@Autowired
	private IWEC0031Service wec0031Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 注册页面URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0031_INDEX, method = RequestMethod.GET)
	public String getPageIndex() {
		
		// 返回
		return WEC0031_VIEW;
	}

	/**
	 * 注册.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0031_GET_INFO, method = RequestMethod.GET, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String get_card_info(WEC0010View memberView) {
		logger.info("========================Controller get_card_info Start==========================");
		logger.info(memberView);
		WEC0031Model resultModel = new WEC0031Model();
		try {
			memberView.setMemberid(WebUtil.getUUID());
			// 调用注册的service
			resultModel = wec0031Service.get_card_info(memberView);
		} catch (Exception e) {
			logger.info("========================Exception get_card_info Start==========================");
			e.printStackTrace();
			
			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller get_card_info End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
