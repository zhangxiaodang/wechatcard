package cn.com.allinpay.wechatcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import cn.com.allinpay.wechatcard.service.IWEC0022Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 绑定旧卡页面Controller.
 **/

@Controller
public class WEC0022Controller extends BaseController {

	/** 页面URL */
	private static String WEC0022_VIEW = "wec_0022/wec_0022";

	/** 绑定旧卡的service **/
	@Autowired
	private IWEC0022Service wec0022Service;
	
	/**
	 * 申请会员卡页面URL.
	 * 
	 * @return 申请会员卡页面
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0022_INDEX, method = RequestMethod.GET)
	public String getPageIndex() {

		// 返回
		return WEC0022_VIEW;
	}
	
	/**
	 * 绑定旧卡
	 */
	@RequestMapping(value = WebConstantUrlValue.BINDINGOLDCARD, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String bindingOldCard(WEC0010View memberView) {
		logger.info("========================Controller bindingOldCard Start==========================");
		logger.info(memberView);
		BaseModel resultModel = new BaseModel();
		try {
			memberView.setMemberid(WebUtil.getUUID());
			// 调用注册的service
			resultModel = wec0022Service.bindingOldCard(memberView);
		} catch (Exception e) {
			logger.info("========================Exception bindingOldCard Start==========================");
			e.printStackTrace();

			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller bindingOldCard End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
