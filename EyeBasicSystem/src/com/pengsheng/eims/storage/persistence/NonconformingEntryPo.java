package com.pengsheng.eims.storage.persistence;

public class NonconformingEntryPo {
	private String leftorright; //左右眼标识quyanping
	private String cshaneid;  //ID	
	private String cshanebillid;  //不合格品单UUID	外键关联不合格品表ID
	private String cshanegoodsid;  //商品代码	外键 关联商品信息-商品代码
	private String cshanebarcode;  //商品条码	
	private String cshanegoodsname;  //商品名称	
	private String cshanegoodstype;  //商品类型	外键 关联商品类型ID
	private String cshanereasons1;  //不合格品原因1	外键 关联不合格品原因ID
	private String cshanereasons1name;
	private String cshanereasons2;  //不合格品原因2	外键 关联不合格品原因ID
	private String cshanereasons2name;
	private String cshaneremark;  //备注	
	private String cshaneconsignmode;
	private String iscustomize; //镜片类型        D:订做 0:成品片
	private String cshanesalesdetailid;//销售明细主键ID
	private String cshanesalesvalue;//销售明细应收金额
	private String cshanegoodsquantity;//商品数量
	private String cshaneretailprice;		//商品零售价
	
	public String getCshaneretailprice() {
		return cshaneretailprice;
	}
	public void setCshaneretailprice(String cshaneretailprice) {
		this.cshaneretailprice = cshaneretailprice;
	}
	public String getCshanegoodsquantity() {
		return cshanegoodsquantity;
	}
	public void setCshanegoodsquantity(String cshanegoodsquantity) {
		this.cshanegoodsquantity = cshanegoodsquantity;
	}
	public String getCshanesalesvalue() {
		return cshanesalesvalue;
	}
	public void setCshanesalesvalue(String cshanesalesvalue) {
		this.cshanesalesvalue = cshanesalesvalue;
	}
	public String getCshanesalesdetailid() {
		return cshanesalesdetailid;
	}
	public void setCshanesalesdetailid(String cshanesalesdetailid) {
		this.cshanesalesdetailid = cshanesalesdetailid;
	}
	public String getIscustomize() {
		return iscustomize;
	}
	public void setIscustomize(String iscustomize) {
		this.iscustomize = iscustomize;
	}
	public String getCshaneid() {
		return cshaneid;
	}
	public String getCshaneconsignmode() {
		return cshaneconsignmode;
	}
	public void setCshaneconsignmode(String cshaneconsignmode) {
		this.cshaneconsignmode = cshaneconsignmode;
	}
	public void setCshaneid(String cshaneid) {
		this.cshaneid = cshaneid;
	}
	public String getCshanebillid() {
		return cshanebillid;
	}
	public void setCshanebillid(String cshanebillid) {
		this.cshanebillid = cshanebillid;
	}
	public String getCshanegoodsid() {
		return cshanegoodsid;
	}
	public void setCshanegoodsid(String cshanegoodsid) {
		this.cshanegoodsid = cshanegoodsid;
	}
	public String getCshanebarcode() {
		return cshanebarcode;
	}
	public void setCshanebarcode(String cshanebarcode) {
		this.cshanebarcode = cshanebarcode;
	}
	public String getCshanegoodsname() {
		return cshanegoodsname;
	}
	public void setCshanegoodsname(String cshanegoodsname) {
		this.cshanegoodsname = cshanegoodsname;
	}
	public String getCshanegoodstype() {
		return cshanegoodstype;
	}
	public void setCshanegoodstype(String cshanegoodstype) {
		this.cshanegoodstype = cshanegoodstype;
	}
	public String getCshanereasons1() {
		return cshanereasons1;
	}
	public void setCshanereasons1(String cshanereasons1) {
		this.cshanereasons1 = cshanereasons1;
	}
	public String getCshanereasons2() {
		return cshanereasons2;
	}
	public void setCshanereasons2(String cshanereasons2) {
		this.cshanereasons2 = cshanereasons2;
	}
	public String getCshaneremark() {
		return cshaneremark;
	}
	public void setCshaneremark(String cshaneremark) {
		this.cshaneremark = cshaneremark;
	}
	public String getCshanereasons1name() {
		return cshanereasons1name;
	}
	public void setCshanereasons1name(String cshanereasons1name) {
		this.cshanereasons1name = cshanereasons1name;
	}
	public String getCshanereasons2name() {
		return cshanereasons2name;
	}
	public void setCshanereasons2name(String cshanereasons2name) {
		this.cshanereasons2name = cshanereasons2name;
	}
	public void setLeftorright(String leftorright) {
		this.leftorright = leftorright;
	}
	public String getLeftorright() {
		return leftorright;
	}
}
