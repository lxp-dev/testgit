package com.pengsheng.eims.storage.persistence;

public class CheckStoragefxEntryPo {
	
	private String cshcseid;// 唯一编号

	private String cshcsebillid;// 盘点单号

	private String cshcsegoodsid;// 商品代码

	private String cshcsegoodsname;// 商品名称

	private String cshcseunitname;// 单位

	private String cshcsebooknumber;// 盘盈数量

	private String cshcsechecknumber;// 盘亏数量
	
	private String cshcsecostPrice; //金额合计	
	
	private String cshcsereason;//原因分析

	private String cshcsesolve;//建议解决方案

	public String getCshcseid() {
		return cshcseid;
	}

	public void setCshcseid(String cshcseid) {
		this.cshcseid = cshcseid;
	}

	public String getCshcsebillid() {
		return cshcsebillid;
	}

	public void setCshcsebillid(String cshcsebillid) {
		this.cshcsebillid = cshcsebillid;
	}

	public String getCshcsegoodsid() {
		return cshcsegoodsid;
	}

	public void setCshcsegoodsid(String cshcsegoodsid) {
		this.cshcsegoodsid = cshcsegoodsid;
	}

	public String getCshcsegoodsname() {
		return cshcsegoodsname;
	}

	public void setCshcsegoodsname(String cshcsegoodsname) {
		this.cshcsegoodsname = cshcsegoodsname;
	}

	public String getCshcseunitname() {
		return cshcseunitname;
	}

	public void setCshcseunitname(String cshcseunitname) {
		this.cshcseunitname = cshcseunitname;
	}

	public String getCshcsebooknumber() {
		return cshcsebooknumber;
	}

	public void setCshcsebooknumber(String cshcsebooknumber) {
		this.cshcsebooknumber = cshcsebooknumber;
	}

	public String getCshcsechecknumber() {
		return cshcsechecknumber;
	}

	public void setCshcsechecknumber(String cshcsechecknumber) {
		this.cshcsechecknumber = cshcsechecknumber;
	}

	public String getCshcsecostPrice() {
		return cshcsecostPrice;
	}

	public void setCshcsecostPrice(String cshcsecostPrice) {
		this.cshcsecostPrice = cshcsecostPrice;
	}

	public String getCshcsereason() {
		return cshcsereason;
	}

	public void setCshcsereason(String cshcsereason) {
		this.cshcsereason = cshcsereason;
	}

	public String getCshcsesolve() {
		return cshcsesolve;
	}

	public void setCshcsesolve(String cshcsesolve) {
		this.cshcsesolve = cshcsesolve;
	}

	
}
