package cn.com.allinpay.frame.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * 
 * 常用工具类.
 * 
 * @version V1.00.
 * 
 */
public class WebUtil {
	
	/**
	 * 生成32的UUID
	 * @return
	 */
	public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        //去掉“-”符号 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    }
	
	/**
	 * 获取格式化时间 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String formatTime(){
		Date nowTime=new Date(); 
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return time.format(nowTime); 
	}
	
	/**
	 * 获取随机数
	 */
	public static String get_random(){
		Random random = new Random();
		float f = random.nextFloat();
        Integer i = (int) (f*100000000);
		return i+""; 
	}
	
	/**
	 * 改方法只是测试用----现阶段没有从通联返回卡的图片，所以遇到卡图片路径为空的话，给一个默认的卡图片
	 * @param card_list
	 * @return
	 */
	public static List<Map<String, Object>> test_set_null_card_img(List<Map<String, Object>> card_list){
		for(int i = 0; i < card_list.size(); i++){
			String merbercardimg = (String) card_list.get(i).get("merbercardimg");
			String merbercardtxm = (String) card_list.get(i).get("merbercardtxm");
			if (merbercardimg == null || merbercardimg == "null" || merbercardimg == "" || "".equals(merbercardimg)){
				card_list.get(i).put("merbercardimg", WebConstantValue.CARD_IMG);
			}
			if (merbercardtxm == null || merbercardtxm == "null" || merbercardtxm == "" || "".equals(merbercardtxm)){
				card_list.get(i).put("merbercardtxm", WebConstantValue.TXM_IMG);
			}
		}
		return card_list;
	}
	
	/**
	 * 改方法只是测试用----现阶段没有从通联返回卡的图片，所以遇到卡图片路径为空的话，给一个默认的卡图片
	 * @param card_list
	 * @return
	 */
	public static Map<String, Object> test_set_null_card_img_map(Map<String, Object> card_list){
		if (card_list == null){
			return card_list;
		}
		String merbercardimg = (String) card_list.get("merbercardimg");
		String merbercardtxm = (String) card_list.get("merbercardtxm");
		String cardcode = (String) card_list.get("cardcode");
		if (merbercardimg == null || merbercardimg == "null" || merbercardimg == "" || "".equals(merbercardimg)){
			card_list.put("merbercardimg", WebConstantValue.CARD_IMG);
		}
		if (merbercardtxm == null || merbercardtxm == "null" || merbercardtxm == "" || "".equals(merbercardtxm)){
			card_list.put("merbercardtxm", WebConstantValue.TXM_IMG);
		}
		if (cardcode == null || cardcode == "null" || cardcode == "" || "".equals(cardcode)){
			card_list.put("cardcode", WebConstantValue.EW_IMG);
		}
		return card_list;
	}
	
	/**
	 * 改方法只是测试用----现阶段没有从通联返回优惠券的图片，所以遇到优惠券图片路径为空的话，给一个默认的优惠券图片
	 * @param card_list
	 * @return
	 */
	public static List<Map<String, Object>> test_set_null_coupon_img(List<Map<String, Object>> coupon_list){
		for(int i = 0; i < coupon_list.size(); i++){
			String merbercardimg = (String) coupon_list.get(i).get("couponimg");
			String couponcode = (String) coupon_list.get(i).get("couponcode");
			if (merbercardimg == null || merbercardimg == "null" || merbercardimg == "" || "".equals(merbercardimg)){
				coupon_list.get(i).put("couponimg", WebConstantValue.COUPON_IMG);
			}
			if (couponcode == null || couponcode == "null" || couponcode == "" || "".equals(couponcode)){
				coupon_list.get(i).put("couponcode", WebConstantValue.EW_IMG);
			}
		}
		return coupon_list;
	}
	
	/**
	 * 改方法只是测试用----现阶段没有从通联返回优惠券的图片，所以遇到优惠券图片路径为空的话，给一个默认的优惠券图片
	 * @param card_list
	 * @return
	 */
	public static Map<String, Object> test_set_null_coupon_img_map(Map<String, Object> coupon_list){
		String merbercardimg = (String) coupon_list.get("couponimg");
		String couponcode = (String) coupon_list.get("couponcode");
		
		if (merbercardimg == null || merbercardimg == "null" || merbercardimg == "" || "".equals(merbercardimg)){
			coupon_list.put("couponimg", WebConstantValue.COUPON_IMG);
		}
		if (couponcode == null || couponcode == "null" || couponcode == "" || "".equals(couponcode)){
			coupon_list.put("couponcode", WebConstantValue.EW_IMG);
		}
		return coupon_list;
	}
}
