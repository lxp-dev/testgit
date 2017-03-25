package com.pengsheng.eims.system.action;

import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.ReminderWindowMgr;
import com.pengsheng.eims.basic.persistence.ReminderWindowPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.PersonSetOptionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.PersonSetOptionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class PersonSetOptionAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private PersonSetOptionPo personSetOptionPo;
	private PersonSetOptionMgr personSetOptionMgr;
	private ReminderWindowMgr reminderWindowMgr;
	
	/**
	 * 加载个人设置页面
	 * @return
	 */
	public String initPersonSetOptionSel() {
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
		
		personSetOptionPo = personSetOptionMgr.selectPersonSetOptionPo(createPerson);
		
		String personReminderWindowid = "";
		String tmpPersonReminderWindowid = Utility.getName(personSetOptionPo.getFpsoreminderwindowid());
		String[] personReminderWindowidArray = tmpPersonReminderWindowid.split("-");//分割不同部门类型的提醒信息设置内容
		for (int i = 0 ; i <personReminderWindowidArray.length ; i++ ) {			
			  //如果登陆部门类型与循环中该部门类型相同，就赋值；
		      if(personReminderWindowidArray[i].split(":")[0].equals(personInfoPo1.getDepartmenttype())){
		    	  	personReminderWindowid = personReminderWindowidArray[i].split(":")[1];
		    	  	personReminderWindowid = personReminderWindowid.substring(1,personReminderWindowid.length()-1);
		      }
		}		

		List<ReminderWindowPo> departmentTypeAndRoleReminderwindowList = reminderWindowMgr.getJiaojiReminderWindowsByDepartmenttypeidAndRoleid(personInfoPo1.getDepartmenttype(),personInfoPo1.getRoleid());
		
		if(personReminderWindowid.equals("")&& departmentTypeAndRoleReminderwindowList!=null && departmentTypeAndRoleReminderwindowList.size()>0){
			Iterator it  = 	departmentTypeAndRoleReminderwindowList.iterator();
			while(it.hasNext()){
				if ("".equals(personReminderWindowid)) {
					personReminderWindowid = ((ReminderWindowPo)it.next()).getFrwsid();
				} else {
					personReminderWindowid = personReminderWindowid + "," + ((ReminderWindowPo)it.next()).getFrwsid();
				}		
			}
		}
		personSetOptionPo.setFpsoreminderwindowid(personReminderWindowid);
		
		request.setAttribute("departmentTypeAndRoleReminderwindowList", departmentTypeAndRoleReminderwindowList);
		return SUCCESS;
	}
	
	/**
	 * 保存个人参数设置
	 * @return
	 */
	public String updatePersonSetOption() {
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
			
		String[] reminderwindowidsArray = request.getParameterValues("reminderwindowids");//取得提醒信息复选框的数组值
		//------将提醒信息复选框的数组值改造成逗号分割的形式
		String reqReminderwindowids = "";
		
		if(reminderwindowidsArray!=null && reminderwindowidsArray.length>0){
			for (int i = 0; i < reminderwindowidsArray.length; i++) {
				if ("".equals(reqReminderwindowids)) {
					reqReminderwindowids = reminderwindowidsArray[i];
				} else {
					reqReminderwindowids = reqReminderwindowids + "," + reminderwindowidsArray[i];
				}
			}
		}else{
			reqReminderwindowids = "no";
		}
		
		String reminderwindowids = reqReminderwindowids;
		//------将提醒信息复选框的数组值改造成逗号分割的形式：1，2，3		
		
		//------将提醒信息复选框的数组值改造为1:[1,2,3]形式；：号前的1表示部门类型；：号后[]里面内容为逗号分割的复选框勾选数组值	
		reminderwindowids = personInfoPo1.getDepartmenttype()+":["+reminderwindowids+"]";		
		
		//取得个人提醒数据；形式：1:[1,3,4]-3:[1,3]；- 连接不同部门类型的提醒信息内容
		String allReminderwindowids = Utility.getName(personSetOptionMgr.selectPersonSetOptionPo(createPerson).getFpsoreminderwindowid());
		String newAllReminderwindowids = "";
		String[] allReminderwindowidsArray = allReminderwindowids.split("-");//分割不同部门类型的提醒信息设置内容
		boolean isExit = false;	//待更新的提醒信息内容的部门类型是否包含在数据库中
		for (int i = 0 ; i <allReminderwindowidsArray.length ; i++ ) {
			  //如果待更新的提醒信息内容的部门类型与该部门类型相同，就替换；
		      if(allReminderwindowidsArray[i].split(":")[0].equals(personInfoPo1.getDepartmenttype())){
		    	  	isExit = true;
					if ("".equals(newAllReminderwindowids)) {
						newAllReminderwindowids = reminderwindowids;
					} else {
						newAllReminderwindowids = newAllReminderwindowids + "-" + reminderwindowids;
					}
		      }else{//如果待更新的提醒信息内容的部门类型与该部门类型不相同，就追加；
					if ("".equals(newAllReminderwindowids)) {
						newAllReminderwindowids = allReminderwindowidsArray[i];
					} else {
						newAllReminderwindowids = newAllReminderwindowids + "-" + allReminderwindowidsArray[i];
					}
		      }
		    } 
		
		//如果数据库中已经设置部门类型不包含待设置的部门类型，就追加；
		if(isExit == false){
			if ("".equals(newAllReminderwindowids)) {
				newAllReminderwindowids = reminderwindowids;
			} else {
				newAllReminderwindowids = newAllReminderwindowids + "-" + reminderwindowids;
			}
		}
		//取得个人提醒数据；形式：1:[1,3,4]-3:[1,3]；- 连接不同部门类型的提醒信息内容
		
		personSetOptionPo.setFpsopersonid(createPerson);
		personSetOptionPo.setFpsoreminderwindowid(newAllReminderwindowids);		
		personSetOptionMgr.updatePersonSetOptionPo(personSetOptionPo);
		this.addActionMessage("更新成功！");
		
		//初始化数据
		String personReminderWindowid = reqReminderwindowids;
		List<ReminderWindowPo> departmentTypeAndRoleReminderwindowList = reminderWindowMgr.getJiaojiReminderWindowsByDepartmenttypeidAndRoleid(personInfoPo1.getDepartmenttype(),personInfoPo1.getRoleid());
		
//		if(reqReminderwindowids.equals("")&& departmentTypeAndRoleReminderwindowList!=null && departmentTypeAndRoleReminderwindowList.size()>0){
//			Iterator it  = 	departmentTypeAndRoleReminderwindowList.iterator();
//			while(it.hasNext()){
//				if ("".equals(personReminderWindowid)) {
//					personReminderWindowid = ((ReminderWindowPo)it.next()).getFrwsid();
//				} else {
//					personReminderWindowid = personReminderWindowid + "," + ((ReminderWindowPo)it.next()).getFrwsid();
//				}		
//			}
//		}
		personSetOptionPo.setFpsoreminderwindowid(reqReminderwindowids);
		
		request.setAttribute("departmentTypeAndRoleReminderwindowList", departmentTypeAndRoleReminderwindowList);
		//初始化数据
		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
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
	public PersonSetOptionPo getPersonSetOptionPo() {
		return personSetOptionPo;
	}
	public void setPersonSetOptionPo(PersonSetOptionPo personSetOptionPo) {
		this.personSetOptionPo = personSetOptionPo;
	}
	public PersonSetOptionMgr getPersonSetOptionMgr() {
		return personSetOptionMgr;
	}
	public void setPersonSetOptionMgr(PersonSetOptionMgr personSetOptionMgr) {
		this.personSetOptionMgr = personSetOptionMgr;
	}
	public ReminderWindowMgr getReminderWindowMgr() {
		return reminderWindowMgr;
	}
	public void setReminderWindowMgr(ReminderWindowMgr reminderWindowMgr) {
		this.reminderWindowMgr = reminderWindowMgr;
	}

}
