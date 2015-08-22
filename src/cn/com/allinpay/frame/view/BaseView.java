package cn.com.allinpay.frame.view;

/**
 * 
 * BaseView。所有的view将继承他
 * 
 * @version V1.00.
 * 
 */
public class BaseView {
	/** urlflag **/
	private String urlflag = "";
	
	/** openid **/
	private String openid = "";

	public String getUrlflag() {
		return urlflag;
	}

	public void setUrlflag(String urlflag) {
		this.urlflag = urlflag;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
}
