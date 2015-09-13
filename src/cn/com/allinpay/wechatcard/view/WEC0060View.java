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
	 * 原手机号
	 */
	private String oldphone = "";
	
	/**
	 * 卡密码
	 */
	private String password = "";

	/**
	 * 验证码.
	 */
	private String yzm = "";

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOldphone() {
		return oldphone;
	}

	public void setOldphone(String oldphone) {
		this.oldphone = oldphone;
	}

}
