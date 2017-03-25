package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.mgr.OveragelossesMgr;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
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

public class OveragelossesAction extends BaseAction {
	private SystemParameterPo systemParameterPo;	
	private SystemParameterMgr systemParameterMgr;
	private InventoryPo inventoryPo;
	private GoodsInfoTempPo goodsInfoTempPo;
	private BillKeyMgr billKeyMgr; 
	private List<GoodsCategoryPo> goodsCategorys;
	private VarietyMgr varietyMgr;
	private AllocationMgr allocationMgr;
	
	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}

	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}

	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
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

	private OveragelossesMgr overagelossesMgr;

	private WarehouseMgr warehouseMgr;

	private List<WarehousePo> warehouselist;

	private List<InventoryPo> overagelossesList;

	private List<InventoryEntryPo> inventoryEntryList;
	
	private PersonPermissionMgr personPermissionMgr;
	private String isFirstExec;
	

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	private InventoryPo overagelossesPo;

	public OveragelossesMgr getOveragelossesMgr() {
		return overagelossesMgr;
	}

	public void setOveragelossesMgr(OveragelossesMgr overagelossesMgr) {
		this.overagelossesMgr = overagelossesMgr;
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

	public List<InventoryPo> getOveragelossesList() {
		return overagelossesList;
	}

	public void setOveragelossesList(List<InventoryPo> overagelossesList) {
		this.overagelossesList = overagelossesList;
	}

	public List<InventoryEntryPo> getInventoryEntryList() {
		return inventoryEntryList;
	}

	public void setInventoryEntryList(List<InventoryEntryPo> inventoryEntryList) {
		this.inventoryEntryList = inventoryEntryList;
	}

	public InventoryPo getOveragelossesPo() {
		return overagelossesPo;
	}

	public void setOveragelossesPo(InventoryPo overagelossesPo) {
		this.overagelossesPo = overagelossesPo;
	}

	/**
	 * 初始化盘盈盘亏
	 * 
	 * @return
	 */
	public String initOveragelossesSel() {
		
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

		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouselist = warehouseMgr.getWarehouseList(deppo);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		if (Utility.getName(permissionPo.getKeyd()).equals("1")){
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "selOverage";
			}
		}

		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		return SUCCESS;
	}

	/**
	 * 盘盈盘亏
	 * 
	 * @return
	 */
	public String selOveragelosses() {
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
		
		String billID = Utility.getName(request.getParameter("billID"));
		String sourceBillID = Utility.getName(request.getParameter("sourceBillID"));
		String billType = Utility.getName(request.getParameter("billType"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String stockID = Utility.getName(request.getParameter("stockID"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String createPersonName = Utility.getName(request.getParameter("createPersonName"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));

		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouselist = warehouseMgr.getWarehouseList(deppo);
		
		InventoryPo po = new InventoryPo();
		po.setCstibillid(billID);
		po.setCstisourcebillid(sourceBillID);
		po.setCstibilltypeid(billType);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstiinstockid(stockID);
		po.setCstiauditstate(auditState);
		po.setCstiauditperson(auditPersonID);
		po.setCsticreateperson(createPersonID);
		po.setCstigoodscategory(goodscategoryID);
		if (!personInfoPo.getDepartmenttype().equals("3")){  // 不是库存类型的部门
			po.setCstistocklist(warehouselist);
		}
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setCsticompanyid(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
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
		
		int count = overagelossesMgr.getOveragelossesCount(po);
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
			overagelossesList = overagelossesMgr.getOveragelossesList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			overagelossesList = null;
		}

		request.setAttribute("billID", billID);
		request.setAttribute("sourceBillID", sourceBillID);
		request.setAttribute("billType", billType);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("stockID", stockID);
		request.setAttribute("auditState", auditState);
		request.setAttribute("selcreatePersonID", createPersonID);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("selauditPersonID", auditPersonID);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("goodscategoryID", goodscategoryID);

		return SUCCESS;
	}
	/**
	 * 新增商品盘盈盘亏初始化
	 */
	public String initOveragelossesInsert() {
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
		if (inventoryPo == null) {
			String billID = "MAI"+ GenerateNumber.getInstance().getGenerageNumber();
			inventoryPo = new InventoryPo();
			inventoryPo.setCstisourcebillid(billID);
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouselist = warehouseMgr.getWarehouseList(deppo);
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		return SUCCESS;
	}	
	
	public String insertOveragelosses()
	{
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
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouselist = warehouseMgr.getWarehouseList(deppo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID()); // 默认插入部门为操作人部门
		if ("".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			inventoryPo.setCstiauditstate("0");
		}
		if ("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))) {
			inventoryPo.setCstiauditperson(inventoryPo.getCsticreateperson());
		}
		
		if("5".equals(Utility.getName(inventoryPo.getCstibilltypeid()))){
			inventoryPo.setCstibillid("SCI"+ GenerateNumber.getInstance().getGenerageNumber());
			inventoryPo.setCstioutstockid(null);
		}else{
			inventoryPo.setCstibillid("SCO"+ GenerateNumber.getInstance().getGenerageNumber());
			inventoryPo.setCstioutstockid(inventoryPo.getCstiinstockid());
			inventoryPo.setCstiinstockid(null);
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("盘盈盘亏单："+inventoryPo.getCstibillid()+" 新增");
		
		int lenth = goodsInfoTempPo.getGoodsid().length;

		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		for (int i = 0; i < lenth; i++) {
			InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			inventoryEntryPo.setCstiespec(goodsInfoTempPo.getSpec()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);
			inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getPcbarcode()[i]);
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);
			inventoryEntryPo.setCstienottaxrateamount(Float.parseFloat(goodsInfoTempPo.getGoodsquantity()[i])*Float.parseFloat(goodsInfoTempPo.getNottaxrate()[i])+"");
			inventoryEntryList.add(inventoryEntryPo);
		}
		
		if(systemParameterPo.getFspsalestype().equals("0") && "6".equals(Utility.getName(inventoryPo.getCstibilltypeid()))){
			String errorBarcode = "";
			for(int i=0;i<inventoryEntryList.size(); i++){
				GoodsInfoPo goodspo = new GoodsInfoPo();
		    	goodspo.setBgiwarehouseid(inventoryPo.getCstioutstockid());
				goodspo.setBgigoodsbarcode(inventoryEntryList.get(i).getCstiepcbarcode());
				goodspo.setBgiallBillid(inventoryPo.getCstibillid());
				List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
				if(Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity())<Integer.parseInt(inventoryEntryList.get(i).getCstiegoodsquantity())){
					errorBarcode = errorBarcode + inventoryEntryList.get(i).getCstiepcbarcode()+"\\n";
				}
			}
			
			if(!errorBarcode.equals("")){
				errorBarcode = errorBarcode + "以上条码商品盘亏数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				return "error";
			}
		}
		
		overagelossesMgr.insertOveragelosses(inventoryPo,inventoryEntryList,logPo);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	/**
	 * 初始化盘盈盘亏删除
	 */
	public String initOveragelossesDelete() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id = Utility.getName(request.getParameter("hid"));
		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);

		overagelossesPo = overagelossesMgr.getOveragelosses(po);

		return SUCCESS;
	}

	public String deleteOveragelossesDelete() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String id = Utility.getName(request.getParameter("hid"));

		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);
		po = overagelossesMgr.getOveragelosses(po);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 删除
		logPo.setsLogContent(id);

		
		overagelossesMgr.deleteOveragelosses(po,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public String initOveragelossesDetails() throws Exception {
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
		
		String id = Utility.getName(request.getParameter("hid"));
		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);

		overagelossesPo = overagelossesMgr.getOveragelosses(po);

		int count = overagelossesMgr.getOveragelossesEntryCount(po);
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
			inventoryEntryList = overagelossesMgr.getOveragelossesEntryList(po,
					page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			inventoryEntryList = null;
		}

		String goodsID = Utility.getName(request.getParameter("goodsID"));//库存综合查询，流水里面的单据明细，商品重点显示。
		request.setAttribute("goodsID", goodsID);	
		return SUCCESS;
	}

	public String initOveragelossesAduit() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id = Utility.getName(request.getParameter("hid"));

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");

		overagelossesPo = new InventoryPo();
		overagelossesPo.setCstibillid(id);

		overagelossesPo = overagelossesMgr.getOveragelosses(overagelossesPo);

		return SUCCESS;
	}

	public String auditduitOveragelosses() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		String id = Utility.getName(request.getParameter("hid"));

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");

		overagelossesPo = new InventoryPo();
		overagelossesPo.setCstibillid(id);

		overagelossesPo = overagelossesMgr.getOveragelosses(overagelossesPo);

		overagelossesPo.setCstiauditperson(personInfoPo.getId());
		overagelossesPo.setCstiauditstate("1");
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("4");    // 审核
		logPo.setsLogContent(id);
		
		int keytype = billKeyMgr.selectBill(id);
		if(keytype == 0){
			billKeyMgr.insertBill(id);
		}else{
			this.clearMessages();
			this.addActionMessage("当前操作失败，该单据正在操作中！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		int isaudit = billKeyMgr.selectInventoryForAuditType(id);
		if(isaudit == 1){
			this.clearMessages();
			this.addActionMessage("该单据已被审核，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		overagelossesMgr.auditOveragelosses(overagelossesPo,logPo);
		
		billKeyMgr.deleteBill(id);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.audit.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initOveragelossesFactDetails() throws Exception {
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
		
		String id = Utility.getName(request.getParameter("hid"));
		String billtype = Utility.getName(request.getParameter("billtype"));
		
		InventoryPo po = new InventoryPo();
		po.setCstibillid(id);
        po.setCstibilltypeid(billtype);
		
		overagelossesPo = overagelossesMgr.getOveragelosses(po);

		int count = overagelossesMgr.getOveragelossesEntryFactCount(po);
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
			inventoryEntryList = overagelossesMgr.getOveragelossesEntryFactList(po,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			inventoryEntryList = null;
		}

		return SUCCESS;
	}
	
}
