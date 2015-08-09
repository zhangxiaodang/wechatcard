package cn.com.allinpay.frame.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Copyright(C) JiNanShangJie 2014.
 * 
 * Json转换类.
 * 
 * @author 张振峰 2015/08/09.
 * 
 * @version V1.00.
 * 
 *          更新履历： V1.00 2015/08/09 张振峰 创建.
 */
public class WebJsonUtil {

	/**
	 * 把对象转换为json字符串
	 * 
	 * @param obj
	 *            要转换的对象
	 * @return json字符串
	 */
	public static String bean2Json(Object obj) {

		Gson gson = new GsonBuilder().serializeNulls().create();
		// 返回
		return gson.toJson(obj);
	}

	/**
	 * 把json字符串转换为对象.
	 * 
	 * @param jsonStr
	 *            json字符串.
	 * 
	 * @param objClass
	 *            对象类.
	 * 
	 * @return 对象
	 */
	public static <T> T json2Bean(String json, Class<T> classOfT) {

		Gson gson = new GsonBuilder().create();
		// 返回
		return gson.fromJson(json, classOfT);
	}
}
