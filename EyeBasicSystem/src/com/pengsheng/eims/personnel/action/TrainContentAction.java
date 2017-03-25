package com.pengsheng.eims.personnel.action;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.mgr.TrainContentMgr;
import com.pengsheng.eims.personnel.persistence.TrainContentPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class TrainContentAction extends BaseAction
{
	private TrainContentPo trainContentPo;
	private TrainContentMgr trainContentMgr;
	private List<TrainContentPo> trainContentPos;
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


	public String initSelectTrainContentList() throws Exception {
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
		TrainContentPo po = new TrainContentPo();
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = trainContentMgr.selectTrainContentCount(po);
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

			trainContentPos = trainContentMgr.selectTrainContentList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
		} else 
		{ //否则查询结果为NULL
			
			trainContentPos = null;
		
		}
		
		//request.setAttribute("", )回带条件
		
		return SUCCESS;
	}
	
	
	public String initInsertTrainContentPo() throws Exception {
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
	
	public String insertTrainContentPo() throws Exception {
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
		logPo.setsLogContent("培训内容编号：" + Utility.getName(trainContentPo.getMtccontentNumber()) + "新增!" );
		
		
		int flag = trainContentMgr.getTrainContentPoId(trainContentPo);
		int flagName=trainContentMgr.getTrainContentPoName(trainContentPo);
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			if(flagName==0)
			{
				trainContentMgr.insertTrainContentPo(trainContentPo, logPo)	;		
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				return SUCCESS;	
			}else
			{
				this.addActionMessage(getText("培训内容名称重复"));
				return "error";
			}
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("培训内容编号重复"));
			return "error";
		}

	}
	
	public String initUpdateTrainContentPo() throws Exception {
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
		TrainContentPo param=new TrainContentPo();
		param.setMtcuuid(request.getParameter("hid"));
		trainContentPo=trainContentMgr.selectTrainContentPo(param);
		return SUCCESS;
	}
	
	public String updateTrainContentPo() throws Exception {
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
		logPo.setsLogContent("培训内容编号：" + Utility.getName(trainContentPo.getMtccontentNumber()) + "修改!" );
		

		int flag = trainContentMgr.getTrainContentPoIdUpdate(trainContentPo);
		int flagName=trainContentMgr.getTrainContentPoNameUpdate(trainContentPo);
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			if(flagName==0)
			{
				trainContentMgr.updateTrainContentPo(trainContentPo, logPo)	;		
				this.addActionMessage(getText("struts.messages.update.sucess"));
				return SUCCESS;	
			}else
			{
				this.addActionMessage(getText("培训内容名称重复！"));
				return "error";
			}
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("培训内容编号重复！"));
			return "error";
		}
		
	}
	
	public String initDeleteTrainContentPo() throws Exception {
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
		TrainContentPo param=new TrainContentPo();
		param.setMtcuuid(request.getParameter("hid"));
		trainContentPo=trainContentMgr.selectTrainContentPo(param);		
		return SUCCESS;
	}
	
	public String deleteTrainContentPo() throws Exception {
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
		logPo.setsLogContent("培训内容编号：" + Utility.getName(request.getParameter("hno")) + "删除!" );
		
		TrainContentPo param=new TrainContentPo();
		param.setMtcuuid(request.getParameter("hid"));
		
		
		//查询职务表在其他s表中是否已经使用
		int flag =0 ;
		
		//清空message
		this.clearMessages();
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		

		//如果结果为0，ID不存在继续执行
		if(flag == 0)
		{	
			trainContentMgr.deleteTrainContentPo(param, logPo);		
			this.addActionMessage(getText("struts.messages.delete.sucess"));
		}else
		{//否则弹出消息			
			this.addActionMessage(getText("培训内容删除失败 这个培训内容已被使用！"));
			
		}
		
		return SUCCESS;
	}
	

	
	
	public TrainContentPo getTrainContentPo() {
		return trainContentPo;
	}


	public void setTrainContentPo(TrainContentPo trainContentPo) {
		this.trainContentPo = trainContentPo;
	}


	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	
	public TrainContentMgr getTrainContentMgr() {
		return trainContentMgr;
	}
	public void setTrainContentMgr(TrainContentMgr trainContentMgr) {
		this.trainContentMgr = trainContentMgr;
	}
	public List<TrainContentPo> getTrainContentPos() {
		return trainContentPos;
	}
	public void setTrainContentPos(List<TrainContentPo> trainContentPos) {
		this.trainContentPos = trainContentPos;
	}
}
