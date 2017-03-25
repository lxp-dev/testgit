package com.pengsheng.eims.storage.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.OtherDatabaseSettlementMgr;
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

public class OtherDatabaseSettlementAction extends BaseAction {
	private List<WarehousePo> warehouseList;
	
	private WarehouseMgr warehouseMgr;
	
	private OtherDatabaseSettlementMgr otherDatabaseSettlementMgr;
	
	private List<InventoryPo> otherDatabaseSettlementList;
	
	private InventoryPo inventoryPo;
	
	private List<InventoryEntryPo> inventoryEntryList;
	
	private PersonPermissionMgr personPermissionMgr;
	
	private GoodsInfoTempPo goodsInfoTempPo;
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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
	public OtherDatabaseSettlementMgr getOtherDatabaseSettlementMgr() {
		return otherDatabaseSettlementMgr;
	}
	public void setOtherDatabaseSettlementMgr(
			OtherDatabaseSettlementMgr otherDatabaseSettlementMgr) {
		this.otherDatabaseSettlementMgr = otherDatabaseSettlementMgr;
	}
	public List<InventoryPo> getOtherDatabaseSettlementList() {
		return otherDatabaseSettlementList;
	}
	public void setOtherDatabaseSettlementList(
			List<InventoryPo> otherDatabaseSettlementList) {
		this.otherDatabaseSettlementList = otherDatabaseSettlementList;
	}
	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}
	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
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

	/**
	 * 初始化其它出库查询
	 */
	public String initOtherDatabaseSettlementSel()throws Exception{
		
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
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		//取得登陆人允许操作的仓位 End
		
		 systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "selOtherDatabaseSettlement";
			}
		
		return SUCCESS;
	}
	
	/**
	 * 查询其它出库结算
	 */
	public String selOtherDatabaseSettlement()throws Exception{
		
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
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String outstockID=Utility.getName(request.getParameter("outstockID"));
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
		po.setCstibilldate(startTime1);
		po.setCstibillenddate(endTime1);
		po.setCstioutstockid(outstockID);
		po.setCstisupplierid(selcstpsupplierid);
		po.setCstifinanceauditstate(auditState);
		po.setCstibilltypeid("1");		
		po.setCstifinanceauditpersonname(financeAuditPersonName);
		po.setCstifinanceauditperson(financeAuditPersonID);
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
		
		int count=otherDatabaseSettlementMgr.getOtherDatabaseSettlementCount(po);
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
	    otherDatabaseSettlementList=otherDatabaseSettlementMgr.getOtherDatabaseSettlementList(po,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			otherDatabaseSettlementList = null;
		}
		
		
		request.setAttribute("billID",billID);
		request.setAttribute("sourceBillID",sourceBillID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("startTime1",startTime1);
		request.setAttribute("endTime1",endTime1);
		request.setAttribute("outstockID",outstockID);
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
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		//取得登陆人允许操作的仓位 End
			
		return SUCCESS;
	}

	/**
	 * 其它出库结算详细
	 */
	public String initOtherDatabaseSettlementDetails()throws Exception{
		
		String id=Utility.getName(request.getParameter("hid"));
		inventoryPo =new InventoryPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=otherDatabaseSettlementMgr.getOtherDatabaseSettlement(inventoryPo);
		inventoryEntryList=otherDatabaseSettlementMgr.getOtherDatabaseSettlementEntryList(inventoryPo);
		
		return SUCCESS;
	}
	/**
	 * 初始化其它出库结算修改
	 */
	public String initOtherDatabaseSettlementUpdate()throws Exception{
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
		String id=Utility.getName(request.getParameter("hid"));
		inventoryPo =new InventoryPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=otherDatabaseSettlementMgr.getOtherDatabaseSettlement(inventoryPo);
		inventoryEntryList=otherDatabaseSettlementMgr.getOtherDatabaseSettlementEntryList(inventoryPo);
		
		return SUCCESS;
	}
	/**
	 * 修改其它出库结算
	 */
	public String updateOtherDatabaseSettlements()throws Exception{
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
		otherDatabaseSettlementMgr.updateOtherDatabaseSettlement(inventoryPo, inventoryEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		//request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		String url = "''initOtherDatabaseSettlementDetails.action?hid={0}''";
		List<String> params = new ArrayList<String>();
		params.add(inventoryPo.getCstibillid());

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		return SUCCESS;
	}

}
