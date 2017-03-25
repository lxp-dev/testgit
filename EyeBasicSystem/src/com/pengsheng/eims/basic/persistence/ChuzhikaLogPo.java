package com.pengsheng.eims.basic.persistence;

public class ChuzhikaLogPo {
	/**
	 * 储值卡LogPo
	 */
	
	private String smeasuuid;			//uuid
	private String smeascustomerid;		//顾客编号
	private String smeasmemberid;		//顾客卡号
	private String smeasmembername;		//顾客姓名
	private String smeaschuzhikaid;		//储值卡ID
	private String smeaschuzhikacardid;	//储值卡卡号
	
	private String smeasshifu;			//对于充值和建卡时，记录实付金额
	private String smeaszengsong;		//对于充值和建卡时，记录赠送金额
	
	private String smeasyintegral;		//更新前金额
	private String smeascintegral;		//更新金额（对于充值和建卡时，更新金额=实付金额+赠送金额）
	private String smeasxintegral;		//更新后金额
	private String smeasdopersonid;		//操作人ID
	private String smeasdopersonname;	//操作人姓名
	private String smeasdodate;			//操作日期
	private String smeasremark;			//备注
	private String smeasaddorsub;		//操作类型(0:建卡；1：充值；3:结款；4:退款；5:补齐欠款；6:订金；7:挂号费；8:维修费；9:退挂号费；)
	private String smeassalesbillid;	//关联单号
	private String smeaswithdrawflag;	//是否退货
	private String smeasischong;		//更改结款方式的冲回数据(C:表示冲回数据)
	
	public String getSmeasuuid() {
		return smeasuuid;
	}
	public void setSmeasuuid(String smeasuuid) {
		this.smeasuuid = smeasuuid;
	}
	public String getSmeascustomerid() {
		return smeascustomerid;
	}
	public void setSmeascustomerid(String smeascustomerid) {
		this.smeascustomerid = smeascustomerid;
	}
	public String getSmeasmemberid() {
		return smeasmemberid;
	}
	public void setSmeasmemberid(String smeasmemberid) {
		this.smeasmemberid = smeasmemberid;
	}
	public String getSmeasmembername() {
		return smeasmembername;
	}
	public void setSmeasmembername(String smeasmembername) {
		this.smeasmembername = smeasmembername;
	}
	public String getSmeaschuzhikaid() {
		return smeaschuzhikaid;
	}
	public void setSmeaschuzhikaid(String smeaschuzhikaid) {
		this.smeaschuzhikaid = smeaschuzhikaid;
	}
	public String getSmeaschuzhikacardid() {
		return smeaschuzhikacardid;
	}
	public void setSmeaschuzhikacardid(String smeaschuzhikacardid) {
		this.smeaschuzhikacardid = smeaschuzhikacardid;
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
	public String getSmeasdopersonname() {
		return smeasdopersonname;
	}
	public void setSmeasdopersonname(String smeasdopersonname) {
		this.smeasdopersonname = smeasdopersonname;
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
	public String getSmeasaddorsub() {
		return smeasaddorsub;
	}
	public void setSmeasaddorsub(String smeasaddorsub) {
		this.smeasaddorsub = smeasaddorsub;
	}
	public String getSmeassalesbillid() {
		return smeassalesbillid;
	}
	public void setSmeassalesbillid(String smeassalesbillid) {
		this.smeassalesbillid = smeassalesbillid;
	}
	public String getSmeaswithdrawflag() {
		return smeaswithdrawflag;
	}
	public void setSmeaswithdrawflag(String smeaswithdrawflag) {
		this.smeaswithdrawflag = smeaswithdrawflag;
	}
	public String getSmeasshifu() {
		return smeasshifu;
	}
	public void setSmeasshifu(String smeasshifu) {
		this.smeasshifu = smeasshifu;
	}
	public String getSmeaszengsong() {
		return smeaszengsong;
	}
	public void setSmeaszengsong(String smeaszengsong) {
		this.smeaszengsong = smeaszengsong;
	}
	public String getSmeasischong() {
		return smeasischong;
	}
	public void setSmeasischong(String smeasischong) {
		this.smeasischong = smeasischong;
	}


}
