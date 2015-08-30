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
import cn.com.allinpay.wechatcard.model.WEC0040Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0040Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 我的优惠券Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0040Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0040_VIEW = "wec_0040/wec_0040";

	/** 卡包的service. */
	@Autowired
	private IWEC0040Service wec0040Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 我的优惠券URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0040_INDEX, method = RequestMethod.GET)
	public String getPageIndex() {
		
		// 返回
		return WEC0040_VIEW;
	}

	/**
	 * 获取我的优惠券.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0040_MY_COUPON, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String my_coupon(WEC0010View memberView) {
		logger.info("========================Controller my_coupon Start==========================");
		logger.info(memberView);
		WEC0040Model resultModel = new WEC0040Model();
		try {
			// urlFlag
			String strUrlFlag = (String) super.session
					.getAttribute(SESSION_KEY_URLFLAG);
			// OpenID
			String strOpenID = (String) super.session
					.getAttribute(SESSION_KEY_OPENID);
			memberView.setOpenid(strOpenID);
			memberView.setUrlflag(strUrlFlag);
			// 调用注册的service 
			resultModel = wec0040Service.get_coupon(memberView);
		} catch (Exception e) {
			logger.info("========================Exception my_coupon Start==========================");
			e.printStackTrace();

			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller my_coupon End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
