package com.pengsheng.eims.storage.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pengsheng.eims.basic.dao.impl.TechnologyTypePo;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsDetailsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.storage.mgr.StockSearchMgr;
import com.pengsheng.eims.storage.persistence.StockSearchWarehousePo;
import com.pengsheng.eims.storage.persistence.StrogeLogPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.FrameMaterialMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.TurnSphCyl;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * 库存查询action
 */
public class StockSearchAction extends BaseAction {
	
	private List<StockSearchWarehousePo> stockSearchWarehousePos;
	private List<RefractiveSetPo> refractiveSetPos;
	private ProcurementOrdersDao procurementOrdersDao;
	private UnitMgr unitMgr;
	private GoodsInfoPo goodsInfoPo;
	private List<StrogeLogPo> strogeLogList = null;
	private DepartmentsMgr departmentsMgr;
	
	//工艺类型和镜架材质
	private List<TechnologyTypePo> teachnologyList;
	private List<FrameMaterialPo> frameMaterialList;
	//注入镜架材质Mgr
	private FrameMaterialMgr frameMaterialMgr;
	
	
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	private ReportQuartzMgr reportQuartzMgr;
	private FquartzSwitchPo fquartzSwitchPo;
	
	public FquartzSwitchPo getFquartzSwitchPo() {
		return fquartzSwitchPo;
	}

	public void setFquartzSwitchPo(FquartzSwitchPo fquartzSwitchPo) {
		this.fquartzSwitchPo = fquartzSwitchPo;
	}

	public ReportQuartzMgr getReportQuartzMgr() {
		return reportQuartzMgr;
	}

	public void setReportQuartzMgr(ReportQuartzMgr reportQuartzMgr) {
		this.reportQuartzMgr = reportQuartzMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public List<StrogeLogPo> getStrogeLogList() {
		return strogeLogList;
	}

	public void setStrogeLogList(List<StrogeLogPo> strogeLogList) {
		this.strogeLogList = strogeLogList;
	}

	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}

	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	public List<RefractiveSetPo> getRefractiveSetPos() {
		return refractiveSetPos;
	}

	public void setRefractiveSetPos(List<RefractiveSetPo> refractiveSetPos) {
		this.refractiveSetPos = refractiveSetPos;
	}

	public List<StockSearchWarehousePo> getStockSearchWarehousePos() {
		return stockSearchWarehousePos;
	}

	public void setStockSearchWarehousePos(
			List<StockSearchWarehousePo> stockSearchWarehousePos) {
		this.stockSearchWarehousePos = stockSearchWarehousePos;
	}

	public ProcurementOrdersDao getProcurementOrdersDao() {
		return procurementOrdersDao;
	}

	public void setProcurementOrdersDao(
			ProcurementOrdersDao procurementOrdersDao) {
		this.procurementOrdersDao = procurementOrdersDao;
	}

	private VarietyMgr varietyMgr;

	private WarehouseMgr warehouseMgr;

	private StockSearchMgr stockSearchMgr;

	private List<GoodsCategoryPo> goodsCategorys;

	private List<WarehousePo> warehouselist;

	private List<GoodsInfoPo> goodsList;

	private List<GoodsInfoPo> brandsList;
	
	private List<GoodsInfoPo> codesList;

	private List<GoodsDetailsInfoPo> goodsDetailsList;
	
	private List stockSearchWarehousePoList;
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	
	
		
	public List<GoodsInfoPo> getCodesList() {
		return codesList;
	}

	public void setCodesList(List<GoodsInfoPo> codesList) {
		this.codesList = codesList;
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
	public List getStockSearchWarehousePoList() {
		return stockSearchWarehousePoList;
	}

	public void setStockSearchWarehousePoList(List stockSearchWarehousePoList) {
		this.stockSearchWarehousePoList = stockSearchWarehousePoList;
	}

	public List<GoodsDetailsInfoPo> getGoodsDetailsList() {
		return goodsDetailsList;
	}

	public void setGoodsDetailsList(List<GoodsDetailsInfoPo> goodsDetailsList) {
		this.goodsDetailsList = goodsDetailsList;
	}

	private PersonPermissionMgr personPermissionMgr;

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public List<WarehousePo> getWarehouselist() {
		return warehouselist;
	}

	public void setWarehouselist(List<WarehousePo> warehouselist) {
		this.warehouselist = warehouselist;
	}

	public List<GoodsInfoPo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsInfoPo> goodsList) {
		this.goodsList = goodsList;
	}

	public List<GoodsInfoPo> getBrandsList() {
		return brandsList;
	}

	public void setBrandsList(List<GoodsInfoPo> brandsList) {
		this.brandsList = brandsList;
	}

	/**
	 * 初始化库存综合查询
	 */
	public String initStockSearchSel() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取
		
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo1.getDepartmentID()));
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		request.setAttribute("whichretail",dpo.getBdpwhichretail());
		
		//新增工艺类型、镜架材质查询字段 add by ZK
		teachnologyList = varietyMgr.getTechnologyType();
		frameMaterialList = frameMaterialMgr.getFrameMaterialList();
		
		//默认显示启用的仓位
		request.setAttribute("usingWarehouse","0");

		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		request.setAttribute("makeinvoiceflag", 1);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		systemParameterPo = getSystemParameterByCompany(systemParameterPo, personInfoPo1);
    	warehouselist = getWarehouseListByCompany(systemParameterPo, personInfoPo1);
   	
    	fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();

    	// 判断是否存在仓位，若不存在则不能使用查询功能
    	if (warehouselist != null) {
        	request.setAttribute("wCount", (warehouselist.size() > 0 ? "1" : "0"));
    	} else {
        	request.setAttribute("wCount", "0");
    	}
    	
		return SUCCESS;
	}

	// 初始化库存详细查询 2011-4-28
	public String initStockSearchDetailsSel() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		WarehousePo warehousePo = new WarehousePo();
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		if ("1".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else if ("2".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else {
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		}

		return SUCCESS;
	}

	/**
	 * 库存详细查询 sxh 2011-4-28
	 */
	public String selStockSearchDtails() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		WarehousePo warehousePo = new WarehousePo();
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		if ("1".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else if ("2".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else {
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		}

		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request
				.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request
				.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String goodsBarcode = Utility.getName(request
				.getParameter("goodsBarcode"));
		String warehouseID = Utility.getName(request
				.getParameter("warehouseID"));
		String sumnum = Utility.getName(request.getParameter("sumnum"));
		String sumnum1 = Utility.getName(request.getParameter("sumnum1"));
		String RetailPrice = Utility.getName(request
				.getParameter("RetailPrice"));
		goodsCategorys = varietyMgr.getGoodsCategorys();

		GoodsDetailsInfoPo goodsDetailsInfoPo = new GoodsDetailsInfoPo();

		goodsDetailsInfoPo.setSxhGoodsBarCode(goodsBarcode);
		goodsDetailsInfoPo.setSxhGoodsId(goodsID);
		goodsDetailsInfoPo.setSxhGoodsName(goodsName);
		goodsDetailsInfoPo.setSxhGoodsCategoryID(goodscategoryID);
		goodsDetailsInfoPo.setSxhSupplierID(supplierID);
		goodsDetailsInfoPo.setSxhRetailPrice(RetailPrice);
		goodsDetailsInfoPo.setSxhStockID(warehouseID);
		goodsDetailsInfoPo.setSxhsumnum(sumnum);
		goodsDetailsInfoPo.setSxhsumnums(sumnum1);
		goodsDetailsInfoPo.setSxhBrandID(brandID);
		
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
		
		Map<String, Object> goodsNums = stockSearchMgr
				.getStockSearchDetailsCount(goodsDetailsInfoPo, (PersonInfoPo) session.get("person"));
		String count = goodsNums.get("count").toString();

		String goodNum = goodsNums.get("titlenum") != null ? goodsNums.get(
				"titlenum").toString() : "0";

		request.setAttribute("titlenum", goodNum);

		if (Integer.parseInt(count) > 0) {
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
			Pagination page = new Pagination(request, Integer.parseInt(count),
					perPage);
			goodsDetailsList = stockSearchMgr.getStockSearchDetailsList(
					goodsDetailsInfoPo, (PersonInfoPo) session.get("person"), page.getStart(), page
							.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsDetailsList = null;
		}
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);
		// request.setAttribute("varietyName",varietyName);
		request.setAttribute("stockID", warehouseID);
		request.setAttribute("sumnum", sumnum);
		request.setAttribute("sumnum1", sumnum1);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsBarcode", Utility.getName(request
				.getParameter("goodsBarcode")));
		request.setAttribute("RetailPrice", RetailPrice);
		return SUCCESS;
	}
	
	/**
	 *  初始化隐形效期查询  sxh 2012-8-30
	 * @return
	 * @throws Exception
	 */
	public String initStockSearchInvisibleSel() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		//查看类型
		String viewType = Utility.getName(request.getParameter("viewType"));
		request.setAttribute("viewType", ("".equals(viewType) ? "0" : viewType));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		warehouselist = this.getWarehouseListByCompany(systemParameterPo, personInfoPo1);
		
    	// 判断是否存在仓位，若不存在则不能使用查询功能
    	if (warehouselist != null) {
        	request.setAttribute("wCount", (warehouselist.size() > 0 ? "1" : "0"));
    	} else {
        	request.setAttribute("wCount", "0");
    	}
    	
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "invisibleSel";
		}
		
		return SUCCESS;
	}

	/**
	 * 隐形效期查询  sxh 2012-8-30
	 * @return
	 * @throws Exception
	 */
	public String selStockSearchInvisible() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		warehouselist = this.getWarehouseListByCompany(systemParameterPo, personInfoPo1);

    	// 判断是否存在仓位，若不存在则不能使用查询功能
    	if (warehouselist != null) {
        	request.setAttribute("wCount", (warehouselist.size() > 0 ? "1" : "0"));
    	} else {
        	request.setAttribute("wCount", "0");
    	}
    	
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String goodsBarcode = Utility.getName(request.getParameter("goodsBarcode"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		String sumnum = Utility.getName(request.getParameter("sumnum"));
		String sumnum1 = Utility.getName(request.getParameter("sumnum1"));
		String RetailPrice = Utility.getName(request.getParameter("RetailPrice"));

		//查看类型
		String viewType = Utility.getName(request.getParameter("viewType"));
		/**
		 * 隐形效期条件
		 */
		String invisibletype = Utility.getName(request.getParameter("invisibletype"));
		String maxandmin = Utility.getName(request.getParameter("maxandmin"));
		String mindown = Utility.getName(request.getParameter("mindown"));		
		
		goodsCategorys = varietyMgr.getGoodsCategorys();

		GoodsDetailsInfoPo goodsDetailsInfoPo = new GoodsDetailsInfoPo();
		goodsDetailsInfoPo.setSxhGoodsBarCode(goodsBarcode);
		goodsDetailsInfoPo.setSxhGoodsId(goodsID);
		goodsDetailsInfoPo.setSxhGoodsName(goodsName);
		goodsDetailsInfoPo.setSxhGoodsCategoryID(goodscategoryID);
		goodsDetailsInfoPo.setSxhSupplierID(supplierID);
		goodsDetailsInfoPo.setSxhRetailPrice(RetailPrice);
		goodsDetailsInfoPo.setSxhStockID(warehouseID);
		goodsDetailsInfoPo.setSxhsumnum(sumnum);
		goodsDetailsInfoPo.setSxhsumnums(sumnum1);
		goodsDetailsInfoPo.setSxhBrandID(brandID);
		goodsDetailsInfoPo.setSxhinvisibletype(invisibletype);
		goodsDetailsInfoPo.setSxhmax(maxandmin);
		goodsDetailsInfoPo.setSxhmin(mindown);
		//查询类型: 0有效期有批号  1有效期无批号  2无效期有批号  3无效期无批号 4全部
		goodsDetailsInfoPo.setViewType(viewType);
		goodsDetailsInfoPo.setSmecistocklist(warehouselist);
		
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
		
		Map<String, Object> goodsNums = stockSearchMgr.getStockSearchInvisibleCount(goodsDetailsInfoPo);
		String count = goodsNums.get("count").toString();

		String goodNum = goodsNums.get("titlenum") != null ? goodsNums.get("titlenum").toString() : "0";

		request.setAttribute("titlenum", goodNum);

		if (Integer.parseInt(count) > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, Integer.parseInt(count),perPage);
			goodsDetailsList = stockSearchMgr.getStockSearchInvisibleList(goodsDetailsInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsDetailsList = null;
		}
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("stockID", warehouseID);
		request.setAttribute("sumnum", sumnum);
		request.setAttribute("sumnum1", sumnum1);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsBarcode", Utility.getName(request.getParameter("goodsBarcode")));
		request.setAttribute("RetailPrice", RetailPrice);
		//查看类型
		request.setAttribute("viewType", viewType);
		
		/*
		 * 隐形效期条件
		 */
		request.setAttribute("invisibletype", invisibletype);
		request.setAttribute("maxandmin", maxandmin);
		request.setAttribute("mindown", mindown);
		
		return SUCCESS;
	}

	/**
	 * 库存综合查询
	 */
	public String selStockSearch() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		// 新增工艺类型、镜架材质查询字段 add by ZK
		teachnologyList = varietyMgr.getTechnologyType();
		frameMaterialList = frameMaterialMgr.getFrameMaterialList();
	
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo1.getDepartmentID()));		
				
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		systemParameterPo = getSystemParameterByCompany(systemParameterPo, personInfoPo1);
    	warehouselist = getWarehouseListByCompany(systemParameterPo, personInfoPo1);
		
    	// 判断是否存在仓位，若不存在则不能使用查询功能
    	if (warehouselist != null) {
        	request.setAttribute("wCount", (warehouselist.size() > 0 ? "1" : "0"));
    	} else {
        	request.setAttribute("wCount", "0");
    	}
    	
    	String radio_type = Utility.getName(request.getParameter("radio_type"));
    	String price_group = Utility.getName(request.getParameter("price_group"));
    	String searchKey = Utility.getName(request.getParameter("searchKey"));

		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String allBrandID = Utility.getName(request.getParameter("allBrandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String warehouseStatus = Utility.getName(request.getParameter("warehouseStatus"));
		String goodsBarcode = Utility.getName(request.getParameter("goodsBarcode"));
		
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));

		String bgiothergoodsbigclass = Utility.getName(request.getParameter("bgiothergoodsbigclass"));
		String bgiothergoodssmallclass = Utility.getName(request.getParameter("bgiothergoodssmallclass"));
		String minSphlh = Utility.getName(request.getParameter("minSphlh"));
		String maxSphlh = Utility.getName(request.getParameter("maxSphlh"));
		String pjlx = Utility.getName(request.getParameter("pjlx"));
		String talerttype = Utility.getName(request.getParameter("talerttype"));
		String makeinvoiceflag = Utility.getName(request.getParameter("makeinvoiceflag"));
		String page_jxfs = Utility.getName(request.getParameter("page_jxfs"));
		
		request.setAttribute("page_jxfs", page_jxfs);
		request.setAttribute("makeinvoiceflag", makeinvoiceflag);
		request.setAttribute("bgiothergoodsbigclass", bgiothergoodsbigclass);
		request.setAttribute("bgiothergoodssmallclass", bgiothergoodssmallclass);
		request.setAttribute("minSphlh", minSphlh);
		request.setAttribute("maxSphlh", maxSphlh);
		request.setAttribute("pjlx", pjlx);
		request.setAttribute("talerttype", talerttype);
		
		if(radio_type.equals("")){
			radio_type = "goods";
		}
		if(price_group.equals("")){
			price_group = "yes";
		}
		
		//判断显示的仓位是启用的还是停用的还是不分仓
		String usingWarehouse = Utility.getName(request.getParameter("usingWarehouse"));
		request.setAttribute("usingWarehouse",usingWarehouse.equals("") ? "0" : usingWarehouse);
		
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String isClosed = Utility.getName(request.getParameter("isClosed"));
		
		//镜架  成镜 老花镜
		String bgispecjj = Utility.getName(request.getParameter("bgispecjj"));
		String bgicolorjj = Utility.getName(request.getParameter("bgicolorjj"));
		String bgispeclh = Utility.getName(request.getParameter("bgispeclh"));
		String bgicolorlh = Utility.getName(request.getParameter("bgicolorlh"));
		String cgyearjj = Utility.getName(request.getParameter("cgyear"));
		
		String bgiframesizejj = Utility.getName(request.getParameter("bgiframesizejj"));

		//add by ZK
		String bgitechnologytypeid = Utility.getName(request.getParameter("bgitechnologytypeid"));
		String bgiframematerialtype = Utility.getName(request.getParameter("bgiframematerialtype"));
		
		request.setAttribute("bgispecjj", bgispecjj);
		request.setAttribute("bgicolorjj", bgicolorjj);
		request.setAttribute("bgispeclh", bgispeclh);
		request.setAttribute("bgicolorlh", bgicolorlh);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("cgyear", cgyearjj);
		//add by ZK
		request.setAttribute("bgitechnologytypeid", bgitechnologytypeid);
		request.setAttribute("bgiframematerialtype", bgiframematerialtype);
		
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
		String changeMinCyljp = Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCyljp"),request.getParameter("minCyljp")));
		String changeMaxCyljp = Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCyljp"),request.getParameter("maxCyljp")));
		
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		
		//隐形镜片
		String bgiusetypeyj = Utility.getName(request.getParameter("bgiusetypeyj"));
		String bgistealthclassyj = Utility.getName(request.getParameter("bgistealthclassyj"));
		//翻方前
		String minSphyj = Utility.getName(request.getParameter("minSphyj"));
		String maxSphyj = Utility.getName(request.getParameter("maxSphyj"));
		String minCylyj = Utility.getName(request.getParameter("minCylyj"));
		String maxCylyj = Utility.getName(request.getParameter("maxCylyj"));
		//翻方后
		String changeMinSphyj = Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphyj"),request.getParameter("minCylyj")));
		String changeMaxSphyj = Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphyj"),request.getParameter("maxCylyj")));
		String changeMinCylyj = Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCylyj"),request.getParameter("minCylyj")));
		String changeMaxCylyj = Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCylyj"),request.getParameter("maxCylyj")));
				
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		
		request.setAttribute("bgiusetypeyj", bgiusetypeyj);
		request.setAttribute("bgistealthclassyj", bgistealthclassyj);
		request.setAttribute("minSphyj", minSphyj);
		request.setAttribute("maxSphyj", maxSphyj);
		request.setAttribute("minCylyj", minCylyj);
		request.setAttribute("maxCylyj", maxCylyj);
		
		request.setAttribute("isClosed",isClosed);
		
		String isCustomizejp = Utility.getName(request.getParameter("isCustomizejp"));
		request.setAttribute("isCustomizejp", isCustomizejp);
		String isCustomizeyx = Utility.getName(request.getParameter("isCustomizeyx"));
		request.setAttribute("isCustomizeyx", isCustomizeyx);
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		FquartzSwitchPo fspo = reportQuartzMgr.getFquartzSwitchPo();
		
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setSmecistocklist(warehouselist);
		goodsInfoPo.setJxfs(page_jxfs);
		goodsInfoPo.setPricegroup(price_group);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setAlerttype(talerttype);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgigoodsquantity(warehouseStatus.equals("") ? "1" : warehouseStatus);
		goodsInfoPo.setBgiflag(isClosed);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiallbrandid(allBrandID);
		goodsInfoPo.setBgigoodsbarcode(goodsBarcode);		
		goodsInfoPo.setBgiwarehouseid(warehouseID);
		goodsInfoPo.setCstcpodid(usingWarehouse.equals("") ? "0" : usingWarehouse);     //判断查询的是启用还是停用的仓位
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgiwhichretail(whichretail);
		goodsInfoPo.setBgiismendretail(select_retail);
		goodsInfoPo.setBgiaccessoriestype(pjlx);
		goodsInfoPo.setMakeinvoiceflags(fspo.getFqswzhzstd());
		goodsInfoPo.setMakeinvoiceflag(makeinvoiceflag);
		if (goodscategoryID.equals("3")){
			goodsInfoPo.setBgiiscustomize(isCustomizejp);
		}
		if (goodscategoryID.equals("4")){
			goodsInfoPo.setBgiiscustomize(isCustomizeyx);
		}
				
		//镜架条件赋值
		goodsInfoPo.setBgispec(bgispecjj.equals("") ? bgispeclh : bgispecjj);
		goodsInfoPo.setBgicolor(bgicolorjj.equals("") ? bgicolorlh : bgicolorjj);
		goodsInfoPo.setBgiframesize(bgiframesizejj);
		
		goodsInfoPo.setBgitechnologytypeid(bgitechnologytypeid);
		goodsInfoPo.setBgiframematerialtype(bgiframematerialtype);
		
		//镜片条件赋值
		goodsInfoPo.setBgieyeglassmaterialtype(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractive(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosity(bgiismutiluminosityjp);
		
		goodsInfoPo.setBgiusetype(bgiusetypeyj);
		goodsInfoPo.setBgistealthclass(bgistealthclassyj);
		goodsInfoPo.setBgiothergoodsbigclass(bgiothergoodsbigclass);
		goodsInfoPo.setBgiothergoodssmallclass(bgiothergoodssmallclass);
		
		goodsInfoPo.setSmecistocklist(warehouselist);
		goodsInfoPo.setBgibrandyear(cgyearjj);
		
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		request.setAttribute("whichretail",whichretail);
		
		if(!"".equals(dpo.getBdpwhichretail())&&"1".equals(personInfoPo1.getDepartmenttype())){
			goodsInfoPo.setBgiwhichretail(dpo.getBdpwhichretail());
			request.setAttribute("whichretail",dpo.getBdpwhichretail());
		}
		
		if(!"".equals(changeMaxSphjp)){
			goodsInfoPo.setMaxSph(changeMaxSphjp);
		}else if(!"".equals(changeMaxSphyj)){
			goodsInfoPo.setMaxSph(changeMaxSphyj);
		}else if(!"".equals(maxSphlh)){
			goodsInfoPo.setMaxSph(maxSphlh);
		}
		if(!"".equals(changeMinSphjp)){
			goodsInfoPo.setMinSph(changeMinSphjp);
		}else if(!"".equals(changeMinSphyj)){
			goodsInfoPo.setMinSph(changeMinSphyj);
		}else if(!"".equals(minSphlh)){
			goodsInfoPo.setMinSph(minSphlh);
		}
		
		if(!"".equals(changeMaxCyljp)){
			goodsInfoPo.setMaxCyl(changeMaxCyljp);
		}else if(!"".equals(changeMaxCylyj)){
			goodsInfoPo.setMaxCyl(changeMaxCylyj);
		}
		
		if(!"".equals(changeMinCyljp)){
			goodsInfoPo.setMinCyl(changeMinCyljp);
		}else if(!"".equals(changeMinCylyj)){
			goodsInfoPo.setMinCyl(changeMinCylyj);
		}
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1"))	{
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
		
		if(searchKey.equals("openwindow")){
			request.setAttribute("showhider", "0");
		}
		
		Map<String, Object> goodsNums = null;
		
		if(radio_type.equals("brand")){//查询角度：品种
			goodsNums = stockSearchMgr.getStockSearchBrandCount(goodsInfoPo);
		}else if(radio_type.equals("goods")){//查询角度：商品
			goodsNums = stockSearchMgr.getStockSearchCount(goodsInfoPo);
		}else{//查询角度: 条码
			goodsNums = stockSearchMgr.getStockSearchCodeCount(goodsInfoPo);
		}
		
		String count = goodsNums.get("count").toString();

		String goodNum = goodsNums.get("titlenum") != null ? goodsNums.get("titlenum").toString() : "0";

		request.setAttribute("titlenum", goodNum);
		if (Integer.parseInt(count) > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, Integer.parseInt(count),perPage);
			if(radio_type.equals("brand")){//查询角度: 品种
				goodsList = null;
				codesList = null;
				brandsList = stockSearchMgr.getStockSearchBrandList(goodsInfoPo,page.getStart(), page.getPageSize());			
			}else if(radio_type.equals("goods")){//查询角度: 商品
				brandsList = null;
				codesList = null;
				goodsList = stockSearchMgr.getStockSearchList(goodsInfoPo,page.getStart(), page.getPageSize());
			}else{//查询角度: 条码
				brandsList = null;
				codesList = stockSearchMgr.getStockSearchCodeList(goodsInfoPo,page.getStart(), page.getPageSize());
				goodsList = null;
				
			}
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
			brandsList = null;
			codesList = null;
		}
		
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("allBrandID", allBrandID);
		request.setAttribute("warehouseStatus", warehouseStatus);
		request.setAttribute("brandName", brandName);
		request.setAttribute("warehouseID", warehouseID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsBarcode", goodsBarcode);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		request.setAttribute("radio_type", radio_type);
		request.setAttribute("price_group", price_group);
		request.setAttribute("searchKey", searchKey);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		return SUCCESS;
	}

	/**
	 * 初始化库存综合查询(品种)
	 */
	public String initStockSearchBrandSel() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		systemParameterPo = getSystemParameterByCompany(systemParameterPo, personInfoPo1);
    	warehouselist = getWarehouseListByCompany(systemParameterPo, personInfoPo1);
    	
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		
		//默认显示启用的仓位
		request.setAttribute("usingWarehouse","0");
    	
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selecttype";
		}

		return SUCCESS;
	}

	/**
	 * 库存综合查询(品种)
	 */
	public String selStockSearchBrand() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		systemParameterPo = getSystemParameterByCompany(systemParameterPo, personInfoPo1);
    	warehouselist = getWarehouseListByCompany(systemParameterPo, personInfoPo1);
    	
    	String openclose=Utility.getName(systemParameterPo.getFspsharestockmessage());
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		// String varietyID=Utility.getName(request.getParameter("varietyID"));
		// String
		// varietyName=Utility.getName(request.getParameter("varietyName"));
		String refractive = Utility.getName(request.getParameter("refractive"));
		String warehouseStatus = Utility.getName(request.getParameter("warehouseStatus"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		
		//判断显示的仓位是启用的还是停用的
		String usingWarehouse = Utility.getName(request.getParameter("usingWarehouse"));
		request.setAttribute("usingWarehouse",usingWarehouse.equals("") ? "0" : usingWarehouse );
		
		goodsCategorys = varietyMgr.getGoodsCategorys();

		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setOpenclose(openclose);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgirefractive(refractive);
		// goodsInfoPo.setBgivarietyid(varietyID);
		goodsInfoPo.setBgiflag(warehouseStatus.equals("") ? "1" : warehouseStatus);
		goodsInfoPo.setBgiwarehouseid(warehouseID);//
		goodsInfoPo.setCstcpodid(usingWarehouse.equals("") ? "0" : usingWarehouse);     //判断查询的是启用还是停用的仓位
		
		
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
		
		Map<String, Object> goodsNums = stockSearchMgr.getStockSearchBrandCount(goodsInfoPo);
		String count = goodsNums.get("count").toString();

		String goodNum = goodsNums.get("titlenum") != null ? goodsNums.get("titlenum").toString() : "0";

		request.setAttribute("titlenum", goodNum);

		if (Integer.parseInt(count) > 0) {
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
			Pagination page = new Pagination(request, Integer.parseInt(count),
					perPage);
			brandsList = stockSearchMgr.getStockSearchBrandList(goodsInfoPo,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			brandsList = null;
		}

		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		// request.setAttribute("varietyID",varietyID);
		request.setAttribute("brandName", brandName);
		// request.setAttribute("varietyName",varietyName);
		request.setAttribute("refractive", refractive);
		request.setAttribute("warehouseStatus", warehouseStatus);
		request.setAttribute("warehouseID", warehouseID);
		
		refractiveSetPos = unitMgr.getRefractiveSetList();
		
		return SUCCESS;
	}

	/**
	 * 初始化库存预警查询
	 */
	public String initStockAlertSel() throws Exception {
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
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		WarehousePo warehousePo = new WarehousePo();
		warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1") && Utility.getName(permissionPo.getKeyb()).equals("1")){
			this.setIsFirstExec("1");
			return "selStockAlert";
		}

		return SUCCESS;
	}

	/**
	 * 库存预警查询
	 */
	public String selStockAlert() throws Exception {

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
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		String alerttype = Utility.getName(request.getParameter("alerttype"));

		goodsCategorys = varietyMgr.getGoodsCategorys();
		WarehousePo warehousePo = new WarehousePo();
		if ("1".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else if ("2".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else {
			
			if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
				warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
			}
			
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		}

		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiwarehouseid(warehouseID);
		goodsInfoPo.setAlerttype(alerttype);
		goodsInfoPo.setBgidepartmenttype(personInfoPo.getDepartmenttype());
		goodsInfoPo.setBgidepartmentid(personInfoPo.getDepartmentID());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			goodsInfoPo.setBgicompanyid(personInfoPo.getPersoncompanyid());
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
			} else {
				request.setAttribute("showhider", "2");
			}
		}

		int count = stockSearchMgr.getStockAlertCount(goodsInfoPo);
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
			goodsList = stockSearchMgr.getStockAlertList(goodsInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}

		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("alerttype",alerttype);
		request.setAttribute("warehouseID", warehouseID);
		request.setAttribute("supplierName", supplierName);
		
		return SUCCESS;
	}

	/**
	 * 库存综合查询(二维)
	 */
	public String initStockSearch_2D() throws Exception {
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
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo.getDepartmenttype()));
		request.setAttribute("makeinvoiceflag", 1);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	

		systemParameterPo = getSystemParameterByCompany(systemParameterPo, personInfoPo);
    	warehouselist = getWarehouseListByCompany(systemParameterPo, personInfoPo);

    	// 判断是否存在仓位，若不存在则不能使用查询功能
    	if (warehouselist != null) {
        	request.setAttribute("wCount", (warehouselist.size() > 0 ? "1" : "0"));
    	} else {
        	request.setAttribute("wCount", "0");
    	}
    	
		//默认显示启用的仓位
		request.setAttribute("usingWarehouse","0");
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		return SUCCESS;
	}
	
	/**
	 * 初始化库存综合查询(仓位)
	 */
	public String initSelectStockSearchWarehouse() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		teachnologyList = varietyMgr.getTechnologyType();
		frameMaterialList = frameMaterialMgr.getFrameMaterialList();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo1.getDepartmentID()));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		systemParameterPo = getSystemParameterByCompany(systemParameterPo, personInfoPo1);
    	warehouselist = getWarehouseListByCompany(systemParameterPo, personInfoPo1);

    	// 判断是否存在仓位，若不存在则不能使用查询功能
    	if (warehouselist != null) {
        	request.setAttribute("wCount", (warehouselist.size() > 0 ? "1" : "0"));
    	} else {
        	request.setAttribute("wCount", "0");
    	}
    	
    	request.setAttribute("makeinvoiceflag", 1);
		String usingWarehouse = Utility.getName(request.getParameter("usingWarehouse"));
		request.setAttribute("usingWarehouse",usingWarehouse.equals("") ? "0" : usingWarehouse);
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		return SUCCESS;
	}
	
	/**
	 * 库存综合查询(仓位)
	 */
	public String selectStockSearchWarehouse() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo1.getDepartmentID()));

		String queryAngle = Utility.getName(request.getParameter("queryAngle"));
		String brandGroup = Utility.getName(request.getParameter("brandGroup"));
		String usingWarehouse = Utility.getName(request.getParameter("usingWarehouse"));
		String bgitechnologytypeid = Utility.getName(request.getParameter("bgitechnologytypeid"));
		String bgiframematerialtype = Utility.getName(request.getParameter("bgiframematerialtype"));
		String bgiothergoodsbigclass = Utility.getName(request.getParameter("bgiothergoodsbigclass"));
		String bgiothergoodssmallclass = Utility.getName(request.getParameter("bgiothergoodssmallclass"));
		String minSphlh = Utility.getName(request.getParameter("minSphlh"));
		String maxSphlh = Utility.getName(request.getParameter("maxSphlh"));
		String pjlx = Utility.getName(request.getParameter("pjlx"));
		
		request.setAttribute("bgiothergoodsbigclass", bgiothergoodsbigclass);
		request.setAttribute("bgiothergoodssmallclass", bgiothergoodssmallclass);
		request.setAttribute("minSphlh", minSphlh);
		request.setAttribute("maxSphlh", maxSphlh);
		request.setAttribute("pjlx", pjlx);

		request.setAttribute("queryAngle",queryAngle.equals("brand") ? "2" : "1");
		request.setAttribute("brandGroup",brandGroup);
		request.setAttribute("usingWarehouse",usingWarehouse);
		request.setAttribute("bgitechnologytypeid",bgitechnologytypeid);
		request.setAttribute("bgiframematerialtype",bgiframematerialtype);
		
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String allBrandID = Utility.getName(request.getParameter("allBrandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String warehouseStatus = Utility.getName(request.getParameter("warehouseStatus"));
		String goodsBarcode = Utility.getName(request.getParameter("goodsBarcode")).length() > 18 ? Utility.getName(request.getParameter("goodsBarcode")).substring(0, 18): Utility.getName(request.getParameter("goodsBarcode"));
		String makeinvoiceflag = Utility.getName(request.getParameter("makeinvoiceflag"));
		request.setAttribute("makeinvoiceflag", makeinvoiceflag);
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		if (!warehouseID.equals("") && !warehouseID.equals(",") && warehouseID.length() >= 1){
			warehouseID = warehouseID.substring(0,warehouseID.length()-1);
		}
		
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String isClosed = Utility.getName(request.getParameter("isClosed"));
		
		request.setAttribute("isClosed",isClosed);
		
		//镜架  成镜 老花镜
		String bgispecjj = Utility.getName(request.getParameter("bgispecjj"));
		String bgicolorjj = Utility.getName(request.getParameter("bgicolorjj"));
		String bgiframesizejj = Utility.getName(request.getParameter("bgiframesizejj"));
		String cgyearjj = Utility.getName(request.getParameter("cgyear"));
		
		request.setAttribute("bgispecjj", bgispecjj);
		request.setAttribute("bgicolorjj", bgicolorjj);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("cgyear", cgyearjj);
		
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
		String changeMinCyljp = Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCyljp"),request.getParameter("minCyljp")));
		String changeMaxCyljp = Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCyljp"),request.getParameter("maxCyljp")));
		
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		
		//隐形镜片
		String bgiusetypeyj = Utility.getName(request.getParameter("bgiusetypeyj"));
		String bgistealthclassyj = Utility.getName(request.getParameter("bgistealthclassyj"));
		//翻方前
		String minSphyj = Utility.getName(request.getParameter("minSphyj"));
		String maxSphyj = Utility.getName(request.getParameter("maxSphyj"));
		String minCylyj = Utility.getName(request.getParameter("minCylyj"));
		String maxCylyj = Utility.getName(request.getParameter("maxCylyj"));
		//翻方后
		String changeMinSphyj = Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphyj"),request.getParameter("minCylyj")));
		String changeMaxSphyj = Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphyj"),request.getParameter("maxCylyj")));
		String changeMinCylyj = Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCylyj"),request.getParameter("minCylyj")));
		String changeMaxCylyj = Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCylyj"),request.getParameter("maxCylyj")));
		
		String page_jxfs = Utility.getName(request.getParameter("jxfs"));//经销方式
		
		request.setAttribute("page_jxfs", page_jxfs);
		request.setAttribute("bgiusetypeyj", bgiusetypeyj);
		request.setAttribute("bgistealthclassyj", bgistealthclassyj);
		request.setAttribute("minSphyj", minSphyj);
		request.setAttribute("maxSphyj", maxSphyj);
		request.setAttribute("minCylyj", minCylyj);
		request.setAttribute("maxCylyj", maxCylyj);
		
		String isCustomizejp = Utility.getName(request.getParameter("isCustomizejp"));
		request.setAttribute("isCustomizejp", isCustomizejp);
		String isCustomizeyx = Utility.getName(request.getParameter("isCustomizeyx"));
		request.setAttribute("isCustomizeyx", isCustomizeyx);
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();		
		FquartzSwitchPo fspo = reportQuartzMgr.getFquartzSwitchPo();

		GoodsInfoPo po = new GoodsInfoPo();
		po.setJxfs(page_jxfs);
		po.setBgiaccessoriestype(pjlx);
		po.setBgigoodsid(goodsID);
		po.setBgigoodsname(goodsName);
		po.setBgigoodscategoryid(goodscategoryID);
		po.setBgisupplierid(supplierID);
		po.setBgiflag(isClosed);
		po.setIsclosed(usingWarehouse);
		po.setBgibrandid(brandID);
		po.setBgiallbrandid(allBrandID);
		po.setBgigoodsbarcode(goodsBarcode);		
		po.setBgiwarehouseid(warehouseID);
		po.setBgiretailbeginprice(bgiretailbeginprice);
		po.setBgiretailendprice(bgiretailendprice);		
		po.setQueryType(queryAngle);   // 查询角度
		po.setBrandGroup(brandGroup);  // 品种零售价分组		
		po.setUsingWarehouse(usingWarehouse);  // 仓位启用标识
		po.setBgigoodsquantity(warehouseStatus);
		po.setMakeinvoiceflags(fspo.getFqswzhzstd());
		po.setMakeinvoiceflag(makeinvoiceflag);
		if (goodscategoryID.equals("3")){
			po.setBgiiscustomize(isCustomizejp);
		}
		if (goodscategoryID.equals("4")){
			po.setBgiiscustomize(isCustomizeyx);
		}
		
		//镜架条件赋值
		po.setBgispec(bgispecjj);
		po.setBgicolor(bgicolorjj);
		po.setBgiframesize(bgiframesizejj);
		po.setBgitechnologytypeid(bgitechnologytypeid); // 工艺类型
		po.setBgiframematerialtype(bgiframematerialtype);  // 镜架材质
		
		//镜片条件赋值
		po.setBgieyeglassmaterialtype(bgieyeglassmaterialtypejp);
		po.setBgirefractive(bgirefractivejp);
		po.setBgiismutiluminosity(bgiismutiluminosityjp);
		
		po.setBgiusetype(bgiusetypeyj);
		po.setBgistealthclass(bgistealthclassyj);
		po.setBgiothergoodsbigclass(bgiothergoodsbigclass);
		po.setBgiothergoodssmallclass(bgiothergoodssmallclass);
		
		if(!"".equals(changeMaxSphjp)){
			po.setMaxSph(changeMaxSphjp);
		}else if(!"".equals(changeMaxSphyj)){
			po.setMaxSph(changeMaxSphyj);
		}else if(!"".equals(maxSphlh)){
			po.setMaxSph(maxSphlh);
		}
		
		if(!"".equals(changeMinSphjp)){
			po.setMinSph(changeMinSphjp);
		}else if(!"".equals(changeMinSphyj)){
			po.setMinSph(changeMinSphyj);
		}else if(!"".equals(minSphlh)){
			po.setMinSph(minSphlh);
		}
		
		if(!"".equals(changeMaxCyljp)){
			po.setMaxCyl(changeMaxCyljp);
		}else if(!"".equals(changeMaxCylyj)){
			po.setMaxCyl(changeMaxCylyj);
		}
		
		if(!"".equals(changeMinCyljp)){
			po.setMinCyl(changeMinCyljp);
		}else if(!"".equals(changeMinCylyj)){
			po.setMinCyl(changeMinCylyj);
		}

		stockSearchWarehousePos = new ArrayList<StockSearchWarehousePo>();

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		systemParameterPo = getSystemParameterByCompany(systemParameterPo, personInfoPo1);
    	warehouselist = getWarehouseListByCompany(systemParameterPo, personInfoPo1);

    	for (WarehousePo wpo : warehouselist){
    		StockSearchWarehousePo sswpo = new StockSearchWarehousePo();
    		sswpo.setWarehouseid(Utility.getName(wpo.getBwhid()));
    		sswpo.setWarehousename(Utility.getName(wpo.getBwhwarehouseName()));
    		
    		stockSearchWarehousePos.add(sswpo);
    	}
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			po.setBgicompanyid(personInfoPo1.getPersoncompanyid());
		}
		po.setBgibrandyear(cgyearjj);
    	
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
		
		int count = 0;
		int sum = 0;		
		if (stockSearchWarehousePos != null && stockSearchWarehousePos.size() > 0){			
			count = stockSearchMgr.selectGoodsIdCount(po);
			sum = stockSearchMgr.selectGoodsIdSum(po);
		}
		
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
			Pagination page = new Pagination(request, count,perPage);
			stockSearchWarehousePoList = stockSearchMgr.selectStockSearchWarehouseList(po,(PersonInfoPo) session.get("person"), page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			stockSearchWarehousePoList = null;
		}

		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo1.getDepartmentID()));
		request.setAttribute("isClosed",isClosed);	
		request.setAttribute("bgispecjj", bgispecjj);
		request.setAttribute("bgicolorjj", bgicolorjj);
		request.setAttribute("bgiframesizejj", bgiframesizejj);		
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("bgiusetypeyj", bgiusetypeyj);
		request.setAttribute("bgistealthclassyj", bgistealthclassyj);		
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("allBrandID", allBrandID);
		request.setAttribute("warehouseStatus", warehouseStatus);
		request.setAttribute("brandName", brandName);
		request.setAttribute("warehouseID", warehouseID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsBarcode", Utility.getName(request.getParameter("goodsBarcode")));
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		request.setAttribute("sum", sum);
		
		if (goodscategoryID.equals("3")){
			request.setAttribute("sphup", minSphjp);
			request.setAttribute("sphul", maxSphjp);
			request.setAttribute("cylup", minCyljp);
			request.setAttribute("cylul", maxCyljp);
		}
		if (goodscategoryID.equals("4")){
			request.setAttribute("sphup", minSphyj);
			request.setAttribute("sphul", maxSphyj);
			request.setAttribute("cylup", minCylyj);
			request.setAttribute("cylul", maxCylyj);
		}
		
		if (Utility.getName(systemParameterPo.getFspselectstocktype()).equals("")){
			systemParameterPo.setFspselectstocktype("1");
		}
		request.setAttribute("goodsStyle", Utility.getName(systemParameterPo.getFspselectstocktype()));
		
		return SUCCESS;
	}
	
	/**
	 * 商品详细
	 */
	public String selectStockGoodsinfoPo() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		//新增工艺类型、镜架材质查询字段 add by ZK
		teachnologyList = varietyMgr.getTechnologyType();

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("departmenttype", personInfoPo1.getDepartmenttype());
		
		String bgigoodsid = Utility.getName(request.getParameter("bgigoodsid"));
		String bgiwarehouseid  = Utility.getName(request.getParameter("bgiwarehouseid"));
		String goodsBarcode  = Utility.getName(request.getParameter("goodsBarcode"));
		
		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgigoodsid(bgigoodsid);
		po.setBgiwarehouseid(bgiwarehouseid);
		po.setBgigoodsbarcode(goodsBarcode);
		po.setBgicompanyid(personInfoPo1.getPersoncompanyid());
		
		goodsInfoPo = stockSearchMgr.getStockGoodsInfoPo(po);
		
		GoodsInfoPo alertpo = stockSearchMgr.getStorageAlertGoodsInfoPo(po);
		
		goodsInfoPo.setBgigoodsquantity(alertpo.getBgigoodsquantity());
		goodsInfoPo.setBgistorageupperlimit(alertpo.getBgistorageupperlimit());
		goodsInfoPo.setBgistoragelowerlimit(alertpo.getBgistoragelowerlimit());
		goodsInfoPo.setBgistorageredlimit(alertpo.getBgistorageredlimit());
		
		String startTime  = Utility.getName(request.getParameter("startTime"));
		String endTime  = Utility.getName(request.getParameter("endTime"));
		
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		
		request.setAttribute("bgigoodsid", bgigoodsid);
		request.setAttribute("bgiwarehouseid", bgiwarehouseid);
		request.setAttribute("goodsBarcode", goodsBarcode);
		
		if("1".equals(bgigoodsid.substring(0, 1))){
			return "t1";
		}
		
		if("2".equals(bgigoodsid.substring(0, 1))){
			return "t2";
		}
		
		if("3".equals(bgigoodsid.substring(0, 1))){
			if("D".equals(bgigoodsid.substring(8, 9))){
				return "t3d";
			}else{
				return "t3c";
			}
		}
		
		if("4".equals(bgigoodsid.substring(0, 1))){
			if("D".equals(bgigoodsid.substring(8, 9))){
				return "t4d";
			}else{
				return "t4c";
			}
		}
		
		if("5".equals(bgigoodsid.substring(0, 1))){
			return "t5";
		}
		
		if("6".equals(bgigoodsid.substring(0, 1))){
			return "t6";
		}
		
		if("7".equals(bgigoodsid.substring(0, 1))){
			return "t7";
		}
		
		if("8".equals(bgigoodsid.substring(0, 1))){
			return "t8";
		}
		
		if("9".equals(bgigoodsid.substring(0, 1))){
			return "t9";
		}
		
		return SUCCESS;
	}
	/**
	 * 商品详细
	 */
	public String selectStockGoodsinfoPo2() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		//新增工艺类型、镜架材质查询字段 add by ZK
		teachnologyList = varietyMgr.getTechnologyType();

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("departmenttype", personInfoPo1.getDepartmenttype());
		
		String bgigoodsid = Utility.getName(request.getParameter("bgigoodsid"));
		String bgiwarehouseid  = Utility.getName(request.getParameter("bgiwarehouseid"));
		String goodsBarcode  = Utility.getName(request.getParameter("goodsBarcode"));
		
		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgigoodsid(bgigoodsid);
		po.setBgiwarehouseid(bgiwarehouseid);
		po.setBgigoodsbarcode(goodsBarcode);
		po.setBgicompanyid(personInfoPo1.getPersoncompanyid());
		
		goodsInfoPo = stockSearchMgr.getStockGoodsInfoPo(po);
		
		GoodsInfoPo alertpo = stockSearchMgr.getStorageAlertGoodsInfoPo(po);
		if(!"".equals(goodsBarcode)){
			goodsInfoPo.setBgigoodsbarcode(goodsBarcode);
		}
		
		goodsInfoPo.setBgigoodsquantity(alertpo.getBgigoodsquantity());
		goodsInfoPo.setBgistorageupperlimit(alertpo.getBgistorageupperlimit());
		goodsInfoPo.setBgistoragelowerlimit(alertpo.getBgistoragelowerlimit());
		goodsInfoPo.setBgistorageredlimit(alertpo.getBgistorageredlimit());
		
		String startTime  = Utility.getName(request.getParameter("startTime"));
		String endTime  = Utility.getName(request.getParameter("endTime"));
		
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		
		request.setAttribute("bgigoodsid", bgigoodsid);
		request.setAttribute("bgiwarehouseid", bgiwarehouseid);
		request.setAttribute("goodsBarcode", goodsBarcode);
		
		if("1".equals(bgigoodsid.substring(0, 1))){
			return "t1";
		}
		
		if("2".equals(bgigoodsid.substring(0, 1))){
			return "t2";
		}
		
		if("3".equals(bgigoodsid.substring(0, 1))){
			if("D".equals(bgigoodsid.substring(8, 9))){
				return "t3d";
			}else{
				return "t3c";
			}
		}
		
		if("4".equals(bgigoodsid.substring(0, 1))){
			if("D".equals(bgigoodsid.substring(8, 9))){
				return "t4d";
			}else{
				return "t4c";
			}
		}
		
		if("5".equals(bgigoodsid.substring(0, 1))){
			return "t5";
		}
		
		if("6".equals(bgigoodsid.substring(0, 1))){
			return "t6";
		}
		
		if("7".equals(bgigoodsid.substring(0, 1))){
			return "t7";
		}
		
		if("8".equals(bgigoodsid.substring(0, 1))){
			return "t8";
		}
		
		if("9".equals(bgigoodsid.substring(0, 1))){
			return "t9";
		}
		
		return SUCCESS;
	}
	/**
	 * 商品库存流水查询 sxh 2011-11-28
	 */
	public String selStockSearchLs() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String bgigoodsid = Utility.getName(request.getParameter("bgigoodsid"));
		String bgiwarehouseid  = Utility.getName(request.getParameter("bgiwarehouseid"));		
		String billID  = Utility.getName(request.getParameter("billID"));
		String startTime  = Utility.getName(request.getParameter("startTime"));
		String endTime  = Utility.getName(request.getParameter("endTime"));
		
		String goodsCategoryID  = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierID  = Utility.getName(request.getParameter("supplierID"));
		String brandID  = Utility.getName(request.getParameter("brandID"));
		String sph  = Utility.getName(request.getParameter("sph"));
		String cyl  = Utility.getName(request.getParameter("cyl"));
		String isCustomize  = Utility.getName(request.getParameter("isCustomize"));
		String goodsBarcode  = Utility.getName(request.getParameter("goodsBarcode"));
		
		request.setAttribute("goodsBarcode", goodsBarcode);
		
		GoodsDetailsInfoPo goodsDetailsInfoPo = new GoodsDetailsInfoPo();
		goodsDetailsInfoPo.setSxhGoodsId(bgigoodsid);
		goodsDetailsInfoPo.setSxhStockID(bgiwarehouseid);
		goodsDetailsInfoPo.setSxhchangeid(billID);
		goodsDetailsInfoPo.setSxhbgndate(startTime);
		goodsDetailsInfoPo.setSxhenddate(endTime);		
		goodsDetailsInfoPo.setSxhGoodsCategoryID(goodsCategoryID);
		goodsDetailsInfoPo.setSxhSupplierID(supplierID);
		goodsDetailsInfoPo.setSxhBrandID(brandID); 
		goodsDetailsInfoPo.setSxhsph(sph);	
		goodsDetailsInfoPo.setSxhcyl(cyl);
		goodsDetailsInfoPo.setSxhisCustomize(isCustomize);
		goodsDetailsInfoPo.setSxhGoodsBarCode(goodsBarcode);
		
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
		
		Map<String, Object> goodsNums = stockSearchMgr.getStockSearchLsCount(goodsDetailsInfoPo);
		String count = goodsNums.get("count").toString();

		String goodNum = goodsNums.get("titlenum") != null ? goodsNums.get(
				"titlenum").toString() : "0";

		request.setAttribute("titlenum", goodNum);

		if (Integer.parseInt(count) > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, Integer.parseInt(count),
					perPage);
			goodsDetailsList = stockSearchMgr.getStockSearchLsList(goodsDetailsInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsDetailsList = null;
		}
		
		GoodsDetailsInfoPo gpo = stockSearchMgr.getFirstStockGoodsInfoPo(goodsDetailsInfoPo);
		request.setAttribute("firstStock", Utility.getName(gpo.getSxhsumnum()).equals("") ? "0" : Utility.getName(gpo.getSxhsumnum()));
		
		goodsDetailsInfoPo.setSxhbgndate("");
		gpo = stockSearchMgr.getEndStockGoodsInfoPo(goodsDetailsInfoPo);

		request.setAttribute("bgigoodsid", bgigoodsid);
		request.setAttribute("bgiwarehouseid", bgiwarehouseid);
		request.setAttribute("billID", billID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);		
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("sph", sph);
		request.setAttribute("cyl", cyl);
		request.setAttribute("isCustomize", isCustomize);		
		
		return SUCCESS;
	}
	/**
	 * 商品库存流水查询 sxh 2011-11-28
	 */
	public String selStockSearchLs2() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String bgigoodsid = Utility.getName(request.getParameter("bgigoodsid"));
		String bgiwarehouseid  = Utility.getName(request.getParameter("bgiwarehouseid"));		
		String billID  = Utility.getName(request.getParameter("billID"));
		String startTime  = Utility.getName(request.getParameter("startTime"));
		String endTime  = Utility.getName(request.getParameter("endTime"));
		
		String goodsCategoryID  = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierID  = Utility.getName(request.getParameter("supplierID"));
		String brandID  = Utility.getName(request.getParameter("brandID"));
		String sph  = Utility.getName(request.getParameter("sph"));
		String cyl  = Utility.getName(request.getParameter("cyl"));
		String isCustomize  = Utility.getName(request.getParameter("isCustomize"));
		String bgigoodsbarcode  = Utility.getName(request.getParameter("bgigoodsbarcode"));
		
		request.setAttribute("bgigoodsbarcode", bgigoodsbarcode);
		
		GoodsDetailsInfoPo goodsDetailsInfoPo = new GoodsDetailsInfoPo();
		goodsDetailsInfoPo.setSxhGoodsId(bgigoodsid.substring(0,7));
		goodsDetailsInfoPo.setSxhStockID(bgiwarehouseid);
		goodsDetailsInfoPo.setSxhchangeid(billID);
		goodsDetailsInfoPo.setSxhbgndate(startTime);
		goodsDetailsInfoPo.setSxhenddate(endTime);		
		goodsDetailsInfoPo.setSxhGoodsCategoryID(goodsCategoryID);
		goodsDetailsInfoPo.setSxhSupplierID(supplierID);
		goodsDetailsInfoPo.setSxhBrandID(brandID); 
		goodsDetailsInfoPo.setSxhsph(sph);	
		goodsDetailsInfoPo.setSxhcyl(cyl);
		goodsDetailsInfoPo.setSxhisCustomize(isCustomize);
		goodsDetailsInfoPo.setSxhGoodsBarCode(bgigoodsbarcode);
		
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
		
		Map<String, Object> goodsNums = stockSearchMgr.getStockSearchLsCount2(goodsDetailsInfoPo);
		String count = goodsNums.get("count").toString();

		String goodNum = goodsNums.get("titlenum") != null ? goodsNums.get("titlenum").toString() : "0";

		request.setAttribute("titlenum", goodNum);

		if (Integer.parseInt(count) > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, Integer.parseInt(count),
					perPage);
			goodsDetailsList = stockSearchMgr.getStockSearchLsList2(goodsDetailsInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsDetailsList = null;
		}
		
		GoodsDetailsInfoPo gpo = stockSearchMgr.getFirstStockGoodsInfoPo(goodsDetailsInfoPo);
		request.setAttribute("firstStock", Utility.getName(gpo.getSxhsumnum()).equals("") ? "0" : Utility.getName(gpo.getSxhsumnum()));
		
		goodsDetailsInfoPo.setSxhbgndate("");
		gpo = stockSearchMgr.getEndStockGoodsInfoPo(goodsDetailsInfoPo);

		request.setAttribute("bgigoodsid", bgigoodsid);
		request.setAttribute("bgiwarehouseid", bgiwarehouseid);
		request.setAttribute("billID", billID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);		
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("sph", sph);
		request.setAttribute("cyl", cyl);
		request.setAttribute("isCustomize", isCustomize);		
		
		return SUCCESS;
	}
	
	/**
	 * 库存流水查询商品信息
	 */
	public String selectStockEntry() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String hid = Utility.getName(request.getParameter("hid"));
		String changeid = Utility.getName(request.getParameter("changeid"));
		String tflag = Utility.getName(request.getParameter("tflag"));
		
		request.setAttribute("hid",hid);
		request.setAttribute("changeid",changeid);
		request.setAttribute("tflag",tflag);
		
		StrogeLogPo po = new StrogeLogPo();
		po.setCshslchangeid(changeid);
		po.setCshslstockid(Utility.getName(request.getParameter("bgiwarehouseid")));
		po.setCshslsalesbillflag(tflag);
		
		strogeLogList = stockSearchMgr.getGoodsStrogeList(po);
		
		String autoAllocationFlag = "";
		String warehouseName = "";
		if (strogeLogList.size() > 0){
			StrogeLogPo tmp = strogeLogList.get(0);  //变更单据和变更仓位都相同,只取第一个商品的单据号和仓位即可
			BigDecimal bg = new BigDecimal(Utility.getName(tmp.getCshslgoodsquantity()));  //根据数量的正与负判断调拨时的发出和接收仓位
			autoAllocationFlag = Utility.getName(tmp.getCshslautoallocationflag());
			if (Utility.getName(tmp.getCshslchangeid()).startsWith("ALL") && bg.intValue() > 0){
				if (autoAllocationFlag.equals("1")){
					warehouseName = "从" + Utility.getName(tmp.getCshslfromstockname()) + "调至" + Utility.getName(tmp.getCshslstockname()) + " 【关联单号：" + Utility.getName(tmp.getCshslsalesid()) + " 】";
				}else{
					warehouseName = "从" + Utility.getName(tmp.getCshslfromstockname()) + "调至" + Utility.getName(tmp.getCshslstockname());
				}				
			}else if (Utility.getName(tmp.getCshslchangeid()).startsWith("ALL") && bg.intValue() < 0){
				if (autoAllocationFlag.equals("1")){
					warehouseName = "从" + Utility.getName(tmp.getCshslstockname()) + "调至" + Utility.getName(tmp.getCshslfromstockname()) + " 【关联单号：" + Utility.getName(tmp.getCshslsalesid()) + " 】";
				}else{
					warehouseName = "从" + Utility.getName(tmp.getCshslstockname()) + "调至" + Utility.getName(tmp.getCshslfromstockname());
				}				
			}else {
				warehouseName = Utility.getName(tmp.getCshslstockname());
			}
		}
		
		request.setAttribute("autoAllocationFlag",autoAllocationFlag);
		request.setAttribute("warehouseName",warehouseName);
		
		return SUCCESS;
	}
	
	/**
	 * 库存综合查询(二维)
	 */
	public String selectStockSearch2D() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		FquartzSwitchPo fspo = reportQuartzMgr.getFquartzSwitchPo();
		
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		String makeinvoiceflag = Utility.getName(request.getParameter("makeinvoiceflag"));
		String startdate = Utility.getName(request.getParameter("startTime"));
		String enddate = Utility.getName(request.getParameter("endTime"));
		request.setAttribute("makeinvoiceflag", makeinvoiceflag);
		request.setAttribute("makeinvoiceflags", Utility.getName(fspo.getFqswzhzstd()));
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandID",brandID);
		request.setAttribute("warehouseID",warehouseID);
		request.setAttribute("startdate",startdate);
		request.setAttribute("enddate",enddate);
		request.setAttribute("selecttype",systemParameterPo.getFspisshowsupplierandbrand());
		request.setAttribute("queryType",Utility.getName(request.getParameter("queryType")));
		
		return SUCCESS;
	}
	/**
	 * 初始化库存综合查询
	 */
	public String initSelectStockSearchAnyTimeSel() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取
		
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo1.getDepartmentID()));
		request.setAttribute("makeinvoiceflag", 1);
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		request.setAttribute("whichretail",dpo.getBdpwhichretail());
		
		//新增工艺类型、镜架材质查询字段 add by ZK
		teachnologyList = varietyMgr.getTechnologyType();
		frameMaterialList = frameMaterialMgr.getFrameMaterialList();
		
		//默认显示启用的仓位
		request.setAttribute("usingWarehouse","0");
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
    	warehouselist = getWarehouseListByCompany(systemParameterPo, personInfoPo1);

    	// 判断是否存在仓位，若不存在则不能使用查询功能
    	if (warehouselist != null) {
        	request.setAttribute("wCount", (warehouselist.size() > 0 ? "1" : "0"));
    	} else {
        	request.setAttribute("wCount", "0");
    	}
    	
    	fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();

		return SUCCESS;
	}
	/**
	 * 库存综合查询
	 */
	public String selStockSearchAnyTime() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		// 新增工艺类型、镜架材质查询字段 add by ZK
		teachnologyList = varietyMgr.getTechnologyType();
		frameMaterialList = frameMaterialMgr.getFrameMaterialList();
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo1.getDepartmentID()));		
				
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
    	warehouselist = getWarehouseListByCompany(systemParameterPo, personInfoPo1);
    	
    	// 判断是否存在仓位，若不存在则不能使用查询功能
    	if (warehouselist != null) {
        	request.setAttribute("wCount", (warehouselist.size() > 0 ? "1" : "0"));
    	} else {
        	request.setAttribute("wCount", "0");
    	}
    	
    	String radio_type = Utility.getName(request.getParameter("radio_type"));
    	String price_group = Utility.getName(request.getParameter("price_group"));
    	String searchKey = Utility.getName(request.getParameter("searchKey"));
    	
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String warehouseStatus = Utility.getName(request.getParameter("warehouseStatus"));
		String goodsBarcode = Utility.getName(request.getParameter("goodsBarcode"));

		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		if (!warehouseID.equals("") && !warehouseID.equals(",") && warehouseID.length() >= 1){
			warehouseID = warehouseID.substring(0,warehouseID.length()-1);
		}
		
		String bgiothergoodsbigclass = Utility.getName(request.getParameter("bgiothergoodsbigclass"));
		String bgiothergoodssmallclass = Utility.getName(request.getParameter("bgiothergoodssmallclass"));
		String minSphlh = Utility.getName(request.getParameter("minSphlh"));
		String maxSphlh = Utility.getName(request.getParameter("maxSphlh"));
		String pjlx = Utility.getName(request.getParameter("pjlx"));
		String talerttype = Utility.getName(request.getParameter("talerttype"));
		String makeinvoiceflag = Utility.getName(request.getParameter("makeinvoiceflag"));
		request.setAttribute("makeinvoiceflag", makeinvoiceflag);
		request.setAttribute("bgiothergoodsbigclass", bgiothergoodsbigclass);
		request.setAttribute("bgiothergoodssmallclass", bgiothergoodssmallclass);
		request.setAttribute("minSphlh", minSphlh);
		request.setAttribute("maxSphlh", maxSphlh);
		request.setAttribute("pjlx", pjlx);
		request.setAttribute("talerttype", talerttype);
		
		if(radio_type.equals("")){
			radio_type = "goods";
		}
		if(price_group.equals("")){
			price_group = "yes";
		}
		
		//判断显示的仓位是启用的还是停用的还是不分仓
		String usingWarehouse = Utility.getName(request.getParameter("usingWarehouse"));
		request.setAttribute("usingWarehouse",usingWarehouse.equals("") ? "0" : usingWarehouse);
		
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String isClosed = Utility.getName(request.getParameter("isClosed"));
		
		//镜架  成镜 老花镜
		String bgispecjj = Utility.getName(request.getParameter("bgispecjj"));
		String bgicolorjj = Utility.getName(request.getParameter("bgicolorjj"));
		String bgispeclh = Utility.getName(request.getParameter("bgispeclh"));
		String bgicolorlh = Utility.getName(request.getParameter("bgicolorlh"));
		String cgyearjj = Utility.getName(request.getParameter("cgyear"));
		String bgiframesizejj = Utility.getName(request.getParameter("bgiframesizejj"));

		//add by ZK
		String bgitechnologytypeid = Utility.getName(request.getParameter("bgitechnologytypeid"));
		String bgiframematerialtype = Utility.getName(request.getParameter("bgiframematerialtype"));
		
		request.setAttribute("bgispecjj", bgispecjj);
		request.setAttribute("bgicolorjj", bgicolorjj);
		request.setAttribute("bgispeclh", bgispeclh);
		request.setAttribute("bgicolorlh", bgicolorlh);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("cgyear", cgyearjj);
		//add by ZK
		request.setAttribute("bgitechnologytypeid", bgitechnologytypeid);
		request.setAttribute("bgiframematerialtype", bgiframematerialtype);
		
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
		String changeMinCyljp = Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCyljp"),request.getParameter("minCyljp")));
		String changeMaxCyljp = Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCyljp"),request.getParameter("maxCyljp")));
		
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		
		//隐形镜片
		String bgiusetypeyj = Utility.getName(request.getParameter("bgiusetypeyj"));
		String bgistealthclassyj = Utility.getName(request.getParameter("bgistealthclassyj"));
		//翻方前
		String minSphyj = Utility.getName(request.getParameter("minSphyj"));
		String maxSphyj = Utility.getName(request.getParameter("maxSphyj"));
		String minCylyj = Utility.getName(request.getParameter("minCylyj"));
		String maxCylyj = Utility.getName(request.getParameter("maxCylyj"));
		//翻方后
		String changeMinSphyj = Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphyj"),request.getParameter("minCylyj")));
		String changeMaxSphyj = Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphyj"),request.getParameter("maxCylyj")));
		String changeMinCylyj = Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCylyj"),request.getParameter("minCylyj")));
		String changeMaxCylyj = Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCylyj"),request.getParameter("maxCylyj")));
		
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		
		request.setAttribute("bgiusetypeyj", bgiusetypeyj);
		request.setAttribute("bgistealthclassyj", bgistealthclassyj);
		request.setAttribute("minSphyj", minSphyj);
		request.setAttribute("maxSphyj", maxSphyj);
		request.setAttribute("minCylyj", minCylyj);
		request.setAttribute("maxCylyj", maxCylyj);
		
		request.setAttribute("isClosed",isClosed);
		
		String isCustomizejp = Utility.getName(request.getParameter("isCustomizejp"));
		request.setAttribute("isCustomizejp", isCustomizejp);
		String isCustomizeyx = Utility.getName(request.getParameter("isCustomizeyx"));
		request.setAttribute("isCustomizeyx", isCustomizeyx);
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		FquartzSwitchPo fspo = reportQuartzMgr.getFquartzSwitchPo();
		
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setPricegroup(price_group);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setAlerttype(talerttype);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgigoodsquantity(warehouseStatus.equals("") ? "1" : warehouseStatus);
		goodsInfoPo.setBgiflag(isClosed);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgigoodsbarcode(goodsBarcode);		
		goodsInfoPo.setBgiwarehouseid(warehouseID);
		goodsInfoPo.setCstcpodid(usingWarehouse.equals("") ? "0" : usingWarehouse);     //判断查询的是启用还是停用的仓位
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgiwhichretail(whichretail);
		goodsInfoPo.setBgiismendretail(select_retail);
		goodsInfoPo.setBgiaccessoriestype(pjlx);
		goodsInfoPo.setMakeinvoiceflags(Utility.getName(fspo.getFqswzhzstd()));
		goodsInfoPo.setMakeinvoiceflag(makeinvoiceflag);

		if (goodscategoryID.equals("3")){
			goodsInfoPo.setBgiiscustomize(isCustomizejp);
		}
		if (goodscategoryID.equals("4")){
			goodsInfoPo.setBgiiscustomize(isCustomizeyx);
		}
		
		//镜架条件赋值
		goodsInfoPo.setBgispec(bgispecjj.equals("") ? bgispeclh : bgispecjj);
		goodsInfoPo.setBgicolor(bgicolorjj.equals("") ? bgicolorlh : bgicolorjj);
		goodsInfoPo.setBgiframesize(bgiframesizejj);
		
		goodsInfoPo.setBgitechnologytypeid(bgitechnologytypeid);
		goodsInfoPo.setBgiframematerialtype(bgiframematerialtype);
		
		//镜片条件赋值
		goodsInfoPo.setBgieyeglassmaterialtype(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractive(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosity(bgiismutiluminosityjp);
		goodsInfoPo.setStockQueryBeginDate(request.getParameter("startTime"));
		goodsInfoPo.setStockQueryEndDate(request.getParameter("endTime"));
		goodsInfoPo.setBgiusetype(bgiusetypeyj);
		goodsInfoPo.setBgistealthclass(bgistealthclassyj);
		goodsInfoPo.setBgiothergoodsbigclass(bgiothergoodsbigclass);
		goodsInfoPo.setBgiothergoodssmallclass(bgiothergoodssmallclass);
		
		goodsInfoPo.setSmecistocklist(warehouselist);		
		goodsInfoPo.setBgibrandyear(cgyearjj);
		
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		request.setAttribute("whichretail",whichretail);
		
		if(!"".equals(dpo.getBdpwhichretail())&&"1".equals(personInfoPo1.getDepartmenttype())){
			goodsInfoPo.setBgiwhichretail(dpo.getBdpwhichretail());
			request.setAttribute("whichretail",dpo.getBdpwhichretail());
		}
		
		if(!"".equals(changeMaxSphjp)){
			goodsInfoPo.setMaxSph(changeMaxSphjp);
		}else if(!"".equals(changeMaxSphyj)){
			goodsInfoPo.setMaxSph(changeMaxSphyj);
		}else if(!"".equals(maxSphlh)){
			goodsInfoPo.setMaxSph(maxSphlh);
		}
		if(!"".equals(changeMinSphjp)){
			goodsInfoPo.setMinSph(changeMinSphjp);
		}else if(!"".equals(changeMinSphyj)){
			goodsInfoPo.setMinSph(changeMinSphyj);
		}else if(!"".equals(minSphlh)){
			goodsInfoPo.setMinSph(minSphlh);
		}
		
		if(!"".equals(changeMaxCyljp)){
			goodsInfoPo.setMaxCyl(changeMaxCyljp);
		}else if(!"".equals(changeMaxCylyj)){
			goodsInfoPo.setMaxCyl(changeMaxCylyj);
		}
		
		if(!"".equals(changeMinCyljp)){
			goodsInfoPo.setMinCyl(changeMinCyljp);
		}else if(!"".equals(changeMinCylyj)){
			goodsInfoPo.setMinCyl(changeMinCylyj);
		}

		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());			
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1"))	{
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
		
		if(searchKey.equals("openwindow")){
			request.setAttribute("showhider", "0");
		}
		
		Map<String, Object> goodsNums = null;
		String bgigoodsquantityCount ="";
		if(radio_type.equals("brand")){//查询角度：品种
			goodsNums = stockSearchMgr.getStockSearchBrandAnyTimeCount(goodsInfoPo);
//			bgigoodsquantityCount=stockSearchMgr.getStorageAnyTimerBrandQ(goodsInfoPo).getBgigoodsquantity();
		}else{//查询角度：商品
			goodsNums = stockSearchMgr.getStockSearchAnyTimeCount(goodsInfoPo);
//			bgigoodsquantityCount = stockSearchMgr.getStorageAnyTimerGoodsQ(goodsInfoPo).getBgigoodsquantity();
		}
		
		String count = goodsNums.get("count").toString();

		String goodNum = goodsNums.get("titlenum") != null ? goodsNums.get("titlenum").toString() : "0";

		request.setAttribute("titlenum", goodNum);
		if (Integer.parseInt(count) > 0) {
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
			Pagination page = new Pagination(request, Integer.parseInt(count),perPage);
			if(radio_type.equals("brand")){//查询角度: 商品
				goodsList = null;
				brandsList = stockSearchMgr.getStockSearchBrandAnyTimeList(goodsInfoPo,page.getStart(), page.getPageSize());			
			}else{//查询角度: 品种
				brandsList = null;
				goodsList = stockSearchMgr.getStockSearchAnyTimeList(goodsInfoPo,page.getStart(), page.getPageSize());
			}
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
			brandsList = null;
		}
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();

		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("warehouseStatus", warehouseStatus);
		request.setAttribute("brandName", brandName);
		request.setAttribute("warehouseID", warehouseID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsBarcode", goodsBarcode);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		request.setAttribute("radio_type", radio_type);
		request.setAttribute("price_group", price_group);
		request.setAttribute("searchKey", searchKey);
		request.setAttribute("endTime", request.getParameter("endTime"));
		request.setAttribute("startTime", request.getParameter("startTime"));
		request.setAttribute("bgigoodsquantityCount", bgigoodsquantityCount);
		return SUCCESS;
	}
		
	public StockSearchMgr getStockSearchMgr() {
		return stockSearchMgr;
	}

	public void setStockSearchMgr(StockSearchMgr stockSearchMgr) {
		this.stockSearchMgr = stockSearchMgr;
	}

	public List<FrameMaterialPo> getFrameMaterialList() {
		return frameMaterialList;
	}

	public void setFrameMaterialList(List<FrameMaterialPo> frameMaterialList) {
		this.frameMaterialList = frameMaterialList;
	}

	public FrameMaterialMgr getFrameMaterialMgr() {
		return frameMaterialMgr;
	}

	public void setFrameMaterialMgr(FrameMaterialMgr frameMaterialMgr) {
		this.frameMaterialMgr = frameMaterialMgr;
	}

	public List<TechnologyTypePo> getTeachnologyList() {
		return teachnologyList;
	}

	public void setTeachnologyList(List<TechnologyTypePo> teachnologyList) {
		this.teachnologyList = teachnologyList;
	}
	/**
	 * 商品销售流水查询 sxh 2011-11-28
	 */
	public String selSalseSearchLs() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String bgigoodsid = Utility.getName(request.getParameter("bgigoodsid"));
		String bgiwarehouseid  = Utility.getName(request.getParameter("bgiwarehouseid"));		
		String billID  = Utility.getName(request.getParameter("billID"));
		String startTime  = Utility.getName(request.getParameter("startdate"));
		String endTime  = Utility.getName(request.getParameter("enddate"));
		
		String goodsCategoryID  = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierID  = Utility.getName(request.getParameter("supplierID"));
		String brandID  = Utility.getName(request.getParameter("brandID"));
		String sph  = Utility.getName(request.getParameter("sph"));
		String cyl  = Utility.getName(request.getParameter("cyl"));
		String isCustomize  = Utility.getName(request.getParameter("isCustomize"));
		String goodsBarcode  = Utility.getName(request.getParameter("goodsBarcode"));
		
		request.setAttribute("goodsBarcode", goodsBarcode);
		
		GoodsDetailsInfoPo goodsDetailsInfoPo = new GoodsDetailsInfoPo();
		goodsDetailsInfoPo.setSxhGoodsId(bgigoodsid);
		goodsDetailsInfoPo.setSxhStockID(bgiwarehouseid);
		goodsDetailsInfoPo.setSxhchangeid(billID);
		goodsDetailsInfoPo.setSxhbgndate(startTime);
		goodsDetailsInfoPo.setSxhenddate(endTime);		
		goodsDetailsInfoPo.setSxhGoodsCategoryID(goodsCategoryID);
		goodsDetailsInfoPo.setSxhSupplierID(supplierID);
		goodsDetailsInfoPo.setSxhBrandID(brandID); 
		goodsDetailsInfoPo.setSxhsph(sph);	
		goodsDetailsInfoPo.setSxhcyl(cyl);
		goodsDetailsInfoPo.setSxhisCustomize(isCustomize);
		goodsDetailsInfoPo.setSxhGoodsBarCode(goodsBarcode);
		
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
		
		Map<String, Object> goodsNums = stockSearchMgr.getSalseSearchLsCount(goodsDetailsInfoPo);
		String count = goodsNums.get("count").toString();

		String goodNum = goodsNums.get("titlenum") != null ? goodsNums.get(
				"titlenum").toString() : "0";

		request.setAttribute("titlenum", goodNum);

		if (Integer.parseInt(count) > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, Integer.parseInt(count),
					perPage);
			goodsDetailsList = stockSearchMgr.getSalseSearchLsList(goodsDetailsInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsDetailsList = null;
		}
		
//		GoodsDetailsInfoPo gpo = stockSearchMgr.getFirstStockGoodsInfoPo(goodsDetailsInfoPo);
//		request.setAttribute("firstStock", Utility.getName(gpo.getSxhsumnum()).equals("") ? "0" : Utility.getName(gpo.getSxhsumnum()));
		
//		goodsDetailsInfoPo.setSxhbgndate("");
//		gpo = stockSearchMgr.getEndStockGoodsInfoPo(goodsDetailsInfoPo);

		request.setAttribute("bgigoodsid", bgigoodsid);
		request.setAttribute("bgiwarehouseid", bgiwarehouseid);
		request.setAttribute("billID", billID);
		request.setAttribute("startdate", startTime);
		request.setAttribute("enddate", endTime);		
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("sph", sph);
		request.setAttribute("cyl", cyl);
		request.setAttribute("isCustomize", isCustomize);		
		
		return SUCCESS;
	}
	
	/**
	 * 初始化库存预警查询(二维)
	 */
	public String initStockAlert2DSel(){
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

		request.setAttribute("usingWarehouse","0");
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(Utility.getName(personInfoPo.getDepartmentID()));
		departmentsPo.setBdptype(Utility.getName(personInfoPo.getDepartmenttype()));		
		WarehousePo warehousePo = new WarehousePo();
		
		if("0".equals(Utility.getName(systemParameterPo.getFspsharestockmessage()))){
			if ("1".equals(personInfoPo.getDepartmenttype())) {
				warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
				warehouselist = warehouseMgr.getWarehouseList(warehousePo);
			} else if ("2".equals(personInfoPo.getDepartmenttype())) {
				warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
				warehouselist = warehouseMgr.getWarehouseList(warehousePo);
			} else {
				if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
					warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
				}
				
				warehouselist = warehouseMgr.getWarehouseList(warehousePo);
			}
		}else{
			if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
				warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
			}
			
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 库存预警查询(二维)
	 */
	public String selStockAlert2D(){
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
		
		String goodsCategoryID  = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierID  = Utility.getName(request.getParameter("supplierID"));
		String brandID  = Utility.getName(request.getParameter("brandID"));
		String warehouseID  = Utility.getName(request.getParameter("warehouseID"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandID",brandID);
		request.setAttribute("warehouseID",warehouseID);
		
		return SUCCESS;
	}
	/**
	 * 初始化库存综合查询
	 */
	public String initStockAgeSearchSel() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取
		
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo1.getDepartmentID()));
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		request.setAttribute("whichretail",dpo.getBdpwhichretail());
		
		//新增工艺类型、镜架材质查询字段 add by ZK
		teachnologyList = varietyMgr.getTechnologyType();
		frameMaterialList = frameMaterialMgr.getFrameMaterialList();
		
		WarehousePo warehousePo = new WarehousePo();
		
		//默认显示启用的仓位
		request.setAttribute("usingWarehouse","0");


		request.setAttribute("makeinvoiceflag", 1);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
    	if("0".equals(Utility.getName(systemParameterPo.getFspsharestockmessage())))
    	{
			if ("1".equals(personInfoPo.getDepartmenttype())) {
				warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
				warehouselist = warehouseMgr.getWarehouseList(warehousePo);
			} else if ("2".equals(personInfoPo.getDepartmenttype())) {
				warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
				warehouselist = warehouseMgr.getWarehouseList(warehousePo);
			} else {
				warehouselist = warehouseMgr.getWarehouseList(warehousePo);
			}
    	}
		else
		{
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		}
    	if("1".equals(personInfoPo1.getDepartmenttype())){
	    	if("1".equals(systemParameterPo.getFspsharestockmessage())&&!"4".equals(systemParameterPo.getFspstockqueryconditions())){
	    		systemParameterPo.setFspshowchange("1");
	    	}
    	}

		return SUCCESS;
	}
	
	public String stockAgeSearchSel() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		// 新增工艺类型、镜架材质查询字段 add by ZK
		teachnologyList = varietyMgr.getTechnologyType();
		frameMaterialList = frameMaterialMgr.getFrameMaterialList();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo1.getDepartmentID()));		
				
		WarehousePo warehousePo = new WarehousePo();
    	if("0".equals(Utility.getName(systemParameterPo.getFspsharestockmessage()))){
			if ("1".equals(personInfoPo1.getDepartmenttype())) {
				warehousePo.setBwhdeptid(personInfoPo1.getDepartmentID());
				warehouselist = warehouseMgr.getWarehouseList(warehousePo);
			} else if ("2".equals(personInfoPo1.getDepartmenttype())) {
				warehousePo.setBwhdeptid(personInfoPo1.getDepartmentID());
				warehouselist = warehouseMgr.getWarehouseList(warehousePo);
			} else {
				warehouselist = warehouseMgr.getWarehouseList(warehousePo);
			}
    	}else{
    		warehouselist = warehouseMgr.getWarehouseList(warehousePo);
    	}
    	
    	String radio_type = Utility.getName(request.getParameter("radio_type"));
    	String price_group = Utility.getName(request.getParameter("price_group"));
    	String searchKey = Utility.getName(request.getParameter("searchKey"));
    	
    	String openclose=Utility.getName(systemParameterPo.getFspsharestockmessage());
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String warehouseStatus = Utility.getName(request.getParameter("warehouseStatus"));
		String goodsBarcode = Utility.getName(request.getParameter("goodsBarcode"));
		String rksjbegin = Utility.getName(request.getParameter("rksjbegin"));
		String rksjend = Utility.getName(request.getParameter("rksjend"));
		
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		if (!warehouseID.equals("") && !warehouseID.equals(",") && warehouseID.length() >= 1 && warehouseID.endsWith(",")){
			warehouseID = warehouseID.substring(0,warehouseID.length()-1);
		}
				
		String bgiothergoodsbigclass = Utility.getName(request.getParameter("bgiothergoodsbigclass"));
		String bgiothergoodssmallclass = Utility.getName(request.getParameter("bgiothergoodssmallclass"));
		String minSphlh = Utility.getName(request.getParameter("minSphlh"));
		String maxSphlh = Utility.getName(request.getParameter("maxSphlh"));
		String pjlx = Utility.getName(request.getParameter("pjlx"));
		String talerttype = Utility.getName(request.getParameter("talerttype"));
		String makeinvoiceflag = Utility.getName(request.getParameter("makeinvoiceflag"));
		request.setAttribute("makeinvoiceflag", makeinvoiceflag);
		request.setAttribute("bgiothergoodsbigclass", bgiothergoodsbigclass);
		request.setAttribute("bgiothergoodssmallclass", bgiothergoodssmallclass);
		request.setAttribute("minSphlh", minSphlh);
		request.setAttribute("maxSphlh", maxSphlh);
		request.setAttribute("pjlx", pjlx);
		request.setAttribute("talerttype", talerttype);
		request.setAttribute("rksjbegin", rksjbegin);
		request.setAttribute("rksjend", rksjend);
		
		if(radio_type.equals("")){
			radio_type = "goods";
		}
		if(price_group.equals("")){
			price_group = "yes";
		}
		
		//判断显示的仓位是启用的还是停用的还是不分仓
		String usingWarehouse = Utility.getName(request.getParameter("usingWarehouse"));
		request.setAttribute("usingWarehouse",usingWarehouse.equals("") ? "0" : usingWarehouse);
		
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String isClosed = Utility.getName(request.getParameter("isClosed"));
		
		//镜架  成镜 老花镜
		String bgispecjj = Utility.getName(request.getParameter("bgispecjj"));
		String bgicolorjj = Utility.getName(request.getParameter("bgicolorjj"));
		String bgispeclh = Utility.getName(request.getParameter("bgispeclh"));
		String bgicolorlh = Utility.getName(request.getParameter("bgicolorlh"));
		
		String bgiframesizejj = Utility.getName(request.getParameter("bgiframesizejj"));

		//add by ZK
		String bgitechnologytypeid = Utility.getName(request.getParameter("bgitechnologytypeid"));
		String bgiframematerialtype = Utility.getName(request.getParameter("bgiframematerialtype"));
		
		request.setAttribute("bgispecjj", bgispecjj);
		request.setAttribute("bgicolorjj", bgicolorjj);
		request.setAttribute("bgispeclh", bgispeclh);
		request.setAttribute("bgicolorlh", bgicolorlh);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		//add by ZK
		request.setAttribute("bgitechnologytypeid", bgitechnologytypeid);
		request.setAttribute("bgiframematerialtype", bgiframematerialtype);
		
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
		
		//隐形镜片
		String bgiusetypeyj = Utility.getName(request.getParameter("bgiusetypeyj"));
		String bgistealthclassyj = Utility.getName(request.getParameter("bgistealthclassyj"));
		//翻方前
		String minSphyj = Utility.getName(request.getParameter("minSphyj"));
		String maxSphyj = Utility.getName(request.getParameter("maxSphyj"));
		String minCylyj = Utility.getName(request.getParameter("minCylyj"));
		String maxCylyj = Utility.getName(request.getParameter("maxCylyj"));
		//翻方后
		String changeMinSphyj = Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphyj"),request.getParameter("minCylyj")));
		String changeMaxSphyj = Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphyj"),request.getParameter("maxCylyj")));
		String changeMinCylyj=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCylyj"),request.getParameter("minCylyj")));
		String changeMaxCylyj=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCylyj"),request.getParameter("maxCylyj")));
		
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		
		request.setAttribute("bgiusetypeyj", bgiusetypeyj);
		request.setAttribute("bgistealthclassyj", bgistealthclassyj);
		request.setAttribute("minSphyj", minSphyj);
		request.setAttribute("maxSphyj", maxSphyj);
		request.setAttribute("minCylyj", minCylyj);
		request.setAttribute("maxCylyj", maxCylyj);
		
		request.setAttribute("isClosed",isClosed);
		
		String isCustomizejp = Utility.getName(request.getParameter("isCustomizejp"));
		request.setAttribute("isCustomizejp", isCustomizejp);
		String isCustomizeyx = Utility.getName(request.getParameter("isCustomizeyx"));
		request.setAttribute("isCustomizeyx", isCustomizeyx);
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		FquartzSwitchPo fspo = reportQuartzMgr.getFquartzSwitchPo();
		
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setPricegroup(price_group);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setAlerttype(talerttype);
		goodsInfoPo.setOpenclose(openclose);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgigoodsquantity(warehouseStatus.equals("") ? "1" : warehouseStatus);
		goodsInfoPo.setBgiflag(isClosed);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgigoodsbarcode(goodsBarcode);		
		goodsInfoPo.setBgiwarehouseid(warehouseID);
		goodsInfoPo.setCstcpodid(usingWarehouse.equals("") ? "0" : usingWarehouse);     //判断查询的是启用还是停用的仓位
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgiwhichretail(whichretail);
		goodsInfoPo.setBgiismendretail(select_retail);
		goodsInfoPo.setBgiaccessoriestype(pjlx);
		goodsInfoPo.setMakeinvoiceflags(Utility.getName(fspo.getFqswzhzstd()));
		goodsInfoPo.setMakeinvoiceflag(makeinvoiceflag);
		goodsInfoPo.setRksjbegin(rksjbegin);
		goodsInfoPo.setRksjend(rksjend);
		if (goodscategoryID.equals("3")){
			goodsInfoPo.setBgiiscustomize(isCustomizejp);
		}
		if (goodscategoryID.equals("4")){
			goodsInfoPo.setBgiiscustomize(isCustomizeyx);
		}
		
		
		//镜架条件赋值
		goodsInfoPo.setBgispec(bgispecjj.equals("") ? bgispeclh : bgispecjj);
		goodsInfoPo.setBgicolor(bgicolorjj.equals("") ? bgicolorlh : bgicolorjj);
		goodsInfoPo.setBgiframesize(bgiframesizejj);
		
		goodsInfoPo.setBgitechnologytypeid(bgitechnologytypeid);
		goodsInfoPo.setBgiframematerialtype(bgiframematerialtype);
		
		//镜片条件赋值
		goodsInfoPo.setBgieyeglassmaterialtype(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractive(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosity(bgiismutiluminosityjp);
		
		
		goodsInfoPo.setBgiusetype(bgiusetypeyj);
		goodsInfoPo.setBgistealthclass(bgistealthclassyj);
		goodsInfoPo.setBgiothergoodsbigclass(bgiothergoodsbigclass);
		goodsInfoPo.setBgiothergoodssmallclass(bgiothergoodssmallclass);
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		request.setAttribute("whichretail",whichretail);
		
		if(!"".equals(dpo.getBdpwhichretail())&&"1".equals(personInfoPo1.getDepartmenttype())){
			goodsInfoPo.setBgiwhichretail(dpo.getBdpwhichretail());
			request.setAttribute("whichretail",dpo.getBdpwhichretail());
		}
		
		if(!"".equals(changeMaxSphjp)){
			goodsInfoPo.setMaxSph(changeMaxSphjp);
		}else if(!"".equals(changeMaxSphyj)){
			goodsInfoPo.setMaxSph(changeMaxSphyj);
		}else if(!"".equals(maxSphlh)){
			goodsInfoPo.setMaxSph(maxSphlh);
		}
		if(!"".equals(changeMinSphjp)){
			goodsInfoPo.setMinSph(changeMinSphjp);
		}else if(!"".equals(changeMinSphyj)){
			goodsInfoPo.setMinSph(changeMinSphyj);
		}else if(!"".equals(minSphlh)){
			goodsInfoPo.setMinSph(minSphlh);
		}
		
		if(!"".equals(changeMaxCyljp)){
			goodsInfoPo.setMaxCyl(changeMaxCyljp);
		}else if(!"".equals(changeMaxCylyj)){
			goodsInfoPo.setMaxCyl(changeMaxCylyj);
		}
		
		if(!"".equals(changeMinCyljp)){
			goodsInfoPo.setMinCyl(changeMinCyljp);
		}else if(!"".equals(changeMinCylyj)){
			goodsInfoPo.setMinCyl(changeMinCylyj);
		}
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1"))	{
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
		
		if(searchKey.equals("openwindow")){
			request.setAttribute("showhider", "0");
		}
		
		Map<String, Object> goodsNums = null;
		

		goodsNums = stockSearchMgr.getStockAgeSearchCount(goodsInfoPo, personInfoPo1);

		
		String count = goodsNums.get("count").toString();
		String goodNum = goodsNums.get("titlenum") != null ? goodsNums.get("titlenum").toString() : "0";

		request.setAttribute("titlenum", goodNum);
		if (Integer.parseInt(count) > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, Integer.parseInt(count),perPage);

			goodsList = stockSearchMgr.getStockAgeSearchList(goodsInfoPo,(PersonInfoPo) session.get("person"), page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
			brandsList = null;
		}
		
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("warehouseStatus", warehouseStatus);
		request.setAttribute("brandName", brandName);
		request.setAttribute("warehouseID", warehouseID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsBarcode", goodsBarcode);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		request.setAttribute("radio_type", radio_type);
		request.setAttribute("price_group", price_group);
		request.setAttribute("searchKey", searchKey);
		
		return SUCCESS;
	}

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
}
