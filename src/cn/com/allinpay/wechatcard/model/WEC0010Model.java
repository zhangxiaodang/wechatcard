package cn.com.allinpay.wechatcard.model;

import cn.com.allinpay.frame.model.BaseModel;

/**
 * Copyright(C) JiNanShangJie 2014.
 * 
 * 会员Model.
 * 
 * @author 张振峰 2015/08/09.
 * 
 * @version V1.00.
 * 
 *          更新履历： V1.00 2015/08/09 张振峰 创建.
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
