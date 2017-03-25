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
import com.pengsheng.eims.storage.mgr.StoreGoodsMgr;
import com.pengsheng.eims.storage.mgr.WholeApplyForAppMgr;
import com.pengsheng.eims.storage.mgr.ProcurementOrdersMgr;
import com.pengsheng.eims.storage.persistence.WholeBarcodePo;
import com.pengsheng.eims.storage.persistence.WholeEntryPo;
import com.pengsheng.eims.storage.persistence.WholePo;
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

public class WholeApplyForAppAction extends BaseAction{ 
	private List<DepartmentsPo> departmentsPos;
	private WholeApplyForAppMgr wholeApplyForAppMgr;
	private ProcurementOrdersMgr procurementOrdersMgr;
	private List<WholeBarcodePo> wholeBarcodeLists;
	private List<WholeEntryPo> wholeEntryList;
	private List<WholePo> wholeList;
	private WholePo wholePo;
	private BrandMgr brandMgr;
	private List<DepartmentsPo> departmentsList;
	private DepartmentsMgr departmentsMgr;
	private StoreGoodsMgr storeGoodsMgr;
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
	 * 商品批发申请明细
	 */
	public String wholeApplyForAppDetails() {
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id=Utility.getName(request.getParameter("hid"));
		WholePo po=new WholePo();
		po.setCshawbillid(id);
		wholePo=wholeApplyForAppMgr.getWhole(po);
		wholeEntryList=wholeApplyForAppMgr.getWholeEntryList(po);
		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		inwarehouselist=warehouseMgr.getWarehouseList(deppo);
		outwarehouselist=warehouseMgr.getWarehouseList(deppo);
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		
		StatusPo spo = new StatusPo();
		
		spo.setCshastatusapplybillid(id);
		
		String categoryid = wholePo.getGoodscategoryid();
		
		if( "3".equals(categoryid)||"4".equals(categoryid) ){
			String supplierid = wholePo.getChaasupplier();
			String brandid = wholeEntryList.get(0).getCshawegoodsid().substring(5, 7);
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
	 * 商品批发申请删除
	 */
	public String deleteApplyWholeForApp() {
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String id=Utility.getName(request.getParameter("hid"));
		
		List<PersonInfoPo> personInfoList=null;
		WholePo po=new WholePo();
		po.setCshawbillid(id);
		WholePo tempWholePo = new WholePo();
		tempWholePo=wholeApplyForAppMgr.getWhole(po);
		if("1".equals(personInfoPo.getDepartmenttype())){
			WarehousePo warehousePo=new WarehousePo();
			warehousePo.setBwhid(tempWholePo.getCshawoutstockid());
			DepartmentsPo departmentsPo=warehouseMgr.getDepartments(warehousePo);
			PersonInfoPo tempPersonInfoPo = new PersonInfoPo();
	    	tempPersonInfoPo.setDepartmentID(departmentsPo.getBdpdepartmentid());
	    	personInfoList = personInfoMgr.getPersonInfos(tempPersonInfoPo, 0, personInfoMgr.getPersoninfosCount(tempPersonInfoPo));
		}
		
		SmsLertsPo smsLertsPo = new SmsLertsPo();
		smsLertsPo.setCstsltitle("批发申请单"+id+"已删除");
    	smsLertsPo.setCstslcontent("批发申请单"+id+"已删除");
    	smsLertsPo.setCstslsenddepartment(personInfoPo.getDepartmentID());
    	smsLertsPo.setCstslsendperson(personInfoPo.getId());
    	
    	String moduleID = Utility.getName(request.getParameter("moduleID"));
    	request.setAttribute("moduleID", moduleID);

    	LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 删除
		logPo.setsLogContent("批发申请："+po.getCshawbillid()+"删除");

    	
		wholeApplyForAppMgr.deleteWhole(po,personInfoList,smsLertsPo,logPo);
				
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	public List<WholeBarcodePo> getWholeBarcodeLists() {
		return wholeBarcodeLists;
	}
	public List<WholeEntryPo> getWholeEntryList() {
		return wholeEntryList;
	}
		
	public List<WholePo> getWholeList() {
		return wholeList;
	}



	public WholePo getWholePo() {
		return wholePo;
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
	 * 删除商品批发申请初始化
	 */
	public String initApplyWholeForAppDelete() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		String id=Utility.getName(request.getParameter("hid"));
		WholePo po=new WholePo();
		po.setCshawbillid(id);
		wholePo=wholeApplyForAppMgr.getWhole(po);
		
		return SUCCESS;
	}
	/**
	 * 新增商品批发申请初始化
	 */
	public String initApplyWholeForAppInsert() {
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

		String billID="WAP"+GenerateNumber.getInstance().getGenerageNumber();
		wholePo=new WholePo();
		wholePo.setCshawbillid(billID);
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		wholePo.setCshawoutdepartmentid(personInfoPo.getDepartmentID());
		wholePo.setCshawoutdepartmentname(personInfoPo.getBdpdepartmentname());
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		String departmenttype = personInfoPo.getDepartmenttype();
		if(null != departmenttype) {
			if ("1".equals(systemParameterPo.getFspshoptoshop())) {
				String[] departmenttypies = {"1", "3"};
				indepartmentsList=departmentsMgr.getDepartments(departmenttypies, "0","");
			} else {
				if("3".equals(departmenttype)) {
					String[] departmenttypies = {"1", "3"};
					indepartmentsList=departmentsMgr.getDepartments(departmenttypies, "0","");
				} else {
					String[] departmenttypies = {"3"};
					indepartmentsList=departmentsMgr.getDepartments(departmenttypies, "0","");
				}
			}
		}
		departmentsPos = storeGoodsMgr.getFranchisees();
		
		return SUCCESS;
	}
	/**
	 * 查询商品批发申请初始化
	 */
	public String initApplyWholeForAppSel() {

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
		String departmentType = personInfoPo1.getDepartmenttype();
		request.setAttribute("departmentType", departmentType);
		request.setAttribute("sysDepartment", personInfoPo1.getDepartmentID()); 
		//取得登陆人允许操作的仓位&部门 Begin		
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		goodsCategorys = varietyMgr.getGoodsCategorys();
		departmentsPos = storeGoodsMgr.getFranchisees();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selApply";
		}
		return SUCCESS;
	}
	/**
	 * 修改商品批发申请初始化
	 */
	public String initApplyWholeForAppUpdate() {
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
		WholePo po=new WholePo();
		po.setCshawbillid(id);
		wholePo=wholeApplyForAppMgr.getWhole(po);
		wholeEntryList=wholeApplyForAppMgr.getWholeEntryList(po);
		
		String categoryid = wholePo.getGoodscategoryid();
		
		if( "3".equals(categoryid)||"4".equals(categoryid) ){
			String supplierid = wholePo.getChaasupplier();
			String brandid = wholeEntryList.get(0).getCshawegoodsid().substring(5, 7);
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

		String departmenttype = personInfoPo.getDepartmenttype();
		if(null != departmenttype) {
			if ("1".equals(systemParameterPo.getFspshoptoshop())) {
				String[] departmenttypies = {"1", "3"};
				indepartmentsList=departmentsMgr.getDepartments(departmenttypies, "0","");
			} else {
				if("3".equals(departmenttype)) {
					String[] departmenttypies = {"1", "3"};
					indepartmentsList=departmentsMgr.getDepartments(departmenttypies, "0","");
				} else {
					String[] departmenttypies = {"3"};
					indepartmentsList=departmentsMgr.getDepartments(departmenttypies, "0","");
				}
			}
		}
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		request.setAttribute("smsFlag", request.getParameter("smsFlag"));
		return SUCCESS;
	}
	/**
	 * 商品批发申请新增
	 */
	public String insertApplyWholeForApp() {
		
        if("".equals(Utility.getName(wholePo.getCshawauditstate()))){
        	wholePo.setCshawauditstate("0");
        }
        List<PersonInfoPo> personInfoList=null;
        SmsLertsPo smsLertsPo=new SmsLertsPo();
        PersonInfoPo tempPersonInfoPo = new PersonInfoPo();
    	WarehousePo tempWarehousePo = new WarehousePo();
    	tempWarehousePo.setBwhid(wholePo.getCshawoutstockid());
    	DepartmentsPo departmentsPo=warehouseMgr.getDepartments(tempWarehousePo);

    	tempPersonInfoPo.setDepartmentID(departmentsPo.getBdpdepartmentid());
    	
    	 personInfoList = personInfoMgr.getPersonInfos(tempPersonInfoPo, 0, personInfoMgr.getPersoninfosCount(tempPersonInfoPo));
    	 
    	 if(((PersonInfoPo)session.get("person")).getDepartmentID().equals(departmentsPo.getBdpdepartmentid())&&"0".equals(Utility.getName(wholePo.getCshawauditstate()))){
    		 personInfoList=null;
     	}
    	
    	
    	smsLertsPo.setCstslsendperson(((PersonInfoPo)session.get("person")).getId());
    	smsLertsPo.setCstslsenddepartment(((PersonInfoPo)session.get("person")).getDepartmentID());
        if("1".equals(Utility.getName(wholePo.getCshawauditstate()))){
        	wholePo.setCshawauditperson(wholePo.getCshawcreateperson());
        }
        
        
		int lenth=goodsInfoTempPo.getGoodsid().length;

		wholeEntryList=new ArrayList<WholeEntryPo>();
		
		WholeBarcodePo wholeBarcodePo=null;
		
		List<WholeBarcodePo> wholeBarcodeList=new ArrayList<WholeBarcodePo>();
		for(int i=0;i<lenth;i++){
			WholeEntryPo wholeEntryPo=new WholeEntryPo();
			wholeEntryPo.setCshawebillid(wholePo.getCshawbillid());
			wholeEntryPo.setCshawegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			wholeEntryPo.setCshawewholequantity(goodsInfoTempPo.getGoodsquantity()!=null?goodsInfoTempPo.getGoodsquantity()[i]:"0");
			wholeEntryPo.setCshawerequirementquantity(request.getParameterValues("needNumber")!=null?request.getParameterValues("needNumber")[i]:"0");
			String goodsID=goodsInfoTempPo.getGoodsid()[i];
			wholeEntryList.add(wholeEntryPo);
			
		}
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		wholePo.setCshawflag("1");//正批发申请
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(((PersonInfoPo)session.get("person")).getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("批发申请："+wholePo.getCshawbillid()+"新增");

		wholeApplyForAppMgr.insertWhole(wholePo, wholeEntryList,smsLertsPo,personInfoList,wholeBarcodeList,logPo);
		
		if("1".equals(Utility.getName(wholePo.getCshawauditstate()))){
			String url = "''wholeApplyForAppDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(wholePo.getCshawbillid());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			String url = "''initApplyWholeForAppUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(wholePo.getCshawbillid());
			params.add(moduleID);
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
		
	}
	
	/**
	 * 商品批发申请收货
	 */
	public String receiveApplyWholeForApp() {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String cshawbillid=Utility.getName(request.getParameter("cshawbillid"));
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");	
		WholePo po=new WholePo();
		po.setCshawbillid(cshawbillid);
		po.setCshawconsignee(personInfoPo.getId());
		po.setCshawconsignstate("1");
		
		int countnumber=wholeApplyForAppMgr.getWholeCount(po);
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
			logPo.setsLogContent(cshawbillid);

			wholeApplyForAppMgr.updateWholeReceive(po,logPo);
			
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
		String cshawbillid=Utility.getName(request.getParameter("cshawbillid"));
		this.wholeApplyForAppMgr.returnAudit(cshawbillid);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 商品批发申请查询
	 */
	public String selApplyWholeForApp() {
		
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
		String cshawcreateperson=Utility.getName(request.getParameter("createPersonID"));//制单人
		String cshawauditperson=Utility.getName(request.getParameter("auditPersonID"));//审核人
		String chaasupplier=Utility.getName(request.getParameter("chaasupplier"));//制造商
		String bspsuppliername=Utility.getName(request.getParameter("bspsuppliername"));//制造商
		String startTime1=Utility.getName(request.getParameter("startTime1"));
		String endTime1=Utility.getName(request.getParameter("endTime1"));
		String goodsName=Utility.getName(request.getParameter("goodsName"));
		String goodsID=Utility.getName(request.getParameter("goodsID"));
		String remark=Utility.getName(request.getParameter("remark"));
		String auditPersonName=Utility.getName(request.getParameter("auditPersonName"));
		String createPersonName=Utility.getName(request.getParameter("createPersonName"));
		
		request.setAttribute("selcreatePersonID",cshawcreateperson);
		request.setAttribute("selauditPersonID",cshawauditperson);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("createPersonName",createPersonName);
		request.setAttribute("goodsName",goodsName);		
		request.setAttribute("goodsID",goodsID);		
		
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
		wholePo.setCshawcreateperson(cshawcreateperson);
		wholePo.setCshawauditperson(cshawauditperson);
		wholePo.setCshawflag("1");//正批发申请
		wholePo.setChaagoodsname(goodsName);
		wholePo.setChaagoodsid(goodsID);
		wholePo.setCshawremark(remark);
		wholePo.setCshawauditperson(auditPersonName);
		wholePo.setCshawcreateperson(createPersonName);
		
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
		
		goodsCategorys = varietyMgr.getGoodsCategorys();		
		
		return SUCCESS;
	}
	
	public String addApplyWholeForAppDimension() throws Exception {
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
		
		wholePo.setCshawoutdepartmentid(personInfoPo.getDepartmentID());
		wholePo.setCshawoutdepartmentname(personInfoPo.getBdpdepartmentname());
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
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
			WholePo po=new WholePo();
			po.setCshawbillid(wholePo.getCshawbillid());
			wholePo=wholeApplyForAppMgr.getWhole(po);
			
			deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
			deppo.setBdptype(personInfoPo.getDepartmenttype());
			deppo.setBdpdepartmentname(personInfoPo.getBdpdepartmentname());
				
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
	
	
	public void setWholeBarcodeLists(
			List<WholeBarcodePo> wholeBarcodeLists) {
		this.wholeBarcodeLists = wholeBarcodeLists;
	}
	public void setWholeEntryList(List<WholeEntryPo> wholeEntryList) {
		this.wholeEntryList = wholeEntryList;
	}
	public void setWholeList(List<WholePo> wholeList) {
		this.wholeList = wholeList;
	}

	public void setWholePo(WholePo wholePo) {
		this.wholePo = wholePo;
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
	 * 商品批发申请修改
	 */
	public String updateApplyWholeForApp() {
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

        if("".equals(Utility.getName(wholePo.getCshawauditstate()))){
        	wholePo.setCshawauditstate("0");
        }
        List<PersonInfoPo> personInfoList=null;
        SmsLertsPo smsLertsPo=new SmsLertsPo();
        PersonInfoPo tempPersonInfoPo = new PersonInfoPo();
//    	tempPersonInfoPo.setWholeFlag("1");

    	
        if("1".equals(Utility.getName(wholePo.getCshawauditstate()))){
        	wholePo.setCshawauditperson(wholePo.getCshawcreateperson());
        }
    
        
		int lenth=goodsInfoTempPo.getGoodsid().length;
		WholeBarcodePo wholeBarcodePo=null;
		
		List<WholeBarcodePo> wholeBarcodeList=new ArrayList<WholeBarcodePo>();;
		wholeEntryList=new ArrayList<WholeEntryPo>();
		for(int i=0;i<lenth;i++){
			WholeEntryPo wholeEntryPo=new WholeEntryPo();
			wholeEntryPo.setCshawebillid(wholePo.getCshawbillid());
			wholeEntryPo.setCshawegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			wholeEntryPo.setCshawoutstockid(wholePo.getCshawoutstockid());
			wholeEntryPo.setCshawinstockid(wholePo.getCshawinstockid());
			wholeEntryPo.setCshawerequirementquantity(request.getParameterValues("needNumber")!=null?request.getParameterValues("needNumber")[i]:"0");
			wholeEntryPo.setCshawewholequantity(goodsInfoTempPo.getGoodsquantity()!=null?goodsInfoTempPo.getGoodsquantity()[i]:"0");
			
			String goodsID=goodsInfoTempPo.getGoodsid()[i];
			wholeEntryList.add(wholeEntryPo);
		
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("批发申请："+wholePo.getCshawbillid()+"修改");

		
		wholeApplyForAppMgr.updateWhole(wholePo, wholeEntryList, smsLertsPo,personInfoList,wholeBarcodeList,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		if("1".equals(Utility.getName(wholePo.getCshawauditstate()))){
			String url = "''wholeApplyForAppDetails.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(wholePo.getCshawbillid());
			params.add(moduleID);

			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}else{
			String url = "''initApplyWholeForAppUpdate.action?hid={0}&moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(wholePo.getCshawbillid());
			params.add(moduleID);
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}		
	}

	public WholeApplyForAppMgr getWholeApplyForAppMgr() {
		return wholeApplyForAppMgr;
	}

	public void setWholeApplyForAppMgr(
			WholeApplyForAppMgr wholeApplyForAppMgr) {
		this.wholeApplyForAppMgr = wholeApplyForAppMgr;
	}

	public ProcurementOrdersMgr getProcurementOrdersMgr() {
		return procurementOrdersMgr;
	}

	public void setProcurementOrdersMgr(ProcurementOrdersMgr procurementOrdersMgr) {
		this.procurementOrdersMgr = procurementOrdersMgr;
	}

	public List<DepartmentsPo> getDepartmentsPos() {
		return departmentsPos;
	}

	public void setDepartmentsPos(List<DepartmentsPo> departmentsPos) {
		this.departmentsPos = departmentsPos;
	}

	public StoreGoodsMgr getStoreGoodsMgr() {
		return storeGoodsMgr;
	}

	public void setStoreGoodsMgr(StoreGoodsMgr storeGoodsMgr) {
		this.storeGoodsMgr = storeGoodsMgr;
	}

}
