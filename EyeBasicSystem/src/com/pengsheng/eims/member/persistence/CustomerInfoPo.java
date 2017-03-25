package com.pengsheng.eims.member.persistence;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;

public class CustomerInfoPo {

	private String smecicustomerid; // 顾客号

	private String smeciname;       // 姓名

	private String smecisex;        // 性别

	private String smecibirthday;   // 生日

	private String smeciemail;      // email

	private String smeciaddress;    // 地址

	private String smecizone;       // 区域名称

	private String smecipostcode;   // 邮编

	private String smeciphone;      // 联系电话1
	
	private String smecitjrphone;   //推荐人手机号

	private String smeciphone2;     // 联系电话2

	private String smeciphone3;     // 联系电话3

	private String smecimemberid;   // 会员卡号

	private String smecimemberoldid;	//更新前会员卡号

	private String smeciintegral;   // 积分

	private String smecicardtype;   // 卡片类型

	private String smecishopcode;   // 店号

	private String fmmmembername;   // 会员卡名称

	private String fmmup;           // 积分上限

	private String fmmdown;         // 积分下限

	private String fmmdiscount;     // 折扣

	private String fmmage;          // 年龄

	private String fmmsalesid;      // 销售单号(配镜单号)

	private String smeciregisterdate;// 注册日期

	private String smeciregister;   // 注册人员

	private String smeciupdatedate; // 更新时间

	private String smeciupdater;    // 更新人员

	private String smecicardid;     // 检查充值卡号(新加)

	private String smeciamount;     // 卡内金额(新加)

	private String smeciavailableamount;// 可用金额(新加)

	private String smeciagemin;     // 查询条件 年龄上限

	private String smeciagemax;     // 查询条件 年龄下限

	private String smeciconsumptionnumber; // 消费比数

	private String smeciconsumptionprice; // 消费总金额

	private String smeciopenid;

	private String smeciremark;

	private String salestype;

	private String smeciisfavorable;  // 是否参与优惠活动

	private String persontype;

	private String srStartTime;

	private String srEndTime;

	private String smecifcustomerid;

	private String smecifmemberid;

	private String smecifmemberidname;

	private String smeciflag;             // 停用启用标记
	private String smecigoodscategoryid;  // 可以购买的商品
	private String smeciiscustomerid;     // 验证电话或会员卡号的时候判断是否需要包含会员ID
	private String smeciwork;             // 职业
	private String smeciworkname;         // 职业名称
	private String smeciqqnumber;         // QQ号
	private String smeciinterest;         // 兴趣爱好
	private String smecimemberorigin;     // 来源
	private String smecimemberoriginname; // 来源名称

	private String smecisourcecard;		  //关联卡对应顾客卡号

	private String openid;                // 微信使用的openid
	private String starttime;
	private String endtime;
	private String starttimes;
	private String endtimes;
	private String integralmin;
	private String integralmax;
	private String numbermin;
	private String numbermax;
	private String pricemin;
	private String pricemax;
	private String allpricemin;
	private String allpricemax;
	private String selbspsuppliername;
	private String selcstpsupplierid;
	private String brandName;
	private String brandID;
	private String goodsname;
	private String goodsid;
	private String technologytypeid;
	private String bbdframematerialtype;
	private String bbdmaterialclass;
	private String bbdrefractive;
	private String bbdluminosityclass;
	private String bbdfunctionclass;
	private String bbdusetype;
	private String bbdstealthclass;
	private String phoneflag;

	private String upgradeshopcode;
	private String upgradeperson;

	private String fmmsalesorderid;

	private String smecioptometrydate;     // 验光时间
	private String smecifurtherdate;       // 复验时间
	private String smecioptometrydpt;      // 验光门店

	private String smeidentitycard;        // 身份证
	private String smecimodelworkerscode;  // 劳模证
	
	private String smecipersontype;        // 人群分类ID
	private String smecipersontypename;    // 人群分类名称
	private String salsepersonname;
	private String huifangcishu;
	// ----------用于照片上传 moyongsheng 2012-12-12-18:39
	private String memberPicPath;
	private String rootPath;

	private String smecicustomertype;     // 顾客类型	

	// ----------用于照片上传 moyongsheng 2012-12-12-18:39\
	
	// ----------5级地区 moyongsheng 2014-11-07-------------	
	private String smeciarea1;
	private String smeciarea2;
	private String smeciarea3;
	private String smeciarea4;
	private String smeciarea5;
	private String smeciarea1name;
	private String smeciarea2name;
	private String smeciarea3name;
	private String smeciarea4name;
	private String smeciarea5name;	
	// ----------5级地区 moyongsheng 2014-11-07-------------
	
	private String isnullfcustomerid;//是否是子卡，主卡不为kong
	
	private String ctype;//类型	
	
	private List<DepartmentsPo> smecishoplist; // 相同公司的部门
	
	private String smecitodayjiuzhenid; // HIS中使用的当日就诊号

	public String getSmecitodayjiuzhenid() {
		return smecitodayjiuzhenid;
	}

	public void setSmecitodayjiuzhenid(String smecitodayjiuzhenid) {
		this.smecitodayjiuzhenid = smecitodayjiuzhenid;
	}

	public List<DepartmentsPo> getSmecishoplist() {
		return smecishoplist;
	}

	public void setSmecishoplist(List<DepartmentsPo> smecishoplist) {
		this.smecishoplist = smecishoplist;
	}

	public String getSmeciiscustomerid() {
		return smeciiscustomerid;
	}

	public void setSmeciiscustomerid(String smeciiscustomerid) {
		this.smeciiscustomerid = smeciiscustomerid;
	}

	public String getSmecigoodscategoryid() {
		return smecigoodscategoryid;
	}

	public void setSmecigoodscategoryid(String smecigoodscategoryid) {
		this.smecigoodscategoryid = smecigoodscategoryid;
	}

	public String getSmeciflag() {
		return smeciflag;
	}

	public void setSmeciflag(String smeciflag) {
		this.smeciflag = smeciflag;
	}

	public String getSmecifcustomerid() {
		return smecifcustomerid;
	}

	public void setSmecifcustomerid(String smecifcustomerid) {
		this.smecifcustomerid = smecifcustomerid;
	}

	public String getSmecifmemberidname() {
		return smecifmemberidname;
	}

	public void setSmecifmemberidname(String smecifmemberidname) {
		this.smecifmemberidname = smecifmemberidname;
	}

	public String getSmecifmemberid() {
		return smecifmemberid;
	}

	public void setSmecifmemberid(String smecifmemberid) {
		this.smecifmemberid = smecifmemberid;
	}

	public String getSrStartTime() {
		return srStartTime;
	}

	public void setSrStartTime(String srStartTime) {
		this.srStartTime = srStartTime;
	}

	public String getSrEndTime() {
		return srEndTime;
	}

	public void setSrEndTime(String srEndTime) {
		this.srEndTime = srEndTime;
	}

	public String getPersontype() {
		return persontype;
	}

	public void setPersontype(String persontype) {
		this.persontype = persontype;
	}

	public String getSmeciisfavorable() {
		return smeciisfavorable;
	}

	public void setSmeciisfavorable(String smeciisfavorable) {
		this.smeciisfavorable = smeciisfavorable;
	}

	public String getSalestype() {
		return salestype;
	}

	public void setSalestype(String salestype) {
		this.salestype = salestype;
	}

	public String getSmeciremark() {
		return smeciremark;
	}

	public void setSmeciremark(String smeciremark) {
		this.smeciremark = smeciremark;
	}

	public String getSmeciopenid() {
		return smeciopenid;
	}

	public void setSmeciopenid(String smeciopenid) {
		this.smeciopenid = smeciopenid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}





	public String getHuifangcishu() {
		return huifangcishu;
	}

	public void setHuifangcishu(String huifangcishu) {
		this.huifangcishu = huifangcishu;
	}

	public String getSalsepersonname() {
		return salsepersonname;
	}

	public void setSalsepersonname(String salsepersonname) {
		this.salsepersonname = salsepersonname;
	}

	public String getSmecipersontypename() {
		return smecipersontypename;
	}

	public void setSmecipersontypename(String smecipersontypename) {
		this.smecipersontypename = smecipersontypename;
	}

	public String getSmecipersontype() {
		return smecipersontype;
	}

	public void setSmecipersontype(String smecipersontype) {
		this.smecipersontype = smecipersontype;
	}

	public String getSmeidentitycard() {
		return smeidentitycard;
	}

	public void setSmeidentitycard(String smeidentitycard) {
		this.smeidentitycard = smeidentitycard;
	}

	public String getSmecioptometrydpt() {
		return smecioptometrydpt;
	}

	public void setSmecioptometrydpt(String smecioptometrydpt) {
		this.smecioptometrydpt = smecioptometrydpt;
	}

	public String getSmecioptometrydate() {
		return smecioptometrydate;
	}

	public void setSmecioptometrydate(String smecioptometrydate) {
		this.smecioptometrydate = smecioptometrydate;
	}

	public String getSmecifurtherdate() {
		return smecifurtherdate;
	}

	public void setSmecifurtherdate(String smecifurtherdate) {
		this.smecifurtherdate = smecifurtherdate;
	}

	public String getFmmsalesorderid() {
		return fmmsalesorderid;
	}

	public void setFmmsalesorderid(String fmmsalesorderid) {
		this.fmmsalesorderid = fmmsalesorderid;
	}

	public String getSmecisourcecard() {
		return smecisourcecard;
	}

	public void setSmecisourcecard(String smecisourcecard) {
		this.smecisourcecard = smecisourcecard;
	}

	public String getUpgradeshopcode() {
		return upgradeshopcode;
	}

	public String getSmeciphone2() {
		return smeciphone2;
	}

	public void setSmeciphone2(String smeciphone2) {
		this.smeciphone2 = smeciphone2;
	}

	public String getSmeciphone3() {
		return smeciphone3;
	}

	public void setSmeciphone3(String smeciphone3) {
		this.smeciphone3 = smeciphone3;
	}

	public void setUpgradeshopcode(String upgradeshopcode) {
		this.upgradeshopcode = upgradeshopcode;
	}

	public String getUpgradeperson() {
		return upgradeperson;
	}

	public void setUpgradeperson(String upgradeperson) {
		this.upgradeperson = upgradeperson;
	}

	public String getPhoneflag() {
		return phoneflag;
	}

	public void setPhoneflag(String phoneflag) {
		this.phoneflag = phoneflag;
	}



	public String getMemberPicPath() {
		return memberPicPath;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public void setMemberPicPath(String memberPicPath) {
		this.memberPicPath = memberPicPath;
	}

	public String getSmeciconsumptionnumber() {
		return smeciconsumptionnumber;
	}

	public void setSmeciconsumptionnumber(String smeciconsumptionnumber) {
		this.smeciconsumptionnumber = smeciconsumptionnumber;
	}

	public String getSmeciconsumptionprice() {
		return smeciconsumptionprice;
	}

	public void setSmeciconsumptionprice(String smeciconsumptionprice) {
		this.smeciconsumptionprice = smeciconsumptionprice;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getStarttimes() {
		return starttimes;
	}

	public void setStarttimes(String starttimes) {
		this.starttimes = starttimes;
	}

	public String getEndtimes() {
		return endtimes;
	}

	public void setEndtimes(String endtimes) {
		this.endtimes = endtimes;
	}

	public String getIntegralmin() {
		return integralmin;
	}

	public void setIntegralmin(String integralmin) {
		this.integralmin = integralmin;
	}

	public String getIntegralmax() {
		return integralmax;
	}

	public void setIntegralmax(String integralmax) {
		this.integralmax = integralmax;
	}

	public String getNumbermin() {
		return numbermin;
	}

	public void setNumbermin(String numbermin) {
		this.numbermin = numbermin;
	}

	public String getNumbermax() {
		return numbermax;
	}

	public void setNumbermax(String numbermax) {
		this.numbermax = numbermax;
	}

	public String getPricemin() {
		return pricemin;
	}

	public void setPricemin(String pricemin) {
		this.pricemin = pricemin;
	}

	public String getPricemax() {
		return pricemax;
	}

	public void setPricemax(String pricemax) {
		this.pricemax = pricemax;
	}

	public String getAllpricemin() {
		return allpricemin;
	}

	public void setAllpricemin(String allpricemin) {
		this.allpricemin = allpricemin;
	}

	public String getAllpricemax() {
		return allpricemax;
	}

	public void setAllpricemax(String allpricemax) {
		this.allpricemax = allpricemax;
	}

	public String getSelbspsuppliername() {
		return selbspsuppliername;
	}

	public void setSelbspsuppliername(String selbspsuppliername) {
		this.selbspsuppliername = selbspsuppliername;
	}

	public String getSelcstpsupplierid() {
		return selcstpsupplierid;
	}

	public void setSelcstpsupplierid(String selcstpsupplierid) {
		this.selcstpsupplierid = selcstpsupplierid;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandID() {
		return brandID;
	}

	public void setBrandID(String brandID) {
		this.brandID = brandID;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getTechnologytypeid() {
		return technologytypeid;
	}

	public void setTechnologytypeid(String technologytypeid) {
		this.technologytypeid = technologytypeid;
	}

	public String getBbdframematerialtype() {
		return bbdframematerialtype;
	}

	public void setBbdframematerialtype(String bbdframematerialtype) {
		this.bbdframematerialtype = bbdframematerialtype;
	}

	public String getBbdmaterialclass() {
		return bbdmaterialclass;
	}

	public void setBbdmaterialclass(String bbdmaterialclass) {
		this.bbdmaterialclass = bbdmaterialclass;
	}

	public String getBbdrefractive() {
		return bbdrefractive;
	}

	public void setBbdrefractive(String bbdrefractive) {
		this.bbdrefractive = bbdrefractive;
	}

	public String getBbdluminosityclass() {
		return bbdluminosityclass;
	}

	public void setBbdluminosityclass(String bbdluminosityclass) {
		this.bbdluminosityclass = bbdluminosityclass;
	}

	public String getBbdfunctionclass() {
		return bbdfunctionclass;
	}

	public void setBbdfunctionclass(String bbdfunctionclass) {
		this.bbdfunctionclass = bbdfunctionclass;
	}

	public String getBbdusetype() {
		return bbdusetype;
	}

	public void setBbdusetype(String bbdusetype) {
		this.bbdusetype = bbdusetype;
	}

	public String getBbdstealthclass() {
		return bbdstealthclass;
	}

	public void setBbdstealthclass(String bbdstealthclass) {
		this.bbdstealthclass = bbdstealthclass;
	}

	public String getSmecicustomertype() {
		return smecicustomertype;
	}

	public void setSmecicustomertype(String smecicustomertype) {
		this.smecicustomertype = smecicustomertype;
	}

	public String getSmeciwork() {
		return smeciwork;
	}

	public void setSmeciwork(String smeciwork) {
		this.smeciwork = smeciwork;
	}

	public String getSmeciqqnumber() {
		return smeciqqnumber;
	}

	public void setSmeciqqnumber(String smeciqqnumber) {
		this.smeciqqnumber = smeciqqnumber;
	}

	public String getSmeciinterest() {
		return smeciinterest;
	}

	public void setSmeciinterest(String smeciinterest) {
		this.smeciinterest = smeciinterest;
	}

	public String getSmecimemberorigin() {
		return smecimemberorigin;
	}

	public void setSmecimemberorigin(String smecimemberorigin) {
		this.smecimemberorigin = smecimemberorigin;
	}

	public String getSmeciworkname() {
		return smeciworkname;
	}

	public void setSmeciworkname(String smeciworkname) {
		this.smeciworkname = smeciworkname;
	}

	public String getSmecimemberoriginname() {
		return smecimemberoriginname;
	}

	public void setSmecimemberoriginname(String smecimemberoriginname) {
		this.smecimemberoriginname = smecimemberoriginname;
	}


	public String getSmeciagemin() {
		return smeciagemin;
	}

	public void setSmeciagemin(String smeciagemin) {
		this.smeciagemin = smeciagemin;
	}

	public String getSmeciagemax() {
		return smeciagemax;
	}

	public void setSmeciagemax(String smeciagemax) {
		this.smeciagemax = smeciagemax;
	}

	public String getSmeciregisterdate() {
		return smeciregisterdate;
	}

	public void setSmeciregisterdate(String smeciregisterdate) {
		this.smeciregisterdate = smeciregisterdate;
	}

	public String getSmeciregister() {
		return smeciregister;
	}

	public void setSmeciregister(String smeciregister) {
		this.smeciregister = smeciregister;
	}

	public String getSmeciupdatedate() {
		return smeciupdatedate;
	}

	public void setSmeciupdatedate(String smeciupdatedate) {
		this.smeciupdatedate = smeciupdatedate;
	}

	public String getSmeciupdater() {
		return smeciupdater;
	}

	public void setSmeciupdater(String smeciupdater) {
		this.smeciupdater = smeciupdater;
	}

	public String getSmecicardid() {
		return smecicardid;
	}

	public void setSmecicardid(String smecicardid) {
		this.smecicardid = smecicardid;
	}

	public String getSmeciamount() {
		return smeciamount;
	}

	public void setSmeciamount(String smeciamount) {
		this.smeciamount = smeciamount;
	}

	public String getSmeciavailableamount() {
		return smeciavailableamount;
	}

	public void setSmeciavailableamount(String smeciavailableamount) {
		this.smeciavailableamount = smeciavailableamount;
	}

	public String getFmmsalesid() {
		return fmmsalesid;
	}

	public void setFmmsalesid(String fmmsalesid) {
		this.fmmsalesid = fmmsalesid;
	}

	public String getSmeciname() {
		return smeciname;
	}

	public void setSmeciname(String smeciname) {
		this.smeciname = smeciname;
	}

	public String getSmecisex() {
		return smecisex;
	}

	public void setSmecisex(String smecisex) {
		this.smecisex = smecisex;
	}

	public String getSmeciemail() {
		return smeciemail;
	}

	public void setSmeciemail(String smeciemail) {
		this.smeciemail = smeciemail;
	}

	public String getSmeciaddress() {
		return smeciaddress;
	}

	public void setSmeciaddress(String smeciaddress) {
		this.smeciaddress = smeciaddress;
	}

	public String getSmecizone() {
		return smecizone;
	}

	public void setSmecizone(String smecizone) {
		this.smecizone = smecizone;
	}

	public String getSmecipostcode() {
		return smecipostcode;
	}

	public void setSmecipostcode(String smecipostcode) {
		this.smecipostcode = smecipostcode;
	}

	public String getSmeciphone() {
		return smeciphone;
	}

	public void setSmeciphone(String smeciphone) {
		this.smeciphone = smeciphone;
	}

	public String getSmecimemberid() {
		return smecimemberid;
	}

	public void setSmecimemberid(String smecimemberid) {
		this.smecimemberid = smecimemberid;
	}

	public String getSmeciintegral() {
		return smeciintegral;
	}

	public void setSmeciintegral(String smeciintegral) {
		this.smeciintegral = smeciintegral;
	}

	public String getSmecicardtype() {
		return smecicardtype;
	}

	public void setSmecicardtype(String smecicardtype) {
		this.smecicardtype = smecicardtype;
	}

	public String getSmecishopcode() {
		return smecishopcode;
	}

	public void setSmecishopcode(String smecishopcode) {
		this.smecishopcode = smecishopcode;
	}

	public String getSmecicustomerid() {
		return smecicustomerid;
	}

	public void setSmecicustomerid(String smecicustomerid) {
		this.smecicustomerid = smecicustomerid;
	}

	public String getFmmmembername() {
		return fmmmembername;
	}

	public void setFmmmembername(String fmmmembername) {
		this.fmmmembername = fmmmembername;
	}

	public String getFmmup() {
		return fmmup;
	}

	public void setFmmup(String fmmup) {
		this.fmmup = fmmup;
	}

	public String getFmmdown() {
		return fmmdown;
	}

	public void setFmmdown(String fmmdown) {
		this.fmmdown = fmmdown;
	}

	public String getFmmdiscount() {
		return fmmdiscount;
	}

	public void setFmmdiscount(String fmmdiscount) {
		this.fmmdiscount = fmmdiscount;
	}

	public String getSmecibirthday() {
		return smecibirthday;
	}

	public void setSmecibirthday(String smecibirthday) {
		this.smecibirthday = smecibirthday;
	}

	public String getFmmage() {
		return fmmage;
	}

	public void setFmmage(String fmmage) {
		this.fmmage = fmmage;
	}

	public String getSmecimodelworkerscode() {
		return smecimodelworkerscode;
	}

	public void setSmecimodelworkerscode(String smecimodelworkerscode) {
		this.smecimodelworkerscode = smecimodelworkerscode;
	}

	public String getSmeciarea1() {
		return smeciarea1;
	}

	public void setSmeciarea1(String smeciarea1) {
		this.smeciarea1 = smeciarea1;
	}

	public String getSmeciarea2() {
		return smeciarea2;
	}

	public void setSmeciarea2(String smeciarea2) {
		this.smeciarea2 = smeciarea2;
	}

	public String getSmeciarea3() {
		return smeciarea3;
	}

	public void setSmeciarea3(String smeciarea3) {
		this.smeciarea3 = smeciarea3;
	}

	public String getSmeciarea4() {
		return smeciarea4;
	}

	public void setSmeciarea4(String smeciarea4) {
		this.smeciarea4 = smeciarea4;
	}

	public String getSmeciarea5() {
		return smeciarea5;
	}

	public void setSmeciarea5(String smeciarea5) {
		this.smeciarea5 = smeciarea5;
	}

	public String getSmeciarea1name() {
		return smeciarea1name;
	}

	public void setSmeciarea1name(String smeciarea1name) {
		this.smeciarea1name = smeciarea1name;
	}

	public String getSmeciarea2name() {
		return smeciarea2name;
	}

	public void setSmeciarea2name(String smeciarea2name) {
		this.smeciarea2name = smeciarea2name;
	}

	public String getSmeciarea3name() {
		return smeciarea3name;
	}

	public void setSmeciarea3name(String smeciarea3name) {
		this.smeciarea3name = smeciarea3name;
	}

	public String getSmeciarea4name() {
		return smeciarea4name;
	}

	public void setSmeciarea4name(String smeciarea4name) {
		this.smeciarea4name = smeciarea4name;
	}

	public String getSmeciarea5name() {
		return smeciarea5name;
	}

	public void setSmeciarea5name(String smeciarea5name) {
		this.smeciarea5name = smeciarea5name;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getSmecimemberoldid() {
		return smecimemberoldid;
	}

	public void setSmecimemberoldid(String smecimemberoldid) {
		this.smecimemberoldid = smecimemberoldid;
	}

	public String getSmecitjrphone() {
		return smecitjrphone;
	}

	public void setSmecitjrphone(String smecitjrphone) {
		this.smecitjrphone = smecitjrphone;
	}

	public String getIsnullfcustomerid() {
		return isnullfcustomerid;
	}

	public void setIsnullfcustomerid(String isnullfcustomerid) {
		this.isnullfcustomerid = isnullfcustomerid;
	}
	
	
}
