package com.pengsheng.eims.system.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.basic.mgr.HisInfoMgr;
import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentTypePo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.HisInfoPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.CompanyNameMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.BrankCardPo;
import com.pengsheng.eims.system.persistence.CompanyNamePo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.DateTool;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.safenet.HaspApi;

public class DepartmentsAction extends BaseAction {

	private CompanyNameMgr companyNameMgr;
	private DepartmentsMgr departmentsMgr;
	private DepartmentsPo departmentsPo;
	private PersonPermissionMgr personPermissionMgr;	
	private List<DepartmentsPo> departmentList = null;
	private List<DepartmentsPo> processDptList = null; //所属加工部门
	private List<WarehousePo> warehouseList; // 仓位列表List
	private List<CompanyNamePo> companyNamePos;
	private WarehouseMgr warehouseMgr;
	private WarehouseConfigurationPo warehouseConfigurationPo;
	private WarehouseConfigurationPo inWarehouseConfigurationPo;
	private WarehouseConfigurationPo warehouseConfigurationPo1;
	private WarehouseConfigurationPo warehouseConfigurationPo2;
	private WarehouseConfigurationPo warehouseConfigurationPo3;
	private WarehouseConfigurationMgr warehouseConfigurationMgr;
	private String menuString;
	private List<FuctionTreeNode> menusList;
	private List<BrankCardPo> brankCardList;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private List<WarehousePo> outwarehouselist;	
	private WarehousePo warehousePo;
	private List<DepartmentTypePo> departmentTypeList;
	private List<HisInfoPo> hisInfoList;	
	private HisInfoPo hisInfoPo;
	private HisInfoMgr hisInfoMgr;
	
	/**
	 * 初始化查询组织树
	 * @return
	 * @throws Exception
	 */
	public String initDepartmentTree() throws Exception {
		
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
	 * 查询组织机构树
	 * @return
	 * @throws Exception
	 */
	public String loadTree() throws Exception {
		
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

		String nodeId = Utility.getName(request.getParameter("pid"));		
		String hrefTarget = Utility.getName(request.getParameter("hrefTarget"));
		String isClosed = Utility.getName(request.getParameter("isClosed"));
		String isRole = Utility.getName(request.getParameter("isRole"));
		String isPerson = Utility.getName(request.getParameter("isPerson"));
		
		String companyID = "";
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			companyID = personInfoPo.getPersoncompanyid();
		}
		
		menusList = departmentsMgr.getDepartmentsTree(nodeId,hrefTarget,moduleID,isClosed,isRole,isPerson,companyID);
		
		return SUCCESS;
	}
	
	/**
	 * 查询组织树
	 * @return
	 * @throws Exception
	 */
	public String departmentTree() throws Exception {
		
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

		String hrefTarget = Utility.getName(request.getParameter("hrefTarget"));
		String isClosed = Utility.getName(request.getParameter("isClosed"));
		request.setAttribute("hrefTarget",hrefTarget);
		request.setAttribute("isClosed",isClosed);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化部门查询
	 * @return
	 * @throws Exception
	 */
	public String initDepartmentSel() throws Exception {
		
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

		String[] str = {"2"};
		String companyID = "";
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			companyID = personInfoPo.getPersoncompanyid();
		}
		
		processDptList = departmentsMgr.getDepartments(str,"0",companyID);
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
		departmentTypeList = departmentsMgr.getDepartmentTypeList();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "departmentSel";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 部门查询
	 * @return
	 * @throws Exception
	 */
	public String departmentSel() throws Exception {
		
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
		
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String departmentName = Utility.getName(request.getParameter("departmentName"));
		String departmentType = Utility.getName(request.getParameter("departmentType"));
		String processDpt = Utility.getName(request.getParameter("processDpt"));
		String departmentFlag = Utility.getName(request.getParameter("departmentFlag"));
		String companysid = Utility.getName(request.getParameter("companysid"));
		
		String treeFlag = Utility.getName(request.getParameter("treeFlag"));		
		if (!treeFlag.equals("")){
			departmentFlag = departmentFlag.equals("") ? "0" : departmentFlag;
		}
		
		request.setAttribute("departmentID",departmentID);
		request.setAttribute("departmentName",departmentName);
		request.setAttribute("departmentType",departmentType);
		request.setAttribute("processDpt",processDpt);
		request.setAttribute("departmentFlag",departmentFlag);
		request.setAttribute("companysid",companysid);
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(departmentID);
		departmentsPo.setBdpdepartmentname(departmentName);
		departmentsPo.setBdptype(departmentType);
		departmentsPo.setBdpregid(processDpt);
		departmentsPo.setBdpisclosed(departmentFlag);
		departmentsPo.setBdpcompanysid(companysid);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			departmentsPo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		
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
		
		int count = departmentsMgr.getDepartmentCount(departmentsPo);
		
		//-----------------Hasp Check By mysflying 2015-3-12----------------------------------
		String haspResult=HaspApi.getHaspResult();	
		if(haspResult.length()!=17){
			this.clearMessages();
			this.addActionMessage(haspResult);
			return SUCCESS;
		}else{
			if(!haspResult.substring(7,17).trim().equals("") && DateTool.compare_date(haspResult.substring(7), systemParameterMgr.getDBSystemData())){
				this.clearMessages();
				this.addActionMessage("截至到"+haspResult.substring(7)+"为系统允许访问时间!");
				return SUCCESS;
			}
			
			DepartmentsPo dpo = new DepartmentsPo();
			dpo.setBdptype("1");
			dpo.setBdpisclosed("0");
			int countHasp = departmentsMgr.getDepartmentCount(dpo);
			BigDecimal bg = new BigDecimal(haspResult.substring(0,6));
			if (bg.intValue() < countHasp){
				this.clearMessages();
				this.addActionMessage(getText("启用的门店总数已超过系统限制,操作失败!"));
				return SUCCESS;
			}
		}
		//-----------------Hasp Check By mysflying 2015-3-12----------------------------------
		
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
			departmentList = departmentsMgr.getDepartmentList(departmentsPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			departmentList = null;
		}
		
		String[] str = {"2"};
		String companyID = "";
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			companyID = personInfoPo.getPersoncompanyid();
		}
		
		processDptList = departmentsMgr.getDepartments(str,"0",companyID);
		
		departmentTypeList = departmentsMgr.getDepartmentTypeList();
		
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));

		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化部门添加
	 * @return
	 * @throws Exception
	 */
	public String initDepartmentInsert() throws Exception {
		
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

		String[] str = {"2"};
		String companyID = "";
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			companyID = personInfoPo.getPersoncompanyid();
		}
		
		processDptList = departmentsMgr.getDepartments(str,"0",companyID);
		
		brankCardList = departmentsMgr.getBankCardList();
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("1")){
			companyNamePos = companyNameMgr.getCompanyNameForSelect(null);
		}	
		
		departmentTypeList = departmentsMgr.getDepartmentTypeList();
		
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		
		return SUCCESS;
	}
	
	/**
	 * 插入部门信息
	 * @return
	 * @throws Exception
	 */
	public String insertDepartment() throws Exception {
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
		
		//声明部门Po的对象并实例化
		DepartmentsPo temp = new DepartmentsPo();
		
		//将得到的部门id放入新实例化的对象中
		temp.setBdpdepartmentid(departmentsPo.getBdpdepartmentid());
		
		// 1:表示新增仓位  0：暂不新增
		String radiobutton = Utility.getName(request.getParameter("radiobutton"));
		if ("1".equals(radiobutton)){
			departmentsPo.setIsNewWarehouse("1");
		}else{
			departmentsPo.setIsNewWarehouse("0");
		}		
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("部门:" + departmentsPo.getBdpdepartmentid() + "新增!");
		
		//调用mgr得到部门方法，并将其填入新声明的Po对象中
		temp = departmentsMgr.getDepartment(temp);
		
		departmentTypeList = departmentsMgr.getDepartmentTypeList();
		
		if (!"".equals(Utility.getName(temp.getBdpdepartmentid()))) {
			this.clearMessages();
			this.addActionMessage(getText("部门编码重复,新增失败!"));
			
			String url = "''initDepartmentInsert.action?moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(Utility.getName(moduleID));
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));			
			request.setAttribute("flag", GlobalConstants.UPADTE);
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			return SUCCESS;
		}
		
		WarehousePo temp1 = new WarehousePo();
		temp1.setBwhid(departmentsPo.getWarehouseID());
		if (!"".equals(departmentsPo.getWarehouseID())&&!"".equals(Utility.getName(warehouseMgr.getWarehouse(temp1).getBwhid()))){
			this.addActionMessage(getText("仓位编码重复!"));						
			String url = "''initDepartmentInsert.action?moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(Utility.getName(moduleID));
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));			
			request.setAttribute("flag", GlobalConstants.UPADTE);
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			return SUCCESS;	
		}
		
		temp1.setBwhwarehouseName(departmentsPo.getWarehouseName());
		int flagName=warehouseMgr.getWarehouseName(temp1);
		if(flagName>0)
		{
			this.addActionMessage(getText("仓位名称重复!"));			
			String url = "''initDepartmentInsert.action?moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(Utility.getName(moduleID));
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));			
			request.setAttribute("flag", GlobalConstants.UPADTE);
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			return SUCCESS;	
		}
		
		//-----------------Hasp Check By mysflying 2015-3-12----------------------------------
		String url = "''initDepartmentInsert.action?moduleID={1}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));			
		request.setAttribute("flag", GlobalConstants.UPADTE);
		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		
		String haspResult=HaspApi.getHaspResult();	
		if(haspResult.length()!=17){
			this.clearMessages();
			this.addActionMessage(haspResult);
			return SUCCESS;
		}else{
			if(!haspResult.substring(7,17).trim().equals("") && DateTool.compare_date(haspResult.substring(7), systemParameterMgr.getDBSystemData())){
				this.clearMessages();
				this.addActionMessage("截至到"+haspResult.substring(7)+"为系统允许访问时间!");
				return SUCCESS;
			}
			
			DepartmentsPo dpo = new DepartmentsPo();
			dpo.setBdptype("1");
			dpo.setBdpisclosed("0");
			int countHasp = departmentsMgr.getDepartmentCount(dpo);
			BigDecimal bg = new BigDecimal(haspResult.substring(0,6));
			if (bg.intValue() < countHasp){
				this.clearMessages();
				this.addActionMessage(getText("启用的门店总数已超过系统限制,操作失败!"));
				return SUCCESS;
			}
		}
		//-----------------Hasp Check By mysflying 2015-3-12----------------------------------
		
		if (!Utility.getName(departmentsPo.getBdptype()).equals("1")){   // 非门店时清空读取会员卡方式
			departmentsPo.setBdpreadcardform("");
		}
		
		//调用mgr中插入部门方法	
		departmentsMgr.insertDepartment(systemParameterPo,departmentsPo,logPo);
		//打印信息
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		if(goodsTree.equals("1"))
		{
			if(parent.equals("1"))
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
			}
		}else
		{
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}


		return SUCCESS;
	}
	
	/**
	 * 初始化部门更新
	 * @return
	 * @throws Exception
	 */
	public String initDepartmentsUpdate() throws Exception {
		
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
		//将po对象实例化
		if (departmentsPo == null){
			departmentsPo = new DepartmentsPo();		
			departmentsPo.setBdpdepartmentid(Utility.getName(request.getParameter("hid")));
		}
		
		//调用得到部门的方法并将其填入新声明的Po对象中
		departmentsPo = departmentsMgr.getDepartment(departmentsPo);
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String[] str = {"2"};
		String companyID = "";
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			companyID = personInfoPo.getPersoncompanyid();
		}
		
		processDptList = departmentsMgr.getDepartments(str,"0",companyID);
		
		brankCardList = departmentsMgr.getBankCardList();
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		
		companyNamePos = companyNameMgr.getCompanyNameForSelect(null);

		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		return SUCCESS;
	}
	
	
	/**
	 * 部门更新
	 * @return
	 * @throws Exception
	 */
	public String updateDepartment() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("部门：" + Utility.getName(departmentsPo.getBdpdepartmentid())+"修改!");
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		//调用mgr更新部门方法
		
		//-----------------Hasp Check By mysflying 2015-3-12----------------------------------
		String url = "''initDepartmentsUpdate.action?hid={0}&moduleID={1}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));
		params.add(Utility.getName(moduleID));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		String haspResult=HaspApi.getHaspResult();	
		if(haspResult.length()!=17){
			this.clearMessages();
			this.addActionMessage(haspResult);
			return SUCCESS;
		}else{
			if(!haspResult.substring(7,17).trim().equals("") && DateTool.compare_date(haspResult.substring(7), systemParameterMgr.getDBSystemData())){
				this.clearMessages();
				this.addActionMessage("截至到"+haspResult.substring(7)+"为系统允许访问时间!");
				return SUCCESS;
			}
			
			DepartmentsPo dpo = new DepartmentsPo();
			dpo.setBdptype("1");
			dpo.setBdpisclosed("0");
			int countHasp = departmentsMgr.getDepartmentCount(dpo);
			BigDecimal bg = new BigDecimal(haspResult.substring(0,6));
			if (bg.intValue() < countHasp){
				this.clearMessages();
				this.addActionMessage(getText("启用的门店总数已超过系统限制,操作失败!"));
				return SUCCESS;
			}
		}
		//-----------------Hasp Check By mysflying 2015-3-12----------------------------------
		
		departmentsMgr.updateDepartment(systemParameterPo,departmentsPo,logPo);
		//打印更新成功信息
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		if(goodsTree.equals("1"))
		{
			if(parent.equals("1"))
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
			}
		}else
		{
			url = "''initDepartmentsUpdate.action?hid={0}&moduleID={1}''";
			params = new ArrayList<String>();
			params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));
			params.add(Utility.getName(moduleID));
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));
			request.setAttribute("flag", GlobalConstants.UPADTE);
		}


		

		return SUCCESS;
	}
	
	/**
	 * 初始化各部门打印单据为系统默认设置模版
	 * @return
	 * @throws Exception
	 */
	public String initConfigDepartmentDefaultBill() throws Exception {
		
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
	 * 初始化各部门打印单据为系统默认设置模版
	 * @return
	 * @throws Exception
	 */
	public String configDepartmentDefaultBill() throws Exception {
		
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
		logPo.setsLogContent("初始化各部门打印单据为系统默认设置模版!");

		departmentsMgr.updateDepartmentDefaultBill(logPo);
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
		return SUCCESS;
		
	}
	
	/**
	 * 初始化删除部门
	 * @return
	 * @throws Exception
	 */
	public String initDepartmentsDelete() throws Exception {
		
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
		//声明po对象
		departmentsPo = new DepartmentsPo();
		
		departmentsPo.setBdpdepartmentid(request.getParameter("hid"));
		//调用mgr得到部门方法并装入po
		departmentsPo = departmentsMgr.getDepartment(departmentsPo);
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));

		request.setAttribute("parent", parent);
		request.setAttribute("goodsTree", goodsTree);
		return SUCCESS;
	}
	
	
	/**
	 * 删除部门
	 * @return
	 * @throws Exception
	 */
	public String deleteDepartments() throws Exception {
		
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("部门：" + Utility.getName(request.getParameter("hid")) + "删除!");
		String parent = Utility.getName(request.getParameter("parent"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		//调用删除方法
		Boolean flag=departmentsMgr.deleteDepartment(systemParameterPo,Utility.getName(request.getParameter("hid")),logPo);
		if(flag){
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			if(goodsTree.equals("1"))
			{
				if(parent.equals("1"))
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
				}else
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
				}
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			}
			return SUCCESS;
		}else{
			this.clearMessages();
			this.addActionMessage(getText("department.delete.error"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			request.setAttribute("parent", parent);
			request.setAttribute("goodsTree", goodsTree);
			return ERROR;
		}

		
	}

	/**
	 * 初始化所属仓位维护
	 * @return
	 * @throws Exception
	 */
	public String initPuisneWarehouse() throws Exception {
		
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
				
		departmentsPo = departmentsMgr.getDepartment(departmentsPo);
		
		WarehousePo warehousePo = new WarehousePo();
		warehousePo.setBwhdeptid(Utility.getName(departmentsPo.getBdpdepartmentid()));

		warehouseList = warehouseMgr.getWarehouseList(warehousePo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化设置默认仓位
	 * @return
	 * @throws Exception
	 */
	public String initDefaultWarehouse() throws Exception {
		
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
				
		departmentsPo = departmentsMgr.getDepartment(departmentsPo);
		
		WarehousePo warehousePo = new WarehousePo();
		warehousePo.setBwhdeptid(Utility.getName(departmentsPo.getBdpdepartmentid()));

		warehouseList = warehouseMgr.getWarehouseList(warehousePo);
		
		warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(departmentsPo.getBdpdepartmentid());
		warehouseConfigurationPo = departmentsMgr.getDefaultWarehouseByDpt(warehouseConfigurationPo);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化出仓配置
	 * @return
	 * @throws Exception
	 */
	public String initGoodsOutWarehouse() throws Exception {
		
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
				
		departmentsPo = departmentsMgr.getDepartment(departmentsPo);
		
		DepartmentsPo deppo = new DepartmentsPo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			deppo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		warehouseList = warehouseConfigurationMgr.getWarehouseList(deppo);		

	    warehousePo = new WarehousePo();
		warehousePo.setBwhdeptid(Utility.getName(departmentsPo.getBdpdepartmentid()));		
		warehousePo = warehouseMgr.getWarehouse(warehousePo);
		
		WarehousePo warehousePo1 = warehouseMgr.getWarehousebwhid(deppo);
		request.setAttribute("warehousePo1", warehousePo1);
		
		WarehouseConfigurationPo wcPo = new WarehouseConfigurationPo();
		wcPo.setBwcdeptid(Utility.getName(departmentsPo.getBdpdepartmentid()));
		warehouseConfigurationPo = warehouseConfigurationMgr.getWarehouseConfiguration(wcPo);		
		inWarehouseConfigurationPo = warehouseConfigurationMgr.getInWarehouseConfiguration(wcPo);
		
		return SUCCESS;
	}
	
	/**
	 * 门店出仓配置
	 */
	public String updateGoodsOutWarehouse()throws Exception{
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
		int count=warehouseConfigurationMgr.getWarehouseConfigurationCount(warehouseConfigurationPo);
		
		this.clearMessages();
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		
		if(count>0){
			logPo.setsLogOpID("3");
			logPo.setsLogContent("门店仓位配置:" + warehouseConfigurationPo.getBwcdeptid() + "修改!");
			warehouseConfigurationMgr.updateWarehouseConfiguration(warehouseConfigurationPo,inWarehouseConfigurationPo,logPo);
			this.addActionMessage(getText("struts.messages.update.sucess"));
		}else{
			logPo.setsLogOpID("1");
			logPo.setsLogContent("门店仓位配置:" + warehouseConfigurationPo.getBwcdeptid() + "新增!");
			warehouseConfigurationMgr.insertWarehouseConfiguration(warehouseConfigurationPo,inWarehouseConfigurationPo,logPo);
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		}
		
		String url = "''initGoodsOutWarehouse.action?moduleID={0}&departmentsPo.bdpdepartmentid={1}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcdeptid()));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化入仓配置
	 * @return
	 * @throws Exception
	 */
	public String initGoodsInWarehouse() throws Exception {
		
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
				
		departmentsPo = departmentsMgr.getDepartment(departmentsPo);

		warehouseList = warehouseConfigurationMgr.getWarehouseList();
		
		 warehousePo = new WarehousePo();
		warehousePo.setBwhdeptid(Utility.getName(departmentsPo.getBdpdepartmentid()));
		
		warehousePo = warehouseMgr.getWarehouse(warehousePo);
		
		WarehousePo warehousePo1 = warehouseMgr.getWarehousebwhid();
		request.setAttribute("warehousePo1", warehousePo1);
		
		warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(Utility.getName(departmentsPo.getBdpdepartmentid()));
		warehouseConfigurationPo = warehouseConfigurationMgr.getInWarehouseConfiguration(warehouseConfigurationPo);
		
		return SUCCESS;
	}
	
	/**
	 * 配置入仓配置
	 * @return
	 * @throws Exception
	 */
	public String updateInWarehouseConfiguration() throws Exception {
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
		
		int count=warehouseConfigurationMgr.getInWarehouseConfigurationCount(warehouseConfigurationPo);
		
		this.clearMessages();
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 

		if(count>0){
			logPo.setsLogOpID("3");
			logPo.setsLogContent("门店退款仓位配置:" + warehouseConfigurationPo.getBwcdeptid() + "修改!");
			warehouseConfigurationMgr.updateInWarehouseConfiguration(warehouseConfigurationPo,logPo);
			this.addActionMessage(getText("struts.messages.update.sucess"));
		}else{
			logPo.setsLogOpID("1");
			logPo.setsLogContent("门店退款仓位配置:" + warehouseConfigurationPo.getBwcdeptid() + "修改!");
			warehouseConfigurationMgr.insertInWarehouseConfiguration(warehouseConfigurationPo,logPo);
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		}
		
		String url = "''initGoodsInWarehouse.action?moduleID={0}&departmentsPo.bdpdepartmentid={1}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		params.add(Utility.getName(warehouseConfigurationPo.getBwcdeptid()));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}

	/**
	 * 设置默认仓位
	 * @return
	 * @throws Exception
	 */
	public String defaultWarehouse() throws Exception {
		
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
		
		warehouseConfigurationPo.setBwcdeptid(Utility.getName(request.getParameter("hid")));
		int count=departmentsMgr.getDefaultWarehouseByDptCount(warehouseConfigurationPo);
		
		this.clearMessages();
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 

		if(count>0){
			logPo.setsLogOpID("3");
			logPo.setsLogContent("默认仓位配置:" + warehouseConfigurationPo.getBwcdeptid() + "修改!");
			departmentsMgr.updateDefaultWarehouse(warehouseConfigurationPo,logPo);
			this.addActionMessage(getText("struts.messages.update.sucess"));
		}else{
			logPo.setsLogOpID("1");
			logPo.setsLogContent("默认仓位配置:" + warehouseConfigurationPo.getBwcdeptid() + "新增!");
			departmentsMgr.insertDefaultWarehouse(warehouseConfigurationPo,logPo);
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		}
	
		String url = "''initDefaultWarehouse.action?moduleID={0}&departmentsPo.bdpdepartmentid={1}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(moduleID));
		params.add(Utility.getName(request.getParameter("hid")));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
				
		return SUCCESS;
	}
	
	/**
	 * 初始化单据模版配置
	 * @return
	 * @throws Exception
	 */
	public String initBillTemplate() throws Exception {
		
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
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,departmentsPo.getBdpdepartmentid());
		
		departmentsPo = departmentsMgr.getBillTemplate(departmentsPo.getBdpdepartmentid());		
		
		departmentsPo.setBdpkjid(systemParameterPo.getFspsalesbillstyle1());
		departmentsPo.setBdpkjurl(systemParameterPo.getFspsalesbillstyleurl1());

		departmentsPo.setBdpyxid(systemParameterPo.getFspsalesbillstyle3());
		departmentsPo.setBdpyxurl(systemParameterPo.getFspsalesbillstyleurl3());

		departmentsPo.setBdpflid(systemParameterPo.getFspsalesbillstyle5());
		departmentsPo.setBdpflurl(systemParameterPo.getFspsalesbillstyleurl5());

		departmentsPo.setBdpdjdid(systemParameterPo.getFspsubscriptionbillstyle());
		departmentsPo.setBdpdjdurl(systemParameterPo.getFspsubscriptionbillstyleurl());

		departmentsPo.setBdpghdid(systemParameterPo.getFspregisterbillstyle());
		departmentsPo.setBdpghdurl(systemParameterPo.getFspregisterbillstyleurl());

		departmentsPo.setBdptkjid(systemParameterPo.getFspsalesbillstyle1tui());
		departmentsPo.setBdptkjurl(systemParameterPo.getFspsalesbillstyleurl1tui());

		departmentsPo.setBdptyxid(systemParameterPo.getFspsalesbillstyle3tui());
		departmentsPo.setBdptyxurl(systemParameterPo.getFspsalesbillstyleurl3tui());

		departmentsPo.setBdptflid(systemParameterPo.getFspsalesbillstyle5tui());
		departmentsPo.setBdptflurl(systemParameterPo.getFspsalesbillstyleurl5tui());
		
		return SUCCESS;
	}

	/**
	 * 更新单据模版配置
	 * @return
	 * @throws Exception
	 */
	public String updateBillTemplate() throws Exception {
		
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
				
		departmentsMgr.updateBillTemplate(departmentsPo);
		departmentsPo = departmentsMgr.getBillTemplate(departmentsPo.getBdpdepartmentid());
		
		this.addActionMessage(getText("struts.messages.update.sucess"));
		return SUCCESS;
	}
	
	/**
	 * 部门详细信息
	 * @return
	 * @throws Exception
	 */
	public String initDepartmentDetail()throws Exception {
		
		departmentsPo = new DepartmentsPo();		
		departmentsPo.setBdpdepartmentid(Utility.getName(request.getParameter("hid")));
		departmentsPo = departmentsMgr.getDepartment(departmentsPo);
		
		StringBuffer buffer = new StringBuffer();
		List<WarehousePo> warehouseList = departmentsMgr.getWarehouseByDpt(departmentsPo);
		Iterator<WarehousePo> it = warehouseList.iterator();
		while (it.hasNext()){
			WarehousePo warehousePo = (WarehousePo)it.next();
			buffer.append(warehousePo.getBwhwarehouseName()+"、");
		}
		
		if (buffer.length() > 0){
			departmentsPo.setWarehouseName(buffer.substring(0,buffer.length()-1));
		}
		
		
		warehouseConfigurationPo = new WarehouseConfigurationPo();
		warehouseConfigurationPo.setBwcdeptid(departmentsPo.getBdpdepartmentid());
		
		warehouseConfigurationPo1 = departmentsMgr.getInWarehouseByDpt(warehouseConfigurationPo);
		warehouseConfigurationPo2 = departmentsMgr.getOutWarehouseByDpt(warehouseConfigurationPo);
		warehouseConfigurationPo3 = departmentsMgr.getDefaultWarehouse(warehouseConfigurationPo);
		
		DepartmentsPo departmentsPoBill = new DepartmentsPo();	
		
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = new SystemParameterPo();
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,request.getParameter("hid"));	
		departmentsPoBill = departmentsMgr.getBillTemplate(request.getParameter("hid"));		
		
		if(Utility.getName(departmentsPo.getBdpkjid()).equals("")){
			departmentsPoBill.setBdpkjid(systemParameterPo.getFspsalesbillstyle1());
			departmentsPoBill.setBdpkjurl(systemParameterPo.getFspsalesbillstyleurl1());
		}
		if(Utility.getName(departmentsPo.getBdpyxid()).equals("")){
			departmentsPoBill.setBdpyxid(systemParameterPo.getFspsalesbillstyle3());
			departmentsPoBill.setBdpyxurl(systemParameterPo.getFspsalesbillstyleurl3());
		}		
		if(Utility.getName(departmentsPo.getBdpflid()).equals("")){
			departmentsPoBill.setBdpflid(systemParameterPo.getFspsalesbillstyle5());
			departmentsPoBill.setBdpflurl(systemParameterPo.getFspsalesbillstyleurl5());
		}	
		if(Utility.getName(departmentsPo.getBdpdjdid()).equals("")){
			departmentsPoBill.setBdpdjdid(systemParameterPo.getFspsubscriptionbillstyle());
			departmentsPoBill.setBdpdjdurl(systemParameterPo.getFspsubscriptionbillstyleurl());
		}	
		if(Utility.getName(departmentsPo.getBdpghdid()).equals("")){
			departmentsPoBill.setBdpghdid(systemParameterPo.getFspregisterbillstyle());
			departmentsPoBill.setBdpghdurl(systemParameterPo.getFspregisterbillstyleurl());
		}
		
		if(Utility.getName(departmentsPo.getBdptkjid()).equals("")){
			departmentsPo.setBdptkjid(systemParameterPo.getFspsalesbillstyle1tui());
			departmentsPo.setBdptkjurl(systemParameterPo.getFspsalesbillstyleurl1tui());
		}
		if(Utility.getName(departmentsPo.getBdptyxid()).equals("")){
			departmentsPo.setBdptyxid(systemParameterPo.getFspsalesbillstyle3tui());
			departmentsPo.setBdptyxurl(systemParameterPo.getFspsalesbillstyleurl3tui());
		}		
		if(Utility.getName(departmentsPo.getBdptflid()).equals("")){
			departmentsPo.setBdptflid(systemParameterPo.getFspsalesbillstyle5tui());
			departmentsPo.setBdptflurl(systemParameterPo.getFspsalesbillstyleurl5tui());
		}	
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		request.setAttribute("departmentsPoBill", departmentsPoBill);
		return SUCCESS;
	}
	
	/**
	 * 初始化停用启用部门
	 * @return
	 * @throws Exception
	 */
	public String initUsingDepartment()throws Exception {
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

		departmentsPo = new DepartmentsPo();		
		departmentsPo.setBdpdepartmentid(Utility.getName(request.getParameter("hid")));
		departmentsPo = departmentsMgr.getDepartment(departmentsPo);
		departmentsPo.setBdpisclosed(Utility.getName(request.getParameter("flag")));
		
		return SUCCESS;
	}
	
	/**
	 * 停用启用部门
	 * @return
	 * @throws Exception
	 */
	public String usingDepartment()throws Exception {
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
		
		//-----------------Hasp Check By mysflying 2015-3-12----------------------------------
		String url = "''initUsingDepartment.action?hid={0}&moduleID={1}''";
		List<String> params = new ArrayList<String>();
		params.add(Utility.getName(departmentsPo.getBdpdepartmentid()));
		params.add(Utility.getName(moduleID));
		
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		String haspResult=HaspApi.getHaspResult();	
		if(haspResult.length()!=17){
			this.clearMessages();
			this.addActionMessage(haspResult);
			return SUCCESS;
		}else{
			if(!haspResult.substring(7,17).trim().equals("") && DateTool.compare_date(haspResult.substring(7), systemParameterMgr.getDBSystemData())){
				this.clearMessages();
				this.addActionMessage("截至到"+haspResult.substring(7)+"为系统允许访问时间!");
				return SUCCESS;
			}
			
			DepartmentsPo dpo = new DepartmentsPo();
			dpo.setBdptype("1");
			dpo.setBdpisclosed("0");
			int countHasp = departmentsMgr.getDepartmentCount(dpo);
			BigDecimal bg = new BigDecimal(haspResult.substring(0,6));
			if (bg.intValue() < countHasp){
				this.clearMessages();
				this.addActionMessage(getText("启用的门店总数已超过系统限制,操作失败!"));
				return SUCCESS;
			}
		}
		//-----------------Hasp Check By mysflying 2015-3-12----------------------------------
		
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
				
		// 38:启用       39:停用		
		if (departmentsPo.getBdpisclosed().equals("0")){ //正在使用
			logPo.setsLogOpID("39");    // 表示状态
			logPo.setsLogContent("部门:" + departmentsPo.getBdpdepartmentid() + "停用!");
			departmentsPo.setBdpisclosed("1");//停用
		}else{
			logPo.setsLogOpID("38");    // 表示状态
			logPo.setsLogContent("部门:" + departmentsPo.getBdpdepartmentid() + "启用!");
			departmentsPo.setBdpisclosed("0");//启用
		}
		departmentsMgr.usingDepartment(departmentsPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**** 客户维护 ********************************************************************************************************************/
	
	
	/**
	 * 初始化客户查询
	 * @return
	 * @throws Exception
	 */
	public String initFranchiseeSel() throws Exception {
		
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
			return "franchiseeSel";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 客户查询
	 * @return
	 * @throws Exception
	 */
	public String franchiseeSel() throws Exception {
		
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
		
		String departmentID = Utility.getName(request.getParameter("departmentID"));
		String departmentName = Utility.getName(request.getParameter("departmentName"));
		
		request.setAttribute("departmentName",departmentName);
		request.setAttribute("departmentID",departmentID);
		
		DepartmentsPo departmentsPo = new DepartmentsPo();
		departmentsPo.setBdpdepartmentid(departmentID);
		departmentsPo.setBdpdepartmentname(departmentName);
		
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
		
		int count = departmentsMgr.getFranchiseeCount(departmentsPo);
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
			departmentList = departmentsMgr.getFranchiseeList(departmentsPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			departmentList = null;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化客户添加
	 * @return
	 * @throws Exception
	 */
	public String initFranchiseeInsert() throws Exception {
		
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
	 * 插入客户信息
	 * @return
	 * @throws Exception
	 */
	public String insertFranchisee() throws Exception {
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

		if (!Utility.getName(departmentsPo.getBdpdepartmentid()).toUpperCase().startsWith("KH")){
			departmentsPo.setBdpdepartmentid("KH"+Utility.getName(departmentsPo.getBdpdepartmentid()));
		}		
		
		DepartmentsPo temp = new DepartmentsPo();
		temp.setBdpdepartmentid(departmentsPo.getBdpdepartmentid());
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("客户:" + departmentsPo.getBdpdepartmentid()+departmentsPo.getBdpdepartmentname() + "新增!");

		temp = departmentsMgr.getFranchisee(temp);
		
		if (!"".equals(Utility.getName(temp.getBdpdepartmentid()))) {
			this.clearMessages();
			this.addActionMessage(getText("客户编码重复,新增失败!"));
			
			String url = "''initFranchiseeInsert.action?moduleID={1}''";
			List<String> params = new ArrayList<String>();
			params.add(Utility.getName(moduleID));
			
			request.setAttribute("url", MessageFormat.format(url, params.toArray()));			
			request.setAttribute("flag", GlobalConstants.UPADTE);
			
			return SUCCESS;
		}

		departmentsMgr.insertFranchisee(departmentsPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));		
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 初始化客户更新
	 * @return
	 * @throws Exception
	 */
	public String initFranchiseeUpdate() throws Exception {
		
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

		if (departmentsPo == null){
			departmentsPo = new DepartmentsPo();		
			departmentsPo.setBdpdepartmentid(Utility.getName(request.getParameter("hid")));
		}

		departmentsPo = departmentsMgr.getFranchisee(departmentsPo);
		
		return SUCCESS;
	}
	
	
	/**
	 * 客户更新
	 * @return
	 * @throws Exception
	 */
	public String updateFranchisee() throws Exception {
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
		logPo.setsLogContent("客户：" + Utility.getName(departmentsPo.getBdpdepartmentid())+Utility.getName(departmentsPo.getBdpdepartmentname())+"修改!");

		departmentsMgr.updateFranchisee(departmentsPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	
	/**
	 * 初始化删除客户
	 * @return
	 * @throws Exception
	 */
	public String initFranchiseeDelete() throws Exception {
		
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

		departmentsPo = new DepartmentsPo();		
		departmentsPo.setBdpdepartmentid(request.getParameter("hid"));

		departmentsPo = departmentsMgr.getFranchisee(departmentsPo);

		return SUCCESS;
	}
	
	
	/**
	 * 删除客户
	 * @return
	 * @throws Exception
	 */
	public String deleteFranchisee() throws Exception {
		
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
		logPo.setsLogContent("客户：" + Utility.getName(request.getParameter("hid")) + "删除!");

        departmentsMgr.deleteFranchisee(Utility.getName(request.getParameter("hid")),logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化启用停用客户
	 * @return
	 * @throws Exception
	 */
	public String initFranchiseeEnable() throws Exception {
		
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

		departmentsPo = new DepartmentsPo();		
		departmentsPo.setBdpdepartmentid(Utility.getName(request.getParameter("hid")));
		departmentsPo.setBdpdepartmentname(Utility.getName(request.getParameter("hname")));
		departmentsPo.setBdpisclosed(Utility.getName(request.getParameter("flag")));

		return SUCCESS;
	}
	
	
	/**
	 * 启用停用客户
	 * @return
	 * @throws Exception
	 */
	public String updateFranchiseeEnable() throws Exception {
		
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
		logPo.setsLogContent("客户：" + Utility.getName(departmentsPo.getBdpdepartmentid()) + ":" + Utility.getName(departmentsPo.getBdpdepartmentname()) + (Utility.getName(departmentsPo.getBdpisclosed()).equals("0") ? "启用!" : "停用!"));

        departmentsMgr.updateFranchiseeEnable(departmentsPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public void getAjaxDepartmentForCompanyID() throws Exception {
		String companysid = Utility.getName(request.getParameter("companysid"));
		String type = Utility.getName(request.getParameter("type"));
		PrintWriter out;
		response.setContentType("text/plain; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		
		out = response.getWriter();
		String ids = "";
		String names = "";

		if (companysid.equals("")) {
			out.println("");
		} else {
			DepartmentsPo tpo = new DepartmentsPo();
			tpo.setBdpcompanysid(companysid);
			tpo.setBdptype(type);
			
			List<DepartmentsPo> pos = departmentsMgr.getDepartmentIDByCompanysID(tpo);
			Iterator it = pos.iterator();
			if (it.hasNext()) {
				while (it.hasNext()) {
					DepartmentsPo tmpPo = (DepartmentsPo) it.next();
					ids = ids + tmpPo.getBdpdepartmentid() + ",";
					names = names + tmpPo.getBdpdepartmentname() + ",";
				}
			}
			
		}
		
		if(ids.length() > 1){
			ids = ids.substring(0, ids.length()-1);
		}
		
		if(names.length() > 1){
			names = names.substring(0, names.length()-1);
		}
		String printstr = "";
		if(!"".equals(Utility.getName(ids))){
			printstr = ids + "/" + names;
		}
		out.println(printstr);
		out.close();
	}
	
	public void getAjaxWarehouseForCompanyID() throws Exception {
		String companysid = Utility.getName(request.getParameter("companysid"));
		String type = Utility.getName(request.getParameter("type"));
		PrintWriter out;
		response.setContentType("text/plain; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		
		out = response.getWriter();
		String ids = "";
		String names = "";

		if (companysid.equals("")) {
			out.println("");
		} else {
			DepartmentsPo tpo = new DepartmentsPo();
			tpo.setBdpcompanysid(companysid);
			tpo.setBdptype(type);
			
			List<WarehousePo> pos = departmentsMgr.getWarehouseByDptCompany(tpo);
			Iterator<WarehousePo> it = pos.iterator();
			if (it.hasNext()) {
				while (it.hasNext()) {
					WarehousePo tmpPo = (WarehousePo) it.next();
					ids = ids + tmpPo.getBwhid() + ",";
					names = names + tmpPo.getBwhwarehouseName() + ",";
				}
			}
			
		}
		
		if(ids.length() > 1){
			ids = ids.substring(0, ids.length()-1);
		}
		
		if(names.length() > 1){
			names = names.substring(0, names.length()-1);
		}
		String printstr = "";
		if(!"".equals(Utility.getName(ids))){
			printstr = ids + "/" + names;
		}
		out.println(printstr);
		out.close();
	}
	
	public void getAjaxDepartmentMenuForCompanyID() throws Exception {
		String id = Utility.getName(request.getParameter("id"));
		String dptid = Utility.getName(request.getParameter("did"));		
		
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(id.equals("")){
			out.println("<option value='' qcdate=''>----请选择----</option>");
		}else{

			DepartmentsPo departmentsPo=new DepartmentsPo();
			departmentsPo.setBdpcompanysid(id);
			
			List<DepartmentsPo> dList = departmentsMgr.getDepartmentIDByCompanysID(departmentsPo);
			
			Iterator<DepartmentsPo> it = dList.iterator();		
			if (it.hasNext()) {
				out.println("<option value='' qcdate=''>----请选择----</option>");
				while (it.hasNext()) {
					DepartmentsPo dpo = it.next();

					if (dptid.equals("")){
						out.println("<option value='" + dpo.getBdpdepartmentid()+ "' qcdate='" + dpo.getBdpqcdate()+ "'>"+dpo.getBdpdepartmentname()+"</option>");
					}else{
						out.println("<option value='" + dpo.getBdpdepartmentid()+ "'" + (dpo.getBdpdepartmentid().equals(dptid) ? "selected='selected'" : "") + "' qcdate='" + dpo.getBdpqcdate()+ "'>"+dpo.getBdpdepartmentname()+"</option>");
					}
					
				}
			}
		}
		out.close();
	}
	
	/**
	 * 初始化部门期初日期和上线日期
	 */
	public String initDepartmentDateUpdate() throws Exception {
		
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
		
		departmentsPo = new DepartmentsPo();		
		departmentsPo.setBdpdepartmentid(hid);

		departmentsPo = departmentsMgr.getDepartment(departmentsPo);
		
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}
	
	/**
	 * 设置部门期初日期和上线日期
	 * @return
	 * @throws Exception
	 */
	public String updateDepartmentDate() throws Exception {
		
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
		logPo.setsLogContent("部门：" + Utility.getName(departmentsPo.getBdpdepartmentid()) + "修改期初日期和上线日期!");

        departmentsMgr.updateDepartmentDate(departmentsPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化设置部门连接HIS的配置项
	 * @return
	 * @throws Exception
	 */
	public String initHisSet() throws Exception {
		
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
		
		hisInfoPo = new HisInfoPo();
		hisInfoList = hisInfoMgr.getHisInfoList(hisInfoPo);
		
		departmentsPo = departmentsMgr.getDepartmentSetHisInfo(Utility.getName(departmentsPo.getBdpdepartmentid()));
		 
		return SUCCESS;
	}
	
	/**
	 * 设置部门连接HIS的配置项
	 * @return
	 * @throws Exception
	 */
	public String updateHisSet() throws Exception {
		
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
		logPo.setsLogContent("部门：" + Utility.getName(departmentsPo.getBdpdepartmentid()) + "修改HIS配置信息!");

		if (departmentsPo.getBdplinkhisflag().equals("0")){
			departmentsPo.setBdpnotpayfeeform("");
		}		
		
        departmentsMgr.updateDepartmentSetHisInfo(departmentsPo,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public WarehouseConfigurationPo getInWarehouseConfigurationPo() {
		return inWarehouseConfigurationPo;
	}
	public void setInWarehouseConfigurationPo(
			WarehouseConfigurationPo inWarehouseConfigurationPo) {
		this.inWarehouseConfigurationPo = inWarehouseConfigurationPo;
	}
	public WarehousePo getWarehousePo() {
		return warehousePo;
	}
	public void setWarehousePo(WarehousePo warehousePo) {
		this.warehousePo = warehousePo;
	}
	public List<WarehousePo> getOutwarehouselist() {
		return outwarehouselist;
	}
	public void setOutwarehouselist(List<WarehousePo> outwarehouselist) {
		this.outwarehouselist = outwarehouselist;
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
	public String getIsFirstExec() {
		return isFirstExec;
	}
	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}
	public List<BrankCardPo> getBrankCardList() {
		return brankCardList;
	}
	public void setBrankCardList(List<BrankCardPo> brankCardList) {
		this.brankCardList = brankCardList;
	}
	public List<FuctionTreeNode> getMenusList() {
		return menusList;
	}
	public void setMenusList(List<FuctionTreeNode> menusList) {
		this.menusList = menusList;
	}
	public String getMenuString() {
		return menuString;
	}
	public void setMenuString(String menuString) {
		this.menuString = menuString;
	}
	public WarehouseConfigurationPo getWarehouseConfigurationPo1() {
		return warehouseConfigurationPo1;
	}
	public void setWarehouseConfigurationPo1(
			WarehouseConfigurationPo warehouseConfigurationPo1) {
		this.warehouseConfigurationPo1 = warehouseConfigurationPo1;
	}
	public WarehouseConfigurationPo getWarehouseConfigurationPo2() {
		return warehouseConfigurationPo2;
	}
	public void setWarehouseConfigurationPo2(
			WarehouseConfigurationPo warehouseConfigurationPo2) {
		this.warehouseConfigurationPo2 = warehouseConfigurationPo2;
	}
	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}
	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
	}
	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}
	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
	}
	public List<DepartmentsPo> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<DepartmentsPo> departmentList) {
		this.departmentList = departmentList;
	}
	public List<DepartmentsPo> getProcessDptList() {
		return processDptList;
	}
	public void setProcessDptList(List<DepartmentsPo> processDptList) {
		this.processDptList = processDptList;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
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
	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}
	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}	
	public WarehouseConfigurationPo getWarehouseConfigurationPo3() {
		return warehouseConfigurationPo3;
	}
	public void setWarehouseConfigurationPo3(
			WarehouseConfigurationPo warehouseConfigurationPo3) {
		this.warehouseConfigurationPo3 = warehouseConfigurationPo3;
	}
	
	public CompanyNameMgr getCompanyNameMgr() {
		return companyNameMgr;
	}
	public void setCompanyNameMgr(CompanyNameMgr companyNameMgr) {
		this.companyNameMgr = companyNameMgr;
	}

	public List<CompanyNamePo> getCompanyNamePos() {
		return companyNamePos;
	}

	public void setCompanyNamePos(List<CompanyNamePo> companyNamePos) {
		this.companyNamePos = companyNamePos;
	}

	public List<DepartmentTypePo> getDepartmentTypeList() {
		return departmentTypeList;
	}

	public void setDepartmentTypeList(List<DepartmentTypePo> departmentTypeList) {
		this.departmentTypeList = departmentTypeList;
	}

	public List<HisInfoPo> getHisInfoList() {
		return hisInfoList;
	}

	public void setHisInfoList(List<HisInfoPo> hisInfoList) {
		this.hisInfoList = hisInfoList;
	}

	public HisInfoPo getHisInfoPo() {
		return hisInfoPo;
	}

	public void setHisInfoPo(HisInfoPo hisInfoPo) {
		this.hisInfoPo = hisInfoPo;
	}

	public HisInfoMgr getHisInfoMgr() {
		return hisInfoMgr;
	}

	public void setHisInfoMgr(HisInfoMgr hisInfoMgr) {
		this.hisInfoMgr = hisInfoMgr;
	}
	
}
