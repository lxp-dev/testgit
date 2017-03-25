package com.pengsheng.eims.basic.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
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

public class WarehouseConfigurationAction extends BaseAction {
	
	private WarehousePo warehousePo;	
	private WarehouseMgr warehouseMgr;
	private PersonPermissionMgr personPermissionMgr;
	private WarehouseConfigurationMgr warehouseConfigurationMgr;	
	private WarehouseConfigurationPo warehouseConfigurationPo;
	private WarehouseConfigurationPo inWarehouseConfigurationPo;	
	private List<WarehouseConfigurationPo> warehouseConfigurationList;
	private List<WarehousePo> warehouseList;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
	public WarehouseConfigurationPo getInWarehouseConfigurationPo() {
		return inWarehouseConfigurationPo;
	}
	public void setInWarehouseConfigurationPo(
			WarehouseConfigurationPo inWarehouseConfigurationPo) {
		this.inWarehouseConfigurationPo = inWarehouseConfigurationPo;
	}
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	public WarehousePo getWarehousePo() {
		return warehousePo;
	}
	public void setWarehousePo(WarehousePo warehousePo) {
		this.warehousePo = warehousePo;
	}	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}
	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}
	
	/**
	 * 门店出仓配置查询
	 */
	public String selWarehouseConfiguration()throws Exception{
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
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}

		int count = warehouseConfigurationMgr.getWarehouseConfigurationsCount(deppo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			warehouseConfigurationList = warehouseConfigurationMgr.getWarehouseConfigurationsList(deppo,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
			
		} else {			
			warehouseConfigurationList = null;		
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化门店出仓配置
	 */
	public String initWarehouseConfigurationUpdate()throws Exception{
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
		
		String id=Utility.getName(request.getParameter("hid"));
		
		warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(id);
		
		inWarehouseConfigurationPo = new WarehouseConfigurationPo();
		inWarehouseConfigurationPo.setBwcdeptid(id);
		
		warehousePo = new WarehousePo();
		warehousePo.setBwhdeptid(Utility.getName(id));			
		warehousePo = warehouseMgr.getWarehouse(warehousePo);
		
		WarehousePo warehousePo1 = warehouseMgr.getWarehousebwhid();
		request.setAttribute("warehousePo1", warehousePo1);
		
		warehouseConfigurationPo = warehouseConfigurationMgr.getWarehouseConfiguration(warehouseConfigurationPo);
		inWarehouseConfigurationPo = warehouseConfigurationMgr.getInWarehouseConfiguration(inWarehouseConfigurationPo);
		
		warehouseList=warehouseConfigurationMgr.getWarehouseList();
		
		request.setAttribute("hid", id);
		
		return SUCCESS;
	}
	/**
	 * 门店出仓配置
	 */
	public String updateWarehouseConfiguration()throws Exception{
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
		
		int count=warehouseConfigurationMgr.getWarehouseConfigurationCount(warehouseConfigurationPo);
		
		this.clearMessages();
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		
		if(count>0){
			logPo.setsLogOpID("3");
			logPo.setsLogContent("门店仓位配置:" + warehouseConfigurationPo.getBwcdeptid() +"修改!");
			warehouseConfigurationMgr.updateWarehouseConfiguration(warehouseConfigurationPo,inWarehouseConfigurationPo,logPo);
			this.addActionMessage(getText("struts.messages.update.sucess"));
		}else{
			logPo.setsLogOpID("1");
			logPo.setsLogContent("门店仓位配置:" + warehouseConfigurationPo.getBwcdeptid() +"新增!");
			warehouseConfigurationMgr.insertWarehouseConfiguration(warehouseConfigurationPo,inWarehouseConfigurationPo,logPo);
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		}
		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}
	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
	}
	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}
	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
	}
	public List<WarehouseConfigurationPo> getWarehouseConfigurationList() {
		return warehouseConfigurationList;
	}
	public void setWarehouseConfigurationList(
			List<WarehouseConfigurationPo> warehouseConfigurationList) {
		this.warehouseConfigurationList = warehouseConfigurationList;
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
