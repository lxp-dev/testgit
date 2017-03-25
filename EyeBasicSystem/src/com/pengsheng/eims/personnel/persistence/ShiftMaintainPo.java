package com.pengsheng.eims.personnel.persistence;

public class ShiftMaintainPo 
{
	private String msmuuid;						//uuid
	private String msmshiftNumber;				//班次编号
	private String msmshiftName;				//班次名称
	private String msmworkLong;					//时长
	private String msmworkBegin;				//工作开始时间
	private String msmworkEnd;					//工作结束时间
	public String getMsmuuid() {
		return msmuuid;
	}
	public void setMsmuuid(String msmuuid) {
		this.msmuuid = msmuuid;
	}
	public String getMsmshiftNumber() {
		return msmshiftNumber;
	}
	public void setMsmshiftNumber(String msmshiftNumber) {
		this.msmshiftNumber = msmshiftNumber;
	}
	public String getMsmshiftName() {
		return msmshiftName;
	}
	public void setMsmshiftName(String msmshiftName) {
		this.msmshiftName = msmshiftName;
	}
	public String getMsmworkLong() {
		return msmworkLong;
	}
	public void setMsmworkLong(String msmworkLong) {
		this.msmworkLong = msmworkLong;
	}
	public String getMsmworkBegin() {
		return msmworkBegin;
	}
	public void setMsmworkBegin(String msmworkBegin) {
		this.msmworkBegin = msmworkBegin;
	}
	public String getMsmworkEnd() {
		return msmworkEnd;
	}
	public void setMsmworkEnd(String msmworkEnd) {
		this.msmworkEnd = msmworkEnd;
	}
	
	
}
