package com.pengsheng.eims.storage.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.text.MessageFormat;

import org.springframework.dao.PessimisticLockingFailureException;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.NonconformingProductPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.AllocationApplyMgr;
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

public class AllocationApplyAction extends BaseAction{ 
	
	private StatusPo statusPo;
	
	private AllocationMgr allocationMgr;
	
	private VarietyMgr varietyMgr;
	
	private BrandMgr brandMgr;
	
	private ProcurementOrdersMgr procurementOrdersMgr;
	
	public ProcurementOrdersMgr getProcurementOrdersMgr() {
		return procurementOrdersMgr;
	}
	public void setProcurementOrdersMgr(ProcurementOrdersMgr procurementOrdersMgr) {
		this.procurementOrdersMgr = procurementOrdersMgr;
	}
	public BrandMgr getBrandMgr() {
		return brandMgr;
	}
	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}
	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}
	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}
	private List<GoodsCategoryPo> goodsCategorys;
	
	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}
	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}
	private AllocationPo allocationPo;
	
	private AllocationApplyMgr allocationApplyMgr;
	
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
	private String isFirstExec;
		
	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
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
	
	public AllocationApplyMgr getAllocationApplyMgr() {
		return allocationApplyMgr;
	}
	public void setAllocationApplyMgr(AllocationApplyMgr allocationApplyMgr) {
		this.allocationApplyMgr = allocationApplyMgr;
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
	public String initApplyAllocationSel() {

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
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selApply";
		}
		return SUCCESS;
	}	
	/**
	 * 商品调拨查询
	 */
	public String selApplyAllocation() {
		
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
		String remark=Utility.getName(request.getParameter("remark"));
		
		request.setAttribute("selcreatePersonID",cshaacreateperson);
		request.setAttribute("selauditPersonID",cshaaauditperson);
		request.setAttribute("auditPersonName", request.getParameter("auditPersonName"));
		request.setAttribute("createPersonName",request.getParameter("createPersonName") );
		request.setAttribute("goodsName",goodsName);		
		
		PersonInfoPo personInfoPo=(PersonInfoPo) session.get("person");
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		
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
		allocationPo.setCshaaremark(remark);
		
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
		
		int count=allocationApplyMgr.getAllocationCount(allocationPo,deppo);
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
	    allocationList=allocationApplyMgr.getAllocationList(allocationPo,deppo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			allocationList = null;
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
		
		goodsCategorys = varietyMgr.getGoodsCategorys();		
		
		return SUCCESS;
	}
	/**
	 * 新增商品调拨初始化
	 */
	public String initApplyAllocationInsert() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String billID="APP"+GenerateNumber.getInstance().getGenerageNumber();
		allocationPo=new AllocationPo();
		allocationPo.setCshaabillid(billID);
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		allocationPo.setCshaaoutdepartmentid(personInfoPo.getDepartmentID());
		allocationPo.setCshaaoutdepartmentname(personInfoPo.getBdpdepartmentname());
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		indepartmentsList=departmentsMgr.getDepartmentsForAllocation(deppo);

		
		return SUCCESS;
	}	
	/**
	 * 商品调拨新增
	 */
	public String insertApplyAllocation() {
		
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
		
		List<AllocationBarcodePo> allocationBarcodeList=new ArrayList<AllocationBarcodePo>();
		for(int i=0;i<lenth;i++){
			AllocationEntryPo allocationEntryPo=new AllocationEntryPo();
			allocationEntryPo.setCshaaebillid(allocationPo.getCshaabillid());
			allocationEntryPo.setCshaaegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			allocationEntryPo.setCshaaeallocationquantity(goodsInfoTempPo.getGoodsquantity()!=null?goodsInfoTempPo.getGoodsquantity()[i]:"0");
			allocationEntryPo.setCshaaGoodsBarCode(goodsInfoTempPo.getGoodsbarcode()!=null?goodsInfoTempPo.getGoodsbarcode()[i]:""); // 新增时加入商品条码
			allocationEntryPo.setCshaaerequirementquantity(request.getParameterValues("needNumber")!=null?request.getParameterValues("needNumber")[i]:"0");
			allocationEntryList.add(allocationEntryPo);
			
		}
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		allocationPo.setCshaaflag("1");//正调拨
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(((PersonInfoPo)session.get("person")).getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("采购申请："+allocationPo.getCshaabillid()+"新增");

		allocationApplyMgr.insertAllocation(allocationPo, allocationEntryList,smsLertsPo,personInfoList,allocationBarcodeList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		String url = "''allocationApplyDetails.action?hid={0}''";
		List<String> params = new ArrayList<String>();
		params.add(allocationPo.getCshaabillid());

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		return SUCCESS;
	}
	/**
	 * 修改商品调拨初始化
	 */
	public String initApplyAllocationUpdate() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id=Utility.getName(request.getParameter("hid"));
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		allocationPo=allocationApplyMgr.getAllocation(po);
		allocationEntryList=allocationApplyMgr.getAllocationEntryList(po);
		
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
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
			
		indepartmentsList=departmentsMgr.getDepartmentsForAllocation(deppo);
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		return SUCCESS;
	}	
	/**
	 * 商品调拨修改
	 */
	public String updateApplyAllocation() {
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
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
			
			allocationEntryList.add(allocationEntryPo);
		
		}
		
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("采购申请："+allocationPo.getCshaabillid()+"修改");

		
		allocationApplyMgr.updateAllocation(allocationPo, allocationEntryList, smsLertsPo,personInfoList,allocationBarcodeList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
		if(Utility.getName(request.getParameter("smsFlag")).equals("1")){
			request.setAttribute("flag",GlobalConstants.MOVE);
			request.setAttribute("url", "'selectSms.action'");
		}else{
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		}
		String url = "''allocationApplyDetails.action?hid={0}''";
		List<String> params = new ArrayList<String>();
		params.add(allocationPo.getCshaabillid());

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		return SUCCESS;
	}
	/**
	 * 删除商品调拨初始化
	 */
	public String initApplyAllocationDelete() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id=Utility.getName(request.getParameter("hid"));
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		allocationPo=allocationApplyMgr.getAllocation(po);
		
		return SUCCESS;
	}	
	/**
	 * 商品调拨删除
	 */
	public String deleteApplyAllocation() {
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String id=Utility.getName(request.getParameter("hid"));
		
		List<PersonInfoPo> personInfoList=null;
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		AllocationPo tempAllocationPo = new AllocationPo();
		tempAllocationPo=allocationApplyMgr.getAllocation(po);
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
		logPo.setsLogContent("采购申请："+po.getCshaabillid()+"删除");

    	
		allocationApplyMgr.deleteAllocation(po,personInfoList,smsLertsPo,logPo);
				
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	/**
	 * 商品调拨明细
	 */
	public String allocationApplyDetails() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id=Utility.getName(request.getParameter("hid"));
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(id);
		allocationPo=allocationApplyMgr.getAllocation(po);
		allocationEntryList=allocationApplyMgr.getAllocationEntryList(po);
		
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
	 * 商品调拨收货
	 */
	public String receiveApplyAllocation() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String cshaabillid=Utility.getName(request.getParameter("cshaabillid"));
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");	
		AllocationPo po=new AllocationPo();
		po.setCshaabillid(cshaabillid);
		po.setCshaaconsignee(personInfoPo.getId());
		po.setCshaaconsignstate("1");
		
		int countnumber=allocationApplyMgr.getAllocationCount(po);
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

			allocationApplyMgr.updateAllocationReceive(po,logPo);
			
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
	public void getApplyAjaxStock() throws Exception {

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
	
	public String returnAudit() throws Exception{
		String cshaabillid=Utility.getName(request.getParameter("cshaabillid"));
		this.allocationApplyMgr.returnAudit(cshaabillid);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	public String addApplyAllocationDimension() throws Exception {
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
		
		allocationPo.setCshaaoutdepartmentid(personInfoPo.getDepartmentID());
		allocationPo.setCshaaoutdepartmentname(personInfoPo.getBdpdepartmentname());
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		indepartmentsList=departmentsMgr.getDepartmentsForAllocation(deppo);
		
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
		
		if(ioru.equals("u")){
			AllocationPo po=new AllocationPo();
			po.setCshaabillid(allocationPo.getCshaabillid());
			allocationPo=allocationApplyMgr.getAllocation(po);
			
			deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
			deppo.setBdptype(personInfoPo.getDepartmenttype());
			deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
				
			indepartmentsList=departmentsMgr.getDepartmentsForAllocation(deppo);
			
			goodsCategorys = varietyMgr.getGoodsCategorys();
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
	
	public StatusPo getStatusPo() {
		return statusPo;
	}
	public void setStatusPo(StatusPo statusPo) {
		this.statusPo = statusPo;
	}
	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}
	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
	}

	
}
