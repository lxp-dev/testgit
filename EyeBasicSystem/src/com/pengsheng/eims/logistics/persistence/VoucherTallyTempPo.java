/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherTallyTempPo.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
**/
package com.pengsheng.eims.logistics.persistence;

public class VoucherTallyTempPo {
	private String[] sLvtvtID = null;                //ID
    private String[] sLvtvtVoucherID = null;         //凭证号
    private String[] sLvtvtResume = null;            //摘要
    private String[] sLvtvtSubjectID = null;         //科目ID
    private String[] sLvtvtSubjectName = null;       //科目名称 
    private String[] sLvtsBalanceDirection = null;   //余额方向
    private String[] sLvtsHBConstant = null;         //公式常量
	private String[] sLvtvtDebitMoney = null;        //借方金额
    private String[] sLvtvtLenderMoney = null;       //贷方金额
    private String[] sLssID = null;    
    private String[] sLssOrderID = null;    
    
	public String[] getsLssID() {
		return sLssID;
	}
	public void setsLssID(String[] sLssID) {
		this.sLssID = sLssID;
	}
	public String[] getsLvtvtID() {
		return sLvtvtID;
	}
	public void setsLvtvtID(String[] sLvtvtID) {
		this.sLvtvtID = sLvtvtID;
	}
	public String[] getsLvtvtVoucherID() {
		return sLvtvtVoucherID;
	}
	public void setsLvtvtVoucherID(String[] sLvtvtVoucherID) {
		this.sLvtvtVoucherID = sLvtvtVoucherID;
	}
	public String[] getsLvtvtResume() {
		return sLvtvtResume;
	}
	public void setsLvtvtResume(String[] sLvtvtResume) {
		this.sLvtvtResume = sLvtvtResume;
	}
	public String[] getsLvtvtSubjectID() {
		return sLvtvtSubjectID;
	}
	public void setsLvtvtSubjectID(String[] sLvtvtSubjectID) {
		this.sLvtvtSubjectID = sLvtvtSubjectID;
	}
	public String[] getsLvtvtSubjectName() {
		return sLvtvtSubjectName;
	}
	public void setsLvtvtSubjectName(String[] sLvtvtSubjectName) {
		this.sLvtvtSubjectName = sLvtvtSubjectName;
	}
	public String[] getsLvtvtDebitMoney() {
		return sLvtvtDebitMoney;
	}
	public void setsLvtvtDebitMoney(String[] sLvtvtDebitMoney) {
		this.sLvtvtDebitMoney = sLvtvtDebitMoney;
	}
	public String[] getsLvtvtLenderMoney() {
		return sLvtvtLenderMoney;
	}
	public void setsLvtvtLenderMoney(String[] sLvtvtLenderMoney) {
		this.sLvtvtLenderMoney = sLvtvtLenderMoney;
	}
	public String[] getsLvtsBalanceDirection() {
		return sLvtsBalanceDirection;
	}
	public void setsLvtsBalanceDirection(String[] sLvtsBalanceDirection) {
		this.sLvtsBalanceDirection = sLvtsBalanceDirection;
	}
	public String[] getsLvtsHBConstant() {
		return sLvtsHBConstant;
	}
	public void setsLvtsHBConstant(String[] sLvtsHBConstant) {
		this.sLvtsHBConstant = sLvtsHBConstant;
	}
	public String[] getsLssOrderID() {
		return sLssOrderID;
	}
	public void setsLssOrderID(String[] sLssOrderID) {
		this.sLssOrderID = sLssOrderID;
	}
	
}
