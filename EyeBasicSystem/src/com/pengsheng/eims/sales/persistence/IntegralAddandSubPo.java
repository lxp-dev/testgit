package com.pengsheng.eims.sales.persistence;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;

public class IntegralAddandSubPo {
	private String smeasuuid;			//主键
	private String smeasmemberid;		//顾客卡号
	private String smeascustomername;	//顾客姓名
	private String smeascustomerphone;	//顾客电话
	private String smeasyintegral;		//顾客原积分
	private String smeascintegral;		//充值积分
	private String smeasxintegral;		//现有积分
	private String smeasdopersonid;		//变动人
	private String smeasdopersonname;	//变动姓名
	private String smeasdodate;			//变动日期
	private String smeasremark;			//备注
	private String smeasissendmessage;	//是否发送短信
	private String smeasaddorsub;		//增减类型
	private String smeassalesbill;		//配镜单号
	private String smeascustomerid;		//顾客ID
	private String smeasfcustomerid;	//顾客主卡
	private String isjifenjiekuan;		//是否是积分结款（用于销售时，如果积分结款，将该条数据的插入数据库时间加几秒，用于区分整单积分数据的插入时间)
	
	//条件补充
	private String smeasdobegindate;	//变动begin
	private String smeasdoenddate;	//变动end
	private List<DepartmentsPo> smecishoplist; // 相同公司的部门

	public List<DepartmentsPo> getSmecishoplist() {
		return smecishoplist;
	}
	public void setSmecishoplist(List<DepartmentsPo> smecishoplist) {
		this.smecishoplist = smecishoplist;
	}
	public String getSmeasfcustomerid() {
		return smeasfcustomerid;
	}
	public void setSmeasfcustomerid(String smeasfcustomerid) {
		this.smeasfcustomerid = smeasfcustomerid;
	}
	public String getSmeascustomerid() {
		return smeascustomerid;
	}
	public void setSmeascustomerid(String smeascustomerid) {
		this.smeascustomerid = smeascustomerid;
	}
	public String getSmeasaddorsub() {
		return smeasaddorsub;
	}
	public void setSmeasaddorsub(String smeasaddorsub) {
		this.smeasaddorsub = smeasaddorsub;
	}
	public String getSmeascustomername() {
		return smeascustomername;
	}
	public void setSmeascustomername(String smeascustomername) {
		this.smeascustomername = smeascustomername;
	}
	public String getSmeascustomerphone() {
		return smeascustomerphone;
	}
	public void setSmeascustomerphone(String smeascustomerphone) {
		this.smeascustomerphone = smeascustomerphone;
	}
	public String getSmeasdopersonname() {
		return smeasdopersonname;
	}
	public void setSmeasdopersonname(String smeasdopersonname) {
		this.smeasdopersonname = smeasdopersonname;
	}
	public String getSmeasdobegindate() {
		return smeasdobegindate;
	}
	public void setSmeasdobegindate(String smeasdobegindate) {
		this.smeasdobegindate = smeasdobegindate;
	}
	public String getSmeasdoenddate() {
		return smeasdoenddate;
	}
	public void setSmeasdoenddate(String smeasdoenddate) {
		this.smeasdoenddate = smeasdoenddate;
	}
	public String getSmeasissendmessage() {
		return smeasissendmessage;
	}
	public void setSmeasissendmessage(String smeasissendmessage) {
		this.smeasissendmessage = smeasissendmessage;
	}
	public String getSmeasuuid() {
		return smeasuuid;
	}
	public void setSmeasuuid(String smeasuuid) {
		this.smeasuuid = smeasuuid;
	}
	public String getSmeasmemberid() {
		return smeasmemberid;
	}
	public void setSmeasmemberid(String smeasmemberid) {
		this.smeasmemberid = smeasmemberid;
	}
	public String getSmeasyintegral() {
		return smeasyintegral;
	}
	public void setSmeasyintegral(String smeasyintegral) {
		this.smeasyintegral = smeasyintegral;
	}
	public String getSmeascintegral() {
		return smeascintegral;
	}
	public void setSmeascintegral(String smeascintegral) {
		this.smeascintegral = smeascintegral;
	}
	public String getSmeasxintegral() {
		return smeasxintegral;
	}
	public void setSmeasxintegral(String smeasxintegral) {
		this.smeasxintegral = smeasxintegral;
	}
	public String getSmeasdopersonid() {
		return smeasdopersonid;
	}
	public void setSmeasdopersonid(String smeasdopersonid) {
		this.smeasdopersonid = smeasdopersonid;
	}
	public String getSmeasdodate() {
		return smeasdodate;
	}
	public void setSmeasdodate(String smeasdodate) {
		this.smeasdodate = smeasdodate;
	}
	public String getSmeasremark() {
		return smeasremark;
	}
	public void setSmeasremark(String smeasremark) {
		this.smeasremark = smeasremark;
	}
	public String getSmeassalesbill() {
		return smeassalesbill;
	}
	public void setSmeassalesbill(String smeassalesbill) {
		this.smeassalesbill = smeassalesbill;
	}
	public String getIsjifenjiekuan() {
		return isjifenjiekuan;
	}
	public void setIsjifenjiekuan(String isjifenjiekuan) {
		this.isjifenjiekuan = isjifenjiekuan;
	}
	
}
