package com.pengsheng.weixin.action;

import java.util.List;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.weixin.mgr.WeiXinLuckDrawSetMgr;
import com.pengsheng.weixin.persistence.WeiXinLuckDrawPo;


public class WeiXinLuckDrawSetAction  extends BaseAction {
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private PersonPermissionMgr personPermissionMgr;
	private WeiXinLuckDrawPo weiXinLuckDrawPo;
	private WeiXinLuckDrawSetMgr weiXinLuckDrawSetMgr;
	private List<WeiXinLuckDrawPo> weiXinLuckDrawPoList;
	private String isFirstExec; 
	
	public WeiXinLuckDrawSetMgr getWeiXinLuckDrawSetMgr() {
		return weiXinLuckDrawSetMgr;
	}
	public void setWeiXinLuckDrawSetMgr(WeiXinLuckDrawSetMgr weiXinLuckDrawSetMgr) {
		this.weiXinLuckDrawSetMgr = weiXinLuckDrawSetMgr;
	}
	public WeiXinLuckDrawPo getWeiXinLuckDrawPo() {
		return weiXinLuckDrawPo;
	}
	public void setWeiXinLuckDrawPo(WeiXinLuckDrawPo weiXinLuckDrawPo) {
		this.weiXinLuckDrawPo = weiXinLuckDrawPo;
	}
	public List<WeiXinLuckDrawPo> getWeiXinLuckDrawPoList() {
		return weiXinLuckDrawPoList;
	}
	public void setWeiXinLuckDrawPoList(List<WeiXinLuckDrawPo> weiXinLuckDrawPoList) {
		this.weiXinLuckDrawPoList = weiXinLuckDrawPoList;
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
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public String initWeiLuckDrawSetSel() throws Exception{
		
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
		systemParameterPo = systemParameterMgr.getSystemParameterPo();		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "weiLuckDrawSetSel";
		}
		return SUCCESS;
	}
	public String weiLuckDrawSetSel() throws Exception{
		
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
		
		
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
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
		
		
		int count=weiXinLuckDrawSetMgr.selectWeiXinLuckDrawSetCount(weiXinLuckDrawPo);
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
	    weiXinLuckDrawPoList=weiXinLuckDrawSetMgr.selectWeiXinLuckDrawSetList(weiXinLuckDrawPo, page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			weiXinLuckDrawPoList = null;
		}
		return SUCCESS;
		
	}
	public String initWeiXinLuckDrawSetUpdate() throws Exception{
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
		weiXinLuckDrawPo = new WeiXinLuckDrawPo();
		weiXinLuckDrawPo.setWcjid(Utility.getName(request.getParameter("hid")));
		weiXinLuckDrawPo=weiXinLuckDrawSetMgr.selectWeiXinLuckDrawPo(weiXinLuckDrawPo);
		return SUCCESS;
	}
	public String updateWeiXinLuckDrawSet() throws Exception{

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
		weiXinLuckDrawPo = new WeiXinLuckDrawPo();
		weiXinLuckDrawPo.setWcjid(Utility.getName(request.getParameter("hid")));
		weiXinLuckDrawPo.setWcjpersonid(personInfoPo.getId());
		weiXinLuckDrawPo.setWcjshopid(personInfoPo.getDepartmentID());
		weiXinLuckDrawSetMgr.updateWeiXinLuckDrawSet(weiXinLuckDrawPo);
		this.clearMessages();
		this.addActionMessage(getText("领取成功！"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	public String initWeiXinLuckDrawSetUpdate1() throws Exception{
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
		weiXinLuckDrawPo = new WeiXinLuckDrawPo();
		weiXinLuckDrawPo=weiXinLuckDrawSetMgr.selectWeiXinLuckDrawSet(weiXinLuckDrawPo);
		if("".equals(Utility.getName(weiXinLuckDrawPo.getWcjspersonlucknumber()))){
			weiXinLuckDrawPo.setWcjspersonlucknumber("1");
		}
		if("".equals(Utility.getName(weiXinLuckDrawPo.getWcjspersonnumber()))){
			weiXinLuckDrawPo.setWcjspersonnumber("1");
		}
		if("".equals(Utility.getName(weiXinLuckDrawPo.getWcjsdaynumber()))){
			weiXinLuckDrawPo.setWcjsdaynumber("1");
		}
		return SUCCESS;
	}
	public String updateWeiXinLuckDrawSet1() throws Exception{
		
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
		weiXinLuckDrawSetMgr.insertWeiXinLuckDrawSetSum(weiXinLuckDrawPo);
		this.clearMessages();
		this.addActionMessage(getText("保存成功！"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
}
