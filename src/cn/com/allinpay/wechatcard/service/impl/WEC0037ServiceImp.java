package cn.com.allinpay.wechatcard.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.model.WEC0037Model;
import cn.com.allinpay.wechatcard.service.IWEC0037Service;
import cn.com.allinpay.wechatcard.view.WEC0037View;

/**
 * 消费记录查询页面ServiceImp.
 */
@Service
public class WEC0037ServiceImp extends BaseService implements IWEC0037Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0037ServiceImp.class);

	@Override
	public WEC0037Model checkPasswd(WEC0037View view) throws Exception {

		// 返回
		WEC0037Model result = new WEC0037Model();

		// 成功
		result.setState(WebConstantValue.HTTP_OK);
		result.setMsg("成功!!");

		// 返回
		return result;
	}

}
