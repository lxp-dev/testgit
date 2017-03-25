package com.pengsheng.eims.his.action;

import java.util.List;

import com.pengsheng.eims.his.mgr.HisMgr;
import com.pengsheng.eims.his.mgr.HisParamMgr;
import com.pengsheng.eims.his.persistence.HisParamPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SmsLertsPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class HisParamAction extends BaseAction {

	private HisMgr hisMgr;	
	private String isFirstExec;
	private HisParamPo hisParamPo;
	private HisParamMgr hisParamMgr;
	private SalesBasicPo salesBasicPo;	
	private List<HisParamPo> HisParamPoList;
	private List<SalesBasicPo> salesBasicPoList;
	private SystemParameterPo systemParameterPo;
	private PersonPermissionMgr personPermissionMgr;

	
	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}
	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}
	public List<SalesBasicPo> getSalesBasicPoList() {
		return salesBasicPoList;
	}
	public void setSalesBasicPoList(List<SalesBasicPo> salesBasicPoList) {
		this.salesBasicPoList = salesBasicPoList;
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
	public List<HisParamPo> getHisParamPoList() {
		return HisParamPoList;
	}
	public void setHisParamPoList(List<HisParamPo> hisParamPoList) {
		HisParamPoList = hisParamPoList;
	}
	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}
	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}
	public HisParamPo getHisParamPo() {
		return hisParamPo;
	}
	public void setHisParamPo(HisParamPo hisParamPo) {
		this.hisParamPo = hisParamPo;
	}
	public HisParamMgr getHisParamMgr() {
		return hisParamMgr;
	}
	public void setHisParamMgr(HisParamMgr hisParamMgr) {
		this.hisParamMgr = hisParamMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public String inithisParam() {
		
		/************************ 权限设置 ******************************/
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
        
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "queryHisParam";
		}
		
		
		return SUCCESS;
	}
	
	/**
	 * 再次向HIS系统提交
	 * @return
	 */
	
	public String initsubmitHisParamPoAgain() {
		 
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
	 
		String billid = Utility.getName(request.getParameter("billid"));
		String chargetype = Utility.getName(request.getParameter("chargetype"));
		request.setAttribute("billid",billid);
		request.setAttribute("chargetype",chargetype);
		
		return SUCCESS;
	}
	
	/**
	 * 接口3)
	 * 
	 * HIS系统待交费用推送接口
	 * @return
	 */
	
	public String submitHisParamPoAgain(){
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		String billid=Utility.getName(request.getParameter("billid"));
		String chargetype = Utility.getName(request.getParameter("chargetype"));
		String chargestatus = Utility.getName(request.getParameter("chargestatus"));
	 
		SmsLertsPo smsLertsPo = new SmsLertsPo();
		smsLertsPo.setCstsltitle("配镜单提交HIS系统");
    	smsLertsPo.setCstslcontent("配镜单"+billid+"已提交HIS系统");
    	smsLertsPo.setCstslsenddepartment(personInfoPo.getDepartmentID());
    	smsLertsPo.setCstslsendperson(personInfoPo.getId());
    	
    	String moduleID = Utility.getName(request.getParameter("moduleID"));
    	request.setAttribute("moduleID", moduleID);

    	//接口调用日志
    	LogisticsLogPo hisLogPo = new LogisticsLogPo();
		hisLogPo.setsLogDepartmentID(personInfoPo.getDepartmentID()); // 调用部门ID
		hisLogPo.setsLogName(personInfoPo.getId()); // 调用人ID
		hisLogPo.setsLogResult(moduleID); // 所属模块ID	
		hisLogPo.setsLogIP(request.getRemoteAddr()); // IP地址
		
		HisParamPo hisParamPo = new HisParamPo();
		hisParamPo.setBillid(billid); 
 
		//调用接口
		hisMgr.insertSalesNotChargeInfoToHis(billid,chargestatus,chargetype,personInfoPo,hisLogPo);
		
		int count = hisMgr.getChargeCount(hisParamPo);
		this.clearMessages();
		if(count>0){
			this.addActionMessage(getText("提交HIS系统失败！"));
		}else{
			this.addActionMessage(getText("已提交HIS系统！"));
		}
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	 /**
	  * 取消向HIS系统提交
	  * @return
	  */
	public String initsubmitHisParamPoCancel() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取
		
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String billid = request.getParameter("billid");
		HisParamPo po = new HisParamPo();
		po.setId(billid);
		hisParamPo = hisParamMgr.getHisParamPo(po);
		
		return SUCCESS;
	}
	
	public String hisParamPoDetails() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		
		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取
		
		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String id = Utility.getName(request.getParameter("id"));
		HisParamPo po = new HisParamPo();
		po.setId(id);
		hisParamPo = hisParamMgr.getHisParamPo(po);
		
		return SUCCESS;
	}

	public String queryHisParam(){
		
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
		
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String pbillid = Utility.getName(request.getParameter("pbillid"));
		String pflag = Utility.getName(request.getParameter("pflag"));
		String pposid = Utility.getName(request.getParameter("pposid"));
		String pchargetype = Utility.getName(request.getParameter("pchargetype"));
		String pchargestatus = Utility.getName(request.getParameter("pchargestatus"));
		 
		request.setAttribute("pbillid", pbillid);            // 缴费单号
		request.setAttribute("startTime", startTime);             // 开始时间
		request.setAttribute("endTime", endTime);               // 结束时间
		request.setAttribute("pflag", pflag);  // 收费标识
		request.setAttribute("pposid", pposid);             // 收费员ID
		request.setAttribute("pchargetype", pchargetype);        // 收费类型
		request.setAttribute("pchargestatus",pchargestatus);      // 收费状态
		
		HisParamPo paramPo = new HisParamPo();
		paramPo.setStart(startTime);
		paramPo.setEnd(endTime);
		paramPo.setBillid(pbillid);
		paramPo.setFlag(pflag);
		paramPo.setPosid(pposid);
		paramPo.setChargetype(pchargetype);
		paramPo.setChargestatus(pchargestatus);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
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

		// 查询分页
		int count = hisParamMgr.getHisParamPoCount(paramPo);
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
			HisParamPoList = hisParamMgr.getHisParamPoList(paramPo, page.getStart(), page.getPageSize());
			
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			HisParamPoList = null;
		}
		
		return SUCCESS;
	}
	public String initHisParamNot(){
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
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "queryHisParamNot";
		}
		
		return SUCCESS;
	}
	
	
	public String queryHisParamNot(){
		
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
		
		String startTime=Utility.getName(request.getParameter("startTime"));
		String endTime=Utility.getName(request.getParameter("endTime"));
		String billid=Utility.getName(request.getParameter("pbillid"));
		String chargetype=Utility.getName(request.getParameter("pchargetype"));
		
		request.setAttribute("pbillid",billid);                 // 缴费单号
		request.setAttribute("startTime", startTime);           // 开始时间
		request.setAttribute("endTime", endTime);               // 结束时间
		request.setAttribute("pchargetype", chargetype);        // 收费类型
		
		SalesBasicPo salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbsalesdatestarttime(startTime);
		salesBasicPo.setSsesbsalesdateendtime(endTime);
		salesBasicPo.setSsesbsalesid(billid);
		salesBasicPo.setSsesbcheckoutflag(chargetype);
		salesBasicPo.setSsesbshopcode(personInfoPo1.getDepartmentID());

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
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
		 
		// 查询分页 
		int count = hisParamMgr.getNotSubCount(salesBasicPo);
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
			salesBasicPoList = hisParamMgr.getNotSubList(salesBasicPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			salesBasicPoList = null;
		}
		return SUCCESS;
	}
}
