package cn.com.allinpay.wechatcard.view;

import java.sql.Timestamp;
import java.util.Date;

import cn.com.allinpay.frame.view.BaseView;

/**
 * 
 * 优惠券
 * @author margin
 *
 */
public class CouponView extends BaseView{
	
	// 会员优惠券标识id
	private String couponid = "";
	// 会员ID 
	private String memberid = "";
	// 商家优惠券ID
	private String merchantcouponid = "";
	// 商家ID（冗余，供查询方便用）
	private String merchantid = "";
	// 优惠券状态
	private String membercouponstate = "";
	// 优惠券的二维码信息
	private String couponcode = "";
	// 申领优惠券时间
	private Timestamp couponsj = null;
	// 备注信息
	private String bz = "";
	// 优惠券的有效开始时间
	private Date starttime = null;
	// 优惠券的有效结束时间
	private Date endtime = null;
	// 优惠券名称
	private String couponname = "";
	// 优惠券类别
	private String coupontype = "";
	// 优惠券图片
	private String couponimg = "";
	// 优惠券内容
	private String couponcontent = "";
	public String getCouponid() {
		return couponid;
	}
	public void setCouponid(String couponid) {
		this.couponid = couponid;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMerchantcouponid() {
		return merchantcouponid;
	}
	public void setMerchantcouponid(String merchantcouponid) {
		this.merchantcouponid = merchantcouponid;
	}
	public String getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}
	public String getMembercouponstate() {
		return membercouponstate;
	}
	public void setMembercouponstate(String membercouponstate) {
		this.membercouponstate = membercouponstate;
	}
	public String getCouponcode() {
		return couponcode;
	}
	public void setCouponcode(String couponcode) {
		this.couponcode = couponcode;
	}
	public Timestamp getCouponsj() {
		return couponsj;
	}
	public void setCouponsj(Timestamp couponsj) {
		this.couponsj = couponsj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getCouponname() {
		return couponname;
	}
	public void setCouponname(String couponname) {
		this.couponname = couponname;
	}
	public String getCoupontype() {
		return coupontype;
	}
	public void setCoupontype(String coupontype) {
		this.coupontype = coupontype;
	}
	public String getCouponimg() {
		return couponimg;
	}
	public void setCouponimg(String couponimg) {
		this.couponimg = couponimg;
	}
	public String getCouponcontent() {
		return couponcontent;
	}
	public void setCouponcontent(String couponcontent) {
		this.couponcontent = couponcontent;
	}
}
