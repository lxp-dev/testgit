package com.pengsheng.eims.hydsycasehistory.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pengsheng.eims.hydsycasehistory.mgr.DoubleEyeFunHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.OptometryBasicHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.mgr.SpecialCheckHydsyMgr;
import com.pengsheng.eims.hydsycasehistory.persistence.ContactGlassPo;
import com.pengsheng.eims.hydsycasehistory.persistence.CornealContactlLensPo;
import com.pengsheng.eims.hydsycasehistory.persistence.DoubleEyeFunPo;
import com.pengsheng.eims.hydsycasehistory.persistence.HealthCheckPo;
import com.pengsheng.eims.hydsycasehistory.persistence.InspectionPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryBasicPo;
import com.pengsheng.eims.hydsycasehistory.persistence.OptometryPo;
import com.pengsheng.eims.hydsycasehistory.persistence.RefractivePo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;

public class SpecialCheckHydsyAction extends BaseAction {
	private List<CornealContactlLensPo> cornealContactlLensPos;
	private CornealContactlLensPo cornealContactlLensPo;
	private OptometryBasicPo optometryBasicPo;
	private HealthCheckPo healthCheckPo;
	private RefractivePo refractivePo;
	private OptometryPo optometryPo;
	private InspectionPo inspectionPo;
	private DoubleEyeFunPo doubleEyeFunPo;
	private CustomerInfoPo customerInfoPo;
	private OptometryBasicHydsyMgr optometryBasicHydsyMgr;
	private DoubleEyeFunHydsyMgr doubleEyeFunHydsyMgr;
	private SpecialCheckHydsyMgr specialCheckHydsyMgr;
	private List<InspectionPo> inspectionPos;

	private ContactGlassPo contactGlassPo;

	private List<ContactGlassPo> contactGlassPos;
	private List<OptionParamPo> optionParamPolist;

	private OptionParamMgr optionParamMgr;;



	/**
	 *初始化新新增特殊功能检查
	 * 
	 * @return
	 */
	public String initSpecialCheckInsertN() {

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
		String chuyanfuyan = Utility.getName(request
				.getParameter("chuyanfuyan")); // 初验0复验1

		optometryPo.setSopoyoptometrybasicid(optometryBasicID);
		// systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		request.setAttribute("createPerson", createPerson);
		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		int isDoubleEyeFun = doubleEyeFunHydsyMgr.getDoubleEyeFunCount(optometryPo);
		request.setAttribute("isDoubleEyeFun", isDoubleEyeFun);

		return SUCCESS;
	}

	/**
	 *新增特殊功能检查
	 * 
	 * @return
	 */
	public String insertSpecialCheckN() {

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

		healthCheckPo.setSophccustomerid(customerID);
		healthCheckPo.setSophcoptometryid(optometryID);
		healthCheckPo.setSophcoptometrybasicid(optometryBasicID);

		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " "
				+ "HH:mm:ss");
		String nowTime = tempDate.format(new Date()); // 取得当前日期
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
		optometryPo.setSopoyoptometrybasicid(Utility.getName(request
				.getParameter("optometryBasicID")));
		optometryPo.setSopoyisinternal("N");
		optometryPo.setSopoyoneormany(chuyanfuyan);

		/**
		 * optometry基表新增
		 */
		String a = healthCheckPo.getSophcchecker();
		OptometryBasicPo optometryBasicPo = new OptometryBasicPo();
		optometryBasicPo.setSopoboptometrybasicid(Utility.getName(request
				.getParameter("optometryBasicID")));
		if (optometryBasicHydsyMgr.getOptometryBasicCount2(optometryBasicPo) == 0) {

			optometryBasicPo = new OptometryBasicPo();
			optometryBasicPo.setSopobcustomerid(customerID);
			optometryBasicPo
					.setSopobcustomername(customerInfoPo.getSmeciname());
			optometryBasicPo.setSopobmedicalendtime(nowTime);
			optometryBasicPo.setSopobmedicalstarttime(nowTime);
			optometryBasicPo.setSopoboptometrybasicid(Utility.getName(request
					.getParameter("optometryBasicID")));
		} else {
			optometryBasicPo = null;
		}
		specialCheckHydsyMgr.insertSpecialCheck(healthCheckPo, optometryBasicPo,
				optometryPo);
		optometryPo.setSopoyoptometrybasicid(optometryBasicID);
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

	/**
	 *初始化更新特殊功能检查
	 * 
	 * @return
	 */
	public String initSpecialCheckUpdateN() {

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
		String optometryBasicID = Utility.getName(request.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request.getParameter("optometryID"));// 验光号
		String chuyanfuyan = Utility.getName(request.getParameter("chuyanfuyan")); // 初验0复验1

		if (optometryPo == null){
			optometryPo = new OptometryPo();
		}
		
		if ("".equals(optometryID)) {
			optometryID = optometryPo.getSopoyoptometrybasicid();
		}

		String oldOptometryID = null;
		if (!Utility.getName(request.getParameter("oldOptometryID")).equals("")) {
			oldOptometryID = Utility.getName(request.getParameter("oldOptometryID"));
			request.setAttribute("oldOptometryID", oldOptometryID);
			if (this.optometryBasicHydsyMgr.getOptometryCount2(optometryPo) > 0	&& this.specialCheckHydsyMgr.getSpecialCheckCount(optometryPo) > 0) {
				oldOptometryID = null;
			}
		}
		optometryPo.setSopoyoptometrybasicid(optometryBasicID);
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		healthCheckPo = new HealthCheckPo();
		healthCheckPo.setSophccustomerid(customerID);
		healthCheckPo.setSophcoptometryid(oldOptometryID == null ? optometryID : oldOptometryID);
		healthCheckPo.setSophcoptometrybasicid(optometryBasicID);
		healthCheckPo = specialCheckHydsyMgr.getSpecialCheck(healthCheckPo);
		
		optometryPo.setSopoyjumpType("update");
		int isDoubleEyeFun = doubleEyeFunHydsyMgr.getDoubleEyeFunCount(optometryPo);
		
		request.setAttribute("isDoubleEyeFun", isDoubleEyeFun);
		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		request.setAttribute("readOnly", "readOnly");
		
		return SUCCESS;
	}
	
	public String initSpecialCheckUpdateN2() {

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

		String optometryBasicID = Utility.getName(request.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request.getParameter("optometryID"));// 验光号
		String chuyanfuyan = Utility.getName(request.getParameter("chuyanfuyan")); // 初验0复验1
		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		
		if (optometryPo == null){
			optometryPo = new OptometryPo();
		}
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		healthCheckPo = new HealthCheckPo();
		healthCheckPo.setSophccustomerid(customerID);
		healthCheckPo.setSophcoptometryid(optometryID);
		healthCheckPo.setSophcoptometrybasicid(optometryBasicID);
		healthCheckPo = specialCheckHydsyMgr.getSpecialCheck(healthCheckPo);

		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("customerID", customerID);
		
		return SUCCESS;
	}

	/**
	 *更新特殊功能检查
	 * 
	 * @return
	 */
	public String updateSpecialCheckN() {

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
		// 得到当前登录人信息
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String updatePertson = personInfoPo.getId();

		String customerID = Utility.getName(request.getParameter("customerID"));// 顾客号
		String optometryBasicID = Utility.getName(request
				.getParameter("optometryBasicID"));// 验光基表ID
		String optometryID = Utility.getName(request
				.getParameter("optometryID"));// 验光号
		String chuyanfuyan = request.getParameter("chuyanfuyan"); // 初验0复验1

		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		request.setAttribute("chuyanfuyan", chuyanfuyan);

		if (specialCheckHydsyMgr.getSpecialCheckCount(optometryPo) > 0) {
			healthCheckPo.setSophcoptometryid(optometryID);
		} else {
			healthCheckPo
					.setSophcoptometryid(Utility.getName(
							request.getParameter("oldOptometryID")).equals("") ? optometryPo
							.getSopoyoptometryid()
							: Utility.getName(request
									.getParameter("oldOptometryID")));
		}

		healthCheckPo.setSophccustomerid(customerID);
		healthCheckPo.setSophcoptometryid(optometryID);
		healthCheckPo.setSophcoptometrybasicid(optometryBasicID);

		optometryPo = new OptometryPo();
		optometryPo.setSopoyupdateuserid(updatePertson);
		optometryPo.setSopoyoptometryid(optometryID);

		optometryBasicPo = new OptometryBasicPo();
		optometryBasicPo.setSopoboptometrybasicid(optometryBasicID);
		
		healthCheckPo.setSophcchecker(createPerson);
		
		int count = specialCheckHydsyMgr.getSpecialCheckCount(optometryPo);
		if (count == 0){
			specialCheckHydsyMgr.insertSpecialCheck(healthCheckPo, optometryBasicPo,optometryPo);
		}else{
			specialCheckHydsyMgr.updateSpecialCheck(healthCheckPo, optometryBasicPo,optometryPo);
		}
		
		int isDoubleEyeFun = doubleEyeFunHydsyMgr.getDoubleEyeFunCount(optometryPo);
		request.setAttribute("isDoubleEyeFun", isDoubleEyeFun);
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		request.setAttribute("oldOptometryID", request
				.getParameter("oldOptometryID"));
		optometryPo.setSopoyjumpType("update");
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 *查询特殊功能检查
	 * 
	 * @return
	 */
	public String selectSpecialCheckN() {

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

		request.setAttribute("customerID", customerID);
		request.setAttribute("optometryID", optometryID);
		request.setAttribute("optometryBasicID", optometryBasicID);

		healthCheckPo = new HealthCheckPo();
		healthCheckPo.setSophccustomerid(customerID);
		healthCheckPo.setSophcoptometryid(optometryID);
		healthCheckPo.setSophcoptometrybasicid(optometryBasicID);
		request.setAttribute("readOnly", "readOnly");
		healthCheckPo = specialCheckHydsyMgr.getSpecialCheck(healthCheckPo);
		String chuyanfuyan = Utility.getName(request
				.getParameter("chuyanfuyan"));
		request.setAttribute("chuyanfuyan", chuyanfuyan);

		String dontshow = Utility.getName(request.getParameter("dontshow"));
		request.setAttribute("dontshow", dontshow);

		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	public String specialCheckToolN() {

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
		String source = request.getParameter("source");
		request.setAttribute("readOnly", "readOnly");
		int count = 0;
		if (!Utility.getName(request.getParameter("oldOptometryID")).equals("")) {
			source = "specialcheckcopy";
		}
		int isDoubleEyeFun = doubleEyeFunHydsyMgr.getDoubleEyeFunCount(optometryPo);
		request.setAttribute("isDoubleEyeFun", isDoubleEyeFun);
		if ("specialcheckiou".equals(source)) {
			count = this.specialCheckHydsyMgr.getSpecialCheckCount(optometryPo);
			if (count > 0) {
				return "specialchecku";
			} else {
				return "specialchecki";
			}
		} else {
			String optometryID = optometryPo.getSopoyoptometryid();
			if (optometryBasicHydsyMgr.getOptometryCount2(optometryPo) > 0
					&& specialCheckHydsyMgr.getSpecialCheckCount(optometryPo) > 0) {

			} else {
				optometryPo.setSopoyoptometryid(Utility.getName(request
						.getParameter("oldOptometryID")));
			}
			request.setAttribute("oldOptometryID", request
					.getParameter("oldOptometryID"));
			count = this.specialCheckHydsyMgr.getSpecialCheckCount(optometryPo);

			if (count > 0) {

				optometryPo.setSopoyoptometryid(optometryID);
				if (this.specialCheckHydsyMgr.getSpecialCheckCount(optometryPo) == 0) {
					request.setAttribute("copy", "copy");
				}

				return "specialchecku";
			} else {
				return "specialchecki";
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
	public DoubleEyeFunHydsyMgr getDoubleEyeFunHydsyMgr() {
		return doubleEyeFunHydsyMgr;
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

	public void setDoubleEyeFunHydsyMgr(DoubleEyeFunHydsyMgr doubleEyeFunHydsyMgr) {
		this.doubleEyeFunHydsyMgr = doubleEyeFunHydsyMgr;
	}

	public RefractivePo getRefractivePo() {
		return refractivePo;
	}

	public void setRefractivePo(RefractivePo refractivePo) {
		this.refractivePo = refractivePo;
	}

	public DoubleEyeFunPo getDoubleEyeFunPo() {
		return doubleEyeFunPo;
	}

	public void setDoubleEyeFunPo(DoubleEyeFunPo doubleEyeFunPo) {
		this.doubleEyeFunPo = doubleEyeFunPo;
	}

	public OptometryBasicHydsyMgr getOptometryBasicHydsyMgr() {
		return optometryBasicHydsyMgr;
	}

	public void setOptometryBasicHydsyMgr(OptometryBasicHydsyMgr optometryBasicHydsyMgr) {
		this.optometryBasicHydsyMgr = optometryBasicHydsyMgr;
	}

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

	public SpecialCheckHydsyMgr getSpecialCheckHydsyMgr() {
		return specialCheckHydsyMgr;
	}

	public void setSpecialCheckHydsyMgr(SpecialCheckHydsyMgr specialCheckHydsyMgr) {
		this.specialCheckHydsyMgr = specialCheckHydsyMgr;
	}

	public HealthCheckPo getHealthCheckPo() {
		return healthCheckPo;
	}

	public void setHealthCheckPo(HealthCheckPo healthCheckPo) {
		this.healthCheckPo = healthCheckPo;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
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

	private PersonPermissionMgr personPermissionMgr;

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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
}