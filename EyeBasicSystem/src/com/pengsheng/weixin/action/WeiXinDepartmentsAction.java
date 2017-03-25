package com.pengsheng.weixin.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.weixin.mgr.WeiXinDepartmentsMgr;
import com.pengsheng.weixin.persistence.WeiXinDepartmentPicPo;

public class WeiXinDepartmentsAction extends BaseAction {

	private WeiXinDepartmentsMgr weiXinDepartmentsMgr;
	private DepartmentsPo departmentsPo;
	private List<WeiXinDepartmentPicPo> weiXinDepartmentPicList = null;
	private PersonPermissionMgr personPermissionMgr;
	private List<DepartmentsPo> departmentList = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;

	/**
	 * 初始化部门查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initWeiDepartmentSel() throws Exception {

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

		departmentList = null;

		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")) {
			this.setIsFirstExec("1");
			return "WeidepartmentSel";
		}

		return SUCCESS;
	}

	/**
	 * 部门查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String WeidepartmentSel() throws Exception {

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

		String departmentID = Utility.getName(request
				.getParameter("departmentID"));
		String departmentName = Utility.getName(request
				.getParameter("departmentName"));
		String issee = Utility.getName(request.getParameter("issee"));
		String isoptometryappointment = Utility.getName(request.getParameter("isoptometryappointment"));		
		
		request.setAttribute("departmentID", departmentID);
		request.setAttribute("departmentName", departmentName);
		request.setAttribute("issee", issee);
		request.setAttribute("isoptometryappointment", isoptometryappointment);
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(departmentID);
		departmentsPo.setBdpdepartmentname(departmentName);
		departmentsPo.setBdpissee(issee);
		departmentsPo.setBdpisoptometryappointment(isoptometryappointment);
		departmentsPo.setBdptype("2");

		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")) {
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(
					systemParameterPo.getFspshowchange()).equals("3") ? "0"
					: "2"));
		} else {
			String showchange = Utility.getName(systemParameterPo
					.getFspselectovershowchange());
			if (showchange.equals("0")) {
				request.setAttribute("showhider", "0");
			} else {
				request.setAttribute("showhider", "2");
			}
		}

		int count = weiXinDepartmentsMgr.getDepartmentCount(departmentsPo);
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
			departmentList = weiXinDepartmentsMgr.getDepartmentList(
					departmentsPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			departmentList = null;
		}

		return SUCCESS;
	}

	/**
	 * 初始化部门更新
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initWeiDepartmentsUpdate() throws Exception {

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

		departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(Utility.getName(request
				.getParameter("hid")));

		// 调用得到部门的方法并将其填入新声明的Po对象中
		departmentsPo = weiXinDepartmentsMgr.getDepartment(departmentsPo);
		systemParameterPo = systemParameterMgr.getSystemParameterPo();

		return SUCCESS;
	}

	/**
	 * 部门更新
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateWeiDepartment() throws Exception {
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
		// 添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("部门："
				+ Utility.getName(departmentsPo.getBdpdepartmentid()) + "修改!");

		if (!Utility.getName(departmentsPo.getBdppicurl()).equals("")) {
			departmentsPo.setBdppicurl(departmentsPo.getBdppicurl().replaceAll(
					",", ""));
		}
		weiXinDepartmentsMgr.updateDepartment(departmentsPo, logPo);

		String url = "''initWeiDepartmentsUpdate.action?hid={0}&moduleID={1}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));
		params.add(Utility.getName(moduleID));

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request
				.setAttribute("url", MessageFormat
						.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);

		return SUCCESS;
	}

	/**
	 * 初始化微信是否可见
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initSeeDepartment() throws Exception {
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

		departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(Utility.getName(request
				.getParameter("hid")));
		departmentsPo.setBdpdepartmentname(Utility.getName(request
				.getParameter("name")));
		departmentsPo
				.setBdpissee(Utility.getName(request.getParameter("flag")));

		return SUCCESS;
	}

	/**
	 * 更新部门是否在微信可见
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateSeeDepartment() throws Exception {
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

		// 添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称

		// 38:启用 39:停用
		if (departmentsPo.getBdpissee().equals("0")) { // 正在使用
			logPo.setsLogOpID("41"); // 表示状态
			logPo.setsLogContent("部门:" + departmentsPo.getBdpdepartmentid()
					+ "微信不可见!");
			departmentsPo.setBdpissee("1");// 停用
		} else {
			logPo.setsLogOpID("40"); // 表示状态
			logPo.setsLogContent("部门:" + departmentsPo.getBdpdepartmentid()
					+ "微信可见!");
			departmentsPo.setBdpissee("0");// 启用
		}

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		weiXinDepartmentsMgr.updateSeeDepartment(departmentsPo);
		return SUCCESS;
	}

	/**
	 * 初始化微信是否可预约
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initOptometryAppointmentDepartment() throws Exception {
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

		departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(Utility.getName(request
				.getParameter("hid")));
		departmentsPo.setBdpdepartmentname(Utility.getName(request
				.getParameter("name")));
		departmentsPo
				.setBdpisoptometryappointment(Utility.getName(request.getParameter("flag")));

		return SUCCESS;
	}

	/**
	 * 更新部门是否在微信可预约
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateOptometryAppointmentDepartment() throws Exception {
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

		// 添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称

		// 38:启用 39:停用
		if (departmentsPo.getBdpisoptometryappointment().equals("0")) { // 正在使用
			logPo.setsLogOpID("41"); // 表示状态
			logPo.setsLogContent("部门:" + departmentsPo.getBdpdepartmentid()
					+ "微信不可预约!");
			departmentsPo.setBdpisoptometryappointment("1");// 停用
		} else {
			logPo.setsLogOpID("40"); // 表示状态
			logPo.setsLogContent("部门:" + departmentsPo.getBdpdepartmentid()
					+ "微信可预约!");
			departmentsPo.setBdpisoptometryappointment("0");// 启用
		}

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		weiXinDepartmentsMgr.updateOptometryAppointmentDepartment(departmentsPo);
		return SUCCESS;
	}
	
	/**
	 * 初始化门店实景图更新
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initWeiDepartmentPicUpdate() throws Exception {

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
		String departmentID = Utility.getName(request.getParameter("hid"));

		departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(departmentID);
		departmentsPo = weiXinDepartmentsMgr.getDepartment(departmentsPo);

		weiXinDepartmentPicList = weiXinDepartmentsMgr
				.getDepartmentPicList(departmentID);

		String picurls = "";
		// 将实景图List转换为字符串，存入departmentsPo中的bdppicurls(图片实景图URLs),每个图片路径后加逗号（，）
		if (weiXinDepartmentPicList != null
				&& weiXinDepartmentPicList.size() > 0) {

			Iterator it = weiXinDepartmentPicList.iterator();
			while (it.hasNext()) {
				WeiXinDepartmentPicPo weiXinDepartmentPicPotmp = (WeiXinDepartmentPicPo) it
						.next();
				if (weiXinDepartmentPicPotmp.getPicUrl() != null
						&& !Utility.getName(
								weiXinDepartmentPicPotmp.getPicUrl())
								.equals("")) {
					picurls = picurls + weiXinDepartmentPicPotmp.getPicUrl()
							+ ",";
				}
			}
			departmentsPo.setBdppicurls(picurls);
		}

		return SUCCESS;
	}

	/**
	 * 上传门店实景图
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateWeiDepartmentPic() throws Exception {
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
		// 添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("部门："
				+ departmentsPo.getBdpdepartmentid() + "上传门店实景图!");

		
		weiXinDepartmentsMgr.updateDepartmentPic(departmentsPo, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
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

	public List<DepartmentsPo> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<DepartmentsPo> departmentList) {
		this.departmentList = departmentList;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public WeiXinDepartmentsMgr getWeiXinDepartmentsMgr() {
		return weiXinDepartmentsMgr;
	}

	public void setWeiXinDepartmentsMgr(
			WeiXinDepartmentsMgr weiXinDepartmentsMgr) {
		this.weiXinDepartmentsMgr = weiXinDepartmentsMgr;
	}

	public DepartmentsPo getDepartmentsPo() {
		return departmentsPo;
	}

	public void setDepartmentsPo(DepartmentsPo departmentsPo) {
		this.departmentsPo = departmentsPo;
	}

	public List<WeiXinDepartmentPicPo> getWeiXinDepartmentPicList() {
		return weiXinDepartmentPicList;
	}

	public void setWeiXinDepartmentPicList(
			List<WeiXinDepartmentPicPo> weiXinDepartmentPicList) {
		this.weiXinDepartmentPicList = weiXinDepartmentPicList;
	}
}
