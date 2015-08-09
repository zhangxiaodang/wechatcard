package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * Copyright(C) JiNanShangJie 2014.
 * 
 * 登录service
 * 
 * @author 张振峰 2014/10/29.
 * 
 * @version V1.00.
 * 
 *          更新履历： V1.00 2014/10/29 张振峰 创建.
 */
public interface WEC0010Service {
	
	/**
	 * 注册的service
	 * @param memberView
	 * @return
	 */
	public WEC0010Model regist(WEC0010View memberView) throws Exception;
	
	/**
	 * 获取验证码service
	 * @param memberView
	 * @return
	 */
	public WEC0010Model getYzm(WEC0010View memberView) throws Exception;
}
