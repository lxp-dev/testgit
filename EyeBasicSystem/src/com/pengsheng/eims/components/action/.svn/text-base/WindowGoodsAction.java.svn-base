package com.pengsheng.eims.components.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.pengsheng.eims.basic.dao.impl.TechnologyTypePo;
import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.DownloadRegionMgr;
import com.pengsheng.eims.basic.mgr.GlassesFrameMgr;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsDetailsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.WindowGoodsMgr;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.mgr.StockSearchMgr;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.FrameMaterialMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.TurnSphCyl;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * 商品查询开窗action
 */
public class WindowGoodsAction extends BaseAction {
	
	private List<GoodsDetailsInfoPo> goodsDetailsList;
	private StockSearchMgr stockSearchMgr;
	private List<InventoryPo> procurementReceiptList;
	private PersonPermissionMgr personPermissionMgr;
	private DownloadRegionMgr downloadRegionMgr;
	private WindowGoodsMgr windowGoodsMgr;
	private List<FrameMaterialPo> frameMateriallist;
	private FrameMaterialMgr frameMaterialMgr;
	private List<BrandPo> brandlist;
	private List<DepartmentsPo> departmentsList;	
	private List<AllocationPo> allocationList;	
	private List<GoodsInfoPo> goodsInfoList;
	private GoodsInfoPo goodsInfoPo;
	private SupplierMgr supplierMgr;
	private VarietyMgr varietyMgr;
	private WarehouseMgr warehouseMgr;
	private List<WarehousePo> warehouselist;
	private List<GoodsCategoryPo> goodsCategorys;	
	private List<TechnologyTypePo> technologyType;//quyanping
	private List<GoodsInfoPo> goodsList;
	private BrandMgr brandMgr;
	private List<GoodsInfoPo> goodsNumberList;
	private DepartmentsMgr departmentsMgr;
	private AllocationMgr allocationMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<SupplierPo> supplierPos;
	private List<BrandPo> brandPos;
	private GlassesFrameMgr glassesFrameMgr;
	private UnitMgr unitMgr;
	private List<GoodsInfoPo> glassesFrameList;
	private List<RefractiveSetPo> refractiveSetPos;

	/**
	 * 初始化单品商品查询
	 */
	public String initGoodsSingleSel() throws Exception {
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
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo.getDepartmentID()));
		
		//是否显示库存为零的查询条件；
		String isshowquantity = Utility.getName(request.getParameter("isshowquantity"));
		request.setAttribute("isshowquantity", isshowquantity);
		
		if(!isshowquantity.equals("")){
			WarehousePo tmpWarehousePo = new WarehousePo();
			tmpWarehousePo.setBwhdeptid(Utility.getName(personInfoPo.getDepartmentID()));
			warehouselist = warehouseMgr.getWarehouseList(tmpWarehousePo);
		}
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);
		String storebatch = Utility.getName(request.getParameter("storebatch"));
		request.setAttribute("storebatch", storebatch);
		
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String brandID = Utility.getName(request.getParameter("brandID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		String cstibillid=Utility.getName(request.getParameter("cstibillid"));
		request.setAttribute("cstibillid", cstibillid);

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		
		if (!"".equals(Utility.getName(brandID))) {
			BrandPo brandPo = new BrandPo();
			brandPo.setBbdid(brandID);
			brandPo.setBbdsupplierid(supplierID);
			brandPo = brandMgr.getBrandPo(brandPo);
			request.setAttribute("brandName", brandPo
					.getBbdbrandname());
		}
		
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("brandID_open", brandID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("iscustomize", iscustomize);
		
		return SUCCESS;
	}
	/**
	 * 初始化单品商品查询
	 */
	public String initGoodsSingleSelUpdateAttribute() throws Exception {
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
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo.getDepartmentID()));
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);
		String storebatch = Utility.getName(request.getParameter("storebatch"));
		request.setAttribute("storebatch", storebatch);
		
		String iscustomizekj=Utility.getName(request.getParameter("iscustomizekj"));
		String iscustomizeyx=Utility.getName(request.getParameter("iscustomizeyx"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String brandID = Utility.getName(request.getParameter("brandID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		
		if (!"".equals(Utility.getName(brandID))) {
			BrandPo brandPo = new BrandPo();
			brandPo.setBbdid(brandID);
			brandPo.setBbdsupplierid(supplierID);
			brandPo = brandMgr.getBrandPo(brandPo);
			request.setAttribute("brandName", brandPo
					.getBbdbrandname());
		}
		
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("brandID_open", brandID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("iscustomizekj", iscustomizekj);
		request.setAttribute("iscustomizeyx", iscustomizeyx);
		return SUCCESS;
	}
	/**
	 * 初始化无配镜单单品商品查询
	 */
	public String initGoodsSingleSelWP() throws Exception {
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
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo.getDepartmentID()));
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);
		String storebatch = Utility.getName(request.getParameter("storebatch"));
		request.setAttribute("storebatch", storebatch);
		request.getParameter("rl");
		request.setAttribute("rl", request.getParameter("rl"));
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String brandID = Utility.getName(request.getParameter("brandID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		
		if (!"".equals(Utility.getName(brandID))) {
			BrandPo brandPo = new BrandPo();
			brandPo.setBbdid(brandID);
			brandPo.setBbdsupplierid(supplierID);
			brandPo = brandMgr.getBrandPo(brandPo);
			request.setAttribute("brandName", brandPo
					.getBbdbrandname());
		}
		
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("brandID_open", brandID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("iscustomize", iscustomize);
		
		return SUCCESS;
	}
	/**
	 * 初始化单品商品查询
	 */
	public String initGoodsSingleSelZT() throws Exception {
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
		request.setAttribute("departmenttype",Utility.getName(personInfoPo.getDepartmenttype()));
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);
		String stockid = Utility.getName(request.getParameter("stockid"));
		request.setAttribute("stockid", stockid);
		WarehousePo wpoq = new WarehousePo();
		wpoq.setBwhid(stockid);
		WarehousePo wpo = warehouseMgr.getWarehouse(wpoq);
		
		request.setAttribute("stockname", wpo.getBwhwarehouseName());
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String brandID = Utility.getName(request.getParameter("brandID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		
		String indptid = Utility.getName(request.getParameter("indptid"));
		request.setAttribute("indptid",indptid);
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		
		if (!"".equals(Utility.getName(brandID))) {
			BrandPo brandPo = new BrandPo();
			brandPo.setBbdid(brandID);
			brandPo.setBbdsupplierid(supplierID);
			brandPo = brandMgr.getBrandPo(brandPo);
			request.setAttribute("brandName", brandPo
					.getBbdbrandname());
		}
		
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("brandID_open", brandID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("iscustomize", iscustomize);
		
		String isshowstealth=Utility.getName(request.getParameter("isshowstealth"));
		request.setAttribute("isshowstealth", isshowstealth);
		
		return SUCCESS;
	}
	
	/**
	 * 查询单品商品
	 */
	public String selGoodsSingle() throws Exception {
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
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo.getDepartmentID()));	
		
		//是否显示库存为零的查询条件；
		String isshowquantity = Utility.getName(request.getParameter("isshowquantity"));
		request.setAttribute("isshowquantity", isshowquantity);
		
		String warehouseid = Utility.getName(request.getParameter("warehouseid"));
		request.setAttribute("warehouseid", warehouseid);
		
		if(!isshowquantity.equals("")){
			WarehousePo tmpWarehousePo = new WarehousePo();
			tmpWarehousePo.setBwhdeptid(Utility.getName(personInfoPo.getDepartmentID()));
			warehouselist = warehouseMgr.getWarehouseList(tmpWarehousePo);
		}
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);
		String storebatch = Utility.getName(request.getParameter("storebatch"));
		request.setAttribute("storebatch", storebatch);
		
		String bgistockquantity = Utility.getName(request.getParameter("num0"));
		String isguaranteeperiod=Utility.getName(request.getParameter("isguaranteeperiod"));
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String iscustomizeyx=Utility.getName(request.getParameter("iscustomizeyx"));
		String iscustomizekj=Utility.getName(request.getParameter("iscustomizekj"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		String bgisuppliercolorjj=Utility.getName(request.getParameter("bgisuppliercolorjj"));
		String bgiframesizejj=Utility.getName(request.getParameter("bgiframesizejj"));
		String bgiframematerialtypejj=Utility.getName(request.getParameter("bgiframematerialtypejj"));
		String technologyTypeIDjj=Utility.getName(request.getParameter("technologyTypeIDjj"));
		String bgiaccessoriestypepj=Utility.getName(request.getParameter("bgiaccessoriestypepj"));
		String minSphjp=Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp=Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp=Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp=Utility.getName(request.getParameter("maxCyljp"));
		//翻方后
		String changeMinSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphjp"), request.getParameter("minCyljp")));
		String changeMaxSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphjp"), request.getParameter("maxCyljp")));
		String changeMinCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCyljp"),request.getParameter("minCyljp")));
		String changeMaxCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCyljp"),request.getParameter("maxCyljp")));
		//翻方后end
		String minbgibelowplusluminosityjp=Utility.getName(request.getParameter("minbgibelowplusluminosityjp"));
		String maxbgibelowplusluminosityjp=Utility.getName(request.getParameter("maxbgibelowplusluminosityjp"));
		String bgieyeglassmaterialtypejp=Utility.getName(request.getParameter("bgieyeglassmaterialtypejp"));
		String bgirefractivejp=Utility.getName(request.getParameter("bgirefractivejp"));
		String bgiismutiluminosityjp=Utility.getName(request.getParameter("bgiismutiluminosityjp"));
		String bgifunctionclassjp=Utility.getName(request.getParameter("bgifunctionclassjp"));
		String bgigradualclassjp=Utility.getName(request.getParameter("bgigradualclassjp"));
		String minSphyx=Utility.getName(request.getParameter("minSphyx"));
		String maxSphyx=Utility.getName(request.getParameter("maxSphyx"));
		String minCylyx=Utility.getName(request.getParameter("minCylyx"));
		String maxCylyx=Utility.getName(request.getParameter("maxCylyx"));
		//翻方后
		String changeMinSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphyx"),request.getParameter("minCylyx")));
		String changeMaxSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphyx"),request.getParameter("maxCylyx")));
		String changeMinCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCylyx"),request.getParameter("minCylyx")));
		String changeMaxCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCylyx"),request.getParameter("maxCylyx")));
		//翻方后end

		String bgicurvature1yx=Utility.getName(request.getParameter("bgicurvature1yx"));
		String bgidiayx=Utility.getName(request.getParameter("bgidiayx"));
		String bgiusetypeyx=Utility.getName(request.getParameter("bgiusetypeyx"));
		String bgistealthclassyx=Utility.getName(request.getParameter("bgistealthclassyx"));
		String bgicapacityyxhly=Utility.getName(request.getParameter("bgicapacityyxhly"));
		String bgicapacityentryyxhly=Utility.getName(request.getParameter("bgicapacityentryyxhly"));
		String bgisuppliercolortyj=Utility.getName(request.getParameter("bgisuppliercolortyj"));
		String bgiframesizetyj=Utility.getName(request.getParameter("bgiframesizetyj"));
		String minSphlhj=Utility.getName(request.getParameter("minSphlhj"));
		String maxSphlhj=Utility.getName(request.getParameter("maxSphlhj"));
		String bgisuppliercolorlhj=Utility.getName(request.getParameter("bgisuppliercolorlhj"));
		String bgiframesizelhj=Utility.getName(request.getParameter("bgiframesizelhj"));
		String bgispecs=Utility.getName(request.getParameter("bgispecs"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		String cstibillid=Utility.getName(request.getParameter("cstibillid"));
		request.setAttribute("cstibillid", cstibillid);
		
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandName", brandName);
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
		request.setAttribute("iscustomize", iscustomize);
		
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		
		if ("".equals(brandID)) {
			brandID = Utility.getName(request.getParameter("brandID_open"));
			
			if (!"".equals(Utility.getName(brandID))) {
				BrandPo brandPo = new BrandPo();
				brandPo.setBbdid(brandID);
				brandPo.setBbdsupplierid(supplierID);
				brandPo = brandMgr.getBrandPo(brandPo);
				request.setAttribute("brandName", brandPo.getBbdbrandname());
			}
			request.setAttribute("brandID_open", brandID);
		}
		
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
				
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgijm(jm);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setBgiwhichretail(whichretail);
		goodsInfoPo.setBgiismendretail(select_retail);
		goodsInfoPo.setIsguaranteeperiod(isguaranteeperiod);
		goodsInfoPo.setBillid(cstibillid);
		
		if("3".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizekj)){
			goodsInfoPo.setBgiiscustomize(iscustomizekj);
		}else if("4".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizeyx)){
			goodsInfoPo.setBgiiscustomize(iscustomizeyx);
		}else{
			goodsInfoPo.setBgiiscustomize(iscustomize);
		}
////////////////////////////////////////////////////////////////////////////////////////		
		goodsInfoPo.setBgispec(bgispecs); 
		goodsInfoPo.setBgisuppliercolorjj(bgisuppliercolorjj);
		goodsInfoPo.setBgiframesizejj(bgiframesizejj);
		goodsInfoPo.setBgiframematerialtypejj(bgiframematerialtypejj);
		goodsInfoPo.setTechnologyTypeIDjj(technologyTypeIDjj);
		goodsInfoPo.setBgiaccessoriestypepj(bgiaccessoriestypepj);
		goodsInfoPo.setMinSphjp(changeMinSphjp);
		goodsInfoPo.setMaxSphjp(changeMaxSphjp);
		goodsInfoPo.setMinCyljp(changeMinCyljp);
		goodsInfoPo.setMaxCyljp(changeMaxCyljp);
		goodsInfoPo.setMinbgibelowplusluminosityjp(minbgibelowplusluminosityjp);
		goodsInfoPo.setMaxbgibelowplusluminosityjp(maxbgibelowplusluminosityjp);
		goodsInfoPo.setBgieyeglassmaterialtypejp(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractivejp(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosityjp(bgiismutiluminosityjp);
		goodsInfoPo.setBgifunctionclassjp(bgifunctionclassjp);
		goodsInfoPo.setBgigradualclassjp(bgigradualclassjp);
		goodsInfoPo.setMinSphyx(changeMinSphyx);
		goodsInfoPo.setMaxSphyx(changeMaxSphyx);
		goodsInfoPo.setMinCylyx(changeMinCylyx);
		goodsInfoPo.setMaxCylyx(changeMaxCylyx);
		goodsInfoPo.setBgicurvature1yx(bgicurvature1yx);
		goodsInfoPo.setBgidiayx(bgidiayx);
		goodsInfoPo.setBgiusetypeyx(bgiusetypeyx);
		goodsInfoPo.setBgistealthclassyx(bgistealthclassyx);
		goodsInfoPo.setBgicapacityyxhly(bgicapacityyxhly);
		goodsInfoPo.setBgicapacityentryyxhly(bgicapacityentryyxhly);
		goodsInfoPo.setBgisuppliercolortyj(bgisuppliercolortyj);
		goodsInfoPo.setBgiframesizetyj(bgiframesizetyj);
		goodsInfoPo.setMinSphlhj(minSphlhj);
		goodsInfoPo.setMaxSphlhj(maxSphlhj);
		goodsInfoPo.setBgisuppliercolorlhj(bgisuppliercolorlhj);
		goodsInfoPo.setBgiframesizelhj(bgiframesizelhj);
		
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		request.setAttribute("whichretail",whichretail);
		
		if(!"".equals(dpo.getBdpwhichretail())&&"1".equals(personInfoPo.getDepartmenttype())){
			goodsInfoPo.setBgiwhichretail(dpo.getBdpwhichretail());
			request.setAttribute("whichretail",dpo.getBdpwhichretail());
		}
		
		String bgiwholesalebeginprice=Utility.getName(request.getParameter("bgiwholesalebeginprice"));
		String bgiwholesaleendprice=Utility.getName(request.getParameter("bgiwholesaleendprice"));
		request.setAttribute("bgiwholesalebeginprice", bgiwholesalebeginprice);
		request.setAttribute("bgiwholesaleendprice", bgiwholesaleendprice);
		
		goodsInfoPo.setBgiwholesalebeginprice(bgiwholesalebeginprice);
		goodsInfoPo.setBgiwholesaleendprice(bgiwholesaleendprice);	
		
		goodsInfoPo.setBgistockquantity(bgistockquantity);
		if(!isshowquantity.equals("")){
			goodsInfoPo.setBgiwarehouseid(warehouseid);
		}			
//////////////////////////////////////////////////////////////////////////////////////////////
		request.setAttribute("num0", bgistockquantity);
		request.setAttribute("bgispecs", bgispecs);
		request.setAttribute("bgisuppliercolorjj", bgisuppliercolorjj);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("bgiframematerialtypejj", bgiframematerialtypejj);
		request.setAttribute("technologyTypeIDjj", technologyTypeIDjj);
		request.setAttribute("bgiaccessoriestypepj", bgiaccessoriestypepj);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		request.setAttribute("minbgibelowplusluminosityjp", minbgibelowplusluminosityjp);
		request.setAttribute("maxbgibelowplusluminosityjp", maxbgibelowplusluminosityjp);
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("bgifunctionclassjp", bgifunctionclassjp);
		request.setAttribute("bgigradualclassjp", bgigradualclassjp);
		request.setAttribute("minSphyx", minSphyx);
		request.setAttribute("maxSphyx", maxSphyx);
		request.setAttribute("minCylyx", minCylyx);
		request.setAttribute("maxCylyx", maxCylyx);
		request.setAttribute("bgicurvature1yx", bgicurvature1yx);
		request.setAttribute("bgidiayx", bgidiayx);
		request.setAttribute("bgiusetypeyx", bgiusetypeyx);
		request.setAttribute("bgistealthclassyx", bgistealthclassyx);
		request.setAttribute("bgicapacityyxhly", bgicapacityyxhly);
		request.setAttribute("bgicapacityentryyxhly", bgicapacityentryyxhly);
		request.setAttribute("bgisuppliercolortyj", bgisuppliercolortyj);
		request.setAttribute("bgiframesizetyj", bgiframesizetyj);
		request.setAttribute("minSphlhj", minSphlhj);
		request.setAttribute("maxSphlhj", maxSphlhj);
		request.setAttribute("bgisuppliercolorlhj", bgisuppliercolorlhj);
		request.setAttribute("bgiframesizelhj", bgiframesizelhj);
		request.setAttribute("iscustomizeyx", iscustomizeyx);
		request.setAttribute("iscustomizekj", iscustomizekj);
		request.setAttribute("iscustomize", iscustomize);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = windowGoodsMgr.getGoodsSingleForAllocationCount(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleForAllocationList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		request.setAttribute("iscustomize", iscustomize);
		
		
		return SUCCESS;
	}	
	/**
	 * 查询单品商品
	 */
	public String selGoodsSingleUpdateAttribute() throws Exception {
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
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo.getDepartmentID()));	
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);
		String storebatch = Utility.getName(request.getParameter("storebatch"));
		request.setAttribute("storebatch", storebatch);
		
		String isguaranteeperiod=Utility.getName(request.getParameter("isguaranteeperiod"));
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String iscustomizeyx=Utility.getName(request.getParameter("iscustomizeyx"));
		String iscustomizekj=Utility.getName(request.getParameter("iscustomizekj"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		String bgisuppliercolorjj=Utility.getName(request.getParameter("bgisuppliercolorjj"));
		String bgiframesizejj=Utility.getName(request.getParameter("bgiframesizejj"));
		String bgiframematerialtypejj=Utility.getName(request.getParameter("bgiframematerialtypejj"));
		String technologyTypeIDjj=Utility.getName(request.getParameter("technologyTypeIDjj"));
		String bgiaccessoriestypepj=Utility.getName(request.getParameter("bgiaccessoriestypepj"));
		String minSphjp=Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp=Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp=Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp=Utility.getName(request.getParameter("maxCyljp"));
		//翻方后
		String changeMinSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphjp"), request.getParameter("minCyljp")));
		String changeMaxSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphjp"), request.getParameter("maxCyljp")));
		String changeMinCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCyljp"),request.getParameter("minCyljp")));
		String changeMaxCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCyljp"),request.getParameter("maxCyljp")));
		//翻方后end
		String minbgibelowplusluminosityjp=Utility.getName(request.getParameter("minbgibelowplusluminosityjp"));
		String maxbgibelowplusluminosityjp=Utility.getName(request.getParameter("maxbgibelowplusluminosityjp"));
		String bgieyeglassmaterialtypejp=Utility.getName(request.getParameter("bgieyeglassmaterialtypejp"));
		String bgirefractivejp=Utility.getName(request.getParameter("bgirefractivejp"));
		String bgiismutiluminosityjp=Utility.getName(request.getParameter("bgiismutiluminosityjp"));
		String bgifunctionclassjp=Utility.getName(request.getParameter("bgifunctionclassjp"));
		String bgigradualclassjp=Utility.getName(request.getParameter("bgigradualclassjp"));
		String minSphyx=Utility.getName(request.getParameter("minSphyx"));
		String maxSphyx=Utility.getName(request.getParameter("maxSphyx"));
		String minCylyx=Utility.getName(request.getParameter("minCylyx"));
		String maxCylyx=Utility.getName(request.getParameter("maxCylyx"));
		//翻方后
		String changeMinSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphyx"),request.getParameter("minCylyx")));
		String changeMaxSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphyx"),request.getParameter("maxCylyx")));
		String changeMinCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCylyx"),request.getParameter("minCylyx")));
		String changeMaxCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCylyx"),request.getParameter("maxCylyx")));
		//翻方后end

		String bgicurvature1yx=Utility.getName(request.getParameter("bgicurvature1yx"));
		String bgidiayx=Utility.getName(request.getParameter("bgidiayx"));
		String bgiusetypeyx=Utility.getName(request.getParameter("bgiusetypeyx"));
		String bgistealthclassyx=Utility.getName(request.getParameter("bgistealthclassyx"));
		String bgicapacityyxhly=Utility.getName(request.getParameter("bgicapacityyxhly"));
		String bgicapacityentryyxhly=Utility.getName(request.getParameter("bgicapacityentryyxhly"));
		String bgisuppliercolortyj=Utility.getName(request.getParameter("bgisuppliercolortyj"));
		String bgiframesizetyj=Utility.getName(request.getParameter("bgiframesizetyj"));
		String minSphlhj=Utility.getName(request.getParameter("minSphlhj"));
		String maxSphlhj=Utility.getName(request.getParameter("maxSphlhj"));
		String bgisuppliercolorlhj=Utility.getName(request.getParameter("bgisuppliercolorlhj"));
		String bgiframesizelhj=Utility.getName(request.getParameter("bgiframesizelhj"));
		String bgispecs=Utility.getName(request.getParameter("bgispecs"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandName", brandName);
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
		request.setAttribute("iscustomize", iscustomize);
		
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		
		if ("".equals(brandID)) {
			brandID = Utility.getName(request.getParameter("brandID_open"));
			
			if (!"".equals(Utility.getName(brandID))) {
				BrandPo brandPo = new BrandPo();
				brandPo.setBbdid(brandID);
				brandPo.setBbdsupplierid(supplierID);
				brandPo = brandMgr.getBrandPo(brandPo);
				request.setAttribute("brandName", brandPo.getBbdbrandname());
			}
			request.setAttribute("brandID_open", brandID);
		}
		
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
				
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgijm(jm);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setBgiwhichretail(whichretail);
		goodsInfoPo.setBgiismendretail(select_retail);
		goodsInfoPo.setIsguaranteeperiod(isguaranteeperiod);
		
		if("3".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizekj)){
			goodsInfoPo.setBgiiscustomize(iscustomizekj);
		}else if("4".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizeyx)){
			goodsInfoPo.setBgiiscustomize(iscustomizeyx);
		}else{
			goodsInfoPo.setBgiiscustomize(iscustomize);
		}
////////////////////////////////////////////////////////////////////////////////////////		
		goodsInfoPo.setBgispec(bgispecs); 
		goodsInfoPo.setBgisuppliercolorjj(bgisuppliercolorjj);
		goodsInfoPo.setBgiframesizejj(bgiframesizejj);
		goodsInfoPo.setBgiframematerialtypejj(bgiframematerialtypejj);
		goodsInfoPo.setTechnologyTypeIDjj(technologyTypeIDjj);
		goodsInfoPo.setBgiaccessoriestypepj(bgiaccessoriestypepj);
		goodsInfoPo.setMinSphjp(changeMinSphjp);
		goodsInfoPo.setMaxSphjp(changeMaxSphjp);
		goodsInfoPo.setMinCyljp(changeMinCyljp);
		goodsInfoPo.setMaxCyljp(changeMaxCyljp);
		goodsInfoPo.setMinbgibelowplusluminosityjp(minbgibelowplusluminosityjp);
		goodsInfoPo.setMaxbgibelowplusluminosityjp(maxbgibelowplusluminosityjp);
		goodsInfoPo.setBgieyeglassmaterialtypejp(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractivejp(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosityjp(bgiismutiluminosityjp);
		goodsInfoPo.setBgifunctionclassjp(bgifunctionclassjp);
		goodsInfoPo.setBgigradualclassjp(bgigradualclassjp);
		goodsInfoPo.setMinSphyx(changeMinSphyx);
		goodsInfoPo.setMaxSphyx(changeMaxSphyx);
		goodsInfoPo.setMinCylyx(changeMinCylyx);
		goodsInfoPo.setMaxCylyx(changeMaxCylyx);
		goodsInfoPo.setBgicurvature1yx(bgicurvature1yx);
		goodsInfoPo.setBgidiayx(bgidiayx);
		goodsInfoPo.setBgiusetypeyx(bgiusetypeyx);
		goodsInfoPo.setBgistealthclassyx(bgistealthclassyx);
		goodsInfoPo.setBgicapacityyxhly(bgicapacityyxhly);
		goodsInfoPo.setBgicapacityentryyxhly(bgicapacityentryyxhly);
		goodsInfoPo.setBgisuppliercolortyj(bgisuppliercolortyj);
		goodsInfoPo.setBgiframesizetyj(bgiframesizetyj);
		goodsInfoPo.setMinSphlhj(minSphlhj);
		goodsInfoPo.setMaxSphlhj(maxSphlhj);
		goodsInfoPo.setBgisuppliercolorlhj(bgisuppliercolorlhj);
		goodsInfoPo.setBgiframesizelhj(bgiframesizelhj);
		
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		request.setAttribute("whichretail",whichretail);
		
		if(!"".equals(dpo.getBdpwhichretail())&&"1".equals(personInfoPo.getDepartmenttype())){
			goodsInfoPo.setBgiwhichretail(dpo.getBdpwhichretail());
			request.setAttribute("whichretail",dpo.getBdpwhichretail());
		}
		
		String bgiwholesalebeginprice=Utility.getName(request.getParameter("bgiwholesalebeginprice"));
		String bgiwholesaleendprice=Utility.getName(request.getParameter("bgiwholesaleendprice"));
		request.setAttribute("bgiwholesalebeginprice", bgiwholesalebeginprice);
		request.setAttribute("bgiwholesaleendprice", bgiwholesaleendprice);
		
		goodsInfoPo.setBgiwholesalebeginprice(bgiwholesalebeginprice);
		goodsInfoPo.setBgiwholesaleendprice(bgiwholesaleendprice);		
		
//////////////////////////////////////////////////////////////////////////////////////////////
		request.setAttribute("bgispecs", bgispecs);
		request.setAttribute("bgisuppliercolorjj", bgisuppliercolorjj);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("bgiframematerialtypejj", bgiframematerialtypejj);
		request.setAttribute("technologyTypeIDjj", technologyTypeIDjj);
		request.setAttribute("bgiaccessoriestypepj", bgiaccessoriestypepj);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		request.setAttribute("minbgibelowplusluminosityjp", minbgibelowplusluminosityjp);
		request.setAttribute("maxbgibelowplusluminosityjp", maxbgibelowplusluminosityjp);
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("bgifunctionclassjp", bgifunctionclassjp);
		request.setAttribute("bgigradualclassjp", bgigradualclassjp);
		request.setAttribute("minSphyx", minSphyx);
		request.setAttribute("maxSphyx", maxSphyx);
		request.setAttribute("minCylyx", minCylyx);
		request.setAttribute("maxCylyx", maxCylyx);
		request.setAttribute("bgicurvature1yx", bgicurvature1yx);
		request.setAttribute("bgidiayx", bgidiayx);
		request.setAttribute("bgiusetypeyx", bgiusetypeyx);
		request.setAttribute("bgistealthclassyx", bgistealthclassyx);
		request.setAttribute("bgicapacityyxhly", bgicapacityyxhly);
		request.setAttribute("bgicapacityentryyxhly", bgicapacityentryyxhly);
		request.setAttribute("bgisuppliercolortyj", bgisuppliercolortyj);
		request.setAttribute("bgiframesizetyj", bgiframesizetyj);
		request.setAttribute("minSphlhj", minSphlhj);
		request.setAttribute("maxSphlhj", maxSphlhj);
		request.setAttribute("bgisuppliercolorlhj", bgisuppliercolorlhj);
		request.setAttribute("bgiframesizelhj", bgiframesizelhj);
		request.setAttribute("iscustomizeyx", iscustomizeyx);
		request.setAttribute("iscustomizekj", iscustomizekj);
		request.setAttribute("iscustomize", iscustomize);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = windowGoodsMgr.getGoodsSingleForAllocationCount(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleForAllocationList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		request.setAttribute("iscustomize", iscustomize);
		
		
		return SUCCESS;
	}	
	/**
	 * 查询单品商品(赠品管理用)
	 */
	public String selGoodsSingleForPremiums() throws Exception {
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
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo.getDepartmentID()));	
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);
		String storebatch = Utility.getName(request.getParameter("storebatch"));
		request.setAttribute("storebatch", storebatch);
		
		String isguaranteeperiod=Utility.getName(request.getParameter("isguaranteeperiod"));
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String iscustomizeyx=Utility.getName(request.getParameter("iscustomizeyx"));
		String iscustomizekj=Utility.getName(request.getParameter("iscustomizekj"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		String bgisuppliercolorjj=Utility.getName(request.getParameter("bgisuppliercolorjj"));
		String bgiframesizejj=Utility.getName(request.getParameter("bgiframesizejj"));
		String bgiframematerialtypejj=Utility.getName(request.getParameter("bgiframematerialtypejj"));
		String technologyTypeIDjj=Utility.getName(request.getParameter("technologyTypeIDjj"));
		String bgiaccessoriestypepj=Utility.getName(request.getParameter("bgiaccessoriestypepj"));
		String minSphjp=Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp=Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp=Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp=Utility.getName(request.getParameter("maxCyljp"));
		//翻方后
		String changeMinSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphjp"), request.getParameter("minCyljp")));
		String changeMaxSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphjp"), request.getParameter("maxCyljp")));
		String changeMinCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCyljp"),request.getParameter("minCyljp")));
		String changeMaxCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCyljp"),request.getParameter("maxCyljp")));
		//翻方后end
		
		String minbgibelowplusluminosityjp=Utility.getName(request.getParameter("minbgibelowplusluminosityjp"));
		String maxbgibelowplusluminosityjp=Utility.getName(request.getParameter("maxbgibelowplusluminosityjp"));
		String bgieyeglassmaterialtypejp=Utility.getName(request.getParameter("bgieyeglassmaterialtypejp"));
		String bgirefractivejp=Utility.getName(request.getParameter("bgirefractivejp"));
		String bgiismutiluminosityjp=Utility.getName(request.getParameter("bgiismutiluminosityjp"));
		String bgifunctionclassjp=Utility.getName(request.getParameter("bgifunctionclassjp"));
		String bgigradualclassjp=Utility.getName(request.getParameter("bgigradualclassjp"));
		String minSphyx=Utility.getName(request.getParameter("minSphyx"));
		String maxSphyx=Utility.getName(request.getParameter("maxSphyx"));
		String minCylyx=Utility.getName(request.getParameter("minCylyx"));
		String maxCylyx=Utility.getName(request.getParameter("maxCylyx"));
		//翻方后
		String changeMinSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphyx"),request.getParameter("minCylyx")));
		String changeMaxSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphyx"),request.getParameter("maxCylyx")));
		String changeMinCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCylyx"),request.getParameter("minCylyx")));
		String changeMaxCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCylyx"),request.getParameter("maxCylyx")));
		//翻方后end
		String bgicurvature1yx=Utility.getName(request.getParameter("bgicurvature1yx"));
		String bgidiayx=Utility.getName(request.getParameter("bgidiayx"));
		String bgiusetypeyx=Utility.getName(request.getParameter("bgiusetypeyx"));
		String bgistealthclassyx=Utility.getName(request.getParameter("bgistealthclassyx"));
		String bgicapacityyxhly=Utility.getName(request.getParameter("bgicapacityyxhly"));
		String bgicapacityentryyxhly=Utility.getName(request.getParameter("bgicapacityentryyxhly"));
		String bgisuppliercolortyj=Utility.getName(request.getParameter("bgisuppliercolortyj"));
		String bgiframesizetyj=Utility.getName(request.getParameter("bgiframesizetyj"));
		String minSphlhj=Utility.getName(request.getParameter("minSphlhj"));
		String maxSphlhj=Utility.getName(request.getParameter("maxSphlhj"));
		String bgisuppliercolorlhj=Utility.getName(request.getParameter("bgisuppliercolorlhj"));
		String bgiframesizelhj=Utility.getName(request.getParameter("bgiframesizelhj"));
		String bgispecs=Utility.getName(request.getParameter("bgispecs"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandName", brandName);
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
		request.setAttribute("iscustomize", iscustomize);
		
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		
		if ("".equals(brandID)) {
			brandID = Utility.getName(request.getParameter("brandID_open"));
			
			if (!"".equals(Utility.getName(brandID))) {
				BrandPo brandPo = new BrandPo();
				brandPo.setBbdid(brandID);
				brandPo.setBbdsupplierid(supplierID);
				brandPo = brandMgr.getBrandPo(brandPo);
				request.setAttribute("brandName", brandPo.getBbdbrandname());
			}
			request.setAttribute("brandID_open", brandID);
		}
		
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
				
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgijm(jm);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setBgiwhichretail(whichretail);
		goodsInfoPo.setBgiismendretail(select_retail);
		goodsInfoPo.setIsguaranteeperiod(isguaranteeperiod);
		
		if("3".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizekj)){
			goodsInfoPo.setBgiiscustomize(iscustomizekj);
		}else if("4".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizeyx)){
			goodsInfoPo.setBgiiscustomize(iscustomizeyx);
		}else{
			goodsInfoPo.setBgiiscustomize(iscustomize);
		}
////////////////////////////////////////////////////////////////////////////////////////		
		goodsInfoPo.setBgispec(bgispecs); 
		goodsInfoPo.setBgisuppliercolorjj(bgisuppliercolorjj);
		goodsInfoPo.setBgiframesizejj(bgiframesizejj);
		goodsInfoPo.setBgiframematerialtypejj(bgiframematerialtypejj);
		goodsInfoPo.setTechnologyTypeIDjj(technologyTypeIDjj);
		goodsInfoPo.setBgiaccessoriestypepj(bgiaccessoriestypepj);
		goodsInfoPo.setMinSphjp(changeMinSphjp);
		goodsInfoPo.setMaxSphjp(changeMaxSphjp);
		goodsInfoPo.setMinCyljp(changeMinCyljp);
		goodsInfoPo.setMaxCyljp(changeMaxCyljp);
		goodsInfoPo.setMinbgibelowplusluminosityjp(minbgibelowplusluminosityjp);
		goodsInfoPo.setMaxbgibelowplusluminosityjp(maxbgibelowplusluminosityjp);
		goodsInfoPo.setBgieyeglassmaterialtypejp(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractivejp(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosityjp(bgiismutiluminosityjp);
		goodsInfoPo.setBgifunctionclassjp(bgifunctionclassjp);
		goodsInfoPo.setBgigradualclassjp(bgigradualclassjp);
		goodsInfoPo.setMinSphyx(changeMinSphyx);
		goodsInfoPo.setMaxSphyx(changeMaxSphyx);
		goodsInfoPo.setMinCylyx(changeMinCylyx);
		goodsInfoPo.setMaxCylyx(changeMaxCylyx);
		goodsInfoPo.setBgicurvature1yx(bgicurvature1yx);
		goodsInfoPo.setBgidiayx(bgidiayx);
		goodsInfoPo.setBgiusetypeyx(bgiusetypeyx);
		goodsInfoPo.setBgistealthclassyx(bgistealthclassyx);
		goodsInfoPo.setBgicapacityyxhly(bgicapacityyxhly);
		goodsInfoPo.setBgicapacityentryyxhly(bgicapacityentryyxhly);
		goodsInfoPo.setBgisuppliercolortyj(bgisuppliercolortyj);
		goodsInfoPo.setBgiframesizetyj(bgiframesizetyj);
		goodsInfoPo.setMinSphlhj(minSphlhj);
		goodsInfoPo.setMaxSphlhj(maxSphlhj);
		goodsInfoPo.setBgisuppliercolorlhj(bgisuppliercolorlhj);
		goodsInfoPo.setBgiframesizelhj(bgiframesizelhj);
		
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		request.setAttribute("whichretail",whichretail);
		
		if(!"".equals(dpo.getBdpwhichretail())&&"1".equals(personInfoPo.getDepartmenttype())){
			goodsInfoPo.setBgiwhichretail(dpo.getBdpwhichretail());
			request.setAttribute("whichretail",dpo.getBdpwhichretail());
		}
		
		String bgiwholesalebeginprice=Utility.getName(request.getParameter("bgiwholesalebeginprice"));
		String bgiwholesaleendprice=Utility.getName(request.getParameter("bgiwholesaleendprice"));
		request.setAttribute("bgiwholesalebeginprice", bgiwholesalebeginprice);
		request.setAttribute("bgiwholesaleendprice", bgiwholesaleendprice);
		
		goodsInfoPo.setBgiwholesalebeginprice(bgiwholesalebeginprice);
		goodsInfoPo.setBgiwholesaleendprice(bgiwholesaleendprice);		
		
//////////////////////////////////////////////////////////////////////////////////////////////
		request.setAttribute("bgispecs", bgispecs);
		request.setAttribute("bgisuppliercolorjj", bgisuppliercolorjj);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("bgiframematerialtypejj", bgiframematerialtypejj);
		request.setAttribute("technologyTypeIDjj", technologyTypeIDjj);
		request.setAttribute("bgiaccessoriestypepj", bgiaccessoriestypepj);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		request.setAttribute("minbgibelowplusluminosityjp", minbgibelowplusluminosityjp);
		request.setAttribute("maxbgibelowplusluminosityjp", maxbgibelowplusluminosityjp);
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("bgifunctionclassjp", bgifunctionclassjp);
		request.setAttribute("bgigradualclassjp", bgigradualclassjp);
		request.setAttribute("minSphyx", minSphyx);
		request.setAttribute("maxSphyx", maxSphyx);
		request.setAttribute("minCylyx", minCylyx);
		request.setAttribute("maxCylyx", maxCylyx);
		request.setAttribute("bgicurvature1yx", bgicurvature1yx);
		request.setAttribute("bgidiayx", bgidiayx);
		request.setAttribute("bgiusetypeyx", bgiusetypeyx);
		request.setAttribute("bgistealthclassyx", bgistealthclassyx);
		request.setAttribute("bgicapacityyxhly", bgicapacityyxhly);
		request.setAttribute("bgicapacityentryyxhly", bgicapacityentryyxhly);
		request.setAttribute("bgisuppliercolortyj", bgisuppliercolortyj);
		request.setAttribute("bgiframesizetyj", bgiframesizetyj);
		request.setAttribute("minSphlhj", minSphlhj);
		request.setAttribute("maxSphlhj", maxSphlhj);
		request.setAttribute("bgisuppliercolorlhj", bgisuppliercolorlhj);
		request.setAttribute("bgiframesizelhj", bgiframesizelhj);
		request.setAttribute("iscustomizeyx", iscustomizeyx);
		request.setAttribute("iscustomizekj", iscustomizekj);
		request.setAttribute("iscustomize", iscustomize);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = windowGoodsMgr.getGoodsSingleCount(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		request.setAttribute("iscustomize", iscustomize);
		
		
		return SUCCESS;
	}
	/**
	 * 查询单品商品
	 */
	public String selGoodsSingleWP() throws Exception {
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
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo.getDepartmentID()));	

		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);
		String storebatch = Utility.getName(request.getParameter("storebatch"));
		request.setAttribute("storebatch", storebatch);
		
		String isguaranteeperiod=Utility.getName(request.getParameter("isguaranteeperiod"));
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String iscustomizeyx=Utility.getName(request.getParameter("iscustomizeyx"));
		String iscustomizekj=Utility.getName(request.getParameter("iscustomizekj"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		String bgisuppliercolorjj=Utility.getName(request.getParameter("bgisuppliercolorjj"));
		String bgiframesizejj=Utility.getName(request.getParameter("bgiframesizejj"));
		String bgiframematerialtypejj=Utility.getName(request.getParameter("bgiframematerialtypejj"));
		String technologyTypeIDjj=Utility.getName(request.getParameter("technologyTypeIDjj"));
		String bgiaccessoriestypepj=Utility.getName(request.getParameter("bgiaccessoriestypepj"));
		String minSphjp=Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp=Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp=Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp=Utility.getName(request.getParameter("maxCyljp"));
		//翻方后
		String changeMinSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphjp"), request.getParameter("minCyljp")));
		String changeMaxSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphjp"), request.getParameter("maxCyljp")));
		String changeMinCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCyljp"),request.getParameter("minCyljp")));
		String changeMaxCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCyljp"),request.getParameter("maxCyljp")));
		//翻方后end
		String minbgibelowplusluminosityjp=Utility.getName(request.getParameter("minbgibelowplusluminosityjp"));
		String maxbgibelowplusluminosityjp=Utility.getName(request.getParameter("maxbgibelowplusluminosityjp"));
		String bgieyeglassmaterialtypejp=Utility.getName(request.getParameter("bgieyeglassmaterialtypejp"));
		String bgirefractivejp=Utility.getName(request.getParameter("bgirefractivejp"));
		String bgiismutiluminosityjp=Utility.getName(request.getParameter("bgiismutiluminosityjp"));
		String bgifunctionclassjp=Utility.getName(request.getParameter("bgifunctionclassjp"));
		String bgigradualclassjp=Utility.getName(request.getParameter("bgigradualclassjp"));
		String minSphyx=Utility.getName(request.getParameter("minSphyx"));
		String maxSphyx=Utility.getName(request.getParameter("maxSphyx"));
		String minCylyx=Utility.getName(request.getParameter("minCylyx"));
		String maxCylyx=Utility.getName(request.getParameter("maxCylyx"));
		//翻方后
		String changeMinSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphyx"),request.getParameter("minCylyx")));
		String changeMaxSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphyx"),request.getParameter("maxCylyx")));
		String changeMinCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCylyx"),request.getParameter("minCylyx")));
		String changeMaxCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCylyx"),request.getParameter("maxCylyx")));
		//翻方后end
		String bgicurvature1yx=Utility.getName(request.getParameter("bgicurvature1yx"));
		String bgidiayx=Utility.getName(request.getParameter("bgidiayx"));
		String bgiusetypeyx=Utility.getName(request.getParameter("bgiusetypeyx"));
		String bgistealthclassyx=Utility.getName(request.getParameter("bgistealthclassyx"));
		String bgicapacityyxhly=Utility.getName(request.getParameter("bgicapacityyxhly"));
		String bgicapacityentryyxhly=Utility.getName(request.getParameter("bgicapacityentryyxhly"));
		String bgisuppliercolortyj=Utility.getName(request.getParameter("bgisuppliercolortyj"));
		String bgiframesizetyj=Utility.getName(request.getParameter("bgiframesizetyj"));
		String minSphlhj=Utility.getName(request.getParameter("minSphlhj"));
		String maxSphlhj=Utility.getName(request.getParameter("maxSphlhj"));
		String bgisuppliercolorlhj=Utility.getName(request.getParameter("bgisuppliercolorlhj"));
		String bgiframesizelhj=Utility.getName(request.getParameter("bgiframesizelhj"));
		String bgispecs=Utility.getName(request.getParameter("bgispecs"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandName", brandName);
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
		request.setAttribute("iscustomize", iscustomize);
		
		String rl = "";
        if (goodscategoryID.equals("3") || goodscategoryID.equals("4")){
        	rl = "".equals(Utility.getName(request.getParameter("rl"))) ? "R": Utility.getName(request.getParameter("rl"));
        }else if (goodscategoryID.equals("1")){
        	rl = "F";
        }        
		request.setAttribute("rl", rl);
		
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		
		if ("".equals(brandID)) {
			brandID = Utility.getName(request.getParameter("brandID_open"));
			
			if (!"".equals(Utility.getName(brandID))) {
				BrandPo brandPo = new BrandPo();
				brandPo.setBbdid(brandID);
				brandPo.setBbdsupplierid(supplierID);
				brandPo = brandMgr.getBrandPo(brandPo);
				request.setAttribute("brandName", brandPo.getBbdbrandname());
			}
			request.setAttribute("brandID_open", brandID);
		}
		
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
				
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgijm(jm);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setBgiwhichretail(whichretail);
		goodsInfoPo.setBgiismendretail(select_retail);
		goodsInfoPo.setIsguaranteeperiod(isguaranteeperiod);
		
		if("3".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizekj)){
			goodsInfoPo.setBgiiscustomize(iscustomizekj);
		}else if("4".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizeyx)){
			goodsInfoPo.setBgiiscustomize(iscustomizeyx);
		}else{
			goodsInfoPo.setBgiiscustomize(iscustomize);
		}
////////////////////////////////////////////////////////////////////////////////////////		
		goodsInfoPo.setBgispec(bgispecs); 
		goodsInfoPo.setBgisuppliercolorjj(bgisuppliercolorjj);
		goodsInfoPo.setBgiframesizejj(bgiframesizejj);
		goodsInfoPo.setBgiframematerialtypejj(bgiframematerialtypejj);
		goodsInfoPo.setTechnologyTypeIDjj(technologyTypeIDjj);
		goodsInfoPo.setBgiaccessoriestypepj(bgiaccessoriestypepj);
		goodsInfoPo.setMinSphjp(changeMinSphjp);
		goodsInfoPo.setMaxSphjp(changeMaxSphjp);
		goodsInfoPo.setMinCyljp(changeMinCyljp);
		goodsInfoPo.setMaxCyljp(changeMaxCyljp);
		goodsInfoPo.setMinbgibelowplusluminosityjp(minbgibelowplusluminosityjp);
		goodsInfoPo.setMaxbgibelowplusluminosityjp(maxbgibelowplusluminosityjp);
		goodsInfoPo.setBgieyeglassmaterialtypejp(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractivejp(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosityjp(bgiismutiluminosityjp);
		goodsInfoPo.setBgifunctionclassjp(bgifunctionclassjp);
		goodsInfoPo.setBgigradualclassjp(bgigradualclassjp);
		goodsInfoPo.setMinSphyx(changeMinSphyx);
		goodsInfoPo.setMaxSphyx(changeMaxSphyx);
		goodsInfoPo.setMinCylyx(changeMinCylyx);
		goodsInfoPo.setMaxCylyx(changeMaxCylyx);
		goodsInfoPo.setBgicurvature1yx(bgicurvature1yx);
		goodsInfoPo.setBgidiayx(bgidiayx);
		goodsInfoPo.setBgiusetypeyx(bgiusetypeyx);
		goodsInfoPo.setBgistealthclassyx(bgistealthclassyx);
		goodsInfoPo.setBgicapacityyxhly(bgicapacityyxhly);
		goodsInfoPo.setBgicapacityentryyxhly(bgicapacityentryyxhly);
		goodsInfoPo.setBgisuppliercolortyj(bgisuppliercolortyj);
		goodsInfoPo.setBgiframesizetyj(bgiframesizetyj);
		goodsInfoPo.setMinSphlhj(minSphlhj);
		goodsInfoPo.setMaxSphlhj(maxSphlhj);
		goodsInfoPo.setBgisuppliercolorlhj(bgisuppliercolorlhj);
		goodsInfoPo.setBgiframesizelhj(bgiframesizelhj);
		
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		request.setAttribute("whichretail",whichretail);
		
		if(!"".equals(dpo.getBdpwhichretail())&&"1".equals(personInfoPo.getDepartmenttype())){
			goodsInfoPo.setBgiwhichretail(dpo.getBdpwhichretail());
			request.setAttribute("whichretail",dpo.getBdpwhichretail());
		}
		
		String bgiwholesalebeginprice=Utility.getName(request.getParameter("bgiwholesalebeginprice"));
		String bgiwholesaleendprice=Utility.getName(request.getParameter("bgiwholesaleendprice"));
		request.setAttribute("bgiwholesalebeginprice", bgiwholesalebeginprice);
		request.setAttribute("bgiwholesaleendprice", bgiwholesaleendprice);
		
		goodsInfoPo.setBgiwholesalebeginprice(bgiwholesalebeginprice);
		goodsInfoPo.setBgiwholesaleendprice(bgiwholesaleendprice);		
		
//////////////////////////////////////////////////////////////////////////////////////////////
		request.setAttribute("bgispecs", bgispecs);
		request.setAttribute("bgisuppliercolorjj", bgisuppliercolorjj);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("bgiframematerialtypejj", bgiframematerialtypejj);
		request.setAttribute("technologyTypeIDjj", technologyTypeIDjj);
		request.setAttribute("bgiaccessoriestypepj", bgiaccessoriestypepj);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		request.setAttribute("minbgibelowplusluminosityjp", minbgibelowplusluminosityjp);
		request.setAttribute("maxbgibelowplusluminosityjp", maxbgibelowplusluminosityjp);
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("bgifunctionclassjp", bgifunctionclassjp);
		request.setAttribute("bgigradualclassjp", bgigradualclassjp);
		request.setAttribute("minSphyx", minSphyx);
		request.setAttribute("maxSphyx", maxSphyx);
		request.setAttribute("minCylyx", minCylyx);
		request.setAttribute("maxCylyx", maxCylyx);
		request.setAttribute("bgicurvature1yx", bgicurvature1yx);
		request.setAttribute("bgidiayx", bgidiayx);
		request.setAttribute("bgiusetypeyx", bgiusetypeyx);
		request.setAttribute("bgistealthclassyx", bgistealthclassyx);
		request.setAttribute("bgicapacityyxhly", bgicapacityyxhly);
		request.setAttribute("bgicapacityentryyxhly", bgicapacityentryyxhly);
		request.setAttribute("bgisuppliercolortyj", bgisuppliercolortyj);
		request.setAttribute("bgiframesizetyj", bgiframesizetyj);
		request.setAttribute("minSphlhj", minSphlhj);
		request.setAttribute("maxSphlhj", maxSphlhj);
		request.setAttribute("bgisuppliercolorlhj", bgisuppliercolorlhj);
		request.setAttribute("bgiframesizelhj", bgiframesizelhj);
		request.setAttribute("iscustomizeyx", iscustomizeyx);
		request.setAttribute("iscustomizekj", iscustomizekj);
		request.setAttribute("iscustomize", iscustomize);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = windowGoodsMgr.getGoodsSingleCount(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		request.setAttribute("iscustomize", iscustomize);
		
		
		return SUCCESS;
	}
	/**
	 * 初始化条码打印商品开窗
	 */
	public String initGoodsSingleSelBP() throws Exception {
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
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);
		
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String brandID = Utility.getName(request.getParameter("brandID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		
		if (!"".equals(Utility.getName(brandID))) {
			BrandPo brandPo = new BrandPo();
			brandPo.setBbdid(brandID);
			brandPo.setBbdsupplierid(supplierID);
			brandPo = brandMgr.getBrandPo(brandPo);
			request.setAttribute("brandName", brandPo
					.getBbdbrandname());
		}
		
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();
		
		WarehousePo warehousePo = new WarehousePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
		}
		warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("brandID_open", brandID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("iscustomize", iscustomize);
		
		return SUCCESS;
	}
	
	/**
	 * 条码打印商品开窗
	 */
	public String selGoodsSingleBP() throws Exception {
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
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);

		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String iscustomizeyx=Utility.getName(request.getParameter("iscustomizeyx"));
		String iscustomizekj=Utility.getName(request.getParameter("iscustomizekj"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		String bgisuppliercolorjj=Utility.getName(request.getParameter("bgisuppliercolorjj"));
		String bgiframesizejj=Utility.getName(request.getParameter("bgiframesizejj"));
		String bgiframematerialtypejj=Utility.getName(request.getParameter("bgiframematerialtypejj"));
		String technologyTypeIDjj=Utility.getName(request.getParameter("technologyTypeIDjj"));
		String bgiaccessoriestypepj=Utility.getName(request.getParameter("bgiaccessoriestypepj"));
		String minSphjp=Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp=Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp=Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp=Utility.getName(request.getParameter("maxCyljp"));
		String minbgibelowplusluminosityjp=Utility.getName(request.getParameter("minbgibelowplusluminosityjp"));
		String maxbgibelowplusluminosityjp=Utility.getName(request.getParameter("maxbgibelowplusluminosityjp"));
		String bgieyeglassmaterialtypejp=Utility.getName(request.getParameter("bgieyeglassmaterialtypejp"));
		String bgirefractivejp=Utility.getName(request.getParameter("bgirefractivejp"));
		String bgiismutiluminosityjp=Utility.getName(request.getParameter("bgiismutiluminosityjp"));
		String bgifunctionclassjp=Utility.getName(request.getParameter("bgifunctionclassjp"));
		String bgigradualclassjp=Utility.getName(request.getParameter("bgigradualclassjp"));
		String minSphyx=Utility.getName(request.getParameter("minSphyx"));
		String maxSphyx=Utility.getName(request.getParameter("maxSphyx"));
		String minCylyx=Utility.getName(request.getParameter("minCylyx"));
		String maxCylyx=Utility.getName(request.getParameter("maxCylyx"));
		String bgicurvature1yx=Utility.getName(request.getParameter("bgicurvature1yx"));
		String bgidiayx=Utility.getName(request.getParameter("bgidiayx"));
		String bgiusetypeyx=Utility.getName(request.getParameter("bgiusetypeyx"));
		String bgistealthclassyx=Utility.getName(request.getParameter("bgistealthclassyx"));
		String bgicapacityyxhly=Utility.getName(request.getParameter("bgicapacityyxhly"));
		String bgicapacityentryyxhly=Utility.getName(request.getParameter("bgicapacityentryyxhly"));
		String bgisuppliercolortyj=Utility.getName(request.getParameter("bgisuppliercolortyj"));
		String bgiframesizetyj=Utility.getName(request.getParameter("bgiframesizetyj"));
		String minSphlhj=Utility.getName(request.getParameter("minSphlhj"));
		String maxSphlhj=Utility.getName(request.getParameter("maxSphlhj"));
		String bgisuppliercolorlhj=Utility.getName(request.getParameter("bgisuppliercolorlhj"));
		String bgiframesizelhj=Utility.getName(request.getParameter("bgiframesizelhj"));
		String bgispecs=Utility.getName(request.getParameter("bgispecs"));
		String warehouseID=Utility.getName(request.getParameter("warehouseID"));
		String kucun=Utility.getName(request.getParameter("kucun"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		
		request.setAttribute("warehouseID", warehouseID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandName", brandName);
		request.setAttribute("kucun", kucun);
		request.setAttribute("whichretail", whichretail);
		
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
		request.setAttribute("iscustomize", iscustomize);
		
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		
		if ("".equals(brandID)) {
			brandID = Utility.getName(request.getParameter("brandID_open"));
			
			if (!"".equals(Utility.getName(brandID))) {
				BrandPo brandPo = new BrandPo();
				brandPo.setBbdid(brandID);
				brandPo.setBbdsupplierid(supplierID);
				brandPo = brandMgr.getBrandPo(brandPo);
				request.setAttribute("brandName", brandPo.getBbdbrandname());
			}
			request.setAttribute("brandID_open", brandID);
		}
		
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			 goodscodes=goodscode;
		}
		
		WarehousePo warehousePo = new WarehousePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
		}
		warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			goodsInfoPo.setBgicompanyid(personInfoPo.getPersoncompanyid());
		}
		goodsInfoPo.setBgiwarehouseid(warehouseID);
		goodsInfoPo.setBgijm(jm);
		goodsInfoPo.setBgigoodsquantity(kucun);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setBgiwhichretail(whichretail);
		
		if("3".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizekj)){
			goodsInfoPo.setBgiiscustomize(iscustomizekj);
		}else if("4".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizeyx)){
			goodsInfoPo.setBgiiscustomize(iscustomizeyx);
		}else{
			goodsInfoPo.setBgiiscustomize(iscustomize);
		}
		goodsInfoPo.setBgispec(bgispecs); 
		goodsInfoPo.setBgisuppliercolorjj(bgisuppliercolorjj);
		goodsInfoPo.setBgiframesizejj(bgiframesizejj);
		goodsInfoPo.setBgiframematerialtypejj(bgiframematerialtypejj);
		goodsInfoPo.setTechnologyTypeIDjj(technologyTypeIDjj);
		goodsInfoPo.setBgiaccessoriestypepj(bgiaccessoriestypepj);
		goodsInfoPo.setMinSphjp(minSphjp);
		goodsInfoPo.setMaxSphjp(maxSphjp);
		goodsInfoPo.setMinCyljp(minCyljp);
		goodsInfoPo.setMaxCyljp(maxCyljp);
		goodsInfoPo.setMinbgibelowplusluminosityjp(minbgibelowplusluminosityjp);
		goodsInfoPo.setMaxbgibelowplusluminosityjp(maxbgibelowplusluminosityjp);
		goodsInfoPo.setBgieyeglassmaterialtypejp(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractivejp(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosityjp(bgiismutiluminosityjp);
		goodsInfoPo.setBgifunctionclassjp(bgifunctionclassjp);
		goodsInfoPo.setBgigradualclassjp(bgigradualclassjp);
		goodsInfoPo.setMinSphyx(minSphyx);
		goodsInfoPo.setMaxSphyx(maxSphyx);
		goodsInfoPo.setMinCylyx(minCylyx);
		goodsInfoPo.setMaxCylyx(maxCylyx);
		goodsInfoPo.setBgicurvature1yx(bgicurvature1yx);
		goodsInfoPo.setBgidiayx(bgidiayx);
		goodsInfoPo.setBgiusetypeyx(bgiusetypeyx);
		goodsInfoPo.setBgistealthclassyx(bgistealthclassyx);
		goodsInfoPo.setBgicapacityyxhly(bgicapacityyxhly);
		goodsInfoPo.setBgicapacityentryyxhly(bgicapacityentryyxhly);
		goodsInfoPo.setBgisuppliercolortyj(bgisuppliercolortyj);
		goodsInfoPo.setBgiframesizetyj(bgiframesizetyj);
		goodsInfoPo.setMinSphlhj(minSphlhj);
		goodsInfoPo.setMaxSphlhj(maxSphlhj);
		goodsInfoPo.setBgisuppliercolorlhj(bgisuppliercolorlhj);
		goodsInfoPo.setBgiframesizelhj(bgiframesizelhj);
		
		String bgiwholesalebeginprice=Utility.getName(request.getParameter("bgiwholesalebeginprice"));
		String bgiwholesaleendprice=Utility.getName(request.getParameter("bgiwholesaleendprice"));
		request.setAttribute("bgiwholesalebeginprice", bgiwholesalebeginprice);
		request.setAttribute("bgiwholesaleendprice", bgiwholesaleendprice);
		
		goodsInfoPo.setBgiwholesalebeginprice(bgiwholesalebeginprice);
		goodsInfoPo.setBgiwholesaleendprice(bgiwholesaleendprice);		
		
		request.setAttribute("bgispecs", bgispecs);
		request.setAttribute("bgisuppliercolorjj", bgisuppliercolorjj);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("bgiframematerialtypejj", bgiframematerialtypejj);
		request.setAttribute("technologyTypeIDjj", technologyTypeIDjj);
		request.setAttribute("bgiaccessoriestypepj", bgiaccessoriestypepj);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		request.setAttribute("minbgibelowplusluminosityjp", minbgibelowplusluminosityjp);
		request.setAttribute("maxbgibelowplusluminosityjp", maxbgibelowplusluminosityjp);
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("bgifunctionclassjp", bgifunctionclassjp);
		request.setAttribute("bgigradualclassjp", bgigradualclassjp);
		request.setAttribute("minSphyx", minSphyx);
		request.setAttribute("maxSphyx", maxSphyx);
		request.setAttribute("minCylyx", minCylyx);
		request.setAttribute("maxCylyx", maxCylyx);
		request.setAttribute("bgicurvature1yx", bgicurvature1yx);
		request.setAttribute("bgidiayx", bgidiayx);
		request.setAttribute("bgiusetypeyx", bgiusetypeyx);
		request.setAttribute("bgistealthclassyx", bgistealthclassyx);
		request.setAttribute("bgicapacityyxhly", bgicapacityyxhly);
		request.setAttribute("bgicapacityentryyxhly", bgicapacityentryyxhly);
		request.setAttribute("bgisuppliercolortyj", bgisuppliercolortyj);
		request.setAttribute("bgiframesizetyj", bgiframesizetyj);
		request.setAttribute("minSphlhj", minSphlhj);
		request.setAttribute("maxSphlhj", maxSphlhj);
		request.setAttribute("bgisuppliercolorlhj", bgisuppliercolorlhj);
		request.setAttribute("bgiframesizelhj", bgiframesizelhj);
		request.setAttribute("iscustomizeyx", iscustomizeyx);
		request.setAttribute("iscustomizekj", iscustomizekj);
		request.setAttribute("iscustomize", iscustomize);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = windowGoodsMgr.getGoodsSingleBPCount(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleBPList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		request.setAttribute("iscustomize", iscustomize);
		
		return SUCCESS;
	}
	
	/**
	 * 查询单品商品
	 */
	public String selGoodsSingleZT() throws Exception {
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
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);
		
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String iscustomizeyx=Utility.getName(request.getParameter("iscustomizeyx"));
		String iscustomizekj=Utility.getName(request.getParameter("iscustomizekj"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
		String kucun = Utility.getName(request.getParameter("kucun"));
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		String bgisuppliercolorjj=Utility.getName(request.getParameter("bgisuppliercolorjj"));
		String bgiframesizejj=Utility.getName(request.getParameter("bgiframesizejj"));
		String bgiframematerialtypejj=Utility.getName(request.getParameter("bgiframematerialtypejj"));
		String technologyTypeIDjj=Utility.getName(request.getParameter("technologyTypeIDjj"));
		String bgiaccessoriestypepj=Utility.getName(request.getParameter("bgiaccessoriestypepj"));
		String minSphjp=Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp=Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp=Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp=Utility.getName(request.getParameter("maxCyljp"));
		//翻方后
		String changeMinSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphjp"), request.getParameter("minCyljp")));
		String changeMaxSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphjp"), request.getParameter("maxCyljp")));
		String changeMinCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCyljp"),request.getParameter("minCyljp")));
		String changeMaxCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCyljp"),request.getParameter("maxCyljp")));
		//翻方后end
		String minbgibelowplusluminosityjp=Utility.getName(request.getParameter("minbgibelowplusluminosityjp"));
		String maxbgibelowplusluminosityjp=Utility.getName(request.getParameter("maxbgibelowplusluminosityjp"));
		String bgieyeglassmaterialtypejp=Utility.getName(request.getParameter("bgieyeglassmaterialtypejp"));
		String bgirefractivejp=Utility.getName(request.getParameter("bgirefractivejp"));
		String bgiismutiluminosityjp=Utility.getName(request.getParameter("bgiismutiluminosityjp"));
		String bgifunctionclassjp=Utility.getName(request.getParameter("bgifunctionclassjp"));
		String bgigradualclassjp=Utility.getName(request.getParameter("bgigradualclassjp"));
		String minSphyx=Utility.getName(request.getParameter("minSphyx"));
		String maxSphyx=Utility.getName(request.getParameter("maxSphyx"));
		String minCylyx=Utility.getName(request.getParameter("minCylyx"));
		String maxCylyx=Utility.getName(request.getParameter("maxCylyx"));
		//翻方后
		String changeMinSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphyx"),request.getParameter("minCylyx")));
		String changeMaxSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphyx"),request.getParameter("maxCylyx")));
		String changeMinCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCylyx"),request.getParameter("maxCylyx")));
		String changeMaxCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCylyx"),request.getParameter("minCylyx")));
		//翻方后end

		String bgicurvature1yx=Utility.getName(request.getParameter("bgicurvature1yx"));
		String bgidiayx=Utility.getName(request.getParameter("bgidiayx"));
		String bgiusetypeyx=Utility.getName(request.getParameter("bgiusetypeyx"));
		String bgistealthclassyx=Utility.getName(request.getParameter("bgistealthclassyx"));
		String bgicapacityyxhly=Utility.getName(request.getParameter("bgicapacityyxhly"));
		String bgicapacityentryyxhly=Utility.getName(request.getParameter("bgicapacityentryyxhly"));
		String bgisuppliercolortyj=Utility.getName(request.getParameter("bgisuppliercolortyj"));
		String bgiframesizetyj=Utility.getName(request.getParameter("bgiframesizetyj"));
		String minSphlhj=Utility.getName(request.getParameter("minSphlhj"));
		String maxSphlhj=Utility.getName(request.getParameter("maxSphlhj"));
		String bgisuppliercolorlhj=Utility.getName(request.getParameter("bgisuppliercolorlhj"));
		String bgiframesizelhj=Utility.getName(request.getParameter("bgiframesizelhj"));
		String bgispecs=Utility.getName(request.getParameter("bgispecs"));
		String isguaranteeperiod=Utility.getName(request.getParameter("isguaranteeperiod"));
		String isshowstealth=Utility.getName(request.getParameter("isshowstealth"));
		
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandName", brandName);
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
		request.setAttribute("iscustomize", iscustomize);
		
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		
		if ("".equals(brandID)) {
			brandID = Utility.getName(request.getParameter("brandID_open"));
			
			if (!"".equals(Utility.getName(brandID))) {
				BrandPo brandPo = new BrandPo();
				brandPo.setBbdid(brandID);
				brandPo.setBbdsupplierid(supplierID);
				brandPo = brandMgr.getBrandPo(brandPo);
				request.setAttribute("brandName", brandPo.getBbdbrandname());
			}
			request.setAttribute("brandID_open", brandID);
		}
		
		String indptid = Utility.getName(request.getParameter("indptid"));
		request.setAttribute("indptid",indptid);
		
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
				
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		String stockid = Utility.getName(request.getParameter("stockid"));
		request.setAttribute("stockid", stockid);
		goodsInfoPo.setBgidepartmentid(indptid);
		goodsInfoPo.setBgiwarehouseid(stockid);
		goodsInfoPo.setBgijm(jm);
		goodsInfoPo.setIsguaranteeperiod(isshowstealth.equals("1") ? "" : isguaranteeperiod);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgigoodsbarcode(goodscode);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setBgigoodsquantity(kucun);
		
		if("3".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizekj)){
			goodsInfoPo.setBgiiscustomize(iscustomizekj);
		}else if("4".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizeyx)){
			goodsInfoPo.setBgiiscustomize(iscustomizeyx);
		}else{
			goodsInfoPo.setBgiiscustomize(iscustomize);
		}
////////////////////////////////////////////////////////////////////////////////////////		
		goodsInfoPo.setBgispec(bgispecs); 
		goodsInfoPo.setBgisuppliercolorjj(bgisuppliercolorjj);
		goodsInfoPo.setBgiframesizejj(bgiframesizejj);
		goodsInfoPo.setBgiframematerialtypejj(bgiframematerialtypejj);
		goodsInfoPo.setTechnologyTypeIDjj(technologyTypeIDjj);
		goodsInfoPo.setBgiaccessoriestypepj(bgiaccessoriestypepj);
		goodsInfoPo.setMinSphjp(changeMinSphjp);
		goodsInfoPo.setMaxSphjp(changeMaxSphjp);
		goodsInfoPo.setMinCyljp(changeMinCyljp);
		goodsInfoPo.setMaxCyljp(changeMaxCyljp);
		goodsInfoPo.setMinbgibelowplusluminosityjp(minbgibelowplusluminosityjp);
		goodsInfoPo.setMaxbgibelowplusluminosityjp(maxbgibelowplusluminosityjp);
		goodsInfoPo.setBgieyeglassmaterialtypejp(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractivejp(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosityjp(bgiismutiluminosityjp);
		goodsInfoPo.setBgifunctionclassjp(bgifunctionclassjp);
		goodsInfoPo.setBgigradualclassjp(bgigradualclassjp);
		goodsInfoPo.setMinSphyx(changeMinSphyx);
		goodsInfoPo.setMaxSphyx(changeMaxSphyx);
		goodsInfoPo.setMinCylyx(changeMinCylyx);
		goodsInfoPo.setMaxCylyx(changeMaxCylyx);
		goodsInfoPo.setBgicurvature1yx(bgicurvature1yx);
		goodsInfoPo.setBgidiayx(bgidiayx);
		goodsInfoPo.setBgiusetypeyx(bgiusetypeyx);
		goodsInfoPo.setBgistealthclassyx(bgistealthclassyx);
		goodsInfoPo.setBgicapacityyxhly(bgicapacityyxhly);
		goodsInfoPo.setBgicapacityentryyxhly(bgicapacityentryyxhly);
		goodsInfoPo.setBgisuppliercolortyj(bgisuppliercolortyj);
		goodsInfoPo.setBgiframesizetyj(bgiframesizetyj);
		goodsInfoPo.setMinSphlhj(minSphlhj);
		goodsInfoPo.setMaxSphlhj(maxSphlhj);
		goodsInfoPo.setBgisuppliercolorlhj(bgisuppliercolorlhj);
		goodsInfoPo.setBgiframesizelhj(bgiframesizelhj);
		goodsInfoPo.setBgistealtheffective(Utility.getName(systemParameterPo.getFspstealtheffective()));
		
		String bgiwholesalebeginprice=Utility.getName(request.getParameter("bgiwholesalebeginprice"));
		String bgiwholesaleendprice=Utility.getName(request.getParameter("bgiwholesaleendprice"));
		request.setAttribute("bgiwholesalebeginprice", bgiwholesalebeginprice);
		request.setAttribute("bgiwholesaleendprice", bgiwholesaleendprice);
		
		goodsInfoPo.setBgiwholesalebeginprice(bgiwholesalebeginprice);
		goodsInfoPo.setBgiwholesaleendprice(bgiwholesaleendprice);		
		
//////////////////////////////////////////////////////////////////////////////////////////////
		request.setAttribute("bgispecs", bgispecs);
		request.setAttribute("bgisuppliercolorjj", bgisuppliercolorjj);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("bgiframematerialtypejj", bgiframematerialtypejj);
		request.setAttribute("technologyTypeIDjj", technologyTypeIDjj);
		request.setAttribute("bgiaccessoriestypepj", bgiaccessoriestypepj);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		request.setAttribute("minbgibelowplusluminosityjp", minbgibelowplusluminosityjp);
		request.setAttribute("maxbgibelowplusluminosityjp", maxbgibelowplusluminosityjp);
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("bgifunctionclassjp", bgifunctionclassjp);
		request.setAttribute("bgigradualclassjp", bgigradualclassjp);
		request.setAttribute("minSphyx", minSphyx);
		request.setAttribute("maxSphyx", maxSphyx);
		request.setAttribute("minCylyx", minCylyx);
		request.setAttribute("maxCylyx", maxCylyx);
		request.setAttribute("bgicurvature1yx", bgicurvature1yx);
		request.setAttribute("bgidiayx", bgidiayx);
		request.setAttribute("bgiusetypeyx", bgiusetypeyx);
		request.setAttribute("bgistealthclassyx", bgistealthclassyx);
		request.setAttribute("bgicapacityyxhly", bgicapacityyxhly);
		request.setAttribute("bgicapacityentryyxhly", bgicapacityentryyxhly);
		request.setAttribute("bgisuppliercolortyj", bgisuppliercolortyj);
		request.setAttribute("bgiframesizetyj", bgiframesizetyj);
		request.setAttribute("minSphlhj", minSphlhj);
		request.setAttribute("maxSphlhj", maxSphlhj);
		request.setAttribute("bgisuppliercolorlhj", bgisuppliercolorlhj);
		request.setAttribute("bgiframesizelhj", bgiframesizelhj);
		request.setAttribute("iscustomizeyx", iscustomizeyx);
		request.setAttribute("iscustomizekj", iscustomizekj);
		request.setAttribute("iscustomize", iscustomize);
		request.setAttribute("kucun", kucun);
		request.setAttribute("departmenttype",Utility.getName(personInfoPo.getDepartmenttype()));
				
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = windowGoodsMgr.getGoodsSingleZTCount(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleZTList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		request.setAttribute("iscustomize", iscustomize);
		request.setAttribute("isshowstealth",isshowstealth);
		
		WarehousePo wpoq = new WarehousePo();
		wpoq.setBwhid(stockid);
		WarehousePo wpo = warehouseMgr.getWarehouse(wpoq);
		
		request.setAttribute("stockname", wpo.getBwhwarehouseName());
		
		return SUCCESS;
	}
	
	

	

	/**
	 * 初始化批发单品商品
	 */
	public String initGoodsSingleWSel() throws Exception {
		
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("iscustomize", iscustomize);
		
		return SUCCESS;
	}
	
	/**
	 * 查询批发单品商品
	 */
	public String selGoodsSingleW() throws Exception {
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String iscustomizeyx=Utility.getName(request.getParameter("iscustomizeyx"));
		String iscustomizekj=Utility.getName(request.getParameter("iscustomizekj"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiwholesalebeginprice=Utility.getName(request.getParameter("bgiwholesalebeginprice"));
		String bgiwholesaleendprice=Utility.getName(request.getParameter("bgiwholesaleendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		String bgisuppliercolorjj=Utility.getName(request.getParameter("bgisuppliercolorjj"));
		String bgiframesizejj=Utility.getName(request.getParameter("bgiframesizejj"));
		String bgiframematerialtypejj=Utility.getName(request.getParameter("bgiframematerialtypejj"));
		String technologyTypeIDjj=Utility.getName(request.getParameter("technologyTypeIDjj"));
		String bgiaccessoriestypepj=Utility.getName(request.getParameter("bgiaccessoriestypepj"));
		String minSphjp=Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp=Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp=Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp=Utility.getName(request.getParameter("maxCyljp"));
		//翻方后
		String changeMinSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphjp"), request.getParameter("minCyljp")));
		String changeMaxSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphjp"), request.getParameter("maxCyljp")));
		String changeMinCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCyljp"),request.getParameter("minCyljp")));
		String changeMaxCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCyljp"),request.getParameter("minCyljp")));
		//翻方后end
		String minbgibelowplusluminosityjp=Utility.getName(request.getParameter("minbgibelowplusluminosityjp"));
		String maxbgibelowplusluminosityjp=Utility.getName(request.getParameter("maxbgibelowplusluminosityjp"));
		String bgieyeglassmaterialtypejp=Utility.getName(request.getParameter("bgieyeglassmaterialtypejp"));
		String bgirefractivejp=Utility.getName(request.getParameter("bgirefractivejp"));
		String bgiismutiluminosityjp=Utility.getName(request.getParameter("bgiismutiluminosityjp"));
		String bgifunctionclassjp=Utility.getName(request.getParameter("bgifunctionclassjp"));
		String bgigradualclassjp=Utility.getName(request.getParameter("bgigradualclassjp"));
		String minSphyx=Utility.getName(request.getParameter("minSphyx"));
		String maxSphyx=Utility.getName(request.getParameter("maxSphyx"));
		String minCylyx=Utility.getName(request.getParameter("minCylyx"));
		String maxCylyx=Utility.getName(request.getParameter("maxCylyx"));
		//翻方后
		String changeMinSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphyx"),request.getParameter("minCylyx")));
		String changeMaxSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphyx"),request.getParameter("maxCylyx")));
		String changeMinCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCylyx"),request.getParameter("minCylyx")));
		String changeMaxCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCylyx"),request.getParameter("maxCylyx")));
		//翻方后end
		String bgicurvature1yx=Utility.getName(request.getParameter("bgicurvature1yx"));
		String bgidiayx=Utility.getName(request.getParameter("bgidiayx"));
		String bgiusetypeyx=Utility.getName(request.getParameter("bgiusetypeyx"));
		String bgistealthclassyx=Utility.getName(request.getParameter("bgistealthclassyx"));
		String bgicapacityyxhly=Utility.getName(request.getParameter("bgicapacityyxhly"));
		String bgicapacityentryyxhly=Utility.getName(request.getParameter("bgicapacityentryyxhly"));
		String bgisuppliercolortyj=Utility.getName(request.getParameter("bgisuppliercolortyj"));
		String bgiframesizetyj=Utility.getName(request.getParameter("bgiframesizetyj"));
		String minSphlhj=Utility.getName(request.getParameter("minSphlhj"));
		String maxSphlhj=Utility.getName(request.getParameter("maxSphlhj"));
		String bgisuppliercolorlhj=Utility.getName(request.getParameter("bgisuppliercolorlhj"));
		String bgiframesizelhj=Utility.getName(request.getParameter("bgiframesizelhj"));
		String bgispecs=Utility.getName(request.getParameter("bgispecs"));
		request.setAttribute("supplierName", supplierName);
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
		request.setAttribute("iscustomize", iscustomize);
		request.setAttribute("iscustomizeyx", iscustomizeyx);
		request.setAttribute("iscustomizekj", iscustomizekj);

		
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();

		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiwholesalebeginprice(bgiwholesalebeginprice);
		goodsInfoPo.setBgiwholesaleendprice(bgiwholesaleendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		if("3".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizekj)){
			goodsInfoPo.setBgiiscustomize(iscustomizekj);
		}else if("4".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizeyx)){
			goodsInfoPo.setBgiiscustomize(iscustomizeyx);
		}else{
			goodsInfoPo.setBgiiscustomize(iscustomize);
		}
////////////////////////////////////////////////////////////////////////////////////////		
		goodsInfoPo.setBgispec(bgispecs); 
		goodsInfoPo.setBgisuppliercolorjj(bgisuppliercolorjj);
		goodsInfoPo.setBgiframesizejj(bgiframesizejj);
		goodsInfoPo.setBgiframematerialtypejj(bgiframematerialtypejj);
		goodsInfoPo.setTechnologyTypeIDjj(technologyTypeIDjj);
		goodsInfoPo.setBgiaccessoriestypepj(bgiaccessoriestypepj);
		goodsInfoPo.setMinSphjp(changeMinSphjp);
		goodsInfoPo.setMaxSphjp(changeMaxSphjp);
		goodsInfoPo.setMinCyljp(changeMinCyljp);
		goodsInfoPo.setMaxCyljp(changeMaxCyljp);
		goodsInfoPo.setMinbgibelowplusluminosityjp(minbgibelowplusluminosityjp);
		goodsInfoPo.setMaxbgibelowplusluminosityjp(maxbgibelowplusluminosityjp);
		goodsInfoPo.setBgieyeglassmaterialtypejp(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractivejp(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosityjp(bgiismutiluminosityjp);
		goodsInfoPo.setBgifunctionclassjp(bgifunctionclassjp);
		goodsInfoPo.setBgigradualclassjp(bgigradualclassjp);
		goodsInfoPo.setMinSphyx(changeMinSphyx);
		goodsInfoPo.setMaxSphyx(changeMaxSphyx);
		goodsInfoPo.setMinCylyx(changeMinCylyx);
		goodsInfoPo.setMaxCylyx(changeMaxCylyx);
		goodsInfoPo.setBgicurvature1yx(bgicurvature1yx);
		goodsInfoPo.setBgidiayx(bgidiayx);
		goodsInfoPo.setBgiusetypeyx(bgiusetypeyx);
		goodsInfoPo.setBgistealthclassyx(bgistealthclassyx);
		goodsInfoPo.setBgicapacityyxhly(bgicapacityyxhly);
		goodsInfoPo.setBgicapacityentryyxhly(bgicapacityentryyxhly);
		goodsInfoPo.setBgisuppliercolortyj(bgisuppliercolortyj);
		goodsInfoPo.setBgiframesizetyj(bgiframesizetyj);
		goodsInfoPo.setMinSphlhj(minSphlhj);
		goodsInfoPo.setMaxSphlhj(maxSphlhj);
		goodsInfoPo.setBgisuppliercolorlhj(bgisuppliercolorlhj);
		goodsInfoPo.setBgiframesizelhj(bgiframesizelhj);
//////////////////////////////////////////////////////////////////////////////////////////////
		request.setAttribute("bgispecs", bgispecs);
		request.setAttribute("bgisuppliercolorjj", bgisuppliercolorjj);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("bgiframematerialtypejj", bgiframematerialtypejj);
		request.setAttribute("technologyTypeIDjj", technologyTypeIDjj);
		request.setAttribute("bgiaccessoriestypepj", bgiaccessoriestypepj);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		request.setAttribute("minbgibelowplusluminosityjp", minbgibelowplusluminosityjp);
		request.setAttribute("maxbgibelowplusluminosityjp", maxbgibelowplusluminosityjp);
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("bgifunctionclassjp", bgifunctionclassjp);
		request.setAttribute("bgigradualclassjp", bgigradualclassjp);
		request.setAttribute("minSphyx", minSphyx);
		request.setAttribute("maxSphyx", maxSphyx);
		request.setAttribute("minCylyx", minCylyx);
		request.setAttribute("maxCylyx", maxCylyx);
		request.setAttribute("bgicurvature1yx", bgicurvature1yx);
		request.setAttribute("bgidiayx", bgidiayx);
		request.setAttribute("bgiusetypeyx", bgiusetypeyx);
		request.setAttribute("bgistealthclassyx", bgistealthclassyx);
		request.setAttribute("bgicapacityyxhly", bgicapacityyxhly);
		request.setAttribute("bgicapacityentryyxhly", bgicapacityentryyxhly);
		request.setAttribute("bgisuppliercolortyj", bgisuppliercolortyj);
		request.setAttribute("bgiframesizetyj", bgiframesizetyj);
		request.setAttribute("minSphlhj", minSphlhj);
		request.setAttribute("maxSphlhj", maxSphlhj);
		request.setAttribute("bgisuppliercolorlhj", bgisuppliercolorlhj);
		request.setAttribute("bgiframesizelhj", bgiframesizelhj);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = windowGoodsMgr.getGoodsSingleCount(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgiwholesalebeginprice", bgiwholesalebeginprice);
		request.setAttribute("bgiwholesaleendprice", bgiwholesaleendprice);
		request.setAttribute("iscustomize", iscustomize);
		request.setAttribute("brandName", brandName);
	
		
		return SUCCESS;
		
	}
	
	/**
	 * 初始化单品商品查询
	 */
	public String initGoodsSinglesSel() throws Exception {
		
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();		
		
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("supplierID", supplierID);

		return SUCCESS;
	}
	
	/**
	 * 查询单品商品
	 */
	public String selGoodsSingles() throws Exception {

		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID"));//quyanping 
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
		// String varietyID=Utility.getName(request.getParameter("varietyID"));
		// String
		// varietyName=Utility.getName(request.getParameter("varietyName"));
		request.setAttribute("supplierName", supplierName);
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
//		if (!"".equals(goodscategoryID)) {
//			
//			request.setAttribute("categoryID_open", goodscategoryID);
//		}
		
		//quyanping
		if("".equals(technologyTypeID)){
			technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
			request.setAttribute("technologyTypeID_open",technologyTypeID);
		}
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo
						.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();

		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgitechnologytypeid(technologyTypeID);//quyanping
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		// goodsInfoPo.setBgivarietyid(varietyID);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = windowGoodsMgr.getGoodsSingleCount(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("technologyTypeID", technologyTypeID);//quyanping
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		// request.setAttribute("varietyID",varietyID);

		request.setAttribute("brandName", brandName);
		// request.setAttribute("varietyName",varietyName);
		
		return SUCCESS;
	}
	
	
	
	
	

	
	/**
	 * 初始化兑换单品商品查询
	 */
	public String initGoodsSingleExchangeSel() throws Exception {
		String integral =  Utility.getName(request.getParameter("integral"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();		
		
		request.setAttribute("integral", integral);
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("supplierID", supplierID);

		return SUCCESS;
	}
	
	/**
	 * 查询兑换单品商品
	 */
	public String selGoodsSingleExchange() throws Exception {
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
		
		String integral =  Utility.getName(request.getParameter("integral"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
		request.setAttribute("supplierName", supplierName);

		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();

		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setShopCode(personInfoPo.getDepartmentID());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getGoodsSingleExchangeCount(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleExchangeList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		request.setAttribute("integral", integral);
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		request.setAttribute("brandName", brandName);
		request.setAttribute("supplierName", supplierName);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化赠送商品查询
	 */
	public String initGoodsSingleGiftsSel() throws Exception {
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
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();		
		
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("supplierID", supplierID);

		return SUCCESS;
	}
	
	
	/**
	 * 查询赠品单品商品
	 */
	public String selGoodsSingleGifts() throws Exception {
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
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID"));//quyanping 
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
		String typeid = Utility.getName(request.getParameter("typeid"));
		
		request.setAttribute("supplierName", supplierName);
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
		if("".equals(technologyTypeID)){
			technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
			request.setAttribute("technologyTypeID_open",technologyTypeID);
		}
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo
						.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();

		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgitechnologytypeid(technologyTypeID);//quyanping
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setShopCode(personInfoPo1.getDepartmentID());
		goodsInfoPo.setBgigifttype(typeid);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		goodsInfoPo.setBgisalestype(systemParameterPo.getFspsalestype());
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getGoodsSingleCountGifts(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleGiftsList(goodsInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("technologyTypeID", technologyTypeID);//quyanping
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		 request.setAttribute("typeid",typeid);

		request.setAttribute("brandName", brandName);
		// request.setAttribute("varietyName",varietyName);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化赠送商品查询
	 */
	public String initGoodsSingleGiftsBatchSel() throws Exception {
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
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
//		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
//		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();		
		
		request.setAttribute("categoryID_open", goodscategoryID);
//		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("supplierID", supplierID);

		return SUCCESS;
	}
	
	/**
	 * 查询赠品单品商品
	 */
	public String selGoodsSingleGiftsBatch() throws Exception {
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
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
		request.setAttribute("supplierName", supplierName);
		String isselect = Utility.getName(request.getParameter("isselect"));
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
		if("".equals(technologyTypeID)){
			technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
			request.setAttribute("technologyTypeID_open",technologyTypeID);
		}
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo
						.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();

		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgitechnologytypeid(technologyTypeID);//quyanping
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setShopCode(personInfoPo1.getDepartmentID());
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		goodsInfoPo.setBgisalestype(systemParameterPo.getFspsalestype());
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getGoodsSingleCountGiftsBatch(goodsInfoPo);
		if("1".equals(isselect)){
			count = 0;
		}
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleGiftsBatchList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
//		technologyType=varietyMgr.getTechnologyType();//quyanping
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("technologyTypeID", technologyTypeID);//quyanping
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		// request.setAttribute("varietyID",varietyID);

		request.setAttribute("brandName", brandName);
		// request.setAttribute("varietyName",varietyName);
		
		return SUCCESS;
	}
	
	
	/**
	 * 初始化成本单品商品查询
	 */
	public String initGoodsModifyPriceSel() throws Exception {
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("iscustomize", iscustomize);
		
		
		return SUCCESS;
	}
	
	/**
	 * 成本价查询单品商品
	 */
	public String selGoodsModifyPrice() throws Exception {

		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String iscustomizeyx=Utility.getName(request.getParameter("iscustomizeyx"));
		String iscustomizekj=Utility.getName(request.getParameter("iscustomizekj"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgicostbeginprice=Utility.getName(request.getParameter("bgicostbeginprice"));
		String bgicostendprice=Utility.getName(request.getParameter("bgicostendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		String bgisuppliercolorjj=Utility.getName(request.getParameter("bgisuppliercolorjj"));
		String bgiframesizejj=Utility.getName(request.getParameter("bgiframesizejj"));
		String bgiframematerialtypejj=Utility.getName(request.getParameter("bgiframematerialtypejj"));
		String technologyTypeIDjj=Utility.getName(request.getParameter("technologyTypeIDjj"));
		String bgiaccessoriestypepj=Utility.getName(request.getParameter("bgiaccessoriestypepj"));
		String minSphjp=Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp=Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp=Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp=Utility.getName(request.getParameter("maxCyljp"));
		//翻方后
		String changeMinSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphjp"), request.getParameter("minCyljp")));
		String changeMaxSphjp=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphjp"), request.getParameter("maxCyljp")));
		String changeMinCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCyljp"),request.getParameter("minCyljp")));
		String changeMaxCyljp=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCyljp"),request.getParameter("maxCyljp")));
		//翻方后end
		String minbgibelowplusluminosityjp=Utility.getName(request.getParameter("minbgibelowplusluminosityjp"));
		String maxbgibelowplusluminosityjp=Utility.getName(request.getParameter("maxbgibelowplusluminosityjp"));
		String bgieyeglassmaterialtypejp=Utility.getName(request.getParameter("bgieyeglassmaterialtypejp"));
		String bgirefractivejp=Utility.getName(request.getParameter("bgirefractivejp"));
		String bgiismutiluminosityjp=Utility.getName(request.getParameter("bgiismutiluminosityjp"));
		String bgifunctionclassjp=Utility.getName(request.getParameter("bgifunctionclassjp"));
		String bgigradualclassjp=Utility.getName(request.getParameter("bgigradualclassjp"));
		String minSphyx=Utility.getName(request.getParameter("minSphyx"));
		String maxSphyx=Utility.getName(request.getParameter("maxSphyx"));
		String minCylyx=Utility.getName(request.getParameter("minCylyx"));
		String maxCylyx=Utility.getName(request.getParameter("maxCylyx"));
		//翻方后
		String changeMinSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("minSphyx"),request.getParameter("minCylyx")));
		String changeMaxSphyx=Utility.getName(TurnSphCyl.changeSph(request.getParameter("maxSphyx"),request.getParameter("maxCylyx")));
		String changeMinCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("maxCylyx"),request.getParameter("minCylyx")));
		String changeMaxCylyx=Utility.getName(TurnSphCyl.changeScopeCyl(request.getParameter("minCylyx"),request.getParameter("maxCylyx")));
		//翻方后end
		String bgicurvature1yx=Utility.getName(request.getParameter("bgicurvature1yx"));
		String bgidiayx=Utility.getName(request.getParameter("bgidiayx"));
		String bgiusetypeyx=Utility.getName(request.getParameter("bgiusetypeyx"));
		String bgistealthclassyx=Utility.getName(request.getParameter("bgistealthclassyx"));
		String bgicapacityyxhly=Utility.getName(request.getParameter("bgicapacityyxhly"));
		String bgicapacityentryyxhly=Utility.getName(request.getParameter("bgicapacityentryyxhly"));
		String bgisuppliercolortyj=Utility.getName(request.getParameter("bgisuppliercolortyj"));
		String bgiframesizetyj=Utility.getName(request.getParameter("bgiframesizetyj"));
		String minSphlhj=Utility.getName(request.getParameter("minSphlhj"));
		String maxSphlhj=Utility.getName(request.getParameter("maxSphlhj"));
		String bgisuppliercolorlhj=Utility.getName(request.getParameter("bgisuppliercolorlhj"));
		String bgiframesizelhj=Utility.getName(request.getParameter("bgiframesizelhj"));
		String bgispecs=Utility.getName(request.getParameter("bgispecs"));
		request.setAttribute("supplierName", supplierName);
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
		request.setAttribute("iscustomizeyx", iscustomizeyx);
		request.setAttribute("iscustomizekj", iscustomizekj);
		request.setAttribute("iscustomize", iscustomize);
		
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();

		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgicostbeginprice(bgicostbeginprice);
		goodsInfoPo.setBgicostendprice(bgicostendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		if("3".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizekj)){
			goodsInfoPo.setBgiiscustomize(iscustomizekj);
		}else if("4".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizeyx)){
			goodsInfoPo.setBgiiscustomize(iscustomizeyx);
		}else{
			goodsInfoPo.setBgiiscustomize(iscustomize);
		}
////////////////////////////////////////////////////////////////////////////////////////		
		goodsInfoPo.setBgispec(bgispecs); 
		goodsInfoPo.setBgisuppliercolorjj(bgisuppliercolorjj);
		goodsInfoPo.setBgiframesizejj(bgiframesizejj);
		goodsInfoPo.setBgiframematerialtypejj(bgiframematerialtypejj);
		goodsInfoPo.setTechnologyTypeIDjj(technologyTypeIDjj);
		goodsInfoPo.setBgiaccessoriestypepj(bgiaccessoriestypepj);
		goodsInfoPo.setMinSphjp(changeMinSphjp);
		goodsInfoPo.setMaxSphjp(changeMaxSphjp);
		goodsInfoPo.setMinCyljp(changeMinCyljp);
		goodsInfoPo.setMaxCyljp(changeMaxCyljp);
		goodsInfoPo.setMinbgibelowplusluminosityjp(minbgibelowplusluminosityjp);
		goodsInfoPo.setMaxbgibelowplusluminosityjp(maxbgibelowplusluminosityjp);
		goodsInfoPo.setBgieyeglassmaterialtypejp(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractivejp(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosityjp(bgiismutiluminosityjp);
		goodsInfoPo.setBgifunctionclassjp(bgifunctionclassjp);
		goodsInfoPo.setBgigradualclassjp(bgigradualclassjp);
		goodsInfoPo.setMinSphyx(changeMinSphyx);
		goodsInfoPo.setMaxSphyx(changeMaxSphyx);
		goodsInfoPo.setMinCylyx(changeMinCylyx);
		goodsInfoPo.setMaxCylyx(changeMaxCylyx);
		goodsInfoPo.setBgicurvature1yx(bgicurvature1yx);
		goodsInfoPo.setBgidiayx(bgidiayx);
		goodsInfoPo.setBgiusetypeyx(bgiusetypeyx);
		goodsInfoPo.setBgistealthclassyx(bgistealthclassyx);
		goodsInfoPo.setBgicapacityyxhly(bgicapacityyxhly);
		goodsInfoPo.setBgicapacityentryyxhly(bgicapacityentryyxhly);
		goodsInfoPo.setBgisuppliercolortyj(bgisuppliercolortyj);
		goodsInfoPo.setBgiframesizetyj(bgiframesizetyj);
		goodsInfoPo.setMinSphlhj(minSphlhj);
		goodsInfoPo.setMaxSphlhj(maxSphlhj);
		goodsInfoPo.setBgisuppliercolorlhj(bgisuppliercolorlhj);
		goodsInfoPo.setBgiframesizelhj(bgiframesizelhj);
//////////////////////////////////////////////////////////////////////////////////////////////
		request.setAttribute("bgispecs", bgispecs);
		request.setAttribute("bgisuppliercolorjj", bgisuppliercolorjj);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("bgiframematerialtypejj", bgiframematerialtypejj);
		request.setAttribute("technologyTypeIDjj", technologyTypeIDjj);
		request.setAttribute("bgiaccessoriestypepj", bgiaccessoriestypepj);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		request.setAttribute("minbgibelowplusluminosityjp", minbgibelowplusluminosityjp);
		request.setAttribute("maxbgibelowplusluminosityjp", maxbgibelowplusluminosityjp);
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("bgifunctionclassjp", bgifunctionclassjp);
		request.setAttribute("bgigradualclassjp", bgigradualclassjp);
		request.setAttribute("minSphyx", minSphyx);
		request.setAttribute("maxSphyx", maxSphyx);
		request.setAttribute("minCylyx", minCylyx);
		request.setAttribute("maxCylyx", maxCylyx);
		request.setAttribute("bgicurvature1yx", bgicurvature1yx);
		request.setAttribute("bgidiayx", bgidiayx);
		request.setAttribute("bgiusetypeyx", bgiusetypeyx);
		request.setAttribute("bgistealthclassyx", bgistealthclassyx);
		request.setAttribute("bgicapacityyxhly", bgicapacityyxhly);
		request.setAttribute("bgicapacityentryyxhly", bgicapacityentryyxhly);
		request.setAttribute("bgisuppliercolortyj", bgisuppliercolortyj);
		request.setAttribute("bgiframesizetyj", bgiframesizetyj);
		request.setAttribute("minSphlhj", minSphlhj);
		request.setAttribute("maxSphlhj", maxSphlhj);
		request.setAttribute("bgisuppliercolorlhj", bgisuppliercolorlhj);
		request.setAttribute("bgiframesizelhj", bgiframesizelhj);

		
		
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = windowGoodsMgr.getGoodsSingleCount(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgicostbeginprice", bgicostbeginprice);
		request.setAttribute("bgicostendprice", bgicostendprice);
		request.setAttribute("iscustomize", iscustomize);
		request.setAttribute("brandName", brandName);
	
		
		return SUCCESS;
	}

	/**
	 * 初始化单品商品查询(调拨商品采购订单使用)
	 */
	public String initGoodsSingleSelAll() throws Exception {
		

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
		
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);		

		String goodscategoryID = Utility.getName(request
				.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request
				.getParameter("supplierID_open"));

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);

		return SUCCESS;
	}

	/**
	 * 查询单品商品(调拨商品采购订单使用)
	 */
	public String selGoodsSingleAll() throws Exception {
		
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
		
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);		

		String billID=Utility.getName(request.getParameter("billID"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));

		AllocationPo allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaindepartmentid(departmentID);
		allocationPo.setCshaaauditstate("1");
		allocationPo.setCshaaauditdatestart(startTime1);
		allocationPo.setCshaaauditdateend(endTime1);
		allocationPo.setGoodscategoryid(goodscategoryID);
		allocationPo.setChaasupplier(supplierID);
		allocationPo.setCshaaauditperson(auditPersonID);
		allocationPo.setCshaaflag("1");//正调拨
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			allocationPo.setCshaaindptcompanyid(personInfoPo1.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getGoodsSingleAllCount(allocationPo);
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
			allocationList = windowGoodsMgr.getGoodsSingleAllList(allocationPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		
		request.setAttribute("billID",billID);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("startTime1",startTime1);
		request.setAttribute("endTime1",endTime1);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("auditPersonID", auditPersonID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		
		return SUCCESS;
	}

	/**
	 * 初始化调拨申请单查询(调拨商品调拨申请使用)
	 */
	public String initGoodsSingleSelAllForApp() throws Exception {
		//TODO
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
		//取得登陆人允许操作的仓位&部门 Begin		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		
		departmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);	
		
		if (departmentsList == null){
			departmentsList = new ArrayList<DepartmentsPo>();
		}
		
		List<DepartmentsPo> dList = departmentsMgr.getSalesAndStorageDepartment();
		for (DepartmentsPo dpo : dList){
			departmentsList.add(dpo);
		}

		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo.getBspsuppliername());
		}
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);

		String isShowBarcode = Utility.getName(request.getParameter("isShowBarcode"));
		request.setAttribute("isShowBarcode", isShowBarcode);
		
		String dptID = Utility.getName(request.getParameter("dptID"));
		request.setAttribute("dptID", dptID);
		
		return SUCCESS;
	}

	/**
	 * 调拨申请单查询(调拨商品调拨申请使用)
	 */
	public String selGoodsSingleAllForApp() throws Exception {
		//TODO
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
		goodsCategorys = varietyMgr.getGoodsCategorys();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		//取得登陆人允许操作的仓位&部门 Begin		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		departmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);		
				
		if (departmentsList == null){
			departmentsList = new ArrayList<DepartmentsPo>();
		}
		
		String masterFlag = "2";
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			masterFlag = "1";
		}
		List<DepartmentsPo> dList = departmentsMgr.getSalesAndStorageDepartment();
		for (DepartmentsPo dpo : dList){
			departmentsList.add(dpo);
		}

		String billID=Utility.getName(request.getParameter("billID"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));
		String isWriteoffs = Utility.getName(request.getParameter("isWriteoffs"));

		String dptID = Utility.getName(request.getParameter("dptID"));
		request.setAttribute("dptID", dptID);
		
		AllocationPo allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaindepartmentid(departmentID);
		allocationPo.setCshaaauditstate("1");
		allocationPo.setCshaaauditdatestart(startTime1);
		allocationPo.setCshaaauditdateend(endTime1);
		allocationPo.setGoodscategoryid(goodscategoryID);
		allocationPo.setChaasupplier(supplierID);
		allocationPo.setCshaaauditperson(auditPersonID);
		allocationPo.setCshaaflag("1");//正调拨
		allocationPo.setCshaaoutdepartmentid(dptID);
		allocationPo.setIsWriteoffs(isWriteoffs.equals("") ? "0" : isWriteoffs);
		allocationPo.setCshaaindptcompanyid(personInfoPo.getPersoncompanyid());
			
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getGoodsSingleAllCountForApp(allocationPo);
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
			allocationList = windowGoodsMgr.getGoodsSingleAllListForApp(allocationPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		
		request.setAttribute("billID",billID);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("startTime1",startTime1);
		request.setAttribute("endTime1",endTime1);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("auditPersonID", auditPersonID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("isWriteoffs", isWriteoffs);
		
		String isShowBarcode = Utility.getName(request.getParameter("isShowBarcode"));
		request.setAttribute("isShowBarcode", isShowBarcode);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化单品商品查询(调拨商品调拨模块使用)
	 */
	public String initGoodsSingleSelAlls() throws Exception {
		

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
		
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);		

		String goodscategoryID = Utility.getName(request
				.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request
				.getParameter("supplierID_open"));

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		return SUCCESS;
	}

	/**
	 * 查询单品商品(调拨商品调拨模块使用)
	 */
	public String selGoodsSingleAlls() throws Exception {
		
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
		
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);		

		String billID=Utility.getName(request.getParameter("billID"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));
		String isguaranteeperiod=Utility.getName(request.getParameter("isguaranteeperiod"));

		AllocationPo allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaindepartmentid(departmentID);
		allocationPo.setCshaaauditstate("1");
		allocationPo.setCshaaauditdatestart(startTime1);
		allocationPo.setCshaaauditdateend(endTime1);
		allocationPo.setGoodscategoryid(goodscategoryID);
		allocationPo.setChaasupplier(supplierID);
		allocationPo.setCshaaauditperson(auditPersonID);
		allocationPo.setCshaaflag("1");//正调拨
		allocationPo.setIsguaranteeperiod(isguaranteeperiod);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getGoodsSingleAllCount1(allocationPo);
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
			allocationList = windowGoodsMgr.getGoodsSingleAllList1(allocationPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		
		request.setAttribute("billID",billID);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("startTime1",startTime1);
		request.setAttribute("endTime1",endTime1);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("auditPersonID", auditPersonID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化单品商品查询(负调拨商品调拨模块使用)
	 */
	public String initGoodsAllocation() throws Exception {
		

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
		
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);		

		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping

		return SUCCESS;
	}

	/**
	 * 查询单品商品(负调拨商品调拨模块使用)
	 */
	public String selGoodsAllocation() throws Exception {
		
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
		
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);		

		String billID=Utility.getName(request.getParameter("billID"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));

		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));

		AllocationPo allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaindepartmentid(departmentID);
//		allocationPo.setCshaaauditstate("1");
		allocationPo.setCshaaauditdatestart(startTime1);
		allocationPo.setCshaaauditdateend(endTime1);
//		allocationPo.setGoodscategoryid(goodscategoryID);
//		allocationPo.setChaasupplier(supplierID);
		allocationPo.setCshaaauditperson(auditPersonID);
		allocationPo.setCshaaflag("2");//负调拨
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getGoodsSingleAllCount2(allocationPo);
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
			allocationList = windowGoodsMgr.getGoodsSingleAllList2(allocationPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		
		request.setAttribute("billID",billID);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("startTime1",startTime1);
		request.setAttribute("endTime1",endTime1);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("auditPersonID", auditPersonID);
	//	request.setAttribute("supplierName", supplierName);
//		request.setAttribute("goodscategoryID", goodscategoryID);
//		request.setAttribute("supplierID", supplierID);
		
		return SUCCESS;
	}
	
	
	/**
	 * 初始化单品收货商品查询(调拨商品调拨模块使用)
	 */
	public String initGoodsReceipt() throws Exception {
		

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

		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo.getBspsuppliername());
		}
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);

		String isShowBarcode = Utility.getName(request.getParameter("isShowBarcode"));
		request.setAttribute("isShowBarcode", isShowBarcode);
		
		return SUCCESS;
	}

	/**
	 * 查询收货商品(收货商品调拨模块使用)
	 */
	public String selGoodsReceipt() throws Exception {
		
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

		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);		

		String billID=Utility.getName(request.getParameter("billID"));
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open")).equals("") ? Utility.getName(request.getParameter("goodscategoryID")) : Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		InventoryPo po = new InventoryPo();
		po.setCstibillid(billID);
		po.setCstiauditdate("1");
		po.setCstiauditstartdate(startTime1);
		po.setCstiauditenddate(endTime1);
		po.setCstigoodscategory(goodscategoryID);
		po.setCstisupplierid(supplierID);
		po.setCstisuppliername(auditPersonID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setCsticompanyid(personInfoPo.getPersoncompanyid());
		}

		int count = windowGoodsMgr.getGoodsReceiptCount(po);
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
			procurementReceiptList = windowGoodsMgr.getGoodsReceiptList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		
		request.setAttribute("billID",billID);
		request.setAttribute("startTime1",startTime1);
		request.setAttribute("endTime1",endTime1);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("auditPersonID", auditPersonID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		
		String isShowBarcode = Utility.getName(request.getParameter("isShowBarcode"));
		request.setAttribute("isShowBarcode", isShowBarcode);
		
		return SUCCESS;
	}

	/**
	 * 初始化库存预警商品查询
	 */
	public String initGoodsAlertSel() throws Exception {
		
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
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String brandID = Utility.getName(request.getParameter("brandID_open"));
		String departmentId = Utility.getName(request.getParameter("departmentId"));

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		
		if (!"".equals(Utility.getName(brandID))) {
			BrandPo brandPo = new BrandPo();
			brandPo.setBbdid(brandID);
			brandPo.setBbdsupplierid(supplierID);
			brandPo = brandMgr.getBrandPo(brandPo);
			request.setAttribute("brandName", brandPo
					.getBbdbrandname());
		}
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		WarehousePo warehousePo = new WarehousePo();
		warehousePo.setBwhdeptid(departmentId);
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			warehousePo.setBwhcompanyid(personInfoPo1.getPersoncompanyid());
		}
		warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		
		String warehouseID = "";
		if(warehouselist!=null && warehouselist.size()==1){
			warehouseID = Utility.getName(warehouselist.get(0).getBwhid());
		}	
		request.setAttribute("warehouseID", warehouseID);
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandID_open", brandID);
		request.setAttribute("departmentId", departmentId);
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("permissionPokeyg",Utility.getName(request.getParameter("permissionPokeyg")));
		
		return SUCCESS;
	}

	/**
	 * 查询库存预警商品
	 */
	public String selGoodsAlert() throws Exception {
		
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
		
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		String alerttype = Utility.getName(request.getParameter("alerttype"));
		String departmentId = Utility.getName(request.getParameter("departmentId"));
		
		request.setAttribute("brandName", brandName);
		request.setAttribute("supplierName", supplierName);
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request
					.getParameter("categoryID_open"));
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request
					.getParameter("supplierID_open"));
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo
						.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		
		if ("".equals(brandID)) {
			brandID = Utility.getName(request
					.getParameter("brandID_open"));
			if (!"".equals(Utility.getName(supplierID))) {
				BrandPo brandPo = new BrandPo();
				brandPo.setBbdid(brandID);
				brandPo.setBbdsupplierid(supplierID);
				if(!"".equals(brandID)){
					brandPo = brandMgr.getBrandPo(brandPo);
				}
				request.setAttribute("brandName", brandPo
						.getBbdbrandname());
			}
			request.setAttribute("brandID_open", brandID);
		}
		
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		
		goodsInfoPo.setAlerttype(alerttype);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiwarehouseid(warehouseID);
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			goodsInfoPo.setBgicompanyid(personInfoPo1.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getGoodsAlertCount(goodsInfoPo);
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
			goodsList = windowGoodsMgr.getGoodsAlertList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		WarehousePo warehousePo = new WarehousePo();
		warehousePo.setBwhdeptid(departmentId);
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			warehousePo.setBwhcompanyid(personInfoPo1.getPersoncompanyid());
		}
		warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("departmentId", departmentId);
		request.setAttribute("warehouseID", warehouseID);
		request.setAttribute("alerttype", alerttype);
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		request.setAttribute("permissionPokeyg",Utility.getName(request.getParameter("permissionPokeyg")));
		
		return SUCCESS;
	}
	
	/**
	 * Description :初始化二维选择商品品开窗
	 * @return: 单品开窗页面
	 */
	public String initGoodsOpen_dimensional() throws Exception {	
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
		String goodsCategoryID = Utility.getName(request.getParameter("cstpgoodscategory"));		
		String supplierID = Utility.getName(request.getParameter("cstpsupplierid"));
		String supplierName = Utility.getName(request.getParameter("bspsuppliername"));
		String brandID = Utility.getName(request.getParameter("brandID_open"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		request.setAttribute("tdgoodsids", request.getParameter("tdgoodsids"));
		request.setAttribute("tdvs", request.getParameter("tdvs"));
		request.setAttribute("makeinvoiceflag", 1);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierID_open",supplierID);
		request.setAttribute("categoryID_open",goodsCategoryID);
		request.setAttribute("brandID",brandID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID_open",brandID);
		request.setAttribute("retailType",request.getParameter("retailType"));
		request.setAttribute("whichretail", request.getParameter("whichretails"));
		
    	return SUCCESS;
    }	
	
	/**
	 * Description :二维选择商品品开窗
	 * @return: 单品开窗页面
	 */
	public String goodsOpen_dimensional() throws Exception {
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("makeinvoiceflag", 1);
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));		
		String supplierID_open = Utility.getName(request.getParameter("supplierID_open"));
		String categoryID_open = Utility.getName(request.getParameter("categoryID_open"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		request.setAttribute("brandID_open",brandID);
		
		//判断显示的仓位是启用的还是停用的
		String usingWarehouse = Utility.getName(request.getParameter("usingWarehouse"));
		request.setAttribute("usingWarehouse",usingWarehouse.equals("") ? "0" : usingWarehouse);
		
		request.setAttribute("supplierID_open",supplierID_open);
		request.setAttribute("categoryID_open",categoryID_open);		
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("brandID",brandID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("warehouseID",warehouseID);
		
		GoodsInfoPo goodsPo=new GoodsInfoPo();		
		goodsPo.setBgigoodscategoryid(goodsCategoryID);
		goodsPo.setBgisupplierid(supplierID);
		goodsPo.setBgibrandid(brandID);
		goodsPo.setBgiwarehouseid(warehouseID);		
		
		goodsInfoPo = varietyMgr.getMaxMinGoods(goodsPo);
		goodsPo.setMaxSph(Utility.getName(goodsInfoPo.getMaxSph()).equals("") ? "0.00" : Utility.getName(goodsInfoPo.getMaxSph()));
		goodsPo.setMaxCyl(Utility.getName(goodsInfoPo.getMaxCyl()).equals("") ? "0.00" : Utility.getName(goodsInfoPo.getMaxCyl()));	
		goodsPo.setMinSph(Utility.getName(goodsInfoPo.getMinSph()).equals("") ? "0.00" : Utility.getName(goodsInfoPo.getMinSph()));
		goodsPo.setMinCyl(Utility.getName(goodsInfoPo.getMinCyl()).equals("") ? "0.00" : Utility.getName(goodsInfoPo.getMinCyl()));	
		
		goodsInfoList = varietyMgr.getstringContextGoodsList(goodsPo);
		//System.out.println(goodsInfoList.get(7).getStringContext().substring(0,goodsInfoList.get(7).getStringContext().length()-1));
		String valueNo="\"v\":0";
		String value="\"v\":";	
		String goodsid="\"goodsid\":\"\"";
		if(!"".equals(Utility.getName(request.getParameter("tdgoodsids")))){
			String[] tgoodsid=request.getParameter("tdgoodsids").split(",");
			String[] tvs=request.getParameter("tdvs").split(",");
			for(int i=0;i<goodsInfoList.size();i++){
				for(int j=0;j<tgoodsid.length;j++){
					if(goodsInfoList.get(i).getStringContext().split(",")[2].substring(11,goodsInfoList.get(i).getStringContext().split(",")[2].length()-2).equals(goodsid)){
						GoodsInfoPo goodsInfoPos=new GoodsInfoPo();
						String StringCon=goodsInfoList.get(i).getStringContext().substring(0,goodsInfoList.get(i).getStringContext().length()-1)+","+valueNo+"}";
						goodsInfoPos.setStringContext(StringCon);
						goodsInfoList.set(i, goodsInfoPos);
					}
					if(!goodsInfoList.get(i).getStringContext().split(",")[2].substring(11,goodsInfoList.get(i).getStringContext().split(",")[2].length()-2).equals(goodsid)){
						if(goodsInfoList.get(i).getStringContext().split(",")[2].substring(11,goodsInfoList.get(i).getStringContext().split(",")[2].length()-2).toUpperCase().equals(tgoodsid[j])){
							GoodsInfoPo goodsInfoPos=new GoodsInfoPo();
							String StringCon=goodsInfoList.get(i).getStringContext().substring(0,goodsInfoList.get(i).getStringContext().length()-1)+","+value+tvs[j]+"}";
							goodsInfoPos.setStringContext(StringCon);
							goodsInfoList.set(i, goodsInfoPos);
						}
					}
				}
			}
		}
		request.setAttribute("dimensiionalFlag","1");
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(Utility.getName(personInfoPo.getDepartmentID()));
		departmentsPo.setBdptype(Utility.getName(personInfoPo.getDepartmenttype()));
		WarehousePo warehousePo = new WarehousePo();
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

		request.setAttribute("retailType",request.getParameter("retailType"));
		request.setAttribute("whichretail", request.getParameter("whichretail"));
    	return SUCCESS;
    }

	public List<GoodsInfoPo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsInfoPo> goodsList) {
		this.goodsList = goodsList;
	}

	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public List<WarehousePo> getWarehouselist() {
		return warehouselist;
	}

	public void setWarehouselist(List<WarehousePo> warehouselist) {
		this.warehouselist = warehouselist;
	}

	public String initMoreAdjustmentPriceOpen() throws Exception {
		goodsCategorys = varietyMgr.getGoodsCategorys();
		return SUCCESS;
	}

	/**
	 * 批量查询开窗
	 * 
	 * @return
	 */
	public String moreAdjustmentPriceSel() {
		goodsCategorys = varietyMgr.getGoodsCategorys();
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request
				.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request
				.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String glassType = Utility.getName(request.getParameter("glassType"));
		String cylup = Utility.getName(request.getParameter("cylup"));
		String cylul = Utility.getName(request.getParameter("cylul"));
		String sphul = Utility.getName(request.getParameter("sphul"));
		String sphup = Utility.getName(request.getParameter("sphup"));
		String sph = Utility.getName(request.getParameter("sph"));
		String cyl = Utility.getName(request.getParameter("cyl"));
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgiiscustomize(glassType);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgicylup(cylup);
		goodsInfoPo.setBgisphup(sphup);
		goodsInfoPo.setBgisphul(sphul);
		goodsInfoPo.setBgicylul(cylul);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getMoreAdjuestmentPriceCount(goodsInfoPo);
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
			goodsList = windowGoodsMgr.getMoreAdjustmentPriceList(goodsInfoPo,
					page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}

		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandName", brandName);
		request.setAttribute("glassType", glassType);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("sphul", sphul);
		request.setAttribute("sphup", sphup);
		request.setAttribute("cylul", cylul);
		request.setAttribute("cylup", cylup);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		
		return SUCCESS;
	}

	public void setTechnologyType(List<TechnologyTypePo> technologyType) {
		this.technologyType = technologyType;
	}

	public List<TechnologyTypePo> getTechnologyType() {
		return technologyType;
	}
	
	/**
	 * 初始化二维表查询查询
	 */
	public String init2DSel() throws Exception {

		return SUCCESS;
	}
	
	
	/**
	 * 初始化单品商品查询(负调拨商品退货模块使用)
	 */
	public String initGoodsAllocationTui() throws Exception {
		

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
		
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);		

		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping


		return SUCCESS;
	}

	/**
	 * 查询单品商品(负调拨商品退货模块使用)
	 */
	public String selGoodsAllocationTui() throws Exception {
		
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
		
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);		

		String billID=Utility.getName(request.getParameter("billID"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));

		AllocationPo allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaindepartmentid(departmentID);
		allocationPo.setCshaaauditdatestart(startTime1);
		allocationPo.setCshaaauditdateend(endTime1);
		allocationPo.setCshaaauditperson(auditPersonID);
		allocationPo.setCshaaflag("2");//负调拨
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getGoodsSingleAllCountTui(allocationPo);
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
			allocationList = windowGoodsMgr.getGoodsSingleAllListTui(allocationPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		
		request.setAttribute("billID",billID);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("startTime1",startTime1);
		request.setAttribute("endTime1",endTime1);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("auditPersonID", auditPersonID);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化单品商品查询(负调拨商品销售出库模块使用)
	 */
	public String initGoodsAllocationOut() throws Exception {
		

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
		
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);		

		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping


		return SUCCESS;
	}

	/**
	 * 查询单品商品(负调拨商品销售出库模块使用)
	 */
	public String selGoodsAllocationOut() throws Exception {
		
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
		
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);		

		String billID=Utility.getName(request.getParameter("billID"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));

		AllocationPo allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaindepartmentid(departmentID);
		allocationPo.setCshaaauditdatestart(startTime1);
		allocationPo.setCshaaauditdateend(endTime1);
		allocationPo.setCshaaauditperson(auditPersonID);
		allocationPo.setCshaaflag("2");//负调拨
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getGoodsSingleAllCountOut(allocationPo);
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
			allocationList = windowGoodsMgr.getGoodsSingleAllListOut(allocationPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		
		request.setAttribute("billID",billID);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("startTime1",startTime1);
		request.setAttribute("endTime1",endTime1);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("auditPersonID", auditPersonID);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化隐形效期查询添加商品
	 */
	public String initOpenInvisible() throws Exception {
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
		
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
			request.setAttribute("supplierid", supplierPo
					.getBspid());
			request.setAttribute("supplierID_open", supplierPo
							.getBspid());
		}

		return SUCCESS;
	}
	
	/**
	 * 初始化隐形效期查询添加商品
	 */
	public String selOpenInvisible() throws Exception {
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

		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierID_open = Utility.getName(request.getParameter("supplierID_open"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String goodsBarcode = Utility.getName(request.getParameter("goodsBarcode"));
		String warehouseID = Utility.getName(request.getParameter("warehouseID"));
		String sumnum = Utility.getName(request.getParameter("sumnum"));
		String sumnum1 = Utility.getName(request.getParameter("sumnum1"));
		String RetailPrice = Utility.getName(request.getParameter("RetailPrice"));
		/**
		 * 隐形效期条件
		 */
		String invisibletype = Utility.getName(request.getParameter("invisibletype"));
		String maxandmin = Utility.getName(request.getParameter("maxandmin"));
		String mindown = Utility.getName(request.getParameter("mindown"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
			request.setAttribute("supplierID", supplierPo
					.getBspid());
		}

		if(!"".equals(Utility.getName(supplierID_open))){
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID_open);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
			request.setAttribute("supplierID_open", supplierID_open);
		}
		
		
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
		goodsDetailsInfoPo.setSmecistocklist(warehouselist);		
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		Map<String, Object> goodsNums = stockSearchMgr.getStockSearchInvisibleCount(goodsDetailsInfoPo);
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
			goodsDetailsList = stockSearchMgr.getStockSearchInvisibleList(
					goodsDetailsInfoPo, page.getStart(), page
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
		request.setAttribute("stockID", warehouseID);
		request.setAttribute("sumnum", sumnum);
		request.setAttribute("sumnum1", sumnum1);
		request.setAttribute("goodsBarcode", Utility.getName(request.getParameter("goodsBarcode")));
		request.setAttribute("RetailPrice", RetailPrice);
		
		/*
		 * 隐形效期条件
		 */
		request.setAttribute("invisibletype", invisibletype);
		request.setAttribute("maxandmin", maxandmin);
		request.setAttribute("mindown", mindown);
		
		return SUCCESS;
	}
	/**
	 * 按品种调价开窗（零售）
	 */
	public String initBrandPriceSel() throws Exception {
	
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));

		return SUCCESS;
	}	
	/**
	 * 按品种调价开窗（零售）
	 */
	public String selBrandPrice() throws Exception {
				
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String whichretail = Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		String bgiretailbeginprice = Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice = Utility.getName(request.getParameter("bgiretailendprice"));
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		
		BrandPo brandPo=new BrandPo();
		brandPo.setBspcategoryid(goodscategoryID);
		brandPo.setBbdsupplierid(supplierID);
		brandPo.setBbdid(brandID);
		brandPo.setBbdwhichretail(whichretail);
		brandPo.setBbdismendretail(select_retail);
		brandPo.setBbdminretailPrice(bgiretailbeginprice);
		brandPo.setBbdmaxretailPrice(bgiretailendprice);
		
		int count = windowGoodsMgr.getBrandPriceCount(brandPo);

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

			brandlist = windowGoodsMgr.getBrandPriceList(brandPo, page.getStart(), page
					.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}
		
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);		


		return SUCCESS;
	}
	/**
	 * 按品种调价开窗（成本）
	 */
	public String initBrandPriceSel2() throws Exception {
	
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));

		return SUCCESS;
	}	
	/**
	 * 按品种调价开窗（成本）
	 */
	public String selBrandPrice2() throws Exception {
				
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));		
		String begincostprice = Utility.getName(request.getParameter("begincostprice"));
		String endcostprice = Utility.getName(request.getParameter("endcostprice"));
		
		BrandPo brandPo=new BrandPo();
		brandPo.setBspcategoryid(goodscategoryID);
		brandPo.setBbdsupplierid(supplierID);
		brandPo.setBbdid(brandID);
		brandPo.setBbdbgncostprice(begincostprice);
		brandPo.setBbdendcostprice(endcostprice);
		
		int count = windowGoodsMgr.getBrandPriceCount2(brandPo);

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

			brandlist = windowGoodsMgr.getBrandPriceList2(brandPo, page.getStart(), page
					.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}		
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);		
		request.setAttribute("begincostprice", begincostprice);	
		request.setAttribute("endcostprice", endcostprice);	

		return SUCCESS;
	}
	/**
	 * 按品种调价开窗（批发价）
	 */
	public String initBrandPriceSel3() throws Exception {
	
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));

		return SUCCESS;
	}	
	/**
	 * 按品种调价开窗（批发价）
	 */
	public String selBrandPrice3() throws Exception {
				
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		
		BrandPo brandPo=new BrandPo();
		brandPo.setBspcategoryid(goodscategoryID);
		brandPo.setBbdsupplierid(supplierID);
		brandPo.setBbdid(brandID);

		
		int count = windowGoodsMgr.getBrandPriceCount3(brandPo);

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

			brandlist = windowGoodsMgr.getBrandPriceList3(brandPo, page.getStart(), page
					.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}
		
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);		

		return SUCCESS;
	}
	

	/**
	 * 按品种调价开窗（门店预销售设置）
	 */
	public String initBrandPriceSel4() throws Exception {
	
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));

		return SUCCESS;
	}	
	/**
	 * 按品种调价开窗（门店预销售设置）
	 */
	public String selBrandPrice4() throws Exception {
				
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String whichretail = Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		String bgiretailbeginprice = Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice = Utility.getName(request.getParameter("bgiretailendprice"));
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		
		BrandPo brandPo=new BrandPo();
		brandPo.setBspcategoryid(goodscategoryID);
		brandPo.setBbdsupplierid(supplierID);
		brandPo.setBbdid(brandID);
		brandPo.setBbdwhichretail(whichretail);
		brandPo.setBbdismendretail(select_retail);
		brandPo.setBbdminretailPrice(bgiretailbeginprice);
		brandPo.setBbdmaxretailPrice(bgiretailendprice);
		
		int count = windowGoodsMgr.getBrandPriceCount4(brandPo);

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

			brandlist = windowGoodsMgr.getBrandPriceList4(brandPo, page.getStart(), page
					.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}
		
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);		


		return SUCCESS;
	}
	public String initSelGoodsInfoForSOUT() throws Exception {
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
		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo.getDepartmenttype()));
		request.setAttribute("departmentID",Utility.getName(personInfoPo.getDepartmentID()));
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);
		String outstockid=Utility.getName(request.getParameter("outstockid"));
		request.setAttribute("outstockid", outstockid);
		
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String bdpdepartmentname=Utility.getName(request.getParameter("bdpdepartmentname"));
		String departmentID=Utility.getName(request.getParameter("departmentID"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String brandID = Utility.getName(request.getParameter("brandID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		request.setAttribute("departmentID", departmentID);
		request.setAttribute("bdpdepartmentname", bdpdepartmentname);
		
		String indptid = Utility.getName(request.getParameter("indptid"));
		request.setAttribute("indptid", indptid);

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		
		if (!"".equals(Utility.getName(brandID))) {
			BrandPo brandPo = new BrandPo();
			brandPo.setBbdid(brandID);
			brandPo.setBbdsupplierid(supplierID);
			brandPo = brandMgr.getBrandPo(brandPo);
			request.setAttribute("brandName", brandPo
					.getBbdbrandname());
		}
		
		technologyType = varietyMgr.getTechnologyType();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();
		
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("brandID_open", brandID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("iscustomize", iscustomize);
		
		String isShowBarcode = Utility.getName(request.getParameter("isShowBarcode"));
		request.setAttribute("isShowBarcode", isShowBarcode);

		return SUCCESS;
	}
	
	/**
	 * 按销采购商品开窗
	 */
	public String selGoodsInfoForSOUT() throws Exception {
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
		String bdpdepartmentname=Utility.getName(request.getParameter("bdpdepartmentname"));
		String departmentID=Utility.getName(request.getParameter("departmentID"));
		request.setAttribute("departmentID", departmentID);
		request.setAttribute("bdpdepartmentname", bdpdepartmentname);
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);

		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String iscustomizeyx=Utility.getName(request.getParameter("iscustomizeyx"));
		String iscustomizekj=Utility.getName(request.getParameter("iscustomizekj"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgiretailbeginprice=Utility.getName(request.getParameter("bgiretailbeginprice"));
		String bgiretailendprice=Utility.getName(request.getParameter("bgiretailendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		String bgisuppliercolorjj=Utility.getName(request.getParameter("bgisuppliercolorjj"));
		String bgiframesizejj=Utility.getName(request.getParameter("bgiframesizejj"));
		String bgiframematerialtypejj=Utility.getName(request.getParameter("bgiframematerialtypejj"));
		String technologyTypeIDjj=Utility.getName(request.getParameter("technologyTypeIDjj"));
		String bgiaccessoriestypepj=Utility.getName(request.getParameter("bgiaccessoriestypepj"));
		String minSphjp=Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp=Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp=Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp=Utility.getName(request.getParameter("maxCyljp"));
		String minbgibelowplusluminosityjp=Utility.getName(request.getParameter("minbgibelowplusluminosityjp"));
		String maxbgibelowplusluminosityjp=Utility.getName(request.getParameter("maxbgibelowplusluminosityjp"));
		String bgieyeglassmaterialtypejp=Utility.getName(request.getParameter("bgieyeglassmaterialtypejp"));
		String bgirefractivejp=Utility.getName(request.getParameter("bgirefractivejp"));
		String bgiismutiluminosityjp=Utility.getName(request.getParameter("bgiismutiluminosityjp"));
		String bgifunctionclassjp=Utility.getName(request.getParameter("bgifunctionclassjp"));
		String bgigradualclassjp=Utility.getName(request.getParameter("bgigradualclassjp"));
		String minSphyx=Utility.getName(request.getParameter("minSphyx"));
		String maxSphyx=Utility.getName(request.getParameter("maxSphyx"));
		String minCylyx=Utility.getName(request.getParameter("minCylyx"));
		String maxCylyx=Utility.getName(request.getParameter("maxCylyx"));
		String bgicurvature1yx=Utility.getName(request.getParameter("bgicurvature1yx"));
		String bgidiayx=Utility.getName(request.getParameter("bgidiayx"));
		String bgiusetypeyx=Utility.getName(request.getParameter("bgiusetypeyx"));
		String bgistealthclassyx=Utility.getName(request.getParameter("bgistealthclassyx"));
		String bgicapacityyxhly=Utility.getName(request.getParameter("bgicapacityyxhly"));
		String bgicapacityentryyxhly=Utility.getName(request.getParameter("bgicapacityentryyxhly"));
		String bgisuppliercolortyj=Utility.getName(request.getParameter("bgisuppliercolortyj"));
		String bgiframesizetyj=Utility.getName(request.getParameter("bgiframesizetyj"));
		String minSphlhj=Utility.getName(request.getParameter("minSphlhj"));
		String maxSphlhj=Utility.getName(request.getParameter("maxSphlhj"));
		String bgisuppliercolorlhj=Utility.getName(request.getParameter("bgisuppliercolorlhj"));
		String bgiframesizelhj=Utility.getName(request.getParameter("bgiframesizelhj"));
		String bgispecs=Utility.getName(request.getParameter("bgispecs"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		
		String outstockid=Utility.getName(request.getParameter("outstockid"));
		request.setAttribute("outstockid", outstockid);
		
		String indptid = Utility.getName(request.getParameter("indptid"));
		request.setAttribute("indptid", indptid);
		
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandName", brandName);
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
		request.setAttribute("iscustomize", iscustomize);
		
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		
		if ("".equals(brandID)) {
			brandID = Utility.getName(request.getParameter("brandID_open"));
			
			if (!"".equals(Utility.getName(brandID))) {
				BrandPo brandPo = new BrandPo();
				brandPo.setBbdid(brandID);
				brandPo.setBbdsupplierid(supplierID);
				brandPo = brandMgr.getBrandPo(brandPo);
				request.setAttribute("brandName", brandPo.getBbdbrandname());
			}
			request.setAttribute("brandID_open", brandID);
		}
		
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
				
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgidepartmentid(indptid);
		goodsInfoPo.setShopCode(departmentID);
		goodsInfoPo.setBgijm(jm);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgiretailbeginprice(bgiretailbeginprice);
		goodsInfoPo.setBgiretailendprice(bgiretailendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		goodsInfoPo.setBgiwhichretail(whichretail);
		goodsInfoPo.setBgiismendretail(select_retail);
		goodsInfoPo.setBgnDate(startTime);
		goodsInfoPo.setEndDate(endTime);
		goodsInfoPo.setBgiwarehouseid(outstockid);
	
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		
		if("3".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizekj)){
			goodsInfoPo.setBgiiscustomize(iscustomizekj);
		}else if("4".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizeyx)){
			goodsInfoPo.setBgiiscustomize(iscustomizeyx);
		}else{
			goodsInfoPo.setBgiiscustomize(iscustomize);
		}
////////////////////////////////////////////////////////////////////////////////////////		
		goodsInfoPo.setBgispec(bgispecs); 
		goodsInfoPo.setBgisuppliercolorjj(bgisuppliercolorjj);
		goodsInfoPo.setBgiframesizejj(bgiframesizejj);
		goodsInfoPo.setBgiframematerialtypejj(bgiframematerialtypejj);
		goodsInfoPo.setTechnologyTypeIDjj(technologyTypeIDjj);
		goodsInfoPo.setBgiaccessoriestypepj(bgiaccessoriestypepj);
		goodsInfoPo.setMinSphjp(minSphjp);
		goodsInfoPo.setMaxSphjp(maxSphjp);
		goodsInfoPo.setMinCyljp(minCyljp);
		goodsInfoPo.setMaxCyljp(maxCyljp);
		goodsInfoPo.setMinbgibelowplusluminosityjp(minbgibelowplusluminosityjp);
		goodsInfoPo.setMaxbgibelowplusluminosityjp(maxbgibelowplusluminosityjp);
		goodsInfoPo.setBgieyeglassmaterialtypejp(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractivejp(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosityjp(bgiismutiluminosityjp);
		goodsInfoPo.setBgifunctionclassjp(bgifunctionclassjp);
		goodsInfoPo.setBgigradualclassjp(bgigradualclassjp);
		goodsInfoPo.setMinSphyx(minSphyx);
		goodsInfoPo.setMaxSphyx(maxSphyx);
		goodsInfoPo.setMinCylyx(minCylyx);
		goodsInfoPo.setMaxCylyx(maxCylyx);
		goodsInfoPo.setBgicurvature1yx(bgicurvature1yx);
		goodsInfoPo.setBgidiayx(bgidiayx);
		goodsInfoPo.setBgiusetypeyx(bgiusetypeyx);
		goodsInfoPo.setBgistealthclassyx(bgistealthclassyx);
		goodsInfoPo.setBgicapacityyxhly(bgicapacityyxhly);
		goodsInfoPo.setBgicapacityentryyxhly(bgicapacityentryyxhly);
		goodsInfoPo.setBgisuppliercolortyj(bgisuppliercolortyj);
		goodsInfoPo.setBgiframesizetyj(bgiframesizetyj);
		goodsInfoPo.setMinSphlhj(minSphlhj);
		goodsInfoPo.setMaxSphlhj(maxSphlhj);
		goodsInfoPo.setBgisuppliercolorlhj(bgisuppliercolorlhj);
		goodsInfoPo.setBgiframesizelhj(bgiframesizelhj);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			goodsInfoPo.setBgicompanyid(personInfoPo.getPersoncompanyid());
		}
		
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		request.setAttribute("whichretail",whichretail);
		
		if(!"".equals(dpo.getBdpwhichretail())&&"1".equals(personInfoPo.getDepartmenttype())){
			goodsInfoPo.setBgiwhichretail(dpo.getBdpwhichretail());
			request.setAttribute("whichretail",dpo.getBdpwhichretail());
		}
		
		String bgiwholesalebeginprice=Utility.getName(request.getParameter("bgiwholesalebeginprice"));
		String bgiwholesaleendprice=Utility.getName(request.getParameter("bgiwholesaleendprice"));
		request.setAttribute("bgiwholesalebeginprice", bgiwholesalebeginprice);
		request.setAttribute("bgiwholesaleendprice", bgiwholesaleendprice);
		
		goodsInfoPo.setBgiwholesalebeginprice(bgiwholesalebeginprice);
		goodsInfoPo.setBgiwholesaleendprice(bgiwholesaleendprice);	
//////////////////////////////////////////////////////////////////////////////////////////////
		request.setAttribute("bgispecs", bgispecs);
		request.setAttribute("bgisuppliercolorjj", bgisuppliercolorjj);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("bgiframematerialtypejj", bgiframematerialtypejj);
		request.setAttribute("technologyTypeIDjj", technologyTypeIDjj);
		request.setAttribute("bgiaccessoriestypepj", bgiaccessoriestypepj);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		request.setAttribute("minbgibelowplusluminosityjp", minbgibelowplusluminosityjp);
		request.setAttribute("maxbgibelowplusluminosityjp", maxbgibelowplusluminosityjp);
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("bgifunctionclassjp", bgifunctionclassjp);
		request.setAttribute("bgigradualclassjp", bgigradualclassjp);
		request.setAttribute("minSphyx", minSphyx);
		request.setAttribute("maxSphyx", maxSphyx);
		request.setAttribute("minCylyx", minCylyx);
		request.setAttribute("maxCylyx", maxCylyx);
		request.setAttribute("bgicurvature1yx", bgicurvature1yx);
		request.setAttribute("bgidiayx", bgidiayx);
		request.setAttribute("bgiusetypeyx", bgiusetypeyx);
		request.setAttribute("bgistealthclassyx", bgistealthclassyx);
		request.setAttribute("bgicapacityyxhly", bgicapacityyxhly);
		request.setAttribute("bgicapacityentryyxhly", bgicapacityentryyxhly);
		request.setAttribute("bgisuppliercolortyj", bgisuppliercolortyj);
		request.setAttribute("bgiframesizetyj", bgiframesizetyj);
		request.setAttribute("minSphlhj", minSphlhj);
		request.setAttribute("maxSphlhj", maxSphlhj);
		request.setAttribute("bgisuppliercolorlhj", bgisuppliercolorlhj);
		request.setAttribute("bgiframesizelhj", bgiframesizelhj);
		request.setAttribute("iscustomizeyx", iscustomizeyx);
		request.setAttribute("iscustomizekj", iscustomizekj);
		request.setAttribute("iscustomize", iscustomize);		
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = windowGoodsMgr.getGoodsInfoCountForSOUT(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsInfoListForSOUT(goodsInfoPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		refractiveSetPos = unitMgr.getRefractiveSetList();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgiretailbeginprice", bgiretailbeginprice);
		request.setAttribute("bgiretailendprice", bgiretailendprice);
		request.setAttribute("iscustomize", iscustomize);
	
//		if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") && !Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0")){
//			goodsInfoPo.setBgigoodscategoryid("no");
//		}	
		goodsCategorys = windowGoodsMgr.getGoodsInfoListForSOUTCategory(goodsInfoPo);
		
		String isShowBarcode = Utility.getName(request.getParameter("isShowBarcode"));
		request.setAttribute("isShowBarcode", isShowBarcode);
		
		return SUCCESS;
	}
	
	/**
	 * 按销采购商品开窗
	 */
	public String initGoodsSingleForSOUTCategory() throws Exception {
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
		
		String app = Utility.getName(request.getParameter("app"));
		request.setAttribute("app", app);
		String jm = Utility.getName(request.getParameter("jm"));
		request.setAttribute("jm", jm);
		
		String bdpdepartmentname=Utility.getName(request.getParameter("bdpdepartmentname"));
		String departmentID=Utility.getName(request.getParameter("departmentID"));
		request.setAttribute("departmentID", departmentID);
		request.setAttribute("bdpdepartmentname", bdpdepartmentname);
		
		String outstockid=Utility.getName(request.getParameter("outstockid"));
		request.setAttribute("outstockid", outstockid);
		
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String brandID = Utility.getName(request.getParameter("brandID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);

		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));

		String indptid = Utility.getName(request.getParameter("indptid"));
		request.setAttribute("indptid", indptid);
		
		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgnDate(startTime);
		po.setEndDate(endTime);
		po.setShopCode(departmentID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBgicompanyid(personInfoPo.getPersoncompanyid());
		}
		
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = windowGoodsMgr.getGoodsInfoListForSOUTCategory(po);
		refractiveSetPos = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("brandID_open", brandID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("iscustomize", iscustomize);

		return SUCCESS;
	}
	
	/**
	 * 按销采购商品开窗
	 */
	/**
	 * @throws Exception
	 */
	public void initGoodsSingleForSOUTSupplier() throws Exception {
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
		
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String supplierID=Utility.getName(request.getParameter("supplierID"));
		String departmentID=Utility.getName(request.getParameter("departmentID"));
		
		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgnDate(startTime);
		po.setEndDate(endTime);
		po.setBgigoodscategoryid(goodscategoryID);
		po.setShopCode(departmentID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBgicompanyid(personInfoPo.getPersoncompanyid());
		}
		
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		if (goodscategoryID.equals("")) {
			out.println("<option value=''>---请选择制造商---</option>");
		} else {
			supplierPos = windowGoodsMgr.getGoodsInfoListForSOUTSupplier(po);
			Iterator it = supplierPos.iterator();
			out.println("<option value=''>---请选择制造商("
					+ supplierPos.size() + ")---</option>");
			if (it.hasNext()) {
				while (it.hasNext()) {
					SupplierPo tmpPo = (SupplierPo) it
							.next();
					if(supplierID.equals(tmpPo.getBspid())){
						out.println("<option value='" + tmpPo.getBspid() + "' selected>" + tmpPo.getBspsuppliername() + "</option>");
					}else{
						out.println("<option value='" + tmpPo.getBspid() + "'>" + tmpPo.getBspsuppliername() + "</option>");
					}
				}
			}
		}
		out.close();
	}
	
	/**
	 * 按销采购商品开窗
	 */
	public void initGoodsSingleForSOUTBrand() throws Exception {
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
		
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String supplierID=Utility.getName(request.getParameter("supplierID"));
		String brandID=Utility.getName(request.getParameter("brandID"));
		String departmentID=Utility.getName(request.getParameter("departmentID"));
		
		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgnDate(startTime);
		po.setEndDate(endTime);
		po.setBgigoodscategoryid(goodscategoryID);
		po.setBgisupplierid(supplierID);
		po.setShopCode(departmentID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBgicompanyid(personInfoPo.getPersoncompanyid());
		}
		
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		if (goodscategoryID.equals("")) {
			out.println("<option value=''>---请选择品种---</option>");
		} else {
			brandPos = windowGoodsMgr.getGoodsInfoListForSOUTBrand(po);
			Iterator it = brandPos.iterator();
			out.println("<option value=''>---请选择品种("
					+ brandPos.size() + ")---</option>");
			if (it.hasNext()) {
				while (it.hasNext()) {
					BrandPo tmpPo = (BrandPo) it.next();
					if(brandID.equals(tmpPo.getBbdid())){
						out.println("<option value='" + tmpPo.getBbdid() + "' selected>" + tmpPo.getBbdbrandname() + "</option>");
					}else{
						out.println("<option value='" + tmpPo.getBbdid() + "'>" + tmpPo.getBbdbrandname() + "</option>");
					}
				}
			}
		}
		out.close();
	}
	
	/**
	 * 初始化按品种退货开窗
	 */
	public String initSelBrandForReturn() throws Exception {
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
		
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
			request.setAttribute("supplierid", supplierPo
					.getBspid());
			request.setAttribute("supplierID_open", supplierPo
							.getBspid());
		}
		String insertorupdate = Utility.getName(request.getParameter("insertorupdate"));
		request.setAttribute("insertorupdate", insertorupdate);
		
		return SUCCESS;
	}

	/**
	 * 按品种退货开窗
	 */
	public String selBrandForReturn() throws Exception {
		
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
		
		String supplierid =Utility.getName(request.getParameter("supplierid"));
		String brandid = Utility.getName(request.getParameter("brandid"));
		String brandname =Utility.getName(request.getParameter("brandname"));

		BrandPo brandPo = new BrandPo();
		brandPo.setBbdbrandname(brandname);
		brandPo.setBbdid(brandid);
		brandPo.setBbdsupplierid(supplierid);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getBrandCountForReturn(brandPo);
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
			brandlist = windowGoodsMgr.getBrandListForReturn(brandPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			brandlist = null;
		}
		

		if (!"".equals(Utility.getName(supplierid))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierid);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
			request.setAttribute("supplierid", supplierPo
					.getBspid());
			request.setAttribute("supplierID_open", supplierPo
							.getBspid());
		}
		
		request.setAttribute("brandid",brandid);
		request.setAttribute("brandname",brandname);
		
		String insertorupdate = Utility.getName(request.getParameter("insertorupdate"));
		request.setAttribute("insertorupdate", insertorupdate);
		
		return SUCCESS;
	}
	/**
	 * 初始化报表单品商品查询
	 */
	public String initGoodsReportSel() throws Exception {
		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String technologyTypeID=Utility.getName(request.getParameter("technologyTypeID_open"));
		
		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo
					.getBspsuppliername());
		}
		technologyType = varietyMgr.getTechnologyType();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("technologyTypeID_open", technologyTypeID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("iscustomize", iscustomize);
		
		
		return SUCCESS;
	}
	
	/**
	 * 报表价查询单品商品
	 */
	public String selGoodsReport() throws Exception {

		String iscustomize=Utility.getName(request.getParameter("iscustomize"));
		String iscustomizeyx=Utility.getName(request.getParameter("iscustomizeyx"));
		String iscustomizekj=Utility.getName(request.getParameter("iscustomizekj"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String bgicostbeginprice=Utility.getName(request.getParameter("bgicostbeginprice"));
		String bgicostendprice=Utility.getName(request.getParameter("bgicostendprice"));
		String goodscode = Utility.getName(request.getParameter("goodscode"));
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		String bgisuppliercolorjj=Utility.getName(request.getParameter("bgisuppliercolorjj"));
		String bgiframesizejj=Utility.getName(request.getParameter("bgiframesizejj"));
		String bgiframematerialtypejj=Utility.getName(request.getParameter("bgiframematerialtypejj"));
		String technologyTypeIDjj=Utility.getName(request.getParameter("technologyTypeIDjj"));
		String bgiaccessoriestypepj=Utility.getName(request.getParameter("bgiaccessoriestypepj"));
		String minSphjp=Utility.getName(request.getParameter("minSphjp"));
		String maxSphjp=Utility.getName(request.getParameter("maxSphjp"));
		String minCyljp=Utility.getName(request.getParameter("minCyljp"));
		String maxCyljp=Utility.getName(request.getParameter("maxCyljp"));
		String minbgibelowplusluminosityjp=Utility.getName(request.getParameter("minbgibelowplusluminosityjp"));
		String maxbgibelowplusluminosityjp=Utility.getName(request.getParameter("maxbgibelowplusluminosityjp"));
		String bgieyeglassmaterialtypejp=Utility.getName(request.getParameter("bgieyeglassmaterialtypejp"));
		String bgirefractivejp=Utility.getName(request.getParameter("bgirefractivejp"));
		String bgiismutiluminosityjp=Utility.getName(request.getParameter("bgiismutiluminosityjp"));
		String bgifunctionclassjp=Utility.getName(request.getParameter("bgifunctionclassjp"));
		String bgigradualclassjp=Utility.getName(request.getParameter("bgigradualclassjp"));
		String minSphyx=Utility.getName(request.getParameter("minSphyx"));
		String maxSphyx=Utility.getName(request.getParameter("maxSphyx"));
		String minCylyx=Utility.getName(request.getParameter("minCylyx"));
		String maxCylyx=Utility.getName(request.getParameter("maxCylyx"));
		String bgicurvature1yx=Utility.getName(request.getParameter("bgicurvature1yx"));
		String bgidiayx=Utility.getName(request.getParameter("bgidiayx"));
		String bgiusetypeyx=Utility.getName(request.getParameter("bgiusetypeyx"));
		String bgistealthclassyx=Utility.getName(request.getParameter("bgistealthclassyx"));
		String bgicapacityyxhly=Utility.getName(request.getParameter("bgicapacityyxhly"));
		String bgicapacityentryyxhly=Utility.getName(request.getParameter("bgicapacityentryyxhly"));
		String bgisuppliercolortyj=Utility.getName(request.getParameter("bgisuppliercolortyj"));
		String bgiframesizetyj=Utility.getName(request.getParameter("bgiframesizetyj"));
		String minSphlhj=Utility.getName(request.getParameter("minSphlhj"));
		String maxSphlhj=Utility.getName(request.getParameter("maxSphlhj"));
		String bgisuppliercolorlhj=Utility.getName(request.getParameter("bgisuppliercolorlhj"));
		String bgiframesizelhj=Utility.getName(request.getParameter("bgiframesizelhj"));
		String bgispecs=Utility.getName(request.getParameter("bgispecs"));
		request.setAttribute("supplierName", supplierName);
		if ("".equals(goodscategoryID)) {
			goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
			request.setAttribute("categoryID_open", goodscategoryID);
		}
		
		request.setAttribute("iscustomizeyx", iscustomizeyx);
		request.setAttribute("iscustomizekj", iscustomizekj);
		request.setAttribute("iscustomize", iscustomize);
		
		if ("".equals(supplierID)) {
			supplierID = Utility.getName(request.getParameter("supplierID_open"));
			
			if (!"".equals(Utility.getName(supplierID))) {
				SupplierPo supplierPo = new SupplierPo();
				supplierPo.setBspid(supplierID);
				supplierPo = supplierMgr.getSupplier(supplierPo);
				request.setAttribute("supplierName", supplierPo.getBspsuppliername());
			}
			request.setAttribute("supplierID_open", supplierID);
		}
		String goodscodes=null;
		if (!"".equals(goodscode)) 
		{
			if(goodscode.length()>18)
			{
				 goodscodes=goodscode.substring(0,18);
			}else
			{
				 goodscodes=goodscode;
			}
		}
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();

		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgigoodscategoryid(goodscategoryID);
		goodsInfoPo.setBgisupplierid(supplierID);
		goodsInfoPo.setBgibrandid(brandID);
		goodsInfoPo.setBgicostbeginprice(bgicostbeginprice);
		goodsInfoPo.setBgicostendprice(bgicostendprice);
		goodsInfoPo.setBgipcbarcode(goodscodes);
		goodsInfoPo.setBgibrandname(brandName);
		if("3".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizekj)){
			goodsInfoPo.setBgiiscustomize(iscustomizekj);
		}else if("4".equalsIgnoreCase(goodscategoryID)&&!"".equalsIgnoreCase(iscustomizeyx)){
			goodsInfoPo.setBgiiscustomize(iscustomizeyx);
		}else{
			goodsInfoPo.setBgiiscustomize(iscustomize);
		}
////////////////////////////////////////////////////////////////////////////////////////		
		goodsInfoPo.setBgispec(bgispecs); 
		goodsInfoPo.setBgisuppliercolorjj(bgisuppliercolorjj);
		goodsInfoPo.setBgiframesizejj(bgiframesizejj);
		goodsInfoPo.setBgiframematerialtypejj(bgiframematerialtypejj);
		goodsInfoPo.setTechnologyTypeIDjj(technologyTypeIDjj);
		goodsInfoPo.setBgiaccessoriestypepj(bgiaccessoriestypepj);
		goodsInfoPo.setMinSphjp(minSphjp);
		goodsInfoPo.setMaxSphjp(maxSphjp);
		goodsInfoPo.setMinCyljp(minCyljp);
		goodsInfoPo.setMaxCyljp(maxCyljp);
		goodsInfoPo.setMinbgibelowplusluminosityjp(minbgibelowplusluminosityjp);
		goodsInfoPo.setMaxbgibelowplusluminosityjp(maxbgibelowplusluminosityjp);
		goodsInfoPo.setBgieyeglassmaterialtypejp(bgieyeglassmaterialtypejp);
		goodsInfoPo.setBgirefractivejp(bgirefractivejp);
		goodsInfoPo.setBgiismutiluminosityjp(bgiismutiluminosityjp);
		goodsInfoPo.setBgifunctionclassjp(bgifunctionclassjp);
		goodsInfoPo.setBgigradualclassjp(bgigradualclassjp);
		goodsInfoPo.setMinSphyx(minSphyx);
		goodsInfoPo.setMaxSphyx(maxSphyx);
		goodsInfoPo.setMinCylyx(minCylyx);
		goodsInfoPo.setMaxCylyx(maxCylyx);
		goodsInfoPo.setBgicurvature1yx(bgicurvature1yx);
		goodsInfoPo.setBgidiayx(bgidiayx);
		goodsInfoPo.setBgiusetypeyx(bgiusetypeyx);
		goodsInfoPo.setBgistealthclassyx(bgistealthclassyx);
		goodsInfoPo.setBgicapacityyxhly(bgicapacityyxhly);
		goodsInfoPo.setBgicapacityentryyxhly(bgicapacityentryyxhly);
		goodsInfoPo.setBgisuppliercolortyj(bgisuppliercolortyj);
		goodsInfoPo.setBgiframesizetyj(bgiframesizetyj);
		goodsInfoPo.setMinSphlhj(minSphlhj);
		goodsInfoPo.setMaxSphlhj(maxSphlhj);
		goodsInfoPo.setBgisuppliercolorlhj(bgisuppliercolorlhj);
		goodsInfoPo.setBgiframesizelhj(bgiframesizelhj);
//////////////////////////////////////////////////////////////////////////////////////////////
		request.setAttribute("bgispecs", bgispecs);
		request.setAttribute("bgisuppliercolorjj", bgisuppliercolorjj);
		request.setAttribute("bgiframesizejj", bgiframesizejj);
		request.setAttribute("bgiframematerialtypejj", bgiframematerialtypejj);
		request.setAttribute("technologyTypeIDjj", technologyTypeIDjj);
		request.setAttribute("bgiaccessoriestypepj", bgiaccessoriestypepj);
		request.setAttribute("minSphjp", minSphjp);
		request.setAttribute("maxSphjp", maxSphjp);
		request.setAttribute("minCyljp", minCyljp);
		request.setAttribute("maxCyljp", maxCyljp);
		request.setAttribute("minbgibelowplusluminosityjp", minbgibelowplusluminosityjp);
		request.setAttribute("maxbgibelowplusluminosityjp", maxbgibelowplusluminosityjp);
		request.setAttribute("bgieyeglassmaterialtypejp", bgieyeglassmaterialtypejp);
		request.setAttribute("bgirefractivejp", bgirefractivejp);
		request.setAttribute("bgiismutiluminosityjp", bgiismutiluminosityjp);
		request.setAttribute("bgifunctionclassjp", bgifunctionclassjp);
		request.setAttribute("bgigradualclassjp", bgigradualclassjp);
		request.setAttribute("minSphyx", minSphyx);
		request.setAttribute("maxSphyx", maxSphyx);
		request.setAttribute("minCylyx", minCylyx);
		request.setAttribute("maxCylyx", maxCylyx);
		request.setAttribute("bgicurvature1yx", bgicurvature1yx);
		request.setAttribute("bgidiayx", bgidiayx);
		request.setAttribute("bgiusetypeyx", bgiusetypeyx);
		request.setAttribute("bgistealthclassyx", bgistealthclassyx);
		request.setAttribute("bgicapacityyxhly", bgicapacityyxhly);
		request.setAttribute("bgicapacityentryyxhly", bgicapacityentryyxhly);
		request.setAttribute("bgisuppliercolortyj", bgisuppliercolortyj);
		request.setAttribute("bgiframesizetyj", bgiframesizetyj);
		request.setAttribute("minSphlhj", minSphlhj);
		request.setAttribute("maxSphlhj", maxSphlhj);
		request.setAttribute("bgisuppliercolorlhj", bgisuppliercolorlhj);
		request.setAttribute("bgiframesizelhj", bgiframesizelhj);

		
		
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = windowGoodsMgr.getGoodsSingleCount(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = windowGoodsMgr.getGoodsSingleList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		refractiveSetPos = unitMgr.getRefractiveSetList();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		frameMateriallist = frameMaterialMgr.getFrameMaterialList();	
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodscode", goodscode);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandID", brandID);
		request.setAttribute("bgicostbeginprice", bgicostbeginprice);
		request.setAttribute("bgicostendprice", bgicostendprice);
		request.setAttribute("iscustomize", iscustomize);
		request.setAttribute("brandName", brandName);
	
		
		return SUCCESS;
	}
	/**
	 * 初始化单品商品查询(调拨商品)
	 */
	public String initAllocationGoods() throws Exception {
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
		
		//取得登陆人允许操作的仓位&部门 Begin		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		departmentsList = departmentsMgr.getDepartments(deppo);	
		
		if (departmentsList == null){
			departmentsList = new ArrayList<DepartmentsPo>();
		}
		
		String masterFlag = "2";
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			masterFlag = "1";
		}
		List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments(masterFlag);
		for (DepartmentsPo dpo : dList){
			departmentsList.add(dpo);
		}
		
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		request.setAttribute("categoryID_open", goodscategoryID);
		
		String dptID = Utility.getName(request.getParameter("dptID"));
		request.setAttribute("dptID", dptID);
		request.setAttribute("allflag", Utility.getName(request.getParameter("allflag")));
		request.setAttribute("supplierID_open", Utility.getName(request.getParameter("supplierID_open")));
		
		return SUCCESS;
	}
	/**
	 * 查询单品商品查询(调拨商品)
	 */
	public String selAllocationGoods() throws Exception {
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
		
		//取得登陆人允许操作的仓位&部门 Begin		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		
		departmentsList = departmentsMgr.getDepartments(deppo);
		
		if (departmentsList == null){
			departmentsList = new ArrayList<DepartmentsPo>();
		}
		
		String masterFlag = "2";
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			masterFlag = "1";
		}
		List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments(masterFlag);
		for (DepartmentsPo dpo : dList){
			departmentsList.add(dpo);
		}

		String billID=Utility.getName(request.getParameter("billID"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));
		String dptID = Utility.getName(request.getParameter("dptID"));
		request.setAttribute("dptID", dptID);

		String allflag = Utility.getName(request.getParameter("allflag"));
		request.setAttribute("allflag", allflag);
		
		String supplierID_open = Utility.getName(request.getParameter("supplierID_open"));
		request.setAttribute("supplierID_open",supplierID_open);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		AllocationPo allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaindepartmentid(departmentID);
		allocationPo.setCshaastartTime(startTime1);
		allocationPo.setCshaaendTime(endTime1);
		allocationPo.setGoodscategoryid(goodscategoryID);
		allocationPo.setChaasupplier(supplierID_open);
		allocationPo.setCshaaauditperson(auditPersonID);
		allocationPo.setCshaaoutdepartmentid(dptID);
		allocationPo.setCshaaflag(allflag);
		allocationPo.setCshaaindptcompanyid(personInfoPo.getPersoncompanyid());
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = windowGoodsMgr.getGoodsSingleAllCountss(allocationPo);
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
			allocationList = windowGoodsMgr.getGoodsSingleAllListss(allocationPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();//quyanping
		
		request.setAttribute("billID",billID);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("startTime1",startTime1);
		request.setAttribute("endTime1",endTime1);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("auditPersonID", auditPersonID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		
		return SUCCESS;
	}
	
	/**
	 * 多选按品种开窗
	 */
	public String selManyBrandOpen() throws Exception {
				
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String brandName = Utility.getName(request.getParameter("brandName"));		
		
		BrandPo brandPo=new BrandPo();
		brandPo.setBspcategoryid(goodscategoryID);
		brandPo.setBbdsupplierid(supplierID);
		brandPo.setBbdid(brandID);
		
		int count = windowGoodsMgr.getManyBrandPriceCountOpen(brandPo);

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

			brandlist = windowGoodsMgr.getManyBrandPriceOpenList(brandPo, page.getStart(), page
					.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}		
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);		

		return SUCCESS;
	}
	
	/**
	 * 初始化商品下传查询
	 */
	public String downloadGoodsSingleSel() throws Exception {
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
		
		String categoryid=  Utility.getName(request.getParameter("categoryid"));
		String supperid=  Utility.getName(request.getParameter("supperid"));
		String brandid=  Utility.getName(request.getParameter("brandid"));
		String goodsID=  Utility.getName(request.getParameter("goodsID"));
		String goodsName=  Utility.getName(request.getParameter("goodsName"));
		String bgisupplierspec=  Utility.getName(request.getParameter("bgisupplierspec"));
		String bgisuppliercolor=  Utility.getName(request.getParameter("bgisuppliercolor"));
		
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgigoodscategoryid(categoryid);
		goodsInfoPo.setBgisupplierid(supperid);
		goodsInfoPo.setBgibrandid(brandid);
		goodsInfoPo.setBgigoodsid(goodsID);
		goodsInfoPo.setBgigoodsname(goodsName);
		goodsInfoPo.setBgisupplierspec(bgisupplierspec);
		goodsInfoPo.setBgisuppliercolor(bgisuppliercolor);
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = downloadRegionMgr.noGetDownloadGoodsInfoCount(goodsInfoPo);
		if (count > 0) {
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
			Pagination page = new Pagination(request, count, perPage);
			goodsList = downloadRegionMgr.noGetDownloadGoodsInfoList(goodsInfoPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		
		if (!"".equals(Utility.getName(supperid))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supperid);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo.getBspsuppliername());
		}
		
		if (!"".equals(Utility.getName(brandid))) {
			BrandPo brandPo = new BrandPo();
			brandPo.setBbdid(brandid);
			brandPo.setBbdsupplierid(supperid);
			brandPo = brandMgr.getBrandPo(brandPo);
			request.setAttribute("brandName", brandPo.getBbdbrandname());
		}
		
		request.setAttribute("categoryid", categoryid);
		request.setAttribute("supperid", supperid);
		request.setAttribute("brandid", brandid);
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("bgisupplierspec", bgisupplierspec);
		request.setAttribute("bgisuppliercolor", bgisuppliercolor);
		return SUCCESS;
	}
	
	public List<BrandPo> getBrandlist() {
		return brandlist;
	}

	public void setBrandlist(List<BrandPo> brandlist) {
		this.brandlist = brandlist;
	}

	public List<FrameMaterialPo> getFrameMateriallist() {
		return frameMateriallist;
	}

	public void setFrameMateriallist(List<FrameMaterialPo> frameMateriallist) {
		this.frameMateriallist = frameMateriallist;
	}

	public FrameMaterialMgr getFrameMaterialMgr() {
		return frameMaterialMgr;
	}

	public void setFrameMaterialMgr(FrameMaterialMgr frameMaterialMgr) {
		this.frameMaterialMgr = frameMaterialMgr;
	}
	public List<SupplierPo> getSupplierPos() {
		return supplierPos;
	}

	public void setSupplierPos(List<SupplierPo> supplierPos) {
		this.supplierPos = supplierPos;
	}

	public List<BrandPo> getBrandPos() {
		return brandPos;
	}

	public void setBrandPos(List<BrandPo> brandPos) {
		this.brandPos = brandPos;
	}

	public GlassesFrameMgr getGlassesFrameMgr() {
		return glassesFrameMgr;
	}

	public void setGlassesFrameMgr(GlassesFrameMgr glassesFrameMgr) {
		this.glassesFrameMgr = glassesFrameMgr;
	}

	public List<GoodsInfoPo> getGlassesFrameList() {
		return glassesFrameList;
	}

	public void setGlassesFrameList(List<GoodsInfoPo> glassesFrameList) {
		this.glassesFrameList = glassesFrameList;
	}
	public List<RefractiveSetPo> getRefractiveSetPos() {
		return refractiveSetPos;
	}

	public void setRefractiveSetPos(List<RefractiveSetPo> refractiveSetPos) {
		this.refractiveSetPos = refractiveSetPos;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
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
	
	public List<GoodsDetailsInfoPo> getGoodsDetailsList() {
		return goodsDetailsList;
	}
	public void setGoodsDetailsList(List<GoodsDetailsInfoPo> goodsDetailsList) {
		this.goodsDetailsList = goodsDetailsList;
	}
	public StockSearchMgr getStockSearchMgr() {
		return stockSearchMgr;
	}
	public void setStockSearchMgr(StockSearchMgr stockSearchMgr) {
		this.stockSearchMgr = stockSearchMgr;
	}
	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}
	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
	}
	public List<InventoryPo> getProcurementReceiptList() {
		return procurementReceiptList;
	}
	public void setProcurementReceiptList(List<InventoryPo> procurementReceiptList) {
		this.procurementReceiptList = procurementReceiptList;
	}	
	public GoodsInfoPo getGoodsInfoPo() {
		return goodsInfoPo;
	}
	public void setGoodsInfoPo(GoodsInfoPo goodsInfoPo) {
		this.goodsInfoPo = goodsInfoPo;
	}
	public List<GoodsInfoPo> getGoodsInfoList() {
		return goodsInfoList;
	}
	public void setGoodsInfoList(List<GoodsInfoPo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}
	public List<AllocationPo> getAllocationList() {
		return allocationList;
	}
	public void setAllocationList(List<AllocationPo> allocationList) {
		this.allocationList = allocationList;
	}	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}	
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}
	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}
	public List<GoodsInfoPo> getGoodsNumberList() {
		return goodsNumberList;
	}
	public void setGoodsNumberList(List<GoodsInfoPo> goodsNumberList) {
		this.goodsNumberList = goodsNumberList;
	}
	public BrandMgr getBrandMgr() {
		return brandMgr;
	}
	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}
	public WindowGoodsMgr getWindowGoodsMgr() {
		return windowGoodsMgr;
	}
	public void setWindowGoodsMgr(WindowGoodsMgr windowGoodsMgr) {
		this.windowGoodsMgr = windowGoodsMgr;
	}
	public DownloadRegionMgr getDownloadRegionMgr() {
		return downloadRegionMgr;
	}
	public void setDownloadRegionMgr(DownloadRegionMgr downloadRegionMgr) {
		this.downloadRegionMgr = downloadRegionMgr;
	}		
}
