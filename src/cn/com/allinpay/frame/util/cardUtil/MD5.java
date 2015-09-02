package cn.com.allinpay.frame.util.cardUtil;
 

/************************************************
MD5 算法的Java Bean
@author:Topcat Tuppin
Last Modified:10,Mar,2001
*************************************************/
import java.security.MessageDigest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.*;

/*************************************************
md5 类实现了RSA Data Security, Inc.在提交给IETF
的RFC1321中的MD5 message-digest 算法。
*************************************************/

public class MD5 {
  private static MessageDigest digest = null;
  private static final Log log = LogFactory.getLog(MD5.class);
  private static char hexDigits[] = {
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
      'a', 'b', 'c', 'd', 'e', 'f'};

  private MD5(){
  }
  /**
   * Hashes a String using the Md5 algorithm and returns the result as a
   * String of hexadecimal numbers. This method is synchronized to avoid
   * excessive MessageDigest object creation. If calling this method becomes
   * a bottleneck in your code, you may wish to maintain a pool of
   * MessageDigest objects instead of using this method.
   * <p>
   * A hash is a one-way function -- that is, given an
   * input, an output is easily computed. However, given the output, the
   * input is almost impossible to compute. This is useful for passwords
   * since we can store the hash and a hacker will then have a very hard time
   * determining the original password.
   * <p>
   * In Jive, every time a user logs in, we simply
   * take their plain text password, compute the hash, and compare the
   * generated hash to the stored hash. Since it is almost impossible that
   * two passwords will generate the same hash, we know if the user gave us
   * the correct password or not. The only negative to this system is that
   * password recovery is basically impossible. Therefore, a reset password
   * method is used instead.
   *
   * @param data the String to compute the hash of.
   * @return a hashed version of the passed-in String
   */


  public synchronized static final String getMD5ofStr(String data) {
    if (digest == null) {
      try {
        digest = MessageDigest.getInstance("MD5");
      }catch (Exception e) {
        log.error("加密失败,错误信息:"+e.getMessage());
        e.printStackTrace();
      }
    }
    //Now, compute hash.
    digest.update(data.getBytes());
    return toHex(digest.digest()).toUpperCase();
  }
  /**
   * Turns an array of bytes into a String representing each byte as an
   * unsigned hex number.
   * <p>
   * Method by Santeri Paavolainen, Helsinki Finland 1996<br>
   * (c) Santeri Paavolainen, Helsinki Finland 1996<br>
   * Distributed under LGPL.
   *
   * @param hash an rray of bytes to convert to a hex-string
   * @return generated hex string
   */
  private static final String toHex (byte hash[]) {
      StringBuffer buf = new StringBuffer(hash.length * 2);
      int i;

      for (i = 0; i < hash.length; i++) {
          if (((int) hash[i] & 0xff) < 0x10) {
              buf.append("0");
          }
          buf.append(Long.toString((int) hash[i] & 0xff, 16));
      }
      return buf.toString();
  }

  public final static String MD5fromString(String s) {

    try {
      byte[] strTemp = s.getBytes();
      MessageDigest mdTemp = MessageDigest.getInstance("MD5");
      mdTemp.update(strTemp);
      byte[] md = mdTemp.digest();
      int j = md.length;
      char str[] = new char[j * 2];
      int k = 0;
      for (int i = 0; i < j; i++) {
        byte byte0 = md[i];
        str[k++] = hexDigits[byte0 >>> 4 & 0xf];
        str[k++] = hexDigits[byte0 & 0xf];
      }
      return new String(str);
    }catch (Exception e) {
      return null;
    }
  }

  public final static String MD5fromByte(byte[] strTemp) {
    try {
      MessageDigest mdTemp = MessageDigest.getInstance("MD5");
      mdTemp.update(strTemp);
      byte[] md = mdTemp.digest();
      int j = md.length;
      char str[] = new char[j * 2];
      int k = 0;
      for (int i = 0; i < j; i++) {
        byte byte0 = md[i];
        str[k++] = hexDigits[byte0 >>> 4 & 0xf];
        str[k++] = hexDigits[byte0 & 0xf];
      }
      return new String(str);
    }catch (Exception e) {
      return null;
    }
  }

  public final static String MD5fromFile(String strDirFilename,String strFileAppender) {
    String _strRet = "";

    try {
      InputStream is = new FileInputStream(strDirFilename);
      ByteArrayOutputStream byteout  =   new  ByteArrayOutputStream();
       byte  tmp []  =   new   byte [256];
       int  i  =   0 ;
       while ((i = is.read(tmp)) !=- 1 ){
          byteout.write(tmp);
      }
      byteout.write(strFileAppender.getBytes());//追加后缀

      byte[] context  =  byteout.toByteArray();

      _strRet = MD5.MD5fromByte(context);

      byteout.close();
      is.close();
    }catch (Exception e) {
      e.printStackTrace();
    }

    return _strRet;
  }
  //数字签名
  public static String signature(String orgin) {
                  String result = null;
                  try {
                          MessageDigest md = MessageDigest.getInstance("MD5");
                          result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));
                  } catch (Exception e) {
                          throw new java.lang.RuntimeException("sign error !");
                  }
                  return result.toUpperCase();
          }

          /**
           * @param b
           * @return
           */
          private static String byte2hex(byte[] b) {
                  StringBuffer hs = new StringBuffer();
                  String stmp = "";
                  for (int n = 0; n < b.length; n++) {
                          stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
                          if (stmp.length() == 1)
                                  hs.append("0").append(stmp);
                          else
                                  hs.append(stmp);
                  }
                  return hs.toString();
	}
}
