package cn.com.allinpay.wechatcard.view;

import cn.com.allinpay.frame.view.BaseView;

/**
 * 
 * 消费记录view.
 * 
 * @version V1.00.
 * 
 */
public class WEC0033View extends BaseView{
	
	// 电子卡号
	private String dzcardno = "";
	
	// 每页显示条数
	private int rows = 10;
	// 当前页数
	private int page_num = 0;
	
	// 显示的开始条数
	private int rn_start = 1;
	// 显示的结束条数
	private int rn_end = 10;
	public String getDzcardno() {
		return dzcardno;
	}

	public void setDzcardno(String dzcardno) {
		this.dzcardno = dzcardno;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage_num() {
		return page_num;
	}

	public void setPage_num(int page_num) {
		this.page_num = page_num;
	}

	public int getRn_start() {
		this.rn_start = this.rows * this.page_num + 1;
		return rn_start;
	}

	public void setRn_start(int rn_start) {
		this.rn_start = rn_start;
	}

	public int getRn_end() {
		this.rn_end = this.rows * (this.page_num + 1);
		return rn_end;
	}

	public void setRn_end(int rn_end) {
		this.rn_end = rn_end;
	}
	
}
