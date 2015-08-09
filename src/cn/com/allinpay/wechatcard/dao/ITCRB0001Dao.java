package cn.com.allinpay.wechatcard.dao;

import java.util.List;
import java.util.Map;

/**
 * Copyright(C) JiNanShangJie 2014.
 * 
 * 存单业务dao.
 * 
 * @author 张振峰 2014/10/09.
 * 
 * @version V1.00.
 * 
 *          更新履历： V1.00 2014/10/09 张振峰 创建.
 * 
 *          V2.00 2014/12/18 添加查询业务参数表信息方法。<br>
 */
public interface ITCRB0001Dao {

	/**
	 * 获取广告URL信息
	 * 
	 * @param paraMap
	 * @return
	 */
	public List<Map<String, Object>> getAdUrl();

}
