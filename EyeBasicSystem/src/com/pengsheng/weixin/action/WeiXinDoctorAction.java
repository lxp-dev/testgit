package com.pengsheng.weixin.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
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
import com.pengsheng.weixin.mgr.WeiXinDoctorAppraisalMgr;
import com.pengsheng.weixin.mgr.WeiXinDoctorMgr;
import com.pengsheng.weixin.persistence.WeiXinDoctorAppraisalPo;
import com.pengsheng.weixin.persistence.WeiXinDoctorPo;

public class WeiXinDoctorAction  extends BaseAction {
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr; 
	private String isFirstExec;

	private WeiXinDoctorMgr weiXinDoctorMgr;
	private WeiXinDoctorPo weiXinDoctorPo;
	private List<WeiXinDoctorPo> weiXinDoctorList;
	
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	
	private WeiXinDoctorAppraisalMgr weiXinDoctorAppraisalMgr;
	/**
	 * 初始化验光师列表查询
	 */
	public String initWeiXinDoctorSelect() throws Exception {
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
	 * 查询验光师
	 */
	public String selectWeiXinDoctor() throws Exception {
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
		String personid = Utility.getName(request.getParameter("personid"));
		String personname = Utility.getName(request.getParameter("personname"));		
		String zhiwu = Utility.getName(request.getParameter("zhiwu"));
		String wangdianid = Utility.getName(request.getParameter("wangdianid"));
		String zhenliaoid = Utility.getName(request.getParameter("zhenliaoid"));
		
		WeiXinDoctorPo po = new WeiXinDoctorPo();

		po.setWdpersonid(personid);
		po.setWdname(personname);
		po.setWdzhiwu(zhiwu);
		po.setWdwangdian(wangdianid);
		po.setWdzhenliao(zhenliaoid);

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
		int count = weiXinDoctorMgr.selectWeiXinDoctorCount(po);
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
			weiXinDoctorList = weiXinDoctorMgr.selectWeiXinDoctorList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			weiXinDoctorList = null;
		}
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		request.setAttribute("personid", personid);
		request.setAttribute("personname", personname);
		request.setAttribute("zhiwu", zhiwu);
		request.setAttribute("wangdianid", wangdianid);
		request.setAttribute("zhenliaoid", zhenliaoid);
		return SUCCESS;
	}
	
	/**
	 * 初始化验光师信息新增
	 */
	public String initInsertWeiXinDoctorPo() throws Exception {
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
		
		String personID = Utility.getName(request.getParameter("pid"));
		
		if(!personID.equals("")){
			weiXinDoctorPo = weiXinDoctorMgr.selectWeiXinDoctorPo(personID);
		}		
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 验光师信息新增
	 */
	public String insertWeiXinDoctorPo() throws Exception {
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
		String wdfirstshow =Utility.getName(request.getParameter("wdfirstshow"));
		if(wdfirstshow.equals("")){
			wdfirstshow = "0";
		}
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("验光师:" + weiXinDoctorPo.getWdpersonid() + "新增!");
		
		WeiXinDoctorPo tmpWeiXinDoctorPo = new WeiXinDoctorPo();
		tmpWeiXinDoctorPo.setWdpersonid(weiXinDoctorPo.getWdpersonid());
		tmpWeiXinDoctorPo = weiXinDoctorMgr.selectWeiXinDoctorPo(tmpWeiXinDoctorPo);
		if(tmpWeiXinDoctorPo!=null && !Utility.getName(tmpWeiXinDoctorPo.getWdpersonid1()).equals("")){
			
			//获取下拉列表值
			OptionParamPo optionParamPoTmp=new OptionParamPo();
			optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
			
			this.clearMessages();
			this.addActionMessage("该验光师已经配置信息！");
			return "reinsert";
		}
		
		String content = Utility.getName(request.getParameter("content"));
		
		weiXinDoctorPo.setWdcontent(content);
		weiXinDoctorPo.setWdfirstshow(wdfirstshow);
		
		this.clearMessages();
		
		if (!Utility.getName(weiXinDoctorPo.getWdpicurl()).equals("")) {
			weiXinDoctorPo.setWdpicurl(weiXinDoctorPo.getWdpicurl().replaceAll(
					",", ""));
		}
		
		weiXinDoctorMgr.insertWeiXinDoctorPo(weiXinDoctorPo, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化验光师信息更新
	 */
	public String initUpdateWeiXinDoctorPo() throws Exception {
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
		
		WeiXinDoctorPo po = new WeiXinDoctorPo();
		po.setWdid(hid);
		
		weiXinDoctorPo = weiXinDoctorMgr.selectWeiXinDoctorPo(po);
		
		List<WeiXinDoctorAppraisalPo> weiXinDoctorAppraisalPoList = new ArrayList<WeiXinDoctorAppraisalPo>();
		weiXinDoctorAppraisalPoList = weiXinDoctorAppraisalMgr.selectWeiXinDoctorAppraisalList(weiXinDoctorPo.getWdpersonid());
		request.setAttribute("weiXinDoctorAppraisalPoList", weiXinDoctorAppraisalPoList);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}
	
	/**
	 * 验光师信息更新
	 */
	public String updateWeiXinDoctorPo() throws Exception {
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
		String wdfirstshow =Utility.getName(request.getParameter("wdfirstshow"));
		if(wdfirstshow.equals("")){
			wdfirstshow = "0";
		}
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("验光师编号:" + weiXinDoctorPo.getWdid() +"修改!");
		this.clearMessages();
		
		String content = Utility.getName(request.getParameter("content"));
		weiXinDoctorPo.setWdcontent(content);
		weiXinDoctorPo.setWdfirstshow(wdfirstshow);
		
		if (!Utility.getName(weiXinDoctorPo.getWdpicurl()).equals("")) {
			weiXinDoctorPo.setWdpicurl(weiXinDoctorPo.getWdpicurl().replaceAll(
					",", ""));
		}
		
		weiXinDoctorMgr.updateWeiXinDoctorPo(weiXinDoctorPo,logPo);		
		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化验光师信息删除
	 */
	public String initDeleteWeiXinDoctorPo()throws Exception{
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
		
		WeiXinDoctorPo po = new WeiXinDoctorPo();
		po.setWdid(hid);
		
		weiXinDoctorPo = weiXinDoctorMgr.selectWeiXinDoctorPo(po);

		return SUCCESS;
	}
	
	/**
	 * 删除验光师信息
	 */
	public String deleteWeiXinDoctorPo()throws Exception{
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
		logPo.setsLogContent("验光师编号:" + weiXinDoctorPo.getWdid() +"删除!");
		
		weiXinDoctorMgr.deleteWeiXinDoctorPo(weiXinDoctorPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 取得Ajax数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public void getAjaxDoctor() throws Exception {
		
		String wangdian = Utility.getName(request.getParameter("wangdian"));
		String zhenliao = Utility.getName(request.getParameter("zhenliao"));
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();

		WeiXinDoctorPo weiXinDoctorPo = new WeiXinDoctorPo();
		weiXinDoctorPo.setWdwangdian(wangdian);
		weiXinDoctorPo.setWdzhenliao(zhenliao);
		List<WeiXinDoctorPo> doctorList =  weiXinDoctorMgr.selectWeiXinDoctorList(weiXinDoctorPo);
		Iterator it = doctorList.iterator();
		out.println("<option value=''>请选择("
				+ doctorList.size() + ")</option>");
		if (it.hasNext()) {
			while (it.hasNext()) {
				WeiXinDoctorPo tmpPo = (WeiXinDoctorPo) it
						.next();
				out.println("<option value='" + tmpPo.getWdpersonid() + "'>"
						+ tmpPo.getWdname() + "</option>");
			}
		}
		
		out.close();		
	}
	
	/**
	 * 取得Ajax数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public void getAjaxWorkday() throws Exception {
		
		String doctorid = Utility.getName(request.getParameter("doctorid"));

		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();

		WeiXinDoctorPo weiXinDoctorPo = new WeiXinDoctorPo();
		weiXinDoctorPo.setWdpersonid(doctorid);
		
		weiXinDoctorPo =  weiXinDoctorMgr.selectWeiXinDoctorPo(weiXinDoctorPo);
		
		out.println(weiXinDoctorPo.getWdworkday());
		out.close();		
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


	public WeiXinDoctorMgr getWeiXinDoctorMgr() {
		return weiXinDoctorMgr;
	}


	public void setWeiXinDoctorMgr(WeiXinDoctorMgr weiXinDoctorMgr) {
		this.weiXinDoctorMgr = weiXinDoctorMgr;
	}


	public WeiXinDoctorPo getWeiXinDoctorPo() {
		return weiXinDoctorPo;
	}


	public void setWeiXinDoctorPo(WeiXinDoctorPo weiXinDoctorPo) {
		this.weiXinDoctorPo = weiXinDoctorPo;
	}


	public List<WeiXinDoctorPo> getWeiXinDoctorList() {
		return weiXinDoctorList;
	}


	public void setWeiXinDoctorList(List<WeiXinDoctorPo> weiXinDoctorList) {
		this.weiXinDoctorList = weiXinDoctorList;
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

	public WeiXinDoctorAppraisalMgr getWeiXinDoctorAppraisalMgr() {
		return weiXinDoctorAppraisalMgr;
	}

	public void setWeiXinDoctorAppraisalMgr(
			WeiXinDoctorAppraisalMgr weiXinDoctorAppraisalMgr) {
		this.weiXinDoctorAppraisalMgr = weiXinDoctorAppraisalMgr;
	}

	
}
