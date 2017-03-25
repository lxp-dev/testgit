package com.pengsheng.eims.basic.persistence;

public class BrandTempPo {
	
	private String[] brandid;
	
	private String[] brands;
	
	private String[] brandname;

	private String[] supplierid;

	private String[] categoryid;

	private String[] suppliername;
	
	private String[] retailprice; //零售价	
	
	private String[] updateretailprice; //调整后零售价

	private String[] costprice;  //含税成本
	
	private String[] updatecostprice;  //调整后含税成本
	
	private String[] wholesaleprice; //批发价
	
	private String[] updatewholesaleprice;  //调整后批发价

	public String[] getBrandid() {
		return brandid;
	}

	public void setBrandid(String[] brandid) {
		this.brandid = brandid;
	}

	public String[] getBrands() {
		return brands;
	}

	public void setBrands(String[] brands) {
		this.brands = brands;
	}

	public String[] getBrandname() {
		return brandname;
	}

	public void setBrandname(String[] brandname) {
		this.brandname = brandname;
	}

	public String[] getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String[] supplierid) {
		this.supplierid = supplierid;
	}

	public String[] getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String[] categoryid) {
		this.categoryid = categoryid;
	}

	public String[] getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String[] suppliername) {
		this.suppliername = suppliername;
	}

	public String[] getRetailprice() {
		return retailprice;
	}

	public void setRetailprice(String[] retailprice) {
		this.retailprice = retailprice;
	}

	public String[] getCostprice() {
		return costprice;
	}

	public void setCostprice(String[] costprice) {
		this.costprice = costprice;
	}

	public String[] getWholesaleprice() {
		return wholesaleprice;
	}

	public void setWholesaleprice(String[] wholesaleprice) {
		this.wholesaleprice = wholesaleprice;
	}

	public String[] getUpdateretailprice() {
		return updateretailprice;
	}

	public void setUpdateretailprice(String[] updateretailprice) {
		this.updateretailprice = updateretailprice;
	}

	public String[] getUpdatecostprice() {
		return updatecostprice;
	}

	public void setUpdatecostprice(String[] updatecostprice) {
		this.updatecostprice = updatecostprice;
	}

	public String[] getUpdatewholesaleprice() {
		return updatewholesaleprice;
	}

	public void setUpdatewholesaleprice(String[] updatewholesaleprice) {
		this.updatewholesaleprice = updatewholesaleprice;
	}
	
	

}
