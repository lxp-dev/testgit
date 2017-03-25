package com.pengsheng.eims.storage.persistence;

public class ProcurementOrdersEntryPo {

	private String cstpeid;	//唯一编号
	
	private String cstpebillid;	//bill编号

	private String cstpepurchaseorderid;	//采购订单号

	private String cstpeordernumber;	//订购数量

	private String cstpegoodsid;		//商品代码

	private String bgigoodsname;		//商品名称

	private String bgispec;				//规格

	private String bgicolor;		//颜色

	private String bgisph;		//球镜

	private String bgicyl;		//柱镜

	private String bgiaxis;		//轴向

	private String bgicurvature1;	//曲率1

	private String bgicurvature2;	//曲率2

	private String bgidia;		//直径

	private String bgiGoodsBarCode;		
	
	private String bspsuppliername;
	
	private String bspid;

	private String bgicostprice;
	
	private String bgiretailprice;
	
	private String bgitaxrate;
	
	private String bginottaxrate;
	
	private String bgisource;		//产地
	
	private String bgiframematerialtype;
	private String bgiframematerialtypename;
	
	private String cstpebrandname;	//品种名称
	
	private String bgiregistrationnum;	//注册证号
	
	public String getBgiregistrationnum() {
		return bgiregistrationnum;
	}

	public void setBgiregistrationnum(String bgiregistrationnum) {
		this.bgiregistrationnum = bgiregistrationnum;
	}

	public String getCstpebillid() {
		return cstpebillid;
	}

	public void setCstpebillid(String cstpebillid) {
		this.cstpebillid = cstpebillid;
	}

	public String getCstpebrandname() {
		return cstpebrandname;
	}

	public void setCstpebrandname(String cstpebrandname) {
		this.cstpebrandname = cstpebrandname;
	}

	public String getBgiframematerialtypename() {
		return bgiframematerialtypename;
	}

	public void setBgiframematerialtypename(String bgiframematerialtypename) {
		this.bgiframematerialtypename = bgiframematerialtypename;
	}

	private String bgiframesize;
	private String bgiaccessoriestype;
	private String bgibelowplusluminosity;
	private String bgirefractive;
	private String bgiismutiluminosity;
	private String bgieyeglassmaterialtype;
	public String getBgiframematerialtype() {
		return bgiframematerialtype;
	}

	public void setBgiframematerialtype(String bgiframematerialtype) {
		this.bgiframematerialtype = bgiframematerialtype;
	}

	public String getBgiframesize() {
		return bgiframesize;
	}

	public void setBgiframesize(String bgiframesize) {
		this.bgiframesize = bgiframesize;
	}

	public String getBgiaccessoriestype() {
		return bgiaccessoriestype;
	}

	public void setBgiaccessoriestype(String bgiaccessoriestype) {
		this.bgiaccessoriestype = bgiaccessoriestype;
	}

	public String getBgibelowplusluminosity() {
		return bgibelowplusluminosity;
	}

	public void setBgibelowplusluminosity(String bgibelowplusluminosity) {
		this.bgibelowplusluminosity = bgibelowplusluminosity;
	}

	public String getBgirefractive() {
		return bgirefractive;
	}

	public void setBgirefractive(String bgirefractive) {
		this.bgirefractive = bgirefractive;
	}

	public String getBgiismutiluminosity() {
		return bgiismutiluminosity;
	}

	public void setBgiismutiluminosity(String bgiismutiluminosity) {
		this.bgiismutiluminosity = bgiismutiluminosity;
	}

	public String getBgieyeglassmaterialtype() {
		return bgieyeglassmaterialtype;
	}

	public void setBgieyeglassmaterialtype(String bgieyeglassmaterialtype) {
		this.bgieyeglassmaterialtype = bgieyeglassmaterialtype;
	}

	public String getBgiusetype() {
		return bgiusetype;
	}

	public void setBgiusetype(String bgiusetype) {
		this.bgiusetype = bgiusetype;
	}

	public String getBgistealthclass() {
		return bgistealthclass;
	}

	public void setBgistealthclass(String bgistealthclass) {
		this.bgistealthclass = bgistealthclass;
	}

	public String getBgicapacity() {
		return bgicapacity;
	}

	public void setBgicapacity(String bgicapacity) {
		this.bgicapacity = bgicapacity;
	}

	public String getBgicapacityentry() {
		return bgicapacityentry;
	}

	public void setBgicapacityentry(String bgicapacityentry) {
		this.bgicapacityentry = bgicapacityentry;
	}

	public String getBgisuppliercolor() {
		return bgisuppliercolor;
	}

	public void setBgisuppliercolor(String bgisuppliercolor) {
		this.bgisuppliercolor = bgisuppliercolor;
	}

	private String bgiusetype;
	private String bgistealthclass;
	private String bgicapacity;
	private String bgicapacityentry;
	private String bgisuppliercolor;
	
	
	public String getBgisource() {
		return bgisource;
	}

	public void setBgisource(String bgisource) {
		this.bgisource = bgisource;
	}

	public String getBgicostprice() {
		return bgicostprice;
	}

	public void setBgicostprice(String bgicostprice) {
		this.bgicostprice = bgicostprice;
	}

	public String getBgiretailprice() {
		return bgiretailprice;
	}

	public void setBgiretailprice(String bgiretailprice) {
		this.bgiretailprice = bgiretailprice;
	}

	public String getBgitaxrate() {
		return bgitaxrate;
	}

	public void setBgitaxrate(String bgitaxrate) {
		this.bgitaxrate = bgitaxrate;
	}

	public String getBginottaxrate() {
		return bginottaxrate;
	}

	public void setBginottaxrate(String bginottaxrate) {
		this.bginottaxrate = bginottaxrate;
	}

	public String getBspsuppliername() {
		return bspsuppliername;
	}

	public void setBspsuppliername(String bspsuppliername) {
		this.bspsuppliername = bspsuppliername;
	}

	public String getBspid() {
		return bspid;
	}

	public void setBspid(String bspid) {
		this.bspid = bspid;
	}

	public String getBgiGoodsBarCode() {
		return bgiGoodsBarCode;
	}

	public void setBgiGoodsBarCode(String bgiGoodsBarCode) {
		this.bgiGoodsBarCode = bgiGoodsBarCode;
	}

	private String cstperemark;

	public String getCstpeid() {
		return cstpeid;
	}

	public void setCstpeid(String cstpeid) {
		this.cstpeid = cstpeid;
	}

	public String getCstpepurchaseorderid() {
		return cstpepurchaseorderid;
	}

	public void setCstpepurchaseorderid(String cstpepurchaseorderid) {
		this.cstpepurchaseorderid = cstpepurchaseorderid;
	}

	public String getCstpeordernumber() {
		return cstpeordernumber;
	}

	public void setCstpeordernumber(String cstpeordernumber) {
		this.cstpeordernumber = cstpeordernumber;
	}

	public String getCstpegoodsid() {
		return cstpegoodsid;
	}

	public void setCstpegoodsid(String cstpegoodsid) {
		this.cstpegoodsid = cstpegoodsid;
	}

	public String getBgigoodsname() {
		return bgigoodsname;
	}

	public void setBgigoodsname(String bgigoodsname) {
		this.bgigoodsname = bgigoodsname;
	}

	public String getBgispec() {
		return bgispec;
	}

	public void setBgispec(String bgispec) {
		this.bgispec = bgispec;
	}

	public String getBgicolor() {
		return bgicolor;
	}

	public void setBgicolor(String bgicolor) {
		this.bgicolor = bgicolor;
	}

	public String getBgisph() {
		return bgisph;
	}

	public void setBgisph(String bgisph) {
		this.bgisph = bgisph;
	}

	public String getBgicyl() {
		return bgicyl;
	}

	public void setBgicyl(String bgicyl) {
		this.bgicyl = bgicyl;
	}

	public String getBgiaxis() {
		return bgiaxis;
	}

	public void setBgiaxis(String bgiaxis) {
		this.bgiaxis = bgiaxis;
	}

	public String getBgicurvature1() {
		return bgicurvature1;
	}

	public void setBgicurvature1(String bgicurvature1) {
		this.bgicurvature1 = bgicurvature1;
	}

	public String getBgicurvature2() {
		return bgicurvature2;
	}

	public void setBgicurvature2(String bgicurvature2) {
		this.bgicurvature2 = bgicurvature2;
	}

	public String getBgidia() {
		return bgidia;
	}

	public void setBgidia(String bgidia) {
		this.bgidia = bgidia;
	}

	public String getCstperemark() {
		return cstperemark;
	}

	public void setCstperemark(String cstperemark) {
		this.cstperemark = cstperemark;
	}

}
