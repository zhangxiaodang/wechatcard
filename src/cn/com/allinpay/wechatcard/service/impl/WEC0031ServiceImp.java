package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.model.BranchparametersForm;
import cn.com.allinpay.frame.model.CalculateinterestForm;
import cn.com.allinpay.frame.service.BaseService;
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
		// 调用接口查询卡的余额  todo
		String merchantid = card_info.get("merchantid").toString();
		Map<String, String> parameters = commonService.getParametersByMerchantid(merchantid);
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
		if(orderid == null){
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg(WebConstantValue.GET_MERCHANT_ERROR);
			return resultModel;
		}
		CalculateinterestForm calform = AllinpayAPI.getCardinfoNopassAPI(card_info.get("cardno").toString(), orderid, _branchInfoform);
        if(calform.getCardproductList().size()>0){
             for(int i=0;i<calform.getCardproductList().size();i++){
                 CalculateinterestForm temForm=(CalculateinterestForm)calform.getCardproductList().get(i);
                 temForm.getAccount_balance();//账户余额
                 temForm.getProduct_id();//产品号
                 temForm.getValid_balance();//有效余额
             }
             //此处应列表展示 账户 1  余额  账户2  余额 。。详情见低保真
             
         //测试   应删掉
         card_info.put("money", ((CalculateinterestForm)calform.getCardproductList().get(0)).getAccount_balance());
             
         }
		resultModel.setCard_info(card_info);
		
		resultModel.setState(WebConstantValue.HTTP_OK);

		logger.info("========================Service get_card_info End==========================");
		return resultModel;
	}
}
