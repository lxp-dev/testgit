package com.pengsheng.eims.storage.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.dao.PessimisticLockingFailureException;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.NonconformingProductPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.mgr.NonconformingMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ReAllocationAction extends BaseAction{ 
	private AllocationPo allocationPo;
	
	private AllocationMgr allocationMgr;
	
	private WarehouseMgr warehouseMgr;
	
	private DepartmentsMgr departmentsMgr;
	
	private List<WarehousePo> inwarehouselist;
	
	private List<WarehousePo> outwarehouselist;
	
	private GoodsInfoTempPo goodsInfoTempPo;
	
	private List<AllocationEntryPo> allocationEntryList;
	
	private List<DepartmentsPo> departmentsList;
	
	private List<AllocationPo> allocationList;
	
	private List<DepartmentsPo> indepartmentsList;
	
	private List<AllocationBarcodePo> allocationBarcodeLists;
	
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
	public List<AllocationBarcodePo> getAllocationBarcodeLists() {
		return allocationBarcodeLists;
	}
	public void setAllocationBarcodeLists(
			List<AllocationBarcodePo> allocationBarcodeLists) {
		this.allocationBarcodeLists = allocationBarcodeLists;
	}
	private PersonInfoMgr personInfoMgr;
	
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}
	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}
	public List<AllocationPo> getAllocationList() {
		return allocationList;
	}
	public void setAllocationList(List<AllocationPo> allocationList) {
		this.allocationList = allocationList;
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
	public List<AllocationEntryPo> getAllocationEntryList() {
		return allocationEntryList;
	}
	public void setAllocationEntryList(List<AllocationEntryPo> allocationEntryList) {
		this.allocationEntryList = allocationEntryList;
	}
	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}
	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}
	public AllocationPo getAllocationPo() {
		return allocationPo;
	}
	public void setAllocationPo(AllocationPo allocationPo) {
		this.allocationPo = allocationPo;
	}
	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}
	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
	}
	
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	public List<WarehousePo> getInwarehouselist() {
		return inwarehouselist;
	}
	public void setInwarehouselist(List<WarehousePo> inwarehouselist) {
		this.inwarehouselist = inwarehouselist;
	}
	public List<WarehousePo> getOutwarehouselist() {
		return outwarehouselist;
	}
	public void setOutwarehouselist(List<WarehousePo> outwarehouselist) {
		this.outwarehouselist = outwarehouselist;
	}
	public List<DepartmentsPo> getIndepartmentsList() {
		return indepartmentsList;
	}
	public void setIndepartmentsList(List<DepartmentsPo> indepartmentsList) {
		this.indepartmentsList = indepartmentsList;
	}
	/**
	 * 查询商品调拨初始化
	 */
	public String initReAllocationSel() {
		

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
		departmentsList = departmentsMgr.getDepartments(deppo);		
		
		return SUCCESS;
	}	
	/**
	 * 商品调拨查询
	 */
	public String selReAllocation() {
		
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
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String auditState=Utility.getName(request.getParameter("auditState"));
		String consignState = Utility.getName(request.getParameter("consignState"));
		String cshaacreateperson=Utility.getName(request.getParameter("createPersonID"));//制单人
		String cshaaauditperson=Utility.getName(request.getParameter("auditPersonID"));//审核人
		String cshaaconsignee=Utility.getName(request.getParameter("consigneePersonID"));//收货人
		request.setAttribute("selcreatePersonID",cshaacreateperson);
		request.setAttribute("selauditPersonID",cshaaauditperson);
		request.setAttribute("selconsigneePersonID",cshaaconsignee);
		request.setAttribute("auditPersonName", request.getParameter("auditPersonName"));
		request.setAttribute("createPersonName",request.getParameter("createPersonName") );
		request.setAttribute("consigneePersonName",request.getParameter("consigneePersonName") );
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		
		AllocationPo allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaoutdepartmentid(departmentID);
		allocationPo.setCshaastartTime(startTime);
		allocationPo.setCshaaendTime(endTime);
		allocationPo.setCshaaauditstate(auditState);
		allocationPo.setCshaaconsignstate(consignState);
		
		allocationPo.setCshaacreateperson(cshaacreateperson);
		allocationPo.setCshaaauditperson(cshaaauditperson);
		allocationPo.setCshaaconsignee(cshaaconsignee);
		allocationPo.setCshaaflag("2");//副调拨
		int count=allocationMgr.getReAllocationCount(allocationPo,deppo);
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
	    allocationList=allocationMgr.getReAllocationList(allocationPo,deppo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			allocationList = null;
		}

		//取得登陆人允许操作的仓位&部门 Begin		
		
		departmentsList = departmentsMgr.getDepartments(deppo);				
		
		request.setAttribute("billID",billID);
		request.setAttribute("startTime",startTime);
		request.setAttribute("endTime",endTime);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("auditState",auditState);
		request.setAttribute("consignState",consignState);		
		
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));
		
		return SUCCESS;
	}
	/**
	 * 新增商品调拨初始化
	 */
	public String initReAllocationInsert() {
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
		
		String billID="ALL"+GenerateNumber.getInstance().getGenerageNumber();
		allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		allocationPo.setCshaaoutdepartmentid(personInfoPo.getDepartmentID());
		allocationPo.setCshaaoutdepartmentname(personInfoPo.getBdpdepartmentname());
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		
		//inwarehouselist=warehouseMgr.getWarehouseForAllocationList(deppo);
////		outwarehouselist=warehouseMgr.getWarehouseForAllocationList(deppo);		
		indepartmentsList=departmentsMgr.getDepartments("3"); //副调拨接收部门只有营运部
		//发出仓位，如果是门店
		if(personInfoPo.getDepartmenttype().equals("1")){
			outwarehouselist=warehouseMgr.getWarehouseForSalesList(personInfoPo.getDepartmentID());
		}else if(personInfoPo.getDepartmenttype().equals("2")){//区域
			//outwarehouselist=warehouseMgr.getWarehouseListForReg(personInfoPo.getDepartmentID());//同仁
			outwarehouselist=warehouseMgr.getWarehouseForSalesList(personInfoPo.getDepartmentID());//眼科
		}else{
			outwarehouselist=warehouseMgr.getWarehouseForStorageList();
		}
		
		//接收仓位只能是营运部仓
		
		inwarehouselist=warehouseMgr.getWarehouseForStorageList();	
		return SUCCESS;
	}	
	/**
	 * 商品调拨新增
	 */
	public String insertReAllocation() {
		
        if("".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
        	allocationPo.setCshaaauditstate("0");
        }
        
        List<PersonInfoPo> personInfoList=null;
        SmsLertsPo smsLertsPo=new SmsLertsPo();
        PersonInfoPo tempPersonInfoPo = new PersonInfoPo();
    	tempPersonInfoPo.setAllocationFlag("1");
    	WarehousePo tempWarehousePo = new WarehousePo();
    	tempWarehousePo.setBwhid(allocationPo.getCshaaoutstockid());
    	DepartmentsPo departmentsPo=warehouseMgr.getDepartments(tempWarehousePo);
    	
    	WarehousePo inWarehousePo = new WarehousePo();
    	inWarehousePo.setBwhid(allocationPo.getCshaainstockid());
    	WarehousePo outWarehousePo = new WarehousePo();
    	outWarehousePo.setBwhid(allocationPo.getCshaaoutstockid());
    	outWarehousePo=warehouseMgr.getWarehouse(outWarehousePo);
    	inWarehousePo=warehouseMgr.getWarehouse(inWarehousePo);
    	
    	smsLertsPo.setCstslcontent("<a href='initAllocationUpdate.action?hid="+allocationPo.getCshaabillid()+"&smsFlag=1'>点击查看详情</a>");
    	smsLertsPo.setCstsltitle(inWarehousePo.getBwhwarehouseName()+"向"+outWarehousePo.getBwhwarehouseName()+"申请调拨,调拨单号!"+allocationPo.getCshaabillid());
    	if(((PersonInfoPo)session.get("person")).getDepartmentID().equals(departmentsPo.getBdpdepartmentid())&&"1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){ //如果出仓时自己本门店,并审核，往收入仓位关联部门
    		tempWarehousePo.setBwhid(allocationPo.getCshaainstockid());
    		departmentsPo=warehouseMgr.getDepartments(tempWarehousePo);
    		smsLertsPo.setCstslcontent("<a href='allocationDetails.action?hid="+allocationPo.getCshaabillid()+"&smsFlag=1'>点击查看详情</a>");
    		smsLertsPo.setCstsltitle(outWarehousePo.getBwhwarehouseName()+"给"+inWarehousePo.getBwhwarehouseName()+"做一调拨单号!"+allocationPo.getCshaabillid());
    	}
    	
    	
    	tempPersonInfoPo.setDepartmentID(departmentsPo.getBdpdepartmentid());
    	
    	 personInfoList = personInfoMgr.getPersonInfos(tempPersonInfoPo, 0, personInfoMgr.getPersoninfosCount(tempPersonInfoPo));
    	 
    	 if(((PersonInfoPo)session.get("person")).getDepartmentID().equals(departmentsPo.getBdpdepartmentid())&&"0".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
    		 personInfoList=null;
     	}
    	
    	
    	smsLertsPo.setCstslsendperson(((PersonInfoPo)session.get("person")).getId());
    	smsLertsPo.setCstslsenddepartment(((PersonInfoPo)session.get("person")).getDepartmentID());
        if("1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
        	allocationPo.setCshaaauditperson(allocationPo.getCshaacreateperson());
        }
        
        WarehousePo warehousePo=new WarehousePo();
        warehousePo.setBwhid(allocationPo.getCshaainstockid());
//        DepartmentsPo deptPo=warehouseMgr.getDepartments(warehousePo);
//        allocationPo.setCshaaindepartmentid(deptPo.getBdpdepartmentid());
//        allocationPo.setCshaaindepartmentname(deptPo.getBdpdepartmentname());
        
		int lenth=goodsInfoTempPo.getGoodsid().length;

		allocationEntryList=new ArrayList<AllocationEntryPo>();
		
		AllocationBarcodePo allocationBarcodePo=null;
		
		List<AllocationBarcodePo> allocationBarcodeList=new ArrayList<AllocationBarcodePo>();
		for(int i=0;i<lenth;i++){
			AllocationEntryPo allocationEntryPo=new AllocationEntryPo();
			allocationEntryPo.setCshaaebillid(allocationPo.getCshaabillid());
			allocationEntryPo.setCshaaegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			allocationEntryPo.setCshaaoutstockid(allocationPo.getCshaaoutstockid());
			allocationEntryPo.setCshaainstockid(allocationPo.getCshaainstockid());
			allocationEntryPo.setCshaaeallocationquantity(goodsInfoTempPo.getGoodsquantity()!=null?goodsInfoTempPo.getGoodsquantity()[i]:"0");
			allocationEntryPo.setCshaaGoodsBarCode(goodsInfoTempPo.getGoodsbarcode()!=null?goodsInfoTempPo.getGoodsbarcode()[i]:""); // 新增时加入商品条码
			allocationEntryPo.setCshaaerequirementquantity(request.getParameterValues("needNumber")!=null?request.getParameterValues("needNumber")[i]:"0");
			String goodsID=goodsInfoTempPo.getGoodsid()[i];
			allocationEntryList.add(allocationEntryPo);
			
			
			/*
			 * 调拨条码
			 */
			if(goodsInfoTempPo.getGoodsbarcode()!=null){
				String barcode=goodsInfoTempPo.getGoodsid()[i].replace(".", "");
				for(int k=0;k<goodsInfoTempPo.getGoodsbarcode().length;k++){
					if(goodsInfoTempPo.getGoodsbarcode()[k].substring(0,18).equals(barcode.toUpperCase())){
						allocationBarcodePo = new AllocationBarcodePo();
						allocationBarcodePo.setCshabgoodsbarcode(goodsInfoTempPo.getGoodsbarcode()[k]);
						allocationBarcodePo.setCshabbillid(allocationPo.getCshaabillid());
						allocationBarcodePo.setCshabgoodsid(goodsID);
						allocationBarcodeList.add(allocationBarcodePo);
					}
				}
			}
		}
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(((PersonInfoPo)session.get("person")).getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("商品负调拨："+allocationPo.getCshaabillid()+"新增");

		
		allocationPo.setCshaaflag("2");//副调拨
		
		allocationMgr.insertAllocation(allocationPo, allocationEntryList,smsLertsPo,personInfoList,allocationBarcodeList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	/**
	 * 修改商品调拨初始化
	 */
	public String initReAllocationUpdate() {
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
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		allocationPo=allocationMgr.getAllocation(po);
		allocationEntryList=allocationMgr.getAllocationEntryList(po);
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");	
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		
		//inwarehouselist=warehouseMgr.getWarehouseForAllocationList(deppo);
//		outwarehouselist=warehouseMgr.getWarehouseForAllocationList(deppo);		
//		indepartmentsList=departmentsMgr.getDepartmentsForAllocation(deppo);
//		
		allocationBarcodeLists=allocationMgr.getAllocationBarcode(po);
		
		indepartmentsList=departmentsMgr.getDepartments("3"); //副调拨接收部门只有营运部
		//发出仓位，如果是门店
		if(personInfoPo.getDepartmenttype().equals("1")){
			outwarehouselist=warehouseMgr.getWarehouseForSalesList(allocationPo.getCshaaoutdepartmentid());
		}else if(personInfoPo.getDepartmenttype().equals("2")){//区域
			//outwarehouselist=warehouseMgr.getWarehouseListForReg(personInfoPo.getDepartmentID());//同仁
			outwarehouselist=warehouseMgr.getWarehouseForSalesList(allocationPo.getCshaaoutdepartmentid());//眼科
		}else{
			outwarehouselist=warehouseMgr.getWarehouseForSalesList(allocationPo.getCshaaoutdepartmentid());
			//outwarehouselist=warehouseMgr.getWarehouseForStorageList();
		}
		
		//接收仓位只能是营运部仓
		
		inwarehouselist=warehouseMgr.getWarehouseForSalesList(allocationPo.getCshaaindepartmentid());
		
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		return SUCCESS;
	}	
	/**
	 * 商品调拨修改
	 */
	public String updateReAllocation() {
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
        if("".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
        	allocationPo.setCshaaauditstate("0");
        }
        List<PersonInfoPo> personInfoList=null;
        SmsLertsPo smsLertsPo=new SmsLertsPo();
        PersonInfoPo tempPersonInfoPo = new PersonInfoPo();
    	tempPersonInfoPo.setAllocationFlag("1");
    	WarehousePo tempWarehousePo = new WarehousePo();
    	tempWarehousePo.setBwhid(allocationPo.getCshaaoutstockid());
    	
    	WarehousePo inWarehousePo = new WarehousePo();
    	inWarehousePo.setBwhid(allocationPo.getCshaainstockid());
    	WarehousePo outWarehousePo = new WarehousePo();
    	outWarehousePo.setBwhid(allocationPo.getCshaaoutstockid());
    	outWarehousePo=warehouseMgr.getWarehouse(outWarehousePo);
    	inWarehousePo=warehouseMgr.getWarehouse(inWarehousePo);
    	
    	DepartmentsPo departmentsPo=warehouseMgr.getDepartments(tempWarehousePo);
    	DepartmentsPo indepartmentsPo=warehouseMgr.getDepartments(inWarehousePo);
		tempPersonInfoPo.setDepartmentID(indepartmentsPo.getBdpdepartmentid());
    	if("1".equals(personInfoPo.getDepartmenttype())){ //如果是门店
    		if(Utility.getName(allocationPo.getCshaaauditstate()).equals("1")){ //如果审核
    			if(personInfoPo.getDepartmentID().equals(departmentsPo.getBdpdepartmentid())){ //如果发出仓位是自己本门店
    				smsLertsPo.setCstsltitle(outWarehousePo.getBwhwarehouseName()+"给"+inWarehousePo.getBwhwarehouseName()+"做一调拨,调拨单号!"+allocationPo.getCshaabillid());
    		    	smsLertsPo.setCstslcontent("<a href='initAllocationUpdate.action?hid="+allocationPo.getCshaabillid()+"&smsFlag=1'>点击查看详情</a>");
    		    	 personInfoList = personInfoMgr.getPersonInfos(tempPersonInfoPo, 0, personInfoMgr.getPersoninfosCount(tempPersonInfoPo));
    			}
    		}
    	}else if("3".equals(personInfoPo.getDepartmenttype())){//如果是仓储
    		if(Utility.getName(allocationPo.getCshaaauditstate()).equals("1")){ //如果审核
    			smsLertsPo.setCstsltitle(outWarehousePo.getBwhwarehouseName()+"同意了"+inWarehousePo.getBwhwarehouseName()+"的采购申请,调拨单号"+allocationPo.getCshaabillid());
		    	smsLertsPo.setCstslcontent("<a href='allocationDetails.action?hid="+allocationPo.getCshaabillid()+"&smsFlag=1'>点击查看详情</a>");
		    	 personInfoList = personInfoMgr.getPersonInfos(tempPersonInfoPo, 0, personInfoMgr.getPersoninfosCount(tempPersonInfoPo));
    		}
    	}
    	
    	smsLertsPo.setCstslsendperson(((PersonInfoPo)session.get("person")).getId());
    	smsLertsPo.setCstslsenddepartment(((PersonInfoPo)session.get("person")).getDepartmentID());
    	
        if("1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
        	allocationPo.setCshaaauditperson(allocationPo.getCshaacreateperson());
        }
        
        WarehousePo warehousePo=new WarehousePo();
        warehousePo.setBwhid(allocationPo.getCshaainstockid());
//        DepartmentsPo deptPo=warehouseMgr.getDepartments(warehousePo);
//        allocationPo.setCshaaindepartmentid(deptPo.getBdpdepartmentid());
//        allocationPo.setCshaaindepartmentname(deptPo.getBdpdepartmentname());
        
		int lenth=goodsInfoTempPo.getGoodsid().length;
		AllocationBarcodePo allocationBarcodePo=null;
		
		List<AllocationBarcodePo> allocationBarcodeList=new ArrayList<AllocationBarcodePo>();;
		allocationEntryList=new ArrayList<AllocationEntryPo>();
		for(int i=0;i<lenth;i++){
			AllocationEntryPo allocationEntryPo=new AllocationEntryPo();
			allocationEntryPo.setCshaaebillid(allocationPo.getCshaabillid());
			allocationEntryPo.setCshaaegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			allocationEntryPo.setCshaaoutstockid(allocationPo.getCshaaoutstockid());
			allocationEntryPo.setCshaainstockid(allocationPo.getCshaainstockid());
			allocationEntryPo.setCshaaerequirementquantity(request.getParameterValues("needNumber")!=null?request.getParameterValues("needNumber")[i]:"0");
			allocationEntryPo.setCshaaeallocationquantity(goodsInfoTempPo.getGoodsquantity()!=null?goodsInfoTempPo.getGoodsquantity()[i]:"0");
			
			String goodsID=goodsInfoTempPo.getGoodsid()[i];
			allocationEntryList.add(allocationEntryPo);
		
			if(goodsInfoTempPo.getGoodsbarcode()!=null){
				String barcode=goodsInfoTempPo.getGoodsid()[i].replace(".", "");
				for(int k=0;k<goodsInfoTempPo.getGoodsbarcode().length;k++){
					if(goodsInfoTempPo.getGoodsbarcode()[k].substring(0,18).equals(barcode.toUpperCase())){
						allocationBarcodePo = new AllocationBarcodePo();
						allocationBarcodePo.setCshabgoodsbarcode(goodsInfoTempPo.getGoodsbarcode()[k]);
						allocationBarcodePo.setCshabbillid(allocationPo.getCshaabillid());
						allocationBarcodePo.setCshabgoodsid(goodsID);
						allocationBarcodeList.add(allocationBarcodePo);
					}
				}
			}

		}
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("商品负调拨："+allocationPo.getCshaabillid()+"修改");

		
		allocationMgr.updateAllocation(allocationPo, allocationEntryList, smsLertsPo,personInfoList,allocationBarcodeList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
		if(Utility.getName(request.getParameter("smsFlag")).equals("1")){
			request.setAttribute("flag",GlobalConstants.MOVE);
			request.setAttribute("url", "'selectSms.action'");
		}else{
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		}
		return SUCCESS;
	}
	/**
	 * 删除商品调拨初始化
	 */
	public String initReAllocationDelete() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		
		String id=Utility.getName(request.getParameter("hid"));
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		allocationPo=allocationMgr.getAllocation(po);
		
		return SUCCESS;
	}	
	/**
	 * 商品调拨删除
	 */
	public String deleteReAllocation() {
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String id=Utility.getName(request.getParameter("hid"));
		
		List<PersonInfoPo> personInfoList=null;
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		AllocationPo tempAllocationPo = new AllocationPo();
		tempAllocationPo=allocationMgr.getAllocation(po);
		if("1".equals(personInfoPo.getDepartmenttype())){
			WarehousePo warehousePo=new WarehousePo();
			warehousePo.setBwhid(tempAllocationPo.getCshaaoutstockid());
			DepartmentsPo departmentsPo=warehouseMgr.getDepartments(warehousePo);
			PersonInfoPo tempPersonInfoPo = new PersonInfoPo();
	    	tempPersonInfoPo.setAllocationFlag("1");
	    	tempPersonInfoPo.setDepartmentID(departmentsPo.getBdpdepartmentid());
	    	personInfoList = personInfoMgr.getPersonInfos(tempPersonInfoPo, 0, personInfoMgr.getPersoninfosCount(tempPersonInfoPo));
		}
		
		SmsLertsPo smsLertsPo = new SmsLertsPo();
		smsLertsPo.setCstsltitle("调拨单"+id+"已删除");
    	smsLertsPo.setCstslcontent("调拨单"+id+"已删除");
    	smsLertsPo.setCstslsenddepartment(personInfoPo.getDepartmentID());
    	smsLertsPo.setCstslsendperson(personInfoPo.getId());
    	
    	String moduleID = Utility.getName(request.getParameter("moduleID"));
    	request.setAttribute("moduleID", moduleID);
    	
    	LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 删除
		logPo.setsLogContent("商品负调拨："+po.getCshaabillid()+"删除");

    	
		allocationMgr.deleteAllocation(po,personInfoList,smsLertsPo,logPo,po);
				
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	/**
	 * 商品调拨明细
	 */
	public String reAllocationDetails() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id=Utility.getName(request.getParameter("hid"));
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		allocationPo=allocationMgr.getAllocation(po);
		allocationEntryList=allocationMgr.getAllocationEntryList(po);
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		inwarehouselist=warehouseMgr.getWarehouseForSalesList(allocationPo.getCshaaindepartmentid());
		outwarehouselist=warehouseMgr.getWarehouseList(deppo);
		allocationBarcodeLists=allocationMgr.getAllocationBarcode(po);
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		
		String auditperson=Utility.getName(allocationPo.getCshaaauditperson());
		PersonInfoPo po1= new PersonInfoPo();
		po1.setId(auditperson);
		if(!auditperson.equals("")){
			po1=personInfoMgr.getPersonInfo(po1);
		}
		
		allocationEntryList=allocationMgr.getAllocationEntryList(po);
		request.setAttribute("receiveDep", po1.getDepartmentID());
		deppo.setBdptype("1");
		outwarehouselist=warehouseMgr.getWarehouseForAllocationList(deppo);
		return SUCCESS;
	}
	/**
	 * 商品调拨收货
	 */
	public String reReceiveAllocation() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		String cshaabillid=Utility.getName(request.getParameter("cshaabillid"));
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");	
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(cshaabillid);
		po.setCshaainstockid(allocationPo.getCshaainstockid());//获取接受仓位
		po.setCshaaconsignee(personInfoPo.getId());
		po.setCshaaconsignstate("1");
		int countnumber=allocationMgr.getAllocationCount(po);
		if(countnumber>0)
		{
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.update.sucess"));
			
			if(Utility.getName(request.getParameter("smsFlag")).equals("1")){
				request.setAttribute("flag",GlobalConstants.MOVE);
				request.setAttribute("url", "'selectSms.action'");
			}else{
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			}
			
		}
		else{
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(personInfoPo.getId());
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 模块ID
			logPo.setsLogOpID("37");    // 确认收货
			logPo.setsLogContent("商品负调拨："+cshaabillid+"收货");
			
	  		//allocationMgr.updateAllocationReceive(po,logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.update.sucess"));
			
			if(Utility.getName(request.getParameter("smsFlag")).equals("1")){
				request.setAttribute("flag",GlobalConstants.MOVE);
				request.setAttribute("url", "'selectSms.action'");
			}else{
				request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			}
		}
		return SUCCESS;
		
	}
	
	/**
	 * 取得Ajax数据
	 */
	public void reGetAjaxStock() throws Exception {

		String id = Utility.getName(request.getParameter("id"));
			PrintWriter out;
			response.setContentType("text/xml;charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			out = response.getWriter();
			
			if(id.equals("")){
				out.println("<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>");
			}else{

				DepartmentsPo departmentsPo=new DepartmentsPo();
				departmentsPo.setBdpdepartmentid(id);
				List<WarehousePo> inwarehouselist=warehouseMgr.getWarehouseForAjaxList(departmentsPo);
				Iterator<WarehousePo> it = inwarehouselist.iterator();		
				if (it.hasNext()) {
					while (it.hasNext()) {
						WarehousePo warehousePo=it.next();
						out.println("<option value='" + warehousePo.getBwhid()+ "'");
						if("yybhgpc".equals(warehousePo.getBwhid()))
						{
							out.println(" selected='selected' ");
						}
						out.println(" > ");
						out.println(""+warehousePo.getBwhwarehouseName()+"</option>");
					}
				}
			}
			out.close();			
	}
	
	public String reReturnAudit() throws Exception{
		String cshaabillid=Utility.getName(request.getParameter("cshaabillid"));
		this.allocationMgr.returnAudit(cshaabillid);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	

	
}
