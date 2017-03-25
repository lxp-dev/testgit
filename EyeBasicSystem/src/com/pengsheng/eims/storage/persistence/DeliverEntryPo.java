package com.pengsheng.eims.storage.persistence;
/**
 * 委外送货从表PO
 */
public class DeliverEntryPo {
	
	private String cstdeid;//ID
	
	private String cstdedeliverbillid;//送货单号
	
	private String cstdereceiptbillid;//委外收货单号

	private String cstdeorderdetailsid;//委外订单号
	
	private String cstdeglassesbillid;//配镜单号
	
	private String cstdegoodsid;//商品代码
	
	private String cstdebarcode;//商品条码
	
	private String cstdenum;//数量
	
	private String cstderemark;//备注	
	
	public String getCstdereceiptbillid() {
		return cstdereceiptbillid;
	}

	public void setCstdereceiptbillid(String cstdereceiptbillid) {
		this.cstdereceiptbillid = cstdereceiptbillid;
	}

	public String getCstdeid() {
		return cstdeid;
	}

	public void setCstdeid(String cstdeid) {
		this.cstdeid = cstdeid;
	}

	public String getCstdedeliverbillid() {
		return cstdedeliverbillid;
	}

	public void setCstdedeliverbillid(String cstdedeliverbillid) {
		this.cstdedeliverbillid = cstdedeliverbillid;
	}

	public String getCstdeglassesbillid() {
		return cstdeglassesbillid;
	}

	public void setCstdeglassesbillid(String cstdeglassesbillid) {
		this.cstdeglassesbillid = cstdeglassesbillid;
	}

	public String getCstderemark() {
		return cstderemark;
	}

	public void setCstderemark(String cstderemark) {
		this.cstderemark = cstderemark;
	}

	public String getCstdegoodsid() {
		return cstdegoodsid;
	}

	public void setCstdegoodsid(String cstdegoodsid) {
		this.cstdegoodsid = cstdegoodsid;
	}

	public String getCstdebarcode() {
		return cstdebarcode;
	}

	public void setCstdebarcode(String cstdebarcode) {
		this.cstdebarcode = cstdebarcode;
	}

	public String getCstdenum() {
		return cstdenum;
	}

	public void setCstdenum(String cstdenum) {
		this.cstdenum = cstdenum;
	}

	public String getCstdeorderdetailsid() {
		return cstdeorderdetailsid;
	}

	public void setCstdeorderdetailsid(String cstdeorderdetailsid) {
		this.cstdeorderdetailsid = cstdeorderdetailsid;
	}


}
