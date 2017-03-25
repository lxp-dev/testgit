package com.pengsheng.eims.personnel.action;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.mgr.ShiftMaintainMgr;
import com.pengsheng.eims.personnel.persistence.ShiftMaintainPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class ShiftMaintainAction extends BaseAction
{
	private ShiftMaintainPo shiftMaintainPo;
	private ShiftMaintainMgr shiftMaintainMgr;
	private List<ShiftMaintainPo> shiftMaintainPos;
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr;
	
	
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
	public ShiftMaintainPo getShiftMaintainPo() {
		return shiftMaintainPo;
	}
	public void setShiftMaintainPo(ShiftMaintainPo shiftMaintainPo) {
		this.shiftMaintainPo = shiftMaintainPo;
	}
	public ShiftMaintainMgr getShiftMaintainMgr() {
		return shiftMaintainMgr;
	}
	public void setShiftMaintainMgr(ShiftMaintainMgr shiftMaintainMgr) {
		this.shiftMaintainMgr = shiftMaintainMgr;
	}
	public List<ShiftMaintainPo> getShiftMaintainPos() {
		return shiftMaintainPos;
	}
	public void setShiftMaintainPos(List<ShiftMaintainPo> shiftMaintainPos) {
		this.shiftMaintainPos = shiftMaintainPos;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	
	
	public String initSelectShiftMaintainList() throws Exception {
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
		ShiftMaintainPo po = new ShiftMaintainPo();
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = shiftMaintainMgr.selectShiftMaintainCount(po);
		//分页
		if (count > 0) 
		{
			int perPage = 0;
			if (request.getParameter("perPage") != null) 
			{
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) 
			{
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

			shiftMaintainPos = shiftMaintainMgr.selectShiftMaintainList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		} else 
		{ //否则查询结果为NULL
			
			shiftMaintainPos = null;
		
		}
		
		//request.setAttribute("", )回带条件
		
		return SUCCESS;
	}
	
	
	public String initInsertShiftMaintainPo() throws Exception {
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
		
		
		
		return SUCCESS;
	}
	
	public String insertShiftMaintainPo() throws Exception {
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
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("班次编号：" + Utility.getName(shiftMaintainPo.getMsmshiftNumber()) + "新增!" );
		
		
		int flag = shiftMaintainMgr.getShiftMaintainPoId(shiftMaintainPo);
		int flagName=shiftMaintainMgr.getShiftMaintainPoName(shiftMaintainPo);
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			if(flagName==0)
			{
				shiftMaintainMgr.insertShiftMaintainPo(shiftMaintainPo, logPo)	;		
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				return SUCCESS;	
			}else
			{
				this.addActionMessage(getText("班次名称重复"));
				return "error";
			}
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("班次编号重复"));
			return "error";
		}

	}
	
	public String initUpdateShiftMaintainPo() throws Exception {
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
		ShiftMaintainPo param=new ShiftMaintainPo();
		param.setMsmuuid(request.getParameter("hid"));
		shiftMaintainPo=shiftMaintainMgr.selectShiftMaintainPo(param);
		return SUCCESS;
	}
	
	public String updateShiftMaintainPo() throws Exception {
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
		logPo.setsLogContent("班次编号：" + Utility.getName(shiftMaintainPo.getMsmshiftNumber()) + "修改!" );
		

		int flag = shiftMaintainMgr.getShiftMaintainPoIdUpdate(shiftMaintainPo);
		int flagName=shiftMaintainMgr.getShiftMaintainPoNameUpdate(shiftMaintainPo);
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			if(flagName==0)
			{
				shiftMaintainMgr.updateShiftMaintainPo(shiftMaintainPo, logPo)	;		
				this.addActionMessage(getText("struts.messages.update.sucess"));
				return SUCCESS;	
			}else
			{
				this.addActionMessage(getText("班次名称重复！"));
				return "error";
			}
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("班次编号重复！"));
			return "error";
		}
		
	}
	
	public String initDeleteShiftMaintainPo() throws Exception {
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
		ShiftMaintainPo param=new ShiftMaintainPo();
		param.setMsmuuid(request.getParameter("hid"));
		shiftMaintainPo=shiftMaintainMgr.selectShiftMaintainPo(param);		
		return SUCCESS;
	}
	
	public String deleteShiftMaintainPo() throws Exception {
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
		logPo.setsLogContent("班次编号：" + Utility.getName(request.getParameter("hno")) + "删除!" );
		
		ShiftMaintainPo param=new ShiftMaintainPo();
		param.setMsmuuid(request.getParameter("hid"));
		
		
		//查询职务表在其他s表中是否已经使用
		int flag =0 ;
		
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		

		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			shiftMaintainMgr.deleteShiftMaintainPo(param, logPo);		
			this.addActionMessage(getText("struts.messages.delete.sucess"));
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("班次删除失败 这个班次已被使用！"));
			
		}
		
		return SUCCESS;
	}
	
	
	
}
