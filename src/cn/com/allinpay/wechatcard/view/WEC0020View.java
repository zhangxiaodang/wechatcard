package cn.com.allinpay.wechatcard.view;

import cn.com.allinpay.frame.view.BaseView;

/**
 * 
 * 会员卡view.
 * 
 * @version V1.00.
 * 
 */
public class WEC0020View extends BaseView{
	
	/**
	 * openid
	 */
	private String openid = "";
	/**
	 * 会员手机号
	 */
	private String memberphone = "";
	/**
	 * urlflag，表示不同商家
	 */
	private String urlflag = "";
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getMemberphone() {
		return memberphone;
	}
	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}
	public String getUrlflag() {
		return urlflag;
	}
	public void setUrlflag(String urlflag) {
		this.urlflag = urlflag;
	}
}
