/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : PayMentBillPo.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2012-05-04
**/
package com.pengsheng.eims.logistics.persistence;

public class PayMentBillPo {

	private String sLpbpbID = null;  //付款单号
	private String sLpbpbSupplierID = null;  //制造商号
	private String sLpbpbDate = null;  //付款日期
	private String sLpbpbDepartmentID = null;  //制单人部门ID
	private String sLpbpbCreatePersonID = null;  //制单人ID
	private String sLpbpbAuditStatue = null;  //审核状态
	private String sLpbpbAuditPersonID = null;  //	审核人ID
	private String sLpbpbAuditDate = null;  //审核日期
	private String sLpbpbCostPriceAmount = null;  //付款金额
	private String sLpbpbPayMentAmount = null;  //已付款金额
	private String sLpbpbDiscountAmount = null;  //折扣金额
	private String sLpbpbRemark = null;  //	备注
	private String sLpbpbSupplierName = null;  //制造商名称
	private String sLpbpbStartDate = null;  //开始制单日期
	private String sLpbpbEndDate = null;  //结束制单日期	
	private String sLpbpbAuditStartDate = null;  //开始审核日期
	private String sLpbpbAuditEndDate = null;  //结束审核日期
	private String sLpbpbDepartmentName = null;  //部门名称
	private String sLpbpbAuditPersonName = null;  //审核人姓名
	private String sLpbpbCreatePersonName = null;  //制单人姓名
	private String sLpbpbIsVoucher = null;  //凭证标记
	private String sLpbpbTypeID = null;  //单据类型编号
	private String sLpbpbTypeName = null;  //单据类型名称
	private String sLpbpbCurrentPayMentAmount = null;  //本次付款
	private String sLpbpbPayMentDptID = null;  //付款部门ID
	private String sLpbpbPayMentDptName = null;  //付款部门名称
	private String sLpbpbCheckStatus = null;  //核销状态
	private String sLpbpbCompanyID = null;  //公司ID
	private String sLpbpbSubSupplierID = null;  //供应商ID
	
	public String getsLpbpbSubSupplierID() {
		return sLpbpbSubSupplierID;
	}
	public void setsLpbpbSubSupplierID(String sLpbpbSubSupplierID) {
		this.sLpbpbSubSupplierID = sLpbpbSubSupplierID;
	}
	public String getsLpbpbCompanyID() {
		return sLpbpbCompanyID;
	}
	public void setsLpbpbCompanyID(String sLpbpbCompanyID) {
		this.sLpbpbCompanyID = sLpbpbCompanyID;
	}
	public String getsLpbpbCheckStatus() {
		return sLpbpbCheckStatus;
	}
	public void setsLpbpbCheckStatus(String sLpbpbCheckStatus) {
		this.sLpbpbCheckStatus = sLpbpbCheckStatus;
	}
	public String getsLpbpbID() {
		return sLpbpbID;
	}
	public void setsLpbpbID(String sLpbpbID) {
		this.sLpbpbID = sLpbpbID;
	}
	public String getsLpbpbSupplierID() {
		return sLpbpbSupplierID;
	}
	public void setsLpbpbSupplierID(String sLpbpbSupplierID) {
		this.sLpbpbSupplierID = sLpbpbSupplierID;
	}
	public String getsLpbpbDate() {
		return sLpbpbDate;
	}
	public void setsLpbpbDate(String sLpbpbDate) {
		this.sLpbpbDate = sLpbpbDate;
	}
	public String getsLpbpbDepartmentID() {
		return sLpbpbDepartmentID;
	}
	public void setsLpbpbDepartmentID(String sLpbpbDepartmentID) {
		this.sLpbpbDepartmentID = sLpbpbDepartmentID;
	}
	public String getsLpbpbCreatePersonID() {
		return sLpbpbCreatePersonID;
	}
	public void setsLpbpbCreatePersonID(String sLpbpbCreatePersonID) {
		this.sLpbpbCreatePersonID = sLpbpbCreatePersonID;
	}
	public String getsLpbpbAuditStatue() {
		return sLpbpbAuditStatue;
	}
	public void setsLpbpbAuditStatue(String sLpbpbAuditStatue) {
		this.sLpbpbAuditStatue = sLpbpbAuditStatue;
	}
	public String getsLpbpbAuditPersonID() {
		return sLpbpbAuditPersonID;
	}
	public void setsLpbpbAuditPersonID(String sLpbpbAuditPersonID) {
		this.sLpbpbAuditPersonID = sLpbpbAuditPersonID;
	}
	public String getsLpbpbAuditDate() {
		return sLpbpbAuditDate;
	}
	public void setsLpbpbAuditDate(String sLpbpbAuditDate) {
		this.sLpbpbAuditDate = sLpbpbAuditDate;
	}
	public String getsLpbpbCostPriceAmount() {
		return sLpbpbCostPriceAmount;
	}
	public void setsLpbpbCostPriceAmount(String sLpbpbCostPriceAmount) {
		this.sLpbpbCostPriceAmount = sLpbpbCostPriceAmount;
	}
	public String getsLpbpbDiscountAmount() {
		return sLpbpbDiscountAmount;
	}
	public void setsLpbpbDiscountAmount(String sLpbpbDiscountAmount) {
		this.sLpbpbDiscountAmount = sLpbpbDiscountAmount;
	}
	public String getsLpbpbRemark() {
		return sLpbpbRemark;
	}
	public void setsLpbpbRemark(String sLpbpbRemark) {
		this.sLpbpbRemark = sLpbpbRemark;
	}
	public String getsLpbpbSupplierName() {
		return sLpbpbSupplierName;
	}
	public void setsLpbpbSupplierName(String sLpbpbSupplierName) {
		this.sLpbpbSupplierName = sLpbpbSupplierName;
	}
	public String getsLpbpbStartDate() {
		return sLpbpbStartDate;
	}
	public void setsLpbpbStartDate(String sLpbpbStartDate) {
		this.sLpbpbStartDate = sLpbpbStartDate;
	}
	public String getsLpbpbEndDate() {
		return sLpbpbEndDate;
	}
	public void setsLpbpbEndDate(String sLpbpbEndDate) {
		this.sLpbpbEndDate = sLpbpbEndDate;
	}
	public String getsLpbpbAuditStartDate() {
		return sLpbpbAuditStartDate;
	}
	public void setsLpbpbAuditStartDate(String sLpbpbAuditStartDate) {
		this.sLpbpbAuditStartDate = sLpbpbAuditStartDate;
	}
	public String getsLpbpbAuditEndDate() {
		return sLpbpbAuditEndDate;
	}
	public void setsLpbpbAuditEndDate(String sLpbpbAuditEndDate) {
		this.sLpbpbAuditEndDate = sLpbpbAuditEndDate;
	}
	public String getsLpbpbDepartmentName() {
		return sLpbpbDepartmentName;
	}
	public void setsLpbpbDepartmentName(String sLpbpbDepartmentName) {
		this.sLpbpbDepartmentName = sLpbpbDepartmentName;
	}
	public String getsLpbpbAuditPersonName() {
		return sLpbpbAuditPersonName;
	}
	public void setsLpbpbAuditPersonName(String sLpbpbAuditPersonName) {
		this.sLpbpbAuditPersonName = sLpbpbAuditPersonName;
	}
	public String getsLpbpbCreatePersonName() {
		return sLpbpbCreatePersonName;
	}
	public void setsLpbpbCreatePersonName(String sLpbpbCreatePersonName) {
		this.sLpbpbCreatePersonName = sLpbpbCreatePersonName;
	}
	public String getsLpbpbPayMentAmount() {
		return sLpbpbPayMentAmount;
	}
	public void setsLpbpbPayMentAmount(String sLpbpbPayMentAmount) {
		this.sLpbpbPayMentAmount = sLpbpbPayMentAmount;
	}
	public String getsLpbpbIsVoucher() {
		return sLpbpbIsVoucher;
	}
	public void setsLpbpbIsVoucher(String sLpbpbIsVoucher) {
		this.sLpbpbIsVoucher = sLpbpbIsVoucher;
	}
	public String getsLpbpbTypeID() {
		return sLpbpbTypeID;
	}
	public void setsLpbpbTypeID(String sLpbpbTypeID) {
		this.sLpbpbTypeID = sLpbpbTypeID;
	}
	public String getsLpbpbCurrentPayMentAmount() {
		return sLpbpbCurrentPayMentAmount;
	}
	public void setsLpbpbCurrentPayMentAmount(String sLpbpbCurrentPayMentAmount) {
		this.sLpbpbCurrentPayMentAmount = sLpbpbCurrentPayMentAmount;
	}
	public String getsLpbpbTypeName() {
		return sLpbpbTypeName;
	}
	public void setsLpbpbTypeName(String sLpbpbTypeName) {
		this.sLpbpbTypeName = sLpbpbTypeName;
	}
	public String getsLpbpbPayMentDptID() {
		return sLpbpbPayMentDptID;
	}
	public void setsLpbpbPayMentDptID(String sLpbpbPayMentDptID) {
		this.sLpbpbPayMentDptID = sLpbpbPayMentDptID;
	}
	public String getsLpbpbPayMentDptName() {
		return sLpbpbPayMentDptName;
	}
	public void setsLpbpbPayMentDptName(String sLpbpbPayMentDptName) {
		this.sLpbpbPayMentDptName = sLpbpbPayMentDptName;
	}
	
	
}
