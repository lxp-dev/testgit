package com.pengsheng.eims.basic.action;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
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
import com.pengsheng.eims.util.tools.TurnSphCyl;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
/**
 * 镜架成品片action
 */
public class LensFinishedARAction extends BaseAction {
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<RefractiveSetPo> refractiveSetPos;
	private LensFinishedMgr lensFinishedMgr;
	private List<RefractiveSetPo> refractiveSetList = null;
	private UnitMgr unitMgr;	
	private GlassesFrameMgr glassesFrameMgr;
	private SupplierMgr supplierMgr;	
	private GoodsInfoPo goodsInfoPo;
	private List<GoodsInfoPo> goodsInfos;
	private List<UnitPo> unitList;	
	private PersonPermissionMgr personPermissionMgr;	
	private OtherGoodsMgr otherGoodsMgr;
	private List<GoodsLevelPo> selectGoodsLevelList;
	private BrandMgr brandMgr;
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

	public List<GoodsLevelPo> getSelectGoodsLevelList() {
		return selectGoodsLevelList;
	}

	public void setSelectGoodsLevelList(List<GoodsLevelPo> selectGoodsLevelList) {
		this.selectGoodsLevelList = selectGoodsLevelList;
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}

	public List<RefractiveSetPo> getRefractiveSetPos() {
		return refractiveSetPos;
	}

	public void setRefractiveSetPos(List<RefractiveSetPo> refractiveSetPos) {
		this.refractiveSetPos = refractiveSetPos;
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
	
	public List<RefractiveSetPo> getRefractiveSetList() {
		return refractiveSetList;
	}
	public void setRefractiveSetList(List<RefractiveSetPo> refractiveSetList) {
		this.refractiveSetList = refractiveSetList;
	}
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

	public LensFinishedMgr getLensFinishedMgr() {
		return lensFinishedMgr;
	}

	public void setLensFinishedMgr(LensFinishedMgr lensFinishedMgr) {
		this.lensFinishedMgr = lensFinishedMgr;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}

	public List<GoodsInfoPo> getGoodsInfos() {
		return goodsInfos;
	}

	public void setGoodsInfos(List<GoodsInfoPo> goodsInfos) {
		this.goodsInfos = goodsInfos;
	}

	public List<UnitPo> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<UnitPo> unitList) {
		this.unitList = unitList;
	}

	/**
	 * 初始化成品镜片类查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initLensFinishedSelAR() throws Exception {

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
				return "selLensFinishedAR";
			}
			
		refractiveSetPos = unitMgr.getRefractiveSetList();
		
		return SUCCESS;
	}

	/**
	 * 查询成品镜片类
	 */
	public String selLensFinishedAR() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

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
		String barcodeflag=Utility.getName(request.getParameter("barcodeflag"));
		
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		request.setAttribute("barcodeflag", barcodeflag);

		refractiveSetPos = unitMgr.getRefractiveSetList();
		
		//框镜镜片
		String bgieyeglassmaterialtypejp = Utility.getName(request.getParameter("bgieyeglassmaterialtypejp"));
		String bgirefractivejp = Utility.getName(request.getParameter("bgirefractivejp"));
		String bgiismutiluminosityjp = Utility.getName(request.getParameter("bgiismutiluminosityjp"));
		//翻方前
		String minSphjp = Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp = Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp = Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp = Utility.getName(request.getParameter("maxCyljp"));
		//翻方后
		String changeMinSphjp = Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphjp"), request.getParameter("minCyljp")));
		String changeMaxSphjp = Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphjp"),request.getParameter("maxCyljp")));
		String changeMinCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCyljp"),request.getParameter("minCyljp")));
		String changeMaxCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCyljp"),request.getParameter("maxCyljp")));
		
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		
		//收费项目
		String bgipayfeeid = Utility.getName(request.getParameter("bgipayfeeid"));
		String bgiissetflag = Utility.getName(request.getParameter("bgiissetflag"));
		request.setAttribute("bgipayfeeid", bgipayfeeid);
		request.setAttribute("bgiissetflag", bgiissetflag);
		
		goodsInfoPo = new GoodsInfoPo();

		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgiflag(isClosed);
		goodsInfoPo.setBgiwhichretail(whichretail);
		goodsInfoPo.setBgiismendretail(select_retail);		
		goodsInfoPo.setBgieyeglassmaterialtype(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractive(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosity(bgiismutiluminosityjp);
		goodsInfoPo.setMaxSph(changeMaxSphjp);
		goodsInfoPo.setMinSph(changeMinSphjp);
		goodsInfoPo.setMaxCyl(changeMaxCyljp);
		goodsInfoPo.setMinCyl(changeMinCyljp);
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

		// 成品镜片
		goodsInfoPo.setBgigoodscategoryid("3");
		goodsInfoPo.setBgiiscustomize("0");

		int count = lensFinishedMgr.getLensFinishedCount(goodsInfoPo);
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
			goodsInfos = lensFinishedMgr.getLensFinishedList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsInfos = null;
		}

		request.setAttribute("goodsID", goodsID);
		request.setAttribute("isClosed", isClosed);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
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
	 * 初始化成品镜片类新增
	 */
	public String initLensFinishedInsertAR() throws Exception {

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
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		goodsInfoPo = new GoodsInfoPo();
		unitList = unitMgr.getUnitList();
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		refractiveSetList = unitMgr.getRefractiveSetList();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
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
		goodsInfoPo.setBgicolor("0000");
		goodsInfoPo.setBgitaxrate("17");
		goodsInfoPo.setBgivcyl("0.00");
		goodsInfoPo.setBgivsph("0.00");
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		if("1".equals(systemParameterPo.getFspnegative())){
			request.setAttribute("goodsIdNegative", "3.00.00.AA0000000.0000");
		}else{
			request.setAttribute("goodsIdNegative", "3.00.00.CA0000000.0000");
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		return SUCCESS;
	}
	
	/**
	 * 初始化成品镜片类新增
	 */
	public String initLensFinished2DInsertAR() throws Exception {

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
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		goodsInfoPo = new GoodsInfoPo();
		unitList = unitMgr.getUnitList();
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		refractiveSetList = unitMgr.getRefractiveSetList();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
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
		goodsInfoPo.setBgicolor("0000");
		goodsInfoPo.setBgitaxrate("17");
		goodsInfoPo.setBgivcyl("0.00");
		goodsInfoPo.setBgivsph("0.00");
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		if("1".equals(systemParameterPo.getFspnegative())){
			request.setAttribute("goodsIdNegative", "3.00.00.AA0000000.0000");
		}else{
			request.setAttribute("goodsIdNegative", "3.00.00.CA0000000.0000");
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		return SUCCESS;
	}

	/**
	 * 新增成品镜片类
	 */
	public String insertLensFinishedAR() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		GoodsInfoPo po = lensFinishedMgr.getLensFinished(goodsInfoPo);
		GoodsInfoPo po1 = glassesFrameMgr.getGlassesFrameCode(goodsInfoPo);
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("成品镜片:" + goodsInfoPo.getBgigoodsid() + "新增!");
		
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String[] goodsnametype = systemParameterPo.getFspcjp().trim().split(",");
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
		if (po.getBgigoodsid() == null&&lensFinishedMgr.getLensFinishedCountNV(goodsInfoPo)==0) {
			if(po1.getBgigoodsbarcode()==null)
			{
				goodsInfoPo.setBgigoodscategoryid("3");
				goodsInfoPo.setBgiiscustomize("0");
				goodsInfoPo.setBginottaxrate(getNottaxrate(goodsInfoPo
						.getBgicostprice(), goodsInfoPo.getBgitaxrate()));
				goodsInfoPo.setBgiflag("1");
				lensFinishedMgr.insertLensFinished(goodsInfoPo,logPo);
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				if(goodsTree.equals("1"))
				{		
					request.setAttribute("goodsIdNegative", request.getParameter("goodsIdNegative"));
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
					return "rtree";
				
				}else{

					request.setAttribute("goodsInfoPo", goodsInfoPo);
					request.setAttribute("goodsIdNegative", request.getParameter("goodsIdNegative"));
					unitList = unitMgr.getUnitList();
					refractiveSetList = unitMgr.getRefractiveSetList();			
					return SUCCESS;
				}
			}else
			{	
				this.addActionMessage(getText("商品条码重复"));
				unitList = unitMgr.getUnitList();
				refractiveSetList = unitMgr.getRefractiveSetList();			
				request.setAttribute("goodsInfoPo", goodsInfoPo);
				request.setAttribute("parent", parent);
				request.setAttribute("goodsTree", goodsTree);
				
				request.setAttribute("goodsIdNegative", request.getParameter("goodsIdNegative"));
				return SUCCESS;
			}
		} else {
			if("1".equals(Utility.getName(systemParameterPo.getFspnegative()))){
				GoodsInfoPo goods=new GoodsInfoPo();
				goods.setBgigoodsid(request.getParameter("goodsIdNegative"));
				if(!"".equals(Utility.getName(lensFinishedMgr.getLensFinished(goods).getBgigoodsid()))||lensFinishedMgr.getLensFinishedCountNV(goodsInfoPo)!=0){
					if(lensFinishedMgr.getLensFinishedCountNV(goodsInfoPo)!=0&&"".equals(Utility.getName(lensFinishedMgr.getLensFinished(goods).getBgigoodsid()))){
						this.addActionMessage(getText("struts.messages.repeat"));
					}else if(!"".equals(Utility.getName(lensFinishedMgr.getLensFinished(goods).getBgigoodsid()))&&lensFinishedMgr.getLensFinishedCountNV(goodsInfoPo)==0){
						this.addActionMessage(getText("与商品"+glassesFrameMgr.getGlassesFrame(goods).getBgigoodsid()+"重复！"));
					}else{
						this.addActionMessage(getText("struts.messages.repeat"));
					}
					unitList = unitMgr.getUnitList();
					refractiveSetList = unitMgr.getRefractiveSetList();			
					request.setAttribute("goodsInfoPo", goodsInfoPo);
					request.setAttribute("parent", parent);
					request.setAttribute("goodsTree", goodsTree);
					
					request.setAttribute("goodsIdNegative", request.getParameter("goodsIdNegative"));
					return SUCCESS;
				}
			}
			this.addActionMessage(getText("struts.messages.repeat"));
			unitList = unitMgr.getUnitList();
			refractiveSetList = unitMgr.getRefractiveSetList();			
			request.setAttribute("goodsInfoPo", goodsInfoPo);
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			
			request.setAttribute("goodsIdNegative", request.getParameter("goodsIdNegative"));
			return SUCCESS;
		}

	}
	
	/**
	 * 新增成品镜片类
	 */
	public String insertLensFinished2DAR() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String[] sphstemp = {                           "-20.00",
							 "-19.75","-19.50","-19.25","-19.00",
							 "-18.75","-18.50","-18.25","-18.00",
							 "-17.75","-17.50","-17.25","-17.00",
							 "-16.75","-16.50","-16.25","-16.00",
							 "-15.75","-15.50","-15.25","-15.00",
							 "-14.75","-14.50","-14.25","-14.00",
							 "-13.75","-13.50","-13.25","-13.00",
							 "-12.75","-12.50","-12.25","-12.00",
							 "-11.75","-11.50","-11.25","-11.00",
							 "-10.75","-10.50","-10.25","-10.00",
							  "-9.75", "-9.50", "-9.25", "-9.00",
							  "-8.75", "-8.50", "-8.25", "-8.00",
							  "-7.75", "-7.50", "-7.25", "-7.00",
							  "-6.75", "-6.50", "-6.25", "-6.00",
							  "-5.75", "-5.50", "-5.25", "-5.00",
							  "-4.75", "-4.50", "-4.25", "-4.00",
							  "-3.75", "-3.50", "-3.25", "-3.00",
							  "-2.75", "-2.50", "-2.25", "-2.00",
							  "-1.75", "-1.50", "-1.25", "-1.00",
							  "-0.75", "-0.50", "-0.25",  "0.00",
							  "+0.25", "+0.50", "+0.75", "+1.00",
							  "+1.25", "+1.50", "+1.75", "+2.00",
							  "+2.25", "+2.50", "+2.75", "+3.00",
							  "+3.25", "+3.50", "+3.75", "+4.00",
							  "+4.25", "+4.50", "+4.75", "+5.00",
							  "+5.25", "+5.50", "+5.75", "+6.00",
							  "+6.25", "+6.50", "+6.75", "+7.00",
							  "+7.25", "+7.50", "+7.75", "+8.00",
							  "+8.25", "+8.50", "+8.75", "+9.00",
							  "+9.25", "+9.50", "+9.75","+10.00",
							 "+10.25","+10.50","+10.75","+11.00",
							 "+11.25","+11.50","+11.75","+12.00",
							 "+12.25","+12.50","+12.75","+13.00",
							 "+13.25","+13.50","+13.75","+14.00",
							 "+14.25","+14.50","+14.75","+15.00",
							 "+15.25","+15.50","+15.75","+16.00",
							 "+16.25","+16.50","+16.75","+17.00",
							 "+17.25","+17.50","+17.75","+18.00",
							 "+18.25","+18.50","+18.75","+19.00",
							 "+19.25","+19.50","+19.75","+20.00",
							 "+20.25","+20.50","+20.75","+21.00",
							 "+21.25","+21.50","+21.75","+22.00",
							 "+22.25","+22.50","+22.75","+23.00",
							 "+23.25","+23.50","+23.75","+24.00",
							 "+24.25","+24.50","+24.75","+25.00",
							 "+25.25","+25.50","+25.75","+26.00",
							 "+26.25","+26.50","+26.75","+27.00",
							 "+27.25","+27.50","+27.75","+28.00",
							 "+28.25","+28.50","+28.75","+29.00",
							 "+29.25","+29.50","+29.75","+30.00",
							 "+30.25","+30.50","+30.75","+31.00"
							 };
		
		String[] cylstemp = {                        "-6.00",                    
							 "-5.75","-5.50","-5.25","-5.00",
							 "-4.75","-4.50","-4.25","-4.00",
							 "-3.75","-3.50","-3.25","-3.00",
							 "-2.75","-2.50","-2.25","-2.00",
							 "-1.75","-1.50","-1.25","-1.00",
							 "-0.75","-0.50","-0.25", "0.00"
				 			};
		if("1".equals(systemParameterPo.getFspnegative())){
			cylstemp = new String[]{                     "-6.00",                    
								 "-5.75","-5.50","-5.25","-5.00",
								 "-4.75","-4.50","-4.25","-4.00",
								 "-3.75","-3.50","-3.25","-3.00",
								 "-2.75","-2.50","-2.25","-2.00",
								 "-1.75","-1.50","-1.25","-1.00",
								 "-0.75","-0.50","-0.25", "0.00",
								 "+0.25","+0.50","+0.75","+1.00",
								 "+1.25","+1.50","+1.75","+2.00",
								 "+2.25","+2.50","+2.75","+3.00",
								 "+3.25","+3.50","+3.75","+4.00",
								 "+4.25","+4.50","+4.75","+5.00",
								 "+5.25","+5.50","+5.75","+6.00"
				 			};
		}
		
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		if(!"".equals(Utility.getName(personInfoPo.getSyspsupplierid()))){
			goodsInfoPo.setBgisupplierid(Utility.getName(personInfoPo.getSyspsupplierid()));
			goodsInfoPo.setBgisuppliername(Utility.getName(personInfoPo.getSyspsuppliername()));
		}
		
		request.setAttribute("defaultdiscountvalue", goodsInfoPo.getBgidefaultdiscountvalue());
		
		String message = "以下商品：\\n";
		this.clearMessages();
		goodsInfoPo.setBgigoodscategoryid("3");
		goodsInfoPo.setBgiiscustomize("0");
		goodsInfoPo.setBginottaxrate(getNottaxrate(goodsInfoPo.getBgicostprice(), goodsInfoPo.getBgitaxrate()));
		goodsInfoPo.setBgiflag("1");
		
		DecimalFormat df = new DecimalFormat("######0.00");
		
		String[] sphs = Utility.getName(request.getParameter("sphs")).split(",");
		String[] cyls = Utility.getName(request.getParameter("cyls")).split(",");
		
		List<GoodsInfoPo> glist = new ArrayList<GoodsInfoPo>();
		List<LogisticsLogPo> loglist = new ArrayList<LogisticsLogPo>();
		for(int i=0; i<sphs.length; i++){
			if(!"".equals(sphs[i])){
				GoodsInfoPo addpo = new GoodsInfoPo();
				addpo.setBgigoodsname(Utility.getName(goodsInfoPo.getBgigoodsname()));
				addpo.setBgigoodscategoryid(Utility.getName(goodsInfoPo.getBgigoodscategoryid()));
				addpo.setBgisupplierid(Utility.getName(goodsInfoPo.getBgisupplierid()));
				addpo.setBgibrandid(Utility.getName(goodsInfoPo.getBgibrandid()));
				addpo.setBgiunitid(Utility.getName(goodsInfoPo.getBgiunitid()));
				addpo.setBgiretailprice(Utility.getName(goodsInfoPo.getBgiretailprice()));
				addpo.setBgicostprice(Utility.getName(goodsInfoPo.getBgicostprice()));
				addpo.setBginottaxrate(Utility.getName(goodsInfoPo.getBginottaxrate()));
				addpo.setBgitaxrate(Utility.getName(goodsInfoPo.getBgitaxrate()));
				addpo.setBgispec(Utility.getName(goodsInfoPo.getBgispec()));
				addpo.setBgicolor(Utility.getName(goodsInfoPo.getBgicolor()));
				addpo.setBgiiscustomize(Utility.getName(goodsInfoPo.getBgiiscustomize()));
				addpo.setBgibelowplusluminosity(Utility.getName(goodsInfoPo.getBgibelowplusluminosity()));
				addpo.setBgibelowplusluminosityul(Utility.getName(goodsInfoPo.getBgibelowplusluminosityul()));
				addpo.setBgibelowplusluminosityup(Utility.getName(goodsInfoPo.getBgibelowplusluminosityup()));
				addpo.setBgiaxis(Utility.getName(goodsInfoPo.getBgiaxis()));
				addpo.setBgiaxisul(Utility.getName(goodsInfoPo.getBgiaxisul()));
				addpo.setBgiaxisup(Utility.getName(goodsInfoPo.getBgiaxisup()));
				addpo.setBgicurvature1(Utility.getName(goodsInfoPo.getBgicurvature1()));
				addpo.setBgicurvature1ul(Utility.getName(goodsInfoPo.getBgicurvature1ul()));
				addpo.setBgicurvature1up(Utility.getName(goodsInfoPo.getBgicurvature1up()));
				addpo.setBgicurvature2(Utility.getName(goodsInfoPo.getBgicurvature2()));
				addpo.setBgicurvature2ul(Utility.getName(goodsInfoPo.getBgicurvature2ul()));
				addpo.setBgicurvature2up(Utility.getName(goodsInfoPo.getBgicurvature2up()));
				addpo.setBgidia(Utility.getName(goodsInfoPo.getBgidia()));
				addpo.setBgidiaul(Utility.getName(goodsInfoPo.getBgidiaul()));
				addpo.setBgidiaup(Utility.getName(goodsInfoPo.getBgidiaup()));
				addpo.setBgiismutiluminosity(Utility.getName(goodsInfoPo.getBgiismutiluminosity()));
				addpo.setBgimutiluminositynum(Utility.getName(goodsInfoPo.getBgimutiluminositynum()));
				addpo.setBgimutiluminosityaddprice(Utility.getName(goodsInfoPo.getBgimutiluminosityaddprice()));
				addpo.setBgieyeglassmaterialtype(Utility.getName(goodsInfoPo.getBgieyeglassmaterialtype()));
				addpo.setBgiisplating(Utility.getName(goodsInfoPo.getBgiisplating()));
				addpo.setBgiordercycle(Utility.getName(goodsInfoPo.getBgiordercycle()));
				addpo.setBgifinishedglassestype(Utility.getName(goodsInfoPo.getBgifinishedglassestype()));
				addpo.setBgiframeprocesscrafttype(Utility.getName(goodsInfoPo.getBgiframeprocesscrafttype()));
				addpo.setBgicylmin(Utility.getName(goodsInfoPo.getBgicylmin()));
				addpo.setBgicylminaddprice(Utility.getName(goodsInfoPo.getBgicylminaddprice()));
				addpo.setBgicyladdprice(Utility.getName(goodsInfoPo.getBgicyladdprice()));
				addpo.setBgiprismaddprice(Utility.getName(goodsInfoPo.getBgiprismaddprice()));
				addpo.setBgicyl25cannotdo(Utility.getName(goodsInfoPo.getBgicyl25cannotdo()));
				addpo.setBgithrowingcycle(Utility.getName(goodsInfoPo.getBgithrowingcycle()));
				addpo.setBgistealthtype(Utility.getName(goodsInfoPo.getBgistealthtype()));
				addpo.setBgiothergoodsbigclass(Utility.getName(goodsInfoPo.getBgiothergoodsbigclass()));
				addpo.setBgiothergoodssmallclass(Utility.getName(goodsInfoPo.getBgiothergoodssmallclass()));
				addpo.setBgiflag(Utility.getName(goodsInfoPo.getBgiflag()));
				addpo.setBgirefractive(Utility.getName(goodsInfoPo.getBgirefractive()));
				addpo.setBgiwholesaleprice(Utility.getName(goodsInfoPo.getBgiwholesaleprice()));
				addpo.setBgigradualclass(Utility.getName(goodsInfoPo.getBgigradualclass()));
				addpo.setBgifunctionclass(Utility.getName(goodsInfoPo.getBgifunctionclass()));
				addpo.setBgiaveragenotnaxrate(Utility.getName(goodsInfoPo.getBgiaveragenotnaxrate()));
				addpo.setBgiretailpricea(Utility.getName(goodsInfoPo.getBgiretailpricea()));
				addpo.setBgiretailpriceb(Utility.getName(goodsInfoPo.getBgiretailpriceb()));
				addpo.setBgiretailpricec(Utility.getName(goodsInfoPo.getBgiretailpricec()));
				addpo.setBgiretailpriced(Utility.getName(goodsInfoPo.getBgiretailpriced()));
				addpo.setBgiretailpricee(Utility.getName(goodsInfoPo.getBgiretailpricee()));
				addpo.setBgiretailpricef(Utility.getName(goodsInfoPo.getBgiretailpricef()));
				addpo.setBgiretailpriceg(Utility.getName(goodsInfoPo.getBgiretailpriceg()));
				addpo.setBgiretailpriceh(Utility.getName(goodsInfoPo.getBgiretailpriceh()));
				addpo.setBgiretailpricei(Utility.getName(goodsInfoPo.getBgiretailpricei()));
				addpo.setBgibarcodeflag(Utility.getName(goodsInfoPo.getBgibarcodeflag()));
				addpo.setBgidefaultdiscountvalue(Utility.getName(goodsInfoPo.getBgidefaultdiscountvalue()));
				addpo.setBgipayfeeid(Utility.getName(goodsInfoPo.getBgipayfeeid()));
				
				String goodsid ="3."+goodsInfoPo.getBgisupplierid()+"."+goodsInfoPo.getBgibrandid()+".";
				Double sphtemp = Double.parseDouble(sphstemp[Integer.parseInt(sphs[i])]);
				Double cyltemp = Double.parseDouble(cylstemp[Integer.parseInt(cyls[i])]);
				
				if("1".equals(systemParameterPo.getFspnegative())){
					String sphtype = "";
					String cyltype = "";
					
					if(sphtemp > 0){
						sphtype = "B";
					}else{
						sphtype = "A";
					}
					
					if(cyltemp > 0){
						cyltype = "B";
					}else{
						cyltype = "A";
					}
					
					goodsid = goodsid + sphtype + cyltype;
				}else{
					if(sphtemp > 0){
						goodsid = goodsid + "CB";
					}else{
						goodsid = goodsid + "CA";
					}
				}
				
				if("1".equals(systemParameterPo.getFspnegative())){
					if(cyltemp > 0){
						Double sph = sphtemp + cyltemp;
						Double cyl = -cyltemp;
						
						if(sphtemp > 0){
							addpo.setBgisph("+"+df.format(sphtemp)+"");
						}else{
							addpo.setBgisph(df.format(sphtemp)+"");
						}
						
						if(cyltemp > 0){
							addpo.setBgicyl("+"+df.format(cyltemp)+"");
						}else{
							addpo.setBgicyl(df.format(cyltemp)+"");
						}
						
						if(sph > 0){
							addpo.setBgivsph("+"+df.format(sph)+"");
						}else{
							addpo.setBgivsph(df.format(sph)+"");
						}
						
						if(cyl > 0){
							addpo.setBgivcyl("+"+df.format(cyl)+"");
						}else{
							addpo.setBgivcyl(df.format(cyl)+"");
						}
					}else{
						if(sphtemp > 0){
							addpo.setBgisph("+"+df.format(sphtemp)+"");
							addpo.setBgivsph("+"+df.format(sphtemp)+"");
						}else{
							addpo.setBgisph(df.format(sphtemp)+"");
							addpo.setBgivsph(df.format(sphtemp)+"");
						}
						
						if(cyltemp > 0){
							addpo.setBgicyl("+"+df.format(cyltemp)+"");
							addpo.setBgivcyl("+"+df.format(cyltemp)+"");
						}else{
							addpo.setBgicyl(df.format(cyltemp)+"");
							addpo.setBgivcyl(df.format(cyltemp)+"");
						}
					}
				}else{
					if(sphtemp > 0){
						addpo.setBgisph("+"+df.format(sphtemp)+"");
						addpo.setBgivsph("+"+df.format(sphtemp)+"");
					}else{
						addpo.setBgisph(df.format(sphtemp)+"");
						addpo.setBgivsph(df.format(sphtemp)+"");
					}
					
					if(cyltemp > 0){
						addpo.setBgicyl("+"+df.format(cyltemp)+"");
						addpo.setBgivcyl("+"+df.format(cyltemp)+"");
					}else{
						addpo.setBgicyl(df.format(cyltemp)+"");
						addpo.setBgivcyl(df.format(cyltemp)+"");
					}
				}
				
				if(Double.parseDouble(addpo.getBgisph()) == 0){
					goodsid = goodsid + "0000";
				}else{
					if(addpo.getBgisph().length() == 5){
						goodsid = goodsid + "0"+ addpo.getBgisph().replace("+", "").replace("-", "").replace(".", "");
					}else{
						goodsid = goodsid + addpo.getBgisph().replace("+", "").replace("-", "").replace(".", "");
					}
				}
				
				goodsid = goodsid + addpo.getBgicyl().replace("+", "").replace("-", "").replace(".", "")+".";
				
				if(goodsInfoPo.getBgicolor().length() == 1){
					goodsid = goodsid + "000" + goodsInfoPo.getBgicolor();
				}else if(goodsInfoPo.getBgicolor().length() == 2){
					goodsid = goodsid + "00" + goodsInfoPo.getBgicolor();
				}else if(goodsInfoPo.getBgicolor().length() == 3){
					goodsid = goodsid + "0" + goodsInfoPo.getBgicolor();
				}else{
					goodsid = goodsid + goodsInfoPo.getBgicolor().substring(goodsInfoPo.getBgicolor().length()-4, goodsInfoPo.getBgicolor().length());
				}
				
				addpo.setBgigoodsid(goodsid);
				addpo.setBgigoodsbarcode(goodsid.replace(".", ""));
				
				
				String[] goodsnametype = systemParameterPo.getFspcjp().trim().split(",");
				String viewgoodsname = addpo.getBgigoodsname();
				for(int j=0; j<goodsnametype.length; j++){
					if(goodsnametype[j].trim().equals("B_GI_Spec")){
						viewgoodsname = viewgoodsname + "-型号："+addpo.getBgispec();
					} else if(goodsnametype[j].trim().equals("B_GI_Color")){
						viewgoodsname = viewgoodsname + "-颜色："+addpo.getBgichinesecolorname();
					} else if(goodsnametype[j].trim().equals("B_GI_Sph")){
						viewgoodsname = viewgoodsname + "-球镜："+addpo.getBgisph();
					} else if(goodsnametype[j].trim().equals("B_GI_Cyl")){
						viewgoodsname = viewgoodsname + "-柱镜："+addpo.getBgicyl();
					} else if(goodsnametype[j].trim().equals("B_GI_RetailPrice")){
						viewgoodsname = viewgoodsname + "-标价："+addpo.getBgiretailprice();
					}
				}
				addpo.setBgiviewgoodsname(viewgoodsname);
				
				//添加日志
				LogisticsLogPo logPo = new LogisticsLogPo();
				logPo.setsLogName(createPerson);
				logPo.setsLogIP(request.getRemoteAddr());
				logPo.setsLogResult(moduleID); // 表示模块名称 
				logPo.setsLogOpID("1");    // 表示状态
				logPo.setsLogContent("成品镜片:" + addpo.getBgigoodsid() + "新增!");
				
				GoodsInfoPo po = lensFinishedMgr.getLensFinished(addpo);
				
				if("".equals(Utility.getName(po.getBgigoodsid()))){
					glist.add(addpo);
					loglist.add(logPo);
				}else{
					message = message + addpo.getBgigoodsid()+"\\n";
				}
					
				
			}
		}
		
		lensFinishedMgr.insertLensFinisheds(glist,loglist);
		message = message + "已存在，其他商品插入成功！";
		if(message.length() > 25){
		}else{
			message = "新增成功！";
		}
		
		
		this.addActionMessage(message+"");
		request.setAttribute("goodsInfoPo", goodsInfoPo);
		request.setAttribute("goodsIdNegative", request.getParameter("goodsIdNegative"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
		unitList = unitMgr.getUnitList();
		refractiveSetList = unitMgr.getRefractiveSetList();	
		
		return SUCCESS;
	}

	/**
	 * 初始化成品镜片类修改
	 */
	public String initLensFinishedUpdateAR() throws Exception {
		
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
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		goodsInfoPo = lensFinishedMgr.getLensFinished(goodsInfoPo);
		unitList = unitMgr.getUnitList();

		refractiveSetList = unitMgr.getRefractiveSetList();
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));

		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		return SUCCESS;
	}
	
	/**
	 * 初始化成品镜片类详细
	 */
	public String initLensFinishedDetailsAR() throws Exception {
		
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
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String id = Utility.getName(request.getParameter("hid"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);

		goodsInfoPo = lensFinishedMgr.getLensFinished(goodsInfoPo);
		unitList = unitMgr.getUnitList();

		refractiveSetList = unitMgr.getRefractiveSetList();
		
		return SUCCESS;
	}

	/**
	 * 修改成品镜片类
	 */
	public String updateLensFinishedAR() throws Exception {
		
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
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		GoodsInfoPo vgoodspo = lensFinishedMgr.getLensFinished(goodsInfoPo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String[] goodsnametype = systemParameterPo.getFspcjp().trim().split(",");
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
		
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		goodsInfoPo.setBginottaxrate(getNottaxrate(goodsInfoPo.getBgicostprice(), goodsInfoPo.getBgitaxrate()));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("成品镜片:" + goodsInfoPo.getBgigoodsid() + "修改!");
		lensFinishedMgr.updateLensFinished(goodsInfoPo,logPo);
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
	 * 初始化成品镜片类删除
	 */
	public String initLensFinishedDeleteAR() throws Exception {
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

		
		goodsInfoPo = lensFinishedMgr.getLensFinished(goodsInfoPo);
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));

		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		return SUCCESS;
	}

	/**
	 * 删除成品镜片类
	 */
	public String deleteLensFinishedAR() throws Exception {
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
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(id);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("成品镜片:" + goodsInfoPo.getBgigoodsid() + "删除!");
		
		int flag = lensFinishedMgr.getGoodsCount(goodsInfoPo);
		this.clearMessages();
		if (flag == 0) {
			lensFinishedMgr.deleteLensFinished(goodsInfoPo,logPo);
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
		} else {
			this.addActionMessage(getText("存在商品库存或业务单据,删除失败!"));
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}
		return SUCCESS;
	}

	/**
	 * 初始化成品镜片类停用
	 */
	public String initLensFinishedDisableAR() throws Exception {
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

		goodsInfoPo = lensFinishedMgr.getLensFinished(goodsInfoPo);

		return SUCCESS;
	}

	/**
	 * 停用成品镜片类
	 */
	public String disableLensFinishedAR() throws Exception {
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
		logPo.setsLogContent("成品镜片:" + goodsInfoPo.getBgigoodsid() + "停用!");
		lensFinishedMgr.updateLendsFinishedDisable(goodsInfoPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化成品镜片类启用
	 */
	public String initLensFinishedAbleAR() throws Exception {
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

		goodsInfoPo = lensFinishedMgr.getLensFinished(goodsInfoPo);

		return SUCCESS;
	}

	/**
	 * 启用成品镜片类
	 */
	public String ableLensFinishedAR() throws Exception {
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
		logPo.setsLogContent("成品镜片:" + goodsInfoPo.getBgigoodsid() + "启用!");
		lensFinishedMgr.updateLendsFinishedDisable(goodsInfoPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化成品镜片类批量新增
	 */
	public String initLensFinishedInsertBulkAR() throws Exception {
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
		goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgitaxrate("17");
		unitList = unitMgr.getUnitList();
		refractiveSetList = unitMgr.getRefractiveSetList();
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		request.setAttribute("defaultdiscountvalue", request.getParameter("defaultdiscountvalue"));
		
		return SUCCESS;
	}

	/**
	 * 批量新增成品镜片类
	 */
	public String insertBulkLensFinishedAR() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		goodsInfoPo.setBgigoodscategoryid("3");
		goodsInfoPo.setBginottaxrate(getNottaxrate(goodsInfoPo.getBgicostprice(), goodsInfoPo.getBgitaxrate()));
		goodsInfoPo.setBgiiscustomize("0");
		goodsInfoPo.setBgiflag("1");
		if(!"".equals(Utility.getName(personInfoPo.getSyspsupplierid()))){
			goodsInfoPo.setBgisupplierid(Utility.getName(personInfoPo.getSyspsupplierid()));
			goodsInfoPo.setBgisuppliername(Utility.getName(personInfoPo.getSyspsuppliername()));
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("不含税价:" + goodsInfoPo.getBginottaxrate() + "成品镜片批量新增!");	
		
		lensFinishedMgr.insertLensFinishedBulk(systemParameterPo,goodsInfoPo,logPo);

		this.addActionMessage(getText("struts.messages.insert.sucess"));

		String url = "''initLensFinishedInsertBulkAR.action?moduleID={0}&defaultdiscountvalue="+goodsInfoPo.getBgidefaultdiscountvalue()+"''";
		List<String> params = new ArrayList<String>();
		params.add(moduleID);

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.INSERT);

		return SUCCESS;
	}

	private String getGoodsbarcode(String goodsID) {

		String goodsbarcode = "";
		String[] goodsid = goodsID.split("\\.");
		for (int i = 0; i < goodsid.length; i++) {
			goodsbarcode = goodsbarcode + goodsid[i];
		}
		return goodsbarcode;
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
}
