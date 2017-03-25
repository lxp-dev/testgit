package com.pengsheng.eims.basic.persistence;

public class BrandPo {
	
	private String bbdid;	
	private String[] bbdids;	
	private String brands;
	private String bbdsettlement;
	private String bbdsettlementmonth;
	private String bbdbrandname;
	private String bbdsupplierid;
	private String bspcategoryid;
	private String bspsuppliername;
	private String bgcgoodscategoryname;
	private String bbdplace;
	private String bbdmnemoniccode;
	private String bbdgoodscategory;
	private String bbdrefractive;	
	private String bbdmaxretailPrice;	
	private String bbdminretailPrice;	
	private String bbdwhichretail;	
	private String bbdismendretail;	
	private String bbdretailprice; //零售价
	private String bbdcostprice;  //含税成本	
	private String bbdwholesaleprice; //批发价
	private String bbdnottaxrate;
	private String bbdtaxrate;
	private String bbdremark;
	private String bbdsalesstatue;
	private String bbdframeprocesscrafttype;
	private String bbdframeprocesscrafttypename;
	private String bbdthrowingcycle;
	private String documentUrl;
	private String contentType;
	private String saveFileName;
	private String bbdvaliddate;	// 效期
	private String bbdvaliddateUL;	// 上限效期
	private String bbdvaliddateUP;	// 下限效期
	private String bbddistributionmethods;	// 经销方式	1：代销   2：数期   3：买断	
	private String updateGoodsName;	// 同步更新该品种下的商品名称
	private String bbdunit;	//计量单位编码
	private String bbdunitname;  //计量单位名称	
	private String bbdframematerialtype;  		//材质
	private String bbdframematerialtypename;    //材质名称
	private String bbdmaterialclass;  		//材料分类
	private String bbdluminosityclass;  		//光度分类
	private String bbdgradualclass;  		//渐进片分类
	private String bbdfunctionclass;  		//功能大类
	private String bbdusetype;  			//使用类型
	private String bbdstealthclass;  				//抛弃型分类	
	private String bbdbgncostprice;  				//起始含税成本	
	private String bbdendcostprice;  				//截止含税成本	
	private String bbddefaultdiscount;  			//商品级别
	private String bbddefaultdiscountname;  		//商品级别名称
	private String updateGoodsDefaultDiscount;  	//是否更新该品种下商品的默认折扣
	private String bbdbarcodeflag;  				//使用批号
	private String bbdpromotion;  					//促销金额
	private String bbdregistrationnum;  			//注册证号
	private String bbddownloadflag;  				//下载状态
	private String bbdpayfeeid;						//收费项目
	private String bbdissetflag;					//收费项目查询设置 1全部   2未设置   3已设置
	
	
	public String getBbdissetflag() {
		return bbdissetflag;
	}
	public void setBbdissetflag(String bbdissetflag) {
		this.bbdissetflag = bbdissetflag;
	}
	public String getBbdpayfeeid() {
		return bbdpayfeeid;
	}

	public void setBbdpayfeeid(String bbdpayfeeid) {
		this.bbdpayfeeid = bbdpayfeeid;
	}
	public String getBbddownloadflag() {
		return bbddownloadflag;
	}
	public void setBbddownloadflag(String bbddownloadflag) {
		this.bbddownloadflag = bbddownloadflag;
	}
	public String getBbdregistrationnum() {
		return bbdregistrationnum;
	}
	public void setBbdregistrationnum(String bbdregistrationnum) {
		this.bbdregistrationnum = bbdregistrationnum;
	}

	public String getBbdpromotion() {
		return bbdpromotion;
	}

	public void setBbdpromotion(String bbdpromotion) {
		this.bbdpromotion = bbdpromotion;
	}

	public String getBbddefaultdiscountname() {
		return bbddefaultdiscountname;
	}

	public void setBbddefaultdiscountname(String bbddefaultdiscountname) {
		this.bbddefaultdiscountname = bbddefaultdiscountname;
	}

	public String getUpdateGoodsDefaultDiscount() {
		return updateGoodsDefaultDiscount;
	}

	public void setUpdateGoodsDefaultDiscount(String updateGoodsDefaultDiscount) {
		this.updateGoodsDefaultDiscount = updateGoodsDefaultDiscount;
	}

	public String getBbddefaultdiscount() {
		return bbddefaultdiscount;
	}

	public void setBbddefaultdiscount(String bbddefaultdiscount) {
		this.bbddefaultdiscount = bbddefaultdiscount;
	}

	public String getBbdbgncostprice() {
		return bbdbgncostprice;
	}

	public void setBbdbgncostprice(String bbdbgncostprice) {
		this.bbdbgncostprice = bbdbgncostprice;
	}

	public String getBbdendcostprice() {
		return bbdendcostprice;
	}

	public void setBbdendcostprice(String bbdendcostprice) {
		this.bbdendcostprice = bbdendcostprice;
	}

	public String getBrands() {
		return brands;
	}

	public void setBrands(String brands) {
		this.brands = brands;
	}
	public String getBbdismendretail() {
		return bbdismendretail;
	}

	public void setBbdismendretail(String bbdismendretail) {
		this.bbdismendretail = bbdismendretail;
	}

	public String getBbdwhichretail() {
		return bbdwhichretail;
	}

	public void setBbdwhichretail(String bbdwhichretail) {
		this.bbdwhichretail = bbdwhichretail;
	}

	public String getBbdmaxretailPrice() {
		return bbdmaxretailPrice;
	}

	public void setBbdmaxretailPrice(String bbdmaxretailPrice) {
		this.bbdmaxretailPrice = bbdmaxretailPrice;
	}

	public String getBbdminretailPrice() {
		return bbdminretailPrice;
	}

	public void setBbdminretailPrice(String bbdminretailPrice) {
		this.bbdminretailPrice = bbdminretailPrice;
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

	public String getBbdluminosityclass() {
		return bbdluminosityclass;
	}

	public void setBbdluminosityclass(String bbdluminosityclass) {
		this.bbdluminosityclass = bbdluminosityclass;
	}

	public String getBbdgradualclass() {
		return bbdgradualclass;
	}

	public void setBbdgradualclass(String bbdgradualclass) {
		this.bbdgradualclass = bbdgradualclass;
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

	public String getBbdwholesaleprice() {
		return bbdwholesaleprice;
	}

	public void setBbdwholesaleprice(String bbdwholesaleprice) {
		this.bbdwholesaleprice = bbdwholesaleprice;
	}
	
	public String getBbdid() {
		return bbdid;
	}

	public void setBbdid(String bbdid) {
		this.bbdid = bbdid;
	}

	public String getBbdbrandname() {
		return bbdbrandname;
	}

	public void setBbdbrandname(String bbdbrandname) {
		this.bbdbrandname = bbdbrandname;
	}

	public String getBbdsupplierid() {
		return bbdsupplierid;
	}

	public void setBbdsupplierid(String bbdsupplierid) {
		this.bbdsupplierid = bbdsupplierid;
	}

	public String getBspcategoryid() {
		return bspcategoryid;
	}

	public void setBspcategoryid(String bspcategoryid) {
		this.bspcategoryid = bspcategoryid;
	}

	public String getBspsuppliername() {
		return bspsuppliername;
	}

	public void setBspsuppliername(String bspsuppliername) {
		this.bspsuppliername = bspsuppliername;
	}

	public String getBgcgoodscategoryname() {
		return bgcgoodscategoryname;
	}

	public void setBgcgoodscategoryname(String bgcgoodscategoryname) {
		this.bgcgoodscategoryname = bgcgoodscategoryname;
	}

	public String getBbdplace() {
		return bbdplace;
	}

	public void setBbdplace(String bbdplace) {
		this.bbdplace = bbdplace;
	}

	public String getBbdmnemoniccode() {
		return bbdmnemoniccode;
	}

	public void setBbdmnemoniccode(String bbdmnemoniccode) {
		this.bbdmnemoniccode = bbdmnemoniccode;
	}

	public String getBbdgoodscategory() {
		return bbdgoodscategory;
	}

	public void setBbdgoodscategory(String bbdgoodscategory) {
		this.bbdgoodscategory = bbdgoodscategory;
	}

	public String getBbdrefractive() {
		return bbdrefractive;
	}

	public void setBbdrefractive(String bbdrefractive) {
		this.bbdrefractive = bbdrefractive;
	}

	public String getBbdretailprice() {
		return bbdretailprice;
	}

	public void setBbdretailprice(String bbdretailprice) {
		this.bbdretailprice = bbdretailprice;
	}

	public String getBbdcostprice() {
		return bbdcostprice;
	}

	public void setBbdcostprice(String bbdcostprice) {
		this.bbdcostprice = bbdcostprice;
	}

	public String getBbdnottaxrate() {
		return bbdnottaxrate;
	}

	public void setBbdnottaxrate(String bbdnottaxrate) {
		this.bbdnottaxrate = bbdnottaxrate;
	}

	public String getBbdtaxrate() {
		return bbdtaxrate;
	}

	public void setBbdtaxrate(String bbdtaxrate) {
		this.bbdtaxrate = bbdtaxrate;
	}

	public String getBbdremark() {
		return bbdremark;
	}

	public void setBbdremark(String bbdremark) {
		this.bbdremark = bbdremark;
	}

	public String getBbdsalesstatue() {
		return bbdsalesstatue;
	}

	public void setBbdsalesstatue(String bbdsalesstatue) {
		this.bbdsalesstatue = bbdsalesstatue;
	}

	public String getBbdframeprocesscrafttype() {
		return bbdframeprocesscrafttype;
	}

	public void setBbdframeprocesscrafttype(String bbdframeprocesscrafttype) {
		this.bbdframeprocesscrafttype = bbdframeprocesscrafttype;
	}

	public String getBbdframeprocesscrafttypename() {
		return bbdframeprocesscrafttypename;
	}

	public void setBbdframeprocesscrafttypename(String bbdframeprocesscrafttypename) {
		this.bbdframeprocesscrafttypename = bbdframeprocesscrafttypename;
	}

	public String getBbdthrowingcycle() {
		return bbdthrowingcycle;
	}

	public void setBbdthrowingcycle(String bbdthrowingcycle) {
		this.bbdthrowingcycle = bbdthrowingcycle;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getBbdvaliddate() {
		return bbdvaliddate;
	}

	public void setBbdvaliddate(String bbdvaliddate) {
		this.bbdvaliddate = bbdvaliddate;
	}

	public String getBbdvaliddateUL() {
		return bbdvaliddateUL;
	}

	public void setBbdvaliddateUL(String bbdvaliddateUL) {
		this.bbdvaliddateUL = bbdvaliddateUL;
	}

	public String getBbdvaliddateUP() {
		return bbdvaliddateUP;
	}

	public void setBbdvaliddateUP(String bbdvaliddateUP) {
		this.bbdvaliddateUP = bbdvaliddateUP;
	}

	public String getBbddistributionmethods() {
		return bbddistributionmethods;
	}

	public void setBbddistributionmethods(String bbddistributionmethods) {
		this.bbddistributionmethods = bbddistributionmethods;
	}

	public String getUpdateGoodsName() {
		return updateGoodsName;
	}

	public void setUpdateGoodsName(String updateGoodsName) {
		this.updateGoodsName = updateGoodsName;
	}

	public String getBbdunit() {
		return bbdunit;
	}

	public void setBbdunit(String bbdunit) {
		this.bbdunit = bbdunit;
	}

	public String getBbdunitname() {
		return bbdunitname;
	}

	public void setBbdunitname(String bbdunitname) {
		this.bbdunitname = bbdunitname;
	}

	public String getBbdframematerialtypename() {
		return bbdframematerialtypename;
	}

	public void setBbdframematerialtypename(String bbdframematerialtypename) {
		this.bbdframematerialtypename = bbdframematerialtypename;
	}

	public String getBbdsettlement() {
		return bbdsettlement;
	}

	public void setBbdsettlement(String bbdsettlement) {
		this.bbdsettlement = bbdsettlement;
	}

	public String getBbdsettlementmonth() {
		return bbdsettlementmonth;
	}

	public void setBbdsettlementmonth(String bbdsettlementmonth) {
		this.bbdsettlementmonth = bbdsettlementmonth;
	}

	public String getBbdbarcodeflag() {
		return bbdbarcodeflag;
	}

	public void setBbdbarcodeflag(String bbdbarcodeflag) {
		this.bbdbarcodeflag = bbdbarcodeflag;
	}

	public String[] getBbdids() {
		return bbdids;
	}

	public void setBbdids(String[] bbdids) {
		this.bbdids = bbdids;
	}

}
