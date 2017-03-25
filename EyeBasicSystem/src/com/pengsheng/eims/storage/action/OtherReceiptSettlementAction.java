package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.OtherReceiptSettlementMgr;
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

public class OtherReceiptSettlementAction extends BaseAction {
	
	private WarehouseMgr warehouseMgr;

	private InventoryPo inventoryPo;
	
	private GoodsInfoTempPo goodsInfoTempPo;
	
	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}
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


	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}


	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}


	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}
	private List<WarehousePo> warehouseList;

	private List<InventoryPo> consignProcessSettlementList;
	
	private List<InventoryEntryPo> inventoryEntryList;
	
	private PersonPermissionMgr personPermissionMgr;


	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}


	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}


	public List<InventoryEntryPo> getInventoryEntryList() {
		return inventoryEntryList;
	}


	public void setInventoryEntryList(List<InventoryEntryPo> inventoryEntryList) {
		this.inventoryEntryList = inventoryEntryList;
	}


	public List<InventoryPo> getConsignProcessSettlementList() {
		return consignProcessSettlementList;
	}


	public void setConsignProcessSettlementList(
			List<InventoryPo> consignProcessSettlementList) {
		this.consignProcessSettlementList = consignProcessSettlementList;
	}
	private OtherReceiptSettlementMgr otherReceiptSettlementMgr;
	public OtherReceiptSettlementMgr getOtherReceiptSettlementMgr() {
		return otherReceiptSettlementMgr;
	}


	public void setOtherReceiptSettlementMgr(
			OtherReceiptSettlementMgr otherReceiptSettlementMgr) {
		this.otherReceiptSettlementMgr = otherReceiptSettlementMgr;
	}


	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}


	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}


	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}


	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}


	/**
	 * 初始其它入库结算查询
	 */
	public String initOtherReceiptSettlementSel() throws Exception {

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
		
		 PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		 DepartmentsPo deppo = new DepartmentsPo();
		 deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		 deppo.setBdptype(personInfoPo.getDepartmenttype());
		 if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
		     deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		 }
		 warehouseList = warehouseMgr.getWarehouseList(deppo);
		 
		 systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "selOtherReceiptSettlement";
			}
		 return SUCCESS;
	}
	/**
	 * 其它入库结算查询
	 * @return
	 * @throws Exception
	 */
    public String selOtherReceiptSettlement()throws Exception{
    	
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
		
    	String billID = Utility.getName(request.getParameter("selbillID"));
		//String billID=Utility.getName(request.getParameter("billID"));
		String sourceBillID=Utility.getName(request.getParameter("sourceBillID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String instockID=Utility.getName(request.getParameter("instockID"));
		String auditState=Utility.getName(request.getParameter("auditState"));
		String selcstpsupplierid = Utility.getName(request.getParameter("selcstpsupplierid"));
		String selbspsuppliername = Utility.getName(request.getParameter("selbspsuppliername"));	
		String financeAuditPersonName=Utility.getName(request.getParameter("financeAuditPersonName"));
		String financeAuditPersonID =Utility.getName(request.getParameter("financeAuditPersonID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		request.setAttribute("goodsName", goodsName);
		
		InventoryPo po=new InventoryPo();
		po.setCstibillid(billID);
		po.setCstisourcebillid(sourceBillID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstiinstockid(instockID);
		po.setCstisupplierid(selcstpsupplierid);
		po.setCstifinanceauditstate(auditState);
     	po.setCstibilltypeid("7");		
		po.setCstifinanceauditpersonname(financeAuditPersonName);
		po.setCstifinanceauditperson(financeAuditPersonID);
		po.setCstigoodsname(goodsName);
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
		
		int count=otherReceiptSettlementMgr.getOtherReceiptSettlementCount(po);
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
	    consignProcessSettlementList=otherReceiptSettlementMgr.getOtherReceiptSettlementList(po,page.getStart(), page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			consignProcessSettlementList = null;
		}
		
		request.setAttribute("selbillID",billID);
		request.setAttribute("sourceBillID",sourceBillID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("instockID",instockID);
		request.setAttribute("auditState",auditState);
		request.setAttribute("selcstpsupplierid", selcstpsupplierid);
		request.setAttribute("selbspsuppliername", selbspsuppliername);
//		request.setAttribute("billType", billType);
		request.setAttribute("financeAuditPersonName", financeAuditPersonName);
		request.setAttribute("financeAuditPersonID", financeAuditPersonID);
		
		
		//取得登陆人允许操作的仓位 Begin
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
		    deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		//取得登陆人允许操作的仓位 End
		
		return SUCCESS;
	}
    /**
	 * 初始其它入库结算修改
	 */
	public String initOtherReceiptSettlementUpdate()throws Exception{
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
		getOtherReceiptSettlementDetailsData();
		return SUCCESS;
	}
	
    /**
	 * 修改其它入库结算
	 */
	public String updateOtherReceiptSettlement()throws Exception{
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
	        
	      //添加日志
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("24");    // 表示状态
			logPo.setsLogContent(inventoryPo.getCstibillid());

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
			otherReceiptSettlementMgr.updateOtherReceiptSettlement(inventoryPo, inventoryEntryList,logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			
			String cstifinanceauditstate = Utility.getName(request.getParameter("cstifinanceauditstate"));
			getOtherReceiptSettlementDetailsData();
			//if (cstifinanceauditstate.equals("0")){
			//	return INPUT;
			//}
			return SUCCESS;
		}
	/**
	 * 其他入库结算详细
	 */
	public String initOtherReceiptSettlementDetails()throws Exception{
		getOtherReceiptSettlementDetailsData();
		return SUCCESS;
	}
	
	private void getOtherReceiptSettlementDetailsData(){
		String id=Utility.getName(request.getParameter("hid"));
		inventoryPo =new InventoryPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=otherReceiptSettlementMgr.getOtherReceiptSettlement(inventoryPo);
		inventoryEntryList=otherReceiptSettlementMgr.getOtherReceiptSettlementDetailsList(inventoryPo);
		request.setAttribute("hid",id);
	}
	
}
