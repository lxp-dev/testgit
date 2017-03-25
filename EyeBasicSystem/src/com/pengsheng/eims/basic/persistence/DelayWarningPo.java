package com.pengsheng.eims.basic.persistence;

public class DelayWarningPo {
	private String bdwuuid;			//主键
	private String bdwwarningdate;	//距取镜多长时间提醒
	private String bdwminwarningdate;	//距取镜多长时间提醒
	private String bdwpmf;			//已配送没发料
	private String bdwfmj;			//已发料没初检
	private String bdcjmj;			//已初检没加工
	private String bdwjmj;			//已加工没检验
	private String bdwjmp;			//已检验没配送
	private String bdwwsmf;			//委外已收货没发料
	private String bdwwsmp;			//委外已收货没配送
	private String bdwwsh;         //已做委外订单未收货
	
	private String bdintransittype;
	private String bdintransit;
	private String bdintransittype2;
	private String bdintransit2;
	private String selbbdsupplierid;	//制造商ID，查询条件
	private String bdwcompanyid; // 所属公司
	
	public String getBdwcompanyid() {
		return bdwcompanyid;
	}
	public void setBdwcompanyid(String bdwcompanyid) {
		this.bdwcompanyid = bdwcompanyid;
	}
	public String getBdwminwarningdate() {
		return bdwminwarningdate;
	}
	public void setBdwminwarningdate(String bdwminwarningdate) {
		this.bdwminwarningdate = bdwminwarningdate;
	}
	public String getBdintransittype() {
		return bdintransittype;
	}
	public void setBdintransittype(String bdintransittype) {
		this.bdintransittype = bdintransittype;
	}
	public String getBdintransit() {
		return bdintransit;
	}
	public void setBdintransit(String bdintransit) {
		this.bdintransit = bdintransit;
	}
	public String getBdintransittype2() {
		return bdintransittype2;
	}
	public void setBdintransittype2(String bdintransittype2) {
		this.bdintransittype2 = bdintransittype2;
	}
	public String getBdintransit2() {
		return bdintransit2;
	}
	public void setBdintransit2(String bdintransit2) {
		this.bdintransit2 = bdintransit2;
	}
	public String getBdwwsh() {
		return bdwwsh;
	}
	public void setBdwwsh(String bdwwsh) {
		this.bdwwsh = bdwwsh;
	}
	private String bdwsalesid;		//销售ID
	private String bdwsshopcodeid;	//销售门店ID
	private String bdwsshopcodename;//销售门店名称
	private String bdwqshopcodeid;	//取镜门店ID
	private String bdwqshopcodename;//取镜门店名称
	private String bdwcustomerid;	//顾客ID
	private String bdwcustomername;	//顾客名称
	private String bdwsalesdatetime;//销售日期
	private String bdwtakedatetime;	//取镜日期
	private String bdwinTransit;	//在途
	private String bdwnoticeid;		//通知主键
	
	private String bdwnoticetype;	//通知状态
	
	
	public String getBdcjmj() {
		return bdcjmj;
	}
	public void setBdcjmj(String bdcjmj) {
		this.bdcjmj = bdcjmj;
	}
	public String getBdwnoticeid() {
		return bdwnoticeid;
	}
	public void setBdwnoticeid(String bdwnoticeid) {
		this.bdwnoticeid = bdwnoticeid;
	}
	public String getBdwsalesid() {
		return bdwsalesid;
	}
	public void setBdwsalesid(String bdwsalesid) {
		this.bdwsalesid = bdwsalesid;
	}
	public String getBdwsshopcodeid() {
		return bdwsshopcodeid;
	}
	public void setBdwsshopcodeid(String bdwsshopcodeid) {
		this.bdwsshopcodeid = bdwsshopcodeid;
	}
	public String getBdwsshopcodename() {
		return bdwsshopcodename;
	}
	public void setBdwsshopcodename(String bdwsshopcodename) {
		this.bdwsshopcodename = bdwsshopcodename;
	}
	public String getBdwqshopcodeid() {
		return bdwqshopcodeid;
	}
	public void setBdwqshopcodeid(String bdwqshopcodeid) {
		this.bdwqshopcodeid = bdwqshopcodeid;
	}
	public String getBdwqshopcodename() {
		return bdwqshopcodename;
	}
	public void setBdwqshopcodename(String bdwqshopcodename) {
		this.bdwqshopcodename = bdwqshopcodename;
	}
	public String getBdwcustomerid() {
		return bdwcustomerid;
	}
	public void setBdwcustomerid(String bdwcustomerid) {
		this.bdwcustomerid = bdwcustomerid;
	}
	public String getBdwcustomername() {
		return bdwcustomername;
	}
	public void setBdwcustomername(String bdwcustomername) {
		this.bdwcustomername = bdwcustomername;
	}
	public String getBdwsalesdatetime() {
		return bdwsalesdatetime;
	}
	public void setBdwsalesdatetime(String bdwsalesdatetime) {
		this.bdwsalesdatetime = bdwsalesdatetime;
	}
	public String getBdwtakedatetime() {
		return bdwtakedatetime;
	}
	public void setBdwtakedatetime(String bdwtakedatetime) {
		this.bdwtakedatetime = bdwtakedatetime;
	}
	public String getBdwinTransit() {
		return bdwinTransit;
	}
	public void setBdwinTransit(String bdwinTransit) {
		this.bdwinTransit = bdwinTransit;
	}
	public String getBdwuuid() {
		return bdwuuid;
	}
	public void setBdwuuid(String bdwuuid) {
		this.bdwuuid = bdwuuid;
	}
	public String getBdwwarningdate() {
		return bdwwarningdate;
	}
	public void setBdwwarningdate(String bdwwarningdate) {
		this.bdwwarningdate = bdwwarningdate;
	}
	public String getBdwpmf() {
		return bdwpmf;
	}
	public void setBdwpmf(String bdwpmf) {
		this.bdwpmf = bdwpmf;
	}
	public String getBdwfmj() {
		return bdwfmj;
	}
	public void setBdwfmj(String bdwfmj) {
		this.bdwfmj = bdwfmj;
	}
	public String getBdwjmj() {
		return bdwjmj;
	}
	public void setBdwjmj(String bdwjmj) {
		this.bdwjmj = bdwjmj;
	}
	public String getBdwjmp() {
		return bdwjmp;
	}
	public void setBdwjmp(String bdwjmp) {
		this.bdwjmp = bdwjmp;
	}
	public String getBdwwsmf() {
		return bdwwsmf;
	}
	public void setBdwwsmf(String bdwwsmf) {
		this.bdwwsmf = bdwwsmf;
	}
	public String getBdwwsmp() {
		return bdwwsmp;
	}
	public void setBdwwsmp(String bdwwsmp) {
		this.bdwwsmp = bdwwsmp;
	}
	public String getBdwnoticetype() {
		return bdwnoticetype;
	}
	public void setBdwnoticetype(String bdwnoticetype) {
		this.bdwnoticetype = bdwnoticetype;
	}
	public String getSelbbdsupplierid() {
		return selbbdsupplierid;
	}
	public void setSelbbdsupplierid(String selbbdsupplierid) {
		this.selbbdsupplierid = selbbdsupplierid;
	}
	
}
