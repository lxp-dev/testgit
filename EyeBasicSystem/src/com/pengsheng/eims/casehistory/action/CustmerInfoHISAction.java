package com.pengsheng.eims.casehistory.action;

import java.io.IOException;

import com.pengsheng.eims.casehistory.mgr.CustmerInfoHISMgr;
import com.pengsheng.eims.casehistory.persistence.CustmerInfoHISPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class CustmerInfoHISAction extends BaseAction {


	private String todayid;
	private String smecicustomerid;
	private CustmerInfoHISPo custmerInfoHISPo;
	private CustmerInfoHISMgr custmerInfoHISMgr;
	private PersonPermissionMgr personPermissionMgr;
	
	
	public String  updateOptometryStatus() {
		
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
		String smecicustomerid = Utility.getName(request.getParameter("smecicustomerid"));
		String sopoytreatmentnum = Utility.getName(request.getParameter("sopoytreatmentnum"));
		
		CustmerInfoHISPo custmerInfoHISPo = new CustmerInfoHISPo();
		custmerInfoHISPo.setShccocustmerid(smecicustomerid);
		custmerInfoHISPo.setShccotodayid(todayid);
		custmerInfoHISPo.setShccoisopt("1");
		custmerInfoHISPo.setShccoisrefund("0");
		System.out.println(smecicustomerid+"  来了");
		System.out.println(sopoytreatmentnum);
		int count = custmerInfoHISMgr.queryCustHIS(custmerInfoHISPo);
		 
		if(count > 0){
			custmerInfoHISMgr.updateCustHIS(custmerInfoHISPo);
		}else if(count == 0){
			custmerInfoHISMgr.insertCustHIS(custmerInfoHISPo);
			
		}
		 return SUCCESS;
	}
	
    
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public CustmerInfoHISPo getCustmerInfoHISPo() {
		return custmerInfoHISPo;
	}
	public void setCustmerInfoHISPo(CustmerInfoHISPo custmerInfoHISPo) {
		this.custmerInfoHISPo = custmerInfoHISPo;
	}
	public CustmerInfoHISMgr getCustmerInfoHISMgr() {
		return custmerInfoHISMgr;
	}
	public void setCustmerInfoHISMgr(CustmerInfoHISMgr custmerInfoHISMgr) {
		this.custmerInfoHISMgr = custmerInfoHISMgr;
	}
	public String getTodayid() {
		return todayid;
	}
	public void setTodayid(String todayid) {
		this.todayid = todayid;
	}
	public String getSmecicustomerid() {
		return smecicustomerid;
	}
	public void setSmecicustomerid(String smecicustomerid) {
		this.smecicustomerid = smecicustomerid;
	}

}
