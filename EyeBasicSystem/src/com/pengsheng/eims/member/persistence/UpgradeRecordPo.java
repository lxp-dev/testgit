package com.pengsheng.eims.member.persistence;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;

public class UpgradeRecordPo {
    
	private String smecuid;
	private String smecucustomerid;
	private String smecumemberid;
	private String smecucustomername;
	private String smecuupgradedate;
	private String smecucurrentcardid;
	private String smecucurrentcardname;
	private String smecucurrentintegral;
	private String smeculastcardid;
	private String smeculastcardname;
	private String smecuintegralchange;
	private String smeculastintegral;
	private String smecushopcode;
	private String smecushopcodename;
	private String smecupersonid;
	private String smecuflag;
	private String smecupersonname;
	private String smecubgnupgradedate;
	private String smecuendupgradedate;
	private List<DepartmentsPo> smecishoplist; // 相同公司的部门
	
	public List<DepartmentsPo> getSmecishoplist() {
		return smecishoplist;
	}
	public void setSmecishoplist(List<DepartmentsPo> smecishoplist) {
		this.smecishoplist = smecishoplist;
	}
	public String getSmecumemberid() {
		return smecumemberid;
	}
	public void setSmecumemberid(String smecumemberid) {
		this.smecumemberid = smecumemberid;
	}
	public String getSmecuid() {
		return smecuid;
	}
	public void setSmecuid(String smecuid) {
		this.smecuid = smecuid;
	}
	public String getSmecucustomerid() {
		return smecucustomerid;
	}
	public void setSmecucustomerid(String smecucustomerid) {
		this.smecucustomerid = smecucustomerid;
	}
	public String getSmecucustomername() {
		return smecucustomername;
	}
	public void setSmecucustomername(String smecucustomername) {
		this.smecucustomername = smecucustomername;
	}
	public String getSmecuupgradedate() {
		return smecuupgradedate;
	}
	public void setSmecuupgradedate(String smecuupgradedate) {
		this.smecuupgradedate = smecuupgradedate;
	}
	public String getSmecucurrentcardid() {
		return smecucurrentcardid;
	}
	public void setSmecucurrentcardid(String smecucurrentcardid) {
		this.smecucurrentcardid = smecucurrentcardid;
	}
	public String getSmecucurrentcardname() {
		return smecucurrentcardname;
	}
	public void setSmecucurrentcardname(String smecucurrentcardname) {
		this.smecucurrentcardname = smecucurrentcardname;
	}
	public String getSmecucurrentintegral() {
		return smecucurrentintegral;
	}
	public void setSmecucurrentintegral(String smecucurrentintegral) {
		this.smecucurrentintegral = smecucurrentintegral;
	}
	public String getSmeculastcardid() {
		return smeculastcardid;
	}
	public void setSmeculastcardid(String smeculastcardid) {
		this.smeculastcardid = smeculastcardid;
	}
	public String getSmeculastcardname() {
		return smeculastcardname;
	}
	public void setSmeculastcardname(String smeculastcardname) {
		this.smeculastcardname = smeculastcardname;
	}
	public String getSmecuintegralchange() {
		return smecuintegralchange;
	}
	public void setSmecuintegralchange(String smecuintegralchange) {
		this.smecuintegralchange = smecuintegralchange;
	}
	public String getSmeculastintegral() {
		return smeculastintegral;
	}
	public void setSmeculastintegral(String smeculastintegral) {
		this.smeculastintegral = smeculastintegral;
	}
	public String getSmecushopcode() {
		return smecushopcode;
	}
	public void setSmecushopcode(String smecushopcode) {
		this.smecushopcode = smecushopcode;
	}
	public String getSmecushopcodename() {
		return smecushopcodename;
	}
	public void setSmecushopcodename(String smecushopcodename) {
		this.smecushopcodename = smecushopcodename;
	}
	public String getSmecupersonid() {
		return smecupersonid;
	}
	public void setSmecupersonid(String smecupersonid) {
		this.smecupersonid = smecupersonid;
	}
	public String getSmecuflag() {
		return smecuflag;
	}
	public void setSmecuflag(String smecuflag) {
		this.smecuflag = smecuflag;
	}
	public String getSmecupersonname() {
		return smecupersonname;
	}
	public void setSmecupersonname(String smecupersonname) {
		this.smecupersonname = smecupersonname;
	}
	public String getSmecubgnupgradedate() {
		return smecubgnupgradedate;
	}
	public void setSmecubgnupgradedate(String smecubgnupgradedate) {
		this.smecubgnupgradedate = smecubgnupgradedate;
	}
	public String getSmecuendupgradedate() {
		return smecuendupgradedate;
	}
	public void setSmecuendupgradedate(String smecuendupgradedate) {
		this.smecuendupgradedate = smecuendupgradedate;
	}
	
	
}
