package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantUrlValue;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.dao.WEC0020Dao;
import cn.com.allinpay.wechatcard.service.ICommonService;
import cn.com.allinpay.wechatcard.service.IWEC0020Service;
import cn.com.allinpay.wechatcard.view.WEC0020View;

/**
 * 
 * 会员卡注册serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0020ServiceImp extends BaseService implements IWEC0020Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0020ServiceImp.class);

	/** 注册的dao **/
	@Autowired
	private WEC0020Dao wec_002_Dao;

	@Autowired
	private ICommonService commonService;

	/**
	 * 注册的service
	 */
	@Override
	public int phone_is_rigist(WEC0020View wec0020View) throws Exception {
		logger.info("========================Service regist Start==========================");
		// 返回前台提示信息
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BEAN, wec0020View);
		int count = wec_002_Dao.phone_is_rigist(paramMap);
		logger.info("========================Service regist End==========================");
		return count;
	}

	@Override
	public ModelAndView getMemberCardInfo(String strOpenID, String strUrlFlag)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String, String> memberInfo = commonService
				.getMemberIDByOpenID(strOpenID);
		// 获取会员信息
		if (memberInfo == null || memberInfo.get("membergrade") == null
				|| "".equals(memberInfo.get("membergrade"))) {
			// 如果根据openid获取会员的id，获取不到，提示用户。
			mv.addObject("errmsg", WebConstantValue.ADD_CARD_ERROR);
			mv.setViewName(WebConstantUrlValue.WEC_ERROR);
			return mv;
		}
		WEC0020View wec0020View = new WEC0020View();
		// 获取用户是否注册过改商户
		wec0020View.setMemberphone(memberInfo.get("memberphone"));
		wec0020View.setOpenid(strOpenID);
		wec0020View.setUrlflag(strUrlFlag);
		// 查询改手机号是否开过卡
		int cnt = this.phone_is_rigist(wec0020View);
		boolean phone_is_used = false;
		if (cnt > 0) {
			phone_is_used = true;
		}
		mv.addObject("phone_is_used", phone_is_used);
		mv.addObject("membergrade", memberInfo.get("membergrade"));

		return mv;
	}

}
