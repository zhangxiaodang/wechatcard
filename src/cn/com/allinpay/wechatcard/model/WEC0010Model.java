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
	
	// 标识手机号是否已经在该商户下注册过了
	private boolean phone_is_regist = false;

	public String getYzm() {
		return yzm;
	}

	public void setYzm(String yzm) {
		this.yzm = yzm;
	}

	public boolean isPhone_is_regist() {
		return phone_is_regist;
	}

	public void setPhone_is_regist(boolean phone_is_regist) {
		this.phone_is_regist = phone_is_regist;
	}

}
