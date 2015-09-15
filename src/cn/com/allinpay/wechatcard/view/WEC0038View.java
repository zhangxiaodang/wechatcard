package cn.com.allinpay.wechatcard.view;

import cn.com.allinpay.frame.view.BaseView;

/**
 * 充值记录查询view.
 */
public class WEC0038View extends BaseView {

	/** 电子卡号. */
	private String dzcardno = "";

	/** 密码. */
	private String passwd = "";

	/** 开始日期. */
	private String date_start = "";

	/** 结束日期. */
	private String date_end = "";

	public String getDzcardno() {
		return dzcardno;
	}

	public void setDzcardno(String dzcardno) {
		this.dzcardno = dzcardno;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getDate_start() {
		return date_start;
	}

	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}

	public String getDate_end() {
		return date_end;
	}

	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}
}