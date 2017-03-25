package com.pengsheng.eims.storage.action;

import java.io.InputStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.SystemClearMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class SystemClearAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;
	private SystemClearMgr systemClearMgr;
    private String backupPath = null;
	
	/**
	 * 初始化备份数据库
	 */
	public String initDataBaseBackupInsert() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String flag1 = Utility.getName(request.getParameter("flag1"));
		String flag2 = Utility.getName(request.getParameter("flag2"));
		String flag3 = Utility.getName(request.getParameter("flag3"));
		String flag4 = Utility.getName(request.getParameter("flag4"));
		
		request.setAttribute("flag1",flag1);
		request.setAttribute("flag2",flag2);
		request.setAttribute("flag3",flag3);
		request.setAttribute("flag4",flag4);
		
		return SUCCESS;
	}
	
	/**
	 * 备份数据库
	 */
	public String insertDataBaseBackup() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String flag1 = Utility.getName(request.getParameter("flag1"));
		String flag2 = Utility.getName(request.getParameter("flag2"));
		String flag3 = Utility.getName(request.getParameter("flag3"));
		String flag4 = Utility.getName(request.getParameter("flag4"));
		flag1 = "1";
		
		request.setAttribute("flag1",flag1);
		request.setAttribute("flag2",flag2);
		request.setAttribute("flag3",flag3);
		request.setAttribute("flag4",flag4);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("备份数据库!");
		
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("/config/jdbc.properties");
		prop.load(in);
		String jdbcurl = Utility.getName(prop.getProperty("jdbc.url"));
		String databaseName = jdbcurl.equals("") ? "" : jdbcurl.substring(jdbcurl.lastIndexOf("=")+1,jdbcurl.length());
		backupPath = Utility.getName(prop.getProperty("jdbc.backup"));
		
		this.clearMessages(); 
		if (!databaseName.equals("") && !backupPath.equals("")){
			try {
				systemClearMgr.dataBaseBackup(databaseName, backupPath, logPo);
				this.addActionMessage(getText("数据备份完毕!"));
			} catch (Exception e) {
				this.addActionMessage(getText("指定目录可能不存在，请现在数据库端创建目录!"));
				System.out.println(e.getMessage());
			}			
		}else{
			this.addActionMessage(getText("数据备份失败!"));
			flag1 = "";
		}		
		
		String url = "''initSystemClear.action?moduleID={0}&flag1={1}&flag2={2}&flag3={3}&flag4={4}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		params.add(Utility.getName(flag1));
		params.add(Utility.getName(flag2));
		params.add(Utility.getName(flag3));
		params.add(Utility.getName(flag4));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE3);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化数据清理
	 */
	public String initSystemClear() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
   	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar c = Calendar.getInstance();
	    request.setAttribute("currentYear",sdf.format(c.getTime()).substring(0,4));
	    
	    if (systemClearMgr.isSystemOnLine() > 0){
	    	request.setAttribute("systemOnLineFlag","1");
	    }else{
	    	request.setAttribute("systemOnLineFlag","0");
	    }
	    
	    String systemOnLineDate = systemClearMgr.getSystemOnLineDate();
	    String[] payMentDate = Utility.getName(systemClearMgr.getCurrentPayMentDate()).equals("") ? null : (Utility.getName(systemClearMgr.getCurrentPayMentDate()).indexOf("-") >= 0 ? Utility.getName(systemClearMgr.getCurrentPayMentDate()).split("-") : null );
	    
		request.setAttribute("systemOnLineDate",systemOnLineDate);
		if (payMentDate != null && payMentDate.length == 2 ){
			request.setAttribute("payMentYear",Utility.getName(payMentDate[0]));
			request.setAttribute("payMentMonth",Utility.getName(payMentDate[1]));
		}
		
	    String flag1 = Utility.getName(request.getParameter("flag1"));
		String flag2 = Utility.getName(request.getParameter("flag2"));
		String flag3 = Utility.getName(request.getParameter("flag3"));
		String flag4 = Utility.getName(request.getParameter("flag4"));
		
		request.setAttribute("flag1",flag1);
		request.setAttribute("flag2",flag2);
		request.setAttribute("flag3",flag3);
		request.setAttribute("flag4",flag4);
		request.setAttribute("endDate",sdf.format(new Date()));
		
		return SUCCESS;
	}

	/**
	 * 数据清理
	 */
	public String clearStorageData() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
	    
	    String flag1 = Utility.getName(request.getParameter("flag1"));
		String flag3 = Utility.getName(request.getParameter("flag3"));
		String flag4 = Utility.getName(request.getParameter("flag4"));
		
		request.setAttribute("flag1",flag1);
		request.setAttribute("flag2","1");
		request.setAttribute("flag3",flag3);
		request.setAttribute("flag4",flag4);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("清理数据库!");
		
		systemClearMgr.deleteDataBase(logPo);
		
		this.clearMessages(); 
		this.addActionMessage(getText("数据清理完毕!"));
		String url = "''initSystemClear.action?moduleID={0}&flag1={1}&flag2={2}&flag3={3}&flag4={4}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		params.add(Utility.getName(flag1));
		params.add(Utility.getName("1"));
		params.add(Utility.getName(flag3));
		params.add(Utility.getName(flag4));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	/**
	 * 系统上线日期
	 */
	public String updateSystemOnLineDate() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
	    
	    String flag1 = Utility.getName(request.getParameter("flag1"));
		String flag2 = Utility.getName(request.getParameter("flag2"));
		String flag4 = Utility.getName(request.getParameter("flag4"));
		
		request.setAttribute("flag1",flag1);
		request.setAttribute("flag2",flag2);
		request.setAttribute("flag3","1");
		request.setAttribute("flag4",flag4);
		
		String systemOnLineDate = Utility.getName(request.getParameter("systemOnLineDate"));
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("确定系统上线日期!");
		
		systemClearMgr.updateSystemOnLineDate(systemOnLineDate, logPo);
		
		this.clearMessages(); 
		this.addActionMessage(getText("系统上线日期已确定!"));
		String url = "''initSystemClear.action?moduleID={0}&flag1={1}&flag2={2}&flag3={3}&flag4={4}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		params.add(Utility.getName(flag1));
		params.add(Utility.getName(flag2));
		params.add(Utility.getName("1"));
		params.add(Utility.getName(flag4));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化账期数据
	 */
	public String insertPayMentDate() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
	    	    
	    String flag1 = Utility.getName(request.getParameter("flag1"));
		String flag2 = Utility.getName(request.getParameter("flag2"));
		String flag3 = Utility.getName(request.getParameter("flag3"));
		
		request.setAttribute("flag1",flag1);
		request.setAttribute("flag2",flag2);
		request.setAttribute("flag3",flag3);
		request.setAttribute("flag4","1");
		
		String payMentDate = Utility.getName(request.getParameter("payMentYear"))+"-"+Utility.getName(request.getParameter("payMentMonth"));
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("初始化账期数据!");
		
		systemClearMgr.insertPayMentDate(payMentDate, logPo);
		
		this.clearMessages(); 
		this.addActionMessage(getText("账期已确定!"));
		String url = "''initSystemClear.action?moduleID={0}&flag1={1}&flag2={2}&flag3={3}&flag4={4}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		params.add(Utility.getName(flag1));
		params.add(Utility.getName(flag2));
		params.add(Utility.getName(flag3));
		params.add(Utility.getName("1"));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}	
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public SystemClearMgr getSystemClearMgr() {
		return systemClearMgr;
	}
	public void setSystemClearMgr(SystemClearMgr systemClearMgr) {
		this.systemClearMgr = systemClearMgr;
	}
	public String getBackupPath() {
		return backupPath;
	}
	public void setBackupPath(String backupPath) {
		this.backupPath = backupPath;
	}

}
