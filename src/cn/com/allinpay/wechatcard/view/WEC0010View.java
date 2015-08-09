package cn.com.allinpay.wechatcard.view;

import cn.com.allinpay.frame.view.BaseView;

/**
 * Copyright(C) JiNanShangJie 2014.
 * 
 * 会员view.
 * 
 * @author 张振峰 2015/08/09.
 * 
 * @version V1.00.
 * 
 *          更新履历： V1.00 2015/08/09 张振峰 创建.
 */
public class WEC0010View extends BaseView{
	
	/**
	 * 会员ID
	 */
	private String memberid = "";
	/**
	 * 商家ID
	 */
	private String merchantid = "";
	/**
	 * 会员针对商家公众号的OPENID
	 */
	private String memberopenid = "";
	/**
	 * 会员姓名
	 */
	private String membername = "";
	/**
	 * 会员性别
	 */
	private String membersex = "";
	/**
	 * 会员生日
	 */
	private String memberbirthday = "";
	/**
	 * 会员手机号
	 */
	private String memberphone = "";
	/**
	 * 会员验证码
	 */
	private String memberyzm = "";
	/**
	 * 会员级别
	 */
	private String membergrade = "";
	/**
	 * 会员申请时间
	 */
	private String membersqsj = "";
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}
	public String getMemberopenid() {
		return memberopenid;
	}
	public void setMemberopenid(String memberopenid) {
		this.memberopenid = memberopenid;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMembersex() {
		return membersex;
	}
	public void setMembersex(String membersex) {
		this.membersex = membersex;
	}
	public String getMemberbirthday() {
		return memberbirthday;
	}
	public void setMemberbirthday(String memberbirthday) {
		this.memberbirthday = memberbirthday;
	}
	public String getMemberphone() {
		return memberphone;
	}
	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}
	public String getMemberyzm() {
		return memberyzm;
	}
	public void setMemberyzm(String memberyzm) {
		this.memberyzm = memberyzm;
	}
	public String getMembergrade() {
		return membergrade;
	}
	public void setMembergrade(String membergrade) {
		this.membergrade = membergrade;
	}
	public String getMembersqsj() {
		return membersqsj;
	}
	public void setMembersqsj(String membersqsj) {
		this.membersqsj = membersqsj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	/**
	 * 备注信息
	 */
	private String bz = "";
	
	

}
