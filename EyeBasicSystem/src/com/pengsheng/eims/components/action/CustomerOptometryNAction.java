/**
 * 
 */
package com.pengsheng.eims.components.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.components.mgr.CustomerOptometryNMgr;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.casehistory.mgr.RefractiveNMgr;
import com.pengsheng.eims.casehistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.casehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.casehistory.persistence.RefractivePo;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class CustomerOptometryNAction extends BaseAction {

	private CustomerInfoMgr customerInfoMgr;

	private CustomerOptometryNMgr customerOptometryNMgr;

	private CustomerInfoPo customerInfoPo;

	private OptometryPo optometryPo;

	private String readOnly;

	private DoubleEyeFunPo doubleEyeFunPo;
	
	private SystemParameterPo systemParameterPo;
	
	private List<PersonInfoPo> optometryPersonInfoPos;
	
	private PersonInfoMgr personInfoMgr;
	private RefractivePo refractivePo;
	private RefractiveNMgr refractiveNMgr;
	
	public RefractivePo getRefractivePo() {
		return refractivePo;
	}

	public void setRefractivePo(RefractivePo refractivePo) {
		this.refractivePo = refractivePo;
	}

	public RefractiveNMgr getRefractiveNMgr() {
		return refractiveNMgr;
	}

	public void setRefractiveNMgr(RefractiveNMgr refractiveNMgr) {
		this.refractiveNMgr = refractiveNMgr;
	}

	public List<PersonInfoPo> getOptometryPersonInfoPos() {
		return optometryPersonInfoPos;
	}

	public void setOptometryPersonInfoPos(List<PersonInfoPo> optometryPersonInfoPos) {
		this.optometryPersonInfoPos = optometryPersonInfoPos;
	}

	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

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

	public CustomerOptometryNMgr getCustomerOptometryNMgr() {
		return customerOptometryNMgr;
	}

	public void setCustomerOptometryNMgr(CustomerOptometryNMgr customerOptometryNMgr) {
		this.customerOptometryNMgr = customerOptometryNMgr;
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
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		optometryPersonInfoPos = personInfoMgr.getPersoninfoPoListByJobType("3",personInfoPo1.getDepartmentID(),systemParameterPo);
		
		String optometryID_title = request.getParameter("optometryID");
		optometryPo = customerOptometryNMgr.getOptometryPo(optometryID_title);
		
		int strcount = personInfoPo1.getPersonjobtype().replace(" ", "").length();
		int persontype1 = personInfoPo1.getPersonjobtype().replace(" ", "").indexOf("3");
		int persontype2 = personInfoPo1.getPersonjobtype().replace(" ", "").indexOf(",3");
		int persontype3 = personInfoPo1.getPersonjobtype().replace(" ", "").indexOf(",3,");
		
		String selecttype = "";
		if(strcount > 1){
			if(persontype2 >= 0 || persontype3 >= 0){
				selecttype = "1";
			}
		}else{
			if(persontype1 >= 0){
				selecttype = "1";
			}
		}
		
		request.setAttribute("selecttype", selecttype);
		request.setAttribute("readOnly", readOnly);
		
		String optometryPersonName = Utility.getName(request.getParameter("optometryPersonName"));
		String optometryPersonID = Utility.getName(request.getParameter("optometryPersonID"));
		
		request.setAttribute("optometryPersonName", optometryPersonName);
		request.setAttribute("optometryPersonID", optometryPersonID);
		
		String isfresh = Utility.getName(request.getParameter("isfresh"));
		if (StringUtils.isEmpty(optometryPo.getSopoyoptometryid())||!isfresh.equals(customerInfoPo.getSmecimemberid())) {
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
			optometryPo.setSopoytime(format1.format(new Date()));
		}

		/**
		 * 扫描卡号得会员信息
		 */
		if (customerInfoPo != null && StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			if(customerInfoPo.getSmecimemberid().split(",").length>1){
				customerInfoPo.setSmecimemberid(customerInfoPo.getSmecimemberid()
						.split(",")[1].trim());
			}else{
				customerInfoPo.setSmecimemberid(customerInfoPo.getSmecimemberid()
					.split(",")[0].trim());
			}
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo.setSmeciflag("1");
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo1));
			
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo,personInfoPo1);
			
			if (customerInfoPo.getSmecicustomerid() == null) {
				this.clearMessages();
				this.addActionMessage("查无此会员或该会员卡已被停用!");
				return SUCCESS;
			}
			
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}
		}
		
		return SUCCESS;
	}
}
