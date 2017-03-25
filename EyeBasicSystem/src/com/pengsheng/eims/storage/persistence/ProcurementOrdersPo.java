package com.pengsheng.eims.storage.persistence;

public class ProcurementOrdersPo {

	private String cstpid;	//单据编号
	
	private String cstpbillid;	//单据编号

	private String cstpbilltypeid;	//单据类型

	private String cstpbilldate;	//单据日期

	private String cstpsupplierid;	//制造商编码

	private String bspsuppliername;	//制造商名称

	private String cstpgoodscategory;	//商品类别

	private String cstpcreateperson;	//制单人

	private String cstpcreatedate;	//制单日期

	private String cstpauditperson;	//审核人

	private String cstpauditstate;	//审核状态

	private String cstpauditdate;	//审核日期

	private String cstpremark;	//备注

	private String cstpstarttime;	//开始时间

	private String cstpendtime;		//结束时间

	private String createPersonName;	//制单人姓名

	private String auditPersonName;		//审核人人姓名

	private String bgcgoodscategoryname;	//商品类别名称

	private String cstpcustomerid; 	// 公司别名

	private String cstpdeliveryid;	// 发货单号
	
	private String cshaaabillid;	// 调拨申请单号
	
	private String cshaaadepartmentid;	//调拨申请仓位
	
	private String cstpgoodsname;
	private String cstpgoodsid;
	
	private String cstpordersdeliveryaddress;  // 收购收货默认地址
	private String cstpordersdeliveryperson;   // 收购收货默认联系人
	private String cstpordersdeliveryphone;    // 收购收货默认联系电话
	private String cstpordersdeliveryfax;      // 收购收货默认传真
	
	private String cstpbrandname;
	private String cstpbrandid;
	private String cstpflag;	      // 收货标识位
	private String fspstealtheffective;	      // 系统参数的隐形有效期配置	
	
	private String cstpdepartmentid;	//制单部门ID
	private String cstpcompanyid;	//公司ID

	public String getCstpdepartmentid() {
		return cstpdepartmentid;
	}

	public void setCstpdepartmentid(String cstpdepartmentid) {
		this.cstpdepartmentid = cstpdepartmentid;
	}

	public String getCstpcompanyid() {
		return cstpcompanyid;
	}

	public void setCstpcompanyid(String cstpcompanyid) {
		this.cstpcompanyid = cstpcompanyid;
	}

	public String getCstpbillid() {
		return cstpbillid;
	}

	public void setCstpbillid(String cstpbillid) {
		this.cstpbillid = cstpbillid;
	}

	public String getCstpbrandname() {
		return cstpbrandname;
	}

	public void setCstpbrandname(String cstpbrandname) {
		this.cstpbrandname = cstpbrandname;
	}

	public String getCstpbrandid() {
		return cstpbrandid;
	}

	public void setCstpbrandid(String cstpbrandid) {
		this.cstpbrandid = cstpbrandid;
	}

	public String getCstpgoodsid() {
		return cstpgoodsid;
	}

	public void setCstpgoodsid(String cstpgoodsid) {
		this.cstpgoodsid = cstpgoodsid;
	}

	public String getCstpordersdeliveryaddress() {
		return cstpordersdeliveryaddress;
	}

	public void setCstpordersdeliveryaddress(String cstpordersdeliveryaddress) {
		this.cstpordersdeliveryaddress = cstpordersdeliveryaddress;
	}

	public String getCstpordersdeliveryperson() {
		return cstpordersdeliveryperson;
	}

	public void setCstpordersdeliveryperson(String cstpordersdeliveryperson) {
		this.cstpordersdeliveryperson = cstpordersdeliveryperson;
	}

	public String getCstpordersdeliveryphone() {
		return cstpordersdeliveryphone;
	}

	public void setCstpordersdeliveryphone(String cstpordersdeliveryphone) {
		this.cstpordersdeliveryphone = cstpordersdeliveryphone;
	}

	public String getCstpordersdeliveryfax() {
		return cstpordersdeliveryfax;
	}

	public void setCstpordersdeliveryfax(String cstpordersdeliveryfax) {
		this.cstpordersdeliveryfax = cstpordersdeliveryfax;
	}

	public String getCstpgoodsname() {
		return cstpgoodsname;
	}

	public void setCstpgoodsname(String cstpgoodsname) {
		this.cstpgoodsname = cstpgoodsname;
	}

	public String getCshaaadepartmentid() {
		return cshaaadepartmentid;
	}

	public void setCshaaadepartmentid(String cshaaadepartmentid) {
		this.cshaaadepartmentid = cshaaadepartmentid;
	}

	public String getCshaaabillid() {
		return cshaaabillid;
	}

	public void setCshaaabillid(String cshaaabillid) {
		this.cshaaabillid = cshaaabillid;
	}

	public String getCstpid() {
		return cstpid;
	}

	public void setCstpid(String cstpid) {
		this.cstpid = cstpid;
	}

	public String getCstpbilltypeid() {
		return cstpbilltypeid;
	}

	public void setCstpbilltypeid(String cstpbilltypeid) {
		this.cstpbilltypeid = cstpbilltypeid;
	}

	public String getCstpbilldate() {
		return cstpbilldate;
	}

	public void setCstpbilldate(String cstpbilldate) {
		this.cstpbilldate = cstpbilldate;
	}

	public String getCstpsupplierid() {
		return cstpsupplierid;
	}

	public void setCstpsupplierid(String cstpsupplierid) {
		this.cstpsupplierid = cstpsupplierid;
	}

	public String getBspsuppliername() {
		return bspsuppliername;
	}

	public void setBspsuppliername(String bspsuppliername) {
		this.bspsuppliername = bspsuppliername;
	}

	public String getCstpgoodscategory() {
		return cstpgoodscategory;
	}

	public void setCstpgoodscategory(String cstpgoodscategory) {
		this.cstpgoodscategory = cstpgoodscategory;
	}

	public String getCstpcreateperson() {
		return cstpcreateperson;
	}

	public void setCstpcreateperson(String cstpcreateperson) {
		this.cstpcreateperson = cstpcreateperson;
	}

	public String getCstpcreatedate() {
		return cstpcreatedate;
	}

	public void setCstpcreatedate(String cstpcreatedate) {
		this.cstpcreatedate = cstpcreatedate;
	}

	public String getCstpauditperson() {
		return cstpauditperson;
	}

	public void setCstpauditperson(String cstpauditperson) {
		this.cstpauditperson = cstpauditperson;
	}

	public String getCstpauditstate() {
		return cstpauditstate;
	}

	public void setCstpauditstate(String cstpauditstate) {
		this.cstpauditstate = cstpauditstate;
	}

	public String getCstpauditdate() {
		return cstpauditdate;
	}

	public void setCstpauditdate(String cstpauditdate) {
		this.cstpauditdate = cstpauditdate;
	}

	public String getCstpremark() {
		return cstpremark;
	}

	public void setCstpremark(String cstpremark) {
		this.cstpremark = cstpremark;
	}

	public String getCstpstarttime() {
		return cstpstarttime;
	}

	public void setCstpstarttime(String cstpstarttime) {
		this.cstpstarttime = cstpstarttime;
	}

	public String getCstpendtime() {
		return cstpendtime;
	}

	public void setCstpendtime(String cstpendtime) {
		this.cstpendtime = cstpendtime;
	}

	public String getCreatePersonName() {
		return createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	public String getAuditPersonName() {
		return auditPersonName;
	}

	public void setAuditPersonName(String auditPersonName) {
		this.auditPersonName = auditPersonName;
	}

	public String getBgcgoodscategoryname() {
		return bgcgoodscategoryname;
	}

	public void setBgcgoodscategoryname(String bgcgoodscategoryname) {
		this.bgcgoodscategoryname = bgcgoodscategoryname;
	}

	public String getCstpcustomerid() {
		return cstpcustomerid;
	}

	public void setCstpcustomerid(String cstpcustomerid) {
		this.cstpcustomerid = cstpcustomerid;
	}

	public String getCstpdeliveryid() {
		return cstpdeliveryid;
	}

	public void setCstpdeliveryid(String cstpdeliveryid) {
		this.cstpdeliveryid = cstpdeliveryid;
	}

	public String getCstpflag() {
		return cstpflag;
	}

	public void setCstpflag(String cstpflag) {
		this.cstpflag = cstpflag;
	}

	public String getFspstealtheffective() {
		return fspstealtheffective;
	}

	public void setFspstealtheffective(String fspstealtheffective) {
		this.fspstealtheffective = fspstealtheffective;
	}

}
