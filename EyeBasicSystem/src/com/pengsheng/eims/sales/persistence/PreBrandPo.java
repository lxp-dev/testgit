package com.pengsheng.eims.sales.persistence;

/**
 * 预销售计划品种对象
 * @author ZK
 *
 */
public class PreBrandPo {
	
	private String preBrandId;//主键
	private String preDepId;//对应预销售部门主键ID
	private String supplierAndBrandId;//类别.制造商.品种ID 如:1.33.H1
	private String supplierId;//制造商ID
	private String supplierName;//制造商名称
	private String brandId;//品种ID
	private String brandName;//品种名称
	private String salesQuantity;//计划销售数量
	
	//新增使用字段 begin

	private String[] preBrandIds;//主键
	private String[] preDepIds;//部门ID
	private String[] supplierAndBrandIds;//类别.制造商.品种ID 如:1.33.H1
	private String[] supplierIds;//制造商ID
	private String[] supplierNames;//制造商名称
	private String[] brandIds;//品种ID
	private String[] brandNames;//品种名称
	private String[] salesQuantitys;//计划销售数量
	//新增使用字段 end
	
	public String getPreBrandId() {
		return preBrandId;
	}
	public void setPreBrandId(String preBrandId) {
		this.preBrandId = preBrandId;
	}
	public String getPreDepId() {
		return preDepId;
	}
	public void setPreDepId(String preDepId) {
		this.preDepId = preDepId;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSalesQuantity() {
		return salesQuantity;
	}
	public void setSalesQuantity(String salesQuantity) {
		this.salesQuantity = salesQuantity;
	}
	public String getSupplierAndBrandId() {
		return supplierAndBrandId;
	}
	public void setSupplierAndBrandId(String supplierAndBrandId) {
		this.supplierAndBrandId = supplierAndBrandId;
	}
	public String[] getPreBrandIds() {
		return preBrandIds;
	}
	public void setPreBrandIds(String[] preBrandIds) {
		this.preBrandIds = preBrandIds;
	}
	public String[] getPreDepIds() {
		return preDepIds;
	}
	public void setPreDepIds(String[] preDepIds) {
		this.preDepIds = preDepIds;
	}
	public String[] getSupplierAndBrandIds() {
		return supplierAndBrandIds;
	}
	public void setSupplierAndBrandIds(String[] supplierAndBrandIds) {
		this.supplierAndBrandIds = supplierAndBrandIds;
	}
	public String[] getSupplierIds() {
		return supplierIds;
	}
	public void setSupplierIds(String[] supplierIds) {
		this.supplierIds = supplierIds;
	}
	public String[] getSupplierNames() {
		return supplierNames;
	}
	public void setSupplierNames(String[] supplierNames) {
		this.supplierNames = supplierNames;
	}
	public String[] getBrandIds() {
		return brandIds;
	}
	public void setBrandIds(String[] brandIds) {
		this.brandIds = brandIds;
	}
	public String[] getBrandNames() {
		return brandNames;
	}
	public void setBrandNames(String[] brandNames) {
		this.brandNames = brandNames;
	}
	public String[] getSalesQuantitys() {
		return salesQuantitys;
	}
	public void setSalesQuantitys(String[] salesQuantitys) {
		this.salesQuantitys = salesQuantitys;
	}
	
}
