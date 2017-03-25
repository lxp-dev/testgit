package com.pengsheng.eims.basic.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.MemberOriginMgr;
import com.pengsheng.eims.basic.persistence.MemberOriginPo;
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

public class MemberOriginAction extends BaseAction{
	private MemberOriginPo memberOriginPo;
	private List<MemberOriginPo> memberOriginPos;
	private PersonPermissionMgr personPermissionMgr;
	private MemberOriginMgr memberOriginMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
	public String selectMemberOrigin() throws Exception {
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
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//根据查询条件返回相应的结果集数量
		int count = memberOriginMgr.getMemberOriginsCount();
		
		//查询结果>0 查询出结果
		if (count > 0) {
			
			//页面显示数量
			int perPage = 0;
			
			//获取页面参数  
			//perPage:页面显示数量
			//如果不为空获取当前参数的值
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				//如果
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			
			//
			Pagination page = new Pagination(request, count, perPage);
			
			//根据查询条件返回相应的结果集
			memberOriginPos = memberOriginMgr.getMemberOriginsList(page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			memberOriginPos = null;
		
		}
		
		return SUCCESS;
	}
	
	public String initInsertMemberOrigin() throws Exception {
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
		
		return SUCCESS;
	}
	
	public String insertMemberOrigin() throws Exception {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("顾客来源:(" + memberOriginPo.getBmoid()+")"+ memberOriginPo.getBmoname() + "新增!");
		
		int count = memberOriginMgr.selectMemberOriginCount(memberOriginPo);
		int flagName=memberOriginMgr.selectMemberOriginName(memberOriginPo);
		this.clearMessages();
		if(count > 0)
		{
			this.addActionMessage("该编号已存在！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);			
			return "error";
		}else
		{
			if(flagName>0)
			{
				this.addActionMessage("该来源名称已存在！");
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);			
				return "error";
			}else
			{
				memberOriginMgr.insertMemberOriginPo(memberOriginPo,logPo);						
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				
				return SUCCESS;
			}
			
		}
		
	}
	
	public String initUpdateMemberOrigin() throws Exception {
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
		
		String bmoid = Utility.getName(request.getParameter("bmoid"));
		
		MemberOriginPo po = new MemberOriginPo();
		
		po.setBmoid(bmoid);
		
		memberOriginPo = memberOriginMgr.selectMemberOriginPo(po);
		
		return SUCCESS;
	}
	
	public String updateMemberOrigin() throws Exception {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("顾客来源:(" + memberOriginPo.getBmoid()+")"+ memberOriginPo.getBmoname() + "更新!");
		int flagName=memberOriginMgr.selectMemberOriginNameUpdate(memberOriginPo);
		
		this.clearMessages();
		if(flagName>0)
		{
			this.addActionMessage("该来源名称已存在！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);			
			return "error";
		}else
		{
			memberOriginMgr.updateMemberOriginPo(memberOriginPo,logPo);	
			this.addActionMessage("更新成功！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);		
			return SUCCESS;
		}
				
	}
	
	public String initDeleteMemberOrigin() throws Exception {
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
		
		String bmoid = Utility.getName(request.getParameter("bmoid"));
		
		MemberOriginPo po = new MemberOriginPo();
		
		po.setBmoid(bmoid);
		
		memberOriginPo = memberOriginMgr.selectMemberOriginPo(po);
		
		return SUCCESS;
	}
	
	public String deleteMemberOrigin() throws Exception {
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
		
		MemberOriginPo po = new MemberOriginPo();
		
		String bmoid = Utility.getName(request.getParameter("bmoid"));
		
		po.setBmoid(bmoid);
		
		memberOriginPo = memberOriginMgr.selectMemberOriginPo(po);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("顾客来源:(" + memberOriginPo.getBmoid()+")"+ memberOriginPo.getBmoname() + "删除!");
		
		memberOriginMgr.deleteMemberOriginPo(po,logPo);
		
		this.clearMessages();
		this.addActionMessage("删除成功！");
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public MemberOriginPo getMemberOriginPo() {
		return memberOriginPo;
	}
	public void setMemberOriginPo(MemberOriginPo memberOriginPo) {
		this.memberOriginPo = memberOriginPo;
	}
	public List<MemberOriginPo> getMemberOriginPos() {
		return memberOriginPos;
	}
	public void setMemberOriginPos(List<MemberOriginPo> memberOriginPos) {
		this.memberOriginPos = memberOriginPos;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public MemberOriginMgr getMemberOriginMgr() {
		return memberOriginMgr;
	}
	public void setMemberOriginMgr(MemberOriginMgr memberOriginMgr) {
		this.memberOriginMgr = memberOriginMgr;
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
	
}
