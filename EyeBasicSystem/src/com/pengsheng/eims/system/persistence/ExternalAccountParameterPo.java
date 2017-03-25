package com.pengsheng.eims.system.persistence;

public class ExternalAccountParameterPo {
	private String feaid;                 //UUID
	private String feaaccessaddress;      //正式系统的访问地址
	private String feaexternaladdress;    //外帐系统的访问地址
	private String feaaccessname;         //跨库链接名称
	private String feaexternalname;       //外帐数据库名称
	private String feaprocreateid;        //采购收货单制单人员
	private String feaproaduiteid;        //采购收货单审核人员
	private String feadepartmentsid;      //采购退货单制单部门
	private String feaproreturncreateid;  //采购退货单制单人员
	private String feaproreturnaduiteid;  //采购退货单审核人员
	private String feanocashmothe;        //顾客非现金结款设置
	private String feanocashmothename;    //顾客非现金结款设置名称
	private String feacastset;            //商品销售成本设置
	
	public String getFeanocashmothename() {
		return feanocashmothename;
	}
	public void setFeanocashmothename(String feanocashmothename) {
		this.feanocashmothename = feanocashmothename;
	}
	public String getFeaid() {
		return feaid;
	}
	public void setFeaid(String feaid) {
		this.feaid = feaid;
	}
	public String getFeaaccessaddress() {
		return feaaccessaddress;
	}
	public void setFeaaccessaddress(String feaaccessaddress) {
		this.feaaccessaddress = feaaccessaddress;
	}
	public String getFeaexternaladdress() {
		return feaexternaladdress;
	}
	public void setFeaexternaladdress(String feaexternaladdress) {
		this.feaexternaladdress = feaexternaladdress;
	}
	public String getFeaaccessname() {
		return feaaccessname;
	}
	public void setFeaaccessname(String feaaccessname) {
		this.feaaccessname = feaaccessname;
	}
	public String getFeaexternalname() {
		return feaexternalname;
	}
	public void setFeaexternalname(String feaexternalname) {
		this.feaexternalname = feaexternalname;
	}
	public String getFeaprocreateid() {
		return feaprocreateid;
	}
	public void setFeaprocreateid(String feaprocreateid) {
		this.feaprocreateid = feaprocreateid;
	}
	public String getFeaproaduiteid() {
		return feaproaduiteid;
	}
	public void setFeaproaduiteid(String feaproaduiteid) {
		this.feaproaduiteid = feaproaduiteid;
	}
	public String getFeadepartmentsid() {
		return feadepartmentsid;
	}
	public void setFeadepartmentsid(String feadepartmentsid) {
		this.feadepartmentsid = feadepartmentsid;
	}
	public String getFeaproreturncreateid() {
		return feaproreturncreateid;
	}
	public void setFeaproreturncreateid(String feaproreturncreateid) {
		this.feaproreturncreateid = feaproreturncreateid;
	}
	public String getFeaproreturnaduiteid() {
		return feaproreturnaduiteid;
	}
	public void setFeaproreturnaduiteid(String feaproreturnaduiteid) {
		this.feaproreturnaduiteid = feaproreturnaduiteid;
	}
	public String getFeanocashmothe() {
		return feanocashmothe;
	}
	public void setFeanocashmothe(String feanocashmothe) {
		this.feanocashmothe = feanocashmothe;
	}
	public String getFeacastset() {
		return feacastset;
	}
	public void setFeacastset(String feacastset) {
		this.feacastset = feacastset;
	}

	
}
