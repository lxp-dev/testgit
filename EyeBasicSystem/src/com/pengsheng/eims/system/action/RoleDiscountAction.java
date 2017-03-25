package com.pengsheng.eims.system.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonDiscountMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.RoleDiscountMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonDiscountPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.RoleDiscountDetailsPo;
import com.pengsheng.eims.system.persistence.RoleDiscountPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class RoleDiscountAction extends BaseAction{
	private BrandMgr brandMgr;
	private List<GoodsLevelPo> selectGoodsLevelList;
	private RoleDiscountMgr roleDiscountMgr;
	private PersonDiscountMgr personDiscountMgr;
	private List<RolePo> roleList;
	private List<RoleDiscountPo> roleDiscountList;
	private RoleDiscountPo roleDiscountPo;
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private RoleDiscountDetailsPo roleDiscountDetailsPo;
	private List<RoleDiscountDetailsPo> roleDiscountDetailsPos;
	
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

	public RoleDiscountDetailsPo getRoleDiscountDetailsPo() {
		return roleDiscountDetailsPo;
	}

	public void setRoleDiscountDetailsPo(RoleDiscountDetailsPo roleDiscountDetailsPo) {
		this.roleDiscountDetailsPo = roleDiscountDetailsPo;
	}

	public List<RoleDiscountDetailsPo> getRoleDiscountDetailsPos() {
		return roleDiscountDetailsPos;
	}

	public void setRoleDiscountDetailsPos(
			List<RoleDiscountDetailsPo> roleDiscountDetailsPos) {
		this.roleDiscountDetailsPos = roleDiscountDetailsPos;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<RolePo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RolePo> roleList) {
		this.roleList = roleList;
	}

	public List<RoleDiscountPo> getRoleDiscountList() {
		return roleDiscountList;
	}

	public void setRoleDiscountList(List<RoleDiscountPo> roleDiscountList) {
		this.roleDiscountList = roleDiscountList;
	}

	public RoleDiscountPo getRoleDiscountPo() {
		return roleDiscountPo;
	}

	public void setRoleDiscountPo(RoleDiscountPo roleDiscountPo) {
		this.roleDiscountPo = roleDiscountPo;
	}

	public RoleDiscountMgr getRoleDiscountMgr() {
		return roleDiscountMgr;
	}

	public void setRoleDiscountMgr(RoleDiscountMgr roleDiscountMgr) {
		this.roleDiscountMgr = roleDiscountMgr;
	}
	
	/**
	 * 初始化角色折扣查询
	 */
	public String initRoleDiscountSel()throws Exception{
		
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
		
		RoleDiscountPo rdpo = new RoleDiscountPo();
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			rdpo.setFrdcompanyid(personInfoPo1.getPersoncompanyid());
		}	
		roleList=roleDiscountMgr.getRoleList(rdpo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selRoleDiscount";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询角色折扣
	 */
	public String selRoleDiscount()throws Exception{
		
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
		
		String role=Utility.getName(request.getParameter("role"));
		
		roleDiscountPo = new RoleDiscountPo();
		roleDiscountPo.setFrdroleid(role);		
		roleDiscountPo.setBegprice(request.getParameter("begPrice"));
		roleDiscountPo.setEndprice(request.getParameter("endPrice"));
		if (Utility.getName(personInfoPo1.getPersoncompanytype()).equals("2")){
			roleDiscountPo.setFrdcompanyid(personInfoPo1.getPersoncompanyid());
		}		
		
		request.setAttribute("begPrice", request.getParameter("begPrice"));
		request.setAttribute("endPrice", request.getParameter("endPrice"));
		
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
		
		int count=roleDiscountMgr.getRoleDiscountCount(roleDiscountPo);
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
	    roleDiscountList=roleDiscountMgr.getRoleDiscountList(roleDiscountPo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			roleDiscountList = null;
		}
		roleList=roleDiscountMgr.getRoleList(roleDiscountPo);
		request.setAttribute("role",role);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化角色折扣设置
	 */
	public String initRoleDiscountInsert()throws Exception{
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
		
		String role=Utility.getName(request.getParameter("hid"));
		roleDiscountPo=new RoleDiscountPo();
		roleDiscountPo.setFrdroleid(role);
		roleDiscountPo=roleDiscountMgr.getRoleDiscount(roleDiscountPo);
		
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		RoleDiscountDetailsPo po = new RoleDiscountDetailsPo();
		po.setFrddroleid(role);
		roleDiscountDetailsPos = roleDiscountMgr.selectRoleDiscountDetails(po);
		
		return SUCCESS;
	}
	
	/**
	 * 设置角色折扣
	 */
	public String insertRoleDiscount()throws Exception{
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
		
		RoleDiscountPo discountPo=roleDiscountMgr.getRoleDiscountDetail(roleDiscountPo);
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		
		String changeDiscount = Utility.getName(request.getParameter("changeDiscount"));
		
		if("".equals(Utility.getName(discountPo.getFrdroleid()))){
			logPo.setsLogOpID("1"); 
			logPo.setsLogContent("角色打折:" + roleDiscountPo.getFrdroleid() + "新增!");
			
			roleDiscountMgr.insertRoleDiscount(roleDiscountPo,roleDiscountDetailsPo, logPo, changeDiscount);
		}else{
			logPo.setsLogOpID("3"); 
			logPo.setsLogContent("角色打折:" + roleDiscountPo.getFrdroleid() + "修改!");
			
			roleDiscountMgr.updateRoleDiscount(roleDiscountPo,roleDiscountDetailsPo, logPo, changeDiscount);
		}	
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	public PersonDiscountMgr getPersonDiscountMgr() {
		return personDiscountMgr;
	}

	public void setPersonDiscountMgr(PersonDiscountMgr personDiscountMgr) {
		this.personDiscountMgr = personDiscountMgr;
	}
}
