package com.pengsheng.eims.bjtrhistory.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.bjtrhistory.mgr.DoubleEyeFunBjtrMgr;
import com.pengsheng.eims.bjtrhistory.mgr.EyesCheckBjtrMgr;
import com.pengsheng.eims.bjtrhistory.mgr.OptometryBasicBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.ContactGlassPo;
import com.pengsheng.eims.bjtrhistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.bjtrhistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.bjtrhistory.persistence.HealthCheckPo;
import com.pengsheng.eims.bjtrhistory.persistence.InspectionPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.bjtrhistory.persistence.OptometryPo;
import com.pengsheng.eims.bjtrhistory.persistence.RefractivePo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class DoubleEyeFunBjtrAction extends BaseAction  {
	private ContactGlassPo contactGlassPo;
	private List<ContactGlassPo> contactGlassPos;
	private List<CornealContactlLensPo> cornealContactlLensPos;
	private CornealContactlLensPo cornealContactlLensPo;	
	private DoubleEyeFunPo doubleEyeFunPo;
	private RefractivePo refractivePo;	
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;

	private EyesCheckBjtrMgr eyesCheckBjtrMgr;
	private DoubleEyeFunBjtrMgr doubleEyeFunBjtrMgr;
	private OptometryBasicBjtrMgr optometryBasicBjtrMgr;
	
	/**
	 * 初始化双眼视功能检查
	 */
	public String initDoubleEyeFunSelN() throws Exception {	
		
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
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		String chuyanfuyan= Utility.getName(request.getParameter("chuyanfuyan")); //初验0复验1
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
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
	public String insertDoubleEyeFunN() throws Exception {
		
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
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
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
		optometryPo.setSopoyoneormany(chuyanfuyan);
		
		/**
		 * optometry基表新增
		 */
		
		OptometryBasicPo optometryBasicPo =new OptometryBasicPo();
		optometryBasicPo.setSopoboptometrybasicid(optometryBasicID);
		if(optometryBasicBjtrMgr.getOptometryBasicCount2(optometryBasicPo)==0){
			optometryBasicPo=new OptometryBasicPo();
			optometryBasicPo.setSopobcustomerid(customerID);
			optometryBasicPo.setSopobcustomername(customerInfoPo.getSmeciname());
			optometryBasicPo.setSopobmedicalendtime(nowTime);
			optometryBasicPo.setSopobmedicalstarttime(nowTime);
			optometryBasicPo.setSopoboptometrybasicid(optometryBasicID);
		}else{
			optometryBasicPo=null;
		}
		
		doubleEyeFunBjtrMgr.insertDoubleEyeFun(doubleEyeFunPo,optometryPo,optometryBasicPo);

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
	public String selectDoubleEyeFunN() throws Exception{
		
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
//		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
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
		String chuyanfuyan=Utility.getName(request.getParameter("chuyanfuyan"));
		request.setAttribute("chuyanfuyan", chuyanfuyan);
	
		doubleEyeFunPo=doubleEyeFunBjtrMgr.getDoubleEyeFun(doubleEyeFunPo);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化修改双眼视功能检查
	 */
	public String initDoubleEyeFunUpdateN() throws Exception{
		
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
//		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
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
		if(this.doubleEyeFunBjtrMgr.getDoubleEyeFunCount(optometryPo)==0){
			doubleEyeFunPo.setSopdeoptometryid(oldOptometryID==null?optometryID:oldOptometryID);
		}else{
			doubleEyeFunPo.setSopdeoptometryid(optometryID);
		}
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
        request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		request.setAttribute("oldOptometryID", request.getParameter("oldOptometryID"));
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		doubleEyeFunPo=doubleEyeFunBjtrMgr.getDoubleEyeFun(doubleEyeFunPo);
		request.setAttribute("isDoubleEyeFun", "1");
		
		return SUCCESS;
	}
	
	/**
	 * 修改双眼视功能检查
	 * @return
	 * @throws Exception
	 */
	public String updateDoubleEyeFunN() throws Exception{
		
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
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		String updatePertson=personInfoPo.getId();
		
		
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		String chuyanfuyan= request.getParameter("chuyanfuyan"); //初验0复验1

		doubleEyeFunPo.setSopdecustomerid(customerID);
		if(doubleEyeFunBjtrMgr.getDoubleEyeFunCount(optometryPo)>0){
			doubleEyeFunPo.setSopdeoptometryid(optometryID);
		}else{
			doubleEyeFunPo.setSopdeoptometryid(Utility.getName(request.getParameter("oldOptometryID")).equals("")?optometryID:Utility.getName(request.getParameter("oldOptometryID")));
		}
		
		doubleEyeFunBjtrMgr.getDoubleEyeFun(doubleEyeFunPo);
		
		optometryBasicPo=new OptometryBasicPo();
		optometryBasicPo.setSopoboptometrybasicid(optometryBasicID);
		
		optometryPo=new OptometryPo();
		optometryPo.setSopoyupdateuserid(updatePertson);
		optometryPo.setSopoyoptometryid(optometryBasicID);
		doubleEyeFunPo.setSopdechecker(createPerson);
		doubleEyeFunBjtrMgr.updateDoubleEyeFun(doubleEyeFunPo,optometryPo,optometryBasicPo);
	
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
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
	
	public String doubleEyeFunToolN(){
		
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
//		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String source=Utility.getName(request.getParameter("source"));
		int count=0;
		if(!Utility.getName(request.getParameter("oldOptometryID")).equals("")){
			source="doubleeyefuncopy";
		}
		request.setAttribute("optometryID", request.getParameter("optometryID"));
		String optometryID=optometryPo.getSopoyoptometryid();
		request.setAttribute("optometryBasicID", request.getParameter("optometryBasicID"));
		if("doubleeyefuniou".equals(source)){
			count=this.doubleEyeFunBjtrMgr.getDoubleEyeFunCount(optometryPo);
			if(count>0){
				request.setAttribute("isDoubleEyeFun", "1");
				return "doubleeyefunu";
			}else{
				return "doubleeyefuni";
			}
		}else {
			if(optometryBasicBjtrMgr.getOptometryCount2(optometryPo)>0&&doubleEyeFunBjtrMgr.getDoubleEyeFunCount(optometryPo)>0){
				
			}else{
				optometryPo.setSopoyoptometryid(Utility.getName(request.getParameter("oldOptometryID")));
			}
			count=this.doubleEyeFunBjtrMgr.getDoubleEyeFunCount(optometryPo);
			request.setAttribute("oldOptometryID",request.getParameter("oldOptometryID") );
			if(count>0){
				optometryPo.setSopoyoptometryid(optometryID);
				if(this.doubleEyeFunBjtrMgr.getDoubleEyeFunCount(optometryPo)==0){
					request.setAttribute("copy", "copy");
				}
				request.setAttribute("isDoubleEyeFun", "1");
				return "doubleeyefunu";
			}else{
				return "doubleeyefuni";
			}
		}
	
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
	
	public EyesCheckBjtrMgr getEyesCheckBjtrMgr() {
		return eyesCheckBjtrMgr;
	}
	public void setEyesCheckBjtrMgr(EyesCheckBjtrMgr eyesCheckBjtrMgr) {
		this.eyesCheckBjtrMgr = eyesCheckBjtrMgr;
	}
	public DoubleEyeFunBjtrMgr getDoubleEyeFunBjtrMgr() {
		return doubleEyeFunBjtrMgr;
	}
	public void setDoubleEyeFunBjtrMgr(DoubleEyeFunBjtrMgr doubleEyeFunBjtrMgr) {
		this.doubleEyeFunBjtrMgr = doubleEyeFunBjtrMgr;
	}
	public OptometryBasicBjtrMgr getOptometryBasicBjtrMgr() {
		return optometryBasicBjtrMgr;
	}
	public void setOptometryBasicBjtrMgr(OptometryBasicBjtrMgr optometryBasicBjtrMgr) {
		this.optometryBasicBjtrMgr = optometryBasicBjtrMgr;
	}
	public ContactGlassPo getContactGlassPo() {
		return contactGlassPo;
	}
	public void setContactGlassPo(ContactGlassPo contactGlassPo) {
		this.contactGlassPo = contactGlassPo;
	}
	public List<ContactGlassPo> getContactGlassPos() {
		return contactGlassPos;
	}
	public void setContactGlassPos(List<ContactGlassPo> contactGlassPos) {
		this.contactGlassPos = contactGlassPos;
	}
	public List<CornealContactlLensPo> getCornealContactlLensPos() {
		return cornealContactlLensPos;
	}
	public void setCornealContactlLensPos(
			List<CornealContactlLensPo> cornealContactlLensPos) {
		this.cornealContactlLensPos = cornealContactlLensPos;
	}
	public CornealContactlLensPo getCornealContactlLensPo() {
		return cornealContactlLensPo;
	}
	public void setCornealContactlLensPo(CornealContactlLensPo cornealContactlLensPo) {
		this.cornealContactlLensPo = cornealContactlLensPo;
	}
}
