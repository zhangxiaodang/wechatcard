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
import cn.com.allinpay.frame.util.WebUtil;
import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.service.IWEC0010Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;
/**
 * 
 * 会员注册controller
 * 
 * @version V1.00.
 * 
 **/
@Controller
public class WEC0010Controller extends BaseController{
	
	/** 登陆的service **/
	@Autowired
	private IWEC0010Service registerService;
	
	@RequestMapping(value = WebConstantUrlValue.REGISTER, produces = WebConstantValue.PRODUCE_TEXT, method = RequestMethod.POST)
	@ResponseBody
	public String login(WEC0010View memberView){
		logger.info("========================Controller register Start==========================");
		logger.info(memberView);
		WEC0010Model resultModel = new WEC0010Model();
		try {
			memberView.setMemberid(WebUtil.getUUID());
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
	
	@RequestMapping(value = WebConstantUrlValue.GETYZM, produces = WebConstantValue.PRODUCE_TEXT, method = RequestMethod.POST)
	@ResponseBody
	public String getYzm(WEC0010View memberView){
		logger.info("========================Controller getYzm Start==========================");
		logger.info(memberView);
		WEC0010Model resultModel = new WEC0010Model();
		try {
			//验证用户名密码
			resultModel = registerService.getYzm(memberView);
		} catch (Exception e) {
			logger.info("========================Exception  getYzm Start==========================");
			e.printStackTrace();
			
			return WebJsonUtil.bean2Json(getSysErrorModel());
		}
		logger.info("========================Controller getYzm End==========================");
		return WebJsonUtil.bean2Json(resultModel);
	}
}
