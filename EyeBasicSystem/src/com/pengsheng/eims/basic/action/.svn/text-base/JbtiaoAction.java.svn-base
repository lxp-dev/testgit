package com.pengsheng.eims.basic.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import com.pengsheng.eims.basic.mgr.JbtiaoMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.JbtiaoPo;
import com.pengsheng.eims.basic.persistence.JbtiaoTypePo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class JbtiaoAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	
	private DepartmentsMgr departmentsMgr;
	
	private List<DepartmentsPo> departments;
	
	private PersonInfoMgr personInfoMgr;	

	private List<PersonInfoPo> persons;
	
	private List<JbtiaoTypePo> jbtiaoTypeList;
	
	private JbtiaoMgr jbtiaoMgr;
	
	private JbtiaoPo jbtiaoPo;
	
	private List<JbtiaoPo> jbtiaoList;
	
	
	
	public List<JbtiaoPo> getJbtiaoList() {
		return jbtiaoList;
	}

	public void setJbtiaoList(List<JbtiaoPo> jbtiaoList) {
		this.jbtiaoList = jbtiaoList;
	}

	public JbtiaoPo getJbtiaoPo() {
		return jbtiaoPo;
	}

	public void setJbtiaoPo(JbtiaoPo jbtiaoPo) {
		this.jbtiaoPo = jbtiaoPo;
	}

	public List<JbtiaoTypePo> getJbtiaoTypeList() {
		return jbtiaoTypeList;
	}

	public void setJbtiaoTypeList(List<JbtiaoTypePo> jbtiaoTypeList) {
		this.jbtiaoTypeList = jbtiaoTypeList;
	}

	public JbtiaoMgr getJbtiaoMgr() {
		return jbtiaoMgr;
	}

	public void setJbtiaoMgr(JbtiaoMgr jbtiaoMgr) {
		this.jbtiaoMgr = jbtiaoMgr;
	}

	public List<PersonInfoPo> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonInfoPo> persons) {
		this.persons = persons;
	}

	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public List<DepartmentsPo> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentsPo> departments) {
		this.departments = departments;
	}

	public String initJBTiaoSel() {

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
		

		// 取所有部门
		departments = departmentsMgr.getDepartments();
		
        jbtiaoTypeList=jbtiaoMgr.getJbtiaoTypeList();

		return SUCCESS;
	}

	public String selJBTiao() {

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
		
		String begindate=request.getParameter("begindate");
		String enddate=request.getParameter("enddate");
		String personid=request.getParameter("personid");
		String personnames=request.getParameter("personnames");
		String jbtype=request.getParameter("jbtype");
		String departmentid=request.getParameter("departmentid");
		
		JbtiaoPo jbtiaoPo=new JbtiaoPo();
		
		jbtiaoPo.setBegindate(begindate);
		jbtiaoPo.setEnddate(enddate);
		jbtiaoPo.setPinfoid(personid);
		jbtiaoPo.setPersonname(personnames);
		jbtiaoPo.setJbtype(jbtype);
		jbtiaoPo.setDepartmentid(departmentid);
		
		departments = departmentsMgr.getDepartments();
		
        jbtiaoTypeList=jbtiaoMgr.getJbtiaoTypeList();
		
		int count = jbtiaoMgr.getJbtiaoCount(jbtiaoPo);

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
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
			Pagination page = new Pagination(request, count, perPage);

			jbtiaoList = jbtiaoMgr.getJbtiaoList(jbtiaoPo,page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}
		
		request.setAttribute("begindate",begindate);
		request.setAttribute("enddate",enddate);
		request.setAttribute("personid",personid);
		request.setAttribute("personnames",personnames);
		request.setAttribute("jbtype",jbtype);
		request.setAttribute("departmentid",departmentid);
		

		return SUCCESS;
	}	

	public String initJBTiaoInsert() {

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
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat currMouthFirstDay = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = currMouthFirstDay.format(calendar.getTime());			
        request.setAttribute("createDate",createDate);
        
        jbtiaoTypeList=jbtiaoMgr.getJbtiaoTypeList();

		return SUCCESS;
	}

	public String insertJBTiao() {

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
		
		if(jbtiaoPo.getSbisdk()==null){
			jbtiaoPo.setSbisdk("0");
		}
		if(jbtiaoPo.getXbisdk()==null){
			jbtiaoPo.setXbisdk("0");
		}
		
		jbtiaoMgr.insertJbtiao(jbtiaoPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		

		return SUCCESS;
	}

	public String initJBTiaoUpdate() {

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
		
		JbtiaoPo po=new JbtiaoPo();
		po.setId(request.getParameter("hid"));
		
		jbtiaoPo=jbtiaoMgr.getJbtiaoPo(po);
		
        jbtiaoTypeList=jbtiaoMgr.getJbtiaoTypeList();

		return SUCCESS;
	}

	public String updateJBTiao() {

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
		
		if(jbtiaoPo.getSbisdk()==null){
			jbtiaoPo.setSbisdk("0");
		}
		if(jbtiaoPo.getXbisdk()==null){
			jbtiaoPo.setXbisdk("0");
		}
		
		jbtiaoMgr.updateJbtiao(jbtiaoPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public String initJBTiaoDelete() {

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
		
		JbtiaoPo po=new JbtiaoPo();
		po.setId(request.getParameter("hid"));
		
		jbtiaoPo=jbtiaoMgr.getJbtiaoPo(po);

		return SUCCESS;
	}

	public String deleteJBTiao() {

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
		
		JbtiaoPo po=new JbtiaoPo();
		po.setId(request.getParameter("hid"));
		
		jbtiaoMgr.deleteJbtiao(po);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}	

	public String initJBTiaoDetail() {

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
		
		JbtiaoPo po=new JbtiaoPo();
		po.setId(request.getParameter("hid"));
		
		jbtiaoPo=jbtiaoMgr.getJbtiaoPo(po);
		
        jbtiaoTypeList=jbtiaoMgr.getJbtiaoTypeList();

		return SUCCESS;
	}
}
