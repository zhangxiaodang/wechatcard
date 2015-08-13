package cn.com.weixin.api.result;

import java.io.Serializable;

/**
 * Copyright(C) SdShangJie 2014-2015.
 * 
 * 微信应用通过OAuth2.0网页授权获取用户openID结果类.
 * 
 * @author 张孝党 2014/03/14.
 * 
 * @version V1.00.
 * 
 *          更新履历： V1.00 2013/03/14 张孝党 创建.
 */
public class OAuthCodeResult extends AbstractResult implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1382938741866378966L;

	/** 网页授权接口调用凭证 */
	private String access_token;

	/** access_token接口调用凭证超时时间 */
	private int expires_in;

	/** 用户刷新access_token */
	private String refresh_token;

	/** 用户唯一标识 */
	private String openid;

	/** 用户授权的作用域 */
	private String scope;

	/**
	 * 取得网页授权接口调用凭证.
	 * 
	 * @return String
	 */
	public String getAccess_token() {
		return this.access_token;
	}

	/**
	 * 设定网页授权接口调用凭证.
	 * 
	 * @param access_token
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * 取得access_token接口调用凭证超时时间.
	 * 
	 * @return int
	 */
	public int getExpires_in() {
		return this.expires_in;
	}

	/**
	 * 设定access_token接口调用凭证超时时间.
	 * 
	 * @param expires_in
	 */
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * 取得用户刷新access_token.
	 * 
	 * @return String
	 */
	public String getRefresh_token() {
		return this.refresh_token;
	}

	/**
	 * 设定用户刷新access_token.
	 * 
	 * @param refresh_token
	 */
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	/**
	 * 取得用户唯一标识.
	 * 
	 * @return String
	 */
	public String getOpenid() {
		return this.openid;
	}

	/**
	 * 设定用户唯一标识.
	 * 
	 * @param openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 取得用户授权的作用域.
	 * 
	 * @return String
	 */
	public String getScope() {
		return this.scope;
	}

	/**
	 * 设定用户授权的作用域.
	 * 
	 * @param scope
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
}
