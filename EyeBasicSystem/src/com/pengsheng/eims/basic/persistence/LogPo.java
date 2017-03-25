package com.pengsheng.eims.basic.persistence;

public class LogPo {
	private String logid; //主键
	private String logdate ;//日志生成日期
	private String logname;//操作人ID
	private String logusername ;//操作人姓名
	private String logip ;//本机IP
	private String logopid ;//操作ID
	private String logopidname ;//操作ID中文说明
	private String logcontent ;//日志记录单号
	private String logresult ;//模块ID
	private String logresultname ;//模块
	private String logBillList ;//备用
	
	//查询条件
	private String logbegindate;//开始时间
	private String logenddate;//结束时间
	
	public String getLogbegindate() {
		return logbegindate;
	}
	public void setLogbegindate(String logbegindate) {
		this.logbegindate = logbegindate;
	}
	public String getLogenddate() {
		return logenddate;
	}
	public void setLogenddate(String logenddate) {
		this.logenddate = logenddate;
	}
	
	public String getLogid() {
		return logid;
	}
	public void setLogid(String logid) {
		this.logid = logid;
	}
	public String getLogdate() {
		return logdate;
	}
	public void setLogdate(String logdate) {
		this.logdate = logdate;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getLogusername() {
		return logusername;
	}
	public void setLogusername(String logusername) {
		this.logusername = logusername;
	}
	public String getLogip() {
		return logip;
	}
	public void setLogip(String logip) {
		this.logip = logip;
	}
	public String getLogopid() {
		return logopid;
	}
	public void setLogopid(String logopid) {
		this.logopid = logopid;
	}
	public String getLogopidname() {
		return logopidname;
	}
	public void setLogopidname(String logopidname) {
		this.logopidname = logopidname;
	}
	public String getLogcontent() {
		return logcontent;
	}
	public void setLogcontent(String logcontent) {
		this.logcontent = logcontent;
	}
	public String getLogresult() {
		return logresult;
	}
	public void setLogresult(String logresult) {
		this.logresult = logresult;
	}
	public String getLogresultname() {
		return logresultname;
	}
	public void setLogresultname(String logresultname) {
		this.logresultname = logresultname;
	}
	public String getLogBillList() {
		return logBillList;
	}
	public void setLogBillList(String logBillList) {
		this.logBillList = logBillList;
	}
	
}
