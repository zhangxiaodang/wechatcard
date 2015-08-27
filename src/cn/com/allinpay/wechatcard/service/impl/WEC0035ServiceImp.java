package cn.com.allinpay.wechatcard.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.dao.WEC0035Dao;
import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.service.IWEC0035Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 
 * 会员卡修改密码serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0035ServiceImp extends BaseService implements IWEC0035Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0035ServiceImp.class);

	/** 会员卡修改密码dao **/
	@Autowired
	private WEC0035Dao wec_0035_Dao;

	/**
	 * 卡密码修改的service
	 */
	@Override
	public WEC0034Model change_pass(WEC0010View memberView) throws Exception {
		logger.info("========================Service get_coupon Start==========================");
		// 返回前台提示信息
		WEC0034Model resultModel = new WEC0034Model();
		// 判断新密码和确认密码是否一致
		if (!memberView.getPassword().equals(memberView.getOldpassword())){
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg(WebConstantValue.CHANGE_PASS_ERROR_1);
		}
		// 调用接口修改密码   todo
		
		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.CHANGE_PASS_SUCCES);

		logger.info("========================Service get_coupon End==========================");
		return resultModel;
	}
}
