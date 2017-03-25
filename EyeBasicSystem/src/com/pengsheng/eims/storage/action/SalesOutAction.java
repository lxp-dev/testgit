package com.pengsheng.eims.storage.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.CustomerMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.CustomerPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.mgr.ProcurementOrdersMgr;
import com.pengsheng.eims.storage.mgr.SalesOutMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
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

public class SalesOutAction extends BaseAction {

	private SalesOutMgr salesOutMgr;	
	private WarehouseMgr warehouseMgr;	
	private CustomerMgr customerMgr;	
	private DepartmentsMgr departmentsMgr;	
    private SystemParameterMgr systemParameterMgr;	
	private SystemParameterPo systemParameterPo;	
	private String isFirstExec;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private ProcurementOrdersMgr procurementOrdersMgr;
	private AllocationMgr allocationMgr;
	private BillKeyMgr billKeyMgr;
	
	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}

	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}

	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
	}

	public ProcurementOrdersMgr getProcurementOrdersMgr() {
		return procurementOrdersMgr;
	}

	public void setProcurementOrdersMgr(ProcurementOrdersMgr procurementOrdersMgr) {
		this.procurementOrdersMgr = procurementOrdersMgr;
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

	
	private InventoryPo inventoryPo;
	
	private GoodsInfoTempPo goodsInfoTempPo;
	
	private List<InventoryEntryPo> inventoryEntryList;
	
	private List<InventoryPo> salesOutList;
	
	private List<WarehousePo> warehouseList;
	
	private List<CustomerPo> customerList;
	
	private List<DepartmentsPo> departmentsList;
	
	private PersonPermissionMgr personPermissionMgr;
	
	private WarehouseConfigurationPo warehouseConfigurationPo;
	private List<AllocationBarcodePo> allocationBarcodeLists;

	public List<AllocationBarcodePo> getAllocationBarcodeLists() {
		return allocationBarcodeLists;
	}

	public void setAllocationBarcodeLists(
			List<AllocationBarcodePo> allocationBarcodeLists) {
		this.allocationBarcodeLists = allocationBarcodeLists;
	}

	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}

	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
	}
	
	
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
	public SalesOutMgr getSalesOutMgr() {
		return salesOutMgr;
	}
	public void setSalesOutMgr(SalesOutMgr salesOutMgr) {
		this.salesOutMgr = salesOutMgr;
	}

	public InventoryPo getInventoryPo() {
		return inventoryPo;
	}
	public void setInventoryPo(InventoryPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}
	public List<InventoryPo> getSalesOutList() {
		return salesOutList;
	}
	public void setSalesOutList(List<InventoryPo> salesOutList) {
		this.salesOutList = salesOutList;
	}
	/**
	 * 初始化销售出库查询
	 */
	public String initSalesOutSel()throws Exception{
		
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
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		deppo.setBdpdepartmentname(personInfoPo1.getBdpdepartmentname());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		//取得登陆人允许操作的仓位&部门 End
		
		 systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "selSalesOut";
			}
		
		return SUCCESS;
	}
	/**
	 * 查询销售出库
	 */
	public String selSalesOut()throws Exception{
		
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
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String departmentid = Utility.getName(request.getParameter("cstidepartmentid"));
		String outstockID=Utility.getName(request.getParameter("cstioutstockid"));
		String auditState=Utility.getName(request.getParameter("auditState"));
		String customerid = Utility.getName(request.getParameter("customerid"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodsId = Utility.getName(request.getParameter("goodsId"));
		//获取备注
		String remark = Utility.getName(request.getParameter("remark"));
		
		InventoryPo po=new InventoryPo();
		po.setCstigoodsname(goodsName);
		po.setCstigoodsid(goodsId);
		po.setCstibillid(billID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstioutstockid(outstockID);
		po.setCstisupplierid(customerid);//客户ID
		po.setCstiauditstate(auditState);
		po.setCstidepartmentid(departmentid);
		po.setCstiremark(remark);//备注
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
		int count=salesOutMgr.getSalesOutCount(po);
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
	    salesOutList=salesOutMgr.getSalesOutList(po,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			salesOutList = null;
		}
		
		
		request.setAttribute("billID",billID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("outstockID",outstockID);
		request.setAttribute("departmentid",departmentid);
		request.setAttribute("auditState",auditState);
		request.setAttribute("customerid", customerid);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodsId", goodsId);
		//页面存取备注
		request.setAttribute("remark", remark);
		
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		//取得登陆人允许操作的仓位&部门 End
		
		return SUCCESS;
	}
	/**
	 * 初始化销售出库新增
	 */
	public String initSalesOutInsert()throws Exception{
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
		
		inventoryPo=new InventoryPo();		
		inventoryPo.setCstibillid("SOUT"+GenerateNumber.getInstance().getGenerageNumber());
		inventoryPo.setCstisupplierid(personInfoPo.getDepartmentID());
		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////		
		
		//取得登陆人允许操作的仓位&部门 Begin			
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		//取得登陆人允许操作的仓位&部门 End
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		return SUCCESS;
	}
	
	public String addSalesOutDimension() throws Exception {
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
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		//取得登陆人允许操作的仓位&部门 End
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		CustomerPo customerPo = new CustomerPo();
		customerList = customerMgr.getCustomerList(customerPo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		
		String[] tdgoodsids = Utility.getName(request.getParameter("tdgoodsids")).split(",");
		String[] tdvs = Utility.getName(request.getParameter("tdvs")).split(",");
		String ioru = Utility.getName(request.getParameter("ioru"));
		if(goodsInfoTempPo != null){
			for (int i = 0; i < goodsInfoTempPo.getGoodsid().length; i++) {
				tdgoodsids =  insert(tdgoodsids, goodsInfoTempPo.getGoodsid()[i]) ;
				tdvs = insert(tdvs,goodsInfoTempPo.getGoodsquantity()[i]);
			}
		}
		
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
		
		return ioru;
	}

	private static String[] insert(String[] arr, String str){
		int size = arr.length;
		String[] tmp = new String[size + 1];
		System.arraycopy(arr, 0, tmp, 0, size);
		tmp[size] = str;
		return tmp;
	}
	
	/**
	 * 新增销售出库
	 */
	public String insertSalesOut()throws Exception{
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
		
        if("".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditstate("0");
        	inventoryPo.setCstifinanceauditstate("0");
        }
        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditperson(createPerson);
        	inventoryPo.setCstifinanceauditstate("1");
        }
        inventoryPo.setCstisourcebillid(request.getParameter("cstisourcebillid"));
        
        inventoryPo.setCstisupplierid(inventoryPo.getCstidepartmentid());  // 客户
      
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("销售出库单:" + inventoryPo.getCstibillid()+"新增!");
		
		int lenth=goodsInfoTempPo.getGoodsid().length;		
		inventoryEntryList=new ArrayList<InventoryEntryPo>();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int count = 0;
		
		for(int i=0; i<lenth; i++){
			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstieoutstockid(inventoryPo.getCstioutstockid());
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);//单位成本(不含税)
			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);//成本合计(不含税)			
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);//含税单价
			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);//价税合计			
			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);//税额合计				
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);//税率		
			inventoryEntryPo.setCstiegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			inventoryEntryPo.setCstiespec(goodsInfoTempPo.getSpec()[i]);
			inventoryEntryPo.setCstiemaxquantity(goodsInfoTempPo.getCshaaemaxquantity()[i]);
			
			inventoryEntryPo.setCstieoutstorageflag("1");
			
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
				warehouseList=warehouseMgr.getWarehouseList(deppo);
				departmentsList = departmentsMgr.getDepartments(deppo);
				
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				return "error";
			}
		}

		salesOutMgr.insertSalesOut(inventoryPo, inventoryEntryList,null,logPo);
		
		this.clearMessages();		
		if (count > 0){
			this.addActionMessage(getText("新增成功!\\n部分商品库存不足,未能出库!"));
		}else{
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		}
		
		String url = "''initSalesOutDetails.action?hid={0}&moduleID={1}''";
		List<String> params = new ArrayList<String>();
		params.add(inventoryPo.getCstibillid());
		params.add(moduleID);

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}

	/**
	 * 销售出库详细
	 */
	public String initSalesOutDetails()throws Exception{
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
		inventoryPo =new InventoryPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=salesOutMgr.getSalesOut(inventoryPo);
		inventoryEntryList=salesOutMgr.getSalesOutEntryList(inventoryPo);
		allocationBarcodeLists = salesOutMgr.getInventoryBarcode(inventoryPo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		
		String goodsID = Utility.getName(request.getParameter("goodsID"));//库存综合查询，流水里面的单据明细，商品重点显示。
		request.setAttribute("goodsID", goodsID);			
		
		return SUCCESS;
	}
	
	/**
	 * 初始化销售出库修改
	 */
	public String initSalesOutUpdate()throws Exception{
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
		inventoryPo =new InventoryPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=salesOutMgr.getSalesOut(inventoryPo);
		inventoryEntryList=salesOutMgr.getSalesOutEntryList(inventoryPo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		return SUCCESS;
	}
	/**
	 * 修改销售出库
	 */
	public String updateSalesOut()throws Exception{
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
        	inventoryPo.setCstifinanceauditstate("0");
        }
        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditperson(personInfoPo.getId());
        	inventoryPo.setCstifinanceauditstate("1");
        }
        inventoryPo.setCstisourcebillid(request.getParameter("cstisourcebillid"));

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("销售出库单:" + inventoryPo.getCstibillid() + "修改!");
		
		int lenth=goodsInfoTempPo.getGoodsid().length;
		inventoryEntryList=new ArrayList<InventoryEntryPo>();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int count = 0;
		
		for(int i=0;i<lenth;i++){
			InventoryEntryPo inventoryEntryPo=new InventoryEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiepcbarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);//单位成本(不含税)
			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);//成本合计(不含税)			
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);//含税单价
			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);//价税合计			
			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);//税额合计		
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);//税率
			inventoryEntryPo.setCstiegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			inventoryEntryPo.setCstiespec(goodsInfoTempPo.getSpec()[i]);
			inventoryEntryPo.setCstiemaxquantity(goodsInfoTempPo.getCshaaemaxquantity()[i]);
			
			inventoryEntryPo.setCstieoutstorageflag("1");
			
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
				String id=inventoryPo.getCstibillid();
				inventoryPo =new InventoryPo();
				inventoryPo.setCstibillid(id);
				inventoryPo=salesOutMgr.getSalesOut(inventoryPo);
				systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
				
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				return "error";
			}
		}
		
		salesOutMgr.updateSalesOut(inventoryPo, inventoryEntryList,null,logPo);
		
		this.clearMessages();		
		if (count > 0){
			this.addActionMessage(getText("修改成功!\\n部分商品库存不足,未能出库!"));
		}else{
			this.addActionMessage(getText("struts.messages.update.sucess"));
		}
		
		String url = "''initSalesOutDetails.action?hid={0}&moduleID={1}''";
		List<String> params = new ArrayList<String>();
		params.add(inventoryPo.getCstibillid());
		params.add(moduleID);

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}
	/**
	 * 初始化销售出库删除
	 */
	public String initSalesOutDelete()throws Exception{
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
		inventoryPo=salesOutMgr.getSalesOut(po);
		
		return SUCCESS;
	}
	/**
	 * 删除销售出库
	 */
	public String deleteSalesOut()throws Exception{
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
		logPo.setsLogContent("销售出库单:" + po.getCstibillid() + "删除!");
		
		salesOutMgr.deleteSalesOut(po,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	//销售出库选择负调拨单（出库单新增页面使用）
	public String selReAllocationBillsOut() throws Exception { 
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
		inventoryPo.setCstisourcebillid(id);
		inventoryPo.getCstibillid();
		inventoryPo.getCstibilldate();
		inventoryPo.getCstisuppliername();
		inventoryPo.getCstisupplierid();
		inventoryPo.getCstioutstockid();
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		inventoryEntryList = salesOutMgr.getReallocationList(inventoryPo);
		
		//List<InventoryEntryPo> barcodes = salesOutMgr.getAllocationBarcode(id);
		

		
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
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		//取得登陆人允许操作的仓位&部门 End
		
		CustomerPo customerPo = new CustomerPo();
		customerList = customerMgr.getCustomerList(customerPo);

		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
//		request.setAttribute("barcodes", barcodes);
		request.setAttribute("cstisourcebillid", id);
		
		return SUCCESS;

	}
	
	//销售出库选择负调拨单（出库单修改页面使用）
	public String selReAllocationBillsUpdateOut() throws Exception { 
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
		inventoryPo.setCstibillid(id);
		inventoryPo.getCstibilldate();
		inventoryPo.getCstisuppliername();
		inventoryPo.getCstisupplierid();
		inventoryPo.getCstioutstockid();
		inventoryEntryList = new ArrayList<InventoryEntryPo>();
		inventoryEntryList = salesOutMgr.getReallocationList(inventoryPo);
		
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
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		//取得登陆人允许操作的仓位&部门 End
		
		CustomerPo customerPo = new CustomerPo();
		customerList = customerMgr.getCustomerList(customerPo);

		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
		return SUCCESS;

	}

	public String queryGoodsAllocationBills() throws Exception { 
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

		String id = Utility.getName(request.getParameter("billID"));
		String outstockid = Utility.getName(inventoryPo.getCstioutstockid());
		String supplieriD = Utility.getName(inventoryPo.getCstisupplierid());
		
		inventoryEntryList = allocationMgr.getAlllyList(id,outstockid,supplieriD);
	
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);

		return SUCCESS;
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
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	public CustomerMgr getCustomerMgr() {
		return customerMgr;
	}
	public void setCustomerMgr(CustomerMgr customerMgr) {
		this.customerMgr = customerMgr;
	}
	public List<CustomerPo> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<CustomerPo> customerList) {
		this.customerList = customerList;
	}
}
