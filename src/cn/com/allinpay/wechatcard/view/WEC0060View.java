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
	private String passwd = "";

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

	 

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getOldphone() {
		return oldphone;
	}

	public void setOldphone(String oldphone) {
		this.oldphone = oldphone;
	}

	@Override
	public String toString() {
		return "WEC0060View [newphone=" + newphone + ", oldphone=" + oldphone + ", password=" + passwd + ", yzm="
				+ yzm + "]";
	}

}
