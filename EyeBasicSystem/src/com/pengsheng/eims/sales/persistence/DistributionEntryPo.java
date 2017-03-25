package com.pengsheng.eims.sales.persistence;

public class DistributionEntryPo {
	private String sdndeid;//UUID
	private String sdndedistributionid;
	private String sdndesalesid;//销售单号
	private String sdndeorderstype;//订单类型:1-镜架成品片  2-镜架订做片  3-隐形成品片  4-隐形订做片  5-辅料
	private String sdndeshopcode;
	private String sdndetakeDate;
	private String sdndemembername;
	private String sdndepersonname;			//配送人员姓名
	private String sdndeallauditname;		//调拨单审核人
	private String sdndeoutdepartmentname;	//调拨发出部门名称
	private String sdndeindepartmentname;	//调拨接收部门名称
	private String sdndeallauditdate;		//调拨单审核日期
	
	public String getSdndepersonname() {
		return sdndepersonname;
	}
	public void setSdndepersonname(String sdndepersonname) {
		this.sdndepersonname = sdndepersonname;
	}
	public String getSdndeallauditname() {
		return sdndeallauditname;
	}
	public void setSdndeallauditname(String sdndeallauditname) {
		this.sdndeallauditname = sdndeallauditname;
	}
	public String getSdndeoutdepartmentname() {
		return sdndeoutdepartmentname;
	}
	public void setSdndeoutdepartmentname(String sdndeoutdepartmentname) {
		this.sdndeoutdepartmentname = sdndeoutdepartmentname;
	}
	public String getSdndeindepartmentname() {
		return sdndeindepartmentname;
	}
	public void setSdndeindepartmentname(String sdndeindepartmentname) {
		this.sdndeindepartmentname = sdndeindepartmentname;
	}
	public String getSdndeallauditdate() {
		return sdndeallauditdate;
	}
	public void setSdndeallauditdate(String sdndeallauditdate) {
		this.sdndeallauditdate = sdndeallauditdate;
	}
	public String getSdndeshopcode() {
		return sdndeshopcode;
	}
	public void setSdndeshopcode(String sdndeshopcode) {
		this.sdndeshopcode = sdndeshopcode;
	}
	public String getSdndetakeDate() {
		return sdndetakeDate;
	}
	public void setSdndetakeDate(String sdndetakeDate) {
		this.sdndetakeDate = sdndetakeDate;
	}
	public String getSdndemembername() {
		return sdndemembername;
	}
	public void setSdndemembername(String sdndemembername) {
		this.sdndemembername = sdndemembername;
	}
	public String getSdndeid() {
		return sdndeid;
	}
	public void setSdndeid(String sdndeid) {
		this.sdndeid = sdndeid;
	}
	public String getSdndedistributionid() {
		return sdndedistributionid;
	}
	public void setSdndedistributionid(String sdndedistributionid) {
		this.sdndedistributionid = sdndedistributionid;
	}
	public String getSdndesalesid() {
		return sdndesalesid;
	}
	public void setSdndesalesid(String sdndesalesid) {
		this.sdndesalesid = sdndesalesid;
	}
	public String getSdndeorderstype() {
		return sdndeorderstype;
	}
	public void setSdndeorderstype(String sdndeorderstype) {
		this.sdndeorderstype = sdndeorderstype;
	}
	
}
