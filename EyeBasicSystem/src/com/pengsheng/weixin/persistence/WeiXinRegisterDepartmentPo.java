package com.pengsheng.weixin.persistence;

/**
 * 微信用户注册部门
 */
public class WeiXinRegisterDepartmentPo {

	private String wrdid;				//ID
	private String wrdaccount ;         // 微信账号原始ID
	private String wrddepartmentid;     // 部门ID
	private String wrddepartmentname;   // 部门名称
	private String wrdcompanyname;   	// 该微信号对应联系我们中的公司名称
	private String wrdcompanyxy;   		// 该微信号对应联系我们中的公司坐标
	private String wrdappid;			// 该微信号对应APPID
	private String wrdappsecret;		// 该微信号对应APPSECRET
	
	public String getWrdaccount() {
		return wrdaccount;
	}
	public void setWrdaccount(String wrdaccount) {
		this.wrdaccount = wrdaccount;
	}
	public String getWrddepartmentid() {
		return wrddepartmentid;
	}
	public void setWrddepartmentid(String wrddepartmentid) {
		this.wrddepartmentid = wrddepartmentid;
	}
	public String getWrddepartmentname() {
		return wrddepartmentname;
	}
	public void setWrddepartmentname(String wrddepartmentname) {
		this.wrddepartmentname = wrddepartmentname;
	}
	public String getWrdid() {
		return wrdid;
	}
	public void setWrdid(String wrdid) {
		this.wrdid = wrdid;
	}
	public String getWrdcompanyname() {
		return wrdcompanyname;
	}
	public void setWrdcompanyname(String wrdcompanyname) {
		this.wrdcompanyname = wrdcompanyname;
	}
	public String getWrdcompanyxy() {
		return wrdcompanyxy;
	}
	public void setWrdcompanyxy(String wrdcompanyxy) {
		this.wrdcompanyxy = wrdcompanyxy;
	}
	public String getWrdappid() {
		return wrdappid;
	}
	public void setWrdappid(String wrdappid) {
		this.wrdappid = wrdappid;
	}
	public String getWrdappsecret() {
		return wrdappsecret;
	}
	public void setWrdappsecret(String wrdappsecret) {
		this.wrdappsecret = wrdappsecret;
	}
}
