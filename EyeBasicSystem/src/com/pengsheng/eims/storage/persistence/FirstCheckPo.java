package com.pengsheng.eims.storage.persistence;

/**
* @author 沈兴贺 
* 类说明
*/
public class FirstCheckPo {
	private String pchfcuuid;					//32位随机主键
	private String pchfcsalesid;				//关联销售单号
	private String pchfcdepartmentid;			//部门ID
	private String pchfccustomerid;				//顾客ID
	private String pchfcsendpersonid;			//发料人ID
	private String pchfcfirstcheckpersonid;		//初检人ID
	private String pchfcfirstcheckdate;			//初检日期
	private String pchfcmassreasonod;			//产品质量原因OD
	private String pchfcmassreasonos;			//产品质量原因OS
	private String pchfcmassphenomenonod;		//产品质量现象OD
	private String pchfcmassphenomenonos;		//产品质量现象OS
	private String pchfcdiameterod;				//直径OD
	private String pchfcdiameteros;				//直径OS
	private String pchfcstandardluminosityod;	//标准光度OD
	private String pchfcstandardluminosityos;	//标准光度OS
	private String pchfcrealityluminosityod;	//实际光度OD	
	private String pchfcrealityluminosityos;	//实际光度OS
	private String pchfccenterthicknessod;		//中心厚度OD
	private String pchfccenterthicknessos;		//中心厚度OS
	private String pchfcpackod;					//包装OD
	private String pchfcpackos;					//包装OS
	private String pchfcmarkod;					//标识OD
	private String pchfcmarkos;					//标识OS
	private String pchfcisqualifiedod;			//是否合格OD
	private String pchfcisqualifiedos;			//是否合格OS
	
	/**
	 * 页面加载
	 * @return
	 */
	private String pchfcgoodsname;
	//private String pchfcsalesid;
	private String pchfcsalesshop;
	private String pchfcsalesshopname;
	private String pchfcgetShop;
	private String pchfcgetshopname;
	//private String pchfccustomerid;
	private String pchfccustomername;
	private String pchfccustomerphone;
	//private String pchfcsendpersonid;
	private String pchfcsendpersonname;
	
	public String getPchfcsalesshopname() {
		return pchfcsalesshopname;
	}
	public void setPchfcsalesshopname(String pchfcsalesshopname) {
		this.pchfcsalesshopname = pchfcsalesshopname;
	}
	public String getPchfcgetshopname() {
		return pchfcgetshopname;
	}
	public void setPchfcgetshopname(String pchfcgetshopname) {
		this.pchfcgetshopname = pchfcgetshopname;
	}
	public String getPchfcgoodsname() {
		return pchfcgoodsname;
	}
	public void setPchfcgoodsname(String pchfcgoodsname) {
		this.pchfcgoodsname = pchfcgoodsname;
	}
	public String getPchfcsalesshop() {
		return pchfcsalesshop;
	}
	public void setPchfcsalesshop(String pchfcsalesshop) {
		this.pchfcsalesshop = pchfcsalesshop;
	}
	public String getPchfcgetShop() {
		return pchfcgetShop;
	}
	public void setPchfcgetShop(String pchfcgetShop) {
		this.pchfcgetShop = pchfcgetShop;
	}
	public String getPchfccustomername() {
		return pchfccustomername;
	}
	public void setPchfccustomername(String pchfccustomername) {
		this.pchfccustomername = pchfccustomername;
	}
	public String getPchfccustomerphone() {
		return pchfccustomerphone;
	}
	public void setPchfccustomerphone(String pchfccustomerphone) {
		this.pchfccustomerphone = pchfccustomerphone;
	}
	public String getPchfcsendpersonname() {
		return pchfcsendpersonname;
	}
	public void setPchfcsendpersonname(String pchfcsendpersonname) {
		this.pchfcsendpersonname = pchfcsendpersonname;
	}
	public String getPchfcuuid() {
		return pchfcuuid;
	}
	public void setPchfcuuid(String pchfcuuid) {
		this.pchfcuuid = pchfcuuid;
	}
	public String getPchfcsalesid() {
		return pchfcsalesid;
	}
	public void setPchfcsalesid(String pchfcsalesid) {
		this.pchfcsalesid = pchfcsalesid;
	}
	public String getPchfcdepartmentid() {
		return pchfcdepartmentid;
	}
	public void setPchfcdepartmentid(String pchfcdepartmentid) {
		this.pchfcdepartmentid = pchfcdepartmentid;
	}
	public String getPchfccustomerid() {
		return pchfccustomerid;
	}
	public void setPchfccustomerid(String pchfccustomerid) {
		this.pchfccustomerid = pchfccustomerid;
	}
	public String getPchfcsendpersonid() {
		return pchfcsendpersonid;
	}
	public void setPchfcsendpersonid(String pchfcsendpersonid) {
		this.pchfcsendpersonid = pchfcsendpersonid;
	}
	public String getPchfcfirstcheckpersonid() {
		return pchfcfirstcheckpersonid;
	}
	public void setPchfcfirstcheckpersonid(String pchfcfirstcheckpersonid) {
		this.pchfcfirstcheckpersonid = pchfcfirstcheckpersonid;
	}
	public String getPchfcfirstcheckdate() {
		return pchfcfirstcheckdate;
	}
	public void setPchfcfirstcheckdate(String pchfcfirstcheckdate) {
		this.pchfcfirstcheckdate = pchfcfirstcheckdate;
	}
	public String getPchfcmassreasonod() {
		return pchfcmassreasonod;
	}
	public void setPchfcmassreasonod(String pchfcmassreasonod) {
		this.pchfcmassreasonod = pchfcmassreasonod;
	}
	public String getPchfcmassreasonos() {
		return pchfcmassreasonos;
	}
	public void setPchfcmassreasonos(String pchfcmassreasonos) {
		this.pchfcmassreasonos = pchfcmassreasonos;
	}
	public String getPchfcmassphenomenonod() {
		return pchfcmassphenomenonod;
	}
	public void setPchfcmassphenomenonod(String pchfcmassphenomenonod) {
		this.pchfcmassphenomenonod = pchfcmassphenomenonod;
	}
	public String getPchfcmassphenomenonos() {
		return pchfcmassphenomenonos;
	}
	public void setPchfcmassphenomenonos(String pchfcmassphenomenonos) {
		this.pchfcmassphenomenonos = pchfcmassphenomenonos;
	}
	public String getPchfcdiameterod() {
		return pchfcdiameterod;
	}
	public void setPchfcdiameterod(String pchfcdiameterod) {
		this.pchfcdiameterod = pchfcdiameterod;
	}
	public String getPchfcdiameteros() {
		return pchfcdiameteros;
	}
	public void setPchfcdiameteros(String pchfcdiameteros) {
		this.pchfcdiameteros = pchfcdiameteros;
	}
	public String getPchfcstandardluminosityod() {
		return pchfcstandardluminosityod;
	}
	public void setPchfcstandardluminosityod(String pchfcstandardluminosityod) {
		this.pchfcstandardluminosityod = pchfcstandardluminosityod;
	}
	public String getPchfcstandardluminosityos() {
		return pchfcstandardluminosityos;
	}
	public void setPchfcstandardluminosityos(String pchfcstandardluminosityos) {
		this.pchfcstandardluminosityos = pchfcstandardluminosityos;
	}
	public String getPchfcrealityluminosityod() {
		return pchfcrealityluminosityod;
	}
	public void setPchfcrealityluminosityod(String pchfcrealityluminosityod) {
		this.pchfcrealityluminosityod = pchfcrealityluminosityod;
	}
	public String getPchfcrealityluminosityos() {
		return pchfcrealityluminosityos;
	}
	public void setPchfcrealityluminosityos(String pchfcrealityluminosityos) {
		this.pchfcrealityluminosityos = pchfcrealityluminosityos;
	}
	public String getPchfccenterthicknessod() {
		return pchfccenterthicknessod;
	}
	public void setPchfccenterthicknessod(String pchfccenterthicknessod) {
		this.pchfccenterthicknessod = pchfccenterthicknessod;
	}
	public String getPchfccenterthicknessos() {
		return pchfccenterthicknessos;
	}
	public void setPchfccenterthicknessos(String pchfccenterthicknessos) {
		this.pchfccenterthicknessos = pchfccenterthicknessos;
	}
	public String getPchfcpackod() {
		return pchfcpackod;
	}
	public void setPchfcpackod(String pchfcpackod) {
		this.pchfcpackod = pchfcpackod;
	}
	public String getPchfcpackos() {
		return pchfcpackos;
	}
	public void setPchfcpackos(String pchfcpackos) {
		this.pchfcpackos = pchfcpackos;
	}
	public String getPchfcmarkod() {
		return pchfcmarkod;
	}
	public void setPchfcmarkod(String pchfcmarkod) {
		this.pchfcmarkod = pchfcmarkod;
	}
	public String getPchfcmarkos() {
		return pchfcmarkos;
	}
	public void setPchfcmarkos(String pchfcmarkos) {
		this.pchfcmarkos = pchfcmarkos;
	}
	public String getPchfcisqualifiedod() {
		return pchfcisqualifiedod;
	}
	public void setPchfcisqualifiedod(String pchfcisqualifiedod) {
		this.pchfcisqualifiedod = pchfcisqualifiedod;
	}
	public String getPchfcisqualifiedos() {
		return pchfcisqualifiedos;
	}
	public void setPchfcisqualifiedos(String pchfcisqualifiedos) {
		this.pchfcisqualifiedos = pchfcisqualifiedos;
	}
	

}
