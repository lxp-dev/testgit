package com.pengsheng.eims.logistics.persistence;

public class ReceiptMentBillEntryPo {
	
	private String sLrbrbeID = null;                 //主键
	private String sLrbrbeBillID = null;             //收款单号
	private String sLrbrbeBillTypeID = null;         //单据类型
	private String sLrbrbeAllocateID = null;         //客户批发调货单号
	private String sLrbrbeBillDate = null;           //单据日期
	private String sLrbrbeCostPriceAmount = null;    //单据金额
	private String sLrbrbeReceiptedMentAmount = null;  //已冲账金额
	private String sLrbrbeNotReceiptedMentAmount = null;  //未收款金额
	private String sLrbrbeReceiptMentAmount = null;  //收款金额
	private String sLrbrbeRemark = null;             //备注
	
	public String getsLrbrbeNotReceiptedMentAmount() {
		return sLrbrbeNotReceiptedMentAmount;
	}
	public void setsLrbrbeNotReceiptedMentAmount(
			String sLrbrbeNotReceiptedMentAmount) {
		this.sLrbrbeNotReceiptedMentAmount = sLrbrbeNotReceiptedMentAmount;
	}
	public String getsLrbrbeID() {
		return sLrbrbeID;
	}
	public void setsLrbrbeID(String sLrbrbeID) {
		this.sLrbrbeID = sLrbrbeID;
	}
	public String getsLrbrbeBillID() {
		return sLrbrbeBillID;
	}
	public void setsLrbrbeBillID(String sLrbrbeBillID) {
		this.sLrbrbeBillID = sLrbrbeBillID;
	}
	public String getsLrbrbeBillTypeID() {
		return sLrbrbeBillTypeID;
	}
	public void setsLrbrbeBillTypeID(String sLrbrbeBillTypeID) {
		this.sLrbrbeBillTypeID = sLrbrbeBillTypeID;
	}
	public String getsLrbrbeAllocateID() {
		return sLrbrbeAllocateID;
	}
	public void setsLrbrbeAllocateID(String sLrbrbeAllocateID) {
		this.sLrbrbeAllocateID = sLrbrbeAllocateID;
	}
	public String getsLrbrbeBillDate() {
		return sLrbrbeBillDate;
	}
	public void setsLrbrbeBillDate(String sLrbrbeBillDate) {
		this.sLrbrbeBillDate = sLrbrbeBillDate;
	}
	public String getsLrbrbeCostPriceAmount() {
		return sLrbrbeCostPriceAmount;
	}
	public void setsLrbrbeCostPriceAmount(String sLrbrbeCostPriceAmount) {
		this.sLrbrbeCostPriceAmount = sLrbrbeCostPriceAmount;
	}
	public String getsLrbrbeReceiptedMentAmount() {
		return sLrbrbeReceiptedMentAmount;
	}
	public void setsLrbrbeReceiptedMentAmount(String sLrbrbeReceiptedMentAmount) {
		this.sLrbrbeReceiptedMentAmount = sLrbrbeReceiptedMentAmount;
	}
	public String getsLrbrbeReceiptMentAmount() {
		return sLrbrbeReceiptMentAmount;
	}
	public void setsLrbrbeReceiptMentAmount(String sLrbrbeReceiptMentAmount) {
		this.sLrbrbeReceiptMentAmount = sLrbrbeReceiptMentAmount;
	}
	public String getsLrbrbeRemark() {
		return sLrbrbeRemark;
	}
	public void setsLrbrbeRemark(String sLrbrbeRemark) {
		this.sLrbrbeRemark = sLrbrbeRemark;
	}
	
}
