package com.pengsheng.eims.system.persistence;

import com.pengsheng.eims.util.tools.Utility;

public class PersonDiscountPo {
	
	private String fpdpersonid;
	
	private String fpdpersonname;

	private String fpddepid;
	
	private String fpddepname;
	
	private String fpdroleid;
	
	private String fpdrolename;
	
	private String fpddiscount;
	
	private String fpdspecialdiscountnumber;
	
	private String fpdcompanyid;
	
	public String getFpdcompanyid() {
		return fpdcompanyid;
	}

	public void setFpdcompanyid(String fpdcompanyid) {
		this.fpdcompanyid = fpdcompanyid;
	}

	public String getFpdspecialdiscountnumber() {
		return fpdspecialdiscountnumber;
	}

	public void setFpdspecialdiscountnumber(String fpdspecialdiscountnumber) {
		this.fpdspecialdiscountnumber = fpdspecialdiscountnumber;
	}

	public String getFpdspecialdiscount() {
		return fpdspecialdiscount;
	}

	public void setFpdspecialdiscount(String fpdspecialdiscount) {
		this.fpdspecialdiscount = fpdspecialdiscount;
	}

	private String fpdspecialdiscount;

	public String getFpdpersonid() {
		return fpdpersonid;
	}

	public void setFpdpersonid(String fpdpersonid) {
		this.fpdpersonid = fpdpersonid;
	}

	public String getFpddiscount() {
		return fpddiscount;
	}

	public void setFpddiscount(String fpddiscount) {
		this.fpddiscount = fpddiscount;
	}

	public String getFpdpersonname() {
		return fpdpersonname;
	}

	public void setFpdpersonname(String fpdpersonname) {
		this.fpdpersonname = fpdpersonname;
	}

	public String getFpddepname() {
		return fpddepname;
	}

	public void setFpddepname(String fpddepname) {
		this.fpddepname = fpddepname;
	}

	public String getFpdrolename() {
		return fpdrolename;
	}

	public void setFpdrolename(String fpdrolename) {
		this.fpdrolename = fpdrolename;
	}

	public String getFpddepid() {
		return fpddepid;
	}

	public void setFpddepid(String fpddepid) {
		this.fpddepid = fpddepid;
	}

	public String getFpdroleid() {
		return fpdroleid;
	}

	public void setFpdroleid(String fpdroleid) {
		this.fpdroleid = fpdroleid;
	}

}
