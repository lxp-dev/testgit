package com.pengsheng.eims.basic.action;

import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class PriceAboutAction extends BaseAction {
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr;
	private PersonPermissionMgr personPermissionMgr;
	private String returnUrl = "wholesale";
	
	public String initPricesAbout() {
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
		String goodsid = request.getParameter("goodsid");
		String glassType = request.getParameter("glassType");
		String goodsTypeID = "";
		
		if(null != goodsid && !"".equals(goodsid)) {
			goodsTypeID = goodsid.substring(0, 1);
		}
		
		request.setAttribute("goodsTypeID", goodsTypeID);
		request.setAttribute("glassType", glassType);
		request.setAttribute("goodsid", goodsid);
		return returnUrl;
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

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

}
