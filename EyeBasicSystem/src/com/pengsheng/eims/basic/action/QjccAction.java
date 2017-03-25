package com.pengsheng.eims.basic.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.QjccMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.JbtiaoPo;
import com.pengsheng.eims.basic.persistence.NonconformingProductPo;
import com.pengsheng.eims.basic.persistence.QjccPo;
import com.pengsheng.eims.basic.persistence.QjccTypePo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class QjccAction extends BaseAction{
	
	private PersonPermissionMgr personPermissionMgr;
	
	private DepartmentsMgr departmentsMgr;
	
	private List<DepartmentsPo> departments;
	
	private List<QjccTypePo> qjccTypePos;
	
	private List<QjccPo> qjccList;
	
	private QjccMgr qjccMgr;
	
	private QjccPo qjccPo;
	
	
	
	public List<QjccPo> getQjccList() {
		return qjccList;
	}

	public void setQjccList(List<QjccPo> qjccList) {
		this.qjccList = qjccList;
	}

	public QjccPo getQjccPo() {
		return qjccPo;
	}

	public void setQjccPo(QjccPo qjccPo) {
		this.qjccPo = qjccPo;
	}

	public List<QjccTypePo> getQjccTypePos() {
		return qjccTypePos;
	}

	public void setQjccTypePos(List<QjccTypePo> qjccTypePos) {
		this.qjccTypePos = qjccTypePos;
	}

	public QjccMgr getQjccMgr() {
		return qjccMgr;
	}

	public void setQjccMgr(QjccMgr qjccMgr) {
		this.qjccMgr = qjccMgr;
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

	public String initQjccSel() {

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
		
		qjccTypePos=qjccMgr.getQjccTypeList();

		return SUCCESS;
	}

	public String selQjcc() {

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
		
		String begindate=Utility.getName(request.getParameter("begindate"));
		String enddate=Utility.getName(request.getParameter("enddate"));
		String personid=Utility.getName(request.getParameter("personid"));
		String personnames=Utility.getName(request.getParameter("personnames"));
		String typemain=Utility.getName(request.getParameter("typemain"));
		String typezi=Utility.getName(request.getParameter("typezi"));
		String departmentid=Utility.getName(request.getParameter("departmentid"));
		
		QjccPo po=new QjccPo();
		
		po.setBegindate(begindate);
		po.setEnddate(enddate);
		po.setPersonid(personid);
		po.setPersonname(personnames);
		po.setTypemain(typemain);
		po.setTypezi(typezi);
		po.setDepartmentid(departmentid);
		
		departments = departmentsMgr.getDepartments();
		
		qjccTypePos=qjccMgr.getQjccTypeList();
		
		int count = qjccMgr.getQjccCount(po);

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

			qjccList = qjccMgr.getQjccList(po,page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		}
		
		QjccTypePo tmp = new QjccTypePo();
		tmp.setBqjparentid(typemain);
		List<QjccTypePo> qjccTypeMinList= qjccMgr.getQjccTypeMinList(tmp);
		
		request.setAttribute("begindate",begindate);
		request.setAttribute("enddate",enddate);
		request.setAttribute("personid",personid);
		request.setAttribute("personnames",personnames);
		request.setAttribute("typemain",typemain);
		request.setAttribute("typezi",typezi);
		request.setAttribute("departmentid",departmentid);
		request.setAttribute("qjccTypeMinList",qjccTypeMinList);
		

		return SUCCESS;
	}	
	public String initQjccInsert() {

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
        
		qjccTypePos=qjccMgr.getQjccTypeList();

		return SUCCESS;
	}

	public String insertQjcc() {

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
		
		qjccPo.setCaozuoyuan(createPerson);
		qjccMgr.insertQjcc(qjccPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		

		return SUCCESS;
	}
	public String initQjccUpdate() {

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
		
		QjccPo po=new QjccPo();
		po.setId(request.getParameter("hid"));
		
		qjccPo=qjccMgr.getQjccPo(po);
		
		qjccTypePos=qjccMgr.getQjccTypeList();

		return SUCCESS;
	}

	public String updateQjcc() {

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
		qjccPo.setCaozuoyuan(createPerson);
		qjccMgr.updateQjcc(qjccPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	public String initQjccDelete() {

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
		
		QjccPo po=new QjccPo();
		po.setId(request.getParameter("hid"));
		
		qjccPo=qjccMgr.getQjccPo(po);
		
		qjccTypePos=qjccMgr.getQjccTypeList();

		return SUCCESS;
	}

	public String deleteQjcc() {

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
		
		QjccPo po=new QjccPo();
		po.setId(request.getParameter("hid"));
		
		qjccMgr.deleteQjcc(po);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	public String initQjccDetail() {

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
		
		QjccPo po=new QjccPo();
		po.setId(request.getParameter("hid"));
		
		qjccPo=qjccMgr.getQjccPo(po);
		
		qjccTypePos=qjccMgr.getQjccTypeList();

		return SUCCESS;
	}
	/**
	 * 取得Ajax数据
	 */
	public void getAjaxQjccDate() throws Exception {

		String fnpid = Utility.getName(request.getParameter("fnpid"));
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();

		if (fnpid.equals("")) {
			out.println("<option value=''>请选取请假出差原因(0)</option>");
		} else {
			QjccTypePo tmp = new QjccTypePo();
			tmp.setBqjparentid(fnpid);
			List<QjccTypePo> qjccTypeMinList= qjccMgr.getQjccTypeMinList(tmp);
			Iterator it = qjccTypeMinList.iterator();
			out.println("<option value=''>请选取请假出差原因("
					+ qjccTypeMinList.size() + ")</option>");
			if (it.hasNext()) {
				while (it.hasNext()) {
					QjccTypePo tmpPo = (QjccTypePo) it.next();
					out.println("<option value='" + tmpPo.getBqjid() + "' >"
							+ tmpPo.getBqjname() + "</option>");
				}
			}
		}
		out.close();
	}
}
