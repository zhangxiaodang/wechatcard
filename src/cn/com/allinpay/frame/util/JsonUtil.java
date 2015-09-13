package cn.com.allinpay.frame.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * json工具类.
 * 
 * @author juwg
 * @author liuxd
 */
public class JsonUtil {

	/**
	 * 把对象转换为json字符串
	 * 
	 * @param obj
	 *            要转换的对象
	 * @return json字符串
	 */
	public static String bean2Json(Object obj) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		// 下面这种方法不会转换出所有的属性，只会转换出有值的属性
		// Gson gson = new GsonBuilder().create();
		return gson.toJson(obj);
	}

	/**
	 * 把json字符串转换为对象
	 * 
	 * @param jsonStr
	 *            json字符串
	 * @param objClass
	 *            对象类
	 * @return 对象
	 */
	public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(jsonStr, objClass);
	}

	/**
	 * @Description: 使用ReaultObject进行反序列化
	 * @param jsonStr
	 * @param objClass
	 * @return T 返回类型
	 * @throws
	 */
	public static <T> T json2Bean(String jsonStr, TypeToken<T> objClass) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(jsonStr, objClass.getType());
	}

}
