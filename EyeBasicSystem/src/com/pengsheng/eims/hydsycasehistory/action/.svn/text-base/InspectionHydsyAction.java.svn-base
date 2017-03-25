package com.pengsheng.eims.hydsycasehistory.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.components.mgr.CustomerOptometryMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.ContactGlassHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.DoubleEyeFunHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.InspectionHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.OptometryBasicHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.RefractiveHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.SpecialCheckHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.ContactGlassPo;
import com.pengsheng.eims.hydsycasehistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.hydsycasehistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.hydsycasehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.hydsycasehistory.persistence.InspectionPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.hydsycasehistory.persistence.RefractivePo;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class InspectionHydsyAction extends BaseAction{
	private LogisticsLogMgr logisticsLogMgr = null;
	private List<CornealContactlLensPo> cornealContactlLensPos;
	private CornealContactlLensPo cornealContactlLensPo;
	private ContactGlassPo contactGlassPo;
	private List<ContactGlassPo> contactGlassPos;
	private SpecialCheckHydsyMgr specialCheckHydsyMgr;
	private OptometryBasicPo optometryBasicPo;
	private ContactGlassHydsyMgr contactGlassHydsyMgr;
	private RefractivePo refractivePo;
	private DoubleEyeFunHydsyMgr doubleEyeFunHydsyMgr;
	private PersonPermissionMgr personPermissionMgr;
	private InspectionHydsyMgr inspectionHydsyMgr;
	private CustomerInfoPo customerInfoPo;
	private OptometryPo optometryPo;
	private OptometryBasicHydsyMgr optometryBasicHydsyMgr;
	private RefractiveHydsyMgr refractiveHydsyMgr;
	private List<InspectionPo> inspectionPos;
	private CustomerOptometryMgr customerOptometryMgr;
	private InspectionPo inspectionPo;
	private CustomerInfoMgr customerInfoMgr;
	private DoubleEyeFunPo doubleEyeFunPo;
	private HealthCheckPo healthCheckPo;
	private UnitMgr unitMgr;
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;

	/*
	 * 初始化检查结论
	 */
	public String initInspectionInsertN(){
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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		String chuyanfuyan= request.getParameter("chuyanfuyan"); //初验0复验1
		
		/*
		 * 复制处方移动到复验里,yiwuyong.
		 */
		if("1".equals(chuyanfuyan)){
			request.setAttribute("oldOptometryIDFirst", request.getParameter("oldOptometryID"));
			request.setAttribute("copyBasicOptometryID", request.getParameter("optometryBasicID"));
		}
		int doublecount = doubleEyeFunHydsyMgr.getDoubleEyeFunCount(optometryPo);
		RefractivePo po = new RefractivePo();
		po.setSoproptometryid(optometryID);
		refractivePo = refractiveHydsyMgr.getRefractive(po);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		if(!"".equals(optometryBasicID)){ //
			request.setAttribute("optometryBasicID", optometryBasicID);
		}else{
			SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			String numHead = "O" + personInfoPo.getDepartmentID()
			+ personInfoPo.getMachinery() + numHeadFormat.format(new Date());
			request.setAttribute("optometryBasicID", numHead);	
		}
		
		ContactGlassPo contact = new ContactGlassPo();
		contact.setSopcgoptometryid(optometryID);
		if (!"".equals(Utility.getName(request.getParameter("oldOptometryID")))) {
			contact.setSopcgoptometryid(request.getParameter("oldOptometryID"));
		}
		contactGlassPos = this.contactGlassHydsyMgr.getContactGlassList(contact);
		if(contactGlassPos.size() > 0){
			contactGlassPo = contactGlassPos.get(0);
		}
		request.setAttribute("doublecount", doublecount);
		request.setAttribute("customerID", customerID);
		request.setAttribute("readOnly", "readOnly");
		return SUCCESS;
	}
	/*
	 * 检查结论新增
	 */
	public String inspectionInsertN(){
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
				
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		String chuyanfuyan= request.getParameter("chuyanfuyan"); //初验0复验1
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " " + "HH:mm:ss"); 
		String nowTime = tempDate.format(new Date()); //取得当前日期 
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 12 表示开始 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("验光验光号："+optometryID+" 新增");
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		inspectionPo.setSopipcustomerid(customerID);
		inspectionPo.setSopipoptometryid(optometryPo.getSopoyoptometryid());
		inspectionPo.setSopipoptometrybasicid(optometryBasicID);
		
		int listcount = inspectionPos.size();
		for(int i=0;i<listcount;i++){
			if(i==inspectionPos.size()){
				break;
			}
			if(inspectionPos.get(i)==null){
				inspectionPos.remove(i);
				i--;
			}else{
				inspectionPos.get(i).setSopipoptometryid(optometryID);
				inspectionPos.get(i).setSopipcustomerid(customerID);
				inspectionPos.get(i).setSopipoptometrybasicid(optometryBasicID);
				inspectionPos.get(i).setSopipflag(Utility.getName(request.getParameter("ruleFlag")));
				inspectionPos.get(i).setSopipusername(personInfoPo.getId());
				inspectionPos.get(i).setSopipseccheckdate(inspectionPo.getSopipseccheckdate());
				inspectionPos.get(i).setSopipsubvisitunit(inspectionPo.getSopipsubvisitunit());
				inspectionPos.get(i).setSopipneareye(inspectionPo.getSopipneareye());
				inspectionPos.get(i).setSopipneareyeos(inspectionPo.getSopipneareyeos());
				inspectionPos.get(i).setSopipfareye(inspectionPo.getSopipfareye());
				inspectionPos.get(i).setSopipfareyeos(inspectionPo.getSopipfareyeos());
				inspectionPos.get(i).setSopipastigmia(inspectionPo.getSopipastigmia());
				inspectionPos.get(i).setSopipastigmiaos(inspectionPo.getSopipastigmiaos());
				inspectionPos.get(i).setSopipestimate(inspectionPo.getSopipestimate());
				inspectionPos.get(i).setSopipestimateos(inspectionPo.getSopipestimateos());
				inspectionPos.get(i).setSopipglasstypes(inspectionPo.getSopipglasstypes());
				//inspectionPos.get(i).setSopiptouchglass(inspectionPo.getSopiptouchglass());
				inspectionPos.get(i).setSopiptraintypes(inspectionPo.getSopiptraintypes());
				inspectionPos.get(i).setSopiptaketype(inspectionPo.getSopiptaketype());
			}
		}
		
		/**
		 * optometry从表新增
		 */
		String nw = Utility.getName(request.getParameter("nw"));
		optometryPo.setSopoyoptometrybasicid(optometryBasicID);
		optometryPo.setSopoycustomerid(customerID);
		optometryPo.setSopoyshopcode(personInfoPo.getDepartmentID());
		optometryPo.setSopoypersonid(personInfoPo.getId());
		optometryPo.setSopoytime(nowTime);
		optometryPo.setSopoyflag(Utility.getName(request.getParameter("ruleFlag")));
		optometryPo.setSopoyupdateuserid("");
		optometryPo.setSopoyrecipeupdatetime("");
		optometryPo.setSopoyisinternal(nw);
		optometryPo.setSopoyisinternal("N");
		optometryPo.setSopoyoneormany(chuyanfuyan);
	
		/**
		 * optometry基表新增
		 */
		
		OptometryBasicPo optometryBasicPo =null;
		if("0".equals(chuyanfuyan)){
		
			optometryBasicPo=new OptometryBasicPo();
			optometryBasicPo.setSopobcustomerid(customerID);
			optometryBasicPo.setSopobcustomername(customerInfoPo.getSmeciname());
			optometryBasicPo.setSopobmedicalendtime(nowTime);
			optometryBasicPo.setSopobmedicalstarttime(nowTime);
			optometryBasicPo.setSopoboptometrybasicid(optometryBasicID);
		}
		
		String isSend = Utility.getName(request.getParameter("isSend"));
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		
		this.inspectionHydsyMgr.inspectionInsertMessage(inspectionPos,optometryPo,optometryBasicPo,smsRecordPo,isSend,personInfoPo,customerID,logPo);
		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE3);
		request.setAttribute("url", "'initOptometryBasicSel.action?moduleID="+moduleID+"'");
        request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		return SUCCESS;
	}
	
	public String inspectionInsertDetailsOpenN() throws Exception{
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
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		String ruleFlag = Utility.getName(request.getParameter("ruleFlag"));
		
		if("1".equals(ruleFlag)){
			
			CustomerInfoPo cpo = inspectionHydsyMgr.getCustomerInfo(optometryID);		
			
			if (!Utility.getName(cpo.getSmecifurtherdate()).equals("")){
		        Calendar cal = Calendar.getInstance();
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Utility.getName(cpo.getSmecifurtherdate()));
		        cal.setTime(date); 
		        cal.add(Calendar.DATE,-1);    // 时间延迟 1天
		        
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd 09:20:00");
			}
					
			this.inspectionHydsyMgr.updateInspectionFlag(optometryID,null);
		}
		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE3);
		request.setAttribute("url", "'initOptometryBasicSelHydsy.action?moduleID="+moduleID+"'");
		return "RuleSubmit";
	}
	
	/*
	 * 初始化修改检查简论
	 */
	public String initInspectionUpdateN(){
		
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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		String chuyanfuyan= request.getParameter("chuyanfuyan"); //初验0复验1		
		inspectionPo = new InspectionPo();
		inspectionPo.setSopipoptometryid(optometryID);
		if(!"".equals(Utility.getName(request.getParameter("oldOptometryID")))){
			inspectionPo.setSopipoptometryid(request.getParameter("oldOptometryID"));
			
		}
		inspectionPos=this.inspectionHydsyMgr.getInspectionList(inspectionPo);
		
		String glassType=null;
		
		request.setAttribute("glassType", glassType);
        request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		
		
		return SUCCESS;
	}
	/*
	 * 修改检查简论
	 */
	public String inspectionUpdateN(){
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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		optometryPo.setSopoyflag(Utility.getName(request.getParameter("ruleFlag")));
		optometryPo.setSopoypersonid((personInfoPo.getId()));
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		String chuyanfuyan= request.getParameter("chuyanfuyan"); //初验0复验1	
		
		String isSend = Utility.getName(request.getParameter("isSend"));
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID);
		logPo.setsLogOpID("3");    // 3 表示修改
		logPo.setsLogContent("验光验光号："+optometryID+" 修改");
		
		logisticsLogMgr.insertLog(logPo);  //新增日志
		int listcount = inspectionPos.size();
		for(int i=0;i<listcount;i++){
			if(i==inspectionPos.size()){
				break;
			}
			if(inspectionPos.get(i)==null){
				inspectionPos.remove(i);
				i--;
			}else{
				inspectionPos.get(i).setSopipoptometryid(optometryID);
				inspectionPos.get(i).setSopipcustomerid(customerID);
				inspectionPos.get(i).setSopipoptometrybasicid(optometryBasicID);
				inspectionPos.get(i).setSopipflag(Utility.getName(request.getParameter("ruleFlag")));
				inspectionPos.get(i).setSopipusername(personInfoPo.getId());
				inspectionPos.get(i).setSopipseccheckdate(inspectionPo.getSopipseccheckdate());
				inspectionPos.get(i).setSopipsubvisitunit(inspectionPo.getSopipsubvisitunit());
				inspectionPos.get(i).setSopipneareye(inspectionPo.getSopipneareye());
				inspectionPos.get(i).setSopipfareye(inspectionPo.getSopipfareye());
				inspectionPos.get(i).setSopipastigmia(inspectionPo.getSopipastigmia());
				inspectionPos.get(i).setSopipestimate(inspectionPo.getSopipestimate());
				inspectionPos.get(i).setSopipglasstypes(inspectionPo.getSopipglasstypes());
				inspectionPos.get(i).setSopiptouchglass(inspectionPo.getSopiptouchglass());
				inspectionPos.get(i).setSopiptraintypes(inspectionPo.getSopiptraintypes());
				inspectionPos.get(i).setSopiptaketype(inspectionPo.getSopiptaketype());
				inspectionPos.get(i).setSopipneareyeos(inspectionPo.getSopipneareyeos());
				inspectionPos.get(i).setSopipfareyeos(inspectionPo.getSopipfareyeos());
				inspectionPos.get(i).setSopipastigmiaos(inspectionPo.getSopipastigmiaos());
				inspectionPos.get(i).setSopipestimateos(inspectionPo.getSopipestimateos());
				inspectionPos.get(i).setSopipusername(inspectionPo.getSopipusername());
			}
		}
			
		this.inspectionHydsyMgr.inspectionUpdateMessage(inspectionPos,optometryPo,smsRecordPo,isSend,personInfoPo,customerID);
		
		logPo.setsLogResult("11"); // 11 表示成功 
		logisticsLogMgr.insertLog(logPo);
		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE3);
		
        request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		request.setAttribute("url", "'initOptometryBasicSelHydsy.action?moduleID="+moduleID+"'");
		return SUCCESS;
	}
	/*
	 * 初始化检查结论查询
	 */
	public String initInspectionSelectN(){
		
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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		inspectionPo = new InspectionPo();
		inspectionPo.setSopipoptometryid(Utility.getName(request.getParameter("optometryID")));
		inspectionPos=this.inspectionHydsyMgr.getInspectionList(inspectionPo);
		
		request.setAttribute("readOnly", "readOnly");
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		
		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		
		String chuyanfuyan=Utility.getName(request.getParameter("chuyanfuyan"));
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		
		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);
		
		return SUCCESS;
	}
	/*
	 * 复制处方
	 */
	public String inspectionCopyN(){
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
		OptometryPo po1 = optometryBasicHydsyMgr.getOptometryPo(optometryBasicID);
		inspectionPo = new InspectionPo();
		inspectionPo.setSopipoptometryid(po1.getSopoyoptometryid());
		inspectionPos=inspectionHydsyMgr.getInspectionList(inspectionPo);
		
		String glassType=null;
		if(inspectionPos.size()==1){
			if("2".equals(inspectionPos.get(0).getSopipglasstype())){
				inspectionPos.add(0,null);
				glassType="2";
			}else if("1".equals(inspectionPos.get(0).getSopipglasstype())){

				glassType="1";
			}else if("3".equals(inspectionPos.get(0).getSopipglasstype())){
				inspectionPos.add(0,null);
				inspectionPos.add(1,null);
				glassType="3";
			}else if("4".equals(inspectionPos.get(0).getSopipglasstype())){
				inspectionPos.add(0,null);
				inspectionPos.add(1,null);
				inspectionPos.add(2,null);
				glassType="4";
			}
		}else if(inspectionPos.size()==2){
			if("1".equals(inspectionPos.get(0).getSopipglasstype())&&"3".equals(inspectionPos.get(1).getSopipglasstype())){
				inspectionPos.add(1, null);
				glassType="9"; 
			}else if("1".equals(inspectionPos.get(0).getSopipglasstype())&&"4".equals(inspectionPos.get(1).getSopipglasstype())){
				inspectionPos.add(1, null);
				inspectionPos.add(2, null);
				glassType="6"; 
			}else if("1".equals(inspectionPos.get(0).getSopipglasstype())&&"2".equals(inspectionPos.get(1).getSopipglasstype())){
				glassType="5"; 
			}else if("2".equals(inspectionPos.get(0).getSopipglasstype())&&"3".equals(inspectionPos.get(1).getSopipglasstype())){
				inspectionPos.add(0, null);
				glassType="10"; 
			}else if("2".equals(inspectionPos.get(0).getSopipglasstype())&&"4".equals(inspectionPos.get(1).getSopipglasstype())){
				inspectionPos.add(0, null);
				inspectionPos.add(2,null);
				glassType="7"; 
			}else if("3".equals(inspectionPos.get(0).getSopipglasstype())&&"4".equals(inspectionPos.get(1).getSopipglasstype())){
				inspectionPos.add(0, null);
				inspectionPos.add(1, null);
				glassType="8"; 
			}
		}
		
		request.setAttribute("oldOptometryID", po1.getSopoyoptometryid());
		request.setAttribute("optometryBasicID", optometryBasicID);
        request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		request.setAttribute("glassType", glassType);
		return SUCCESS;
	}
	/*
	 * 检查结论调度
	 */
	public String inspectionToolN(){
		
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
		String source=request.getParameter("source");
		int count=0;
		optometryPo=new OptometryPo();
		optometryPo.setSopoyoptometrybasicid(request.getParameter("optometryBasicID"));
		optometryPo.setSopoyoptometryid(request.getParameter("optometryID"));
		if(!"".equals(Utility.getName(request.getParameter("oldOptometryID")))){
			optometryPo.setSopoyoptometryid(request.getParameter("oldOptometryID"));
			request.setAttribute("oldOptometryID", request.getParameter("oldOptometryID"));
		}
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecicustomerid(request.getParameter("customerID"));
		
		healthCheckPo = new HealthCheckPo();
		healthCheckPo.setSophccustomerid(request.getParameter("customerID"));
		healthCheckPo.setSophcoptometryid(request.getParameter("optometryID"));
		healthCheckPo.setSophcoptometrybasicid(request.getParameter("optometryBasicID"));
		healthCheckPo = specialCheckHydsyMgr.getSpecialCheck(healthCheckPo);
		
		if("inspectioniou".equals(source)){
			count=this.inspectionHydsyMgr.getInspectionCount(optometryPo);
			if(count>0){
				return "inspectionu";
			}else{
				return "inspectioni";
			}
		}else{
			optometryPo.setSopoyoptometryid(request.getParameter("oldOptometryID"));
			count=this.inspectionHydsyMgr.getInspectionCount(optometryPo);
			return "inspectioncopy";
		}
	}
	
	
	
	/**
	 * 打印处方UPDATE
	 * 
	 * */
	
	public void inspectionPrintN(){
		String[] dayin = request.getParameterValues("dayin");
		inspectionHydsyMgr.inspectionprint(dayin[0]);
	}
	
	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}
	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}
	
	public DoubleEyeFunHydsyMgr getDoubleEyeFunHydsyMgr() {
		return doubleEyeFunHydsyMgr;
	}
	public void setDoubleEyeFunHydsyMgr(DoubleEyeFunHydsyMgr doubleEyeFunHydsyMgr) {
		this.doubleEyeFunHydsyMgr = doubleEyeFunHydsyMgr;
	}
	public RefractivePo getRefractivePo() {
		return refractivePo;
	}
	public void setRefractivePo(RefractivePo refractivePo) {
		this.refractivePo = refractivePo;
	}

	public RefractiveHydsyMgr getRefractiveHydsyMgr() {
		return refractiveHydsyMgr;
	}
	public void setRefractiveHydsyMgr(RefractiveHydsyMgr refractiveHydsyMgr) {
		this.refractiveHydsyMgr = refractiveHydsyMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}
	public InspectionHydsyMgr getInspectionHydsyMgr() {
		return inspectionHydsyMgr;
	}
	public void setInspectionHydsyMgr(InspectionHydsyMgr inspectionHydsyMgr) {
		this.inspectionHydsyMgr = inspectionHydsyMgr;
	}
	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}
	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public OptometryPo getOptometryPo() {
		return optometryPo;
	}
	public void setOptometryPo(OptometryPo optometryPo) {
		this.optometryPo = optometryPo;
	}
	
	public CustomerOptometryMgr getCustomerOptometryMgr() {
		return customerOptometryMgr;
	}
	public void setCustomerOptometryMgr(CustomerOptometryMgr customerOptometryMgr) {
		this.customerOptometryMgr = customerOptometryMgr;
	}
	public InspectionPo getInspectionPo() {
		return inspectionPo;
	}
	public void setInspectionPo(InspectionPo inspectionPo) {
		this.inspectionPo = inspectionPo;
	}

	public OptometryBasicHydsyMgr getOptometryBasicHydsyMgr() {
		return optometryBasicHydsyMgr;
	}
	public void setOptometryBasicHydsyMgr(OptometryBasicHydsyMgr optometryBasicHydsyMgr) {
		this.optometryBasicHydsyMgr = optometryBasicHydsyMgr;
	}
	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}
	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}
	
	public DoubleEyeFunPo getDoubleEyeFunPo() {
		return doubleEyeFunPo;
	}
	public void setDoubleEyeFunPo(DoubleEyeFunPo doubleEyeFunPo) {
		this.doubleEyeFunPo = doubleEyeFunPo;
	}
	
	public List<InspectionPo> getInspectionPos() {
		return inspectionPos;
	}
	public void setInspectionPos(List<InspectionPo> inspectionPos) {
		this.inspectionPos = inspectionPos;
	}
	public HealthCheckPo getHealthCheckPo() {
		return healthCheckPo;
	}
	public void setHealthCheckPo(HealthCheckPo healthCheckPo) {
		this.healthCheckPo = healthCheckPo;
	}
//	public SystemParameterPo getSystemParameterPo() {
//		return systemParameterPo;
//	}
//	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
//		this.systemParameterPo = systemParameterPo;
//	}
//	public SystemParameterMgr getSystemParameterMgr() {
//		return systemParameterMgr;
//	}
//	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
//		this.systemParameterMgr = systemParameterMgr;
//	}
	public UnitMgr getUnitMgr() {
		return unitMgr;
	}
	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
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
	public OptometryBasicPo getOptometryBasicPo() {
		return optometryBasicPo;
	}
	public void setOptometryBasicPo(OptometryBasicPo optometryBasicPo) {
		this.optometryBasicPo = optometryBasicPo;
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
	public SpecialCheckHydsyMgr getSpecialCheckHydsyMgr() {
		return specialCheckHydsyMgr;
	}
	public void setSpecialCheckHydsyMgr(SpecialCheckHydsyMgr specialCheckHydsyMgr) {
		this.specialCheckHydsyMgr = specialCheckHydsyMgr;
	}
	public ContactGlassHydsyMgr getContactGlassHydsyMgr() {
		return contactGlassHydsyMgr;
	}
	public void setContactGlassHydsyMgr(ContactGlassHydsyMgr contactGlassHydsyMgr) {
		this.contactGlassHydsyMgr = contactGlassHydsyMgr;
	}
}
