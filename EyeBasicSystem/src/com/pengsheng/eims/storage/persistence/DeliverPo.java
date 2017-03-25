package com.pengsheng.eims.storage.persistence;
/**
 * 委外送货主表PO
 */
public class DeliverPo {
	
	private String cstddeliverbillid;//送货单号
	
	private String cstddeliverdate;//送货单日期
	
	private String cstdstarttime;//送货单开始日期
	
	private String cstdendtime;//送货单结束日期

	private String cstddeliverdept;//送货单位
	
	private String cstdcreateperson;//制单人
	
	private String cstdcreatepersonname;//制单人姓名	
	
	private String cstdauditperson;//审核人
	
	private String cstdauditpersonname;//审核人姓名
	
	private String cstdauditdate;//审核日期
	
	private String cstdauditstate;//审核状态
	
	private String cstdremark;//备注
	
	
	public String getCstdstarttime() {
		return cstdstarttime;
	}

	public void setCstdstarttime(String cstdstarttime) {
		this.cstdstarttime = cstdstarttime;
	}

	public String getCstdendtime() {
		return cstdendtime;
	}

	public void setCstdendtime(String cstdendtime) {
		this.cstdendtime = cstdendtime;
	}
	
	public String getCstddeliverbillid() {
		return cstddeliverbillid;
	}

	public void setCstddeliverbillid(String cstddeliverbillid) {
		this.cstddeliverbillid = cstddeliverbillid;
	}

	public String getCstddeliverdate() {
		return cstddeliverdate;
	}

	public void setCstddeliverdate(String cstddeliverdate) {
		this.cstddeliverdate = cstddeliverdate;
	}



	public String getCstddeliverdept() {
		return cstddeliverdept;
	}

	public void setCstddeliverdept(String cstddeliverdept) {
		this.cstddeliverdept = cstddeliverdept;
	}

	public String getCstdcreateperson() {
		return cstdcreateperson;
	}

	public void setCstdcreateperson(String cstdcreateperson) {
		this.cstdcreateperson = cstdcreateperson;
	}

	public String getCstdauditperson() {
		return cstdauditperson;
	}

	public void setCstdauditperson(String cstdauditperson) {
		this.cstdauditperson = cstdauditperson;
	}

	public String getCstdauditdate() {
		return cstdauditdate;
	}

	public void setCstdauditdate(String cstdauditdate) {
		this.cstdauditdate = cstdauditdate;
	}

	public String getCstdauditstate() {
		return cstdauditstate;
	}

	public void setCstdauditstate(String cstdauditstate) {
		this.cstdauditstate = cstdauditstate;
	}

	public String getCstdremark() {
		return cstdremark;
	}

	public void setCstdremark(String cstdremark) {
		this.cstdremark = cstdremark;
	}

	public String getCstdcreatepersonname() {
		return cstdcreatepersonname;
	}

	public void setCstdcreatepersonname(String cstdcreatepersonname) {
		this.cstdcreatepersonname = cstdcreatepersonname;
	}

	public String getCstdauditpersonname() {
		return cstdauditpersonname;
	}

	public void setCstdauditpersonname(String cstdauditpersonname) {
		this.cstdauditpersonname = cstdauditpersonname;
	}

}
