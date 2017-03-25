package com.pengsheng.eims.storage.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.WindowsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerReturnVisitMgr;
import com.pengsheng.eims.sales.mgr.ProcessDistributionMgr;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.storage.mgr.RecordWorkingTimeMgr;
import com.pengsheng.eims.storage.mgr.WorkingCheckMgr;
import com.pengsheng.eims.storage.persistence.FirstCheckPo;
import com.pengsheng.eims.storage.persistence.MistakePo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class RecordWorkingTimeAction extends BaseAction {
	private List<WarehousePo> warehouseList;
	private ProcessDistributionMgr processDistributionMgr;
    private WindowsMgr windowsMgr;	
    private SystemParameterMgr systemParameterMgr;
    private SystemParameterPo systemParameterPo;
    private PersonInfoMgr personInfoMgr;
    private String isFirstExec;
    private BillKeyMgr billKeyMgr;
    
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
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}
	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
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
	public WindowsMgr getWindowsMgr() {
		return windowsMgr;
	}
	public void setWindowsMgr(WindowsMgr windowsMgr) {
		this.windowsMgr = windowsMgr;
	}
	
	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}

	public ProcessDistributionMgr getProcessDistributionMgr() {
		return processDistributionMgr;
	}

	public void setProcessDistributionMgr(
			ProcessDistributionMgr processDistributionMgr) {
		this.processDistributionMgr = processDistributionMgr;
	}

	private WorkingCheckMgr workingCheckMgr;
	
	private List<SalesBasicPo> workingCheckList;
	
	private SalesBasicPo salesBasicPo;
	
	private SalesBasicPo oDPo;
	
	private SalesBasicPo fPo;
	
	private SalesBasicPo oSPo;
	
	private List<PersonInfoPo> workingCheckpersonList;
	
	private CustomerReturnVisitMgr customerReturnVisitMgr;
	
	private List<SpecialPDetailPo> specialPDetailList;
	
	private WorkingCheckPo workingCheckPo;
	
	private MistakePo odMisPo;
	
	private MistakePo osMisPo;

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

	public WorkingCheckPo getWorkingCheckPo() {
		return workingCheckPo;
	}

	public void setWorkingCheckPo(WorkingCheckPo workingCheckPo) {
		this.workingCheckPo = workingCheckPo;
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

	public List<PersonInfoPo> getWorkingCheckpersonList() {
		return workingCheckpersonList;
	}

	public void setWorkingCheckpersonList(List<PersonInfoPo> workingCheckpersonList) {
		this.workingCheckpersonList = workingCheckpersonList;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
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

	public WorkingCheckMgr getWorkingCheckMgr() {
		return workingCheckMgr;
	}

	public void setWorkingCheckMgr(WorkingCheckMgr workingCheckMgr) {
		this.workingCheckMgr = workingCheckMgr;
	}

	public List<SalesBasicPo> getWorkingCheckList() {
		return workingCheckList;
	}

	public void setWorkingCheckList(List<SalesBasicPo> workingCheckList) {
		this.workingCheckList = workingCheckList;
	}

	public SalesBasicPo getfPo() {
		return fPo;
	}

	public void setfPo(SalesBasicPo fPo) {
		this.fPo = fPo;
	}
	
	private List<FirstCheckPo> firstCheckPos;
	
	private RecordWorkingTimeMgr recordWorkingTimeMgr;
	
	private List<SalesBasicPo> recordWorkingTimeList;
	
	private List<DepartmentsPo> departmentsList;
	
	private PersonPermissionMgr personPermissionMgr;
	
	private FirstCheckPo firstCheckPo;
	
	public FirstCheckPo getFirstCheckPo() {
		return firstCheckPo;
	}

	public void setFirstCheckPo(FirstCheckPo firstCheckPo) {
		this.firstCheckPo = firstCheckPo;
	}

	public List<FirstCheckPo> getFirstCheckPos() {
		return firstCheckPos;
	}

	public void setFirstCheckPos(List<FirstCheckPo> firstCheckPos) {
		this.firstCheckPos = firstCheckPos;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public RecordWorkingTimeMgr getRecordWorkingTimeMgr() {
		return recordWorkingTimeMgr;
	}

	public void setRecordWorkingTimeMgr(RecordWorkingTimeMgr recordWorkingTimeMgr) {
		this.recordWorkingTimeMgr = recordWorkingTimeMgr;
	}

	public List<SalesBasicPo> getRecordWorkingTimeList() {
		return recordWorkingTimeList;
	}

	public void setRecordWorkingTimeList(List<SalesBasicPo> recordWorkingTimeList) {
		this.recordWorkingTimeList = recordWorkingTimeList;
	}

	/**
	 * 初始化记录加工时间
	 * @return
	 */
	public String initRecordWorkingTimeSel(){
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
		
		//得到取镜及销售门店列表
		DepartmentsPo dePo=new DepartmentsPo();
		dePo.setBdpregid(personInfoPo.getDepartmentID());
		
		departmentsList=recordWorkingTimeMgr.getdepartment(dePo);
		
		int count = windowsMgr.isEnabledInTransit("7");
		request.setAttribute("InTransitCount", count);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectRecordWorkingTime";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 记录加工时间信息查询
	 * @return
	 */
	public String selectRecordWorkingTime(){
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
		//得到取镜及销售门店列表
		DepartmentsPo dePo=new DepartmentsPo();
		dePo.setBdpregid(personInfoPo.getDepartmentID());
		
		departmentsList=recordWorkingTimeMgr.getdepartment(dePo);
		
		String salesid=Utility.getName(request.getParameter("shopsalesid"));
		String customername=Utility.getName(request.getParameter("shoppersonName"));
		String salesshopcode=Utility.getName(request.getParameter("salesshopcode"));
		String takeshopcode=Utility.getName(request.getParameter("takeshopcode"));
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String ssesbtakeglassstartdata=Utility.getName(request.getParameter("ssesbtakeglassstartdata"));
		String ssesbtakeglassenddata=Utility.getName(request.getParameter("ssesbtakeglassenddata"));
		String worrytype = Utility.getName(request.getParameter("worrytype"));
		String djsbm=Utility.getName(request.getParameter("djsbm"));
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbdepartmentid(departmentid);
		salesPo.setSsesbsalesid(salesid);
		salesPo.setSsesbpersonName(customername);
		salesPo.setSsesbshopcode(salesshopcode);
		salesPo.setSsesblocation(takeshopcode);
		salesPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesPo.setSsesbtakeglassstartdata(ssesbtakeglassstartdata);
		salesPo.setSsesbtakeglassenddata(ssesbtakeglassenddata);
		salesPo.setSsesbworrytype(worrytype);
		salesPo.setDjsbm(djsbm);
		
		request.setAttribute("shopsalesid", salesid);
		request.setAttribute("shoppersonName", customername);
		request.setAttribute("salesshopcode", salesshopcode);
		request.setAttribute("takeshopcode", takeshopcode);
		request.setAttribute("ssesbsalesdatestarttime", ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime", ssesbsalesdateendtime);
		request.setAttribute("ssesbtakeglassstartdata", ssesbtakeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata", ssesbtakeglassenddata);
		request.setAttribute("worrytype", worrytype);
		request.setAttribute("djsbm", djsbm);
		
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
		int count=recordWorkingTimeMgr.getRecordWorkingTimeCount(salesPo);
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
			recordWorkingTimeList=recordWorkingTimeMgr.selectRecordWorkingTime(salesPo , page.getStart() , page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			recordWorkingTimeList = null;
		}

		request.setAttribute("InTransitCount", windowsMgr.isEnabledInTransit("7"));
		
		return SUCCESS;
	}
	
	public String initRecordWorkingTimeIns(){
		
		String salesid=Utility.getName(request.getParameter("ssesbsalesid"));
		
		request.setAttribute("ssesbsalesid", salesid);
		
		return SUCCESS;
	}
	
	
	
	public String initInsertRecordWorkingTime(){
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
		
		String ssesbsalesid = Utility.getName(request.getParameter("ssesbsalesid"));
		
		firstCheckPos = recordWorkingTimeMgr.getFirstChecks(ssesbsalesid);
		
		String firstcheckpersonname = personInfoPo.getPersonName();
		
		request.setAttribute("createPerson", createPerson);
		request.setAttribute("firstcheckpersonname", firstcheckpersonname);
				
		request.setAttribute("moduleID", moduleID);

		PersonInfoPo workingCheck=new PersonInfoPo();
		workingCheck.setDepartmentID(personInfoPo.getDepartmentID());
		
		request.setAttribute("ssesbsalesid", ssesbsalesid);
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbsalesid(ssesbsalesid);
		
		SalesBasicPo oDBasicPo=new SalesBasicPo();
		oDBasicPo.setSsesbsalesid(ssesbsalesid);
		
		SalesBasicPo oSBasicPo=new SalesBasicPo();
		oSBasicPo.setSsesbsalesid(ssesbsalesid);
		
		//特殊加工要求List
		SpecialPDetailPo specialPDetailPo=new SpecialPDetailPo();
		specialPDetailPo.setSsesdsalesid(ssesbsalesid);
		
		specialPDetailList=customerReturnVisitMgr.getSpecialPDetail(specialPDetailPo);
		
		salesBasicPo=workingCheckMgr.getCustomerInfo(salesPo);
		
		oDPo=workingCheckMgr.getODDetailInfo(oDBasicPo);
		oSPo=workingCheckMgr.getOSDetailInfo(oSBasicPo);
		fPo = workingCheckMgr.getFrameDetailInfo(oSBasicPo);
		
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
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		return SUCCESS;
	}
	
	/**
	 * 插入初检记录
	 * @return
	 */
	public String insertRecordWorkingTime(){
		
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
		
		String ssesbsalesid=Utility.getName(request.getParameter("ssesbsalesid"));
		SalesBasicPo salesPo=new SalesBasicPo();
		InTransitPo inTransitPo=new InTransitPo();
		
		salesPo.setSsesbsalesid(ssesbsalesid);
		
		int istake = billKeyMgr.selectProcurementOrderForType("7",ssesbsalesid);
		if(istake == 1){
			this.clearMessages();
			this.addActionMessage("该配镜单已初验，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		inTransitPo.setSseitsalesid(ssesbsalesid);
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("32");    // 1 表示新增
		logPo.setsLogContent(ssesbsalesid);
		
	    systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
	    String salesid=Utility.getName(request.getParameter("shopsalesid"));
		
		String customername=Utility.getName(request.getParameter("shoppersonName"));
		String salesshopcode=Utility.getName(request.getParameter("salesshopcode"));
		String takeshopcode=Utility.getName(request.getParameter("takeshopcode"));
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String ssesbtakeglassstartdata=Utility.getName(request.getParameter("ssesbtakeglassstartdata"));
		String ssesbtakeglassenddata=Utility.getName(request.getParameter("ssesbtakeglassenddata"));
		String pchfckremark=Utility.getName(request.getParameter("pchfckremark"));
		
		request.setAttribute("ssesbsalesid", ssesbsalesid);
		request.setAttribute("shoppersonName", customername);
		request.setAttribute("salesshopcode", salesshopcode);
		request.setAttribute("takeshopcode", takeshopcode);
		request.setAttribute("ssesbsalesdatestarttime", ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime", ssesbsalesdateendtime);
		request.setAttribute("ssesbtakeglassstartdata", ssesbtakeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata", ssesbtakeglassenddata);
		request.setAttribute("pchfckremark", pchfckremark);
		
		if("1".equals(Utility.getName(systemParameterPo.getFspfirstchecktype()))){
			recordWorkingTimeMgr.insertRecordWorkingTimeEasy(salesPo, inTransitPo,logPo);
			String url = "'selectRecordWorkingTime.action?moduleID="+moduleID;
			if(!"".equals(salesid))
			{
				url+="&shopsalesid="+salesid;
			}
			if(!"".equals(customername))
			{
				url+="&shoppersonName="+customername;
			}
			if(!"".equals(salesshopcode))
			{
				url+="&salesshopcode="+salesshopcode;
			}
			if(!"".equals(takeshopcode))
			{
				url+="&takeshopcode="+takeshopcode;
			}
			if(!"".equals(ssesbsalesdatestarttime))
			{
				url+="&ssesbsalesdatestarttime="+ssesbsalesdatestarttime;
			}
			if(!"".equals(ssesbsalesdateendtime))
			{
				url+="&ssesbsalesdateendtime="+ssesbsalesdateendtime;
			}
			if(!"".equals(ssesbtakeglassstartdata))
			{
				url+="&ssesbtakeglassstartdata="+ssesbtakeglassstartdata;
			}
			if(!"".equals(ssesbtakeglassenddata))
			{
				url+="&ssesbtakeglassenddata="+ssesbtakeglassenddata;
			}
			url+="'";
			this.clearMessages();
			this.addActionMessage("初检成功！");
			request.setAttribute("url", url);
			request.setAttribute("flag", GlobalConstants.INSERT);
		}else{
			workingCheckPo.setPchcksalesid(ssesbsalesid);
			workingCheckPo.setPchckchecklabourid(personInfoPo.getId());
			workingCheckPo.setPchckremark(pchfckremark);
			recordWorkingTimeMgr.insertRecordWorkingTime(salesPo, inTransitPo,workingCheckPo,logPo);
			this.clearMessages();
			this.addActionMessage("初检信息插入成功！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 加载初检记录查询页
	 * @return
	 */
	public String initRecordWorkingCheckSel(){
		
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
		
		//得到取镜及销售门店列表
		DepartmentsPo dePo=new DepartmentsPo();
		dePo.setBdpregid(personInfoPo.getDepartmentID());
		
		departmentsList=recordWorkingTimeMgr.getdepartment(dePo);
		
		int count = windowsMgr.isEnabledInTransit("7");
		request.setAttribute("InTransitCount", count);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectRecordWorkingCheck";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 记录加工时间信息查询
	 * @return
	 */
	public String selectRecordWorkingCheck(){
		
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
		//得到取镜及销售门店列表
		DepartmentsPo dePo=new DepartmentsPo();
		dePo.setBdpregid(personInfoPo.getDepartmentID());
		
		departmentsList=recordWorkingTimeMgr.getdepartment(dePo);
		
		String salesid=Utility.getName(request.getParameter("shopsalesid"));
		String customername=Utility.getName(request.getParameter("shoppersonName"));
		String salesshopcode=Utility.getName(request.getParameter("salesshopcode"));
		String takeshopcode=Utility.getName(request.getParameter("takeshopcode"));
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String ssesbtakeglassstartdata=Utility.getName(request.getParameter("ssesbtakeglassstartdata"));
		String ssesbtakeglassenddata=Utility.getName(request.getParameter("ssesbtakeglassenddata"));
		String remark=Utility.getName(request.getParameter("remark"));
		
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbdepartmentid(departmentid);
		salesPo.setSsesbsalesid(salesid);
		salesPo.setSsesbpersonName(customername);
		salesPo.setSsesbshopcode(salesshopcode);
		salesPo.setSsesblocation(takeshopcode);
		salesPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesPo.setSsesbtakeglassstartdata(ssesbtakeglassstartdata);
		salesPo.setSsesbtakeglassenddata(ssesbtakeglassenddata);
		salesPo.setRemark(remark);
		request.setAttribute("shopsalesid", salesid);
		request.setAttribute("shoppersonName", customername);
		request.setAttribute("salesshopcode", salesshopcode);
		request.setAttribute("takeshopcode", takeshopcode);
		request.setAttribute("ssesbsalesdatestarttime", ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime", ssesbsalesdateendtime);
		request.setAttribute("ssesbtakeglassstartdata", ssesbtakeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata", ssesbtakeglassenddata);
		request.setAttribute("remark", remark);
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
		int count=recordWorkingTimeMgr.getRecordWorkingCheckCount(salesPo);
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
			recordWorkingTimeList=recordWorkingTimeMgr.selectRecordWorkingCheck(salesPo , page.getStart() , page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			recordWorkingTimeList = null;
		}
		request.setAttribute("InTransitCount", windowsMgr.isEnabledInTransit("7"));
		return SUCCESS;
	}
	
	public String detailsRecordWorkingCheck(){
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
		
		String ssesbsalesid = Utility.getName(request.getParameter("ssesbsalesid"));
		
		workingCheckPo = recordWorkingTimeMgr.getFirstChecksDetails(ssesbsalesid);
		
		request.setAttribute("moduleID", moduleID);

		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbsalesid(ssesbsalesid);
		
		SalesBasicPo oDBasicPo=new SalesBasicPo();
		oDBasicPo.setSsesbsalesid(ssesbsalesid);
		
		SalesBasicPo oSBasicPo=new SalesBasicPo();
		oSBasicPo.setSsesbsalesid(ssesbsalesid);
		
		//特殊加工要求List
		SpecialPDetailPo specialPDetailPo=new SpecialPDetailPo();
		specialPDetailPo.setSsesdsalesid(ssesbsalesid);
		
		specialPDetailList=customerReturnVisitMgr.getSpecialPDetail(specialPDetailPo);
		
		salesBasicPo=workingCheckMgr.getCustomerInfo(salesPo);

		oDPo=workingCheckMgr.getODDetailInfo(oDBasicPo);
		oSPo=workingCheckMgr.getOSDetailInfo(oSBasicPo);
		fPo = workingCheckMgr.getFrameDetailInfo(oSBasicPo);
		
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
	 * 加工师加工初始化
	 * @return
	 */
	public String initSelectStartWorking(){
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
		
		//得到取镜及销售门店列表
		DepartmentsPo dePo=new DepartmentsPo();
		dePo.setBdpregid(personInfoPo.getDepartmentID());
		
		departmentsList=recordWorkingTimeMgr.getdepartment(dePo);
		
		int count = windowsMgr.isEnabledInTransit("8");
		request.setAttribute("InTransitCount", count);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectStartWorking";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 加工师加工查询
	 * @return
	 */
	public String selectStartWorking(){
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
		//得到取镜及销售门店列表
		DepartmentsPo dePo=new DepartmentsPo();
		dePo.setBdpregid(personInfoPo.getDepartmentID());
		
		departmentsList=recordWorkingTimeMgr.getdepartment(dePo);
		
		String salesid=Utility.getName(request.getParameter("shopsalesid"));
		String customername=Utility.getName(request.getParameter("shoppersonName"));
		String salesshopcode=Utility.getName(request.getParameter("salesshopcode"));
		String takeshopcode=Utility.getName(request.getParameter("takeshopcode"));
		String ssesbsalesdatestarttime=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String ssesbsalesdateendtime=Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		String ssesbtakeglassstartdata=Utility.getName(request.getParameter("ssesbtakeglassstartdata"));
		String ssesbtakeglassenddata=Utility.getName(request.getParameter("ssesbtakeglassenddata"));
		String worrytype = Utility.getName(request.getParameter("worrytype"));
		String djsbm=Utility.getName(request.getParameter("djsbm"));
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbdepartmentid(departmentid);
		salesPo.setSsesbsalesid(salesid);
		salesPo.setSsesbpersonName(customername);
		salesPo.setSsesbshopcode(salesshopcode);
		salesPo.setSsesblocation(takeshopcode);
		salesPo.setSsesbsalesdatestarttime(ssesbsalesdatestarttime);
		salesPo.setSsesbsalesdateendtime(ssesbsalesdateendtime);
		salesPo.setSsesbtakeglassstartdata(ssesbtakeglassstartdata);
		salesPo.setSsesbtakeglassenddata(ssesbtakeglassenddata);
		salesPo.setSsesbworrytype(worrytype);
		salesPo.setDjsbm(djsbm);
		
		request.setAttribute("worrytype", worrytype);
		request.setAttribute("shopsalesid", salesid);
		request.setAttribute("shoppersonName", customername);
		request.setAttribute("salesshopcode", salesshopcode);
		request.setAttribute("takeshopcode", takeshopcode);
		request.setAttribute("ssesbsalesdatestarttime", ssesbsalesdatestarttime);
		request.setAttribute("ssesbsalesdateendtime", ssesbsalesdateendtime);
		request.setAttribute("ssesbtakeglassstartdata", ssesbtakeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata", ssesbtakeglassenddata);
		request.setAttribute("djsbm", djsbm);
		
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
		int count=recordWorkingTimeMgr.selectStartWorkingCount(salesPo);
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
			recordWorkingTimeList=recordWorkingTimeMgr.selectStartWorkingList(salesPo , page.getStart() , page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			recordWorkingTimeList = null;
		}
		request.setAttribute("InTransitCount", windowsMgr.isEnabledInTransit("8"));
		
		return SUCCESS;
	}
	
	/**
	 * 加载员工卡扫描页
	 */
	public String initStartWorkingScanPerson() throws Exception {
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
		String ssesbsalesid = Utility.getName(request.getParameter("ssesbsalesid"));
		String allsalesid = Utility.getName(request.getParameter("allsalesid"));
		request.setAttribute("ssesbsalesid", ssesbsalesid);
		request.setAttribute("allsalesid", allsalesid);
		return SUCCESS;
	}
	
	/**
	 * 加工师加工在途信息插入及更新
	 * @return
	 */
	public String updateStartWorkingState(){
		/** ********************** 权限设置  ***************************** */
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
		
		String personcardid = Utility.getName(request.getParameter("personcardid"));
		String ssesbsalesid = Utility.getName(request.getParameter("ssesbsalesid"));
		request.setAttribute("ssesbsalesid", ssesbsalesid);
		
		int istake = billKeyMgr.selectProcurementOrderForType("8",ssesbsalesid);
		if(istake == 1){
			this.clearMessages();
			this.addActionMessage("该销售单已加工，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		PersonInfoPo po = new PersonInfoPo();
		po.setCardid(personcardid);
		
		PersonInfoPo ppo = new PersonInfoPo();
		ppo = personInfoMgr.getPersonInfo(po);
		
		if("".equals(Utility.getName(ppo.getId()))){
			this.addActionMessage(getText("不存在该员工信息！")); 
			return "error"; 
		}else{
			SalesBasicPo salesPo=new SalesBasicPo();
			InTransitPo inTransitPo=new InTransitPo();
			
			salesPo.setSsesbsalesid(ssesbsalesid);
			inTransitPo.setSseitsalesid(ssesbsalesid);
			inTransitPo.setSseitcreateperson(ppo.getId());
			inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 模块ID
			logPo.setsLogOpID("32");    // 1 表示新增
			logPo.setsLogContent(ssesbsalesid);
			
		    systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			
			String customername=Utility.getName(request.getParameter("shoppersonName"));
			String salesshopcode=Utility.getName(request.getParameter("salesshopcode"));
			String takeshopcode=Utility.getName(request.getParameter("takeshopcode"));
			String ssesbsalesdatestarttime=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
			String ssesbsalesdateendtime=Utility.getName(request.getParameter("ssesbsalesdateendtime"));
			String ssesbtakeglassstartdata=Utility.getName(request.getParameter("ssesbtakeglassstartdata"));
			String ssesbtakeglassenddata=Utility.getName(request.getParameter("ssesbtakeglassenddata"));
			
			request.setAttribute("ssesbsalesid", ssesbsalesid);
			request.setAttribute("shoppersonName", customername);
			request.setAttribute("salesshopcode", salesshopcode);
			request.setAttribute("takeshopcode", takeshopcode);
			request.setAttribute("ssesbsalesdatestarttime", ssesbsalesdatestarttime);
			request.setAttribute("ssesbsalesdateendtime", ssesbsalesdateendtime);
			request.setAttribute("ssesbtakeglassstartdata", ssesbtakeglassstartdata);
			request.setAttribute("ssesbtakeglassenddata", ssesbtakeglassenddata);
			
			recordWorkingTimeMgr.updateStartWorkingState(salesPo, inTransitPo,logPo);
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
	}
	
	/**
	 * 加工师加工在途信息插入及更新
	 * @return
	 */
	public String updateStartWorkingAllState(){
		/** ********************** 权限设置  ***************************** */
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
		String personcardid = Utility.getName(request.getParameter("personcardid"));
		String allsalesid = Utility.getName(request.getParameter("allsalesid"));
		request.setAttribute("allsalesid", allsalesid);
		String ssesbsalesid = Utility.getName(request.getParameter("ssesbsalesid"));
		request.setAttribute("ssesbsalesid", ssesbsalesid);
		PersonInfoPo po = new PersonInfoPo();
		po.setCardid(personcardid);
		
		PersonInfoPo ppo = new PersonInfoPo();
		ppo = personInfoMgr.getPersonInfo(po);
		
		if("".equals(Utility.getName(ppo.getId()))){
			this.addActionMessage(getText("不存在该员工信息！")); 
			return "error"; 
		}else{
				String[] bills = Utility.getName(allsalesid).split(",");
				
				String errorsalesid = "以下销售单号：\\n";
				String errortype = "";
				for(int i=0; i<bills.length; i++){
					int istake = billKeyMgr.selectProcurementOrderForType("8",bills[i]);
					if(istake == 1){
						errorsalesid = errorsalesid + bills[i]+"\\n";
						errortype = "1";
					}
				}
				if(errortype.equals("1")){
					this.clearMessages();
					this.addActionMessage(errorsalesid+"已被加工，不能进行重复操作！");
					request.setAttribute("flag", GlobalConstants.OPENUPDATE);
					
					return SUCCESS;
				}
				
				for (int i = 0; i < bills.length; i++)
				{
					SalesBasicPo salesPo=new SalesBasicPo();
					InTransitPo inTransitPo=new InTransitPo();
					
					salesPo.setSsesbsalesid(bills[i]);
					inTransitPo.setSseitsalesid(bills[i]);
					inTransitPo.setSseitcreateperson(ppo.getId());
					inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
					LogisticsLogPo logPo = new LogisticsLogPo();
					logPo.setsLogName(createPerson);
					logPo.setsLogIP(request.getRemoteAddr());
					logPo.setsLogResult(moduleID);
					logPo.setsLogOpID("32");
					logPo.setsLogContent(bills[i]);
				  
					recordWorkingTimeMgr.updateStartWorkingState(salesPo, inTransitPo,logPo);
				
				}
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return SUCCESS;
			}	
	}
}
