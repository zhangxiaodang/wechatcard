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
import cn.com.allinpay.wechatcard.view.WEC0060View;

/**
 * 
 * 修改手机号serviceImp
 * 
 */

@Service
public class WEC0060ServiceImp extends BaseService implements IWEC0060Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0060ServiceImp.class);

	/** 修改手机号dao **/
	@Autowired
	private WEC0060Dao wec0060Dao;

	@Override
	public String getCurrentPhonum(String merchantflag, String opendid) {
		logger.info("========================Service getCurrentPhonum Start==========================");

		// 手机号
		String strPhoneNum = "";

		// 查询参数
		Map<String, String> paramMap = new HashMap<String, String>();
		// urlflag
		paramMap.put("urlflag", merchantflag);
		// openid
		paramMap.put("openid", opendid);
		// 调用SQL
		strPhoneNum = this.wec0060Dao.getCurrentPhoneNum(paramMap);
		logger.info("会员手机号为:" + strPhoneNum);

		logger.info("========================Service getCurrentPhonum End==========================");
		// 返回
		return strPhoneNum;
	}

	@Override
	public BaseModel change_phone(WEC0060View view) throws Exception {
		logger.info("========================Service change_phone Start==========================");

		// 返回前台提示信息
		WEC0034Model resultModel = new WEC0034Model();

		// 参数
		Map<String, String> paramMap = new HashMap<String, String>();
		// openid
		paramMap.put("openid", view.getOpenid());
		// urlflag
		paramMap.put("urlflag", view.getUrlflag());
		// 新手机号
		paramMap.put("newphone", view.getNewphone());

		// 调用接口修改手机号 todo
		int result = wec0060Dao.updatePhoneNum(paramMap);
		logger.info("更新结果为：" + result);

		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.CHANGE_PHONE_SUCCES);

		logger.info("========================Service change_phone End==========================");

		// 返回
		return resultModel;
	}
}
