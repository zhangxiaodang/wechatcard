package cn.com.allinpay.wechatcard.service.impl;

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
import cn.com.allinpay.wechatcard.dao.WEC0035Dao;
import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
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
	@Autowired
	private ICommonService commonService;

	/**
	 * 卡密码修改的service
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public WEC0034Model change_pass(WEC0010View memberView) throws Exception {
		logger.info("========================Service change_pass Start==========================");
		// 返回前台提示信息
		WEC0034Model resultModel = new WEC0034Model();
		// 判断新密码和确认密码是否一致
		if (!memberView.getPassword().equals(memberView.getOldpassword())) {
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg(WebConstantValue.CHANGE_PASS_ERROR_1);
		}
		Map<String, String> memberInfo = commonService
				.getMemberIDByOpenID(memberView.getMemberopenid());
		if (memberInfo == null || memberInfo.get("memberid") == null
				|| "".equals(memberInfo.get("memberid"))) {
			// 如果根据openid获取会员的id，获取不到，提示用户。
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg(WebConstantValue.ADD_CARD_ERROR);
			return resultModel;
		}
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
		CalculateinterestForm caForm = AllinpayAPI.changePasswordAPI(memberView.getCardno(),
				memberView.getOldpassword(), memberView.getPassword(), orderid,
				_branchInfoform);
		if (caForm.getReturn_message()== null
				|| !"00".equals(caForm.getReturn_message())) {
			// 如果根据openid获取会员的id，获取不到，提示用户。
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			if (caForm.getReturn_message() == null)
				resultModel.setMsg(WebConstantValue.OPEN_CARD_ERROR);
			else
				resultModel.setMsg(caForm.getReturn_message());
			return resultModel;
		}
		
		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.CHANGE_PASS_SUCCES);

		logger.info("========================Service change_pass End==========================");
		return resultModel;
	}
}
