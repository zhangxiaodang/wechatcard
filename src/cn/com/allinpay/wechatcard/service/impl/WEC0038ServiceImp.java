package cn.com.allinpay.wechatcard.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.model.WEC0038Model;
import cn.com.allinpay.wechatcard.service.IWEC0038Service;
import cn.com.allinpay.wechatcard.view.WEC0038View;

/**
 * 充值记录查询ServiceImp.
 */
@Service
public class WEC0038ServiceImp extends BaseService implements IWEC0038Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0038ServiceImp.class);

	@Override
	public WEC0038Model checkPasswd(WEC0038View view) throws Exception {

		// 返回
		WEC0038Model result = new WEC0038Model();

		// 成功
		result.setState(WebConstantValue.HTTP_OK);
		result.setMsg("成功!!");

		// 返回
		return result;
	}

}
