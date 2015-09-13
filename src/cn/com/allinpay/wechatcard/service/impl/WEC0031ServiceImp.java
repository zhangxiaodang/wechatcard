package cn.com.allinpay.wechatcard.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.model.BranchparametersForm;
import cn.com.allinpay.frame.model.CalculateinterestForm;
import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.JsonUtil;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.WebUtil;
import cn.com.allinpay.frame.util.cardUtil.AllinpayAPI;
import cn.com.allinpay.wechatcard.dao.WEC0031Dao;
import cn.com.allinpay.wechatcard.model.WEC0031Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0031Service;

/**
 * 
 * 会员卡信息serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0031ServiceImp extends BaseService implements IWEC0031Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0031ServiceImp.class);

	/** 注册的dao **/
	@Autowired
	private WEC0031Dao wec_0031_Dao;
	@Autowired
	private ICommonService commonService;

	/**
	 * 注册的service
	 */
	@Override
	public WEC0031Model get_card_info(String membercardid) throws Exception {
		logger.info("========================Service get_card_info Start==========================");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("merbercardid", membercardid);
		// 获取会员卡信息
		// 返回前台提示信息
		WEC0031Model resultModel = new WEC0031Model();
		Map<String, Object> card_info = wec_0031_Dao.get_card(paramMap);
		card_info = WebUtil.test_set_null_card_img_map(card_info);
		// 调用接口查询卡的余额 todo
		String merchantid = card_info.get("merchantid").toString();
		Map<String, String> parameters = commonService
				.getParametersByMerchantid(merchantid);
		if (parameters == null) {
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg(WebConstantValue.GET_MERCHANT_ERROR);
			return resultModel;
		}

		BranchparametersForm _branchInfoform = new BranchparametersForm();
		_branchInfoform.setAppkey(parameters.get("appkey"));
		_branchInfoform.setAppsecret(parameters.get("appsecret"));
		_branchInfoform.setApiversion(parameters.get("apiversion"));
		_branchInfoform.setDeskey(parameters.get("deskey"));
		String orderid = commonService.getOrderIdByDual("");
		if (orderid == null) {
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg(WebConstantValue.GET_MERCHANT_ERROR);
			return resultModel;
		}
		CalculateinterestForm calform = AllinpayAPI.getCardinfoNopassAPI(
				card_info.get("cardno").toString(), orderid, _branchInfoform);

		// 账户信息
		List<String> zhList = new ArrayList<String>();

		if (calform.getCardproductList().size() > 0) {

			for (int i = 0; i < calform.getCardproductList().size(); i++) {
				// 账户信息
				Map<String, Object> zhInfo = new HashMap<String, Object>();

				CalculateinterestForm temForm = (CalculateinterestForm) calform
						.getCardproductList().get(i);

				// 账户余额
				zhInfo.put("ye", temForm.getAccount_balance());
				// 产品号
				zhInfo.put("cph", temForm.getProduct_id());
				// 有效余额
				zhInfo.put("yxye", temForm.getValid_balance());

				// 增加
				zhList.add(JsonUtil.bean2Json(zhInfo));
			}

			// 此处应列表展示 账户 1 余额 账户2 余额 。。详情见低保真

			// 测试 应删掉
			CalculateinterestForm mfirstform = (CalculateinterestForm) calform
					.getCardproductList().get(0);
			String money = mfirstform.getAccount_balance();
			if ("".equals(money))
				money = "0.00";
			card_info.put("money", money);

		} else {// 新开的卡 没有 card_product_info_arrays --account_balance
			card_info.put("money", "0.00");
		}

		// ================测试数据 START================
		// Map<String, Object> zhInfo1 = new HashMap<String, Object>();
		// // 账户余额
		// zhInfo1.put("ye", "100.00");
		// // 产品号
		// zhInfo1.put("cph", "AAAA");
		// // 有效余额
		// zhInfo1.put("yxye", "99.00");
		// // 增加
		// zhList.add(JsonUtil.bean2Json(zhInfo1));
		// Map<String, Object> zhInfo2 = new HashMap<String, Object>();
		// // 账户余额
		// zhInfo2.put("ye", "800.00");
		// // 产品号
		// zhInfo2.put("cph", "BBBB");
		// // 有效余额
		// zhInfo2.put("yxye", "22.00");
		// // 增加
		// zhList.add(JsonUtil.bean2Json(zhInfo2));
		// ================测试数据 END================

		// 放到返回信息中
		card_info.put("zh", zhList);

		resultModel.setCard_info(card_info);

		resultModel.setState(WebConstantValue.HTTP_OK);

		logger.info("========================Service get_card_info End==========================");
		return resultModel;
	}
}
