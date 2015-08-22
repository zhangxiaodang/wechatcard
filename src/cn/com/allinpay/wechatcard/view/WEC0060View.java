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

}
