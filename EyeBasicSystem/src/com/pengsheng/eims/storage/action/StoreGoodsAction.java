package com.pengsheng.eims.storage.action;

import java.math.BigDecimal;
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
import com.pengsheng.eims.storage.mgr.ProcurementReturnMgr;
import com.pengsheng.eims.storage.mgr.StoreGoodsMgr;
import com.pengsheng.eims.storage.mgr.WholeApplyForAppMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.storage.persistence.TracEntryPo;
import com.pengsheng.eims.storage.persistence.TracPo;
import com.pengsheng.eims.storage.persistence.WholePo;

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

public class StoreGoodsAction extends BaseAction
{
	private StoreGoodsMgr storeGoodsMgr;
	private WarehouseMgr warehouseMgr;	
	private CustomerMgr customerMgr;	
	private DepartmentsMgr departmentsMgr;	
	private SystemParameterMgr systemParameterMgr;	
	private SystemParameterPo systemParameterPo;	
	private String isFirstExec;
	private TracPo inventoryPo;	
	private GoodsInfoTempPo goodsInfoTempPo;	
	private List<TracEntryPo> inventoryEntryList;	
	private List<TracPo> salesOutList;	
	private List<WarehousePo> warehouseList;	
	private List<CustomerPo> customerList;	
	private List<DepartmentsPo> departmentsList;	
	private PersonPermissionMgr personPermissionMgr;	
	private WarehouseConfigurationPo warehouseConfigurationPo;
	private List<AllocationBarcodePo> allocationBarcodeLists;
	private List<DepartmentsPo> departmentsPos;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private ProcurementReturnMgr procurementReturnMgr;
	private AllocationMgr allocationMgr;
	private BillKeyMgr billKeyMgr;
	private List<WholePo> wholeList;
	private WholeApplyForAppMgr wholeApplyForAppMgr;
	
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
	/**
	 * 初始化销售出库查询
	 */
	public String initStoreGoodsSel()throws Exception{
		
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
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		//取得登陆人允许操作的仓位&部门 End
		
		CustomerPo customerPo = new CustomerPo();
		customerList = customerMgr.getCustomerList(customerPo);
		departmentsPos=storeGoodsMgr.getFranchisees();
		 systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "selStoreGoods";
			}
		
		return SUCCESS;
	}
	/**
	 * 查询销售出库
	 */
	public String selStoreGoods()throws Exception{
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
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String createPersonName = Utility.getName(request.getParameter("createPersonName"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		//获取备注
		String remark = Utility.getName(request.getParameter("remark"));
		
		TracPo po=new TracPo();
		po.setCstibillid(billID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstioutstockid(outstockID);
		po.setCstisupplierid(customerid);//客户ID
		po.setCstiauditstate(auditState);
		po.setCstidepartmentid(departmentid);
		po.setCstiremark(remark);//备注
		po.setCstigoodsname(goodsName);
		po.setCstigoodsid(goodsId);
		po.setCstisupplieridz(supplierID);
		po.setCstisuppliernamez(supplierName);
		po.setCstibrandid(brandID);
		po.setCstibrandname(brandName);
		po.setCsticreatepersonname(createPersonName);
		po.setCstiauditpersonname(auditPersonName);
		
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
				request.setAttribute("showhider","2");
			}
		}
		int count=storeGoodsMgr.getStoreGoodsCount(po);
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
		    salesOutList=storeGoodsMgr.getStoreGoodsList(po,page.getStart(),page.getPageSize());
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
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("auditPersonName", auditPersonName);
		
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		//取得登陆人允许操作的仓位&部门 End
		
		CustomerPo customerPo = new CustomerPo();
		customerList = customerMgr.getCustomerList(customerPo);
		departmentsPos = storeGoodsMgr.getFranchisees();
		
		return SUCCESS;
	}
	/**
	 * 初始化销售出库新增
	 */
	public String initStoreGoodsInsert()throws Exception{
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
		inventoryPo=new TracPo();
		
		inventoryPo.setCstibillid("SG"+GenerateNumber.getInstance().getGenerageNumber());
		inventoryPo.setCstisupplierid(personInfoPo.getDepartmentID());
		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
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
		
		DepartmentsPo dpo=new DepartmentsPo();
		dpo.setBdpisclosed("0");
		departmentsPos=storeGoodsMgr.getFranchisees(dpo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化销售出库新增
	 */
	public String initStoreReturnGoodsForBatchInsert()throws Exception{
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
		inventoryPo=new TracPo();
		
		inventoryPo.setCstibillid("SR"+GenerateNumber.getInstance().getGenerageNumber());
		inventoryPo.setCstisupplierid(personInfoPo.getDepartmentID());
		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
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
		departmentsPos=storeGoodsMgr.getFranchisees();
		return SUCCESS;
	}
	
	/**
	 * 新增销售出库
	 */
	public String insertStoreGoods()throws Exception{
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
		
        if("".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditstate("0");
        	inventoryPo.setCstifinanceauditstate("0");
        }
        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditperson(createPerson);
        	inventoryPo.setCstifinanceauditstate("1");
        }
        inventoryPo.setCstisourcebillid(request.getParameter("cstisourcebillid"));

        LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("客户批发调货单:" + inventoryPo.getCstibillid()+"新增!");
		
		int lenth=goodsInfoTempPo.getGoodsid().length;		
		inventoryEntryList=new ArrayList<TracEntryPo>();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		for(int i=0; i<lenth; i++){
			TracEntryPo inventoryEntryPo=new TracEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstieoutstockid(inventoryPo.getCstioutstockid());
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);//单位成本(不含税)
			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);//成本合计(不含税)			
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);//含税单价
			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);//价税合计			
			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);//税额合计				
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);//税率		
			inventoryEntryPo.setCstieoutstorageflag("1");
			inventoryEntryPo.setCstiespec(goodsInfoTempPo.getSpec()[i]);
			inventoryEntryPo.setCstiemaxquantity(goodsInfoTempPo.getCshaaemaxquantity()[i]);
			inventoryEntryPo.setIsSalesFlag("1");
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		
		if(systemParameterPo.getFspsalestype().equals("0")){
			String errorBarcode = "";
			for(int i=0;i<inventoryEntryList.size(); i++){
				GoodsInfoPo goodspo = new GoodsInfoPo();
				goodspo.setBgiwarehouseid(inventoryEntryList.get(i).getCstieoutstockid());
				goodspo.setBgigoodsbarcode(inventoryEntryList.get(i).getCstiebarcode());
				List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
				if(Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity())<Integer.parseInt(inventoryEntryList.get(i).getCstiegoodsquantity())){
					errorBarcode = errorBarcode + inventoryEntryList.get(i).getCstiebarcode()+"\\n";
				}
			}
			
			if(!errorBarcode.equals("")){
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
				departmentsPos=storeGoodsMgr.getFranchisees();
				
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				return "error";
			}
		}
		
		inventoryPo.setIsSalesFlag("1");
		inventoryPo.setCstibilltypeid("3");
		storeGoodsMgr.insertStoreGoods(inventoryPo, inventoryEntryList,null,logPo);
		
		this.clearMessages();		
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		
		String url = "''initStoreGoodsDetails.action?hid={0}&moduleID={1}''";
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
	public String initStoreGoodsDetails()throws Exception{
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
		request.setAttribute("systemParameterPo", systemParameterPo);
		String id=Utility.getName(request.getParameter("hid"));
		inventoryPo =new TracPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=storeGoodsMgr.getStoreGoods(inventoryPo);
		DepartmentsPo dd=storeGoodsMgr.getFranchisee(inventoryPo.getCstisupplierid());
		inventoryPo.setCstisuppliername(dd.getBdpdepartmentname());
		inventoryPo.setDpPerson(dd.getBdpperson());
		inventoryPo.setDpPhone(dd.getBdpphone());
		inventoryEntryList=storeGoodsMgr.getStoreGoodsDetailList(inventoryPo);
		
		String goodsID = Utility.getName(request.getParameter("goodsID"));//库存综合查询，流水里面的单据明细，商品重点显示。
		request.setAttribute("goodsID", goodsID);	
		
		return SUCCESS;
	}
	
	/**
	 * 初始化销售出库修改
	 */
	public String initStoreGoodsUpdate()throws Exception{
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		String id=Utility.getName(request.getParameter("hid"));
		inventoryPo =new TracPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=storeGoodsMgr.getStoreGoods(inventoryPo);
		DepartmentsPo dd=storeGoodsMgr.getFranchisee(inventoryPo.getCstisupplierid());
		inventoryPo.setCstisuppliername(dd.getBdpdepartmentname());
		inventoryPo.setDpPerson(dd.getBdpperson());
		inventoryPo.setDpPhone(dd.getBdpphone());
		inventoryEntryList=storeGoodsMgr.getStoreGoodsEntryList(inventoryPo);
		return SUCCESS;
	}
	/**
	 * 修改销售出库
	 */
	public String updateStoreGoods()throws Exception{
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
		
		int isaudit = billKeyMgr.selectTracForAuditType(inventoryPo.getCstibillid());
		if(isaudit == 1){
			this.clearMessages();
			this.addActionMessage("该单据已被审核，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
        if("".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditstate("0");
        	inventoryPo.setCstifinanceauditstate("0");
        }
        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditperson(personInfoPo.getId());
        	inventoryPo.setCstifinanceauditstate("1");
        }
        inventoryPo.setCstisourcebillid(request.getParameter("cstisourcebillid"));
        inventoryPo.setIsSalesFlag("1");

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("客户批发调货单:"+inventoryPo.getCstibillid()+"修改!");
		
		int lenth=goodsInfoTempPo.getGoodsid().length;
		List<AllocationBarcodePo> allocationBarcodeList=new ArrayList<AllocationBarcodePo>();
		inventoryEntryList = new ArrayList<TracEntryPo>();
		for(int i=0; i<lenth; i++){
			TracEntryPo inventoryEntryPo=new TracEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstieoutstockid(inventoryPo.getCstioutstockid());
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);//单位成本(不含税)
			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);//成本合计(不含税)			
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);//含税单价
			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);//价税合计			
			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);//税额合计				
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);//税率		
			inventoryEntryPo.setCstieoutstorageflag("1");
			inventoryEntryPo.setCstiespec(goodsInfoTempPo.getSpec()[i]);
			inventoryEntryPo.setCstiemaxquantity(goodsInfoTempPo.getCshaaemaxquantity()[i]);
			inventoryEntryPo.setIsSalesFlag("1");
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		
		if(systemParameterPo.getFspsalestype().equals("0")){
			String errorBarcode = "";
			for(int i=0;i<inventoryEntryList.size(); i++){
				GoodsInfoPo goodspo = new GoodsInfoPo();
				goodspo.setBgiwarehouseid(inventoryEntryList.get(i).getCstieoutstockid());
				goodspo.setBgigoodsbarcode(inventoryEntryList.get(i).getCstiebarcode());
				goodspo.setBgiallBillid(inventoryPo.getCstibillid());
				List<GoodsInfoPo> goodsInfoPos = allocationMgr.checkNumber(goodspo);
				if(Integer.parseInt(goodsInfoPos.get(0).getBgigoodsquantity())+Integer.parseInt(goodsInfoPos.get(1).getBgigoodsquantity())<Integer.parseInt(inventoryEntryList.get(i).getCstiegoodsquantity())){
					errorBarcode = errorBarcode + inventoryEntryList.get(i).getCstiebarcode()+"\\n";
				}
			}
			
			if(!errorBarcode.equals("")){
				inventoryPo=storeGoodsMgr.getStoreGoods(inventoryPo);
				DepartmentsPo dd=storeGoodsMgr.getFranchisee(inventoryPo.getCstisupplierid());
				inventoryPo.setCstisuppliername(dd.getBdpdepartmentname());
				inventoryPo.setDpPerson(dd.getBdpperson());
				inventoryPo.setDpPhone(dd.getBdpphone());
				inventoryEntryList=storeGoodsMgr.getStoreGoodsEntryList(inventoryPo);
				
				errorBarcode = errorBarcode + "以上条码商品调拨数量大于可用库存！";
				this.addActionMessage(errorBarcode);
				return "error";
			}
		}
		
		inventoryPo.setCstibilltypeid("3");
		storeGoodsMgr.updateStoreGoods(inventoryPo, inventoryEntryList,allocationBarcodeList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		String url = "''initStoreGoodsDetails.action?hid={0}&moduleID={1}''";
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
	public String initStoreGoodsDelete()throws Exception{
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
		TracPo po=new TracPo();
		po.setCstibillid(id);
		inventoryPo=storeGoodsMgr.getStoreGoods(po);
		
		return SUCCESS;
	}
	/**
	 * 删除销售出库
	 */
	public String deleteStoreGoods()throws Exception{
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
		TracPo po=new TracPo();
		po.setCstibillid(id);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("客户批发调货单:"+po.getCstibillid()+"删除!");
		
		storeGoodsMgr.deleteStoreGoods(po,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	//销售出库选择负调拨单（出库单新增页面使用）
	public String selAllocationBillsOut() throws Exception { 
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
		inventoryEntryList = new ArrayList<TracEntryPo>();
		inventoryEntryList = storeGoodsMgr.getReallocationList(inventoryPo);
		
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
		request.setAttribute("cstisourcebillid", id);
		
		return SUCCESS;
	}
	
	//销售出库选择负调拨单（出库单修改页面使用）
	public String selAllocationBillsUpdateOut() throws Exception { 
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
		inventoryEntryList = new ArrayList<TracEntryPo>();
		inventoryEntryList = storeGoodsMgr.getReallocationList(inventoryPo);
		
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
	
	//退货部分
	
	/**
	 * 初始化销售出库查询
	 */
	public String initStoreReturnGoodsSel()throws Exception{
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
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		//取得登陆人允许操作的仓位&部门 End
		
		CustomerPo customerPo = new CustomerPo();
		customerList = customerMgr.getCustomerList(customerPo);
		departmentsPos=storeGoodsMgr.getFranchisees();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selStoreReturnGoods";
		}
		
		return SUCCESS;
	}
	/**
	 * 查询销售出库
	 */
	public String selStoreReturnGoods()throws Exception{
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
		
		TracPo po=new TracPo();
		po.setCstibillid(billID);
		po.setCstistartTime(startTime);
		po.setCstiendTime(endTime);
		po.setCstioutstockid(outstockID);
		po.setCstisupplierid(customerid);//客户ID
		po.setCstiauditstate(auditState);
		po.setCstidepartmentid(departmentid);
		po.setCstiremark(remark);//备注
		po.setCstigoodsname(goodsName);
		po.setCstigoodsid(goodsId);
		po.setCstiinorout("out");
		po.setBgiretailbeginpricemin(request.getParameter("bgiretailbeginpricemin"));
		po.setBgiretailendpricemax(request.getParameter("bgiretailendpricemax"));
		po.setWhichretail(request.getParameter("whichretail"));
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
		int count=storeGoodsMgr.getStoreGoodsCount(po);
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
	    salesOutList=storeGoodsMgr.getStoreGoodsList(po,page.getStart(),page.getPageSize());
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
		request.setAttribute("bgiretailbeginpricemin", request.getParameter("bgiretailbeginpricemin"));
		request.setAttribute("bgiretailendpricemax", request.getParameter("bgiretailendpricemax"));
		request.setAttribute("whichretail", request.getParameter("whichretail"));
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		warehouseList=warehouseMgr.getWarehouseList(deppo);
		departmentsList = departmentsMgr.getDepartments(deppo);
		//取得登陆人允许操作的仓位&部门 End
		
		CustomerPo customerPo = new CustomerPo();
		customerList = customerMgr.getCustomerList(customerPo);
		departmentsPos=storeGoodsMgr.getFranchisees();

		
		return SUCCESS;
	}
	/**
	 * 初始化销售出库新增
	 */
	public String initStoreReturnGoodsInsert()throws Exception{
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
		inventoryPo=new TracPo();
		
		inventoryPo.setCstibillid("SR"+GenerateNumber.getInstance().getGenerageNumber());
		inventoryPo.setCstisupplierid(personInfoPo.getDepartmentID());
		inventoryPo.setCstidepartmentid(personInfoPo.getDepartmentID());
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
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
		departmentsPos=storeGoodsMgr.getFranchisees();
		return SUCCESS;
	}
	/**
	 * 新增销售出库
	 */
	public String insertStoreReturnGoods()throws Exception{
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
		
        if("".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditstate("0");
        	inventoryPo.setCstifinanceauditstate("0");
        }
        if("1".equals(Utility.getName(inventoryPo.getCstiauditstate()))){
        	inventoryPo.setCstiauditperson(createPerson);
        	inventoryPo.setCstifinanceauditstate("1");
        }
        inventoryPo.setCstisourcebillid(request.getParameter("cstisourcebillid"));

        LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("客户批发退货单:" + inventoryPo.getCstibillid()+"新增!");
		
		int lenth=goodsInfoTempPo.getGoodsid().length;		
		inventoryEntryList=new ArrayList<TracEntryPo>();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String havebatch = Utility.getName(request.getParameter("havebatch"));
		for(int i=0; i<lenth; i++){
			TracEntryPo inventoryEntryPo=new TracEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstieoutstockid(inventoryPo.getCstioutstockid());
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);//单位成本(不含税)
			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);//成本合计(不含税)			
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);//含税单价
			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);//价税合计			
			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);//税额合计				
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);//税率		
			inventoryEntryPo.setCstieoutstorageflag("1");
			inventoryEntryPo.setCstiespec(goodsInfoTempPo.getSpec()[i]);
			if(havebatch.equals("1")){
				inventoryEntryPo.setCstieguaranteeperiod(goodsInfoTempPo.getGuaranteeperiod()[i]); 	//效期
				inventoryEntryPo.setCstiebatch(goodsInfoTempPo.getBatch()[i]);			 	//批号
			}
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		
		inventoryPo.setCstibilltypeid("2");
		storeGoodsMgr.insertStoreGoods(inventoryPo, inventoryEntryList,null,logPo);
		
		this.clearMessages();		
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		
		String url = "''initStoreReturnGoodsDetails.action?hid={0}&moduleID={1}''";
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
	public String initStoreReturnGoodsDetails()throws Exception{
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
		request.setAttribute("systemParameterPo", systemParameterPo);
		String id=Utility.getName(request.getParameter("hid"));
		inventoryPo =new TracPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=storeGoodsMgr.getStoreGoods(inventoryPo);
		DepartmentsPo dd=storeGoodsMgr.getFranchisee(inventoryPo.getCstisupplierid());
		inventoryPo.setCstisuppliername(dd.getBdpdepartmentname());
		inventoryPo.setDpPerson(dd.getBdpperson());
		inventoryPo.setDpPhone(dd.getBdpphone());
		inventoryEntryList=storeGoodsMgr.getStoreGoodsEntryList(inventoryPo);
		allocationBarcodeLists = storeGoodsMgr.getTracBarcode(inventoryPo);
		
		String goodsID = Utility.getName(request.getParameter("goodsID"));//库存综合查询，流水里面的单据明细，商品重点显示。
		request.setAttribute("goodsID", goodsID);	
		
		return SUCCESS;
	}
	
	/**
	 * 初始化销售出库修改
	 */
	public String initStoreReturnGoodsUpdate()throws Exception{
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
		request.setAttribute("systemParameterPo", systemParameterPo);
		String id=Utility.getName(request.getParameter("hid"));
		inventoryPo =new TracPo();
		inventoryPo.setCstibillid(id);
		inventoryPo=storeGoodsMgr.getStoreGoods(inventoryPo);
		DepartmentsPo dd=storeGoodsMgr.getFranchisee(inventoryPo.getCstisupplierid());
		inventoryPo.setCstisuppliername(dd.getBdpdepartmentname());
		inventoryPo.setDpPerson(dd.getBdpperson());
		inventoryPo.setDpPhone(dd.getBdpphone());
		inventoryEntryList=storeGoodsMgr.getStoreGoodsEntryList(inventoryPo);
		allocationBarcodeLists = storeGoodsMgr.getTracBarcode(inventoryPo);
		return SUCCESS;
	}
	/**
	 * 修改销售出库
	 */
	public String updateStoreReturnGoods()throws Exception{
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
		
		int isaudit = billKeyMgr.selectTracForAuditType(inventoryPo.getCstibillid());
		if(isaudit == 1){
			this.clearMessages();
			this.addActionMessage("该单据已被审核，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
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
		logPo.setsLogContent("客户批发退货单:"+inventoryPo.getCstibillid()+"修改!");
		
		int lenth=goodsInfoTempPo.getGoodsid().length;
		List<AllocationBarcodePo> allocationBarcodeList=new ArrayList<AllocationBarcodePo>();
		inventoryEntryList = new ArrayList<TracEntryPo>();
		for(int i=0; i<lenth; i++){
			TracEntryPo inventoryEntryPo=new TracEntryPo();
			inventoryEntryPo.setCstiebillid(inventoryPo.getCstibillid());
			inventoryEntryPo.setCstiegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			inventoryEntryPo.setCstiegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			inventoryEntryPo.setCstiebarcode(goodsInfoTempPo.getGoodsbarcode()[i]);
			inventoryEntryPo.setCstiegoodsquantity(goodsInfoTempPo.getGoodsquantity()[i]);
			inventoryEntryPo.setCstieoutstockid(inventoryPo.getCstioutstockid());
			inventoryEntryPo.setCstienottaxrate(goodsInfoTempPo.getNottaxrate()[i]);//单位成本(不含税)
			inventoryEntryPo.setCstienottaxrateamount(goodsInfoTempPo.getNottaxrateamount()[i]);//成本合计(不含税)			
			inventoryEntryPo.setCstiecostprice(goodsInfoTempPo.getCostprice()[i]);//含税单价
			inventoryEntryPo.setCstiecostpriceamount(goodsInfoTempPo.getCostpriceamount()[i]);//价税合计			
			inventoryEntryPo.setCstietaxamount(goodsInfoTempPo.getTaxamount()[i]);//税额合计				
			inventoryEntryPo.setCstietaxrate(goodsInfoTempPo.getTaxrate()[i]);//税率		
			inventoryEntryPo.setCstieoutstorageflag("1");
			inventoryEntryPo.setCstiespec(goodsInfoTempPo.getSpec()[i]);
			
			inventoryEntryList.add(inventoryEntryPo);
		}
		
		inventoryPo.setCstibilltypeid("2");
		storeGoodsMgr.updateStoreGoods(inventoryPo, inventoryEntryList,allocationBarcodeList,logPo);
		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		String url = "''initStoreReturnGoodsDetails.action?hid={0}&moduleID={1}''";
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
	public String initStoreReturnGoodsDelete()throws Exception{
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
		TracPo po=new TracPo();
		po.setCstibillid(id);
		inventoryPo=storeGoodsMgr.getStoreGoods(po);
		
		return SUCCESS;
	}
	/**
	 * 删除销售出库
	 */
	public String deleteStoreReturnGoods()throws Exception{
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
		TracPo po=new TracPo();
		po.setCstibillid(id);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("客户批发退货单:"+po.getCstibillid()+"删除!");
		
		storeGoodsMgr.deleteStoreGoods(po,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	//销售出库选择负调拨单（出库单新增页面使用）
	public String selAllocationReturnBillsOut() throws Exception { 
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
		inventoryEntryList = new ArrayList<TracEntryPo>();
		inventoryEntryList = storeGoodsMgr.getReallocationList(inventoryPo);
		
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
		request.setAttribute("cstisourcebillid", id);
		
		return SUCCESS;

	}
	
	//销售出库选择负调拨单（出库单修改页面使用）
	public String selAllocationReturnBillsUpdateOut() throws Exception { 
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
		inventoryEntryList = new ArrayList<TracEntryPo>();
		inventoryEntryList = storeGoodsMgr.getReallocationList(inventoryPo);
		
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
	
	public String selStoreStockGoodsForBrandInsert() throws Exception { 
		/* ********************** 权限设置 ***************************** */
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
		
		
		String brandid=Utility.getName(request.getParameter("brandid"));
		String outstockid=Utility.getName(request.getParameter("outstockid"));
		
		inventoryPo.setCstigoodsid(brandid);
		inventoryPo.setCstioutstockid(outstockid);
		inventoryEntryList = new ArrayList<TracEntryPo>();
		inventoryEntryList = procurementReturnMgr.getStoreStockGoodsForBrand(inventoryPo);
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		warehouseList = warehouseMgr.getWarehouseList(po);

		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		departmentsPos=storeGoodsMgr.getFranchisees();
		
		return SUCCESS;

	}
	
	public String selStoreStockGoodsForBrandUpdate() throws Exception { 
		/* ********************** 权限设置 ***************************** */
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
		
		
		String brandid=Utility.getName(request.getParameter("brandid"));
		String outstockid=Utility.getName(request.getParameter("outstockid"));
		
		inventoryPo.setCstigoodsid(brandid);
		inventoryPo.setCstioutstockid(outstockid);
		inventoryEntryList = new ArrayList<TracEntryPo>();
		inventoryEntryList = procurementReturnMgr.getStoreStockGoodsForBrand(inventoryPo);
		
		////默认仓位////
		warehouseConfigurationPo= new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		////默认仓位////
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		warehouseList = warehouseMgr.getWarehouseList(po);

		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		request.setAttribute("StatusID", "0");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		inventoryPo=storeGoodsMgr.getStoreGoods(inventoryPo);
		DepartmentsPo dd=storeGoodsMgr.getFranchisee(inventoryPo.getCstisupplierid());
		inventoryPo.setCstisuppliername(dd.getBdpdepartmentname());
		inventoryPo.setDpPerson(dd.getBdpperson());
		inventoryPo.setDpPhone(dd.getBdpphone());
		departmentsPos=storeGoodsMgr.getFranchisees();
		
		return SUCCESS;

	}
	
	/**
	 * 商品批发申请查询
	 */
	public String selApplyWholeForAppOpen() {
		
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
		String type = Utility.getName(request.getParameter("type"));
		request.setAttribute("type", type);
		
		String departmentType = personInfoPo1.getDepartmenttype();
		request.setAttribute("departmentType", departmentType);

		request.setAttribute("sysDepartment", personInfoPo1.getDepartmentID()); 
		String billID=Utility.getName(request.getParameter("billID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String auditState=Utility.getName(request.getParameter("auditState"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String createPersonName=Utility.getName(request.getParameter("createPersonName"));//制单人
		String auditPersonName=Utility.getName(request.getParameter("auditPersonName"));//审核人
		String chaasupplier=Utility.getName(request.getParameter("chaasupplier"));//制造商
		String bspsuppliername=Utility.getName(request.getParameter("bspsuppliername"));//制造商
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String goodsName=Utility.getName(request.getParameter("goodsName"));
		String remark=Utility.getName(request.getParameter("remark"));
		String brandID=Utility.getName(request.getParameter("brandID"));
		String brandName=Utility.getName(request.getParameter("brandName"));
		String goodsId=Utility.getName(request.getParameter("goodsId"));
		
		request.setAttribute("createPersonName",createPersonName);
		request.setAttribute("auditPersonName",auditPersonName);
		request.setAttribute("auditPersonName", request.getParameter("auditPersonName"));
		request.setAttribute("createPersonName",request.getParameter("createPersonName") );
		request.setAttribute("goodsName",goodsName);		
		request.setAttribute("goodsId",goodsId);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		
		PersonInfoPo personInfoPo=(PersonInfoPo) session.get("person");
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		
		WholePo wholePo=new WholePo();
		wholePo.setCshawbillid(billID);
		wholePo.setCshawindepartmentid(departmentID);
		wholePo.setCshawstartTime(startTime);
		wholePo.setCshawendTime(endTime);
		wholePo.setCshawauditstate(auditState);
		wholePo.setCshawauditdatestart(startTime1);
		wholePo.setCshawauditdateend(endTime1);
		wholePo.setGoodscategoryid(goodscategoryID);
		wholePo.setChaasupplier(chaasupplier);		
		wholePo.setCshawcreateperson(createPersonName);
		wholePo.setCshawauditperson(auditPersonName);
		wholePo.setCshawflag("1");//正批发申请
		wholePo.setChaagoodsname(goodsName);
		wholePo.setChaagoodsid(goodsId);
		wholePo.setCshawremark(remark);
		wholePo.setChaabrand(brandID);
		wholePo.setChaabrandname(brandName);
		
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
		
		int count=wholeApplyForAppMgr.getWholeCount(wholePo,deppo);
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
	    wholeList=wholeApplyForAppMgr.getWholeList(wholePo,deppo,page.getStart(),page.getPageSize());
	    departmentsPos = storeGoodsMgr.getFranchisees();
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			wholeList = null;
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
		
		return SUCCESS;
	}
	
	
	/**
	 * 客户批发申请开窗赋值
	 */
	public String initWholeApplyGoodsOpenSetValue()throws Exception{
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
		String type = Utility.getName(request.getParameter("type"));
		request.setAttribute("type", type);
		
		String outstockid = Utility.getName(request.getParameter("outstockid"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		String id=Utility.getName(request.getParameter("hid"));
		DepartmentsPo dd=storeGoodsMgr.getFranchisee(inventoryPo.getCstisupplierid());
		
		TracPo po = new TracPo();
		
		po.setCstibillid(id);
		po.setCstisuppliername(dd.getBdpdepartmentname());
		po.setDpPerson(dd.getBdpperson());
		po.setDpPhone(dd.getBdpphone());
		po.setCstioutstockid(outstockid);
		po.setCstiisbatch(systemParameterPo.getFspstealtheffective());
		
		inventoryEntryList=storeGoodsMgr.getWholeApplyGoodsEntryList(po);
		
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
		
		DepartmentsPo dpo=new DepartmentsPo();
		dpo.setBdpisclosed("0");
		departmentsPos=storeGoodsMgr.getFranchisees(dpo);
		
		if("update".equals(type)){
			return "update";
		}else{
			return "insert";
		}
	}
	
	public StoreGoodsMgr getStoreGoodsMgr() {
		return storeGoodsMgr;
	}
	public void setStoreGoodsMgr(StoreGoodsMgr storeGoodsMgr) {
		this.storeGoodsMgr = storeGoodsMgr;
	}
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	public CustomerMgr getCustomerMgr() {
		return customerMgr;
	}
	public void setCustomerMgr(CustomerMgr customerMgr) {
		this.customerMgr = customerMgr;
	}
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
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
	public String getIsFirstExec() {
		return isFirstExec;
	}
	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}
	public TracPo getInventoryPo() {
		return inventoryPo;
	}
	public void setInventoryPo(TracPo inventoryPo) {
		this.inventoryPo = inventoryPo;
	}
	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}
	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}
	public List<TracEntryPo> getInventoryEntryList() {
		return inventoryEntryList;
	}
	public void setInventoryEntryList(List<TracEntryPo> inventoryEntryList) {
		this.inventoryEntryList = inventoryEntryList;
	}
	public List<TracPo> getSalesOutList() {
		return salesOutList;
	}
	public void setSalesOutList(List<TracPo> salesOutList) {
		this.salesOutList = salesOutList;
	}
	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}
	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}
	public List<CustomerPo> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<CustomerPo> customerList) {
		this.customerList = customerList;
	}
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}
	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}
	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
	}
	public List<AllocationBarcodePo> getAllocationBarcodeLists() {
		return allocationBarcodeLists;
	}
	public void setAllocationBarcodeLists(
			List<AllocationBarcodePo> allocationBarcodeLists) {
		this.allocationBarcodeLists = allocationBarcodeLists;
	}
	public List<DepartmentsPo> getDepartmentsPos() {
		return departmentsPos;
	}
	public void setDepartmentsPos(List<DepartmentsPo> departmentsPos) {
		this.departmentsPos = departmentsPos;
	}
	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}
	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
	}
	public ProcurementReturnMgr getProcurementReturnMgr() {
		return procurementReturnMgr;
	}
	public void setProcurementReturnMgr(ProcurementReturnMgr procurementReturnMgr) {
		this.procurementReturnMgr = procurementReturnMgr;
	}
	public List<WholePo> getWholeList() {
		return wholeList;
	}
	public void setWholeList(List<WholePo> wholeList) {
		this.wholeList = wholeList;
	}
	public WholeApplyForAppMgr getWholeApplyForAppMgr() {
		return wholeApplyForAppMgr;
	}
	public void setWholeApplyForAppMgr(WholeApplyForAppMgr wholeApplyForAppMgr) {
		this.wholeApplyForAppMgr = wholeApplyForAppMgr;
	}
}
