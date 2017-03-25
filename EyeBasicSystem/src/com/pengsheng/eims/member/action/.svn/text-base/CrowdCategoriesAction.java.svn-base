package com.pengsheng.eims.member.action;

import java.util.List;
import com.pengsheng.eims.member.mgr.CrowdCategoriesMgr;
import com.pengsheng.eims.member.persistence.CrowdCategoriesPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class CrowdCategoriesAction extends BaseAction{

	private CrowdCategoriesPo crowdCategoriesPo;

	private List<CrowdCategoriesPo> list; // 会员人群分类列表List

	private CrowdCategoriesMgr crowdCategoriesMgr; 
	
	private PersonPermissionMgr personPermissionMgr;

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	/**
	 * 查询会员人群分类列表
	 */
	public String selCrowdCategories() throws Exception {
		
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
		// 页面查询条件

		// 取得查询结果会员人群分类List Begin
		list = crowdCategoriesMgr.getCrowdCategoriesList();
		// 取得查询结果会员人群分类List End

		// 传回页面变量参数 Begin
		// 传回页面变量参数 End

		return SUCCESS;
	}

	/**
	 * 初始化会员人群分类新增
	 */
	public String initInsertCrowdCategories() throws Exception {

		crowdCategoriesPo = new CrowdCategoriesPo();
		return SUCCESS;
	}

	/**
	 * 会员人群分类新增
	 */
	public String insertCrowdCategories() throws Exception {

		crowdCategoriesMgr.insertCrowdCategories(crowdCategoriesPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化会员人群分类更新
	 */
	public String initUpdateCrowdCategories() throws Exception {

		// 页面参数：会员人群分类Id
		String fccid=Utility.getName(request.getParameter("hid"));
		
		//根据会员人群分类Id查询会员人群分类对象
		crowdCategoriesPo = new CrowdCategoriesPo();
		crowdCategoriesPo.setFccid(fccid);
		crowdCategoriesPo=crowdCategoriesMgr.getCrowdCategories(crowdCategoriesPo);

		return SUCCESS;
	}
	
	/**
	 * 会员人群分类更新
	 */
	public String updateCrowdCategories() throws Exception {
		
		crowdCategoriesMgr.updateCrowdCategories(crowdCategoriesPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 初始化会员人群分类删除
	 */
	public String initDeleteCrowdCategories()throws Exception{
		
		// 页面参数：会员人群分类Id
		String fccid=Utility.getName(request.getParameter("hid"));
		
		//根据会员人群分类Id查询会员人群分类对象
		crowdCategoriesPo = new CrowdCategoriesPo();
		crowdCategoriesPo.setFccid(fccid);
		crowdCategoriesPo=crowdCategoriesMgr.getCrowdCategories(crowdCategoriesPo);

		return SUCCESS;
	}
	
	/**
	 * 删除会员人群分类
	 */
	public String deleteCrowdCategories()throws Exception{
		
		// 页面参数：会员人群分类Id
		String fccid=Utility.getName(request.getParameter("hid"));
		
		//根据会员人群分类Id查询会员人群分类对象
		crowdCategoriesPo = new CrowdCategoriesPo();
		crowdCategoriesPo.setFccid(fccid);
		crowdCategoriesMgr.deleteCrowdCategories(crowdCategoriesPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public CrowdCategoriesPo getCrowdCategoriesPo() {
		return crowdCategoriesPo;
	}

	public void setCrowdCategoriesPo(CrowdCategoriesPo crowdCategoriesPo) {
		this.crowdCategoriesPo = crowdCategoriesPo;
	}

	public List<CrowdCategoriesPo> getList() {
		return list;
	}

	public void setList(List<CrowdCategoriesPo> list) {
		this.list = list;
	}

	public CrowdCategoriesMgr getCrowdCategoriesMgr() {
		return crowdCategoriesMgr;
	}

	public void setCrowdCategoriesMgr(CrowdCategoriesMgr crowdCategoriesMgr) {
		this.crowdCategoriesMgr = crowdCategoriesMgr;
	}
}
