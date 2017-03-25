package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.storage.mgr.ReturnMerchandiseManagementMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
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

public class ReturnMerchandiseManagementAction extends BaseAction {
	
	private List<WarehousePo> warehouselist;
	
	private List<DepartmentsPo> departmentsList;

	private WarehouseMgr warehouseMgr;
	
	private InventoryPo inventoryPo;
	
	private GoodsInfoTempPo goodsInfoTempPo;
	
	private List<InventoryEntryPo> inventoryEntryList;
	
	private ReturnMerchandiseManagementMgr returnMerchandiseManagementMgr;
	
	private DepartmentsMgr departmentsMgr;
	
	private List<InventoryPo> returnMerchandiseManagementList;
	
	private PersonPermissionMgr personPermissionMgr;
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
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
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<InventoryPo> getReturnMerchandiseManagementList() {
		return returnMerchandiseManagementList;
	}

	public void setReturnMerchandiseManagementList(
			List<InventoryPo> returnMerchandiseManagementList) {
		this.returnMerchandiseManagementList = returnMerchandiseManagementList;
	}

	public ReturnMerchandiseManagementMgr getReturnMerchandiseManagementMgr() {
		return returnMerchandiseManagementMgr;
	}

	public void setReturnMerchandiseManagementMgr(
			ReturnMerchandiseManagementMgr returnMerchandiseManagementMgr) {
		this.returnMerchandiseManagementMgr = returnMerchandiseManagementMgr;
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
	
	public List<InventoryEntryPo> getInventoryEntryList() {
		return inventoryEntryList;
	}

	public void setInventoryEntryList(List<InventoryEntryPo> inventoryEntryList) {
		this.inventoryEntryList = inventoryEntryList;
	}

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}

	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
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

	/**
	 * 初始化采购商品退货查询
	 */
	public String initReturnMerchandiseManagementSel()throws Exception{
		
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
		warehouselist=warehouseMgr.getWarehouseList(deppo);
		return SUCCESS;
	}
	
	/**
	 * 初始化采购收货新增
	 */
	public String initReturnMerchandiseManagementInsert()throws Exception{
		
		String billID="POUT"+GenerateNumber.getInstance().getGenerageNumber();
		inventoryPo=new InventoryPo();
		inventoryPo.setCstibillid(billID);
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehouselist=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 新增采购商品退货
	 */
	public String insertReturnMerchandiseManagement()throws Exception{
		 
		String billID=Utility.getName(request.getParameter("cstibillid"));//单据编号
		String billDate=Utility.getName(request.getParameter("cstibilldate"));//单据日期
		String createPersonName=Utility.getName(request.getParameter("cstisuppliername"));//制造商名称
		String createPersonID=Utility.getName(request.getParameter("cstisupplierid"));//制造商ID
		String instockID=Utility.getName(request.getParameter("cstiinstockid"));//
		String createPerson=Utility.getName(request.getParameter("csticreateperson"));//制单人
		String cstiremark=Utility.getName(request.getParameter("cstiremark"));//备注
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		inventoryPo=new InventoryPo();
		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());	//默认插入退货部门为操作人部门
		inventoryPo.setCstibillid(billID);
		inventoryPo.setCstibilldate(billDate);
		inventoryPo.setCstisupplierid(createPersonID);
		inventoryPo.setCstiinstockid(instockID);
		inventoryPo.setCsticreateperson(createPerson);
		inventoryPo.setCstiremark(cstiremark);
        if("".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditstate("0");
        }
        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditperson(inventoryPo.getCsticreateperson());
        }
        
		int lenth=goodsInfoTempPo.getGoodsid().length;

		inventoryEntryList=new ArrayList<InventoryEntryPo>();
		for(int i=0;i<lenth;i++){
			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
//			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiebarcode("1");
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			
//			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo);
//			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
//			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
//			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);
//			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);
//			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		returnMerchandiseManagementMgr.insertReturnMerchandiseManagement(inventoryPo, inventoryEntryList);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;
		
		
//		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
//		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());	//默认插入退货部门为操作人部门
//        if("".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
//        	inventoryPo.setCstiauditstate("0");
//        }
//        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
//        	inventoryPo.setCstiauditperson(inventoryPo.getCsticreateperson());
//        }
//        
//		int lenth=goodsInfoTempPo.getGoodsid().length;
//
//		inventoryEntryList=new ArrayList<InventoryEntryPo>();
//		for(int i=0;i<lenth;i++){
//			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
//			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
//			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
//			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
//			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
//			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
//			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
//			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
//			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);
//			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);
//			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);
//			
//			inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getPcbarcode()[i]);
//			inventoryEntryList.add(inventoryEntryPo);
//		}
//		returnMerchandiseManagementMgr.insertReturnMerchandiseManagement(inventoryPo, inventoryEntryList);
//		
//		this.clearMessages();
//		this.addActionMessage(getText("struts.messages.insert.sucess"));
//		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
//		return SUCCESS;
	}	
	
	
	
	
	
/////////////原代码////////////////////////////
//	/**
//	 * 新增采购商品退货
//	 */
//	public String insertReturnMerchandiseManagement()throws Exception{
//		 
//		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
//		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());	//默认插入退货部门为操作人部门
//        if("".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
//        	inventoryPo.setCstiauditstate("0");
//        }
//        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
//        	inventoryPo.setCstiauditperson(inventoryPo.getCsticreateperson());
//        }
//        
//		int lenth=goodsInfoTempPo.getGoodsid().length;
//
//		inventoryEntryList=new ArrayList<InventoryEntryPo>();
//		for(int i=0;i<lenth;i++){
//			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
//			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
//			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
//			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
//			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
//			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
//			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
//			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
//			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);
//			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);
//			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);
//			
//			inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getPcbarcode()[i]);
//			inventoryEntryList.add(inventoryEntryPo);
//		}
//		returnMerchandiseManagementMgr.insertReturnMerchandiseManagement(inventoryPo, inventoryEntryList);
//		
//		this.clearMessages();
//		this.addActionMessage(getText("struts.messages.insert.sucess"));
//		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
//		return SUCCESS;
//	}	
	///////////////////////////////////////
	/**
	 * 查询商品退货
	 * @return
	 * @throws Exception
	 */
	public String selReturnMerchandiseManagement()throws Exception{
		
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
		String instockID=Utility.getName(request.getParameter("instockID"));
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
		po.setCstiinstockid(instockID);
		po.setCstiauditstate(auditState);
		po.setCsticreateperson(createPersonID);
		po.setCstiauditperson(auditPersonID);
		po.setCstiauditstartdate(auditstartdate);
		po.setCstiauditenddate(auditenddate);
		
		int count=returnMerchandiseManagementMgr.getReturnMerchandiseManagementCount(po);
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
	    returnMerchandiseManagementList=returnMerchandiseManagementMgr.getReturnMerchandiseManagementList(po,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			returnMerchandiseManagementList = null;
		}
		request.setAttribute("billID",billID);
		request.setAttribute("sourceBillID",sourceBillID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("instockID",instockID);
		request.setAttribute("auditState",auditState);
		request.setAttribute("createPersonName",createPersonName);
		request.setAttribute("createPersonID",createPersonID);
		request.setAttribute("auditPersonName",auditPersonName);
		request.setAttribute("auditPersonID",auditPersonID);
		request.setAttribute("auditStartDate",auditstartdate);
		request.setAttribute("auditEndDate",auditenddate);
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		warehouselist=warehouseMgr.getWarehouseList(deppo);
		return SUCCESS;
	}
	
	/**
	 * 采购商品退货详细
	 */
	public String returnMerchandiseManagementDetails()throws Exception{
		
		String id=Utility.getName(request.getParameter("hid"));
		InventoryPo po=new InventoryPo();
		po.setCstibillid(id);
		inventoryPo=returnMerchandiseManagementMgr.getReturnMerchandiseManagement(po);
		inventoryEntryList=returnMerchandiseManagementMgr.getReturnMerchandiseManagementEntryList(po);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化采购收货修改
	 */
	public String initReturnMerchandiseManagementUpdate()throws Exception{
		
		String id=Utility.getName(request.getParameter("hid"));
		InventoryPo po=new InventoryPo();
		po.setCstibillid(id);
		inventoryPo=returnMerchandiseManagementMgr.getReturnMerchandiseManagement(po);
		inventoryEntryList=returnMerchandiseManagementMgr.getReturnMerchandiseManagementEntryList(po);
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		warehouselist=warehouseMgr.getWarehouseList(deppo);
		
		return SUCCESS;
	}
	/**
	 * 修改商品退货信息
	 */
	public String updateReturnMerchandiseManagement()throws Exception{
		
		 
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());
        if("".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditstate("0");
        }
        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditperson(personInfoPo.getId());
        }

		int lenth=goodsInfoTempPo.getGoodsid().length;

		inventoryEntryList=new ArrayList<InventoryEntryPo>();
		for(int i=0;i<lenth;i++){
			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
//			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);
//			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);
//			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);
			inventoryEntryList.add(inventoryEntryPo);
		}
		returnMerchandiseManagementMgr.updateReturnMerchandiseManagement(inventoryPo, inventoryEntryList);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化采购收货删除
	 */
	public String initReturnMerchandiseManagementDelete()throws Exception{
		
		String id=Utility.getName(request.getParameter("hid"));
		InventoryPo po=new InventoryPo();
		po.setCstibillid(id);
		inventoryPo=returnMerchandiseManagementMgr.getReturnMerchandiseManagement(po);
		
		return SUCCESS;
	}
	/**
	 * 删除采购收货
	 */
	public String deleteReturnMerchandiseManagement()throws Exception{
		
		String id=Utility.getName(request.getParameter("hid"));
		InventoryPo po=new InventoryPo();
		po.setCstibillid(id);
		returnMerchandiseManagementMgr.deleteReturnMerchandiseManagement(po);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	

}
