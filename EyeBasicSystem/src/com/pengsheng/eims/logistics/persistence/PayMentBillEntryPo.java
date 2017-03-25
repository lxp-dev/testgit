/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : PayMentBillEntryPo.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2012-05-04
**/
package com.pengsheng.eims.logistics.persistence;

public class PayMentBillEntryPo{
    
	private String sLpbpbeID = null;                 //主键
	private String sLpbpbeBillID = null;             //付款单号
	private String sLpbpbeBillTypeID = null;         //单据类型
	private String sLpbpbeInvoiceID = null;          //发票号
	private String sLpbpbeCostPriceAmount = null;    //付款金额
	private String sLpbpbePayMentAmount = null;      //已付款金额
	private String sLpbpbeDiscountAmount = null;     //折扣金额
	private String sLpbpbeRemark = null;             //备注
	private String sLpbpbeOutComeName = null;        //收支类型
	private String sCstieCostPriceAmount = null;     //单据金额
	private String sLpbpbePayedMentAmount = null;    //已核销金额
	private String sLpbpbePayedMentDate = null;      //单据日期
	
	public String getsLpbpbeID() {
		return sLpbpbeID;
	}
	public void setsLpbpbeID(String sLpbpbeID) {
		this.sLpbpbeID = sLpbpbeID;
	}
	public String getsLpbpbeBillID() {
		return sLpbpbeBillID;
	}
	public void setsLpbpbeBillID(String sLpbpbeBillID) {
		this.sLpbpbeBillID = sLpbpbeBillID;
	}
	public String getsLpbpbeBillTypeID() {
		return sLpbpbeBillTypeID;
	}
	public void setsLpbpbeBillTypeID(String sLpbpbeBillTypeID) {
		this.sLpbpbeBillTypeID = sLpbpbeBillTypeID;
	}
	public String getsLpbpbeInvoiceID() {
		return sLpbpbeInvoiceID;
	}
	public void setsLpbpbeInvoiceID(String sLpbpbeInvoiceID) {
		this.sLpbpbeInvoiceID = sLpbpbeInvoiceID;
	}
	public String getsLpbpbeCostPriceAmount() {
		return sLpbpbeCostPriceAmount;
	}
	public void setsLpbpbeCostPriceAmount(String sLpbpbeCostPriceAmount) {
		this.sLpbpbeCostPriceAmount = sLpbpbeCostPriceAmount;
	}
	public String getsLpbpbeDiscountAmount() {
		return sLpbpbeDiscountAmount;
	}
	public void setsLpbpbeDiscountAmount(String sLpbpbeDiscountAmount) {
		this.sLpbpbeDiscountAmount = sLpbpbeDiscountAmount;
	}
	public String getsLpbpbePayMentAmount() {
		return sLpbpbePayMentAmount;
	}
	public void setsLpbpbePayMentAmount(String sLpbpbePayMentAmount) {
		this.sLpbpbePayMentAmount = sLpbpbePayMentAmount;
	}
	public String getsLpbpbeRemark() {
		return sLpbpbeRemark;
	}
	public void setsLpbpbeRemark(String sLpbpbeRemark) {
		this.sLpbpbeRemark = sLpbpbeRemark;
	}
	public String getsLpbpbeOutComeName() {
		return sLpbpbeOutComeName;
	}
	public void setsLpbpbeOutComeName(String sLpbpbeOutComeName) {
		this.sLpbpbeOutComeName = sLpbpbeOutComeName;
	}
	public String getsCstieCostPriceAmount() {
		return sCstieCostPriceAmount;
	}
	public void setsCstieCostPriceAmount(String sCstieCostPriceAmount) {
		this.sCstieCostPriceAmount = sCstieCostPriceAmount;
	}
	public String getsLpbpbePayedMentAmount() {
		return sLpbpbePayedMentAmount;
	}
	public void setsLpbpbePayedMentAmount(String sLpbpbePayedMentAmount) {
		this.sLpbpbePayedMentAmount = sLpbpbePayedMentAmount;
	}
	public String getsLpbpbePayedMentDate() {
		return sLpbpbePayedMentDate;
	}
	public void setsLpbpbePayedMentDate(String sLpbpbePayedMentDate) {
		this.sLpbpbePayedMentDate = sLpbpbePayedMentDate;
	}

	
}
