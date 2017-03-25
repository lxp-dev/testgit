package com.pengsheng.eims.personnel.action;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.dao.TrainLevelDao;
import com.pengsheng.eims.personnel.mgr.TrainLevelMgr;
import com.pengsheng.eims.personnel.persistence.PostPo;
import com.pengsheng.eims.personnel.persistence.TrainLevelPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class TrainLevelAction extends BaseAction
{
	private TrainLevelPo trainLevelPo;
	private TrainLevelMgr trainLevelMgr;
	private List<TrainLevelPo> trainLevelPos;
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


	public String initSelectTrainLevelList() throws Exception {
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
		TrainLevelPo po = new TrainLevelPo();
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = trainLevelMgr.selectTrainLevelCount(po);
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

			trainLevelPos = trainLevelMgr.selectTrainLevelList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		} else 
		{ //否则查询结果为NULL
			
			trainLevelPos = null;
		
		}
		
		//request.setAttribute("", )回带条件
		
		return SUCCESS;
	}
	
	
	public String initInsertTrainLevelPo() throws Exception {
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
	
	public String insertTrainLevelPo() throws Exception {
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
		logPo.setsLogContent("培训等级编号：" + Utility.getName(trainLevelPo.getMtllevelNumber()) + "新增!" );
		
		
		int flag = trainLevelMgr.getTrainLevelPoId(trainLevelPo);
		int flagName=trainLevelMgr.getTrainLevelPoName(trainLevelPo);
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			if(flagName==0)
			{
				trainLevelMgr.insertTrainLevelPo(trainLevelPo, logPo)	;		
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				return SUCCESS;	
			}else
			{
				this.addActionMessage(getText("培训等级名称重复"));
				return "error";
			}
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("培训等级编号重复"));
			return "error";
		}

	}
	
	public String initUpdateTrainLevelPo() throws Exception {
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
		TrainLevelPo param=new TrainLevelPo();
		param.setMtluuid(request.getParameter("hid"));
		trainLevelPo=trainLevelMgr.selectTrainLevelPo(param);
		return SUCCESS;
	}
	
	public String updateTrainLevelPo() throws Exception {
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
		logPo.setsLogContent("培训等级编号：" + Utility.getName(trainLevelPo.getMtllevelNumber()) + "修改!" );
		

		int flag = trainLevelMgr.getTrainLevelPoIdUpdate(trainLevelPo);
		int flagName=trainLevelMgr.getTrainLevelPoNameUpdate(trainLevelPo);
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			if(flagName==0)
			{
			trainLevelMgr.updateTrainLevelPo(trainLevelPo, logPo)	;		
			this.addActionMessage(getText("struts.messages.update.sucess"));
			return SUCCESS;	
			}else
			{
				this.addActionMessage(getText("培训等级名称重复！"));
				return "error";
			}
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("培训等级编号重复！"));
			return "error";
		}
		
	}
	
	public String initDeleteTrainLevelPo() throws Exception {
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
		TrainLevelPo param=new TrainLevelPo();
		param.setMtluuid(request.getParameter("hid"));
		trainLevelPo=trainLevelMgr.selectTrainLevelPo(param);		
		return SUCCESS;
	}
	
	public String deleteTrainLevelPo() throws Exception {
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
		logPo.setsLogContent("培训等级编号：" + Utility.getName(request.getParameter("hno")) + "删除!" );
		
		TrainLevelPo param=new TrainLevelPo();
		param.setMtluuid(request.getParameter("hid"));
		
		
		//查询职务表在其他s表中是否已经使用
		int flag =0 ;
		
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		

		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			trainLevelMgr.deleteTrainLevelPo(param, logPo);		
			this.addActionMessage(getText("struts.messages.delete.sucess"));
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("培训等级删除失败 这个培训等级已被使用！"));
			
		}
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public TrainLevelPo getTrainLevelPo() {
		return trainLevelPo;
	}


	public void setTrainLevelPo(TrainLevelPo trainLevelPo) {
		this.trainLevelPo = trainLevelPo;
	}


	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	
	public TrainLevelMgr getTrainLevelMgr() {
		return trainLevelMgr;
	}
	public void setTrainLevelMgr(TrainLevelMgr trainLevelMgr) {
		this.trainLevelMgr = trainLevelMgr;
	}
	public List<TrainLevelPo> getTrainLevelPos() {
		return trainLevelPos;
	}
	public void setTrainLevelPos(List<TrainLevelPo> trainLevelPos) {
		this.trainLevelPos = trainLevelPos;
	}
	
}
