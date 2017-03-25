package com.pengsheng.eims.storage.persistence;

public class StrogeChangePo {

	private String cshscgoodsbarcode;//商品条码	
	private String cshscgoodsid;//商品代码    	
	private String cshscstockid;//仓库	
	private String cshscgoodsquantity;//商品数量	
	private String cshsccostprice;//商品成本	
	private String cshscnottaxrate;//不含税成本	
	private String cshscwarehousingdate;//入库日期	
	private String cshscmonth;//月度	
	private String cshscchangeid;//变更单据编号	
	private String cshscguaranteeperiod;		//效期	
	private String cshscBatch;					//批号
	private String cshscfromstockid; //调拨库房
	private String cshscrksj;		//入库时间
	private String cshscbarcodeflag;
	private String cshscuuid;
	private String cshscautoallocationflag;
	private String cshscsalesbillid;//销售单号	
	
	


	public String getCshscsalesbillid() {
		return cshscsalesbillid;
	}

	public void setCshscsalesbillid(String cshscsalesbillid) {
		this.cshscsalesbillid = cshscsalesbillid;
	}

	public String getCshscautoallocationflag() {
		return cshscautoallocationflag;
	}

	public void setCshscautoallocationflag(String cshscautoallocationflag) {
		this.cshscautoallocationflag = cshscautoallocationflag;
	}

	public String getCshscuuid() {
		return cshscuuid;
	}

	public void setCshscuuid(String cshscuuid) {
		this.cshscuuid = cshscuuid;
	}

	public String getCshscbarcodeflag() {
		return cshscbarcodeflag;
	}

	public void setCshscbarcodeflag(String cshscbarcodeflag) {
		this.cshscbarcodeflag = cshscbarcodeflag;
	}

	public String getCshscrksj() {
		return cshscrksj;
	}

	public void setCshscrksj(String cshscrksj) {
		this.cshscrksj = cshscrksj;
	}

	public String getCshscfromstockid() {
		return cshscfromstockid;
	}

	public void setCshscfromstockid(String cshscfromstockid) {
		this.cshscfromstockid = cshscfromstockid;
	}

	public String getCshscguaranteeperiod() {
		return cshscguaranteeperiod;
	}

	public void setCshscguaranteeperiod(String cshscguaranteeperiod) {
		this.cshscguaranteeperiod = cshscguaranteeperiod;
	}

	public String getCshscBatch() {
		return cshscBatch;
	}

	public void setCshscBatch(String cshscBatch) {
		this.cshscBatch = cshscBatch;
	}

	public String getCshscgoodsbarcode() {
		return cshscgoodsbarcode;
	}

	public void setCshscgoodsbarcode(String cshscgoodsbarcode) {
		this.cshscgoodsbarcode = cshscgoodsbarcode;
	}

	public String getCshscgoodsid() {
		return cshscgoodsid;
	}

	public void setCshscgoodsid(String cshscgoodsid) {
		this.cshscgoodsid = cshscgoodsid;
	}

	public String getCshscstockid() {
		return cshscstockid;
	}

	public void setCshscstockid(String cshscstockid) {
		this.cshscstockid = cshscstockid;
	}

	public String getCshscgoodsquantity() {
		return cshscgoodsquantity;
	}

	public void setCshscgoodsquantity(String cshscgoodsquantity) {
		this.cshscgoodsquantity = cshscgoodsquantity;
	}


	public String getCshscwarehousingdate() {
		return cshscwarehousingdate;
	}

	public String getCshsccostprice() {
		return cshsccostprice;
	}

	public void setCshsccostprice(String cshsccostprice) {
		this.cshsccostprice = cshsccostprice;
	}

	public String getCshscnottaxrate() {
		return cshscnottaxrate;
	}

	public void setCshscnottaxrate(String cshscnottaxrate) {
		this.cshscnottaxrate = cshscnottaxrate;
	}

	public void setCshscwarehousingdate(String cshscwarehousingdate) {
		this.cshscwarehousingdate = cshscwarehousingdate;
	}

	public String getCshscmonth() {
		return cshscmonth;
	}

	public void setCshscmonth(String cshscmonth) {
		this.cshscmonth = cshscmonth;
	}

	public String getCshscchangeid() {
		return cshscchangeid;
	}

	public void setCshscchangeid(String cshscchangeid) {
		this.cshscchangeid = cshscchangeid;
	}

}
