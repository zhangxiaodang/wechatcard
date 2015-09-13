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

	/** 会员卡图片 **/
	public static final String CARD_IMG = "resources/images/u5_normal.jpg";

	/** 条形码图片 **/
	public static final String TXM_IMG = "resources/images/txm.png";

	/** 二维码图片 **/
	public static final String EW_IMG = "resources/images/ewm.jpg";

	/** 优惠券图片图片 **/
	public static final String COUPON_IMG = "resources/images/u5_normal.jpg";

	/** http请求状态 000000成功 **/
	public static final String HTTP_OK = "000000";

	/** http请求状态 TS0004失败 **/
	public static final String HTTP_ERROR = "TS0004";

	/** 添加会员卡失败 **/
	public static final String ADD_CARD_ERROR = "对不起，您还不是会员，请注册后使用！";

	/** 开卡失败 **/
	public static final String OPEN_CARD_ERROR = "开卡失败！";

	/** 注册失败 **/
	public static final String GET_MERCHANT_ERROR = "对不起，您所在的商户状态异常！";

	/** 注册成功 **/
	public static final String REGISTER_SUCCESS = "恭喜您，注册成功！";

	/** 注册失败 **/
	public static final String LOGIN_ERROR = "对不起，注册失败，请刷新页面后重试！";

	/** 系统异常 **/
	public static final String SYS_ERROR = "系统异常，请刷新后重试。";

	/** produces. */
	public static final String PRODUCE_TEXT = "text/html;charset=UTF-8";

	/** 获取验证码成功 **/
	public static final String GET_YZM_SUCCESS = "验证码发送成功，请注意查收！";

	/** 获取验证码失败 **/
	public static final String GET_YZM_ERROR = "获取验证码失败！";

	/** 申请新卡成功 **/
	public static final String APPLY_CARD_SUCCESS = "申请新卡成功！";

	/** 申请新卡失败 **/
	public static final String APPLY_CARD_ERROR = "申请新卡失败！";
	public static final String BAND_CARD_ERROR = "绑定旧卡失败！";
	/** 修改密码成功 **/
	public static final String CHANGE_PASS_SUCCES = "修改密码成功！";
	/** 修改密码失败 **/
	public static final String CHANGE_PASS_ERROR = "修改密码失败！";
	/** 新密码和确认密码不一致 **/
	public static final String CHANGE_PASS_ERROR_1 = "新密码和确认密码不一致！";

	public static final String VERIFYMSG = "验证码为：";

	/** 修改手机号成功 **/
	public static final String CHANGE_PHONE_SUCCES = "手机号修改成功！";
	/** 修改手机号失败 **/
	public static final String CHANGE_PHONE_ERROR = "手机号修改失败！";

	/** 重新绑定成功 **/
	public static final String CHANGE_OPENID_SUCCES = "重新绑定成功！";
	/** 领取优惠券成功 **/
	public static final String COLLECT_SUCCESS = "领取成功！";
	/** 没有优惠券 **/
	public static final String NULL_COUPON = "亲，您没有未领取的优惠券奥！";
	/** 商家没有优惠券 **/
	public static final String NULL_MERCHANTCOUPON = "亲，您没有优惠券奥！";
	/** 商家优惠券不存在 **/
	public static final String NULL_MERCHANTCOUPON_CAP = "亲，优惠券已经下架了奥！";
	/** 用户没有消费记录 **/
	public static final String NULL_CONSUME = "亲，您没有消费记录奥！";
	/** 用户没有充值记录 **/
	public static final String NULL_RECHARGE = "亲，您还没有充值过奥！";

	// 优惠券状态--未领用
	public static final String WLY = "00";
	// 优惠券状态--已领用
	public static final String YLY = "01";
	// 优惠券状态--已使用
	public static final String YSY = "02";
	// 优惠券状态--已过期
	public static final String YGQ = "03";

	// 优惠券类别--现金券
	public static final String XJQ = "00";
	// 优惠券状态--折扣券
	public static final String ZKQ = "01";
	// 优惠券状态--实物券
	public static final String SWQ = "02";
}
