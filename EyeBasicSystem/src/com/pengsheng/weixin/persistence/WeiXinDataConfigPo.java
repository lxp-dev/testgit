package com.pengsheng.weixin.persistence;

/**
 * 微信数据配置
 */
public class WeiXinDataConfigPo {

	private String wdcregistagreement;          // 注册协议对应文章内容ID
	private String wdcregistagreementname;          // 注册协议对应文章标题
	private String wdcintegralagreement;          // 积分兑换对应对应文章内容ID
	private String wdcintegralagreementname;          // 积分兑换对应对应文章标题
	private String wdcoptometryappointment;          // 预约说明对应对应文章内容ID	
	private String wdcoptometryappointmentname;          // 预约说明对应对应文章标题
	private String wdcnewcmstype;          // 最新技术分享文章列表ID	
	private String wdcnewcmstypename;          // 最新技术分享文章列表内容
	
	private String wdcdepartmentpicurl;	//连锁店默认图文中第一个大图
	private String wdcdepartmentpicurl2;
	private String wdccmslargepicurl;	//文章默认图文中第一个大图
	private String wdccmslargepicurl2; //	
	private String wdccmssmallpicurl;	//文章默认图文中小图（80*80）
	private String wdccmssmallpicurl2;
	private String wdcpersoncenterpicurl;	//个人中心企业Log（80*80）
	private String wdcpersoncenterpicurl2;	
	
	private String wdccontactuslxfs;	//联系我们中的联系方式对应文章ID
	private String wdccontactuslxfstitle;	//联系我们中的联系方式对应文章标题
	private String wdccontactuslxfscontent;	//联系我们中的联系方式对应文章内容
	private String wdccontactusldlx;	//联系我们中的来店路线对应文章ID
	private String wdccontactusldlxtitle;	//联系我们中的来店路线对应文章标题
	private String wdccontactusldlxcontent;	//联系我们中的来店路线对应文章内容
	private String wdcnewactivity;	//最新活动对应文章列表ID
	private String wdcnewactivityname;	//最新活动对应文章列表内容
	
	private String wdcyqhy;	//邀请好友中的标题对应文章ID
	private String wdcyqhytitle;	//邀请好友中的标题对应文章标题
	
	private String wdcyqhysuccess;	//邀请好友成功分享页面中的说明对应文章内容
	private String wdcyqhysuccesstitle;	//邀请好友成功分享页面中的说明对应文章标题
	
	private String wdclxhx;	//蓝星红星会员区别对应文章ID
	private String wdclxhxtitle;	//蓝星红星会员区别对应文章标题
	
	private String wdcalertregistersuccess;		// 会员注册成功页面弹出信息
	private String wdcalertyaoqingsuccess;		// 邀请好友成功页面弹出信息
	private String wdcalertyaoqingerror1;		// 邀请好友失败页面弹出信息:①	您的好友已是红星会员
	private String wdcalertyaoqingerror2;		// 邀请好友失败页面弹出信息:②	只有红星会员才有资格邀请好友
	private String wdcalertjifenduihuansuccess;	// 积分商城兑换成功弹出信息
	private String wdcalertjifenduihuanconfirm;	// 积分商城兑换确认弹出信息
	private String wdcalertyuyuesuccess;		// 微信预约成功页面弹出信息
	private String wdcalertyuyueerror;			// 微信预约失败页面弹出信息
	
	private String wdcintroductionjifen;			// 积分名称在系统中显示为什么文字
	private String wdcintroductionchuzhi;			// 储值名称在系统中显示为什么文字
	private String wdcintroductionwodebingli;		// 个人中心主页面我的病例在系统中显示为什么文字
	private String wdcintroductionzuixinyizhu;		// 消息中心的最新医嘱在系统中显示为什么文字
	private String wdcintroductionzuixinzhenliao;	// 消息中心的最新诊疗信息在系统中显示为什么文字
	
	public String getWdcregistagreement() {
		return wdcregistagreement;
	}
	public void setWdcregistagreement(String wdcregistagreement) {
		this.wdcregistagreement = wdcregistagreement;
	}
	public String getWdcintegralagreement() {
		return wdcintegralagreement;
	}
	public void setWdcintegralagreement(String wdcintegralagreement) {
		this.wdcintegralagreement = wdcintegralagreement;
	}
	public String getWdcoptometryappointment() {
		return wdcoptometryappointment;
	}
	public void setWdcoptometryappointment(String wdcoptometryappointment) {
		this.wdcoptometryappointment = wdcoptometryappointment;
	}
	public String getWdcregistagreementname() {
		return wdcregistagreementname;
	}
	public void setWdcregistagreementname(String wdcregistagreementname) {
		this.wdcregistagreementname = wdcregistagreementname;
	}
	public String getWdcintegralagreementname() {
		return wdcintegralagreementname;
	}
	public void setWdcintegralagreementname(String wdcintegralagreementname) {
		this.wdcintegralagreementname = wdcintegralagreementname;
	}
	public String getWdcoptometryappointmentname() {
		return wdcoptometryappointmentname;
	}
	public void setWdcoptometryappointmentname(String wdcoptometryappointmentname) {
		this.wdcoptometryappointmentname = wdcoptometryappointmentname;
	}
	public String getWdcnewcmstype() {
		return wdcnewcmstype;
	}
	public void setWdcnewcmstype(String wdcnewcmstype) {
		this.wdcnewcmstype = wdcnewcmstype;
	}
	public String getWdcnewcmstypename() {
		return wdcnewcmstypename;
	}
	public void setWdcnewcmstypename(String wdcnewcmstypename) {
		this.wdcnewcmstypename = wdcnewcmstypename;
	}
	public String getWdcdepartmentpicurl() {
		return wdcdepartmentpicurl;
	}
	public void setWdcdepartmentpicurl(String wdcdepartmentpicurl) {
		this.wdcdepartmentpicurl = wdcdepartmentpicurl;
	}
	public String getWdcdepartmentpicurl2() {
		return wdcdepartmentpicurl2;
	}
	public void setWdcdepartmentpicurl2(String wdcdepartmentpicurl2) {
		this.wdcdepartmentpicurl2 = wdcdepartmentpicurl2;
	}
	public String getWdccmslargepicurl() {
		return wdccmslargepicurl;
	}
	public void setWdccmslargepicurl(String wdccmslargepicurl) {
		this.wdccmslargepicurl = wdccmslargepicurl;
	}
	public String getWdccmslargepicurl2() {
		return wdccmslargepicurl2;
	}
	public void setWdccmslargepicurl2(String wdccmslargepicurl2) {
		this.wdccmslargepicurl2 = wdccmslargepicurl2;
	}
	public String getWdccmssmallpicurl() {
		return wdccmssmallpicurl;
	}
	public void setWdccmssmallpicurl(String wdccmssmallpicurl) {
		this.wdccmssmallpicurl = wdccmssmallpicurl;
	}
	public String getWdccmssmallpicurl2() {
		return wdccmssmallpicurl2;
	}
	public void setWdccmssmallpicurl2(String wdccmssmallpicurl2) {
		this.wdccmssmallpicurl2 = wdccmssmallpicurl2;
	}
	public String getWdcpersoncenterpicurl() {
		return wdcpersoncenterpicurl;
	}
	public void setWdcpersoncenterpicurl(String wdcpersoncenterpicurl) {
		this.wdcpersoncenterpicurl = wdcpersoncenterpicurl;
	}
	public String getWdcpersoncenterpicurl2() {
		return wdcpersoncenterpicurl2;
	}
	public void setWdcpersoncenterpicurl2(String wdcpersoncenterpicurl2) {
		this.wdcpersoncenterpicurl2 = wdcpersoncenterpicurl2;
	}
	public String getWdccontactuslxfs() {
		return wdccontactuslxfs;
	}
	public void setWdccontactuslxfs(String wdccontactuslxfs) {
		this.wdccontactuslxfs = wdccontactuslxfs;
	}
	public String getWdccontactusldlx() {
		return wdccontactusldlx;
	}
	public void setWdccontactusldlx(String wdccontactusldlx) {
		this.wdccontactusldlx = wdccontactusldlx;
	}
	public String getWdccontactuslxfstitle() {
		return wdccontactuslxfstitle;
	}
	public void setWdccontactuslxfstitle(String wdccontactuslxfstitle) {
		this.wdccontactuslxfstitle = wdccontactuslxfstitle;
	}
	public String getWdccontactuslxfscontent() {
		return wdccontactuslxfscontent;
	}
	public void setWdccontactuslxfscontent(String wdccontactuslxfscontent) {
		this.wdccontactuslxfscontent = wdccontactuslxfscontent;
	}
	public String getWdccontactusldlxtitle() {
		return wdccontactusldlxtitle;
	}
	public void setWdccontactusldlxtitle(String wdccontactusldlxtitle) {
		this.wdccontactusldlxtitle = wdccontactusldlxtitle;
	}
	public String getWdccontactusldlxcontent() {
		return wdccontactusldlxcontent;
	}
	public void setWdccontactusldlxcontent(String wdccontactusldlxcontent) {
		this.wdccontactusldlxcontent = wdccontactusldlxcontent;
	}
	public String getWdcnewactivity() {
		return wdcnewactivity;
	}
	public void setWdcnewactivity(String wdcnewactivity) {
		this.wdcnewactivity = wdcnewactivity;
	}
	public String getWdcnewactivityname() {
		return wdcnewactivityname;
	}
	public void setWdcnewactivityname(String wdcnewactivityname) {
		this.wdcnewactivityname = wdcnewactivityname;
	}
	public String getWdcyqhytitle() {
		return wdcyqhytitle;
	}
	public void setWdcyqhytitle(String wdcyqhytitle) {
		this.wdcyqhytitle = wdcyqhytitle;
	}
	public String getWdcyqhy() {
		return wdcyqhy;
	}
	public void setWdcyqhy(String wdcyqhy) {
		this.wdcyqhy = wdcyqhy;
	}
	public String getWdclxhx() {
		return wdclxhx;
	}
	public void setWdclxhx(String wdclxhx) {
		this.wdclxhx = wdclxhx;
	}
	public String getWdclxhxtitle() {
		return wdclxhxtitle;
	}
	public void setWdclxhxtitle(String wdclxhxtitle) {
		this.wdclxhxtitle = wdclxhxtitle;
	}
	public String getWdcalertregistersuccess() {
		return wdcalertregistersuccess;
	}
	public void setWdcalertregistersuccess(String wdcalertregistersuccess) {
		this.wdcalertregistersuccess = wdcalertregistersuccess;
	}

	public String getWdcalertjifenduihuansuccess() {
		return wdcalertjifenduihuansuccess;
	}
	public void setWdcalertjifenduihuansuccess(String wdcalertjifenduihuansuccess) {
		this.wdcalertjifenduihuansuccess = wdcalertjifenduihuansuccess;
	}
	public String getWdcalertjifenduihuanconfirm() {
		return wdcalertjifenduihuanconfirm;
	}
	public void setWdcalertjifenduihuanconfirm(String wdcalertjifenduihuanconfirm) {
		this.wdcalertjifenduihuanconfirm = wdcalertjifenduihuanconfirm;
	}
	public String getWdcalertyuyuesuccess() {
		return wdcalertyuyuesuccess;
	}
	public void setWdcalertyuyuesuccess(String wdcalertyuyuesuccess) {
		this.wdcalertyuyuesuccess = wdcalertyuyuesuccess;
	}
	public String getWdcalertyuyueerror() {
		return wdcalertyuyueerror;
	}
	public void setWdcalertyuyueerror(String wdcalertyuyueerror) {
		this.wdcalertyuyueerror = wdcalertyuyueerror;
	}
	public String getWdcalertyaoqingsuccess() {
		return wdcalertyaoqingsuccess;
	}
	public void setWdcalertyaoqingsuccess(String wdcalertyaoqingsuccess) {
		this.wdcalertyaoqingsuccess = wdcalertyaoqingsuccess;
	}
	public String getWdcalertyaoqingerror1() {
		return wdcalertyaoqingerror1;
	}
	public void setWdcalertyaoqingerror1(String wdcalertyaoqingerror1) {
		this.wdcalertyaoqingerror1 = wdcalertyaoqingerror1;
	}
	public String getWdcalertyaoqingerror2() {
		return wdcalertyaoqingerror2;
	}
	public void setWdcalertyaoqingerror2(String wdcalertyaoqingerror2) {
		this.wdcalertyaoqingerror2 = wdcalertyaoqingerror2;
	}
	public String getWdcyqhysuccess() {
		return wdcyqhysuccess;
	}
	public void setWdcyqhysuccess(String wdcyqhysuccess) {
		this.wdcyqhysuccess = wdcyqhysuccess;
	}
	public String getWdcyqhysuccesstitle() {
		return wdcyqhysuccesstitle;
	}
	public void setWdcyqhysuccesstitle(String wdcyqhysuccesstitle) {
		this.wdcyqhysuccesstitle = wdcyqhysuccesstitle;
	}
	public String getWdcintroductionjifen() {
		return wdcintroductionjifen;
	}
	public void setWdcintroductionjifen(String wdcintroductionjifen) {
		this.wdcintroductionjifen = wdcintroductionjifen;
	}
	public String getWdcintroductionchuzhi() {
		return wdcintroductionchuzhi;
	}
	public void setWdcintroductionchuzhi(String wdcintroductionchuzhi) {
		this.wdcintroductionchuzhi = wdcintroductionchuzhi;
	}
	public String getWdcintroductionwodebingli() {
		return wdcintroductionwodebingli;
	}
	public void setWdcintroductionwodebingli(String wdcintroductionwodebingli) {
		this.wdcintroductionwodebingli = wdcintroductionwodebingli;
	}
	public String getWdcintroductionzuixinyizhu() {
		return wdcintroductionzuixinyizhu;
	}
	public void setWdcintroductionzuixinyizhu(String wdcintroductionzuixinyizhu) {
		this.wdcintroductionzuixinyizhu = wdcintroductionzuixinyizhu;
	}
	public String getWdcintroductionzuixinzhenliao() {
		return wdcintroductionzuixinzhenliao;
	}
	public void setWdcintroductionzuixinzhenliao(
			String wdcintroductionzuixinzhenliao) {
		this.wdcintroductionzuixinzhenliao = wdcintroductionzuixinzhenliao;
	}

}
