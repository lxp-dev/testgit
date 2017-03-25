package com.pengsheng.eims.member.persistence;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;

public class CustomerVisitPo {

	private String smecvid;// 回访单号ID
	private String smecvsalesid;// 配镜单号
	private String smecvcustomername;// 顾客姓名
	private String smecvfeedbackdate;// 回访日期
	private String smecvcustomertype;// 顾客类型
	private String smecvcontentment;// 顾客满意度
	private String smecvfeedbackcontent;// 反馈内容
	private String smecvresolvent;// 解决方法
	private String smecvremark;// 备注
	private String smecvpersonid;// 回访接待人ID	
	private String smecvpersonname;//回访人姓名	
	private String smecvreturntype;//回访类型	
	private String smecvfeedbackdatestart;//回访开始时间
	private String smecvfeedbackdateend;//回访结束时间	
	private String smecvpersonphone;//联系电话
	private String smecvmemberid;//会员卡号
	private String smecvsalestime;//销售时间
	private String smecvtaketiome;//取镜时间
	private String smecvcontentmentname;//满意度名称
	private String smecvcontent; //短信内容	
	private String smecvssd;//配适度
	private String smecvcprzd;//产品认知度
	private String smecvzcxz;//再次选择	
	private String smeciaddress ;
	private String smeciarea1   ;
	private String smeciarea2   ;
	private String smeciarea3   ;
	private String smeciarea4   ;
	private String smeciarea5   ;
	
	public String getSmeciaddress() {
		return smeciaddress;
	}

	public void setSmeciaddress(String smeciaddress) {
		this.smeciaddress = smeciaddress;
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

	private List<DepartmentsPo> smecishoplist; // 相同公司的部门
	
	public List<DepartmentsPo> getSmecishoplist() {
		return smecishoplist;
	}

	public void setSmecishoplist(List<DepartmentsPo> smecishoplist) {
		this.smecishoplist = smecishoplist;
	}

	public String getSmecvssd() {
		return smecvssd;
	}

	public void setSmecvssd(String smecvssd) {
		this.smecvssd = smecvssd;
	}

	public String getSmecvcprzd() {
		return smecvcprzd;
	}

	public void setSmecvcprzd(String smecvcprzd) {
		this.smecvcprzd = smecvcprzd;
	}

	public String getSmecvzcxz() {
		return smecvzcxz;
	}

	public void setSmecvzcxz(String smecvzcxz) {
		this.smecvzcxz = smecvzcxz;
	}

	private String salsepersonname;
	private String huifangcishu;
	private String salestype;
	public String getSalsepersonname() {
		return salsepersonname;
	}

	public void setSalsepersonname(String salsepersonname) {
		this.salsepersonname = salsepersonname;
	}

	public String getHuifangcishu() {
		return huifangcishu;
	}

	public void setHuifangcishu(String huifangcishu) {
		this.huifangcishu = huifangcishu;
	}

	public String getSalestype() {
		return salestype;
	}

	public void setSalestype(String salestype) {
		this.salestype = salestype;
	}

	public String getSmecvcontent() {
		return smecvcontent;
	}

	public void setSmecvcontent(String smecvcontent) {
		this.smecvcontent = smecvcontent;
	}

	private String sopoypersonid;//满意度名称
	
	private String smecishopcode; // 店号
	private String smeciagemin;//查询条件  年龄上限
	private String smeciagemax;//查询条件  年龄下限
	private String smecimemberid; // 会员卡号
	
	private String smeciname; // 姓名
	private String smecisex; // 性别
	private String smeciphone; // 联系电话
	
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

	public String getSmecishopcode() {
		return smecishopcode;
	}

	public void setSmecishopcode(String smecishopcode) {
		this.smecishopcode = smecishopcode;
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

	public String getSmecimemberid() {
		return smecimemberid;
	}

	public void setSmecimemberid(String smecimemberid) {
		this.smecimemberid = smecimemberid;
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

	public String getSmeciphone() {
		return smeciphone;
	}

	public void setSmeciphone(String smeciphone) {
		this.smeciphone = smeciphone;
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

	public String getSmecvpersonname() {
		return smecvpersonname;
	}

	public void setSmecvpersonname(String smecvpersonname) {
		this.smecvpersonname = smecvpersonname;
	}

	public String getSopoypersonid() {
		return sopoypersonid;
	}

	public void setSopoypersonid(String sopoypersonid) {
		this.sopoypersonid = sopoypersonid;
	}

	public String getSmecvpersonphone() {
		return smecvpersonphone;
	}

	public void setSmecvpersonphone(String smecvpersonphone) {
		this.smecvpersonphone = smecvpersonphone;
	}

	public String getSmecvmemberid() {
		return smecvmemberid;
	}

	public void setSmecvmemberid(String smecvmemberid) {
		this.smecvmemberid = smecvmemberid;
	}

	public String getSmecvsalestime() {
		return smecvsalestime;
	}

	public void setSmecvsalestime(String smecvsalestime) {
		this.smecvsalestime = smecvsalestime;
	}

	public String getSmecvtaketiome() {
		return smecvtaketiome;
	}

	public void setSmecvtaketiome(String smecvtaketiome) {
		this.smecvtaketiome = smecvtaketiome;
	}

	public String getSmecvcontentmentname() {
		return smecvcontentmentname;
	}

	public void setSmecvcontentmentname(String smecvcontentmentname) {
		this.smecvcontentmentname = smecvcontentmentname;
	}

	public String getSmecvfeedbackdatestart() {
		return smecvfeedbackdatestart;
	}

	public void setSmecvfeedbackdatestart(String smecvfeedbackdatestart) {
		this.smecvfeedbackdatestart = smecvfeedbackdatestart;
	}

	public String getSmecvfeedbackdateend() {
		return smecvfeedbackdateend;
	}

	public void setSmecvfeedbackdateend(String smecvfeedbackdateend) {
		this.smecvfeedbackdateend = smecvfeedbackdateend;
	}

	public String getSmecvid() {
		return smecvid;
	}

	public void setSmecvid(String smecvid) {
		this.smecvid = smecvid;
	}

	public String getSmecvsalesid() {
		return smecvsalesid;
	}

	public void setSmecvsalesid(String smecvsalesid) {
		this.smecvsalesid = smecvsalesid;
	}

	public String getSmecvcustomername() {
		return smecvcustomername;
	}

	public void setSmecvcustomername(String smecvcustomername) {
		this.smecvcustomername = smecvcustomername;
	}

	public String getSmecvfeedbackdate() {
		return smecvfeedbackdate;
	}

	public void setSmecvfeedbackdate(String smecvfeedbackdate) {
		this.smecvfeedbackdate = smecvfeedbackdate;
	}

	public String getSmecvcustomertype() {
		return smecvcustomertype;
	}

	public void setSmecvcustomertype(String smecvcustomertype) {
		this.smecvcustomertype = smecvcustomertype;
	}

	public String getSmecvcontentment() {
		return smecvcontentment;
	}

	public void setSmecvcontentment(String smecvcontentment) {
		this.smecvcontentment = smecvcontentment;
	}

	public String getSmecvfeedbackcontent() {
		return smecvfeedbackcontent;
	}

	public void setSmecvfeedbackcontent(String smecvfeedbackcontent) {
		this.smecvfeedbackcontent = smecvfeedbackcontent;
	}

	public String getSmecvresolvent() {
		return smecvresolvent;
	}

	public void setSmecvresolvent(String smecvresolvent) {
		this.smecvresolvent = smecvresolvent;
	}

	public String getSmecvremark() {
		return smecvremark;
	}

	public void setSmecvremark(String smecvremark) {
		this.smecvremark = smecvremark;
	}

	public String getSmecvpersonid() {
		return smecvpersonid;
	}

	public void setSmecvpersonid(String smecvpersonid) {
		this.smecvpersonid = smecvpersonid;
	}

	public String getSmecvreturntype() {
		return smecvreturntype;
	}

	public void setSmecvreturntype(String smecvreturntype) {
		this.smecvreturntype = smecvreturntype;
	}
	

}
