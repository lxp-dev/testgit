package com.pengsheng.eims.logistics.action;

import java.util.List;

import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

@SuppressWarnings("serial")
public class LogisticsLogAction extends BaseAction {
	
	private LogisticsLogMgr logisticsLogMgr = null;
	private List<LogisticsLogPo> logisticsLogLst = null;
    private List<PersonInfoPo> personInfoLst = null;
    private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
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

	/**
	 * 模块：物流系统
	 * 描述：初始化日志界面
	 * 优化记录：1. szk 2011-08-10
	 */
	public String initLogisticsLog() throws Exception {
		personInfoLst = logisticsLogMgr.selPersonInfo();
		return SUCCESS;
	}
	
	/**
	 * 模块：物流系统
	 * 描述：查询日志
	 * 优化记录：1. szk 2011-08-10
	 */
	public String selLogisticsLog() throws Exception {
		String sLogStartDate = Utility.getName(request.getParameter("sLogStartDate"));
		String sLogEndDate = Utility.getName(request.getParameter("sLogEndDate"));
		String sLogName = Utility.getName(request.getParameter("sLogName"));
		String sLogBillList = Utility.getName(request.getParameter("sLogBillList"));
		String sLogContent = Utility.getName(request.getParameter("sLogContent"));
		
		LogisticsLogPo po = new LogisticsLogPo();
		po.setsLogStartDate(sLogStartDate);
		po.setsLogEndDate(sLogEndDate);
		po.setsLogName(sLogName);
		po.setsLogContent(sLogContent);
		po.setsLogBillList(sLogBillList);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = logisticsLogMgr.selLogisticsLogCount(po);		
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage")).intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String)request.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}

			Pagination page = new Pagination(request, count, perPage);
			logisticsLogLst = logisticsLogMgr.selLogisticsLog(po,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			logisticsLogLst = null;
		}
		
		personInfoLst = logisticsLogMgr.selPersonInfo();
		
		request.setAttribute("sLogStartDate",sLogStartDate);
		request.setAttribute("sLogEndDate",sLogEndDate);
		request.setAttribute("sLogNameTemp",sLogName);
		request.setAttribute("sLogBillList",sLogBillList);
		request.setAttribute("sLogContent",sLogContent);
		
		return SUCCESS;
	}
	
	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}
	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}
	public List<PersonInfoPo> getPersonInfoLst() {
		return personInfoLst;
	}
	public void setPersonInfoLst(List<PersonInfoPo> personInfoLst) {
		this.personInfoLst = personInfoLst;
	}
	public List<LogisticsLogPo> getLogisticsLogLst() {
		return logisticsLogLst;
	}
	public void setLogisticsLogLst(List<LogisticsLogPo> logisticsLogLst) {
		this.logisticsLogLst = logisticsLogLst;
	}
	
}
