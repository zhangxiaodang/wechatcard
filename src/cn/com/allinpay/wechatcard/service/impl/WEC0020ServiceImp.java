package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.wechatcard.dao.WEC0020Dao;
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
	private static final Logger logger = Logger.getLogger(WEC0020ServiceImp.class);
	
	/** 注册的dao **/
	@Autowired
	private WEC0020Dao wec_002_Dao;

	/**
	 * 注册的service
	 */
	@Override
	public int phone_is_rigist(WEC0020View wec0020View) throws Exception{
		logger.info("========================Service regist Start==========================");
		// 返回前台提示信息
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BEAN, wec0020View);
		int count = wec_002_Dao.phone_is_rigist(paramMap);
		logger.info("========================Service regist End==========================");
		return count;
	}
	
}
