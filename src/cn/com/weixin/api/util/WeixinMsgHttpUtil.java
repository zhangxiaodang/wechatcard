package cn.com.weixin.api.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Http请求类.
 */

public class WeixinMsgHttpUtil {

	/**
	 * 使用GET方法得到一个URL的数据.
	 * 
	 * @param pstrUrl
	 *            URL
	 * @return String
	 * 
	 * @throws Exception
	 */
	public static String getResponseWithGET(String pstrUrl) throws Exception {

		// 返回值
		String strResponseBody = WeixinMsgConstValue.EMPTY;
		// Http Client
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			// http get
			HttpGet httpget = new HttpGet(pstrUrl);
			// Response
			CloseableHttpResponse response = httpclient.execute(httpget);

			try {
				// 取得返回值
				HttpEntity entity = response.getEntity();
				// 判断返回值
				strResponseBody = entity != null ? EntityUtils.toString(entity,
						"UTF-8") : WeixinMsgConstValue.EMPTY;
			} finally {
				response.close();
			}

		} finally {
			httpclient.close();
		}

		// 返回
		return strResponseBody;
	}

	/**
	 * 使用POST方法得到一个URL的数据.
	 * 
	 * @param pstrUrl
	 *            URL
	 * 
	 * @return 返回值.
	 * 
	 * @throws Exception
	 */
	public static String getResponseWithPOST(String pstrUrl) throws Exception {

		// 返回值
		String strResponseBody = WeixinMsgConstValue.EMPTY;
		// Http Client
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			// http post
			HttpPost httpPost = new HttpPost(pstrUrl);
			// Response
			CloseableHttpResponse response = httpclient.execute(httpPost);

			try {
				// 取得返回值
				HttpEntity entity = response.getEntity();
				// 判断返回值
				strResponseBody = entity != null ? EntityUtils.toString(entity,
						"UTF-8") : WeixinMsgConstValue.EMPTY;
			} finally {
				response.close();
			}

		} finally {
			httpclient.close();
		}

		// 返回
		return strResponseBody;
	}

	/**
	 * 使用POST方法得到一个URL的数据.
	 * 
	 * @param pstrUrl
	 *            URL
	 * 
	 * @param pstrPostBodyData
	 *            POST数据.
	 * 
	 * @return String POST请求返回值.
	 * 
	 * @throws Exception
	 */
	public static String getResponseWithPOST(String pstrUrl,
			String pstrPostBodyData) throws Exception {

		// 返回值
		String strResponseBody = WeixinMsgConstValue.EMPTY;
		// Http Client
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			// http post
			HttpPost httpPost = new HttpPost(pstrUrl);

			// POST数据
			StringEntity postEntity = new StringEntity(pstrPostBodyData,
					ContentType.create("text/plain", "UTF-8"));
			// 设定POST数据
			httpPost.setEntity(postEntity);
			// Response
			CloseableHttpResponse response = httpclient.execute(httpPost);

			try {
				// 取得返回值
				HttpEntity entity = response.getEntity();
				// 判断返回值
				strResponseBody = entity != null ? EntityUtils.toString(entity,
						"UTF-8") : WeixinMsgConstValue.EMPTY;
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}

		// 返回
		return strResponseBody;
	}
}
