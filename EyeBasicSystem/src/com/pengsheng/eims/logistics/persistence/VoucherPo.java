/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherPo.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
**/
package com.pengsheng.eims.logistics.persistence;

public class VoucherPo {
	
	private String sLvvID = null;                   //凭证号 
    private String sLvvSupplierID = null;           //制造商ID
    private String sLvvSupplierName = null;         //制造商名称
	private String sLvvDate = null;                 //凭证日期
	private String sLvvDateTopLimit = null;         //凭证日期上限
	private String sLvvDateLowerLimit = null;       //凭证日期下限
    private String sLvvPersonID = null;             //凭证人ID
    private String sLvvPersonName = null;           //凭证人名称
	private String sLvvVoucherTypeID = null;        //子类凭证类型ID（与DB中凭证类型ID对应）
    private String sLvvVoucherTypeName = null;      //子类凭证类型名称
    private String sLvvVoucherParentTypeID = null;  //父类凭证类型ID
    private String sLvvVoucherParentTypeName = null;//父类凭证类型名称
	private String sLvvBalanceMethod = null;        //结算方式
    private String sLvvAuditStatue = null;          //审核状态
    private String sLvvAuditPersonID = null;        //审核人ID
    private String sLvvAuditPersonName = null;      //审核人名称
	private String sLvvAuditDate = null;            //审核日期
	private String sLvvAuditDateTopLimit = null;    //审核日期上限
	private String sLvvAuditDateLowerLimit = null;  //审核日期下限
	private String sLvvHandlePersonID = null;       //经办人
    private String sLvvRemark = null;               //备注     
	private String sLvvNotTaxRateAmount = null;     //成本合计
	private String sLvvTaxAmount = null;            //税额合计
    private String sLvvCostPriceAmount = null;      //价税合计    
    private String sLvvPosting = null;              //过账标识	0:未过账  1:已过账
    private String sShopCode = null;
    private String sLvvAttchBillCount = null;       //附单数        
    private String sLvvCreateDptID = null;          // 创建人部门
    private String sLvvAuditDptID = null;           // 审核人部门
    private String sLvvTypeID = null;              //  凭证种类
    private String sLvvDepartmentID = null;        // 核算部门
    private String sLvvFranchiseeDptID = null;          // 创建人部门
    private String sLvvCompanyID = null;          // 所属公司
    private String sLvvSubSupplierID = null;           //供应商ID
    
	public String getsLvvSubSupplierID() {
		return sLvvSubSupplierID;
	}
	public void setsLvvSubSupplierID(String sLvvSubSupplierID) {
		this.sLvvSubSupplierID = sLvvSubSupplierID;
	}
	public String getsLvvCompanyID() {
		return sLvvCompanyID;
	}
	public void setsLvvCompanyID(String sLvvCompanyID) {
		this.sLvvCompanyID = sLvvCompanyID;
	}
	public String getsLvvFranchiseeDptID() {
		return sLvvFranchiseeDptID;
	}
	public void setsLvvFranchiseeDptID(String sLvvFranchiseeDptID) {
		this.sLvvFranchiseeDptID = sLvvFranchiseeDptID;
	}
	public String getsLvvCreateDptID() {
		return sLvvCreateDptID;
	}
	public void setsLvvCreateDptID(String sLvvCreateDptID) {
		this.sLvvCreateDptID = sLvvCreateDptID;
	}
	public String getsLvvAuditDptID() {
		return sLvvAuditDptID;
	}
	public void setsLvvAuditDptID(String sLvvAuditDptID) {
		this.sLvvAuditDptID = sLvvAuditDptID;
	}
	public String getsLvvTypeID() {
		return sLvvTypeID;
	}
	public void setsLvvTypeID(String sLvvTypeID) {
		this.sLvvTypeID = sLvvTypeID;
	}
	public String getsLvvDepartmentID() {
		return sLvvDepartmentID;
	}
	public void setsLvvDepartmentID(String sLvvDepartmentID) {
		this.sLvvDepartmentID = sLvvDepartmentID;
	}
	public String getsLvvAttchBillCount() {
		return sLvvAttchBillCount;
	}
	public void setsLvvAttchBillCount(String sLvvAttchBillCount) {
		this.sLvvAttchBillCount = sLvvAttchBillCount;
	}
	public String getsShopCode() {
		return sShopCode;
	}
	public void setsShopCode(String sShopCode) {
		this.sShopCode = sShopCode;
	}
	public String getsLvvNotTaxRateAmount() {
		return sLvvNotTaxRateAmount;
	}
	public void setsLvvNotTaxRateAmount(String sLvvNotTaxRateAmount) {
		this.sLvvNotTaxRateAmount = sLvvNotTaxRateAmount;
	}
	public String getsLvvTaxAmount() {
		return sLvvTaxAmount;
	}
	public void setsLvvTaxAmount(String sLvvTaxAmount) {
		this.sLvvTaxAmount = sLvvTaxAmount;
	}
	public String getsLvvCostPriceAmount() {
		return sLvvCostPriceAmount;
	}
	public void setsLvvCostPriceAmount(String sLvvCostPriceAmount) {
		this.sLvvCostPriceAmount = sLvvCostPriceAmount;
	}
    public String getsLvvPersonName() {
		return sLvvPersonName;
	}
	public void setsLvvPersonName(String sLvvPersonName) {
		this.sLvvPersonName = sLvvPersonName;
	}
    public String getsLvvAuditPersonName() {
		return sLvvAuditPersonName;
	}
	public void setsLvvAuditPersonName(String sLvvAuditPersonName) {
		this.sLvvAuditPersonName = sLvvAuditPersonName;
	}
    public String getsLvvDateTopLimit() {
		return sLvvDateTopLimit;
	}
	public void setsLvvDateTopLimit(String sLvvDateTopLimit) {
		this.sLvvDateTopLimit = sLvvDateTopLimit;
	}
	public String getsLvvDateLowerLimit() {
		return sLvvDateLowerLimit;
	}
	public void setsLvvDateLowerLimit(String sLvvDateLowerLimit) {
		this.sLvvDateLowerLimit = sLvvDateLowerLimit;
	}
	public String getsLvvAuditDateTopLimit() {
		return sLvvAuditDateTopLimit;
	}
	public void setsLvvAuditDateTopLimit(String sLvvAuditDateTopLimit) {
		this.sLvvAuditDateTopLimit = sLvvAuditDateTopLimit;
	}
	public String getsLvvAuditDateLowerLimit() {
		return sLvvAuditDateLowerLimit;
	}
	public void setsLvvAuditDateLowerLimit(String sLvvAuditDateLowerLimit) {
		this.sLvvAuditDateLowerLimit = sLvvAuditDateLowerLimit;
	}
    public String getsLvvID() {
		return sLvvID;
	}
	public void setsLvvID(String sLvvID) {
		this.sLvvID = sLvvID;
	}
	public String getsLvvSupplierID() {
		return sLvvSupplierID;
	}
	public void setsLvvSupplierID(String sLvvSupplierID) {
		this.sLvvSupplierID = sLvvSupplierID;
	}
	public String getsLvvDate() {
		return sLvvDate;
	}
	public void setsLvvDate(String sLvvDate) {
		this.sLvvDate = sLvvDate;
	}
	public String getsLvvPersonID() {
		return sLvvPersonID;
	}
	public void setsLvvPersonID(String sLvvPersonID) {
		this.sLvvPersonID = sLvvPersonID;
	}
	public String getsLvvVoucherTypeID() {
		return sLvvVoucherTypeID;
	}
	public void setsLvvVoucherTypeID(String sLvvVoucherTypeID) {
		this.sLvvVoucherTypeID = sLvvVoucherTypeID;
	}
	public String getsLvvBalanceMethod() {
		return sLvvBalanceMethod;
	}
	public void setsLvvBalanceMethod(String sLvvBalanceMethod) {
		this.sLvvBalanceMethod = sLvvBalanceMethod;
	}
	public String getsLvvAuditStatue() {
		return sLvvAuditStatue;
	}
	public void setsLvvAuditStatue(String sLvvAuditStatue) {
		this.sLvvAuditStatue = sLvvAuditStatue;
	}
	public String getsLvvAuditPersonID() {
		return sLvvAuditPersonID;
	}
	public void setsLvvAuditPersonID(String sLvvAuditPersonID) {
		this.sLvvAuditPersonID = sLvvAuditPersonID;
	}
	public String getsLvvAuditDate() {
		return sLvvAuditDate;
	}
	public void setsLvvAuditDate(String sLvvAuditDate) {
		this.sLvvAuditDate = sLvvAuditDate;
	}
	public String getsLvvHandlePersonID() {
		return sLvvHandlePersonID;
	}
	public void setsLvvHandlePersonID(String sLvvHandlePersonID) {
		this.sLvvHandlePersonID = sLvvHandlePersonID;
	}
	public String getsLvvRemark() {
		return sLvvRemark;
	}
	public void setsLvvRemark(String sLvvRemark) {
		this.sLvvRemark = sLvvRemark;
	}
	public String getsLvvSupplierName() {
		return sLvvSupplierName;
	}
	public void setsLvvSupplierName(String sLvvSupplierName) {
		this.sLvvSupplierName = sLvvSupplierName;
	}
    public String getsLvvVoucherParentTypeID() {
		return sLvvVoucherParentTypeID;
	}
	public void setsLvvVoucherParentTypeID(String sLvvVoucherParentTypeID) {
		this.sLvvVoucherParentTypeID = sLvvVoucherParentTypeID;
	}
	public String getsLvvVoucherTypeName() {
		return sLvvVoucherTypeName;
	}
	public void setsLvvVoucherTypeName(String sLvvVoucherTypeName) {
		this.sLvvVoucherTypeName = sLvvVoucherTypeName;
	}
	public String getsLvvVoucherParentTypeName() {
		return sLvvVoucherParentTypeName;
	}
	public void setsLvvVoucherParentTypeName(String sLvvVoucherParentTypeName) {
		this.sLvvVoucherParentTypeName = sLvvVoucherParentTypeName;
	}
	public String getsLvvPosting() {
		return sLvvPosting;
	}
	public void setsLvvPosting(String sLvvPosting) {
		this.sLvvPosting = sLvvPosting;
	}
}
