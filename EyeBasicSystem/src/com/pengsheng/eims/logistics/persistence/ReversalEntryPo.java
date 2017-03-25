package com.pengsheng.eims.logistics.persistence;

public class ReversalEntryPo {

	private String liereid;// ID
	private String liereinvoiceid;// 发票号
	private String lierebillid;// 单据号码
	private String lieregoodsid;// 商品代码
	private String lieregoodsname;// 商品名称
	private String lierespec;// 规格
	private String lieregoodsquantity;// 数量
	private String lierecheckgoodsquantity;// 核销数量
	private String lierenottaxrate;// 单位成本
	private String lierenottaxrateamount;// 成本合计
	private String lierecostprice;// 含税单价
	private String lieretaxamount;// 税额合计
	private String lierecostpriceamount;// 价税合计
	private String liereisvoucher;// 凭证标识
	private String lierevoucherdate;// 凭证日期
	
	public String getLiereid() {
		return liereid;
	}
	public void setLiereid(String liereid) {
		this.liereid = liereid;
	}
	public String getLiereinvoiceid() {
		return liereinvoiceid;
	}
	public void setLiereinvoiceid(String liereinvoiceid) {
		this.liereinvoiceid = liereinvoiceid;
	}
	public String getLierebillid() {
		return lierebillid;
	}
	public void setLierebillid(String lierebillid) {
		this.lierebillid = lierebillid;
	}
	public String getLieregoodsid() {
		return lieregoodsid;
	}
	public void setLieregoodsid(String lieregoodsid) {
		this.lieregoodsid = lieregoodsid;
	}
	public String getLieregoodsname() {
		return lieregoodsname;
	}
	public void setLieregoodsname(String lieregoodsname) {
		this.lieregoodsname = lieregoodsname;
	}
	public String getLierespec() {
		return lierespec;
	}
	public void setLierespec(String lierespec) {
		this.lierespec = lierespec;
	}
	public String getLieregoodsquantity() {
		return lieregoodsquantity;
	}
	public void setLieregoodsquantity(String lieregoodsquantity) {
		this.lieregoodsquantity = lieregoodsquantity;
	}
	public String getLierecheckgoodsquantity() {
		return lierecheckgoodsquantity;
	}
	public void setLierecheckgoodsquantity(String lierecheckgoodsquantity) {
		this.lierecheckgoodsquantity = lierecheckgoodsquantity;
	}
	public String getLierenottaxrate() {
		return lierenottaxrate;
	}
	public void setLierenottaxrate(String lierenottaxrate) {
		this.lierenottaxrate = lierenottaxrate;
	}
	public String getLierenottaxrateamount() {
		return lierenottaxrateamount;
	}
	public void setLierenottaxrateamount(String lierenottaxrateamount) {
		this.lierenottaxrateamount = lierenottaxrateamount;
	}
	public String getLierecostprice() {
		return lierecostprice;
	}
	public void setLierecostprice(String lierecostprice) {
		this.lierecostprice = lierecostprice;
	}
	public String getLieretaxamount() {
		return lieretaxamount;
	}
	public void setLieretaxamount(String lieretaxamount) {
		this.lieretaxamount = lieretaxamount;
	}
	public String getLierecostpriceamount() {
		return lierecostpriceamount;
	}
	public void setLierecostpriceamount(String lierecostpriceamount) {
		this.lierecostpriceamount = lierecostpriceamount;
	}
	public String getLiereisvoucher() {
		return liereisvoucher;
	}
	public void setLiereisvoucher(String liereisvoucher) {
		this.liereisvoucher = liereisvoucher;
	}
	public String getLierevoucherdate() {
		return lierevoucherdate;
	}
	public void setLierevoucherdate(String lierevoucherdate) {
		this.lierevoucherdate = lierevoucherdate;
	}

}
