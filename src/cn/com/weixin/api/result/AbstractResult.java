package cn.com.weixin.api.result;

/**
 * 微信应用返回结果基类.
 */

public abstract class AbstractResult {

	/** 返回码 */
	private int errcode = 0;

	/** 返回信息 */
	private String errmsg = "";

	/**
	 * 取得返回码.
	 * 
	 * @return String
	 */
	public int getErrcode() {
		return this.errcode;
	}

	/**
	 * 设定返回码.
	 * 
	 * @param errcode
	 */
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	/**
	 * 取得返回信息.
	 * 
	 * @return String
	 */
	public String getErrmsg() {
		return this.errmsg;
	}

	/**
	 * 设定返回信息.
	 * 
	 * @param errmsg
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	/**
	 * 是否有异常。
	 * 
	 * @return true:有异常 false:正常
	 */
	public boolean isError() {

		// 返回code为0时正常
		if (this.errcode == 0) {
			return false;
		} else {
			// 其它时有异常
			return true;
		}
	}
}
