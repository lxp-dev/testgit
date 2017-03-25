package com.pengsheng.eims.sales.action;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.GlassesHistoryMgr;
import com.pengsheng.eims.sales.persistence.HisInfoPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class OldGlassCheckAction extends BaseAction{
	
	private PersonPermissionMgr personPermissionMgr;
	private GlassesHistoryMgr glassesHistoryMgr;
	private HisInfoPo hisInfoPo;
	private CustomerInfoPo customerInfoPo;
	private CustomerInfoMgr customerInfoMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
	public String initOldGlassCheckInsert() throws Exception {

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

		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			
			//年龄
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmdown(Integer.toString(age));
			}
			
		}
		
		return SUCCESS;
	}
	
	public String oldGlassCheckInsert() throws Exception {

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
		
		HisInfoPo po = new HisInfoPo();
		String customerID = Utility.getName(request.getParameter("customerID"));
		po.setSophifcustomerid(customerID);
		
		customerInfoPo.setSmecimemberid(request.getParameter("customerInfoPo.smecimemberid"));
		
		HisInfoPo ispo = new HisInfoPo();
		ispo = glassesHistoryMgr.selectGlassesHistory(po);
		if("".equals(Utility.getName(ispo.getSophifcustomerid()))){
			hisInfoPo.setSophifcustomerid(customerID);
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 模块ID
			logPo.setsLogOpID("1");    // 新增
			logPo.setsLogContent("旧镜检查管理会员卡号："+customerInfoPo.getSmecimemberid()+" 新增");
			
			glassesHistoryMgr.insertGlassesHistory(hisInfoPo,logPo);
		}else{
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 模块ID
			logPo.setsLogOpID("3");    // 新增
			logPo.setsLogContent("旧镜检查管理会员卡号："+customerInfoPo.getSmecimemberid()+" 修改");
			
			hisInfoPo.setSophifcustomerid(customerID);
			glassesHistoryMgr.updateGlassesHistory(hisInfoPo,logPo);
		}
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.save.sucess"));
		
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	

	public GlassesHistoryMgr getGlassesHistoryMgr() {
		return glassesHistoryMgr;
	}

	public void setGlassesHistoryMgr(GlassesHistoryMgr glassesHistoryMgr) {
		this.glassesHistoryMgr = glassesHistoryMgr;
	}

	public HisInfoPo getHisInfoPo() {
		return hisInfoPo;
	}

	public void setHisInfoPo(HisInfoPo hisInfoPo) {
		this.hisInfoPo = hisInfoPo;
	}
	
	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
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
