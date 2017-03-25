package com.pengsheng.mall.action;

import java.util.List;

import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.mall.mgr.MallShoppingCartMgr;
import com.pengsheng.mall.mgr.MallShoppingOrderMgr;
import com.pengsheng.mall.po.MallShoppingCartPo;
import com.pengsheng.mall.po.MallShoppingOrderPo;

public class MallShoppingOrderAction  extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr; 
	private String isFirstExec;
	
	private MallShoppingOrderPo mallShoppingOrderPo;
	private List<MallShoppingOrderPo> mallShoppingOrderList;
	private MallShoppingOrderMgr mallShoppingOrderMgr;
	
	private MallShoppingCartMgr mallShoppingCartMgr;	
	/**
	 * 初始化商城订单查询
	 */
	public String initMallShoppingOrderSelect() throws Exception {
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
	 * 查询商城订单
	 */
	public String selectMallShoppingOrder() throws Exception {
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
		
		MallShoppingOrderPo po = new MallShoppingOrderPo();

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
		int count = mallShoppingOrderMgr.getMallShoppingOrderPoCount(po);
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
			mallShoppingOrderList = mallShoppingOrderMgr.getMallShoppingOrderPoList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			mallShoppingOrderList = null;
		}

		return SUCCESS;
	}

	/**
	 * 商城订单新增
	 */
	public String insertMallShoppingOrderPo() throws Exception {
		
		String openID = (String)request.getSession().getAttribute("openID");
		List<MallShoppingCartPo> mallShoppingCartList = mallShoppingCartMgr.getMallShoppingCartPoListByOpenID(openID);
		
		mallShoppingOrderMgr.insertMallShoppingOrderPo(mallShoppingCartList);
		
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		return SUCCESS;
	}

	/**
	 * 初始化商城订单更新
	 */
	public String initUpdateMallShoppingOrderPo() throws Exception {
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
		
		mallShoppingOrderPo = new MallShoppingOrderPo();
		mallShoppingOrderPo.setMsoid(hid);
		
		mallShoppingOrderPo = mallShoppingOrderMgr.getMallShoppingOrderPo(mallShoppingOrderPo);

		return SUCCESS;
	}
	
	/**
	 * 商城订单更新
	 */
	public String updateMallShoppingOrderPo() throws Exception {
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
		
		if (!Utility.getName(mallShoppingOrderPo.getMsosmallpicurl()).equals("")) {
			mallShoppingOrderPo.setMsosmallpicurl(mallShoppingOrderPo.getMsosmallpicurl().replaceAll(
					",", ""));
		}
		
		mallShoppingOrderMgr.updateMallShoppingOrderPo(mallShoppingOrderPo);
		
		this.clearMessages();
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);		
		this.addActionMessage(getText("struts.messages.update.sucess"));
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

	public MallShoppingOrderPo getMallShoppingOrderPo() {
		return mallShoppingOrderPo;
	}

	public void setMallShoppingOrderPo(MallShoppingOrderPo mallShoppingOrderPo) {
		this.mallShoppingOrderPo = mallShoppingOrderPo;
	}

	public MallShoppingOrderMgr getMallShoppingOrderMgr() {
		return mallShoppingOrderMgr;
	}

	public void setMallShoppingOrderMgr(MallShoppingOrderMgr mallShoppingOrderMgr) {
		this.mallShoppingOrderMgr = mallShoppingOrderMgr;
	}

	public List<MallShoppingOrderPo> getMallShoppingOrderList() {
		return mallShoppingOrderList;
	}

	public void setMallShoppingOrderList(List<MallShoppingOrderPo> mallShoppingOrderList) {
		this.mallShoppingOrderList = mallShoppingOrderList;
	}

	public MallShoppingCartMgr getMallShoppingCartMgr() {
		return mallShoppingCartMgr;
	}

	public void setMallShoppingCartMgr(MallShoppingCartMgr mallShoppingCartMgr) {
		this.mallShoppingCartMgr = mallShoppingCartMgr;
	}
}
