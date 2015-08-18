package cn.com.allinpay.wechatcard.view;

import cn.com.allinpay.frame.view.BaseView;

/**
 * 修改手机号view.
 */
public class WEC0060View extends BaseView {

	/**
	 * 新手机号
	 */
	private String newphone = "";

	/**
	 * 验证码.
	 */
	private String yzm = "";

	/**
	 * openid.
	 */
	private String openid = "";

	/**
	 * 商户标识.
	 */
	private String urlflag = "";

	public String getNewphone() {
		return newphone;
	}

	public void setNewphone(String newphone) {
		this.newphone = newphone;
	}

	public String getYzm() {
		return yzm;
	}

	public void setYzm(String yzm) {
		this.yzm = yzm;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUrlflag() {
		return urlflag;
	}

	public void setUrlflag(String urlflag) {
		this.urlflag = urlflag;
	}
}
