package cn.com.allinpay.frame.model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.portlet.bind.annotation.ActionMapping;

import cn.com.allinpay.frame.model.BaseModel;

public class BranchparametersForm extends BaseModel {
	private String branchid;
	private String branchcode;
	private String appkey;
	private String appsecret;
	private String apiversion;
	private String deskey;
	private String branchtype;

	// 代付相关交易:批量代付一笔
	private String batchpayoneapi_trx_code;
	private String batchpayoneapi_version;
	private String batchpayoneapi_data_type;
	private String batchpayoneapi_business_code;
	private String batchpayoneapi_bank_code;
	// 代付相关交易:查询请求
	private String querypayapi_trx_code;
	private String querypayapi_version;
	// constants参数
	private String active_product;
	private String offline_product;
	private String mer_id;
	private String payment_id;
	private String real_pay_merchantid;
	private String real_pay_cerpl2name;
	private String real_pay_username;
	private String real_pay_userpass;
	private String real_pay_certpass;
	private String pay_batch_timea;
	private String pay_batch_timeb;
	private String pay_batch_time_ta;
	private String pay_batch_time_tb;
	private String user_charge;
	private String bank_charge;
	private String batch_user_charge;
	private String batch_bank_charge;
	private String financ_product;
	private String recharge_channel;// 付款渠道 通联通代付tlt 农行nonghang
	private String is_time_limit;// 是否有圈提时间限制 1有 0无
	private String time_limit_range;// 圈提时间区间
	private String branchname;
	private String bankcode;
	private String idcard;
	private String issms;// 是否发短信

	private String jexz;// 是否有金额限制
	private String dbmoney;// 单笔金额 单位万元
	private String drmoney;// 单日金额 单位万元

	public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
	}

	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public void setApiversion(String apiversion) {
		this.apiversion = apiversion;
	}

	public void setDeskey(String deskey) {
		this.deskey = deskey;
	}

	public void setBranchtype(String branchtype) {
		this.branchtype = branchtype;
	}

	public String getBranchid() {
		return branchid;
	}

	public String getAppkey() {
		return appkey;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public String getApiversion() {
		return apiversion;
	}

	public String getDeskey() {
		return deskey;
	}

	public String getBranchtype() {
		return branchtype;
	}

	public String getBatchpayoneapi_trx_code() {
		return batchpayoneapi_trx_code;
	}

	public void setBatchpayoneapi_trx_code(String batchpayoneapi_trx_code) {
		this.batchpayoneapi_trx_code = batchpayoneapi_trx_code;
	}

	public String getBatchpayoneapi_version() {
		return batchpayoneapi_version;
	}

	public void setBatchpayoneapi_version(String batchpayoneapi_version) {
		this.batchpayoneapi_version = batchpayoneapi_version;
	}

	public String getBatchpayoneapi_data_type() {
		return batchpayoneapi_data_type;
	}

	public void setBatchpayoneapi_data_type(String batchpayoneapi_data_type) {
		this.batchpayoneapi_data_type = batchpayoneapi_data_type;
	}

	public String getBatchpayoneapi_business_code() {
		return batchpayoneapi_business_code;
	}

	public void setBatchpayoneapi_business_code(String batchpayoneapi_business_code) {
		this.batchpayoneapi_business_code = batchpayoneapi_business_code;
	}

	public String getBatchpayoneapi_bank_code() {
		return batchpayoneapi_bank_code;
	}

	public void setBatchpayoneapi_bank_code(String batchpayoneapi_bank_code) {
		this.batchpayoneapi_bank_code = batchpayoneapi_bank_code;
	}

	public String getQuerypayapi_trx_code() {
		return querypayapi_trx_code;
	}

	public void setQuerypayapi_trx_code(String querypayapi_trx_code) {
		this.querypayapi_trx_code = querypayapi_trx_code;
	}

	public String getQuerypayapi_version() {
		return querypayapi_version;
	}

	public void setQuerypayapi_version(String querypayapi_version) {
		this.querypayapi_version = querypayapi_version;
	}

	public String getActive_product() {
		return active_product;
	}

	public void setActive_product(String active_product) {
		this.active_product = active_product;
	}

	public String getOffline_product() {
		return offline_product;
	}

	public void setOffline_product(String offline_product) {
		this.offline_product = offline_product;
	}

	public String getMer_id() {
		return mer_id;
	}

	public void setMer_id(String mer_id) {
		this.mer_id = mer_id;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getReal_pay_merchantid() {
		return real_pay_merchantid;
	}

	public void setReal_pay_merchantid(String real_pay_merchantid) {
		this.real_pay_merchantid = real_pay_merchantid;
	}

	public String getReal_pay_cerpl2name() {
		return real_pay_cerpl2name;
	}

	public void setReal_pay_cerpl2name(String real_pay_cerpl2name) {
		this.real_pay_cerpl2name = real_pay_cerpl2name;
	}

	public String getReal_pay_username() {
		return real_pay_username;
	}

	public void setReal_pay_username(String real_pay_username) {
		this.real_pay_username = real_pay_username;
	}

	public String getReal_pay_userpass() {
		return real_pay_userpass;
	}

	public void setReal_pay_userpass(String real_pay_userpass) {
		this.real_pay_userpass = real_pay_userpass;
	}

	public String getReal_pay_certpass() {
		return real_pay_certpass;
	}

	public void setReal_pay_certpass(String real_pay_certpass) {
		this.real_pay_certpass = real_pay_certpass;
	}

	public String getPay_batch_timea() {
		return pay_batch_timea;
	}

	public void setPay_batch_timea(String pay_batch_timea) {
		this.pay_batch_timea = pay_batch_timea;
	}

	public String getPay_batch_timeb() {
		return pay_batch_timeb;
	}

	public void setPay_batch_timeb(String pay_batch_timeb) {
		this.pay_batch_timeb = pay_batch_timeb;
	}

	public String getPay_batch_time_ta() {
		return pay_batch_time_ta;
	}

	public void setPay_batch_time_ta(String pay_batch_time_ta) {
		this.pay_batch_time_ta = pay_batch_time_ta;
	}

	public String getPay_batch_time_tb() {
		return pay_batch_time_tb;
	}

	public void setPay_batch_time_tb(String pay_batch_time_tb) {
		this.pay_batch_time_tb = pay_batch_time_tb;
	}

	public String getUser_charge() {
		return user_charge;
	}

	public void setUser_charge(String user_charge) {
		this.user_charge = user_charge;
	}

	public String getBank_charge() {
		return bank_charge;
	}

	public void setBank_charge(String bank_charge) {
		this.bank_charge = bank_charge;
	}

	public String getBatch_user_charge() {
		return batch_user_charge;
	}

	public void setBatch_user_charge(String batch_user_charge) {
		this.batch_user_charge = batch_user_charge;
	}

	public String getBatch_bank_charge() {
		return batch_bank_charge;
	}

	public void setBatch_bank_charge(String batch_bank_charge) {
		this.batch_bank_charge = batch_bank_charge;
	}

	public String getFinanc_product() {
		return financ_product;
	}

	public void setFinanc_product(String financ_product) {
		this.financ_product = financ_product;
	}

	public String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public String getRecharge_channel() {
		return recharge_channel;
	}

	public void setRecharge_channel(String recharge_channel) {
		this.recharge_channel = recharge_channel;
	}

	public String getIs_time_limit() {
		return is_time_limit;
	}

	public void setIs_time_limit(String is_time_limit) {
		this.is_time_limit = is_time_limit;
	}

	public String getTime_limit_range() {
		return time_limit_range;
	}

	public void setTime_limit_range(String time_limit_range) {
		this.time_limit_range = time_limit_range;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getIssms() {
		return issms;
	}

	public void setIssms(String issms) {
		this.issms = issms;
	}

	public String getJexz() {
		return jexz;
	}

	public void setJexz(String jexz) {
		this.jexz = jexz;
	}

	public String getDbmoney() {
		return dbmoney;
	}

	public void setDbmoney(String dbmoney) {
		this.dbmoney = dbmoney;
	}

	public String getDrmoney() {
		return drmoney;
	}

	public void setDrmoney(String drmoney) {
		this.drmoney = drmoney;
	}

}
