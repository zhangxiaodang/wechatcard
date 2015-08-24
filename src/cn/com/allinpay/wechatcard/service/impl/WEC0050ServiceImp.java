package cn.com.allinpay.wechatcard.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.wechatcard.dao.WEC0042Dao;
import cn.com.allinpay.wechatcard.dao.WEC0050Dao;
import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.service.IWEC0042Service;
import cn.com.allinpay.wechatcard.service.IWEC0050Service;
import cn.com.allinpay.wechatcard.view.WEC0041View;

/**
 * 
 * 优惠券领取完毕serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0050ServiceImp extends BaseService implements IWEC0050Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0050ServiceImp.class);

	/** 优惠券领取完毕dao **/
	@Autowired
	private WEC0050Dao wec_0050_Dao;

	
	
}
