package com.pengsheng.eims.system.persistence;

import java.util.List;

public class PersonInfoPo {

	private String id;// 工号

	private String password;// 密码

	private String personName;// 中文姓名

	private String departmentID;// 部门

	private String userState;// 当前状态0:正常 1:删除

	private String phone;// 电话

	private String sex;// 性别： 1：男 2：女

	private String email;// 邮箱

	private String address;// 地址

	private String roleid;// 角色ID

	private String rolename;// 角色名称

	private String bdpdepartmentname;//部门名称

	private String moduleapplicationid;// 角色应用ID

	private String departmenttype;// 部门类型:门店：1 区域（加工中心）：2 仓储：3

	private String outsourcingFlag; // 委外提醒

	private String allocationFlag; // 调拨提醒

	private String machinery;// 机器识别号
	
	private String personDiscount;//员工打折
	
	private String orderid;
	
	private String orderpassword;
	
	private String cardid;//员工卡id--刷卡登录
	
	private String isinvocation; //启用状态
	
	private String fpdspecialdiscountnumber;//特殊打折次数
	
	private String fpdspecialdiscount;//特殊打折
	
	private String departmentCount;
	private	String	updatepersonid	;		//修改人
	private	String	updatepersonname	;			//修改人姓名
	
	private	String	mctbasicsalary;			//基本工资
	private	String	mctattendanceaward;		//全勤奖
	private	String	mctdutyallowance;		//职务津贴
	private	String	mctsubsidy;				//补助
	private	String	mcthousingreserve;		//住房公积金
	private	String	mctpersonalsecurity;	//个人社保
	private	String	mctyearendbonus	;		//年终奖
	
	private String firstViewDate;
	private String lastViewDate;
	private String whichretail;
	
	private String checkMac;
	private String goodslevel;
	private String dptsalestype;
	
	private String personjobtype;			//员工职能类型
	private String personcompanyid;			//所属公司id
	private String personcompanyname;		//所属公司名称
	private String personcompanytype;		//1、总公司  2、分公司
	private List<PersonDiscountDetailsPo> personDiscountDetailsPos;

	private String companynature;		//所属公司性质    1.直营    2.加盟

	private String syspsupplierid;			//员工制造商ID
	private String syspsuppliername;		//员工制造商名称
    private String syspsuppliercategoryid;		//员工制造商名称
    private String personcompanyregionid;			//公司区域ID
    private String personcompanycodeid;		//区域编码ID
    
	private String bdplinkhisflag; // 门店是否连接HIS系统
	private String bdplinkhis; // 门店连接的哪个HIS系统ID
	private String bdpnotpayfeeform; // 待收费记录向HIS传递方式
	private String bdpreadcardform; // 读取会员卡的方式
	private String bdpchargingitemid; // 收费项目编号
	private String bdplinkhisurl; // 门店连接的HIS系统的url
    
	public String getBdplinkhisflag() {
		return bdplinkhisflag;
	}

	public void setBdplinkhisflag(String bdplinkhisflag) {
		this.bdplinkhisflag = bdplinkhisflag;
	}

	public String getBdplinkhis() {
		return bdplinkhis;
	}

	public void setBdplinkhis(String bdplinkhis) {
		this.bdplinkhis = bdplinkhis;
	}

	public String getBdpnotpayfeeform() {
		return bdpnotpayfeeform;
	}

	public void setBdpnotpayfeeform(String bdpnotpayfeeform) {
		this.bdpnotpayfeeform = bdpnotpayfeeform;
	}

	public String getBdpreadcardform() {
		return bdpreadcardform;
	}

	public void setBdpreadcardform(String bdpreadcardform) {
		this.bdpreadcardform = bdpreadcardform;
	}

	public String getBdpchargingitemid() {
		return bdpchargingitemid;
	}

	public void setBdpchargingitemid(String bdpchargingitemid) {
		this.bdpchargingitemid = bdpchargingitemid;
	}

	public String getBdplinkhisurl() {
		return bdplinkhisurl;
	}

	public void setBdplinkhisurl(String bdplinkhisurl) {
		this.bdplinkhisurl = bdplinkhisurl;
	}

	public String getPersoncompanycodeid() {
		return personcompanycodeid;
	}

	public void setPersoncompanycodeid(String personcompanycodeid) {
		this.personcompanycodeid = personcompanycodeid;
	}

	public String getPersoncompanyregionid() {
		return personcompanyregionid;
	}

	public void setPersoncompanyregionid(String personcompanyregionid) {
		this.personcompanyregionid = personcompanyregionid;
	}

	public String getCompanynature() {
		return companynature;
	}

	public void setCompanynature(String companynature) {
		this.companynature = companynature;
	}

	public String getSyspsuppliercategoryid() {
		return syspsuppliercategoryid;
	}

	public void setSyspsuppliercategoryid(String syspsuppliercategoryid) {
		this.syspsuppliercategoryid = syspsuppliercategoryid;
	}

	public String getSyspsuppliername() {
		return syspsuppliername;
	}

	public void setSyspsuppliername(String syspsuppliername) {
		this.syspsuppliername = syspsuppliername;
	}

	public String getSyspsupplierid() {
		return syspsupplierid;
	}

	public void setSyspsupplierid(String syspsupplierid) {
		this.syspsupplierid = syspsupplierid;
	}

	public List<PersonDiscountDetailsPo> getPersonDiscountDetailsPos() {
		return personDiscountDetailsPos;
	}

	public void setPersonDiscountDetailsPos(
			List<PersonDiscountDetailsPo> personDiscountDetailsPos) {
		this.personDiscountDetailsPos = personDiscountDetailsPos;
	}

	public String getPersoncompanytype() {
		return personcompanytype;
	}

	public void setPersoncompanytype(String personcompanytype) {
		this.personcompanytype = personcompanytype;
	}

	public String getPersoncompanyname() {
		return personcompanyname;
	}

	public void setPersoncompanyname(String personcompanyname) {
		this.personcompanyname = personcompanyname;
	}

	public String getPersoncompanyid() {
		return personcompanyid;
	}

	public void setPersoncompanyid(String personcompanyid) {
		this.personcompanyid = personcompanyid;
	}

	public String getPersonjobtype() {
		return personjobtype;
	}

	public void setPersonjobtype(String personjobtype) {
		this.personjobtype = personjobtype;
	}

	public String getDptsalestype() {
		return dptsalestype;
	}

	public void setDptsalestype(String dptsalestype) {
		this.dptsalestype = dptsalestype;
	}

	public String getGoodslevel() {
		return goodslevel;
	}

	public void setGoodslevel(String goodslevel) {
		this.goodslevel = goodslevel;
	}

	public String getWhichretail() {
		return whichretail;
	}

	public void setWhichretail(String whichretail) {
		this.whichretail = whichretail;
	}

	public String getFirstViewDate() {
		return firstViewDate;
	}

	public void setFirstViewDate(String firstViewDate) {
		this.firstViewDate = firstViewDate;
	}

	public String getLastViewDate() {
		return lastViewDate;
	}

	public void setLastViewDate(String lastViewDate) {
		this.lastViewDate = lastViewDate;
	}

	public String getDepartmentCount() {
		return departmentCount;
	}

	public void setDepartmentCount(String departmentCount) {
		this.departmentCount = departmentCount;
	}

	public String getFpdspecialdiscountnumber() {
		return fpdspecialdiscountnumber;
	}

	public void setFpdspecialdiscountnumber(String fpdspecialdiscountnumber) {
		this.fpdspecialdiscountnumber = fpdspecialdiscountnumber;
	}

	public String getFpdspecialdiscount() {
		return fpdspecialdiscount;
	}

	public void setFpdspecialdiscount(String fpdspecialdiscount) {
		this.fpdspecialdiscount = fpdspecialdiscount;
	}
	
	public String getIsinvocation() {
		return isinvocation;
	}

	public void setIsinvocation(String isinvocation) {
		this.isinvocation = isinvocation;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOrderpassword() {
		return orderpassword;
	}

	public void setOrderpassword(String orderpassword) {
		this.orderpassword = orderpassword;
	}

	public String getPersonDiscount() {
		return personDiscount;
	}

	public void setPersonDiscount(String personDiscount) {
		this.personDiscount = personDiscount;
	}

	public String getDepartmenttype() {
		return departmenttype;
	}

	public void setDepartmenttype(String departmenttype) {
		this.departmenttype = departmenttype;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getBdpdepartmentname() {
		return bdpdepartmentname;
	}

	public void setBdpdepartmentname(String bdpdepartmentname) {
		this.bdpdepartmentname = bdpdepartmentname;
	}

	public String getModuleapplicationid() {
		return moduleapplicationid;
	}

	public void setModuleapplicationid(String moduleapplicationid) {
		this.moduleapplicationid = moduleapplicationid;
	}

	public String getOutsourcingFlag() {
		return outsourcingFlag;
	}

	public void setOutsourcingFlag(String outsourcingFlag) {
		this.outsourcingFlag = outsourcingFlag;
	}

	public String getAllocationFlag() {
		return allocationFlag;
	}

	public void setAllocationFlag(String allocationFlag) {
		this.allocationFlag = allocationFlag;
	}

	public String getMachinery() {
		return machinery;
	}

	public void setMachinery(String machinery) {
		this.machinery = machinery;
	}

	public String getUpdatepersonid() {
		return updatepersonid;
	}

	public void setUpdatepersonid(String updatepersonid) {
		this.updatepersonid = updatepersonid;
	}

	public String getUpdatepersonname() {
		return updatepersonname;
	}

	public void setUpdatepersonname(String updatepersonname) {
		this.updatepersonname = updatepersonname;
	}

	public String getMctbasicsalary() {
		return mctbasicsalary;
	}

	public void setMctbasicsalary(String mctbasicsalary) {
		this.mctbasicsalary = mctbasicsalary;
	}

	public String getMctattendanceaward() {
		return mctattendanceaward;
	}

	public void setMctattendanceaward(String mctattendanceaward) {
		this.mctattendanceaward = mctattendanceaward;
	}

	public String getMctdutyallowance() {
		return mctdutyallowance;
	}

	public void setMctdutyallowance(String mctdutyallowance) {
		this.mctdutyallowance = mctdutyallowance;
	}

	public String getMctsubsidy() {
		return mctsubsidy;
	}

	public void setMctsubsidy(String mctsubsidy) {
		this.mctsubsidy = mctsubsidy;
	}

	public String getMcthousingreserve() {
		return mcthousingreserve;
	}

	public void setMcthousingreserve(String mcthousingreserve) {
		this.mcthousingreserve = mcthousingreserve;
	}

	public String getMctpersonalsecurity() {
		return mctpersonalsecurity;
	}

	public void setMctpersonalsecurity(String mctpersonalsecurity) {
		this.mctpersonalsecurity = mctpersonalsecurity;
	}

	public String getMctyearendbonus() {
		return mctyearendbonus;
	}

	public void setMctyearendbonus(String mctyearendbonus) {
		this.mctyearendbonus = mctyearendbonus;
	}

	public String getCheckMac() {
		return checkMac;
	}

	public void setCheckMac(String checkMac) {
		this.checkMac = checkMac;
	}
}
