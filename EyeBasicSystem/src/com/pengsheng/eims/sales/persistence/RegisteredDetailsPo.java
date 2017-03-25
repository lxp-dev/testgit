package com.pengsheng.eims.sales.persistence;

public class RegisteredDetailsPo {
	private String scrrdid;				// 主键

	private String scrrddetailsid;		// 挂号流水号

	private String scrrdcustomerid;		// 会员号

	private String scrrdshopcode;		// 店号

	private String scrrdregisterid;		// 挂号类别ID

	private String scrrdregistername; 	// 挂号类别名称

	private String scrrdflag;			// 收费标志

	private String scrrdmoney;			// 挂号金额

	private String scrrdpersonsumtoday;			// 当日个人挂号金额汇总

	private String scrrdoptdate;		// 挂号时间

	private String scrrdregister;		// 挂号人
	
	private String scrrdcreatename;		// 挂号人姓名

	private String scrrdcasher; 		// 收银人
	
	private String scrrdcashername;		//收银人名称
	
	private String scrrdcasherdate;		// 收银时间
	
	private String scrrdamounttype;		// 检查分类
	
	private String scrrdcheckperson;	// 检查人
	
	private String scrrdcheckpersonname;	// 检查人

	private String[] chk;				// 获取数组ID
	
	private String scrrdcasherbgndate;		// 收银起始时间	
	private String scrrdcasherenddate;		// 收银截止时间
	
	private String[] scrrdids;				// 主键

	private String[] scrrddetailsids;		// 挂号流水号

	private String[] scrrdcustomerids;		// 会员号

	private String[] scrrdshopcodes;		// 店号

	private String[] scrrdregisterids;		// 挂号类别ID

	private String[] scrrdregisternames; 	// 挂号类别名称

	private String[] scrrdflags;			// 收费标志

	private String[] scrrdmoneys;			// 挂号金额

	private String[] scrrdpersonsumtodays;			// 当日个人挂号金额汇总

	private String[] scrrdoptdates;		// 挂号时间

	private String[] scrrdregisters;		// 挂号人

	private String[] scrrdcashers; 		// 收银人
	
	private String[] scrrdcashernames;		//收银人名称
	
	private String[] scrrdcasherdates;		// 收银时间
	
	private String[] scrrdamounttypes;		// 检查分类
	
	private String[] scrrdcheckpersons;	// 检查人
	
	private String[] scrrdcheckpersonnames;	// 检查人
	
	private String scrrdpayfeeid;		// 收费项目ID
	private String scrrdpayfeeno;		// 挂号待交费序号
	
	public String getScrrdpayfeeid() {
		return scrrdpayfeeid;
	}

	public void setScrrdpayfeeid(String scrrdpayfeeid) {
		this.scrrdpayfeeid = scrrdpayfeeid;
	}

	public String getScrrdpayfeeno() {
		return scrrdpayfeeno;
	}

	public void setScrrdpayfeeno(String scrrdpayfeeno) {
		this.scrrdpayfeeno = scrrdpayfeeno;
	}

	public String getScrrdcreatename() {
		return scrrdcreatename;
	}

	public void setScrrdcreatename(String scrrdcreatename) {
		this.scrrdcreatename = scrrdcreatename;
	}

	public String[] getScrrdids() {
		return scrrdids;
	}

	public void setScrrdids(String[] scrrdids) {
		this.scrrdids = scrrdids;
	}

	public String[] getScrrddetailsids() {
		return scrrddetailsids;
	}

	public void setScrrddetailsids(String[] scrrddetailsids) {
		this.scrrddetailsids = scrrddetailsids;
	}

	public String[] getScrrdcustomerids() {
		return scrrdcustomerids;
	}

	public void setScrrdcustomerids(String[] scrrdcustomerids) {
		this.scrrdcustomerids = scrrdcustomerids;
	}

	public String[] getScrrdshopcodes() {
		return scrrdshopcodes;
	}

	public void setScrrdshopcodes(String[] scrrdshopcodes) {
		this.scrrdshopcodes = scrrdshopcodes;
	}

	public String[] getScrrdregisterids() {
		return scrrdregisterids;
	}

	public void setScrrdregisterids(String[] scrrdregisterids) {
		this.scrrdregisterids = scrrdregisterids;
	}

	public String[] getScrrdregisternames() {
		return scrrdregisternames;
	}

	public void setScrrdregisternames(String[] scrrdregisternames) {
		this.scrrdregisternames = scrrdregisternames;
	}

	public String[] getScrrdflags() {
		return scrrdflags;
	}

	public void setScrrdflags(String[] scrrdflags) {
		this.scrrdflags = scrrdflags;
	}

	public String[] getScrrdmoneys() {
		return scrrdmoneys;
	}

	public void setScrrdmoneys(String[] scrrdmoneys) {
		this.scrrdmoneys = scrrdmoneys;
	}

	public String[] getScrrdpersonsumtodays() {
		return scrrdpersonsumtodays;
	}

	public void setScrrdpersonsumtodays(String[] scrrdpersonsumtodays) {
		this.scrrdpersonsumtodays = scrrdpersonsumtodays;
	}

	public String[] getScrrdoptdates() {
		return scrrdoptdates;
	}

	public void setScrrdoptdates(String[] scrrdoptdates) {
		this.scrrdoptdates = scrrdoptdates;
	}

	public String[] getScrrdregisters() {
		return scrrdregisters;
	}

	public void setScrrdregisters(String[] scrrdregisters) {
		this.scrrdregisters = scrrdregisters;
	}

	public String[] getScrrdcashers() {
		return scrrdcashers;
	}

	public void setScrrdcashers(String[] scrrdcashers) {
		this.scrrdcashers = scrrdcashers;
	}

	public String[] getScrrdcashernames() {
		return scrrdcashernames;
	}

	public void setScrrdcashernames(String[] scrrdcashernames) {
		this.scrrdcashernames = scrrdcashernames;
	}

	public String[] getScrrdcasherdates() {
		return scrrdcasherdates;
	}

	public void setScrrdcasherdates(String[] scrrdcasherdates) {
		this.scrrdcasherdates = scrrdcasherdates;
	}

	public String[] getScrrdamounttypes() {
		return scrrdamounttypes;
	}

	public void setScrrdamounttypes(String[] scrrdamounttypes) {
		this.scrrdamounttypes = scrrdamounttypes;
	}

	public String[] getScrrdcheckpersons() {
		return scrrdcheckpersons;
	}

	public void setScrrdcheckpersons(String[] scrrdcheckpersons) {
		this.scrrdcheckpersons = scrrdcheckpersons;
	}

	public String[] getScrrdcheckpersonnames() {
		return scrrdcheckpersonnames;
	}

	public void setScrrdcheckpersonnames(String[] scrrdcheckpersonnames) {
		this.scrrdcheckpersonnames = scrrdcheckpersonnames;
	}

	public String getScrrdcasherbgndate() {
		return scrrdcasherbgndate;
	}

	public void setScrrdcasherbgndate(String scrrdcasherbgndate) {
		this.scrrdcasherbgndate = scrrdcasherbgndate;
	}

	public String getScrrdcasherenddate() {
		return scrrdcasherenddate;
	}

	public void setScrrdcasherenddate(String scrrdcasherenddate) {
		this.scrrdcasherenddate = scrrdcasherenddate;
	}

	public String getScrrdcheckpersonname() {
		return scrrdcheckpersonname;
	}

	public void setScrrdcheckpersonname(String scrrdcheckpersonname) {
		this.scrrdcheckpersonname = scrrdcheckpersonname;
	}

	public String getScrrdamounttype() {
		return scrrdamounttype;
	}

	public void setScrrdamounttype(String scrrdamounttype) {
		this.scrrdamounttype = scrrdamounttype;
	}

	public String getScrrdcheckperson() {
		return scrrdcheckperson;
	}

	public void setScrrdcheckperson(String scrrdcheckperson) {
		this.scrrdcheckperson = scrrdcheckperson;
	}

	public String getScrrdcashername() {
		return scrrdcashername;
	}

	public void setScrrdcashername(String scrrdcashername) {
		this.scrrdcashername = scrrdcashername;
	}

	
	public String getScrrdid() {
		return scrrdid;
	}

	public void setScrrdid(String scrrdid) {
		this.scrrdid = scrrdid;
	}

	public String getScrrddetailsid() {
		return scrrddetailsid;
	}

	public void setScrrddetailsid(String scrrddetailsid) {
		this.scrrddetailsid = scrrddetailsid;
	}

	public String getScrrdcustomerid() {
		return scrrdcustomerid;
	}

	public void setScrrdcustomerid(String scrrdcustomerid) {
		this.scrrdcustomerid = scrrdcustomerid;
	}

	public String getScrrdshopcode() {
		return scrrdshopcode;
	}

	public void setScrrdshopcode(String scrrdshopcode) {
		this.scrrdshopcode = scrrdshopcode;
	}

	public String getScrrdregisterid() {
		return scrrdregisterid;
	}

	public void setScrrdregisterid(String scrrdregisterid) {
		this.scrrdregisterid = scrrdregisterid;
	}

	public String getScrrdregistername() {
		return scrrdregistername;
	}

	public void setScrrdregistername(String scrrdregistername) {
		this.scrrdregistername = scrrdregistername;
	}

	public String getScrrdflag() {
		return scrrdflag;
	}

	public void setScrrdflag(String scrrdflag) {
		this.scrrdflag = scrrdflag;
	}

	public String getScrrdmoney() {
		return scrrdmoney;
	}

	public void setScrrdmoney(String scrrdmoney) {
		this.scrrdmoney = scrrdmoney;
	}

	public String getScrrdoptdate() {
		return scrrdoptdate;
	}

	public void setScrrdoptdate(String scrrdoptdate) {
		this.scrrdoptdate = scrrdoptdate;
	}

	public String getScrrdregister() {
		return scrrdregister;
	}

	public void setScrrdregister(String scrrdregister) {
		this.scrrdregister = scrrdregister;
	}

	public String getScrrdcasher() {
		return scrrdcasher;
	}

	public void setScrrdcasher(String scrrdcasher) {
		this.scrrdcasher = scrrdcasher;
	}

	public String getScrrdcasherdate() {
		return scrrdcasherdate;
	}

	public void setScrrdcasherdate(String scrrdcasherdate) {
		this.scrrdcasherdate = scrrdcasherdate;
	}

	public String[] getChk() {
		return chk;
	}

	public void setChk(String[] chk) {
		this.chk = chk;
	}

	public String getScrrdpersonsumtoday() {
		return scrrdpersonsumtoday;
	}

	public void setScrrdpersonsumtoday(String scrrdpersonsumtoday) {
		this.scrrdpersonsumtoday = scrrdpersonsumtoday;
	}

}
