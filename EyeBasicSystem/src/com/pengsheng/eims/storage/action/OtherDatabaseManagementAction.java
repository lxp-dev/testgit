package com.pengsheng.eims.storage.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.mgr.OtherDatabaseManagementMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
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

public class OtherDatabaseManagementAction extends BaseAction {
	
	private List<DepartmentsPo> departmentsList;
	private WarehouseMgr warehouseMgr;	
	private InventoryPo inventoryPo;	
	private GoodsInfoTempPo goodsInfoTempPo;	
	private List<InventoryEntryPo> inventoryEntryList;	
	private List<WarehousePo> warehouselist;	
	private DepartmentsMgr departmentsMgr;	
	private OtherDatabaseManagementMgr otherDatabaseManagementMgr;	
	private List<InventoryPo> otherDatabaseManagementList;	
	private PersonPermissionMgr personPermissionMgr;	
	private List<WarehousePo> inWarehouseList;	
	private WarehouseConfigurationMgr warehouseConfigurationMgr;	
	private WarehouseConfigurationPo warehouseConfigurationPo;	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private InTransitDetailsMgr inTransitDetailsMgr;	
	private BillKeyMgr billKeyMgr;
	
	private AllocationMgr allocationMgr;
	
	
	
	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}

	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
	}

	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}

	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}

	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
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

	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}

	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
	}
	
	
	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}
	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
	}
	public List<WarehousePo> getInWarehouseList() {
		return inWarehouseList;
	}
	public void setInWarehouseList(List<WarehousePo> inWarehouseList) {
		this.inWarehouseList = inWarehouseList;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<InventoryPo> getOtherDatabaseManagementList() {
		return otherDatabaseManagementList;
	}

	public void setOtherDatabaseManagementList(
			List<InventoryPo> otherDatabaseManagementList) {
		this.otherDatabaseManagementList = otherDatabaseManagementList;
	}

	public OtherDatabaseManagementMgr getOtherDatabaseManagementMgr() {
		return otherDatabaseManagementMgr;
	}

	public void setOtherDatabaseManagementMgr(
			OtherDatabaseManagementMgr otherDatabaseManagementMgr) {
		this.otherDatabaseManagementMgr = otherDatabaseManagementMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public List<WarehousePo> getWarehouselist() {
		return warehouselist;
	}

	public void setWarehouselist(List<WarehousePo> warehouselist) {
		this.warehouselist = warehouselist;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}

	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	public List<InventoryEntryPo> getInventoryEntryList() {
		return inventoryEntryList;
	}

	public void setInventoryEntryList(List<InventoryEntryPo> inventoryEntryList) {
		this.inventoryEntryList = inventoryEntryList;
	}

	

	/**
	 * 初始化其它出库查询
	 */
	public String initOtherDatabaseManagementSel()throws Exception{
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
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		warehouselist=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);		
		inWarehouseList=warehouseConfigurationMgr.getWarehouseList();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "otherDatabaseManagements";
		}		
		
		return SUCCESS;
	}
	/**
	 * 查询其它出库
	 * @return
	 * @throws Exception
	 */
	public String selOtherDatabaseManagement()throws Exception{
		
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
		String sourceBillID=Utility.getName(request.getParameter("sourceBillID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String outstockID=Utility.getName(request.getParameter("outstockID"));
		String departmentID=Utility.getName(request.getParameter("departmentID"));
		String auditState=Utility.getName(request.getParameter("auditState"));
		String createPersonName=Utility.getName(request.getParameter("createPersonName"));
		String createPersonID=Utility.getName(request.getParameter("createPersonID"));
		String auditPersonName=Utility.getName(request.getParameter("auditPersonName"));
		String auditPersonID=Utility.getName(request.getParameter("auditPersonID"));
		String auditstartdate=Utility.getName(request.getParameter("auditStartDate"));
		String auditenddate=Utility.getName(request.getParameter("auditEndDate"));
		
		InventoryPo po=new InventoryPo();
		po.setCstibillid(billID);
		po.setCstisourcebillid(sourceBillID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstioutstockid(outstockID);
		po.setCstisupplierid(departmentID);
		po.setCstiauditstate(auditState);
		po.setCsticreateperson(createPersonID);
		po.setCstiauditperson(auditPersonID);
		po.setCstiauditstartdate(auditstartdate);
		po.setCstiauditenddate(auditenddate);
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			po.setCsticompanyid(personInfoPo1.getPersoncompanyid());
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
		
		
		
		int count=otherDatabaseManagementMgr.getOtherDatabaseManagementCount(po);
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
	    otherDatabaseManagementList=otherDatabaseManagementMgr.getOtherDatabaseManagementList(po,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			otherDatabaseManagementList = null;
		}
		request.setAttribute("billID",billID);
		request.setAttribute("sourceBillID",sourceBillID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("outstockID",outstockID);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("auditState",auditState);
		request.setAttribute("createPersonName",createPersonName);
		request.setAttribute("createPersonID",createPersonID);
		request.setAttribute("auditPersonName",auditPersonName);
		request.setAttribute("auditPersonID",auditPersonID);
		request.setAttribute("auditStartDate",auditstartdate);
		request.setAttribute("auditEndDate",auditenddate);
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpisalldepartments("all");
		deppo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		deppo.setBdptype(personInfoPo1.getDepartmenttype());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		
		departmentsList = departmentsMgr.getDepartments(deppo);	
		warehouselist=warehouseMgr.getWarehouseList(deppo);
		inWarehouseList=warehouseConfigurationMgr.getWarehouseList();		
		
		return SUCCESS;
	}
	
	/**
	 * 初始化其它出库新增
	 */
	public String initOtherDatabaseManagementInsert()throws Exception{
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
		String billID="OTO"+GenerateNumber.getInstance().getGenerageNumber();
		inventoryPo=new InventoryPo();
		inventoryPo.setCstibillid(billID);
		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID())	;
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpisalldepartments("all");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		warehouselist=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		inWarehouseList=warehouseConfigurationMgr.getWarehouseList();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		return SUCCESS;
	}
	
	/**
	 * 新增其他出库
	 */
	public String insertOtherDatabaseManagement()throws Exception{
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
		String billID=Utility.getName(request.getParameter("cstibillid"));//单据编号
		String billDate=Utility.getName(request.getParameter("cstibilldate"));//单据日期
		String cstiinstockid=Utility.getName(request.getParameter("cstiinstockid"));//接收部门
		String outstockid=Utility.getName(request.getParameter("cstioutstockid"));//发出仓位
		String cstiremark=Utility.getName(request.getParameter("cstiremark"));//备注
		
		inventoryPo=new InventoryPo();
		inventoryPo.setCstidepartmentid(Utility.getName(request.getParameter("cstidepartmentid")));	//默认插入退货部门为操作人部门
		inventoryPo.setCstisupplierid(Utility.getName(request.getParameter("cstiinstockid")));
		inventoryPo.setCstibillid(billID);
		inventoryPo.setCstibilldate(billDate);
		inventoryPo.setCstiinstockid(cstiinstockid);
		inventoryPo.setCstioutstockid(outstockid);
		inventoryPo.setCsticreateperson(createPerson);
		inventoryPo.setCstiremark(cstiremark);
		request.setAttribute("cstidepartmentid", Utility.getName(request.getParameter("cstidepartmentid")));
		request.setAttribute("cstiinstockid", Utility.getName(request.getParameter("cstiinstockid")));
		request.setAttribute("permissionPo", billID);
		request.setAttribute("permissionPo", billDate);
//		request.setAttribute("permissionPo", cstiinstockid);
		request.setAttribute("outstockid", outstockid);
		request.setAttribute("permissionPo", createPerson);
		request.setAttribute("permissionPo", cstiremark);
		
        if("".equals(Utility.getName(request.getParameter("cstiauditstate")))){
        	inventoryPo.setCstiauditstate("0");
        }
        if("1".equals(Utility.getName(request.getParameter("cstiauditstate")))){
        	inventoryPo.setCstiauditstate("1");
        	inventoryPo.setCstiauditperson(createPerson);
        }
        //添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("其他出库单:" + inventoryPo.getCstibillid() + "新增!");

		int lenth=goodsInfoTempPo.getGoodsid().length;
		inventoryEntryList=new ArrayList<InventoryEntryPo>();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int count = 0;
		String goodsID = null;
		BigDecimal sNum = null;
		BigDecimal dNum = null;
		
		for(int i=0;i<lenth;i++){
			goodsID = goodsInfoTempPo.getGoodsid()[i];
			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
			inventoryEntryPo.setCstieoutstockid(inventoryPo.getCstioutstockid());//发出仓位
			inventoryEntryPo.setCstiegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			inventoryEntryPo.setCstiespec(goodsInfoTempPo.getSpec()[i]);
			inventoryEntryPo.setCstiemaxquantity(goodsInfoTempPo.getCshaaemaxquantity()[i]);
			inventoryEntryPo.setCstieoutstorageflag("1");
			inventoryEntryPo.setCstiegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			inventoryEntryPo.setCstiespec(goodsInfoTempPo.getSpec()[i]);
			//inventoryEntryPo.setCstieunitname(goodsInfoTempPo.getUnitname()[i]);
			inventoryEntryPo.setCstiemaxquantity(goodsInfoTempPo.getCshaaemaxquantity()[i]);
			inventoryEntryPo.setCstiemaxquantity2(String.valueOf(Integer.parseInt(goodsInfoTempPo.getCshaaemaxquantity()[i])-Integer.parseInt(goodsInfoTempPo.getGoodsquantity()[i])));

			if (Utility.getName(systemParameterPo.getFspsalestype()).equals("0")){ //不允许负库存销售
				int goodsNums = 0;
				if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //使用条码
					if (Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") || (!goodsID.substring(0,1).equals("4") && !goodsID.substring(0,1).equals("5"))){ //不用批号
						goodsNums += inTransitDetailsMgr.getStorageNumByNotBatch(inventoryEntryPo);
					}
					if (!Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") && (goodsID.substring(0,1).equals("4") || goodsID.substring(0,1).equals("5"))){ //使用批号
						goodsNums += inTransitDetailsMgr.getStorageNumByBatch(inventoryEntryPo);
					}
				}
				if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //不使用条码
					goodsNums = inTransitDetailsMgr.getStorageNumByGoodsID(inventoryEntryPo);
				}
				
				sNum = new BigDecimal(goodsNums);
				dNum = new BigDecimal(inventoryEntryPo.getCstiegoodsquantity());
				sNum = sNum.subtract(dNum);
				if (sNum.intValue() < 0){
					count = 1;
		        	inventoryPo.setCstiauditstate("0");
		        	inventoryPo.setCstiauditperson("");
					inventoryEntryPo.setCstieoutstorageflag("0");
				}
				
				sNum = null;
				dNum = null;
			}
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		if(systemParameterPo.getFspsalestype().equals("0")){
			String errorBarcode = "";
			for(int i=0;i<inventoryEntryList.size(); i++){
				GoodsInfoPo goodspo = new GoodsInfoPo();
				goodspo.setBgiwarehouseid(inventoryPo.getCstioutstockid());
				goodspo.setBgigoodsbarcode(inventoryEntryList.get(i).getCstiebarcode());
				goodspo.setBgiallBillid(inventoryPo.getCstibillid());
				List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
				if(Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity())<Integer.parseInt(inventoryEntryList.get(i).getCstiegoodsquantity())){
					errorBarcode = errorBarcode + inventoryEntryList.get(i).getCstiebarcode()+"\\n";
				}
			}
			
			if(!errorBarcode.equals("")){
				////默认仓位////
				warehouseConfigurationPo= new WarehouseConfigurationPo();
				warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
				warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
				////默认仓位////		
				
				//取得登陆人允许操作的仓位&部门 Begin			
				DepartmentsPo deppo=new DepartmentsPo();
				deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
				deppo.setBdptype(personInfoPo.getDepartmenttype());
				deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
				if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
					deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
				}
				
				departmentsList = departmentsMgr.getDepartments(deppo);
				warehouselist=warehouseMgr.getWarehouseList(deppo);
				
				inWarehouseList=warehouseConfigurationMgr.getWarehouseList();
				//取得登陆人允许操作的仓位&部门 End
				systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
				request.setAttribute("systemParameterPo", systemParameterPo);

				
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				return "error";
			}
		}
		otherDatabaseManagementMgr.insertOtherDatabaseManagement(inventoryPo, inventoryEntryList,logPo);
		
		this.clearMessages();
		if (count > 0){
			this.addActionMessage(getText("新增成功!\\n部分商品库存不足,未能出库!"));
		}else{
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		}		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}	
	/**
	 * 其它出库详细
	 */
	public String returnOtherDatabaseManagementDetails()throws Exception{
		
		String id=Utility.getName(request.getParameter("hid"));
		InventoryPo po=new InventoryPo();
		po.setCstibillid(id);
		inventoryPo=otherDatabaseManagementMgr.getOtherDatabaseManagement(po);
		inventoryEntryList=otherDatabaseManagementMgr.getOtherDatabaseManagementEntryList(po);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		return SUCCESS;
	}
	
	/**
	 * 初始化其它出库修改
	 */
	public String initOtherDatabaseManagementUpdate()throws Exception{
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
		String id=Utility.getName(request.getParameter("hid"));
		InventoryPo po=new InventoryPo();
		po.setCstibillid(id);
		inventoryPo=otherDatabaseManagementMgr.getOtherDatabaseManagement(po);
		inventoryEntryList=otherDatabaseManagementMgr.getOtherDatabaseManagementEntryList(po);
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpisalldepartments("all");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);
		warehouselist=warehouseMgr.getWarehouseList(deppo);
		
		inWarehouseList=warehouseConfigurationMgr.getWarehouseList();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		return SUCCESS;
	}
	/**
	 * 修改其它出库
	 */
	public String updateOtherDatabaseManagement()throws Exception{
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
		
		int isaudit = billKeyMgr.selectInventoryForAuditType(inventoryPo.getCstibillid());
		if(isaudit == 1){
			this.clearMessages();
			this.addActionMessage("该单据已被审核，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
				
        if("".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditstate("0");
        }
        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditperson(personInfoPo.getId());
        }
      //添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("其他出库单:"+inventoryPo.getCstibillid()+"修改!");
		
		int lenth = goodsInfoTempPo.getGoodsid().length;
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		int count = 0;
		String goodsID = null;
		BigDecimal sNum = null;
		BigDecimal dNum = null;
		
		for(int i=0;i<lenth;i++){
			goodsID = goodsInfoTempPo.getGoodsid()[i];
			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
			inventoryEntryPo.setCstieoutstockid(inventoryPo.getCstioutstockid());//发出仓位
			inventoryEntryPo.setCstieoutstorageflag("1");
			inventoryEntryPo.setCstiegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			inventoryEntryPo.setCstiespec(goodsInfoTempPo.getSpec()[i]);
			//inventoryEntryPo.setCstieunitname(goodsInfoTempPo.getUnitname()[i]);
			inventoryEntryPo.setCstiemaxquantity(goodsInfoTempPo.getCshaaemaxquantity()[i]);
			inventoryEntryPo.setCstiemaxquantity2(String.valueOf(Integer.parseInt(goodsInfoTempPo.getCshaaemaxquantity()[i])-Integer.parseInt(goodsInfoTempPo.getGoodsquantity()[i])));
			if (Utility.getName(systemParameterPo.getFspsalestype()).equals("0")){ //不允许负库存销售
				int goodsNums = 0;
				if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //使用条码
					if (Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") || (!goodsID.substring(0,1).equals("4") && !goodsID.substring(0,1).equals("5"))){ //不用批号
						goodsNums += inTransitDetailsMgr.getStorageNumByNotBatch(inventoryEntryPo);
					}
					if (!Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") && (goodsID.substring(0,1).equals("4") || goodsID.substring(0,1).equals("5"))){ //使用批号
						goodsNums += inTransitDetailsMgr.getStorageNumByBatch(inventoryEntryPo);
					}
				}
				if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //不使用条码
					goodsNums = inTransitDetailsMgr.getStorageNumByGoodsID(inventoryEntryPo);
				}
				
				sNum = new BigDecimal(goodsNums);
				dNum = new BigDecimal(inventoryEntryPo.getCstiegoodsquantity());
				sNum = sNum.subtract(dNum);
				if (sNum.intValue() < 0){
					count = 1;
		        	inventoryPo.setCstiauditstate("0");
		        	inventoryPo.setCstiauditperson("");
					inventoryEntryPo.setCstieoutstorageflag("0");
				}
				
				sNum = null;
				dNum = null;
			}
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		if(systemParameterPo.getFspsalestype().equals("0")){
			String errorBarcode = "";
			for(int i=0;i<inventoryEntryList.size(); i++){
				GoodsInfoPo goodspo = new GoodsInfoPo();
				goodspo.setBgiwarehouseid(inventoryPo.getCstioutstockid());
				goodspo.setBgigoodsbarcode(inventoryEntryList.get(i).getCstiebarcode());
				goodspo.setBgiallBillid(inventoryPo.getCstibillid());
				List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
				if(Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity())<Integer.parseInt(inventoryEntryList.get(i).getCstiegoodsquantity())){
					errorBarcode = errorBarcode + inventoryEntryList.get(i).getCstiebarcode()+"\\n";
				}
			}
			
			if(!errorBarcode.equals("")){
				////默认仓位////
				warehouseConfigurationPo= new WarehouseConfigurationPo();
				warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
				warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
				////默认仓位////		


				//取得登陆人允许操作的仓位&部门 Begin			
				DepartmentsPo deppo=new DepartmentsPo();
				deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
				deppo.setBdptype(personInfoPo.getDepartmenttype());
				deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
				deppo.setBdpisalldepartments("all");
				if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
					deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
				}
				departmentsList = departmentsMgr.getDepartments(deppo);
				
				warehouselist=warehouseMgr.getWarehouseList(deppo);
				
				inWarehouseList=warehouseConfigurationMgr.getWarehouseList();
				//取得登陆人允许操作的仓位&部门 End
				systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
				
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				return "error";
			}
		}
		otherDatabaseManagementMgr.updateOtherDatabaseManagement(inventoryPo, inventoryEntryList,logPo);	

		this.clearMessages();
		if (count > 0){
			this.addActionMessage(getText("修改成功!\\n部分商品库存不足,未能出库!"));
		}else{
			this.addActionMessage(getText("struts.messages.update.sucess"));
		}		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化其它出库删除
	 */
	public String initOtherDatabaseManagementDelete()throws Exception{
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
		String id=Utility.getName(request.getParameter("hid"));
		InventoryPo po=new InventoryPo();
		po.setCstibillid(id);
		inventoryPo=otherDatabaseManagementMgr.getOtherDatabaseManagement(po);
		
		return SUCCESS;
	}
	/**
	 * 删除其它出库
	 */
	public String deleteOtherDatabaseManagement()throws Exception{
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
		String id=Utility.getName(request.getParameter("hid"));		
		InventoryPo po=new InventoryPo();
		po.setCstibillid(id);
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("其他出库单:" + po.getCstibillid() + "删除!");
		
		otherDatabaseManagementMgr.deleteOtherDatabaseManagement(po,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
}
