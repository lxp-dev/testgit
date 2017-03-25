package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.storage.mgr.ReturnMerchandiseSettlementMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ReturnMerchandiseSettlementAction extends BaseAction {
	
	private List<WarehousePo> warehouseList;
	
	private WarehouseMgr warehouseMgr;
	
	private ReturnMerchandiseSettlementMgr returnMerchandiseSettlementMgr;
	
	private List<InventoryPo> returnMerchandiseSettlementList;
	
	private InventoryPo inventoryPo;
	
	private List<InventoryEntryPo> inventoryEntryList;
	
	private GoodsInfoTempPo goodsInfoTempPo;
	
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

	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}

	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}

	public List<InventoryPo> getReturnMerchandiseSettlementList() {
		return returnMerchandiseSettlementList;
	}

	public void setReturnMerchandiseSettlementList(
			List<InventoryPo> returnMerchandiseSettlementList) {
		this.returnMerchandiseSettlementList = returnMerchandiseSettlementList;
	}

	public ReturnMerchandiseSettlementMgr getReturnMerchandiseSettlementMgr() {
		return returnMerchandiseSettlementMgr;
	}

	public void setReturnMerchandiseSettlementMgr(
			ReturnMerchandiseSettlementMgr returnMerchandiseSettlementMgr) {
		this.returnMerchandiseSettlementMgr = returnMerchandiseSettlementMgr;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}

	/**
	 * 初始化财务结算查询
	 */
	public String initReturnMerchandiseSettlementSel()throws Exception{
		
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
		
		//取得登陆人允许操作的仓位 Begin
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		//取得登陆人允许操作的仓位 End
		
		return SUCCESS;
	}
	
	/**
	 * 查询财务结算
	 */
	public String selReturnMerchandiseSettlement()throws Exception{
		
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
		String selcstpsupplierid = Utility.getName(request.getParameter("selcstpsupplierid"));
		String selbspsuppliername = Utility.getName(request.getParameter("selbspsuppliername"));
		//String billType = Utility.getName(request.getParameter("billType"));
	
		String financeAuditPersonName=Utility.getName(request.getParameter("financeAuditPersonName"));
		String financeAuditPersonID =Utility.getName(request.getParameter("financeAuditPersonID"));
		
		InventoryPo po=new InventoryPo();
		po.setCstibillid(billID);
		po.setCstisourcebillid(sourceBillID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstiinstockid(instockID);
		po.setCstisupplierid(selcstpsupplierid);
		po.setCstifinanceauditstate(auditState);
		po.setCstibilltypeid("1");
		
		po.setCstifinanceauditpersonname(financeAuditPersonName);
		po.setCstifinanceauditperson(financeAuditPersonID);
		
		int count=returnMerchandiseSettlementMgr.getReturnMerchandiseSettlementCount(po);
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
	    returnMerchandiseSettlementList=returnMerchandiseSettlementMgr.getReturnMerchandiseSettlementList(po,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			returnMerchandiseSettlementList = null;
		}
		
		
		request.setAttribute("billID",billID);
		request.setAttribute("sourceBillID",sourceBillID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("instockID",instockID);
		request.setAttribute("auditState",auditState);
		request.setAttribute("selcstpsupplierid", selcstpsupplierid);
		request.setAttribute("selbspsuppliername", selbspsuppliername);
		//request.setAttribute("billType", billType);
		request.setAttribute("financeAuditPersonName", financeAuditPersonName);
		request.setAttribute("financeAuditPersonID", financeAuditPersonID);
		
		
		//取得登陆人允许操作的仓位 Begin
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		//取得登陆人允许操作的仓位 End
		
		return SUCCESS;
	}

	/**
	 * 商品退货结算详细
	 */
	public String initReturnMerchandiseSettlementDetails()throws Exception{
		
		String id=Utility.getName(request.getParameter("hid"));
		inventoryPo =new InventoryPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=returnMerchandiseSettlementMgr.getReturnMerchandiseSettlement(inventoryPo);
		inventoryEntryList=returnMerchandiseSettlementMgr.getReturnMerchandiseSettlementEntryList(inventoryPo);
		
		return SUCCESS;
	}
	/**
	 * 初始化商品退货结算修改
	 */
	public String initReturnMerchandiseSettlementUpdate()throws Exception{
		
		String id=Utility.getName(request.getParameter("hid"));
		inventoryPo =new InventoryPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=returnMerchandiseSettlementMgr.getReturnMerchandiseSettlement(inventoryPo);
		inventoryEntryList=returnMerchandiseSettlementMgr.getReturnMerchandiseSettlementEntryList(inventoryPo);
		
		return SUCCESS;
	}
	/**
	 * 修改商品退货结算
	 */
	public String updateReturnMerchandiseSettlement()throws Exception{
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		inventoryPo.setCstibillid(inventoryPo.getCstibillid());
        if("".equals(Utility.getName(inventoryPo.getCstifinanceauditstate()))){
        	inventoryPo.setCstifinanceauditstate("0");
        	inventoryPo.setCstifinanceauditdate(inventoryPo.getCstifinanceauditdate());
        	inventoryPo.setCstifinanceauditperson(personInfoPo.getId());
        }else if("1".equals(Utility.getName(inventoryPo.getCstifinanceauditstate()))){
        	inventoryPo.setCstifinanceauditstate("1");
        	inventoryPo.setCstifinanceauditdate(inventoryPo.getCstifinanceauditdate());
        	inventoryPo.setCstifinanceauditperson(personInfoPo.getId());
        }

		int lenth=goodsInfoTempPo.getId().length;

		inventoryEntryList=new ArrayList<InventoryEntryPo>();
		for(int i=0;i<lenth;i++){
			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
			inventoryEntryPo.setCstieid(goodsInfoTempPo.getId()[i]);

			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);//单位成本(不含税)
			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);//成本合计(不含税)
			
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);//含税单价
			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);//价税合计
			
			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);//税额合计		
		
			inventoryEntryList.add(inventoryEntryPo);
		}
		returnMerchandiseSettlementMgr.updateReturnMerchandiseSettlement(inventoryPo, inventoryEntryList);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
}
