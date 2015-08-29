package cn.com.allinpay.wechatcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0060Service;
import cn.com.allinpay.wechatcard.view.WEC0060View;

/**
 * 修改手机号Controller.
 */

@Controller
@Scope(value = "prototype")
public class WEC0060Controller extends BaseController {

	/** 页面URL. */
	private static String WEC0060_VIEW = "wec_0060/wec_0060";

	/** 修改手机号service. */
	@Autowired
	private IWEC0060Service wec0060Service;

	@Autowired
	private ICommonService commonService;

	/**
	 * 修改卡密码URL.
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0060_INDEX, method = RequestMethod.GET)
	public ModelAndView getPageIndex() {

		// 商户标识
		String strUrlFlag = "";
		// openid
		String strOpenID = "";
		// 网页Code
		String strCode = "";
		// 返回值
		ModelAndView mv = new ModelAndView();

		try {
			strUrlFlag = super.request.getParameter(KEY_URL_FLAG);
			strCode = super.request.getParameter(KEY_CODE);

			super.logger.info("zhangxd==获取网页code：" + strCode);
			super.logger.info("zhangxd==获取网页urlflag：" + strUrlFlag);

			// 放到session中
			super.session.setAttribute(SESSION_KEY_URLFLAG, strUrlFlag);

			// 从session中取得openid
			strOpenID = (String) super.session.getAttribute(SESSION_KEY_OPENID);
			// 从其它页面跳转过来时
			if (strOpenID == null || strOpenID.isEmpty()) {
				// 取得OpenID
				strOpenID = this.commonService.getOpenID(strUrlFlag, strCode);
			}

			// todo-zhangxd
			//strOpenID = "asdfasdfoo";

			// 未获取openid时
			if (strOpenID == null || strOpenID.equals("")) {
				logger.info("未获取到openid!");
				mv.addObject("errmsg", "未获取到openid!");
				mv.setViewName(WebConstantUrlValue.WEC_ERROR);
			} else {
				// 放到Session中
				super.session.setAttribute(SESSION_KEY_OPENID, strOpenID);
				logger.info("用户openid:" + strOpenID);

				// 是否注册
				boolean isRegister = this.commonService.isRegister(strUrlFlag,
						strOpenID);
				// 已注册时
				if (isRegister) {
					// 取得会员现有手机号
					String strPhoneNum = this.wec0060Service.getCurrentPhonum(
							strUrlFlag, strOpenID);
					// 手机号
					mv.addObject("oldphone", strPhoneNum);
					// 返回修改手机号页面
					mv.setViewName(WEC0060_VIEW);
				} else {
					// 返回注册页面
					mv.setViewName("wec_0010/wec_0010");
				}
			}
		} catch (Exception e) {
			logger.info("异常：\n" + e.getMessage());
			mv.addObject("errmsg", "打开页面时异常");
			mv.setViewName(WebConstantUrlValue.WEC_ERROR);
		}

		// 返回
		return mv;
	}

	/**
	 * 修改手机号
	 */
	@RequestMapping(value = WebConstantUrlValue.WEC0060_CHANGE_PHONE, method = RequestMethod.POST, produces = WebConstantValue.PRODUCE_TEXT)
	@ResponseBody
	public String change_phone(WEC0060View view) {
		logger.info("========================Controller change_phone Start==========================");

		BaseModel resultModel = new BaseModel();

		try {
			// openid
			view.setOpenid(super.session.getAttribute(SESSION_KEY_OPENID)
					.toString());
			// urlflag
			view.setUrlflag(super.session.getAttribute(SESSION_KEY_URLFLAG)
					.toString());

			// 调用修改密码的service
			resultModel = this.wec0060Service.change_phone(view);
		} catch (Exception e) {
			logger.info("========================Exception change_phone Start==========================");
			logger.info("修改手机号异常：\n" + e.getMessage());

			// 异常
			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller change_phone End==========================");

		// 返回
		return WebJsonUtil.bean2Json(resultModel);
	}
}
