package com.pengsheng.eims.sales.action;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.PrintRegistrationMgr;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class PrintRegistrationAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;	
	private RegisteredDetailsPo registeredDetailsPo;	
	private List<RegisteredDetailsPo> registeredDetailsPosList;	
	private CustomerInfoPo customerInfoPo;
	private CustomerInfoMgr customerInfoMgr;	
	private PrintRegistrationMgr printRegistrationMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;	
	
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public PrintRegistrationMgr getPrintRegistrationMgr() {
		return printRegistrationMgr;
	}

	public void setPrintRegistrationMgr(PrintRegistrationMgr printRegistrationMgr) {
		this.printRegistrationMgr = printRegistrationMgr;
	}

	public RegisteredDetailsPo getRegisteredDetailsPo() {
		return registeredDetailsPo;
	}

	public void setRegisteredDetailsPo(RegisteredDetailsPo registeredDetailsPo) {
		this.registeredDetailsPo = registeredDetailsPo;
	}

	public List<RegisteredDetailsPo> getRegisteredDetailsPosList() {
		return registeredDetailsPosList;
	}

	public void setRegisteredDetailsPosList(
			List<RegisteredDetailsPo> registeredDetailsPosList) {
		this.registeredDetailsPosList = registeredDetailsPosList;
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


	/**
	 * 初始化打印挂号单
	 */
	public String initPrintRegistrationSel() throws Exception {

		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
		}
		
		//判断跳转哪个界面
		String isGO = Utility.getName(request.getParameter("isGO"));
		if("".equals(isGO)){
		if("2".equals(systemParameterPo.getFsphisflag())){//系统连接HIS
			
			if("0".equals(personInfoPo.getBdplinkhisflag())&&"initSCIHISsaomaWin.action".equals(personInfoPo.getBdpreadcardform())){
				request.setAttribute("isGO","0");//现有是界面
			}else{
				request.setAttribute("isGO","1");//读卡扫码界面
			}
		}else if("0".equals(systemParameterPo.getFsphisflag())){//系统不连接HIS
			
			 if("initSCIHISsaomaWin.action".equals(personInfoPo.getBdpreadcardform())){
				 request.setAttribute("isGO","0");//现有是界面
			 }else{
				 request.setAttribute("isGO","1");//读卡界面
			 }
		}
		}
		return SUCCESS;
	}
	
	/**
	 * 查看打印挂号单信息
	 */
	public String selectPrintRegistration() throws Exception {
		
		/**
		 * 扫描卡号得会员信息
		 */
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
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,personInfoPo.getDepartmentID());
		
		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
				RegisteredDetailsPo registered =new RegisteredDetailsPo();
				registered.setScrrdcustomerid(customerInfoPo.getSmecicustomerid());
				registered.setScrrdshopcode(((PersonInfoPo)session.get("person")).getDepartmentID());
				registeredDetailsPosList = printRegistrationMgr.getRegisteredDetailsPos(registered);
			}
			//年龄
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmdown(Integer.toString(age));
			}
			
		}
		request.setAttribute("departmentID", personInfoPo.getDepartmentID());
		return SUCCESS;
	}
}
