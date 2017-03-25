package com.pengsheng.eims.sales.action;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.his.mgr.HisMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.MydriasisMgr;
import com.pengsheng.eims.sales.persistence.MydriasisPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.RegisteredPrintDetailsPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class MydriasisAction extends BaseAction {


	private PersonPermissionMgr personPermissionMgr;
	
	private MydriasisMgr mydriasisMgr;

	private MydriasisPo mydriasisPo;

	private CustomerInfoPo customerInfoPo;

	private CustomerInfoMgr customerInfoMgr;

	private RegisteredCategoryPo registeredCategoryPo;

	private List<MydriasisPo> mydriasisList;

	private List<RegisteredCategoryPo> frcmoneyList;

	private RegisteredDetailsPo registeredDetailsPo;

	private List<RegisteredPrintDetailsPo> list;

	private List<RegisteredDetailsPo> registeredDetailsList;
	
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	
	private HisMgr hisMgr;

	
	
	public List<RegisteredDetailsPo> getRegisteredDetailsList() {
		return registeredDetailsList;
	}

	public void setRegisteredDetailsList(List<RegisteredDetailsPo> registeredDetailsList) {
		this.registeredDetailsList = registeredDetailsList;
	}

	public HisMgr getHisMgr() {
		return hisMgr;
	}

	public void setHisMgr(HisMgr hisMgr) {
		this.hisMgr = hisMgr;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
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
	

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public RegisteredCategoryPo getRegisteredCategoryPo() {
		return registeredCategoryPo;
	}

	public void setRegisteredCategoryPo(
			RegisteredCategoryPo registeredCategoryPo) {
		this.registeredCategoryPo = registeredCategoryPo;
	}

	public RegisteredDetailsPo getRegisteredDetailsPo() {
		return registeredDetailsPo;
	}

	public void setRegisteredDetailsPo(RegisteredDetailsPo registeredDetailsPo) {
		this.registeredDetailsPo = registeredDetailsPo;
	}

	public List<RegisteredPrintDetailsPo> getList() {
		return list;
	}

	public void setList(List<RegisteredPrintDetailsPo> list) {
		this.list = list;
	}

	public List<RegisteredCategoryPo> getFrcmoneyList() {
		return frcmoneyList;
	}

	public void setFrcmoneyList(List<RegisteredCategoryPo> frcmoneyList) {
		this.frcmoneyList = frcmoneyList;
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

	public MydriasisMgr getMydriasisMgr() {
		return mydriasisMgr;
	}

	public void setMydriasisMgr(MydriasisMgr mydriasisMgr) {
		this.mydriasisMgr = mydriasisMgr;
	}

	public MydriasisPo getMydriasisPo() {
		return mydriasisPo;
	}

	public void setMydriasisPo(MydriasisPo mydriasisPo) {
		this.mydriasisPo = mydriasisPo;
	}

	public List<MydriasisPo> getMydriasisList() {
		return mydriasisList;
	}

	public void setMydriasisList(List<MydriasisPo> mydriasisList) {
		this.mydriasisList = mydriasisList;
	}

	/**
	 * 初始化散瞳检查查询
	 */
	public String initMydriasisSel() throws Exception {

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
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "mydSel";
		}
		return SUCCESS;
	}

	/**
	 * 查询散瞳检查
	 */
	public String selMydriasis() throws Exception {
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
		
		String memberid = Utility.getName(request.getParameter("memberid"));
		String customername = Utility.getName(request
				.getParameter("customername"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));

		MydriasisPo po = new MydriasisPo();
		po.setSopmdcustomerpostcode(memberid);
		po.setSopmdcustomername(customername);
		po.setSopmdstartTime(startTime);
		po.setSopmdendTime(endTime);
		po.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));

		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}
		
		
		int count = mydriasisMgr.getMydriasisCount(po);
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
			mydriasisList = mydriasisMgr.getMydriasisList(po, page.getStart(),
					page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			mydriasisList = null;
		}

		request.setAttribute("memberid", memberid);
		request.setAttribute("customername", customername);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		return SUCCESS;
	}

	/**
	 * 初始化散瞳检查新增
	 */
	public String initMydriasisInsert() throws Exception {
		
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
	 * 新增散瞳检查
	 */
	public String insertMydriasis() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		String smecimemberid = request.getParameter("smecimemberid");
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		mydriasisPo.setSopmdshopcode(personInfoPo.getDepartmentID());
		mydriasisPo.setSopmdmydriasispersonid(personInfoPo.getId());

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 散瞳新增
		logPo.setsLogContent("散瞳信息检查顾客卡号："+smecimemberid+" 新增");
		
		mydriasisMgr.insertMydriasis(mydriasisPo,logPo);
		
		
		if(!"".equals(mydriasisPo.getSopmdsubmitexpenseid())){
			String [] chk = {mydriasisPo.getSopmdsubmitexpenseid()};
			
			registeredDetailsPo = new RegisteredDetailsPo();
			registeredDetailsPo.setScrrdcustomerid(mydriasisPo.getSopmdfcustomerid());
			registeredDetailsPo.setScrrddetailsid("R"
					+ personInfoPo.getDepartmentID()
					+ GenerateNumber.getInstance().getGenerageNumber());
			registeredDetailsPo.setScrrdregister(personInfoPo.getId());
			registeredDetailsPo.setScrrdshopcode(personInfoPo.getDepartmentID());
			registeredDetailsPo.setChk(chk);
	
			mydriasisMgr.insertRegisteredDetails(registeredDetailsPo,logPo);
		}
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("url", "'initMydriasisInsert.action?moduleID="+moduleID+"'");
		request.setAttribute("flag", GlobalConstants.MOVE);
		return SUCCESS;
	}

	/**
	 * 查询散瞳检查人员
	 */
	public String selMydriasisForCustomer() throws Exception {
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
		
		String id = Utility.getName(request.getParameter("smecimemberid"));		

		CustomerInfoPo po = new CustomerInfoPo();
		po.setSmecimemberid(id);
		po.setSmeciflag("1");
		po.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
		
		customerInfoPo = customerInfoMgr.getCustomerInfo(po);
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
		
		MydriasisPo mpo = new MydriasisPo();
		mpo.setSopmdmemberid(id);	

		mydriasisPo = mydriasisMgr.getMydriasis(mpo);
		
		return SUCCESS;
	}

	/**
	 * 查看散瞳检查
	 */
	public String detailMydriasis() throws Exception {
		String id = Utility.getName(request.getParameter("hid"));
		String sopmdid = Utility.getName(request.getParameter("sopmdid"));
		MydriasisPo po = new MydriasisPo();
		po.setSopmdfcustomerid(id);
		po.setSopmdid(sopmdid);
		mydriasisPo = mydriasisMgr.getMydriasis(po);

		return SUCCESS;
	}

	/**
	 * 初始化费用提交
	 */
	public String initChargePutInsert() throws Exception {
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
		
		String customerID = Utility.getName(request.getParameter("customerID"));
		String feeType = Utility.getName("1");

		request.setAttribute("customerID", customerID);
		request.setAttribute("feeType", feeType);

		RegisteredCategoryPo po = new RegisteredCategoryPo();
		po.setFrcfeetype(feeType);
		
		int notollcount = mydriasisMgr.getNoTollType();
		request.setAttribute("notollcount", notollcount);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = mydriasisMgr.getChargePutCount(po);
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
			frcmoneyList = mydriasisMgr.getChargePutList(po, page.getStart(),page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			frcmoneyList = null;
		}

		return SUCCESS;
	}

	/**
	 * 查询费用提交
	 */
	public String selChargePut() throws Exception {

		String customerID = Utility.getName(request.getParameter("customerID"));
		String feeType = Utility.getName(request.getParameter("feeType"));

		request.setAttribute("customerID", customerID);
		request.setAttribute("feeType", feeType);

		RegisteredCategoryPo po = new RegisteredCategoryPo();
		po.setFrcfeetype(feeType);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = mydriasisMgr.getChargePutCount(po);
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
			frcmoneyList = mydriasisMgr.getChargePutList(po, page.getStart(),
					page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			frcmoneyList = null;
		}

		return SUCCESS;
	}
	

	/**
	 * 保存费用提交
	 */
	public String updateChargePut() throws Exception {
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
		
		String customerID = Utility.getName(request.getParameter("customerID"));
		String feeType = Utility.getName(request.getParameter("feeType"));
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
       		
		
		request.setAttribute("customerID", customerID);
		request.setAttribute("feeType", feeType);

		String[] chk = request.getParameterValues("chk");
		registeredDetailsPo = new RegisteredDetailsPo();
		registeredDetailsPo.setScrrdcustomerid(customerID);
		registeredDetailsPo.setScrrddetailsid("R"
				+ personInfoPo.getDepartmentID()
				+ GenerateNumber.getInstance().getGenerageNumber());
		registeredDetailsPo.setScrrdregister(personInfoPo.getId());
		registeredDetailsPo.setScrrdshopcode(personInfoPo.getDepartmentID());
		registeredDetailsPo.setChk(chk);
		registeredDetailsPo.setScrrdamounttype("1");  
		registeredDetailsPo.setScrrdcheckperson(personInfoPo.getId());
		
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 新增
		logPo.setsLogDepartmentID(personInfoPo.getDepartmentID());    //部门 
		
		CustomerInfoPo po = new CustomerInfoPo();
		
		po.setSmecicustomerid(customerID);
		
		customerInfoPo = customerInfoMgr.getCustomerInfo(po);
		logPo.setsLogContent("费用提交会员卡号："+customerInfoPo.getSmecimemberid()+" 新增");

		mydriasisMgr.insertRegisteredDetails(registeredDetailsPo,logPo);
		
		 if("1".equals(personInfoPo.getBdplinkhisflag()) && "2".equals(systemParameterPo.getFsphisflag())){
			 
			 hisMgr.insertRegisteredNotChargeInfoToHis(registeredDetailsPo.getScrrddetailsid(),feeType,personInfoPo,logPo);//挂号流水号,收费退费,系统日志类		
		 }
		 
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE2);

		return SUCCESS;
	}
	
	
	/**
	 * 查询会员费用提交详细
	 */
	public String selectRegisteredDetails() throws Exception {
		
		String billid = Utility.getName(request.getParameter("hid"));
		request.setAttribute("billid", billid);
		
		RegisteredDetailsPo po = new RegisteredDetailsPo();
		po.setScrrddetailsid(billid);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = mydriasisMgr.getRegisteredCount(po);
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
			registeredDetailsList = mydriasisMgr.getRegisteredList(po, page.getStart(), page.getPageSize());
			registeredDetailsPo = registeredDetailsList.get(0);
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			registeredDetailsList = null;
		}
	 
		return SUCCESS;
	}

}
