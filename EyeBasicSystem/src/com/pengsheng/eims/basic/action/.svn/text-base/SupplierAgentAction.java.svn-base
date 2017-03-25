package com.pengsheng.eims.basic.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.SupplierAgentMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.OptionParamPo;
import com.pengsheng.eims.basic.persistence.SupplierPo;
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

public class SupplierAgentAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	private SupplierAgentMgr supplierAgentMgr;
	private List<SupplierPo> supplierList;
	private List<GoodsCategoryPo> goodsCategoryList;	
	private SupplierPo supplierPo;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private BrandMgr brandMgr;
	private List<BrandPo> brands;
	
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	/**
	 * 初始化供应商查询
	 */
	public String initSupplierAgentSel() throws Exception {
		
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

		goodsCategoryList = supplierAgentMgr.getGoodsCategoryList();
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selSupplierAgent";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询供应商
	 */
	public String selSupplierAgent() throws Exception {
		
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
		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String bspsuppliermnemonic = Utility.getName(request.getParameter("bspsuppliermnemonic"));
		String bsporderby = Utility.getName(request.getParameter("bsporderby"));
		String isClosed = Utility.getName(request.getParameter("isClosed"));
		String cateid= Utility.getName(request.getParameter("cateid"));
		String makeinvoiceflag = Utility.getName(request.getParameter("makeinvoiceflag"));
		String linksupplierid = Utility.getName(request.getParameter("linksupplierid"));
		String linksuppliername = Utility.getName(request.getParameter("linksuppliername"));
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		supplierPo = new SupplierPo();
		supplierPo.setBspid(supplierID);
		supplierPo.setBspsuppliername(supplierName);
		supplierPo.setBspcategoryid(goodsCategoryID);
		supplierPo.setBspsuppliermnemonic(bspsuppliermnemonic);
		supplierPo.setBspflag(isClosed);
		supplierPo.setBspordersupplierid(bsporderby);
		supplierPo.setBspmakeinvoiceflag(makeinvoiceflag);
		supplierPo.setBsplinksupplierid(linksupplierid);
		
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
		
		int count = supplierAgentMgr.getSupplierCount(supplierPo);
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
			supplierList = supplierAgentMgr.getSupplierList(supplierPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			supplierList = null;
		}

		goodsCategoryList = supplierAgentMgr.getGoodsCategoryList();

		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("bspsuppliermnemonic", bspsuppliermnemonic);
		request.setAttribute("bsporderby", bsporderby);
		request.setAttribute("isClosed", isClosed);
		request.setAttribute("makeinvoiceflag", makeinvoiceflag);
		request.setAttribute("linksupplierid", linksupplierid);
		request.setAttribute("linksuppliername", linksuppliername);
		
		if("".equals(cateid))
		{
			cateid=goodsCategoryID;
		}
		request.setAttribute("cateid", cateid);
		//加载树中供应商
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		request.setAttribute("goodsTree", goodsTree);
		
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("parent", parent);
		if (goodsTree.equals("1")){
			SupplierPo po = new SupplierPo();
			po.setBspid(supplierID);
			po = supplierAgentMgr.getSupplier(po);
			request.setAttribute("supplierName",Utility.getName(po.getBspsuppliername()));
		}
		
		return SUCCESS;
	}

	/**
	 * 初始化供应商新增
	 */
	public String initSupplierAgentInsert() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String selbspcategoryid = Utility.getName(request.getParameter("selbspcategoryid"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
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
		if(goodsTree.equals("1")){
			hid=selbspcategoryid;
			request.setAttribute("cateid", hid);
			request.setAttribute("goodsTree", "1");
		}
		goodsCategoryList = supplierAgentMgr.getGoodsCategoryList();		
		if (!hid.equals("")){
			goodsCategoryList = getGoodsCategoryList(goodsCategoryList,hid);
		}
				
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 新增供应商
	 */
	public String insertSupplierAgent() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String cateid = Utility.getName(request.getParameter("cateid"));
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
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("1");    		// 表示状态
		logPo.setsLogContent("供应商:" + supplierPo.getBspid()+supplierPo.getBspsuppliername() + "新增!");
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		supplierPo.setBspcategoryid("");
		this.clearMessages();
		SupplierPo po = supplierAgentMgr.getSupplier(supplierPo);
		if (po.getBspid() == null) {
			supplierPo.setBspinsertxzdflag(Utility.getName(systemParameterPo.getFspsupplierinsertxzd()));
			supplierAgentMgr.insertSupplier(supplierPo,logPo);
			
			if(goodsTree.equals("1")){

				this.clearMessages();
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
			}else{
				this.clearMessages();
				this.addActionMessage(getText("struts.messages.insert.sucess"));
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);		
			}
			
		} else {			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.repeat"));
			request.setAttribute("goodsTree",goodsTree);
			request.setAttribute("flag", GlobalConstants.INSERT);
			
			return ERROR;
		}

		return SUCCESS;
	}

	/**
	* Description :查询某一供应商的详细信息
	* @return :供应商详情页面
	*/
	public String supplierAgentDetail() throws Exception {
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
		
		String id = Utility.getName(request.getParameter("hid"));

		supplierPo = new SupplierPo();

		supplierPo.setBspid(id);
		supplierPo = supplierAgentMgr.getSupplier(supplierPo);
		
		goodsCategoryList = supplierAgentMgr.getGoodsCategoryList();
		goodsCategoryList = getGoodsCategoryList(goodsCategoryList, supplierPo.getBspcategoryid());
	
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 初始化供应商修改
	 */
	public String initSupplierAgentUpdate() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));

		supplierPo = new SupplierPo();

		supplierPo.setBspid(id);
		supplierPo = supplierAgentMgr.getSupplier(supplierPo);

		goodsCategoryList = supplierAgentMgr.getGoodsCategoryList();
		goodsCategoryList = getGoodsCategoryList(goodsCategoryList, supplierPo.getBspcategoryid());
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("goodsTree", goodsTree);
		request.setAttribute("parent", parent);
		
		return SUCCESS;
	}

	/**
	 * 修改供应商
	 * 
	 */
	public String updateSupplierAgent() throws Exception {
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
		String updateBrand = Utility.getName(request.getParameter("updateBrand"));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("供应商:" + supplierPo.getBspid()+supplierPo.getBspsuppliername()+"修改!");
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent = Utility.getName(request.getParameter("parent"));
		supplierPo.setBspcategoryid("");

		supplierAgentMgr.updateSupplier(supplierPo, updateBrand, logPo);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		
		if(goodsTree.equals("1"))
		{

			if(parent.equals("1"))
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
			}
		}else
		{
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}


		return SUCCESS;
	}

	/**
	 * 初始化批量导入Excel
	 */
	public String initSupplierAgentExcel() throws Exception {

		return SUCCESS;
	}

	/**
	 * 批量导入Excel
	 * 
	 */
	public String insertSupplierAgentExcel() throws Exception {

		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(this
				.getFile()));
		HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFRow row = null;// 对应excel的行
		HSSFCell cell = null;// 对应excel的列
		int i = 0;
		// 遍历SupplierPo
		List<SupplierPo> supplierList = new ArrayList<SupplierPo>();
		while (true) {
			SupplierPo supplierPo = new SupplierPo();

			i++;
			// 第一行
			row = sheet.getRow(i);

			// 供应商代码字段是否
			String B_SP_ID = row.getCell(0).getRichStringCellValue().toString();
			if (B_SP_ID.equals("")) {
				break;
			}
			
			// 添加供应商名称字段
			String B_SP_SupplierName = row.getCell(1).getRichStringCellValue()
					.toString();

			// 添加供应商联系人字段
			String B_SP_ContactPerson = row.getCell(2).getRichStringCellValue()
					.toString();

			// 添加供应商电话字段
			String B_SP_ContactPhone = row.getCell(3).getRichStringCellValue()
					.toString();

			// 添加供应商传真字段
			String B_SP_Fax = row.getCell(4).getRichStringCellValue()
					.toString();

			// 添加供应商地址字段
			String B_SP_Address = row.getCell(5).getRichStringCellValue()
					.toString();

			// 供应商备注字段
			String B_SP_Remark = row.getCell(6).getRichStringCellValue()
					.toString();

			// 添加供应商类别字段
			String B_SP_CategoryID = row.getCell(7).getRichStringCellValue()
					.toString();

			// 供应商启用/停用字段
			String B_SP_Flag = "1";

			supplierPo.setBspid(B_SP_ID);
			supplierPo.setBspsuppliername(B_SP_SupplierName);
			supplierPo.setBspcontactperson(B_SP_ContactPerson);
			supplierPo.setBspcontactphone(B_SP_ContactPhone);
			supplierPo.setBspflag(B_SP_Flag);
			supplierPo.setBspremark(B_SP_Remark);
			supplierPo.setBspaddress(B_SP_Address);
			supplierPo.setBspcategoryid(B_SP_CategoryID);
			supplierPo.setBspfax(B_SP_Fax);

			supplierList.add(supplierPo);

		}
		// 把遍历信息添加到数据库中
		supplierAgentMgr.insertSupplier(supplierList);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.import.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;

	}

	/**
	 * 初始化供应商删除
	 */
	public String initSupplierAgentDelete() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));

		supplierPo = new SupplierPo();

		supplierPo.setBspid(id);
		supplierPo = supplierAgentMgr.getSupplier(supplierPo);
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("goodsTree", goodsTree);
		request.setAttribute("parent", parent);
		return SUCCESS;
	}

	/**
	 * 删除供应商
	 */
	public String deleteSupplierAgent() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent = Utility.getName(request.getParameter("parent"));
		
		supplierPo = new SupplierPo();
		supplierPo.setBspid(id);
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("2");    // 表示状态
		logPo.setsLogContent("供应商:" + supplierPo.getBspid()+"删除!");
		
		int flag = supplierAgentMgr.getBrandCount(id);
		//flag=supplierAgentMgr.getGoodsCount(supplierPo);
		this.clearMessages();
		if (flag == 0) {
			supplierAgentMgr.deleteSupplier(supplierPo,logPo);
			this.addActionMessage(getText("struts.messages.delete.sucess"));
			
			if(goodsTree.equals("1"))
			{
				if(parent.equals("1"))
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE9);
				}else
				{
					request.setAttribute("flag", GlobalConstants.OPENUPDATE7);
				}
			}else
			{
				request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			}
		} else {
			this.addActionMessage(getText("supplier.delete.err"));
			request.setAttribute("goodsTree", goodsTree);
			request.setAttribute("parent",parent );
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}
		
		
		return SUCCESS;
	}

	/**
	 * 初始化供应商停用
	 */
	public String initSupplierAgentDisable() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));

		supplierPo = new SupplierPo();

		supplierPo.setBspid(id);
		supplierPo = supplierAgentMgr.getSupplier(supplierPo);

		return SUCCESS;
	}

	/**
	 * 停用供应商
	 */
	public String disableSupplierAgent() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		supplierPo = new SupplierPo();

		supplierPo.setBspid(id);
		supplierPo.setBspflag("0");
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("39");    // 表示状态
		logPo.setsLogContent("供应商:" + supplierPo.getBspid()+"停用!");
		
		supplierAgentMgr.updateSupplierDisable(supplierPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化供应商启用
	 */
	public String initSupplierAgentAble() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		supplierPo = new SupplierPo();

		supplierPo.setBspid(id);
		supplierPo = supplierAgentMgr.getSupplier(supplierPo);

		return SUCCESS;
	}

	/**
	 * 启用供应商
	 */
	public String ableSupplierAgent() throws Exception {
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
		String id = Utility.getName(request.getParameter("hid"));
		supplierPo = new SupplierPo();

		supplierPo.setBspid(id);
		supplierPo.setBspflag("1");
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("38");    // 表示状态
		logPo.setsLogContent("供应商:" + supplierPo.getBspid()+"启用!");
		
		supplierAgentMgr.updateSupplierDisable(supplierPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public SupplierAgentMgr getSupplierAgentMgr() {
		return supplierAgentMgr;
	}

	public void setSupplierAgentMgr(SupplierAgentMgr supplierAgentMgr) {
		this.supplierAgentMgr = supplierAgentMgr;
	}

	public List<SupplierPo> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<SupplierPo> supplierList) {
		this.supplierList = supplierList;
	}

	public List<GoodsCategoryPo> getGoodsCategoryList() {
		return goodsCategoryList;
	}

	public void setGoodsCategoryList(List<GoodsCategoryPo> goodsCategoryList) {
		this.goodsCategoryList = goodsCategoryList;
	}

	private String getGoodsCategory(String[] goodsCategoryID) {

		String goodsCategory = "";
		for (int i = 0; i < goodsCategoryID.length; i++) {

			if ("".equals(goodsCategory)) {
				goodsCategory = goodsCategoryID[i];
			} else {
				goodsCategory = goodsCategory + "," + goodsCategoryID[i];
			}
		}

		return goodsCategory;
	}

	private List<GoodsCategoryPo> getGoodsCategoryList(
			List<GoodsCategoryPo> list, String goodsCategoryID) {

		List<GoodsCategoryPo> glist = new ArrayList();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			GoodsCategoryPo po = (GoodsCategoryPo) it.next();
			String[] goodsCategory = goodsCategoryID.split(",");
			for (int i = 0; i < goodsCategory.length; i++) {
				if (po.getBgcid().equals(goodsCategory[i])) {
					po.setFlag("1");
					break;
				} else {
					po.setFlag("0");
				}
			}
			glist.add(po);
		}
		return glist;
	}
	/**
	 * 查询供应商
	 */
	public String selSupplierAgentTree() throws Exception {
		
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
		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String bspsuppliermnemonic = Utility.getName(request.getParameter("bspsuppliermnemonic"));
		String bsporderby = Utility.getName(request.getParameter("bsporderby"));
		String isClosed = Utility.getName(request.getParameter("isClosed"));
		String cateid= Utility.getName(request.getParameter("cateid"));

		supplierPo = new SupplierPo();
		supplierPo.setBspid(supplierID);
		supplierPo.setBspsuppliername(supplierName);
		supplierPo.setBspcategoryid(goodsCategoryID);
		supplierPo.setBspsuppliermnemonic(bspsuppliermnemonic);
		supplierPo.setBspflag(isClosed);
		supplierPo.setBspordersupplierid(bsporderby);
		
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
		BrandPo brandPo=new BrandPo();
		brandPo.setBbdsupplierid(supplierID);
		int count = brandMgr.getBrandsCount(brandPo);
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
			supplierList = supplierAgentMgr.getSupplierList(supplierPo, 0,300);
			brands =  brandMgr.getBrands(brandPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			supplierList = null;
		}

		goodsCategoryList = supplierAgentMgr.getGoodsCategoryList();

		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("bspsuppliermnemonic", bspsuppliermnemonic);
		request.setAttribute("bsporderby", bsporderby);
		request.setAttribute("isClosed", isClosed);
		if("".equals(cateid))
		{
			cateid=goodsCategoryID;
		}
		request.setAttribute("cateid", cateid);
		//加载树中供应商
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		request.setAttribute("goodsTree", goodsTree);
		
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("parent", parent);
		//System.out.println(goodsTree+"#####"+goodsCategoryID);
		if (goodsTree.equals("1")){
			
			
			SupplierPo po = new SupplierPo();
			po.setBspid(supplierID);
			po = supplierAgentMgr.getSupplier(po);
			request.setAttribute("supplierName",Utility.getName(po.getBspsuppliername()));
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化供应商查询
	 */
	public String initSupplierAgentDateSel() throws Exception {
		
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

		goodsCategoryList = supplierAgentMgr.getGoodsCategoryList();
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selSupplierAgentDate";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询供应商
	 */
	public String selSupplierAgentDate() throws Exception {
		
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
		
		supplierList = new ArrayList<SupplierPo>();
		
		String bbdsupplierid = Utility.getName(request.getParameter("bbdsupplierid"));
		String selbspsuppliername = Utility.getName(request.getParameter("selbspsuppliername"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String bspsuppliermnemonic = Utility.getName(request.getParameter("bspsuppliermnemonic"));
		String bsporderby = Utility.getName(request.getParameter("bsporderby"));
		String isClosed = Utility.getName(request.getParameter("isClosed"));
		String cateid= Utility.getName(request.getParameter("cateid"));
		String makeinvoiceflag = Utility.getName(request.getParameter("makeinvoiceflag"));
		String linksupplierid = Utility.getName(request.getParameter("linksupplierid"));
		String linksuppliername = Utility.getName(request.getParameter("linksuppliername"));
		String bsplicencetype = Utility.getName(request.getParameter("bsplicencetype"));
		String bsplicencestate = Utility.getName(request.getParameter("bsplicencestate"));
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		supplierPo = new SupplierPo();
		supplierPo.setBspid(supplierID);
		supplierPo.setBspsuppliername(supplierName);
		supplierPo.setBspcategoryid(goodsCategoryID);
		supplierPo.setBspsuppliermnemonic(bspsuppliermnemonic);
		supplierPo.setBspflag(isClosed);
		supplierPo.setBspordersupplierid(bsporderby);
		supplierPo.setBspmakeinvoiceflag(makeinvoiceflag);
		supplierPo.setBsplinksupplierid(linksupplierid);
		supplierPo.setBsplicencetype(bsplicencetype);
		supplierPo.setBsplicencestate(bsplicencestate);
		supplierPo.setBsplinksupplierid(bbdsupplierid);
		
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
		
		int count = supplierAgentMgr.getSupplierCount(supplierPo);
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
			supplierList = supplierAgentMgr.getSupplierList(supplierPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			supplierList = null;
		}

		goodsCategoryList = supplierAgentMgr.getGoodsCategoryList();

		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("bspsuppliermnemonic", bspsuppliermnemonic);
		request.setAttribute("bsporderby", bsporderby);
		request.setAttribute("isClosed", isClosed);
		request.setAttribute("makeinvoiceflag", makeinvoiceflag);
		request.setAttribute("linksupplierid", linksupplierid);
		request.setAttribute("linksuppliername", linksuppliername);
		request.setAttribute("bsplicencetype", bsplicencetype);
		request.setAttribute("bsplicencestate", bsplicencestate);
		request.setAttribute("bbdsupplierid", bbdsupplierid);
		request.setAttribute("selbspsuppliername", selbspsuppliername);
		
		if("".equals(cateid))
		{
			cateid=goodsCategoryID;
		}
		request.setAttribute("cateid", cateid);
		//加载树中供应商
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		request.setAttribute("goodsTree", goodsTree);
		
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("parent", parent);
		if (goodsTree.equals("1")){
			SupplierPo po = new SupplierPo();
			po.setBspid(supplierID);
			po = supplierAgentMgr.getSupplier(po);
			request.setAttribute("supplierName",Utility.getName(po.getBspsuppliername()));
		}
		
		return SUCCESS;
	}
	
	public BrandMgr getBrandMgr() {
		return brandMgr;
	}
	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}
	public List<BrandPo> getBrands() {
		return brands;
	}
	public void setBrands(List<BrandPo> brands) {
		this.brands = brands;
	}
	public String getIsFirstExec() {
		return isFirstExec;
	}
	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public SupplierPo getSupplierPo() {
		return supplierPo;
	}

	public void setSupplierPo(SupplierPo supplierPo) {
		this.supplierPo = supplierPo;
	}

	/**
	 * 
	 * 当前文件
	 */
	private String file;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
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
}
