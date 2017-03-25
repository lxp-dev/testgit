package com.pengsheng.eims.system.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fr.third.org.hsqldb.lib.HashMap;
import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonDiscountMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.RoleDiscountMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.MemberManagementPo;
import com.pengsheng.eims.system.persistence.PersonDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class PersonDiscountAction extends BaseAction {
	private PersonDiscountMgr personDiscountMgr;
	private RoleDiscountMgr roleDiscountMgr;
	private PersonPermissionMgr personPermissionMgr;
	private List<PersonDiscountPo> personDiscountList;
	private PersonDiscountPo personDiscountPo;
	private List<RolePo> roleList;	
	private List<DepartmentsPo> departmentList;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private BrandMgr brandMgr;
	private List<GoodsLevelPo> selectGoodsLevelList;
	private List<PersonDiscountDetailsPo> personDiscountDetailsPos;
	private PersonDiscountDetailsPo personDiscountDetailsPo;
	
	public List<PersonDiscountDetailsPo> getPersonDiscountDetailsPos() {
		return personDiscountDetailsPos;
	}

	public void setPersonDiscountDetailsPos(
			List<PersonDiscountDetailsPo> personDiscountDetailsPos) {
		this.personDiscountDetailsPos = personDiscountDetailsPos;
	}

	public PersonDiscountDetailsPo getPersonDiscountDetailsPo() {
		return personDiscountDetailsPo;
	}

	public void setPersonDiscountDetailsPo(
			PersonDiscountDetailsPo personDiscountDetailsPo) {
		this.personDiscountDetailsPo = personDiscountDetailsPo;
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}

	public List<GoodsLevelPo> getSelectGoodsLevelList() {
		return selectGoodsLevelList;
	}

	public void setSelectGoodsLevelList(List<GoodsLevelPo> selectGoodsLevelList) {
		this.selectGoodsLevelList = selectGoodsLevelList;
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

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public PersonDiscountMgr getPersonDiscountMgr() {
		return personDiscountMgr;
	}

	public void setPersonDiscountMgr(PersonDiscountMgr personDiscountMgr) {
		this.personDiscountMgr = personDiscountMgr;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	/**
	 * 初始化员工折扣查询
	 */
	public String initPersonDiscountSel()throws Exception{
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
		
		RoleDiscountPo rdpo = new RoleDiscountPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			rdpo.setFrdcompanyid(personInfoPo.getPersoncompanyid());
		}	
		
		departmentList=personDiscountMgr.getDepartmentList(rdpo);
		roleList=roleDiscountMgr.getRoleList(rdpo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selPersonDiscount";
		}
		
		return SUCCESS;
	}
	/**
	 * 查询员工折扣
	 */
	public String selPersonDiscount()throws Exception{
		
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
		
		String personid=Utility.getName(request.getParameter("personid"));
		String personname=Utility.getName(request.getParameter("personname"));
		String role=Utility.getName(request.getParameter("role"));
		String dept=Utility.getName(request.getParameter("dept"));
		String selPersonName=Utility.getName(request.getParameter("selPersonName"));;
		
		personDiscountPo=new PersonDiscountPo();
		personDiscountPo.setFpdpersonid(personid);
		personDiscountPo.setFpdpersonname(personname);
		personDiscountPo.setFpdroleid(role);
		personDiscountPo.setFpddepid(dept);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			personDiscountPo.setFpdcompanyid(personInfoPo.getPersoncompanyid());
		}	
		
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
		
		int count=personDiscountMgr.getPersonDiscountCount(personDiscountPo);
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
	    personDiscountList=personDiscountMgr.getPersonDiscountList(personDiscountPo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			personDiscountList = null;
		}		
		
		RoleDiscountPo rdpo = new RoleDiscountPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			rdpo.setFrdcompanyid(personInfoPo.getPersoncompanyid());
		}	
		
		departmentList=personDiscountMgr.getDepartmentList(rdpo);
		roleList=roleDiscountMgr.getRoleList(rdpo);
		
		request.setAttribute("personid",personid);
		request.setAttribute("personname",personname);
		request.setAttribute("role",role);
		request.setAttribute("dept",dept);
		request.setAttribute("selPersonName",selPersonName);
		
		
		return SUCCESS;
	}
	/**
	 * 初始化员工折扣新增
	 */
	public String initPersonDiscountInsert()throws Exception{
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
		
		personDiscountPo=new PersonDiscountPo();
		
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		return SUCCESS;
	}
	
	/**
	 * 员工折扣新增回车查询
	 */
	public String insertPersonDiscountSel()throws Exception{
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
		
		Map<String, String> disablePersonIDMap = new java.util.HashMap<String, String>();
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		disablePersonIDMap.put("wbygs", "true");
		disablePersonIDMap.put("wbjgs", "true");
		disablePersonIDMap.put("yyb001", "true");
		disablePersonIDMap.put("psb001", "true");
		disablePersonIDMap.put("admin", "true");
		
		if(null == disablePersonIDMap.get(personDiscountPo.getFpdpersonid()) || 
				!disablePersonIDMap.get(personDiscountPo.getFpdpersonid()).equals("true")) {
			
			if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
				personDiscountPo.setFpdcompanyid(personInfoPo.getPersoncompanyid());
			}	
			personDiscountPo = personDiscountMgr.getPersonDiscount(personDiscountPo);
			
			PersonDiscountDetailsPo pdpo = new PersonDiscountDetailsPo();
			pdpo.setFpddpersonid(personDiscountPo.getFpdpersonid());
			if(!"".equals(Utility.getName(personDiscountPo.getFpdpersonid()))){
				personDiscountDetailsPos=personDiscountMgr.selectPersonDiscountDetail(pdpo);
			}
			this.clearMessages();
			
		} else {
			personDiscountPo.setFpdpersonid(null);
			this.addActionMessage(getText("该用户不存在!"));
		}
		return SUCCESS;
	}
	/**
	 * 员工折扣新增
	 */
	public String insertPersonDiscount()throws Exception{
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
		PersonDiscountPo discountPo=personDiscountMgr.getPersonDiscountDetail(personDiscountPo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		
		if("".equals(Utility.getName(discountPo.getFpdpersonid()))){
			logPo.setsLogOpID("1");    // 表示状态
			logPo.setsLogContent("员工打折:" + personDiscountPo.getFpdpersonid() + "新增!");
			personDiscountMgr.insertPersonDiscount(personDiscountPo,personDiscountDetailsPo,logPo);
		}else{
			logPo.setsLogOpID("3");    // 表示状态
			logPo.setsLogContent("员工打折:" + personDiscountPo.getFpdpersonid() + "修改!");
			personDiscountMgr.updatePersonDiscount(personDiscountPo,personDiscountDetailsPo,logPo);
		}
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);				
		
		return SUCCESS;
	}
	/**
	 * 初始化员工折扣修改
	 */
	public String initPersonDiscountUpdate()throws Exception{
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
		String id=Utility.getName(request.getParameter("hid"));
		PersonDiscountPo po=new PersonDiscountPo();
		po.setFpdpersonid(id);
		
		personDiscountPo=personDiscountMgr.getPersonDiscount(po);
		
		PersonDiscountDetailsPo dpo=new PersonDiscountDetailsPo();
		dpo.setFpddpersonid(id);
		
		personDiscountDetailsPos=personDiscountMgr.selectPersonDiscountDetail(dpo);
		
		return SUCCESS;
	}
	/**
	 * 修改员工折扣
	 */
	public String updatePersonDiscount()throws Exception{
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("员工打折:" + personDiscountPo.getFpdpersonid() + "修改!");
		
		personDiscountMgr.updatePersonDiscount(personDiscountPo,personDiscountDetailsPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	/**
	 * 初始化员工折扣删除
	 */
	public String initPersonDiscountDel()throws Exception{
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
		String id=Utility.getName(request.getParameter("hid"));
		PersonDiscountPo po=new PersonDiscountPo();
		po.setFpdpersonid(id);
		
		personDiscountPo=personDiscountMgr.getPersonDiscount(po);
		
		return SUCCESS;
	}
	/**
	 * 删除员工折扣
	 */
	public String delPersonDiscount()throws Exception{
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
		String id=Utility.getName(request.getParameter("hid"));
		PersonDiscountPo po=new PersonDiscountPo();
		po.setFpdpersonid(id);		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("员工打折:" + po.getFpdpersonid() + "删除!");
		
		personDiscountMgr.deletePersonDiscount(po,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	public List<PersonDiscountPo> getPersonDiscountList() {
		return personDiscountList;
	}

	public void setPersonDiscountList(List<PersonDiscountPo> personDiscountList) {
		this.personDiscountList = personDiscountList;
	}

	public PersonDiscountPo getPersonDiscountPo() {
		return personDiscountPo;
	}

	public void setPersonDiscountPo(PersonDiscountPo personDiscountPo) {
		this.personDiscountPo = personDiscountPo;
	}

	public List<RolePo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RolePo> roleList) {
		this.roleList = roleList;
	}

	public List<DepartmentsPo> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<DepartmentsPo> departmentList) {
		this.departmentList = departmentList;
	}

	public RoleDiscountMgr getRoleDiscountMgr() {
		return roleDiscountMgr;
	}

	public void setRoleDiscountMgr(RoleDiscountMgr roleDiscountMgr) {
		this.roleDiscountMgr = roleDiscountMgr;
	}

	
}
