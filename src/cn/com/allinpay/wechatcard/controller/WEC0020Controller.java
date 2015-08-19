package cn.com.allinpay.wechatcard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.util.WebConstantUrlValue;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0020Service;
import cn.com.allinpay.wechatcard.view.WEC0020View;

/**
 * 申请会员卡页面Controller.
 **/

@Controller
@Scope(value = "prototype")
public class WEC0020Controller extends BaseController {

	/** 页面URL */
	private static String WEC0020_VIEW = "wec_0020/wec_0020";
	
	@Autowired
	private ICommonService commonService;
	
	@Autowired
	private IWEC0020Service wec0020Service;
	
	/**
	 * 申请会员卡页面URL.
	 * 
	 * @return 申请会员卡页面
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0020_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {

		super.session.setAttribute("key", "test");
		// 获取会员的信息，级别，卡片信息。
		ModelAndView mv = new ModelAndView();
		// 获取当前登陆用户的手机号
		try {
			// 取得OpenID
			String strOpenID = (String) this.session.getAttribute(SESSION_KEY_OPENID);
			String strUrlFlag = (String) this.session.getAttribute(SESSION_KEY_URLFLAG);
			// 查询当前登陆人的卡的信息（会员级别，是否可以申请新卡）
			mv = wec0020Service.getMemberCardInfo(strOpenID, strUrlFlag);
			mv.setViewName(WEC0020_VIEW);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("异常：\n" + e.getMessage());
			mv.addObject("errmsg", "打开页面时异常");
			mv.setViewName(WebConstantUrlValue.WEC_ERROR);
		}
		// 返回
		return mv;
	}
}