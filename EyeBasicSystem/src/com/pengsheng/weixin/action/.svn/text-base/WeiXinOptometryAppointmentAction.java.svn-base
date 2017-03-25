package com.pengsheng.weixin.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SendNoteMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SendNotePo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.weixin.mgr.ConfigurationMgr;
import com.pengsheng.weixin.mgr.WeiXinCmsContentMgr;
import com.pengsheng.weixin.mgr.WeiXinDataConfigMgr;
import com.pengsheng.weixin.mgr.WeiXinDepartmentsMgr;
import com.pengsheng.weixin.mgr.WeiXinOptometryAppointmentMgr;
import com.pengsheng.weixin.mgr.WeiXinRegisterDepartmentMgr;
import com.pengsheng.weixin.persistence.WeiXinCmsContentPo;
import com.pengsheng.weixin.persistence.WeiXinDataConfigPo;
import com.pengsheng.weixin.persistence.WeiXinOptometryAppointmentPo;
import com.pengsheng.weixin.persistence.WeiXinRegisterDepartmentPo;
import com.pengsheng.weixin.util.SendWeChatMessage;

public class WeiXinOptometryAppointmentAction  extends BaseAction {
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr; 
	private String isFirstExec;

	private WeiXinOptometryAppointmentMgr weiXinOptometryAppointmentMgr;
	private WeiXinOptometryAppointmentPo weiXinOptometryAppointmentPo;
	private List<WeiXinOptometryAppointmentPo> weiXinOptometryAppointmentList;
	
	private WeiXinDepartmentsMgr weiXinDepartmentsMgr;
	private List<DepartmentsPo> departmentList = null;
	
	private WeiXinCmsContentPo weiXinCmsContentPo;
	private WeiXinCmsContentMgr weiXinCmsContentMgr;
	private ConfigurationMgr configurationMgr;
	private WeiXinDataConfigMgr weiXinDataConfigMgr;
	
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;;
	private SendNoteMgr sendNoteMgr;	
	private WeiXinRegisterDepartmentMgr weiXinRegisterDepartmentMgr;
	
	/**
	 * 初始化预约列表查询
	 */
	public String initWeiXinOptometryAppointmentSelect() throws Exception {
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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 查询预约
	 */
	public String selectWeiXinOptometryAppointment() throws Exception {
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
		String wangdianid = Utility.getName(request.getParameter("wangdianid"));
		String name = Utility.getName(request.getParameter("name"));		
		String mobilephone = Utility.getName(request.getParameter("mobilephone"));
		String isconfirm = Utility.getName(request.getParameter("isconfirm"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		
		WeiXinOptometryAppointmentPo po = new WeiXinOptometryAppointmentPo();

		po.setWoawangdian(wangdianid);
		po.setWoaname(name);
		po.setWoamobilephone(mobilephone);
		po.setWoaisconfirm(isconfirm);
		po.setWoastartTime(startTime);
		po.setWoaendTime(endTime);
		
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
		int count = weiXinOptometryAppointmentMgr.selectWeiXinOptometryAppointmentCount(po);
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
			weiXinOptometryAppointmentList = weiXinOptometryAppointmentMgr.selectWeiXinOptometryAppointmentList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			weiXinOptometryAppointmentList = null;
		}
		
//		departmentList = weiXinDepartmentsMgr.getDepartmentsList(new DepartmentsPo());
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		request.setAttribute("wangdianid", wangdianid);
		request.setAttribute("name", name);
		request.setAttribute("mobilephone", mobilephone);
		request.setAttribute("isconfirm", isconfirm);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		return SUCCESS;
	}
	
	/**
	 * 初始化预约信息新增
	 */
	public String initInsertWeiXinOptometryAppointmentPo() throws Exception {
		
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		//微信号对应原始ID写入Session
		String toUserName = Utility.getName(request.getParameter("toUserName"));
		if(!toUserName.equals("")){
			request.getSession().setAttribute("toUserName", toUserName);
		}else if(request.getSession().getAttribute("toUserName")!=null && !request.getSession().getAttribute("toUserName").toString().equals("")){
			toUserName = request.getSession().getAttribute("toUserName").toString();
		}
		//微信号对应原始ID写入Session
		request.setAttribute("toUserName", toUserName);
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断
		
//		DepartmentsPo departmentsPo = new DepartmentsPo();
//		departmentsPo.setBdpisoptometryappointment("0");
//		departmentList = weiXinDepartmentsMgr.getDepartmentsList(departmentsPo);
		
		WeiXinDataConfigPo weiXinDataConfigPo =  weiXinDataConfigMgr.getWeiXinDataConfigPo();
		WeiXinCmsContentPo po = new WeiXinCmsContentPo();
		po.setWcmscid(weiXinDataConfigPo.getWdcoptometryappointment());
		
		weiXinCmsContentPo = weiXinCmsContentMgr.selectWeiXinCmsContentPo(po);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 预约信息新增
	 */
	public String insertWeiXinOptometryAppointmentPo() throws Exception {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		String toUserName = Utility.getName(request.getParameter("toUserName"));
		if(toUserName.equals("") && session.get("toUserName")!=null && !session.get("toUserName").toString().equals("")){
			toUserName = session.get("toUserName").toString();
		}
		
		if(toUserName.equals("")){
			return "weixinSessionOut";
		}
		
		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName("weixin");
		logPo.setsLogIP(this.request.getRemoteAddr());
		logPo.setsLogResult("");
		logPo.setsLogOpID("1");
		logPo.setsLogContent("预约:" + weiXinOptometryAppointmentPo.getWoaname() + "新增!");

		this.clearMessages();
		weiXinOptometryAppointmentPo.setWoaopencustomerid(customerInfoPo.getSmecicustomerid());
		weiXinOptometryAppointmentPo.setWoaaccount(toUserName);
		weiXinOptometryAppointmentMgr.insertWeiXinOptometryAppointmentPo(weiXinOptometryAppointmentPo, logPo);
		
		departmentList = weiXinDepartmentsMgr.getDepartmentsList(new DepartmentsPo());

		this.clearMessages(); 
		String url = "''initInsertWeiXinOptometryAppointmentOK.action?openID={0}''";
		List<String> params = new ArrayList<String>();
		params.add(openID);
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}

	/**
	 * 预约信息新增成功
	 */
	public String initInsertWeiXinOptometryAppointmentOK() throws Exception {

		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断
		
		WeiXinDataConfigPo weiXinDataConfigPo = weiXinDataConfigMgr.getWeiXinDataConfigPo();
		request.setAttribute("weiXinDataConfigPo", weiXinDataConfigPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化预约信息更新
	 */
	public String initUpdateWeiXinOptometryAppointmentPo() throws Exception {
		
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
		
		WeiXinOptometryAppointmentPo po = new WeiXinOptometryAppointmentPo();
		po.setWoaid(hid);
		
		weiXinOptometryAppointmentPo = weiXinOptometryAppointmentMgr.selectWeiXinOptometryAppointmentPo(po);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
//		departmentList = weiXinDepartmentsMgr.getDepartmentsList(new DepartmentsPo());
		
		return SUCCESS;
	}
	
	/**
	 * 预约信息更新
	 */
	public String updateWeiXinOptometryAppointmentPo() throws Exception {
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
		logPo.setsLogContent("预约编号:" + weiXinOptometryAppointmentPo.getWoaname() +"修改!");
		this.clearMessages();
		weiXinOptometryAppointmentPo.setWoaconfirmpersonid(personInfoPo.getId());
		weiXinOptometryAppointmentMgr.updateWeiXinOptometryAppointmentPo(weiXinOptometryAppointmentPo,logPo);		
		departmentList = weiXinDepartmentsMgr.getDepartmentsList(new DepartmentsPo());
		
		//根据微信公众号原始ID取得APPSECRET
		WeiXinRegisterDepartmentPo weiXinRegisterDepartmentPo = new WeiXinRegisterDepartmentPo();
		weiXinRegisterDepartmentPo.setWrdaccount(weiXinOptometryAppointmentPo.getWoaaccount());
		weiXinRegisterDepartmentPo = weiXinRegisterDepartmentMgr.getWeiXinRegisterDepartmentPo(weiXinRegisterDepartmentPo);
		//根据微信公众号原始ID取得APPSECRET
		
		//----------如果预约成功（1）或预约失败（2），确认结果时，向微信用户发送预约结果信息-------------
		if(weiXinOptometryAppointmentPo.getWoaisconfirm().equals("1") || weiXinOptometryAppointmentPo.getWoaisconfirm().equals("2")){
			weiXinOptometryAppointmentPo = weiXinOptometryAppointmentMgr.selectWeiXinOptometryAppointmentPo(weiXinOptometryAppointmentPo);
			String sendMsg = "预约结果：\n"+weiXinOptometryAppointmentPo.getWoaname()+"于"+ weiXinOptometryAppointmentPo.getWoadatetime().substring(0,10) +"日在" +weiXinOptometryAppointmentPo.getWoawangdianname()+"预约的"+ weiXinOptometryAppointmentPo.getWoazhenliaoname() +"";		
			if(weiXinOptometryAppointmentPo.getWoaisconfirm().equals("1")){
				CustomerInfoPo customerInfoPo = new CustomerInfoPo();
				customerInfoPo.setSmecicustomerid(weiXinOptometryAppointmentPo.getWoaopencustomerid());
				customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);
				sendMsg = sendMsg +"预约成功！";
				if(!customerInfoPo.getOpenid().equals("")){					
					new SendWeChatMessage().sendMessage(weiXinRegisterDepartmentPo.getWrdappid(),weiXinRegisterDepartmentPo.getWrdappsecret(),customerInfoPo.getOpenid(),sendMsg);
				}
			}
			if(weiXinOptometryAppointmentPo.getWoaisconfirm().equals("2")){
				CustomerInfoPo customerInfoPo = new CustomerInfoPo();
				customerInfoPo.setSmecicustomerid(weiXinOptometryAppointmentPo.getWoaopencustomerid());
				customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);
				sendMsg = sendMsg +"预约失败！";
				if(!customerInfoPo.getOpenid().equals("")){
					new SendWeChatMessage().sendMessage(weiXinRegisterDepartmentPo.getWrdappid(),weiXinRegisterDepartmentPo.getWrdappsecret(),customerInfoPo.getOpenid(),sendMsg);
				}
			}
			
			SendNotePo snpo = new SendNotePo();
			snpo.setSncustomertelphone(weiXinOptometryAppointmentPo.getWoamobilephone());
			snpo.setSnnotecontent(sendMsg);
			snpo.setSnpersonid("");
			snpo.setSnnotetypeid("17");
			snpo.setSnsenddate("");
			snpo.setSnpersonid("");
			sendNoteMgr.sendNote(snpo);
		}
		//----------如果预约成功（1）或预约失败（2），确认结果时，向微信用户发送预约结果信息-------------
		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化预约信息删除
	 */
	public String initDeleteWeiXinOptometryAppointmentPo()throws Exception{
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
		
		WeiXinOptometryAppointmentPo po = new WeiXinOptometryAppointmentPo();
		po.setWoaid(hid);
		
		weiXinOptometryAppointmentPo = weiXinOptometryAppointmentMgr.selectWeiXinOptometryAppointmentPo(po);

		return SUCCESS;
	}
	
	/**
	 * 删除预约信息
	 */
	public String deleteWeiXinOptometryAppointmentPo()throws Exception{
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
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("预约编号:" + weiXinOptometryAppointmentPo.getWoaname() +"删除!");
		
		weiXinOptometryAppointmentMgr.deleteWeiXinOptometryAppointmentPo(weiXinOptometryAppointmentPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 预约结果信息
	 */
	public String initWeiXinOptometryAppointmentResult()throws Exception{
		
		// openID判断
		String openID = Utility.getName(request.getParameter("openID"));
		if (openID.equals("")) {
			return "weixinSessionOut";
		}
		request.setAttribute("openID", openID);

		CustomerInfoPo customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setOpenid(openID);
		customerInfoPo = configurationMgr.getCustomerInfoByOpenID(customerInfoPo);

		if (customerInfoPo == null
				|| Utility.getName(customerInfoPo.getSmecicustomerid()).equals(
						"")) {
			return "weiXinMemberBindSel";
		}
		// openID判断
		
		WeiXinOptometryAppointmentPo po = new WeiXinOptometryAppointmentPo();
		po.setWoaopencustomerid(customerInfoPo.getSmecicustomerid());

		weiXinOptometryAppointmentList = weiXinOptometryAppointmentMgr.selectWeiXinOptometryAppointmentList(po);

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


	public WeiXinOptometryAppointmentMgr getWeiXinOptometryAppointmentMgr() {
		return weiXinOptometryAppointmentMgr;
	}


	public void setWeiXinOptometryAppointmentMgr(WeiXinOptometryAppointmentMgr weiXinOptometryAppointmentMgr) {
		this.weiXinOptometryAppointmentMgr = weiXinOptometryAppointmentMgr;
	}


	public WeiXinOptometryAppointmentPo getWeiXinOptometryAppointmentPo() {
		return weiXinOptometryAppointmentPo;
	}


	public void setWeiXinOptometryAppointmentPo(WeiXinOptometryAppointmentPo weiXinOptometryAppointmentPo) {
		this.weiXinOptometryAppointmentPo = weiXinOptometryAppointmentPo;
	}


	public List<WeiXinOptometryAppointmentPo> getWeiXinOptometryAppointmentList() {
		return weiXinOptometryAppointmentList;
	}


	public void setWeiXinOptometryAppointmentList(List<WeiXinOptometryAppointmentPo> weiXinOptometryAppointmentList) {
		this.weiXinOptometryAppointmentList = weiXinOptometryAppointmentList;
	}


	public WeiXinDepartmentsMgr getWeiXinDepartmentsMgr() {
		return weiXinDepartmentsMgr;
	}


	public void setWeiXinDepartmentsMgr(WeiXinDepartmentsMgr weiXinDepartmentsMgr) {
		this.weiXinDepartmentsMgr = weiXinDepartmentsMgr;
	}


	public List<DepartmentsPo> getDepartmentList() {
		return departmentList;
	}


	public void setDepartmentList(List<DepartmentsPo> departmentList) {
		this.departmentList = departmentList;
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

	public ConfigurationMgr getConfigurationMgr() {
		return configurationMgr;
	}

	public void setConfigurationMgr(ConfigurationMgr configurationMgr) {
		this.configurationMgr = configurationMgr;
	}

	public WeiXinDataConfigMgr getWeiXinDataConfigMgr() {
		return weiXinDataConfigMgr;
	}

	public void setWeiXinDataConfigMgr(WeiXinDataConfigMgr weiXinDataConfigMgr) {
		this.weiXinDataConfigMgr = weiXinDataConfigMgr;
	}

	public List<OptionParamPo> getOptionParamPolist() {
		return optionParamPolist;
	}

	public void setOptionParamPolist(List<OptionParamPo> optionParamPolist) {
		this.optionParamPolist = optionParamPolist;
	}

	public OptionParamMgr getOptionParamMgr() {
		return optionParamMgr;
	}

	public void setOptionParamMgr(OptionParamMgr optionParamMgr) {
		this.optionParamMgr = optionParamMgr;
	}

	public SendNoteMgr getSendNoteMgr() {
		return sendNoteMgr;
	}

	public void setSendNoteMgr(SendNoteMgr sendNoteMgr) {
		this.sendNoteMgr = sendNoteMgr;
	}

	public WeiXinRegisterDepartmentMgr getWeiXinRegisterDepartmentMgr() {
		return weiXinRegisterDepartmentMgr;
	}

	public void setWeiXinRegisterDepartmentMgr(
			WeiXinRegisterDepartmentMgr weiXinRegisterDepartmentMgr) {
		this.weiXinRegisterDepartmentMgr = weiXinRegisterDepartmentMgr;
	}

	
}
