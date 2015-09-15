package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.model.BranchparametersForm;
import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.WebUtil;
import cn.com.allinpay.frame.util.cardUtil.AllinpayAPI;
import cn.com.allinpay.wechatcard.dao.WEC0021Dao;
import cn.com.allinpay.wechatcard.dao.WEC0033Dao;
import cn.com.allinpay.wechatcard.model.WEC0033Model;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0033Service;
import cn.com.allinpay.wechatcard.view.WEC0033View;

/**
 * 
 * 获获取消费记录serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0033ServiceImp extends BaseService implements IWEC0033Service {

	/** logger **/
	private static final Logger logger = Logger.getLogger(WEC0033ServiceImp.class);

	/** 优惠券详细dao **/
	@Autowired
	private WEC0033Dao wec_0033_Dao;
	@Autowired
	private WEC0021Dao wec_0021_Dao;

	@Autowired
	private ICommonService commonService;

	/**
	 * 获取我的消费记录service
	 */
	@Override
	public WEC0033Model get_consume(WEC0033View wec0033View) throws Exception {
		logger.info("========================Service get_coupon Start==========================");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// todo-zhangxd
		// wec0033View.setDzcardno("18363017058");
		paramMap.put(BEAN, wec0033View);
		// 返回前台提示信息
		WEC0033Model resultModel = new WEC0033Model();
		// 获取消费记录
		Map<String, String> memberInfo = commonService.getMemberIDByOpenID(wec0033View.getOpenid());
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
		String pageno = "1";
		String pagesize = "10";
		logger.info(wec0033View); 
		//根据实体卡号 调总公司接口查询 消费记录
		AllinpayAPI.searchtxnlogAPI("20150817", "20150901", wec0033View.getDzcardno(), "123456", pageno, pagesize, _branchInfoform);
		
		List<Map<String, Object>> consume_list = wec_0033_Dao.get_consume(paramMap);
		// 如果图片为空的话设置默认图片
		WebUtil.test_set_null_card_img(consume_list);
		

		
		resultModel.setRows(consume_list);
		resultModel.setState(WebConstantValue.HTTP_OK);
		if(consume_list.size() == 0){
			resultModel.setMsg(WebConstantValue.NULL_CONSUME);
		}

		logger.info("========================Service get_coupon End==========================");
		return resultModel;
	}
}
