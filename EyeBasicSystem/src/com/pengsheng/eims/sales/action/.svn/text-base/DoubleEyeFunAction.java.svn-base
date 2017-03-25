package com.pengsheng.eims.sales.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.DoubleEyeFunMgr;
import com.pengsheng.eims.sales.mgr.OptometryBasicMgr;
import com.pengsheng.eims.sales.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.sales.persistence.HealthCheckPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.sales.persistence.RefractivePo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class DoubleEyeFunAction extends BaseAction  {
	private DoubleEyeFunPo doubleEyeFunPo;
	private RefractivePo refractivePo;
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
	public RefractivePo getRefractivePo() {
		return refractivePo;
	}
	public void setRefractivePo(RefractivePo refractivePo) {
		this.refractivePo = refractivePo;
	}
	private PersonPermissionMgr personPermissionMgr;

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public DoubleEyeFunPo getDoubleEyeFunPo() {
		return doubleEyeFunPo;
	}
	public void setDoubleEyeFunPo(DoubleEyeFunPo doubleEyeFunPo) {
		this.doubleEyeFunPo = doubleEyeFunPo;
	}
	private DoubleEyeFunMgr doubleEyeFunMgr;
	public DoubleEyeFunMgr getDoubleEyeFunMgr() {
		return doubleEyeFunMgr;
	}
	public void setDoubleEyeFunMgr(DoubleEyeFunMgr doubleEyeFunMgr) {
		this.doubleEyeFunMgr = doubleEyeFunMgr;
	}
	private OptometryBasicPo optometryBasicPo;
	public OptometryBasicPo getOptometryBasicPo() {
		return optometryBasicPo;
	}
	public void setOptometryBasicPo(OptometryBasicPo optometryBasicPo) {
		this.optometryBasicPo = optometryBasicPo;
	}
	public OptometryPo getOptometryPo() {
		return optometryPo;
	}
	public void setOptometryPo(OptometryPo optometryPo) {
		this.optometryPo = optometryPo;
	}
	private OptometryPo optometryPo;
	
	private CustomerInfoPo customerInfoPo;
	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}
	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}
	private InspectionPo inspectionPo;
	private List<InspectionPo> inspectionPos;
	public InspectionPo getInspectionPo() {
		return inspectionPo;
	}
	public void setInspectionPo(InspectionPo inspectionPo) {
		this.inspectionPo = inspectionPo;
	}
	public List<InspectionPo> getInspectionPos() {
		return inspectionPos;
	}
	public void setInspectionPos(List<InspectionPo> inspectionPos) {
		this.inspectionPos = inspectionPos;
	}
	private HealthCheckPo healthCheckPo;
	public HealthCheckPo getHealthCheckPo() {
		return healthCheckPo;
	}
	public void setHealthCheckPo(HealthCheckPo healthCheckPo) {
		this.healthCheckPo = healthCheckPo;
	}
	private OptometryBasicMgr optometryBasicMgr;
	public OptometryBasicMgr getOptometryBasicMgr() {
		return optometryBasicMgr;
	}
	public void setOptometryBasicMgr(OptometryBasicMgr optometryBasicMgr) {
		this.optometryBasicMgr = optometryBasicMgr;
	}
	/**
	 * 初始化双眼视功能检查
	 */
	public String initDoubleEyeFunSel() throws Exception {	
		
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		String chuyanfuyan= Utility.getName(request.getParameter("chuyanfuyan")); //初验0复验1
		
        request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);

		return SUCCESS;
	}
	/**
	 * 新增双眼视功能检查 
	 */
	public String insertDoubleEyeFun() throws Exception {
		
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
//		doubleEyeFunPo.getSopdeoptometrybasicid();
		String chuyanfuyan=Utility.getName(request.getParameter("chuyanfuyan"));
		String eyefunflag=Utility.getName(request.getParameter("eyefunflag"));
		
		doubleEyeFunPo.setSopdeoptometryid(optometryID);
		doubleEyeFunPo.setSopdecustomerid(customerID);
		doubleEyeFunPo.setSopdeoptometryBasicid(optometryBasicID);
		doubleEyeFunPo.setSopdechecker(createPerson);
		doubleEyeFunPo.setSopdeinspecteyefun(eyefunflag);
		
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm:ss"); 
		String nowTime = tempDate.format(new Date()); //取得当前日期 
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		/**
		 * optometry从表新增
		 */
		
		optometryPo.setSopoycustomerid(customerID);
		optometryPo.setSopoyshopcode(personInfoPo.getDepartmentID());
		optometryPo.setSopoypersonid(personInfoPo.getId());
		optometryPo.setSopoytime(nowTime);
		optometryPo.setSopoyflag("0");
		optometryPo.setSopoyupdateuserid("");
		optometryPo.setSopoyrecipeupdatetime("");
		optometryPo.setSopoyoptometrybasicid(optometryBasicID);
		optometryPo.setSopoyisinternal("N");
		
		/**
		 * optometry基表新增
		 */
		
		OptometryBasicPo optometryBasicPo =new OptometryBasicPo();
		optometryBasicPo.setSopoboptometrybasicid(optometryBasicID);
		if(optometryBasicMgr.getOptometryBasicCount2(optometryBasicPo)==0){
			optometryBasicPo=new OptometryBasicPo();
			optometryBasicPo.setSopobcustomerid(customerID);
			optometryBasicPo.setSopobcustomername(customerInfoPo.getSmeciname());
			optometryBasicPo.setSopobmedicalendtime(nowTime);
			optometryBasicPo.setSopobmedicalstarttime(nowTime);
			optometryBasicPo.setSopoboptometrybasicid(optometryBasicID);
		}else{
			optometryBasicPo=null;
		}
		
		doubleEyeFunMgr.insertDoubleEyeFun(doubleEyeFunPo,optometryPo,optometryBasicPo);

        request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		request.setAttribute("isDoubleEyeFun", "1");
		return SUCCESS;
	}
	/**
	 * 查看双眼视功能检查
	 */
	public String selectDoubleEyeFun() throws Exception{
		
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		
		doubleEyeFunPo = new DoubleEyeFunPo();
		
		doubleEyeFunPo.setSopdecustomerid(customerID);
		doubleEyeFunPo.setSopdeoptometryid(optometryID);
		
		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		request.setAttribute("oldOptometryID", request.getParameter("oldOptometryID"));
		request.setAttribute("readOnly", "readOnly");
	
		doubleEyeFunPo=doubleEyeFunMgr.getDoubleEyeFun(doubleEyeFunPo);
		
		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化修改双眼视功能检查
	 */
	public String initDoubleEyeFunUpdate() throws Exception{
		
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		String chuyanfuyan= request.getParameter("chuyanfuyan"); //初验0复验1
		
		doubleEyeFunPo = new DoubleEyeFunPo();
		
		doubleEyeFunPo.setSopdecustomerid(customerID);
		String oldOptometryID=null;
		if(!Utility.getName(request.getParameter("oldOptometryID")).equals("")){
			oldOptometryID= Utility.getName(request.getParameter("oldOptometryID"));
			request.setAttribute("oldOptometryID", oldOptometryID);
		}
		if(this.doubleEyeFunMgr.getDoubleEyeFunCount(optometryPo)==0){
			doubleEyeFunPo.setSopdeoptometryid(oldOptometryID==null?optometryID:oldOptometryID);
		}else{
			doubleEyeFunPo.setSopdeoptometryid(optometryID);
		}
        request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		request.setAttribute("oldOptometryID", request.getParameter("oldOptometryID"));
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		doubleEyeFunPo=doubleEyeFunMgr.getDoubleEyeFun(doubleEyeFunPo);
		request.setAttribute("isDoubleEyeFun", "1");
		
		return SUCCESS;
	}
	
	/**
	 * 修改双眼视功能检查
	 * @return
	 * @throws Exception
	 */
	public String updateDoubleEyeFun() throws Exception{
		
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String updatePertson=personInfoPo.getId();
		
		
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		String chuyanfuyan= request.getParameter("chuyanfuyan"); //初验0复验1

		doubleEyeFunPo.setSopdecustomerid(customerID);
		if(doubleEyeFunMgr.getDoubleEyeFunCount(optometryPo)>0){
			doubleEyeFunPo.setSopdeoptometryid(optometryID);
		}else{
			doubleEyeFunPo.setSopdeoptometryid(Utility.getName(request.getParameter("oldOptometryID")).equals("")?optometryID:Utility.getName(request.getParameter("oldOptometryID")));
		}
		
		doubleEyeFunMgr.getDoubleEyeFun(doubleEyeFunPo);
		
		optometryBasicPo=new OptometryBasicPo();
		optometryBasicPo.setSopoboptometrybasicid(optometryBasicID);
		
		optometryPo=new OptometryPo();
		optometryPo.setSopoyupdateuserid(updatePertson);
		optometryPo.setSopoyoptometryid(optometryBasicID);
		doubleEyeFunPo.setSopdechecker(createPerson);
		doubleEyeFunMgr.updateDoubleEyeFun(doubleEyeFunPo,optometryPo,optometryBasicPo);
	
        request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		request.setAttribute("oldOptometryID", request.getParameter("oldOptometryID"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		request.setAttribute("isDoubleEyeFun", "1");
		
		return SUCCESS;
	}
	
	public String doubleEyeFunTool(){
		
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
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String source=Utility.getName(request.getParameter("source"));
		int count=0;
		if(!Utility.getName(request.getParameter("oldOptometryID")).equals("")){
			source="doubleeyefuncopy";
		}
		request.setAttribute("optometryID", request.getParameter("optometryID"));
		String optometryID=optometryPo.getSopoyoptometryid();
		request.setAttribute("optometryBasicID", request.getParameter("optometryBasicID"));
		if("doubleeyefuniou".equals(source)){
			count=this.doubleEyeFunMgr.getDoubleEyeFunCount(optometryPo);
			if(count>0){
				request.setAttribute("isDoubleEyeFun", "1");
				return "doubleeyefunu";
			}else{
				return "doubleeyefuni";
			}
		}else {
			if(optometryBasicMgr.getOptometryCount2(optometryPo)>0&&doubleEyeFunMgr.getDoubleEyeFunCount(optometryPo)>0){
				
			}else{
				optometryPo.setSopoyoptometryid(Utility.getName(request.getParameter("oldOptometryID")));
			}
			count=this.doubleEyeFunMgr.getDoubleEyeFunCount(optometryPo);
			request.setAttribute("oldOptometryID",request.getParameter("oldOptometryID") );
			if(count>0){
				optometryPo.setSopoyoptometryid(optometryID);
				if(this.doubleEyeFunMgr.getDoubleEyeFunCount(optometryPo)==0){
					request.setAttribute("copy", "copy");
				}
				request.setAttribute("isDoubleEyeFun", "1");
				return "doubleeyefunu";
			}else{
				return "doubleeyefuni";
			}
		}
	
	}
}
