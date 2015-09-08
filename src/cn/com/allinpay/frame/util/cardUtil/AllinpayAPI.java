package cn.com.allinpay.frame.util.cardUtil;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.com.allinpay.frame.model.BranchparametersForm;
import cn.com.allinpay.frame.model.CalculateinterestForm;
import cn.com.allinpay.frame.model.Yufuka;
import cn.com.allinpay.frame.util.WechatCardCommonUtil;

public class AllinpayAPI {
	private static java.text.DecimalFormat df = new java.text.DecimalFormat(
			"####0.00");
	private static java.text.DecimalFormat intdf = new java.text.DecimalFormat(
			"#");

	/************************************ 生产环境 *****************************************/
	/*
	 * private static String app_key="80000040"; private static String
	 * app_secret="800000401aopreq20130624155822chVg4Pak"; private static String
	 * api_v="1.0"; private static String DESKey="7f43d39e"; private static
	 * String befurl="http://210.22.146.163:7001/aop/rest?";
	 */
	/***********************************************************************************/

	/************************************ 测试环境 *****************************************/
	/*
	 * private static String app_key="test"; private static String
	 * app_secret="test"; private static String api_v="1.0"; private static
	 * String DESKey="abcdefgh"; private static String
	 * befurl="http://27.115.64.18:30064/aop/rest?";
	 */
	/***********************************************************************************/

	private static boolean timeError = true;// 有些服务器由于环境原因时间会相差八个小时，如果时间有问题，timeError需要改为true
	private static String app_key = "";
	private static String app_secret = "";
	private static String api_v = "";
	private static String DESKey = "";
	private static String befurl = "";

	private static void initParameters(BranchparametersForm _branchInfoform) {
		// 初始化其他信息
		app_key = _branchInfoform.getAppkey();
		app_secret = _branchInfoform.getAppsecret();
		api_v = _branchInfoform.getApiversion();
		DESKey = _branchInfoform.getDeskey();
		befurl = WechatCardCommonUtil.getBefUrl();
	}

	public static Yufuka openaccount(Yufuka yufuka,
			BranchparametersForm _branchInfoform) {

		initParameters(_branchInfoform);// 初始化参数
		try {
			SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (timeError) {
				_sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			}
			String timestamp = _sf.format(new Date());// 时间戳
			String signstring = "" + app_secret + "app_key" + app_key
					+ "brand_no" + yufuka.getBrand_no() + "brh_id"
					+ yufuka.getBrh_id() + "chan_no" + yufuka.getChan_no()
					+ "formatxml" + "methodallinpay.ppcs.cloud.card.open"
					+ "order_id" + yufuka.getOrder_id() + "password"
					+ yufuka.getPassword() + "phone_num"
					+ yufuka.getPhone_num() + "sign_methodmd5" + "sign_v1"
					+ "timestamp" + timestamp + "v" + api_v + "" + app_secret
					+ "";// 需要签名的字符串
			System.out.println("timestamp=" + timestamp);
			System.out.println("signstring=" + signstring);

			String md5sign = MD5.signature(signstring);// 对字符串进行md5加密
			String url = befurl + "app_key=" + app_key + "&brand_no="
					+ yufuka.getBrand_no() + "&brh_id=" + yufuka.getBrh_id()
					+ "&chan_no=" + yufuka.getChan_no() + "&format=xml"
					+ "&method=allinpay.ppcs.cloud.card.open" + "&order_id="
					+ yufuka.getOrder_id() + "&password="
					+ yufuka.getPassword() + "&phone_num="
					+ yufuka.getPhone_num() + "&sign=" + md5sign
					+ "&sign_method=md5" + "&sign_v=1" + "&timestamp="
					+ timestamp + "&v=" + api_v + "";// 拼装url
			System.out.println(url);
			URL urls = new URL(url);// url定义
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(urls);
			System.out.println("document=" + formatXML(document));
			Element rootElm = document.getRootElement();// 获取根节点
			if ("error_response".equals(rootElm.getName())) {// 如果出现错误
				Element sub_msg = rootElm.element("sub_msg");
				String msg = null == sub_msg ? rootElm.element("msg").getText()
						: sub_msg.getText();
				yufuka.setReturnMsg(msg);
			} else {
				Element brh_id = rootElm.element("brh_id");
				Element order_id = rootElm.element("order_id");
				Element card_id = rootElm.element("card_id");
				Element trans_no = rootElm.element("trans_no");
				Element phone_num = rootElm.element("phone_num");

				yufuka.setReturnMsg("00");// 设置00为成功返回标识
				yufuka.setBrh_id(brh_id.getText());
				yufuka.setOrder_id(order_id.getText());
				yufuka.setCard_id(card_id.getText());
				yufuka.setTrans_no(trans_no.getText());
				yufuka.setPhone_num(phone_num.getText());

			}
		} catch (Exception e) {
			String msge = ("远程通信中断，请检查网络！");
			yufuka.setReturnMsg(msge);
			e.printStackTrace();
		}
		return yufuka;
	}

	// 查询余额API:根据生产环境做修正
	public static CalculateinterestForm getCardinfoAPI(String strcardid,
			String strpassword, BranchparametersForm _branchInfoform) {
		CalculateinterestForm _calculateinterestForm = new CalculateinterestForm();
		initParameters(_branchInfoform);// 初始化参数
		ArrayList producList = new ArrayList();
		try {
			SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (timeError) {
				_sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			}
			String timestamp = _sf.format(new Date());// 时间戳
			String pinblock = timestamp + "aop" + strpassword;// pinblock构成
			byte[] key = DESKey.getBytes("UTF8");// 密钥编码
			byte[] iv = DESKey.getBytes("UTF8");// 初始向量编码
			byte[] data = DESEncryptDecrypt.CBCEncrypt(
					pinblock.getBytes("UTF-8"), key, iv);// DES加密
			String _DesInfo = (new sun.misc.BASE64Encoder()).encode(data);// Base64编码后的DES数据
			String des_urlencode = URLEncoder.encode(_DesInfo, "UTF-8");// urlencode转义
			String signstring = "" + app_secret + "app_key" + app_key
					+ "card_id" + strcardid
					+ "formatxmlmethodallinpay.card.cardinfo.getpassword"
					+ _DesInfo + "sign_methodmd5sign_v1timestamp" + timestamp
					+ "v" + api_v + "" + app_secret + "";// 需要签名的字符串
			String md5sign = MD5.signature(signstring);// 对字符串进行md5加密
			String url = befurl
					+ "app_key="
					+ app_key
					+ "&format=xml&v="
					+ api_v
					+ "&sign_method=md5&sign_v=1&method=allinpay.card.cardinfo.get&timestamp="
					+ timestamp + "&card_id=" + strcardid + "&password="
					+ des_urlencode + "&sign=" + md5sign + "";// 拼装url
			// System.out.println(url);
			URL urls = new URL(url);// url定义
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(urls);
			System.out.println("document=" + formatXML(document));
			Element rootElm = document.getRootElement();// 获取根节点
			if ("error_response".equals(rootElm.getName())) {// 如果出现错误
				Element sub_msg = rootElm.element("sub_msg");
				_calculateinterestForm
						.setReturn_message(null == sub_msg ? rootElm.element(
								"msg").getText() : sub_msg.getText());
			} else {
				Element cardinfo = rootElm.element("card_info");
				Element card_product_info_arrays = cardinfo
						.element("card_product_info_arrays");
				_calculateinterestForm.setReturn_message("00");// 设置00为成功返回标识
				for (Iterator i = card_product_info_arrays
						.elementIterator("card_product_info"); i.hasNext();) {
					Element card = (Element) i.next();
					CalculateinterestForm _productForm = new CalculateinterestForm();
					_productForm.setProduct_id(card.element("product_id")
							.getText());
					String account_balance = card.element("valid_balance")
							.getText();// 账户余额:可用余额
					_productForm.setAccount_balance(df.format(Double
							.parseDouble(account_balance) / 100));// 设置账户余额，转化为元
					_productForm.setCard_id(card.element("card_id").getText());// 设置卡号
					_productForm.setProduct_state(card.element("product_stat")
							.getText());// 设置产品状态

					producList.add(_productForm);// 产品集
				}
				_calculateinterestForm.setCardproductList(producList);
			}
		} catch (Exception e) {
			_calculateinterestForm.setReturn_message("远程通信中断，请检查网络！");
			e.printStackTrace();
		}
		return _calculateinterestForm;
	}

	// 换卡操作:测试成功。将老卡换到未激活的卡里，必须是未激活的。order_id自己生成
	public static CalculateinterestForm changeCardAPI(String card_id,
			String new_card_id, String order_id,
			BranchparametersForm _branchInfoform) {
		CalculateinterestForm _calculateinterestForm = new CalculateinterestForm();
		initParameters(_branchInfoform);// 初始化参数
		try {
			SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (timeError) {
				_sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			}
			String timestamp = _sf.format(new Date());// 时间戳
			String signstring = "" + app_secret + "app_key" + app_key
					+ "card_id" + card_id
					+ "formatxmlmethodallinpay.ppcs.cardchange.addnew_card_id"
					+ new_card_id + "order_id" + order_id
					+ "sign_methodmd5sign_v1timestamp" + timestamp + "v"
					+ api_v + "" + app_secret + "";// 需要签名的字符串
			String md5sign = MD5.signature(signstring);// 对字符串进行md5加密
			String url = befurl
					+ "app_key="
					+ app_key
					+ "&format=xml&v="
					+ api_v
					+ "&sign_method=md5&sign_v=1&method=allinpay.ppcs.cardchange.add&timestamp="
					+ timestamp + "&card_id=" + card_id + "&new_card_id="
					+ new_card_id + "&order_id=" + order_id + "&sign="
					+ md5sign + "";// 拼装url
			URL urls = new URL(url);// url定义
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(urls);
			Element rootElm = document.getRootElement();// 获取根节点
			Element oldcard_id = rootElm.element("card_id");
			Element newcard_id = rootElm.element("new_card_id");
			Element theorder_id = rootElm.element("order_id");
			Element trans_no = rootElm.element("trans_no");
			if ("error_response".equals(rootElm.getName())) {// 如果出现错误
				_calculateinterestForm.setReturn_message(null == rootElm
						.element("sub_msg") ? rootElm.element("msg").getText()
						: rootElm.element("sub_msg").getText());
			} else {
				_calculateinterestForm.setCard_id(oldcard_id.getText());
				_calculateinterestForm.setNew_card_id(newcard_id.getText());
				_calculateinterestForm.setOrder_id(theorder_id.getText());
				_calculateinterestForm.setTrans_no(trans_no.getText());
				_calculateinterestForm.setReturn_message("00");// 设置00为成功返回标识
			}
		} catch (Exception e) {
			_calculateinterestForm.setReturn_message("远程通信中断，请检查网络！");
			e.printStackTrace();
		}
		return _calculateinterestForm;
	}

	// 单卡充值 syp测试成功
	public static CalculateinterestForm cardSingleTopup(String order_id,
			String card_id, String prdt_no, String amount, String top_up_way,
			String desn, String oprid, BranchparametersForm _branchInfoform) {
		CalculateinterestForm _calculateinterestForm = new CalculateinterestForm();
		initParameters(_branchInfoform);// 初始化参数
		try {
			SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (timeError) {
				_sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			}
			String timestamp = _sf.format(new Date());// 时间戳

			String urlencode = URLEncoder.encode(desn, "UTF-8");
			String signstring = "" + app_secret + "amount" + amount + "app_key"
					+ app_key + "card_id" + card_id + "desn" + desn
					+ "formatxmlmethodallinpay.ppcs.cardsingletopup.addoprId"
					+ oprid + "order_id" + order_id + "prdt_no" + prdt_no
					+ "sign_methodmd5sign_v1timestamp" + timestamp
					+ "top_up_way" + top_up_way + "v" + api_v + "" + app_secret
					+ "";// 需要签名的字符串
			// System.out.println("signstring:"+signstring);
			String md5sign = MD5.signature(signstring);// 对字符串进行md5加密
			String url = befurl
					+ "app_key="
					+ app_key
					+ "&format=xml&v="
					+ api_v
					+ "&sign_method=md5&sign_v=1&method=allinpay.ppcs.cardsingletopup.add&timestamp="
					+ timestamp + "&card_id=" + card_id + "&oprId=" + oprid
					+ "&order_id=" + order_id + "&prdt_no=" + prdt_no
					+ "&amount=" + amount + "&top_up_way=" + top_up_way
					+ "&desn=" + urlencode + "&sign=" + md5sign + "";// 拼装url
			// System.out.println("url:"+url);
			URL urls = new URL(url);// url定义
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(urls);
			Element rootElm = document.getRootElement();// 获取根节点
			Element theorder_id = rootElm.element("order_id");
			Element trans_no = rootElm.element("trans_no");
			if ("error_response".equals(rootElm.getName())) {// 如果出现错误
				Element sub_msg = rootElm.element("sub_msg");
				_calculateinterestForm
						.setReturn_message(null == sub_msg ? rootElm.element(
								"msg").getText() : sub_msg.getText());
			} else {
				_calculateinterestForm.setOrder_id(theorder_id.getText());
				_calculateinterestForm.setTrans_no(trans_no.getText());
				_calculateinterestForm.setReturn_message("00");// 设置00为成功返回标识
				Element result_info = rootElm.element("result_info");
				_calculateinterestForm.setCard_id(result_info
						.element("card_id").getText());
				_calculateinterestForm.setProduct_id(result_info.element(
						"prdt_no").getText());
				_calculateinterestForm.setAmount(result_info.element("amount")
						.getText());
			}
		} catch (Exception e) {
			_calculateinterestForm.setReturn_message("远程通信中断，请检查网络！");
			e.printStackTrace();
		}
		return _calculateinterestForm;
	}

	// 消费：卡密支付接口
	public static CalculateinterestForm cardPayWithPassword(String mer_id,
			String mer_tm, String order_id, String mer_order_id,
			String pay_cur, String payment_id, String amount, String card_id,
			String password, String type, BranchparametersForm _branchInfoform) {
		CalculateinterestForm _calculateinterestForm = new CalculateinterestForm();
		initParameters(_branchInfoform);// 初始化参数
		try {
			SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (timeError) {
				_sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			}
			String timestamp = _sf.format(new Date());// 时间戳
			String passblock = timestamp + "aop" + password;// passblock构成
			String cardblock = timestamp + "aop" + card_id;// cardblock构成
			byte[] key = DESKey.getBytes("UTF8");// 密钥编码
			byte[] iv = DESKey.getBytes("UTF8");// 初始向量编码
			byte[] passdata = DESEncryptDecrypt.CBCEncrypt(
					passblock.getBytes("UTF-8"), key, iv);// DES加密
			byte[] carddata = DESEncryptDecrypt.CBCEncrypt(
					cardblock.getBytes("UTF-8"), key, iv);// DES加密
			String _passDesInfo = (new sun.misc.BASE64Encoder())
					.encode(passdata);// Base64编码后的DES数据
			String _cardDesInfo = (new sun.misc.BASE64Encoder())
					.encode(carddata);// Base64编码后的DES数据
			String des_pass_urlencode = URLEncoder
					.encode(_passDesInfo, "UTF-8");// urlencode转义
			String des_card_urlencode = URLEncoder
					.encode(_cardDesInfo, "UTF-8");// urlencode转义
			String signstring = "" + app_secret + "amount" + amount + "app_key"
					+ app_key + "card_id" + _cardDesInfo + "formatxmlmer_id"
					+ mer_id + "mer_order_id" + mer_order_id + "mer_tm"
					+ mer_tm
					+ "methodallinpay.card.paywithpassword.addorder_id"
					+ order_id + "password" + _passDesInfo + "pay_cur"
					+ pay_cur + "payment_id" + payment_id
					+ "sign_methodmd5sign_v1timestamp" + timestamp + "type"
					+ type + "v" + api_v + "" + app_secret + "";// 需要签名的字符串
			String md5sign = MD5.signature(signstring);// 对字符串进行md5加密
			String url = befurl
					+ "app_key="
					+ app_key
					+ "&format=xml&v="
					+ api_v
					+ "&sign_method=md5&sign_v=1&method=allinpay.card.paywithpassword.add&timestamp="
					+ timestamp + "&card_id=" + des_card_urlencode + "&mer_tm="
					+ mer_tm + "&mer_order_id=" + mer_order_id + "&pay_cur="
					+ pay_cur + "&payment_id=" + payment_id + "&amount="
					+ amount + "&password=" + des_pass_urlencode + "&order_id="
					+ order_id + "&type=" + type + "&mer_id=" + mer_id
					+ "&sign=" + md5sign + "";// 拼装url
			// System.out.println(url);
			URL urls = new URL(url);// url定义
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(urls);
			Element rootElm = document.getRootElement();// 获取根节点
			Element theorder_id = rootElm.element("order_id");
			if ("error_response".equals(rootElm.getName())) {// 如果出现错误
				Element sub_msg = rootElm.element("sub_msg");
				_calculateinterestForm
						.setReturn_message(null == sub_msg ? rootElm.element(
								"msg").getText() : sub_msg.getText());
			} else {
				_calculateinterestForm.setReturn_message("00");// 设置00为成功返回标识
				Element result_info = rootElm.element("pay_result_info");
				_calculateinterestForm.setCard_id(result_info
						.element("card_id").getText());
				_calculateinterestForm.setAmount(result_info.element("amount")
						.getText());
				_calculateinterestForm.setOrder_id(theorder_id.getText());
				_calculateinterestForm.setMer_id(result_info.element("mer_id")
						.getText());
				_calculateinterestForm.setPay_txn_id(result_info.element(
						"pay_txn_id").getText());
				_calculateinterestForm.setMer_order_id(result_info.element(
						"mer_order_id").getText());
				// Element _type=result_info.element("type");
				// Element _mer_tm=result_info.element("mer_tm");
				// Element _mer_order_id=result_info.element("mer_order_id");
				// Element _stat=result_info.element("stat");
				// Element _pay_cur=result_info.element("pay_cur");
				// Element _payment_id=result_info.element("payment_id");
				// Element _pay_txn_tm=result_info.element("pay_txn_tm");
			}
		} catch (Exception e) {
			_calculateinterestForm.setReturn_message("远程通信中断，请检查网络！");
			e.printStackTrace();
		}
		return _calculateinterestForm;
	}

	// 卡无密支付接口
	/*
	 * mer_id--, mer_tm--, order_id--, mer_order_id--, pay_cur--, payment_id--,
	 * amount--, card_id--, type--
	 */
	public static CalculateinterestForm cardPayNoPassword(String mer_id,
			String mer_tm, String order_id, String mer_order_id,
			String pay_cur, String payment_id, String amount, String card_id,
			String type, BranchparametersForm _branchInfoform) {
		CalculateinterestForm _calculateinterestForm = new CalculateinterestForm();
		initParameters(_branchInfoform);// 初始化参数
		try {
			SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (timeError) {
				_sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			}
			String timestamp = _sf.format(new Date());// 时间戳
			String cardblock = timestamp + "aop" + card_id;// cardblock构成
			byte[] key = DESKey.getBytes("UTF8");// 密钥编码
			byte[] iv = DESKey.getBytes("UTF8");// 初始向量编码
			byte[] carddata = DESEncryptDecrypt.CBCEncrypt(
					cardblock.getBytes("UTF-8"), key, iv);// DES加密
			String _cardDesInfo = (new sun.misc.BASE64Encoder())
					.encode(carddata);// Base64编码后的DES数据
			String des_card_urlencode = URLEncoder
					.encode(_cardDesInfo, "UTF-8");// urlencode转义
			String signstring = "" + app_secret + "amount" + amount + "app_key"
					+ app_key + "card_id" + _cardDesInfo + "formatxmlmer_id"
					+ mer_id + "mer_order_id" + mer_order_id + "mer_tm"
					+ mer_tm
					+ "methodallinpay.card.paywithcontract.addorder_id"
					+ order_id + "pay_cur" + pay_cur + "payment_id"
					+ payment_id + "sign_methodmd5sign_v1timestamp" + timestamp
					+ "type" + type + "v" + api_v + "" + app_secret + "";// 需要签名的字符串
			String md5sign = MD5.signature(signstring);// 对字符串进行md5加密
			String url = befurl
					+ "app_key="
					+ app_key
					+ "&format=xml&v="
					+ api_v
					+ "&sign_method=md5&sign_v=1&method=allinpay.card.paywithcontract.add&timestamp="
					+ timestamp + "&card_id=" + des_card_urlencode + "&mer_tm="
					+ mer_tm + "&mer_order_id=" + mer_order_id + "&pay_cur="
					+ pay_cur + "&payment_id=" + payment_id + "&amount="
					+ amount + "&order_id=" + order_id + "&type=" + type
					+ "&mer_id=" + mer_id + "&sign=" + md5sign + "";// 拼装url
			// System.out.println(url);
			URL urls = new URL(url);// url定义
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(urls);
			Element rootElm = document.getRootElement();// 获取根节点
			Element theorder_id = rootElm.element("order_id");
			if ("error_response".equals(rootElm.getName())) {// 如果出现错误
				Element sub_msg = rootElm.element("sub_msg");
				_calculateinterestForm
						.setReturn_message(null == sub_msg ? rootElm.element(
								"msg").getText() : sub_msg.getText());
			} else {
				_calculateinterestForm.setReturn_message("00");// 设置00为成功返回标识
				Element result_info = rootElm.element("pay_result_info");
				_calculateinterestForm.setCard_id(result_info
						.element("card_id").getText());
				_calculateinterestForm.setAmount(result_info.element("amount")
						.getText());
				_calculateinterestForm.setOrder_id(theorder_id.getText());
				_calculateinterestForm.setMer_id(result_info.element("mer_id")
						.getText());
				_calculateinterestForm.setPay_txn_id(result_info.element(
						"pay_txn_id").getText());
				_calculateinterestForm.setMer_order_id(result_info.element(
						"mer_order_id").getText());
				// Element _type=result_info.element("type");
				// Element _mer_tm=result_info.element("mer_tm");
				// Element _mer_order_id=result_info.element("mer_order_id");
				// Element _stat=result_info.element("stat");
				// Element _pay_cur=result_info.element("pay_cur");
				// Element _payment_id=result_info.element("payment_id");
				// Element _pay_txn_tm=result_info.element("pay_txn_tm");
			}
		} catch (Exception e) {
			_calculateinterestForm.setReturn_message("远程通信中断，请检查网络！");
			e.printStackTrace();
		}
		return _calculateinterestForm;
	}

	// 卡内转账
	public static CalculateinterestForm cardaccounttransfer(String card_id,
			String password, String trans_card_id, String prdt_no,
			String trans_prdt_no, String amout, String order_id,
			BranchparametersForm _branchInfoform) {
		CalculateinterestForm _calculateinterestForm = new CalculateinterestForm();
		initParameters(_branchInfoform);// 初始化参数
		URL urls = null;
		HttpURLConnection urlConnection = null;
		try {
			SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (timeError) {
				_sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			}
			String timestamp = _sf.format(new Date());// 时间戳
			String passblock = timestamp + "aop" + password;// passblock构成
			byte[] key = DESKey.getBytes("UTF8");// 密钥编码
			byte[] iv = DESKey.getBytes("UTF8");// 初始向量编码
			byte[] passdata = DESEncryptDecrypt.CBCEncrypt(
					passblock.getBytes("UTF-8"), key, iv);// DES加密
			String _passDesInfo = (new sun.misc.BASE64Encoder())
					.encode(passdata);// Base64编码后的DES数据
			String des_pass_urlencode = URLEncoder
					.encode(_passDesInfo, "UTF-8");// urlencode转义
			String signstring = ""
					+ app_secret
					+ "amount"
					+ amout
					+ "app_key"
					+ app_key
					+ "card_id"
					+ card_id
					+ "formatxmlmethodallinpay.card.cardaccount.transferorder_id"
					+ order_id + "password" + _passDesInfo + "prdt_no"
					+ prdt_no + "sign_methodmd5sign_v1timestamp" + timestamp
					+ "trans_card_id" + trans_card_id + "trans_prdt_no"
					+ trans_prdt_no + "v" + api_v + "" + app_secret + "";// 需要签名的字符串
			String md5sign = MD5.signature(signstring);// 对字符串进行md5加密
			String url = befurl
					+ "app_key="
					+ app_key
					+ "&format=xml&v="
					+ api_v
					+ "&sign_method=md5&sign_v=1&method=allinpay.card.cardaccount.transfer&timestamp="
					+ timestamp + "&card_id=" + card_id + "&trans_prdt_no="
					+ trans_prdt_no + "&prdt_no=" + prdt_no + "&trans_card_id="
					+ trans_card_id + "&amount=" + amout + "&password="
					+ des_pass_urlencode + "&order_id=" + order_id + "&sign="
					+ md5sign + "";// 拼装url
			urls = new URL(url);// url定义
			urlConnection = (HttpURLConnection) urls.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setUseCaches(false);
			urlConnection.setRequestProperty("content-type",
					"application/x-www-form-urlencoded");
			OutputStreamWriter out = new OutputStreamWriter(
					urlConnection.getOutputStream());
			out.flush();
			out.close();

			// ByteArrayOutputStream ms = null;
			// ms = new ByteArrayOutputStream();
			// byte[] buf = new byte[4096];
			// int count;
			// while ((count = urlConnection.getInputStream().read(buf, 0,
			// buf.length)) > 0)
			// {
			// ms.write(buf, 0, count);
			// };
			// String respText = new String(ms.toByteArray(), "UTF-8");
			// System.out.println(respText);
			//

			// 从服务器读取响应
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(urlConnection.getInputStream());
			Element rootElm = document.getRootElement();// 获取根节点
			Element theorder_id = rootElm.element("order_id");
			if ("error_response".equals(rootElm.getName())) {// 如果出现错误
				Element sub_msg = rootElm.element("sub_msg");
				_calculateinterestForm
						.setReturn_message(null == sub_msg ? rootElm.element(
								"msg").getText() : sub_msg.getText());
			} else {
				_calculateinterestForm.setReturn_message("00");// 设置00为成功返回标识
				_calculateinterestForm.setCard_id(rootElm.element("card_id")
						.getText());
				_calculateinterestForm.setAmount(rootElm.element("amount")
						.getText());
				_calculateinterestForm.setOrder_id(theorder_id.getText());
				_calculateinterestForm.setProduct_id(rootElm.element("prdt_no")
						.getText());
				_calculateinterestForm.setTrans_no(rootElm.element("trans_no")
						.getText());
				_calculateinterestForm.setTrans_card_id(rootElm.element(
						"trans_card_id").getText());
				_calculateinterestForm.setTrans_prdt_no(rootElm.element(
						"trans_prdt_no").getText());
			}
		} catch (Exception e) {
			_calculateinterestForm.setReturn_message("远程通信中断，请检查网络！");
			e.printStackTrace();
		} finally {
			if (null != urlConnection) {
				urlConnection.disconnect();
			}
		}
		return _calculateinterestForm;
	}

	// 销卡
	public static CalculateinterestForm backcard(String card_id,
			String order_id, BranchparametersForm _branchInfoform) {
		CalculateinterestForm _calculateinterestForm = new CalculateinterestForm();
		initParameters(_branchInfoform);// 初始化参数
		URL urls = null;
		HttpURLConnection urlConnection = null;
		try {
			SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (timeError) {
				_sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			}
			String timestamp = _sf.format(new Date());// 时间戳
			String passblock = timestamp + "aop" + card_id;// passblock构成
			byte[] key = DESKey.getBytes("UTF8");// 密钥编码
			byte[] iv = DESKey.getBytes("UTF8");// 初始向量编码
			byte[] carddata = DESEncryptDecrypt.CBCEncrypt(
					passblock.getBytes("UTF-8"), key, iv);// DES加密
			String _carddataInfo = (new sun.misc.BASE64Encoder())
					.encode(carddata);// Base64编码后的DES数据
			String des_card_urlencode = URLEncoder.encode(_carddataInfo,
					"UTF-8");// urlencode转义
			String signstring = "" + app_secret + "app_key" + app_key
					+ "card_id" + _carddataInfo
					+ "formatxmlmethodallinpay.ppcs.cardreturn.addorder_id"
					+ order_id + "sign_methodmd5sign_v1timestamp" + timestamp
					+ "v" + api_v + "" + app_secret + "";// 需要签名的字符串
			String md5sign = MD5.signature(signstring);// 对字符串进行md5加密
			String url = befurl
					+ "app_key="
					+ app_key
					+ "&format=xml&v="
					+ api_v
					+ "&sign_method=md5&sign_v=1&method=allinpay.ppcs.cardreturn.add&timestamp="
					+ timestamp + "&card_id=" + des_card_urlencode
					+ "&order_id=" + order_id + "&sign=" + md5sign + "";// 拼装url
			urls = new URL(url);// url定义
			urlConnection = (HttpURLConnection) urls.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setUseCaches(false);
			urlConnection.setRequestProperty("content-type",
					"application/x-www-form-urlencoded");
			OutputStreamWriter out = new OutputStreamWriter(
					urlConnection.getOutputStream());
			out.flush();
			out.close();
			// 从服务器读取响应
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(urlConnection.getInputStream());
			Element rootElm = document.getRootElement();// 获取根节点
			if ("error_response".equals(rootElm.getName())) {// 如果出现错误
				Element sub_msg = rootElm.element("sub_msg");
				_calculateinterestForm
						.setReturn_message(null == sub_msg ? rootElm.element(
								"msg").getText() : sub_msg.getText());
			} else {
				Element _order_id = rootElm.element("order_id");
				Element _card_id = rootElm.element("card_id");
				Element _result = rootElm.element("result");
				_calculateinterestForm.setOrder_id(_order_id.getText());
				_calculateinterestForm.setCard_id(_card_id.getText());
				_calculateinterestForm.setReturn_message("true".equals(_result
						.getText()) ? "00" : "01");// 根据返回结果显示具体情况
				Element return_info_arrays = rootElm
						.element("return_info_arrays");
				ArrayList returnList = new ArrayList();
				for (Iterator i = return_info_arrays
						.elementIterator("return_info"); i.hasNext();) {
					CalculateinterestForm _retrunForm = new CalculateinterestForm();
					Element returninfo = (Element) i.next();
					_retrunForm.setAmount(returninfo.element("amount")
							.getText());
					_retrunForm.setPrdt_name(returninfo.element("prdt_name")
							.getText());
					_retrunForm.setProduct_id(returninfo.element("prdt_no")
							.getText());
					_retrunForm.setRescode(returninfo.element("rescode")
							.getText());
					_retrunForm.setTrans_no(returninfo.element("trans_no")
							.getText());
					_retrunForm.setReason(returninfo.element("reason")
							.getText());
					returnList.add(_retrunForm);// 产品集
				}
				_calculateinterestForm.setCardproductList(returnList);//
			}
		} catch (Exception e) {
			_calculateinterestForm.setReturn_message("远程通信中断，请检查网络！");
			e.printStackTrace();
		} finally {
			if (null != urlConnection) {
				urlConnection.disconnect();
			}
		}
		return _calculateinterestForm;
	}

	// 修改卡密码
	public static CalculateinterestForm changePasswordAPI(String strcardid,
			String strpassword, String strnewpassword, String strorderid,
			BranchparametersForm _branchInfoform) {
		CalculateinterestForm _calculateinterestForm = new CalculateinterestForm();
		initParameters(_branchInfoform);// 初始化参数
		try {
			SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (timeError) {
				_sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			}
			String timestamp = _sf.format(new Date());// 时间戳
			String passwd = timestamp + "aop" + strpassword;// pinblock构成
			String newpasswd = timestamp + "aop" + strnewpassword;// pinblock构成
			byte[] key = DESKey.getBytes("UTF8");// 密钥编码
			byte[] iv = DESKey.getBytes("UTF8");// 初始向量编码
			byte[] passwddata = DESEncryptDecrypt.CBCEncrypt(
					passwd.getBytes("UTF-8"), key, iv);// DES加密
			byte[] newpasswddata = DESEncryptDecrypt.CBCEncrypt(
					newpasswd.getBytes("UTF-8"), key, iv);// DES加密
			String _passwdDesInfo = (new sun.misc.BASE64Encoder())
					.encode(passwddata);// Base64编码后的DES数据
			String _newpasswdDesInfo = (new sun.misc.BASE64Encoder())
					.encode(newpasswddata);// Base64编码后的DES数据
			String des_urlpassencode = URLEncoder.encode(_passwdDesInfo,
					"UTF-8");// urlencode转义
			String des_urlnewpassencode = URLEncoder.encode(_newpasswdDesInfo,
					"UTF-8");// urlencode转义
			String signstring = ""
					+ app_secret
					+ "app_key"
					+ app_key
					+ "card_id"
					+ strcardid
					+ "formatxmlmethodallinpay.card.password.changenew_password"
					+ _newpasswdDesInfo + "order_id" + strorderid + "password"
					+ _passwdDesInfo + "sign_methodmd5sign_v1timestamp"
					+ timestamp + "v" + api_v + "" + app_secret + "";// 需要签名的字符串
			String md5sign = MD5.signature(signstring);// 对字符串进行md5加密
			String url = befurl
					+ "app_key="
					+ app_key
					+ "&format=xml&v="
					+ api_v
					+ "&sign_method=md5&sign_v=1&method=allinpay.card.password.change&timestamp="
					+ timestamp + "&order_id=" + strorderid + "&card_id="
					+ strcardid + "&password=" + des_urlpassencode
					+ "&new_password=" + des_urlnewpassencode + "&sign="
					+ md5sign + "";// 拼装url
			URL urls = new URL(url);// url定义
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(urls);
			System.out.println(" changePasswordAPI document="
					+ formatXML(document));
			Element rootElm = document.getRootElement();// 获取根节点
			if ("error_response".equals(rootElm.getName())) {// 如果出现错误
				Element sub_msg = rootElm.element("sub_msg");
				_calculateinterestForm
						.setReturn_message(null == sub_msg ? rootElm.element(
								"msg").getText() : sub_msg.getText());
			} else {
				Element card_id = rootElm.element("card_id");
				Element order_id = rootElm.element("order_id");
				Element trans_no = rootElm.element("trans_no");
				_calculateinterestForm.setReturn_message("00");// 设置00为成功返回标识
				_calculateinterestForm.setCard_id(card_id.getText());
				_calculateinterestForm.setOrder_id(order_id.getText());
				_calculateinterestForm.setTrans_no(trans_no.getText());
			}
		} catch (Exception e) {
			_calculateinterestForm.setReturn_message("远程通信中断，请检查网络！");
			e.printStackTrace();
		}
		return _calculateinterestForm;
	}

	// 查询交易流水:0-挂起，1-失败，2-成功，3-已冲正，4-撤销
	public static CalculateinterestForm searchtxnlogAPI(String begindate,
			String enddate, String cardid, String password, String pageno,
			String pagesize, BranchparametersForm _branchInfoform) {
		CalculateinterestForm _calculateinterestForm = new CalculateinterestForm();
		initParameters(_branchInfoform);// 初始化参数
		begindate = begindate.replace("-", "");
		enddate = enddate.replace("-", "");
		URL urls = null;
		HttpURLConnection urlConnection = null;
		try {
			SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (timeError) {
				_sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			}
			String timestamp = _sf.format(new Date());// 时间戳
			String passwd = timestamp + "aop" + password;// pinblock构成
			byte[] key = DESKey.getBytes("UTF8");// 密钥编码
			byte[] iv = DESKey.getBytes("UTF8");// 初始向量编码
			byte[] passwddata = DESEncryptDecrypt.CBCEncrypt(
					passwd.getBytes("UTF-8"), key, iv);// DES加密
			String _passwdDesInfo = (new sun.misc.BASE64Encoder())
					.encode(passwddata);// Base64编码后的DES数据
			String des_urlpassencode = URLEncoder.encode(_passwdDesInfo,
					"UTF-8");// urlencode转义
			String signstring = ""
					+ app_secret
					+ "app_key"
					+ app_key
					+ "begin_date"
					+ begindate
					+ "card_id"
					+ cardid
					+ "end_date"
					+ enddate
					+ "formatxmlmethodallinpay.card.txnlogByCardId.searchpage_no"
					+ pageno + "page_size" + pagesize + "password"
					+ _passwdDesInfo + "sign_methodmd5sign_v1timestamp"
					+ timestamp + "v" + api_v + "" + app_secret + "";// 需要签名的字符串
			String md5sign = MD5.signature(signstring);// 对字符串进行md5加密
			String url = befurl
					+ "app_key="
					+ app_key
					+ "&format=xml&v="
					+ api_v
					+ "&sign_method=md5&sign_v=1&method=allinpay.card.txnlogByCardId.search&timestamp="
					+ timestamp + "&begin_date=" + begindate + "&card_id="
					+ cardid + "&password=" + des_urlpassencode + "&end_date="
					+ enddate + "&page_no=" + pageno + "&page_size=" + pagesize
					+ "&sign=" + md5sign + "";// 拼装url
			urls = new URL(url);// url定义
			urlConnection = (HttpURLConnection) urls.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setUseCaches(false);
			urlConnection.setRequestProperty("content-type",
					"application/x-www-form-urlencoded");
			OutputStreamWriter out = new OutputStreamWriter(
					urlConnection.getOutputStream());
			out.flush();
			out.close();
			// 从服务器读取响应
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(urlConnection.getInputStream());
			System.out.println("searchtxnlogAPI document="
					+ formatXML(document));
			Element rootElm = document.getRootElement();// 获取根节点
			if ("error_response".equals(rootElm.getName())) {// 如果出现错误
				Element sub_msg = rootElm.element("sub_msg");
				_calculateinterestForm
						.setReturn_message(null == sub_msg ? rootElm.element(
								"msg").getText() : sub_msg.getText());
			} else {
				_calculateinterestForm.setReturn_message("00");
				Element total = rootElm.element("total");
				if (null == total || "".equals(total.getText())
						|| "0".equals(total.getText())) {
					return _calculateinterestForm;
				} else {
					Element txn_log_arrays = rootElm.element("txn_log_arrays");
					ArrayList returnList = new ArrayList();
					int count = 1;
					for (Iterator i = txn_log_arrays.elementIterator("txn_log"); i
							.hasNext();) {
						CalculateinterestForm _retrunForm = new CalculateinterestForm();
						Element returninfo = (Element) i.next();
						_retrunForm.setI(String.valueOf(count++));
						_retrunForm.setCard_id(returninfo.element("card_id")
								.getText());// 卡号
						_retrunForm.setProduct_id(returninfo.element("prdt_no")
								.getText());// 产品号
						_retrunForm.setInt_txn_dt(returninfo.element(
								"int_txn_dt").getText());// 交易日期
						_retrunForm.setInt_txn_tm(returninfo.element(
								"int_txn_tm").getText());// 交易时间
						_retrunForm.setAccept_brh_id(returninfo.element(
								"accept_brh_id").getText());// 商户号
						_retrunForm.setInt_txn_seq_id(returninfo.element(
								"int_txn_seq_id").getText());// 交易流水
						_retrunForm.setAccess_ref_seq_id(returninfo.element(
								"access_ref_seq_id").getText());// 交易参考号
						_retrunForm.setTxn_at(df.format(Double
								.parseDouble(returninfo.element("txn_at")
										.getText()) / 100));// 交易金额
						_retrunForm.setTxn_fee_at(df.format(Double
								.parseDouble(returninfo.element("txn_fee_at")
										.getText()) / 100));// 手续费
						// 0-挂起，1-失败，2-成功，3-已冲正，4-撤销
						String sta = returninfo.element("txn_sta_cd").getText();
						if ("2".equals(sta)) {
							_retrunForm.setTxn_sta_cd("成功");
						} else if ("1".equals(sta)) {
							_retrunForm.setTxn_sta_cd("失败");
						} else if ("4".equals(sta)) {
							_retrunForm.setTxn_sta_cd("撤销");
						} else if ("3".equals(sta)) {
							_retrunForm.setTxn_sta_cd("已冲正");
						} else if ("1".equals(sta)) {
							_retrunForm.setTxn_sta_cd("挂起");
						}
						_retrunForm.setTerm_id(returninfo.element("term_id")
								.getText());// 终端号
						_retrunForm.setTxn_cd(returninfo.element("txn_cd")
								.getText());// 交易码
						returnList.add(_retrunForm);// 交易流水级
						String time = _retrunForm.getInt_txn_dt()
								+ _retrunForm.getInt_txn_tm();
						time = DateManager.getStringTime(
								DateManager.DATE_TIME_PATTERN1, time,
								DateManager.DATE_TIME_PATTERN2);
						_retrunForm.setTrans_time(time);
						time = DateManager.getStringTime(
								DateManager.DATE_TIME_PATTERN2, time,
								DateManager.DATE_TIME_PATTERN3);
						_retrunForm.setTrans_time_wx(time);
					}
					_calculateinterestForm.setCardproductList(returnList);//
				}
			}
		} catch (Exception e) {
			_calculateinterestForm.setReturn_message("远程通信中断，请检查网络！");
			e.printStackTrace();
		} finally {
			if (null != urlConnection) {
				urlConnection.disconnect();
			}
		}
		return _calculateinterestForm;
	}

	// 查询余额API:根据生产环境做修正
	public static CalculateinterestForm getCardinfoNopassAPI(String strcardid,
			String strorderid, BranchparametersForm _branchInfoform) {
		CalculateinterestForm _calculateinterestForm = new CalculateinterestForm();
		initParameters(_branchInfoform);// 初始化参数
		ArrayList producList = new ArrayList();
		try {
			SimpleDateFormat _sf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (timeError) {
				_sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			}
			String timestamp = _sf.format(new Date());// 时间戳
			String signstring = "" + app_secret + "app_key" + app_key
					+ "card_id" + strcardid
					+ "formatxmlmethodallinpay.ppcs.cardinfo.getorder_id"
					+ strorderid + "sign_methodmd5sign_v1timestamp" + timestamp
					+ "v" + api_v + "" + app_secret + "";// 需要签名的字符串
			String md5sign = MD5.signature(signstring);// 对字符串进行md5加密
			String url = befurl
					+ "app_key="
					+ app_key
					+ "&format=xml&v="
					+ api_v
					+ "&sign_method=md5&sign_v=1&method=allinpay.ppcs.cardinfo.get&timestamp="
					+ timestamp + "&card_id=" + strcardid + "&order_id="
					+ strorderid + "&sign=" + md5sign + "";// 拼装url
			URL urls = new URL(url);// url定义
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(urls);
			System.out.println("document=" + formatXML(document));
			Element rootElm = document.getRootElement();// 获取根节点
			if ("error_response".equals(rootElm.getName())) {// 如果出现错误
				Element sub_msg = rootElm.element("sub_msg");
				_calculateinterestForm
						.setReturn_message(null == sub_msg ? rootElm.element(
								"msg").getText() : sub_msg.getText());
			} else {
				Element cardinfo = rootElm.element("card_info");
				Element card_product_info_arrays = cardinfo
						.element("card_product_info_arrays");
				_calculateinterestForm.setReturn_message("00");// 设置00为成功返回标识
				for (Iterator i = card_product_info_arrays
						.elementIterator("card_product_info"); i.hasNext();) {
					Element card = (Element) i.next();
					CalculateinterestForm _productForm = new CalculateinterestForm();
					_productForm.setProduct_id(card.element("product_id")
							.getText());
					String account_balance = card.element("valid_balance")
							.getText();// 账户余额:查询的是可用余额
					_productForm.setAccount_balance(df.format(Double
							.parseDouble(account_balance) / 100));// 设置账户余额，转化为元
					_productForm.setCard_id(card.element("card_id").getText());// 设置卡号
					_productForm.setProduct_state(card.element("product_stat")
							.getText());// 设置产品状态
					producList.add(_productForm);// 产品集
				}
				_calculateinterestForm.setCardproductList(producList);
			}
		} catch (Exception e) {
			_calculateinterestForm.setReturn_message("远程通信中断，请检查网络！");
			e.printStackTrace();
		}
		return _calculateinterestForm;
	}

	public static String formatXML(Document doc) throws Exception {
		StringWriter out = null;
		try {
			OutputFormat formate = OutputFormat.createPrettyPrint();
			out = new StringWriter();
			XMLWriter writer = new XMLWriter(out, formate);
			writer.write(doc);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return out.toString();
	}

}
