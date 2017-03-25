package com.pengsheng.eims.sales.persistence;
/*
 * 检查充值卡实体类。
 */
public class CardPo {
	private String ssecid                 ; //主键
    private String sseccustomerid         ; //顾客号
    private String sseccardid             ; //检查充值卡
    private String ssecamount             ; //卡内金额
	private String ssecavailableamount    ; //可用金额
	private String ssecname               ; //顾客姓名
	private String ssecrecharge           ; //充值金额(新加)
	private String shopcode;              ; //部门(新加)
	private String sourceid;              ; //计费源(新加)
	public String getSourceid() {
		return sourceid;
	}
	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
	}
	public String getShopcode() {
		return shopcode;
	}
	public void setShopcode(String shopcode) {
		this.shopcode = shopcode;
	}
	public String getSsecrecharge() {
		return ssecrecharge;
	}
	public void setSsecrecharge(String ssecrecharge) {
		this.ssecrecharge = ssecrecharge;
	}
	public String getSsecname() {
		return ssecname;
	}
	public void setSsecname(String ssecname) {
		this.ssecname = ssecname;
	}
	public String getSsecid() {
		return ssecid;
	}
	public void setSsecid(String ssecid) {
		this.ssecid = ssecid;
	}
	public String getSseccustomerid() {
		return sseccustomerid;
	}
	public void setSseccustomerid(String sseccustomerid) {
		this.sseccustomerid = sseccustomerid;
	}
	public String getSseccardid() {
		return sseccardid;
	}
	public void setSseccardid(String sseccardid) {
		this.sseccardid = sseccardid;
	}
	public String getSsecamount() {
		return ssecamount;
	}
	public void setSsecamount(String ssecamount) {
		this.ssecamount = ssecamount;
	}
	public String getSsecavailableamount() {
		return ssecavailableamount;
	}
	public void setSsecavailableamount(String ssecavailableamount) {
		this.ssecavailableamount = ssecavailableamount;
	}



}