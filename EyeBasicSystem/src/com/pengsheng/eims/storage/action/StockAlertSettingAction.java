/**
 * 
 */
package com.pengsheng.eims.storage.action;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.mgr.VarietyMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.GoodsCategoryPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.mgr.StockAlertSettingMgr;
import com.pengsheng.eims.storage.persistence.StockAlertSettingPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.TurnSphCyl;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * @author Liuqian
 * 
 */
public class StockAlertSettingAction extends BaseAction {

	private StockAlertSettingMgr stockAlertSettingMgr;
	private VarietyMgr varietyMgr;
	private WarehouseMgr warehouseMgr;
	private List<WarehousePo> warehouselist;
	private List<StockAlertSettingPo> alertList;
	private List<StockAlertSettingPo> alerts;
	private StockAlertSettingPo alertSettingPo;
	private List<GoodsCategoryPo> goodsCategorys;
	private PersonPermissionMgr personPermissionMgr;	
    private SystemParameterMgr systemParameterMgr;	
	private SystemParameterPo systemParameterPo;
	private GoodsInfoTempPo goodsInfoTempPo;
	private String isFirstExec;
	private List<GoodsInfoPo> goodsInfoPos;
	
	public List<GoodsInfoPo> getGoodsInfoPos() {
		return goodsInfoPos;
	}

	public void setGoodsInfoPos(List<GoodsInfoPo> goodsInfoPos) {
		this.goodsInfoPos = goodsInfoPos;
	}
	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}

	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}

	public String getIsFirstExec() {
		return isFirstExec;
	}

	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
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

	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public StockAlertSettingMgr getStockAlertSettingMgr() {
		return stockAlertSettingMgr;
	}

	public void setStockAlertSettingMgr(
			StockAlertSettingMgr stockAlertSettingMgr) {
		this.stockAlertSettingMgr = stockAlertSettingMgr;
	}

	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public VarietyMgr getVarietyMgr() {
		return varietyMgr;
	}

	public void setVarietyMgr(VarietyMgr varietyMgr) {
		this.varietyMgr = varietyMgr;
	}

	public List<WarehousePo> getWarehouselist() {
		return warehouselist;
	}

	public void setWarehouselist(List<WarehousePo> warehouselist) {
		this.warehouselist = warehouselist;
	}

	public List<StockAlertSettingPo> getAlertList() {
		return alertList;
	}

	public void setAlertList(List<StockAlertSettingPo> alertList) {
		this.alertList = alertList;
	}

	public List<StockAlertSettingPo> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<StockAlertSettingPo> alerts) {
		this.alerts = alerts;
	}

	public StockAlertSettingPo getAlertSettingPo() {
		return alertSettingPo;
	}

	public void setAlertSettingPo(StockAlertSettingPo alertSettingPo) {
		this.alertSettingPo = alertSettingPo;
	}

	public List<GoodsCategoryPo> getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(List<GoodsCategoryPo> goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
	}

	public String initStockAlertSettingInsert() {
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
		// 取仓位
		WarehousePo warehousePo = new WarehousePo();
		if ("1".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else if ("2".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else {
			if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
				warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
			}
			
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		return SUCCESS;
	}

	public String initStockAlertSettingSel() {
		

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

		goodsCategorys = varietyMgr.getGoodsCategorys();

		// 取仓位
		WarehousePo warehousePo = new WarehousePo();
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
		}
		warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selStockAlertSetting";
		}

		return SUCCESS;
	}

	public String initStockAlertSettingUpdate() {
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
		alertSettingPo = stockAlertSettingMgr.getStockAlertSettingPo(request
				.getParameter("id"));

		return SUCCESS;
	}

	public String updateStockAlertSetting() {
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
		logPo.setsLogContent(alertSettingPo.getCsasaid());
		
		stockAlertSettingMgr.updateGoodsStockAlert(alertSettingPo,logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	public String insertStockAlertSetting() {
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
		logPo.setsLogOpID("1");    // 表示状态
		logPo.setsLogContent("");
		alertSettingPo.setCsasasphul(TurnSphCyl.changeSph(alertSettingPo.getCsasasphul(), alertSettingPo.getCsasacylul()));
		alertSettingPo.setCsasasphup(TurnSphCyl.changeSph(alertSettingPo.getCsasasphup(), alertSettingPo.getCsasacylup()));
		alertSettingPo.setCsasacylul(TurnSphCyl.changeScopeCyl(alertSettingPo.getCsasacylup(),alertSettingPo.getCsasacylul()));
		alertSettingPo.setCsasacylup(TurnSphCyl.changeScopeCyl(alertSettingPo.getCsasacylul(),alertSettingPo.getCsasacylup()));
		stockAlertSettingMgr.updateStockAlertSettings(alertSettingPo,logPo);
		
		

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("alertSettingPo", alertSettingPo);
		
		WarehousePo warehousePo = new WarehousePo();
		warehouselist = warehouseMgr.getWarehouseList(warehousePo);

		return SUCCESS;
	}

	public String selStockAlertSetting() {

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
		
		String selGoodsID = request.getParameter("selGoodsID");
		String selGoodsName = request.getParameter("selGoodsName");
		String selGoodscategoryID = request.getParameter("selGoodscategoryID");
		String selSupplierName = request.getParameter("selSupplierName");
		String selSupplierID = request.getParameter("selSupplierID");
		String selBrandID = request.getParameter("selBrandID");
		String selBrandName = request.getParameter("selBrandName");
		String selWarehouseID = request.getParameter("selWarehouseID");

		goodsCategorys = varietyMgr.getGoodsCategorys();

		// 取仓位
		WarehousePo warehousePo = new WarehousePo();
		
		if ("1".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else if ("2".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else {
			
			if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
				warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
			}
			
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		}

		StockAlertSettingPo stockAlertSettingPo = new StockAlertSettingPo();
		stockAlertSettingPo.setCsasasupplierid(selSupplierID);
		stockAlertSettingPo.setCsasabrandid(selBrandID);
		stockAlertSettingPo.setCsasastockid(selWarehouseID);
		stockAlertSettingPo.setCsasagoodsid(selGoodsID);
		stockAlertSettingPo.setCsasagoodsname(selGoodsName);
		stockAlertSettingPo.setCsasagoodscategoryid(selGoodscategoryID);
		stockAlertSettingPo.setCsasadepartmenttype(personInfoPo.getDepartmenttype());
		stockAlertSettingPo.setCsasadepartmentid(personInfoPo.getDepartmentID());
		
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			stockAlertSettingPo.setCsasacompanyd(personInfoPo.getPersoncompanyid());
		}
		
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

		// 总数、分页
		int count = stockAlertSettingMgr.getStrockAlerInfoCount(stockAlertSettingPo);
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
			// 取详细信息

			alertList = stockAlertSettingMgr.getStrockAlerInfo(
					stockAlertSettingPo, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			alertList = null;
		}

		request.setAttribute("selGoodsID", selGoodsID);
		request.setAttribute("selGoodsName", selGoodsName);
		request.setAttribute("selGoodscategoryID", selGoodscategoryID);
		request.setAttribute("selSupplierName", selSupplierName);
		request.setAttribute("selSupplierID", selSupplierID);
		request.setAttribute("selBrandName", selBrandName);
		request.setAttribute("selBrandID", selBrandID);
		request.setAttribute("selWarehouseID", selWarehouseID);

		return SUCCESS;
	}
		
	public String initStockAlertSettingBatchDel(){
		
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
		
		String billID = Utility.getName(request.getParameter("billID"));
		request.setAttribute("billID",billID);
		
		return SUCCESS;
	}
	
	
	public String stockAlertSettingBatchDel(){
		
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
		logPo.setsLogOpID("2");  // 表示状态
		logPo.setsLogContent("库存预警设置批量删除!" );
		
		stockAlertSettingMgr.batchDeteleSettings(alertSettingPo, logPo);
			
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	
	public String initStockAlertSettingBatchUpt(){
		
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
		
		String billID = Utility.getName(request.getParameter("billID"));
		request.setAttribute("billID",billID);
		
		return SUCCESS;
	}
	
	
	public String stockAlertSettingBatchUpt(){
		
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
		logPo.setsLogOpID("3");  // 表示状态
		logPo.setsLogContent("库存预警设置批量修改!" );
		
		stockAlertSettingMgr.batchUpdateSettings(alertSettingPo, logPo);
			
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	public String initStockAlertSettingInsert2D(){
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
		
		// 取仓位
		WarehousePo warehousePo = new WarehousePo();
		if ("1".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else if ("2".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else {
			if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
				warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
			}
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		}
		
		return SUCCESS;
	}
	
	public String insertStockAlertSetting2D(){
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
		logPo.setsLogOpID("3");  // 表示状态
		logPo.setsLogContent("库存预警设置批量修改!" );
		
		int count = 0;
		if (goodsInfoTempPo == null){
			goodsInfoTempPo = new GoodsInfoTempPo();
		}		
		if (goodsInfoTempPo.getGoodsid() != null){
			count = goodsInfoTempPo.getGoodsid().length;
		}
		List<StockAlertSettingPo> spoList = new ArrayList<StockAlertSettingPo>();
		
		for (int i = 0; i < count; i++){
			
			StockAlertSettingPo spo = new StockAlertSettingPo();
			spo.setCsasagoodsid(Utility.getName(goodsInfoTempPo.getGoodsid()[i]));
			spo.setCsasasupplierid(Utility.getName(goodsInfoTempPo.getGoodsid()[i]).substring(2,4));
			spo.setCsasabrandid(Utility.getName(goodsInfoTempPo.getGoodsid()[i]).substring(5,7));
			spo.setCsasastockcap(Utility.getName(request.getParameter("csasastockcap")));
			spo.setCsasastocklower(Utility.getName(request.getParameter("csasastocklower")));
			spo.setCsasastockred(Utility.getName(request.getParameter("csasastockred")));
			spo.setCsasastockid(Utility.getName(request.getParameter("csasastockid")));
			
			spoList.add(spo);
		}
		
		stockAlertSettingMgr.updateStockAlertSettings2D(spoList,logPo);
		
		request.setAttribute("url", "'initStockAlertSettingInsert2D.action?moduleID="+moduleID+"'");
		request.setAttribute("flag", GlobalConstants.MOVE);
		
		return SUCCESS;
	}
	
	public String addStockAlertDimension(){
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

		// 取仓位
		WarehousePo warehousePo = new WarehousePo();
		if ("1".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else if ("2".equals(personInfoPo.getDepartmenttype())) {
			warehousePo.setBwhdeptid(personInfoPo.getDepartmentID());
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		} else {
			if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
				warehousePo.setBwhcompanyid(personInfoPo.getPersoncompanyid());
			}
			warehouselist = warehouseMgr.getWarehouseList(warehousePo);
		}
		
		String cstpgoodscategory = Utility.getName(request.getParameter("cstpgoodscategory"));
		String tdgoodsids = Utility.getName(request.getParameter("tdgoodsids"));
		String tdvs = Utility.getName(request.getParameter("tdvs"));		
		String csasasuppliername = Utility.getName(request.getParameter("csasasuppliername"));
		String csasasupplierid = Utility.getName(request.getParameter("csasasupplierid"));		
		String csasastockid = Utility.getName(request.getParameter("csasastockid"));		
		String csasastockcap = Utility.getName(request.getParameter("csasastockcap"));
		String csasastocklower = Utility.getName(request.getParameter("csasastocklower"));
		String csasastockred = Utility.getName(request.getParameter("csasastockred"));
		
		int count = 0;
		if (goodsInfoTempPo == null){
			goodsInfoTempPo = new GoodsInfoTempPo();
		}		
		if (goodsInfoTempPo.getGoodsid() != null){
			count = goodsInfoTempPo.getGoodsid().length;
		}		
		List<GoodsInfoPo> gpoList = new ArrayList<GoodsInfoPo>();
		
		for (int i = 0; i < count; i++){
			
			GoodsInfoPo gpo = new GoodsInfoPo();
			gpo.setBgigoodsid(Utility.getName(goodsInfoTempPo.getGoodsid()[i]));
			gpo.setBgigoodsname(Utility.getName(goodsInfoTempPo.getGoodsname()[i]));
			gpo.setBgibrandname(Utility.getName(goodsInfoTempPo.getBrandnames()[i]));
			gpo.setBgisph(Utility.getName(goodsInfoTempPo.getSphs()[i]));
			gpo.setBgicyl(Utility.getName(goodsInfoTempPo.getCyls()[i]));
			
			gpoList.add(gpo);
		}
		
		goodsInfoPos = stockAlertSettingMgr.selectDimensionPos(gpoList,tdgoodsids);

		request.setAttribute("cstpgoodscategory", cstpgoodscategory);
		request.setAttribute("tdgoodsids", tdgoodsids);		
		request.setAttribute("tdvs", tdvs);
		request.setAttribute("csasasuppliername", csasasuppliername);
		request.setAttribute("csasasupplierid", csasasupplierid);
		request.setAttribute("csasastockid", csasastockid);
		request.setAttribute("csasastockcap", csasastockcap);
		request.setAttribute("csasastocklower", csasastocklower);
		request.setAttribute("csasastockred", csasastockred);
		
		return SUCCESS;
	}
	
}
