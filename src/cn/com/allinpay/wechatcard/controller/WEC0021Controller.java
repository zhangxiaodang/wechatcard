package cn.com.allinpay.wechatcard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.util.WebConstantUrlValue;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.WebJsonUtil;
import cn.com.allinpay.frame.util.WebUtil;
import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
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
	
	@Autowired
	private ICommonService commonService;
	/**
	 * 申请会员卡页面URL.
	 * 
	 * @return 申请会员卡页面
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0021_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {

		super.logger.info(super.session.getAttribute("key"));
		ModelAndView mv = new ModelAndView();
		// 获取当前登陆用户的手机号
		try {
			// 取得OpenID
			String strOpenID = (String) this.session.getAttribute(SESSION_KEY_OPENID);
			Map<String, String> memberInfo = commonService.getMemberInfoByOpenID(strOpenID);
			if(memberInfo == null || memberInfo.get("memberphone") == null || "".equals(memberInfo.get("memberphone"))){
				// 如果根据openid获取会员的id，获取不到，提示用户。
				mv.addObject("errmsg", WebConstantValue.ADD_CARD_ERROR);
				mv.setViewName(WebConstantUrlValue.WEC_ERROR);
				return mv;
			}
			mv.addObject("memberphone", memberInfo.get("memberphone"));
			mv.setViewName(WEC0021_VIEW);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("异常：\n" + e.getMessage());
			mv.addObject("errmsg", "打开页面时异常");
			mv.setViewName(WebConstantUrlValue.WEC_ERROR);
		}
		// 返回
		return mv;
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
			// 取得OpenID
			String strOpenID = (String) this.session.getAttribute(SESSION_KEY_OPENID);
			memberView.setMemberopenid(strOpenID);
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
