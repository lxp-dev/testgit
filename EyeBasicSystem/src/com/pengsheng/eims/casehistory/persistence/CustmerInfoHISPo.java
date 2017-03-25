package com.pengsheng.eims.casehistory.persistence;

public class CustmerInfoHISPo {

	private String shccoid;            //主键
	private String shccocustmerid;     //顾客号
	private String shccooptometrytime; //验光时间 数据库取getDate()
	private String shccotodayid;       //当日就诊号
	private String shccoisopt;         //是否验光    0未验光 ； 1已经验光
	private String shccoisrefund;      //是否退款    0未退款 ； 1已经退款
	
	
	public String getShccoisopt() {
		return shccoisopt;
	}
	public void setShccoisopt(String shccoisopt) {
		this.shccoisopt = shccoisopt;
	}
	public String getShccoisrefund() {
		return shccoisrefund;
	}
	public void setShccoisrefund(String shccoisrefund) {
		this.shccoisrefund = shccoisrefund;
	}
	public String getShccoid() {
		return shccoid;
	}
	public void setShccoid(String shccoid) {
		this.shccoid = shccoid;
	}
	public String getShccocustmerid() {
		return shccocustmerid;
	}
	public void setShccocustmerid(String shccocustmerid) {
		this.shccocustmerid = shccocustmerid;
	}
	public String getShccooptometrytime() {
		return shccooptometrytime;
	}
	public void setShccooptometrytime(String shccooptometrytime) {
		this.shccooptometrytime = shccooptometrytime;
	}
	public String getShccotodayid() {
		return shccotodayid;
	}
	public void setShccotodayid(String shccotodayid) {
		this.shccotodayid = shccotodayid;
	}
	
	
	
	
}
