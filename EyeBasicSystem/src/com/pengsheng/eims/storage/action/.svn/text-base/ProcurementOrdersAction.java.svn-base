package com.pengsheng.eims.storage.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.storage.mgr.AllocationApplyForAppMgr;
import com.pengsheng.eims.storage.mgr.AllocationApplyMgr;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.mgr.ProcurementOrdersMgr;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersEntryPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
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

public class ProcurementOrdersAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;	
	private AllocationApplyMgr allocationApplyMgr;
	private ProcurementOrdersMgr procurementOrdersMgr;
	private List<GoodsCategoryPo> goodsCategorys;
	private ProcurementOrdersPo procurementOrdersPo;
	private List<ProcurementOrdersEntryPo> procurementOrdersEntrys;
	private GoodsInfoTempPo goodsInfoTempPo;
	private List<ProcurementOrdersPo> orders;	
	private StatusPo statusPo;	
	private AllocationMgr allocationMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private BrandMgr brandMgr;	
	private List<GoodsInfoPo> goodsInfoPos = null;
	private List<DepartmentsPo> departmentsList;
	private DepartmentsMgr departmentsMgr;
	private AllocationApplyForAppMgr allocationApplyForAppMgr;
	private List<AllocationPo> allocationList;
	
	public List<AllocationPo> getAllocationList() {
		return allocationList;
	}

	public void setAllocationList(List<AllocationPo> allocationList) {
		this.allocationList = allocationList;
	}

	public AllocationApplyForAppMgr getAllocationApplyForAppMgr() {
		return allocationApplyForAppMgr;
	}

	public void setAllocationApplyForAppMgr(
			AllocationApplyForAppMgr allocationApplyForAppMgr) {
		this.allocationApplyForAppMgr = allocationApplyForAppMgr;
	}

	public List<GoodsInfoPo> getGoodsInfoPos() {
		return goodsInfoPos;
	}

	public void setGoodsInfoPos(List<GoodsInfoPo> goodsInfoPos) {
		this.goodsInfoPos = goodsInfoPos;
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}

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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public ProcurementOrdersMgr getProcurementOrdersMgr() {
		return procurementOrdersMgr;
	}

	public void setProcurementOrdersMgr(
			ProcurementOrdersMgr procurementOrdersMgr) {
		this.procurementOrdersMgr = procurementOrdersMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public ProcurementOrdersPo getProcurementOrdersPo() {
		return procurementOrdersPo;
	}

	public void setProcurementOrdersPo(ProcurementOrdersPo procurementOrdersPo) {
		this.procurementOrdersPo = procurementOrdersPo;
	}

	public List<ProcurementOrdersEntryPo> getProcurementOrdersEntrys() {
		return procurementOrdersEntrys;
	}

	public void setProcurementOrdersEntrys(
			List<ProcurementOrdersEntryPo> procurementOrdersEntrys) {
		this.procurementOrdersEntrys = procurementOrdersEntrys;
	}

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	public List<ProcurementOrdersPo> getOrders() {
		return orders;
	}

	public void setOrders(List<ProcurementOrdersPo> orders) {
		this.orders = orders;
	}
	

	public AllocationApplyMgr getAllocationApplyMgr() {
		return allocationApplyMgr;
	}

	public void setAllocationApplyMgr(AllocationApplyMgr allocationApplyMgr) {
		this.allocationApplyMgr = allocationApplyMgr;
	}

	/**
	 * 查询页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initProcurementOrdersSel() throws Exception {
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

		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selprocurementorders";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selProcurementOrders() throws Exception {
		
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

		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();

		String billID = Utility.getName(request.getParameter("billID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String createPersonName = Utility.getName(request.getParameter("createPersonName"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));
		String selbspcategoryid = Utility.getName(request.getParameter("selbspcategoryid"));
		String selcstpsupplierid = Utility.getName(request.getParameter("selcstpsupplierid"));
		String selbspsuppliername = Utility.getName(request.getParameter("selbspsuppliername"));
		String goodsname = Utility.getName(request.getParameter("goodsname"));
		String remark = Utility.getName(request.getParameter("remark"));

		ProcurementOrdersPo po = new ProcurementOrdersPo();
		po.setCstpid(billID);
		po.setCstpgoodsname(goodsname);
		po.setCstpstarttime(startTime);
		po.setCstpendtime(endTime);
		po.setCstpgoodscategory(selbspcategoryid);
		po.setCstpsupplierid(selcstpsupplierid);
		po.setCstpauditstate(auditState);
		po.setCstpcreateperson(createPersonID);
		po.setCstpauditperson(auditPersonID);
		po.setCstpremark(remark);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setCstpcompanyid(personInfoPo.getPersoncompanyid());
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
				
		int count = procurementOrdersMgr.getProcurementOroderCount(po);
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
			orders = procurementOrdersMgr.getProcurementOroderList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			orders = null;
		}
		
		request.setAttribute("createPersonID", createPersonID);
		request.setAttribute("auditPersonID", auditPersonID);
		request.setAttribute("billID", billID);
		request.setAttribute("goodsname", goodsname);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("auditState", auditState);
		request.setAttribute("selcreatePersonID", createPersonID);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("selauditPersonID", auditPersonID);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("selbspcategoryid", selbspcategoryid);
		request.setAttribute("selcstpsupplierid", selcstpsupplierid);
		request.setAttribute("selbspsuppliername", selbspsuppliername);
		request.setAttribute("remark", remark);

		return SUCCESS;
	}
	
	/**
	 * 按调拨申请查询未生成订单初始化
	 */
	public String initSelProcurementOrdersForApp() {

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
		String departmentType = personInfoPo1.getDepartmenttype();
		request.setAttribute("departmentType", departmentType);
		request.setAttribute("sysDepartment", personInfoPo1.getDepartmentID()); 
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);		
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		if("1".equals(systemParameterPo.getFspisallocationsupplier())){
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "selApply";
			}
			return SUCCESS;
		}else{
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "iselApply";
			}
			return "isuccess";
		}
		
	}
	
	/**
	 * 按调拨申请查询未生成订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selProcurementOrdersForApp() throws Exception {
		
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
		String departmentType = personInfoPo1.getDepartmenttype();
		request.setAttribute("departmentType", departmentType);

		request.setAttribute("sysDepartment", personInfoPo1.getDepartmentID()); 
		String billID=Utility.getName(request.getParameter("billID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String auditState=Utility.getName(request.getParameter("auditState"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String cshaacreateperson=Utility.getName(request.getParameter("createPersonID"));//制单人
		String cshaaauditperson=Utility.getName(request.getParameter("auditPersonID"));//审核人
		String chaasupplier=Utility.getName(request.getParameter("chaasupplier"));//制造商
		String bspsuppliername=Utility.getName(request.getParameter("bspsuppliername"));//制造商
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String goodsName=Utility.getName(request.getParameter("goodsName"));
		String goodsID=Utility.getName(request.getParameter("goodsID"));
		String remark=Utility.getName(request.getParameter("remark"));
		
		request.setAttribute("selcreatePersonID",cshaacreateperson);
		request.setAttribute("selauditPersonID",cshaaauditperson);
		request.setAttribute("auditPersonName", request.getParameter("auditPersonName"));
		request.setAttribute("createPersonName",request.getParameter("createPersonName") );
		request.setAttribute("goodsName",goodsName);		
		request.setAttribute("goodsID",goodsID);		
		
		PersonInfoPo personInfoPo=(PersonInfoPo) session.get("person");
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		
		AllocationPo allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaindepartmentid(departmentID);
		allocationPo.setCshaastartTime(startTime);
		allocationPo.setCshaaendTime(endTime);
		allocationPo.setCshaaauditstate(auditState);
		allocationPo.setCshaaauditdatestart(startTime1);
		allocationPo.setCshaaauditdateend(endTime1);
		allocationPo.setGoodscategoryid(goodscategoryID);
		allocationPo.setChaasupplier(chaasupplier);		
		allocationPo.setCshaacreateperson(cshaacreateperson);
		allocationPo.setCshaaauditperson(cshaaauditperson);
		allocationPo.setCshaaflag("1");//正调拨
		allocationPo.setChaagoodsname(goodsName);
		allocationPo.setChaagoodsid(goodsID);
		allocationPo.setCshaaremark(remark);
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			allocationPo.setCshaaindptcompanyid(personInfoPo1.getPersoncompanyid());
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
		
		int count = allocationApplyForAppMgr.getProcurementOrdersForAppCount(allocationPo,deppo);
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
	    allocationList=allocationApplyForAppMgr.getProcurementOrdersForAppList(allocationPo,deppo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			allocationList = null;
		}

		//取得登陆人允许操作的仓位&部门 Begin		
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		departmentsList = departmentsMgr.getDepartments(deppo);				
		
		request.setAttribute("billID",billID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("auditState",auditState);
		request.setAttribute("goodscategoryID",goodscategoryID);
		request.setAttribute("chaasupplier",chaasupplier);
		request.setAttribute("bspsuppliername",bspsuppliername);
		request.setAttribute("startTime1",startTime1);
		request.setAttribute("endTime1",endTime1);
		request.setAttribute("remark",remark);
		
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();		
		
		return SUCCESS;
	}

	/**
	 * 新增页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initProcurementOrdersInsert() throws Exception {
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
		procurementOrdersPo = new ProcurementOrdersPo();
		procurementOrdersPo.setCstpid("PO"+ GenerateNumber.getInstance().getGenerageNumber());

		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		procurementOrdersPo.setCstpordersdeliveryaddress(Utility.getName(systemParameterPo.getFsptakeaddress()));
		procurementOrdersPo.setCstpordersdeliveryperson(Utility.getName(systemParameterPo.getFsptakeperson()));
		procurementOrdersPo.setCstpordersdeliveryphone(Utility.getName(systemParameterPo.getFsptakephone()));
		procurementOrdersPo.setCstpordersdeliveryfax(Utility.getName(systemParameterPo.getFsptakeportraiture()));
		
		return SUCCESS;
	}
	
	public String selApplyBills() throws Exception { 
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
		
		String id=Utility.getName(request.getParameter("billID"));
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String suppliername = Utility.getName(request.getParameter("supplierName"));
		
		procurementOrdersPo = new ProcurementOrdersPo();
		procurementOrdersPo.setCstpid("PO"+ GenerateNumber.getInstance().getGenerageNumber());
		procurementOrdersPo.setBspsuppliername(suppliername);
		procurementOrdersPo.setCshaaabillid(id);
		procurementOrdersPo.setCstpsupplierid(supplierID);
		
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		procurementOrdersPo.setCstpordersdeliveryaddress(Utility.getName(systemParameterPo.getFsptakeaddress()));
		procurementOrdersPo.setCstpordersdeliveryperson(Utility.getName(systemParameterPo.getFsptakeperson()));
		procurementOrdersPo.setCstpordersdeliveryphone(Utility.getName(systemParameterPo.getFsptakephone()));
		procurementOrdersPo.setCstpordersdeliveryfax(Utility.getName(systemParameterPo.getFsptakeportraiture()));
		
		ProcurementOrdersPo ppo = new ProcurementOrdersPo();
		ppo.setCshaaabillid(id);
		ppo.setCstpgoodscategory(goodsCategoryID);
		ppo.setCstpsupplierid(supplierID);
		ppo.setCstpbrandid(brandID);

		procurementOrdersEntrys = procurementOrdersMgr.getProcurementOrdersApplyList(ppo);
			
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		
		String categoryid = goodsCategoryID;
		request.setAttribute("goodstype", categoryid);
		
		if( "3".equals(categoryid)||"4".equals(categoryid) ){
			String supplierid = supplierID;
			String brandid = procurementOrdersEntrys.get(0).getCstpegoodsid().substring(5, 7);
			BrandPo brandPo = new BrandPo();
			brandPo.setBbdid(brandid);
			brandPo.setBbdsupplierid(supplierid);
			brandPo = brandMgr.getBrandPo(brandPo);
			request.setAttribute("brandID", brandPo
					.getBbdid());
			request.setAttribute("brandName", brandPo
					.getBbdbrandname());
		}
		
		return SUCCESS;

	}
	
	public String selApplyBillsUpdate() throws Exception { 
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

		String id=Utility.getName(request.getParameter("billID"));
		procurementOrdersPo.setCshaaabillid(id);
		procurementOrdersPo.getCstpid();
		procurementOrdersPo.getCstpgoodscategory();
		procurementOrdersPo.getBspsuppliername();
		procurementOrdersPo.getCstpsupplierid();
		procurementOrdersPo.getCreatePersonName();
		procurementOrdersEntrys = new ArrayList<ProcurementOrdersEntryPo>();
		procurementOrdersEntrys=procurementOrdersMgr.getProcurementOrdersApplyList(procurementOrdersPo); 
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		
		return SUCCESS;

	}

	/**
	 * 新增订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertProcurementOrders() throws Exception {
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
		if ("1".equals(request.getParameter("stateFlag"))) {
			procurementOrdersPo.setCstpauditstate("1");
			procurementOrdersPo.setCstpauditperson(((PersonInfoPo) session.get("person")).getId());
		} else {
			procurementOrdersPo.setCstpauditstate("0");
		}
		int lenth = goodsInfoTempPo.getGoodsid().length;

		procurementOrdersEntrys = new ArrayList<ProcurementOrdersEntryPo>();

		for (int i = 0; i < lenth; i++) {
			ProcurementOrdersEntryPo procurementOrdersEntryPo = new ProcurementOrdersEntryPo();
			procurementOrdersEntryPo.setCstpegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			procurementOrdersEntryPo.setCstpeordernumber(goodsInfoTempPo.getGoodsquantity()[i]);
			procurementOrdersEntryPo.setCstperemark(goodsInfoTempPo.getRemark()[i]);

			procurementOrdersEntrys.add(procurementOrdersEntryPo);
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 12 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("采购订单："+procurementOrdersPo.getCstpid()+" 新增!");

		procurementOrdersPo.setCstpdepartmentid(personInfoPo.getDepartmentID());
		
		procurementOrdersMgr.insertPOs(procurementOrdersPo,procurementOrdersEntrys,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		if ("1".equals(request.getParameter("stateFlag"))) {
			String url = "''initProcurementOrdersView.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(procurementOrdersPo.getCstpid());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
		else
		{
			String url = "''initProcurementOrdersUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(procurementOrdersPo.getCstpid());
			params.add(moduleID);
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
		
	}

	/**
	 * 更新页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initProcurementOrdersUpdate() throws Exception {
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
		procurementOrdersPo = new ProcurementOrdersPo();
		procurementOrdersPo.setCstpid(Utility.getName(request.getParameter("hid")));

		ProcurementOrdersEntryPo procurementOrdersEntryPo = new ProcurementOrdersEntryPo();

		procurementOrdersPo = procurementOrdersMgr.getProcurementOrders(procurementOrdersPo);

		procurementOrdersEntryPo.setCstpepurchaseorderid(procurementOrdersPo.getCstpid());
		procurementOrdersEntryPo.setCstpebillid("");

		procurementOrdersEntrys = procurementOrdersMgr.getProcurementOrdersEntryList(procurementOrdersEntryPo);
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		
		String categoryid = procurementOrdersPo.getCstpgoodscategory();
		
		if( "3".equals(categoryid)||"4".equals(categoryid) ){
			String supplierid = procurementOrdersPo.getCstpsupplierid();
			String brandid = procurementOrdersEntrys.get(0).getCstpegoodsid().substring(5, 7);
			BrandPo brandPo = new BrandPo();
			brandPo.setBbdid(brandid);
			brandPo.setBbdsupplierid(supplierid);
			brandPo = brandMgr.getBrandPo(brandPo);
			request.setAttribute("brandID", brandPo
					.getBbdid());
			request.setAttribute("brandName", brandPo
					.getBbdbrandname());
		}
		
		return SUCCESS;
	}

	/**
	 * 更新订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateProcurementOrders() throws Exception {
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
		if ("1".equals(request.getParameter("stateFlag"))) {
			procurementOrdersPo.setCstpauditstate("1");
			procurementOrdersPo.setCstpauditperson(((PersonInfoPo) session
					.get("person")).getId());
		} else {
			procurementOrdersPo.setCstpauditstate("0");
		}
		int lenth = goodsInfoTempPo.getGoodsid().length;
		
		AllocationPo po = new AllocationPo();
		po.setCshaabillid(procurementOrdersPo.getCshaaabillid());
		
		AllocationPo allocationPo = allocationApplyMgr.getAllocation(po);

		procurementOrdersEntrys = new ArrayList<ProcurementOrdersEntryPo>();

		for (int i = 0; i < lenth; i++) {
			ProcurementOrdersEntryPo procurementOrdersEntryPo = new ProcurementOrdersEntryPo();
			procurementOrdersEntryPo.setCstpegoodsid(goodsInfoTempPo
					.getGoodsid()[i]);
			procurementOrdersEntryPo.setCstpeordernumber(goodsInfoTempPo
					.getGoodsquantity()[i]);
			procurementOrdersEntryPo
					.setCstperemark(goodsInfoTempPo.getRemark()[i]);

			procurementOrdersEntrys.add(procurementOrdersEntryPo);
		}
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");// 表示状态
		logPo.setsLogContent("采购订单："+procurementOrdersPo.getCstpid()+" 修改!");
		
		procurementOrdersPo.setCshaaadepartmentid(allocationPo.getCshaaoutdepartmentid());
		procurementOrdersMgr.updatePOs(procurementOrdersPo,procurementOrdersEntrys,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		if ("1".equals(request.getParameter("stateFlag"))) {
			String url = "''initProcurementOrdersView.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(procurementOrdersPo.getCstpid());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else
		{
			String url = "''initProcurementOrdersUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(procurementOrdersPo.getCstpid());
			params.add(moduleID);
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
		
	}

	/**
	 * 查看页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initProcurementOrdersView() throws Exception {
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
		
		procurementOrdersPo = new ProcurementOrdersPo();
		procurementOrdersPo.setCstpid(Utility.getName(request.getParameter("hid")));
		procurementOrdersPo = procurementOrdersMgr.getProcurementOrders(procurementOrdersPo);
		
		ProcurementOrdersEntryPo procurementOrdersEntryPo = new ProcurementOrdersEntryPo();
		procurementOrdersEntryPo.setCstpepurchaseorderid(procurementOrdersPo.getCstpid());
		procurementOrdersEntryPo.setCstpebillid("");
		procurementOrdersEntrys = procurementOrdersMgr.getProcurementOrdersEntryList(procurementOrdersEntryPo);
		
		StatusPo spo = new StatusPo();		
		spo.setCshastatusorderid(Utility.getName(request.getParameter("hid")));
		statusPo = allocationMgr.getStatusPo(spo);
		
		goodsInfoPos = procurementOrdersMgr.getProBrand(Utility.getName(request.getParameter("hid")));
		if ( goodsInfoPos.size() != 0 ){
			if ( !"".equals(Utility.getName(request.getParameter("checkedBrandid")))){
				request.setAttribute("bid", request.getParameter("checkedBrandid"));	
			}else{
				request.setAttribute("bid", goodsInfoPos.get(0).getBgibrandid());	
			}
		}
		request.setAttribute("brandcount",goodsInfoPos.size() > 1 ? "2" : "1");
		
		return SUCCESS;
	}

	/**
	 * 删除页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initProcurementOrdersDelete() throws Exception {
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
		procurementOrdersPo = new ProcurementOrdersPo();
		procurementOrdersPo.setCstpid(Utility.getName(request.getParameter("hid")));

		procurementOrdersPo = procurementOrdersMgr.getProcurementOrders(procurementOrdersPo);

		return SUCCESS;
	}

	/**
	 * 删除订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteProcurementOrders() throws Exception {
		
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
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");  // 表示状态
		logPo.setsLogContent("采购订单："+Utility.getName(request.getParameter("hid"))+" 删除" );
		procurementOrdersMgr.delProcurementOrders(Utility.getName(request
				.getParameter("hid")),logPo);
			
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	public String addProcurementOrderDimension() throws Exception {
		
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
		
		goodsCategorys = procurementOrdersMgr.getGoodsCategorys();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		
		String[] tdgoodsids = Utility.getName(request.getParameter("tdgoodsids")).split(",");
		String[] tdvs = Utility.getName(request.getParameter("tdvs")).split(",");
		String ioru = Utility.getName(request.getParameter("ioru"));
		
		List<String> goodsidslist = new ArrayList<String>();
		List<String> vslist = new ArrayList<String>();
		for(int i=0; i< tdgoodsids.length; i++){
			if (!goodsidslist.contains(tdgoodsids[i])){
				goodsidslist.add(tdgoodsids[i].toString());
				vslist.add(tdvs[i].toString());
			}
		}
		
		List<GoodsInfoPo> goodsInfoPos = procurementOrdersMgr.selectDimensionPos(goodsidslist, vslist);
		
		request.setAttribute("goodsInfoPos", goodsInfoPos);
		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("tdgoodsids", request.getParameter("tdgoodsids"));
		request.setAttribute("tdvs", request.getParameter("tdvs"));
		return ioru;
	}
	
	private static String[] insert(String[] arr, String str){
		int size = arr.length;
		String[] tmp = new String[size + 1];
		System.arraycopy(arr, 0, tmp, 0, size);
		tmp[size] = str;
		return tmp;
	}

	public StatusPo getStatusPo() {
		return statusPo;
	}

	public void setStatusPo(StatusPo statusPo) {
		this.statusPo = statusPo;
	}

	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}

	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
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
}
