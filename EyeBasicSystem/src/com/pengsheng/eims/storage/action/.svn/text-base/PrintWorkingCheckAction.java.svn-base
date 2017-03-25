package com.pengsheng.eims.storage.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.mgr.PrintWorkingCheckMgr;
import com.pengsheng.eims.storage.mgr.WorkingCheckMgr;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class PrintWorkingCheckAction extends BaseAction {
	
	private PrintWorkingCheckMgr printWorkingCheckMgr;
	
	private List<WorkingCheckPo> printWorkingCheckList;
	
	private WorkingCheckMgr workingCheckMgr;
	
	private List<PersonInfoPo> workingCheckpersonList;
	
	private List<DepartmentsPo> departmentsList;
	
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
	/**
	 * 初始化检验单打印
	 * @return
	 */
	public String initPrintWorkingCheckSel(){
		
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
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selectPrintWorkingCheck";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 检验单打印查询  
	 * @return
	 */
	public String selectPrintWorkingCheck(){
		
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
		String remark=Utility.getName(request.getParameter("remark"));
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
		CheckPo.setPchckprocesspersonid(pchckprocesspersonid);
		CheckPo.setPchckchecklabourid(pchckchecklabourid);
		CheckPo.setPchckstartcheckdate(checkStart);
		CheckPo.setPchckendcheckdate(checkEnd);
		CheckPo.setPchckremark(remark);
		request.setAttribute("shopsalesid", salesId);
		
		request.setAttribute("ssesbsalesdatestarttime", salesStart);
		request.setAttribute("ssesbsalesdateendtime", salesEnd);
		
		request.setAttribute("shoppersonName", customerName);
		request.setAttribute("pchckprocesspersonid", pchckprocesspersonid);
		request.setAttribute("pchckchecklabourid", pchckchecklabourid);
		request.setAttribute("shopcode", shopcode);
		
		request.setAttribute("ssesbtakeglassstartdata", takeStart);
		request.setAttribute("ssesbtakeglassenddata", takeEnd);
		request.setAttribute("remark", remark);
		request.setAttribute("pchckstartcheckdate", checkStart);
		request.setAttribute("pchckendcheckdate", checkEnd);
		
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
		int count=printWorkingCheckMgr.getPrintWorkingCheckCount(salesPo, CheckPo);
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
			printWorkingCheckList=printWorkingCheckMgr.selectPrintWorkingCheck(salesPo , CheckPo , page.getStart() , page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			printWorkingCheckList = null;
		}
		return SUCCESS;
	}

}
