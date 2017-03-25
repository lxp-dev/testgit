package com.pengsheng.eims.storage.persistence;

public class CheckStorageEntryPo {
	private String cshcseid;// 唯一编号

	private String cshcsebillid;// 盘点单号

	private String cshcsebarcode;// 商品条码

	private String cshcsegoodsid;// 商品代码

	private String cshcsegoodsname;// 商品名称

	private String cshcsespec;// 规格

	private String cshcseunitname;// 单位

	private String cshcsebooknumber;// 账存数量

	private String cshcsechecknumber;// 盘点数量

	private String cshcsesurplusnumber;// 盈余数量

	private String cshcseremark;// 备注
	
	private String cshcsecostPrice; //含税单价

	public String getCshcsecostPrice() {
		return cshcsecostPrice;
	}

	public void setCshcsecostPrice(String cshcsecostPrice) {
		this.cshcsecostPrice = cshcsecostPrice;
	}

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

	public String getCshcsebarcode() {
		return cshcsebarcode;
	}

	public void setCshcsebarcode(String cshcsebarcode) {
		this.cshcsebarcode = cshcsebarcode;
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

	public String getCshcsespec() {
		return cshcsespec;
	}

	public void setCshcsespec(String cshcsespec) {
		this.cshcsespec = cshcsespec;
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

	public String getCshcsesurplusnumber() {
		return cshcsesurplusnumber;
	}

	public void setCshcsesurplusnumber(String cshcsesurplusnumber) {
		this.cshcsesurplusnumber = cshcsesurplusnumber;
	}

	public String getCshcseremark() {
		return cshcseremark;
	}

	public void setCshcseremark(String cshcseremark) {
		this.cshcseremark = cshcseremark;
	}

}
