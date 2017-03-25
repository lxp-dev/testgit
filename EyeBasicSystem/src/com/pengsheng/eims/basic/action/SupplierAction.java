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
import com.pengsheng.eims.basic.mgr.DownloadRegionMgr;
import com.pengsheng.eims.basic.mgr.OptionParamMgr;
import com.pengsheng.eims.basic.mgr.SupplierMgr;
import com.pengsheng.eims.basic.persistence.BrandPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
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

public class SupplierAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	private SupplierMgr supplierMgr;
	private List<SupplierPo> supplierList;
	private List<GoodsCategoryPo> goodsCategoryList;	
	private SupplierPo supplierPo;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private BrandMgr brandMgr;
	private List<BrandPo> brands;
	private DownloadRegionMgr downloadRegionMgr;
	private List<OptionParamPo> optionParamPolist;
	private OptionParamMgr optionParamMgr;
	private BrandPo brandPo;
	
	/**
	 * 初始化制造商查询
	 */
	public String initSupplierSel() throws Exception {
		
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
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selSupplier";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询制造商
	 */
	public String selSupplier() throws Exception {
		
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
		
		int count = supplierMgr.getSupplierCount(supplierPo);
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
			supplierList = supplierMgr.getSupplierList(supplierPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			supplierList = null;
		}

		goodsCategoryList = supplierMgr.getGoodsCategoryList();

		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("bspsuppliermnemonic", bspsuppliermnemonic);
		request.setAttribute("bsporderby", bsporderby);
		request.setAttribute("isClosed", isClosed);
		request.setAttribute("makeinvoiceflag", makeinvoiceflag);
		
		if("".equals(cateid))
		{
			cateid=goodsCategoryID;
		}
		request.setAttribute("cateid", cateid);
		//加载树中制造商
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		request.setAttribute("goodsTree", goodsTree);
		
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("parent", parent);
		if (goodsTree.equals("1")){
			SupplierPo po = new SupplierPo();
			po.setBspid(supplierID);
			po = supplierMgr.getSupplier(po);
			request.setAttribute("supplierName",Utility.getName(po.getBspsuppliername()));
		}
		
		return SUCCESS;
	}

	/**
	 * 初始化制造商新增
	 */
	public String initSupplierInsert() throws Exception {
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
		goodsCategoryList = supplierMgr.getGoodsCategoryList();		
		if (!hid.equals("")){
			goodsCategoryList = getGoodsCategoryList(goodsCategoryList,hid);
		}
				
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	 * 新增制造商
	 */
	public String insertSupplier() throws Exception {
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

		goodsCategoryList = supplierMgr.getGoodsCategoryList();		
		String[] goodsCategoryID = request.getParameterValues("goodsCategoryID");
	
		String goodsCategory = getGoodsCategory(goodsCategoryID);
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); 	// 表示模块名称 
		logPo.setsLogOpID("1");    		// 表示状态
		logPo.setsLogContent("制造商:" + supplierPo.getBspid()+supplierPo.getBspsuppliername() + "新增!");
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		supplierPo.setBspcategoryid(goodsCategory);
		this.clearMessages();
		SupplierPo po = supplierMgr.getSupplier(supplierPo);
		if (po.getBspid() == null) {
			supplierPo.setBspinsertxzdflag(Utility.getName(systemParameterPo.getFspsupplierinsertxzd()));
			supplierPo.setBspcompanyid(personInfoPo.getPersoncompanyid());
			supplierPo.setBspissyncompanysupplier(systemParameterPo.getFspsyncompanysupplier());
			supplierMgr.insertSupplier(supplierPo,logPo);
			
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
			//获取下拉列表值
			OptionParamPo optionParamPoTmp=new OptionParamPo();
			optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
			
			goodsCategoryList = supplierMgr.getGoodsCategoryList();
			goodsCategoryList = getGoodsCategoryList(goodsCategoryList, supplierPo.getBspcategoryid());
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.repeat"));
			request.setAttribute("goodsTree",goodsTree);
			request.setAttribute("flag", GlobalConstants.INSERT);
			
			return ERROR;
		}

		return SUCCESS;
	}

	/**
	* Description :查询某一制造商的详细信息
	* @return :制造商详情页面
	*/
	public String supplierDetail() throws Exception {
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
		supplierPo = supplierMgr.getSupplier(supplierPo);
		
		goodsCategoryList = supplierMgr.getGoodsCategoryList();
		goodsCategoryList = getGoodsCategoryList(goodsCategoryList, supplierPo.getBspcategoryid());
	
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		return SUCCESS;
	}

	/**
	* Description :下载制造商许可证
	* @return :下载弹窗
	*/
	public String downloadImage() throws Exception {

		String bspid = Utility.getName(request.getParameter("bspid"));

		supplierPo = new SupplierPo();

		supplierPo.setBspid(bspid);
		supplierPo = supplierMgr.getSupplier(supplierPo);

		return SUCCESS;
	}

	/**
	 * 初始化制造商修改
	 */
	public String initSupplierUpdate() throws Exception {
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

		supplierPo = new SupplierPo();

		supplierPo.setBspid(hid);
		supplierPo = supplierMgr.getSupplier(supplierPo);

		goodsCategoryList = supplierMgr.getGoodsCategoryList();
		goodsCategoryList = getGoodsCategoryList(goodsCategoryList, supplierPo.getBspcategoryid());
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("goodsTree", goodsTree);
		request.setAttribute("parent", parent);
		request.setAttribute("hid", hid);
		
		return SUCCESS;
	}

	/**
	 * 修改制造商
	 * 
	 */
	public String updateSupplier() throws Exception {
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
		String[] goodsCategoryID = request
				.getParameterValues("goodsCategoryID");
		String goodsCategory = getGoodsCategory(goodsCategoryID);
		String updateBrand = Utility.getName(request.getParameter("updateBrand"));
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("制造商:" + supplierPo.getBspid()+supplierPo.getBspsuppliername()+"修改!");
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent = Utility.getName(request.getParameter("parent"));
		supplierPo.setBspcategoryid(goodsCategory);

		supplierMgr.updateSupplier(supplierPo, updateBrand, logPo);
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
	public String initSupplierExcel() throws Exception {

		return SUCCESS;
	}

	/**
	 * 批量导入Excel
	 * 
	 */
	public String insertSupplierExcel() throws Exception {

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

			// 制造商代码字段是否
			String B_SP_ID = row.getCell(0).getRichStringCellValue().toString();
			if (B_SP_ID.equals("")) {
				break;
			}
			
			// 添加制造商名称字段
			String B_SP_SupplierName = row.getCell(1).getRichStringCellValue()
					.toString();

			// 添加制造商联系人字段
			String B_SP_ContactPerson = row.getCell(2).getRichStringCellValue()
					.toString();

			// 添加制造商电话字段
			String B_SP_ContactPhone = row.getCell(3).getRichStringCellValue()
					.toString();

			// 添加制造商传真字段
			String B_SP_Fax = row.getCell(4).getRichStringCellValue()
					.toString();

			// 添加制造商地址字段
			String B_SP_Address = row.getCell(5).getRichStringCellValue()
					.toString();

			// 制造商备注字段
			String B_SP_Remark = row.getCell(6).getRichStringCellValue()
					.toString();

			// 添加制造商类别字段
			String B_SP_CategoryID = row.getCell(7).getRichStringCellValue()
					.toString();

			// 制造商启用/停用字段
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
		supplierMgr.insertSupplier(supplierList);
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.import.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;

	}

	/**
	 * 初始化制造商删除
	 */
	public String initSupplierDelete() throws Exception {
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
		supplierPo = supplierMgr.getSupplier(supplierPo);
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("goodsTree", goodsTree);
		request.setAttribute("parent", parent);
		return SUCCESS;
	}

	/**
	 * 删除制造商
	 */
	public String deleteSupplier() throws Exception {
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
		logPo.setsLogContent("制造商:" + supplierPo.getBspid()+"删除!");
		
		int flag = supplierMgr.getBrandCount(id);
		this.clearMessages();
		if (flag == 0) {
			supplierMgr.deleteSupplier(supplierPo,logPo);
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
	 * 初始化制造商停用
	 */
	public String initSupplierDisable() throws Exception {
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
		supplierPo = supplierMgr.getSupplier(supplierPo);

		return SUCCESS;
	}

	/**
	 * 停用制造商
	 */
	public String disableSupplier() throws Exception {
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
		logPo.setsLogContent("制造商:" + supplierPo.getBspid()+"停用!");
		
		supplierMgr.updateSupplierDisable(supplierPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化制造商启用
	 */
	public String initSupplierAble() throws Exception {
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
		supplierPo = supplierMgr.getSupplier(supplierPo);

		return SUCCESS;
	}

	/**
	 * 启用制造商
	 */
	public String ableSupplier() throws Exception {
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
		logPo.setsLogContent("制造商:" + supplierPo.getBspid()+"启用!");
		
		supplierMgr.updateSupplierDisable(supplierPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化制造商账款
	 */
	public String selAccount() throws Exception {
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
		request.setAttribute("hid", id);		
		String flag = Utility.getName(request.getParameter("flag"));		
		request.setAttribute("flag", flag);
		
		supplierPo = new SupplierPo();
		supplierPo.setBspid(id);
		supplierPo = supplierMgr.getSupplier(supplierPo);
		
		return SUCCESS;
	}
	
	/**
	 * 更改制造商账款
	 */
	public String insertAccount() throws Exception {
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
		
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("制造商:" + supplierPo.getBspid()+Utility.getName(supplierPo.getBspsuppliername())+"修改账款信息!");

		supplierMgr.updateSupplierAccount(supplierPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public SupplierMgr getSupplierMgr() {
		return supplierMgr;
	}

	public void setSupplierMgr(SupplierMgr supplierMgr) {
		this.supplierMgr = supplierMgr;
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
	 * 查询制造商
	 */
	public String selSupplierTree() throws Exception {
		
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
			supplierList = supplierMgr.getSupplierList(supplierPo, 0,300);
			brands =  brandMgr.getBrands(brandPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			supplierList = null;
		}

		goodsCategoryList = supplierMgr.getGoodsCategoryList();

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
		//加载树中制造商
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		request.setAttribute("goodsTree", goodsTree);
		
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("parent", parent);
		if (goodsTree.equals("1")){
			
			
			SupplierPo po = new SupplierPo();
			po.setBspid(supplierID);
			po = supplierMgr.getSupplier(po);
			request.setAttribute("supplierName",Utility.getName(po.getBspsuppliername()));
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 初始化品种下载制造商查询
	 */
	public String initDownloadBrandSel() throws Exception {
		
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
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selDownloadBrand";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询品种下载制造商
	 */
	public String selDownloadBrand() throws Exception {
		
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
		
		int count = supplierMgr.getSupplierCount(supplierPo);
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
			supplierList = supplierMgr.getSupplierList(supplierPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			supplierList = null;
		}

		goodsCategoryList = supplierMgr.getGoodsCategoryList();

		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("bspsuppliermnemonic", bspsuppliermnemonic);
		request.setAttribute("bsporderby", bsporderby);
		request.setAttribute("isClosed", isClosed);
		request.setAttribute("makeinvoiceflag", makeinvoiceflag);
		
		if("".equals(cateid))
		{
			cateid=goodsCategoryID;
		}
		request.setAttribute("cateid", cateid);
		//加载树中制造商
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		request.setAttribute("goodsTree", goodsTree);
		
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("parent", parent);
		if (goodsTree.equals("1")){
			SupplierPo po = new SupplierPo();
			po.setBspid(supplierID);
			po = supplierMgr.getSupplier(po);
			request.setAttribute("supplierName",Utility.getName(po.getBspsuppliername()));
		}
		
		return SUCCESS;
	}
	
	/**
	 * 初始化品种下载
	 */
	public String initDownloadBrandSet() throws Exception {
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

		supplierPo = new SupplierPo();

		supplierPo.setBspid(hid);
		supplierPo = supplierMgr.getSupplier(supplierPo);

		goodsCategoryList = supplierMgr.getGoodsCategoryList();
		goodsCategoryList = getGoodsCategoryList(goodsCategoryList, supplierPo.getBspcategoryid());
		
		//获取下拉列表值
		OptionParamPo optionParamPoTmp=new OptionParamPo();
		optionParamPolist=optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		BrandPo tbpo = new BrandPo();
		tbpo.setBbdsupplierid(hid);
		List<BrandPo> brands = downloadRegionMgr.noGetDownloadBrandList(tbpo);
		
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("goodsTree", goodsTree);
		request.setAttribute("parent", parent);
		request.setAttribute("hid", hid);
		request.setAttribute("brands", brands);
		
		return SUCCESS;
	}

	/**
	 * 品种下载
	 * 
	 */
	public String setDownloadBrand() throws Exception {
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
		String bbdsupplierid = request.getParameter("brandPo.bbdsupplierid");
		String[] bbdids = request.getParameterValues("brandPo.bbdids");
		//添加日志
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称 
		logPo.setsLogOpID("3");    // 表示状态
		logPo.setsLogContent("品种下载:" + bbdsupplierid+"制造商下载!");
		
		BrandPo bpo = new BrandPo();
		bpo.setBbdids(bbdids);
		bpo.setBbdsupplierid(bbdsupplierid);
		supplierMgr.noInsertCompanyBrandPos(bpo, logPo);
		this.clearMessages();
		this.addActionMessage("设置成功");
		
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
	
	/**
	 * 初始化商品下载
	 */
	public String initInsertDownloadGoodsinfo() throws Exception {
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
		String goodsId = Utility.getName(request.getParameter("goodsId"));
		request.setAttribute("goodsId", goodsId);

		return SUCCESS;
	}
	
	/**
	 * 商品下载
	 * 
	 */
	public String insertDownloadGoodsInfo() throws Exception {
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
		String goodsId = Utility.getName(request.getParameter("hid"));
		
		if(goodsId.equals("")){
			this.clearMessages();
			this.addActionMessage("商品代码为空,下载失败!");
			
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}else{
			//添加日志
			LogisticsLogPo logPo = new LogisticsLogPo();
			logPo.setsLogName(createPerson);
			logPo.setsLogIP(request.getRemoteAddr());
			logPo.setsLogResult(moduleID); // 表示模块名称 
			logPo.setsLogOpID("3");    // 表示状态
			logPo.setsLogContent("商品下载:" + goodsId+"商品下载!");
			
			GoodsInfoPo goodsInfoPo = new GoodsInfoPo();
			goodsInfoPo.setBgigoodsid(goodsId);
			downloadRegionMgr.noInsertCompanyGoodsPo(goodsInfoPo, logPo);
			this.clearMessages();
			this.addActionMessage("下载成功!");
			
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}		

		return SUCCESS;
	}
	
	/**
	 * 初始化制造商查询
	 */
	public String initSupplierDateSel() throws Exception {
		
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

		goodsCategoryList = supplierMgr.getGoodsCategoryList();
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selSupplierDate";
		}
		
		return SUCCESS;
	}

	/**
	 * 查询制造商
	 */
	public String selSupplierDate() throws Exception {
		
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
		
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String goodsCategoryID = Utility.getName(request.getParameter("goodsCategoryID"));
		String bspsuppliermnemonic = Utility.getName(request.getParameter("bspsuppliermnemonic"));
		String bsporderby = Utility.getName(request.getParameter("bsporderby"));
		String isClosed = Utility.getName(request.getParameter("isClosed"));
		String cateid= Utility.getName(request.getParameter("cateid"));
		String makeinvoiceflag = Utility.getName(request.getParameter("makeinvoiceflag"));
		String bsplicencetype = Utility.getName(request.getParameter("bsplicencetype"));
		String bsplicencestate = Utility.getName(request.getParameter("bsplicencestate"));
		
		OptionParamPo optionParamPoTmp = new OptionParamPo();
		optionParamPolist = optionParamMgr.getOptionParamMinList(optionParamPoTmp);

		if(bsplicencetype.equals("")){
			bsplicencetype="1";
		}
		supplierPo = new SupplierPo();
		supplierPo.setBspid(supplierID);
		supplierPo.setBspsuppliername(supplierName);
		supplierPo.setBspcategoryid(goodsCategoryID);
		supplierPo.setBspsuppliermnemonic(bspsuppliermnemonic);
		supplierPo.setBspflag(isClosed);
		supplierPo.setBspordersupplierid(bsporderby);
		supplierPo.setBspmakeinvoiceflag(makeinvoiceflag);
		supplierPo.setBsplicencetype(bsplicencetype);
		supplierPo.setBsplicencestate(bsplicencestate);
		
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
		
		int count = supplierMgr.getSupplierCount(supplierPo);
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
			supplierList = supplierMgr.getSupplierList(supplierPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			supplierList = null;
		}

		goodsCategoryList = supplierMgr.getGoodsCategoryList();

		request.setAttribute("supplierID", supplierID);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("goodsCategoryID", goodsCategoryID);
		request.setAttribute("bspsuppliermnemonic", bspsuppliermnemonic);
		request.setAttribute("bsporderby", bsporderby);
		request.setAttribute("isClosed", isClosed);
		request.setAttribute("makeinvoiceflag", makeinvoiceflag);
		request.setAttribute("bsplicencetype", bsplicencetype);
		request.setAttribute("bsplicencestate", bsplicencestate);
		
		if("".equals(cateid))
		{
			cateid=goodsCategoryID;
		}
		request.setAttribute("cateid", cateid);
		//加载树中制造商
		String goodsTree = Utility.getName(request.getParameter("goodsTree"));
		request.setAttribute("goodsTree", goodsTree);
		
		String parent = Utility.getName(request.getParameter("parent"));
		request.setAttribute("parent", parent);
		if (goodsTree.equals("1")){
			SupplierPo po = new SupplierPo();
			po.setBspid(supplierID);
			po = supplierMgr.getSupplier(po);
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

	public DownloadRegionMgr getDownloadRegionMgr() {
		return downloadRegionMgr;
	}

	public void setDownloadRegionMgr(DownloadRegionMgr downloadRegionMgr) {
		this.downloadRegionMgr = downloadRegionMgr;
	}

	public BrandPo getBrandPo() {
		return brandPo;
	}

	public void setBrandPo(BrandPo brandPo) {
		this.brandPo = brandPo;
	}
}
