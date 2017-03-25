package com.pengsheng.eims.storage.persistence;
/**
 * 调拨主表PO
 */
public class WholePo {
	
	private String cshawbillid;//单据编号	
	private String cshawbilldate;//制单日期	
	private String cshawoutdepartmentid;//申请部门	
	private String cshawoutdepartmentname;//申请部门名称	
	private String cshawoutstockid;//发出部门仓位ID	
	private String cshawoutstockname;//发出仓位名称	
	private String cshawindepartmentid;//接收部门ID	
	private String cshawindepartmentname;//接收部门名称	
	private String cshawinstockid;//接收仓位ID	
	private String cshawinstockname;//接收仓位名称	
	private String cshawcreateperson;//制单人	
	private String cshawcreatepersonname;//制单人姓名	
	private String cshawauditperson;//审核人	
	private String cshawauditpersonname;//审核人姓名	
	private String cshawauditstate;//审核状态	
	private String cshawauditdate;//审核日期	
	private String cshawconsignee;//收货人	
	private String cshawconsigneename;//收货人姓名	
	private String cshawconsignstate;//收货状态	
	private String cshawconsigndate;//收货日期	
	private String cshawremark;//备注	
	private String cshawstartTime;//开始时间	
	private String cshawendTime;//结束时间	
	private String cshawauditdatestart;//审核开始日期
	private String cshawauditdateend;//审核结束日期	
	private String cshawflag;//正负调拨标识	
	private String cshawbillassociation;//关联单号	
	private String chaasupplier;//制造商	
	private String chaasuppliername;//制造商名称	
	private String cshastatusorderid;//关联订单号
	private String goodscategoryid;//商品类型编号
	private String goodscategoryname;//商品类型名称
	private String chaabrand;//品种代码	
	private String chaabrandname;//品种名称	
	private String chaagoodsid;//商品代码	
	private String chaagoodsname;//商品名称	
	private String isguaranteeperiod;
	private String chaaautoflag;//自动调拨标志
	private String isWriteoffs;//是否核销   未核销:0 ,已核销:本单单号
	private String cshawcategoryid;	
	
	public String getCshawcategoryid() {
		return cshawcategoryid;
	}

	public void setCshawcategoryid(String cshawcategoryid) {
		this.cshawcategoryid = cshawcategoryid;
	}

	public String getChaaautoflag() {
		return chaaautoflag;
	}

	public void setChaaautoflag(String chaaautoflag) {
		this.chaaautoflag = chaaautoflag;
	}

	public String getIsguaranteeperiod() {
		return isguaranteeperiod;
	}

	public void setIsguaranteeperiod(String isguaranteeperiod) {
		this.isguaranteeperiod = isguaranteeperiod;
	}

	public String getChaagoodsid() {
		return chaagoodsid;
	}

	public void setChaagoodsid(String chaagoodsid) {
		this.chaagoodsid = chaagoodsid;
	}

	public String getChaagoodsname() {
		return chaagoodsname;
	}

	public void setChaagoodsname(String chaagoodsname) {
		this.chaagoodsname = chaagoodsname;
	}

	public String getCshawauditdatestart() {
		return cshawauditdatestart;
	}

	public void setCshawauditdatestart(String cshawauditdatestart) {
		this.cshawauditdatestart = cshawauditdatestart;
	}

	public String getCshawauditdateend() {
		return cshawauditdateend;
	}

	public void setCshawauditdateend(String cshawauditdateend) {
		this.cshawauditdateend = cshawauditdateend;
	}
	
	public String getCshastatusorderid() {
		return cshastatusorderid;
	}

	public void setCshastatusorderid(String cshastatusorderid) {
		this.cshastatusorderid = cshastatusorderid;
	}

	public String getGoodscategoryname() {
		return goodscategoryname;
	}

	public void setGoodscategoryname(String goodscategoryname) {
		this.goodscategoryname = goodscategoryname;
	}

	public String getGoodscategoryid() {
		return goodscategoryid;
	}

	public void setGoodscategoryid(String goodscategoryid) {
		this.goodscategoryid = goodscategoryid;
	}

	public String getChaasupplier() {
		return chaasupplier;
	}

	public void setChaasupplier(String chaasupplier) {
		this.chaasupplier = chaasupplier;
	}

	public String getChaasuppliername() {
		return chaasuppliername;
	}

	public void setChaasuppliername(String chaasuppliername) {
		this.chaasuppliername = chaasuppliername;
	}

	public String getCshawbillassociation() {
		return cshawbillassociation;
	}

	public void setCshawbillassociation(String cshawbillassociation) {
		this.cshawbillassociation = cshawbillassociation;
	}

	public String getCshawflag() {
		return cshawflag;
	}

	public void setCshawflag(String cshawflag) {
		this.cshawflag = cshawflag;
	}

	public String getCshawbillid() {
		return cshawbillid;
	}

	public void setCshawbillid(String cshawbillid) {
		this.cshawbillid = cshawbillid;
	}

	public String getCshawbilldate() {
		return cshawbilldate;
	}

	public void setCshawbilldate(String cshawbilldate) {
		this.cshawbilldate = cshawbilldate;
	}

	public String getCshawoutdepartmentid() {
		return cshawoutdepartmentid;
	}

	public void setCshawoutdepartmentid(String cshawoutdepartmentid) {
		this.cshawoutdepartmentid = cshawoutdepartmentid;
	}

	public String getCshawoutstockid() {
		return cshawoutstockid;
	}

	public void setCshawoutstockid(String cshawoutstockid) {
		this.cshawoutstockid = cshawoutstockid;
	}

	public String getCshawindepartmentid() {
		return cshawindepartmentid;
	}

	public void setCshawindepartmentid(String cshawindepartmentid) {
		this.cshawindepartmentid = cshawindepartmentid;
	}

	public String getCshawinstockid() {
		return cshawinstockid;
	}

	public void setCshawinstockid(String cshawinstockid) {
		this.cshawinstockid = cshawinstockid;
	}

	public String getCshawcreateperson() {
		return cshawcreateperson;
	}

	public void setCshawcreateperson(String cshawcreateperson) {
		this.cshawcreateperson = cshawcreateperson;
	}

	public String getCshawauditperson() {
		return cshawauditperson;
	}

	public void setCshawauditperson(String cshawauditperson) {
		this.cshawauditperson = cshawauditperson;
	}

	public String getCshawauditstate() {
		return cshawauditstate;
	}

	public void setCshawauditstate(String cshawauditstate) {
		this.cshawauditstate = cshawauditstate;
	}

	public String getCshawauditdate() {
		return cshawauditdate;
	}

	public void setCshawauditdate(String cshawauditdate) {
		this.cshawauditdate = cshawauditdate;
	}

	public String getCshawconsignee() {
		return cshawconsignee;
	}

	public void setCshawconsignee(String cshawconsignee) {
		this.cshawconsignee = cshawconsignee;
	}

	public String getCshawconsignstate() {
		return cshawconsignstate;
	}

	public void setCshawconsignstate(String cshawconsignstate) {
		this.cshawconsignstate = cshawconsignstate;
	}

	public String getCshawconsigndate() {
		return cshawconsigndate;
	}

	public void setCshawconsigndate(String cshawconsigndate) {
		this.cshawconsigndate = cshawconsigndate;
	}

	public String getCshawremark() {
		return cshawremark;
	}

	public void setCshawremark(String cshawremark) {
		this.cshawremark = cshawremark;
	}

	public String getCshawoutdepartmentname() {
		return cshawoutdepartmentname;
	}

	public void setCshawoutdepartmentname(String cshawoutdepartmentname) {
		this.cshawoutdepartmentname = cshawoutdepartmentname;
	}

	public String getCshawindepartmentname() {
		return cshawindepartmentname;
	}

	public void setCshawindepartmentname(String cshawindepartmentname) {
		this.cshawindepartmentname = cshawindepartmentname;
	}

	public String getCshawstartTime() {
		return cshawstartTime;
	}

	public void setCshawstartTime(String cshawstartTime) {
		this.cshawstartTime = cshawstartTime;
	}

	public String getCshawendTime() {
		return cshawendTime;
	}

	public void setCshawendTime(String cshawendTime) {
		this.cshawendTime = cshawendTime;
	}

	public String getCshawcreatepersonname() {
		return cshawcreatepersonname;
	}

	public void setCshawcreatepersonname(String cshawcreatepersonname) {
		this.cshawcreatepersonname = cshawcreatepersonname;
	}

	public String getCshawauditpersonname() {
		return cshawauditpersonname;
	}

	public void setCshawauditpersonname(String cshawauditpersonname) {
		this.cshawauditpersonname = cshawauditpersonname;
	}

	public String getCshawconsigneename() {
		return cshawconsigneename;
	}

	public void setCshawconsigneename(String cshawconsigneename) {
		this.cshawconsigneename = cshawconsigneename;
	}

	public String getCshawoutstockname() {
		return cshawoutstockname;
	}

	public void setCshawoutstockname(String cshawoutstockname) {
		this.cshawoutstockname = cshawoutstockname;
	}

	public String getCshawinstockname() {
		return cshawinstockname;
	}

	public void setCshawinstockname(String cshawinstockname) {
		this.cshawinstockname = cshawinstockname;
	}

	public String getChaabrand() {
		return chaabrand;
	}

	public void setChaabrand(String chaabrand) {
		this.chaabrand = chaabrand;
	}

	public String getChaabrandname() {
		return chaabrandname;
	}

	public void setChaabrandname(String chaabrandname) {
		this.chaabrandname = chaabrandname;
	}

	public String getIsWriteoffs() {
		return isWriteoffs;
	}

	public void setIsWriteoffs(String isWriteoffs) {
		this.isWriteoffs = isWriteoffs;
	}

}
