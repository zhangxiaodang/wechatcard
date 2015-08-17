package cn.com.allinpay.frame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;

import cn.com.allinpay.frame.model.BaseModel;
import cn.com.allinpay.frame.util.WebConstantValue;

/**
 * 
 * BaseController
 * 
 * @version V1.00.
 * 
 */
public class BaseController {

	/** logger. */
	protected Logger logger;

	/** HttpServletRequest. */
	protected HttpServletRequest request;

	/** HttpServletResponse. */
	protected HttpServletResponse response;

	/** HttpSession. */
	protected HttpSession session;

	/** 网页授权code. */
	protected static final String KEY_CODE = "code";

	/** URL标识. */
	protected static final String KEY_URL_FLAG = "urlflag";

	/** Session中的username KEY. */
	protected static final String SESSION_KEY_OPENID = "openid";

	/** Session中的urlflag KEY. */
	protected static final String SESSION_KEY_URLFLAG = "urlfalg";

	/**
	 * 设置基本对象.
	 * 
	 * @param request
	 *            HttpServletRequest.
	 * 
	 * @param response
	 *            HttpServletResponse.
	 */
	@ModelAttribute
	private void setContextValue(HttpServletRequest request,
			HttpServletResponse response) {

		// request
		this.request = request;
		// response
		this.response = response;
		// session
		this.session = request.getSession(true);
		// logger
		this.logger = Logger.getLogger(this.getClass());

	}

	/**
	 * 从Request中取得IP.
	 * 
	 * @return 取得访问者IP.
	 */
	protected String getRemoteAddress() {

		return this.request.getRemoteAddr().toString();
	}

	/**
	 * 取得webApp的绝对路径.
	 * 
	 * @return webApp的绝对路径.
	 */
	protected String getWebRootPath() {

		return this.request.getServletPath();
	}

	/**
	 * 设置controller返回异常的信息
	 */
	protected BaseModel getSysErrorModel() {

		// 创建返回的model
		BaseModel model = new BaseModel();

		// 设置系统提示信息错误
		model.setMsg(WebConstantValue.SYS_ERROR);
		model.setState(WebConstantValue.HTTP_ERROR);

		// 返回
		return model;
	}
}
