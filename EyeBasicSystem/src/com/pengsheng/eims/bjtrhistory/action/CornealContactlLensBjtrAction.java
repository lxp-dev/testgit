package com.pengsheng.eims.bjtrhistory.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.components.mgr.CustomerOptometryMgr;
import com.pengsheng.eims.logistics.mgr.LogisticsLogMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.bjtrhistory.mgr.DoubleEyeFunBjtrMgr;
import com.pengsheng.eims.bjtrhistory.mgr.CornealContactlLensBjtrMgr;
import com.pengsheng.eims.bjtrhistory.mgr.OptometryBasicBjtrMgr;
import com.pengsheng.eims.bjtrhistory.mgr.RefractiveBjtrMgr;
import com.pengsheng.eims.bjtrhistory.persistence.ContactGlassPo;
import com.pengsheng.eims.bjtrhistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.bjtrhistory.persistence.HealthCheckPo;
import com.pengsheng.eims.bjtrhistory.persistence.CornealContactlLensPo;
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

public class CornealContactlLensBjtrAction extends BaseAction
{
	private LogisticsLogMgr logisticsLogMgr = null;
	private ContactGlassPo contactGlassPo;
	private List<ContactGlassPo> contactGlassPos;
	private OptometryBasicPo optometryBasicPo;
	private InspectionPo inspectionPo;
	private List<InspectionPo> inspectionPos;	
	private RefractivePo refractivePo;	
	private PersonPermissionMgr personPermissionMgr;
	private CustomerInfoPo customerInfoPo;
	private OptometryPo optometryPo;
	private List<CornealContactlLensPo> cornealContactlLensPos;	
	private CustomerOptometryMgr customerOptometryMgr;	
	private CornealContactlLensPo cornealContactlLensPo;	
	private CustomerInfoMgr customerInfoMgr;	
	private DoubleEyeFunPo doubleEyeFunPo;	
	private HealthCheckPo healthCheckPo;
	private UnitMgr unitMgr;	
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	
	private CornealContactlLensBjtrMgr cornealContactlLensBjtrMgr;
	private OptometryBasicBjtrMgr optometryBasicBjtrMgr;	
	private RefractiveBjtrMgr refractiveBjtrMgr;	
	private DoubleEyeFunBjtrMgr doubleEyeFunBjtrMgr;	
	
	public CornealContactlLensBjtrMgr getCornealContactlLensBjtrMgr() {
		return cornealContactlLensBjtrMgr;
	}

	public void setCornealContactlLensBjtrMgr(
			CornealContactlLensBjtrMgr cornealContactlLensBjtrMgr) {
		this.cornealContactlLensBjtrMgr = cornealContactlLensBjtrMgr;
	}

	public OptometryBasicBjtrMgr getOptometryBasicBjtrMgr() {
		return optometryBasicBjtrMgr;
	}

	public void setOptometryBasicBjtrMgr(OptometryBasicBjtrMgr optometryBasicBjtrMgr) {
		this.optometryBasicBjtrMgr = optometryBasicBjtrMgr;
	}

	public RefractiveBjtrMgr getRefractiveBjtrMgr() {
		return refractiveBjtrMgr;
	}

	public void setRefractiveBjtrMgr(RefractiveBjtrMgr refractiveBjtrMgr) {
		this.refractiveBjtrMgr = refractiveBjtrMgr;
	}

	public DoubleEyeFunBjtrMgr getDoubleEyeFunBjtrMgr() {
		return doubleEyeFunBjtrMgr;
	}

	public void setDoubleEyeFunBjtrMgr(DoubleEyeFunBjtrMgr doubleEyeFunBjtrMgr) {
		this.doubleEyeFunBjtrMgr = doubleEyeFunBjtrMgr;
	}

	public List<OptionParamPo> getOptionParamPolist() {
		return optionParamPolist;
	}

	/*
	 * 初始化检查结论
	 */
	public String initCornealContactlLensInsertN(){
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
//		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
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
		int doublecount = doubleEyeFunBjtrMgr.getDoubleEyeFunCount(optometryPo);
		RefractivePo po = new RefractivePo();
		po.setSoproptometryid(optometryID);
		refractivePo = refractiveBjtrMgr.getRefractive(po);
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
		request.setAttribute("doublecount", doublecount);
		request.setAttribute("customerID", customerID);
		request.setAttribute("readOnly", "readOnly");
		return SUCCESS;
	}
	/*
	 * 检查结论新增
	 */
	public String cornealContactlLensInsertN(){
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
		logPo.setsLogContent("角膜接触镜："+optometryID+" 新增");
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		cornealContactlLensPo.setSopclcustomerid(customerID);
		cornealContactlLensPo.setSopcloptometryid(optometryPo.getSopoyoptometryid());
		cornealContactlLensPo.setSopcloptometrybasicid(optometryBasicID);
		
		/**
		 * optometry从表新增
		 */
		optometryPo.setSopoyoptometrybasicid(optometryBasicID);
		optometryPo.setSopoycustomerid(customerID);
		optometryPo.setSopoyshopcode(personInfoPo.getDepartmentID());
		optometryPo.setSopoypersonid(personInfoPo.getId());
		optometryPo.setSopoytime(nowTime);
		optometryPo.setSopoyflag("0");
		optometryPo.setSopoyupdateuserid("");
		optometryPo.setSopoyrecipeupdatetime("");
		optometryPo.setSopoyoneormany(chuyanfuyan);
		optometryPo.setSopoyisinternal("N");
	
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
		
		this.cornealContactlLensBjtrMgr.cornealContactlLensInsertMessage(cornealContactlLensPo,optometryPo,optometryBasicPo,smsRecordPo,isSend,personInfoPo,customerID,logPo);
		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE3);
		request.setAttribute("url", "'initOptometryBasicSelBjtr.action?moduleID="+moduleID+"'");
        request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}
	
	public String cornealContactlLensInsertDetailsOpenN() throws Exception{
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
			
			CustomerInfoPo cpo = cornealContactlLensBjtrMgr.getCustomerInfo(optometryID);		
			
			if (!Utility.getName(cpo.getSmecifurtherdate()).equals("")){
		        Calendar cal = Calendar.getInstance();
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Utility.getName(cpo.getSmecifurtherdate()));
		        cal.setTime(date); 
		        cal.add(Calendar.DATE,-1);    // 时间延迟 1天
		        
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd 09:20:00");
			}
					
			this.cornealContactlLensBjtrMgr.updateCornealContactlLensFlag(optometryID,null);
		}
		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE3);
		request.setAttribute("url", "'initOptometryBasicSelBjtr.action?moduleID="+moduleID+"'");
		return "RuleSubmit";
	}
	
	/*
	 * 初始化修改检查简论
	 */
	public String initCornealContactlLensUpdateN(){
		
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
		String chuyanfuyan= request.getParameter("chuyanfuyan"); //初验0复验1		
		cornealContactlLensPo = new CornealContactlLensPo();
		cornealContactlLensPo.setSopcloptometryid(optometryID);
		if(!"".equals(Utility.getName(request.getParameter("oldOptometryID")))){
			cornealContactlLensPo.setSopcloptometryid(request.getParameter("oldOptometryID"));
			
		}
		cornealContactlLensPo=this.cornealContactlLensBjtrMgr.getCornealContactlLensList(cornealContactlLensPo).get(0);
		
		String glassType=null;
		
		request.setAttribute("glassType", glassType);
        request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);	
		
		return SUCCESS;
	}
	/*
	 * 修改检查简论
	 */
	public String cornealContactlLensUpdateN(){
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
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		optometryPo.setSopoyflag("0");
		optometryPo.setSopoypersonid((personInfoPo.getId()));
		String customerID=Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID=Utility.getName(request.getParameter("optometryBasicID"));//验光基表ID
		String optometryID=Utility.getName(request.getParameter("optometryID"));// 验光号
		String chuyanfuyan= request.getParameter("chuyanfuyan"); //初验0复验1	
		
		cornealContactlLensPo.setSopcloptometryid(optometryID);
		cornealContactlLensPo.setSopcloptometrybasicid(optometryBasicID);
		cornealContactlLensPo.setSopclcustomerid(customerID);
		
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
			
		this.cornealContactlLensBjtrMgr.cornealContactlLensUpdateMessage(cornealContactlLensPo,optometryPo,smsRecordPo,isSend,personInfoPo,customerID);
		
		logPo.setsLogResult("11"); // 11 表示成功 
		logisticsLogMgr.insertLog(logPo);
		
		request.setAttribute("flag",GlobalConstants.OPENUPDATE3);
		
        request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID",optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		request.setAttribute("url", "'initOptometryBasicSelBjtr.action?moduleID="+moduleID+"'");
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}
	/*
	 * 初始化检查结论查询
	 */
	public String initCornealContactlLensSelectN(){
		
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
//		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		cornealContactlLensPo = new CornealContactlLensPo();
		cornealContactlLensPo.setSopcloptometryid(Utility.getName(request.getParameter("optometryID")));
		
		List<CornealContactlLensPo> cpo = cornealContactlLensBjtrMgr.getCornealContactlLensList(cornealContactlLensPo);
		if (cpo != null && cpo.size() > 0){
			cornealContactlLensPo = cpo.get(0);
		}		
		
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
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}
	/*
	 * 复制处方
	 */
	public String cornealContactlLensCopyN(){
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
		OptometryPo po1 = optometryBasicBjtrMgr.getOptometryPo(optometryBasicID);
		cornealContactlLensPo = new CornealContactlLensPo();
		cornealContactlLensPo.setSopcloptometryid(po1.getSopoyoptometryid());
		cornealContactlLensPos=cornealContactlLensBjtrMgr.getCornealContactlLensList(cornealContactlLensPo);
		
		String glassType=null;
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
	public String cornealContactlLensToolN(){
		
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
		
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);	
		
		if("cornealContactlLensu".equals(source)){
			count=this.cornealContactlLensBjtrMgr.getCornealContactlLensCount(optometryPo);
			
			if(count>0){
				return "cornealContactlLensu";
			}else{
				return "cornealContactlLensi";
			}
		}else{
			return "cornealContactlLensi";
		}
	}
	
	
	
	/**
	 * 打印处方UPDATE
	 * 
	 * */
	
	public void cornealContactlLensPrintN(){
		String[] dayin = request.getParameterValues("dayin");
		cornealContactlLensBjtrMgr.cornealContactlLensprint(dayin[0]);
	}
	
	public LogisticsLogMgr getLogisticsLogMgr() {
		return logisticsLogMgr;
	}
	public void setLogisticsLogMgr(LogisticsLogMgr logisticsLogMgr) {
		this.logisticsLogMgr = logisticsLogMgr;
	}
	public RefractivePo getRefractivePo() {
		return refractivePo;
	}
	public void setRefractivePo(RefractivePo refractivePo) {
		this.refractivePo = refractivePo;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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
	public CornealContactlLensPo getCornealContactlLensPo() {
		return cornealContactlLensPo;
	}
	public void setCornealContactlLensPo(CornealContactlLensPo cornealContactlLensPo) {
		this.cornealContactlLensPo = cornealContactlLensPo;
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
	
	public List<CornealContactlLensPo> getCornealContactlLensPos() {
		return cornealContactlLensPos;
	}
	public void setCornealContactlLensPos(List<CornealContactlLensPo> cornealContactlLensPos) {
		this.cornealContactlLensPos = cornealContactlLensPos;
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
	public void setOptionParamPolist(List<OptionParamPo> optionParamPolist) {
		this.optionParamPolist = optionParamPolist;
	}
	public OptionParamMgr getOptionParamMgr() {
		return optionParamMgr;
	}
	public void setOptionParamMgr(OptionParamMgr optionParamMgr) {
		this.optionParamMgr = optionParamMgr;
	}	
}
