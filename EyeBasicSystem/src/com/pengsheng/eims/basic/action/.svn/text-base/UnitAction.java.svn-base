package com.pengsheng.eims.basic.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.ComplaintsTypePo;
import com.pengsheng.eims.basic.persistence.ForeignRecipelPo;
import com.pengsheng.eims.basic.persistence.NonconformingProductPo;
import com.pengsheng.eims.basic.persistence.NoteTemplatePo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.basic.persistence.UnitPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class UnitAction extends BaseAction implements ServletRequestAware,
		SessionAware {

	private PersonPermissionMgr personPermissionMgr;	
	private UnitPo unitPo;
	private List<UnitPo> list; // 门店列表List
	private UnitMgr unitMgr;
 
	private ComplaintsTypePo complaintsTypePo = null;
	private ForeignRecipelPo foreignRecipelPo = null;
	private RefractiveSetPo refractivePo = null;
	private NoteTemplatePo noteTemplatePo = null;	
	private List<ComplaintsTypePo> complaintsTypeList = null;
	private List<ForeignRecipelPo> foreignRecipelList = null;
	private List<RefractiveSetPo> refractiveSetList = null;
	private List<NoteTemplatePo> noteTemplateList = null;
	private List<NoteTemplatePo> noteTypeList = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public List<NoteTemplatePo> getNoteTypeList() {
		return noteTypeList;
	}
	public void setNoteTypeList(List<NoteTemplatePo> noteTypeList) {
		this.noteTypeList = noteTypeList;
	}
	
	/**
	 * 查询计量单位列表
	 */
	public String selUnit() throws Exception {
		
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

		// 页面查询条件

		// 取得查询结果计量单位List Begin
		//list = unitMgr.getUnitList();
		// 取得查询结果计量单位List End
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//根据查询条件返回相应的结果集数量
		int count = unitMgr.getUnitCount();
		
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
			list = unitMgr.getUnitsList(page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			list = null;
		
		}
		
		

		// 传回页面变量参数 End
		return SUCCESS;
	}

	/**
	 * 初始化计量单位新增
	 */
	public String initInsertUnit() throws Exception {

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
		
		unitPo=new UnitPo();
		return SUCCESS;
	}

	/**
	 * 初始化计量单位新增
	 */
	public String insertUnit() throws Exception {

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
		
		UnitPo temp = new UnitPo();
		temp.setButid(unitPo.getButid());
		this.clearMessages();
		int flagename=unitMgr.getUnitName(unitPo);
		if (!"".equals(Utility.getName(unitMgr.getUnit(temp).getButid()))) 
		{			
			this.addActionMessage(getText("计量单位编码重复!"));
			return "NoRepeat";
		}else
		{
			if(flagename==0)
			{
				//添加日志
				LogisticsLogPo logPo = new LogisticsLogPo();
				logPo.setsLogName(createPerson);
				logPo.setsLogIP(request.getRemoteAddr());
				logPo.setsLogResult(moduleID); 	// 表示模块名称 
				logPo.setsLogOpID("1");    		// 表示状态
				logPo.setsLogContent("计量单位:" + unitPo.getButid() + "新增!");

				unitMgr.insertUnit(unitPo,logPo);
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				return SUCCESS;
			}else
			{
				this.addActionMessage(getText("计量单位名称重复!"));
				return "NoRepeat";
			}
		}
		
		
	}

	/**
	 * 初始化计量单位更新
	 */
	public String initUpdateUnit() throws Exception {
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
		
		// 页面参数：计量单位Id
		String butid=Utility.getName(request.getParameter("hid"));
		
		//根据计量单位Id查询计量单位对象
		unitPo = new UnitPo();
		unitPo.setButid(butid);
		unitPo=unitMgr.getUnit(unitPo);

		return SUCCESS;
	}
	
	/**
	 * 计量单位更新
	 */
	public String updateUnit() throws Exception {
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
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("3");    		// 表示状态
		logPo.setsLogContent("计量单位:" + unitPo.getButid() + "修改!");
		int flagname=unitMgr.getUnitNameUpdate(unitPo);
		this.clearMessages();
		if(flagname==0)
		{
			unitMgr.updateUnit(unitPo,logPo);				
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);

			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("计量单位名称重复!"));
			return "NoRepeat";
		}
		
	}
	
	/**
	 * 初始化计量单位删除
	 */
	public String initDeleteUnit()throws Exception{
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
		
		// 页面参数：计量单位Id
		String butid=Utility.getName(request.getParameter("hid"));
		
		//根据计量单位Id查询计量单位对象
		unitPo = new UnitPo();
		unitPo.setButid(butid);
		unitPo=unitMgr.getUnit(unitPo);

		return SUCCESS;
	}
	
	/**
	 * 删除计量单位
	 */
	public String deleteUnit()throws Exception{
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
		
		// 页面参数：计量单位Id
		String butid=Utility.getName(request.getParameter("hid"));
		
		unitPo = new UnitPo();
		unitPo.setButid(butid);
		int count=unitMgr.getGoodsCount(unitPo);
		if(count>0){
			this.clearMessages();
			this.addActionMessage(getText("data.have.been.used.remove.failed"));
			return "dataUsed";
		}
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("2");    		// 表示状态
		logPo.setsLogContent("计量单位:" + unitPo.getButid() + "删除!");
		
		unitMgr.deleteUnit(unitPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/*** 投诉类型 **************************************************************************************************************************/
	
	/**
	 * 查询投诉类型
	 */
	public String initComplaintsTypeSel() throws Exception {
		
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

		//complaintsTypeList = unitMgr.getComplaintsTypeList();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//根据查询条件返回相应的结果集数量
		int count = unitMgr.getComplaintsTypesCount();
		
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
			complaintsTypeList = unitMgr.getComplaintsTypesList(page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			complaintsTypeList = null;
		
		}

		return SUCCESS;
	}

	/**
	 * 初始化投诉类型新增
	 */
	public String initComplaintsTypeInsert() throws Exception {

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

	/**
	 * 投诉类型新增
	 */
	public String complaintsTypeInsert() throws Exception {

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
		
		this.clearMessages();
		int flagname=unitMgr.getComplaintsTypeName(complaintsTypePo);
		if (unitMgr.isExistComplaintsType(complaintsTypePo) > 0){
			
			request.setAttribute("bctid",complaintsTypePo.getBctid());
			request.setAttribute("bctname",complaintsTypePo.getBctname());
			this.addActionMessage(getText("投诉类型编码重复!"));
			return "NoRepeat";
		}else
		{
			if(flagname==0)
			{
				//添加日志
				LogisticsLogPo logPo = new LogisticsLogPo();
				logPo.setsLogName(createPerson);
				logPo.setsLogIP(request.getRemoteAddr());
				logPo.setsLogResult(moduleID); 	// 表示模块名称 
				logPo.setsLogOpID("1");    		// 表示状态
				logPo.setsLogContent("投诉类型:" + complaintsTypePo.getBctid()+complaintsTypePo.getBctname() + "新增!");
				
				unitMgr.insertComplaintsType(complaintsTypePo,logPo);		
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				return SUCCESS;
			}else
			{

				request.setAttribute("bctid",complaintsTypePo.getBctid());
				request.setAttribute("bctname",complaintsTypePo.getBctname());
				this.addActionMessage(getText("投诉类型名称重复!"));
				return "NoRepeat";
			}
		}
		
		
	}

	/**
	 * 初始化投诉类型更新
	 */
	public String initComplaintsTypeUpdate() throws Exception {
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

		complaintsTypePo = new ComplaintsTypePo();
		complaintsTypePo.setBctid(Utility.getName(request.getParameter("hid")));

		complaintsTypePo = unitMgr.getComplaintsTypeDetail(complaintsTypePo);
		
		return SUCCESS;
	}
	
	/**
	 * 投诉类型更新
	 */
	public String complaintsTypeUpdate() throws Exception {
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
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("3");    		// 表示状态
		logPo.setsLogContent("投诉类型:" + complaintsTypePo.getBctid()+complaintsTypePo.getBctname() + "修改!");
		this.clearMessages();
		int flagname=unitMgr.getComplaintsTypeNameUpdate(complaintsTypePo);
		if(flagname==0)
		{
			unitMgr.updateComplaintsType(complaintsTypePo, logPo);	
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("投诉类型名称重复!"));
			return "NoRepeat";
		}
		
		
	}
	
	/**
	 * 初始化投诉类型删除
	 */
	public String initComplaintsTypeDelete()throws Exception{
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

		complaintsTypePo = new ComplaintsTypePo();
		complaintsTypePo.setBctid(Utility.getName(request.getParameter("hid")));

		complaintsTypePo = unitMgr.getComplaintsTypeDetail(complaintsTypePo);

		return SUCCESS;
	}
	
	/**
	 * 删除投诉类型
	 */
	public String complaintsTypeDelete()throws Exception{
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
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("2");    		// 表示状态
		logPo.setsLogContent("投诉类型:" + complaintsTypePo.getBctid()+complaintsTypePo.getBctname() + "删除!");
		
		unitMgr.deleteComplaintsType(complaintsTypePo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**** 折射率 ***************************************************************************************************************************/
	
	/**
	 * 查询折射率
	 */
	public String initRefractiveSetSel() throws Exception {
		
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

		//refractiveSetList = unitMgr.getRefractiveSetList();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//根据查询条件返回相应的结果集数量
		int count = unitMgr.getRefractiveSetsCount();
		
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
			refractiveSetList = unitMgr.getRefractiveSetsList(page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			refractiveSetList = null;
		
		}
		
		

		return SUCCESS;
	}

	/**
	 * 初始化折射率新增
	 */
	public String initRefractiveSetInsert() throws Exception {

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

	/**
	 * 折射率新增
	 */
	public String refractiveSetInsert() throws Exception {

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
		this.clearMessages();
		int flagname=unitMgr.getRefractiveName(refractivePo);
		if (unitMgr.isExistRefractiveSet(refractivePo) > 0){	
			
			request.setAttribute("brfid",refractivePo.getBrfid());
			request.setAttribute("brfname",refractivePo.getBrfname());
						
			this.addActionMessage(getText("折射率编码重复!"));
			return "NoRepeat";
		}else
		{
			if(flagname==0)
			{
				//添加日志
				LogisticsLogPo logPo = new LogisticsLogPo();
				logPo.setsLogName(createPerson);
				logPo.setsLogIP(request.getRemoteAddr());
				logPo.setsLogResult(moduleID); 	// 表示模块名称 
				logPo.setsLogOpID("1");    		// 表示状态
				logPo.setsLogContent("折射率:" + refractivePo.getBrfid()+refractivePo.getBrfname() + "新增!");

				unitMgr.insertRefractiveSet(refractivePo, logPo);
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);

				return SUCCESS;
			}else
			{
				request.setAttribute("brfid",refractivePo.getBrfid());
				request.setAttribute("brfname",refractivePo.getBrfname());
							
				this.addActionMessage(getText("折射率值重复!"));
				return "NoRepeat";
			}
		}
		
		
	}

	/**
	 * 初始化折射率更新
	 */
	public String initRefractiveSetUpdate() throws Exception {
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

		refractivePo = new RefractiveSetPo();
		refractivePo.setBrfid(Utility.getName(request.getParameter("hid")));
		
		refractivePo = unitMgr.getRefractiveSetDetail(refractivePo);

		return SUCCESS;
	}
	
	/**
	 * 折射率更新
	 */
	public String refractiveSetUpdate() throws Exception {
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
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("3");    		// 表示状态
		logPo.setsLogContent("折射率:" + refractivePo.getBrfid()+refractivePo.getBrfname() + "修改!");
		this.clearMessages();
		int flagname=unitMgr.getRefractiveNameUpdate(refractivePo);
		if(flagname==0)
		{
			unitMgr.updateRefractiveSet(refractivePo, logPo);					
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("折射率值重复!"));
			return "NoRepeat";
		}
		
	}
	
	/**
	 * 初始化折射率删除
	 */
	public String initRefractiveSetDelete()throws Exception{
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

		refractivePo = new RefractiveSetPo();
		refractivePo.setBrfid(Utility.getName(request.getParameter("hid")));
		
		refractivePo = unitMgr.getRefractiveSetDetail(refractivePo);

		return SUCCESS;
	}
	
	/**
	 * 删除折射率
	 */
	public String refractiveSetDelete()throws Exception{
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
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("2");    		// 表示状态
		logPo.setsLogContent("折射率:" + refractivePo.getBrfid()+refractivePo.getBrfname() + "删除!");
		
		unitMgr.deleteRefractiveSet(refractivePo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/*** 外来处方 **************************************************************************************************************************/
	
	/**
	 * 查询外来处方
	 */
	public String initForeignRecipelSel() throws Exception {
		
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

		//foreignRecipelList = unitMgr.getForeignRecipelList();
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//根据查询条件返回相应的结果集数量
		int count = unitMgr.getForeignRecipelsCount();
		
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
			foreignRecipelList = unitMgr.getForeignRecipelsList(page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			foreignRecipelList = null;
		
		}

		return SUCCESS;
	}

	/**
	 * 初始化外来处方新增
	 */
	public String initForeignRecipelInsert() throws Exception {

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

	/**
	 * 外来处方新增
	 */
	public String foreignRecipelInsert() throws Exception {

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
		int flagname=unitMgr.getForeignRecipelName(foreignRecipelPo);
		if (unitMgr.isExistForeignRecipel(foreignRecipelPo) > 0){	
			
			request.setAttribute("bfrid",foreignRecipelPo.getBfrid());
			request.setAttribute("bfrname",foreignRecipelPo.getBfrname());
			
			this.clearMessages();
			this.addActionMessage(getText("外来处方编码重复!"));
			return "NoRepeat";
		}else
		{
			if(flagname==0)
			{
				//添加日志
				LogisticsLogPo logPo = new LogisticsLogPo();
				logPo.setsLogName(createPerson);
				logPo.setsLogIP(request.getRemoteAddr());
				logPo.setsLogResult(moduleID); 	// 表示模块名称 
				logPo.setsLogOpID("1");    		// 表示状态
				logPo.setsLogContent("外来处方:" + foreignRecipelPo.getBfrid()+foreignRecipelPo.getBfrname() + "新增!");

				unitMgr.insertForeignRecipel(foreignRecipelPo, logPo);

				this.clearMessages();
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);

				return SUCCESS;
			}else
			{
				request.setAttribute("bfrid",foreignRecipelPo.getBfrid());
				request.setAttribute("bfrname",foreignRecipelPo.getBfrname());
				
				this.clearMessages();
				this.addActionMessage(getText("外来处方名称重复!"));
				return "NoRepeat";
			}			
		}
		
		
	}

	/**
	 * 初始化外来处方更新
	 */
	public String initForeignRecipelUpdate() throws Exception {
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

		foreignRecipelPo = new ForeignRecipelPo();
		foreignRecipelPo.setBfrid(Utility.getName(request.getParameter("hid")));
		
		foreignRecipelPo = unitMgr.getForeignRecipelDetail(foreignRecipelPo);
		
		return SUCCESS;
	}
	
	/**
	 * 外来处方更新
	 */
	public String foreignRecipelUpdate() throws Exception {
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
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("3");    		// 表示状态
		logPo.setsLogContent("外来处方:" + foreignRecipelPo.getBfrid()+foreignRecipelPo.getBfrname() + "修改!");
		this.clearMessages();
		int flagname=unitMgr.getForeignRecipelNameUpdate(foreignRecipelPo);
		if(flagname==0)
		{
			unitMgr.updateForeignRecipel(foreignRecipelPo, logPo);			
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("外来处方名称重复!"));
			return "NoRepeat";
		}
		
		
	}
	
	/**
	 * 初始化外来处方删除
	 */
	public String initForeignRecipelDelete()throws Exception{
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
		
		foreignRecipelPo = new ForeignRecipelPo();
		foreignRecipelPo.setBfrid(Utility.getName(request.getParameter("hid")));
		
		foreignRecipelPo = unitMgr.getForeignRecipelDetail(foreignRecipelPo);

		return SUCCESS;
	}
	
	/**
	 * 删除外来处方
	 */
	public String foreignRecipelDelete()throws Exception{
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
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("2");    		// 表示状态
		logPo.setsLogContent("外来处方:" + foreignRecipelPo.getBfrid()+foreignRecipelPo.getBfrname() + "删除!");
		
		unitMgr.deleteForeignRecipel(foreignRecipelPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**** 短信模板 ***************************************************************************************************************************/		
	
	/**
	 * 初始化查询短信模板
	 */
	public String initNoteTemplateSel() throws Exception {
		
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

		noteTypeList = unitMgr.getNoteTemplateList();

		return SUCCESS;
	}

	/**
	 * 查询短信模板
	 */
	public String noteTemplateSel() throws Exception {
		
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

		String fnpid=Utility.getName(request.getParameter("fnpid"));
		noteTypeList = unitMgr.getNoteTemplateList();
		
		if(!fnpid.equals("")){
			noteTemplatePo =  new NoteTemplatePo();
			noteTemplatePo.setBntname(fnpid);
			noteTemplateList = unitMgr.getNoteTemplateMinList(noteTemplatePo);
		}
		
		request.setAttribute("fnpidpage", fnpid);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化短信模板新增
	 */
	public String initNoteTemplateInsert() throws Exception {

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
		
		noteTypeList = unitMgr.getNoteTemplateList();
		request.setAttribute("fnpidpage",Utility.getName(request.getParameter("fnpidpage")));
		
		return SUCCESS;
	}

	/**
	 * 短信模板新增
	 */
	public String noteTemplateInsert() throws Exception {

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

		noteTemplatePo.setBntid(UUIDHexGenerator.getInstance().generate());
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("1");    		// 表示状态
		logPo.setsLogContent("短信模板:" + noteTemplatePo.getBntid()+noteTemplatePo.getBntname() + "新增!");
		
		String[] throwType=request.getParameterValues("throwType");
		if(null!=throwType && throwType.length>0)
		{
			for(int i=0;i<throwType.length;i++)
			{
				if(throwType[i].equals("1"))
				{
					noteTemplatePo.setBntdaythrow("1");
				}
				if(throwType[i].equals("2"))
				{
					noteTemplatePo.setBntweekthrow("1");
				}
				if(throwType[i].equals("9"))
				{
					noteTemplatePo.setBntbiweeklythrow("1");
				}
				if(throwType[i].equals("3"))
				{
					noteTemplatePo.setBntmonththrow("1");
				}
				if(throwType[i].equals("4"))
				{
					noteTemplatePo.setBntseasonthrow("1");
				}
				if(throwType[i].equals("5"))
				{
					noteTemplatePo.setBnthalfyearthrow("1");
				}
				if(throwType[i].equals("6"))
				{
					noteTemplatePo.setBntyearthrow("1");
				}
				if(throwType[i].equals("7"))
				{
					noteTemplatePo.setBntrgpthrow("1");
				}
			}
		}

		unitMgr.insertNoteTemplate(noteTemplatePo, logPo);
		
		String url = "''noteTemplateSel.action?moduleID={0}&fnpid={1}''";
		List<String> params = new ArrayList<String>();
		params.add(moduleID);
		params.add(Utility.getName(noteTemplatePo.getBntname()));

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE3);

		return SUCCESS;
	}

	/**
	 * 初始化短信模板更新
	 */
	public String initNoteTemplateUpdate() throws Exception {
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

		noteTemplatePo = new NoteTemplatePo();
		noteTemplatePo.setBntid(Utility.getName(request.getParameter("hid")));		
		noteTemplatePo = unitMgr.getNoteTemplateDetail(noteTemplatePo);
		
		noteTypeList = unitMgr.getNoteTemplateList();
		
		request.setAttribute("fnpidpage",Utility.getName(request.getParameter("fnpidpage")));
		
		return SUCCESS;
	}
	
	/**
	 * 短信模板更新
	 */
	public String noteTemplateUpdate() throws Exception {
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
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("3");    		// 表示状态
		logPo.setsLogContent("短信模板:" + noteTemplatePo.getBntid()+noteTemplatePo.getBntname() + "修改!");
		
		String[] throwType=request.getParameterValues("throwType");
		if(null!=throwType && throwType.length>0)
		{
			for(int i=0;i<throwType.length;i++)
			{
				if(throwType[i].equals("1"))
				{
					noteTemplatePo.setBntdaythrow("1");
				}
				if(throwType[i].equals("2"))
				{
					noteTemplatePo.setBntweekthrow("1");
				}
				if(throwType[i].equals("9"))
				{
					noteTemplatePo.setBntbiweeklythrow("1");
				}
				if(throwType[i].equals("3"))
				{
					noteTemplatePo.setBntmonththrow("1");
				}
				if(throwType[i].equals("4"))
				{
					noteTemplatePo.setBntseasonthrow("1");
				}
				if(throwType[i].equals("5"))
				{
					noteTemplatePo.setBnthalfyearthrow("1");
				}
				if(throwType[i].equals("6"))
				{
					noteTemplatePo.setBntyearthrow("1");
				}
				if(throwType[i].equals("7"))
				{
					noteTemplatePo.setBntrgpthrow("1");
				}
			}
		}
		
		unitMgr.updateNoteTemplate(noteTemplatePo, logPo);
		
		String url = "''noteTemplateSel.action?moduleID={0}&fnpid={1}''";
		List<String> params = new ArrayList<String>();
		params.add(moduleID);
		params.add(Utility.getName(request.getParameter("fnpidpage")));

		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE3);

		return SUCCESS;
	}
	
	/**
	 * 初始化短信模板删除
	 */
	public String initNoteTemplateDelete()throws Exception{
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

		noteTemplatePo = new NoteTemplatePo();
		noteTemplatePo.setBntid(Utility.getName(request.getParameter("hid")));
		
		noteTemplatePo = unitMgr.getNoteTemplateDetail(noteTemplatePo);

		return SUCCESS;
	}
	
	/**
	 * 删除短信模板
	 */
	public String noteTemplateDelete()throws Exception{
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
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("2");    		// 表示状态
		logPo.setsLogContent("短信模板:" + noteTemplatePo.getBntid()+noteTemplatePo.getBntname() + "删除!");
		
		unitMgr.deleteNoteTemplate(noteTemplatePo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 设置自动和默认发送短信
	 */
	public String setNoteTemplateAutoSend() throws Exception{
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
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("3");    		// 表示状态

	    String flag = Utility.getName(request.getParameter("flag"));
	    
	    noteTemplatePo = new NoteTemplatePo();
	    if (flag.equals("1")){
	    	logPo.setsLogContent("设置自动发送短信!");
	    	noteTemplatePo.setBnttypename(Utility.getName(request.getParameter("name")));
	    	noteTemplatePo.setBnttypeautosend(Utility.getName(request.getParameter("isauto")));
	    	
	    	unitMgr.updateNoteTemplateAutoSend(noteTemplatePo, logPo);
	    }else if (flag.equals("2")){
	    	logPo.setsLogContent("设置默认发送短信!");
	    	noteTemplatePo.setBntid(Utility.getName(request.getParameter("name")));
	    	noteTemplatePo.setBntautosend(Utility.getName(request.getParameter("isauto")));
	    	noteTemplatePo.setBntname(Utility.getName(request.getParameter("bntname")));  
	    	
	    	unitMgr.updateNoteTemplate(noteTemplatePo, logPo);
	    }
	    
		String fnpid=Utility.getName(request.getParameter("fnpid"));
		noteTypeList = unitMgr.getNoteTemplateList();
		
		if(!fnpid.equals("")){
			noteTemplatePo =  new NoteTemplatePo();
			noteTemplatePo.setBntname(fnpid);
			noteTemplateList = unitMgr.getNoteTemplateMinList(noteTemplatePo);
		}
		
		request.setAttribute("fnpidpage", fnpid);
		
		return SUCCESS;
	}
	/**
	 * 短信模板预览
	 */
	public String initNoteTemplatePreview()throws Exception{
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
	
	public UnitPo getUnitPo() {
		return unitPo;
	}

	public void setUnitPo(UnitPo unitPo) {
		this.unitPo = unitPo;
	}

	public List<UnitPo> getList() {
		return list;
	}

	public void setList(List<UnitPo> list) {
		this.list = list;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}
	public ComplaintsTypePo getComplaintsTypePo() {
		return complaintsTypePo;
	}
	public void setComplaintsTypePo(ComplaintsTypePo complaintsTypePo) {
		this.complaintsTypePo = complaintsTypePo;
	}
	public ForeignRecipelPo getForeignRecipelPo() {
		return foreignRecipelPo;
	}
	public void setForeignRecipelPo(ForeignRecipelPo foreignRecipelPo) {
		this.foreignRecipelPo = foreignRecipelPo;
	}
	public RefractiveSetPo getRefractivePo() {
		return refractivePo;
	}
	public void setRefractivePo(RefractiveSetPo refractivePo) {
		this.refractivePo = refractivePo;
	}
	public NoteTemplatePo getNoteTemplatePo() {
		return noteTemplatePo;
	}
	public void setNoteTemplatePo(NoteTemplatePo noteTemplatePo) {
		this.noteTemplatePo = noteTemplatePo;
	}
	public List<ComplaintsTypePo> getComplaintsTypeList() {
		return complaintsTypeList;
	}
	public void setComplaintsTypeList(List<ComplaintsTypePo> complaintsTypeList) {
		this.complaintsTypeList = complaintsTypeList;
	}
	public List<ForeignRecipelPo> getForeignRecipelList() {
		return foreignRecipelList;
	}
	public void setForeignRecipelList(List<ForeignRecipelPo> foreignRecipelList) {
		this.foreignRecipelList = foreignRecipelList;
	}
	public List<RefractiveSetPo> getRefractiveSetList() {
		return refractiveSetList;
	}
	public void setRefractiveSetList(List<RefractiveSetPo> refractiveSetList) {
		this.refractiveSetList = refractiveSetList;
	}
	public List<NoteTemplatePo> getNoteTemplateList() {
		return noteTemplateList;
	}
	public void setNoteTemplateList(List<NoteTemplatePo> noteTemplateList) {
		this.noteTemplateList = noteTemplateList;
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
