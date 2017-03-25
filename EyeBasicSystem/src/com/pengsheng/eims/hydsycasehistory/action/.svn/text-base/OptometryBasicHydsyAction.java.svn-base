package com.pengsheng.eims.hydsycasehistory.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.hydsycasehistory.mgr.OptometryBasicHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * @author Liuqian
 * 
 */
public class OptometryBasicHydsyAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;

	private OptometryBasicHydsyMgr optometryBasicHydsyMgr;

	private CustomerInfoMgr customerInfoMgr;

	private List<OptometryBasicPo> optometryBasics;

	private CustomerInfoPo customerInfoPo;


	/**
	 * 扫描卡号得会员信息
	 */
	public String initOptometryBasicSelN() {
		
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
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			if(Utility.getName(request.getParameter("memberID")).equals("")){
				request.setAttribute("memberID", customerInfoPo.getSmecimemberid());
				request.setAttribute("customerID", customerInfoPo.getSmecicustomerid());
			}
			
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
				int count = optometryBasicHydsyMgr
						.getcustomerOptometryBasicCount(customerInfoPo
								.getSmecicustomerid());
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
							perPage = 10;
						}
					} else {
						perPage = 10;
					}
					Pagination page = new Pagination(request, count, perPage);
					optometryBasics = optometryBasicHydsyMgr.getcustomerOptometryBasics(customerInfoPo.getSmecicustomerid(), page.getStart(),page.getPageSize());

					for (OptometryBasicPo basic : optometryBasics) {
						basic.setOptometrys(optometryBasicHydsyMgr.getcustomerOptometrys(basic.getSopoboptometrybasicid()));
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

	public String initOptometryBasicDeleteN() {
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

	public String deleteOptometryBasicN() {
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
		
		optometryBasicHydsyMgr.delOptometryData(basicID, optometryID,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public OptometryBasicHydsyMgr getOptometryBasicHydsyMgr() {
		return optometryBasicHydsyMgr;
	}

	public void setOptometryBasicHydsyMgr(OptometryBasicHydsyMgr optometryBasicHydsyMgr) {
		this.optometryBasicHydsyMgr = optometryBasicHydsyMgr;
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
	
}
