package com.pengsheng.eims.storage.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.BrandMgr;
import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.CheckStorageMgr;
import com.pengsheng.eims.storage.persistence.CheckStorageEntryPo;
import com.pengsheng.eims.storage.persistence.CheckStorageEntryfxTempPo;
import com.pengsheng.eims.storage.persistence.CheckStoragePo;
import com.pengsheng.eims.storage.persistence.CheckStoragefxEntryPo;
import com.pengsheng.eims.storage.persistence.CheckStoragefxPo;
import com.pengsheng.eims.storage.persistence.InventoryPo;
import com.pengsheng.eims.system.mgr.BillKeyMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class CheckStorageAction extends BaseAction {

	private CheckStorageMgr checkStorageMgr;
	private CheckStorageEntryPo checkStorageEntryPo;
	private CheckStorageEntryfxTempPo checkStorageEntryfxTempPo;
	private List<CheckStoragefxEntryPo> checkStoragefxEntryList;
	private CheckStoragefxPo checkStoragefxPo;	
	private BillKeyMgr billKeyMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private VarietyMgr varietyMgr;
		
	public BillKeyMgr getBillKeyMgr() {
		return billKeyMgr;
	}

	public void setBillKeyMgr(BillKeyMgr billKeyMgr) {
		this.billKeyMgr = billKeyMgr;
	}

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
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
	public List<CheckStoragefxEntryPo> getCheckStoragefxEntryList() {
		return checkStoragefxEntryList;
	}

	public void setCheckStoragefxEntryList(
			List<CheckStoragefxEntryPo> checkStoragefxEntryList) {
		this.checkStoragefxEntryList = checkStoragefxEntryList;
	}

	public CheckStoragefxPo getCheckStoragefxPo() {
		return checkStoragefxPo;
	}

	public void setCheckStoragefxPo(CheckStoragefxPo checkStoragefxPo) {
		this.checkStoragefxPo = checkStoragefxPo;
	}

	public CheckStorageEntryfxTempPo getCheckStorageEntryfxTempPo() {
		return checkStorageEntryfxTempPo;
	}

	public void setCheckStorageEntryfxTempPo(
			CheckStorageEntryfxTempPo checkStorageEntryfxTempPo) {
		this.checkStorageEntryfxTempPo = checkStorageEntryfxTempPo;
	}

	public CheckStorageEntryPo getCheckStorageEntryPo() {
		return checkStorageEntryPo;
	}

	public void setCheckStorageEntryPo(CheckStorageEntryPo checkStorageEntryPo) {
		this.checkStorageEntryPo = checkStorageEntryPo;
	}

	private WarehouseMgr warehouseMgr;

	private List<WarehousePo> warehouselist;

	private List<CheckStoragePo> checkStorages;

	private List<CheckStorageEntryPo> checkStorageEntrys;

	private CheckStoragePo checkStoragePo;

	private File[] checkBarcode;

	private String[] uploadContentType;

	private String[] uploadFileName;

	private PersonPermissionMgr personPermissionMgr;

	private BrandMgr brandMgr;
	private List<GoodsCategoryPo> goodsCategorys;

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public BrandMgr getBrandMgr() {
		return brandMgr;
	}

	public void setBrandMgr(BrandMgr brandMgr) {
		this.brandMgr = brandMgr;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public CheckStorageMgr getCheckStorageMgr() {
		return checkStorageMgr;
	}

	public void setCheckStorageMgr(CheckStorageMgr checkStorageMgr) {
		this.checkStorageMgr = checkStorageMgr;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public List<WarehousePo> getWarehouselist() {
		return warehouselist;
	}

	public void setWarehouselist(List<WarehousePo> warehouselist) {
		this.warehouselist = warehouselist;
	}

	public List<CheckStoragePo> getCheckStorages() {
		return checkStorages;
	}

	public void setCheckStorages(List<CheckStoragePo> checkStorages) {
		this.checkStorages = checkStorages;
	}

	public List<CheckStorageEntryPo> getCheckStorageEntrys() {
		return checkStorageEntrys;
	}

	public void setCheckStorageEntrys(
			List<CheckStorageEntryPo> checkStorageEntrys) {
		this.checkStorageEntrys = checkStorageEntrys;
	}

	public CheckStoragePo getCheckStoragePo() {
		return checkStoragePo;
	}

	public void setCheckStoragePo(CheckStoragePo checkStoragePo) {
		this.checkStoragePo = checkStoragePo;
	}

	public File[] getCheckBarcode() {
		return checkBarcode;
	}

	public void setCheckBarcode(File[] checkBarcode) {
		this.checkBarcode = checkBarcode;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String initInsertCheckBarcode() throws Exception {

		String billID = "MAIO"
				+ GenerateNumber.getInstance().getGenerageNumber();
		String stockid = Utility.getName(request.getParameter("stockid"));
		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(billID);

		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype("1");
		goodsCategorys = varietyMgr.getGoodsCategorys();
		warehouselist = warehouseMgr.getWarehouseList(po);
		request.setAttribute("stockid", stockid);
		return SUCCESS;
	}

	public String insertCheckBarcode() throws Exception {
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		// 读取盘点文件流
		String billID = request.getParameter("checkStoragePo.cshcsbillid");
		String stockId = request.getParameter("checkStoragePo.cshcsstockid");
		String checkname = request.getParameter("checkStoragePo.cshcscheckname");
		String goodscategoryID = request.getParameter("goodscategoryID");
		
		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(billID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		checkStoragePo.setCshcscheckname(checkname);
		checkStoragePo.setCshcsstockid(stockId);
		checkStoragePo.setCshccategoryid(goodscategoryID);

		checkStoragePo.setCshcscheckstockperson(personInfoPo.getId());
		
		int count = 0;		
		String errorBarcode = "";
		for (File barcodeF : checkBarcode) {
			try {
				BufferedReader bfReader = new BufferedReader(new FileReader(barcodeF));
				
				String lineStr = "";
				int i=1;
				while ((lineStr = bfReader.readLine()) != null) {
					if(!goodscategoryID.equals("")){
						if (!"".equals(lineStr) && (!lineStr.substring(0, 1).equals(goodscategoryID) || lineStr.trim().length() != 26)) {
							errorBarcode = errorBarcode+"第"+i+"行："+lineStr+"\\n";
							count++;
						}						
					}else{
						if (!"".equals(lineStr) && lineStr.trim().length() != 26) {
							errorBarcode = errorBarcode+"第"+i+"行："+lineStr+"\\n";
							count++;
						}						
					}

					i++;
				}
			} catch (Exception e) {
				po.setBdpdepartmentid(personInfoPo.getDepartmentID());
				po.setBdptype("1");
				goodsCategorys = varietyMgr.getGoodsCategorys();
				warehouselist = warehouseMgr.getWarehouseList(po);
				request.setAttribute("stockid", stockId);
				request.setAttribute("goodscategoryID", goodscategoryID);
				
				request.setAttribute("errorBarcode", "导入文本文件不能为空！");
				
				return "errorBarcode";
			}
		}
		
		if(count > 0){
			po.setBdpdepartmentid(personInfoPo.getDepartmentID());
			po.setBdptype("1");
			goodsCategorys = varietyMgr.getGoodsCategorys();
			warehouselist = warehouseMgr.getWarehouseList(po);
			request.setAttribute("stockid", stockId);
			request.setAttribute("goodscategoryID", goodscategoryID);
			
			request.setAttribute("errorBarcode", "由于以下商品不属于此类商品或条码长度有误：\\n"+errorBarcode+"导入失败！");
			
			return "errorBarcode";
		}
		
		checkStorageMgr.insertCheckStorgeTemp(checkStoragePo, checkBarcode);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.import.sucess"));
		request.setAttribute("url",
				"'initCheckStorageView.action?checkStoragePo.cshcsstockid="
						+ stockId + "&hid=" + billID + "'");
		request.setAttribute("flag", GlobalConstants.UPADTE);
		return SUCCESS;
	}

	public String initInsertCheckStorageSel() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		goodsCategorys = varietyMgr.getGoodsCategorys();
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype("1");

		warehouselist = warehouseMgr.getWarehouseList(po);

		return SUCCESS;
	}

	public String selInsertCheckStorage() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		PersonInfoPo  personInfoPo = (PersonInfoPo) session.get("person");
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype("1");
		
		
		String stockid = checkStoragePo.getCshcsstockid();
		String billid = checkStoragePo.getCshcsbillid();
		String audit = checkStoragePo.getCshcsauditstate();
		String kid = request.getParameter("kid");
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		CheckStoragePo StoragePo = new CheckStoragePo();
		StoragePo.setCshcsstockid(stockid);
		StoragePo.setCshcsbillid(billid);
		StoragePo.setCshcsauditstate(audit);
		StoragePo.setCshccategoryid(goodscategoryID);
		request.setAttribute("goodscategoryID", goodscategoryID);
		warehouselist = warehouseMgr.getWarehouseList(po);
		if (stockid != null && stockid != "") {
			checkStorages = checkStorageMgr.getCheckStorageTempList(StoragePo);
		}
		if (kid != null && kid != "") {
			checkStorages = checkStorageMgr.getCheckStorageTempList(StoragePo);
		}
		goodsCategorys = varietyMgr.getGoodsCategorys();
		return SUCCESS;
	}

	public String initCheckStorageView() throws Exception {
		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(Utility.getName(request
				.getParameter("hid")));
		checkStoragePo = checkStorageMgr.getCheckStorageTempPo(checkStoragePo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = checkStorageMgr.getCheckStorageTempEntryCount(checkStoragePo);
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
			checkStorageEntrys = checkStorageMgr.getCheckStorageTempEntryList(
					checkStoragePo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			checkStorageEntrys = null;
		}

		return SUCCESS;
	}

	public String initCheckStorageDelete() throws Exception {
		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(request.getParameter("hid"));

		checkStoragePo = checkStorageMgr.getCheckStorageTempPo(checkStoragePo);
		return SUCCESS;
	}

	public String deleteCheckStorage() throws Exception {

		checkStorageMgr.deleteCheckStorageTemp(request.getParameter("hid"));

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public String initCheckStorageAudit() throws Exception {
		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(request.getParameter("hid"));

		checkStoragePo = checkStorageMgr.getCheckStorageTempPo(checkStoragePo);

		return SUCCESS;
	}

	public String auditCheckStorage() throws Exception {

		checkStorageMgr.auditCheckStorageTemp(request.getParameter("hid"));
		String kid = request.getParameter("kid");
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.audit.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	public String initCheckStorageBuild() throws Exception {

		request.setAttribute("checkStorageid", request
				.getParameter("checkStorageid"));

		return SUCCESS;
	}

	public String buildCheckStorage() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		String[] billids = request.getParameter("checkid").split(",");
		String billid = "MAIO" + GenerateNumber.getInstance().getGenerageNumber();
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String stockid = checkStoragePo.getCshcsstockid();
		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(billid);
		checkStoragePo.setCshcsstockid(stockid);
		checkStoragePo.setCshcscheckstockperson(personInfoPo.getId());
		checkStoragePo.setCshccategoryid(goodscategoryID);
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent(billid);
		
		checkStorageMgr.insertCheckStorage(checkStoragePo,logPo,billids);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	public String initInsertCheckStorageSumSel() throws Exception {

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

		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		DepartmentsPo dpo = new DepartmentsPo();
		dpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		dpo.setBdptype("1");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			dpo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		List<WarehousePo> warehouselist1 = warehouseMgr.getWarehouseList(dpo);		
		request.setAttribute("warehousesize", warehouselist1.size());

		warehouselist = warehouseMgr.getWarehouseList(po);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "storageSum";
		}
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		request.setAttribute("departmenttype", personInfoPo.getDepartmenttype());

		return SUCCESS;
	}

	public String selInsertCheckStorageSum() throws Exception {

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
		DepartmentsPo po = new DepartmentsPo();
		po.setBdpdepartmentid(personInfoPo.getDepartmentID());
		po.setBdptype(personInfoPo.getDepartmenttype());
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		warehouselist = warehouseMgr.getWarehouseList(po);
		
		DepartmentsPo dpo = new DepartmentsPo();
		dpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		dpo.setBdptype("1");
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			dpo.setBdpcompanysid(personInfoPo.getPersoncompanyid());
		}
		
		List<WarehousePo> warehouselist1 = warehouseMgr.getWarehouseList(dpo);		
		request.setAttribute("warehousesize", warehouselist1.size());

		String billID = Utility.getName(request.getParameter("billID"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String auditState = Utility.getName(request.getParameter("auditState"));
		String stockid = Utility.getName(request.getParameter("stockid"));
		String createPersonName = Utility.getName(request.getParameter("createPersonName"));
		String createPersonID = Utility.getName(request.getParameter("createPersonID"));
		String auditPersonName = Utility.getName(request.getParameter("auditPersonName"));
		String auditPersonID = Utility.getName(request.getParameter("auditPersonID"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));

		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(billID);
		checkStoragePo.setCshcsstarttime(startTime);
		checkStoragePo.setCshcsendtime(endTime);
		checkStoragePo.setCshcsstockid(stockid);
		checkStoragePo.setCshcsauditstate(auditState);
		checkStoragePo.setCshcsauditperson(auditPersonID);
		checkStoragePo.setCshcscheckstockperson(createPersonID);
		checkStoragePo.setCshccategoryid(goodscategoryID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			checkStoragePo.setCshcscompanyid(personInfoPo.getPersoncompanyid());
		}
		
		if("1".equals(personInfoPo.getDepartmenttype())&& "".equals(stockid)){
			checkStoragePo.setCshcsstockid(warehouselist.get(0).getBwhid());
		}
		request.setAttribute("departmenttype", personInfoPo.getDepartmenttype());
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
		
		int count = checkStorageMgr.getCheckStorageCount(checkStoragePo);
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
			checkStorages = checkStorageMgr.getCheckStorageList(checkStoragePo,
					page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			checkStorages = null;
		}
		
		goodsCategorys = varietyMgr.getGoodsCategorys();
		
		request.setAttribute("billID", billID);
		request.setAttribute("goodscategoryID", goodscategoryID);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("auditState", auditState);
		request.setAttribute("stockid", stockid);
		request.setAttribute("createPersonName", createPersonName);
		request.setAttribute("createPersonID", createPersonID);
		request.setAttribute("auditPersonName", auditPersonName);
		request.setAttribute("auditPersonID", auditPersonID);
		

		return SUCCESS;
	}

	public String initCheckStorageSumView() throws Exception {

		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(request.getParameter("hid"));

		checkStoragePo = checkStorageMgr.getCheckStoragePo(checkStoragePo);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = checkStorageMgr.getCheckStorageEntryCount(checkStoragePo);
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
			checkStorageEntrys = checkStorageMgr.getCheckStorageEntryList(
					checkStoragePo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			checkStorageEntrys = null;
		}
		int checkStoragefxCount=checkStorageMgr.getCheckStoragefxCount(checkStoragePo);
		
		request.setAttribute("checkStoragefxCount",checkStoragefxCount);

		return SUCCESS;
	}

	public String initCheckStorageSumAudit() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		request.setAttribute("goodscategoryID", goodscategoryID);

		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(request.getParameter("hid"));
		checkStoragePo = checkStorageMgr.getCheckStoragePo(checkStoragePo);
		return SUCCESS;
	}

	public String auditCheckStorageSum() throws Exception {
		checkStoragePo = new CheckStoragePo();
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String cshcsstockid = request.getParameter("kid");
		checkStoragePo.setCshcsstockid(cshcsstockid);
		
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String goodscategoryID = Utility.getName(request.getParameter("goodscategoryID"));
		checkStoragePo.setCshccategoryid(goodscategoryID);
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("4");    // 审核
		logPo.setsLogContent(request.getParameter("hid"));
		
		checkStorageMgr.auditCheckStorage(checkStoragePo, request
				.getParameter("hid"), personInfoPo.getId(),logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.audit.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}

	public String initCheckStorageSumDelete() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		
		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(request.getParameter("hid"));

		checkStoragePo = checkStorageMgr.getCheckStoragePo(checkStoragePo);

		return SUCCESS;
	}

	public String deleteCheckStorageSum() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("2");    // 删除
		logPo.setsLogContent(request.getParameter("hid"));

		
		checkStorageMgr.deleteCheckStorage(request.getParameter("hid"),logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public String initbuildSCI() throws Exception {
		
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);


		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(request.getParameter("hid"));

		checkStoragePo = checkStorageMgr.getCheckStoragePo(checkStoragePo);
		checkStoragePo.setYkFlag("1");

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = checkStorageMgr.getCheckStorageykCount(checkStoragePo);
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
			checkStorageEntrys = checkStorageMgr.getCheckStorageykList(
					checkStoragePo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			checkStorageEntrys = null;
		}
		return SUCCESS;
	}

	public String buildSCI() throws Exception {
		String type = Utility.getName(request.getParameter("type"));
		int undo = billKeyMgr.selectSCIorSCOForAuditType("SCI",type,request.getParameter("stockid"));
		if(undo > 0){
			this.clearMessages();
			this.addActionMessage("存在未处理的盘盈单，请处理后进行此项操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		InventoryPo inventoryPo = new InventoryPo();
		inventoryPo.setCstibilltypeid("5");
		inventoryPo.setCstisourcebillid(request.getParameter("hid"));
		inventoryPo.setCstioutstockid(request.getParameter("stockid"));
		inventoryPo.setCstibillid("SCI"
				+ GenerateNumber.getInstance().getGenerageNumber());
		inventoryPo.setCsticreateperson(personInfoPo.getId());

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent(inventoryPo.getCstibillid());

		
		checkStorageMgr.insertSCISCO(inventoryPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public String initbuildSCO() throws Exception {
		
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);


		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(request.getParameter("hid"));

		checkStoragePo = checkStorageMgr.getCheckStoragePo(checkStoragePo);
		checkStoragePo.setYkFlag("2");

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = checkStorageMgr.getCheckStorageykCount(checkStoragePo);
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
			checkStorageEntrys = checkStorageMgr.getCheckStorageykList(
					checkStoragePo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			checkStorageEntrys = null;
		}
		return SUCCESS;
	}

	public String buildSCO() throws Exception {
		String type = Utility.getName(request.getParameter("type"));
		int undo = billKeyMgr.selectSCIorSCOForAuditType("SCO",type,request.getParameter("stockid"));
		if(undo > 0){
			this.clearMessages();
			this.addActionMessage("存在未处理的盘亏单，请处理后进行此项操作！");
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			
			return SUCCESS;
		}
		
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		
		InventoryPo inventoryPo = new InventoryPo();
		inventoryPo.setCstibilltypeid("6");
		inventoryPo.setCstisourcebillid(request.getParameter("hid"));
		inventoryPo.setCstioutstockid(request.getParameter("stockid"));
		inventoryPo.setCstibillid("SCO"
				+ GenerateNumber.getInstance().getGenerageNumber());
		inventoryPo.setCsticreateperson(personInfoPo.getId());

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent(inventoryPo.getCstibillid());

		
		checkStorageMgr.insertSCISCO(inventoryPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}
    //初始化盘盈盘亏查询	
	public String initCheckStorageykSel() throws Exception {

		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(request.getParameter("hid"));

		checkStoragePo = checkStorageMgr.getCheckStoragePo(checkStoragePo);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = checkStorageMgr.getCheckStorageykCount(checkStoragePo);
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
			checkStorageEntrys = checkStorageMgr.getCheckStorageykList(
					checkStoragePo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			checkStorageEntrys = null;
		}

		return SUCCESS;

	}
    //盘盈盘亏查询
	public String checkStorageykSel() throws Exception {

		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(request.getParameter("hid"));

		checkStoragePo = checkStorageMgr.getCheckStoragePo(checkStoragePo);
		checkStoragePo.setYkFlag(request.getParameter("ykFlag"));

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count = checkStorageMgr.getCheckStorageykCount(checkStoragePo);
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
			checkStorageEntrys = checkStorageMgr.getCheckStorageykList(
					checkStoragePo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			checkStorageEntrys = null;
		}
		request.setAttribute("ykFlag",request.getParameter("ykFlag"));
		return SUCCESS;
	}	
    //初始化盈亏分析
	public String initCheckStoragefxInsert() throws Exception {
		
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

		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(request.getParameter("hid"));

		checkStoragePo = checkStorageMgr.getCheckStoragePo(checkStoragePo);

		checkStorageEntrys = checkStorageMgr.getCheckStorageykList(checkStoragePo);
		


		return SUCCESS;
	}
    //盈亏分析新增
	public String checkStoragefxInsert() throws Exception {
		
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
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 12 表示模块名称 
		logPo.setsLogOpID("1");    // 1 表示新增
		logPo.setsLogContent("盘点单号："+checkStoragefxPo.getCshcsbillid()+" 盈亏分析新增");
		
		checkStoragefxPo.setCshcsauditstate("1");
		checkStoragefxPo.setCshcsauditperson(createPerson);
		checkStoragefxPo.setCshcsremark("");
		
		int lenth =checkStorageEntryfxTempPo.getCshcsefxtgoodsid().length;
		
		checkStoragefxEntryList=new ArrayList<CheckStoragefxEntryPo>();
		
		for (int i = 0; i < lenth; i++) {			
			CheckStoragefxEntryPo checkStoragefxEntryPo=new CheckStoragefxEntryPo();
			checkStoragefxEntryPo.setCshcsebillid(checkStoragefxPo.getCshcsbillid());
			checkStoragefxEntryPo.setCshcsegoodsid(checkStorageEntryfxTempPo.getCshcsefxtgoodsid()[i]);
			checkStoragefxEntryPo.setCshcsegoodsname(checkStorageEntryfxTempPo.getCshcsefxtgoodsname()[i]);
			checkStoragefxEntryPo.setCshcseunitname(checkStorageEntryfxTempPo.getCshcsefxtunitname()[i]);
			checkStoragefxEntryPo.setCshcsebooknumber(checkStorageEntryfxTempPo.getCshcsefxtbooknumber()[i]);
			checkStoragefxEntryPo.setCshcsechecknumber(checkStorageEntryfxTempPo.getCshcsefxtchecknumber()[i]);
			checkStoragefxEntryPo.setCshcsecostPrice(checkStorageEntryfxTempPo.getCshcsefxtcostPrice()[i]);
			checkStoragefxEntryPo.setCshcsereason(checkStorageEntryfxTempPo.getCshcsefxtreason()[i]);
			checkStoragefxEntryPo.setCshcsesolve(checkStorageEntryfxTempPo.getCshcsefxtsolve()[i]);
			
			checkStoragefxEntryList.add(checkStoragefxEntryPo);
		}
		
		checkStorageMgr.insertCheckStoragefx(checkStoragefxPo, checkStoragefxEntryList, logPo);		
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
    //盈亏分析查询
	public String checkStoragefxSel() throws Exception {
		
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
		checkStoragePo = new CheckStoragePo();
		checkStoragePo.setCshcsbillid(request.getParameter("hid"));
		
		checkStoragefxPo=checkStorageMgr.getCheckStoragefxPo(checkStoragePo);	
		
		checkStoragefxEntryList=checkStorageMgr.getCheckStoragefxEntryList(checkStoragePo);
	
		return SUCCESS;
	}
	public String initGoodsBalance() throws Exception {
		// 获取仓位信息
		WarehousePo po = new WarehousePo();
		warehouselist = warehouseMgr.getWarehouseList(po);

		// 获取商品类别
		goodsCategorys = brandMgr.getGoodsCategorys();

		return SUCCESS;
	}

}
