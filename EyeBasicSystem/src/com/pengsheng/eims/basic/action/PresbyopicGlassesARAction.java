package com.pengsheng.eims.basic.action;

import java.math.BigDecimal;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.ColorMgr;
import com.pengsheng.eims.basic.mgr.GlassesFrameMgr;
import com.pengsheng.eims.basic.mgr.LensFinishedMgr;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.OtherGoodsMgr;
import com.pengsheng.eims.basic.mgr.PresbyopicGlassesMgr;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.ColorPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
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

public class PresbyopicGlassesARAction extends BaseAction {
	private BrandMgr brandMgr;
	private List<GoodsLevelPo> selectGoodsLevelList;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<ColorPo> colorList;
	private ColorMgr colorMgr;
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

	public List<ColorPo> getColorList() {
		return colorList;
	}

	public void setColorList(List<ColorPo> colorList) {
		this.colorList = colorList;
	}

	public ColorMgr getColorMgr() {
		return colorMgr;
	}

	public void setColorMgr(ColorMgr colorMgr) {
		this.colorMgr = colorMgr;
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


	private PresbyopicGlassesMgr presbyopicGlassesMgr;

	private GoodsInfoPo goodsInfoPo;

	private List<GoodsInfoPo> presbyopicGlassesList;
	
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

	private List<UnitPo> unitList;

	private UnitMgr unitMgr;
	
	private PersonPermissionMgr personPermissionMgr;
	
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

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	public List<UnitPo> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<UnitPo> unitList) {
		this.unitList = unitList;
	}

	public PresbyopicGlassesMgr getPresbyopicGlassesMgr() {
		return presbyopicGlassesMgr;
	}

	public void setPresbyopicGlassesMgr(PresbyopicGlassesMgr presbyopicGlassesMgr) {
		this.presbyopicGlassesMgr = presbyopicGlassesMgr;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}

	public List<GoodsInfoPo> getPresbyopicGlassesList() {
		return presbyopicGlassesList;
	}

	public void setPresbyopicGlassesList(List<GoodsInfoPo> presbyopicGlassesList) {
		this.presbyopicGlassesList = presbyopicGlassesList;
	}

	/**
	 * 初始化老花镜类查询
	 */
	public String initPresbyopicGlassesSelAR() throws Exception {

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
				return "selPresbyopicGlassesAR";
			}
		return SUCCESS;
	}

	/**
	 * 查询老花镜类
	 */
	public String selPresbyopicGlassesAR() throws Exception {

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
		String varietyID = Utility.getName(request.getParameter("varietyID"));
		String varietyName = Utility.getName(request
				.getParameter("varietyName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String isClosed=Utility.getName(request.getParameter("isClosed"));
		String bgicostbeginprice="";
		String bgicostendprice="";
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);

		String minSphlh = Utility.getName(request.getParameter("minSphlh"));
		String maxSphlh = Utility.getName(request.getParameter("maxSphlh"));
		String bgispeclh = Utility.getName(request.getParameter("bgispeclh"));
		String bgicolorlh = Utility.getName(request.getParameter("bgicolorlh"));
		
		String barcodeflag=Utility.getName(request.getParameter("barcodeflag"));

		request.setAttribute("barcodeflag", barcodeflag);
		
		request.setAttribute("minSphlh", minSphlh);
		request.setAttribute("maxSphlh", maxSphlh);
		request.setAttribute("bgispeclh", bgispeclh);
		request.setAttribute("bgicolorlh", bgicolorlh);
		
		//收费项目
		String bgipayfeeid = Utility.getName(request.getParameter("bgipayfeeid"));
		String bgiissetflag = Utility.getName(request.getParameter("bgiissetflag"));
		request.setAttribute("bgipayfeeid", bgipayfeeid);
		request.setAttribute("bgiissetflag", bgiissetflag);
		
		goodsInfoPo = new GoodsInfoPo();

		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgiflag(isClosed);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgiwhichretail(whichretail);
		goodsInfoPo.setBgiismendretail(select_retail);
		goodsInfoPo.setBgispec(bgispeclh);
		goodsInfoPo.setBgicolor(bgicolorlh);
		goodsInfoPo.setMaxSph(maxSphlh);
		goodsInfoPo.setMinSph(minSphlh);
		goodsInfoPo.setBgibarcodeflag(barcodeflag);
		goodsInfoPo.setBgipayfeeid(bgipayfeeid);
		goodsInfoPo.setBgiissetflag(bgiissetflag);
		
		if("1".equals(permissionPo.getKeyf()))
		{
			bgicostbeginprice=Utility.getName(request.getParameter("bgicostbeginprice"));
			goodsInfoPo.setBgicostbeginprice(bgicostbeginprice);
			bgicostendprice=Utility.getName(request.getParameter("bgicostendprice"));
			goodsInfoPo.setBgicostendprice(bgicostendprice);
		}
		
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

		int count = presbyopicGlassesMgr.getPresbyopicGlassesCount(goodsInfoPo);
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
			presbyopicGlassesList = presbyopicGlassesMgr.getPresbyopicGlassesList(
					goodsInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			presbyopicGlassesList = null;
		}

		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("isClosed", isClosed);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("varietyID", varietyID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandName", brandName);
		request.setAttribute("varietyName", varietyName);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		if("1".equals(permissionPo.getKeyf()))
		{
			request.setAttribute("bgicostbeginprice", bgicostbeginprice);
			request.setAttribute("bgicostendprice", bgicostendprice);
		}
		
		
		//加载树中制造商
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent=Utility.getName(request.getParameter("parent"));
		if (goodsTree.equals("1")){
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName",Utility.getName(supplierPo.getBspsuppliername()));
		}
		request.setAttribute("goodsTree", goodsTree);
		request.setAttribute("parent", parent);
		
		//收费项目列表
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 初始化老花镜类新增
	 */
	public String initPresbyopicGlassesInsertAR() throws Exception {
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
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		goodsInfoPo = new GoodsInfoPo();
		unitList = unitMgr.getUnitList();
		colorList = colorMgr.getColorList();
		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgitaxrate("17");
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 新增老花镜类
	 */
	public String insertPresbyopicGlassesAR() throws Exception {

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
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String[] goodsnametype = systemParameterPo.getFspclh().trim().split(",");
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
			} else if(goodsnametype[i].trim().equals("B_GI_FrameSize")){
				viewgoodsname = viewgoodsname + "-尺寸："+goodsInfoPo.getBgiframesize();
			}
		}
		goodsInfoPo.setBgiviewgoodsname(viewgoodsname);
		if(!"".equals(Utility.getName(personInfoPo.getSyspsupplierid()))){
			goodsInfoPo.setBgisupplierid(Utility.getName(personInfoPo.getSyspsupplierid()));
			goodsInfoPo.setBgisuppliername(Utility.getName(personInfoPo.getSyspsuppliername()));
		}
		
		request.setAttribute("defaultdiscountvalue", goodsInfoPo.getBgidefaultdiscountvalue());
		
		GoodsInfoPo po = presbyopicGlassesMgr.getPresbyopicGlasses(goodsInfoPo);
		GoodsInfoPo po1 = glassesFrameMgr.getGlassesFrameCode(goodsInfoPo);
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("老花镜:" + goodsInfoPo.getBgigoodsid() + "新增!");
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		colorList = colorMgr.getColorList();
		this.clearMessages();
		if (po.getBgigoodsid() == null) 
		{
			if(po1.getBgigoodsbarcode()==null)
			{
				goodsInfoPo.setBgigoodscategoryid("8");
				goodsInfoPo.setBginottaxrate(getNottaxrate(goodsInfoPo
						.getBgicostprice(), goodsInfoPo.getBgitaxrate()));
				presbyopicGlassesMgr.insertPresbyopicGlasses(goodsInfoPo,logPo);
				if(goodsTree.equals("1"))
				{		
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
					return "rtree";
				
				}else
				{
					this.addActionMessage(getText("struts.messages.insert.sucess"));
					request.setAttribute("goodsInfoPo", goodsInfoPo);
					unitList = unitMgr.getUnitList();
					return SUCCESS;
				}
				
			}else
			{
				this.addActionMessage(getText("商品条码重复"));
				
				unitList = unitMgr.getUnitList();
				
				String supplierID = Utility.getName(request.getParameter("supplierID"));
				String supplierName = Utility.getName(request.getParameter("supplierName"));
				String brandID = Utility.getName(request.getParameter("brandID"));
				String brandName = Utility.getName(request.getParameter("brandName"));
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
				request.setAttribute("goodsInfoPo", goodsInfoPo);
				return SUCCESS;
			}
		} else 
		{
			this.addActionMessage(getText("struts.messages.repeat"));
			request.setAttribute("goodsInfoPo", goodsInfoPo);
			unitList = unitMgr.getUnitList();
			
			String supplierID = Utility.getName(request.getParameter("supplierID"));
			String supplierName = Utility.getName(request.getParameter("supplierName"));
			String brandID = Utility.getName(request.getParameter("brandID"));
			String brandName = Utility.getName(request.getParameter("brandName"));
			if (goodsTree.equals("1"))
			{
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				goodsInfoPo.setBgisuppliername(Utility.getName(supplierPo.getBspsuppliername()));
			}
			if(!"".equals(supplierID)) {
				goodsInfoPo.setBgisupplierid(supplierID);
			}
			if(!"".equals(brandID)) {
				goodsInfoPo.setBgibrandid(brandID);
			}
			if(!"".equals(brandName)) {
				goodsInfoPo.setBgibrandname(brandName);
			}
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			request.setAttribute("goodsInfoPo", goodsInfoPo);
			return SUCCESS;
		}
		
	}

	/**
	 * 初始化老花镜类修改
	 */
	public String initPresbyopicGlassesUpdateAR() throws Exception {

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
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		colorList = colorMgr.getColorList();
		goodsInfoPo = presbyopicGlassesMgr.getPresbyopicGlasses(goodsInfoPo);
		unitList = unitMgr.getUnitList();
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		return SUCCESS;
	}

	/**
	 * 初始化老花镜类详细
	 */
	public String initPresbyopicGlassesDetailsAR() throws Exception {

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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		goodsInfoPo = presbyopicGlassesMgr.getPresbyopicGlasses(goodsInfoPo);
		unitList = unitMgr.getUnitList();
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		return SUCCESS;
	}

	/**
	 * 修改老花镜类
	 */
	public String updatePresbyopicGlassesAR() throws Exception {
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
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		colorList = colorMgr.getColorList();
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String[] goodsnametype = systemParameterPo.getFspclh().trim().split(",");
		GoodsInfoPo vgoodsInfoPo = presbyopicGlassesMgr.getPresbyopicGlasses(goodsInfoPo);
		
		String viewgoodsname = goodsInfoPo.getBgigoodsname();
		for(int i=0; i<goodsnametype.length; i++){
			if(goodsnametype[i].trim().equals("B_GI_Spec")){
				viewgoodsname = viewgoodsname + "-型号："+vgoodsInfoPo.getBgispec();
			} else if(goodsnametype[i].trim().equals("B_GI_Color")){
				viewgoodsname = viewgoodsname + "-颜色："+vgoodsInfoPo.getBgichinesecolorname();
			} else if(goodsnametype[i].trim().equals("B_GI_Sph")){
				viewgoodsname = viewgoodsname + "-球镜："+vgoodsInfoPo.getBgisph();
			} else if(goodsnametype[i].trim().equals("B_GI_RetailPrice")){
				viewgoodsname = viewgoodsname + "-标价："+goodsInfoPo.getBgiretailprice();
			} else if(goodsnametype[i].trim().equals("B_GI_FrameSize")){
				viewgoodsname = viewgoodsname + "-尺寸："+goodsInfoPo.getBgiframesize();
			}
		}
		goodsInfoPo.setBgiviewgoodsname(viewgoodsname);
		
		goodsInfoPo.setBginottaxrate(getNottaxrate(goodsInfoPo
				.getBgicostprice(), goodsInfoPo.getBgitaxrate()));
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("老花镜:" + goodsInfoPo.getBgigoodsid() + "修改!");
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		presbyopicGlassesMgr.updatePresbyopicGlasses(goodsInfoPo,logPo);		
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
	 * 初始化老花镜类删除
	 */
	public String initPresbyopicGlassesDeleteAR() throws Exception {
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
		goodsInfoPo = presbyopicGlassesMgr.getPresbyopicGlasses(goodsInfoPo);
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);

		return SUCCESS;
	}

	/**
	 * 删除老花镜类
	 */
	public String deletePresbyopicGlassesAR() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("老花镜:" + goodsInfoPo.getBgigoodsid() + "删除!");
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		int flag = lensFinishedMgr.getGoodsCount(goodsInfoPo);
		this.clearMessages();
		if (flag == 0) 
		{			
			presbyopicGlassesMgr.deletePresbyopicGlasses(goodsInfoPo,logPo);
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
			
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			this.addActionMessage(getText("存在商品库存或业务单据,删除失败!"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}
		
		return SUCCESS;
	}

	/**
	 * 初始化老花镜类停用
	 */
	public String initPresbyopicGlassesDisableAR() throws Exception {
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

		goodsInfoPo = presbyopicGlassesMgr.getPresbyopicGlasses(goodsInfoPo);

		return SUCCESS;
	}

	/**
	 * 停用老花镜类
	 */
	public String disablePresbyopicGlassesAR() throws Exception {
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
		logPo.setsLogContent("老花镜:" + goodsInfoPo.getBgigoodsid() + "停用!");
		presbyopicGlassesMgr.updatePresbyopicGlassesDisable(goodsInfoPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化老花镜类启用
	 */
	public String initPresbyopicGlassesAbleAR() throws Exception {
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

		goodsInfoPo = presbyopicGlassesMgr.getPresbyopicGlasses(goodsInfoPo);

		return SUCCESS;
	}

	/**
	 * 启用老花镜类
	 */
	public String ablePresbyopicGlassesAR() throws Exception {
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
		logPo.setsLogContent("老花镜:" + goodsInfoPo.getBgigoodsid() + "启用!");
		presbyopicGlassesMgr.updatePresbyopicGlassesDisable(goodsInfoPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
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
