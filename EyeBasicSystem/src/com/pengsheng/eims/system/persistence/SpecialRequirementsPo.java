package com.pengsheng.eims.system.persistence;

/*
 * 特殊加工要求Po
 */
public class SpecialRequirementsPo {

	//特殊加工要求编号
	private String fsrid;
	//特殊加工要求名称
	private String fsrname;
	//特殊加工要求标识 0:停用 1:使用
//	private String fsrflag;
	private String[] chk;//获取数组ID
//	private String fsrflag;
	
	public String[] getChk() {
		return chk;
	}
	public void setChk(String[] chk) {
		this.chk = chk;
	}
	public String getFsrid() {
		return fsrid;
	}
	public void setFsrid(String fsrid) {
		this.fsrid = fsrid;
	}
	public String getFsrname() {
		return fsrname;
	}
	public void setFsrname(String fsrname) {
		this.fsrname = fsrname;
	}
//	public String getFsrflag() {
//		return fsrflag;
//	}
//	public void setFsrflag(String fsrflag) {
//		this.fsrflag = fsrflag;
//	}
	
}
