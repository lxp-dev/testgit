package com.pengsheng.eims.system.persistence;

public class SendNotePo {

	private String snpersonid;                   // 发送人工号
	private String snpersonname;                 // 发送人姓名
	private String sndepartmentid;               // 发送部门编号
	private String sndepartmentname;             // 发送部门名称
	private String sncreatedate;                 // 新增短信时间
	private String snsenddate;                   // 发送短信时间
	private String snnotetypeid;                 // 短信类型
	private String snnotecontent;                // 短信内容
	
	private String sncustomerid;                 // 顾客编号
	private String sncustomername;               // 顾客姓名
	private String sncustomertelphone;           // 手机
	private String snsex;                        // 性别
	private String snbirthday;                   // 出生日期	
	private String sncardid;                     // 会员卡类型编号
	private String sncardname;                   // 会员卡类型名称
	private String snsendflag;                   // 发送状态
	
	private String snoptometryshopcode;          // 验光门店编号
	private String snoptometryshopcodename;      // 验光门店名称	
	private String snoptometrydate;              // 验光日期
	private String snfurtherdate;                // 复诊日期		
	private String snfurthershopcode;            // 复诊门店编号
	private String snfurthershopcodename;        // 复诊门店名称	
	
	private String snbillid;                     // 单据编号	
	private String snposdate;                    // 配镜日期
	private String sntakedate;                   // 取镜日期
	private String snshopcode;                   // 销售门店编号
	private String snshopcodename;               // 销售门店名称
	private String snshopcodephone;              // 销售门店电话
	private String sntakeshopcodephone;          // 取镜门店电话
	private String snpsalesprice;                // 实收金额
	private String sncustomprice;                // 订金
	private String snarrearprice;	             // 欠款金额
	private String snchangeprice;                // 变更金额	
	private String sntakeshopcode;               // 取镜门店编号
	private String sntakeshopcodename;           // 取镜门店名称
	private String snshopcodetakedate;           // 门店到镜日期
	
	private String snmailaddress;                // 邮寄地址
	private String snmailbillid;                 // 邮寄单号
	private String snmaildate;                   // 邮寄日期
	private String snmailcompany;                // 邮寄公司
	
	private String sncomplaintdate;              // 投诉日期
	private String sncomplainttype;              // 投诉类型编号
	private String sncomplainttypename;          // 投诉类型名称
	private String sncomplainthandledate;        // 投诉处理日期
	private String sncomplainthandletype;        // 投诉处理类型编号
	private String sncomplainthandletypename;    // 投诉处理类型名称
	
	private String snintegral;                   // 现有积分
	private String snoriginalintegral;           // 原有积分
	private String snpresentintegral;            // 赠送积分
	private String snpresentreason;              // 赠送原因
	private String snpresentdate;                // 赠送时间
	
	private String snmemberupgradedate;          // 会员升级时间
	
	private String snfeedbackcontent;            // 委外预误期反馈内容
	
	private String snstealthclass;               // 抛弃类型
	private String sngoodsname;                 // 商品名称
	
	
	public String getSnstealthclass() {
		return snstealthclass;
	}
	public void setSnstealthclass(String snstealthclass) {
		this.snstealthclass = snstealthclass;
	}
	public String getSngoodsname() {
		return sngoodsname;
	}
	public void setSngoodsname(String sngoodsname) {
		this.sngoodsname = sngoodsname;
	}
	public String getSnsendflag() {
		return snsendflag;
	}
	public void setSnsendflag(String snsendflag) {
		this.snsendflag = snsendflag;
	}
	public String getSntakeshopcodephone() {
		return sntakeshopcodephone;
	}
	public void setSntakeshopcodephone(String sntakeshopcodephone) {
		this.sntakeshopcodephone = sntakeshopcodephone;
	}
	public String getSnsex() {
		return snsex;
	}
	public void setSnsex(String snsex) {
		this.snsex = snsex;
	}
	public String getSnoptometryshopcode() {
		return snoptometryshopcode;
	}
	public void setSnoptometryshopcode(String snoptometryshopcode) {
		this.snoptometryshopcode = snoptometryshopcode;
	}
	public String getSnoptometryshopcodename() {
		return snoptometryshopcodename;
	}
	public void setSnoptometryshopcodename(String snoptometryshopcodename) {
		this.snoptometryshopcodename = snoptometryshopcodename;
	}
	public String getSnoptometrydate() {
		return snoptometrydate;
	}
	public void setSnoptometrydate(String snoptometrydate) {
		this.snoptometrydate = snoptometrydate;
	}
	public String getSnfurthershopcode() {
		return snfurthershopcode;
	}
	public void setSnfurthershopcode(String snfurthershopcode) {
		this.snfurthershopcode = snfurthershopcode;
	}
	public String getSnfurthershopcodename() {
		return snfurthershopcodename;
	}
	public void setSnfurthershopcodename(String snfurthershopcodename) {
		this.snfurthershopcodename = snfurthershopcodename;
	}
	public String getSnshopcodetakedate() {
		return snshopcodetakedate;
	}
	public void setSnshopcodetakedate(String snshopcodetakedate) {
		this.snshopcodetakedate = snshopcodetakedate;
	}
	public String getSncomplaintdate() {
		return sncomplaintdate;
	}
	public void setSncomplaintdate(String sncomplaintdate) {
		this.sncomplaintdate = sncomplaintdate;
	}
	public String getSncomplainttype() {
		return sncomplainttype;
	}
	public void setSncomplainttype(String sncomplainttype) {
		this.sncomplainttype = sncomplainttype;
	}
	public String getSncomplainttypename() {
		return sncomplainttypename;
	}
	public void setSncomplainttypename(String sncomplainttypename) {
		this.sncomplainttypename = sncomplainttypename;
	}
	public String getSncomplainthandledate() {
		return sncomplainthandledate;
	}
	public void setSncomplainthandledate(String sncomplainthandledate) {
		this.sncomplainthandledate = sncomplainthandledate;
	}
	public String getSncomplainthandletype() {
		return sncomplainthandletype;
	}
	public void setSncomplainthandletype(String sncomplainthandletype) {
		this.sncomplainthandletype = sncomplainthandletype;
	}
	public String getSncomplainthandletypename() {
		return sncomplainthandletypename;
	}
	public void setSncomplainthandletypename(String sncomplainthandletypename) {
		this.sncomplainthandletypename = sncomplainthandletypename;
	}
	public String getSnoriginalintegral() {
		return snoriginalintegral;
	}
	public void setSnoriginalintegral(String snoriginalintegral) {
		this.snoriginalintegral = snoriginalintegral;
	}
	public String getSnpresentintegral() {
		return snpresentintegral;
	}
	public void setSnpresentintegral(String snpresentintegral) {
		this.snpresentintegral = snpresentintegral;
	}
	public String getSnpresentreason() {
		return snpresentreason;
	}
	public void setSnpresentreason(String snpresentreason) {
		this.snpresentreason = snpresentreason;
	}
	public String getSnpresentdate() {
		return snpresentdate;
	}
	public void setSnpresentdate(String snpresentdate) {
		this.snpresentdate = snpresentdate;
	}
	public String getSnmemberupgradedate() {
		return snmemberupgradedate;
	}
	public void setSnmemberupgradedate(String snmemberupgradedate) {
		this.snmemberupgradedate = snmemberupgradedate;
	}
	public String getSnfeedbackcontent() {
		return snfeedbackcontent;
	}
	public void setSnfeedbackcontent(String snfeedbackcontent) {
		this.snfeedbackcontent = snfeedbackcontent;
	}
	public String getSncustomername() {
		return sncustomername;
	}
	public void setSncustomername(String sncustomername) {
		this.sncustomername = sncustomername;
	}
	public String getSnbirthday() {
		return snbirthday;
	}
	public void setSnbirthday(String snbirthday) {
		this.snbirthday = snbirthday;
	}
	public String getSnposdate() {
		return snposdate;
	}
	public void setSnposdate(String snposdate) {
		this.snposdate = snposdate;
	}
	public String getSntakedate() {
		return sntakedate;
	}
	public void setSntakedate(String sntakedate) {
		this.sntakedate = sntakedate;
	}
	public String getSnshopcode() {
		return snshopcode;
	}
	public void setSnshopcode(String snshopcode) {
		this.snshopcode = snshopcode;
	}
	public String getSnshopcodename() {
		return snshopcodename;
	}
	public void setSnshopcodename(String snshopcodename) {
		this.snshopcodename = snshopcodename;
	}
	public String getSnshopcodephone() {
		return snshopcodephone;
	}
	public void setSnshopcodephone(String snshopcodephone) {
		this.snshopcodephone = snshopcodephone;
	}
	public String getSnpsalesprice() {
		return snpsalesprice;
	}
	public void setSnpsalesprice(String snpsalesprice) {
		this.snpsalesprice = snpsalesprice;
	}
	public String getSncustomprice() {
		return sncustomprice;
	}
	public void setSncustomprice(String sncustomprice) {
		this.sncustomprice = sncustomprice;
	}
	public String getSnarrearprice() {
		return snarrearprice;
	}
	public void setSnarrearprice(String snarrearprice) {
		this.snarrearprice = snarrearprice;
	}
	public String getSnintegral() {
		return snintegral;
	}
	public void setSnintegral(String snintegral) {
		this.snintegral = snintegral;
	}
	public String getSntakeshopcode() {
		return sntakeshopcode;
	}
	public void setSntakeshopcode(String sntakeshopcode) {
		this.sntakeshopcode = sntakeshopcode;
	}
	public String getSntakeshopcodename() {
		return sntakeshopcodename;
	}
	public void setSntakeshopcodename(String sntakeshopcodename) {
		this.sntakeshopcodename = sntakeshopcodename;
	}
	public String getSnmailaddress() {
		return snmailaddress;
	}
	public void setSnmailaddress(String snmailaddress) {
		this.snmailaddress = snmailaddress;
	}
	public String getSnmailbillid() {
		return snmailbillid;
	}
	public void setSnmailbillid(String snmailbillid) {
		this.snmailbillid = snmailbillid;
	}
	public String getSnmaildate() {
		return snmaildate;
	}
	public void setSnmaildate(String snmaildate) {
		this.snmaildate = snmaildate;
	}
	public String getSnmailcompany() {
		return snmailcompany;
	}
	public void setSnmailcompany(String snmailcompany) {
		this.snmailcompany = snmailcompany;
	}
	public String getSnchangeprice() {
		return snchangeprice;
	}
	public void setSnchangeprice(String snchangeprice) {
		this.snchangeprice = snchangeprice;
	}
	public String getSncardid() {
		return sncardid;
	}
	public void setSncardid(String sncardid) {
		this.sncardid = sncardid;
	}
	public String getSncardname() {
		return sncardname;
	}
	public void setSncardname(String sncardname) {
		this.sncardname = sncardname;
	}
	public String getSnfurtherdate() {
		return snfurtherdate;
	}
	public void setSnfurtherdate(String snfurtherdate) {
		this.snfurtherdate = snfurtherdate;
	}
	public String getSnbillid() {
		return snbillid;
	}
	public void setSnbillid(String snbillid) {
		this.snbillid = snbillid;
	}
	public String getSncustomertelphone() {
		return sncustomertelphone;
	}
	public void setSncustomertelphone(String sncustomertelphone) {
		this.sncustomertelphone = sncustomertelphone;
	}
	public String getSncustomerid() {
		return sncustomerid;
	}
	public void setSncustomerid(String sncustomerid) {
		this.sncustomerid = sncustomerid;
	}
	public String getSnpersonid() {
		return snpersonid;
	}
	public void setSnpersonid(String snpersonid) {
		this.snpersonid = snpersonid;
	}
	public String getSnpersonname() {
		return snpersonname;
	}
	public void setSnpersonname(String snpersonname) {
		this.snpersonname = snpersonname;
	}
	public String getSndepartmentid() {
		return sndepartmentid;
	}
	public void setSndepartmentid(String sndepartmentid) {
		this.sndepartmentid = sndepartmentid;
	}
	public String getSndepartmentname() {
		return sndepartmentname;
	}
	public void setSndepartmentname(String sndepartmentname) {
		this.sndepartmentname = sndepartmentname;
	}
	public String getSncreatedate() {
		return sncreatedate;
	}
	public void setSncreatedate(String sncreatedate) {
		this.sncreatedate = sncreatedate;
	}
	public String getSnsenddate() {
		return snsenddate;
	}
	public void setSnsenddate(String snsenddate) {
		this.snsenddate = snsenddate;
	}
	public String getSnnotetypeid() {
		return snnotetypeid;
	}
	public void setSnnotetypeid(String snnotetypeid) {
		this.snnotetypeid = snnotetypeid;
	}
	public String getSnnotecontent() {
		return snnotecontent;
	}
	public void setSnnotecontent(String snnotecontent) {
		this.snnotecontent = snnotecontent;
	}
	
	
}
