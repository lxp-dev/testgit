package com.pengsheng.eims.personnel.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.mgr.RewardsAndPenaltiesMgr;
import com.pengsheng.eims.personnel.persistence.RewardsAndPenaltiesPo;
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

public class RewardsAndPenaltiesAction extends BaseAction
{
	private RewardsAndPenaltiesMgr rewardsAndPenaltiesMgr;
	private PersonPermissionMgr personPermissionMgr;
	private List<RewardsAndPenaltiesPo> rewardsAndPenaltiesPos;
	private RewardsAndPenaltiesPo rewardsAndPenaltiesPo;
	private List<PersonInfoPo> persons;
	private List<RolePo> roles;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private PersonInfoMgr personInfoMgr;
	private PersonInfoPo rppersonInfo;
	
	public String initSelRewardsAndPenalties() 
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selRewardsAndPenalties";
		}
				
		return SUCCESS;
	}
	
	public String selRewardsAndPenalties()
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

		RewardsAndPenaltiesPo po = new RewardsAndPenaltiesPo();
		
		po.setRewardsandpenaltiesid(Utility.getName(request.getParameter("rewardsandpenaltiesid")));
		po.setRewardsorpenalties(Utility.getName(request.getParameter("rewardsorpenalties")));
		po.setPersonid(Utility.getName(request.getParameter("personid")));
		po.setPersonname(Utility.getName(request.getParameter("personname")));
		po.setCreatpersonid(Utility.getName(request.getParameter("creatpersonid")));
		po.setCreatpersonname(Utility.getName(request.getParameter("creatpersonname")));
		po.setBgncreatdate(Utility.getName(request.getParameter("bgncreatdate")));
		po.setEndcreatdate(Utility.getName(request.getParameter("endcreatdate")));
		po.setRemark(Utility.getName(request.getParameter("remark")));
		
		request.setAttribute("rewardsandpenaltiesid", request.getParameter("rewardsandpenaltiesid"));
		request.setAttribute("rewardsorpenalties", request.getParameter("rewardsorpenalties"));
		request.setAttribute("personid", request.getParameter("personid"));
		request.setAttribute("personname", request.getParameter("personname"));
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

		int count = rewardsAndPenaltiesMgr.getRewardsAndPenaltiesCount(po);

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

			rewardsAndPenaltiesPos = rewardsAndPenaltiesMgr.getRewardsAndPenalties(po, page.getStart(), page.getPageSize());			
			
			request.setAttribute(Pagination.PAGINATION, page);
		}		
		return SUCCESS;
	}
	
	public String initInsertRewardsAndPenalties() {
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
	
	public String insertRewardsAndPenalties() throws Exception 
	{
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
		
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String billid = "JC" + personInfoPo.getMachinery() + numHeadFormat.format(new Date());
		
		rewardsAndPenaltiesPo.setMrprewardsandpenaltiesid(billid);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("员工奖惩：" + billid + " 新增!" );
		rewardsAndPenaltiesPo.setMrpcreatpersonid(personInfoPo.getId());
		
		this.clearMessages();
		
		rewardsAndPenaltiesMgr.insertRewardsAndPenaltiesPo(rewardsAndPenaltiesPo, logPo);		
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;				
	}
	
	
	public String initUpdateRewardsAndPenaltiesPo() throws Exception 
	{
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
		String hid = request.getParameter(Utility.getName("hid"));
		
		RewardsAndPenaltiesPo po = new RewardsAndPenaltiesPo();
		po.setRewardsandpenaltiesid(hid);
		
		rewardsAndPenaltiesPo = rewardsAndPenaltiesMgr.getRewardsAndPenaltiesPo(po);
		
		PersonInfoPo tjcpo = new PersonInfoPo();
		tjcpo.setId(rewardsAndPenaltiesPo.getMrppersonid());
		rppersonInfo = personInfoMgr.getPersonInfo(tjcpo);
		
		return SUCCESS;
	}
	
	public String updateRewardsAndPenaltiesPo() throws Exception {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("员工奖惩：" + Utility.getName(rewardsAndPenaltiesPo.getMrprewardsandpenaltiesid()) + "修改!" );
		
		this.clearMessages();
		
		rewardsAndPenaltiesMgr.updateRewardsAndPenaltiesPo(rewardsAndPenaltiesPo, logPo);		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;				
	}
	
	public String initSelRewardsAndPenaltiesPo() throws Exception 
	{
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
		String hid = request.getParameter(Utility.getName("hid"));
		
		RewardsAndPenaltiesPo po = new RewardsAndPenaltiesPo();
		po.setRewardsandpenaltiesid(hid);
		
		rewardsAndPenaltiesPo = rewardsAndPenaltiesMgr.getRewardsAndPenaltiesPo(po);
		
		return SUCCESS;	
	}
	
	public String initDeleteRewardsAndPenaltiesPo() throws Exception {
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
		String hid = request.getParameter(Utility.getName("hid"));
		
		RewardsAndPenaltiesPo po = new RewardsAndPenaltiesPo();
		po.setRewardsandpenaltiesid(hid);
		
		rewardsAndPenaltiesPo = rewardsAndPenaltiesMgr.getRewardsAndPenaltiesPo(po);
		
		return SUCCESS;
	}
	
	public String deleteRewardsAndPenaltiesPo() throws Exception {
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
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 2 表示删除
		logPo.setsLogContent("员工奖惩：" + Utility.getName(rewardsAndPenaltiesPo.getMrprewardsandpenaltiesid()) + "删除!");
		
		this.clearMessages();
		
		rewardsAndPenaltiesMgr.deleteRewardsAndPenaltiesPo(rewardsAndPenaltiesPo, logPo);	
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	public RewardsAndPenaltiesMgr getRewardsAndPenaltiesMgr() {
		return rewardsAndPenaltiesMgr;
	}

	public void setRewardsAndPenaltiesMgr(
			RewardsAndPenaltiesMgr rewardsAndPenaltiesMgr) {
		this.rewardsAndPenaltiesMgr = rewardsAndPenaltiesMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<RewardsAndPenaltiesPo> getRewardsAndPenaltiesPos() {
		return rewardsAndPenaltiesPos;
	}

	public void setRewardsAndPenaltiesPos(
			List<RewardsAndPenaltiesPo> rewardsAndPenaltiesPos) {
		this.rewardsAndPenaltiesPos = rewardsAndPenaltiesPos;
	}

	public RewardsAndPenaltiesPo getRewardsAndPenaltiesPo() {
		return rewardsAndPenaltiesPo;
	}

	public void setRewardsAndPenaltiesPo(RewardsAndPenaltiesPo rewardsAndPenaltiesPo) {
		this.rewardsAndPenaltiesPo = rewardsAndPenaltiesPo;
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
}
