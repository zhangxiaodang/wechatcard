package cn.com.allinpay.wechatcard.view;


import java.sql.Timestamp;

import cn.com.allinpay.frame.view.BaseView;

/**
 * 
 * 会员卡view.
 * 
 * @version V1.00.
 * 
 */
public class WEC0021View extends BaseView{
	
	/**
	 * 会员卡ID
	 */
	private String merbercardid = "";
	/**
	 * 会员ID
	 */
	private String memberid = "";
	/**
	 * 商家ID(冗余，供查询方便用)
	 */
	private String merchantid = "";
	/**
	 * 会员卡号（预付卡系统后台实体卡号）
	 */
	private String cardno = "";
	/**
	 * 电子卡号（预付卡系统后台电子卡号）
	 */
	private String dzcardno = "";
	/**
	 * 会员卡等级
	 */
	private String cardgrade = "";
	/**
	 * 会员卡二维码信息
	 */
	private String cardcode = "";
	/**
	 * 卡状态
	 */
	private String cardstat = "";
	/**
	 * 申请会员卡时间
	 */
	private Timestamp cardsqsj = null;
	/**
	 * 申请会员卡方式（申请新卡或绑定旧卡
	 */
	private String cardmode = "";
	/**
	 * 备注信息
	 */
	private String bz = "";
	/**
	 * 会员卡密码
	 */
	private String password = "";
	/**
	 * 卡名称
	 */
	private String cardname = "";
	public String getMerbercardid() {
		return merbercardid;
	}
	public void setMerbercardid(String merbercardid) {
		this.merbercardid = merbercardid;
	}
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
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getDzcardno() {
		return dzcardno;
	}
	public void setDzcardno(String dzcardno) {
		this.dzcardno = dzcardno;
	}
	public String getCardgrade() {
		return cardgrade;
	}
	public void setCardgrade(String cardgrade) {
		this.cardgrade = cardgrade;
	}
	public String getCardcode() {
		return cardcode;
	}
	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}
	public String getCardstat() {
		return cardstat;
	}
	public void setCardstat(String cardstat) {
		this.cardstat = cardstat;
	}
	public String getCardmode() {
		return cardmode;
	}
	public void setCardmode(String cardmode) {
		this.cardmode = cardmode;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCardsqsj() {
		return cardsqsj;
	}
	public void setCardsqsj(Timestamp cardsqsj) {
		this.cardsqsj = cardsqsj;
	}
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	
}
