package com.pengsheng.eims.basic.persistence;

/**
 * 
 * @author sxh 20121103
 *
 */
public class CustomerAgeGroupPo {
	private String bcguuid;				//主键
	private String bcgagesmin;			//min age 
	private String bcgagesmax;			//max age
	private String bcggoodscategory;	//goodscategory
	private String bcggoodscategoryname;//goodscategoryname
	private String bcgremark;			//remark
	
	private String[] bcgagesmins;		//min age 
	private String[] bcgagesmaxs;		//max age
	
	public String[] getBcgagesmins() {
		return bcgagesmins;
	}
	public void setBcgagesmins(String[] bcgagesmins) {
		this.bcgagesmins = bcgagesmins;
	}
	public String[] getBcgagesmaxs() {
		return bcgagesmaxs;
	}
	public void setBcgagesmaxs(String[] bcgagesmaxs) {
		this.bcgagesmaxs = bcgagesmaxs;
	}
	public String getBcggoodscategoryname() {
		return bcggoodscategoryname;
	}
	public void setBcggoodscategoryname(String bcggoodscategoryname) {
		this.bcggoodscategoryname = bcggoodscategoryname;
	}
	public String getBcguuid() {
		return bcguuid;
	}
	public void setBcguuid(String bcguuid) {
		this.bcguuid = bcguuid;
	}
	public String getBcgagesmin() {
		return bcgagesmin;
	}
	public void setBcgagesmin(String bcgagesmin) {
		this.bcgagesmin = bcgagesmin;
	}
	public String getBcgagesmax() {
		return bcgagesmax;
	}
	public void setBcgagesmax(String bcgagesmax) {
		this.bcgagesmax = bcgagesmax;
	}
	public String getBcggoodscategory() {
		return bcggoodscategory;
	}
	public void setBcggoodscategory(String bcggoodscategory) {
		this.bcggoodscategory = bcggoodscategory;
	}
	public String getBcgremark() {
		return bcgremark;
	}
	public void setBcgremark(String bcgremark) {
		this.bcgremark = bcgremark;
	}
	
}
