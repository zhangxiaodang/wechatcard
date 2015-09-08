package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.allinpay.frame.model.BranchparametersForm;
import cn.com.allinpay.frame.model.Yufuka;
import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.cardUtil.AllinpayAPI;
import cn.com.allinpay.wechatcard.dao.WEC0021Dao;
import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0021Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;
import cn.com.allinpay.wechatcard.view.WEC0021View;

/**
 * 注册serviceImp
 */
@Service
public class WEC0021ServiceImp extends BaseService implements IWEC0021Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0021ServiceImp.class);

	/** 注册的dao **/
	@Autowired
	private WEC0021Dao wec_0021_Dao;

	@Autowired
	private ICommonService commonService;

	/**
	 * 注册的service
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public WEC0010Model applyNewCard(WEC0010View memberView) throws Exception {
		logger.info("========================Service applyNewCard Start==========================");

		// 返回前台提示信息
		WEC0010Model resultModel = new WEC0010Model();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 会员卡信息
		WEC0021View wec0021View = new WEC0021View();
		// 申请新卡的密码
		wec0021View.setPassword(memberView.getPassword());
		// 调用总公司的预付卡后台电子卡开卡接口，进行开卡
		// todo
		Map<String, String> memberInfo = commonService
				.getMemberIDByOpenID(memberView.getMemberopenid());
		if (memberInfo == null || memberInfo.get("memberid") == null
				|| "".equals(memberInfo.get("memberid"))) {
			// 如果根据openid获取会员的id，获取不到，提示用户。
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg(WebConstantValue.ADD_CARD_ERROR);
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
		Yufuka yufuka = new Yufuka();
		BranchparametersForm _branchInfoform = new BranchparametersForm();
		_branchInfoform.setAppkey(parameters.get("appkey"));
		_branchInfoform.setAppsecret(parameters.get("appsecret"));
		_branchInfoform.setApiversion(parameters.get("apiversion"));
		_branchInfoform.setDeskey(parameters.get("deskey"));
		yufuka.setBrh_id(parameters.get("branchcode"));
		yufuka.setBrand_no(parameters.get("branchno"));
		yufuka.setChan_no(parameters.get("channo"));
		yufuka.setPhone_num(memberView.getMemberphone());
		yufuka.setPassword(memberView.getPassword());
		yufuka.setOrder_id(orderid);

		yufuka = AllinpayAPI.openaccount(yufuka, _branchInfoform);
		if (yufuka.getReturnMsg() == null
				|| !"00".equals(yufuka.getReturnMsg())) {
			// 如果根据openid获取会员的id，获取不到，提示用户。
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			if (yufuka.getReturnMsg() == null)
				resultModel.setMsg(WebConstantValue.OPEN_CARD_ERROR);
			else
				resultModel.setMsg(yufuka.getReturnMsg());
			return resultModel;
		}
		// 更新本地会员卡的信息
		wec0021View.setMerbercardid(yufuka.getOrder_id());
		// 会员ID 这个地方的需要从session中获取会员的id。
		wec0021View.setMemberid(memberInfo.get("memberid"));
		// 商家ID
		wec0021View.setMerchantid(memberInfo.get("merchantid"));
		// 会员卡号（预付卡系统后台实体卡号）
		wec0021View.setCardno(yufuka.getCard_id());
		// 电子卡号（预付卡系统后台电子卡号），申请新卡时电子卡号为手机号
		wec0021View.setDzcardno(yufuka.getPhone_num());
		// 会员卡等级
		wec0021View.setCardgrade("");
		// 会员卡二维码信息
		wec0021View.setCardcode("");
		// 卡状态
		wec0021View.setCardstat("");
		// 申请会员卡方式（申请新卡或绑定旧卡)
		wec0021View.setCardmode("01");
		// 会员卡名称
		wec0021View.setCardname("优惠金卡");
		// 会员卡图片
		wec0021View.setMerbercardimg(WebConstantValue.CARD_IMG);

		paramMap.put(BEAN, wec0021View);
		// 生成本地的会员卡号
		wec_0021_Dao.add_card(paramMap);
		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.APPLY_CARD_SUCCESS);
		resultModel.setMembercardid(wec0021View.getMerbercardid());
		logger.info("========================Service applyNewCard End==========================");
		return resultModel;
	}
}
