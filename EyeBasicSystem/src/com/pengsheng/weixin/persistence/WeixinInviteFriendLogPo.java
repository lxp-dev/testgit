package com.pengsheng.weixin.persistence;

public class WeixinInviteFriendLogPo {
	private String wiflid;				//ID
	private String wiflcustomerid;		//邀请人顾客编号
	private String wiflcustomername;	//邀请人顾客姓名
	private String wifltouserphone;		//被邀请人手机号
	private String wifltousername;		//被邀请人姓名
	private String wiflcreatetime;		//邀请时间
	private String wiflisconfirm;		//是否确认发放积分
	
	public String getWiflid() {
		return wiflid;
	}
	public void setWiflid(String wiflid) {
		this.wiflid = wiflid;
	}
	public String getWiflcustomerid() {
		return wiflcustomerid;
	}
	public void setWiflcustomerid(String wiflcustomerid) {
		this.wiflcustomerid = wiflcustomerid;
	}
	public String getWifltouserphone() {
		return wifltouserphone;
	}
	public void setWifltouserphone(String wifltouserphone) {
		this.wifltouserphone = wifltouserphone;
	}
	public String getWifltousername() {
		return wifltousername;
	}
	public void setWifltousername(String wifltousername) {
		this.wifltousername = wifltousername;
	}
	public String getWiflcreatetime() {
		return wiflcreatetime;
	}
	public void setWiflcreatetime(String wiflcreatetime) {
		this.wiflcreatetime = wiflcreatetime;
	}
	public String getWiflisconfirm() {
		return wiflisconfirm;
	}
	public void setWiflisconfirm(String wiflisconfirm) {
		this.wiflisconfirm = wiflisconfirm;
	}
	public String getWiflcustomername() {
		return wiflcustomername;
	}
	public void setWiflcustomername(String wiflcustomername) {
		this.wiflcustomername = wiflcustomername;
	}
}