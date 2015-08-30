package cn.com.allinpay.wechatcard.view;

import cn.com.allinpay.frame.view.BaseView;

/**
 * 
 * 商家优惠券领取view.
 * 
 * @version V1.00.
 * 
 */
public class WEC0041View extends BaseView{
	
	/**
	 * 优惠券id
	 */
	private String couponid = "";
	// 商家优惠券id
	private String merchantcouponid = "";
	// 商家ID
	private String merchantid = "";
	// 优惠券分类
	private String couponclass = "";
	// 优惠券有效期
	private String couponvalid = "";
	// 优惠券有效期的起始时间
	private String couponkssj = "";
	// 优惠券有效期的结束时间
	private String couponjssj = "";
	// 商家优惠券内容
	private String couponcontent = "";
	// 商家优惠券内容
	private String merchantcouponstate = "";
	// 备注信息
	private String bz = "";
	// 优惠券名称
	private String couponname = "";
	// 优惠券图片
	private String couponimg = "";
	public String getCouponid() {
		return couponid;
	}
	public void setCouponid(String couponid) {
		this.couponid = couponid;
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
	public String getCouponclass() {
		return couponclass;
	}
	public void setCouponclass(String couponclass) {
		this.couponclass = couponclass;
	}
	public String getCouponvalid() {
		return couponvalid;
	}
	public void setCouponvalid(String couponvalid) {
		this.couponvalid = couponvalid;
	}
	public String getCouponkssj() {
		return couponkssj;
	}
	public void setCouponkssj(String couponkssj) {
		this.couponkssj = couponkssj;
	}
	public String getCouponjssj() {
		return couponjssj;
	}
	public void setCouponjssj(String couponjssj) {
		this.couponjssj = couponjssj;
	}
	public String getMerchantcouponstate() {
		return merchantcouponstate;
	}
	public void setMerchantcouponstate(String merchantcouponstate) {
		this.merchantcouponstate = merchantcouponstate;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getCouponname() {
		return couponname;
	}
	public void setCouponname(String couponname) {
		this.couponname = couponname;
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
