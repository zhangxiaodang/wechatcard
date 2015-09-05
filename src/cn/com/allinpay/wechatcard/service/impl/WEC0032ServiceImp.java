package cn.com.allinpay.wechatcard.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.model.WEC0032Model;
import cn.com.allinpay.wechatcard.service.IWEC0032Service;
import cn.com.allinpay.wechatcard.view.WEC0032View;

/**
 * 我要充值serviceImp.
 */

@Service
public class WEC0032ServiceImp extends BaseService implements IWEC0032Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0032ServiceImp.class);

	@Override
	public WEC0032Model chongzhi_ser(WEC0032View view) throws Exception {

		logger.info("========================Service chongzhi_ser Start==========================");

		// 返回前台提示信息
		WEC0032Model resultModel = new WEC0032Model();

		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.CHANGE_PHONE_SUCCES);

		logger.info("========================Service chongzhi_ser End==========================");

		// 返回
		return resultModel;
	}
}
