package com.pengsheng.eims.basic.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class WarehouseAction extends BaseAction{

	private PersonPermissionMgr personPermissionMgr;	
	private WarehousePo warehousePo;
	private DepartmentsMgr departmentsMgr;
	private List<WarehousePo> list; // 门店列表List
	private List<DepartmentsPo> departmentsList; // 部门List
	private WarehouseMgr warehouseMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;

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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	/**
	 * 初始化仓位查询
	 */
	public String initWarehouseSel() throws Exception {
		
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

		// 取得部门List
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selWarehouse";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询仓位列表
	 */
	public String selWarehouse() throws Exception {
		
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
		String bwhid = Utility.getName(request.getParameter("bwhid"));
		String bwhwarehouseName = Utility.getName(request.getParameter("bwhwarehouseName"));
		String bwhdeptid = Utility.getName(request.getParameter("bwhdeptid"));
		String bwhisclosed = Utility.getName(request.getParameter("bwhisclosed"));
		
		// 取得部门List
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(deppo);

		// 取得查询结果仓位List Begin
		warehousePo = new WarehousePo();
		warehousePo.setBwhid(bwhid);
		warehousePo.setBwhwarehouseName(bwhwarehouseName);
		warehousePo.setBwhdeptid(bwhdeptid);
		warehousePo.setBwhisclosed(bwhisclosed);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
		}
		
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
		
		int count = warehouseMgr.getWarehouseCount(warehousePo);
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
			list = warehouseMgr.getWarehouseList(warehousePo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			list = null;
		}	

		request.setAttribute("bwhidpage", bwhid);
		request.setAttribute("bwhwarehouseNamepage", bwhwarehouseName);
		request.setAttribute("bwhdeptidpage", bwhdeptid);
		request.setAttribute("bwhisclosedpage", bwhisclosed);

		return SUCCESS;
	}

	/**
	 * 初始化仓位新增
	 */
	public String initInsertWarehouse() throws Exception {
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
		warehousePo = new WarehousePo();
		
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		request.setAttribute("departmentID",departmentID);
		
		// 取得部门List
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpisalldepartments("all");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsPo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(departmentsPo);

		return SUCCESS;
	}

	/**
	 * 仓位新增
	 */
	public String insertWarehouse() throws Exception {
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
		WarehousePo temp = new WarehousePo();
		temp.setBwhid(warehousePo.getBwhid());
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("仓位:" + warehousePo.getBwhid() + "新增!");
		
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		request.setAttribute("departmentID",departmentID);

		// 取得部门List
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpisalldepartments("all");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsPo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		departmentsList = departmentsMgr.getDepartments(departmentsPo);
		
		this.clearMessages();
		if (!"".equals(Utility.getName(warehouseMgr.getWarehouse(temp).getBwhid()))) 
		{
			
			this.addActionMessage(getText("仓位编码重复!"));						
			return "error";			

		}
		
		if ("".equals(Utility.getName(warehousePo.getBwhdeptid()))){
			warehousePo.setBwhdeptid(departmentID);
		}
		DepartmentsPo dpp=new DepartmentsPo();
		dpp.setBdpdepartmentid(warehousePo.getBwhdeptid());
		DepartmentsPo depart=departmentsMgr.getDepartment(dpp);
		int flagName=warehouseMgr.getWarehouseName(warehousePo);
		int flagDept=warehouseMgr.getWarehouseDept(depart);
		if(flagName>0)
		{
			this.addActionMessage(getText("仓位名称重复!"));			
			return "error";
		}
		if(flagDept>0)
		{			
			this.addActionMessage(getText("除了总仓库房类型的部门只能有一个仓位!"));
									
			return "error";
		}
		
		warehouseMgr.insertWarehouse(warehousePo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化仓位更新
	 */
	public String initUpdateWarehouse() throws Exception {
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
		// 页面参数：仓位Id
		String bwhid=Utility.getName(request.getParameter("hid"));
		
		//根据仓位Id查询仓位对象
		warehousePo = new WarehousePo();
		warehousePo.setBwhid(bwhid);
		warehousePo=warehouseMgr.getWarehouse(warehousePo);

		String departmentID = Utility.getName(request.getParameter("departmentID"));
		request.setAttribute("departmentID",departmentID);
		
		return SUCCESS;
	}
	
	/**
	 * 仓位更新
	 */
	public String updateWarehouse() throws Exception {
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
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("仓位:" + warehousePo.getBwhid() +"修改!");
		this.clearMessages();
		
		DepartmentsPo dpp=new DepartmentsPo();
		dpp.setBdpdepartmentid(warehousePo.getBwhdeptid());
		DepartmentsPo depart=departmentsMgr.getDepartment(dpp);
		int flagName=warehouseMgr.getWarehouseNameUpdate(warehousePo);
		int flagDept=warehouseMgr.getWarehouseDeptUpdate(depart,warehousePo.getBwhid());
		if(flagName>0)
		{
			// 取得部门List
			departmentsList = departmentsMgr.getDepartments();
			this.addActionMessage(getText("仓位名称重复!"));

			return "error";
		}
		if(flagDept>0)
		{	
			// 取得部门List
			departmentsList = departmentsMgr.getDepartments();		
			this.addActionMessage(getText("除了总仓库房类型的部门只能有一个仓位!"));			
			return "error";
		}
		
		
		warehouseMgr.updateWarehouse(warehousePo,logPo);				
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化仓位删除
	 */
	public String initDeleteWarehouse()throws Exception{
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
		// 页面参数：仓位Id
		String bwhid=Utility.getName(request.getParameter("hid"));
		
		//根据仓位Id查询仓位对象
		warehousePo = new WarehousePo();
		warehousePo.setBwhid(bwhid);
		warehousePo=warehouseMgr.getWarehouse(warehousePo);

		return SUCCESS;
	}
	
	/**
	 * 删除仓位
	 */
	public String deleteWarehouse()throws Exception{
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
		// 页面参数：仓位Id
		String bwhid=Utility.getName(request.getParameter("hid"));		
		warehousePo = new WarehousePo();
		warehousePo.setBwhid(bwhid);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("仓位:" + warehousePo.getBwhid() +"删除!");
		
		int count=warehouseMgr.getWareHouseCountForDel(warehousePo);
		if(count != 0){
			this.clearMessages();
			this.addActionMessage(getText("warehouse.delete.error"));
			request.setAttribute("flag",GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}
		warehouseMgr.deleteWarehouse(warehousePo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化仓位停用启用
	 */
	public String initWarehouseAble()throws Exception{
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

		String bwhid=Utility.getName(request.getParameter("bwhid"));		
		String bwhname=Utility.getName(request.getParameter("bwhname"));
		String flag=Utility.getName(request.getParameter("flag"));
		
		request.setAttribute("bwhid",bwhid);
		request.setAttribute("bwhname",bwhname);
		request.setAttribute("flag",flag);

		return SUCCESS;
	}
	
	/**
	 * 仓位停用启用
	 */
	public String updateWarehouseAble()throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		/** ********************** 权限设置 ***************************** */
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		if (Utility.getName(warehousePo.getBwhisclosed()).equals("1")){
			logPo.setsLogOpID("39");    // 表示状态  39 停用  38 启用
			logPo.setsLogContent("仓位:" + warehousePo.getBwhid() +"停用!");
		}else{
			logPo.setsLogOpID("38");    // 表示状态  39 停用  38 启用
			logPo.setsLogContent("仓位:" + warehousePo.getBwhid() +"启用!");
		}
		
		warehouseMgr.updateWarehouseAble(warehousePo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public WarehousePo getWarehousePo() {
		return warehousePo;
	}

	public void setWarehousePo(WarehousePo warehousePo) {
		this.warehousePo = warehousePo;
	}

	public List<WarehousePo> getList() {
		return list;
	}

	public void setList(List<WarehousePo> list) {
		this.list = list;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

}
