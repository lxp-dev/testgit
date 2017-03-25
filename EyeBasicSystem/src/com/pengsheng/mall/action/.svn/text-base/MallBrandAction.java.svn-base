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
import com.pengsheng.mall.mgr.MallBrandMgr;
import com.pengsheng.mall.mgr.MallTypeSmallMgr;
import com.pengsheng.mall.po.MallBrandPo;
import com.pengsheng.mall.po.MallTypeSmallPo;

public class MallBrandAction  extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr; 
	private String isFirstExec;
	private MallBrandPo mallBrandPo;
	private List<MallBrandPo> mallBrandList;
	private MallBrandMgr mallBrandMgr;
	private MallTypeSmallMgr mallTypeSmallMgr;
	/**
	 * 初始化商城品种查询
	 */
	public String initMallBrandSelect() throws Exception {
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
	 * 查询商城品种
	 */
	public String selectMallBrand() throws Exception {
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
		
		MallBrandPo po = new MallBrandPo();
		po.setMbname(mtlname);

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
		int count = mallBrandMgr.getMallBrandPoCount(po);
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
			mallBrandList = mallBrandMgr.getMallBrandPoList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			mallBrandList = null;
		}

		return SUCCESS;
	}
	
	/**
	 * 初始化商城品种新增
	 */
	public String initInsertMallBrandPo() throws Exception {
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
	 * 商城品种新增
	 */
	public String insertMallBrandPo() throws Exception {
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
		logPo.setsLogContent("商城品种:" + mallBrandPo.getMbname() + "新增!");
				
		if (!Utility.getName(mallBrandPo.getMbpicurl()).equals("")) {
			mallBrandPo.setMbpicurl(mallBrandPo.getMbpicurl().replaceAll(
					",", ""));
		}
		
		mallBrandMgr.insertMallBrandPo(mallBrandPo, logPo);
		
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		return SUCCESS;
	}

	/**
	 * 初始化商城品种更新
	 */
	public String initUpdateMallBrandPo() throws Exception {
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
		
		mallBrandPo = new MallBrandPo();
		mallBrandPo.setMbid(hid);
		
		mallBrandPo = mallBrandMgr.getMallBrandPo(mallBrandPo);

		return SUCCESS;
	}
	
	/**
	 * 商城品种更新
	 */
	public String updateMallBrandPo() throws Exception {
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
		logPo.setsLogContent("商城品种:" + mallBrandPo.getMbname() +"修改!");
		
		if (!Utility.getName(mallBrandPo.getMbpicurl()).equals("")) {
			mallBrandPo.setMbpicurl(mallBrandPo.getMbpicurl().replaceAll(
					",", ""));
		}
		
		mallBrandMgr.updateMallBrandPo(mallBrandPo, logPo);
		
		this.clearMessages();
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		return SUCCESS;
	}
	
	/**
	 * 初始化商城品种删除
	 */
	public String initDeleteMallBrandPo()throws Exception{
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

		mallBrandPo = new MallBrandPo();
		mallBrandPo.setMbid(hid);
		
		mallBrandPo = mallBrandMgr.getMallBrandPo(mallBrandPo);
		
//		MallTypeSmallPo po = new MallTypeSmallPo();
//		po.setMtslargeid(hid);
//		int i = mallTypeSmallMgr.getMallTypeSmallPoCount(po);
//		request.setAttribute("flagCount", i);
		return SUCCESS;
	}
	
	/**
	 * 删除商城品种
	 */
	public String deleteMallBrandPo()throws Exception{
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
		mallBrandPo = new MallBrandPo();
		mallBrandPo.setMbid(hid);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("商城品种编号:" + hid +"删除!");
		
		mallBrandMgr.deleteMallBrandPo(mallBrandPo, logPo);
		
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

	public MallBrandPo getMallBrandPo() {
		return mallBrandPo;
	}

	public void setMallBrandPo(MallBrandPo mallBrandPo) {
		this.mallBrandPo = mallBrandPo;
	}

	public MallBrandMgr getMallBrandMgr() {
		return mallBrandMgr;
	}

	public void setMallBrandMgr(MallBrandMgr mallBrandMgr) {
		this.mallBrandMgr = mallBrandMgr;
	}

	public List<MallBrandPo> getMallBrandList() {
		return mallBrandList;
	}

	public void setMallBrandList(List<MallBrandPo> mallBrandList) {
		this.mallBrandList = mallBrandList;
	}

	public MallTypeSmallMgr getMallTypeSmallMgr() {
		return mallTypeSmallMgr;
	}

	public void setMallTypeSmallMgr(MallTypeSmallMgr mallTypeSmallMgr) {
		this.mallTypeSmallMgr = mallTypeSmallMgr;
	}
}
