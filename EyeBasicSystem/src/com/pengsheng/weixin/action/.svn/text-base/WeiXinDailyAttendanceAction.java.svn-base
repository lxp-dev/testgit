package com.pengsheng.weixin.action;



import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.persistence.IntegralExchangePo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.weixin.mgr.WeiXinDailyAttendanceMgr;
import com.pengsheng.weixin.persistence.DailyAttendance;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;

public class WeiXinDailyAttendanceAction extends BaseAction {
	private WeiXinDailyAttendanceMgr weiXinDailyAttendanceMgr;
	
	private SystemParameterMgr systemParameterMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private PersonPermissionMgr personPermissionMgr;
	
	private DailyAttendance dailyAttendance;
	
	private IntegralExchangePo integralExchangePo;	
	
	private GuitarManagementMgr guitarManagementMgr;
	
	private WeiXinIntegralSelectPo weiXinIntegralSelectPo;
	
	private WarehouseConfigurationMgr warehouseConfigurationMgr;
	
	private List<DailyAttendance> dailyAttendanceSelectList;
	
	public List<DailyAttendance> getDailyAttendanceSelectList() {
		return dailyAttendanceSelectList;
	}

	public void setDailyAttendanceSelectList(
			List<DailyAttendance> dailyAttendanceSelectList) {
		this.dailyAttendanceSelectList = dailyAttendanceSelectList;
	}

	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}

	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
	}

	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}

	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}

	public WeiXinIntegralSelectPo getWeiXinIntegralSelectPo() {
		return weiXinIntegralSelectPo;
	}

	public void setWeiXinIntegralSelectPo(
			WeiXinIntegralSelectPo weiXinIntegralSelectPo) {
		this.weiXinIntegralSelectPo = weiXinIntegralSelectPo;
	}

	public IntegralExchangePo getIntegralExchangePo() {
		return integralExchangePo;
	}

	public void setIntegralExchangePo(IntegralExchangePo integralExchangePo) {
		this.integralExchangePo = integralExchangePo;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public DailyAttendance getDailyAttendance() {
		return dailyAttendance;
	}

	public void setDailyAttendance(DailyAttendance dailyAttendance) {
		this.dailyAttendance = dailyAttendance;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public WeiXinDailyAttendanceMgr getWeiXinDailyAttendanceMgr() {
		return weiXinDailyAttendanceMgr;
	}

	public void setWeiXinDailyAttendanceMgr(
			WeiXinDailyAttendanceMgr weiXinDailyAttendanceMgr) {
		this.weiXinDailyAttendanceMgr = weiXinDailyAttendanceMgr;
	}

	public String initWeiDailyAttendanceSel(){
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
		if(null==dailyAttendance){
			dailyAttendance=new DailyAttendance();
		}
		dailyAttendance=weiXinDailyAttendanceMgr.selectDailyAttendancePo(dailyAttendance);
		return SUCCESS;
	}
	
	public String insertWeiDailyAttendance(){
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
		
		weiXinDailyAttendanceMgr.insertDailyAttendancePo(dailyAttendance);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", "openUpdate2");
		return SUCCESS;
	}
	public String insertWeiXinDailyAttendance(){
		
		dailyAttendance=new DailyAttendance();
		dailyAttendance.setWdlopenid(request.getParameter("openID"));
		dailyAttendance.setWdlintegral(weiXinDailyAttendanceMgr.selectDailyAttendancePo(dailyAttendance).getWdaintegral());
		int dailyAttendanceLogCount = weiXinDailyAttendanceMgr.getDailyAttendanceLogPo(request.getParameter("openID"));
		request.setAttribute("openID", request.getParameter("openID"));
		
		weiXinIntegralSelectPo=new WeiXinIntegralSelectPo();
		weiXinIntegralSelectPo.setWieopenid(request.getParameter("openID"));
		weiXinIntegralSelectPo=guitarManagementMgr.getWeiXinIntegralSelect(weiXinIntegralSelectPo).get(0);
		
		String uuid = "DH"+GenerateNumber.getInstance().getGenerageNumber();
		integralExchangePo = new IntegralExchangePo();
		integralExchangePo.setFiluuid(uuid);
		integralExchangePo.setFilcustomername(weiXinIntegralSelectPo.getWiecustomerid());
		integralExchangePo.setFilmemberid(Utility.getName(weiXinIntegralSelectPo.getWiememberid()));
		integralExchangePo.setFildepartmentid(Utility.getName(""));
		integralExchangePo.setFilpersonid(Utility.getName(""));
		integralExchangePo.setFilintegralsum(Utility.getName(weiXinIntegralSelectPo.getWieintegral()));   //会员原有积分
		integralExchangePo.setFilrefundflag("0");  //标识积分兑换(没有退货的)
		
		
		WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
		tempWarehouseConfigurationPo.setBwcdeptid("");
		WarehouseConfigurationPo warehouseConfigurationPo = warehouseConfigurationMgr.getWarehouseConfiguration(tempWarehouseConfigurationPo);
		integralExchangePo.setFilstock(Utility.getName(warehouseConfigurationPo.getBwcstockid14()));   //积分兑换仓位
		
		
		if(dailyAttendanceLogCount==0){
			weiXinDailyAttendanceMgr.insertDailyAttendanceLogPo(dailyAttendance,integralExchangePo);
			this.clearMessages();
			this.addActionMessage(getText("签到成功！"));
			String url = "''initWeiXinDailyAttendance.action?openID={0}''";
			List<String> params = new ArrayList<String>();
			params.add(Utility.getName(request.getParameter("openID")));
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
		}else{
			this.clearMessages();
			this.addActionMessage(getText("您今日已签过！"));
			String url = "''initWeiXinDailyAttendance.action?openID={0}''";
			List<String> params = new ArrayList<String>();
			params.add(Utility.getName(request.getParameter("openID")));
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
		}
		
		return SUCCESS;
	}
	public String initWeiXinDailyAttendance(){
		request.setAttribute("openID", request.getParameter("openID"));
		return SUCCESS;
	}
	public String initWeiXinDALog() {
		String openID = Utility.getName(request.getParameter("openID"));
		request.setAttribute("openID",openID);
		
		systemParameterPo = systemParameterMgr.getSystemParameterPo();
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());		
		
		//获取品种总数
		int count = weiXinDailyAttendanceMgr.getWeiXinIntegralSelectCount(openID);
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
			dailyAttendanceSelectList = weiXinDailyAttendanceMgr.getDailyAttendanceSelectList(openID, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		}else{
			dailyAttendanceSelectList = null;
		}
		return SUCCESS;
	}
}
