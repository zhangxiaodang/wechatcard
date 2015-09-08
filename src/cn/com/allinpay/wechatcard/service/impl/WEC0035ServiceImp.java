package cn.com.allinpay.wechatcard.service.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.allinpay.frame.model.BranchparametersForm;
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
		logger.info("========================Service get_coupon Start==========================");
		// 返回前台提示信息
		WEC0034Model resultModel = new WEC0034Model();
		// 判断新密码和确认密码是否一致
		if (!memberView.getPassword().equals(memberView.getOldpassword())) {
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg(WebConstantValue.CHANGE_PASS_ERROR_1);
		}
		// 需要商家id merchantid======================
		// 根据merchantid读取总公司相关数据
		String merchantid = memberView.getMerchantid();
		Map<String, String> parameters = commonService
				.getParametersByMerchantid(merchantid);
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
		System.out.println("memberView.getCardno()===="
				+ memberView.getCardno());
		AllinpayAPI.changePasswordAPI(memberView.getCardno(),
				memberView.getOldpassword(), memberView.getPassword(), orderid,
				_branchInfoform);
		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.CHANGE_PASS_SUCCES);

		logger.info("========================Service get_coupon End==========================");
		return resultModel;
	}
}
