package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.OtherReceiptMgr;
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

public class OtherReceiptAction extends BaseAction {
	
	private OtherReceiptMgr otherReceiptMgr;	
	
	private WarehouseMgr warehouseMgr;
	
	private DepartmentsMgr departmentsMgr;
	private BillKeyMgr billKeyMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	
	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
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
	
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	private PersonPermissionMgr personPermissionMgr;

	private InventoryPo inventoryPo;
	
	private GoodsInfoTempPo goodsInfoTempPo;
	
	private List<InventoryEntryPo> inventoryEntryList;
	
	private List<WarehousePo> warehouselist;
	
	private List<InventoryPo> otherReceiptList;
	
	private WarehouseConfigurationPo warehouseConfigurationPo;

	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}

	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
	}
	
	public OtherReceiptMgr getOtherReceiptMgr() {
		return otherReceiptMgr;
	}
	public void setOtherReceiptMgr(OtherReceiptMgr otherReceiptMgr) {
		this.otherReceiptMgr = otherReceiptMgr;
	}
	
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	/**
	 * 初始化其它入库查询
	 */
	public String initOtherReceiptSel()throws Exception{
		
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
		/** ********************** 权限设置 ******************************/
		
		PersonInfoPo personInfoPo1=(PersonInfoPo)session.get("person");
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		deppo.setBdptype(personInfoPo1.getDepartmenttype());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		warehouselist=warehouseMgr.getWarehouseList(deppo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selOtherReceipt";
		}
		return SUCCESS;
	}
	/**
	 * 查询其它入库
	 */
	public String selOtherReceipt()throws Exception{
		
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
		String cstcprCreatePersonName=Utility.getName(request.getParameter("cstcprCreatePersonName"));
		String cstcprCreatePersonID=Utility.getName(request.getParameter("cstcprCreatePersonID"));
		String cstcprAuditPersonName=Utility.getName(request.getParameter("cstcprAuditPersonName"));
		String cstcprAuditPersonID=Utility.getName(request.getParameter("cstcprAuditPersonID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		request.setAttribute("goodsName", goodsName);
		
		InventoryPo po=new InventoryPo();
		po.setCstibillid(billID);
		po.setCstisourcebillid(sourceBillID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstiinstockid(instockID);
		po.setCstiauditstate(auditState);		
		po.setCsticreateperson(cstcprCreatePersonID);
		po.setCstiauditperson(cstcprAuditPersonID);
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
		
		int count=otherReceiptMgr.getOtherReceiptCount(po);
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
	    otherReceiptList=otherReceiptMgr.getOtherReceiptList(po,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			otherReceiptList = null;
		}
		
		
		request.setAttribute("billID",billID);
		request.setAttribute("sourceBillID",sourceBillID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("instockID",instockID);
		request.setAttribute("auditState",auditState);
		
		request.setAttribute("cstcprCreatePersonName",cstcprCreatePersonName);
		request.setAttribute("cstcprCreatePersonID",cstcprCreatePersonID);
		request.setAttribute("cstcprAuditPersonName",cstcprAuditPersonName);
		request.setAttribute("cstcprAuditPersonID",cstcprAuditPersonID);
	
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		deppo.setBdptype(personInfoPo1.getDepartmenttype());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		warehouselist=warehouseMgr.getWarehouseList(deppo);		
		
		return SUCCESS;
	}

	/**
	 * 初始化其它入库新增
	 */
	public String initOtherReceiptInsert()throws Exception{
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
		String billID="OTI"+GenerateNumber.getInstance().getGenerageNumber();
		inventoryPo=new InventoryPo();
		inventoryPo.setCstibillid(billID);
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		DepartmentsPo po=new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouselist=warehouseMgr.getWarehouseList(po);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		return SUCCESS;
	}
	
	/**
	 * 新增其它入库
	 */
	public String insertOtherReceipt()throws Exception{
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
		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());	//默认插入退货部门为操作人部门
        if("".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditstate("0");
        }
        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditperson(inventoryPo.getCsticreateperson());
        }
        //添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent(inventoryPo.getCstibillid());

		int lenth=goodsInfoTempPo.getGoodsid().length;
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

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
			inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getPcbarcode()[i]);
			inventoryEntryPo.setCstierksj(goodsInfoTempPo.getBgirksj()[i]);
			inventoryEntryList.add(inventoryEntryPo);
		}
		inventoryPo.setCstigoodscategory("7");
		otherReceiptMgr.insertOtherReceipt(inventoryPo, inventoryEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		String cstiauditstate = Utility.getName(request.getParameter("cstiauditstate"));
		if (cstiauditstate.equals("0")){
			getOtherReceiptData(inventoryPo.getCstibillid(),personInfoPo);
			return INPUT;
		}
		
		return SUCCESS;
	}	
	/**
	 * 初始化其它入库修改
	 */
	public String initOtherReceiptUpdate()throws Exception{
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
		getOtherReceiptData(id,personInfoPo);	
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		return SUCCESS;
	}
	private void getOtherReceiptData(String id,PersonInfoPo personInfoPo){
		InventoryPo po=new InventoryPo();
		InventoryEntryPo ipo=new InventoryEntryPo();
		po.setCstibillid(id);
		inventoryPo=otherReceiptMgr.getOtherReceipt(po);
		inventoryEntryList=otherReceiptMgr.getOtherReceiptEntryList(po);
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouselist=warehouseMgr.getWarehouseList(deppo);
	}
	/**
	 * 修改其它入库
	 */
	public String updateOtherReceipt()throws Exception{
		
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
		
		int isaudit = billKeyMgr.selectInventoryForAuditType(inventoryPo.getCstibillid());
		if(isaudit == 1){
			this.clearMessages();
			this.addActionMessage("该单据已被审核，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());
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
		logPo.setsLogContent(inventoryPo.getCstibillid());
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
			inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getPcbarcode()[i]);
			inventoryEntryPo.setCstierksj(goodsInfoTempPo.getBgirksj()[i]);
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		otherReceiptMgr.updateOtherReceipt(inventoryPo, inventoryEntryList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		String cstiauditstate = Utility.getName(request.getParameter("cstiauditstate"));
		if (cstiauditstate.equals("0")){
			getOtherReceiptData(inventoryPo.getCstibillid(),personInfoPo);
			return INPUT;
		}
		request.setAttribute("systemParameterPo", systemParameterPo);
		return SUCCESS;
	}
	/**
	 * 初始化其它入库删除
	 */
	public String initOtherReceiptDelete()throws Exception{
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
		inventoryPo=otherReceiptMgr.getOtherReceipt(po);
		
		return SUCCESS;
	}
	/**
	 * 删除其它入库
	 */
	public String deleteOtherReceipt()throws Exception{
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
		logPo.setsLogContent(po.getCstibillid());
		otherReceiptMgr.deleteOtherReceipt(po,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	/**
	 * 其它入库详细
	 */
	public String otherReceiptDetails()throws Exception{
		
		String id=Utility.getName(request.getParameter("hid"));
		InventoryPo po=new InventoryPo();
		po.setCstibillid(id);
		inventoryPo=otherReceiptMgr.getOtherReceipt(po);
		inventoryEntryList=otherReceiptMgr.getOtherReceiptEntryList(po);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		return SUCCESS;
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
	public List<InventoryPo> getOtherReceiptList() {
		return otherReceiptList;
	}
	public void setOtherReceiptList(List<InventoryPo> otherReceiptList) {
		this.otherReceiptList = otherReceiptList;
	}
	
}
