package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.allinpay.frame.model.BranchparametersForm;
import cn.com.allinpay.frame.model.CalculateinterestForm;
import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.cardUtil.AllinpayAPI;
import cn.com.allinpay.wechatcard.dao.WEC0022Dao;
import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0022Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;
import cn.com.allinpay.wechatcard.view.WEC0021View;

/**
 * 
 * 绑定旧卡serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0022ServiceImp extends BaseService implements IWEC0022Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0022ServiceImp.class);

	/** 注册的dao **/
	@Autowired
	private WEC0022Dao wec_0022_Dao;

	@Autowired
	private ICommonService commonService;

	/**
	 * 注册的service
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public WEC0010Model bindingOldCard(WEC0010View memberView) throws Exception {
		logger.info("========================Service bindingOldCard Start==========================");

		// 返回前台提示信息
		WEC0010Model resultModel = new WEC0010Model();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 会员卡信息
		WEC0021View wec0021View = new WEC0021View();
		// 调用总公司的预付卡后台电子卡开卡接口，进行开卡
		Map<String, String> memberInfo = commonService
				.getMemberIDByOpenID(memberView.getMemberopenid());
		if (memberInfo == null || memberInfo.get("memberid") == null
				|| "".equals(memberInfo.get("memberid"))) {
			// 如果根据openid获取会员的id，获取不到，提示用户。
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg(WebConstantValue.ADD_CARD_ERROR);
			return resultModel;
		}

		// 如果该卡号已注册过提示已注册
		Map<String, String> param = new HashMap<String, String>();
		// 会员ID
		param.put("memberid", memberInfo.get("memberid"));
		// 卡号
		param.put("cardno", memberView.getCardno());
		int intResult = this.wec_0022_Dao.getCardNoCnt(param);
		if (intResult > 0) {
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg("该卡号已绑定！");
			return resultModel;
		}

		// 从数据库中读取数据
		Map<String, String> parameters = commonService
				.getParametersByMerchantid(memberInfo.get("merchantid"));
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

		CalculateinterestForm cForm = AllinpayAPI.getCardinfoNopassAPI(
				memberView.getCardno(), orderid, _branchInfoform);
		// 旧卡 查询失败 或者不存在该卡时
		if (cForm.getReturn_message() == null
				|| !"00".equals(cForm.getReturn_message())) {
			// 如果根据openid获取会员的id，获取不到，提示用户。
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			if (cForm.getReturn_message() == null)
				resultModel.setMsg(WebConstantValue.BAND_CARD_ERROR);
			else
				resultModel.setMsg(cForm.getReturn_message());
			return resultModel;
		}

		// 更新本地会员卡的信息
		wec0021View.setMerbercardid(orderid);
		// 会员ID 这个地方的需要从session中获取会员的id。
		wec0021View.setMemberid(memberInfo.get("memberid"));
		// 商家ID
		wec0021View.setMerchantid(memberInfo.get("merchantid"));
		// 会员卡号（预付卡系统后台实体卡号）
		wec0021View.setCardno(memberView.getCardno());
		// 电子卡号（预付卡系统后台电子卡号），新申请卡时为手机号，绑定旧卡时为卡号
		wec0021View.setDzcardno(memberView.getCardno());
		// 会员卡等级
		wec0021View.setCardgrade("");
		// 会员卡二维码信息
		wec0021View.setCardcode("");
		// 卡状态
		wec0021View.setCardstat("");
		// 申请会员卡方式（申请新卡或绑定旧卡)
		wec0021View.setCardmode("02");
		// 会员卡名称
		wec0021View.setCardname("优惠金卡");
		// 会员卡图片
		wec0021View.setMerbercardimg(WebConstantValue.CARD_IMG);

		paramMap.put(BEAN, wec0021View);
		// 生成本地的会员卡号
		wec_0022_Dao.binding_card(paramMap);
		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.APPLY_CARD_SUCCESS);
		resultModel.setMembercardid(wec0021View.getMerbercardid());
		logger.info("========================Service bindingOldCard End==========================");
		return resultModel;
	}
}
