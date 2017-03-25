/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherEntryPo.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
**/
package com.pengsheng.eims.logistics.persistence;

public class VoucherEntryPo {
    private String sLveveID = null;          //ID
    private String sLveveVoucherID = null;   //凭证号 
    private String sLveveBillID = null;      //发票号\单据号
    private String sLveveGoodsID = null;     //商品代码
    private String sLveveGoodsCategoryID = null;     //商品类型
    private String sLveveAccessoriesType = null;     //辅料类型
    
    /*
     *  单据数据
     */
    private String sGoodsName = null;        //商品名称
    private String sSpec = null;             //规格 
    private String sGoodsQuantity = null;    //数量
    private String sNotTaxRate = null;       //单位成本
    private String sNotTaxRateAmount = null; //成本合计
    private String sTaxRate = null;          //税率 
    private String sCostPrice = null;        //含税单价
    private String sTaxAmount = null;        //税额合计
    private String sCostPriceAmount = null;  //价税合计
    private String sInvoiceState = null;     //核销状态 
    private String sCheckNumber = null;      //核销数量 
    private String sBillDate = null;         //单据日期 
    
	/*
     *  发票数据
     */
    private String sDate = null;             //发票或冲回日期 
    private String sSupplierName = null;     //制造商名称
    private String sDepartment = null;       //部门名称
    private String sDepartmentID = null;     //部门名称
    private String sPersonID = null;         //核销人 
    private String sStockID = null;         //仓位ID
    
	public String getsLveveAccessoriesType() {
		return sLveveAccessoriesType;
	}
	public void setsLveveAccessoriesType(String sLveveAccessoriesType) {
		this.sLveveAccessoriesType = sLveveAccessoriesType;
	}
	public String getsLveveGoodsCategoryID() {
		return sLveveGoodsCategoryID;
	}
	public void setsLveveGoodsCategoryID(String sLveveGoodsCategoryID) {
		this.sLveveGoodsCategoryID = sLveveGoodsCategoryID;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String getsSupplierName() {
		return sSupplierName;
	}
	public void setsSupplierName(String sSupplierName) {
		this.sSupplierName = sSupplierName;
	}
	public String getsDepartment() {
		return sDepartment;
	}
	public void setsDepartment(String sDepartment) {
		this.sDepartment = sDepartment;
	}
	public String getsPersonID() {
		return sPersonID;
	}
	public void setsPersonID(String sPersonID) {
		this.sPersonID = sPersonID;
	}
	public String getsGoodsName() {
		return sGoodsName;
	}
	public void setsGoodsName(String sGoodsName) {
		this.sGoodsName = sGoodsName;
	}
	public String getsSpec() {
		return sSpec;
	}
	public void setsSpec(String sSpec) {
		this.sSpec = sSpec;
	}
	public String getsGoodsQuantity() {
		return sGoodsQuantity;
	}
	public void setsGoodsQuantity(String sGoodsQuantity) {
		this.sGoodsQuantity = sGoodsQuantity;
	}
	public String getsNotTaxRate() {
		return sNotTaxRate;
	}
	public void setsNotTaxRate(String sNotTaxRate) {
		this.sNotTaxRate = sNotTaxRate;
	}
	public String getsNotTaxRateAmount() {
		return sNotTaxRateAmount;
	}
	public void setsNotTaxRateAmount(String sNotTaxRateAmount) {
		this.sNotTaxRateAmount = sNotTaxRateAmount;
	}
	public String getsTaxRate() {
		return sTaxRate;
	}
	public void setsTaxRate(String sTaxRate) {
		this.sTaxRate = sTaxRate;
	}
	public String getsCostPrice() {
		return sCostPrice;
	}
	public void setsCostPrice(String sCostPrice) {
		this.sCostPrice = sCostPrice;
	}
	public String getsTaxAmount() {
		return sTaxAmount;
	}
	public void setsTaxAmount(String sTaxAmount) {
		this.sTaxAmount = sTaxAmount;
	}
	public String getsCostPriceAmount() {
		return sCostPriceAmount;
	}
	public void setsCostPriceAmount(String sCostPriceAmount) {
		this.sCostPriceAmount = sCostPriceAmount;
	}
	public String getsInvoiceState() {
		return sInvoiceState;
	}
	public void setsInvoiceState(String sInvoiceState) {
		this.sInvoiceState = sInvoiceState;
	}
	public String getsLveveID() {
		return sLveveID;
	}
	public void setsLveveID(String sLveveID) {
		this.sLveveID = sLveveID;
	}
	public String getsLveveVoucherID() {
		return sLveveVoucherID;
	}
	public void setsLveveVoucherID(String sLveveVoucherID) {
		this.sLveveVoucherID = sLveveVoucherID;
	}
	public String getsLveveBillID() {
		return sLveveBillID;
	}
	public void setsLveveBillID(String sLveveBillID) {
		this.sLveveBillID = sLveveBillID;
	}
	public String getsLveveGoodsID() {
		return sLveveGoodsID;
	}
	public void setsLveveGoodsID(String sLveveGoodsID) {
		this.sLveveGoodsID = sLveveGoodsID;
	}    
    public String getsCheckNumber() {
		return sCheckNumber;
	}
	public void setsCheckNumber(String sCheckNumber) {
		this.sCheckNumber = sCheckNumber;
	}
	public String getsBillDate() {
		return sBillDate;
	}
	public void setsBillDate(String sBillDate) {
		this.sBillDate = sBillDate;
	}
	public String getsDepartmentID() {
		return sDepartmentID;
	}
	public void setsDepartmentID(String sDepartmentID) {
		this.sDepartmentID = sDepartmentID;
	}
	public String getsStockID() {
		return sStockID;
	}
	public void setsStockID(String sStockID) {
		this.sStockID = sStockID;
	}
	
}
