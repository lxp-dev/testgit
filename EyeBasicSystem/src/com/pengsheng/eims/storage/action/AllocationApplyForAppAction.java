package com.pengsheng.eims.storage.action;

import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.AllocationApplyForAppMgr;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.mgr.ProcurementOrdersMgr;
import com.pengsheng.eims.storage.persistence.AllocationBarcodePo;
import com.pengsheng.eims.storage.persistence.AllocationEntryPo;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.StatusPo;
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

public class AllocationApplyForAppAction extends BaseAction{ 
	
	private AllocationApplyForAppMgr allocationApplyForAppMgr;
	private ProcurementOrdersMgr procurementOrdersMgr;
	
	private List<AllocationBarcodePo> allocationBarcodeLists;
	
	private List<AllocationEntryPo> allocationEntryList;
	
	private List<AllocationPo> allocationList;
	
	private AllocationMgr allocationMgr;
	private AllocationPo allocationPo;
	private BrandMgr brandMgr;
	private List<DepartmentsPo> departmentsList;
	private DepartmentsMgr departmentsMgr;
	
	private List<GoodsCategoryPo> goodsCategorys;
	private GoodsInfoTempPo goodsInfoTempPo;
	private List<DepartmentsPo> indepartmentsList;
	
	private List<WarehousePo> inwarehouselist;
	
	private String isFirstExec;
	
	private List<WarehousePo> outwarehouselist;
	
	private PersonInfoMgr personInfoMgr;
	
	private PersonPermissionMgr personPermissionMgr;
	
	private StatusPo statusPo;
	
	private SystemParameterMgr systemParameterMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private VarietyMgr varietyMgr;
	
	private WarehouseMgr warehouseMgr;
	
	/**
	 * 商品调拨明细
	 */
	public String allocationApplyForAppDetails() {
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id=Utility.getName(request.getParameter("hid"));
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		allocationPo=allocationApplyForAppMgr.getAllocation(po);
		allocationEntryList=allocationApplyForAppMgr.getAllocationEntryList(po);
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		inwarehouselist=warehouseMgr.getWarehouseList(deppo);
		outwarehouselist=warehouseMgr.getWarehouseList(deppo);
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		
		StatusPo spo = new StatusPo();
		
		spo.setCshastatusapplybillid(id);
		
		statusPo = allocationMgr.getStatusPo(spo);
		
		String categoryid = allocationPo.getGoodscategoryid();
		
		if( "3".equals(categoryid)||"4".equals(categoryid) ){
			String supplierid = allocationPo.getChaasupplier();
			String brandid = allocationEntryList.get(0).getCshaaegoodsid().substring(5, 7);
			BrandPo brandPo = new BrandPo();
			brandPo.setBbdid(brandid);
			brandPo.setBbdsupplierid(supplierid);
			brandPo = brandMgr.getBrandPo(brandPo);
			request.setAttribute("brandID", brandPo.getBbdid());
			request.setAttribute("brandName", brandPo.getBbdbrandname());
		}
		
		return SUCCESS;
	}
	
	/**
	 * 商品调拨删除
	 */
	public String deleteApplyAllocationForApp() {
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String id=Utility.getName(request.getParameter("hid"));
		
		List<PersonInfoPo> personInfoList=null;
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		AllocationPo tempAllocationPo = new AllocationPo();
		tempAllocationPo=allocationApplyForAppMgr.getAllocation(po);
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
		logPo.setsLogContent("调拨申请："+po.getCshaabillid()+"删除");

    	
		allocationApplyForAppMgr.deleteAllocation(po,personInfoList,smsLertsPo,logPo);
				
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	public List<AllocationBarcodePo> getAllocationBarcodeLists() {
		return allocationBarcodeLists;
	}
	public List<AllocationEntryPo> getAllocationEntryList() {
		return allocationEntryList;
	}
		
	public List<AllocationPo> getAllocationList() {
		return allocationList;
	}



	public AllocationPo getAllocationPo() {
		return allocationPo;
	}

	/**
	 * 取得Ajax数据
	 */
	public void getApplyAjaxStockForApp() throws Exception {

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
						out.println("<option value='" + warehousePo.getBwhid()+ "'>"+warehousePo.getBwhwarehouseName()+"</option>");
					}
				}
			}
			out.close();			
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}
	
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}
	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}
	public List<DepartmentsPo> getIndepartmentsList() {
		return indepartmentsList;
	}
	public List<WarehousePo> getInwarehouselist() {
		return inwarehouselist;
	}
	
	public String getIsFirstExec() {
		return isFirstExec;
	}
	public List<WarehousePo> getOutwarehouselist() {
		return outwarehouselist;
	}
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public StatusPo getStatusPo() {
		return statusPo;
	}
	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}
	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}
	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	/**
	 * 删除商品调拨初始化
	 */
	public String initApplyAllocationForAppDelete() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id=Utility.getName(request.getParameter("hid"));
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		allocationPo=allocationApplyForAppMgr.getAllocation(po);
		
		return SUCCESS;
	}
	
	/**
	 * 新增商品调拨初始化
	 */
	public String initApplyAllocationForAppInsert() {
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	

		String billID="APP"+GenerateNumber.getInstance().getGenerageNumber();
		allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		allocationPo.setCshaaoutdepartmentid(personInfoPo.getDepartmentID());
		allocationPo.setCshaaoutdepartmentname(personInfoPo.getBdpdepartmentname());
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !personInfoPo.getDepartmenttype().equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}	
		
		goodsCategorys = varietyMgr.getGoodsCategorys();

		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 总公司获取所有已启用的部门，分公司获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}

		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		
		return SUCCESS;
	}
	/**
	 * 查询商品调拨初始化
	 */
	public String initApplyAllocationForAppSel() {

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
		String departmentType = personInfoPo.getDepartmenttype();
		request.setAttribute("departmentType", departmentType);
		request.setAttribute("sysDepartment", personInfoPo.getDepartmentID()); 
		//取得登陆人允许操作的仓位&部门 Begin		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
		    deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		departmentsList = departmentsMgr.getDepartments(deppo);	

		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selApply";
		}
		return SUCCESS;
	}
	/**
	 * 修改商品调拨初始化
	 */
	public String initApplyAllocationForAppUpdate() {
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		request.setAttribute("sysDepartment", personInfoPo1.getDepartmentID()); 
		String id=Utility.getName(request.getParameter("hid"));
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		allocationPo=allocationApplyForAppMgr.getAllocation(po);
		allocationEntryList=allocationApplyForAppMgr.getAllocationEntryList(po);
		
		String categoryid = allocationPo.getGoodscategoryid();
		
		if( "3".equals(categoryid)||"4".equals(categoryid) ){
			String supplierid = allocationPo.getChaasupplier();
			String brandid = allocationEntryList.get(0).getCshaaegoodsid().substring(5, 7);
			BrandPo brandPo = new BrandPo();
			brandPo.setBbdid(brandid);
			brandPo.setBbdsupplierid(supplierid);
			brandPo = brandMgr.getBrandPo(brandPo);
			request.setAttribute("brandID", brandPo
					.getBbdid());
			request.setAttribute("brandName", brandPo
					.getBbdbrandname());
		}
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");	
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2") || !personInfoPo.getDepartmenttype().equals("3")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}

		if("0".equals(systemParameterPo.getFspshoptoshop())){    // 不允许店店调拨
			if("3".equals(personInfoPo.getDepartmenttype())){
				indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 总公司获取所有已启用的部门，分公司获取当前公司下所有已启用的部门
			}else{
				String[] str = {"3"};
				indepartmentsList = departmentsMgr.getDepartments(str,"0",personInfoPo.getPersoncompanyid()); // 获取当前公司下所有已启用的库房
			}
		}else{
			indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);
		}
		
		if (indepartmentsList == null){
			indepartmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				indepartmentsList.add(dpo);
			}
		}
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));		
		request.setAttribute("departmenttype",Utility.getName(personInfoPo1.getDepartmenttype()));
		
		return SUCCESS;
	}
	/**
	 * 商品调拨新增
	 */
	public String insertApplyAllocationForApp() {
		
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
        
        
		int lenth=goodsInfoTempPo.getGoodsid().length;

		allocationEntryList=new ArrayList<AllocationEntryPo>();
		
		AllocationBarcodePo allocationBarcodePo=null;
		
		List<AllocationBarcodePo> allocationBarcodeList=new ArrayList<AllocationBarcodePo>();
		for(int i=0;i<lenth;i++){
			AllocationEntryPo allocationEntryPo=new AllocationEntryPo();
			allocationEntryPo.setCshaaebillid(allocationPo.getCshaabillid());
			allocationEntryPo.setCshaaegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			allocationEntryPo.setCshaaeallocationquantity(goodsInfoTempPo.getGoodsquantity()!=null?goodsInfoTempPo.getGoodsquantity()[i]:"0");
			allocationEntryPo.setCshaaGoodsBarCode(goodsInfoTempPo.getGoodsbarcode()!=null?goodsInfoTempPo.getGoodsbarcode()[i]:""); // 新增时加入商品条码
			allocationEntryPo.setCshaaerequirementquantity(request.getParameterValues("needNumber")!=null?request.getParameterValues("needNumber")[i]:"0");
			String goodsID=goodsInfoTempPo.getGoodsid()[i];
			allocationEntryList.add(allocationEntryPo);
			
		}
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		allocationPo.setCshaaflag("1");//正调拨
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(((PersonInfoPo)session.get("person")).getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("调拨申请："+allocationPo.getCshaabillid()+"新增");

		allocationApplyForAppMgr.insertAllocation(allocationPo, allocationEntryList,smsLertsPo,personInfoList,allocationBarcodeList,logPo);
		
		if("1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
			String url = "''allocationApplyForAppDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(allocationPo.getCshaabillid());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			String url = "''initApplyAllocationForAppUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(allocationPo.getCshaabillid());
			params.add(moduleID);
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
		
	}
	
	/**
	 * 商品调拨收货
	 */
	public String receiveApplyAllocationForApp() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String cshaabillid=Utility.getName(request.getParameter("cshaabillid"));
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");	
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(cshaabillid);
		po.setCshaaconsignee(personInfoPo.getId());
		po.setCshaaconsignstate("1");
		
		int countnumber=allocationApplyForAppMgr.getAllocationCount(po);
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
			logPo.setsLogContent(cshaabillid);

			allocationApplyForAppMgr.updateAllocationReceive(po,logPo);
			
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
	public String returnAuditForApp() throws Exception{
		String cshaabillid=Utility.getName(request.getParameter("cshaabillid"));
		this.allocationApplyForAppMgr.returnAudit(cshaabillid);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	/**
	 * 商品调拨查询
	 */
	public String selApplyAllocationForApp() {
		
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
		String departmentType = personInfoPo1.getDepartmenttype();
		request.setAttribute("departmentType", departmentType);

		request.setAttribute("sysDepartment", personInfoPo1.getDepartmentID()); 
		String billID=Utility.getName(request.getParameter("billID"));
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String auditState=Utility.getName(request.getParameter("auditState"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String cshaacreateperson=Utility.getName(request.getParameter("createPersonID"));//制单人
		String cshaaauditperson=Utility.getName(request.getParameter("auditPersonID"));//审核人
		String chaasupplier=Utility.getName(request.getParameter("chaasupplier"));//制造商
		String bspsuppliername=Utility.getName(request.getParameter("bspsuppliername"));//制造商
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String goodsName=Utility.getName(request.getParameter("goodsName"));
		String goodsID=Utility.getName(request.getParameter("goodsID"));
		String remark=Utility.getName(request.getParameter("remark"));
		
		request.setAttribute("selcreatePersonID",cshaacreateperson);
		request.setAttribute("selauditPersonID",cshaaauditperson);
		request.setAttribute("auditPersonName", request.getParameter("auditPersonName"));
		request.setAttribute("createPersonName",request.getParameter("createPersonName") );
		request.setAttribute("goodsName",goodsName);		
		request.setAttribute("goodsID",goodsID);		

		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo1.getDepartmentID());
		deppo.setBdptype(personInfoPo1.getDepartmenttype());
		
		AllocationPo allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		allocationPo.setCshaaindepartmentid(departmentID);
		allocationPo.setCshaastartTime(startTime);
		allocationPo.setCshaaendTime(endTime);
		allocationPo.setCshaaauditstate(auditState);
		allocationPo.setCshaaauditdatestart(startTime1);
		allocationPo.setCshaaauditdateend(endTime1);
		allocationPo.setGoodscategoryid(goodscategoryID);
		allocationPo.setChaasupplier(chaasupplier);		
		allocationPo.setCshaacreateperson(cshaacreateperson);
		allocationPo.setCshaaauditperson(cshaaauditperson);
		allocationPo.setCshaaflag("1");//正调拨
		allocationPo.setChaagoodsname(goodsName);
		allocationPo.setChaagoodsid(goodsID);
		allocationPo.setCshaaremark(remark);
		allocationPo.setCshaaoutdptcompanyid(personInfoPo1.getPersoncompanyid());
		
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
		
		int count=allocationApplyForAppMgr.getAllocationCount(allocationPo,deppo);
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
	    allocationList=allocationApplyForAppMgr.getAllocationList(allocationPo,deppo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			allocationList = null;
		}

		//取得登陆人允许操作的仓位&部门 Begin		
		deppo.setBdpdepartmentname(personInfoPo1.getBdpdepartmentname());
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
		    deppo.setBdpcompanysid(personInfoPo1.getPersoncompanyid());
		}
		deppo.setBdptype("");
		departmentsList = departmentsMgr.getDepartments(deppo);
		
		if (departmentsList == null){
			departmentsList = new ArrayList<DepartmentsPo>();
		}

		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
			for (DepartmentsPo dpo : dList){
				departmentsList.add(dpo);
			}
		}
		
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
		
		goodsCategorys = varietyMgr.getGoodsCategorys();		
		
		return SUCCESS;
	}
	
	public String addApplyAllocationForAppDimension() throws Exception {
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
		
		allocationPo.setCshaaoutdepartmentid(personInfoPo.getDepartmentID());
		allocationPo.setCshaaoutdepartmentname(personInfoPo.getBdpdepartmentname());
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(Utility.getName(systemParameterPo.getFspshoptoshop()).equals("1") ? "3" : personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		deppo.setBdpcompanynature(personInfoPo.getCompanynature());
		deppo.setBdpothercompanyid(personInfoPo.getPersoncompanyid());
		deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		
		goodsCategorys = varietyMgr.getGoodsCategorys();

		indepartmentsList = departmentsMgr.getDepartmentsForAllocation(deppo);   // 获取当前公司下所有已启用的部门
		
		if (personInfoPo.getDepartmenttype().equals("3")){
			if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
				List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("1");
				for (DepartmentsPo dpo : dList){
					indepartmentsList.add(dpo);
				}
			}else{
				List<DepartmentsPo> dList = departmentsMgr.getParentCompanyDepartments("2");
				for (DepartmentsPo dpo : dList){
					indepartmentsList.add(dpo);
				}
			}
		}
		
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		
		String[] tdgoodsids = Utility.getName(request.getParameter("tdgoodsids")).split(",");
		String[] tdvs = Utility.getName(request.getParameter("tdvs")).split(",");
		String ioru = Utility.getName(request.getParameter("ioru"));
		if(goodsInfoTempPo != null){
			for (int i = 0; i < goodsInfoTempPo.getGoodsid().length; i++) {
				tdgoodsids =  insert(tdgoodsids, goodsInfoTempPo.getGoodsid()[i]) ;
				tdvs = insert(tdvs,request.getParameterValues("needNumber")!=null?request.getParameterValues("needNumber")[i]:goodsInfoTempPo.getGoodsquantity()[i]);
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
		request.setAttribute("tdgoodsids", request.getParameter("tdgoodsids"));
		request.setAttribute("tdvs", request.getParameter("tdvs"));
		if(ioru.equals("u")){
			AllocationPo po=new AllocationPo();
			po.setCshaabillid(allocationPo.getCshaabillid());
			
			allocationPo=allocationApplyForAppMgr.getAllocation(po);
		}
		
		return ioru;
	}
	
	private static String[] insert(String[] arr, String str){
		int size = arr.length;
		String[] tmp = new String[size + 1];
		System.arraycopy(arr, 0, tmp, 0, size);
		tmp[size] = str;
		return tmp;
	}
	
	
	public void setAllocationBarcodeLists(
			List<AllocationBarcodePo> allocationBarcodeLists) {
		this.allocationBarcodeLists = allocationBarcodeLists;
	}
	public void setAllocationEntryList(List<AllocationEntryPo> allocationEntryList) {
		this.allocationEntryList = allocationEntryList;
	}
	public void setAllocationList(List<AllocationPo> allocationList) {
		this.allocationList = allocationList;
	}

	public void setAllocationPo(AllocationPo allocationPo) {
		this.allocationPo = allocationPo;
	}
	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}
	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}	
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}	
	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}
	public void setIndepartmentsList(List<DepartmentsPo> indepartmentsList) {
		this.indepartmentsList = indepartmentsList;
	}	
	public void setInwarehouselist(List<WarehousePo> inwarehouselist) {
		this.inwarehouselist = inwarehouselist;
	}
	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}	
	public void setOutwarehouselist(List<WarehousePo> outwarehouselist) {
		this.outwarehouselist = outwarehouselist;
	}
	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	
	public void setStatusPo(StatusPo statusPo) {
		this.statusPo = statusPo;
	}
	
	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}
	
	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}
	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	/**
	 * 商品调拨修改
	 */
	public String updateApplyAllocationForApp() {
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

        if("".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
        	allocationPo.setCshaaauditstate("0");
        }
        List<PersonInfoPo> personInfoList=null;
        SmsLertsPo smsLertsPo=new SmsLertsPo();
        PersonInfoPo tempPersonInfoPo = new PersonInfoPo();
    	tempPersonInfoPo.setAllocationFlag("1");

    	
        if("1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
        	allocationPo.setCshaaauditperson(allocationPo.getCshaacreateperson());
        }
    
        
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
		
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("调拨申请："+allocationPo.getCshaabillid()+"修改");

		
		allocationApplyForAppMgr.updateAllocation(allocationPo, allocationEntryList, smsLertsPo,personInfoList,allocationBarcodeList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		if("1".equals(Utility.getName(allocationPo.getCshaaauditstate()))){
			String url = "''allocationApplyForAppDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(allocationPo.getCshaabillid());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			String url = "''initApplyAllocationForAppUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(allocationPo.getCshaabillid());
			params.add(moduleID);
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}		
	}

	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}

	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
	}

	public AllocationApplyForAppMgr getAllocationApplyForAppMgr() {
		return allocationApplyForAppMgr;
	}

	public void setAllocationApplyForAppMgr(
			AllocationApplyForAppMgr allocationApplyForAppMgr) {
		this.allocationApplyForAppMgr = allocationApplyForAppMgr;
	}

	public ProcurementOrdersMgr getProcurementOrdersMgr() {
		return procurementOrdersMgr;
	}

	public void setProcurementOrdersMgr(ProcurementOrdersMgr procurementOrdersMgr) {
		this.procurementOrdersMgr = procurementOrdersMgr;
	}

}
