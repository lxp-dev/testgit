package com.pengsheng.weixin.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.ComplaintsTypePo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.frame.dao.LoginDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.mgr.CustomerComplainMgr;
import com.pengsheng.eims.sales.persistence.CustomerComplainPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsContentMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsTypeMgr;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;
import com.pengsheng.weixin.persistence.WeiXinCmsTypePo;

public class WeiXinCmsContentAction  extends BaseAction {
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr; 
	private String isFirstExec;
	private WeiXinCmsContentPo weiXinCmsContentPo;
	private WeiXinCmsContentMgr weiXinCmsContentMgr;
	private WeiXinCmsTypeMgr weiXinCmsTypeMgr;
	private List<WeiXinCmsContentPo> weiXinCmsContentList;
	private UnitMgr unitMgr;
	private List<ComplaintsTypePo> complaintsTypeList;
	private CustomerComplainPo customerComplainPo;
	private CustomerComplainMgr customerComplainMgr;
	private List<WeiXinCmsTypePo> weiXinCmsTypeList;
	private List<DepartmentsPo> departmentsList;
	private DepartmentsPo departmentsPo;
	private CompanyNamePo companyNamePo;
	private LoginDao loginDao;
	private ConfigurationMgr configurationMgr;
	private CustomerInfoPo customerInfoPo;
	
	private List<SalesBasicPo> salesBasicList;

	/**
	 * 初始化文章查询
	 */
	public String initWeiXinCmsContentSelect() throws Exception {
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

		systemParameterPo = systemParameterMgr.getSystemParameterPo();		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "formingSel";
		}
		
		weiXinCmsTypeList = weiXinCmsTypeMgr.getWeiXinCmsTypeList(new WeiXinCmsTypePo());
		
		return SUCCESS;
	}
	
	/**
	 * 查询文章
	 */
	public String selectWeiXinCmsContent() throws Exception {
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

		// 得到查询条件
		String title = Utility.getName(request.getParameter("title"));
		String typeid = Utility.getName(request.getParameter("typeid"));		
		String content = Utility.getName(request.getParameter("content"));
		String flag = Utility.getName(request.getParameter("flag"));
		
		String arg1 = Utility.getName(request.getParameter("arg1"));
		String arg2 = Utility.getName(request.getParameter("arg2"));
		if(arg1.equals("")){
			arg1 = "departmentID";
		}
		if(arg2.equals("")){
			arg2 = "ds";
		}		
		request.setAttribute("arg1", arg1);
		request.setAttribute("arg2", arg2);
		
		WeiXinCmsContentPo po = new WeiXinCmsContentPo();

		po.setWcmsctypeid(typeid);
		po.setWcmsctitle(title);
		po.setWcmsccontent(content);
		po.setWcmscflag(flag);
		
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
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
		int count = weiXinCmsContentMgr.selectWeiXinCmsContentCount(po);
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
			weiXinCmsContentList = weiXinCmsContentMgr.selectWeiXinCmsContentList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			weiXinCmsContentList = null;
		}
		
		weiXinCmsTypeList = weiXinCmsTypeMgr.getWeiXinCmsTypeList(new WeiXinCmsTypePo());
		
		request.setAttribute("typeid", typeid);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		request.setAttribute("flag", flag);

		return SUCCESS;
	}
	
	/**
	 * 查询文章
	 */
	public String initCmsContentOpen() throws Exception {
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

		// 得到查询条件
		String title = Utility.getName(request.getParameter("title"));
		String typeid = Utility.getName(request.getParameter("typeid"));		
		String content = Utility.getName(request.getParameter("content"));
		String flag = Utility.getName(request.getParameter("flag"));
		
		String arg1 = Utility.getName(request.getParameter("arg1"));
		String arg2 = Utility.getName(request.getParameter("arg2"));
		if(arg1.equals("")){
			arg1 = "departmentID";
		}
		if(arg2.equals("")){
			arg2 = "ds";
		}		
		request.setAttribute("arg1", arg1);
		request.setAttribute("arg2", arg2);
		
		WeiXinCmsContentPo po = new WeiXinCmsContentPo();

		po.setWcmsctypeid(typeid);
		po.setWcmsctitle(title);
		po.setWcmsccontent(content);
		po.setWcmscflag(flag);
		
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
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
		int count = weiXinCmsContentMgr.selectWeiXinCmsContentCount(po);
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
			weiXinCmsContentList = weiXinCmsContentMgr.selectWeiXinCmsContentList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			weiXinCmsContentList = null;
		}
		
		weiXinCmsTypeList = weiXinCmsTypeMgr.getWeiXinCmsTypeList(new WeiXinCmsTypePo());
		
		request.setAttribute("typeid", typeid);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		request.setAttribute("flag", flag);

		return SUCCESS;
	}
	
	/**
	 * 初始化文章信息新增
	 */
	public String initInsertWeiXinCmsContentPo() throws Exception {
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
		
		weiXinCmsTypeList = weiXinCmsTypeMgr.getWeiXinCmsTypeList(new WeiXinCmsTypePo());
		
		return SUCCESS;
	}

	/**
	 * 文章信息新增
	 */
	public String insertWeiXinCmsContentPo() throws Exception {
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
		logPo.setsLogContent("文章:" + weiXinCmsContentPo.getWcmsctitle() + "新增!");
		String content = Utility.getName(request.getParameter("content"));
		String picisshow =Utility.getName(request.getParameter("picisshow"));
		
		if ("1".equals(request.getParameter("stateFlag"))) {
			weiXinCmsContentPo.setWcmscflag("1");
		} else {
			weiXinCmsContentPo.setWcmscflag("0");
		}
		
		weiXinCmsContentPo.setWcmscpicisshow(picisshow);
		weiXinCmsContentPo.setWcmsccontent(content);
		
		this.clearMessages();
		
		if (!Utility.getName(weiXinCmsContentPo.getWcmscpicurl()).equals("")) {
			weiXinCmsContentPo.setWcmscpicurl(weiXinCmsContentPo.getWcmscpicurl().replaceAll(
					",", ""));
		}
		
		weiXinCmsContentMgr.insertWeiXinCmsContentPo(weiXinCmsContentPo, logPo);
		
		weiXinCmsTypeList = weiXinCmsTypeMgr.getWeiXinCmsTypeList(new WeiXinCmsTypePo());

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化文章信息更新
	 */
	public String initUpdateWeiXinCmsContentPo() throws Exception {
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
		
		WeiXinCmsContentPo po = new WeiXinCmsContentPo();
		po.setWcmscid(hid);
		
		weiXinCmsContentPo = weiXinCmsContentMgr.selectWeiXinCmsContentPo(po);
		
		weiXinCmsTypeList = weiXinCmsTypeMgr.getWeiXinCmsTypeList(new WeiXinCmsTypePo());
		
		return SUCCESS;
	}
	
	/**
	 * 文章信息更新
	 */
	public String updateWeiXinCmsContentPo() throws Exception {
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
		logPo.setsLogContent("文章编号:" + weiXinCmsContentPo.getWcmscid() +"修改!");
		this.clearMessages();
		
		String picisshow =Utility.getName(request.getParameter("picisshow"));
		String content = Utility.getName(request.getParameter("content"));
		weiXinCmsContentPo.setWcmsccontent(content);
		if ("1".equals(request.getParameter("stateFlag"))) {
			weiXinCmsContentPo.setWcmscflag("1");
		} else {
			weiXinCmsContentPo.setWcmscflag("0");
		}
		
		weiXinCmsContentPo.setWcmscpicisshow(picisshow);
		
		if (!Utility.getName(weiXinCmsContentPo.getWcmscpicurl()).equals("")) {
			weiXinCmsContentPo.setWcmscpicurl(weiXinCmsContentPo.getWcmscpicurl().replaceAll(
					",", ""));
		}
		
		weiXinCmsContentMgr.updateWeiXinCmsContentPo(weiXinCmsContentPo,logPo);		
		weiXinCmsTypeList = weiXinCmsTypeMgr.getWeiXinCmsTypeList(new WeiXinCmsTypePo());
		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化文章信息删除
	 */
	public String initDeleteWeiXinCmsContentPo()throws Exception{
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
		
		WeiXinCmsContentPo po = new WeiXinCmsContentPo();
		po.setWcmscid(hid);
		
		weiXinCmsContentPo = weiXinCmsContentMgr.selectWeiXinCmsContentPo(po);

		return SUCCESS;
	}
	
	/**
	 * 删除文章信息
	 */
	public String deleteWeiXinCmsContentPo()throws Exception{
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
		WeiXinCmsContentPo po = new WeiXinCmsContentPo();
		po.setWcmscid(hid);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("文章编号:" + hid +"删除!");
		
		weiXinCmsContentMgr.deleteWeiXinCmsContentPo(po, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化文章信息停用启用
	 */
	public String initWeiXinCmsContentPoAble()throws Exception{
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

		String hid=Utility.getName(request.getParameter("hid"));
		
		WeiXinCmsContentPo po = new WeiXinCmsContentPo();
		po.setWcmscid(hid);
		
		weiXinCmsContentPo = weiXinCmsContentMgr.selectWeiXinCmsContentPo(po);

		return SUCCESS;
	}
	
	/**
	 * 文章信息停用启用
	 */
	public String updateWeiXinCmsContentPoAble()throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		/** ********************** 权限设置 ***************************** */
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		
		if (Utility.getName(weiXinCmsContentPo.getWcmscflag()).equals("1")){
			logPo.setsLogOpID("39");    // 表示状态  39 停用  38 启用
			logPo.setsLogContent("文章编号:" + weiXinCmsContentPo.getWcmscid() +"停用!");
		}else{
			logPo.setsLogOpID("38");    // 表示状态  39 停用  38 启用
			logPo.setsLogContent("文章编号:" + weiXinCmsContentPo.getWcmscid() +"启用!");
		}
		
		if("0".equals(weiXinCmsContentPo.getWcmscflag())){
			weiXinCmsContentPo.setWcmscflag("1");
		}else if("1".equals(weiXinCmsContentPo.getWcmscflag())){
			weiXinCmsContentPo.setWcmscflag("0");
		}
		
		weiXinCmsContentMgr.updateWeiXinCmsContentFlag(weiXinCmsContentPo, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	public String initInsertCustomerComplainWX(){
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String complainid = "TWX" + numHeadFormat.format(new Date());
		
		String openID = Utility.getName(request.getParameter("openID"));
		CustomerComplainPo po = new CustomerComplainPo();
		po.setSmecccustomermemberid(openID);
		
		customerComplainPo = weiXinCmsContentMgr.selectCustomerComplainPo(po);
		
		complaintsTypeList = unitMgr.getComplaintsTypeList();
		
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);
		
		salesBasicList = configurationMgr.getSalesBillInfoByCustomer(customerInfoPo);
		
		request.setAttribute("smeccuuid", complainid);
		return SUCCESS;
	}
	
	public String insertCustomerComplainWX(){
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName("weixin");
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(""); 
		logPo.setsLogOpID("1");  
		logPo.setsLogContent("顾客投诉单号："+customerComplainPo.getSmeccuuid()+"（微信）新增！");
		
		//主表填充值
		customerComplainPo.setSmeccregisterpersonid("weixin");
		
		//子表填充值
		customerComplainPo.setSmechcustomercomplainid(customerComplainPo.getSmeccuuid());
		customerComplainPo.setSmechhandlepersonid("");
		
		String isSend = Utility.getName(request.getParameter("isSend"));
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		
		customerComplainMgr.insertCustomerComplainPo(customerComplainPo,smsRecordPo,isSend,null,logPo);
		
		CompanyNamePo po1 = new CompanyNamePo();
		companyNamePo = loginDao.getCompanyInfo(po1);
		
		return SUCCESS;
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

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public WeiXinCmsContentPo getWeiXinCmsContentPo() {
		return weiXinCmsContentPo;
	}

	public void setWeiXinCmsContentPo(WeiXinCmsContentPo weiXinCmsContentPo) {
		this.weiXinCmsContentPo = weiXinCmsContentPo;
	}

	public WeiXinCmsContentMgr getWeiXinCmsContentMgr() {
		return weiXinCmsContentMgr;
	}

	public void setWeiXinCmsContentMgr(WeiXinCmsContentMgr weiXinCmsContentMgr) {
		this.weiXinCmsContentMgr = weiXinCmsContentMgr;
	}

	public List<WeiXinCmsContentPo> getWeiXinCmsContentList() {
		return weiXinCmsContentList;
	}

	public void setWeiXinCmsContentList(
			List<WeiXinCmsContentPo> weiXinCmsContentList) {
		this.weiXinCmsContentList = weiXinCmsContentList;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	public List<ComplaintsTypePo> getComplaintsTypeList() {
		return complaintsTypeList;
	}

	public void setComplaintsTypeList(List<ComplaintsTypePo> complaintsTypeList) {
		this.complaintsTypeList = complaintsTypeList;
	}

	public CustomerComplainPo getCustomerComplainPo() {
		return customerComplainPo;
	}

	public void setCustomerComplainPo(CustomerComplainPo customerComplainPo) {
		this.customerComplainPo = customerComplainPo;
	}

	public CustomerComplainMgr getCustomerComplainMgr() {
		return customerComplainMgr;
	}

	public void setCustomerComplainMgr(CustomerComplainMgr customerComplainMgr) {
		this.customerComplainMgr = customerComplainMgr;
	}

	public List<WeiXinCmsTypePo> getWeiXinCmsTypeList() {
		return weiXinCmsTypeList;
	}

	public void setWeiXinCmsTypeList(List<WeiXinCmsTypePo> weiXinCmsTypeList) {
		this.weiXinCmsTypeList = weiXinCmsTypeList;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public DepartmentsPo getDepartmentsPo() {
		return departmentsPo;
	}

	public void setDepartmentsPo(DepartmentsPo departmentsPo) {
		this.departmentsPo = departmentsPo;
	}

	public CompanyNamePo getCompanyNamePo() {
		return companyNamePo;
	}

	public void setCompanyNamePo(CompanyNamePo companyNamePo) {
		this.companyNamePo = companyNamePo;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}

	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public List<SalesBasicPo> getSalesBasicList() {
		return salesBasicList;
	}

	public void setSalesBasicList(List<SalesBasicPo> salesBasicList) {
		this.salesBasicList = salesBasicList;
	}

	public WeiXinCmsTypeMgr getWeiXinCmsTypeMgr() {
		return weiXinCmsTypeMgr;
	}

	public void setWeiXinCmsTypeMgr(WeiXinCmsTypeMgr weiXinCmsTypeMgr) {
		this.weiXinCmsTypeMgr = weiXinCmsTypeMgr;
	}
	
}
