/**
* 项目名称 : EIMS财务物流子系统
* 文件名称 : VoucherTypePo.java
* 版本号      : V1
* 作者           : SZK
* 生成日期 : 2011-02-11
**/
package com.pengsheng.eims.logistics.persistence;

public class VoucherTypePo {
	private String sLvtvtId = null;          //凭证类型ID
	private String sLvtvtTypeName = null;    //凭证类型名称
	private String sLvtvtParentID = null;    //所属凭证类型ID
	private String sLvtvtMinCount = null;    //所属凭证类型ID
	
	public String getsLvtvtMinCount() {
		return sLvtvtMinCount;
	}
	public void setsLvtvtMinCount(String sLvtvtMinCount) {
		this.sLvtvtMinCount = sLvtvtMinCount;
	}
	public String getsLvtvtId() {
		return sLvtvtId;
	}
	public void setsLvtvtId(String sLvtvtId) {
		this.sLvtvtId = sLvtvtId;
	}
	public String getsLvtvtTypeName() {
		return sLvtvtTypeName;
	}
	public void setsLvtvtTypeName(String sLvtvtTypeName) {
		this.sLvtvtTypeName = sLvtvtTypeName;
	}
	public String getsLvtvtParentID() {
		return sLvtvtParentID;
	}
	public void setsLvtvtParentID(String sLvtvtParentID) {
		this.sLvtvtParentID = sLvtvtParentID;
	}
}
