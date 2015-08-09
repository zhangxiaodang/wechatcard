package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.dao.WEC0010Dao;
import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.service.WEC0010Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * Copyright(C) JiNanShangJie 2014.
 * 
 * 注册serviceImp
 * 
 * @author 张振峰 2015/08/09.
 * 
 * @version V1.00.
 * 
 *          更新履历： V1.00 2015/08/09 张振峰 创建.
 */
@Service
public class WEC0010ServiceImp extends BaseService implements WEC0010Service {
	
	/** logger **/
	private static final Logger logger = Logger.getLogger(WEC0010ServiceImp.class);
	
	/** 注册的dao **/
	@Autowired
	private WEC0010Dao wec_001_Dao;
	
	/**
	 * 注册的service
	 */
	@Override
	public WEC0010Model regist(WEC0010View memberView) throws Exception{
		logger.info("========================Service regist Start==========================");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BEAN, memberView);
		// 将用户信息添加到会员表中
		wec_001_Dao.regist(paramMap);
		// 返回前台提示信息
		WEC0010Model resultModel = new WEC0010Model();
		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.REGISTER_SUCCESS);
		
		logger.info("========================Service regist End==========================");
		return resultModel;
	}
	
	/**
	 * 获取验证码service
	 */
	@Override
	public WEC0010Model getYzm(WEC0010View memberView) throws Exception {
		logger.info("========================Service getYzm Start==========================");
		// TODO Auto-generated method stub
		// 调用通联接口返回验证码，这里先todo
		
		WEC0010Model resultModel = new WEC0010Model();
		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.GET_YZM_SUCCESS);
		resultModel.setYzm("4rba");
		
		logger.info("========================Service getYzm End==========================");
		return resultModel;
	}
	
}
