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
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0010Service;
import cn.com.allinpay.wechatcard.service.IWEC0021Service;
import cn.com.allinpay.wechatcard.service.IWEC0022Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;

/**
 * 
 * 注册serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0010ServiceImp extends BaseService implements IWEC0010Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0010ServiceImp.class);

	/** 注册的dao **/
	@Autowired
	private WEC0010Dao wec_001_Dao;

	/** 共通Service. */
	@Autowired
	private ICommonService commonService;

	/** 开通新卡的service **/
	@Autowired
	private IWEC0021Service wec0021Service;

	/** 绑定新卡的service **/
	@Autowired
	private IWEC0022Service wec0022Service;

	/**
	 * 注册的service
	 */
	@Override
	public WEC0010Model regist(WEC0010View memberView) throws Exception {
		logger.info("========================Service regist Start==========================");

		// 返回前台提示信息
		WEC0010Model resultModel = new WEC0010Model();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put(BEAN, memberView);
		// 判断用户的手机号是否注册过
		int count = wec_001_Dao.phone_is_regist(paramMap);
		if (count > 0) {
			resultModel.setMember_phone(memberView.getMemberphone());
			// 标识成该手机好已被注册
			resultModel.setPhone_is_regist(true);
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg(WebConstantValue.GET_MERCHANT_ERROR);
			return resultModel;
		}
		// 根据urlFlag查询商户的id
		Map<String, String> merchantInfo = commonService
				.getMerchantInfoByUrlFlag(memberView.getUrlflag());
		// 如果没有商户信息，则提示用户
		if (merchantInfo == null || "".equals(merchantInfo.get("merchantid"))) {
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg(WebConstantValue.GET_MERCHANT_ERROR);
			return resultModel;
		}
		// 会员级别
		memberView.setMembergrade("01");
		memberView.setMerchantid(merchantInfo.get("merchantid"));

		Map<String, Object> paramMap1 = new HashMap<String, Object>();
		paramMap1.put(BEAN, memberView);
		// 将用户信息添加到会员表中
		wec_001_Dao.regist(paramMap1);

		// 判断用户是注册新的卡还是绑定旧卡
		if ("01".equals(memberView.getCardmode())) {
			// 开通新卡
			resultModel = wec0021Service.applyNewCard(memberView);
		} else if ("02".equals(memberView.getCardmode())) {
			// 绑定旧卡
			resultModel = wec0022Service.bindingOldCard(memberView);
		}
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
