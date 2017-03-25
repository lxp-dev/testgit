package com.pengsheng.eims.personnel.persistence;

public class AttendanceManagePo {
	private String mamuuid; // 主键
	private String mampersonid; // 和员工表外键
	private String mampersonname; // 姓名
	private String mamdepartmentid; // 部门id
	private String mamdepartmentname; // 部门名称

	private String mamchidao; // 迟到
	private String mamzaotui; // 早退
	private String mambingjia; // 病假
	private String mamshijia; // 事假
	private String mamhunjia; // 婚假
	private String mamsangjia; // 丧假
	private String mamchanjia; // 产假
	private String mamtanqinjia; // 探亲假
	private String mamgongjia; // 公假

	private String mamchuchai; // 出差
	private String mamwaichuxuexi; // 外出学习

	private String mamremark; // 备注
	private String mamcreatepersonid; // 录入人id
	private String mamcreatedate; // 录入人时间

	private String mamyear; // 考勤年份
	private String mammonth; // 考勤月份

	public String getMamuuid() {
		return mamuuid;
	}

	public void setMamuuid(String mamuuid) {
		this.mamuuid = mamuuid;
	}

	public String getMampersonid() {
		return mampersonid;
	}

	public void setMampersonid(String mampersonid) {
		this.mampersonid = mampersonid;
	}

	public String getMampersonname() {
		return mampersonname;
	}

	public void setMampersonname(String mampersonname) {
		this.mampersonname = mampersonname;
	}

	public String getMamchidao() {
		return mamchidao;
	}

	public void setMamchidao(String mamchidao) {
		this.mamchidao = mamchidao;
	}

	public String getMamzaotui() {
		return mamzaotui;
	}

	public void setMamzaotui(String mamzaotui) {
		this.mamzaotui = mamzaotui;
	}

	public String getMambingjia() {
		return mambingjia;
	}

	public void setMambingjia(String mambingjia) {
		this.mambingjia = mambingjia;
	}

	public String getMamshijia() {
		return mamshijia;
	}

	public void setMamshijia(String mamshijia) {
		this.mamshijia = mamshijia;
	}

	public String getMamhunjia() {
		return mamhunjia;
	}

	public void setMamhunjia(String mamhunjia) {
		this.mamhunjia = mamhunjia;
	}

	public String getMamsangjia() {
		return mamsangjia;
	}

	public void setMamsangjia(String mamsangjia) {
		this.mamsangjia = mamsangjia;
	}

	public String getMamchanjia() {
		return mamchanjia;
	}

	public void setMamchanjia(String mamchanjia) {
		this.mamchanjia = mamchanjia;
	}

	public String getMamtanqinjia() {
		return mamtanqinjia;
	}

	public void setMamtanqinjia(String mamtanqinjia) {
		this.mamtanqinjia = mamtanqinjia;
	}

	public String getMamgongjia() {
		return mamgongjia;
	}

	public void setMamgongjia(String mamgongjia) {
		this.mamgongjia = mamgongjia;
	}

	public String getMamchuchai() {
		return mamchuchai;
	}

	public void setMamchuchai(String mamchuchai) {
		this.mamchuchai = mamchuchai;
	}

	public String getMamwaichuxuexi() {
		return mamwaichuxuexi;
	}

	public void setMamwaichuxuexi(String mamwaichuxuexi) {
		this.mamwaichuxuexi = mamwaichuxuexi;
	}

	public String getMamremark() {
		return mamremark;
	}

	public void setMamremark(String mamremark) {
		this.mamremark = mamremark;
	}

	public String getMamcreatepersonid() {
		return mamcreatepersonid;
	}

	public void setMamcreatepersonid(String mamcreatepersonid) {
		this.mamcreatepersonid = mamcreatepersonid;
	}

	public String getMamcreatedate() {
		return mamcreatedate;
	}

	public void setMamcreatedate(String mamcreatedate) {
		this.mamcreatedate = mamcreatedate;
	}

	public String getMamyear() {
		return mamyear;
	}

	public void setMamyear(String mamyear) {
		this.mamyear = mamyear;
	}

	public String getMammonth() {
		return mammonth;
	}

	public void setMammonth(String mammonth) {
		this.mammonth = mammonth;
	}
	public String getMamdepartmentid() {
		return mamdepartmentid;
	}

	public void setMamdepartmentid(String mamdepartmentid) {
		this.mamdepartmentid = mamdepartmentid;
	}

	public String getMamdepartmentname() {
		return mamdepartmentname;
	}

	public void setMamdepartmentname(String mamdepartmentname) {
		this.mamdepartmentname = mamdepartmentname;
	}
}
