package com.pengsheng.eims.basic.persistence;

import java.util.List;


//库存详细查询 PO 
// 2011-4-28
public class GoodsDetailsInfoPo {
	private String sxhGoodsBarCode; 		//条码
	private String sxhGoodsId; 				//代码
	private String sxhGoodsName; 			//商品名称
	private String sxhGoodsCategoryName;	//商品类别
	private String sxhSupplierName;			//制造商名称
	private String sxhRetailPrice; 			//单价 
	private String sxhWarehouseName;  		//仓库名称
	private String sxhsumnum;  				//数量 
	private String sxhsumnums;  			//数量 1
	private String sxhDay;					//距过期天数
	private String sxhGoodsCategoryID; 		//商品类别
	private String sxhSupplierID; 			//制造商ID 
	private String sxhBrandID; 				//商品类别ID 
	private String sxhStockID; 				//仓位ID
	private String count;					//查询条数
	private String sxhbrandName;			//品种名称
	private String sxhtitlenum;				
	private String sxhguaranteeperiod;		//失效日期
	private String sxhmax;		
	private String sxhmin;		
	private String sxhinvisibletype;
	private String sxhwarehousingdate;		//变更日期
	private String sxhchangeid;				//变更单号	
	private String sxhunitname;
	private String sxhcostprice;
	private String sxhnottaxrate;
	private String sxhspec;
	private String sxhtaxrate;
	private String sxhautoallocationflag;
	private String sxhsalesbillflag;	
	private String cshslbatch; //批号
	private String viewType; //查询类型: 0有效期有批号  1有效期无批号  2无效期有批号  3全部	
	private String sxhbgndate;		//变更起始日期
	private String sxhenddate;		//变更截止日期
	private String sxhsph;		
	private String sxhcyl;	
	private String sxhisCustomize;	
	private String sxhStockID1;
	private List<WarehousePo> smecistocklist; // 相同公司的仓位
		
	public List<WarehousePo> getSmecistocklist() {
		return smecistocklist;
	}
	public void setSmecistocklist(List<WarehousePo> smecistocklist) {
		this.smecistocklist = smecistocklist;
	}
	public String getSxhStockID1() {
		return sxhStockID1;
	}
	public void setSxhStockID1(String sxhStockID1) {
		this.sxhStockID1 = sxhStockID1;
	}
	public String getSxhisCustomize() {
		return sxhisCustomize;
	}
	public void setSxhisCustomize(String sxhisCustomize) {
		this.sxhisCustomize = sxhisCustomize;
	}
	public String getSxhsph() {
		return sxhsph;
	}
	public void setSxhsph(String sxhsph) {
		this.sxhsph = sxhsph;
	}
	public String getSxhcyl() {
		return sxhcyl;
	}
	public void setSxhcyl(String sxhcyl) {
		this.sxhcyl = sxhcyl;
	}
	public String getSxhbgndate() {
		return sxhbgndate;
	}
	public void setSxhbgndate(String sxhbgndate) {
		this.sxhbgndate = sxhbgndate;
	}
	public String getSxhenddate() {
		return sxhenddate;
	}
	public void setSxhenddate(String sxhenddate) {
		this.sxhenddate = sxhenddate;
	}
	public String getSxhsalesbillflag() {
		return sxhsalesbillflag;
	}
	public void setSxhsalesbillflag(String sxhsalesbillflag) {
		this.sxhsalesbillflag = sxhsalesbillflag;
	}
	public String getSxhautoallocationflag() {
		return sxhautoallocationflag;
	}
	public void setSxhautoallocationflag(String sxhautoallocationflag) {
		this.sxhautoallocationflag = sxhautoallocationflag;
	}
	public String getSxhwarehousingdate() {
		return sxhwarehousingdate;
	}
	public void setSxhwarehousingdate(String sxhwarehousingdate) {
		this.sxhwarehousingdate = sxhwarehousingdate;
	}
	public String getSxhchangeid() {
		return sxhchangeid;
	}
	public void setSxhchangeid(String sxhchangeid) {
		this.sxhchangeid = sxhchangeid;
	}
	public String getSxhunitname() {
		return sxhunitname;
	}
	public void setSxhunitname(String sxhunitname) {
		this.sxhunitname = sxhunitname;
	}
	public String getSxhcostprice() {
		return sxhcostprice;
	}
	public void setSxhcostprice(String sxhcostprice) {
		this.sxhcostprice = sxhcostprice;
	}
	public String getSxhnottaxrate() {
		return sxhnottaxrate;
	}
	public void setSxhnottaxrate(String sxhnottaxrate) {
		this.sxhnottaxrate = sxhnottaxrate;
	}
	public String getSxhspec() {
		return sxhspec;
	}
	public void setSxhspec(String sxhspec) {
		this.sxhspec = sxhspec;
	}
	public String getSxhtaxrate() {
		return sxhtaxrate;
	}
	public void setSxhtaxrate(String sxhtaxrate) {
		this.sxhtaxrate = sxhtaxrate;
	}
	public String getSxhinvisibletype() {
		return sxhinvisibletype;
	}
	public void setSxhinvisibletype(String sxhinvisibletype) {
		this.sxhinvisibletype = sxhinvisibletype;
	}
	public String getSxhmax() {
		return sxhmax;
	}
	public void setSxhmax(String sxhmax) {
		this.sxhmax = sxhmax;
	}
	public String getSxhmin() {
		return sxhmin;
	}
	public void setSxhmin(String sxhmin) {
		this.sxhmin = sxhmin;
	}
	public String getSxhguaranteeperiod() {
		return sxhguaranteeperiod;
	}
	public void setSxhguaranteeperiod(String sxhguaranteeperiod) {
		this.sxhguaranteeperiod = sxhguaranteeperiod;
	}
	public String getSxhDay() {
		return sxhDay;
	}
	public void setSxhDay(String sxhDay) {
		this.sxhDay = sxhDay;
	}
	public String getSxhsumnums() {
		return sxhsumnums;
	}
	public void setSxhsumnums(String sxhsumnums) {
		this.sxhsumnums = sxhsumnums;
	}
	
	
	public String getSxhtitlenum() {
		return sxhtitlenum;
	}
	public void setSxhtitlenum(String sxhtitlenum) {
		this.sxhtitlenum = sxhtitlenum;
	}
	public String getSxhbrandName() {
		return sxhbrandName;
	}
	public void setSxhbrandName(String sxhbrandName) {
		this.sxhbrandName = sxhbrandName;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getSxhGoodsBarCode() {
		return sxhGoodsBarCode;
	}
	public void setSxhGoodsBarCode(String sxhGoodsBarCode) {
		this.sxhGoodsBarCode = sxhGoodsBarCode;
	}
	public String getSxhGoodsId() {
		return sxhGoodsId;
	}
	public void setSxhGoodsId(String sxhGoodsId) {
		this.sxhGoodsId = sxhGoodsId;
	}

	public String getSxhGoodsName() {
		return sxhGoodsName;
	}
	public void setSxhGoodsName(String sxhGoodsName) {
		this.sxhGoodsName = sxhGoodsName;
	}
	public String getSxhGoodsCategoryName() {
		return sxhGoodsCategoryName;
	}
	public void setSxhGoodsCategoryName(String sxhGoodsCategoryName) {
		this.sxhGoodsCategoryName = sxhGoodsCategoryName;
	}
	public String getSxhSupplierName() {
		return sxhSupplierName;
	}
	public void setSxhSupplierName(String sxhSupplierName) {
		this.sxhSupplierName = sxhSupplierName;
	}
	public String getSxhRetailPrice() {
		return sxhRetailPrice;
	}
	public void setSxhRetailPrice(String sxhRetailPrice) {
		this.sxhRetailPrice = sxhRetailPrice;
	}
	public String getSxhWarehouseName() {
		return sxhWarehouseName;
	}
	public void setSxhWarehouseName(String sxhWarehouseName) {
		this.sxhWarehouseName = sxhWarehouseName;
	}

	public String getSxhsumnum() {
		return sxhsumnum;
	}
	public void setSxhsumnum(String sxhsumnum) {
		this.sxhsumnum = sxhsumnum;
	}
	public String getSxhGoodsCategoryID() {
		return sxhGoodsCategoryID;
	}
	public void setSxhGoodsCategoryID(String sxhGoodsCategoryID) {
		this.sxhGoodsCategoryID = sxhGoodsCategoryID;
	}
	public String getSxhSupplierID() {
		return sxhSupplierID;
	}
	public void setSxhSupplierID(String sxhSupplierID) {
		this.sxhSupplierID = sxhSupplierID;
	}
	public String getSxhBrandID() {
		return sxhBrandID;
	}
	public void setSxhBrandID(String sxhBrandID) {
		this.sxhBrandID = sxhBrandID;
	}
	public String getSxhStockID() {
		return sxhStockID;
	}
	public void setSxhStockID(String sxhStockID) {
		this.sxhStockID = sxhStockID;
	}
	public String getCshslbatch() {
		return cshslbatch;
	}
	public void setCshslbatch(String cshslbatch) {
		this.cshslbatch = cshslbatch;
	}
	public String getViewType() {
		return viewType;
	}
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	
}
