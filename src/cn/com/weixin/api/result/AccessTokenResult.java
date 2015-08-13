package cn.com.weixin.api.result;

import java.io.Serializable;

import cn.com.weixin.api.util.WeixinMsgConstValue;

/**
 * 微信应用取得access_token结果类.
 */

public class AccessTokenResult extends AbstractResult implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = -1761944807700812709L;

	/** AccessToekn */
	private String access_token = WeixinMsgConstValue.EMPTY;

	/** expires_in */
	private int expires_in = 0;

	/**
	 * 取得AccessToken.
	 * 
	 * @return String
	 */
	public String getAccess_token() {
		return this.access_token;
	}

	/**
	 * 设定AccessToken.
	 * 
	 * @param access_token
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * 取得Expiresin.
	 * 
	 * @return int
	 */
	public int getExpires_in() {
		return this.expires_in;
	}

	/**
	 * 设定Expiresin.
	 * 
	 * @param expires_in
	 */
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
}
