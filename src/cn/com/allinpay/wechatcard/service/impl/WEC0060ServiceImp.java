package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.allinpay.frame.model.BaseModel;
import cn.com.allinpay.frame.model.BranchparametersForm;
import cn.com.allinpay.frame.model.CalculateinterestForm;
import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.cardUtil.AllinpayAPI;
import cn.com.allinpay.wechatcard.dao.WEC0021Dao;
import cn.com.allinpay.wechatcard.dao.WEC0060Dao;
import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
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
	private static final Logger logger = Logger.getLogger(WEC0060ServiceImp.class);

	/** 修改手机号dao **/
	@Autowired
	private WEC0060Dao wec0060Dao;

	@Autowired
	private WEC0021Dao wec_0021_Dao;

	@Autowired
	private ICommonService commonService;

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
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
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
		// 原手机号
		paramMap.put("oldphone", view.getOldphone());
		logger.info(view.toString());
		// 调用接口修改手机号 todo
		// 获取手机号对应的实体卡号
		String cardno = this.wec0060Dao.getCardnoFromDzcardno(paramMap);
		logger.info("cardno=" + cardno);
		if (cardno == null || "".equals(cardno)) {
			// 无实体卡号
			logger.info("无实体卡号");
			int result2 = wec0060Dao.updatePhoneNum(paramMap);
			resultModel.setState(WebConstantValue.HTTP_OK);
			resultModel.setMsg(WebConstantValue.CHANGE_PHONE_SUCCES);
			return resultModel;
		} else {
			// 有实体卡号时 总公司接口 1 接口2 更新
			Map<String, String> memberInfo = commonService.getMemberIDByOpenID(view.getOpenid());
			if (memberInfo == null || memberInfo.get("memberid") == null || "".equals(memberInfo.get("memberid"))) {
				// 如果根据openid获取会员的id，获取不到，提示用户。
				resultModel.setState(WebConstantValue.HTTP_ERROR);
				resultModel.setMsg(WebConstantValue.ADD_CARD_ERROR);
				return resultModel;
			}
			// 从数据库中读取数据
			Map<String, String> parameters = commonService.getParametersByMerchantid(memberInfo.get("merchantid"));
			if (parameters == null) {
				resultModel.setState(WebConstantValue.HTTP_ERROR);
				resultModel.setMsg(WebConstantValue.GET_MERCHANT_ERROR);
				return resultModel;
			}

			String orderid = commonService.getOrderIdByDual("");
			if (orderid == null) {
				resultModel.setState(WebConstantValue.HTTP_ERROR);
				resultModel.setMsg(WebConstantValue.GET_MERCHANT_ERROR);
				return resultModel;
			}
			BranchparametersForm _branchInfoform = new BranchparametersForm();
			_branchInfoform.setAppkey(parameters.get("appkey"));
			_branchInfoform.setAppsecret(parameters.get("appsecret"));
			_branchInfoform.setApiversion(parameters.get("apiversion"));
			_branchInfoform.setDeskey(parameters.get("deskey"));

			CalculateinterestForm unbunlForm = AllinpayAPI.unbundleCardAlias(cardno, view.getPasswd(),
					view.getOldphone(), orderid, _branchInfoform);
			if (unbunlForm.getReturn_message() == null || !"00".equals(unbunlForm.getReturn_message())) {
				// 如果根据openid获取会员的id，获取不到，提示用户。
				resultModel.setState(WebConstantValue.HTTP_ERROR);
				if (unbunlForm.getReturn_message() == null)
					resultModel.setMsg(WebConstantValue.OPEN_CARD_ERROR);
				else
					resultModel.setMsg(unbunlForm.getReturn_message());
				return resultModel;
			} else {
				// 解绑成功
				// 绑定新手机号
				CalculateinterestForm bunlForm = AllinpayAPI.bundleCardAlias(cardno, view.getPasswd(),
						view.getNewphone(), orderid, _branchInfoform);
				if (bunlForm.getReturn_message() == null || !"00".equals(bunlForm.getReturn_message())) {
					// 如果根据openid获取会员的id，获取不到，提示用户。
					resultModel.setState(WebConstantValue.HTTP_ERROR);
					if (bunlForm.getReturn_message() == null)
						resultModel.setMsg(WebConstantValue.OPEN_CARD_ERROR);
					else
						resultModel.setMsg(bunlForm.getReturn_message());
					return resultModel;
				} else {
					// 解绑成功 且绑定新手机号成功
					int result = wec0060Dao.updateDzcardno(paramMap);
					int result2 = wec0060Dao.updatePhoneNum(paramMap);
					logger.info("更新结果为：" + result);
					logger.info("更新结果2为：" + result2);
					resultModel.setState(WebConstantValue.HTTP_OK);
					resultModel.setMsg(WebConstantValue.CHANGE_PHONE_SUCCES);
				}
			}
		}
		logger.info("========================Service change_phone End==========================");
		return resultModel;
	}
}
