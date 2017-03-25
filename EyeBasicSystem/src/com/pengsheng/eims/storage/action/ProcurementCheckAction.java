package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.dao.impl.TechnologyTypePo;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
import com.pengsheng.eims.components.mgr.WindowGoodsMgr;
import com.pengsheng.eims.storage.mgr.ProcurementCheckMgr;
import com.pengsheng.eims.storage.mgr.ProcurementReceiptMgr;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.ProcurementCheckEntryPo;
import com.pengsheng.eims.storage.persistence.ProcurementCheckPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersEntryPo;
import com.pengsheng.eims.storage.persistence.StatusPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ProcurementCheckAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	
	private SupplierMgr supplierMgr;
	
	private VarietyMgr varietyMgr;
	
	private List<GoodsCategoryPo> goodsCategorys;
	
	private List<TechnologyTypePo> technologyType;
	
	private List<GoodsInfoPo> goodsList;
	
	private List<DepartmentsPo> departmentsList;
	
	private DepartmentsMgr departmentsMgr;
	
	private WindowGoodsMgr windowGoodsMgr;
	
	private List<InventoryPo> procurementReceiptList;
	
	private List<ProcurementCheckPo> procurementCheckPos;
	
	private ProcurementCheckMgr procurementCheckMgr;
	
	private ProcurementCheckPo procurementCheckPo;
	
	private ProcurementCheckEntryPo procurementCheckEntryPo;
	
	private InventoryPo inventoryPo;
	
	private ProcurementReceiptMgr procurementReceiptMgr;
	
	private List<InventoryEntryPo> inventoryEntryList;
	
private SystemParameterMgr systemParameterMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private String isFirstExec;
	
	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}
	
	
	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	
	
	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}



	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}



	public ProcurementReceiptMgr getProcurementReceiptMgr() {
		return procurementReceiptMgr;
	}



	public void setProcurementReceiptMgr(ProcurementReceiptMgr procurementReceiptMgr) {
		this.procurementReceiptMgr = procurementReceiptMgr;
	}



	public List<InventoryEntryPo> getInventoryEntryList() {
		return inventoryEntryList;
	}



	public void setInventoryEntryList(List<InventoryEntryPo> inventoryEntryList) {
		this.inventoryEntryList = inventoryEntryList;
	}



	public ProcurementCheckEntryPo getProcurementCheckEntryPo() {
		return procurementCheckEntryPo;
	}



	public void setProcurementCheckEntryPo(
			ProcurementCheckEntryPo procurementCheckEntryPo) {
		this.procurementCheckEntryPo = procurementCheckEntryPo;
	}



	public ProcurementCheckPo getProcurementCheckPo() {
		return procurementCheckPo;
	}



	public void setProcurementCheckPo(ProcurementCheckPo procurementCheckPo) {
		this.procurementCheckPo = procurementCheckPo;
	}



	public ProcurementCheckMgr getProcurementCheckMgr() {
		return procurementCheckMgr;
	}



	public void setProcurementCheckMgr(ProcurementCheckMgr procurementCheckMgr) {
		this.procurementCheckMgr = procurementCheckMgr;
	}



	public List<ProcurementCheckPo> getProcurementCheckPos() {
		return procurementCheckPos;
	}



	public void setProcurementCheckPos(List<ProcurementCheckPo> procurementCheckPos) {
		this.procurementCheckPos = procurementCheckPos;
	}



	public List<GoodsInfoPo> getGoodsList() {
		return goodsList;
	}



	public void setGoodsList(List<GoodsInfoPo> goodsList) {
		this.goodsList = goodsList;
	}



	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}



	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}



	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}



	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}



	public WindowGoodsMgr getWindowGoodsMgr() {
		return windowGoodsMgr;
	}



	public void setWindowGoodsMgr(WindowGoodsMgr windowGoodsMgr) {
		this.windowGoodsMgr = windowGoodsMgr;
	}



	public List<InventoryPo> getProcurementReceiptList() {
		return procurementReceiptList;
	}



	public void setProcurementReceiptList(List<InventoryPo> procurementReceiptList) {
		this.procurementReceiptList = procurementReceiptList;
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



	public List<TechnologyTypePo> getTechnologyType() {
		return technologyType;
	}



	public void setTechnologyType(List<TechnologyTypePo> technologyType) {
		this.technologyType = technologyType;
	}



	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}



	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}



	/**
	 * 初始化收货检验查询页面
	 * @return
	 */
	public String initProcurementCheckSelect(){
		
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
			return "procurementCheckSelect";
		}
		return SUCCESS;
	}
	
	
	/**
	 * 初始化收货检验新增页面
	 * @return
	 */
	public String initProcurementCheckGlassInsert(){
		
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
		
		String billID="RCK"+GenerateNumber.getInstance().getGenerageNumber();
		
		request.setAttribute("billID", billID);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化收货检验新增页面
	 * @return
	 */
	public String initProcurementCheckUnGlassInsert(){
		
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
		
		String billID="RCK"+GenerateNumber.getInstance().getGenerageNumber();
		
		request.setAttribute("billID", billID);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 初始化单品收货商品查询
	 */
	public String initProcurementCheckReceiptBillSelect() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		//取得登陆人允许操作的仓位&部门 Begin
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");	
		
		String goodscategoryID = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID = Utility.getName(request.getParameter("supplierID_open"));
		String type = Utility.getName(request.getParameter("type"));

		if (!"".equals(Utility.getName(supplierID))) {
			SupplierPo supplierPo = new SupplierPo();
			supplierPo.setBspid(supplierID);
			supplierPo = supplierMgr.getSupplier(supplierPo);
			request.setAttribute("supplierName", supplierPo.getBspsuppliername());
		}
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();
		request.setAttribute("categoryID_open", goodscategoryID);
		request.setAttribute("supplierID_open", supplierID);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("type", type);

		return SUCCESS;
	}
	
	
	/**
	 * 收货检验镜片类选择收货单
	 * @return
	 * @throws Exception
	 */
	public String procurementCheckReceiptBillSelect() throws Exception { 
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
		
	
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);		

		String billID=Utility.getName(request.getParameter("billID"));
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));
		String type = Utility.getName(request.getParameter("type"));

		InventoryPo po = new InventoryPo();
		po.setCstibillid(billID);
		po.setCstiauditdate("1");
		po.setCstiauditstartdate(startTime1);
		po.setCstiauditenddate(endTime1);
		po.setCstigoodscategory(goodscategoryID);
		po.setCstisupplierid(supplierID);
		po.setCstiauditperson(auditPersonID);
		
		int count ;
		if("j".equals(type)){
			count = procurementCheckMgr.getProcurementCheckReceiptGlassCount(po);
		}else{
			count = procurementCheckMgr.getProcurementCheckReceiptCount(po);
		}
		if (count > 0) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
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
			if("j".equals(type)){
				procurementReceiptList = procurementCheckMgr.getProcurementCheckGlassReceiptList(po, page.getStart(), page.getPageSize());
			}else{
				procurementReceiptList = procurementCheckMgr.getProcurementCheckReceiptList(po, page.getStart(), page.getPageSize());
			}
			
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		technologyType=varietyMgr.getTechnologyType();
		
		request.setAttribute("startTime1",startTime1);
		request.setAttribute("endTime1",endTime1);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("auditPersonID", auditPersonID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("type", type);
		request.setAttribute("billID",request.getParameter("billID"));
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));
		
		return SUCCESS;

	}
	
	
	
	
	/**
	 * 收货检验镜片类选择收货单
	 * @return
	 * @throws Exception
	 */
	public String procurementCheckReceiptBillChange() throws Exception { 
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
		/** ********************** 权限设置  ***************************** */
		
		String sourcebillID = Utility.getName(request.getParameter("billID"));
		
		ProcurementCheckPo po = new ProcurementCheckPo();
		
		po.setCstpoebillsource(sourcebillID);
		
		
		procurementCheckPos = procurementCheckMgr.getProcurementCheckReceiptList(po);
		
		procurementCheckPos.get(0).setCstpoebillid(procurementCheckPo.getCstpoebillid());
		
		String billID=request.getParameter("procurementCheckPo.cstpoebillid");
		
		request.setAttribute("billID", billID);
		

		return SUCCESS;

	}
	
	/**
	 * 收货检验非镜片类选择收货单
	 * @return
	 * @throws Exception
	 */
	public String procurementCheckUnReceiptBillChange() throws Exception { 
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
		/** ********************** 权限设置  ***************************** */
		
		String sourcebillID = Utility.getName(request.getParameter("billID"));
		
		ProcurementCheckPo po = new ProcurementCheckPo();
		
		po.setCstpoebillsource(sourcebillID);
		
		
		procurementCheckPos = procurementCheckMgr.getProcurementCheckReceiptList(po);
		
		//procurementCheckPos.get(0).setCstpoebillid(procurementCheckPo.getCstpoebillid());
		
		String billID=request.getParameter("procurementCheckPo.cstpoebillid");
		
		request.setAttribute("billID", billID);
		

		return SUCCESS;

	}
	
	/**
	 * 收货检验选择收货单
	 * @return
	 * @throws Exception
	 */
	public String procurementCheckGlassInsert() throws Exception { 
		
		List<ProcurementCheckPo> pos =  new ArrayList<ProcurementCheckPo>();
		
		int size = procurementCheckEntryPo.getCstpoegoodsids().length;
		
		for(int i = 0; i < size; i++){
			ProcurementCheckPo po = new ProcurementCheckPo();
			po.setCstpoebillid(Utility.getName(procurementCheckPo.getCstpoebillid()));
			po.setCstpoegoodsid(Utility.getName(procurementCheckEntryPo.getCstpoegoodsids()[i]));
			po.setCstpoeordergoodsquantity(Utility.getName(procurementCheckEntryPo.getCstpoeordergoodsquantitys()[i]));
			po.setCstpoegoodsquantity(Utility.getName(procurementCheckEntryPo.getCstpoegoodsquantitys()[i]));
//			po.setCstpoecoincidencerate(Utility.getName(procurementCheckEntryPo.getCstpoecoincidencerates()[i]));
			po.setCstpoepack(Utility.getName(procurementCheckEntryPo.getCstpoepacks()[i]));
			po.setCstpoeapp(Utility.getName(procurementCheckEntryPo.getCstpoeapps()[i]));
			po.setCstpoeunqualifiedquantity(Utility.getName(procurementCheckEntryPo.getCstpoeunqualifiedquantitys()[i]));
			po.setCstpoeunqualifiedrate(Utility.getName(procurementCheckEntryPo.getCstpoeunqualifiedrates()[i]));
			po.setCstpoebluminosity(Utility.getName(procurementCheckEntryPo.getCstpoebluminositys()[i]));
			po.setCstpoesluminosity(Utility.getName(procurementCheckEntryPo.getCstpoesluminositys()[i]));
			po.setCstpoethickness(Utility.getName(procurementCheckEntryPo.getCstpoethicknesss()[i]));
			pos.add(po);
		}
		
		procurementCheckMgr.insertProcurementCheck(procurementCheckPo,pos);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;

	}
	
	
	/**
	 * 收货检验选择收货单
	 * @return
	 * @throws Exception
	 */
	public String procurementCheckUnGlassInsert() throws Exception { 
		
		List<ProcurementCheckPo> pos =  new ArrayList<ProcurementCheckPo>();
		
		int size = procurementCheckEntryPo.getCstpoegoodsids().length;
		
		for(int i = 0; i < size; i++){
			ProcurementCheckPo po = new ProcurementCheckPo();
			po.setCstpoebillid(Utility.getName(procurementCheckPo.getCstpoebillid()));
			po.setCstpoegoodsid(Utility.getName(procurementCheckEntryPo.getCstpoegoodsids()[i]));
			po.setCstpoeordergoodsquantity(Utility.getName(procurementCheckEntryPo.getCstpoeordergoodsquantitys()[i]));
			po.setCstpoegoodsquantity(Utility.getName(procurementCheckEntryPo.getCstpoegoodsquantitys()[i]));
			po.setCstpoecoincidencerate(Utility.getName(procurementCheckEntryPo.getCstpoecoincidencerates()[i]));
			po.setCstpoepack(Utility.getName(procurementCheckEntryPo.getCstpoepacks()[i]));
			po.setCstpoeapp(Utility.getName(procurementCheckEntryPo.getCstpoeapps()[i]));
			po.setCstpoeunqualifiedquantity(Utility.getName(procurementCheckEntryPo.getCstpoeunqualifiedquantitys()[i]));
			po.setCstpoeunqualifiedrate(Utility.getName(procurementCheckEntryPo.getCstpoeunqualifiedrates()[i]));
//			po.setCstpoebluminosity(Utility.getName(procurementCheckEntryPo.getCstpoebluminositys()[i]));
//			po.setCstpoesluminosity(Utility.getName(procurementCheckEntryPo.getCstpoesluminositys()[i]));
//			po.setCstpoethickness(Utility.getName(procurementCheckEntryPo.getCstpoethicknesss()[i]));
			pos.add(po);
		}
		
		procurementCheckMgr.insertProcurementCheck(procurementCheckPo,pos);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;

	}
	
	
	/**
	 * 收货检验单查询
	 * @return
	 * @throws Exception
	 */
	public String procurementCheckSelect() throws Exception { 
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
		
	
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);		

		String billID=Utility.getName(request.getParameter("billID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String createPersonName = Utility.getName(request.getParameter("createPersonName"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String billtype = Utility.getName(request.getParameter("billtype"));
		
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		request.setAttribute("goodsName", goodsName);
		
		ProcurementCheckPo po = new ProcurementCheckPo();
		po.setCstpoebillid(billID);
		po.setCstpoebegintime(startTime);
		po.setCstpoeendtime(endTime);
		po.setCstpoesupplierid(supplierID);
		po.setCstpoechecker(createPersonID);
		po.setCstpoebilltype(billtype);
		po.setCstpoegoodsname(goodsName);
		
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
		
		int count = procurementCheckMgr.getProcurementCheckCount(po);
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
			procurementCheckPos = procurementCheckMgr.getProcurementCheckList(po, page.getStart(), page.getPageSize());
			
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			procurementCheckPos = null;
		}
		
		request.setAttribute("billID",billID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("billtype", billtype);
		request.setAttribute("createPersonID", createPersonID);
		
		
		return SUCCESS;

	}
	
	
	/**
	 * 收货检验详细
	 * @return
	 * @throws Exception
	 */
	public String procurementCheckDetails() throws Exception { 
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

		String billID=Utility.getName(request.getParameter("billID"));
		String billtype=Utility.getName(request.getParameter("billtype"));
		
		ProcurementCheckPo po = new ProcurementCheckPo();
		po.setCstpoebillid(billID);
		
		procurementCheckPo = procurementCheckMgr.getProcurementCheckDetailsByPin(po);
		
		procurementCheckPos = procurementCheckMgr.getProcurementCheckDetails(po);
		
		if("1".equals(billtype)){
			return SUCCESS;
		}else{
			return "unglass";
		}

	}
	
	/**
	 * 采购收货详细
	 */
	public String procurementCheckReceiptDetails() throws Exception {

		String id = Utility.getName(request.getParameter("hid"));
		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);
		inventoryPo = procurementReceiptMgr.getProcurementReceipt(po);
		inventoryEntryList = procurementReceiptMgr
				.getProcurementReceiptEntryList(po);
		
		StatusPo spo = new StatusPo();
		
		spo.setCshastatusreceiptid(Utility.getName(request.getParameter("hid")));
		
		return SUCCESS;
	}
	
	
	
}
