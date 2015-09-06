package cn.com.allinpay.frame.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MsgUtil {
	
    String urlPath = "http://10.64.254.50:9000/smsweb/NoValidationMt.do?method=sendNow";//localhost配成参数

	  public void demoClient(String strSendphone,String strContents) {

	        StringBuffer sbf = new StringBuffer();
	        BufferedWriter writer = null;
	        BufferedReader reader = null;
	        HttpURLConnection uc = null;
	        try {
	            URL url = new URL(urlPath);
	            uc = (HttpURLConnection)url.openConnection();
	            uc.setDoOutput(true);
	            uc.setDoInput(true);
	            uc.setUseCaches(false);
	            uc.setRequestMethod("POST");
	            uc.setRequestProperty("connection", "Keep-Alive");
	            uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
	            uc.setRequestProperty("Charsert", "UTF-8");
	            uc.setRequestProperty("Content-Type", "text/html");
	            writer = new BufferedWriter(new OutputStreamWriter(uc.getOutputStream())); //向服务器传送数据
	            StringBuffer _sb = new StringBuffer(5000);
	            _sb.append("<?xml version='1.0' encoding='utf-8'?> ");
	            _sb.append("<sms> ");
	            _sb.append("  <sendphone>"+strSendphone+"</sendphone> ");//手机号,必须只能发送一个手机号
	            _sb.append("  <smscontents>"+strContents+"</smscontents> ");//内容
	            _sb.append("  <smstypes>wechatcardverificationcode</smstypes> ");//短信类型
	            _sb.append("  <extendcode>01</extendcode> ");//扩展码
	            _sb.append("</sms> ");
	            writer.write(_sb.toString()); //传送的数据
	            writer.flush();
	            writer.close();

	            reader = new BufferedReader(new InputStreamReader(uc.getInputStream(),"UTF-8"));//读取服务器响应信息

	            String line;
	            while ((line = reader.readLine()) != null){
	                sbf.append(line);
	            }
	            System.out.println(sbf.toString());
	            reader.close();
	            uc.disconnect();
	        } catch (Exception e) {
	            sbf.append("服务器连接失败！请稍后重新操作");
	            e.printStackTrace();
	        } finally{
	            try{
	                writer.close(); //关闭流
	                reader.close();
	                uc.disconnect();
	            }catch(Exception e){
	                sbf.append("服务器连接失败！请稍后重新操作");
	                e.printStackTrace();
	            }
	        }
	    }

}
