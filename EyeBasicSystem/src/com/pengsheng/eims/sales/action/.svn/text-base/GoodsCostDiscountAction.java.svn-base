package com.pengsheng.eims.sales.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.mgr.GoodsCostDiscountMgr;
import com.pengsheng.eims.sales.mgr.SetMealMgr;
import com.pengsheng.eims.sales.persistence.SetMealChildPropertyPo;
import com.pengsheng.eims.sales.persistence.SetMealEntryPo;
import com.pengsheng.eims.sales.persistence.SetMealEntryTempPo;
import com.pengsheng.eims.sales.persistence.SetMealParentPropertyPo;
import com.pengsheng.eims.sales.persistence.SetMealPo;
import com.pengsheng.eims.sales.persistence.SetMealPropertyValuePo;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.FrameMaterialMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.mgr.TeachnologyTypeMgr;
import com.pengsheng.eims.system.persistence.FrameMaterialPo;
import com.pengsheng.eims.system.persistence.IntegralPo;
import com.pengsheng.eims.system.persistence.MaxDiscountPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.system.persistence.TeachnologyTypePo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class GoodsCostDiscountAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;	
	private SetMealPo setMealPo;
	private List<SetMealPo> setMealList;
	private List<SetMealEntryPo> salesGoodsArrayList;
	private List<SetMealEntryPo> creditGoodsArrayList;
	private SetMealEntryTempPo salesGoodsArray;
	private SetMealEntryTempPo creditGoodsArray;
	private SetMealEntryPo setMealEntryPo;
	private DepartmentsMgr departmentsMgr;	
	private DepartmentsPo departmentsPo;
	private List<DepartmentsPo> departmentList = null;
	private GoodsCostDiscountMgr goodsCostDiscountMgr;
	private UnitMgr unitMgr;
	private List<RefractiveSetPo> refractiveSetList = null;
	private List<GoodsInfoPo> goodsList = null;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private GoodsInfoTempPo goodsInfoTempPo = null;
	private IntegralPo integralPo = null;
	private List<IntegralPo> integralList = null;
	private TeachnologyTypeMgr teachnologyTypeMgr;
	private List<TeachnologyTypePo> teachnologyTypeList;
	private List<MaxDiscountPo> maxDiscountList;
	private MaxDiscountPo maxDiscountPo;
	private FrameMaterialMgr frameMaterialMgr = null;	
	private List<FrameMaterialPo> frameMateriallist = null;
	private List<SetMealParentPropertyPo> setMealParentPropertyList = null;
	private List<SetMealChildPropertyPo> setMealChildPropertyList = null;
	private List<SetMealPropertyValuePo> setMealPropertyValueList = null;
	protected UUIDHexGenerator uuid = UUIDHexGenerator.getInstance();
	
	public List<SetMealParentPropertyPo> getSetMealParentPropertyList() {
		return setMealParentPropertyList;
	}

	public void setSetMealParentPropertyList(
			List<SetMealParentPropertyPo> setMealParentPropertyList) {
		this.setMealParentPropertyList = setMealParentPropertyList;
	}

	public List<SetMealChildPropertyPo> getSetMealChildPropertyList() {
		return setMealChildPropertyList;
	}

	public void setSetMealChildPropertyList(
			List<SetMealChildPropertyPo> setMealChildPropertyList) {
		this.setMealChildPropertyList = setMealChildPropertyList;
	}

	public List<SetMealPropertyValuePo> getSetMealPropertyValueList() {
		return setMealPropertyValueList;
	}

	public void setSetMealPropertyValueList(
			List<SetMealPropertyValuePo> setMealPropertyValueList) {
		this.setMealPropertyValueList = setMealPropertyValueList;
	}

	public List<FrameMaterialPo> getFrameMateriallist() {
		return frameMateriallist;
	}

	public void setFrameMateriallist(List<FrameMaterialPo> frameMateriallist) {
		this.frameMateriallist = frameMateriallist;
	}

	public FrameMaterialMgr getFrameMaterialMgr() {
		return frameMaterialMgr;
	}

	public void setFrameMaterialMgr(FrameMaterialMgr frameMaterialMgr) {
		this.frameMaterialMgr = frameMaterialMgr;
	}

	public List<MaxDiscountPo> getMaxDiscountList() {
		return maxDiscountList;
	}

	public void setMaxDiscountList(List<MaxDiscountPo> maxDiscountList) {
		this.maxDiscountList = maxDiscountList;
	}

	public MaxDiscountPo getMaxDiscountPo() {
		return maxDiscountPo;
	}

	public void setMaxDiscountPo(MaxDiscountPo maxDiscountPo) {
		this.maxDiscountPo = maxDiscountPo;
	}

	
	

	/***************************************************************************************************************************/
	
	/**
	 * 初始化最大折扣设置
	 * @return
	 * @throws Exception
	 */
	public String initGoodsCostDiscountSetSel() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "goodsCostDiscountSetSel";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 最大折扣设置查询
	 * @return
	 * @throws Exception
	 */
	public String goodsCostDiscountSetSel() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);

		maxDiscountPo = new MaxDiscountPo();
		if (goodsCategoryID.startsWith("3") || goodsCategoryID.startsWith("4")){
			maxDiscountPo.setFmdiscustomize(goodsCategoryID.split("_")[1]);
			maxDiscountPo.setFmdgoodscategoryid(goodsCategoryID.split("_")[0]);				
		}else{
			maxDiscountPo.setFmdgoodscategoryid(goodsCategoryID);
		}
		
		maxDiscountPo.setFmdsupplierid(supplierID);
		maxDiscountPo.setFmdbrandid(brandID);
		maxDiscountPo.setFmdgoodsid(goodsID);
		maxDiscountPo.setFmdgoodsname(goodsName);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")){
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(systemParameterPo.getFspshowchange()).equals("3") ? "0" : "2"));
		}else{	
			String showchange = Utility.getName(systemParameterPo.getFspselectovershowchange());
			if (showchange.equals("0")){
				request.setAttribute("showhider","0");
			}else{
				request.setAttribute("showhider", "2");
			}
		}
		
		int count = goodsCostDiscountMgr.getMaxDiscountSetCount(maxDiscountPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			maxDiscountList = goodsCostDiscountMgr.getMaxDiscountSetList(maxDiscountPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			maxDiscountList = null;
		}
	
		return SUCCESS;
	}
	
	/**
	 * 初始化最大折扣设置新增
	 * @return
	 * @throws Exception
	 */
	public String initGoodsCostDiscountSetInsert() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		return SUCCESS;
	}
	
	/**
	 * 最大折扣设置新增
	 * @return
	 * @throws Exception
	 */
	public String insertGoodsCostDiscountSet() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		if (maxDiscountPo.getFmdgoodscategoryid().equals("3-0")){
			maxDiscountPo.setFmdgoodscategoryname("成品片");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("3-D")){
			maxDiscountPo.setFmdgoodscategoryname("订做片");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("4-0")){
			maxDiscountPo.setFmdgoodscategoryname("隐形成品片");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("4-D")){
			maxDiscountPo.setFmdgoodscategoryname("隐形订做片");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("1")){
			maxDiscountPo.setFmdgoodscategoryname("镜架");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("2")){
			maxDiscountPo.setFmdgoodscategoryname("配件");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("5")){
			maxDiscountPo.setFmdgoodscategoryname("隐形护理液");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("6")){
			maxDiscountPo.setFmdgoodscategoryname("太阳镜");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("7")){
			maxDiscountPo.setFmdgoodscategoryname("耗材");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("8")){
			maxDiscountPo.setFmdgoodscategoryname("老花镜");				
		}
		if (maxDiscountPo.getFmdgoodscategoryid().equals("9")){
			maxDiscountPo.setFmdgoodscategoryname("视光");				
		}			
		if (maxDiscountPo.getFmdgoodscategoryid().startsWith("3") || maxDiscountPo.getFmdgoodscategoryid().startsWith("4")){
			maxDiscountPo.setFmdiscustomize(maxDiscountPo.getFmdgoodscategoryid().split("-")[1]);
			maxDiscountPo.setFmdgoodscategoryid(maxDiscountPo.getFmdgoodscategoryid().split("-")[0]);				
		}
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("最大折扣设置:" + Utility.getName(maxDiscountPo.getFmdid()) + "新增!");
		
		int count = goodsCostDiscountMgr.isExistMaxDiscountSet(maxDiscountPo);
		if (count == 0){

			goodsCostDiscountMgr.insertMaxDiscountSet(maxDiscountPo, logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));		
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
		}else{
			this.clearMessages();
			this.addActionMessage(getText("最大折扣设置不能重复!"));
			
			return "NoRepeat";
		}

		return SUCCESS;
	}
	
	/**
	 * 初始化最大折扣设置更新
	 * @return
	 * @throws Exception
	 */
	public String initGoodsCostDiscountSetUpdate() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		maxDiscountPo = new MaxDiscountPo();
		maxDiscountPo.setFmdid(Utility.getName(request.getParameter("hid")));
		
		maxDiscountPo = goodsCostDiscountMgr.getMaxDiscountSetDetail(maxDiscountPo);
		
		return SUCCESS;
	}
	
	
	/**
	 * 最大折扣设置更新
	 * @return
	 * @throws Exception
	 */
	public String updateGoodsCostDiscountSet() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("最大折扣设置：" + Utility.getName(maxDiscountPo.getFmdid()) +"修改!");
		
		goodsCostDiscountMgr.updateMaxDiscountSet(maxDiscountPo, logPo);		
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}	
	
	/**
	 * 初始化最大折扣设置删除
	 * @return
	 * @throws Exception
	 */
	public String initGoodsCostDiscountSetDelete() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String hid = Utility.getName(request.getParameter("hid"));
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	
	
	/**
	 * 删除最大折扣设置
	 * @return
	 * @throws Exception
	 */
	public String deleteGoodsCostDiscountSet() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("最大折扣设置：" + Utility.getName(maxDiscountPo.getFmdid()) + "删除!");
		
		goodsCostDiscountMgr.deleteMaxDiscountSet(maxDiscountPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	
	/**
	 * 初始化最大折扣设置批量删除
	 * @return
	 * @throws Exception
	 */
	public String initGoodsCostDiscountSetBatchDelete() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String hid = Utility.getName(request.getParameter("hid"));
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	
	
	/**
	 * 批量删除最大折扣设置
	 * @return
	 * @throws Exception
	 */
	public String deleteBatchGoodsCostDiscountSet() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("最大折扣设置：" + Utility.getName(maxDiscountPo.getFmdid()) + "批量删除!");
		
		goodsCostDiscountMgr.deleteBatchMaxDiscountSet(maxDiscountPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	
	/**
	 * 初始化最大折扣设置批量修改
	 * @return
	 * @throws Exception
	 */
	public String initGoodsCostDiscountSetBatchUpdate() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String hid = Utility.getName(request.getParameter("hid"));
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	
	
	/**
	 * 批量修改最大折扣设置
	 * @return
	 * @throws Exception
	 */
	public String updateBatchGoodsCostDiscountSet() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("最大折扣设置：" + Utility.getName(maxDiscountPo.getFmdid()) + "批量修改!");
		
		goodsCostDiscountMgr.updateBatchMaxDiscountSet(maxDiscountPo, logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;	
	}
	
	/**
	 * 初始化商品开窗
	 * @return
	 * @throws Exception
	 */
	public String initGoodsCostDiscountOpen() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String categoryID_open = Utility.getName(request.getParameter("categoryID_open"));
		String supplierID_open = Utility.getName(request.getParameter("supplierID_open"));
		String brand_open = Utility.getName(request.getParameter("brand_open"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		
		if (categoryID_open.startsWith("3") || categoryID_open.startsWith("4")){
			request.setAttribute("iscustomize",categoryID_open.split("-")[1]);
		}else{
			request.setAttribute("iscustomize","");
		}
		
		request.setAttribute("goodsCategoryID",categoryID_open);
		request.setAttribute("supplierID",supplierID_open);
		request.setAttribute("brandID",brand_open);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("brandName",brandName);		
		
		return SUCCESS;
	}
	
	/**
	 * 商品开窗
	 * @return
	 * @throws Exception
	 */
	public String goodsCostDiscountOpen() throws Exception {
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		String iscustomize = Utility.getName(request.getParameter("iscustomize"));
		
		request.setAttribute("goodsCategoryID",goodsCategoryID);
		request.setAttribute("supplierName",supplierName);
		request.setAttribute("supplierID",supplierID);
		request.setAttribute("brandName",brandName);
		request.setAttribute("brandID",brandID);
		request.setAttribute("goodsID",goodsID);
		request.setAttribute("goodsName",goodsName);
		request.setAttribute("iscustomize",iscustomize);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		integralPo = new IntegralPo();
		if (goodsCategoryID.startsWith("3") || goodsCategoryID.startsWith("4")){
			integralPo.setFirGoodsCategoryID(goodsCategoryID.split("-")[0]);
		}else{
			integralPo.setFirGoodsCategoryID(goodsCategoryID);
		}		
		integralPo.setFirBrandID(brandID);
		integralPo.setFirSupplierID(supplierID);
		integralPo.setFirGoodsID(goodsID);
		integralPo.setFirGoodsName(goodsName);
		integralPo.setFirIscustomize(iscustomize);
		
		int count = goodsCostDiscountMgr.getGoodsCount(integralPo);
		if (count > 0) {
			int perPage = 0;
			if (request.getParameter("perPage") != null) {
				perPage = new Integer((String) request.getParameter("perPage"))
						.intValue();
			} else if (request.getParameter("perPageNo") != null) {
				if (!request.getParameter("perPageNo").equals("")) {
					perPage = new Integer((String) request
							.getParameter("perPageNo")).intValue();
				} else {
					perPage = fsppageno;
				}
			} else {
				perPage = fsppageno;
			}
			Pagination page = new Pagination(request, count, perPage);
			goodsList = goodsCostDiscountMgr.getGoodsList(integralPo,page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		
		return SUCCESS;
	}
	/***************************************************************************************************************************/
	/***************************************************************************************************************************/
	/***************************************************************************************************************************/
	/***************************************************************************************************************************/
	
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public SetMealPo getSetMealPo() {
		return setMealPo;
	}

	public void setSetMealPo(SetMealPo setMealPo) {
		this.setMealPo = setMealPo;
	}
	public SetMealEntryPo getSetMealEntryPo() {
		return setMealEntryPo;
	}

	public void setSetMealEntryPo(SetMealEntryPo setMealEntryPo) {
		this.setMealEntryPo = setMealEntryPo;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public DepartmentsPo getDepartmentsPo() {
		return departmentsPo;
	}

	public void setDepartmentsPo(DepartmentsPo departmentsPo) {
		this.departmentsPo = departmentsPo;
	}

	public List<DepartmentsPo> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<DepartmentsPo> departmentList) {
		this.departmentList = departmentList;
	}

	

	public GoodsCostDiscountMgr getGoodsCostDiscountMgr() {
		return goodsCostDiscountMgr;
	}

	public void setGoodsCostDiscountMgr(GoodsCostDiscountMgr goodsCostDiscountMgr) {
		this.goodsCostDiscountMgr = goodsCostDiscountMgr;
	}

	public List<SetMealPo> getSetMealList() {
		return setMealList;
	}

	public void setSetMealList(List<SetMealPo> setMealList) {
		this.setMealList = setMealList;
	}

	public UnitMgr getUnitMgr() {
		return unitMgr;
	}

	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}

	public List<RefractiveSetPo> getRefractiveSetList() {
		return refractiveSetList;
	}

	public void setRefractiveSetList(List<RefractiveSetPo> refractiveSetList) {
		this.refractiveSetList = refractiveSetList;
	}

	public List<GoodsInfoPo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsInfoPo> goodsList) {
		this.goodsList = goodsList;
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

	public List<SetMealEntryPo> getSalesGoodsArrayList() {
		return salesGoodsArrayList;
	}

	public void setSalesGoodsArrayList(List<SetMealEntryPo> salesGoodsArrayList) {
		this.salesGoodsArrayList = salesGoodsArrayList;
	}

	public List<SetMealEntryPo> getCreditGoodsArrayList() {
		return creditGoodsArrayList;
	}

	public void setCreditGoodsArrayList(List<SetMealEntryPo> creditGoodsArrayList) {
		this.creditGoodsArrayList = creditGoodsArrayList;
	}

	public SetMealEntryTempPo getSalesGoodsArray() {
		return salesGoodsArray;
	}

	public void setSalesGoodsArray(SetMealEntryTempPo salesGoodsArray) {
		this.salesGoodsArray = salesGoodsArray;
	}

	public SetMealEntryTempPo getCreditGoodsArray() {
		return creditGoodsArray;
	}

	public void setCreditGoodsArray(SetMealEntryTempPo creditGoodsArray) {
		this.creditGoodsArray = creditGoodsArray;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}

	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	public IntegralPo getIntegralPo() {
		return integralPo;
	}

	public void setIntegralPo(IntegralPo integralPo) {
		this.integralPo = integralPo;
	}

	public List<IntegralPo> getIntegralList() {
		return integralList;
	}

	public void setIntegralList(List<IntegralPo> integralList) {
		this.integralList = integralList;
	}

	public TeachnologyTypeMgr getTeachnologyTypeMgr() {
		return teachnologyTypeMgr;
	}

	public void setTeachnologyTypeMgr(TeachnologyTypeMgr teachnologyTypeMgr) {
		this.teachnologyTypeMgr = teachnologyTypeMgr;
	}

	public List<TeachnologyTypePo> getTeachnologyTypeList() {
		return teachnologyTypeList;
	}

	public void setTeachnologyTypeList(List<TeachnologyTypePo> teachnologyTypeList) {
		this.teachnologyTypeList = teachnologyTypeList;
	}

	
}
