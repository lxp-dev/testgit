/**
 * 
 */
package com.pengsheng.eims.sales.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.OptometryBasicMgr;
import com.pengsheng.eims.sales.persistence.HealthCheckPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * @author Liuqian
 * 
 */
public class OptometryBasicAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;

	private OptometryBasicMgr optometryBasicMgr;

	private CustomerInfoMgr customerInfoMgr;

	private List<OptometryBasicPo> optometryBasics;

	private CustomerInfoPo customerInfoPo;

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

	public OptometryBasicMgr getOptometryBasicMgr() {
		return optometryBasicMgr;
	}

	public void setOptometryBasicMgr(OptometryBasicMgr optometryBasicMgr) {
		this.optometryBasicMgr = optometryBasicMgr;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public List<OptometryBasicPo> getOptometryBasics() {
		return optometryBasics;
	}

	public void setOptometryBasics(List<OptometryBasicPo> optometryBasics) {
		this.optometryBasics = optometryBasics;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}
	
	private HealthCheckPo healthCheckPo;

	public HealthCheckPo getHealthCheckPo() {
		return healthCheckPo;
	}

	public void setHealthCheckPo(HealthCheckPo healthCheckPo) {
		this.healthCheckPo = healthCheckPo;
	}
		private OptometryPo optometryPo;


	public void setOptometryPo(OptometryPo optometryPo) {
		this.optometryPo = optometryPo;
	}

	public OptometryPo getOptometryPo() {
		return optometryPo;
	}

	/**
	 * 扫描卡号得会员信息
	 */
	public String initOptometryBasicSel() {
		
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
		
		//向页面传递当日就诊号
		String sopoytreatmentnum = Utility.getName(request.getParameter("sopoytreatmentnum")); // 当日就诊号
		request.setAttribute("sopoytreatmentnum", sopoytreatmentnum);
		request.setAttribute("personInfoPo", personInfoPo);
		
		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			if(customerInfoPo.getSmecimemberid().split(",").length>1){
				customerInfoPo.setSmecimemberid(customerInfoPo.getSmecimemberid()
						.split(",")[1].trim());
			}else{
				customerInfoPo.setSmecimemberid(customerInfoPo.getSmecimemberid()
					.split(",")[0].trim());
			}
			
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo.setSmeciflag("1");
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
			
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo,personInfoPo);
			
			if (customerInfoPo.getSmecicustomerid() == null) {
				this.clearMessages();
				this.addActionMessage("查无此会员或该会员卡已被停用!");
				return SUCCESS;
			}
			
			if(Utility.getName(request.getParameter("memberID")).equals("")){
				request.setAttribute("memberID", customerInfoPo.getSmecimemberid());
				request.setAttribute("customerID", customerInfoPo.getSmecicustomerid());
			}
			
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
			
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
				customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
				int count = optometryBasicMgr.getcustomerOptometryBasicCount(customerInfoPo);
				if (count > 0) {
					int perPage = 0;
					if (request.getParameter("perPage") != null) {
						perPage = new Integer((String) request
								.getParameter("perPage")).intValue();
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
					optometryBasics = optometryBasicMgr.getcustomerOptometryBasics(customerInfoPo, page.getStart(),page.getPageSize());

					for (OptometryBasicPo basic : optometryBasics) {
						basic.setOptometrys(optometryBasicMgr.getcustomerOptometrys(basic.getSopoboptometrybasicid()));
					}
					request.setAttribute(Pagination.PAGINATION, page);

				} else {
					optometryBasics = null;
				}
			}
		}
		request.setAttribute("createPerson", createPerson);
		

		return SUCCESS;
	}

	public String initOptometryBasicDelete() {
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
		
		String basicID = request.getParameter("basicID");
		String optometryID = request.getParameter("optometryID");

		request.setAttribute("basicID", basicID);
		request.setAttribute("optometryID", optometryID);
		return SUCCESS;
	}

	public String deleteOptometryBasic() {
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
		
		String basicID = request.getParameter("basicID");
		String optometryID = request.getParameter("optometryID");
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 删除
		logPo.setsLogContent("验光验光号："+optometryID+" 删除");
		
		optometryBasicMgr.delOptometryData(basicID, optometryID,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
}
