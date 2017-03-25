package com.pengsheng.eims.sales.persistence;

public class SalesPostBasicPo {
	 private String  ssespbid                ;   //主键
	 private String  ssespbsalesid           ;   //原销售单号
     private String  ssespbnewsalesid        ;   //新销售单号
     private String  ssespbcreater           ;   //操作人
	 private String  ssespbdatetime          ;   //操作时间          
	public String getSsespbid() {
		return ssespbid;
	}
	public void setSsespbid(String ssespbid) {
		this.ssespbid = ssespbid;
	}
	public String getSsespbsalesid() {
		return ssespbsalesid;
	}
	public void setSsespbsalesid(String ssespbsalesid) {
		this.ssespbsalesid = ssespbsalesid;
	}
	public String getSsespbnewsalesid() {
		return ssespbnewsalesid;
	}
	public void setSsespbnewsalesid(String ssespbnewsalesid) {
		this.ssespbnewsalesid = ssespbnewsalesid;
	}
	public String getSsespbcreater() {
		return ssespbcreater;
	}
	public void setSsespbcreater(String ssespbcreater) {
		this.ssespbcreater = ssespbcreater;
	}
	public String getSsespbdatetime() {
		return ssespbdatetime;
	}
	public void setSsespbdatetime(String ssespbdatetime) {
		this.ssespbdatetime = ssespbdatetime;
	}
	 
		
}
