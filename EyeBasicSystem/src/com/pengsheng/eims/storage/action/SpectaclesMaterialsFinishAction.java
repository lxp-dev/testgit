package com.pengsheng.eims.storage.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.mgr.SpectaclesMaterialsFinishMgr;
import com.pengsheng.eims.storage.mgr.SpectaclesMaterialsMgr;
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

public class SpectaclesMaterialsFinishAction extends BaseAction {

	private SpectaclesMaterialsFinishMgr spectaclesMaterialsFinishMgr;
	
	private List<SalesBasicPo> spectaclesMaterialsFinishList;
	
	private SalesBasicPo salesBasicPo;
	
	private DepartmentsMgr departmentsMgr;
	
	private FittingTemplateTypeMgr fittingTemplateTypeMgr = null;
	
	private List<DepartmentsPo> departmentsList;
	
	private SalesBasicPo oDPo;
	
	private SalesBasicPo oSPo;
	
	private List<SalesDetailPo> goodsInfoList;
	
	private PersonPermissionMgr personPermissionMgr;
	
	private SpectaclesMaterialsMgr spectaclesMaterialsMgr; 
	
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

	
	public SpectaclesMaterialsMgr getSpectaclesMaterialsMgr() {
		return spectaclesMaterialsMgr;
	}

	public void setSpectaclesMaterialsMgr(
			SpectaclesMaterialsMgr spectaclesMaterialsMgr) {
		this.spectaclesMaterialsMgr = spectaclesMaterialsMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public SalesBasicPo getoDPo() {
		return oDPo;
	}

	public void setoDPo(SalesBasicPo oDPo) {
		this.oDPo = oDPo;
	}

	public SalesBasicPo getoSPo() {
		return oSPo;
	}

	public void setoSPo(SalesBasicPo oSPo) {
		this.oSPo = oSPo;
	}

	public List<SalesDetailPo> getGoodsInfoList() {
		return goodsInfoList;
	}

	public void setGoodsInfoList(List<SalesDetailPo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}

	public SpectaclesMaterialsFinishMgr getSpectaclesMaterialsFinishMgr() {
		return spectaclesMaterialsFinishMgr;
	}

	public void setSpectaclesMaterialsFinishMgr(
			SpectaclesMaterialsFinishMgr spectaclesMaterialsFinishMgr) {
		this.spectaclesMaterialsFinishMgr = spectaclesMaterialsFinishMgr;
	}

	public List<SalesBasicPo> getSpectaclesMaterialsFinishList() {
		return spectaclesMaterialsFinishList;
	}

	public void setSpectaclesMaterialsFinishList(
			List<SalesBasicPo> spectaclesMaterialsFinishList) {
		this.spectaclesMaterialsFinishList = spectaclesMaterialsFinishList;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
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

	/**
	 * 初始化配镜已发料页面
	 * @return
	 */
	public String initSpectaclesMaterialsFinishSel(){
		

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
		
		// 取得登陆人允许操作的仓位&部门 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpregid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = spectaclesMaterialsMgr.getdepartment(deppo);
		// 取得登陆人允许操作的仓位&部门 End
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectSpectaclesMaterialsFinish";
		}
		return SUCCESS;
	}
	
	/**
	 * 配镜已发料查询
	 * @return
	 */
	public String selectSpectaclesMaterialsFinish(){

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
		
		String departmentid=personInfoPo.getDepartmentID();
		
		String ssesbsalesid=Utility.getName(request.getParameter("salesid"));
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("salesStartTime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("salesEndTime"));
		String ssesbpersonName=Utility.getName(request.getParameter("personName"));
		String ssesborderstype=Utility.getName(request.getParameter("orderstype"));
		String ssesbshopcode=Utility.getName(request.getParameter("shopcode"));
		
		//制造商 、品种 id及name
		String supplierID=Utility.getName(request.getParameter("supplierID"));
		String supplierName=Utility.getName(request.getParameter("supplierName"));
		String brandID=Utility.getName(request.getParameter("brandID"));
		String brandName=Utility.getName(request.getParameter("brandName"));
		String worrytype=Utility.getName(request.getParameter("worrytype"));
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbdepartmentid(departmentid);
		salesPo.setSsesbsalesid(ssesbsalesid);
		salesPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesPo.setSsesbpersonName(ssesbpersonName);
		salesPo.setSsesborderstype(ssesborderstype);
		salesPo.setSsesbshopcode(ssesbshopcode);
		salesPo.setSsesbdepartmenttype(personInfoPo.getDepartmenttype());
		salesPo.setSsesbworrytype(worrytype);
		salesPo.setSsesbsupplierid(supplierID);
		salesPo.setSsesbsuppliername(supplierName);
		salesPo.setSsesbbrandid(brandID);
		salesPo.setSsesbbrandname(brandName);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			salesPo.setSsesbcompanyid(personInfoPo.getPersoncompanyid());
		}		
		
		request.setAttribute("worrytype", worrytype);
		request.setAttribute("salesid", ssesbsalesid);
		request.setAttribute("salesStartTime", ssesbsalesdatestarttime);
		request.setAttribute("salesEndTime", ssesbsalesdateendtime);
		request.setAttribute("personName", ssesbpersonName);
		request.setAttribute("orderstype", ssesborderstype);
		request.setAttribute("shopcode", ssesbshopcode);
		
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);
		
		// 取得登陆人允许操作的仓位&部门 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpregid(personInfoPo.getDepartmentID());
		deppo.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = spectaclesMaterialsMgr.getdepartment(deppo);
		// 取得登陆人允许操作的仓位&部门 End
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,personInfoPo.getDepartmentID());
		
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

		//总数、分页
		int count=spectaclesMaterialsFinishMgr.getSpectaclesMaterialsFinishCount(salesPo);
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
	    //取详细信息
	    spectaclesMaterialsFinishList=spectaclesMaterialsFinishMgr.selectSpectaclesMaterialsFinish(salesPo , page.getStart() , page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			spectaclesMaterialsFinishList = null;
		}
		
		
		return SUCCESS;
	}
	
	
	public String selectSpectaclesMaterialsFinishDetail(){
		
		String salesId=Utility.getName(request.getParameter("hid"));
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbsalesid(salesId);
		
		SalesBasicPo oDBasicPo=new SalesBasicPo();
		oDBasicPo.setSsesbsalesid(salesId);
		
		SalesBasicPo oSBasicPo=new SalesBasicPo();
		oSBasicPo.setSsesbsalesid(salesId);
		
		SalesDetailPo salesDetailPo=new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(salesId);
		
		salesBasicPo=spectaclesMaterialsFinishMgr.getSalesDetailInfo(salesPo);
		oDPo=spectaclesMaterialsFinishMgr.getODDetailInfo(oDBasicPo);
		oSPo=spectaclesMaterialsFinishMgr.getOSDetailInfo(oSBasicPo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("systemParameterPo", systemParameterPo);
		goodsInfoList=spectaclesMaterialsFinishMgr.selectGoodsDetailInfoes(salesDetailPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化已打印配镜已发料单页面
	 * @return
	 */
	public String initPrintSpectaclesMaterialsBillFinishSel(){
		

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
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdptype("2");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1") && Utility.getName(permissionPo.getKeya()).equals("1")){
			this.setIsFirstExec("1");
			return "selectPrintSpectaclesMaterialsBillFinish";
		}
		return SUCCESS;
	}
	
	/**
	 * 已打印配镜发料单查询
	 * @return
	 */
	public String selectPrintSpectaclesMaterialsBillFinish(){		

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
		
		String departmentid=personInfoPo.getDepartmentID();
		
		String ssesbsalesid=Utility.getName(request.getParameter("salesid"));
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("salesStartTime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("salesEndTime"));
		String ssesbpersonName=Utility.getName(request.getParameter("personName"));
		String ssesborderstype=Utility.getName(request.getParameter("orderstype"));
		String ssesbshopcode=Utility.getName(request.getParameter("shopcode"));
		String supplierID=Utility.getName(request.getParameter("supplierID"));
		String supplierName=Utility.getName(request.getParameter("supplierName"));
		String brandID=Utility.getName(request.getParameter("brandID"));
		String brandName=Utility.getName(request.getParameter("brandName"));
		String worrytype=Utility.getName(request.getParameter("worrytype"));		
		String printSerialNumber = Utility.getName(request.getParameter("printSerialNumber"));
		String printorderby = Utility.getName(request.getParameter("printorderby"));
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbdepartmentid(departmentid);
		salesPo.setSsesbsalesid(ssesbsalesid);
		salesPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesPo.setSsesbpersonName(ssesbpersonName);
		salesPo.setSsesborderstype(ssesborderstype);
		salesPo.setSsesbprocessdpt(ssesbshopcode);	
		salesPo.setSsesbdepartmenttype(personInfoPo.getDepartmenttype());
		salesPo.setSsesbworrytype(worrytype);
		salesPo.setSsesbsupplierid(supplierID);
		salesPo.setSsesbsuppliername(supplierName);
		salesPo.setSsesbbrandid(brandID);
		salesPo.setSsesbbrandname(brandName);
		salesPo.setSsesbprintserialnumber(printSerialNumber);
		salesPo.setSsesborderby(printorderby.equals("") ? "1" : printorderby);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			salesPo.setSsesbcompanyid(personInfoPo.getPersoncompanyid());
		}
		
		request.setAttribute("worrytype", worrytype);
		request.setAttribute("salesid", ssesbsalesid);
		request.setAttribute("salesStartTime", ssesbsalesdatestarttime);
		request.setAttribute("salesEndTime", ssesbsalesdateendtime);
		request.setAttribute("personName", ssesbpersonName);
		request.setAttribute("orderstype", ssesborderstype);
		request.setAttribute("shopcode", ssesbshopcode);		
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("printSerialNumber", printSerialNumber);
		request.setAttribute("printPerson", personInfoPo.getId());
		request.setAttribute("printorderby", printorderby);
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdptype("2");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);
		
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

		//总数、分页
		int count=spectaclesMaterialsFinishMgr.getPrintSpectaclesMaterialsBillFinishCount(salesPo);
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
	    //取详细信息
	    spectaclesMaterialsFinishList=spectaclesMaterialsFinishMgr.selectPrintSpectaclesMaterialsBillFinish(salesPo , page.getStart() , page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			spectaclesMaterialsFinishList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 打印配镜发料单(流水号)
	 * @return
	 */
	public String selectPrintSpectaclesMaterialsBillRpt(){
		

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
		
		String printserialnumber = GenerateNumber.getInstance().getGenerageNumber();
		
		String billID = Utility.getName(request.getParameter("bill"));
		request.setAttribute("billID",billID);
		request.setAttribute("printPerson", request.getParameter("printPerson"));
		
		
		SalesBasicPo spo = new SalesBasicPo();
		spo.setSsesbsalesid(billID);
		spo.setSsesbprintserialnumber(printserialnumber);

		if ("1".equals(Utility.getName(request.getParameter("printflag")))){
			request.setAttribute("printserialnumber", printserialnumber);
			spectaclesMaterialsFinishMgr.updatePrintSpectaclesMaterialsBillSerialNumber(spo);
		}
		
		//获得打印结算单信息----------------------------
		String actionTypeID = "39";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------		
		
		return SUCCESS;
	}
	
	/**
	 * 初始化确认发料单已打印
	 * @return
	 */
	public String initPrintSpectaclesMaterialsBillDefineSel(){
		

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
		
		String billID = Utility.getName(request.getParameter("bill"));
		request.setAttribute("billID",billID);
		
		return SUCCESS;
	}
	
	/**
	 * 确认发料单已打印
	 * @return
	 */
	public String selectPrintSpectaclesMaterialsBillDefine(){		

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
		
		String billID = Utility.getName(request.getParameter("bill"));
		request.setAttribute("billID",billID);
		
		SalesBasicPo spo = new SalesBasicPo();
		spo.setSsesbsalesid(billID);
		
		spectaclesMaterialsFinishMgr.updatePrintSpectaclesMaterialsBillStatus(spo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	public FittingTemplateTypeMgr getFittingTemplateTypeMgr() {
		return fittingTemplateTypeMgr;
	}

	public void setFittingTemplateTypeMgr(
			FittingTemplateTypeMgr fittingTemplateTypeMgr) {
		this.fittingTemplateTypeMgr = fittingTemplateTypeMgr;
	}
	
}
