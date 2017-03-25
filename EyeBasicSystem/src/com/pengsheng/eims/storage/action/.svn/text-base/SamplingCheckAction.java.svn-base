package com.pengsheng.eims.storage.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerReturnVisitMgr;
import com.pengsheng.eims.sales.mgr.ProcessDistributionMgr;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.storage.mgr.PrintWorkingCheckMgr;
import com.pengsheng.eims.storage.mgr.SamplingCheckMgr;
import com.pengsheng.eims.storage.mgr.WorkingCheckMgr;
import com.pengsheng.eims.storage.persistence.MistakePo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class SamplingCheckAction extends BaseAction {
	
	private PrintWorkingCheckMgr printWorkingCheckMgr;
	
	private List<WorkingCheckPo> printWorkingCheckList;
	
	private WorkingCheckMgr workingCheckMgr;
	
	private SamplingCheckMgr samplingCheckMgr;
	
	private List<PersonInfoPo> workingCheckpersonList;
	
	private List<DepartmentsPo> departmentsList;
	
	private PersonPermissionMgr personPermissionMgr;
	
	private CustomerReturnVisitMgr customerReturnVisitMgr;
	
	private List<SpecialPDetailPo> specialPDetailList;
	
	private SalesBasicPo salesBasicPo;
	
	private WorkingCheckPo workingCheckPo;
	
	private WorkingCheckPo samplingCheckPo;
	
	private List<WarehousePo> warehouseList;
	
	private SalesBasicPo joDPo;
	
	private SalesBasicPo joSPo;
	
	private SalesBasicPo oDPo;
	
	private SalesBasicPo oSPo;
	
	private ProcessDistributionMgr processDistributionMgr;
	
	private MistakePo odMisPo;
	
	private MistakePo osMisPo;
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

	
	/**
	 * 初始化检验单打印
	 * @return
	 */
	public String initSamplingCheckSel(){
		
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
		
		
//		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		workingCheckpersonList=workingCheckMgr.getWorkingChenkPerson(personInfoPo);
		
		// 取得登陆人允许操作的仓位&部门 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpregid(personInfoPo.getDepartmentID());
		departmentsList = printWorkingCheckMgr.getdepartment(deppo);
		// 取得登陆人允许操作的仓位&部门 End
		
		return SUCCESS;
	}
	
	/**
	 * 检验单打印查询  
	 * @return
	 */
	public String selectSamplingCheck(){
		
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
		
		
//		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String departmentid=personInfoPo.getDepartmentID();
		
		workingCheckpersonList=workingCheckMgr.getWorkingChenkPerson(personInfoPo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpregid(personInfoPo.getDepartmentID());
		departmentsList = printWorkingCheckMgr.getdepartment(deppo);
		
		String salesId=Utility.getName(request.getParameter("shopsalesid"));
		String customerName=Utility.getName(request.getParameter("shoppersonName"));
		String pchckprocesspersonid=Utility.getName(request.getParameter("pchckprocesspersonid"));
		String pchckchecklabourid=Utility.getName(request.getParameter("pchckchecklabourid"));
		String shopcode=Utility.getName(request.getParameter("shopcode"));
		
		String salesStart=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String salesEnd=Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		
		String takeStart=Utility.getName(request.getParameter("ssesbtakeglassstartdata"));
		String takeEnd=Utility.getName(request.getParameter("ssesbtakeglassenddata"));
		
		String checkStart=Utility.getName(request.getParameter("pchckstartcheckdate"));
		String checkEnd=Utility.getName(request.getParameter("pchckendcheckdate"));
		String djsbm=Utility.getName(request.getParameter("djsbm"));
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbsalesid(salesId);
		
		salesPo.setSsesbsalesdatestarttime(salesStart);
		salesPo.setSsesbsalesdateendtime(salesEnd);
		
		salesPo.setSsesbtakeglassstartdata(takeStart);
		salesPo.setSsesbtakeglassenddata(takeEnd);
		
		salesPo.setSsesbpersonName(customerName);
		salesPo.setSsesbshopcode(shopcode);
		salesPo.setSsesbdepartmentid(departmentid);
		salesPo.setDjsbm(djsbm);
		
		WorkingCheckPo CheckPo=new WorkingCheckPo();
		CheckPo.setPchckprocesspersonid(pchckprocesspersonid);
		CheckPo.setPchckchecklabourid(pchckchecklabourid);
		CheckPo.setPchckstartcheckdate(checkStart);
		CheckPo.setPchckendcheckdate(checkEnd);
		
		request.setAttribute("shopsalesid", salesId);
		
		request.setAttribute("ssesbsalesdatestarttime", salesStart);
		request.setAttribute("ssesbsalesdateendtime", salesEnd);
		
		request.setAttribute("shoppersonName", customerName);
		request.setAttribute("pchckprocesspersonid", pchckprocesspersonid);
		request.setAttribute("pchckchecklabourid", pchckchecklabourid);
		request.setAttribute("shopcode", shopcode);
		
		request.setAttribute("ssesbtakeglassstartdata", takeStart);
		request.setAttribute("ssesbtakeglassenddata", takeEnd);
		
		request.setAttribute("pchckstartcheckdate", checkStart);
		request.setAttribute("pchckendcheckdate", checkEnd);
		request.setAttribute("djsbm", djsbm);
		
		//总数、分页
		int count=printWorkingCheckMgr.getPrintWorkingCheckCount(salesPo, CheckPo);
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
			//取详细信息
			printWorkingCheckList=printWorkingCheckMgr.selectPrintWorkingCheck(salesPo , CheckPo , page.getStart() , page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			printWorkingCheckList = null;
		}
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));
		return SUCCESS;
	}
	public String initInsertSamplingCheck(){
		
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
		
		PersonInfoPo workingCheck=new PersonInfoPo();
		workingCheck.setDepartmentID(personInfoPo.getDepartmentID());
		
		workingCheckpersonList=workingCheckMgr.getWorkingChenkPerson(personInfoPo);
		
		String hid=Utility.getName(request.getParameter("hid"));
		
		request.setAttribute("hid", hid);
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbsalesid(hid);
		
		SalesBasicPo oDBasicPo=new SalesBasicPo();
		oDBasicPo.setSsesbsalesid(hid);
		
		SalesBasicPo oSBasicPo=new SalesBasicPo();
		oSBasicPo.setSsesbsalesid(hid);
		
		//特殊加工要求List
		SpecialPDetailPo specialPDetailPo=new SpecialPDetailPo();
		specialPDetailPo.setSsesdsalesid(hid);
		
		specialPDetailList=customerReturnVisitMgr.getSpecialPDetail(specialPDetailPo);
		
		salesBasicPo=workingCheckMgr.getCustomerInfo(salesPo);
		SalesBasicPo basicPo = new SalesBasicPo();
		basicPo.setSsesbcustomerid(salesBasicPo.getSsesbcustomerid());
		workingCheckPo = workingCheckMgr.getLastWorkingCheckPo(basicPo);
		if(workingCheckPo.getPchckcokeballglassod()!= null){
			request.setAttribute("copylast", "1");
		}else{
			request.setAttribute("copylast", "0");
		}
		joDPo=workingCheckMgr.getODDetailInfo(oDBasicPo);
		joSPo=workingCheckMgr.getOSDetailInfo(oSBasicPo);
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(((PersonInfoPo)session.get("person")).getDepartmentID());
		warehouseList=processDistributionMgr.getWarehouseList(deppo);
		
		/*
		 * 不同镜片类型允差不同 1为单多光，2为渐进
		 */
		if("J".equals(joDPo.getSsesbismutiluminosity())){
			joDPo.setSsesbismutiluminosity("2");
		}else{
			joDPo.setSsesbismutiluminosity("1");
		}
		
		if("J".equals(joSPo.getSsesbismutiluminosity())){
			joSPo.setSsesbismutiluminosity("2");
		}else{
			joSPo.setSsesbismutiluminosity("1");
		}
		odMisPo=workingCheckMgr.getMistakeODPo(joDPo);
		osMisPo=workingCheckMgr.getMistakeOSPo(joSPo);
		workingCheckPo = workingCheckMgr.getWorkingCheckPo(hid);
		workingCheckPo.setPchckpersonname(personInfoPo.getPersonName());
		
		
		workingCheckpersonList=workingCheckMgr.getWorkingChenkPerson(personInfoPo);
		
		String salesId=Utility.getName(request.getParameter("ssesbsalesid"));
		
		request.setAttribute("ssesbsalesid", salesId);
		
		
		salesBasicPo=workingCheckMgr.getCustomerInfo(salesPo);

		oDPo=workingCheckMgr.getODDetailInfo(oDBasicPo);
		oSPo=workingCheckMgr.getOSDetailInfo(oSBasicPo);
		
		/*
		 * 不同镜片类型允差不同 1为单多光，2为渐进
		 */
		if("J".equals(oDPo.getSsesbismutiluminosity())){
			oDPo.setSsesbismutiluminosity("2");
		}else{
			oDPo.setSsesbismutiluminosity("1");
		}
		
		if("J".equals(oSPo.getSsesbismutiluminosity())){
			oSPo.setSsesbismutiluminosity("2");
		}else{
			oSPo.setSsesbismutiluminosity("1");
		}
		odMisPo=workingCheckMgr.getMistakeODPo(oDPo);
		osMisPo=workingCheckMgr.getMistakeOSPo(oSPo);
		
		return SUCCESS;
	}
	
	public String initSamplingCheckDetails(){
		
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

		PersonInfoPo workingCheck=new PersonInfoPo();
		workingCheck.setDepartmentID(personInfoPo.getDepartmentID());
		
		workingCheckpersonList=workingCheckMgr.getWorkingChenkPerson(personInfoPo);
		
		String hid=Utility.getName(request.getParameter("hid"));
		
		request.setAttribute("hid", hid);
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbsalesid(hid);
		
		SalesBasicPo oDBasicPo=new SalesBasicPo();
		oDBasicPo.setSsesbsalesid(hid);
		
		SalesBasicPo oSBasicPo=new SalesBasicPo();
		oSBasicPo.setSsesbsalesid(hid);
		
		//特殊加工要求List
		SpecialPDetailPo specialPDetailPo=new SpecialPDetailPo();
		specialPDetailPo.setSsesdsalesid(hid);
		
		specialPDetailList=customerReturnVisitMgr.getSpecialPDetail(specialPDetailPo);
		
		salesBasicPo=workingCheckMgr.getCustomerInfo(salesPo);
		SalesBasicPo basicPo = new SalesBasicPo();
		basicPo.setSsesbcustomerid(salesBasicPo.getSsesbcustomerid());
		workingCheckPo = workingCheckMgr.getLastWorkingCheckPo(basicPo);
		if(workingCheckPo.getPchckcokeballglassod()!= null){
			request.setAttribute("copylast", "1");
		}else{
			request.setAttribute("copylast", "0");
		}
		
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(((PersonInfoPo)session.get("person")).getDepartmentID());
		warehouseList=processDistributionMgr.getWarehouseList(deppo);
		
		joDPo=workingCheckMgr.getODDetailInfo(oDBasicPo);
		joSPo=workingCheckMgr.getOSDetailInfo(oSBasicPo);
		
		/*
		 * 不同镜片类型允差不同 1为单多光，2为渐进
		 */
		if("J".equals(Utility.getName(joDPo.getSsesbismutiluminosity()))){
			joDPo.setSsesbismutiluminosity("2");
		}else{
			joDPo.setSsesbismutiluminosity("1");
		}
		
		if("J".equals(Utility.getName(joSPo.getSsesbismutiluminosity()))){
			joSPo.setSsesbismutiluminosity("2");
		}else{
			joSPo.setSsesbismutiluminosity("1");
		}
		odMisPo=workingCheckMgr.getMistakeODPo(joDPo);
		osMisPo=workingCheckMgr.getMistakeOSPo(joSPo);
		
		workingCheckPo = workingCheckMgr.getWorkingCheckPo(hid);
		samplingCheckPo = printWorkingCheckMgr.getSampledCheckPo(hid);
		workingCheckPo.setPchckpersonname(personInfoPo.getPersonName());
		
		
		workingCheckpersonList=workingCheckMgr.getWorkingChenkPerson(personInfoPo);
		
		String salesId=Utility.getName(request.getParameter("ssesbsalesid"));
		
		request.setAttribute("ssesbsalesid", salesId);		
		
		salesBasicPo=workingCheckMgr.getCustomerInfo(salesPo);

		oDPo=workingCheckMgr.getODDetailInfo(oDBasicPo);
		oSPo=workingCheckMgr.getOSDetailInfo(oSBasicPo);
		
		/*
		 * 不同镜片类型允差不同 1为单多光，2为渐进
		 */
		if("J".equals(oDPo.getSsesbismutiluminosity())){
			oDPo.setSsesbismutiluminosity("2");
		}else{
			oDPo.setSsesbismutiluminosity("1");
		}
		
		if("J".equals(oSPo.getSsesbismutiluminosity())){
			oSPo.setSsesbismutiluminosity("2");
		}else{
			oSPo.setSsesbismutiluminosity("1");
		}
		odMisPo=workingCheckMgr.getMistakeODPo(oDPo);
		osMisPo=workingCheckMgr.getMistakeOSPo(oSPo);
		
		return SUCCESS;
	}
	
	/**
	 * 新增检验数据
	 * @return
	 */
	public String insertSamplingCheck(){
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		String createPerson = personInfoPo.getId();
		
		String salesId=Utility.getName(request.getParameter("salesid"));
		
		InTransitPo inTransitPo=new InTransitPo();
		inTransitPo.setSseitsalesid(salesId);
		inTransitPo.setSseitdepartment(departmentId);
		inTransitPo.setSseitcreateperson(createPerson);
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbsalesid(salesId);
		
		
		workingCheckPo.setPchckchecklabourid(createPerson);
		workingCheckPo.setPchcksalesid(salesId);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("34");    // 检验完成
		logPo.setsLogContent(salesId);
		
		samplingCheckMgr.insertWorkingCheck(inTransitPo, salesPo, workingCheckPo,logPo);
		//删除检验完成提示
		//this.clearMessages();
		//this.addActionMessage(getText("struts.messages.insert.check.sucess"));
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(((PersonInfoPo)session.get("person")).getDepartmentID());
		warehouseList=processDistributionMgr.getWarehouseList(deppo);
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化抽检记录查询
	 * @return
	 */
	public String initSelectSampledCheck(){
		
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
		
		
		
//		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		workingCheckpersonList=workingCheckMgr.getWorkingChenkPerson(personInfoPo);
		
		// 取得登陆人允许操作的仓位&部门 Begin
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpregid(personInfoPo.getDepartmentID());
		departmentsList = printWorkingCheckMgr.getdepartment(deppo);
		// 取得登陆人允许操作的仓位&部门 End
		
		return SUCCESS;
	}
	
	/**
	 * 抽检记录查询  
	 * @return
	 */
	public String selectSampledCheck(){
		
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
		
		workingCheckpersonList=workingCheckMgr.getWorkingChenkPerson(personInfoPo);
		
		DepartmentsPo deppo = new DepartmentsPo();
		deppo.setBdpregid(personInfoPo.getDepartmentID());
		departmentsList = printWorkingCheckMgr.getdepartment(deppo);
		
		String salesId=Utility.getName(request.getParameter("shopsalesid"));
		String customerName=Utility.getName(request.getParameter("shoppersonName"));
		String samplingname=Utility.getName(request.getParameter("samplingname"));
		String pchckchecklabourid=Utility.getName(request.getParameter("pchckchecklabourid"));
		String shopcode=Utility.getName(request.getParameter("shopcode"));
		
		String salesStart=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String salesEnd=Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		
		String takeStart=Utility.getName(request.getParameter("ssesbtakeglassstartdata"));
		String takeEnd=Utility.getName(request.getParameter("ssesbtakeglassenddata"));
		
		String checkStart=Utility.getName(request.getParameter("pchckstartcheckdate"));
		String checkEnd=Utility.getName(request.getParameter("pchckendcheckdate"));
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbsalesid(salesId);
		
		salesPo.setSsesbsalesdatestarttime(salesStart);
		salesPo.setSsesbsalesdateendtime(salesEnd);
		
		salesPo.setSsesbtakeglassstartdata(takeStart);
		salesPo.setSsesbtakeglassenddata(takeEnd);
		
		salesPo.setSsesbpersonName(customerName);
		salesPo.setSsesbshopcode(shopcode);
		salesPo.setSsesbdepartmentid(departmentid);
		
		WorkingCheckPo CheckPo=new WorkingCheckPo();
		CheckPo.setPchckprocesspersonid(pchckchecklabourid);
		CheckPo.setPchckchecklabourid(samplingname);
		CheckPo.setPchckstartcheckdate(checkStart);
		CheckPo.setPchckendcheckdate(checkEnd);
		
		request.setAttribute("shopsalesid", salesId);
		
		request.setAttribute("ssesbsalesdatestarttime", salesStart);
		request.setAttribute("ssesbsalesdateendtime", salesEnd);
		
		request.setAttribute("shoppersonName", customerName);
		request.setAttribute("samplingname", samplingname);
		request.setAttribute("pchckchecklabourid", pchckchecklabourid);
		request.setAttribute("shopcode", shopcode);
		
		request.setAttribute("ssesbtakeglassstartdata", takeStart);
		request.setAttribute("ssesbtakeglassenddata", takeEnd);
		
		request.setAttribute("pchckstartcheckdate", checkStart);
		request.setAttribute("pchckendcheckdate", checkEnd);
		
		//总数、分页
		int count=printWorkingCheckMgr.getSampledCheckCount(salesPo, CheckPo);
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
			//取详细信息
			printWorkingCheckList=printWorkingCheckMgr.selectSampledCheck(salesPo , CheckPo , page.getStart() , page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			printWorkingCheckList = null;
		}
		request.setAttribute("showhider", Utility.getName(request.getParameter("showhider")));
		return SUCCESS;
	}

	public SalesBasicPo getJoDPo() {
		return joDPo;
	}

	public void setJoDPo(SalesBasicPo joDPo) {
		this.joDPo = joDPo;
	}

	public SalesBasicPo getJoSPo() {
		return joSPo;
	}

	public void setJoSPo(SalesBasicPo joSPo) {
		this.joSPo = joSPo;
	}
	
	public MistakePo getOdMisPo() {
		return odMisPo;
	}

	public void setOdMisPo(MistakePo odMisPo) {
		this.odMisPo = odMisPo;
	}

	public MistakePo getOsMisPo() {
		return osMisPo;
	}

	public void setOsMisPo(MistakePo osMisPo) {
		this.osMisPo = osMisPo;
	}
	
	public ProcessDistributionMgr getProcessDistributionMgr() {
		return processDistributionMgr;
	}

	public void setProcessDistributionMgr(
			ProcessDistributionMgr processDistributionMgr) {
		this.processDistributionMgr = processDistributionMgr;
	}

	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}
	
	public WorkingCheckPo getWorkingCheckPo() {
		return workingCheckPo;
	}

	public void setWorkingCheckPo(WorkingCheckPo workingCheckPo) {
		this.workingCheckPo = workingCheckPo;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}
	
	public CustomerReturnVisitMgr getCustomerReturnVisitMgr() {
		return customerReturnVisitMgr;
	}

	public void setCustomerReturnVisitMgr(
			CustomerReturnVisitMgr customerReturnVisitMgr) {
		this.customerReturnVisitMgr = customerReturnVisitMgr;
	}

	public List<SpecialPDetailPo> getSpecialPDetailList() {
		return specialPDetailList;
	}

	public void setSpecialPDetailList(List<SpecialPDetailPo> specialPDetailList) {
		this.specialPDetailList = specialPDetailList;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public WorkingCheckMgr getWorkingCheckMgr() {
		return workingCheckMgr;
	}

	public void setWorkingCheckMgr(WorkingCheckMgr workingCheckMgr) {
		this.workingCheckMgr = workingCheckMgr;
	}

	public List<PersonInfoPo> getWorkingCheckpersonList() {
		return workingCheckpersonList;
	}

	public void setWorkingCheckpersonList(List<PersonInfoPo> workingCheckpersonList) {
		this.workingCheckpersonList = workingCheckpersonList;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public List<WorkingCheckPo> getPrintWorkingCheckList() {
		return printWorkingCheckList;
	}

	public void setPrintWorkingCheckList(List<WorkingCheckPo> printWorkingCheckList) {
		this.printWorkingCheckList = printWorkingCheckList;
	}

	public PrintWorkingCheckMgr getPrintWorkingCheckMgr() {
		return printWorkingCheckMgr;
	}

	public void setPrintWorkingCheckMgr(PrintWorkingCheckMgr printWorkingCheckMgr) {
		this.printWorkingCheckMgr = printWorkingCheckMgr;
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

	public SamplingCheckMgr getSamplingCheckMgr() {
		return samplingCheckMgr;
	}

	public void setSamplingCheckMgr(SamplingCheckMgr samplingCheckMgr) {
		this.samplingCheckMgr = samplingCheckMgr;
	}

	public WorkingCheckPo getSamplingCheckPo() {
		return samplingCheckPo;
	}

	public void setSamplingCheckPo(WorkingCheckPo samplingCheckPo) {
		this.samplingCheckPo = samplingCheckPo;
	}
	
}
