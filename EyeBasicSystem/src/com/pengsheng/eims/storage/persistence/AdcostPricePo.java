package com.pengsheng.eims.storage.persistence;

public class AdcostPricePo {

	private String cpracbillid;//调价单编号
	private String cpraceffectivedate;//生效日期
	
	private String cpraceffectivestartdate;//生效开始日期
	private String cpraceffectiveenddate;//生效结束日期
	
	private String cpraccreateperson;//制单人
	private String cpraccreatedate;//制单日期
	
	private String cpraccreatestartdate;//制单开始日期
	private String cpraccreateenddate;//制单结束日期
	
	private String cpracauditstartdate;//审核开始日期
	private String cpracauditenddate;//审核结束日期
	
	private String cpracauditperson;//审核人
	private String cpracauditdate;//审核日期
	
	private String cpracauditstate;//审核状态
	
	private String cpracremark;//备注

	private String cpracauditpersonname;//审核人姓名
	private String cpraccreatepersonname;//制单人姓名
	
	private String cpraceffectivestate;//生效状态
	
	private String goodsName;//查询商品名称用
	
	private String cprapflag = null;  // 0:实时调价   1：石英调价
	
	private String cpracsupplierid;
	private String cpracbrandid	;
	private String cpracsupplieridname;
	private String cpracbrandidname;
	
		
	public String getCpracsupplieridname() {
		return cpracsupplieridname;
	}
	public void setCpracsupplieridname(String cpracsupplieridname) {
		this.cpracsupplieridname = cpracsupplieridname;
	}
	public String getCpracbrandidname() {
		return cpracbrandidname;
	}
	public void setCpracbrandidname(String cpracbrandidname) {
		this.cpracbrandidname = cpracbrandidname;
	}
	public String getCpracsupplierid() {
		return cpracsupplierid;
	}
	public void setCpracsupplierid(String cpracsupplierid) {
		this.cpracsupplierid = cpracsupplierid;
	}
	public String getCpracbrandid() {
		return cpracbrandid;
	}
	public void setCpracbrandid(String cpracbrandid) {
		this.cpracbrandid = cpracbrandid;
	}
	public String getCprapflag() {
		return cprapflag;
	}
	public void setCprapflag(String cprapflag) {
		this.cprapflag = cprapflag;
	}
	public String getCpracauditstate() {
		return cpracauditstate;
	}
	public void setCpracauditstate(String cpracauditstate) {
		this.cpracauditstate = cpracauditstate;
	}
	public String getCpracremark() {
		return cpracremark;
	}
	public void setCpracremark(String cpracremark) {
		this.cpracremark = cpracremark;
	}
	public String getCpracauditpersonname() {
		return cpracauditpersonname;
	}
	public void setCpracauditpersonname(String cpracauditpersonname) {
		this.cpracauditpersonname = cpracauditpersonname;
	}
	public String getCpraccreatepersonname() {
		return cpraccreatepersonname;
	}
	public void setCpraccreatepersonname(String cpraccreatepersonname) {
		this.cpraccreatepersonname = cpraccreatepersonname;
	}
	public String getCpraceffectivestate() {
		return cpraceffectivestate;
	}
	public void setCpraceffectivestate(String cpraceffectivestate) {
		this.cpraceffectivestate = cpraceffectivestate;
	}
	public String getCpracbillid() {
		return cpracbillid;
	}
	public void setCpracbillid(String cpracbillid) {
		this.cpracbillid = cpracbillid;
	}
	public String getCpraceffectivedate() {
		return cpraceffectivedate;
	}
	public void setCpraceffectivedate(String cpraceffectivedate) {
		this.cpraceffectivedate = cpraceffectivedate;
	}
	public String getCpraceffectivestartdate() {
		return cpraceffectivestartdate;
	}
	public void setCpraceffectivestartdate(String cpraceffectivestartdate) {
		this.cpraceffectivestartdate = cpraceffectivestartdate;
	}
	public String getCpraceffectiveenddate() {
		return cpraceffectiveenddate;
	}
	public void setCpraceffectiveenddate(String cpraceffectiveenddate) {
		this.cpraceffectiveenddate = cpraceffectiveenddate;
	}
	public String getCpraccreateperson() {
		return cpraccreateperson;
	}
	public void setCpraccreateperson(String cpraccreateperson) {
		this.cpraccreateperson = cpraccreateperson;
	}
	public String getCpraccreatedate() {
		return cpraccreatedate;
	}
	public void setCpraccreatedate(String cpraccreatedate) {
		this.cpraccreatedate = cpraccreatedate;
	}
	public String getCpraccreatestartdate() {
		return cpraccreatestartdate;
	}
	public void setCpraccreatestartdate(String cpraccreatestartdate) {
		this.cpraccreatestartdate = cpraccreatestartdate;
	}
	public String getCpraccreateenddate() {
		return cpraccreateenddate;
	}
	public void setCpraccreateenddate(String cpraccreateenddate) {
		this.cpraccreateenddate = cpraccreateenddate;
	}
	public String getCpracauditstartdate() {
		return cpracauditstartdate;
	}
	public void setCpracauditstartdate(String cpracauditstartdate) {
		this.cpracauditstartdate = cpracauditstartdate;
	}
	public String getCpracauditenddate() {
		return cpracauditenddate;
	}
	public void setCpracauditenddate(String cpracauditenddate) {
		this.cpracauditenddate = cpracauditenddate;
	}
	public String getCpracauditperson() {
		return cpracauditperson;
	}
	public void setCpracauditperson(String cpracauditperson) {
		this.cpracauditperson = cpracauditperson;
	}
	public String getCpracauditdate() {
		return cpracauditdate;
	}
	public void setCpracauditdate(String cpracauditdate) {
		this.cpracauditdate = cpracauditdate;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
}
