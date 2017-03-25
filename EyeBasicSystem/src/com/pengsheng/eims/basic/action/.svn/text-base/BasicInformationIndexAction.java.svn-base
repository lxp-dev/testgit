package com.pengsheng.eims.basic.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.mgr.FrameSalesMgr;
import com.pengsheng.eims.sales.persistence.SalesRecipeNumViewPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class BasicInformationIndexAction extends BaseAction{
	
	private PersonPermissionMgr personPermissionMgr;
	private FrameSalesMgr frameSalesMgr;
	private SalesRecipeNumViewPo salesRecipeNumViewPo;
	
	public String initBasicinformationindex() throws Exception {
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
	
	public String initBasicinformationLeft() throws Exception {
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
	
	public String initBasicinformationRight() throws Exception {
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
	 * 初始化销售页面显示处方数量
	 */	
	public String initSalesRecipeNumView() throws Exception {
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
		
		List<SalesRecipeNumViewPo> spoList = frameSalesMgr.getSalesRecipeNumViewList();
		salesRecipeNumViewPo = new SalesRecipeNumViewPo();
		
		for (SalesRecipeNumViewPo spo : spoList){
			if (Utility.getName(spo.getBrnid()).equals("1")){
				salesRecipeNumViewPo.setBrnnum1(Utility.getName(spo.getBrnnum()));
				continue;
			}
			if (Utility.getName(spo.getBrnid()).equals("2")){
				salesRecipeNumViewPo.setBrnnum2(Utility.getName(spo.getBrnnum()));
				continue;
			}
			if (Utility.getName(spo.getBrnid()).equals("3")){
				salesRecipeNumViewPo.setBrnnum3(Utility.getName(spo.getBrnnum()));
				continue;
			}
			if (Utility.getName(spo.getBrnid()).equals("4")){
				salesRecipeNumViewPo.setBrnnum4(Utility.getName(spo.getBrnnum()));
				continue;
			}
			if (Utility.getName(spo.getBrnid()).equals("5")){
				salesRecipeNumViewPo.setBrnnum5(Utility.getName(spo.getBrnnum()));
				continue;
			}
			if (Utility.getName(spo.getBrnid()).equals("6")){
				salesRecipeNumViewPo.setBrnnum6(Utility.getName(spo.getBrnnum()));
				continue;
			}
			if (Utility.getName(spo.getBrnid()).equals("7")){
				salesRecipeNumViewPo.setBrnnum7(Utility.getName(spo.getBrnnum()));
				continue;
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * 销售页面显示处方数量
	 */	
	public String updateSalesRecipeNumView() throws Exception {
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
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("修改销售页面显示的处方数量");
		
		List<SalesRecipeNumViewPo> spoList = new ArrayList<SalesRecipeNumViewPo>();
		
		SalesRecipeNumViewPo po1 = new SalesRecipeNumViewPo();
		po1.setBrnid("1");
		po1.setBrnnum(Utility.getName(salesRecipeNumViewPo.getBrnnum1()).equals("") ? "0" : Utility.getName(salesRecipeNumViewPo.getBrnnum1()));
		
		SalesRecipeNumViewPo po2 = new SalesRecipeNumViewPo();
		po2.setBrnid("2");
		po2.setBrnnum(Utility.getName(salesRecipeNumViewPo.getBrnnum2()).equals("") ? "0" : Utility.getName(salesRecipeNumViewPo.getBrnnum2()));
		
		SalesRecipeNumViewPo po3 = new SalesRecipeNumViewPo();
		po3.setBrnid("3");
		po3.setBrnnum(Utility.getName(salesRecipeNumViewPo.getBrnnum3()).equals("") ? "0" : Utility.getName(salesRecipeNumViewPo.getBrnnum3()));
		
		SalesRecipeNumViewPo po4 = new SalesRecipeNumViewPo();
		po4.setBrnid("4");
		po4.setBrnnum(Utility.getName(salesRecipeNumViewPo.getBrnnum4()).equals("") ? "0" : Utility.getName(salesRecipeNumViewPo.getBrnnum4()));
		
		SalesRecipeNumViewPo po5 = new SalesRecipeNumViewPo();
		po5.setBrnid("5");
		po5.setBrnnum(Utility.getName(salesRecipeNumViewPo.getBrnnum5()).equals("") ? "0" : Utility.getName(salesRecipeNumViewPo.getBrnnum5()));
		
		SalesRecipeNumViewPo po6 = new SalesRecipeNumViewPo();
		po6.setBrnid("6");
		po6.setBrnnum(Utility.getName(salesRecipeNumViewPo.getBrnnum6()).equals("") ? "0" : Utility.getName(salesRecipeNumViewPo.getBrnnum6()));
		
		SalesRecipeNumViewPo po7 = new SalesRecipeNumViewPo();
		po7.setBrnid("7");
		po7.setBrnnum(Utility.getName(salesRecipeNumViewPo.getBrnnum7()).equals("") ? "0" : Utility.getName(salesRecipeNumViewPo.getBrnnum7()));
		
		spoList.add(po1);
		spoList.add(po2);
		spoList.add(po3);
		spoList.add(po4);
		spoList.add(po5);
		spoList.add(po6);
		spoList.add(po7);
		
		frameSalesMgr.updateSalesRecipeNumView(spoList, logPo);
		
		this.addActionMessage(getText("struts.messages.save.sucess"));		
		String url = "''initSalesRecipeNumView.action?moduleID={0}''";
		List<String> params = new ArrayList<String>();
		params.add(moduleID);		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE6);
		
		return SUCCESS;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public FrameSalesMgr getFrameSalesMgr() {
		return frameSalesMgr;
	}

	public void setFrameSalesMgr(FrameSalesMgr frameSalesMgr) {
		this.frameSalesMgr = frameSalesMgr;
	}

	public SalesRecipeNumViewPo getSalesRecipeNumViewPo() {
		return salesRecipeNumViewPo;
	}

	public void setSalesRecipeNumViewPo(SalesRecipeNumViewPo salesRecipeNumViewPo) {
		this.salesRecipeNumViewPo = salesRecipeNumViewPo;
	}
	
	
}
