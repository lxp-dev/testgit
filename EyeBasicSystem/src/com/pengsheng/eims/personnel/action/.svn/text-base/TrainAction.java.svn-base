package com.pengsheng.eims.personnel.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.mgr.MPersonInfoMgr;
import com.pengsheng.eims.personnel.mgr.TrainMgr;

import com.pengsheng.eims.personnel.persistence.PersonInfoPo;
import com.pengsheng.eims.personnel.persistence.TrainPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class TrainAction extends BaseAction
{
	private TrainMgr trainMgr;
	private MPersonInfoMgr mpersonInfoMgr;	
	private PersonPermissionMgr personPermissionMgr;
	private List<TrainPo> trainPos;
	private TrainPo trainPo;
	private List<PersonInfoPo> persons;
	private List<RolePo> roles;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private PersonInfoMgr personInfoMgr;
	private PersonInfoPo rppersonInfo;
	private List<DepartmentsPo> departments;
	private DepartmentsMgr departmentsMgr;
	private List<PersonDepartmentsPo> personDepartments;
	
	public String initSelTrain() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selTrain";
		}
				
		return SUCCESS;
	}
	
	public String selTrain()
	{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo1 = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		TrainPo po = new TrainPo();
		
		po.setTrainid(Utility.getName(request.getParameter("trainid")));
		po.setTraintittle(Utility.getName(request.getParameter("traintittle")));
		po.setCreatpersonid(Utility.getName(request.getParameter("creatpersonid")));
		po.setCreatpersonname(Utility.getName(request.getParameter("creatpersonname")));
		po.setBgncreatdate(Utility.getName(request.getParameter("bgncreatdate")));
		po.setEndcreatdate(Utility.getName(request.getParameter("endcreatdate")));
		po.setRemark(Utility.getName(request.getParameter("remark")));
		
		request.setAttribute("trainid", request.getParameter("trainid"));
		request.setAttribute("traintittle", request.getParameter("traintittle"));
		request.setAttribute("creatpersonid", request.getParameter("creatpersonid"));
		request.setAttribute("creatpersonname", request.getParameter("creatpersonname"));
		request.setAttribute("bgncreatdate", request.getParameter("bgncreatdate"));
		request.setAttribute("endcreatdate", request.getParameter("endcreatdate"));
		request.setAttribute("remark", request.getParameter("remark"));
	
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

		int count = trainMgr.getTrainCount(po);

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

			trainPos = trainMgr.getTrains(po, page.getStart(), page.getPageSize());			
			
			request.setAttribute(Pagination.PAGINATION, page);
		}		
		return SUCCESS;
	}
	
	public String initInsertTrain() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		return SUCCESS;
	}
	
	public String insertTrain() throws Exception 
	{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String billid = "PX" + numHeadFormat.format(new Date());
		
		trainPo.setMttrainid(billid);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("培训信息：" + billid + " 新增!" );
		
		trainPo.setMtcreatpersonid(personInfoPo.getId());
		
		trainMgr.insertTrainPo(trainPo, logPo);
		
		this.clearMessages();
		
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;				
	}
	
	
	public String initUpdateTrainPo() throws Exception 
	{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String hid = request.getParameter(Utility.getName("hid"));
		
		TrainPo po = new TrainPo();
		po.setTrainid(hid);
		
		trainPo = trainMgr.getTrainPo(po);
		
		trainPos = trainMgr.getTrainResults(po);
		
		return SUCCESS;
	}
	
	public String updateTrainPo() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("员工奖惩：" + Utility.getName(trainPo.getTrainid()) + "修改!" );
		
		this.clearMessages();
		
		trainMgr.updateTrainPo(trainPo, logPo);		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;				
	}
	
	public String initSelTrainPo() throws Exception 
	{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String hid = request.getParameter(Utility.getName("hid"));
		
		TrainPo po = new TrainPo();
		po.setTrainid(hid);
		
		trainPo = trainMgr.getTrainPo(po);
		
		trainPos = trainMgr.getTrainResults(po);
		
		return SUCCESS;	
	}
	
	public String initDeleteTrainPo() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String hid = request.getParameter(Utility.getName("hid"));
		
		TrainPo po = new TrainPo();
		po.setTrainid(hid);
		
		trainPo = trainMgr.getTrainPo(po);
		
		return SUCCESS;
	}
	
	public String deleteTrainPo() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("员工奖惩：" + Utility.getName(trainPo.getTrainid()) + "删除!");
		
		this.clearMessages();
		
		trainMgr.deleteTrainPo(trainPo, logPo);	
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	public String initSelTrainPersonInfo() {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		
		// 取得所有角色
		roles = mpersonInfoMgr.getRoles();

		// 取所有部门
		departments = departmentsMgr.getDepartments();

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
//		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
//		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
//			this.setIsFirstExec("1");
//			return "selPersonInfo";
//		}
		
		return SUCCESS;
	}

	/**
	 * 
	 * 
	 */
	public String selTrainPersonInfo() {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		com.pengsheng.eims.system.persistence.PersonInfoPo personInfoPo = (com.pengsheng.eims.system.persistence.PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		PersonInfoPo personInfo = new PersonInfoPo();
		personInfo.setId(request.getParameter("selId"));
		personInfo.setPersonName(request.getParameter("selPersonName"));
		personInfo.setDepartmentID(request.getParameter("selDepartmentID"));
		personInfo.setRoleid(request.getParameter("selRoleid"));
		personInfo.setIsinvocation(request.getParameter("isinvocation"));

		// 取得所有角色
		roles = mpersonInfoMgr.getRoles();

		// 取所有部门
		departments = departmentsMgr.getDepartments();

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
		
		int count = mpersonInfoMgr.getPersoninfosCount(personInfo);
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

			persons = mpersonInfoMgr.getPersonInfos(personInfo, page.getStart(), page.getPageSize());

			for (PersonInfoPo po : persons) {
				personDepartments = mpersonInfoMgr.getPersonDepartments(po);
			}
			
			request.setAttribute(Pagination.PAGINATION, page);
		}

		setRequest();
		
		return SUCCESS;
	}
	
	private void setRequest() {
		request.setAttribute("selId", request.getParameter("selId"));
		request.setAttribute("selPersonName", request
				.getParameter("selPersonName"));
		request.setAttribute("selDepartmentID", request
				.getParameter("selDepartmentID"));
		request.setAttribute("selDepartmentName", Utility.getName(request.getParameter("selDepartmentName")));
		request.setAttribute("selRoleid", request.getParameter("selRoleid"));
		request.setAttribute("isinvocation", request.getParameter("isinvocation"));
	}

	public TrainMgr getTrainMgr() {
		return trainMgr;
	}

	public void setTrainMgr(
			TrainMgr trainMgr) {
		this.trainMgr = trainMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<TrainPo> getTrainPos() {
		return trainPos;
	}

	public void setTrainPos(
			List<TrainPo> trainPos) {
		this.trainPos = trainPos;
	}

	public TrainPo getTrainPo() {
		return trainPo;
	}

	public void setTrainPo(TrainPo trainPo) {
		this.trainPo = trainPo;
	}

	public List<PersonInfoPo> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonInfoPo> persons) {
		this.persons = persons;
	}

	public List<RolePo> getRoles() {
		return roles;
	}

	public void setRoles(List<RolePo> roles) {
		this.roles = roles;
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

	public PersonInfoPo getRppersonInfo() {
		return rppersonInfo;
	}

	public void setRppersonInfo(PersonInfoPo rppersonInfo) {
		this.rppersonInfo = rppersonInfo;
	}

	public List<DepartmentsPo> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentsPo> departments) {
		this.departments = departments;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public List<PersonDepartmentsPo> getPersonDepartments() {
		return personDepartments;
	}

	public void setPersonDepartments(List<PersonDepartmentsPo> personDepartments) {
		this.personDepartments = personDepartments;
	}
	public MPersonInfoMgr getMpersonInfoMgr() {
		return mpersonInfoMgr;
	}

	public void setMpersonInfoMgr(MPersonInfoMgr mpersonInfoMgr) {
		this.mpersonInfoMgr = mpersonInfoMgr;
	}	
}
