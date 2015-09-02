package cn.com.allinpay.frame.util.cardUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import java.text.*;

public class DateManager {
  public static final Log log = LogFactory.getLog(DateManager.class);
	public static final String DATE_TIME_PATTERN1 = "yyyyMMddHHmmss";
	public static final String DATE_TIME_PATTERN2 = "yyyyMMdd HH:mm:ss";
	public static final String DATE_TIME_PATTERN3 = "MMdd HH:mm:ss";
  private DateManager() {
  }
  public static String getCurrentDateShort() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		Calendar cal = Calendar.getInstance();
	    return sdf.format(cal.getTime());
	}
  public static String getCurrentDateLong() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		Calendar cal = Calendar.getInstance();
	    return sdf.format(cal.getTime());
	}
  public static String dateDiff(String strDate,int iDays) {
    String _strRet = "";
    try{
      GregorianCalendar _calendar = new GregorianCalendar();//
      java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
      _calendar.setTime(sdf.parse(strDate));
      _calendar.add(GregorianCalendar.DAY_OF_YEAR,iDays);
      String _strCurYear = String.valueOf(_calendar.get(GregorianCalendar.YEAR));
      String _strCurMonth = (_calendar.get(GregorianCalendar.MONTH)+1<10)?"0"+String.valueOf(_calendar.get(GregorianCalendar.MONTH)+1):String.valueOf(_calendar.get(GregorianCalendar.MONTH)+1);
      String _strCurDay = (_calendar.get(GregorianCalendar.DAY_OF_MONTH)<10)?"0"+String.valueOf(_calendar.get(GregorianCalendar.DAY_OF_MONTH)):String.valueOf(_calendar.get(GregorianCalendar.DAY_OF_MONTH));
      _strRet=_strCurYear+"-"+_strCurMonth+"-"+_strCurDay;
    }catch(Exception e){
      e.printStackTrace();
    }

    return _strRet;
  }

  public static int dateDistance(String strBeginDate,String strEndDate) {//�õ������ڵ�ʱ����
    int _iRet = 0;
    try{
      SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date date1= _sdf.parse(strBeginDate);
      Date date2= _sdf.parse(strEndDate);
      long day=(date2.getTime()-date1.getTime())/(24*60*60*1000);
      _iRet=Integer.parseInt(String.valueOf(day));
    }catch(Exception e){
      e.printStackTrace();
    }

    return _iRet;
  }

  public static String getMonth(String strYYYYMM,int i) {//���������·�,�õ�n����ǰ���(iΪ��ֵ)���·�
    String _strRet = "";
    try{
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar _calendar = new GregorianCalendar();//
        _calendar.setTime(sdf.parse(strYYYYMM+"-01"));//����������
        _calendar.add(GregorianCalendar.MONTH,i);//��i

        String _strYYYY = String.valueOf(_calendar.get(GregorianCalendar.YEAR));
        String _strMM = (_calendar.get(GregorianCalendar.MONTH)+1<10)?"0"+String.valueOf(_calendar.get(GregorianCalendar.MONTH)+1):String.valueOf(_calendar.get(GregorianCalendar.MONTH)+1);

        _strRet = _strYYYY+"-"+_strMM;

    }catch(Exception e){
      e.printStackTrace();
    }

    return _strRet;
  }
 //Linux��������
  public static String getLastmonth(String strYyyy_mm) {//�õ������ڵ�ʱ����
    String _strRet = "";
    try{
        GregorianCalendar _calendar = new GregorianCalendar();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
         _calendar.setTime(sdf.parse(strYyyy_mm+"-01"));
        //_calendar.setTime(DateFormat.getDateInstance().parse(strYyyy_mm+"-01"));
        _calendar.add(Calendar.MONTH,-1);
        SimpleDateFormat _sfMonth = new SimpleDateFormat("yyyy-MM");
        _strRet = _sfMonth.format(_calendar.getTime());
    }catch(Exception e){
      e.printStackTrace();
    }

    return _strRet;
  }

  public static String getLastmonth() {
    String _strRet = "";
    try{
        GregorianCalendar _calendar = new GregorianCalendar();
        _calendar.setTime(new Date());
        _calendar.add(Calendar.MONTH,-1);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
        _strRet = sf.format(_calendar.getTime());
    }catch(Exception e){
      e.printStackTrace();
    }

    return _strRet;
  }

  public static String getLastyearend(String strYyyy_mm) {//
    String _strRet = "";
    try{
        GregorianCalendar _calendar = new GregorianCalendar();
        //_calendar.setTime(DateFormat.getDateInstance().parse(strYyyy_mm+"-01"));
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        _calendar.setTime(sdf.parse(strYyyy_mm+"-01"));
        _calendar.add(Calendar.YEAR,-1);
        SimpleDateFormat _sfYear = new SimpleDateFormat("yyyy");
        _strRet = _sfYear.format(_calendar.getTime())+"-12";
    }catch(Exception e){
      e.printStackTrace();
    }

    return _strRet;
  }

  public static String getLastquarterend(String strYyyy_mm) {//
    String _strRet = "";
    try{

        String _strQuarterndmonth = "";
        String _strYyyy = strYyyy_mm.substring(0,4);
        int _iMonth = Integer.parseInt(strYyyy_mm.substring(5,7));
        if(_iMonth<4){
            _strQuarterndmonth = "03";
        }else if(_iMonth>=4&&_iMonth<=6){
            _strQuarterndmonth = "06";
        }else if(_iMonth>=7&&_iMonth<=9){
            _strQuarterndmonth = "09";
        }else if(_iMonth>=10&&_iMonth<=12){
            _strQuarterndmonth = "12";
        }
        _strRet = getMonth(_strYyyy+"-"+_strQuarterndmonth,-3);
    }catch(Exception e){
      e.printStackTrace();
    }

    return _strRet;
  }

  public static String getDate() {//
    String _strRet = "";
    try{
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        _strRet = sdf.format(new Date());

    }catch(Exception e){
      e.printStackTrace();
    }

    return _strRet;
  }

  public static String getYyyymmdd(String strYyyy_mm_dd) {//
    String _strRet = "";
    try{
        GregorianCalendar _calendar = new GregorianCalendar();
        //_calendar.setTime(DateFormat.getDateInstance().parse(strYyyy_mm_dd));
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        _calendar.setTime(sdf.parse(strYyyy_mm_dd));
        SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMdd");
        _strRet = _sf.format(_calendar.getTime());
    }catch(Exception e){
      e.printStackTrace();
    }

    return _strRet;
  }

  public static String getDateTime() {
    String _strRet = "";
    try{
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
        _strRet = sdf.format(new Date());
    }catch(Exception e){
      e.printStackTrace();
    }

    return _strRet;
  }

  public static String getDateTimeOfStandard() {
    String _strRet = "";
    try{
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        _strRet = sdf.format(new Date());
    }catch(Exception e){
      e.printStackTrace();
    }

    return _strRet;
  }

  public static void main(String[] strArgs){

      //String _str = "20100501";
      //byte rawKeyData[] = "ums1012ejbca2010archives".getBytes();
      //System.out.println("rawKeyData�ĳ���"+rawKeyData.length);
      //System.out.println(_str.substring(0,6));
      //System.out.println(DateManager.getMonth("2010-07",-13));
      //System.out.println(DateManager.getMonth("2010-07",-5));
    //System.out.println(DateManager.getDateTimeOfStandard());
	  //DecimalFormat _dfInt = new DecimalFormat("###############0");
    //System.out.println(Integer.parseInt("2009-08".substring(5,7)));
    //System.out.println(addmulMonth("2013-01-07",1));//
//    System.out.println(dateDistance("2010-11-01","2010-11-15"));
//    System.out.println(getMonth("2010-05",3));
//    System.out.println(getLastmonth("2010-07"));
//    System.out.println(getLastmonth());
//    System.out.println(getLastyearend("2010-05"));
//    System.out.println(getLastquarterend("2010-04"));
//    System.out.println(getDate());
//    System.out.println(getYyyymmdd("2010-01-01"));
//    System.out.println(getDateTime());
//    System.out.println(getDateTimeOfStandard());
//    System.out.println(getYesterday("2010-01-05"));
//    System.out.println(getDatetime());
	  
      System.out.println(DateManager.dateDistance("2015-04-21","2015-04-23"));
    
    
	  //System.out.println(DateManager.addmulDay("2014-10-14",Integer.parseInt(_dfInt.format(Double.parseDouble("0.5")*30))));
  }
  public static String getYesterday(String nowDate) {
       String yesterday="";
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
           Date date = sdf.parse(nowDate);
           if(date == null) {
               return null;
           }
           Calendar cal = Calendar.getInstance();
           cal.setTime(date);
           cal.add(Calendar.DAY_OF_MONTH, -1);
           yesterday=sdf.format(cal.getTime());
           return yesterday;
       } catch (ParseException e) {
           return null;
       }
  }
  public static String getDatetime() {//
   String _strRet = "";
   try{
       java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
       _strRet = sdf.format(new Date());

   }catch(Exception e){
     e.printStackTrace();
   }

   return _strRet;
 }

  public static String addmulMonth(String nowDate,int i) {//���������·�,�õ�n����ǰ���(iΪ��ֵ)���·�
   String _strRet = "";
   try{
       java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
       GregorianCalendar _calendar = new GregorianCalendar();//
       _calendar.setTime(sdf.parse(nowDate));//����������
       _calendar.add(GregorianCalendar.MONTH,i);//��i

       String _strYYYY = String.valueOf(_calendar.get(GregorianCalendar.YEAR));
       String _strMM = (_calendar.get(GregorianCalendar.MONTH)+1<10)?"0"+String.valueOf(_calendar.get(GregorianCalendar.MONTH)+1):String.valueOf(_calendar.get(GregorianCalendar.MONTH)+1);
       String _strCurDay = (_calendar.get(GregorianCalendar.DAY_OF_MONTH)<10)?"0"+String.valueOf(_calendar.get(GregorianCalendar.DAY_OF_MONTH)):String.valueOf(_calendar.get(GregorianCalendar.DAY_OF_MONTH));
       _strRet = _strYYYY+"-"+_strMM+"-"+_strCurDay;

   }catch(Exception e){
     e.printStackTrace();
   }

   return _strRet;
 }
  public static String addmulDay(String inputDate,int day) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String nextDate = "";
		try {
			Date date = sdf.parse(inputDate);
			Calendar calender = Calendar.getInstance();
	        calender.setTime(date);
	        calender.add(Calendar.DATE, day);
	        nextDate = sdf.format(calender.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return nextDate;
	}
 
  public static String getYYYYMMDD() {
	    String _strRet = "";
	    try{
	        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMdd");
	        _strRet = sdf.format(new Date());
	    }catch(Exception e){
	      e.printStackTrace();
	    }

	    return _strRet;
	  }
  public static String getYYYYMM() {
	    String _strRet = "";
	    try{
	        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM");
	        _strRet = sdf.format(new Date());
	    }catch(Exception e){
	      e.printStackTrace();
	    }

	    return _strRet;
	  }
  public static String getMMDD() {
	    String _strRet = "";
	    try{
	        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMdd");
	        _strRet = sdf.format(new Date());
	    }catch(Exception e){
	      e.printStackTrace();
	    }

	    return _strRet;
	  }
  public static String getMMDDHHMMSS() {
	    String _strRet = "";
	    try{
	    	_strRet = getMMDD()+getHHMMSS();
	    }catch(Exception e){
	      e.printStackTrace();
	    }

	    return _strRet;
	  }
  public static String getHHMMSS() {
	  SimpleDateFormat _sf = new SimpleDateFormat("HHmmss");
      _sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
	  String timestamp=_sf.format(new Date());//ʱ���
	  return timestamp;
  }
  public static String getYear() {
	  SimpleDateFormat _sf = new SimpleDateFormat("yyyy");
      _sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
	  String timestamp=_sf.format(new Date());//ʱ���
	  return timestamp;
  }
public static String getFirstDayOfMonth(String dateStr) {
	  
	  String firstDayOfMonth = "";
	  SimpleDateFormat simpleFormate  =   new  SimpleDateFormat( "yyyy-MM-dd" );
	  if(dateStr!=null && !"".equals(dateStr)) {
		  String[] arr = dateStr.split("-");
		  if(arr.length==3) {
			  firstDayOfMonth = arr[0]+"-"+arr[1]+"-01";
		  }
	  }else {
		  Calendar calendar  =   new  GregorianCalendar();
		  calendar.set( Calendar.DATE,  1 );
		  firstDayOfMonth = simpleFormate.format(calendar.getTime());
	  }
	  return firstDayOfMonth;
  }

/**
 * 
 * @param inFormat
 *            �����ʱ���ʽ
 * @param inTime
 *            �����ʱ��
 * @param outDateFormat
 *            ��������ڸ�ʽ
 * 
 * @return
 * 
 */
public static String getStringTime(String inFormat, String inTime,
		String outDateFormat) {
	SimpleDateFormat format = new SimpleDateFormat(inFormat);
	Date date = null;
	try {
		date = format.parse(inTime);
		SimpleDateFormat format2 = new SimpleDateFormat(outDateFormat);
		String strDate = format2.format(date);
		return strDate;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return inTime;
	}
}
}
