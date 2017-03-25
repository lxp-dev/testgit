package com.pengsheng.eims.basic.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.GiftsMgr;
import com.pengsheng.eims.basic.mgr.NoticeMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class GiftsAction extends BaseAction{
	
	private PersonPermissionMgr personPermissionMgr;
	private NoticeMgr noticeMgr;
	private List<DepartmentsPo> departmentsList;
	private DepartmentsMgr departmentsMgr;
	private GiftsMgr giftsMgr;
	private GiftsPo giftsPo;
	private List<GiftsPo> gifts;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	
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
	public NoticeMgr getNoticeMgr() {
		return noticeMgr;
	}
	public void setNoticeMgr(NoticeMgr noticeMgr) {
		this.noticeMgr = noticeMgr;
	}	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}	
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}
	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}	
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public GiftsMgr getGiftsMgr() {
		return giftsMgr;
	}
	public void setGiftsMgr(GiftsMgr giftsMgr) {
		this.giftsMgr = giftsMgr;
	}
	public GiftsPo getGiftsPo() {
		return giftsPo;
	}
	public void setGiftsPo(GiftsPo giftsPo) {
		this.giftsPo = giftsPo;
	}
	public List<GiftsPo> getGifts() {
		return gifts;
	}
	public void setGifts(List<GiftsPo> gifts) {
		this.gifts = gifts;
	}

	public String initGiftsSel() throws Exception{
		
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
		
		if (Utility.getName(permissionPo.getKeyg()).equals("1")){
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
				this.setIsFirstExec("1");
				return "giftsSel";
			}
		}
		
		return SUCCESS;
	}
	
	public String giftsSel() throws Exception{
		
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
		
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String bdpdepartmentname = Utility.getName(request.getParameter("bdpdepartmentname"));
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String typeid = Utility.getName(request.getParameter("typeid"));
		
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("bdpdepartmentname",bdpdepartmentname);
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("typeid",typeid);
		
		giftsPo = new GiftsPo();
		giftsPo.setBgsgoodsid(goodsID);
		giftsPo.setBgsgoodsname(goodsName);
		giftsPo.setBgsdepartments(departmentID);
		giftsPo.setBgstype(typeid);
		
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

		int count = giftsMgr.getGiftsCount2(giftsPo);
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
			gifts = giftsMgr.getGifts(giftsPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			gifts = null;
		}
		
		return SUCCESS;
	}
	
	/*
	 * 赠品新增页面初始化
	 */
	public String initGiftsInsert() throws Exception{
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
		
		return SUCCESS;
	}
	/*
	 * 新增赠品
	 */
	public String giftsInsert() throws Exception{
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
		
		if ("".equals(Utility.getName(giftsPo.getBdpisshow()))){
			giftsPo.setBdpisshow("0");
		}else{
			giftsPo.setBdpisshow("1");
		}
		giftsPo.setBgsinperson(createPerson);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("赠品:" + Utility.getName(giftsPo.getBgsgoodsid()) + "新增!");
		
		int count = giftsMgr.getGiftsCount(giftsPo);
		if(count>0){
			this.clearMessages();
			this.addActionMessage(getText("您选择的赠送重复，请重新选择!"));
			
			return "NoRepeat";
		}else{
			giftsMgr.insertGifts(giftsPo,logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}

	}
	
	
	private String getinterestpolist(String[] departments) {

		String departmentid = "";
		if(null!=departments && !"".equals(departments))
		{
			for (int i = 0; i < departments.length; i++) {

				if ("".equals(departmentid)) {
					departmentid = departments[i];
				} else {
					departmentid = departmentid + "," + departments[i];
				}
			}
		}
		return departmentid;
	}
	
	/*
	 * 修改赠品页面初始化
	 */
	public String initGiftsUpdate() throws Exception{
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
		
		GiftsPo po = new GiftsPo();
		po.setBgsuuid(Utility.getName(request.getParameter("bgsuuid")));
		
		giftsPo = this.giftsMgr.getGift(po);
		
		if(!"".equalsIgnoreCase(Utility.getName(giftsPo.getBgsdepartments()))){
			
			List<DepartmentsPo> dps = noticeMgr.getDepartmentsList(giftsPo.getBgsdepartments());
			StringBuffer departmentNames = new StringBuffer();

			for (DepartmentsPo departmentsPo : dps) {					
				departmentNames.append(departmentsPo.getBdpdepartmentname() + ",");
			}
			if (departmentNames.length() - 1 > 0) {
				departmentNames.deleteCharAt(departmentNames.length() - 1);
			}
			String departmentName = departmentNames.toString();	
			giftsPo.setBdpdepartmentname(departmentName);
		}
		
		return SUCCESS;
	}
	
	private List<DepartmentsPo> getDepartmentList(List<DepartmentsPo> list, String department) {

		List<DepartmentsPo> glist = new ArrayList();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			DepartmentsPo po = (DepartmentsPo) it.next();
			String[] departments = department.split(",");
			for (int i = 0; i < departments.length; i++) {
				if (po.getBdpdepartmentid().equals(departments[i])) {
					po.setBdpwizardflag("1");
					break;
				} else {
					po.setBdpwizardflag("0");
				}
			}
			glist.add(po);
		}
		return glist;
	}
	
	/*
	 *  修改赠品
	 */
	public String giftsUpdate() throws Exception{
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("赠品:" + Utility.getName(giftsPo.getBgsgoodsid()) + "修改!");
		
		if ("".equals(Utility.getName(giftsPo.getBdpisshow())) || "0".equals(Utility.getName(giftsPo.getBdpisshow()))){
			giftsPo.setBdpisshow("0");
		}else{
			giftsPo.setBdpisshow("1");
		}		
		
		giftsMgr.updateGifts(giftsPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));	
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
		
	}
	
	/*
	 *  修改赠品
	 */
	public String giftsUpdateDpt() throws Exception{
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("赠品活动部门:" + Utility.getName(giftsPo.getBgsgoodsid()) + "修改!");
		
		if ("".equals(Utility.getName(giftsPo.getBdpisshow()))){
			giftsPo.setBdpisshow("0");
		}else{
			giftsPo.setBdpisshow("1");
		}
		giftsMgr.updateGiftsDepartment(giftsPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));	
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
		
	}
	
	/*
	 * 删除赠品页面初始化
	 */
	public String initGiftsDelete() throws Exception{
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
		GiftsPo po = new GiftsPo();
		po.setBgsuuid(Utility.getName(request.getParameter("bgsuuid")));
		giftsPo=this.giftsMgr.getGift(po);
		return SUCCESS;
	}
	/*
	 * 删除赠品
	 */
	public String giftsDelete() throws Exception{
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
		GiftsPo giftsPo = new GiftsPo();
		giftsPo.setBgsuuid(Utility.getName(request.getParameter("bgsuuid")));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("赠品:" + giftsPo.getBgsgoodsname() + "删除!");
		
		this.giftsMgr.deleteGifts(giftsPo,logPo);
		
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	/*
	 * 启用赠品页面初始化
	 */
	public String initGiftsAble() throws Exception{
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
		GiftsPo po = new GiftsPo();
		po.setBgsuuid(Utility.getName(request.getParameter("bgsuuid")));
		giftsPo=this.giftsMgr.getGift(po);
		return SUCCESS;
	}
	/*
	 * 停用赠品页面初始化
	 */
	public String initGiftsDisable() throws Exception{
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
		GiftsPo po = new GiftsPo();
		po.setBgsuuid(Utility.getName(request.getParameter("bgsuuid")));
		giftsPo=this.giftsMgr.getGift(po);
		return SUCCESS;
	}
	
	/*
	 * 启用赠品
	 */
	public String giftsAble() throws Exception{
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
		
		GiftsPo giftsPo = new GiftsPo();
		giftsPo.setBgsuuid(Utility.getName(request.getParameter("bgsuuid")));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("38");    // 表示状态
		logPo.setsLogContent("赠品:" + giftsPo.getBgsgoodsname() + "启用!");
		
		this.giftsMgr.ableGifts(giftsPo,logPo);
		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	/*
	 * 停用赠品
	 */
	public String giftsDisable() throws Exception{
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
		
		GiftsPo giftsPo = new GiftsPo();
		giftsPo.setBgsuuid(Utility.getName(request.getParameter("bgsuuid")));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("39");    // 表示状态
		logPo.setsLogContent("赠品:" + giftsPo.getBgsgoodsname() + "停用!");
		
		this.giftsMgr.disableGifts(giftsPo,logPo);
		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

}
