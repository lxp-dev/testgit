package com.pengsheng.eims.sales.persistence;

public class SalesLogPo {
	private String ssesluuid; // 主键编号
	private String sseslsalesid; // 销售单号
	private String sseslpaymenttype; // 结款类型 1.结款，2交订金，3补齐欠款，4退款
	private String sseslconsumptionid; // 付款方式   1、现金   2、积分  3、银行卡  4、储值卡
	private String sseslconsumptionname; // 付款方式   1、现金   2、积分  3、银行卡  4、储值卡
	private String sseslprice; // 付款金额
	private String ssesldatetime; // 账面缴费日期
	private String sseslperson; // 人员
	private String sseslorderby; // 排序
	private String sseslsourceid; // 关联银行类型及储值卡ID
	private String sseslintegralprice; // 积分抵扣金额
	private String bbname;//银行卡名称
	private String sseslshopcode;
	private String ssesltype;	
	private String sseslcashprice;    //现金合计
	private String sseslpetcardprice;    //储值卡合计
	private String sseslbankcardprice;    //银行卡合计
	private String sseslchitprice;    //代金券合计
	private String sseslnotcashprice;    //非现金合计
	private String czkye;
	private String sseslintransit;	// 在途
	private String sseslfactdatetime; // 实际缴费日期
	
	public String getSseslfactdatetime() {
		return sseslfactdatetime;
	}
	public void setSseslfactdatetime(String sseslfactdatetime) {
		this.sseslfactdatetime = sseslfactdatetime;
	}
	public String getSseslintransit() {
		return sseslintransit;
	}
	public void setSseslintransit(String sseslintransit) {
		this.sseslintransit = sseslintransit;
	}
	public String getCzkye() {
		return czkye;
	}
	public void setCzkye(String czkye) {
		this.czkye = czkye;
	}
	public String getSseslcashprice() {
		return sseslcashprice;
	}
	public void setSseslcashprice(String sseslcashprice) {
		this.sseslcashprice = sseslcashprice;
	}
	public String getSseslpetcardprice() {
		return sseslpetcardprice;
	}
	public void setSseslpetcardprice(String sseslpetcardprice) {
		this.sseslpetcardprice = sseslpetcardprice;
	}
	public String getSseslbankcardprice() {
		return sseslbankcardprice;
	}
	public void setSseslbankcardprice(String sseslbankcardprice) {
		this.sseslbankcardprice = sseslbankcardprice;
	}
	public String getSseslchitprice() {
		return sseslchitprice;
	}
	public void setSseslchitprice(String sseslchitprice) {
		this.sseslchitprice = sseslchitprice;
	}
	public String getSseslnotcashprice() {
		return sseslnotcashprice;
	}
	public void setSseslnotcashprice(String sseslnotcashprice) {
		this.sseslnotcashprice = sseslnotcashprice;
	}
	public String getSseslconsumptionname() {
		return sseslconsumptionname;
	}
	public void setSseslconsumptionname(String sseslconsumptionname) {
		this.sseslconsumptionname = sseslconsumptionname;
	}
	public String getSseslshopcode() {
		return sseslshopcode;
	}
	public void setSseslshopcode(String sseslshopcode) {
		this.sseslshopcode = sseslshopcode;
	}
	public String getSsesltype() {
		return ssesltype;
	}
	public void setSsesltype(String ssesltype) {
		this.ssesltype = ssesltype;
	}
	public String getBbname() {
		return bbname;
	}
	public void setBbname(String bbname) {
		this.bbname = bbname;
	}
	public String getSseslintegralprice() {
		return sseslintegralprice;
	}
	public void setSseslintegralprice(String sseslintegralprice) {
		this.sseslintegralprice = sseslintegralprice;
	}
	public String getSseslsourceid() {
		return sseslsourceid;
	}
	public void setSseslsourceid(String sseslsourceid) {
		this.sseslsourceid = sseslsourceid;
	}
	public String getSsesluuid() {
		return ssesluuid;
	}
	public void setSsesluuid(String ssesluuid) {
		this.ssesluuid = ssesluuid;
	}
	public String getSseslsalesid() {
		return sseslsalesid;
	}
	public void setSseslsalesid(String sseslsalesid) {
		this.sseslsalesid = sseslsalesid;
	}
	public String getSseslpaymenttype() {
		return sseslpaymenttype;
	}
	public void setSseslpaymenttype(String sseslpaymenttype) {
		this.sseslpaymenttype = sseslpaymenttype;
	}
	public String getSseslconsumptionid() {
		return sseslconsumptionid;
	}
	public void setSseslconsumptionid(String sseslconsumptionid) {
		this.sseslconsumptionid = sseslconsumptionid;
	}
	public String getSseslprice() {
		return sseslprice;
	}
	public void setSseslprice(String sseslprice) {
		this.sseslprice = sseslprice;
	}
	public String getSsesldatetime() {
		return ssesldatetime;
	}
	public void setSsesldatetime(String ssesldatetime) {
		this.ssesldatetime = ssesldatetime;
	}
	public String getSseslperson() {
		return sseslperson;
	}
	public void setSseslperson(String sseslperson) {
		this.sseslperson = sseslperson;
	}
	public String getSseslorderby() {
		return sseslorderby;
	}
	public void setSseslorderby(String sseslorderby) {
		this.sseslorderby = sseslorderby;
	}

}
