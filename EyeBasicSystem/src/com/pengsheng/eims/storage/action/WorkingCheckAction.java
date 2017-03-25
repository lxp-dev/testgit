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
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.storage.mgr.InTransitMgr;
import com.pengsheng.eims.storage.mgr.WorkingCheckMgr;
import com.pengsheng.eims.storage.persistence.MistakePo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class WorkingCheckAction extends BaseAction {

	private List<WarehousePo> warehouseList;
	private ProcessDistributionMgr processDistributionMgr;
    private WindowsMgr windowsMgr;
    private SystemParameterMgr systemParameterMgr;
    private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private InTransitPo inTransitPo;
	private InTransitMgr inTransitMgr;
	private BillKeyMgr billKeyMgr; 
	
	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}
    
	public InTransitPo getInTransitPo() {
		return inTransitPo;
	}
	public void setInTransitPo(InTransitPo inTransitPo) {
		this.inTransitPo = inTransitPo;
	}
	public InTransitMgr getInTransitMgr() {
		return inTransitMgr;
	}
	public void setInTransitMgr(InTransitMgr inTransitMgr) {
		this.inTransitMgr = inTransitMgr;
	}
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

	private PersonPermissionMgr personPermissionMgr;
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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

	/**
	 * 初始化加工检验查询页面
	 * @return
	 */
	public String initWorkingCheckSel(){
		
		
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
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(((PersonInfoPo)session.get("person")).getDepartmentID());
		warehouseList=processDistributionMgr.getWarehouseList(deppo);
		/** ********************** 权限设置 ***************************** */
		
		int count = windowsMgr.isEnabledInTransit("9");
		request.setAttribute("InTransitCount", count);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectWorkingCheck";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询加工检验信息
	 * @return
	 */
	public String selectWorkingCheck(){
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
		DepartmentsPo deppo=new DepartmentsPo();
		deppo.setBdpdepartmentid(((PersonInfoPo)session.get("person")).getDepartmentID());
		warehouseList=processDistributionMgr.getWarehouseList(deppo);
		String departmentid=personInfoPo.getDepartmentID();
		
		String salesId=Utility.getName(request.getParameter("shopsalesid"));
		
		String salesStart=Utility.getName(request.getParameter("ssesbsalesdatestarttime"));
		String salesEnd=Utility.getName(request.getParameter("ssesbsalesdateendtime"));
		
		//添加取镜日期判断begin end 和  制造商ID
		String ssesbtakeglassstartdata=Utility.getName(request.getParameter("ssesbtakeglassstartdata"));
		String ssesbtakeglassenddata=Utility.getName(request.getParameter("ssesbtakeglassenddata"));
		String customerName=Utility.getName(request.getParameter("shoppersonName"));
		String ssesbsupplierid=Utility.getName(request.getParameter("ssesbsupplierid"));
		String worrytype=Utility.getName(request.getParameter("worrytype"));
		String djsbm=Utility.getName(request.getParameter("djsbm"));
		
		SalesBasicPo salesPo=new SalesBasicPo();
		
		// 添加取镜日期判断begin end 和  制造商ID
		salesPo.setSsesbtakeglassstartdata(ssesbtakeglassstartdata);
		salesPo.setSsesbtakeglassenddata(ssesbtakeglassenddata);
		salesPo.setSsesbshopcode(ssesbsupplierid);
		
		salesPo.setSsesbsalesid(salesId);
		salesPo.setSsesbsalesdatestarttime(salesStart);
		salesPo.setSsesbsalesdateendtime(salesEnd);
		salesPo.setSsesbpersonName(customerName);
		salesPo.setSsesbdepartmentid(departmentid);
		salesPo.setSsesbworrytype(worrytype);
		salesPo.setDjsbm(djsbm);
		
		request.setAttribute("worrytype", worrytype);
		request.setAttribute("shopsalesid", salesId);
		request.setAttribute("ssesbsalesdatestarttime", salesStart);
		request.setAttribute("ssesbsalesdateendtime", salesEnd);
		request.setAttribute("shoppersonName", customerName);
		request.setAttribute("ssesbtakeglassstartdata", ssesbtakeglassstartdata);
		request.setAttribute("ssesbtakeglassenddata", ssesbtakeglassenddata);
		request.setAttribute("ssesbsupplierid", ssesbsupplierid);
		request.setAttribute("shopsalesid", salesId);
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
		int count=workingCheckMgr.getWorkingCheckCount(salesPo);
		//System.out.println("++++总条数++++"+count);
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
			workingCheckList=workingCheckMgr.selectWorkingCheck(salesPo , page.getStart() , page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			workingCheckList = null;
		}
		
		request.setAttribute("InTransitCount", windowsMgr.isEnabledInTransit("9"));
		
		return SUCCESS;
	}
	
	/**
	 * 初始化检验页面
	 * @return
	 */
	public String initWorkingCheckIns(){	
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
		
		String salesId=Utility.getName(request.getParameter("ssesbsalesid"));
		
		request.setAttribute("ssesbsalesid", salesId);
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbsalesid(salesId);
		salesPo.setSsesborderstype(Utility.getName(systemParameterPo.getFspvd()));//Ssesborderstype原为销售单类型，此处用为系统设置中的光心垂差检验类型
		
		SalesBasicPo oDBasicPo=new SalesBasicPo();
		oDBasicPo.setSsesbsalesid(salesId);
		
		SalesBasicPo oSBasicPo=new SalesBasicPo();
		oSBasicPo.setSsesbsalesid(salesId);
		
		//特殊加工要求List
		SpecialPDetailPo specialPDetailPo=new SpecialPDetailPo();
		specialPDetailPo.setSsesdsalesid(salesId);
		
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
		
		Float distanceod = Float.parseFloat(odMisPo.getFmtodtjmistake());
		Float distanceos = Float.parseFloat(osMisPo.getFmtostjmistake());
		
		if(distanceod > distanceos){
			odMisPo.setFmtodtjmistake(osMisPo.getFmtostjmistake());
		}else if(distanceod < distanceos){
			osMisPo.setFmtostjmistake(odMisPo.getFmtodtjmistake());
		}
		
	    inTransitPo = new InTransitPo();
	    inTransitPo.setSseitsalesid(salesId);
	    inTransitPo.setSseitstate("8");
	    
	    inTransitPo = inTransitMgr.getInTransitPo(inTransitPo);
	    
		return SUCCESS;
	}
	
	/**
	 * 取上次检验数据
	 * @return
	 */
	public void getLastWorkingCheck(){	
		String cid = request.getParameter("cid").trim();
		SalesBasicPo basicPo = new SalesBasicPo();
		basicPo.setSsesbcustomerid(cid);
		workingCheckPo = workingCheckMgr.getLastWorkingCheckPo(basicPo);
	}
	
	/**
	 * 新增检验数据
	 * @return
	 */
	public String insertWorkingCheck(){
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String departmentId = personInfoPo.getDepartmentID();
		String createPerson = personInfoPo.getId();
		request.setAttribute("moduleID", moduleID);
		String salesId=Utility.getName(request.getParameter("salesid"));
		String remark=Utility.getName(request.getParameter("remark"));
		
		InTransitPo inTransitPo=new InTransitPo();
		inTransitPo.setSseitsalesid(salesId);
		inTransitPo.setSseitdepartment(departmentId);
		inTransitPo.setSseitcreateperson(createPerson);
		
		SalesBasicPo salesPo=new SalesBasicPo();
		salesPo.setSsesbsalesid(salesId);
		
		InTransitPo ipo = new InTransitPo();
		ipo.setSseitsalesid(salesId);
		ipo.setSseitstate("8");	    
		ipo = inTransitMgr.getInTransitPo(ipo);
	    
		workingCheckPo.setPchckchecklabourid(createPerson);
		workingCheckPo.setPchcksalesid(salesId);
		workingCheckPo.setPchckremark(remark);
		workingCheckPo.setPchckprocessdepartmentid(Utility.getName(ipo.getSseitdepartment()));
		
		int istake = billKeyMgr.selectProcurementOrderForType("9",salesId);
		if(istake == 1){
			this.clearMessages();
			this.addActionMessage("该配镜单已检验，不能进行重复操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("34");    // 检验完成
		logPo.setsLogContent(salesId);
		int keytype = billKeyMgr.selectBill(salesId);
		if(keytype == 0){
			billKeyMgr.insertBill(salesId);
		}else{
			this.clearMessages();
			this.addActionMessage("当前操作失败，该单据正在操作中！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				
			return SUCCESS;
		}
		workingCheckMgr.insertWorkingCheck(inTransitPo, salesPo, workingCheckPo,logPo);
		billKeyMgr.deleteBill(salesId);
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
	 * 检验单详细
	 * @return
	 */
	public String selectWorkingCheckDetails(){	
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		PersonInfoPo workingCheck=new PersonInfoPo();
		workingCheck.setDepartmentID(personInfoPo.getDepartmentID());
		
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
		
		specialPDetailList = customerReturnVisitMgr.getSpecialPDetail(specialPDetailPo);
		
		salesBasicPo = workingCheckMgr.getCustomerInfo(salesPo);
		SalesBasicPo basicPo = new SalesBasicPo();
		basicPo.setSsesbcustomerid(salesBasicPo.getSsesbcustomerid());

		oDPo = workingCheckMgr.getODDetailInfo(oDBasicPo);
		oSPo = workingCheckMgr.getOSDetailInfo(oSBasicPo);
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
		
		workingCheckPo = workingCheckMgr.getWorkingCheckPo(hid);
		
		return SUCCESS;
	}
	
	/**
	 * 
	 * 初始化报表帮助
	 */
	public String initWorkingCheckHelp() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		
		return SUCCESS;
	}
}
