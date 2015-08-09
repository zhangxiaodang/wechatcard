package cn.com.allinpay.wechatcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.allinpay.frame.controller.BaseController;
import cn.com.allinpay.frame.util.WebConstantUrlValue;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.WebJsonUtil;
import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.service.WEC0010Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;
/**
 * Copyright(C) JiNanShangJie 2014.1.2
 * 
 * 会员注册controller
 * 
 * @author 张振峰 2014/10/29.
 * 
 * @version V1.00.
 * 
 *          更新履历： V1.00 2014/10/29 张振峰 创建.
 */
@Controller
public class WEC0010Controller extends BaseController{
	
	/** 登陆的service **/
	@Autowired
	private WEC0010Service registerService;
	
	@RequestMapping(value = WebConstantUrlValue.REGISTER, produces = WebConstantValue.PRODUCE_TEXT, method = RequestMethod.GET)
	@ResponseBody
	public String login(WEC0010View memberView){
		logger.info("========================Controller register Start==========================");
		logger.info(memberView);
		WEC0010Model resultModel = new WEC0010Model();
		try {
			memberView.setMemberid(getUUID());
			//验证用户名密码
			resultModel = registerService.regist(memberView);
		} catch (Exception e) {
			logger.info("========================Exception register Start==========================");
			e.printStackTrace();
			
			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller register End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
	
	@RequestMapping(value = WebConstantUrlValue.GETYZM, produces = WebConstantValue.PRODUCE_TEXT, method = RequestMethod.GET)
	@ResponseBody
	public String getYzm(WEC0010View memberView){
		logger.info("========================Controller getYzm Start==========================");
		logger.info(memberView);
		WEC0010Model resultModel = new WEC0010Model();
		try {
			memberView.setMemberid(getUUID());
			//验证用户名密码
			resultModel = registerService.getYzm(memberView);
		} catch (Exception e) {
			logger.info("========================Exception getYzm Start==========================");
			e.printStackTrace();
			
			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller getYzm End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
