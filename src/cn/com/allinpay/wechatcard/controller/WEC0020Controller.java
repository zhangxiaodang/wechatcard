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
			Map<String, String> memberInfo = commonService.getMemberInfoByOpenID(strOpenID);
			if(memberInfo == null || memberInfo.get("membergrade") == null || "".equals(memberInfo.get("membergrade"))){
				// 如果根据openid获取会员的id，获取不到，提示用户。
				mv.addObject("errmsg", WebConstantValue.ADD_CARD_ERROR);
				mv.setViewName(WebConstantUrlValue.WEC_ERROR);
				return mv;
			}
			WEC0020View wec0020View = new WEC0020View();
			// 获取用户是否注册过改商户
			wec0020View.setMemberphone(memberInfo.get("memberphone"));
			wec0020View.setOpenid(strOpenID);
			wec0020View.setUrlflag(strUrlFlag);
			// 查询改手机号是否开过卡
			int cnt = wec0020Service.phone_is_rigist(wec0020View);
			boolean phone_is_used = false;
			if (cnt > 0){
				phone_is_used = true;
			}
			mv.addObject("phone_is_used", phone_is_used);
			mv.addObject("membergrade", memberInfo.get("membergrade"));
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