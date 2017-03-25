package com.pengsheng.eims.sales.persistence;

public class InTransitPo {
	private String sseitid;// 主键
	private String sseitsalesid;// 销售编号
	private String sseitstate;// 在途状态
	private String sseitintransitname;// 在途名称
	private String sseitdate;// 在途时间
	private String sseitcreateperson;// 操作人
	private String sseitdepartment;// 部门
	private String sseitstateflag;// 状态标志(0:未执行 1：已执行 2：当前执行)(新加)
	private String sseitysalesid;//原配镜单号
	private String orderssalesid;//委外订单号
	private String sseitflag; //停用启用
	private String sseitisflag; //是否可以停用启用
	private String sseitcreatepersonname;
	private String sseitidordetype;   // 销售类型
	
	public String getSseitidordetype() {
		return sseitidordetype;
	}

	public void setSseitidordetype(String sseitidordetype) {
		this.sseitidordetype = sseitidordetype;
	}

	private String cstcporesalesremark;
	
	public String getCstcporesalesremark() {
		return cstcporesalesremark;
	}

	public void setCstcporesalesremark(String cstcporesalesremark) {
		this.cstcporesalesremark = cstcporesalesremark;
	}

	public String getSseitcreatepersonname() {
		return sseitcreatepersonname;
	}

	public void setSseitcreatepersonname(String sseitcreatepersonname) {
		this.sseitcreatepersonname = sseitcreatepersonname;
	}

	public String getSseitisflag() {
		return sseitisflag;
	}

	public void setSseitisflag(String sseitisflag) {
		this.sseitisflag = sseitisflag;
	}

	public String getOrderssalesid() {
		return orderssalesid;
	}

	public void setOrderssalesid(String orderssalesid) {
		this.orderssalesid = orderssalesid;
	}

	public String getSseitysalesid() {
		return sseitysalesid;
	}

	public void setSseitysalesid(String sseitysalesid) {
		this.sseitysalesid = sseitysalesid;
	}

	public String getSseitid() {
		return sseitid;
	}

	public void setSseitid(String sseitid) {
		this.sseitid = sseitid;
	}

	public String getSseitsalesid() {
		return sseitsalesid;
	}

	public void setSseitsalesid(String sseitsalesid) {
		this.sseitsalesid = sseitsalesid;
	}

	public String getSseitstate() {
		return sseitstate;
	}

	public void setSseitstate(String sseitstate) {
		this.sseitstate = sseitstate;
	}

	public String getSseitintransitname() {
		return sseitintransitname;
	}

	public void setSseitintransitname(String sseitintransitname) {
		this.sseitintransitname = sseitintransitname;
	}

	public String getSseitdate() {
		return sseitdate;
	}

	public void setSseitdate(String sseitdate) {
		this.sseitdate = sseitdate;
	}

	public String getSseitcreateperson() {
		return sseitcreateperson;
	}

	public void setSseitcreateperson(String sseitcreateperson) {
		this.sseitcreateperson = sseitcreateperson;
	}

	public String getSseitdepartment() {
		return sseitdepartment;
	}

	public void setSseitdepartment(String sseitdepartment) {
		this.sseitdepartment = sseitdepartment;
	}

	public String getSseitstateflag() {
		return sseitstateflag;
	}

	public void setSseitstateflag(String sseitstateflag) {
		this.sseitstateflag = sseitstateflag;
	}

	public String getSseitflag() {
		return sseitflag;
	}

	public void setSseitflag(String sseitflag) {
		this.sseitflag = sseitflag;
	}

}
