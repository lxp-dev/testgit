package com.pengsheng.eims.casehistory.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.casehistory.mgr.OptometryCaseNMgr;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class OptometryCaseNAction extends BaseAction {
	private PersonPermissionMgr personPermissionMgr;
	
	private OptometryCaseNMgr optometryCaseNMgr;

	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	


	private DepartmentsMgr departmentsMgr;
	
	private List<DepartmentsPo> departmentsList;
	private String isFirstExec;
		


	/**
	 * 扫描卡号得会员信息
	 */
	public String initOptometryCaseSelN() {
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
		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo);	
		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "optomeSel";
		}
		return SUCCESS;
	}
	
	public String optometryCaseSelN() {
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
		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo);
		
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
	
		String sopoymemberid = Utility.getName(request.getParameter("sopoymemberid"));
		String sopoyname = Utility.getName(request.getParameter("sopoyname"));
		String sopoypersonid = Utility.getName(request.getParameter("sopoypersonid"));
		String sopoybegindate = Utility.getName(request.getParameter("sopoybegindate"));
		String sopoyenddate = Utility.getName(request.getParameter("sopoyenddate"));
		String sopoydiffusepupil = Utility.getName(request.getParameter("sopoydiffusepupil"));
		//翻方前的值
		String sopoyballglassodmin = Utility.getName(request.getParameter("sopoyballglassodmin"));
		String sopoyballglassodmax = Utility.getName(request.getParameter("sopoyballglassodmax"));
		
		String sopoypostglassodmin = Utility.getName(request.getParameter("sopoypostglassodmin"));
		String sopoypostglassodmax = Utility.getName(request.getParameter("sopoypostglassodmax"));
		
		String sopoyfarworth = Utility.getName(request.getParameter("sopoyfarworth"));
		
		String sopoybccmin = Utility.getName(request.getParameter("sopoybccmin"));
		String sopoybccmax = Utility.getName(request.getParameter("sopoybccmax"));
		
		String sopoynramin = Utility.getName(request.getParameter("sopoynramin"));
		String sopoynramax = Utility.getName(request.getParameter("sopoynramax"));
		
		String sopoypramin = Utility.getName(request.getParameter("sopoypramin"));
		String sopoypramax = Utility.getName(request.getParameter("sopoypramax"));
		
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String doublecheck = Utility.getName(request.getParameter("doublecheck"));
		String sopoyacamin = Utility.getName(request.getParameter("sopoyacamin"));
		String sopoyacamax = Utility.getName(request.getParameter("sopoyacamax"));
		String sopoyfarhetelevelmin = Utility.getName(request.getParameter("sopoyfarhetelevelmin"));
		String sopoyfarhetelevelmax = Utility.getName(request.getParameter("sopoyfarhetelevelmax"));
		String sopoyfarHeteuprightnessmin = Utility.getName(request.getParameter("sopoyfarHeteuprightnessmin"));
		String sopoyfarHeteuprightnessmax = Utility.getName(request.getParameter("sopoyfarHeteuprightnessmax"));
		String sopoyclosehetelevelmin = Utility.getName(request.getParameter("sopoyclosehetelevelmin"));
		String sopoyclosehetelevelmax = Utility.getName(request.getParameter("sopoyclosehetelevelmax"));
		String sopoycloseheteuprightnessmin = Utility.getName(request.getParameter("sopoycloseheteuprightnessmin"));
		String sopoycloseheteuprightnessmax = Utility.getName(request.getParameter("sopoycloseheteuprightnessmax"));
		
		request.setAttribute("sopoyacamin", sopoyacamin);
		request.setAttribute("sopoyacamax", sopoyacamax);
		request.setAttribute("sopoyfarhetelevelmin", sopoyfarhetelevelmin);
		request.setAttribute("sopoyfarhetelevelmax", sopoyfarhetelevelmax);
		request.setAttribute("sopoyfarHeteuprightnessmin", sopoyfarHeteuprightnessmin);
		request.setAttribute("sopoyfarHeteuprightnessmax", sopoyfarHeteuprightnessmax);
		request.setAttribute("sopoyclosehetelevelmin", sopoyclosehetelevelmin);
		request.setAttribute("sopoyclosehetelevelmax", sopoyclosehetelevelmax);
		request.setAttribute("sopoycloseheteuprightnessmin", sopoycloseheteuprightnessmin);
		request.setAttribute("sopoycloseheteuprightnessmax", sopoycloseheteuprightnessmax);
		
		request.setAttribute("sopoymemberid", sopoymemberid);
		request.setAttribute("sopoyname", sopoyname);
		request.setAttribute("sopoypersonid", sopoypersonid);
		request.setAttribute("sopoybegindate", sopoybegindate);
		request.setAttribute("sopoyenddate", sopoyenddate);
		request.setAttribute("sopoydiffusepupil", sopoydiffusepupil);
		
		request.setAttribute("sopoyballglassodmin", sopoyballglassodmin);
		request.setAttribute("sopoyballglassodmax", sopoyballglassodmax);
		request.setAttribute("sopoypostglassodmin", sopoypostglassodmin);
		request.setAttribute("sopoypostglassodmax", sopoypostglassodmax);
		request.setAttribute("sopoyfarworth", sopoyfarworth);
		request.setAttribute("sopoybccmin", sopoybccmin);
		request.setAttribute("sopoybccmax", sopoybccmax);
		request.setAttribute("sopoynramin", sopoynramin);
		request.setAttribute("sopoynramax", sopoynramax);
		request.setAttribute("sopoypramin", sopoypramin);
		request.setAttribute("sopoypramax", sopoypramax);
		request.setAttribute("departmentID", departmentID);
		request.setAttribute("doublecheck", doublecheck);
		
		OptometryPo po = new OptometryPo();
		po.setSopoymemberid(sopoymemberid);
		po.setSopoyname(sopoyname);
		po.setSopoypersonid(sopoypersonid);
		po.setSopoybegindate(sopoybegindate);
		po.setSopoyenddate(sopoyenddate);
		po.setSopoydiffusepupil(sopoydiffusepupil);
		po.setSopoyballglassodmin(sopoyballglassodmin);
		po.setSopoyballglassodmax(sopoyballglassodmax);
		po.setSopoypostglassodmin(sopoypostglassodmin);
		po.setSopoypostglassodmax(sopoypostglassodmax);
		po.setSopoyfarworth(sopoyfarworth);
		po.setSopoyacamin(sopoyacamin);
		po.setSopoyacamax(sopoyacamax);
		po.setSopoyfarhetelevelmin(sopoyfarhetelevelmin);
		po.setSopoyfarhetelevelmax(sopoyfarhetelevelmax);
		po.setSopoyfarHeteuprightnessmin(sopoyfarHeteuprightnessmin);
		po.setSopoyfarHeteuprightnessmax(sopoyfarHeteuprightnessmax);
		po.setSopoyclosehetelevelmin(sopoyclosehetelevelmin);
		po.setSopoyclosehetelevelmax(sopoyclosehetelevelmax);
		po.setSopoycloseheteuprightnessmin(sopoycloseheteuprightnessmin);
		po.setSopoycloseheteuprightnessmax(sopoycloseheteuprightnessmax);
		po.setSopoybccmin(sopoybccmin);
		po.setSopoybccmax(sopoybccmax);
		po.setSopoynramin(sopoynramin);
		po.setSopoynramax(sopoynramax);
		po.setSopoypramin(sopoypramin);
		po.setSopoypramax(sopoypramax);
		po.setSopoyshopcode(departmentID);
		po.setSopoydoublecheck(doublecheck);
		po.setSmecishoplist(departmentsList);
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
		int count = optometryCaseNMgr.getOptometryCaseCount(po);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request
						.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			optometryPos = optometryCaseNMgr.getOptometryCases(po, page.getStart(),page.getPageSize());
		
			request.setAttribute(Pagination.PAGINATION, page);
		} 
		
		return SUCCESS;
	}
	public OptometryCaseNMgr getOptometryCaseNMgr() {
		return optometryCaseNMgr;
	}

	public void setOptometryCaseNMgr(OptometryCaseNMgr optometryCaseNMgr) {
		this.optometryCaseNMgr = optometryCaseNMgr;
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

	private ProcurementOrdersDao procurementOrdersDao;
	
	public ProcurementOrdersDao getProcurementOrdersDao() {
		return procurementOrdersDao;
	}

	public void setProcurementOrdersDao(ProcurementOrdersDao procurementOrdersDao) {
		this.procurementOrdersDao = procurementOrdersDao;
	}

	private List<OptometryPo> optometryPos;

	public List<OptometryPo> getOptometryPos() {
		return optometryPos;
	}

	public void setOptometryPos(List<OptometryPo> optometryPos) {
		this.optometryPos = optometryPos;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
}
