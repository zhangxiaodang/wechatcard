package cn.com.allinpay.frame.util.cardUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DESEncryptDecrypt {

/**
　　*
　　* @return DES算法密钥
　　*/
public static byte[] generateKey() {
try {
// DES算法要求有一个可信任的随机数源
SecureRandom sr = new SecureRandom();
// 生成一个DES算法的KeyGenerator对象
KeyGenerator kg = KeyGenerator.getInstance("DES");
kg.init(sr);
// 生成密钥
SecretKey secretKey = kg.generateKey();
// 获取密钥数据
byte[] key = secretKey.getEncoded();
return key;
} catch (NoSuchAlgorithmException e) {
System.err.println("DES算法，生成密钥出错!");
e.printStackTrace();
}
return null;
}

/**
　　* 加密函数
　　*
　　* @param data
　　*            加密数据
　　* @param key
　　*            密钥
　　* @return 返回加密后的数据
　　*/
public static byte[] encrypt(byte[] data, byte[] key) {
try {
// DES算法要求有一个可信任的随机数源
SecureRandom sr = new SecureRandom();
// 从原始密钥数据创建DESKeySpec对象
DESKeySpec dks = new DESKeySpec(key);
// 创建一个密匙工厂，然后用它把DESKeySpec转换成
// 一个SecretKey对象
SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
SecretKey secretKey = keyFactory.generateSecret(dks);
// using DES in ECB mode
Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
// 用密匙初始化Cipher对象
cipher.init(Cipher.ENCRYPT_MODE, secretKey, sr);
// 执行加密操作
byte encryptedData[] = cipher.doFinal(data);
return encryptedData;
} catch (Exception e) {
System.err.println("DES算法，加密数据出错!");
e.printStackTrace();
}
return null;
}
/**
　　* 解密函数
　　*
　　* @param data
　　*            解密数据
　　* @param key
　　*            密钥
　　* @return 返回解密后的数据
　　*/
public static byte[] decrypt(byte[] data, byte[] key) {
try {
// DES算法要求有一个可信任的随机数源
SecureRandom sr = new SecureRandom();
// byte rawKeyData[] = /* 用某种方法获取原始密匙数据 */;
// 从原始密匙数据创建一个DESKeySpec对象
DESKeySpec dks = new DESKeySpec(key);
// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
// 一个SecretKey对象
SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
SecretKey secretKey = keyFactory.generateSecret(dks);
// using DES in ECB mode
Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
// 用密匙初始化Cipher对象
cipher.init(Cipher.DECRYPT_MODE, secretKey, sr);
// 正式执行解密操作
byte decryptedData[] = cipher.doFinal(data);
return decryptedData;
} catch (Exception e) {
System.err.println("DES算法，解密出错。");
e.printStackTrace();
}
return null;
}

/**
　　* 加密函数
　　*
　　* @param data
　　*            加密数据
　　* @param key
　　*            密钥
　　* @return 返回加密后的数据
　　*/
public static byte[] CBCEncrypt(byte[] data, byte[] key, byte[] iv) {
try {
// 从原始密钥数据创建DESKeySpec对象
DESKeySpec dks = new DESKeySpec(key);
// 创建一个密匙工厂，然后用它把DESKeySpec转换成
// 一个SecretKey对象
SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
SecretKey secretKey = keyFactory.generateSecret(dks);
// Cipher对象实际完成加密操作
Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
// 若采用NoPadding模式，data长度必须是8的倍数
// Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");
// 用密匙初始化Cipher对象
IvParameterSpec param = new IvParameterSpec(iv);
cipher.init(Cipher.ENCRYPT_MODE, secretKey, param);
// 执行加密操作
byte encryptedData[] = cipher.doFinal(data);
return encryptedData;
} catch (Exception e) {
System.err.println("DES算法，加密数据出错!");
e.printStackTrace();
}
return null;
}

/**
　　* 解密函数
　　*
　　* @param data
　　*            解密数据
　　* @param key
　　*            密钥
　　* @return 返回解密后的数据
　　*/
public static byte[] CBCDecrypt(byte[] data, byte[] key, byte[] iv) {
try {
// 从原始密匙数据创建一个DESKeySpec对象
DESKeySpec dks = new DESKeySpec(key);
// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
// 一个SecretKey对象
SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
SecretKey secretKey = keyFactory.generateSecret(dks);
// using DES in CBC mode
Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
// 若采用NoPadding模式，data长度必须是8的倍数
// Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");
// 用密匙初始化Cipher对象
IvParameterSpec param = new IvParameterSpec(iv);
cipher.init(Cipher.DECRYPT_MODE, secretKey, param);
// 正式执行解密操作
byte decryptedData[] = cipher.doFinal(data);
return decryptedData;
} catch (Exception e) {
System.err.println("DES算法，解密出错。");
e.printStackTrace();
}
return null;
}

public static void mainss(String[] args) {
try {
    //FixCurrentTransForm _fixCurrentTransForm=AllinpayAPI.getCardinfoAPI("8668083660000001017","111111");

SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMddHHmmss");
String nowtime=_sf.format(new Date());
String pinblock=nowtime+"aop111112";
byte[] key = "abcdefgh".getBytes("UTF8");
byte[] iv = "abcdefgh".getBytes("UTF8");
byte[] data = DESEncryptDecrypt.CBCEncrypt(pinblock.getBytes("UTF-8"), key, iv);
String _Des =(new sun.misc.BASE64Encoder()).encode(data);
System.out.println("DES加密>>"+_Des);
    String urlenco=URLEncoder.encode(_Des,"UTF-8");
System.out.println("urlencode转义>>"+URLEncoder.encode(_Des,"UTF-8"));
String strmd5="testapp_keytestcard_id8668083660000001017formatxmlmethodallinpay.card.cardinfo.getpassword"+_Des+"sign_methodmd5sign_v1timestamp"+nowtime+"v1.0test";
String md5de=MD5.getMD5ofStr(strmd5).toUpperCase();
System.out.println("MD5>>"+MD5.getMD5ofStr(strmd5).toUpperCase());

String url="http://116.236.192.117:8080/aop/rest?app_key=test&format=xml&v=1.0&sign_method=md5&sign_v=1&method=allinpay.card.cardinfo.get&timestamp="+nowtime+"&card_id=8668083660000001017&password="+urlenco+"&sign="+md5de+"";
System.out.println("url:"+url);
String a=transport(url,"");
System.out.println("返回值:"+a);


} catch (Exception e) {
e.printStackTrace();
}
}
//发送http请求并接收响应
   public static String transport(String url, String message) {
   StringBuffer sb = new StringBuffer();
   try {

   URL urls = new URL(url);
   HttpURLConnection uc = (HttpURLConnection) urls.openConnection();
   uc.setRequestMethod("POST");
   uc.setRequestProperty("content-type",
   "application/x-www-form-urlencoded");
   uc.setRequestProperty("charset", "UTF-8");
   uc.setDoOutput(true);
   uc.setDoInput(true);
   uc.setReadTimeout(10000);
   uc.setConnectTimeout(10000);
   OutputStream os = uc.getOutputStream();
   DataOutputStream dos = new DataOutputStream(os);
   dos.write(message.getBytes("utf-8"));
   dos.flush();
   os.close();
   BufferedReader in = new BufferedReader(new InputStreamReader(uc
   .getInputStream(), "utf-8"));
   String readLine = "";
   while ((readLine = in.readLine()) != null) {
   sb.append(readLine);
   }
   in.close();
   } catch (Exception e) {

   }
   return sb.toString();
}


}
