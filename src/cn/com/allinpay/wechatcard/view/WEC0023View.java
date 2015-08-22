package cn.com.allinpay.wechatcard.view;

import cn.com.allinpay.frame.view.BaseView;

/**
 * 
 * 重新绑定view.
 * 
 * @version V1.00.
 * 
 */
public class WEC0023View extends BaseView{
	
	/**
	 * 会员手机号
	 */
	private String memberphone = "";
	
	/**
	 * 会员所在商家的id
	 * @return
	 */
	private String merchantid = "";
	
	public String getMemberphone() {
		return memberphone;
	}

	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}

	public String getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}
	
}
