package com.pengsheng.eims.basic.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.DoubleEyeFunMendMgr;
import com.pengsheng.eims.basic.persistence.DoubleEyeFunMendPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class DoubleEyeFunMendAction  extends BaseAction{
	private PersonPermissionMgr personPermissionMgr;
	private DoubleEyeFunMendMgr doubleEyeFunMendMgr;
	private DoubleEyeFunMendPo doubleEyeFunMendPo;
	
	/**
	 * 加载双眼视功能参数设置
	 */
	public String initDoubleEyeFunMend() throws Exception {
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
		
		doubleEyeFunMendPo = doubleEyeFunMendMgr.selectDoubleEyeFunMendPo();

		return SUCCESS;
	}
	
	/**
	 * 保存双眼视功能参数设置
	 */
	public String mendDoubleEyeFun() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("双眼视功能参数设置被"+personInfoPo.getPersonName()+"("+personInfoPo.getId()+")"+"修改!");
		
		if(doubleEyeFunMendPo == null){
			doubleEyeFunMendPo = new DoubleEyeFunMendPo();
		}
		
		doubleEyeFunMendMgr.insertDoubleEyeFunMendPo(doubleEyeFunMendPo, logPo);
		
		String url = "''initDoubleEyeFunMend.action?moduleID={0}''";
		List<String> params = new ArrayList<String>();
		params.add(moduleID);		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		this.clearMessages();
		this.addActionMessage("设置成功!");
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public DoubleEyeFunMendMgr getDoubleEyeFunMendMgr() {
		return doubleEyeFunMendMgr;
	}

	public void setDoubleEyeFunMendMgr(DoubleEyeFunMendMgr doubleEyeFunMendMgr) {
		this.doubleEyeFunMendMgr = doubleEyeFunMendMgr;
	}

	public DoubleEyeFunMendPo getDoubleEyeFunMendPo() {
		return doubleEyeFunMendPo;
	}

	public void setDoubleEyeFunMendPo(DoubleEyeFunMendPo doubleEyeFunMendPo) {
		this.doubleEyeFunMendPo = doubleEyeFunMendPo;
	}
}
