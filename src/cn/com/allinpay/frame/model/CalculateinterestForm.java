package cn.com.allinpay.frame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.portlet.bind.annotation.ActionMapping;

import cn.com.allinpay.frame.model.BaseModel;

public class CalculateinterestForm extends BaseModel {
	private String i;
	// 新添加的机构名称和机构id
	private String organization_id;
	private String organization_name;
	// 增加登陆类型
	private String loginType;
	// 增加查询机构号
	private String conorgan_id;
	//绑定 用
	private String alias;
	// 查询条件
	private String startdate;
	private String enddate;
	private String concard_id;
	private String conuserid;
	private String conusername;
	private String conpassword;
	private String conpageno;
	private String constate;
	private String confinanc_name;
	private ArrayList cardproductList = new ArrayList();

	private String keyid = "";
	private String card_id = "";
	private String account_type = "";
	private String interest_rate = "0";
	private String product_sn = "0";
	private String product_id = "";
	private String account_balance = "";
	private String start_date = "";
	private String end_date = "";
	private String sum_balance = "0";
	private String offline_balance = "0";
	private String account_state;
	private String collect_date;
	private String operate_date;
	private String interest_money = "0";
	private String operatorid;
	private String save_money = "";
	private String interest_ratename;
	private String return_message;
	private String product_state;
	private String password;
	private String amount = "0";
	private String mer_id;
	private String mer_order_id;
	private String pay_txn_id;
	private String trans_card_id;
	private String trans_prdt_no;
	private String sum_updatedate;
	// 换卡用到
	private String new_card_id;
	private String order_id = "";
	private String pay_order_id = "";
	private String trans_no;
	private String state;
	private String statename;
	// 退卡用
	private String result;
	private String rescode;
	private String prdt_name;
	private String reason;
	// 充值用到的字段
	private String recharge_type;
	private String detail_stat;
	private String recharge_tujing;
	private String req_man;
	private String req_date;
	private String recharge_man;
	private String recharge_date;
	private String remark;
	// 查询交易流水
	private String int_txn_dt;
	private String int_txn_tm;
	private String accept_brh_id;
	private String int_txn_seq_id;
	private String access_ref_seq_id;
	private String txn_at;
	private String txn_fee_at;
	private String txn_sta_cd;
	private String term_id;
	private String txn_cd;
	private String inforet_code;
	private String transret_code;
	private String requesttime;
	private String requestman;
	private String dealflag;
	private String dealflagname;
	private String[] keyidbox;
	private String batch_id;
	private String sn;
	private String trans_time;
	private String trans_time_wx;
	// 手续费
	private String user_charge = "";
	private String bank_charge = "";
	// 理财产品
	private String financ_name;
	private String total_amount;
	private String principal;// 本金
	private String income;// 收益
	// 工资圈提查询
	private String inouttype;
	private HashMap branchMap = new HashMap();

	private String stateTxt;
	private String ckrsxf;// 持卡人手续费
	private String yhcd;// 银行承担
	// ftp新增字段部门
	private String deptname;
	private String ll;
	private String branchname;
	private String custname;
	private String valid_balance;
	private String day_interest;
	private String opertime;
	private String operor;
	private String ismobile;
	private String isdel;
	private String id;
	private String bank_back_code;
	private String back_code;
	private String canTransferMore;// 能够再次发起圈存
	private String branchid;
	private String sourceid;
	private String company;// 公司名称
	private String uuid;// UUID为了和订单平台相对应
	private String bankBalanceMoney;

	private String paralabel;
	private String username;
	private String mytoken;

	 

	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}

	public String getCard_id() {
		return card_id;
	}

	public String getTrans_time() {
		return trans_time;
	}

	public void setTrans_time(String trans_time) {
		this.trans_time = trans_time;
	}

	public String getTrans_time_wx() {
		return trans_time_wx;
	}

	public void setTrans_time_wx(String trans_time_wx) {
		this.trans_time_wx = trans_time_wx;
	}

	public String getConcard_id() {
		return concard_id;
	}

	public String getEnddate() {
		return enddate;
	}
 
	public String getI() {
		return i;
	}

	public void setI(String i) {
		this.i = i;
	}

	public String getInterest_money() {
		return interest_money;
	}

	public String getOperate_date() {
		return operate_date;
	}

	public String getOperatorid() {
		return operatorid;
	}

	public String getProduct_id() {
		return product_id;
	}

	public String getStartdate() {
		return startdate;
	}

	public String getAccount_balance() {
		return account_balance;
	}

	public String getAccount_state() {
		return account_state;
	}

	public String getAccount_type() {
		return account_type;
	}

	public String getCollect_date() {
		return collect_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public String getInterest_rate() {
		return interest_rate;
	}

	public String getProduct_sn() {
		return product_sn;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getSum_balance() {
		return sum_balance;
	}

	public String getConpassword() {
		return conpassword;
	}

	public String getConuserid() {
		return conuserid;
	}

	public String getInterest_ratename() {
		return interest_ratename;
	}

	public String getKeyid() {
		return keyid;
	}

	public String getReturn_message() {
		return return_message;
	}

	public String getProduct_state() {
		return product_state;
	}

	public String getPassword() {
		return password;
	}

	public String getNew_card_id() {
		return new_card_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public String getTrans_no() {
		return trans_no;
	}

	public String getSave_money() {
		return save_money;
	}

	public String getConusername() {
		return conusername;
	}

	public String getState() {
		return state;
	}

	public String getAmount() {
		return amount;
	}

	public String getMer_id() {
		return mer_id;
	}

	public String getPay_txn_id() {
		return pay_txn_id;
	}

	public String getTrans_card_id() {
		return trans_card_id;
	}

	public String getTrans_prdt_no() {
		return trans_prdt_no;
	}

	public ArrayList getCardproductList() {
		return cardproductList;
	}

	public String getMer_order_id() {
		return mer_order_id;
	}

	public String getSum_updatedate() {
		return sum_updatedate;
	}

	public String getRescode() {
		return rescode;
	}

	public String getResult() {
		return result;
	}

	public String getPrdt_name() {
		return prdt_name;
	}

	public String getReason() {
		return reason;
	}

	public String getAccept_brh_id() {
		return accept_brh_id;
	}

	public String getAccess_ref_seq_id() {
		return access_ref_seq_id;
	}

	public String getInt_txn_dt() {
		return int_txn_dt;
	}

	public String getInt_txn_seq_id() {
		return int_txn_seq_id;
	}

	public String getInt_txn_tm() {
		return int_txn_tm;
	}

	public String getTerm_id() {
		return term_id;
	}

	public String getTxn_at() {
		return txn_at;
	}

	public String getTxn_cd() {
		return txn_cd;
	}

	public String getTxn_fee_at() {
		return txn_fee_at;
	}

	public String getTxn_sta_cd() {
		return txn_sta_cd;
	}

	public String getConpageno() {
		return conpageno;
	}

	public String getOffline_balance() {
		return offline_balance;
	}

	public String getInforet_code() {
		return inforet_code;
	}

	public String getTransret_code() {
		return transret_code;
	}

	public String getRemark() {
		return remark;
	}

	public String getRequestman() {
		return requestman;
	}

	public String getRequesttime() {
		return requesttime;
	}

	public String getDealflag() {
		return dealflag;
	}

	public String[] getKeyidbox() {
		return keyidbox;
	}

	public String getBatch_id() {
		return batch_id;
	}

	public String getSn() {
		return sn;
	}

	public HashMap getBranchMap() {
		return branchMap;
	}

	public String getDealflagname() {
		return dealflagname;
	}

	public String getBank_charge() {
		return bank_charge;
	}

	public String getUser_charge() {
		return user_charge;
	}

	public String getConstate() {
		return constate;
	}

	public String getFinanc_name() {
		return financ_name;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public String getStatename() {
		return statename;
	}

	public String getConfinanc_name() {
		return confinanc_name;
	}

	public String getPay_order_id() {
		return pay_order_id;
	}

	public String getDetail_stat() {
		return detail_stat;
	}

	public String getRecharge_date() {
		return recharge_date;
	}

	public String getRecharge_man() {
		return recharge_man;
	}

	public String getRecharge_tujing() {
		return recharge_tujing;
	}

	public String getRecharge_type() {
		return recharge_type;
	}

	public String getReq_date() {
		return req_date;
	}

	public String getReq_man() {
		return req_man;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid;
	}

	public void setOperate_date(String operate_date) {
		this.operate_date = operate_date;
	}

	public void setInterest_money(String interest_money) {
		this.interest_money = interest_money;
	}

	 
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public void setConcard_id(String concard_id) {
		this.concard_id = concard_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public void setAccount_balance(String account_balance) {
		this.account_balance = account_balance;
	}

	public void setAccount_state(String account_state) {
		this.account_state = account_state;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public void setCollect_date(String collect_date) {
		this.collect_date = collect_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public void setInterest_rate(String interest_rate) {
		this.interest_rate = interest_rate;
	}

	public void setProduct_sn(String product_sn) {
		this.product_sn = product_sn;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public void setSum_balance(String sum_balance) {
		this.sum_balance = sum_balance;
	}

	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}

	public void setConuserid(String conuserid) {
		this.conuserid = conuserid;
	}

	public void setInterest_ratename(String interest_ratename) {
		this.interest_ratename = interest_ratename;
	}

	public void setKeyid(String keyid) {
		this.keyid = keyid;
	}

	public void setReturn_message(String return_message) {
		this.return_message = return_message;
	}

	public void setProduct_state(String product_state) {
		this.product_state = product_state;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNew_card_id(String new_card_id) {
		this.new_card_id = new_card_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public void setTrans_no(String trans_no) {
		this.trans_no = trans_no;
	}

	public void setSave_money(String save_money) {
		this.save_money = save_money;
	}

	public void setConusername(String conusername) {
		this.conusername = conusername;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setMer_id(String mer_id) {
		this.mer_id = mer_id;
	}

	public void setPay_txn_id(String pay_txn_id) {
		this.pay_txn_id = pay_txn_id;
	}

	public void setTrans_card_id(String trans_card_id) {
		this.trans_card_id = trans_card_id;
	}

	public void setTrans_prdt_no(String trans_prdt_no) {
		this.trans_prdt_no = trans_prdt_no;
	}

	public void setCardproductList(ArrayList cardproductList) {
		this.cardproductList = cardproductList;
	}

	public void setMer_order_id(String mer_order_id) {
		this.mer_order_id = mer_order_id;
	}

	public void setSum_updatedate(String sum_updatedate) {
		this.sum_updatedate = sum_updatedate;
	}

	public void setRescode(String rescode) {
		this.rescode = rescode;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setPrdt_name(String prdt_name) {
		this.prdt_name = prdt_name;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setAccept_brh_id(String accept_brh_id) {
		this.accept_brh_id = accept_brh_id;
	}

	public void setAccess_ref_seq_id(String access_ref_seq_id) {
		this.access_ref_seq_id = access_ref_seq_id;
	}

	public void setInt_txn_dt(String int_txn_dt) {
		this.int_txn_dt = int_txn_dt;
	}

	public void setInt_txn_seq_id(String int_txn_seq_id) {
		this.int_txn_seq_id = int_txn_seq_id;
	}

	public void setInt_txn_tm(String int_txn_tm) {
		this.int_txn_tm = int_txn_tm;
	}

	public void setTerm_id(String term_id) {
		this.term_id = term_id;
	}

	public void setTxn_at(String txn_at) {
		this.txn_at = txn_at;
	}

	public void setTxn_cd(String txn_cd) {
		this.txn_cd = txn_cd;
	}

	public void setTxn_fee_at(String txn_fee_at) {
		this.txn_fee_at = txn_fee_at;
	}

	public void setTxn_sta_cd(String txn_sta_cd) {
		this.txn_sta_cd = txn_sta_cd;
	}

	public void setConpageno(String conpageno) {
		this.conpageno = conpageno;
	}

	public void setOffline_balance(String offline_balance) {
		this.offline_balance = offline_balance;
	}

	public void setInforet_code(String inforet_code) {
		this.inforet_code = inforet_code;
	}

	public void setTransret_code(String transret_code) {
		this.transret_code = transret_code;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setRequestman(String requestman) {
		this.requestman = requestman;
	}

	public void setRequesttime(String requesttime) {
		this.requesttime = requesttime;
	}

	public void setDealflag(String dealflag) {
		this.dealflag = dealflag;
	}

	public void setKeyidbox(String[] keyidbox) {
		this.keyidbox = keyidbox;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public void setBranchMap(HashMap branchMap) {
		this.branchMap = branchMap;
	}

	public void setDealflagname(String dealflagname) {
		this.dealflagname = dealflagname;
	}

	public void setBank_charge(String bank_charge) {
		this.bank_charge = bank_charge;
	}

	public void setUser_charge(String user_charge) {
		this.user_charge = user_charge;
	}

	public void setConstate(String constate) {
		this.constate = constate;
	}

	public void setFinanc_name(String financ_name) {
		this.financ_name = financ_name;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public void setConfinanc_name(String confinanc_name) {
		this.confinanc_name = confinanc_name;
	}

	public void setPay_order_id(String pay_order_id) {
		this.pay_order_id = pay_order_id;
	}

	public void setDetail_stat(String detail_stat) {
		this.detail_stat = detail_stat;
	}

	public void setRecharge_date(String recharge_date) {
		this.recharge_date = recharge_date;
	}

	public void setRecharge_man(String recharge_man) {
		this.recharge_man = recharge_man;
	}

	public void setRecharge_tujing(String recharge_tujing) {
		this.recharge_tujing = recharge_tujing;
	}

	public void setRecharge_type(String recharge_type) {
		this.recharge_type = recharge_type;
	}

	public void setReq_date(String req_date) {
		this.req_date = req_date;
	}

	public void setReq_man(String req_man) {
		this.req_man = req_man;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getInouttype() {
		return inouttype;
	}

	public void setInouttype(String inouttype) {
		this.inouttype = inouttype;
	}

	public String getStateTxt() {
		return stateTxt;
	}

	public void setStateTxt(String stateTxt) {
		this.stateTxt = stateTxt;
	}

	public String getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(String organization_id) {
		this.organization_id = organization_id;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getConorgan_id() {
		return conorgan_id;
	}

	public void setConorgan_id(String conorgan_id) {
		this.conorgan_id = conorgan_id;
	}

	public String getCkrsxf() {
		return ckrsxf;
	}

	public void setCkrsxf(String ckrsxf) {
		this.ckrsxf = ckrsxf;
	}

	public String getYhcd() {
		return yhcd;
	}

	public void setYhcd(String yhcd) {
		this.yhcd = yhcd;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getLl() {
		return ll;
	}

	public void setLl(String ll) {
		this.ll = ll;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getValid_balance() {
		return valid_balance;
	}

	public void setValid_balance(String valid_balance) {
		this.valid_balance = valid_balance;
	}

	public String getDay_interest() {
		return day_interest;
	}

	public void setDay_interest(String day_interest) {
		this.day_interest = day_interest;
	}

	public String getOpertime() {
		return opertime;
	}

	public void setOpertime(String opertime) {
		this.opertime = opertime;
	}

	public String getOperor() {
		return operor;
	}

	public void setOperor(String operor) {
		this.operor = operor;
	}

	public String getIsmobile() {
		return ismobile;
	}

	public void setIsmobile(String ismobile) {
		this.ismobile = ismobile;
	}

	public String getIsdel() {
		return isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBank_back_code() {
		return bank_back_code;
	}

	public void setBank_back_code(String bank_back_code) {
		this.bank_back_code = bank_back_code;
	}

	public String getBack_code() {
		return back_code;
	}

	public void setBack_code(String back_code) {
		this.back_code = back_code;
	}

	public String getCanTransferMore() {
		return canTransferMore;
	}

	public void setCanTransferMore(String canTransferMore) {
		this.canTransferMore = canTransferMore;
	}

	public String getBranchid() {
		return branchid;
	}

	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}

	public String getSourceid() {
		return sourceid;
	}

	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getBankBalanceMoney() {
		return bankBalanceMoney;
	}

	public void setBankBalanceMoney(String bankBalanceMoney) {
		this.bankBalanceMoney = bankBalanceMoney;
	}

	public String getMytoken() {
		return mytoken;
	}

	public void setMytoken(String mytoken) {
		this.mytoken = mytoken;
	}

	public String getParalabel() {
		return paralabel;
	}

	public void setParalabel(String paralabel) {
		this.paralabel = paralabel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString() {
		return "CalculateinterestForm [i=" + i + ", organization_id=" + organization_id + ", organization_name="
				+ organization_name + ", loginType=" + loginType + ", conorgan_id=" + conorgan_id + ", alias=" + alias
				+ ", startdate=" + startdate + ", enddate=" + enddate + ", concard_id=" + concard_id + ", conuserid="
				+ conuserid + ", conusername=" + conusername + ", conpassword=" + conpassword + ", conpageno="
				+ conpageno + ", constate=" + constate + ", confinanc_name=" + confinanc_name + ", cardproductList="
				+ cardproductList + ", keyid=" + keyid + ", card_id=" + card_id + ", account_type=" + account_type
				+ ", interest_rate=" + interest_rate + ", product_sn=" + product_sn + ", product_id=" + product_id
				+ ", account_balance=" + account_balance + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", sum_balance=" + sum_balance + ", offline_balance=" + offline_balance + ", account_state="
				+ account_state + ", collect_date=" + collect_date + ", operate_date=" + operate_date
				+ ", interest_money=" + interest_money + ", operatorid=" + operatorid + ", save_money=" + save_money
				+ ", interest_ratename=" + interest_ratename + ", return_message=" + return_message + ", product_state="
				+ product_state + ", password=" + password + ", amount=" + amount + ", mer_id=" + mer_id
				+ ", mer_order_id=" + mer_order_id + ", pay_txn_id=" + pay_txn_id + ", trans_card_id=" + trans_card_id
				+ ", trans_prdt_no=" + trans_prdt_no + ", sum_updatedate=" + sum_updatedate + ", new_card_id="
				+ new_card_id + ", order_id=" + order_id + ", pay_order_id=" + pay_order_id + ", trans_no=" + trans_no
				+ ", state=" + state + ", statename=" + statename + ", result=" + result + ", rescode=" + rescode
				+ ", prdt_name=" + prdt_name + ", reason=" + reason + ", recharge_type=" + recharge_type
				+ ", detail_stat=" + detail_stat + ", recharge_tujing=" + recharge_tujing + ", req_man=" + req_man
				+ ", req_date=" + req_date + ", recharge_man=" + recharge_man + ", recharge_date=" + recharge_date
				+ ", remark=" + remark + ", int_txn_dt=" + int_txn_dt + ", int_txn_tm=" + int_txn_tm
				+ ", accept_brh_id=" + accept_brh_id + ", int_txn_seq_id=" + int_txn_seq_id + ", access_ref_seq_id="
				+ access_ref_seq_id + ", txn_at=" + txn_at + ", txn_fee_at=" + txn_fee_at + ", txn_sta_cd=" + txn_sta_cd
				+ ", term_id=" + term_id + ", txn_cd=" + txn_cd + ", inforet_code=" + inforet_code + ", transret_code="
				+ transret_code + ", requesttime=" + requesttime + ", requestman=" + requestman + ", dealflag="
				+ dealflag + ", dealflagname=" + dealflagname + ", keyidbox=" + Arrays.toString(keyidbox)
				+ ", batch_id=" + batch_id + ", sn=" + sn + ", trans_time=" + trans_time + ", trans_time_wx="
				+ trans_time_wx + ", user_charge=" + user_charge + ", bank_charge=" + bank_charge + ", financ_name="
				+ financ_name + ", total_amount=" + total_amount + ", principal=" + principal + ", income=" + income
				+ ", inouttype=" + inouttype + ", branchMap=" + branchMap + ", stateTxt=" + stateTxt + ", ckrsxf="
				+ ckrsxf + ", yhcd=" + yhcd + ", deptname=" + deptname + ", ll=" + ll + ", branchname=" + branchname
				+ ", custname=" + custname + ", valid_balance=" + valid_balance + ", day_interest=" + day_interest
				+ ", opertime=" + opertime + ", operor=" + operor + ", ismobile=" + ismobile + ", isdel=" + isdel
				+ ", id=" + id + ", bank_back_code=" + bank_back_code + ", back_code=" + back_code
				+ ", canTransferMore=" + canTransferMore + ", branchid=" + branchid + ", sourceid=" + sourceid
				+ ", company=" + company + ", uuid=" + uuid + ", bankBalanceMoney=" + bankBalanceMoney + ", paralabel="
				+ paralabel + ", username=" + username + ", mytoken=" + mytoken + "]";
	}

}
