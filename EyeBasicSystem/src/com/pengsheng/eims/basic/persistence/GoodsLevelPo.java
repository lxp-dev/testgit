package com.pengsheng.eims.basic.persistence;

/**
 * 商品
 * @author Administrator
 *
 */
public class GoodsLevelPo {
	private String bgluuid;			//主键
	private String bglid;			//商品等级ID
	private String bglname;			//商品等级名称
	private String bgldiscount;		//默认折扣
	private String bglcategoryid;	//对应商品类别
	
	public String getBgluuid() {
		return bgluuid;
	}
	public void setBgluuid(String bgluuid) {
		this.bgluuid = bgluuid;
	}
	public String getBglid() {
		return bglid;
	}
	public void setBglid(String bglid) {
		this.bglid = bglid;
	}
	public String getBglname() {
		return bglname;
	}
	public void setBglname(String bglname) {
		this.bglname = bglname;
	}
	public String getBgldiscount() {
		return bgldiscount;
	}
	public void setBgldiscount(String bgldiscount) {
		this.bgldiscount = bgldiscount;
	}
	public String getBglcategoryid() {
		return bglcategoryid;
	}
	public void setBglcategoryid(String bglcategoryid) {
		this.bglcategoryid = bglcategoryid;
	}
	
}
