package com.pengsheng.eims.basic.action;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import java.util.List;

public class SetGoodsNameAction extends BaseAction {
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	
	private SystemParameterPo systemParameterPo;
	private List<DepartmentsPo> departmentsPos;

	/**
	 * 加载设置商品名称显示样式
	 * @return
	 */
	public String initSetGoodsName() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		departmentsPos = systemParameterMgr.selectDepartmentsPoForWhichretail();
		
		return SUCCESS;
	}
	
	/**
	 * 插入设置商品名称显示样式
	 * @return
	 */
	public String insertSetGoodsName() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		this.clearMessages();
		
		SystemParameterPo po = new SystemParameterPo();		
		po = systemParameterMgr.getSystemParameterPo();
		
		//复制商品名称显示设置
		systemParameterPo = copySaveAttr(po, systemParameterPo);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		
		if(Utility.getName(po.getFspuuid()) != ""){
			logPo.setsLogOpID("2");    // 表示状态
			logPo.setsLogContent("修改显示商品名称!");

			systemParameterMgr.updateGoodsViewName(systemParameterPo,logPo);
			this.addActionMessage("更新成功！");
		}else{
			this.addActionMessage("更新失败，请先设置系统参数设定！");
		}

		request.setAttribute("url", "'initSetGoodsName.action?moduleID="+moduleID+"'");		
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	/**
	 * 复制需要保存属性到目标对象
	 * @param descPo 目标对象
	 * @param resPo 源对象
	 */
	private SystemParameterPo copySaveAttr(SystemParameterPo descPo, SystemParameterPo resPo) {
		
		if(null != resPo && null != descPo) {
			//镜架商品名称
			descPo.setFspcjj(resPo.getFspcjj());
			//配件商品名称
			descPo.setFspcpj(resPo.getFspcpj());
			//镜片商品名称
			descPo.setFspcjp(resPo.getFspcjp());
			//隐形镜片商品名称
			descPo.setFspcyxjp(resPo.getFspcyxjp());
			//护理液类商品名称
			descPo.setFspchly(resPo.getFspchly());
			//太阳镜商品名称
			descPo.setFspctyj(resPo.getFspctyj());
			//耗材商品名称
			descPo.setFspchc(resPo.getFspchc());
			//老花镜商品名称
			descPo.setFspclh(resPo.getFspclh());
			//视光商品名称
			descPo.setFspcsg(resPo.getFspcsg());
		}
		return descPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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

	public List<DepartmentsPo> getDepartmentsPos() {
		return departmentsPos;
	}

	public void setDepartmentsPos(List<DepartmentsPo> departmentsPos) {
		this.departmentsPos = departmentsPos;
	}
}
