package com.pengsheng.eims.frame.action;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.frame.mgr.LoginMgr;
import com.pengsheng.eims.report.mgr.ReportQuartzMgr;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.ExternalAccountParameterMgr;
import com.pengsheng.eims.system.mgr.MacMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.PersonSetOptionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.ExternalAccountParameterPo;
import com.pengsheng.eims.system.persistence.FquartzSwitchPo;
import com.pengsheng.eims.system.persistence.MacPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonSetOptionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.DateLicenceUtil;
import com.pengsheng.eims.util.tools.DateTool;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.persistence.ConfigurationPo;
import com.safenet.*;

public class LoginAction extends BaseAction {
	
	private String userID;
	private String userPassword;
	private String cardID;
	private LoginMgr loginMgr;
	private String errorFlag;
	private List<DepartmentsPo> departmentList = null;
	private CompanyNamePo companyNamePo = null;
	private String savePath;
	private String defaultLogoPath;
	private String defaultBgPath;
	private String defaultDepPath;
	private SystemParameterMgr systemParameterMgr;
	private DepartmentsMgr departmentsMgr;
	private MacMgr macMgr;
	private MacPo macPo;
	private SystemParameterPo systemParameterPo;
	private PersonPermissionMgr personPermissionMgr = null;
	private ExternalAccountParameterMgr externalAccountParameterMgr = null;
	private ExternalAccountParameterPo externalAccountParameterPo = null;
	private PersonSetOptionMgr personSetOptionMgr;
	private ReportQuartzMgr reportQuartzMgr;
	private FquartzSwitchPo fquartzSwitchPo;
	private CompanyNameMgr companyNameMgr;
	private ConfigurationMgr configurationMgr; 

	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}

	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}

	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}

	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}

	public FquartzSwitchPo getFquartzSwitchPo() {
		return fquartzSwitchPo;
	}

	public void setFquartzSwitchPo(FquartzSwitchPo fquartzSwitchPo) {
		this.fquartzSwitchPo = fquartzSwitchPo;
	}

	public ReportQuartzMgr getReportQuartzMgr() {
		return reportQuartzMgr;
	}

	public void setReportQuartzMgr(ReportQuartzMgr reportQuartzMgr) {
		this.reportQuartzMgr = reportQuartzMgr;
	}

	public ExternalAccountParameterMgr getExternalAccountParameterMgr() {
		return externalAccountParameterMgr;
	}

	public void setExternalAccountParameterMgr(
			ExternalAccountParameterMgr externalAccountParameterMgr) {
		this.externalAccountParameterMgr = externalAccountParameterMgr;
	}

	public ExternalAccountParameterPo getExternalAccountParameterPo() {
		return externalAccountParameterPo;
	}

	public void setExternalAccountParameterPo(
			ExternalAccountParameterPo externalAccountParameterPo) {
		this.externalAccountParameterPo = externalAccountParameterPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public String getDefaultDepPath() {
		return defaultDepPath;
	}

	public void setDefaultDepPath(String defaultDepPath) {
		this.defaultDepPath = defaultDepPath;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public MacMgr getMacMgr() {
		return macMgr;
	}

	public void setMacMgr(MacMgr macMgr) {
		this.macMgr = macMgr;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public String getDefaultLogoPath() {
		return defaultLogoPath;
	}

	public void setDefaultLogoPath(String defaultLogoPath) {
		this.defaultLogoPath = defaultLogoPath;
	}

	public String getDefaultBgPath() {
		return defaultBgPath;
	}

	public void setDefaultBgPath(String defaultBgPath) {
		this.defaultBgPath = defaultBgPath;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public CompanyNamePo getCompanyNamePo() {
		return companyNamePo;
	}

	public void setCompanyNamePo(CompanyNamePo companyNamePo) {
		this.companyNamePo = companyNamePo;
	}

	public List<DepartmentsPo> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<DepartmentsPo> departmentList) {
		this.departmentList = departmentList;
	}

	public String getErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(String errorFlag) {
		this.errorFlag = errorFlag;
	}

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public LoginMgr getLoginMgr() {
		return loginMgr;
	}

	public void setLoginMgr(LoginMgr loginMgr) {
		this.loginMgr = loginMgr;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * 登陆验证
	 * 
	 * @return
	 * @throws Exception
	 */
	public String loginSearch() throws Exception {
		//-----------------Hasp Check By mysflying 2015-3-12----------------------------------
		String haspResult=HaspApi.getHaspResult();	
		if(haspResult.length()!=17){
			this.clearMessages();
			this.addActionMessage(haspResult);
			return ERROR;
		}else{
			if(!haspResult.substring(7,17).trim().equals("") && DateTool.compare_date(haspResult.substring(7), systemParameterMgr.getDBSystemData())){
				this.clearMessages();
				this.addActionMessage("截至到"+haspResult.substring(7)+"为系统允许访问时间!");
				return ERROR;
			}
			
			DepartmentsPo dpo = new DepartmentsPo();
			dpo.setBdptype("1");
			dpo.setBdpisclosed("0");
			int countHasp = departmentsMgr.getDepartmentCount(dpo);
			BigDecimal bg = new BigDecimal(haspResult.substring(0,6));

			if (bg.intValue() < countHasp){
				this.clearMessages();
				this.addActionMessage(getText("启用的门店总数已超过系统限制,操作失败!"));
				return ERROR;
			}
		}
		//-----------------Hasp Check By mysflying 2015-3-12----------------------------------
		
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		
		externalAccountParameterPo = new ExternalAccountParameterPo();
		externalAccountParameterPo = externalAccountParameterMgr.getExternalAccountParameterPo(externalAccountParameterPo);

		this.clearMessages();

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		if (personInfoPo != null) {
			return "chooseDepartment";
		}

		String userID = Utility.getName(request.getParameter("userID"));
		String userPassword = Utility.getName(request.getParameter("userPassword"));
		String cardID = Utility.getName(request.getParameter("cardID"));

		PersonInfoPo personInfo = new PersonInfoPo();
		personInfo.setId(userID);
		personInfo.setPassword(userPassword);
		personInfo.setCardid(cardID);

		request.setAttribute("userID", userID);
		request.setAttribute("userPassword", userPassword);
		request.setAttribute("cardID", cardID);

		String personlogin = Utility.getName(request.getParameter("personlogin"));
		PersonInfoPo po = new PersonInfoPo();

		//-------------------如果系统参数表未填写系统是否过期时间，返回错误，不允许登录-----------------------------
		GlobalConstants.SYSTEM_SHUTDOWN_DATE = systemParameterPo.getFspsleepstarttime();
//		String limitdate = Utility.getName(GlobalConstants.SYSTEM_SHUTDOWN_DATE);
//		if (limitdate.equals("")) {
//			this.errorFlag = personlogin;
//			this.addActionMessage(this.getText("系统关键参数未设置，请联系系统管理员!"));
//			return ERROR;
//		}
		//-------------------如果系统参数表未填写系统是否过期时间，返回错误，不允许登录-----------------------------
		
		// 判断登录方式 if(刷卡) else(用户名)
		if (personlogin.equals("0")) {
			po = loginMgr.cardLogin(personInfo);
			session.remove("person");

			if (po.getCardid() != null) {
				if (po.getUserState().matches("[0]")) { // 当前状态0:正常 1:删除
					String address = request.getRemoteAddr();
					String machineCode = this.getMachineCode(address);
					po.setMachinery(machineCode);
				} else {
					this.errorFlag = "0";
					this.addActionMessage(this.getText("person.not.error"));
					return ERROR;
				}
			} else {
				this.errorFlag = "0";
				this.addActionMessage(this.getText("card.password.error"));
				return ERROR;
			}
			departmentList = loginMgr.getDepartmentsByPerson(po);
		} else if (personlogin.equals("1")) {
			po = loginMgr.getPerson(personInfo);
			session.remove("person");

			if (po.getId() != null) {
				if (po.getUserState().matches("[0]")) { // 当前状态0:正常 1:删除
					String address = request.getRemoteAddr();
					String machineCode = this.getMachineCode(address);
					po.setMachinery(machineCode);
				} else {
					this.errorFlag = "1";
					this.addActionMessage(this.getText("person.not.error"));
					return ERROR;
				}
			} else {
				this.errorFlag = "1";
				this.addActionMessage(this.getText("personid.password.error"));
				return ERROR;
			}

			departmentList = loginMgr.getDepartmentsByPerson(po);

		}

		if (po.getDepartmentCount() != null && Integer.valueOf(po.getDepartmentCount()) > 1) {
			request.setAttribute("loginPersonName", Utility.getName(po.getPersonName()));

			BigDecimal departmentCount = new BigDecimal(po.getDepartmentCount());
			departmentCount = departmentCount.divide(new BigDecimal(3), 1);

			double rowCount = departmentCount.doubleValue() + 1;
			request.setAttribute("rowCount", Math.round(rowCount));

			if (!userID.equals("admin")) {// 系统管理员不进行Mac验证
				// 客户机Mac地址验证
				String macKey = Utility.getName(request.getParameter("txtMac"));
				String isMacKey = systemParameterMgr.getSystemParameterPo().getFspischeckmac();
				
				if (isMacKey != null && isMacKey.equals("1")
						&& "1".equals(po.getCheckMac())) {
					if (macKey == null || macKey.equals("") || macKey.equals("undefined")) {
						this.addActionMessage("客户机信息提取错误，请将IE浏览器安全设置中的ActiveX的相关属性改为提示状态。或请联系系统管理员！");
						return ERROR;
					} else {
						macPo = new MacPo();
						macPo.setSysmackey(macKey);
						macPo = macMgr.getMac(macPo);
						if (macPo == null || macPo.getSysmacid() == null || macPo.getSysmacid().equals("")) {
							this.addActionMessage("客户机信息在系统未注册，请联系系统管理员！");
							return ERROR;
						} else if (macPo.getSysmacisable().equals("1")) {
							macPo.setSysmaccurrentloginpersonid(userID);
						} else {
							this.addActionMessage("客户机被设置了禁止登入，请联系系统管理员！");
							return ERROR;
						}
					}
				}
				// 客户机Mac地址验证
				// 更新客户机Mac在线情况
				if (isMacKey != null && isMacKey.equals("1")
						&& "1".equals(po.getCheckMac())) {
					macMgr.updateMacLogin(macPo);
					session.put("macKey", macKey);
				}
				// 更新客户机Mac在线情况
			}
			
			session.remove("weixin");
			ConfigurationPo configurationPo = configurationMgr.getConfigurationDetail();
			
			CompanyNamePo lcpo = new CompanyNamePo();
			lcpo.setFcnId(po.getPersoncompanyid());
			CompanyNamePo lcompanyNamePo = loginMgr.getCompanyInfo(lcpo);
			
			systemParameterPo.setFsptakeaddress(lcompanyNamePo.getFcntakeaddress());
			systemParameterPo.setFsptakeperson(lcompanyNamePo.getFcntakeperson());
			systemParameterPo.setFsptakephone(lcompanyNamePo.getFcntakephone());
			systemParameterPo.setFsptakeportraiture(lcompanyNamePo.getFcntakeportraiture());
			
			session.put("weixin", configurationPo);
			session.put("person", po);
			session.put("systemParameterPo", systemParameterPo);
			
			personInfoPo = (PersonInfoPo) session.get("person");
			CompanyNamePo cpo = new CompanyNamePo();
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
			cpo.setFcnDepartmentShowSystem("1");
			companyNamePo = loginMgr.getCompanyInfo(cpo);
			if (!"".equals(Utility.getName(companyNamePo.getFcndepgroundPath()))) {
				companyNamePo.setFcndepgroundPath((this.getSavePath() + File.separator + Utility.getName(companyNamePo.getFcndepgroundPath())).replace("\\", "/"));
			} else {
				companyNamePo.setFcndepgroundPath(this.getDefaultDepPath().replace("\\", "/"));
			}
			
			return SUCCESS;
		} else if (po.getDepartmentCount() != null && Integer.valueOf(po.getDepartmentCount()) == 1) {

			DepartmentsPo dpo = departmentsMgr.getDepartmentSetHisInfo(po.getDepartmentID());
			
			po.setBdplinkhisflag(dpo.getBdplinkhisflag()); // 门店是否连接HIS系统
			po.setBdplinkhis(dpo.getBdplinkhis()); // 门店连接的哪个HIS系统ID
			po.setBdpnotpayfeeform(dpo.getBdpnotpayfeeform()); // 待收费记录向HIS传递方式
			po.setBdpreadcardform(dpo.getBdpreadcardform()); // 读取会员卡的方式
			po.setBdpchargingitemid(dpo.getBdpchargingitemid()); // 收费项目编号
			po.setBdplinkhisurl(dpo.getBdplinkhisurl()); // 门店连接的HIS系统的url *需要改动的
			
			if (!userID.equals("admin")) {// 系统管理员不进行Mac验证
				// 客户机Mac地址验证
				String macKey = Utility.getName(request.getParameter("txtMac"));
				String isMacKey = systemParameterMgr.getSystemParameterPo().getFspischeckmac();
				if (isMacKey != null && isMacKey.equals("1")
						&& "1".equals(po.getCheckMac())) {
					if (macKey == null || macKey.equals("") || macKey.equals("undefined")) {
						this.addActionMessage("客户机信息提取错误，请将IE浏览器安全设置中的ActiveX的相关属性改为提示状态。或联系系统管理员！");
						return ERROR;
					} else {
						macPo = new MacPo();
						macPo.setSysmackey(macKey);
						macPo = macMgr.getMac(macPo);
						if (macPo == null || macPo.getSysmacid() == null || macPo.getSysmacid().equals("")) {
							this.addActionMessage("客户机信息在系统未注册，请联系系统管理员！");
							return ERROR;
						} else if (macPo.getSysmacisable().equals("1")) {
							macPo.setSysmaccurrentloginpersonid(userID);
						} else {
							this.addActionMessage("客户机被设置了禁止登入，请联系系统管理员！");
							return ERROR;
						}
					}
				}
				// 客户机Mac地址验证
				// 更新客户机Mac在线情况
				if (isMacKey != null && isMacKey.equals("1") && "1".equals(po.getCheckMac())) {
					macMgr.updateMacLogin(macPo);
					session.put("macKey", macKey);
				}
				// 更新客户机Mac在线情况
			}
			session.remove("weixin");
			
			CompanyNamePo lcpo = new CompanyNamePo();
			lcpo.setFcnId(po.getPersoncompanyid());
			CompanyNamePo lcompanyNamePo = loginMgr.getCompanyInfo(lcpo);
			
			systemParameterPo.setFsptakeaddress(lcompanyNamePo.getFcntakeaddress());
			systemParameterPo.setFsptakeperson(lcompanyNamePo.getFcntakeperson());
			systemParameterPo.setFsptakephone(lcompanyNamePo.getFcntakephone());
			systemParameterPo.setFsptakeportraiture(lcompanyNamePo.getFcntakeportraiture());
			
			ConfigurationPo configurationPo = configurationMgr.getConfigurationDetail();
			session.put("weixin", configurationPo);
			session.put("person", po);
			session.put("systemParameterPo", systemParameterPo);
			
			personInfoPo = (PersonInfoPo) session.get("person");
			CompanyNamePo cpo = new CompanyNamePo();
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
			cpo.setFcnDepartmentShowSystem("1");
			companyNamePo = loginMgr.getCompanyInfo(cpo);
			if (!"".equals(Utility.getName(companyNamePo.getFcndepgroundPath()))) {
				companyNamePo.setFcndepgroundPath((this.getSavePath() + File.separator + Utility.getName(companyNamePo.getFcndepgroundPath())).replace("\\", "/"));
			} else {
				companyNamePo.setFcndepgroundPath(this.getDefaultDepPath().replace("\\", "/"));
			}

			DepartmentsPo tmpDepartmentsPo = (DepartmentsPo) departmentList.get(0);
			if (tmpDepartmentsPo != null && tmpDepartmentsPo.getBdpisclosed().equals("0")) {
				PersonSetOptionPo personSetOptionPo = personSetOptionMgr.selectPersonSetOptionPo(personInfoPo.getId());
				request.setAttribute("hidetopString", personSetOptionPo.getFpsohidetop());
				return "onedepartment";
			} else {
				return SUCCESS;
			}
		} else {
			return ERROR;
		}
	}

	/**
	 * 管理员登陆验证
	 * 
	 * @return
	 * @throws Exception
	 */
	public String adminLoginSearch() throws Exception {
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		session.put("systemParameterPo", systemParameterPo);
		
		externalAccountParameterPo = new ExternalAccountParameterPo();
		externalAccountParameterPo = externalAccountParameterMgr.getExternalAccountParameterPo(externalAccountParameterPo);

		CompanyNamePo cpo = new CompanyNamePo();
		cpo.setFcnDepartmentShowSystem("1");
		companyNamePo = loginMgr.getCompanyInfo(cpo);
		if (!"".equals(Utility.getName(companyNamePo.getFcndepgroundPath()))) {
			companyNamePo.setFcndepgroundPath((this.getSavePath()+ File.separator + Utility.getName(companyNamePo.getFcndepgroundPath())).replace("\\", "/"));
		} else {
			companyNamePo.setFcndepgroundPath(this.getDefaultDepPath().replace("\\", "/"));
		}

		String userID = Utility.getName(request.getParameter("userID"));
		String userPassword = Utility.getName(request.getParameter("userPassword"));

		request.setAttribute("userID", userID);
		request.setAttribute("userPassword", userPassword);

		if (userID.equals(GlobalConstants.USER) && userPassword.equals(GlobalConstants.PASSWORD)) {

			PersonInfoPo personInfo = new PersonInfoPo();
			personInfo.setId(userID);
			personInfo.setPassword(userPassword);
			personInfo.setDepartmentID(GlobalConstants.DEPARTMENTSID);
			personInfo.setRoleid(GlobalConstants.ROLESID);
			personInfo.setBdpdepartmentname(GlobalConstants.DEPARTMENT_NAME);
			personInfo.setPersonName(GlobalConstants.PERSON_NAME);
			personInfo.setDepartmenttype(GlobalConstants.DEPARTMENT_TYPE);
			personInfo.setPersoncompanytype("1");
			personInfo.setPersoncompanyid("EIMS");
			session.remove("weixin");
			ConfigurationPo configurationPo = configurationMgr.getConfigurationDetail();
			session.put("weixin", configurationPo);
			session.put("person", personInfo);

			return SUCCESS;

		} else {

			this.clearMessages();
			this.addActionMessage(this.getText("用户登录失败!"));

			return ERROR;
		}

	}

	/**
	 * 初始化选取部门
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initAffirmDepartment() throws Exception {
		
		//-----------------Hasp Check By mysflying 2015-3-12----------------------------------
		String haspResult=HaspApi.getHaspResult();	
		if(haspResult.length()!=17){
			this.clearMessages();
			this.addActionMessage(haspResult);
			return ERROR;
		}else{
			if(!haspResult.substring(7,17).trim().equals("") && DateTool.compare_date(haspResult.substring(7), systemParameterMgr.getDBSystemData())){
				this.clearMessages();
				this.addActionMessage("截至到"+haspResult.substring(7)+"为系统允许访问时间!");
				return ERROR;
			}
			
			DepartmentsPo dpo = new DepartmentsPo();
			dpo.setBdptype("1");
			dpo.setBdpisclosed("0");
			int countHasp = departmentsMgr.getDepartmentCount(dpo);
			BigDecimal bg = new BigDecimal(haspResult.substring(0,6));
			if (bg.intValue() < countHasp){
				this.clearMessages();
				this.addActionMessage(getText("启用的门店总数已超过系统限制,操作失败!"));
				return ERROR;
			}
		}
		//-----------------Hasp Check By mysflying 2015-3-12----------------------------------
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		externalAccountParameterPo = new ExternalAccountParameterPo();
		externalAccountParameterPo = externalAccountParameterMgr
				.getExternalAccountParameterPo(externalAccountParameterPo);

		CompanyNamePo cpo = new CompanyNamePo();
		cpo.setFcnId(personInfoPo.getPersoncompanyid());
		cpo.setFcnDepartmentShowSystem("1");
		companyNamePo = loginMgr.getCompanyInfo(cpo);
		if (!"".equals(Utility.getName(companyNamePo.getFcndepgroundPath()))) {
			companyNamePo.setFcndepgroundPath((this.getSavePath() + File.separator + Utility.getName(companyNamePo.getFcndepgroundPath())).replace("\\", "/"));
		} else {
			companyNamePo.setFcndepgroundPath(this.getDefaultDepPath().replace("\\", "/"));
		}

		departmentList = loginMgr.getDepartmentsByPerson(personInfoPo);

		request.setAttribute("loginPersonName", Utility.getName(personInfoPo
				.getPersonName()));

		PersonInfoPo po = loginMgr.getPerson(personInfoPo);

		// 修复bug205 2013-08-16
		if (null == po || null == po.getId()) {
			session.clear();
			return ERROR;
		}
		BigDecimal departmentCount = new BigDecimal(po.getDepartmentCount());
		departmentCount = departmentCount.divide(new BigDecimal(3), 1);

		double rowCount = departmentCount.doubleValue() + 1;
		request.setAttribute("rowCount", Math.round(rowCount));

		return SUCCESS;
	}

	/**
	 * 选取部门
	 * 
	 * @return
	 * @throws Exception
	 */
	public String affirmDepartment() throws Exception {

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		PersonSetOptionPo personSetOptionPo = personSetOptionMgr.selectPersonSetOptionPo(personInfoPo.getId());
		request.setAttribute("hidetopString", personSetOptionPo.getFpsohidetop());
		
		externalAccountParameterPo = new ExternalAccountParameterPo();
		externalAccountParameterPo = externalAccountParameterMgr
				.getExternalAccountParameterPo(externalAccountParameterPo);

		String departmentID = Utility.getName(request
				.getParameter("departmentID"));
		String departmentName = Utility.getName(request
				.getParameter("departmentName"));
		String departmentType = Utility.getName(request
				.getParameter("departmentType"));

		if (departmentID == null || departmentID.equals("")) {
			return "chooseDepartment";
		}

		personInfoPo.setDepartmentID(departmentID);
		personInfoPo.setBdpdepartmentname(departmentName);
		personInfoPo.setDepartmenttype(departmentType);
		personInfoPo.setDptsalestype(loginMgr.getShopCodeSalesForm(departmentID));
		
		DepartmentsPo dpo = departmentsMgr.getDepartmentSetHisInfo(departmentID);
		
		personInfoPo.setBdplinkhisflag(dpo.getBdplinkhisflag()); // 门店是否连接HIS系统
		personInfoPo.setBdplinkhis(dpo.getBdplinkhis()); // 门店连接的哪个HIS系统ID
		personInfoPo.setBdpnotpayfeeform(dpo.getBdpnotpayfeeform()); // 待收费记录向HIS传递方式
		personInfoPo.setBdpreadcardform(dpo.getBdpreadcardform()); // 读取会员卡的方式
		personInfoPo.setBdpchargingitemid(dpo.getBdpchargingitemid()); // 收费项目编号
		personInfoPo.setBdplinkhisurl(dpo.getBdplinkhisurl()); // 门店连接的HIS系统的url *需要改动的
		
		session.remove("weixin");
		ConfigurationPo configurationPo = configurationMgr.getConfigurationDetail();
		session.put("weixin", configurationPo);
		session.remove("person");
		session.put("person", personInfoPo);

		return SUCCESS;
	}

	public String initTopFrame() throws Exception {

		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		externalAccountParameterPo = new ExternalAccountParameterPo();
		externalAccountParameterPo = externalAccountParameterMgr.getExternalAccountParameterPo(externalAccountParameterPo);

		clean();
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		PersonSetOptionPo personSetOptionPo = personSetOptionMgr
				.selectPersonSetOptionPo(personInfoPo.getId());
		CompanyNamePo cpo = new CompanyNamePo();
		cpo.setFcnId(personInfoPo.getPersoncompanyid());
		cpo.setFcnShowSystem("1");
		companyNamePo = loginMgr.getCompanyInfo(cpo);

		if (!"".equals(Utility.getName(companyNamePo.getFcnbackGroundPath()))) {
			companyNamePo.setFcnbackGroundPath((this.getSavePath()
					+ File.separator + Utility.getName(companyNamePo
					.getFcnbackGroundPath())).replace("\\", "/"));
		} else {
			companyNamePo.setFcnbackGroundPath(this.getDefaultBgPath().replace(
					"\\", "/"));
		}
		if (!"".equals(Utility.getName(companyNamePo.getFcnLogoPath()))) {
			companyNamePo
					.setFcnLogoPath((this.getSavePath() + File.separator + Utility
							.getName(companyNamePo.getFcnLogoPath())).replace(
							"\\", "/"));
		} else {
			companyNamePo.setFcnLogoPath(this.getDefaultLogoPath().replace(
					"\\", "/"));
		}

		return SUCCESS;
	}
	
	/** 初始化框架右侧
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getRightFrame() throws Exception {
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		PersonSetOptionPo personSetOptionPo = personSetOptionMgr.selectPersonSetOptionPo(createPerson);
		request.setAttribute("personSetOptionPo", personSetOptionPo);
		return SUCCESS;
	}
	
	/**
	 * 初始化登陆
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initLogin() throws Exception {
		clean();
		
		String isMacKey = systemParameterMgr.getSystemParameterPo().getFspischeckmac();
		if ("1".equals(isMacKey)) {
			List<CompanyNamePo> cpos = loginMgr.getCompanyNameByMacList(null);
			request.setAttribute("cpos", cpos);
		}else{
			CompanyNamePo tcpo = new CompanyNamePo();
			tcpo.setFcnmasterorvice("1");
			tcpo.setFcnLoginShowSystem("1");
			CompanyNamePo cpo = companyNameMgr.getCompanyName(tcpo);
			request.setAttribute("cpo", cpo);
		}
		
		request.setAttribute("errorFlag", errorFlag);

		CompanyNamePo cpo = new CompanyNamePo();
		cpo.setFcnLoginShowSystem("1");
		companyNamePo = loginMgr.getCompanyInfo(cpo);

		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		
		externalAccountParameterPo = new ExternalAccountParameterPo();
		externalAccountParameterPo = externalAccountParameterMgr.getExternalAccountParameterPo(externalAccountParameterPo);

		return SUCCESS;
	}

	/**
	 * 管理员初始化登陆
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initAdminLogin() throws Exception {
		String isMacKey = systemParameterMgr.getSystemParameterPo().getFspischeckmac();
		if ("1".equals(isMacKey)) {
			List<CompanyNamePo> cpos = loginMgr.getCompanyNameByMacList(null);
			request.setAttribute("cpos", cpos);
		}else{
			CompanyNamePo tcpo = new CompanyNamePo();
			tcpo.setFcnmasterorvice("1");
			CompanyNamePo cpo = companyNameMgr.getCompanyName(tcpo);
			request.setAttribute("cpo", cpo);
		}

		externalAccountParameterPo = new ExternalAccountParameterPo();
		externalAccountParameterPo = externalAccountParameterMgr.getExternalAccountParameterPo(externalAccountParameterPo);

		return SUCCESS;
	}

	public String adminLogin() throws Exception {
		clean();
		
		request.setAttribute("errorFlag", errorFlag);

		CompanyNamePo cpo = new CompanyNamePo();
		cpo.setFcnLoginShowSystem("1");
		companyNamePo = loginMgr.getCompanyInfo(cpo);

		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		session.put("systemParameterPo", systemParameterPo);
		
		externalAccountParameterPo = new ExternalAccountParameterPo();
		externalAccountParameterPo = externalAccountParameterMgr
				.getExternalAccountParameterPo(externalAccountParameterPo);

		String haspResult=HaspApi.getHaspResult();	
		if(haspResult.length()==17){
			request.setAttribute("maxDepartmentCount", haspResult.substring(0,6));
			request.setAttribute("maxSysLoginDate", haspResult.substring(7,17));
		}	
		
		return SUCCESS;
	}

	/**
	 * 注销
	 * 
	 * @throws Exception
	 */
	public String loginOut() throws Exception {
		String isMacKey = systemParameterMgr.getSystemParameterPo().getFspischeckmac();
		if ("1".equals(isMacKey)) {
			List<CompanyNamePo> cpos = loginMgr.getCompanyNameByMacList(null);
			request.setAttribute("cpos", cpos);
		}else{
			CompanyNamePo tcpo = new CompanyNamePo();
			tcpo.setFcnmasterorvice("1");
			tcpo.setFcnLoginShowSystem("1");
			CompanyNamePo cpo = companyNameMgr.getCompanyName(tcpo);
			request.setAttribute("cpo", cpo);
		}

		externalAccountParameterPo = new ExternalAccountParameterPo();
		externalAccountParameterPo = externalAccountParameterMgr.getExternalAccountParameterPo(externalAccountParameterPo);

//		session.remove("systemParameterPo");
		
		fquartzSwitchPo = reportQuartzMgr.getFquartzSwitchPo();
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		if (personInfoPo == null) {
			return "login";
		} else if (personInfoPo.getId().equals(GlobalConstants.USER)
				&& personInfoPo.getPassword().equals(GlobalConstants.PASSWORD)) {
			CompanyNamePo cpo = new CompanyNamePo();
			cpo.setFcnId(personInfoPo.getPersoncompanyid());
			cpo.setFcnLoginShowSystem("1");
			companyNamePo = loginMgr.getCompanyInfo(cpo);
			systemParameterPo = systemParameterMgr.getSystemParameterPo();
			session.remove("person");
			return "adminsucess";
		} else {
			String userId = personInfoPo.getId();
			session.remove("person");

			request.setAttribute("userID", userId);
			request.setAttribute("errorFlag", this.errorFlag);

			CompanyNamePo cpo = new CompanyNamePo();
			cpo.setFcnLoginShowSystem("1");
			companyNamePo = loginMgr.getCompanyInfo(cpo);
			systemParameterPo = systemParameterMgr.getSystemParameterPo();

			// 客户机Mac地址
			if (session.get("macKey") != null
					&& !session.get("macKey").equals("")) {
				macPo = new MacPo();
				macPo.setSysmackey(session.get("macKey").toString());
				macPo.setSysmaccurrentloginpersonid("");
				macMgr.updateMacLogin(macPo);
			}
			// 客户机Mac地址

			return SUCCESS;
		}
	}

	public String initButtomFrame() throws Exception {
		CompanyNamePo cpo = new CompanyNamePo();
		cpo.setFcnLoginShowFooter("1");
		companyNamePo = loginMgr.getCompanyInfo(cpo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		externalAccountParameterPo = new ExternalAccountParameterPo();
		externalAccountParameterPo = externalAccountParameterMgr
				.getExternalAccountParameterPo(externalAccountParameterPo);

		return SUCCESS;
	}

	public PersonInfoPo intoObject() {
		PersonInfoPo info = new PersonInfoPo();
		info.setId(this.userID);
		info.setPassword(this.userPassword);
		return info;
	}

	public void clean() {
		this.userID = Utility.EMPTY;
		this.userPassword = Utility.EMPTY;
		this.cardID = Utility.EMPTY;
	}

	private String getMachineCode(String args) {
		if (args == null) {
			return "";
		}
		String[] ips = args.split("\\.");
		String code = ips[3];

		int number = Integer.parseInt(code);
		String hex = Integer.toHexString(number).toUpperCase();
		int length = hex.length();
		if (length < 2) {
			hex = "0" + hex;
		}
		return hex;
	}

	public String initPswdUpdate() {
		return SUCCESS;
	}

	public String pswdUpdate() {
		String pswd = Utility.getName(request.getParameter("newPswd"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		personInfoPo.setPassword(pswd);
		loginMgr.pswdUpdate(personInfoPo);
		this.addActionMessage(this.getText("修改密码成功"));
		request.setAttribute("pswdUpdate", "1");
		return SUCCESS;
	}

	/**
	 * 更新试用期限
	 */
	public String updateSysLicence() throws Exception {

		String licenceID = Utility.getName(request.getParameter("licenceID"));
		String notLicence = Utility.getName(request.getParameter("notLicence"));

		String licence = Utility.getName(DateLicenceUtil.decrypt(licenceID));
		if (!licence.equals("")) {

			try {
				new SimpleDateFormat(licence);
			} catch (Exception e) {
				return SUCCESS;
			}
			loginMgr.updateSysLicence(licence); // 更新试用期限制
		}

		if (notLicence.equals("1")) {
			loginMgr.updateSysLicence(""); // 取消试用期限制
		}

		return SUCCESS;
	}

	public MacPo getMacPo() {
		return macPo;
	}

	public void setMacPo(MacPo macPo) {
		this.macPo = macPo;
	}

	public PersonSetOptionMgr getPersonSetOptionMgr() {
		return personSetOptionMgr;
	}

	public void setPersonSetOptionMgr(PersonSetOptionMgr personSetOptionMgr) {
		this.personSetOptionMgr = personSetOptionMgr;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

}
