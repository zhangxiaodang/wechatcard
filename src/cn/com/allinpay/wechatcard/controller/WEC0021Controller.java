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
import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.service.IWEC0021Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 申请新卡页面Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0021Controller extends BaseController {

	/** 页面URL */
	private static String WEC0021_VIEW = "wec_0021/wec_0021";
	
	/** 开通新卡的service **/
	@Autowired
	private IWEC0021Service wec0021Service;

	/**
	 * 申请会员卡页面URL.
	 * 
	 * @return 申请会员卡页面
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0021_INDEX, method = RequestMethod.GET)
	public String getPageIndex() {

		super.logger.info(super.session.getAttribute("key"));

		// 返回
		return WEC0021_VIEW;
	}
	
	/**
	 * 注册新卡.
	 */
	@RequestMapping(value = WebConstantUrlValue.APPLYNEWCARD, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String applyNewCard(WEC0010View memberView) {
		logger.info("========================Controller applyNewCard Start==========================");
		logger.info(memberView);
		WEC0010Model resultModel = new WEC0010Model();
		try {
			memberView.setMemberid(WebUtil.getUUID());
			// 调用注册的service
			resultModel = wec0021Service.applyNewCard(memberView);
		} catch (Exception e) {
			logger.info("========================Exception applyNewCard Start==========================");
			e.printStackTrace();

			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller applyNewCard End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
