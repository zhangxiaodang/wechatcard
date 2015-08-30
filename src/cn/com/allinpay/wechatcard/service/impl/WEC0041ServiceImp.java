package cn.com.allinpay.wechatcard.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.allinpay.frame.service.BaseService;
import cn.com.allinpay.frame.util.WebConstantValue;
import cn.com.allinpay.frame.util.WebUtil;
import cn.com.allinpay.wechatcard.dao.CommonDao;
import cn.com.allinpay.wechatcard.dao.WEC0030Dao;
import cn.com.allinpay.wechatcard.dao.WEC0041Dao;
import cn.com.allinpay.wechatcard.model.WEC0034Model;
import cn.com.allinpay.wechatcard.service.IWEC0041Service;
import cn.com.allinpay.wechatcard.view.CouponView;
import cn.com.allinpay.wechatcard.view.WEC0010View;
import cn.com.allinpay.wechatcard.view.WEC0041View;

/**
 * 
 * 优惠券领取serviceImp
 * 
 * @version V1.00.
 * 
 */
@Service
public class WEC0041ServiceImp extends BaseService implements IWEC0041Service {

	/** logger **/
	private static final Logger logger = Logger
			.getLogger(WEC0041ServiceImp.class);

	/** 优惠券详细dao **/
	@Autowired
	private WEC0041Dao wec_0041_Dao;
	
	@Autowired
	private WEC0030Dao wec_0030_Dao;
	
	@Autowired
	private CommonDao commondao;
	/**
	 * 优惠券的service
	 */
	@Override
	public WEC0034Model get_coupon(WEC0041View wec0041View) throws Exception {
		logger.info("========================Service get_coupon Start==========================");
		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 获取用户已有的优惠券
		Map<String, Object> user_coupon_param = new HashMap<String, Object>();
		WEC0010View memberView = new WEC0010View();
		memberView.setUrlflag(wec0041View.getUrlflag());
		memberView.setOpenid(wec0041View.getOpenid());
		user_coupon_param.put(BEAN, memberView);
		// 返回前台提示信息
		WEC0034Model resultModel = new WEC0034Model();
		paramMap.put(BEAN, wec0041View);
		// 获取优惠券信息
		Map<String, Object> coupon_info = wec_0041_Dao.get_coupon(paramMap);
		// 获取用户已经有的优惠券
		List<Map<String, Object>> user_coupon = wec_0030_Dao.get_coupon(user_coupon_param);
		// 循环商家的优惠券，来标识出哪些别用户领取了。
		coupon_info.put("ly_zt","未领用");
		for(int j = 0; j < user_coupon.size(); j++){
			if(coupon_info.get("merchantcouponid").equals(user_coupon.get(j).get("merchantcouponid"))){
				coupon_info.put("ly_zt","已领用");
			}
		}
		
		// todo-zhangxd
		// 如果有空图片地址的话，给一个默认的图片地址。
		coupon_info = WebUtil.test_set_null_coupon_img_map(coupon_info);
		
		resultModel.setCoupon_info(coupon_info);
		resultModel.setState(WebConstantValue.HTTP_OK);

		logger.info("========================Service get_coupon End==========================");
		return resultModel;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public WEC0034Model collect_coupon(WEC0041View wec0041View) throws Exception {
		logger.info("========================Service collect_coupon Start==========================");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(BEAN, wec0041View);
		// 查询商家的id
		Map<String, String> merchant_info= commondao.getMerchantInfoByUrlFlag(wec0041View.getUrlflag());
		Map<String, String> member_param = new HashMap<String, String>();
		member_param.put("openid", wec0041View.getOpenid());
		// 查询会员id
		Map<String, String> member_info= commondao.getMemberIDByOpenID(member_param);
		// 从商户的优惠券中查询优惠券信息
		// 获取优惠券信息
		Map<String, Object> coupon_info = wec_0041_Dao.get_coupon(paramMap);
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		CouponView param = new CouponView();
		param.setCouponid(WebUtil.getUUID());
		// 会员ID
		param.setMemberid(member_info.get("memberid") + "");
		// 商家优惠券ID
		param.setMerchantcouponid(coupon_info.get("merchantcouponid") + "");
		// 商家ID
		param.setMerchantid(merchant_info.get("merchantid") + "");
		//优惠券状态--已领用
		param.setMembercouponstate(WebConstantValue.YLY);
		// 优惠券的二维码信息 todo，需要插入真是的二维码信息
		param.setCouponcode("");
		// 申领优惠券时间
		param.setCouponsj(new Timestamp(System.currentTimeMillis()));
		// 备注信息
		param.setBz(coupon_info.get("bz") + "");
		// 优惠券的有效开始时间
		param.setStarttime(sdf.parse(coupon_info.get("couponkssj") + ""));
		// 优惠券的有效结束时间
		param.setEndtime(sdf.parse(coupon_info.get("couponjssj") + ""));
		// 优惠券名称
		param.setCouponname(coupon_info.get("couponname") + "");
		// 优惠券类别
		param.setCoupontype(coupon_info.get("couponclass_code") + "");
		// 优惠券图片
		param.setCouponimg(coupon_info.get("couponimg") + "");
		// 优惠券内容
		param.setCouponcontent(coupon_info.get("couponcontent") + "");
		// 在用户的优惠券表中插入优惠券

		paramMap.put(BEAN, param);
		wec_0041_Dao.add_coupon(paramMap);
		
		// 返回前台提示信息
		WEC0034Model resultModel = new WEC0034Model();
		resultModel.setCoupon_id(param.getCouponid());
		resultModel.setState(WebConstantValue.HTTP_OK);
		resultModel.setMsg(WebConstantValue.COLLECT_SUCCESS);
		logger.info("========================Service collect_coupon End==========================");
		return resultModel;
	}
}
