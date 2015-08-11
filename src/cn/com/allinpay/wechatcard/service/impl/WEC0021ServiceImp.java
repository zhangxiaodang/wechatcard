package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.WebUtil;
import cn.com.allinpay.wechatcard.dao.WEC0010Dao;
import cn.com.allinpay.wechatcard.dao.WEC0021Dao;
import cn.com.allinpay.wechatcard.model.WEC0010Model;
import cn.com.allinpay.wechatcard.service.IWEC0010Service;
import cn.com.allinpay.wechatcard.service.IWEC0021Service;
import cn.com.allinpay.wechatcard.view.WEC0010View;
import cn.com.allinpay.wechatcard.view.WEC0021View;

/**
 * 
 * 注册serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0021ServiceImp extends BaseService implements IWEC0021Service {
	
	/** logger **/
	private static final Logger logger = Logger.getLogger(WEC0021ServiceImp.class);
	
	/** 注册的dao **/
	@Autowired
	private WEC0021Dao wec_0021_Dao;
	
	/**
	 * 注册的service
	 */
	@Override
	public WEC0010Model applyNewCard(WEC0010View memberView) throws Exception{
		logger.info("========================Service applyNewCard Start==========================");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 会员卡信息
		WEC0021View wec0021View = new WEC0021View();
		// 调用总公司的预付卡后台电子卡开卡接口，进行开卡
		// 申请新卡的密码
		wec0021View.setPassword(memberView.getPassword());
		// todo
		
		// 更新本地会员卡的信息
		wec0021View.setMerbercardid(WebUtil.getUUID());
		// 会员ID
		wec0021View.setMemberid(memberView.getMemberid());
		// 商家ID
		wec0021View.setMerchantid("");
		// 商家ID(冗余，供查询方便用)
		wec0021View.setCardno("");
		// 电子卡号（预付卡系统后台电子卡号）
		wec0021View.setDzcardno("");
		// 会员卡等级
		wec0021View.setCardgrade("");
		// 会员卡二维码信息
		wec0021View.setCardcode("");
		// 卡状态
		wec0021View.setCardstat("");
		// 申请会员卡时间
		wec0021View.setCardsqsj(WebUtil.formatTime());
		// 申请会员卡方式（申请新卡或绑定旧卡)
		wec0021View.setCardmode("1");
		
		paramMap.put(BEAN, wec0021View);
		// 生成本地的会员卡号
		wec_0021_Dao.add_card(paramMap);
		// 返回前台提示信息
		WEC0010Model resultModel = new WEC0010Model();
		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.APPLY_CARD_SUCCESS);
		
		logger.info("========================Service applyNewCard End==========================");
		return resultModel;
	}
}