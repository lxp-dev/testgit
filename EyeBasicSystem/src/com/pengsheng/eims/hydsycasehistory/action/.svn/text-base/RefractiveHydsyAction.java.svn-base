package com.pengsheng.eims.hydsycasehistory.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.hydsycasehistory.mgr.DoubleEyeFunHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.MydriasisHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.OptometryBasicHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.RefractiveHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.ContactGlassPo;
import com.pengsheng.eims.hydsycasehistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.hydsycasehistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.hydsycasehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.hydsycasehistory.persistence.InspectionPo;
import com.pengsheng.eims.hydsycasehistory.persistence.MydriasisPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.hydsycasehistory.persistence.RefractivePo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class RefractiveHydsyAction extends BaseAction {
	private List<CornealContactlLensPo> cornealContactlLensPos;
	private CornealContactlLensPo cornealContactlLensPo;
	private ContactGlassPo contactGlassPo;
	private List<ContactGlassPo> contactGlassPos;

	private RefractivePo refractivePo;
	private RefractiveHydsyMgr refractiveHydsyMgr;
	private PersonPermissionMgr personPermissionMgr;
	private HealthCheckPo healthCheckPo;
	private OptometryBasicPo optometryBasicPo;
	private InspectionPo inspectionPo;
	private List<InspectionPo> inspectionPos;
	private OptometryBasicHydsyMgr optometryBasicHydsyMgr;
	private CustomerInfoPo customerInfoPo;
	private DoubleEyeFunPo doubleEyeFunPo;
	private CustomerInfoMgr customerInfoMgr;
	private DoubleEyeFunHydsyMgr doubleEyeFunHydsyMgr;
	private OptometryPo optometryPo;
	private MydriasisHydsyMgr mydriasisHydsyMgr;
	private MydriasisPo mydriasisPo;
	private List<OptionParamPo> optionParamPolist;

	private OptionParamMgr optionParamMgr;;

	/*
	 * 
	 * 初始化屈光检查新增
	 */
	public String initRefractiveInsertN() throws Exception {
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
		// systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号
		String chuyanfuyan = request.getParameter("chuyanfuyan"); // 初验0复验1

		/*
		 * 复制处方移动到复验里,yiwuyong.
		 */
		if ("1".equals(chuyanfuyan)) {
			request.setAttribute("oldOptometryIDFirst", request
					.getParameter("oldOptometryID"));
			request.setAttribute("copyBasicOptometryID", request
					.getParameter("optometryBasicID"));
		}

		CustomerInfoPo tempCustomerInfoPo = new CustomerInfoPo();
		tempCustomerInfoPo.setSmecicustomerid(customerID);
		customerInfoPo = customerInfoMgr.getCustomerInfo(tempCustomerInfoPo); // optometrytitle
		MydriasisPo mpo = new MydriasisPo();
		mpo.setSopmdfcustomerid(customerInfoPo.getSmecicustomerid());
		mydriasisPo = mydriasisHydsyMgr.getMydriasis(mpo);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		if (!"".equals(optometryBasicID)) { //
			request.setAttribute("optometryBasicID", optometryBasicID);
		} else {
			SimpleDateFormat numHeadFormat = new SimpleDateFormat(
					"yyyyMMddHHmmss");
			String numHead = "O" + personInfoPo.getDepartmentID()
					+ personInfoPo.getMachinery()
					+ numHeadFormat.format(new Date());
			request.setAttribute("optometryBasicID", numHead);

		}
		OptometryPo optometryPo = new OptometryPo();
		optometryPo.setSopoyoptometryid(optometryID);
		int isDoubleEyeFun = doubleEyeFunHydsyMgr.getDoubleEyeFunCount(optometryPo);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);		

		request.setAttribute("isDoubleEyeFun", isDoubleEyeFun);
		request.setAttribute("customerID", customerID);
		request.setAttribute("readOnly", "readOnly");
		return SUCCESS;
	}

	/*
	 * 
	 * 新增屈光检查
	 */
	public String refractiveInsertN() throws Exception {
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
		// systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号
		String chuyanfuyan = Utility.getName(request
				.getParameter("chuyanfuyan"));

		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " "
				+ "HH:mm:ss");
		String nowTime = tempDate.format(new Date()); // 取得当前日期
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String shopcodeid = Utility.getName(personInfoPo.getDepartmentID());// 部门
		String refractiverID = Utility.getName(personInfoPo.getId());
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

		refractivePo.setSoprcustomerid(customerID);
		refractivePo.setSoprrefractiverid(refractiverID);
		refractivePo.setSoproptometrybasicid(optometryBasicID);
		refractivePo.setSoproptometryid(optometryPo.getSopoyoptometryid());
		refractivePo.setSoprinspectiondate(nowTime);
		refractivePo.setSoprshopcode(shopcodeid);

		/**
		 * optometry基表新增
		 */

		OptometryBasicPo optometryBasicPo = new OptometryBasicPo();
		optometryBasicPo.setSopoboptometrybasicid(optometryBasicID);
		if (optometryBasicHydsyMgr.getOptometryBasicCount2(optometryBasicPo) == 0) {
			optometryBasicPo = new OptometryBasicPo();
			optometryBasicPo.setSopobcustomerid(customerID);
			optometryBasicPo
					.setSopobcustomername(customerInfoPo.getSmeciname());
			optometryBasicPo.setSopobmedicalendtime(nowTime);
			optometryBasicPo.setSopobmedicalstarttime(nowTime);
			optometryBasicPo.setSopoboptometrybasicid(optometryBasicID);
		} else {
			optometryBasicPo = null;
		}

		refractiveHydsyMgr.insertRefractivePo(refractivePo, optometryPo,
				optometryBasicPo);

		int isDoubleEyeFun = doubleEyeFunHydsyMgr.getDoubleEyeFunCount(optometryPo);

		request.setAttribute("isDoubleEyeFun", isDoubleEyeFun);

		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	/*
	 * 
	 * 初始化屈光检查修改
	 */
	public String initRefractiveUpdateN() throws Exception {
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
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号
		String chuyanfuyan = request.getParameter("chuyanfuyan"); // 初验0复验1
		CustomerInfoPo tempCustomerInfoPo = new CustomerInfoPo();
		tempCustomerInfoPo.setSmecicustomerid(customerID);
		customerInfoPo = customerInfoMgr.getCustomerInfo(tempCustomerInfoPo);
		refractivePo = new RefractivePo();
		refractivePo.setSoprcustomerid(customerID);
		refractivePo.setSoproptometryid(optometryID);
		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);
		request.setAttribute("oldOptometryID", request
				.getParameter("oldOptometryID"));
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		refractivePo = refractiveHydsyMgr.getRefractive(refractivePo);
		OptometryPo doublecheck = new OptometryPo();
		doublecheck.setSopoyoptometryid(optometryID);
		int isDoubleEyeFun = doubleEyeFunHydsyMgr.getDoubleEyeFunCount(doublecheck);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		request.setAttribute("isDoubleEyeFun", isDoubleEyeFun);

		if ((Utility.getName(refractivePo.getSoproptometryid())).equals("")) {
			return "insert";
		}

		return SUCCESS;
	}

	/*
	 * 
	 * 修改屈光检查
	 */
	public String refractiveUpdateN() throws Exception {
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
		String updatePertson = personInfoPo.getId();
		String soprrefractiverid = personInfoPo.getId();
		String soprshopcode = personInfoPo.getDepartmentID();
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号
		String chuyanfuyan = request.getParameter("chuyanfuyan"); // 初验0复验1

		refractivePo.setSoprrefractiverid(soprrefractiverid);
		refractivePo.setSoprshopcode(soprshopcode);
		refractivePo.setSoprcustomerid(customerID);
		if (refractiveHydsyMgr.getRefractiveCount(optometryPo) > 0) {
			refractivePo.setSoproptometryid(optometryID);
		} else {
			refractivePo
					.setSoproptometryid(Utility.getName(
							request.getParameter("oldOptometryID")).equals("") ? optometryID
							: Utility.getName(request
									.getParameter("oldOptometryID")));
		}

		optometryBasicPo = new OptometryBasicPo();
		optometryBasicPo.setSopoboptometrybasicid(optometryBasicID);

		optometryPo = new OptometryPo();
		optometryPo.setSopoyupdateuserid(updatePertson);
		optometryPo.setSopoyoptometryid(optometryBasicID);

		refractiveHydsyMgr.updateRefractive(refractivePo, optometryPo,
				optometryBasicPo);

		int isDoubleEyeFun = doubleEyeFunHydsyMgr.getDoubleEyeFunCount(optometryPo);

		request.setAttribute("isDoubleEyeFun", isDoubleEyeFun);

		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		request.setAttribute("oldOptometryID", request
				.getParameter("oldOptometryID"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		return SUCCESS;
	}

	/*
	 * 
	 * copy屈光检查
	 */
	public String refractiveCopyN() throws Exception {

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
		// systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号
		String chuyanfuyan = request.getParameter("chuyanfuyan"); // 初验0复验1
		OptometryPo po1 = optometryBasicHydsyMgr.getOptometryPo(optometryBasicID);
		RefractivePo Po2 = new RefractivePo();
		Po2.setSoproptometryid(po1.getSopoyoptometryid());
		refractivePo = refractiveHydsyMgr.getRefractive(Po2);

		CustomerInfoPo tempCustomerInfoPo = new CustomerInfoPo();
		tempCustomerInfoPo.setSmecicustomerid(customerID);
		customerInfoPo = customerInfoMgr.getCustomerInfo(tempCustomerInfoPo);

		OptometryPo doublecheck = new OptometryPo();
		doublecheck.setSopoyoptometryid(optometryID);
		int isDoubleEyeFun = doubleEyeFunHydsyMgr.getDoubleEyeFunCount(doublecheck);

		request.setAttribute("isDoubleEyeFun", isDoubleEyeFun);

		request.setAttribute("optometryBasicID", optometryBasicID);
		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);		return SUCCESS;
	}

	/*
	 * 
	 * 查询屈光检查
	 */
	public String initRefractiveSelectN() throws Exception {

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
		// systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		RefractivePo Po2 = new RefractivePo();
		Po2.setSoproptometryid(request.getParameter("optometryID"));
		refractivePo = refractiveHydsyMgr.getRefractive(Po2);

		request.setAttribute("readOnly", "readOnly");
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号

		CustomerInfoPo tempCustomerInfoPo = new CustomerInfoPo();
		tempCustomerInfoPo.setSmecicustomerid(customerID);
		customerInfoPo = customerInfoMgr.getCustomerInfo(tempCustomerInfoPo);

		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);

		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);

		String chuyanfuyan = Utility.getName(request
				.getParameter("chuyanfuyan"));
		request.setAttribute("chuyanfuyan", chuyanfuyan);

		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		return SUCCESS;
	}

	/*
	 * 
	 * 处理屈光检查
	 */
	public String refractiveToolN() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);
		String chuyanfuyan = Utility.getName(request
				.getParameter("chuyanfuyan")); // 初验0复验1

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		// systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		String source = request.getParameter("source");
		request.setAttribute("readOnly", "readOnly");
		int count = 0;
		if (!Utility.getName(request.getParameter("oldOptometryID")).equals("")) {
			source = "refractiveCopy";
		}

		int isDoubleEyeFun = doubleEyeFunHydsyMgr.getDoubleEyeFunCount(optometryPo);
		request.setAttribute("isDoubleEyeFun", isDoubleEyeFun);
		if ("refractiveiou".equals(source)) {
			count = this.refractiveHydsyMgr.getRefractiveCount(optometryPo);
			if (count > 0) {
				return "refractiveu";
			} else {
				return "refractivei";
			}
		} else {
			String optometryID = optometryPo.getSopoyoptometryid();
			if (optometryBasicHydsyMgr.getOptometryCount2(optometryPo) > 0
					&& refractiveHydsyMgr.getRefractiveCount(optometryPo) > 0) {

			} else {
				optometryPo.setSopoyoptometryid(Utility.getName(request
						.getParameter("oldOptometryID")));
			}
			request.setAttribute("oldOptometryID", request
					.getParameter("oldOptometryID"));
			count = this.refractiveHydsyMgr.getRefractiveCount(optometryPo);

			if (count > 0) {

				optometryPo.setSopoyoptometryid(optometryID);
				if (this.refractiveHydsyMgr.getRefractiveCount(optometryPo) == 0) {
					request.setAttribute("copy", "copy");
				}

				return "refractivecopy";
			} else {
				return "refractiveu";
			}
		}

	}

	public MydriasisPo getMydriasisPo() {
		return mydriasisPo;
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

	public void setMydriasisPo(MydriasisPo mydriasisPo) {
		this.mydriasisPo = mydriasisPo;
	}

	public MydriasisHydsyMgr getMydriasisHydsyMgr() {
		return mydriasisHydsyMgr;
	}

	public void setMydriasisHydsyMgr(MydriasisHydsyMgr mydriasisHydsyMgr) {
		this.mydriasisHydsyMgr = mydriasisHydsyMgr;
	}

	public DoubleEyeFunHydsyMgr getDoubleEyeFunHydsyMgr() {
		return doubleEyeFunHydsyMgr;
	}

	public void setDoubleEyeFunHydsyMgr(DoubleEyeFunHydsyMgr doubleEyeFunHydsyMgr) {
		this.doubleEyeFunHydsyMgr = doubleEyeFunHydsyMgr;
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

	public HealthCheckPo getHealthCheckPo() {
		return healthCheckPo;
	}

	public void setHealthCheckPo(HealthCheckPo healthCheckPo) {
		this.healthCheckPo = healthCheckPo;
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

	public OptometryBasicHydsyMgr getOptometryBasicHydsyMgr() {
		return optometryBasicHydsyMgr;
	}

	public void setOptometryBasicHydsyMgr(OptometryBasicHydsyMgr optometryBasicHydsyMgr) {
		this.optometryBasicHydsyMgr = optometryBasicHydsyMgr;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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

	public void setCornealContactlLensPo(
			CornealContactlLensPo cornealContactlLensPo) {
		this.cornealContactlLensPo = cornealContactlLensPo;
	}
}
