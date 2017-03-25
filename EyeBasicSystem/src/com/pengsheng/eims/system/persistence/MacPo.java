package com.pengsheng.eims.system.persistence;

/*
 * Mac地址Po
 */
public class MacPo {
	private String sysmacid;					//UUID
	private String sysmacdepartmentid;			//所属部门ID
	private String sysmacdepartmentname;		//所属部门名称
	private String sysmacname;					//机器名称
	private String sysmackey;					//机器MAC
	private String sysmacisable;				//是否允许登录
	private String sysmaccurrentloginpersonid;	//当前登录人ID
	private String sysmaccurrentloginpersonname;//当前登录人姓名
	private String sysmaccompanyid;			//所属公司ID
	
	public String getSysmaccompanyid() {
		return sysmaccompanyid;
	}
	public void setSysmaccompanyid(String sysmaccompanyid) {
		this.sysmaccompanyid = sysmaccompanyid;
	}
	public String getSysmacdepartmentname() {
		return sysmacdepartmentname;
	}
	public void setSysmacdepartmentname(String sysmacdepartmentname) {
		this.sysmacdepartmentname = sysmacdepartmentname;
	}
	public String getSysmaccurrentloginpersonname() {
		return sysmaccurrentloginpersonname;
	}
	public void setSysmaccurrentloginpersonname(String sysmaccurrentloginpersonname) {
		this.sysmaccurrentloginpersonname = sysmaccurrentloginpersonname;
	}
	public String getSysmacid() {
		return sysmacid;
	}
	public void setSysmacid(String sysmacid) {
		this.sysmacid = sysmacid;
	}
	public String getSysmacdepartmentid() {
		return sysmacdepartmentid;
	}
	public void setSysmacdepartmentid(String sysmacdepartmentid) {
		this.sysmacdepartmentid = sysmacdepartmentid;
	}
	public String getSysmacname() {
		return sysmacname;
	}
	public void setSysmacname(String sysmacname) {
		this.sysmacname = sysmacname;
	}
	public String getSysmackey() {
		return sysmackey;
	}
	public void setSysmackey(String sysmackey) {
		this.sysmackey = sysmackey;
	}
	public String getSysmacisable() {
		return sysmacisable;
	}
	public void setSysmacisable(String sysmacisable) {
		this.sysmacisable = sysmacisable;
	}
	public String getSysmaccurrentloginpersonid() {
		return sysmaccurrentloginpersonid;
	}
	public void setSysmaccurrentloginpersonid(String sysmaccurrentloginpersonid) {
		this.sysmaccurrentloginpersonid = sysmaccurrentloginpersonid;
	}
}
