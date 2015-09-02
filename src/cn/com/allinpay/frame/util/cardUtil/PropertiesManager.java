package cn.com.allinpay.frame.util.cardUtil;

import java.util.Properties;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertiesManager {
  private Properties dbProps = null;
  private static final Log log = LogFactory.getLog(PropertiesManager.class);

  public PropertiesManager() {
  }

  public String getProperty(String strKey){
    if(dbProps == null){
      initProperties();
    }

    return dbProps.getProperty(strKey);
  }

  public void setProperty(String strKey,String strValue){
    if(dbProps == null){
      initProperties();
    }

    dbProps.setProperty(strKey,strValue);
  }

  private void initProperties(){
    try{
      InputStream is = getClass().getResourceAsStream("/parameter.properties");
      dbProps = new Properties();
      dbProps.load(is);
    }catch(Exception e){
      log.info("-1\t读取parameter.properties文件时出错");//写日志
      e.printStackTrace();
    }
  }


}
