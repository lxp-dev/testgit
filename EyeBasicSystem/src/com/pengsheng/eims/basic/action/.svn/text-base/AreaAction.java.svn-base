package com.pengsheng.eims.basic.action;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.AreaMgr;
import com.pengsheng.eims.basic.persistence.AreaPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class AreaAction extends BaseAction {

	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	private AreaPo areaPo;
	private AreaMgr areaMgr;
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;

	/**
	 * 取得Ajax数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public void getAjaxArea() throws Exception {
		
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
		
		String level = Utility.getName(request.getParameter("level"));
		String pid = Utility.getName(request.getParameter("pid"));
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();

		List<AreaPo> areaList =  areaMgr.getAjaxAreaData(level, pid);
		Iterator it = areaList.iterator();
		out.println("<option value=''>请选择("
				+ areaList.size() + ")</option>");
		if (it.hasNext()) {
			while (it.hasNext()) {
				AreaPo tmpPo = (AreaPo) it
						.next();
				out.println("<option value='" + tmpPo.getFaid() + "'>"
						+ tmpPo.getFaname() + "</option>");
			}
		}
		
		out.close();		
	}

	public AreaPo getAreaPo() {
		return areaPo;
	}

	public void setAreaPo(AreaPo areaPo) {
		this.areaPo = areaPo;
	}

	public AreaMgr getAreaMgr() {
		return areaMgr;
	}

	public void setAreaMgr(AreaMgr areaMgr) {
		this.areaMgr = areaMgr;
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
}
