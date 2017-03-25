package com.pengsheng.mall.action;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.mall.mgr.MallTypeLargeMgr;
import com.pengsheng.mall.mgr.MallTypeSmallMgr;
import com.pengsheng.mall.po.MallTypeLargePo;
import com.pengsheng.mall.po.MallTypeSmallPo;

public class MallTypeLargeAction  extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr; 
	private String isFirstExec;
	private MallTypeLargePo mallTypeLargePo;
	private List<MallTypeLargePo> mallTypeLargeList;
	private MallTypeLargeMgr mallTypeLargeMgr;
	private MallTypeSmallMgr mallTypeSmallMgr;
	/**
	 * 初始化商城商品类型查询
	 */
	public String initMallTypeLargeSelect() throws Exception {
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
			return "formingSel";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询商城商品类型
	 */
	public String selectMallTypeLarge() throws Exception {
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
		
		// 得到查询条件
		String mtlname = Utility.getName(request.getParameter("mtlname"));

		request.setAttribute("mtlname", mtlname);
		
		MallTypeLargePo po = new MallTypeLargePo();
		po.setMtlname(mtlname);

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
		int count = mallTypeLargeMgr.getMallTypeLargePoCount(po);
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
			mallTypeLargeList = mallTypeLargeMgr.getMallTypeLargePoList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			mallTypeLargeList = null;
		}

		return SUCCESS;
	}
	
	/**
	 * 初始化商城商品类型新增
	 */
	public String initInsertMallTypeLargePo() throws Exception {
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
	 * 商城商品类型新增
	 */
	public String insertMallTypeLargePo() throws Exception {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("商城商品类型:" + mallTypeLargePo.getMtlname() + "新增!");
				
		if (!Utility.getName(mallTypeLargePo.getMtlpicurl()).equals("")) {
			mallTypeLargePo.setMtlpicurl(mallTypeLargePo.getMtlpicurl().replaceAll(
					",", ""));
		}
		
		mallTypeLargeMgr.insertMallTypeLargePo(mallTypeLargePo, logPo);
		
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		return SUCCESS;
	}

	/**
	 * 初始化商城商品类型更新
	 */
	public String initUpdateMallTypeLargePo() throws Exception {
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
		String hid=Utility.getName(request.getParameter("hid"));
		
		mallTypeLargePo = new MallTypeLargePo();
		mallTypeLargePo.setMtlid(hid);
		
		mallTypeLargePo = mallTypeLargeMgr.getMallTypeLargePo(mallTypeLargePo);

		return SUCCESS;
	}
	
	/**
	 * 商城商品类型更新
	 */
	public String updateMallTypeLargePo() throws Exception {
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("商城商品类型:" + mallTypeLargePo.getMtlname() +"修改!");
		
		if (!Utility.getName(mallTypeLargePo.getMtlpicurl()).equals("")) {
			mallTypeLargePo.setMtlpicurl(mallTypeLargePo.getMtlpicurl().replaceAll(
					",", ""));
		}
		
		mallTypeLargeMgr.updateMallTypeLargePo(mallTypeLargePo, logPo);
		
		this.clearMessages();
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		return SUCCESS;
	}
	
	/**
	 * 初始化商城商品类型删除
	 */
	public String initDeleteMallTypeLargePo()throws Exception{
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
		String hid=Utility.getName(request.getParameter("hid"));

		mallTypeLargePo = new MallTypeLargePo();
		mallTypeLargePo.setMtlid(hid);
		
		mallTypeLargePo = mallTypeLargeMgr.getMallTypeLargePo(mallTypeLargePo);
		
		MallTypeSmallPo po = new MallTypeSmallPo();
		po.setMtslargeid(hid);
		int i = mallTypeSmallMgr.getMallTypeSmallPoCount(po);
		request.setAttribute("flagCount", i);
		return SUCCESS;
	}
	
	/**
	 * 删除商城商品类型
	 */
	public String deleteMallTypeLargePo()throws Exception{
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
		String hid=Utility.getName(request.getParameter("hid"));
		mallTypeLargePo = new MallTypeLargePo();
		mallTypeLargePo.setMtlid(hid);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("商城商品类型编号:" + hid +"删除!");
		
		mallTypeLargeMgr.deleteMallTypeLargePo(mallTypeLargePo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
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

	public MallTypeLargePo getMallTypeLargePo() {
		return mallTypeLargePo;
	}

	public void setMallTypeLargePo(MallTypeLargePo mallTypeLargePo) {
		this.mallTypeLargePo = mallTypeLargePo;
	}

	public MallTypeLargeMgr getMallTypeLargeMgr() {
		return mallTypeLargeMgr;
	}

	public void setMallTypeLargeMgr(MallTypeLargeMgr mallTypeLargeMgr) {
		this.mallTypeLargeMgr = mallTypeLargeMgr;
	}

	public List<MallTypeLargePo> getMallTypeLargeList() {
		return mallTypeLargeList;
	}

	public void setMallTypeLargeList(List<MallTypeLargePo> mallTypeLargeList) {
		this.mallTypeLargeList = mallTypeLargeList;
	}

	public MallTypeSmallMgr getMallTypeSmallMgr() {
		return mallTypeSmallMgr;
	}

	public void setMallTypeSmallMgr(MallTypeSmallMgr mallTypeSmallMgr) {
		this.mallTypeSmallMgr = mallTypeSmallMgr;
	}
}
