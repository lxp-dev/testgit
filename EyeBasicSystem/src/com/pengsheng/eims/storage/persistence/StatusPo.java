package com.pengsheng.eims.storage.persistence;
/**
 * @author 沈兴贺 
 * @version 创建时间：2012-5-5 下午04:16:01
 * 类说明
 */

public class StatusPo {
	
	private String cshastatusuuid;			//主键
	private String cshastatusapplybillid;	//申请单号
	private String cshastatusbillid;		//调拨单号
	private String cshastatusorderid;		//采购单号
	private String cshastatusreceiptid;		//收货单号
	
	
	public String getCshastatusuuid() {
		return cshastatusuuid;
	}
	public void setCshastatusuuid(String cshastatusuuid) {
		this.cshastatusuuid = cshastatusuuid;
	}
	public String getCshastatusapplybillid() {
		return cshastatusapplybillid;
	}
	public void setCshastatusapplybillid(String cshastatusapplybillid) {
		this.cshastatusapplybillid = cshastatusapplybillid;
	}
	public String getCshastatusbillid() {
		return cshastatusbillid;
	}
	public void setCshastatusbillid(String cshastatusbillid) {
		this.cshastatusbillid = cshastatusbillid;
	}
	public String getCshastatusorderid() {
		return cshastatusorderid;
	}
	public void setCshastatusorderid(String cshastatusorderid) {
		this.cshastatusorderid = cshastatusorderid;
	}
	public String getCshastatusreceiptid() {
		return cshastatusreceiptid;
	}
	public void setCshastatusreceiptid(String cshastatusreceiptid) {
		this.cshastatusreceiptid = cshastatusreceiptid;
	}
}
