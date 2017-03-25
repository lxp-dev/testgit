package com.pengsheng.eims.sales.action;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.GlassesHistoryMgr;
import com.pengsheng.eims.sales.persistence.HisInfoPo;
import com.pengsheng.eims.sales.persistence.OptometryBasicPo;
import com.pengsheng.eims.sales.persistence.OptometryPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class GlassesHistoryAction extends BaseAction {
	
	private HisInfoPo hisInfoPo;
	
	private GlassesHistoryMgr glassesHistoryMgr;
	
	private PersonPermissionMgr personPermissionMgr;
	
	private OptometryPo optometryPo;
	
	public OptometryPo getOptometryPo() {
		return optometryPo;
	}
	public void setOptometryPo(OptometryPo optometryPo) {
		this.optometryPo = optometryPo;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public HisInfoPo getHisInfoPo() {
		return hisInfoPo;
	}
	public void setHisInfoPo(HisInfoPo hisInfoPo) {
		this.hisInfoPo = hisInfoPo;
	}
	public GlassesHistoryMgr getGlassesHistoryMgr() {
		return glassesHistoryMgr;
	}
	private CustomerInfoPo customerInfoPo;
	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}
	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}
	public void setGlassesHistoryMgr(GlassesHistoryMgr glassesHistoryMgr) {
		this.glassesHistoryMgr = glassesHistoryMgr;
	}
	
	/**
	 * 查询戴镜史信息
	 * @return
	 */
	public String selectGlassesHistory(){
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
		
		String sophifcustomerid = Utility.getName(request.getParameter("customerID"));
		
		String sophifglassestype = Utility.getName(request.getParameter("sophifglassestype"));
		String sophifglassesm = Utility.getName(request.getParameter("sophifglassesm"));
		String sophifglasseskind = Utility.getName(request.getParameter("sophifglasseskind"));
		String sophifglassesc = Utility.getName(request.getParameter("sophifglassesc"));
		String sophifglassesage = Utility.getName(request.getParameter("sophifglassesage"));
		String sophifcontactlensm = Utility.getName(request.getParameter("sophifcontactlensm"));
		String sophifcontactlensbrand = Utility.getName(request.getParameter("sophifcontactlensbrand"));
		String sophifcontactlensc = Utility.getName(request.getParameter("sophifcontactlensc"));
		String sophifcontactlensage = Utility.getName(request.getParameter("sophifcontactlensage"));
		String sophifeyeillhis1 = Utility.getName(request.getParameter("sophifeyeillhis1"));
		String sophifeyeillhis2 = Utility.getName(request.getParameter("sophifeyeillhis2"));
		String sophifeyeillhis3 = Utility.getName(request.getParameter("sophifeyeillhis3"));
		String sophifinherithis = Utility.getName(request.getParameter("sophifinherithis"));
		String sophifsensitivehis = Utility.getName(request.getParameter("sophifsensitivehis"));
		 
		request.setAttribute("customerID", sophifcustomerid);
		
		request.setAttribute("sophifglassestype", sophifglassestype);
		request.setAttribute("sophifglassesm", sophifglassesm);
		request.setAttribute("sophifglasseskind", sophifglasseskind);
		request.setAttribute("sophifglassesc", sophifglassesc);
		request.setAttribute("sophifglassesage", sophifglassesage);
		request.setAttribute("sophifcontactlensm", sophifcontactlensm);
		request.setAttribute("sophifcontactlensbrand", sophifcontactlensbrand);
		request.setAttribute("sophifcontactlensc", sophifcontactlensc);
		request.setAttribute("sophifcontactlensage", sophifcontactlensage);
		request.setAttribute("sophifeyeillhis1", sophifeyeillhis1);
		request.setAttribute("sophifeyeillhis2", sophifeyeillhis2);
		request.setAttribute("sophifeyeillhis3", sophifeyeillhis3);
		request.setAttribute("sophifinherithis", sophifinherithis);
		request.setAttribute("sophifsensitivehis", sophifsensitivehis);
		
		hisInfoPo=new HisInfoPo();
		hisInfoPo.setSophifcustomerid(sophifcustomerid);
		hisInfoPo.setSophifglassestype(sophifglassestype);
		hisInfoPo.setSophifglassesm(sophifglassesm);
		hisInfoPo.setSophifglasseskind(sophifglasseskind);
		hisInfoPo.setSophifglassesc(sophifglassesc);
		hisInfoPo.setSophifglassesage(sophifglassesage);
		hisInfoPo.setSophifcontactlensm(sophifcontactlensm);
		hisInfoPo.setSophifcontactlensbrand(sophifcontactlensbrand);
		hisInfoPo.setSophifcontactlensc(sophifcontactlensc);
		hisInfoPo.setSophifcontactlensage(sophifcontactlensage);
		hisInfoPo.setSophifeyeillhis1(sophifeyeillhis1);
		hisInfoPo.setSophifeyeillhis2(sophifeyeillhis2);
		hisInfoPo.setSophifeyeillhis3(sophifeyeillhis3);
		hisInfoPo.setSophifinherithis(sophifinherithis);
		hisInfoPo.setSophifsensitivehis(sophifsensitivehis);
		
		hisInfoPo=glassesHistoryMgr.selectGlassesHistory(hisInfoPo);

		
		return SUCCESS;
	}
	
	/**
	 * 更新戴镜史信息
	 * @return
	 */
	public String updateGlassesHistory(){
		
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
		String optPersonName=personInfoPo.getPersonName();
		
		String sophifcustomerid = customerInfoPo.getSmecicustomerid();
		
		String sophifglassestype = Utility.getName(request.getParameter("sophifglassestype"));
		String sophifglassesm = Utility.getName(request.getParameter("sophifglassesm"));
		String sophifglasseskind = Utility.getName(request.getParameter("sophifglasseskind"));
		String sophifglassesc = Utility.getName(request.getParameter("sophifglassesc"));
		String sophifglassesage = Utility.getName(request.getParameter("sophifglassesage"));
		String sophifcontactlensm = Utility.getName(request.getParameter("sophifcontactlensm"));
		String sophifcontactlensbrand = Utility.getName(request.getParameter("sophifcontactlensbrand"));
		String sophifcontactlensc = Utility.getName(request.getParameter("sophifcontactlensc"));
		String sophifcontactlensage = Utility.getName(request.getParameter("sophifcontactlensage"));
		String sophifeyeillhis1 = Utility.getName(request.getParameter("sophifeyeillhis1"));
		String sophifeyeillhis2 = Utility.getName(request.getParameter("sophifeyeillhis2"));
		String sophifeyeillhis3 = Utility.getName(request.getParameter("sophifeyeillhis3"));
		String sophifinherithis = Utility.getName(request.getParameter("sophifinherithis"));
		String sophifsensitivehis = Utility.getName(request.getParameter("sophifsensitivehis"));
		
		String sophiballod = Utility.getName(request.getParameter("sophiballod"));
		String sophiballos = Utility.getName(request.getParameter("sophiballos"));
		String sophipostod = Utility.getName(request.getParameter("sophipostod"));
		String sophipostos = Utility.getName(request.getParameter("sophipostos"));
		String sophiaxesod = Utility.getName(request.getParameter("sophiaxesod"));
		String sophiaxesos = Utility.getName(request.getParameter("sophiaxesos"));
		String sophiaddod = Utility.getName(request.getParameter("sophiaddod"));
		String sophiaddos = Utility.getName(request.getParameter("sophiaddos"));
		String sophiarriseod = Utility.getName(request.getParameter("sophiarriseod"));
		String sophiarriseos = Utility.getName(request.getParameter("sophiarriseos"));
		String sophibasisod = Utility.getName(request.getParameter("sophibasisod"));
		String sophibasisos = Utility.getName(request.getParameter("sophibasisos"));
		String sophiinterhighod = Utility.getName(request.getParameter("sophiinterhighod"));
		String sophiinterhighos = Utility.getName(request.getParameter("sophiinterhighos"));
		
		request.setAttribute("customerID", sophifcustomerid);
		
		hisInfoPo=new HisInfoPo();
		hisInfoPo.setSophifcustomerid(sophifcustomerid);
		hisInfoPo.setSophifglassestype(sophifglassestype);
		hisInfoPo.setSophifglassesm(sophifglassesm);
		hisInfoPo.setSophifglasseskind(sophifglasseskind);
		hisInfoPo.setSophifglassesc(sophifglassesc);
		hisInfoPo.setSophifglassesage(sophifglassesage);
		hisInfoPo.setSophifcontactlensm(sophifcontactlensm);
		hisInfoPo.setSophifcontactlensbrand(sophifcontactlensbrand);
		hisInfoPo.setSophifcontactlensc(sophifcontactlensc);
		hisInfoPo.setSophifcontactlensage(sophifcontactlensage);
		hisInfoPo.setSophifeyeillhis1(sophifeyeillhis1);
		hisInfoPo.setSophifeyeillhis2(sophifeyeillhis2);
		hisInfoPo.setSophifeyeillhis3(sophifeyeillhis3);
		hisInfoPo.setSophifinherithis(sophifinherithis);
		hisInfoPo.setSophifsensitivehis(sophifsensitivehis);
		hisInfoPo.setSophifusername(optPersonName);
		
		hisInfoPo.setSophiballod(sophiballod);
		hisInfoPo.setSophiballos(sophiballos);
		hisInfoPo.setSophipostod(sophipostod);
		hisInfoPo.setSophipostos(sophipostos);
		hisInfoPo.setSophiaxesod(sophiaxesod);
		hisInfoPo.setSophiaxesos(sophiaxesos);
		hisInfoPo.setSophiaddod(sophiaddod);
		hisInfoPo.setSophiaddos(sophiaddos);
		hisInfoPo.setSophiarriseod(sophiarriseod);
		hisInfoPo.setSophiarriseos(sophiarriseos);
		hisInfoPo.setSophibasisod(sophibasisod);
		hisInfoPo.setSophibasisos(sophibasisos);
		hisInfoPo.setSophiinterhighod(sophiinterhighod);
		hisInfoPo.setSophiinterhighos(sophiinterhighos);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 新增
		logPo.setsLogContent("戴镜史管理会员卡号："+customerInfoPo.getSmecimemberid()+"删除后新增");
		
		glassesHistoryMgr.insertGlassesHistory(hisInfoPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.save.sucess"));
		
		return SUCCESS;
	}

}
