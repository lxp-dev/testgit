package com.pengsheng.eims.basic.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.SalesAreaMgr;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.SalesAreaPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class SalesAreaAction extends BaseAction{
	
	private PersonPermissionMgr personPermissionMgr;
	private SalesAreaMgr salesAreaMgr;
	private SalesAreaPo salesAreaPo;
	private List<SalesAreaPo> salesAreaPos;
	private SupplierMgr supplierMgr;	
	private List<GoodsCategoryPo> goodsCategoryList;
	private SystemParameterPo systemParameterPo;
	private SystemParameterMgr systemParameterMgr;
	private String isFirstExec;
	
	public List<SalesAreaPo> getSalesAreaPos() {
		return salesAreaPos;
	}

	public void setSalesAreaPos(List<SalesAreaPo> salesAreaPos) {
		this.salesAreaPos = salesAreaPos;
	}

	public SalesAreaMgr getSalesAreaMgr() {
		return salesAreaMgr;
	}

	public void setSalesAreaMgr(SalesAreaMgr salesAreaMgr) {
		this.salesAreaMgr = salesAreaMgr;
	}

	public SalesAreaPo getSalesAreaPo() {
		return salesAreaPo;
	}

	public void setSalesAreaPo(SalesAreaPo salesAreaPo) {
		this.salesAreaPo = salesAreaPo;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	/**
	 * 查询某module下所有价格区间
	 */
	public String selectSalesArea() throws Exception {
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
		
		goodsCategoryList = supplierMgr.getGoodsCategoryList();
		String[] goodsCategoryID = request.getParameterValues("goodsCategoryID");
		String typeID = Utility.getName(request.getParameter("typeID"));
		String[] salesTypeID = request.getParameterValues("salesTypeID");
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
		
		//获取品种总数
		int count = salesAreaMgr.selectSalesAreaListAllByCategoryIDOrSalesTypeCount(goodsCategoryID, salesTypeID);
		//分页
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
			//获取品种信息并分页
			salesAreaPos = salesAreaMgr.selectSalesAreaListAllByCategoryIDOrSalesType(goodsCategoryID, salesTypeID, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			salesAreaPos = null;
		}
		
//		salesAreaPos = salesAreaMgr.selectSalesAreaListAllByCategoryIDOrSalesType(goodsCategoryID, salesTypeID);
		
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("typeID", typeID);
		request.setAttribute("salesTypeID", salesTypeID);

		return SUCCESS;
	}
	
	/**
	 * 初始化删除价格区间
	 */
	public String initDeleteSalesArea() throws Exception {
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
		
		String uuid = Utility.getName(request.getParameter("uuid"));		
		salesAreaPo = salesAreaMgr.selectSalesAreaPo(uuid);
		
		return SUCCESS;
	}
	
	/**
	 * 删除价格区间
	 */
	public String deleteSalesArea() throws Exception {
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
		
		String uuid = Utility.getName(request.getParameter("uuid"));		
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("价格区间："+ Utility.getName(request.getParameter("delcontent")) +"删除!");		
		
		salesAreaMgr.deleteSalesAreaPo(uuid,logPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化新增价格区间
	 */
	public String initInsertSalesArea() throws Exception {
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

		goodsCategoryList = supplierMgr.getGoodsCategoryList();
		
		return SUCCESS;
	}
	
	/**
	 * 新增价格区间
	 */
	public String insertSalesArea() throws Exception {
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
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("价格区间：" + Utility.getName(salesAreaPo.getRrcsapricemin()) + "至" + Utility.getName(salesAreaPo.getRrcsapricemax()) + ",级差：" + Utility.getName(salesAreaPo.getRrcsarange()) + " 新增!");
		
		String[] goodsCategoryID = request.getParameterValues("goodsCategoryID");
		String[] salesTypeID = request.getParameterValues("salesTypeID");
		String typeID = Utility.getName(request.getParameter("typeID"));
		
		List<SalesAreaPo> salesAreaList = new ArrayList<SalesAreaPo>();
		BigDecimal bg1 = new BigDecimal(Utility.getName(salesAreaPo.getRrcsapricemin()));
		BigDecimal bg2 = new BigDecimal(Utility.getName(salesAreaPo.getRrcsapricemax()).equals("") ? "0.00" : Utility.getName(salesAreaPo.getRrcsapricemax()));
		BigDecimal bg = new BigDecimal(Utility.getName(salesAreaPo.getRrcsarange()).equals("") ? "0.00" : Utility.getName(salesAreaPo.getRrcsarange()));

		if (!Utility.getName(salesAreaPo.getRrcsapricemax()).equals("")){
			do{
				SalesAreaPo po = new SalesAreaPo();
				po.setRrcsapricemin(bg1.toString());
				bg1 = bg1.add(bg);
				po.setRrcsapricemax(bg1.toString());
			
				salesAreaList.add(po);
				
			} while(bg1.add(bg).floatValue() < bg2.floatValue());
			
			if (bg1.add(new BigDecimal(1)).floatValue() == bg2.floatValue()){
				bg1 = bg1.add(new BigDecimal(1));
			}
			if (bg1.floatValue() < bg2.floatValue()){
				SalesAreaPo spo = new SalesAreaPo();
				spo.setRrcsapricemin(bg1.toString());
				spo.setRrcsapricemax(bg2.toString());		
				salesAreaList.add(spo);
			}
		}else{
			SalesAreaPo spo = new SalesAreaPo();
			spo.setRrcsapricemin(bg1.toString());
			spo.setRrcsapricemax("");		
			salesAreaList.add(spo);
		}
		
		List<SalesAreaPo> poList = new ArrayList<SalesAreaPo>();		
		if(typeID.equals("1")) {
			for (int i = 0; i < goodsCategoryID.length; i++) {
				for (int j = 0; j < salesAreaList.size(); j++) {					
					SalesAreaPo tpo = new SalesAreaPo();
					tpo.setRrcsapricemin(salesAreaList.get(j).getRrcsapricemin());
					tpo.setRrcsapricemax(salesAreaList.get(j).getRrcsapricemax());
					tpo.setRrcsagoodscategoryid(goodsCategoryID[i]);
					
					poList.add(tpo);
				}
			}
		} else if(typeID.equals("2")) {
			for (int i = 0; i < salesTypeID.length; i++) {
				for (int j = 0; j < salesAreaList.size(); j++) {
					SalesAreaPo tpo = new SalesAreaPo();
					tpo.setRrcsapricemin(salesAreaList.get(j).getRrcsapricemin());
					tpo.setRrcsapricemax(salesAreaList.get(j).getRrcsapricemax());
					tpo.setRrcsasalestype(salesTypeID[i]);
					
					poList.add(tpo);
				}
			}
		}
		
		for (SalesAreaPo po : poList){
			int count = salesAreaMgr.getSalesAreaBeforeCount(po);
			if (count > 0){
				String url = "'initInsertSalesArea.action?moduleID="+moduleID+"'";
				
				this.clearMessages();
				this.addActionMessage(getText("价格区间重复设置,请重新设置!"));
				request.setAttribute("url", url);
				request.setAttribute("flag", GlobalConstants.MOVE);
				
				return SUCCESS;
			}			
		}	
		
		salesAreaMgr.insertSalesAreaPo(poList,logPo);
	
		request.setAttribute("typeID", typeID);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	/**
	 * 初始化批量删除价格区间
	 */
	public String initBatchDeleteSalesArea() throws Exception {
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

		String hid = Utility.getName(request.getParameter("hid"));
		request.setAttribute("hid",hid);
		
		return SUCCESS;
	}

	/**
	 * 批量删除价格区间
	 */
	public String bathDeleteSalesArea() throws Exception {
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

		String ids = Utility.getName(request.getParameter("delID"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("价格区间："+ ids +"删除!");		
		
		salesAreaMgr.deleteSalesAreaPo(ids,logPo);

		this.clearMessages(); 
		this.addActionMessage(getText("struts.messages.delete.sucess")); 
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
	}

	public List<GoodsCategoryPo> getGoodsCategoryList() {
		return goodsCategoryList;
	}

	public void setGoodsCategoryList(List<GoodsCategoryPo> goodsCategoryList) {
		this.goodsCategoryList = goodsCategoryList;
	}

	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public SystemParameterMgr getSystemParameterMgr() {
		return systemParameterMgr;
	}

	public void setSystemParameterMgr(SystemParameterMgr systemParameterMgr) {
		this.systemParameterMgr = systemParameterMgr;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}
	
}
