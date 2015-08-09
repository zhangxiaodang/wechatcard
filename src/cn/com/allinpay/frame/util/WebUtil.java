package cn.com.allinpay.frame.util;

import java.text.SimpleDateFormat;
import java.util.Date;
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
}
