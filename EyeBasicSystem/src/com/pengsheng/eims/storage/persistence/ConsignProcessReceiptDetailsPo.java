package com.pengsheng.eims.storage.persistence;

public class ConsignProcessReceiptDetailsPo {
	private String cstcprdid;// UUID
	private String cstcprdreceiptbilld;// 委外收货单号
	private String cstcprdorderdetailsid;// 订单明细UUID
	private String cstcprdgoodsid;// 商品代码
	private String cstcprdbarcode; // 商品条码
	private String cstcprdnum;// 数量
	private String cstcprdnottaxrate;// 单位成本
	private String cstcprdcostprice;// 含税单价
	private String cstcprdtaxrate;// 税率
	private String cstcprdinstockid; // 入库仓位

	private String cstcprdgoodsname;// 商品名称
	private String cstcprbarcode;// 条码
	private String cstcprdspec;
	private String cstcprdcolor;//
	private String cstcprdsph;
	private String cstcprdcyl;
	private String cstcprdaxis;
	private String cstcprdcurvature;
	private String cstcprddia;
	private String cstcprflag;//左右眼标识
	private String cstcpretailprice;
	private String cstcpodsalesid;
	
	private String cstcpguaranteeperiod;  // 效期
	private String cstcpbatch;   // 批号
	private String cstcpregistrationnum;    // 注册证号
	
	private String[] cstcprflags;
	private String[] cstcprdgoodsids;
	private String[] cstcprdnums;
	private String[] cstcprdnottaxrates;
	private String[] cstcprdtaxrates;
	private String[] cstcprdcostprices;
	private String[] cstcprdorderdetailsids;
	private String[] cstcpodsalesids;
	private String[] cstcprdbarcodes;
	private String[] cstcpguaranteeperiods;
	private String[] cstcpbatchs;
	private String[] cstcpregistrationnums;
	
	public String[] getCstcprflags() {
		return cstcprflags;
	}

	public void setCstcprflags(String[] cstcprflags) {
		this.cstcprflags = cstcprflags;
	}

	public String[] getCstcprdgoodsids() {
		return cstcprdgoodsids;
	}

	public void setCstcprdgoodsids(String[] cstcprdgoodsids) {
		this.cstcprdgoodsids = cstcprdgoodsids;
	}

	public String[] getCstcprdnums() {
		return cstcprdnums;
	}

	public void setCstcprdnums(String[] cstcprdnums) {
		this.cstcprdnums = cstcprdnums;
	}

	public String[] getCstcprdnottaxrates() {
		return cstcprdnottaxrates;
	}

	public void setCstcprdnottaxrates(String[] cstcprdnottaxrates) {
		this.cstcprdnottaxrates = cstcprdnottaxrates;
	}

	public String[] getCstcprdtaxrates() {
		return cstcprdtaxrates;
	}

	public void setCstcprdtaxrates(String[] cstcprdtaxrates) {
		this.cstcprdtaxrates = cstcprdtaxrates;
	}

	public String[] getCstcprdcostprices() {
		return cstcprdcostprices;
	}

	public void setCstcprdcostprices(String[] cstcprdcostprices) {
		this.cstcprdcostprices = cstcprdcostprices;
	}

	public String[] getCstcprdorderdetailsids() {
		return cstcprdorderdetailsids;
	}

	public void setCstcprdorderdetailsids(String[] cstcprdorderdetailsids) {
		this.cstcprdorderdetailsids = cstcprdorderdetailsids;
	}

	public String[] getCstcpodsalesids() {
		return cstcpodsalesids;
	}

	public void setCstcpodsalesids(String[] cstcpodsalesids) {
		this.cstcpodsalesids = cstcpodsalesids;
	}

	public String[] getCstcprdbarcodes() {
		return cstcprdbarcodes;
	}

	public void setCstcprdbarcodes(String[] cstcprdbarcodes) {
		this.cstcprdbarcodes = cstcprdbarcodes;
	}

	public String[] getCstcpguaranteeperiods() {
		return cstcpguaranteeperiods;
	}

	public void setCstcpguaranteeperiods(String[] cstcpguaranteeperiods) {
		this.cstcpguaranteeperiods = cstcpguaranteeperiods;
	}

	public String[] getCstcpbatchs() {
		return cstcpbatchs;
	}

	public void setCstcpbatchs(String[] cstcpbatchs) {
		this.cstcpbatchs = cstcpbatchs;
	}

	public String[] getCstcpregistrationnums() {
		return cstcpregistrationnums;
	}

	public void setCstcpregistrationnums(String[] cstcpregistrationnums) {
		this.cstcpregistrationnums = cstcpregistrationnums;
	}

	public String getCstcpguaranteeperiod() {
		return cstcpguaranteeperiod;
	}

	public void setCstcpguaranteeperiod(String cstcpguaranteeperiod) {
		this.cstcpguaranteeperiod = cstcpguaranteeperiod;
	}

	public String getCstcpbatch() {
		return cstcpbatch;
	}

	public void setCstcpbatch(String cstcpbatch) {
		this.cstcpbatch = cstcpbatch;
	}

	public String getCstcpregistrationnum() {
		return cstcpregistrationnum;
	}

	public void setCstcpregistrationnum(String cstcpregistrationnum) {
		this.cstcpregistrationnum = cstcpregistrationnum;
	}

	public String getCstcpodsalesid() {
		return cstcpodsalesid;
	}

	public void setCstcpodsalesid(String cstcpodsalesid) {
		this.cstcpodsalesid = cstcpodsalesid;
	}

	public String getCstcpretailprice() {
		return cstcpretailprice;
	}

	public void setCstcpretailprice(String cstcpretailprice) {
		this.cstcpretailprice = cstcpretailprice;
	}

	public String getCstcprflag() {
		return cstcprflag;
	}

	public void setCstcprflag(String cstcprflag) {
		this.cstcprflag = cstcprflag;
	}

	public String getCstcprdid() {
		return cstcprdid;
	}

	public void setCstcprdid(String cstcprdid) {
		this.cstcprdid = cstcprdid;
	}

	public String getCstcprdreceiptbilld() {
		return cstcprdreceiptbilld;
	}

	public void setCstcprdreceiptbilld(String cstcprdreceiptbilld) {
		this.cstcprdreceiptbilld = cstcprdreceiptbilld;
	}

	public String getCstcprdorderdetailsid() {
		return cstcprdorderdetailsid;
	}

	public void setCstcprdorderdetailsid(String cstcprdorderdetailsid) {
		this.cstcprdorderdetailsid = cstcprdorderdetailsid;
	}

	public String getCstcprdgoodsid() {
		return cstcprdgoodsid;
	}

	public void setCstcprdgoodsid(String cstcprdgoodsid) {
		this.cstcprdgoodsid = cstcprdgoodsid;
	}

	public String getCstcprdbarcode() {
		return cstcprdbarcode;
	}

	public void setCstcprdbarcode(String cstcprdbarcode) {
		this.cstcprdbarcode = cstcprdbarcode;
	}

	public String getCstcprdnum() {
		return cstcprdnum;
	}

	public void setCstcprdnum(String cstcprdnum) {
		this.cstcprdnum = cstcprdnum;
	}

	public String getCstcprdcostprice() {
		return cstcprdcostprice;
	}

	public void setCstcprdcostprice(String cstcprdcostprice) {
		this.cstcprdcostprice = cstcprdcostprice;
	}

	public String getCstcprdnottaxrate() {
		return cstcprdnottaxrate;
	}

	public void setCstcprdnottaxrate(String cstcprdnottaxrate) {
		this.cstcprdnottaxrate = cstcprdnottaxrate;
	}

	public String getCstcprdinstockid() {
		return cstcprdinstockid;
	}

	public void setCstcprdinstockid(String cstcprdinstockid) {
		this.cstcprdinstockid = cstcprdinstockid;
	}

	public String getCstcprdtaxrate() {
		return cstcprdtaxrate;
	}

	public void setCstcprdtaxrate(String cstcprdtaxrate) {
		this.cstcprdtaxrate = cstcprdtaxrate;
	}

	public String getCstcprdgoodsname() {
		return cstcprdgoodsname;
	}

	public void setCstcprdgoodsname(String cstcprdgoodsname) {
		this.cstcprdgoodsname = cstcprdgoodsname;
	}

	public String getCstcprbarcode() {
		return cstcprbarcode;
	}

	public void setCstcprbarcode(String cstcprbarcode) {
		this.cstcprbarcode = cstcprbarcode;
	}

	public String getCstcprdspec() {
		return cstcprdspec;
	}

	public void setCstcprdspec(String cstcprdspec) {
		this.cstcprdspec = cstcprdspec;
	}

	public String getCstcprdcolor() {
		return cstcprdcolor;
	}

	public void setCstcprdcolor(String cstcprdcolor) {
		this.cstcprdcolor = cstcprdcolor;
	}

	public String getCstcprdsph() {
		return cstcprdsph;
	}

	public void setCstcprdsph(String cstcprdsph) {
		this.cstcprdsph = cstcprdsph;
	}

	public String getCstcprdcyl() {
		return cstcprdcyl;
	}

	public void setCstcprdcyl(String cstcprdcyl) {
		this.cstcprdcyl = cstcprdcyl;
	}

	public String getCstcprdaxis() {
		return cstcprdaxis;
	}

	public void setCstcprdaxis(String cstcprdaxis) {
		this.cstcprdaxis = cstcprdaxis;
	}

	public String getCstcprdcurvature() {
		return cstcprdcurvature;
	}

	public void setCstcprdcurvature(String cstcprdcurvature) {
		this.cstcprdcurvature = cstcprdcurvature;
	}

	public String getCstcprddia() {
		return cstcprddia;
	}

	public void setCstcprddia(String cstcprddia) {
		this.cstcprddia = cstcprddia;
	}

}
