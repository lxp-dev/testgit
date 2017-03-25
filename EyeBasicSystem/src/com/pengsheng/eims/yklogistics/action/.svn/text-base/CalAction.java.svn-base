package com.pengsheng.eims.yklogistics.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.yklogistics.mgr.CalMgr;
import com.pengsheng.eims.yklogistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LCTCostingTempPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class CalAction extends BaseAction {

	private LogisticsLogMgr yklogisticsLogMgr = null;	
	private PersonPermissionMgr personPermissionMgr = null;	
	private CalMgr ykcalMgr;	
	private List<LCTCostingTempPo> resultList;
	
	public LogisticsLogMgr getYklogisticsLogMgr() {
		return yklogisticsLogMgr;
	}
	public void setYklogisticsLogMgr(LogisticsLogMgr yklogisticsLogMgr) {
		this.yklogisticsLogMgr = yklogisticsLogMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public List<LCTCostingTempPo> getResultList() {
		return resultList;
	}
	public void setResultList(List<LCTCostingTempPo> resultList) {
		this.resultList = resultList;
	}
	public CalMgr getYkcalMgr() {
		return ykcalMgr;
	}
	public void setYkcalMgr(CalMgr ykcalMgr) {
		this.ykcalMgr = ykcalMgr;
	}
	
	public String initCalSel() throws Exception {
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
		/** ********************** 权限设置 ******************************/
		
		getCurrentDate();
		return SUCCESS;
	}

	private void getCurrentDate(){
   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));
	}
	
	public String realCalStorage() throws Exception {

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
		/** ********************** 权限设置 ******************************/
		
		String currDate = Utility.getName(request.getParameter("currDate"));
		String lastDate = Utility.getName(request.getParameter("lastDate"));
		String isAvgCal = Utility.getName(request.getParameter("isAvgCal"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());

		logPo.setsLogResult(moduleID); // 表示模块名称 
//		logPo.setsLogResult("12"); // 12 表示开始 
		logPo.setsLogOpID("1");   // 1 表示加权平均计算
		logPo.setsLogContent("加权平均计算时间：" + currDate);		
		yklogisticsLogMgr.insertLog(logPo);  //新增日志

		getCurrentDate();
		request.setAttribute("date", currDate);
		
		int count = ykcalMgr.selCurrentDate(lastDate);
		if (count > 0){
			logPo.setsLogContent("加权平均计算时间：" + currDate + " 完成!");		
			ykcalMgr.insertRealCalStorage(currDate,logPo);
		}else{			
			
//			logPo.setsLogResult("14"); // 11 表示失败 
//			logisticsLogMgr.insertLog(logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("无法进行成本计算!"));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			return SUCCESS;
		}
		
		request.setAttribute("isAvgCal",isAvgCal);
		
//		logPo.setsLogResult("11"); // 11 表示成功 
//		logisticsLogMgr.insertLog(logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("加权平均计算完毕!"));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}
	
	public String moniCalRetrun() throws Exception {

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
		/** ********************** 权限设置 ******************************/
	
		String date = Utility.getName(request.getParameter("date"));
		String isCostCal = Utility.getName(request.getParameter("isCostCal"));
		String isAvgCal = Utility.getName(request.getParameter("isAvgCal"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
//		logPo.setsLogResult("12"); // 12 表示开始 
		logPo.setsLogOpID("2");   // 2 表示计算单位成本
		logPo.setsLogContent("计算单位成本时间：" + date);		
		yklogisticsLogMgr.insertLog(logPo);  //新增日志
		
		logPo.setsLogContent("计算单位成本时间：" + date + " 完成!");	
		ykcalMgr.insertMoniCalRetrun(logPo);
		getCurrentDate();
		
//		logPo.setsLogResult("11"); // 11 表示成功 
//		logisticsLogMgr.insertLog(logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("单位成本计算完毕!"));
		
		request.setAttribute("date", date);
		request.setAttribute("isCostCal", isCostCal);		
		request.setAttribute("isAvgCal",isAvgCal);
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}
	
	public String realCalReturn() throws Exception {

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
		/** ********************** 权限设置 ******************************/
		
		String date=Utility.getName(request.getParameter("date"));	
		getCurrentDate();
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());

		logPo.setsLogResult(moduleID); // 表示模块名称 
//		logPo.setsLogResult("12"); // 12 表示开始 
		logPo.setsLogOpID("3");   // 3 表示单位成本回填
		logPo.setsLogContent("单位成本回填时间：" + date);		
		yklogisticsLogMgr.insertLog(logPo);  //新增日志
		
		//回填
		logPo.setsLogContent("单位成本回填时间：" + date + " 完成!");	
		ykcalMgr.insertRealCalRetrun(date,logPo);
		
//		logPo.setsLogResult("11"); // 11 表示成功 
//		logisticsLogMgr.insertLog(logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("单位成本回填完毕!"));
		request.setAttribute("date", date);
		request.setAttribute("flag", GlobalConstants.UPADTE);
		return SUCCESS;
	}
	
	public String moniSelect() throws Exception {
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
		/** ********************** 权限设置 ******************************/
		
		GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
		goodsInfoPo.setBgisupplierid(Utility.getName(request.getParameter("supplierID")));
		goodsInfoPo.setBgibrandid(Utility.getName(request.getParameter("brandID")));
		goodsInfoPo.setBgigoodsname(Utility.getName(request.getParameter("goodsID")));
		goodsInfoPo.setBgiflag(Utility.getName(request.getParameter("status")));		
	
		String date=Utility.getName(request.getParameter("date"));
		int count=ykcalMgr.getResultCount(goodsInfoPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request.getParameter("perPageNo")).intValue();
				} else {
					perPage = 10;
				}
			} else {
				perPage = 10;
			}
				
	    Pagination page = new Pagination(request, count, perPage);
	    resultList=ykcalMgr.getResultList(goodsInfoPo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			resultList = null;
		}
		request.setAttribute("supplierID",Utility.getName(request.getParameter("supplierID")) );
		request.setAttribute("brandID",Utility.getName(request.getParameter("brandID")) );
		request.setAttribute("supplierName",Utility.getName(request.getParameter("supplierName")) );
		request.setAttribute("brandName",Utility.getName(request.getParameter("brandName")) );
		request.setAttribute("goodsID",Utility.getName(request.getParameter("goodsID")) );
		request.setAttribute("date",date );
		request.setAttribute("status",Utility.getName(request.getParameter("status")) );
		return SUCCESS;
	}
	
	public String initMoniSelect() throws Exception {
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
		/** ********************** 权限设置 ******************************/
		
		String date = Utility.getName(request.getParameter("date"));
		request.setAttribute("date", date);
		return SUCCESS;
	}
	
	
	
	
	
	

	

}
