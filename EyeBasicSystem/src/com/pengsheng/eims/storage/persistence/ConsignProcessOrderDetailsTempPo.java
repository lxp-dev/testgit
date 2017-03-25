package com.pengsheng.eims.storage.persistence;

public class ConsignProcessOrderDetailsTempPo {
	private String[] cstcpodid;// uuid
	private String[] cstcpodorderbilld;// 订单号
	private String[] cstcprdreceiptbilld;//收货单号
	private String[] cstcpodglassesbillid;// 配镜单号，对外订单号
	private String[] cstcpodexpecteddate;// 预计制造商到镜日期
	private String[] cstcpodordertype;// 订单类型 内部：N， 外部：W
	private String[] cstcpodcustomerid;// 客户id
	private String[] cstcpodcustomername;// 客户名称
	private String[] cstcpodbilltype;// 订单类型 镜片订做，隐形订做
	private String[] cstcpodglassflag;// 右眼：r， 左眼：l
	private String[] cstcpodgoodsid;// 商品代码
	private String[] cstcpodgoodsbarcode;// 商品条码
	private String[] cstcpodballglass;// 球镜
	private String[] cstcpodpostglass;// 柱镜
	private String[] cstcpodaxes;// 轴向
	private String[] cstcpodadd;// add
	private String[] cstcpodarriseglass;// 棱镜
	private String[] cstcpodbasis;// 基底
	private String[] cstcpodeyecurvature;// 隐形曲率
	private String[] cstcpoddiameter;// 隐形直径
	private String[] cstcpodconlenva;// va
	private String[] cstcpodarriveddate;// 配镜单到镜日期
	private String[] cstcpodrequirement;// 加工要求
	private String[] cstcpodrequirement2;//特殊加工要求ID
	private String[] cstcpoddragstype;
	private String[] cstcpodsalesbillid;//原配镜单号
	private String[] cstcpodsalesid;//配镜单商品明细ID
	private String[] cstcpodinter;//瞳距(远)
	private String[] cstcpodinterdistance;//瞳距(近)
	
	
	public String[] getCstcpodinterdistance() {
		return cstcpodinterdistance;
	}

	public void setCstcpodinterdistance(String[] cstcpodinterdistance) {
		this.cstcpodinterdistance = cstcpodinterdistance;
	}

	public String[] getCstcpodinter() {
		return cstcpodinter;
	}

	public void setCstcpodinter(String[] cstcpodinter) {
		this.cstcpodinter = cstcpodinter;
	}

	public String[] getCstcpodsalesid() {
		return cstcpodsalesid;
	}

	public void setCstcpodsalesid(String[] cstcpodsalesid) {
		this.cstcpodsalesid = cstcpodsalesid;
	}

	public String[] getCstcpodsalesbillid() {
		return cstcpodsalesbillid;
	}

	public void setCstcpodsalesbillid(String[] cstcpodsalesbillid) {
		this.cstcpodsalesbillid = cstcpodsalesbillid;
	}

	public String[] getCstcpoddragstype() {
		return cstcpoddragstype;
	}

	public void setCstcpoddragstype(String[] cstcpoddragstype) {
		this.cstcpoddragstype = cstcpoddragstype;
	}

	public String[] getCstcpodrequirement2() {
		return cstcpodrequirement2;
	}

	public void setCstcpodrequirement2(String[] cstcpodrequirement2) {
		this.cstcpodrequirement2 = cstcpodrequirement2;
	}

	public String[] getCstcpodrequirement1() {
		return cstcpodrequirement1;
	}

	public void setCstcpodrequirement1(String[] cstcpodrequirement1) {
		this.cstcpodrequirement1 = cstcpodrequirement1;
	}

	private String[] cstcpodrequirement1;// 特殊加工要求
	private String[] cstcpodnum;// 数量
	private String[] cstcpodstate;// 到货状态0：未到货 1：到货
	private String[] cstcpodgoodsname;// 商品名称

	public String[] getCstcpodid() {
		return cstcpodid;
	}

	public void setCstcpodid(String[] cstcpodid) {
		this.cstcpodid = cstcpodid;
	}

	public String[] getCstcpodorderbilld() {
		return cstcpodorderbilld;
	}

	public void setCstcpodorderbilld(String[] cstcpodorderbilld) {
		this.cstcpodorderbilld = cstcpodorderbilld;
	}

	public String[] getCstcpodglassesbillid() {
		return cstcpodglassesbillid;
	}

	public void setCstcpodglassesbillid(String[] cstcpodglassesbillid) {
		this.cstcpodglassesbillid = cstcpodglassesbillid;
	}

	public String[] getCstcpodexpecteddate() {
		return cstcpodexpecteddate;
	}

	public void setCstcpodexpecteddate(String[] cstcpodexpecteddate) {
		this.cstcpodexpecteddate = cstcpodexpecteddate;
	}

	public String[] getCstcpodordertype() {
		return cstcpodordertype;
	}

	public void setCstcpodordertype(String[] cstcpodordertype) {
		this.cstcpodordertype = cstcpodordertype;
	}

	public String[] getCstcpodcustomerid() {
		return cstcpodcustomerid;
	}

	public void setCstcpodcustomerid(String[] cstcpodcustomerid) {
		this.cstcpodcustomerid = cstcpodcustomerid;
	}

	public String[] getCstcpodcustomername() {
		return cstcpodcustomername;
	}

	public void setCstcpodcustomername(String[] cstcpodcustomername) {
		this.cstcpodcustomername = cstcpodcustomername;
	}

	public String[] getCstcpodbilltype() {
		return cstcpodbilltype;
	}

	public void setCstcpodbilltype(String[] cstcpodbilltype) {
		this.cstcpodbilltype = cstcpodbilltype;
	}

	public String[] getCstcpodglassflag() {
		return cstcpodglassflag;
	}

	public void setCstcpodglassflag(String[] cstcpodglassflag) {
		this.cstcpodglassflag = cstcpodglassflag;
	}

	public String[] getCstcpodgoodsid() {
		return cstcpodgoodsid;
	}

	public void setCstcpodgoodsid(String[] cstcpodgoodsid) {
		this.cstcpodgoodsid = cstcpodgoodsid;
	}

	public String[] getCstcpodgoodsbarcode() {
		return cstcpodgoodsbarcode;
	}

	public void setCstcpodgoodsbarcode(String[] cstcpodgoodsbarcode) {
		this.cstcpodgoodsbarcode = cstcpodgoodsbarcode;
	}

	public String[] getCstcpodballglass() {
		return cstcpodballglass;
	}

	public void setCstcpodballglass(String[] cstcpodballglass) {
		this.cstcpodballglass = cstcpodballglass;
	}

	public String[] getCstcpodpostglass() {
		return cstcpodpostglass;
	}

	public void setCstcpodpostglass(String[] cstcpodpostglass) {
		this.cstcpodpostglass = cstcpodpostglass;
	}

	public String[] getCstcpodaxes() {
		return cstcpodaxes;
	}

	public void setCstcpodaxes(String[] cstcpodaxes) {
		this.cstcpodaxes = cstcpodaxes;
	}

	public String[] getCstcpodadd() {
		return cstcpodadd;
	}

	public void setCstcpodadd(String[] cstcpodadd) {
		this.cstcpodadd = cstcpodadd;
	}

	public String[] getCstcpodarriseglass() {
		return cstcpodarriseglass;
	}

	public void setCstcpodarriseglass(String[] cstcpodarriseglass) {
		this.cstcpodarriseglass = cstcpodarriseglass;
	}

	public String[] getCstcpodbasis() {
		return cstcpodbasis;
	}

	public void setCstcpodbasis(String[] cstcpodbasis) {
		this.cstcpodbasis = cstcpodbasis;
	}

	public String[] getCstcpodeyecurvature() {
		return cstcpodeyecurvature;
	}

	public void setCstcpodeyecurvature(String[] cstcpodeyecurvature) {
		this.cstcpodeyecurvature = cstcpodeyecurvature;
	}

	public String[] getCstcpoddiameter() {
		return cstcpoddiameter;
	}

	public void setCstcpoddiameter(String[] cstcpoddiameter) {
		this.cstcpoddiameter = cstcpoddiameter;
	}

	public String[] getCstcpodconlenva() {
		return cstcpodconlenva;
	}

	public void setCstcpodconlenva(String[] cstcpodconlenva) {
		this.cstcpodconlenva = cstcpodconlenva;
	}

	public String[] getCstcpodarriveddate() {
		return cstcpodarriveddate;
	}

	public void setCstcpodarriveddate(String[] cstcpodarriveddate) {
		this.cstcpodarriveddate = cstcpodarriveddate;
	}

	public String[] getCstcpodrequirement() {
		return cstcpodrequirement;
	}

	public void setCstcpodrequirement(String[] cstcpodrequirement) {
		this.cstcpodrequirement = cstcpodrequirement;
	}

	public String[] getCstcpodnum() {
		return cstcpodnum;
	}

	public void setCstcpodnum(String[] cstcpodnum) {
		this.cstcpodnum = cstcpodnum;
	}

	public String[] getCstcpodstate() {
		return cstcpodstate;
	}

	public void setCstcpodstate(String[] cstcpodstate) {
		this.cstcpodstate = cstcpodstate;
	}

	public String[] getCstcpodgoodsname() {
		return cstcpodgoodsname;
	}

	public void setCstcpodgoodsname(String[] cstcpodgoodsname) {
		this.cstcpodgoodsname = cstcpodgoodsname;
	}

	public String[] getCstcprdreceiptbilld() {
		return cstcprdreceiptbilld;
	}

	public void setCstcprdreceiptbilld(String[] cstcprdreceiptbilld) {
		this.cstcprdreceiptbilld = cstcprdreceiptbilld;
	}

}
