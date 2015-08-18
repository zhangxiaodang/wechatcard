package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.model.BaseModel;
import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.dao.WEC0060Dao;
import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.service.IWEC0060Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 
 * 修改手机号serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0060ServiceImp extends BaseService implements IWEC0060Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0060ServiceImp.class);

	/** 修改手机号dao **/
	@Autowired
	private WEC0060Dao wec_0036_Dao;

	/**
	 * 修改手机号service
	 */
	@Override
	public BaseModel change_phone(WEC0010View memberView) throws Exception {
		
		memberView.setMemberid("0612db1f7f744b1ba11cf9b136381e29");
		logger.info("========================Service change_phone Start==========================");
		// 返回前台提示信息
		WEC0034Model resultModel = new WEC0034Model();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BEAN, memberView);
		// 调用接口修改手机号   todo
		wec_0036_Dao.change_phone(paramMap);
		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.CHANGE_PHONE_SUCCES);

		logger.info("========================Service change_phone End==========================");
		return resultModel;
	}
}
