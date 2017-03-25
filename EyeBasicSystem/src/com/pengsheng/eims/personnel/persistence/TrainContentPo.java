package com.pengsheng.eims.personnel.persistence;

public class TrainContentPo 
{
	private String mtcuuid;						//uuid
	private String mtccontentNumber;			//培训内容编号
	private String mtccontentName;				//培训内容名称
	public String getMtccontentName() {
		return mtccontentName;
	}
	public void setMtccontentName(String mtccontentName) {
		this.mtccontentName = mtccontentName;
	}
	public String getMtcuuid() {
		return mtcuuid;
	}
	public void setMtcuuid(String mtcuuid) {
		this.mtcuuid = mtcuuid;
	}
	public String getMtccontentNumber() {
		return mtccontentNumber;
	}
	public void setMtccontentNumber(String mtccontentNumber) {
		this.mtccontentNumber = mtccontentNumber;
	}
	
	
}
