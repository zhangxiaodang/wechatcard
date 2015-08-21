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
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0022Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 微信手机号重新绑定Controller.
 **/

@Controller
public class WEC0023Controller extends BaseController {

	/** 页面URL */
	private static String WEC0023_VIEW = "wec_0023/wec_0023";
	
	/**
	 * 重新绑定URL.
	 * 
	 * @return 重新绑定页面
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0023_INDEX, method = RequestMethod.GET)
	public String getPageIndex(){
		
		// 返回
		return WEC0023_VIEW;
	}
	
}
