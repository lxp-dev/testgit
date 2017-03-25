package com.pengsheng.weixin.persistence;

public class WeiXinDoctorAppraisalPo {
	
	private String wdaid;				//ID
	private String wdainspectionid;		//检查结论ID
	private String wdacustomerid;		//顾客号
	private String wdacustomername;		//顾客名称
	private String wdadoctorid;			//验光师工号
	private String wdamanyidu;			//满意度
	private String wdacontent;			//评价内容
	private String wdacreatetime;		//评价时间
	
	public String getWdaid() {
		return wdaid;
	}
	public void setWdaid(String wdaid) {
		this.wdaid = wdaid;
	}
	public String getWdainspectionid() {
		return wdainspectionid;
	}
	public void setWdainspectionid(String wdainspectionid) {
		this.wdainspectionid = wdainspectionid;
	}
	public String getWdacustomerid() {
		return wdacustomerid;
	}
	public void setWdacustomerid(String wdacustomerid) {
		this.wdacustomerid = wdacustomerid;
	}
	public String getWdadoctorid() {
		return wdadoctorid;
	}
	public void setWdadoctorid(String wdadoctorid) {
		this.wdadoctorid = wdadoctorid;
	}
	public String getWdamanyidu() {
		return wdamanyidu;
	}
	public void setWdamanyidu(String wdamanyidu) {
		this.wdamanyidu = wdamanyidu;
	}
	public String getWdacontent() {
		return wdacontent;
	}
	public void setWdacontent(String wdacontent) {
		this.wdacontent = wdacontent;
	}
	public String getWdacreatetime() {
		return wdacreatetime;
	}
	public void setWdacreatetime(String wdacreatetime) {
		this.wdacreatetime = wdacreatetime;
	}
	public String getWdacustomername() {
		return wdacustomername;
	}
	public void setWdacustomername(String wdacustomername) {
		this.wdacustomername = wdacustomername;
	}
}