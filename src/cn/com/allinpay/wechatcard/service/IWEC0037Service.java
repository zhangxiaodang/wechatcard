package cn.com.allinpay.wechatcard.service;

import cn.com.allinpay.wechatcard.model.WEC0037Model;
import cn.com.allinpay.wechatcard.view.WEC0037View;

/**
 * 消费记录查询页面Service.
 */
public interface IWEC0037Service {

	public WEC0037Model checkPasswd(WEC0037View view) throws Exception;
}
