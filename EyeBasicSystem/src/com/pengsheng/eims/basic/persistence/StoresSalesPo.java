package com.pengsheng.eims.basic.persistence;

public class StoresSalesPo {
	private String storesID;//销售门店ID
	private String storesName;//销售门店名称
	private String salesAmount;//销售金额
	private String salesDate;//查询日期
	
	
	public String getStoresID() {
		return storesID;
	}
	public void setStoresID(String storesID) {
		this.storesID = storesID;
	}
	public String getStoresName() {
		return storesName;
	}
	public void setStoresName(String storesName) {
		this.storesName = storesName;
	}
	public String getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(String salesAmount) {
		this.salesAmount = salesAmount;
	}
	public String getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}
	
}
