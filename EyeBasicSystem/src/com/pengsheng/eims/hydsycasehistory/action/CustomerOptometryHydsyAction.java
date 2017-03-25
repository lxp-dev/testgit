/**
 * 
 */
package com.pengsheng.eims.hydsycasehistory.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.hydsycasehistory.mgr.CustomerOptometryHydsyMgr;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.hydsycasehistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.hydsycasehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;

import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class CustomerOptometryHydsyAction extends BaseAction {

	private CustomerInfoMgr customerInfoMgr;

	private CustomerOptometryHydsyMgr customerOptometryHydsyMgr;

	private CustomerInfoPo customerInfoPo;

	private OptometryPo optometryPo;

	private String readOnly;

	private DoubleEyeFunPo doubleEyeFunPo;

	public DoubleEyeFunPo getDoubleEyeFunPo() {
		return doubleEyeFunPo;
	}

	public void setDoubleEyeFunPo(DoubleEyeFunPo doubleEyeFunPo) {
		this.doubleEyeFunPo = doubleEyeFunPo;
	}

	private HealthCheckPo healthCheckPo;

	public HealthCheckPo getHealthCheckPo() {
		return healthCheckPo;
	}

	public void setHealthCheckPo(HealthCheckPo healthCheckPo) {
		this.healthCheckPo = healthCheckPo;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public CustomerOptometryHydsyMgr getCustomerOptometryHydsyMgr() {
		return customerOptometryHydsyMgr;
	}

	public void setCustomerOptometryHydsyMgr(
			CustomerOptometryHydsyMgr customerOptometryHydsyMgr) {
		this.customerOptometryHydsyMgr = customerOptometryHydsyMgr;
	}
	
	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public OptometryPo getOptometryPo() {
		return optometryPo;
	}

	public void setOptometryPo(OptometryPo optometryPo) {
		this.optometryPo = optometryPo;
	}

	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}
	
	private PersonPermissionMgr personPermissionMgr;

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public String initCustomerOptometryTitleN() {
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
		
		String optometryID_title = request.getParameter("optometryID");
		optometryPo = customerOptometryHydsyMgr.getOptometryPo(optometryID_title);

		request.setAttribute("readOnly", readOnly);
		
		if (customerInfoPo == null){
			customerInfoPo = new CustomerInfoPo();
		}

		String isfresh = Utility.getName(request.getParameter("isfresh"));
		if (StringUtils.isEmpty(optometryPo.getSopoyoptometryid())||!isfresh.equals(Utility.getName(customerInfoPo.getSmecimemberid()))) {
			// 生成新验光号
			PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");

			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			// 生成验光号
			String numHead = "Y" + personInfoPo.getDepartmentID()
					+ personInfoPo.getMachinery() + format.format(new Date());
			optometryPo = new OptometryPo();
			if (request.getParameter("optometryID") != null && isfresh.equals(customerInfoPo.getSmecimemberid())) {
				optometryPo.setSopoyoptometryid(optometryID_title);
			} else {
				optometryPo.setSopoyoptometryid(numHead);
			}
			optometryPo.setSopoypersonname(personInfoPo.getPersonName());
			optometryPo.setSopoypersonid(personInfoPo.getId());
			optometryPo.setSopoytime(format1.format(new Date()));
		}

		/**
		 * 扫描卡号得会员信息
		 */
		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			if(customerInfoPo.getSmecimemberid().split(",").length>1){
				customerInfoPo.setSmecimemberid(customerInfoPo.getSmecimemberid()
						.split(",")[1].trim());
			}else{
				customerInfoPo.setSmecimemberid(customerInfoPo.getSmecimemberid()
					.split(",")[0].trim());
			}
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo.setSmeciflag("1");
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}


		}else{
			if (!Utility.getName(request.getParameter("customerID")).equals("")) {				
				CustomerInfoPo tempCustomerInfoPo = new CustomerInfoPo();
				tempCustomerInfoPo.setSmecicustomerid(Utility.getName(request.getParameter("customerID")));
				customerInfoPo = customerInfoMgr.getCustomerInfo(tempCustomerInfoPo);
				
				if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
					String birthdayYear = customerInfoPo.getSmecibirthday().substring(0, 4);
					int age = Calendar.getInstance().get(Calendar.YEAR)	- Integer.parseInt(birthdayYear);
					customerInfoPo.setFmmage(Integer.toString(age));
				}
			}
		}
		
		return SUCCESS;
	}
}
