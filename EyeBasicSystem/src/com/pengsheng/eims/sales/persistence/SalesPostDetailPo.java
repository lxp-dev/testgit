package com.pengsheng.eims.sales.persistence;

public class SalesPostDetailPo {
	private String ssespdid             ; //ID                       
	private String ssespdsalesid        ; //销售单号                 
	private String ssespdsalesitemid    ; //商品代码                 
	private String ssespditemid         ; //商品条码                 
	private String ssespdstockid        ; //仓储ID                   
	private String ssespdsalesitemname  ; //商品名称                 
	private String ssespdsprice         ; //商品单价                 
	private String ssespdnumber         ; //数量
	private String ssespdunitprice      ; //单位成本(不含税价格)
	private String ssespdcostsprive     ; //成本价格
	private String ssespdpricesum       ; //原价合计                 
	private String ssespdsalesvalue     ; //应收金额                 
	private String ssespddiscountrate   ; //原折率                     
	private String ssespddiscountnum    ; //原折扣金额                 
	private String ssespdysvalue        ; //原实收金额                 
	private String ssespdnewdiscountrate; //新折率                     
	private String ssespdnewdiscountnum ; //新折扣金额                 
	private String ssespdnewysvalue     ; //新实收金额                 
	private String ssespdpostvalue      ; //退差价金额                 
	private String ssespdgooddescribe   ; //商品描述                 
	private String ssespdglassflag      ; //右眼：R， 左眼：L        
	private String ssespdcommoditiesflag; //商品类别
	private String ssespdupdatetime     ; //更新时间
	private String ssespdlargessflag    ; //赠品标识           
	private String ssespdrownumber;
	public String getSsespdrownumber() {
		return ssespdrownumber;
	}
	public void setSsespdrownumber(String ssespdrownumber) {
		this.ssespdrownumber = ssespdrownumber;
	}
	public String getSsespdid() {
		return ssespdid;
	}
	public void setSsespdid(String ssespdid) {
		this.ssespdid = ssespdid;
	}
	public String getSsespdsalesid() {
		return ssespdsalesid;
	}
	public void setSsespdsalesid(String ssespdsalesid) {
		this.ssespdsalesid = ssespdsalesid;
	}
	public String getSsespdsalesitemid() {
		return ssespdsalesitemid;
	}
	public void setSsespdsalesitemid(String ssespdsalesitemid) {
		this.ssespdsalesitemid = ssespdsalesitemid;
	}
	public String getSsespditemid() {
		return ssespditemid;
	}
	public void setSsespditemid(String ssespditemid) {
		this.ssespditemid = ssespditemid;
	}
	public String getSsespdstockid() {
		return ssespdstockid;
	}
	public void setSsespdstockid(String ssespdstockid) {
		this.ssespdstockid = ssespdstockid;
	}
	public String getSsespdsalesitemname() {
		return ssespdsalesitemname;
	}
	public void setSsespdsalesitemname(String ssespdsalesitemname) {
		this.ssespdsalesitemname = ssespdsalesitemname;
	}
	public String getSsespdsprice() {
		return ssespdsprice;
	}
	public void setSsespdsprice(String ssespdsprice) {
		this.ssespdsprice = ssespdsprice;
	}
	public String getSsespdnumber() {
		return ssespdnumber;
	}
	public void setSsespdnumber(String ssespdnumber) {
		this.ssespdnumber = ssespdnumber;
	}
	public String getSsespdunitprice() {
		return ssespdunitprice;
	}
	public void setSsespdunitprice(String ssespdunitprice) {
		this.ssespdunitprice = ssespdunitprice;
	}
	public String getSsespdcostsprive() {
		return ssespdcostsprive;
	}
	public void setSsespdcostsprive(String ssespdcostsprive) {
		this.ssespdcostsprive = ssespdcostsprive;
	}
	public String getSsespdpricesum() {
		return ssespdpricesum;
	}
	public void setSsespdpricesum(String ssespdpricesum) {
		this.ssespdpricesum = ssespdpricesum;
	}
	public String getSsespdsalesvalue() {
		return ssespdsalesvalue;
	}
	public void setSsespdsalesvalue(String ssespdsalesvalue) {
		this.ssespdsalesvalue = ssespdsalesvalue;
	}
	public String getSsespddiscountrate() {
		return ssespddiscountrate;
	}
	public void setSsespddiscountrate(String ssespddiscountrate) {
		this.ssespddiscountrate = ssespddiscountrate;
	}
	public String getSsespddiscountnum() {
		return ssespddiscountnum;
	}
	public void setSsespddiscountnum(String ssespddiscountnum) {
		this.ssespddiscountnum = ssespddiscountnum;
	}
	public String getSsespdysvalue() {
		return ssespdysvalue;
	}
	public void setSsespdysvalue(String ssespdysvalue) {
		this.ssespdysvalue = ssespdysvalue;
	}
	public String getSsespdnewdiscountrate() {
		return ssespdnewdiscountrate;
	}
	public void setSsespdnewdiscountrate(String ssespdnewdiscountrate) {
		this.ssespdnewdiscountrate = ssespdnewdiscountrate;
	}
	public String getSsespdnewdiscountnum() {
		return ssespdnewdiscountnum;
	}
	public void setSsespdnewdiscountnum(String ssespdnewdiscountnum) {
		this.ssespdnewdiscountnum = ssespdnewdiscountnum;
	}
	public String getSsespdnewysvalue() {
		return ssespdnewysvalue;
	}
	public void setSsespdnewysvalue(String ssespdnewysvalue) {
		this.ssespdnewysvalue = ssespdnewysvalue;
	}
	public String getSsespdpostvalue() {
		return ssespdpostvalue;
	}
	public void setSsespdpostvalue(String ssespdpostvalue) {
		this.ssespdpostvalue = ssespdpostvalue;
	}
	public String getSsespdgooddescribe() {
		return ssespdgooddescribe;
	}
	public void setSsespdgooddescribe(String ssespdgooddescribe) {
		this.ssespdgooddescribe = ssespdgooddescribe;
	}
	public String getSsespdglassflag() {
		return ssespdglassflag;
	}
	public void setSsespdglassflag(String ssespdglassflag) {
		this.ssespdglassflag = ssespdglassflag;
	}
	public String getSsespdcommoditiesflag() {
		return ssespdcommoditiesflag;
	}
	public void setSsespdcommoditiesflag(String ssespdcommoditiesflag) {
		this.ssespdcommoditiesflag = ssespdcommoditiesflag;
	}
	public String getSsespdupdatetime() {
		return ssespdupdatetime;
	}
	public void setSsespdupdatetime(String ssespdupdatetime) {
		this.ssespdupdatetime = ssespdupdatetime;
	}
	public String getSsespdlargessflag() {
		return ssespdlargessflag;
	}
	public void setSsespdlargessflag(String ssespdlargessflag) {
		this.ssespdlargessflag = ssespdlargessflag;
	}
	
}                  
