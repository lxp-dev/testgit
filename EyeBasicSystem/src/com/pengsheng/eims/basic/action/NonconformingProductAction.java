package com.pengsheng.eims.basic.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.NonconformingProductMgr;
import com.pengsheng.eims.basic.persistence.NonconformingProductPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class NonconformingProductAction extends BaseAction {

	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	private NonconformingProductPo nonconformingProductPo;

	private List<NonconformingProductPo> nonconformingProductMaxList; // 不合格品原因List
	private List<NonconformingProductPo> nonconformingProductMinList; // 不合格品原因List

	private NonconformingProductMgr nonconformingProductMgr;
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	/**
	 * 查询页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initNonconformingProductSel() throws Exception {
		
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
		
		//nonconformingProductMaxList=nonconformingProductMgr.getNonconformingProductMaxList();
		NonconformingProductPo po = new NonconformingProductPo();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//根据查询条件返回相应的结果集数量
		int count = nonconformingProductMgr.getNonconformingProductCount(po);
		
		//查询结果>0 查询出结果
		if (count > 0) {
			
			//页面显示数量
			int perPage = 0;
			
			//获取页面参数  
			//perPage:页面显示数量
			//如果不为空获取当前参数的值
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				//如果
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			
			//
			Pagination page = new Pagination(request, count, perPage);
			
			//根据查询条件返回相应的结果集
			nonconformingProductMaxList = nonconformingProductMgr.getNonconformingProductList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			nonconformingProductMaxList = null;
		
		}
		
		
		return SUCCESS;
	}

	/**
	 * 查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selNonconformingProduct() throws Exception {
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
		String fnpid=Utility.getName(request.getParameter("fnpid"));
		
		NonconformingProductPo po = new NonconformingProductPo();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		//根据查询条件返回相应的结果集数量
		int count = nonconformingProductMgr.getNonconformingProductCount(po);
		
		//查询结果>0 查询出结果
		if (count > 0) {
			
			//页面显示数量
			int perPage = 0;
			
			//获取页面参数  
			//perPage:页面显示数量
			//如果不为空获取当前参数的值
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				//如果
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			
			//
			Pagination page = new Pagination(request, count, perPage);
			
			//根据查询条件返回相应的结果集
			nonconformingProductMaxList = nonconformingProductMgr.getNonconformingProductList(po, page.getStart(), page.getPageSize());

			request.setAttribute(Pagination.PAGINATION, page);
			
		} else { //否则查询结果为NULL
			
			nonconformingProductMaxList = null;
		
		}
		if(!fnpid.equals("")){
			NonconformingProductPo tmp=  new NonconformingProductPo();
			tmp.setFnpparented(fnpid);
			nonconformingProductMinList=nonconformingProductMgr.getNonconformingProductMinList(tmp);
		}
		
		request.setAttribute("fnpidpage", fnpid);
		return SUCCESS;
	}
	
	/**
	 * 新增页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initNonconformingProductInsert() throws Exception {
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
		
		nonconformingProductPo = new NonconformingProductPo();
		nonconformingProductMaxList=nonconformingProductMgr.getNonconformingProductMaxList();
		return SUCCESS;
	}

	/**
	 * 新增不合格品现象
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertNonconformingProduct() throws Exception {
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
		
		if(nonconformingProductPo.getFnpdeptid().equals("1")){
			nonconformingProductPo.setFnpparented("");
		}
		
		nonconformingProductPo.setFnpid(uuid.generate());
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("不合格品现象:" + nonconformingProductPo.getFnpid() + "新增!");
		this.clearMessages();
		int flagName=nonconformingProductMgr.getNonconformingProductName(nonconformingProductPo);
		
		if(flagName==0)
		{
			nonconformingProductMgr.insertNonconformingProduct(nonconformingProductPo,logPo);
			nonconformingProductPo = new NonconformingProductPo();
			nonconformingProductMaxList=nonconformingProductMgr.getNonconformingProductMaxList();				
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}else
		{
			this.addActionMessage(getText("内容重复!"));
			nonconformingProductMaxList=nonconformingProductMgr.getNonconformingProductMaxList();
			return "error";
		}

		
	}

	/**
	 * 更新不合格品现象初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initNonconformingProductUpdate() throws Exception {	
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
		
		String fnpid=Utility.getName(request.getParameter("hid"));
		NonconformingProductPo tmp = new NonconformingProductPo();
		tmp.setFnpid(fnpid);
		nonconformingProductPo = nonconformingProductMgr.getNonconformingProduct(tmp);
		return SUCCESS;
	}

	/**
	 * 更新不合格品现象
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateNonconformingProduct() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 1 表示状态
		logPo.setsLogContent("不合格品现象:" + nonconformingProductPo.getFnpid() + "修改!");
	
		

		this.clearMessages();
		
		int flagName=nonconformingProductMgr.getNonconformingProductNameUpdate(nonconformingProductPo);
		
		if(flagName==0)
		{
			nonconformingProductMgr.updateNonconformingProduct(nonconformingProductPo,logPo);
			this.addActionMessage(getText("struts.messages.update.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		
		}else
		{
			this.addActionMessage(getText("内容重复!"));
			return "error";
		}
	}	
		

	/**
	 * 刪除页面初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initNonconformingProductDelete() throws Exception {
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
		
		String fnpid=Utility.getName(request.getParameter("hid"));
		NonconformingProductPo tmp = new NonconformingProductPo();
		tmp.setFnpid(fnpid);
		nonconformingProductPo = nonconformingProductMgr.getNonconformingProduct(tmp);
		return SUCCESS;
	}

	/**
	 * 刪除不合格品现象
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteNonconformingProduct() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 1 表示状态
		logPo.setsLogContent("不合格品现象:" + nonconformingProductPo.getFnpid() + "删除!");
		
		nonconformingProductMgr.deleteNonconformingProduct(nonconformingProductPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public NonconformingProductPo getNonconformingProductPo() {
		return nonconformingProductPo;
	}

	public void setNonconformingProductPo(
			NonconformingProductPo nonconformingProductPo) {
		this.nonconformingProductPo = nonconformingProductPo;
	}

	public List<NonconformingProductPo> getNonconformingProductMaxList() {
		return nonconformingProductMaxList;
	}

	public void setNonconformingProductMaxList(
			List<NonconformingProductPo> nonconformingProductMaxList) {
		this.nonconformingProductMaxList = nonconformingProductMaxList;
	}

	public NonconformingProductMgr getNonconformingProductMgr() {
		return nonconformingProductMgr;
	}

	public void setNonconformingProductMgr(
			NonconformingProductMgr nonconformingProductMgr) {
		this.nonconformingProductMgr = nonconformingProductMgr;
	}

	public List<NonconformingProductPo> getNonconformingProductMinList() {
		return nonconformingProductMinList;
	}

	public void setNonconformingProductMinList(
			List<NonconformingProductPo> nonconformingProductMinList) {
		this.nonconformingProductMinList = nonconformingProductMinList;
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
	
}
