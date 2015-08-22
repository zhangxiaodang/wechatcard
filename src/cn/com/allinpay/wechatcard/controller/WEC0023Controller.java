package cn.com.allinpay.wechatcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import cn.com.allinpay.wechatcard.service.IWEC0023Service;
import cn.com.allinpay.wechatcard.view.WEC0023View;

/**
 * 微信手机号重新绑定Controller.
 **/

@Controller
public class WEC0023Controller extends BaseController {

	/** 页面URL */
	private static String WEC0023_VIEW = "wec_0023/wec_0023";
	
	@Autowired
	private IWEC0023Service wec0023Service;
	
	/**
	 * 重新绑定URL.
	 * 
	 * @return 重新绑定页面
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0023_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex(){
		ModelAndView mv = new ModelAndView();
		// 获取手机号
		String member_phone = super.request.getParameter("member_phone");
		mv.setViewName(WEC0023_VIEW);
		mv.addObject("member_phone", member_phone);
		// 返回
		return mv;
	}
	
	/**
	 * 重新绑定的方法.
	 * 
	 * @return 重新绑定页面
	 */
	@RequestMapping(value = WebConstantUrlValue.CHANGE_OPENID, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String change_openid(String member_phone){
		// urlFlag
		String strUrlFlag = (String)super.session.getAttribute(SESSION_KEY_URLFLAG);
		// OpenID
		String strOpenID = (String)super.session.getAttribute(SESSION_KEY_OPENID);
		
		BaseModel baseModel = new BaseModel();
		try {
			WEC0023View wec0023View = new WEC0023View();
			wec0023View.setMemberphone(member_phone);
			wec0023View.setOpenid(strOpenID);
			wec0023View.setUrlflag(strUrlFlag);
			baseModel = wec0023Service.change_openid(wec0023View);
		} catch (Exception e) {
			logger.info("========================Exception change_openid Start==========================");
			logger.info("重新绑定微信号异常：\n" + e.getMessage());
			
			// 异常
			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller change_openid End==========================");

		// 返回
		return WebJsonUtil.bean2Json(baseModel);
	}
	
}
