package com.pengsheng.mall.action;


import java.util.Iterator;
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
import com.pengsheng.mall.mgr.MallAreaMgr;
import com.pengsheng.mall.mgr.MallBrandMgr;
import com.pengsheng.mall.mgr.MallTypeSmallMgr;
import com.pengsheng.mall.mgr.MallTypeLargeMgr;
import com.pengsheng.mall.po.MallAreaPo;
import com.pengsheng.mall.po.MallBrandPo;
import com.pengsheng.mall.po.MallTypeSmallPicPo;
import com.pengsheng.mall.po.MallTypeSmallPo;
import com.pengsheng.mall.po.MallTypeLargePo;

public class MallTypeSmallAction  extends BaseAction {
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr; 
	private String isFirstExec;
	
	private MallTypeSmallPo mallTypeSmallPo;
	private MallTypeSmallMgr mallTypeSmallMgr;
	private List<MallTypeSmallPo> mallTypeSmallList;
	
	private MallTypeLargeMgr mallTypeLargeMgr;	
	private List<MallTypeLargePo> mallTypeLargeList;
	private List<MallTypeSmallPicPo> mallTypeSmallPicList;
	
	private List<MallBrandPo> mallBrandList;
	private MallBrandMgr mallBrandMgr;
	
	private List<MallAreaPo> mallAreaList;
	private MallAreaMgr mallAreaMgr;
	/**
	 * 初始化商品查询
	 */
	public String initMallTypeSmallSelect() throws Exception {
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
		
		mallTypeLargeList = mallTypeLargeMgr.getMallTypeLargePoList(new MallTypeLargePo());
		mallBrandList = mallBrandMgr.getMallBrandPoList(new MallBrandPo());
		mallAreaList = mallAreaMgr.getMallAreaPoList(new MallAreaPo());
		
		return SUCCESS;
	}
	
	/**
	 * 查询商品
	 */
	public String selectMallTypeSmall() throws Exception {
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
		String mtsname = Utility.getName(request.getParameter("mtsname"));
		String mtslargeid = Utility.getName(request.getParameter("mtslargeid"));		
		String mtsflag = Utility.getName(request.getParameter("mtsflag"));
		
		MallTypeSmallPo po = new MallTypeSmallPo();

		po.setMtsname(mtsname);
		po.setMtslargeid(mtslargeid);
		po.setMtsflag(mtsflag);
		
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

		// 查询分页
		int count = mallTypeSmallMgr.getMallTypeSmallPoCount(po);
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
			mallTypeSmallList = mallTypeSmallMgr.getMallTypeSmallPoList(po, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			mallTypeSmallList = null;
		}
		
		mallTypeLargeList = mallTypeLargeMgr.getMallTypeLargePoList(new MallTypeLargePo());
		mallBrandList = mallBrandMgr.getMallBrandPoList(new MallBrandPo());
		mallAreaList = mallAreaMgr.getMallAreaPoList(new MallAreaPo());
		
		request.setAttribute("mtsname", mtsname);
		request.setAttribute("mtslargeid", mtslargeid);
		request.setAttribute("mtsflag", mtsflag);

		return SUCCESS;
	}
	
	/**
	 * 初始化商品信息新增
	 */
	public String initInsertMallTypeSmallPo() throws Exception {
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
		
		mallTypeLargeList = mallTypeLargeMgr.getMallTypeLargePoList(new MallTypeLargePo());
		mallBrandList = mallBrandMgr.getMallBrandPoList(new MallBrandPo());
		mallAreaList = mallAreaMgr.getMallAreaPoList(new MallAreaPo());
		
		return SUCCESS;
	}

	/**
	 * 商品信息新增
	 */
	public String insertMallTypeSmallPo() throws Exception {
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
		
		String content = Utility.getName(request.getParameter("content"));
		mallTypeSmallPo.setMtscontent(content);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示状态
		logPo.setsLogContent("商品:" + mallTypeSmallPo.getMtsname() + "新增!");
		
		if ("1".equals(request.getParameter("stateFlag"))) {
			mallTypeSmallPo.setMtsflag("1");
		} else {
			mallTypeSmallPo.setMtsflag("0");
		}
		
		this.clearMessages();
		
		if (!Utility.getName(mallTypeSmallPo.getMtspicurl()).equals("")) {
			mallTypeSmallPo.setMtspicurl(mallTypeSmallPo.getMtspicurl().replaceAll(
					",", ""));
		}
		
		
		mallTypeSmallMgr.insertMallTypeSmallPo(mallTypeSmallPo, logPo);
		
		mallTypeLargeList = mallTypeLargeMgr.getMallTypeLargePoList(new MallTypeLargePo());

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化商品信息更新
	 */
	public String initUpdateMallTypeSmallPo() throws Exception {
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
		
		MallTypeSmallPo po = new MallTypeSmallPo();
		po.setMtsid(hid);
		
		mallTypeSmallPo = mallTypeSmallMgr.getMallTypeSmallPo(po);
		
		mallTypeLargeList = mallTypeLargeMgr.getMallTypeLargePoList(new MallTypeLargePo());
		mallBrandList = mallBrandMgr.getMallBrandPoList(new MallBrandPo());
		mallAreaList = mallAreaMgr.getMallAreaPoList(new MallAreaPo());
		
		return SUCCESS;
	}
	
	/**
	 * 商品信息更新
	 */
	public String updateMallTypeSmallPo() throws Exception {
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
		
		String content = Utility.getName(request.getParameter("content"));
		mallTypeSmallPo.setMtscontent(content);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("商品编号:" + mallTypeSmallPo.getMtsid() +"修改!");
		this.clearMessages();
		
		if ("1".equals(request.getParameter("stateFlag"))) {
			mallTypeSmallPo.setMtsflag("1");
		} else {
			mallTypeSmallPo.setMtsflag("0");
		}
		
		if (!Utility.getName(mallTypeSmallPo.getMtspicurl()).equals("")) {
			mallTypeSmallPo.setMtspicurl(mallTypeSmallPo.getMtspicurl().replaceAll(
					",", ""));
		}
		
		mallTypeSmallMgr.updateMallTypeSmallPo(mallTypeSmallPo,logPo);		
		mallTypeLargeList = mallTypeLargeMgr.getMallTypeLargePoList(new MallTypeLargePo());
		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	
	/**
	 * 初始化商品信息删除
	 */
	public String initDeleteMallTypeSmallPo()throws Exception{
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
		
		MallTypeSmallPo po = new MallTypeSmallPo();
		po.setMtsid(hid);
		
		mallTypeSmallPo = mallTypeSmallMgr.getMallTypeSmallPo(po);

		return SUCCESS;
	}
	
	/**
	 * 删除商品信息
	 */
	public String deleteMallTypeSmallPo()throws Exception{
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
		MallTypeSmallPo po = new MallTypeSmallPo();
		po.setMtsid(hid);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("商品编号:" + hid +"删除!");
		
		mallTypeSmallMgr.deleteMallTypeSmallPo(po, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化商品信息停用启用
	 */
	public String initMallTypeSmallPoAble()throws Exception{
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
		
		MallTypeSmallPo po = new MallTypeSmallPo();
		po.setMtsid(hid);
		
		mallTypeSmallPo = mallTypeSmallMgr.getMallTypeSmallPo(po);

		return SUCCESS;
	}
	
	/**
	 * 商品信息停用启用
	 */
	public String updateMallTypeSmallPoAble()throws Exception{
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
		
		if (Utility.getName(mallTypeSmallPo.getMtsflag()).equals("1")){
			logPo.setsLogOpID("39");    // 表示状态  39 停用  38 启用
			logPo.setsLogContent("商品编号:" + mallTypeSmallPo.getMtsid() +"停用!");
		}else{
			logPo.setsLogOpID("38");    // 表示状态  39 停用  38 启用
			logPo.setsLogContent("商品编号:" + mallTypeSmallPo.getMtsid() +"启用!");
		}
		
		if("0".equals(mallTypeSmallPo.getMtsflag())){
			mallTypeSmallPo.setMtsflag("1");
		}else if("1".equals(mallTypeSmallPo.getMtsflag())){
			mallTypeSmallPo.setMtsflag("0");
		}
		
		mallTypeSmallMgr.updateMallTypeSmallFlag(mallTypeSmallPo, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	/**
	 * 初始化滚动导航图更新
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initMallTypeSmallPicUpdate() throws Exception {

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
		String smallID = Utility.getName(request.getParameter("hid"));

		mallTypeSmallPo = new MallTypeSmallPo();
		mallTypeSmallPo.setMtsid(smallID);
		mallTypeSmallPo = mallTypeSmallMgr.getMallTypeSmallPo(mallTypeSmallPo);

		mallTypeSmallPicList = mallTypeSmallMgr.getMallTypeSmallPicList(smallID);

		String picurls = "";
		// 将实景图List转换为字符串，存入po中的picurls(图片URLs),每个图片路径后加逗号（，）
		if (mallTypeSmallPicList != null
				&& mallTypeSmallPicList.size() > 0) {

			Iterator<MallTypeSmallPicPo> it = mallTypeSmallPicList.iterator();
			while (it.hasNext()) {
				MallTypeSmallPicPo mallTypeSmallPicPotmp = (MallTypeSmallPicPo) it
						.next();
				if (mallTypeSmallPicPotmp.getMtsppicUrl() != null
						&& !Utility.getName(
								mallTypeSmallPicPotmp.getMtsppicUrl())
								.equals("")) {
					picurls = picurls + mallTypeSmallPicPotmp.getMtsppicUrl()
							+ ",";
				}
			}
			mallTypeSmallPo.setMtspicurls(picurls);
		}

		return SUCCESS;
	}

	/**
	 * 上传滚动导航图
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateMallTypeSmallPic() throws Exception {
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
		// 添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("商品："
				+ mallTypeSmallPo.getMtsid() + "上传滚动导航图!");

		
		mallTypeSmallMgr.updateMallTypeSmallPic(mallTypeSmallPo, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

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

	public MallTypeSmallPo getMallTypeSmallPo() {
		return mallTypeSmallPo;
	}

	public void setMallTypeSmallPo(MallTypeSmallPo mallTypeSmallPo) {
		this.mallTypeSmallPo = mallTypeSmallPo;
	}

	public MallTypeSmallMgr getMallTypeSmallMgr() {
		return mallTypeSmallMgr;
	}

	public void setMallTypeSmallMgr(MallTypeSmallMgr mallTypeSmallMgr) {
		this.mallTypeSmallMgr = mallTypeSmallMgr;
	}

	public List<MallTypeSmallPo> getMallTypeSmallList() {
		return mallTypeSmallList;
	}

	public void setMallTypeSmallList(
			List<MallTypeSmallPo> mallTypeSmallList) {
		this.mallTypeSmallList = mallTypeSmallList;
	}

	public List<MallTypeLargePo> getMallTypeLargeList() {
		return mallTypeLargeList;
	}

	public void setMallTypeLargeList(List<MallTypeLargePo> mallTypeLargeList) {
		this.mallTypeLargeList = mallTypeLargeList;
	}

	public MallTypeLargeMgr getMallTypeLargeMgr() {
		return mallTypeLargeMgr;
	}

	public void setMallTypeLargeMgr(MallTypeLargeMgr mallTypeLargeMgr) {
		this.mallTypeLargeMgr = mallTypeLargeMgr;
	}

	public List<MallTypeSmallPicPo> getMallTypeSmallPicList() {
		return mallTypeSmallPicList;
	}

	public void setMallTypeSmallPicList(
			List<MallTypeSmallPicPo> mallTypeSmallPicList) {
		this.mallTypeSmallPicList = mallTypeSmallPicList;
	}

	public List<MallBrandPo> getMallBrandList() {
		return mallBrandList;
	}

	public void setMallBrandList(List<MallBrandPo> mallBrandList) {
		this.mallBrandList = mallBrandList;
	}

	public MallBrandMgr getMallBrandMgr() {
		return mallBrandMgr;
	}

	public void setMallBrandMgr(MallBrandMgr mallBrandMgr) {
		this.mallBrandMgr = mallBrandMgr;
	}

	public List<MallAreaPo> getMallAreaList() {
		return mallAreaList;
	}

	public void setMallAreaList(List<MallAreaPo> mallAreaList) {
		this.mallAreaList = mallAreaList;
	}

	public MallAreaMgr getMallAreaMgr() {
		return mallAreaMgr;
	}

	public void setMallAreaMgr(MallAreaMgr mallAreaMgr) {
		this.mallAreaMgr = mallAreaMgr;
	}
	
}
