package com.pengsheng.eims.aierhistory.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.casehistory.mgr.CustmerInfoHISMgr;
import com.pengsheng.eims.casehistory.mgr.OptometryBasicNMgr;
import com.pengsheng.eims.casehistory.persistence.CustmerInfoHISPo;
import com.pengsheng.eims.casehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.casehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.casehistory.persistence.OptometryPo;
import com.pengsheng.eims.components.mgr.CustomerOptometryNMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
//import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
//import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * @author Liuqian
 * 
 */
public class OptometryBasicAierAction extends BaseAction {
	
	private PersonInfoMgr personInfoMgr;
	private CustomerInfoPo customerInfoPo;
	private CustomerInfoMgr customerInfoMgr;
	private CustmerInfoHISMgr custmerInfoHISMgr;
	private SystemParameterPo systemParameterPo;
	private OptometryBasicNMgr optometryBasicNMgr;
	private List<OptometryBasicPo> optometryBasics;
	private PersonPermissionMgr personPermissionMgr;
	private List<PersonInfoPo> optometryPersonInfoPos;
	private CustomerOptometryNMgr customerOptometryNMgr;
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
	 
		request.setAttribute("personInfoPo", personInfoPo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		List departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo);
		
		optometryPersonInfoPos = personInfoMgr.getPersoninfoPoListByJobType("3",personInfoPo.getDepartmentID(),systemParameterPo);
		
		String optometryID_title = request.getParameter("optometryID");
		optometryPo = customerOptometryNMgr.getOptometryPo(optometryID_title);
		int strcount = personInfoPo.getPersonjobtype().replace(" ", "").length();
		int persontype1 = personInfoPo.getPersonjobtype().replace(" ", "").indexOf("3");
		int persontype2 = personInfoPo.getPersonjobtype().replace(" ", "").indexOf(",3");
		int persontype3 = personInfoPo.getPersonjobtype().replace(" ", "").indexOf(",3,");
		
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
		
		String sopoytreatmentnum = Utility.getName(request.getParameter("sopoytreatmentnum"));
		
		String optometryPersonName = Utility.getName(request.getParameter("optometryPersonName"));
		String optometryPersonID = Utility.getName(request.getParameter("optometryPersonID"));
		request.setAttribute("optometryPersonID", optometryPersonID);
		request.setAttribute("optometryPersonName", optometryPersonName);
		request.setAttribute("sopoytreatmentnum", sopoytreatmentnum);
		
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
			customerInfoPo.setSmecishoplist(getDepartmentListBySystemParameter(systemParameterPo,departmentsList));
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
		 
			if(Utility.getName(request.getParameter("memberID")).equals("")){
				request.setAttribute("memberID", customerInfoPo.getSmecimemberid());
				request.setAttribute("customerID", customerInfoPo.getSmecicustomerid());
			}
			
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
				int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
				int count = optometryBasicNMgr.getcustomerOptometryBasicCount(customerInfoPo);
				if (count > 0) {
					int perPage = 0;
					if (request.getParameter("perPage") != null) {
						perPage = new Integer((String) request.getParameter("perPage"))
								.intValue();
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
					optometryBasics = optometryBasicNMgr.getcustomerOptometryBasics(customerInfoPo, page.getStart(),page.getPageSize());

					for (OptometryBasicPo basic : optometryBasics) {
						basic.setOptometrys(optometryBasicNMgr.getcustomerOptometrys(basic.getSopoboptometrybasicid()));
					}
					request.setAttribute(Pagination.PAGINATION, page);

				} else {
					optometryBasics = null;
				}
			}
		}
		request.setAttribute("createPerson", createPerson);
		
		//判断是否开始验光检查
		String isshow = Utility.getName(request.getParameter("isshow"));
		String smecicustomerid = Utility.getName(request.getParameter("psmecicustomerid"));
		if("1".equals(isshow)){
			
			if(!"".equals(sopoytreatmentnum)){

				CustmerInfoHISPo custmerInfoHISPo = new CustmerInfoHISPo();
				custmerInfoHISPo.setShccotodayid(sopoytreatmentnum);
				custmerInfoHISPo.setShccocustmerid(smecicustomerid);
				custmerInfoHISPo.setShccoisopt("1");
				custmerInfoHISPo.setShccoisrefund("0");
				int count = custmerInfoHISMgr.queryCustHIS(custmerInfoHISPo);
				 
				if(count > 0){
					custmerInfoHISMgr.updateCustHIS(custmerInfoHISPo);
				}else if(count == 0){
					custmerInfoHISMgr.insertCustHIS(custmerInfoHISPo);
				}
			}  
			
			request.setAttribute("isshow", isshow);
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
		
		optometryBasicNMgr.delOptometryData(basicID, optometryID,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	 
	public CustmerInfoHISMgr getCustmerInfoHISMgr() {
		return custmerInfoHISMgr;
	}

	public void setCustmerInfoHISMgr(CustmerInfoHISMgr custmerInfoHISMgr) {
		this.custmerInfoHISMgr = custmerInfoHISMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public OptometryBasicNMgr getOptometryBasicNMgr() {
		return optometryBasicNMgr;
	}

	public void setOptometryBasicNMgr(OptometryBasicNMgr optometryBasicNMgr) {
		this.optometryBasicNMgr = optometryBasicNMgr;
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

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
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

	public CustomerOptometryNMgr getCustomerOptometryNMgr() {
		return customerOptometryNMgr;
	}

	public void setCustomerOptometryNMgr(CustomerOptometryNMgr customerOptometryNMgr) {
		this.customerOptometryNMgr = customerOptometryNMgr;
	}
}
