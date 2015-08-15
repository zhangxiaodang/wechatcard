package cn.com.allinpay.wechatcard.view;

/**
 * 
 * 优惠券
 * @author margin
 *
 */
public class CouponView {
	
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
	private String couponsj = "";
	// 备注信息
	private String bz = "";
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
	public String getCouponsj() {
		return couponsj;
	}
	public void setCouponsj(String couponsj) {
		this.couponsj = couponsj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	

}
