package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.model.BaseModel;
import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.dao.WEC0023Dao;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0023Service;
import cn.com.allinpay.wechatcard.view.WEC0023View;

/**
 * 
 * 重新绑定serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0023ServiceImp extends BaseService implements IWEC0023Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0023ServiceImp.class);

	/** 注册的dao **/
	@Autowired
	private WEC0023Dao wec_0023_Dao;
	
	@Autowired
	private ICommonService commonService;

	/**
	 * 重新绑定service
	 */
	@Override
	public BaseModel change_openid(WEC0023View wec0023View) throws Exception {
		logger.info("========================Service change_openid Start==========================");

		// 返回前台提示信息
		BaseModel resultModel = new BaseModel();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 查询openid所在的商户的id
		Map<String, String> merchantInfo = commonService.getMerchantInfoByUrlFlag(wec0023View.getUrlflag());
		
		// 如果查询不到商户的信息
		if (merchantInfo == null || merchantInfo.get("merchantid".toUpperCase()) == null) {
			resultModel.setState(WebConstantValue.HTTP_ERROR);
			resultModel.setMsg(WebConstantValue.GET_MERCHANT_ERROR);
			return resultModel;
		}
		wec0023View.setMerchantid(merchantInfo.get("merchantid".toUpperCase()));

		paramMap.put(BEAN, wec0023View);
		
		// 修改会员的OpenID
		wec_0023_Dao.change_member_openid(paramMap);
		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.CHANGE_OPENID_SUCCES);

		logger.info("========================Service change_openid End==========================");
		return resultModel;
	}
}
