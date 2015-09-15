package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0038Model;
import cn.com.allinpay.wechatcard.view.WEC0038View;

/**
 * 充值记录查询页面Service.
 */
public interface IWEC0038Service {

	public WEC0038Model checkPasswd(WEC0038View view) throws Exception;
}
