package com.pengsheng.eims.sales.action;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.PrintPrescriptionMgr;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class PrintPrescriptionAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;	
	private FittingTemplateTypeMgr fittingTemplateTypeMgr = null;	
	private List<InspectionPo> inspectionPoList;
	private InspectionPo inspectionPo;
	private CustomerInfoPo customerInfoPo;
	private CustomerInfoMgr customerInfoMgr;
	private PrintPrescriptionMgr printPrescriptionMgr;
	private OptometryBasicPo optometryBasicPo;	
	private String readOnly;	
	private SystemParameterPo systemParameterPo;
	
	/**
	 * 初始化打印处方
	 */
	public String initPrintPrescriptionSel() throws Exception {
		
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		
		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			
		}
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
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
	 * 查看打印处方信息
	 */
	public String selectPrintPrescription() throws Exception {
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
		
		/**
		 * 扫描卡号得会员信息
		 */
		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);

			if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
				String smecicustomerid = Utility.getName(customerInfoPo
						.getSmecicustomerid());
				inspectionPoList = printPrescriptionMgr
						.getInspectionPos(smecicustomerid);
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
		
		//获得打印结算单信息----------------------------
		String actionTypeID = "44";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------
		
		return SUCCESS;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public InspectionPo getInspectionPo() {
		return inspectionPo;
	}

	public void setInspectionPo(InspectionPo inspectionPo) {
		this.inspectionPo = inspectionPo;
	}

	public List<InspectionPo> getInspectionPoList() {
		return inspectionPoList;
	}

	public void setInspectionPoList(List<InspectionPo> inspectionPoList) {
		this.inspectionPoList = inspectionPoList;
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

	public PrintPrescriptionMgr getPrintPrescriptionMgr() {
		return printPrescriptionMgr;
	}

	public void setPrintPrescriptionMgr(
			PrintPrescriptionMgr printPrescriptionMgr) {
		this.printPrescriptionMgr = printPrescriptionMgr;
	}

	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	public OptometryBasicPo getOptometryBasicPo() {
		return optometryBasicPo;
	}

	public void setOptometryBasicPo(OptometryBasicPo optometryBasicPo) {
		this.optometryBasicPo = optometryBasicPo;
	}

	private OptometryPo optometryPo;

	public OptometryPo getOptometryPo() {
		return optometryPo;
	}

	public void setOptometryPo(OptometryPo optometryPo) {
		this.optometryPo = optometryPo;
	}

	public FittingTemplateTypeMgr getFittingTemplateTypeMgr() {
		return fittingTemplateTypeMgr;
	}

	public void setFittingTemplateTypeMgr(
			FittingTemplateTypeMgr fittingTemplateTypeMgr) {
		this.fittingTemplateTypeMgr = fittingTemplateTypeMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}
	
}
