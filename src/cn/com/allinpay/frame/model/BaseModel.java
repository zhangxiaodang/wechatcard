package cn.com.allinpay.frame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.allinpay.frame.util.WebConstantValue;

/**
 * 
 * BaseModel。所有的model将继承他
 * 
 * @version V1.00.
 * 
 */
public class BaseModel {
	
	/** 状态. */
	private String state = WebConstantValue.HTTP_OK;

	/** 提示信息. */
	private String msg;

	/** 总条数. */
	private int total;

	/** 前台渲染的List. */
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	
	/** urlflag **/
	private String urlflag = "";
	
	/** openid **/
	private String openid = "";
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

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
