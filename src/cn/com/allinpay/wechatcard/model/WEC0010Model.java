package cn.com.allinpay.wechatcard.model;

import cn.com.allinpay.frame.model.BaseModel;

/**
 * 
 * 会员Model.
 * 
 * @version V1.00.
 * 
 */
public class WEC0010Model extends BaseModel{
	// 验证码
	private String yzm = "";

	public String getYzm() {
		return yzm;
	}

	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
}
