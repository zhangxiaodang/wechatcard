package cn.com.allinpay.frame.util;


/**
 * 
 * 常量类
 * 
 * 
 * @version V1.00.
 * 
 */
public class WebConstantValue {
	
	/** 空字符串 **/
	public static final String EMPTY = ""; 
	
	/** Session中的username KEY. */
	public static final String SESSION_KEY_USERNAME = "username";
	
	/** http请求状态  000000成功 **/
	public static final String HTTP_OK = "000000";
	
	/** http请求状态  TS0004失败 **/
	public static final String HTTP_ERROR = "TS0004";
	
	/** 添加会员卡失败 **/
	public static final String ADD_CARD_ERROR = "对不起，您还不是会员，请注册后使用！";
	/** 注册成功 **/
	public static final String REGISTER_SUCCESS = "恭喜您，注册成功！";
	
	/** 注册失败 **/
	public static final String LOGIN_ERROR = "对不起，注册失败，请刷新页面后重试！";
	
	/** 系统异常 **/
	public static final String SYS_ERROR = "系统异常，请刷新后重试。";
	
	/** produces. */
	public static final String PRODUCE_TEXT = "text/html;charset=UTF-8";
	
	/** 获取验证码成功 **/
	public static final String GET_YZM_SUCCESS = "获取验证码成功！";
	
	/** 获取验证码失败 **/
	public static final String GET_YZM_ERROR = "获取验证码失败！";
	
	/** 申请新卡成功 **/
	public static final String APPLY_CARD_SUCCESS = "申请新卡成功！";
	
	/** 申请新卡失败 **/
	public static final String APPLY_CARD_ERROR = "申请新卡失败！";
	/** 修改密码成功 **/
	public static final String CHANGE_PASS_SUCCES = "修改密码成功！";
	/** 修改密码失败 **/
	public static final String CHANGE_PASS_ERROR = "修改密码失败！";
	/** 新密码和确认密码不一致 **/
	public static final String CHANGE_PASS_ERROR_1 = "新密码和确认密码不一致！";
	

	/** 修改手机号成功 **/
	public static final String CHANGE_PHONE_SUCCES = "修改手机号成功！";
	/** 修改手机号失败 **/
	public static final String CHANGE_PHONE_ERROR = "修改手机号失败！";
}
