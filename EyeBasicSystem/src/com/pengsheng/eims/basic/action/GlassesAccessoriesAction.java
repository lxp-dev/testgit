package com.pengsheng.eims.basic.action;

import java.math.BigDecimal;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.GlassesAccessoriesMgr;
import com.pengsheng.eims.basic.mgr.GlassesFrameMgr;
import com.pengsheng.eims.basic.mgr.LensFinishedMgr;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.OtherGoodsMgr;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.UnitPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * 配件类action
 */
public class GlassesAccessoriesAction extends BaseAction {
	private BrandMgr brandMgr;
	private List<GoodsLevelPo> selectGoodsLevelList;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<RefractiveSetPo> refractiveSetList = null;
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	
	public List<OptionParamPo> getOptionParamPolist() {
		return optionParamPolist;
	}

	public void setOptionParamPolist(List<OptionParamPo> optionParamPolist) {
		this.optionParamPolist = optionParamPolist;
	}

	public OptionParamMgr getOptionParamMgr() {
		return optionParamMgr;
	}

	public void setOptionParamMgr(OptionParamMgr optionParamMgr) {
		this.optionParamMgr = optionParamMgr;
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}

	public List<GoodsLevelPo> getSelectGoodsLevelList() {
		return selectGoodsLevelList;
	}

	public void setSelectGoodsLevelList(List<GoodsLevelPo> selectGoodsLevelList) {
		this.selectGoodsLevelList = selectGoodsLevelList;
	}

	public List<RefractiveSetPo> getRefractiveSetList() {
		return refractiveSetList;
	}

	public void setRefractiveSetList(List<RefractiveSetPo> refractiveSetList) {
		this.refractiveSetList = refractiveSetList;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	private PersonPermissionMgr personPermissionMgr;

	private GlassesAccessoriesMgr glassesAccessoriesMgr;

	private GoodsInfoPo goodsInfoPo;

	private List<GoodsInfoPo> glassesAccessoriesList;

	private List<UnitPo> unitList;

	private UnitMgr unitMgr;
	
	private GlassesFrameMgr glassesFrameMgr;
	private SupplierMgr supplierMgr;	
	
	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}
	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}
	public GlassesFrameMgr getGlassesFrameMgr() {
		return glassesFrameMgr;
	}

	public void setGlassesFrameMgr(GlassesFrameMgr glassesFrameMgr) {
		this.glassesFrameMgr = glassesFrameMgr;
	}

	private OtherGoodsMgr otherGoodsMgr;
	private LensFinishedMgr lensFinishedMgr;
	
	public LensFinishedMgr getLensFinishedMgr() {
		return lensFinishedMgr;
	}

	public void setLensFinishedMgr(LensFinishedMgr lensFinishedMgr) {
		this.lensFinishedMgr = lensFinishedMgr;
	}

	public OtherGoodsMgr getOtherGoodsMgr() {
		return otherGoodsMgr;
	}

	public void setOtherGoodsMgr(OtherGoodsMgr otherGoodsMgr) {
		this.otherGoodsMgr = otherGoodsMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public GlassesAccessoriesMgr getGlassesAccessoriesMgr() {
		return glassesAccessoriesMgr;
	}

	public void setGlassesAccessoriesMgr(
			GlassesAccessoriesMgr glassesAccessoriesMgr) {
		this.glassesAccessoriesMgr = glassesAccessoriesMgr;
	}

	/**
	 * 初始化配件类查询
	 */
	public String initGlassesAccessoriesSel() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		 systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "selGlassesAccessories";
			}

		return SUCCESS;
	}

	/**
	 * 查询配件类
	 */
	public String selGlassesAccessories() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		if(!"".equals(Utility.getName(personInfoPo.getSyspsupplierid()))){
			supplierID = Utility.getName(personInfoPo.getSyspsupplierid());
			supplierName = Utility.getName(personInfoPo.getSyspsuppliername());
		}
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String isClosed=Utility.getName(request.getParameter("isClosed"));
		String bgicostbeginprice="";
		String bgicostendprice="";
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);

		String pjlx = Utility.getName(request.getParameter("pjlx"));
		String bgipayfeeid = Utility.getName(request.getParameter("bgipayfeeid"));
		String bgiissetflag = Utility.getName(request.getParameter("bgiissetflag"));

		request.setAttribute("pjlx", pjlx);
		request.setAttribute("bgipayfeeid", bgipayfeeid);
		request.setAttribute("bgiissetflag", bgiissetflag);
		
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgiaccessoriestype(pjlx);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgiflag(isClosed);
		goodsInfoPo.setBgiwhichretail(whichretail);
		goodsInfoPo.setBgiismendretail(select_retail);
		goodsInfoPo.setBgipayfeeid(bgipayfeeid);
		goodsInfoPo.setBgiissetflag(bgiissetflag);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}
		
		if("1".equals(permissionPo.getKeyf()))
		{
			bgicostbeginprice=Utility.getName(request.getParameter("bgicostbeginprice"));
			goodsInfoPo.setBgicostbeginprice(bgicostbeginprice);
			bgicostendprice=Utility.getName(request.getParameter("bgicostendprice"));
			goodsInfoPo.setBgicostendprice(bgicostendprice);
		}

		int count = glassesAccessoriesMgr.getGlassesAccessoriesCount(goodsInfoPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			glassesAccessoriesList = glassesAccessoriesMgr
					.getGlassesAccessoriesList(goodsInfoPo, page.getStart(),
							page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			glassesAccessoriesList = null;
		}

		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("isClosed", isClosed);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandName", brandName);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		if("1".equals(permissionPo.getKeyf()))
		{
			request.setAttribute("bgicostbeginprice", bgicostbeginprice);
			request.setAttribute("bgicostendprice", bgicostendprice);
		}

		//加载树中制造商
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		if (goodsTree.equals("1")){
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName",Utility.getName(supplierPo.getBspsuppliername()));
		}
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		
		//收费项目列表
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 初始化配件类新增
	 */
	public String initGlassesAccessoriesInsert() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		goodsInfoPo = new GoodsInfoPo();
		unitList = unitMgr.getUnitList();
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		if (goodsTree.equals("1"))
		{
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			goodsInfoPo.setBgisuppliername(Utility.getName(supplierPo.getBspsuppliername()));
		}		
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setBgibrandid(brandID);
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		refractiveSetList = unitMgr.getRefractiveSetList();
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 新增辅料类
	 */
	public String insertGlassesAccessories() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		refractiveSetList = unitMgr.getRefractiveSetList();
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		GoodsInfoPo po = glassesAccessoriesMgr
				.getGlassesAccessories(goodsInfoPo);
		GoodsInfoPo po1 = glassesFrameMgr.getGlassesFrameCode(goodsInfoPo);
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("辅料:" + goodsInfoPo.getBgigoodsid() + "新增!");
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String[] goodsnametype = systemParameterPo.getFspcpj().trim().split(",");
		String viewgoodsname = goodsInfoPo.getBgigoodsname();
		for(int i=0; i<goodsnametype.length; i++){
			if(goodsnametype[i].trim().equals("B_GI_Spec")){
				viewgoodsname = viewgoodsname + "-型号："+goodsInfoPo.getBgispec();
			} else if(goodsnametype[i].trim().equals("B_GI_Color")){
				viewgoodsname = viewgoodsname + "-颜色："+goodsInfoPo.getBgichinesecolorname();
			} else if(goodsnametype[i].trim().equals("B_GI_Sph")){
				viewgoodsname = viewgoodsname + "-球镜："+goodsInfoPo.getBgisph();
			} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
				viewgoodsname = viewgoodsname + "-柱镜："+goodsInfoPo.getBgicyl();
			} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
				viewgoodsname = viewgoodsname + "-标价："+goodsInfoPo.getBgiretailprice();
			}
		}
		goodsInfoPo.setBgiviewgoodsname(viewgoodsname);
		
		if(!"".equals(Utility.getName(personInfoPo.getSyspsupplierid()))){
			goodsInfoPo.setBgisupplierid(Utility.getName(personInfoPo.getSyspsupplierid()));
			goodsInfoPo.setBgisuppliername(Utility.getName(personInfoPo.getSyspsuppliername()));
		}
		
		request.setAttribute("defaultdiscountvalue", goodsInfoPo.getBgidefaultdiscountvalue());
		
		this.clearMessages();
		if (po.getBgigoodsid() == null) {
			if(po1.getBgigoodsbarcode()==null)
			{
				goodsInfoPo.setBgigoodscategoryid("2");
				goodsInfoPo.setBgiflag("1");
				goodsInfoPo.setBginottaxrate(getNottaxrate(goodsInfoPo
						.getBgicostprice(), goodsInfoPo.getBgitaxrate()));
				glassesAccessoriesMgr.insertGlassesAccessories(goodsInfoPo,logPo);
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				if(goodsTree.equals("1"))
				{		
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
					return "rtree";
				
				}else
				{

					request.setAttribute("goodsInfoPo", goodsInfoPo);
					unitList = unitMgr.getUnitList();					
					return SUCCESS;
				}				
				
			}else
			{				
				this.addActionMessage(getText("商品条码重复"));
				unitList=unitMgr.getUnitList();				
				request.setAttribute("goodsInfoPo", goodsInfoPo);
				request.setAttribute("parent", parent);
				request.setAttribute("goodsTree", goodsTree);
				return SUCCESS;
			}
		
		} else {
			this.addActionMessage(getText("struts.messages.repeat"));
			unitList=unitMgr.getUnitList();				
			request.setAttribute("goodsInfoPo", goodsInfoPo);
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			return SUCCESS;
		}
	}

	/**
	 * 初始化配件类修改
	 */
	public String initGlassesAccessoriesUpdate() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		goodsInfoPo = glassesAccessoriesMgr.getGlassesAccessories(goodsInfoPo);
		unitList = unitMgr.getUnitList();
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));

		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		refractiveSetList = unitMgr.getRefractiveSetList();
		
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化配件类详细
	 */
	public String initGlassesAccessoriesDetails() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		goodsInfoPo = glassesAccessoriesMgr.getGlassesAccessories(goodsInfoPo);
		unitList = unitMgr.getUnitList();
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		return SUCCESS;
	}

	/**
	 * 修改配件类
	 */
	public String updateGlassesAccessories() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		//添加日志
		GoodsInfoPo vgoodspo = glassesAccessoriesMgr.getGlassesAccessories(goodsInfoPo);
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String[] goodsnametype = systemParameterPo.getFspcpj().trim().split(",");
		String viewgoodsname = goodsInfoPo.getBgigoodsname();
		for(int i=0; i<goodsnametype.length; i++){
			if(goodsnametype[i].trim().equals("B_GI_Spec")){
				viewgoodsname = viewgoodsname + "-型号："+vgoodspo.getBgispec();
			} else if(goodsnametype[i].trim().equals("B_GI_Color")){
				viewgoodsname = viewgoodsname + "-颜色："+vgoodspo.getBgichinesecolorname();
			} else if(goodsnametype[i].trim().equals("B_GI_Sph")){
				viewgoodsname = viewgoodsname + "-球镜："+vgoodspo.getBgisph();
			} else if(goodsnametype[i].trim().equals("B_GI_Cyl")){
				viewgoodsname = viewgoodsname + "-柱镜："+vgoodspo.getBgicyl();
			} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
				viewgoodsname = viewgoodsname + "-标价："+goodsInfoPo.getBgiretailprice();
			}
		}
		goodsInfoPo.setBgiviewgoodsname(viewgoodsname);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");   // 表示状态
		logPo.setsLogContent("辅料:" + goodsInfoPo.getBgigoodsid() + "修改!");
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		goodsInfoPo.setBginottaxrate(getNottaxrate(goodsInfoPo
				.getBgicostprice(), goodsInfoPo.getBgitaxrate()));
		
		glassesAccessoriesMgr.updateGlassesAccessories(goodsInfoPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		if(goodsTree.equals("1"))
		{
			if(parent.equals("1"))
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
			}
		}else
		{
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}

		return SUCCESS;
	}

	/**
	 * 初始化配件类删除
	 */
	public String initGlassesAccessoriesDelete() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		int num = otherGoodsMgr.getGoodsNumber(goodsInfoPo);
				request.setAttribute("num", num);
		
		goodsInfoPo = glassesAccessoriesMgr.getGlassesAccessories(goodsInfoPo);
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));

		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		return SUCCESS;
	}

	/**
	 * 删除配件类
	 */
	public String deleteGlassesAccessories() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("辅料:" + goodsInfoPo.getBgigoodsid() + "删除!");
		
		int num = otherGoodsMgr.getGoodsNumber(goodsInfoPo);
		request.setAttribute("num", num);
		
		int flag = lensFinishedMgr.getGoodsCount(goodsInfoPo);
		this.clearMessages();
		if (flag == 0) {
			glassesAccessoriesMgr.deleteGlassesAccessories(goodsInfoPo,logPo);
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			if(goodsTree.equals("1"))
			{
				if(parent.equals("1"))
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
				}else
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
				}
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			}
		} else 
		{
			this.addActionMessage(getText("存在商品库存或业务单据,删除失败!"));
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}
		
		return SUCCESS;

	}

	/**
	 * 初始化配件类停用
	 */
	public String initGlassesAccessoriesDisable() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		goodsInfoPo = glassesAccessoriesMgr.getGlassesAccessories(goodsInfoPo);

		return SUCCESS;
	}

	/**
	 * 停用配件类
	 */
	public String disableGlassesAccessories() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);
		goodsInfoPo.setBgiflag("0");
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("39");    // 表示状态
		logPo.setsLogContent("辅料:" + goodsInfoPo.getBgigoodsid() + "停用!");

		glassesAccessoriesMgr.updateGlassesAccessoriesDisable(goodsInfoPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化配件类启用
	 */
	public String initGlassesAccessoriesAble() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		goodsInfoPo = glassesAccessoriesMgr.getGlassesAccessories(goodsInfoPo);

		return SUCCESS;
	}

	/**
	 * 启用配件类
	 */
	public String ableGlassesAccessories() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);
		goodsInfoPo.setBgiflag("1");
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("38");    // 表示状态
		logPo.setsLogContent("辅料:" + goodsInfoPo.getBgigoodsid() + "启用!");

		glassesAccessoriesMgr.updateGlassesAccessoriesDisable(goodsInfoPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}

	public List<GoodsInfoPo> getGlassesAccessoriesList() {
		return glassesAccessoriesList;
	}

	public void setGlassesAccessoriesList(
			List<GoodsInfoPo> glassesAccessoriesList) {
		this.glassesAccessoriesList = glassesAccessoriesList;
	}

	public List<UnitPo> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<UnitPo> unitList) {
		this.unitList = unitList;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	private String getNottaxrate(String costPrice, String taxRate) {

		BigDecimal nottaxrate = new BigDecimal("0");
		BigDecimal rate = new BigDecimal(taxRate).divide(new BigDecimal("100"),
				2, BigDecimal.ROUND_HALF_UP);
		rate = new BigDecimal("1").add(rate);
		nottaxrate = new BigDecimal(costPrice).divide(rate, 6,
				BigDecimal.ROUND_HALF_UP);

		return nottaxrate.toString();
	}

	private String getGoodsbarcode(String goodsID) {

		String goodsbarcode = "";
		String[] goodsid = goodsID.split("\\.");
		for (int i = 0; i < goodsid.length; i++) {
			goodsbarcode = goodsbarcode + goodsid[i];
		}
		return goodsbarcode;
	}
}
