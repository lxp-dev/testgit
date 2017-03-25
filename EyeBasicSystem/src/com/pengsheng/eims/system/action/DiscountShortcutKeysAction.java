package com.pengsheng.eims.system.action;

import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.persistence.GoodsLevelPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.DiscountShortcutKeysMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysDetailsPo;
import com.pengsheng.eims.system.persistence.DiscountShortcutKeysPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;

public class DiscountShortcutKeysAction extends BaseAction{
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private DiscountShortcutKeysMgr discountShortcutKeysMgr;
	private List<DiscountShortcutKeysPo> discountShortcutKeysPolist;
	private DiscountShortcutKeysPo discountShortcutKeysPo;
	private DiscountShortcutKeysDetailsPo discountShortcutKeysDetailsPo;
	private List<DiscountShortcutKeysDetailsPo> discountShortcutKeysDetailsPos;
	private PersonPermissionMgr personPermissionMgr;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	private BrandMgr brandMgr;
	
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

	private List<GoodsLevelPo> selectGoodsLevelList;
	
	public List<DiscountShortcutKeysDetailsPo> getDiscountShortcutKeysDetailsPos() {
		return discountShortcutKeysDetailsPos;
	}

	public void setDiscountShortcutKeysDetailsPos(
			List<DiscountShortcutKeysDetailsPo> discountShortcutKeysDetailsPos) {
		this.discountShortcutKeysDetailsPos = discountShortcutKeysDetailsPos;
	}

	/**
	 * 初始化打折快捷键查询
	 */
	public String initSelectDiscountShortcutKeys()throws Exception{
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
		discountShortcutKeysPolist = discountShortcutKeysMgr.getDiscountShortcutKeysPoList();
		return SUCCESS;
	}
	
	/**
	 * 初始化打折快捷键新增
	 */
	public String initInsertDiscountShortcutKeys()throws Exception{
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
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		
		return SUCCESS;
	}
	
	/**
	 * 打折快捷键新增
	 */
	public String insertDiscountShortcutKeys()throws Exception{
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
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		//判断打折码 快捷键名称是否重复
		int flagCode = discountShortcutKeysMgr.getShortcutKeysPoId(discountShortcutKeysPo);
		int flagName=discountShortcutKeysMgr.getShortcutKeysPoName(discountShortcutKeysPo);
		
		if(flagCode == 0)
		{	
			if(flagName==0)
			{
				discountShortcutKeysPo.setFdkid(uuid.generate());
				
				//添加日志
				LogisticsLogPo logPo = new LogisticsLogPo();
				logPo.setsLogName(createPerson);
				logPo.setsLogIP(request.getRemoteAddr());
				logPo.setsLogResult(moduleID); // 表示模块名称 
				logPo.setsLogOpID("1");    // 表示状态
				logPo.setsLogContent("打折快捷键:" + discountShortcutKeysPo.getFdkid() + "新增!");
				
				discountShortcutKeysMgr.insertDiscountShortcutKeys(discountShortcutKeysPo,discountShortcutKeysDetailsPo,logPo);
				
				this.clearMessages();
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				return SUCCESS;	
			}else
			{
				this.clearMessages();
				this.addActionMessage("此快捷键名称已存在！");
				
				return "NoRepeat";
			}
		}else
		{
			this.clearMessages();
			this.addActionMessage("此员工打折券已存在！");		
			return "NoRepeat";
		}
		
		
	}
	
	/**
	 * 初始化打折快捷键更新
	 */
	public String initUpdateDiscountShortcutKeys()throws Exception{
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
		String fdkid = Utility.getName(request.getParameter("hid"));
		
		DiscountShortcutKeysPo po = new DiscountShortcutKeysPo();
		po.setFdkid(fdkid);
		DiscountShortcutKeysDetailsPo dpo = new DiscountShortcutKeysDetailsPo();
		dpo.setFdkddiscountkeysid(fdkid);
		discountShortcutKeysPo = discountShortcutKeysMgr.getDiscountShortcutKeysPo(po);
		discountShortcutKeysDetailsPos=discountShortcutKeysMgr.selectDiscountShortcutKeysDetails(dpo);
		return SUCCESS;
	}
	
	/**
	 * 打折快捷键更新
	 */
	public String updateDiscountShortcutKeys()throws Exception{
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
		selectGoodsLevelList = brandMgr.selectGoodsLevelList(null);
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("打折快捷键:" + discountShortcutKeysPo.getFdkid() + "修改!");
		
		//判断打折码 快捷键名称是否重复
		int flagCode = discountShortcutKeysMgr.getShortcutKeysPoIdUpdate(discountShortcutKeysPo);
		int flagName=discountShortcutKeysMgr.getShortcutKeysPoNameUpdate(discountShortcutKeysPo);
		
		if(flagCode == 0)
		{	
			if(flagName==0)
			{
				discountShortcutKeysMgr.updateDiscountShortcutKeys(discountShortcutKeysPo,discountShortcutKeysDetailsPo,logPo);
				
				this.clearMessages();
				this.addActionMessage(getText("struts.messages.update.sucess"));

				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
				
				return SUCCESS;
			}else{
				this.clearMessages();
				this.addActionMessage("此快捷键名称已存在！");
				
				return "NoRepeat";
			}
		}else
		{
			this.clearMessages();
			this.addActionMessage("此员工打折券已存在！");		
			return "NoRepeat";
		}
		
		
	}
	
	/**
	 * 初始化打折快捷键停用/启用
	 */
	public String initUpdateDiscountShortcutKeysEnable()throws Exception{
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
		
		String fdkid = Utility.getName(request.getParameter("hid"));
		
		DiscountShortcutKeysPo po = new DiscountShortcutKeysPo();
		po.setFdkid(fdkid);
		discountShortcutKeysPo = discountShortcutKeysMgr.getDiscountShortcutKeysPo(po);
		return SUCCESS;
	}
	
	/**
	 * 打折快捷键停用/启用
	 */
	public String updateDiscountShortcutKeysEnable()throws Exception{
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
		
		String fdkid = Utility.getName(request.getParameter("hid"));
		String fdkenable = Utility.getName(request.getParameter("enable"));
		
		DiscountShortcutKeysPo po = new DiscountShortcutKeysPo();
		po.setFdkid(fdkid);
		po.setFdkenable(fdkenable);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		
		if (fdkenable.equals("0")){
			logPo.setsLogOpID("39");    // 表示状态
			logPo.setsLogContent("打折快捷键:" + po.getFdkid() + "停用!");
		}else{
			logPo.setsLogOpID("38");    // 表示状态
			logPo.setsLogContent("打折快捷键:" + po.getFdkid() + "启用!");
		}
		
		discountShortcutKeysMgr.updateDiscountShortcutKeysEnable(po,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化打折快捷键显示/隐藏
	 */
	public String initUpdateDiscountShortcutKeysIsShow()throws Exception{
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
		
		String fdkid = Utility.getName(request.getParameter("hid"));
		
		DiscountShortcutKeysPo po = new DiscountShortcutKeysPo();
		po.setFdkid(fdkid);
		discountShortcutKeysPo = discountShortcutKeysMgr.getDiscountShortcutKeysPo(po);
		return SUCCESS;
	}
	
	/**
	 * 打折快捷键显示/隐藏
	 */
	public String updateDiscountShortcutKeysIsShow()throws Exception{
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
		
		String fdkid = Utility.getName(request.getParameter("hid"));
		String fdkisshow = Utility.getName(request.getParameter("isshow"));
		
		DiscountShortcutKeysPo po = new DiscountShortcutKeysPo();
		po.setFdkid(fdkid);
		po.setFdkisshow(fdkisshow);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		
		if (fdkisshow.equals("0")){
			logPo.setsLogOpID("39");    // 表示状态
			logPo.setsLogContent("打折快捷键:" + po.getFdkid() + "页面隐藏!");
		}else{
			logPo.setsLogOpID("38");    // 表示状态
			logPo.setsLogContent("打折快捷键:" + po.getFdkid() + "页面显示!");
		}
		
		discountShortcutKeysMgr.updateDiscountShortcutKeysIsShow(po,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化打折快捷键删除
	 */
	public String initDeleteDiscountShortcutKeys()throws Exception{
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
		String fdkid = Utility.getName(request.getParameter("hid"));
		
		DiscountShortcutKeysPo po = new DiscountShortcutKeysPo();
		po.setFdkid(fdkid);
		discountShortcutKeysPo = discountShortcutKeysMgr.getDiscountShortcutKeysPo(po);
		return SUCCESS;
	}
	
	/**
	 * 打折快捷键删除
	 */
	public String deleteDiscountShortcutKeys()throws Exception{
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
		
		String fdkid = Utility.getName(request.getParameter("hid"));
		
		DiscountShortcutKeysPo po = new DiscountShortcutKeysPo();
		po.setFdkid(fdkid);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("打折快捷键:" + po.getFdkid() + "删除!");
		
		discountShortcutKeysMgr.deleteDiscountShortcutKeys(po,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public DiscountShortcutKeysMgr getDiscountShortcutKeysMgr() {
		return discountShortcutKeysMgr;
	}

	public void setDiscountShortcutKeysMgr(
			DiscountShortcutKeysMgr discountShortcutKeysMgr) {
		this.discountShortcutKeysMgr = discountShortcutKeysMgr;
	}

	public List<DiscountShortcutKeysPo> getDiscountShortcutKeysPolist() {
		return discountShortcutKeysPolist;
	}

	public void setDiscountShortcutKeysPolist(
			List<DiscountShortcutKeysPo> discountShortcutKeysPolist) {
		this.discountShortcutKeysPolist = discountShortcutKeysPolist;
	}

	public DiscountShortcutKeysPo getDiscountShortcutKeysPo() {
		return discountShortcutKeysPo;
	}

	public void setDiscountShortcutKeysPo(
			DiscountShortcutKeysPo discountShortcutKeysPo) {
		this.discountShortcutKeysPo = discountShortcutKeysPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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

	public DiscountShortcutKeysDetailsPo getDiscountShortcutKeysDetailsPo() {
		return discountShortcutKeysDetailsPo;
	}

	public void setDiscountShortcutKeysDetailsPo(
			DiscountShortcutKeysDetailsPo discountShortcutKeysDetailsPo) {
		this.discountShortcutKeysDetailsPo = discountShortcutKeysDetailsPo;
	}
	
	
}
