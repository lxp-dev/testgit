package com.pengsheng.eims.storage.persistence;

public class ConsignProcessOrderPo {

	private String cstcpoorderbillid;// 订单编号
	private String cstcpobilldate;// 单据日期
	private String cstcpoordergoodscategory;// 订做商品类型
	private String cstcposupplierid;// 制造商
	private String cstcpocreateperson;// 创建人
	private String cstcpoauditperson;// 审核人
	private String cstcpoauditdate;// 审核日期
	private String cstcpoauditstate;// 0，未审核 1，已审核
	private String cstcporemark;// 备注
	private String cstcpostarttime;// 开始时间
	private String cstcpoendtime;// /结束时间
	private String createPersonName;// 创建人姓名
	private String auditPersonName;// 审核人姓名
	private String bspsuppliername; // 制造商名称
	private String salesid;			//配镜单号
	private String salesdjsbm;		//配镜单识别码;
	
	private String cstcpodeliveryaddress;  // 收购收货默认地址
	private String cstcpodeliveryperson;   // 收购收货默认联系人
	private String cstcpodeliveryphone;    // 收购收货默认联系电话
	private String cstcpodeliveryfax;      // 收购收货默认传真
	private String cstcpogoodsname;// 商品名称
	private String cstcposalesremark;
	
	private String cstcpodeparmentid;   // s所属公司ID
	private String cstcpocompanyid;   // s所属公司ID
	
	public String getCstcpodeparmentid() {
		return cstcpodeparmentid;
	}

	public void setCstcpodeparmentid(String cstcpodeparmentid) {
		this.cstcpodeparmentid = cstcpodeparmentid;
	}

	public String getCstcpocompanyid() {
		return cstcpocompanyid;
	}

	public void setCstcpocompanyid(String cstcpocompanyid) {
		this.cstcpocompanyid = cstcpocompanyid;
	}

	public String getCstcposalesremark() {
		return cstcposalesremark;
	}

	public void setCstcposalesremark(String cstcposalesremark) {
		this.cstcposalesremark = cstcposalesremark;
	}

	public String getCstcpodignosisre() {
		return cstcpodignosisre;
	}

	public void setCstcpodignosisre(String cstcpodignosisre) {
		this.cstcpodignosisre = cstcpodignosisre;
	}

	private String cstcpodignosisre;
	private String cstcporesalesremark; // 委外重订单备注
	
	

	public String getCstcporesalesremark() {
		return cstcporesalesremark;
	}

	public void setCstcporesalesremark(String cstcporesalesremark) {
		this.cstcporesalesremark = cstcporesalesremark;
	}

	

	public String getCstcpogoodsname() {
		return cstcpogoodsname;
	}

	public void setCstcpogoodsname(String cstcpogoodsname) {
		this.cstcpogoodsname = cstcpogoodsname;
	}

	public String getCstcpodeliveryaddress() {
		return cstcpodeliveryaddress;
	}

	public void setCstcpodeliveryaddress(String cstcpodeliveryaddress) {
		this.cstcpodeliveryaddress = cstcpodeliveryaddress;
	}

	public String getCstcpodeliveryperson() {
		return cstcpodeliveryperson;
	}

	public void setCstcpodeliveryperson(String cstcpodeliveryperson) {
		this.cstcpodeliveryperson = cstcpodeliveryperson;
	}

	public String getCstcpodeliveryphone() {
		return cstcpodeliveryphone;
	}

	public void setCstcpodeliveryphone(String cstcpodeliveryphone) {
		this.cstcpodeliveryphone = cstcpodeliveryphone;
	}

	public String getCstcpodeliveryfax() {
		return cstcpodeliveryfax;
	}

	public void setCstcpodeliveryfax(String cstcpodeliveryfax) {
		this.cstcpodeliveryfax = cstcpodeliveryfax;
	}

	public String getSalesid() {
		return salesid;
	}

	public void setSalesid(String salesid) {
		this.salesid = salesid;
	}

	public String getCstcpoorderbillid() {
		return cstcpoorderbillid;
	}

	public void setCstcpoorderbillid(String cstcpoorderbillid) {
		this.cstcpoorderbillid = cstcpoorderbillid;
	}

	public String getCstcpobilldate() {
		return cstcpobilldate;
	}

	public void setCstcpobilldate(String cstcpobilldate) {
		this.cstcpobilldate = cstcpobilldate;
	}

	public String getCstcpoordergoodscategory() {
		return cstcpoordergoodscategory;
	}

	public void setCstcpoordergoodscategory(String cstcpoordergoodscategory) {
		this.cstcpoordergoodscategory = cstcpoordergoodscategory;
	}

	public String getCstcposupplierid() {
		return cstcposupplierid;
	}

	public void setCstcposupplierid(String cstcposupplierid) {
		this.cstcposupplierid = cstcposupplierid;
	}

	public String getCstcpocreateperson() {
		return cstcpocreateperson;
	}

	public void setCstcpocreateperson(String cstcpocreateperson) {
		this.cstcpocreateperson = cstcpocreateperson;
	}

	public String getCstcpoauditperson() {
		return cstcpoauditperson;
	}

	public void setCstcpoauditperson(String cstcpoauditperson) {
		this.cstcpoauditperson = cstcpoauditperson;
	}

	public String getCstcpoauditdate() {
		return cstcpoauditdate;
	}

	public void setCstcpoauditdate(String cstcpoauditdate) {
		this.cstcpoauditdate = cstcpoauditdate;
	}

	public String getCstcpoauditstate() {
		return cstcpoauditstate;
	}

	public void setCstcpoauditstate(String cstcpoauditstate) {
		this.cstcpoauditstate = cstcpoauditstate;
	}

	public String getCstcporemark() {
		return cstcporemark;
	}

	public void setCstcporemark(String cstcporemark) {
		this.cstcporemark = cstcporemark;
	}

	public String getCstcpostarttime() {
		return cstcpostarttime;
	}

	public void setCstcpostarttime(String cstcpostarttime) {
		this.cstcpostarttime = cstcpostarttime;
	}

	public String getCstcpoendtime() {
		return cstcpoendtime;
	}

	public void setCstcpoendtime(String cstcpoendtime) {
		this.cstcpoendtime = cstcpoendtime;
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

	public String getBspsuppliername() {
		return bspsuppliername;
	}

	public void setBspsuppliername(String bspsuppliername) {
		this.bspsuppliername = bspsuppliername;
	}

	public String getSalesdjsbm() {
		return salesdjsbm;
	}

	public void setSalesdjsbm(String salesdjsbm) {
		this.salesdjsbm = salesdjsbm;
	}

}
