package com.pengsheng.eims.basic.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.pengsheng.eims.basic.mgr.DelayWarningMgr;
import com.pengsheng.eims.basic.mgr.NoticeMgr;
import com.pengsheng.eims.basic.mgr.ReminderWindowMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.DelayWarningPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsDetailsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.NoticeFilePo;
import com.pengsheng.eims.basic.persistence.NoticePo;
import com.pengsheng.eims.basic.persistence.NoticeStaffViewPo;
import com.pengsheng.eims.basic.persistence.ReminderWindowPo;
import com.pengsheng.eims.basic.persistence.RepairsCostPo;
import com.pengsheng.eims.basic.persistence.StoresSalesPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.WindowConsignProcessOrderMgr;
import com.pengsheng.eims.components.mgr.WindowGoodsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.mgr.DelaysReminderMgr;
import com.pengsheng.eims.sales.persistence.DelaysReminderPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.mgr.AllocationMgr;
import com.pengsheng.eims.storage.mgr.NonconformingMgr;
import com.pengsheng.eims.storage.mgr.ProcurementWaitMgr;
import com.pengsheng.eims.storage.mgr.StockSearchMgr;
import com.pengsheng.eims.storage.persistence.AllocationPo;
import com.pengsheng.eims.storage.persistence.ConsignProcessOrderDetailsPo;
import com.pengsheng.eims.storage.persistence.NonconformingPo;
import com.pengsheng.eims.storage.persistence.ProcurementOrdersPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.PersonSetOptionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.PersonSetOptionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * 公告管理
 * 
 * @author sxh
 * 
 */
public class NoticeAction extends BaseAction {
	private PersonPermissionMgr personPermissionMgr;
	private NoticePo noticePo;
	private List<NoticePo> noticePos;
	private List<NoticePo> noticeTypeList;
	private NoticeMgr noticeMgr;
	private List<DepartmentsPo> departmentsList;
	private File[] upload;
	private String savePath;
	private String[] uploadFileName;
	private String[] uploadContentType;
	private String fileName;
	private List<PersonInfoPo> personInfoPos;
	private InputStream inputStream;
	private String contentType;
	private List<NoticeFilePo> noticeFileList;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private String isFirstExec;
	private DelayWarningPo delayWarningPo;
	private List<DelayWarningPo> delayWarningPos;
	private DelayWarningMgr delayWarningMgr;
	private StockSearchMgr stockSearchMgr;
	private List<GoodsInfoPo> alertgoodsList;
	private WindowConsignProcessOrderMgr windowConsignProcessOrderMgr;
	private List<ConsignProcessOrderDetailsPo> consignprocessordergoodsList;
	private List<AllocationPo> allocationList;
	private List<AllocationPo> allocationListForApp;
	private AllocationMgr allocationMgr;
	private List<NonconformingPo> nonconformingList;
	private NonconformingMgr nonconformingMgr;
	private List<StoresSalesPo> storesSalesList;
	private WindowGoodsMgr windowGoodsMgr;
	private RepairsCostPo repairsCostPo;
	private List<RepairsCostPo> repairsCostList;
	private PersonSetOptionMgr personSetOptionMgr;
	private ReminderWindowMgr reminderWindowMgr;
	private ProcurementWaitMgr procurementWaitMgr;
	private List<ProcurementOrdersPo> procurementOrdersListForApp;
	private DelaysReminderMgr delaysReminderMgr;
	private List<DelaysReminderPo> delaysReminderListForApp;
	private WarehouseMgr warehouseMgr;
	
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}

	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}

	public RepairsCostPo getRepairsCostPo() {
		return repairsCostPo;
	}

	public void setRepairsCostPo(RepairsCostPo repairsCostPo) {
		this.repairsCostPo = repairsCostPo;
	}

	public List<RepairsCostPo> getRepairsCostList() {
		return repairsCostList;
	}

	public void setRepairsCostList(List<RepairsCostPo> repairsCostList) {
		this.repairsCostList = repairsCostList;
	}

	public List<NonconformingPo> getNonconformingList() {
		return nonconformingList;
	}

	public void setNonconformingList(List<NonconformingPo> nonconformingList) {
		this.nonconformingList = nonconformingList;
	}

	public NonconformingMgr getNonconformingMgr() {
		return nonconformingMgr;
	}

	public void setNonconformingMgr(NonconformingMgr nonconformingMgr) {
		this.nonconformingMgr = nonconformingMgr;
	}

	public AllocationMgr getAllocationMgr() {
		return allocationMgr;
	}

	public void setAllocationMgr(AllocationMgr allocationMgr) {
		this.allocationMgr = allocationMgr;
	}

	public List<AllocationPo> getAllocationList() {
		return allocationList;
	}

	public void setAllocationList(List<AllocationPo> allocationList) {
		this.allocationList = allocationList;
	}

	public List<ConsignProcessOrderDetailsPo> getConsignprocessordergoodsList() {
		return consignprocessordergoodsList;
	}

	public void setConsignprocessordergoodsList(
			List<ConsignProcessOrderDetailsPo> consignprocessordergoodsList) {
		this.consignprocessordergoodsList = consignprocessordergoodsList;
	}

	public WindowConsignProcessOrderMgr getWindowConsignProcessOrderMgr() {
		return windowConsignProcessOrderMgr;
	}

	public void setWindowConsignProcessOrderMgr(
			WindowConsignProcessOrderMgr windowConsignProcessOrderMgr) {
		this.windowConsignProcessOrderMgr = windowConsignProcessOrderMgr;
	}

	public List<GoodsInfoPo> getAlertgoodsList() {
		return alertgoodsList;
	}

	public void setAlertgoodsList(List<GoodsInfoPo> alertgoodsList) {
		this.alertgoodsList = alertgoodsList;
	}

	public StockSearchMgr getStockSearchMgr() {
		return stockSearchMgr;
	}

	public void setStockSearchMgr(StockSearchMgr stockSearchMgr) {
		this.stockSearchMgr = stockSearchMgr;
	}

	public DelayWarningPo getDelayWarningPo() {
		return delayWarningPo;
	}

	public void setDelayWarningPo(DelayWarningPo delayWarningPo) {
		this.delayWarningPo = delayWarningPo;
	}

	public List<DelayWarningPo> getDelayWarningPos() {
		return delayWarningPos;
	}

	public void setDelayWarningPos(List<DelayWarningPo> delayWarningPos) {
		this.delayWarningPos = delayWarningPos;
	}

	public DelayWarningMgr getDelayWarningMgr() {
		return delayWarningMgr;
	}

	public void setDelayWarningMgr(DelayWarningMgr delayWarningMgr) {
		this.delayWarningMgr = delayWarningMgr;
	}

	public List<NoticePo> getNoticeTypeList() {
		return noticeTypeList;
	}

	public void setNoticeTypeList(List<NoticePo> noticeTypeList) {
		this.noticeTypeList = noticeTypeList;
	}

	public List<NoticeFilePo> getNoticeFileList() {
		return noticeFileList;
	}

	public void setNoticeFileList(List<NoticeFilePo> noticeFileList) {
		this.noticeFileList = noticeFileList;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public InputStream getInputStream() {
		return inputStream;
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

	/**
	 * 加载公告查询页
	 */
	public String initNoticeSel() throws Exception {

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

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")) {
			this.setIsFirstExec("1");
			return "selNotice";
		}

		noticeTypeList = noticeMgr.getNoticeTypeList();

		return SUCCESS;
	}

	/**
	 * 查询公告信息
	 */
	public String selNotice() throws Exception {

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

		String bnesearchtitle = Utility.getName(
				request.getParameter("bnesearchtitle")).trim();
		String bnesearchpublishdatebegin = Utility.getName(
				request.getParameter("bnesearchpublishdatebegin")).trim();
		String bnesearchpublishdateend = Utility.getName(
				request.getParameter("bnesearchpublishdateend")).trim();
		String bnesearchpublishperson = Utility.getName(
				request.getParameter("bnesearchpublishperson")).trim();
		String noticeTypeID = Utility.getName(
				request.getParameter("noticeTypeID")).trim();

		NoticePo po = new NoticePo();
		po.setBnesearchtitle(bnesearchtitle);
		po.setBnesearchpublishdatebegin(bnesearchpublishdatebegin);
		po.setBnesearchpublishdateend(bnesearchpublishdateend);
		po.setBnesearchpublishperson(bnesearchpublishperson);
		po.setBnetypeid(noticeTypeID);
		if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
			po.setBnecompanyid(personInfoPo.getPersoncompanyid());
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		if (Utility.getName(request.getParameter("isFirstExec")).equals("1")) {
			this.setIsFirstExec("0");
			request.setAttribute("showhider", (Utility.getName(
					systemParameterPo.getFspshowchange()).equals("3") ? "0"
					: "2"));
		} else {
			String showchange = Utility.getName(systemParameterPo
					.getFspselectovershowchange());
			if (showchange.equals("0")) {
				request.setAttribute("showhider", "0");
			} else {
				request.setAttribute("showhider", "2");
			}
		}

		int count = noticeMgr.selectNoticeCount(po);
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
			noticePos = noticeMgr.selectNoticeList(po, page.getStart(), page
					.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			noticePos = null;
		}

		request.setAttribute("bnesearchtitle", bnesearchtitle);
		request.setAttribute("bnesearchpublishdatebegin",
				bnesearchpublishdatebegin);
		request
				.setAttribute("bnesearchpublishdateend",
						bnesearchpublishdateend);
		request.setAttribute("bnesearchpublishperson", bnesearchpublishperson);
		request.setAttribute("noticeTypeID", noticeTypeID);

		noticeTypeList = noticeMgr.getNoticeTypeList();

		return SUCCESS;
	}

	public String initNoticeStore() throws Exception {

		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		request
				.setAttribute("departmenttype", personInfoPo
						.getDepartmenttype());
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */

		List<String> loadlist = new ArrayList<String>();

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		// --------------取得个人提醒范围id-----------------------------------------
		PersonSetOptionPo personSetOptionPo = personSetOptionMgr
				.selectPersonSetOptionPo(createPerson);
		request.setAttribute("personSetOptionPo", personSetOptionPo);
		String personReminderWindowid = "";
		String tmpPersonReminderWindowid = Utility.getName(personSetOptionPo
				.getFpsoreminderwindowid());
		String[] personReminderWindowidArray = tmpPersonReminderWindowid
				.split("-");// 分割不同部门类型的提醒信息设置内容
		for (int i = 0; i < personReminderWindowidArray.length; i++) {
			// 如果登陆部门类型与循环中该部门类型相同，就赋值；
			if (personReminderWindowidArray[i].split(":")[0]
					.equals(personInfoPo.getDepartmenttype())) {
				personReminderWindowid = personReminderWindowidArray[i]
						.split(":")[1];
				personReminderWindowid = personReminderWindowid.substring(1,
						personReminderWindowid.length() - 1);
			}
		}

		List<ReminderWindowPo> departmentTypeAndRoleReminderwindowList = reminderWindowMgr
				.getJiaojiReminderWindowsByDepartmenttypeidAndRoleid(
						personInfoPo.getDepartmenttype(), personInfoPo
								.getRoleid());

		if (personReminderWindowid.equals("")
				&& departmentTypeAndRoleReminderwindowList != null
				&& departmentTypeAndRoleReminderwindowList.size() > 0) {
			Iterator<ReminderWindowPo> it = departmentTypeAndRoleReminderwindowList.iterator();
			while (it.hasNext()) {
				if ("".equals(personReminderWindowid)) {
					personReminderWindowid = ((ReminderWindowPo) it.next())
							.getFrwsid();
				} else {
					personReminderWindowid = personReminderWindowid + ","
							+ ((ReminderWindowPo) it.next()).getFrwsid();
				}
			}
		}
		// --------------取得个人提醒范围id-----------------------------------------

		NoticePo noticetypePo = new NoticePo();
		noticetypePo.setBnetypeid("");
		noticetypePo.setBnetypename("");
		List<String> noticecount = new ArrayList<String>();
		List<NoticePo> noticetypepos = noticeMgr.getNoticeTypeList(
				noticetypePo, 0, 1000);
		List<List<NoticePo>> noticetypeposs = new ArrayList<List<NoticePo>>();
		for (int i = 0; i < noticetypepos.size(); i++) {
			NoticePo po = new NoticePo();
			po.setBnedepartmentid(personInfoPo.getDepartmentID());
			po.setBneauditstate("1");
			po.setBneflag("1");
			po.setBnetypeid(noticetypepos.get(i).getBnetypeid());
			if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
				po.setBnecompanyid(personInfoPo.getPersoncompanyid());
			}
			
			noticePos = noticeMgr.selectNoticeList(po, 0, 4);
			if (noticePos.size() > 0) {
				noticecount.add(noticeMgr.selectNoticeCount(po) + "");
				noticetypeposs.add(noticePos);
				loadlist.add("notice");
			}

		}
		request.setAttribute("noticetypeposs", noticetypeposs);
		request.setAttribute("noticecount", noticecount);

		String[] tmpPersonReminderWindowidArray = personReminderWindowid
				.split(",");
		for (int i = 0; i < tmpPersonReminderWindowidArray.length; i++) {
			// -----------------委外预误期查询----------------------
			if("1".equals(tmpPersonReminderWindowidArray[i])){
				PersonPermissionPo tdelayWarningPermissionPo = new PersonPermissionPo();
				tdelayWarningPermissionPo.setApplicationID("1");
				tdelayWarningPermissionPo.setModuleID("S0507"); 
				tdelayWarningPermissionPo.setPersonID(createPerson);

				PersonPermissionPo delayWarningPermissionPo = personPermissionMgr
						.getPersonPermission(tdelayWarningPermissionPo);

				if (delayWarningPermissionPo.getModuleName() != null) {
					delayWarningPo = delayWarningMgr.selectDelayWarningPo();
					delayWarningPo.setBdwqshopcodeid(personInfoPo.getDepartmentID());
					
					int delaywarningcount = delayWarningMgr.selectDelayWarningCount(delayWarningPo);
					
					request.setAttribute("delaywarningcount", delaywarningcount);

					if (delaywarningcount > 0) {
						loadlist.add("delaywarning");
					}
				}				
			}
			// -----------------委外预误期查询----------------------			

			// -----------------隐形效期查询------------------------	
			if("2".equals(tmpPersonReminderWindowidArray[i])){
				PersonPermissionPo tinvisiblePermissionPo = new PersonPermissionPo();
				tinvisiblePermissionPo.setApplicationID("1");
				tinvisiblePermissionPo.setModuleID("C0102");
				tinvisiblePermissionPo.setPersonID(createPerson);

				PersonPermissionPo invisiblePermissionPo = personPermissionMgr.getPersonPermission(tinvisiblePermissionPo);

				if (invisiblePermissionPo.getModuleName() != null && !systemParameterPo.getFspstealtheffective().equals("0")) {
					
					DepartmentsPo dpo = new DepartmentsPo();
					if (!personInfoPo.getDepartmenttype().equals("3")){
						dpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
					}
					WarehousePo wpo = warehouseMgr.getWarehousePo(dpo);
					
					List<WarehousePo> warehouselist = this.getWarehouseListByCompany(systemParameterPo, personInfoPo);
					
					GoodsDetailsInfoPo goodspoyxjgq = new GoodsDetailsInfoPo();
					goodspoyxjgq.setSmecistocklist(warehouselist);
					
					goodspoyxjgq.setSxhGoodsCategoryID("4");
					goodspoyxjgq.setSxhinvisibletype("3");
					goodspoyxjgq.setViewType("0");
					goodspoyxjgq.setSxhStockID(Utility.getName(wpo.getBwhid()));

					Map<String, Object> goodsNumsyxjgq = stockSearchMgr.getStockSearchInvisibleCount(goodspoyxjgq);
					String yxjgqcount = goodsNumsyxjgq.get("titlenum").toString();

					request.setAttribute("yxjgqcount", yxjgqcount);

					GoodsDetailsInfoPo goodspoyxgq = new GoodsDetailsInfoPo();
					goodspoyxgq.setSmecistocklist(warehouselist);
					goodspoyxgq.setSxhGoodsCategoryID("4");
					goodspoyxgq.setSxhinvisibletype("4");
					goodspoyxgq.setViewType("0");
					goodspoyxgq.setSxhStockID(Utility.getName(wpo.getBwhid()));

					Map<String, Object> goodsNumsyxgq = stockSearchMgr.getStockSearchInvisibleCount(goodspoyxgq);
					String yxgqcount = goodsNumsyxgq.get("titlenum").toString();

					request.setAttribute("yxgqcount", yxgqcount);

					GoodsDetailsInfoPo goodspohlyjgq = new GoodsDetailsInfoPo();
					goodspohlyjgq.setSmecistocklist(warehouselist);
					goodspohlyjgq.setSxhGoodsCategoryID("5");
					goodspohlyjgq.setSxhinvisibletype("3");
					goodspohlyjgq.setViewType("0");
					goodspohlyjgq.setSxhStockID(Utility.getName(wpo.getBwhid()));

					Map<String, Object> goodsNumshlyjgq = stockSearchMgr.getStockSearchInvisibleCount(goodspohlyjgq);

					String hlyjgqcount = goodsNumshlyjgq.get("titlenum").toString();

					request.setAttribute("hlyjgqcount", hlyjgqcount);

					GoodsDetailsInfoPo goodspohlygq = new GoodsDetailsInfoPo();
					goodspohlygq.setSmecistocklist(warehouselist);
					goodspohlygq.setSxhGoodsCategoryID("5");
					goodspohlygq.setSxhinvisibletype("4");
					goodspohlygq.setViewType("0");
					goodspohlygq.setSxhStockID(Utility.getName(wpo.getBwhid()));
					
					Map<String, Object> goodsNumshlygq = stockSearchMgr.getStockSearchInvisibleCount(goodspohlygq);

					String hlygqcount = goodsNumshlygq.get("titlenum").toString();

					request.setAttribute("hlygqcount", hlygqcount);

					if (Integer.parseInt(yxjgqcount) > 0
							|| Integer.parseInt(yxgqcount) > 0
							|| Integer.parseInt(hlygqcount) > 0
							|| Integer.parseInt(hlygqcount) > 0) {
						loadlist.add("invisible");
					}
				}				
			}
			// -----------------隐形效期查询------------------------			

			// -----------------库存量预警查询----------------------
			if( "3".equals(tmpPersonReminderWindowidArray[i])){
				PersonPermissionPo talertPermissionPo = new PersonPermissionPo();
				talertPermissionPo.setApplicationID("1");
				talertPermissionPo.setModuleID("C0109");
				talertPermissionPo.setPersonID(createPerson);

				PersonPermissionPo alertPermissionPo = personPermissionMgr
						.getPersonPermission(talertPermissionPo);

				if (alertPermissionPo.getModuleName() != null) {
					GoodsInfoPo alertgoodspo = new GoodsInfoPo();
					alertgoodspo.setAlerttype("4");
					alertgoodspo.setBgidepartmentid(personInfoPo.getDepartmentID());
					alertgoodspo.setBgidepartmenttype(personInfoPo.getDepartmenttype());
					if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
						alertgoodspo.setBgicompanyid(personInfoPo.getPersoncompanyid());
					}
					
					int alertcount = stockSearchMgr.getStockAlertCount(alertgoodspo);

					request.setAttribute("alertcount", alertcount);

					if (alertcount > 0) {
						loadlist.add("alert");
					}
				}				
			}
			// -----------------库存量预警查询----------------------	

			// -----------------委外订单管理------------------------
			if("4".equals(tmpPersonReminderWindowidArray[i])){
				PersonPermissionPo tconsignprocessorderPermissionPo = new PersonPermissionPo();
				tconsignprocessorderPermissionPo.setApplicationID("1");
				tconsignprocessorderPermissionPo.setModuleID("C0205"); // 委外订单管理
				tconsignprocessorderPermissionPo.setPersonID(createPerson);

				PersonPermissionPo consignprocessorderPermissionPo = personPermissionMgr
						.getPersonPermission(tconsignprocessorderPermissionPo);

				if (consignprocessorderPermissionPo.getModuleName() != null) {
					SalesBasicPo consignprocessordersalesbasicpo = new SalesBasicPo();
					consignprocessordersalesbasicpo.setSsesbsupplierid("");
					consignprocessordersalesbasicpo.setSsesbsalesid("");
					consignprocessordersalesbasicpo.setSsesbshopcode("");
					consignprocessordersalesbasicpo.setSsesborderstype("");
					consignprocessordersalesbasicpo.setSsesbsalesdatestarttime("");
					consignprocessordersalesbasicpo.setSsesbsalesdateendtime("");
					consignprocessordersalesbasicpo.setSsesbtakeglassstartdata("");
					consignprocessordersalesbasicpo.setSsesbtakeglassenddata("");
					consignprocessordersalesbasicpo.setSsesbgoodsname("");
					if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
						consignprocessordersalesbasicpo.setSsesbcompanyid(personInfoPo.getPersoncompanyid());
					}
										
					int consignprocessordercount = windowConsignProcessOrderMgr.getSalesBasicForConsignProcessCount1(consignprocessordersalesbasicpo);

					request.setAttribute("consignprocessordercount",consignprocessordercount);

					if (consignprocessordercount > 0) {
						loadlist.add("consignprocessorder");
					}
				}				
			}
			// -----------------委外订单管理------------------------

			// -----------------商品调拨----------------------------
			if("7".equals(tmpPersonReminderWindowidArray[i])){
				PersonPermissionPo tallocationPermissionPo = new PersonPermissionPo();
				tallocationPermissionPo.setApplicationID("1");
				tallocationPermissionPo.setModuleID("C0104"); // 商品调拨
				tallocationPermissionPo.setPersonID(createPerson);

				PersonPermissionPo allocationPermissionPo = personPermissionMgr
						.getPersonPermission(tallocationPermissionPo);

				if (allocationPermissionPo.getModuleName() != null) {
					AllocationPo allocationPo = new AllocationPo();
					allocationPo.setCshaabillid("");
					allocationPo.setCshaaindepartmentid(personInfoPo.getDepartmentID());
					allocationPo.setCshaaoutdepartmentid("");
					allocationPo.setCshaastartTime("");
					allocationPo.setCshaaendTime("");
					allocationPo.setCshaaauditstate("1");
					allocationPo.setCshaaconsignstate("0");
					allocationPo.setCshaacreateperson("");
					allocationPo.setCshaaauditperson("");
					allocationPo.setCshaaconsignee("");
					allocationPo.setCshaaflag("1");// 正调拨
					allocationPo.setChaasupplier("");// 制造商代码
					allocationPo.setChaabrand("");// 品种代码
					allocationPo.setChaagoodsname("");// 商品名称
					allocationPo.setCshaaremark("");
					allocationPo.setChaaautoflag("");
					if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
						allocationPo.setCshaaindptcompanyid(personInfoPo.getPersoncompanyid());
					}

					DepartmentsPo deppo = new DepartmentsPo();
					deppo.setBdpdepartmentid(personInfoPo.getDepartmentID());
					deppo.setBdptype(personInfoPo.getDepartmenttype());

					int allocationcount = allocationMgr.getAllocationCount(allocationPo, deppo);

					request.setAttribute("allocationcount", allocationcount);

					if (allocationcount > 0) {
						loadlist.add("allocation");
					}
				}				
			}
			// -----------------商品调拨----------------------------			

			// -----------------不合格品管理------------------------
			if("5".equals(tmpPersonReminderWindowidArray[i])){
				PersonPermissionPo tnonconformingPermissionPo = new PersonPermissionPo();
				tnonconformingPermissionPo.setApplicationID("1");
				tnonconformingPermissionPo.setModuleID("C0501"); // 不合格品管理
				tnonconformingPermissionPo.setPersonID(createPerson);

				PersonPermissionPo nonconformingPermissionPo = personPermissionMgr
						.getPersonPermission(tnonconformingPermissionPo);

				if (nonconformingPermissionPo.getModuleName() != null) {
					NonconformingPo nonconformingPo = new NonconformingPo();
					nonconformingPo.setCshanbillid("");
					nonconformingPo.setCshanstartTime("");
					nonconformingPo.setCshanendTime("");
					nonconformingPo.setCshanconsignmode("");
					nonconformingPo.setCshandepartmentid("");
					nonconformingPo.setCshanauditstate("notdo");
					nonconformingPo.setCshancreatepersonname("");
					nonconformingPo.setCshancreateperson("");
					nonconformingPo.setCshanauditpersonname("");
					nonconformingPo.setCshanauditperson("");
					nonconformingPo.setCshansupplierid("");
					nonconformingPo.setCshanbrandid("");
					nonconformingPo.setCshandepartmentname("");
					nonconformingPo.setIscustomize("");
					nonconformingPo.setCshanlinkbillID("");
					if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
						nonconformingPo.setCshancompanyid(personInfoPo.getPersoncompanyid());
					}

					int nonconformingcount = nonconformingMgr.getNonconformingCount(nonconformingPo);

					request.setAttribute("nonconformingcount", nonconformingcount);

					if (nonconformingcount > 0) {
						loadlist.add("nonconforming");
					}
				}				
			}
			// -----------------不合格品管理------------------------
			
			// -----------------昨日销售金额------------------------			
			String totalType = Utility.getName(systemParameterPo.getFspcustomamount());
			request.setAttribute("totalType", totalType);
			if (("1".equals(personInfoPo.getDepartmenttype()) || "3".equals(personInfoPo.getDepartmenttype())) && "8".equals(tmpPersonReminderWindowidArray[i])) {
				
				int storesSalesCount = 0;
				if ("1".equals(personInfoPo.getDepartmenttype())) {
					String departmentID = personInfoPo.getDepartmentID();
					storesSalesCount = noticeMgr.getStoresSalesAmountCount(departmentID, totalType,"");

					storesSalesList = noticeMgr.getStoresSalesAmountList(departmentID, totalType,"");
				} else {
					
					String companyID = "";
					if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
						companyID = personInfoPo.getPersoncompanyid();
					}					
					
					storesSalesCount = noticeMgr.getStoresSalesAmountCount(null, totalType,companyID);

					storesSalesList = noticeMgr.getStoresSalesAmountList(null,totalType,companyID);
				}

				request.setAttribute("storesSalesCount", storesSalesCount);

				if (storesSalesCount > 0) {
					loadlist.add("storesSales");
				}
			}
			// -----------------昨日销售金额------------------------				

			// -----------------调拨申请----------------------------		
			if("6".equals(tmpPersonReminderWindowidArray[i])){
				PersonPermissionPo tAllocationForAppPermissionPo = new PersonPermissionPo();
				tAllocationForAppPermissionPo.setApplicationID("1");
				tAllocationForAppPermissionPo.setModuleID("C0112"); // 调拨申请
				tAllocationForAppPermissionPo.setPersonID(createPerson);

				PersonPermissionPo allocationForAppPermissionPo = personPermissionMgr
						.getPersonPermission(tAllocationForAppPermissionPo);

				if (allocationForAppPermissionPo.getModuleName() != null) {
					AllocationPo allocationPo = new AllocationPo();
					allocationPo.setCshaaauditstate("1");
					allocationPo.setCshaaflag("1");// 正调拨
					allocationPo.setIsWriteoffs("0");
					allocationPo.setCshaaoutdepartmentid(personInfoPo.getDepartmentID());
					if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
						allocationPo.setCshaaindptcompanyid(personInfoPo.getPersoncompanyid());
					}				
					
					int allocationAppCount = windowGoodsMgr.getGoodsSingleAllCountForApp(allocationPo);

					request.setAttribute("allocationAppCount", allocationAppCount);

					if (allocationAppCount > 0) {
						loadlist.add("allocationListForApp");
					}
				}				
			}
			// -----------------调拨申请----------------------------		
			
			// -----------------未收货采购订单----------------------		
			if("9".equals(tmpPersonReminderWindowidArray[i])){
				PersonPermissionPo tProcurementWaitForAppPermissionPo = new PersonPermissionPo();
				tProcurementWaitForAppPermissionPo.setApplicationID("1");
				tProcurementWaitForAppPermissionPo.setModuleID("C0202"); // 未收货采购订单
				tProcurementWaitForAppPermissionPo.setPersonID(createPerson);

				PersonPermissionPo procurementWaitForAppPermissionPo = personPermissionMgr
						.getPersonPermission(tProcurementWaitForAppPermissionPo);

				if (procurementWaitForAppPermissionPo.getModuleName() != null) {

					ProcurementOrdersPo procurementOrdersPo = new ProcurementOrdersPo();
					if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
						procurementOrdersPo.setCstpcompanyid(personInfoPo.getPersoncompanyid());
					}
					
					int procurementOrdersAppCount = procurementWaitMgr.getProcurementWaitCount(procurementOrdersPo);

					request.setAttribute("procurementOrdersAppCount", procurementOrdersAppCount);

					if (procurementOrdersAppCount > 0) {
						loadlist.add("procurementWait");
					}
				}				
			}
			// -----------------未收货采购订单----------------------
			
			// -----------------预误期----------------------	
			if("10".equals(tmpPersonReminderWindowidArray[i])){
				PersonPermissionPo tDelaysReminderForAppPermissionPo = new PersonPermissionPo();
				tDelaysReminderForAppPermissionPo.setApplicationID("1");
				tDelaysReminderForAppPermissionPo.setModuleID("S0514"); // 未通知误期提醒
				tDelaysReminderForAppPermissionPo.setPersonID(createPerson);

				PersonPermissionPo delaysReminderForAppPermissionPo = personPermissionMgr
						.getPersonPermission(tDelaysReminderForAppPermissionPo);

				if (delaysReminderForAppPermissionPo.getModuleName() != null) {

					DelaysReminderPo delaysReminderPo = new DelaysReminderPo();
					delaysReminderPo.setSsedrshopcode(personInfoPo.getDepartmentID());
					delaysReminderPo.setSsedrdepartmenttype(personInfoPo.getDepartmenttype());
					if (Utility.getName(personInfoPo.getPersoncompanytype()).equals("2")){
						delaysReminderPo.setSsedrcompanyid(personInfoPo.getPersoncompanyid());
					}
					
					int delaysReminderAppCount = delaysReminderMgr.getDelaysRemindertCount(delaysReminderPo);

					request.setAttribute("delaysReminderAppCount", delaysReminderAppCount);

					if (delaysReminderAppCount > 0) {
						loadlist.add("delaysReminder");
					}
				}				
			}
			// -----------------预误期----------------------			
		}
		request.setAttribute("loadlist", loadlist);
		return SUCCESS;
	}

	/**
	 * 公告通知查询
	 */
	public String selNoticeStore() throws Exception {

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

		String noticeTypeID = Utility.getName(request
				.getParameter("noticeTypeID"));

		NoticePo po = new NoticePo();
		po.setBnedepartmentid(personInfoPo.getDepartmentID());
		po.setBneauditstate("1");
		po.setBneflag("1");
		po.setBnetypeid(noticeTypeID);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());

		int count = noticeMgr.selectNoticeCount(po);
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
			noticePos = noticeMgr.selectNoticeList(po, page.getStart(), page
					.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			noticePos = null;
		}

		return SUCCESS;
	}

	/**
	 * 加载公告信息open
	 */
	public String selNoticeMessage() throws Exception {

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

		NoticePo po = new NoticePo();
		po.setBnedepartmentid(personInfoPo.getDepartmentID());

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());

		int count = noticeMgr.selectNoticeCount(po);
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
			noticePos = noticeMgr.selectNoticeList(po, page.getStart(), page
					.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			noticePos = null;
		}

		return SUCCESS;
	}

	/**
	 * 加载新增公告信息
	 */
	public String initInsertNotice() throws Exception {

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

		Calendar date = Calendar.getInstance();
		SimpleDateFormat datefont = new SimpleDateFormat("yyyy-MM-dd hh:mm");

		request.setAttribute("date", datefont.format(date.getTime()));
		request.setAttribute("personname", personInfoPo.getPersonName());

		noticePos = noticeMgr.getNoticeTypeList();

		return SUCCESS;
	}

	/**
	 * 插入公告查询页
	 */
	public String insertNotice() throws Exception {

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
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("1"); // 表示状态
		logPo.setsLogContent("公告:" + noticePo.getBnetitle() + "新增!");

		noticePo.setBneaddhtml(Utility.getName(request.getParameter("content")));
		noticePo.setBnepublishperson(createPerson);
		noticePo.setBnecompanyid(personInfoPo.getPersoncompanyid());

		noticeMgr.insertNotice(noticePo, upload, ServletActionContext
				.getServletContext().getRealPath(this.getSavePath()), this
				.getUploadFileName(), this.getUploadContentType(), logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 加载公告信息
	 */
	public String initUpdateNotice() throws Exception {

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
		String bneuuid = Utility.getName(request.getParameter("bneuuid"))
				.trim();

		NoticePo po = new NoticePo();
		po.setBneuuid(bneuuid);

		noticePo = noticeMgr.selectNoticePo(po);
		List<DepartmentsPo> dps = noticeMgr.getDepartmentsList(noticePo
				.getBnedepartmentid());
		StringBuffer departmentNames = new StringBuffer();

		for (DepartmentsPo departmentsPo : dps) {
			departmentNames.append(departmentsPo.getBdpdepartmentname() + ",");
		}
		if (departmentNames.length() - 1 > 0) {
			departmentNames.deleteCharAt(departmentNames.length() - 1);
		}

		String departmentName = departmentNames.toString();
		noticePo.setBnedepartmentname(departmentName);

		noticePos = noticeMgr.getNoticeTypeList();

		return SUCCESS;
	}

	/**
	 * 更新公告信息
	 */
	public String updateNotice() throws Exception {

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
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("1"); // 表示状态
		logPo.setsLogContent("公告:" + noticePo.getBnetitle() + "更新!");

		noticePo
				.setBneaddhtml(Utility.getName(request.getParameter("content")));
		noticePo.setBnepublishperson(createPerson);

		noticeMgr.updateNotice(noticePo, upload, ServletActionContext
				.getServletContext().getRealPath(this.getSavePath()), this
				.getUploadFileName(), this.getUploadContentType(), logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 加载删除公告信息
	 */
	public String initDeleteNotice() throws Exception {

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

		String bneuuid = Utility.getName(request.getParameter("bneuuid"))
				.trim();
		String bnetitle = Utility.getName(request.getParameter("bnetitle"))
				.trim();

		request.setAttribute("bneuuid", bneuuid);
		request.setAttribute("bnetitle", bnetitle);

		return SUCCESS;
	}

	/**
	 * 删除公告信息
	 */
	public String deleteNotice() throws Exception {

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

		String bneuuid = Utility.getName(request.getParameter("bneuuid"))
				.trim();
		NoticePo po = new NoticePo();
		po.setBneuuid(bneuuid);

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("公告:" + bneuuid + "删除!");

		noticeMgr.deleteNotice(po, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 加载公告信息
	 */
	public String initDetailsNotice() throws Exception {

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
		String bneuuid = Utility.getName(request.getParameter("bneuuid"))
				.trim();

		NoticePo po = new NoticePo();
		po.setBneuuid(bneuuid);
		noticePo = noticeMgr.selectNoticePo(po);
		noticeFileList = noticeMgr.selectNoticeFile(po);
		for (int i = 0; noticeFileList != null && i < noticeFileList.size(); i++) {
			File file = new File(ServletActionContext.getServletContext()
					.getRealPath(this.getSavePath())
					+ File.separator
					+ Utility
							.getName(noticeFileList.get(i).getBnfdocumenturl()));
			if (file.exists() && file.isFile()) {
				noticeFileList.get(i).setBnfdocumenturl(
						(this.getSavePath() + File.separator + Utility
								.getName(noticeFileList.get(i)
										.getBnfdocumenturl())).replace("\\",
								"/"));
			} else {
				noticeFileList.get(i).setBnfdocumenturl("");
			}
		}

		int fsppageno = 0;
		int count = 0;
		if (Utility.getName(noticePo.getBneauditstate()).equals("1")) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
			count = noticeMgr.getViewNoticePersonCount(po);
		}

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
			personInfoPos = noticeMgr.getPersonList(po, page.getStart(), page
					.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			personInfoPos = null;
		}

		po.setBnedepartmentid(noticePo.getBnedepartmentid());
		List<DepartmentsPo> dps = noticeMgr.getDepartmentsList(noticePo
				.getBnedepartmentid());
		StringBuffer departmentNames = new StringBuffer();

		for (DepartmentsPo departmentsPo : dps) {
			departmentNames.append(departmentsPo.getBdpdepartmentname() + ",");
		}
		if (departmentNames.length() - 1 > 0) {
			departmentNames.deleteCharAt(departmentNames.length() - 1);
		}

		String departmentName = departmentNames.toString();
		noticePo.setBnedepartmentname(departmentName);

		return SUCCESS;
	}

	/**
	 * 加载公告信息
	 */
	public String initDetailsNoticeStore() throws Exception {

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
		String bneuuid = Utility.getName(request.getParameter("bneuuid"))
				.trim();

		NoticePo po = new NoticePo();
		po.setBneuuid(bneuuid);

		noticePo = noticeMgr.selectNoticePo(po);
		noticeFileList = noticeMgr.selectNoticeFile(po);
		for (int i = 0; noticeFileList != null && i < noticeFileList.size(); i++) {
			File file = new File(ServletActionContext.getServletContext()
					.getRealPath(this.getSavePath())
					+ File.separator
					+ Utility
							.getName(noticeFileList.get(i).getBnfdocumenturl()));
			if (file.exists() && file.isFile()) {
				noticeFileList.get(i).setBnfdocumenturl(
						(this.getSavePath() + File.separator + Utility
								.getName(noticeFileList.get(i)
										.getBnfdocumenturl())).replace("\\",
								"/"));
			} else {
				noticeFileList.get(i).setBnfdocumenturl("");
			}
		}

		NoticeStaffViewPo noticeStaffViewPo = new NoticeStaffViewPo();
		noticeStaffViewPo.setBnsvnoticeid(po.getBneuuid());
		noticeStaffViewPo.setBnsvpersonid(personInfoPo.getId());
		if (noticeMgr.getNoticeStaffViewCount(noticeStaffViewPo) > 0) {
			noticeMgr.updateNoticeStaffView(noticeStaffViewPo);
		} else {
			noticeMgr.insertNoticeStaffViewPo(noticeStaffViewPo);
		}

		po.setBnedepartmentid(noticePo.getBnedepartmentid());
		List<DepartmentsPo> dps = noticeMgr.getDepartmentsList(noticePo
				.getBnedepartmentid());
		StringBuffer departmentNames = new StringBuffer();

		for (DepartmentsPo departmentsPo : dps) {
			departmentNames.append(departmentsPo.getBdpdepartmentname() + ",");
		}
		if (departmentNames.length() - 1 > 0) {
			departmentNames.deleteCharAt(departmentNames.length() - 1);
		}

		String departmentName = departmentNames.toString();
		noticePo.setBnedepartmentname(departmentName);

		return SUCCESS;
	}

	/**
	 * 下载附件
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exportNoticeFile() throws Exception {
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
		String bnfuuid = Utility.getName(request.getParameter("bnfuuid"))
				.trim();
		NoticeFilePo po = new NoticeFilePo();
		po.setBnfuuid(bnfuuid);
		po = noticeMgr.selectNoticeFile(po);

		fileName = po.getBnfsavefilename();
		this.contentType = po.getBnfcontenttype();

		inputStream = new FileInputStream(ServletActionContext
				.getServletContext().getRealPath(this.getSavePath())
				+ File.separator + Utility.getName(po.getBnfdocumenturl()));

		return SUCCESS;
	}

	/**
	 * 初始化删除下载附件
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initNoticeFileDelete() throws Exception {
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

		String bnfuuid = Utility.getName(request.getParameter("bnfuuid"))
				.trim();
		String title = Utility.getName(request.getParameter("title")).trim();
		request.setAttribute("bnfuuid", bnfuuid);
		request.setAttribute("title", title);

		return SUCCESS;
	}

	/**
	 * 删除下载附件
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteNoticeFile() throws Exception {
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

		String bnfuuid = Utility.getName(request.getParameter("bnfuuid"))
				.trim();
		String title = Utility.getName(request.getParameter("title")).trim();

		NoticeFilePo po = new NoticeFilePo();
		po.setBnfuuid(bnfuuid);

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("2"); // 表示状态
		logPo.setsLogContent("公告附件:" + title + "删除!");

		noticeMgr.deleteNoticeFile(po, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化审核公告
	 */
	public String initAuditNotice() throws Exception {

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
		String bneuuid = Utility.getName(request.getParameter("bneuuid"))
				.trim();

		NoticePo po = new NoticePo();
		po.setBneuuid(bneuuid);
		noticePo = noticeMgr.selectNoticePo(po);
		noticeFileList = noticeMgr.selectNoticeFile(po);

		po.setBnedepartmentid(noticePo.getBnedepartmentid());
		List<DepartmentsPo> dps = noticeMgr.getDepartmentsList(noticePo
				.getBnedepartmentid());
		StringBuffer departmentNames = new StringBuffer();

		for (DepartmentsPo departmentsPo : dps) {
			departmentNames.append(departmentsPo.getBdpdepartmentname() + ",");
		}
		if (departmentNames.length() - 1 > 0) {
			departmentNames.deleteCharAt(departmentNames.length() - 1);
		}

		String departmentName = departmentNames.toString();
		noticePo.setBnedepartmentname(departmentName);

		return SUCCESS;
	}

	/**
	 * 审核公告
	 */
	public String auditNotice() throws Exception {

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

		String bnfuuid = Utility.getName(request.getParameter("bnfuuid"))
				.trim();
		NoticePo po = new NoticePo();
		po.setBneuuid(bnfuuid);
		po.setBnepublishperson(createPerson);

		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(createPerson);
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("公告:" + noticePo.getBnetitle() + "审核!");

		noticeMgr.updateNoticeAudit(po, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化停用启用公告
	 */
	public String initEnableNotice() throws Exception {

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

		String hid = Utility.getName(request.getParameter("hid")).trim();
		String title = Utility.getName(request.getParameter("title")).trim();
		String flag = Utility.getName(request.getParameter("flag")).trim();

		request.setAttribute("hid", hid);
		request.setAttribute("title", title);
		request.setAttribute("flag", flag);

		return SUCCESS;
	}

	/**
	 * 停用启用公告公告
	 */
	public String enableNotice() throws Exception {

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
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("公告:"
				+ Utility.getName(noticePo.getBnetitle())
				+ (Utility.getName(noticePo.getBneflag()).equals("1") ? "启用!"
						: "停用!"));

		noticeMgr.updateNoticeEnable(noticePo, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 修改公告发布部门
	 */
	public String updateNoticeDpt() throws Exception {

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
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("公告:" + Utility.getName(noticePo.getBnetitle())
				+ "修改发布部门!");

		noticeMgr.updateNoticeDpt(noticePo, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	// 对于配置中的 ${fileName}, 获得下载保存时的文件名
	public String getFileName() throws Exception {
		return new String(fileName.getBytes(), "ISO8859-1");
		// return fileName;
	}

	/**
	 * 初始化新增公告类型
	 */
	public String initNoticeTypeInsert() throws Exception {

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

		String noticeTypeID = Utility.getName(request
				.getParameter("noticeTypeID"));
		String noticeTypeName = Utility.getName(request
				.getParameter("noticeTypeName"));

		noticePo = new NoticePo();
		noticePo.setBnetypeid(noticeTypeID);
		noticePo.setBnetypename(noticeTypeName);

		return SUCCESS;
	}

	/**
	 * 新增公告类型
	 */
	public String noticeTypeInsert() throws Exception {

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
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("公告类型:"
				+ Utility.getName(noticePo.getBnetypename()) + "新增!");

		NoticePo po = noticeMgr.getNoticeTypeDetail(noticePo);
		String msg = "";
		String url = "\"initNoticeTypeInsert.action?moduleID=" + moduleID;
		if (Utility.getName(po.getBnetypeid()).equals("")) {
			noticeMgr.insertNoticeType(noticePo, logPo);
			url = url + "&noticeTypeID="
					+ Utility.getName(noticePo.getBnetypeid())
					+ "&noticeTypeName="
					+ Utility.getName(noticePo.getBnetypename());
			msg = "struts.messages.insert.sucess";
		} else {
			msg = "公告类型新增失败,类型编号重复!";
			url = url + "&noticeTypeID="
					+ Utility.getName(noticePo.getBnetypeid())
					+ "&noticeTypeName="
					+ Utility.getName(noticePo.getBnetypename());
		}
		url = url + "\"";
		this.clearMessages();
		this.addActionMessage(getText(msg));
		request.setAttribute("url", url);
		request.setAttribute("flag", GlobalConstants.MOVE);

		return SUCCESS;
	}

	/**
	 * 初始化修改公告类型
	 */
	public String initNoticeTypeUpdate() throws Exception {

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

		String noticeTypeID = Utility.getName(request
				.getParameter("noticeTypeID"));

		NoticePo po = new NoticePo();
		po.setBnetypeid(noticeTypeID);

		noticePo = noticeMgr.getNoticeTypeDetail(po);

		return SUCCESS;
	}

	/**
	 * 修改公告类型
	 */
	public String noticeTypeUpdate() throws Exception {

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
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("公告类型:" + Utility.getName(noticePo.getBnetypeid())
				+ "修改!");

		noticeMgr.updateNoticeType(noticePo, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化删除公告类型
	 */
	public String initNoticeTypeDelete() throws Exception {

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

		String noticeTypeID = Utility.getName(request
				.getParameter("noticeTypeID"));
		String noticeTypeName = Utility.getName(request
				.getParameter("noticeTypeName"));

		request.setAttribute("noticeTypeID", noticeTypeID);
		request.setAttribute("noticeTypeName", noticeTypeName);

		return SUCCESS;
	}

	/**
	 * 删除公告类型
	 */
	public String noticeTypeDelete() throws Exception {

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
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("公告类型:"
				+ Utility.getName(noticePo.getBnetypename()) + "删除!");

		noticeMgr.deleteNoticeType(noticePo, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化查询公告类型
	 */
	public String initNoticeTypeSel() throws Exception {

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

		if (Utility.getName(permissionPo.getKeyd()).equals("1")) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals(
					"1")) {
				this.setIsFirstExec("1");
				return "noticeTypeSel";
			}
		}

		return SUCCESS;
	}

	/**
	 * 查询公告类型
	 */
	public String noticeTypeSel() throws Exception {

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

		String noticeTypeID = Utility.getName(request
				.getParameter("noticeTypeID"));
		String noticeTypeName = Utility.getName(request
				.getParameter("noticeTypeName"));

		request.setAttribute("noticeTypeID", noticeTypeID);
		request.setAttribute("noticeTypeName", noticeTypeName);

		NoticePo po = new NoticePo();
		po.setBnetypeid(noticeTypeID);
		po.setBnetypename(noticeTypeName);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());

		int count = noticeMgr.getNoticeTypeCount(po);
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
			noticePos = noticeMgr.getNoticeTypeList(po, page.getStart(), page
					.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			noticePos = null;
		}

		return SUCCESS;
	}

	/***************************************************************************************************************************************/

	/**
	 * 初始化新增维修项
	 */
	public String initRepairsCostSetInsert() throws Exception {

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

		String rcid = Utility.getName(request.getParameter("rcid"));
		String rcname = Utility.getName(request.getParameter("rcname"));
		String rcinmoney = Utility.getName(request.getParameter("rcinmoney"));
		String rcoutmoney = Utility.getName(request.getParameter("rcoutmoney"));

		repairsCostPo = new RepairsCostPo();
		repairsCostPo.setFrcid(rcid);
		repairsCostPo.setFrcname(rcname);
		repairsCostPo.setFrcinmoney(rcinmoney);
		repairsCostPo.setFrcoutmoney(rcoutmoney);

		return SUCCESS;
	}

	/**
	 * 新增维修项
	 */
	public String repairsCostSetInsert() throws Exception {

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
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("维修项:"
				+ Utility.getName(repairsCostPo.getFrcname()) + "新增!");

		RepairsCostPo po = noticeMgr.getRepairsCostDetail(repairsCostPo);
		String msg = "";
		String url = "'initRepairsCostSetInsert.action?moduleID=" + moduleID;
		if (Utility.getName(po.getFrcid()).equals("")) {
			noticeMgr.insertRepairsCost(repairsCostPo, logPo);
			url = url + "&rcid=" + Utility.getName(repairsCostPo.getFrcid())
					+ "&rcname=" + Utility.getName(repairsCostPo.getFrcname())
					+ "&rcinmoney="
					+ Utility.getName(repairsCostPo.getFrcinmoney())
					+ "&rcoutmoney="
					+ Utility.getName(repairsCostPo.getFrcoutmoney());
			msg = "struts.messages.insert.sucess";
		} else {
			msg = "维修项新增失败,编号重复!";
			url = url + "&rcid=" + Utility.getName(repairsCostPo.getFrcid())
					+ "&rcname=" + Utility.getName(repairsCostPo.getFrcname())
					+ "&rcinmoney="
					+ Utility.getName(repairsCostPo.getFrcinmoney())
					+ "&rcoutmoney="
					+ Utility.getName(repairsCostPo.getFrcoutmoney());
		}
		url = url + "'";
		this.clearMessages();
		this.addActionMessage(getText(msg));
		request.setAttribute("url", url);
		request.setAttribute("flag", GlobalConstants.MOVE);

		return SUCCESS;
	}

	/**
	 * 初始化修改维修项
	 */
	public String initRepairsCostSetUpdate() throws Exception {

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

		String rcid = Utility.getName(request.getParameter("rcid"));

		repairsCostPo = new RepairsCostPo();
		repairsCostPo.setFrcid(rcid);

		repairsCostPo = noticeMgr.getRepairsCostDetail(repairsCostPo);

		return SUCCESS;
	}

	/**
	 * 修改维修项
	 */
	public String repairsCostSetUpdate() throws Exception {

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
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("维修项:"
				+ Utility.getName(repairsCostPo.getFrcname()) + "修改!");

		noticeMgr.updateRepairsCost(repairsCostPo, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.update.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化删除维修项
	 */
	public String initRepairsCostSetDelete() throws Exception {

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

		String rcid = Utility.getName(request.getParameter("rcid"));
		String rcrname = Utility.getName(request.getParameter("rcrname"));

		request.setAttribute("rcid", rcid);
		request.setAttribute("rcrname", rcrname);

		return SUCCESS;
	}

	/**
	 * 删除维修项
	 */
	public String repairsCostSetDelete() throws Exception {

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
		logPo.setsLogResult(moduleID); // 表示模块名称
		logPo.setsLogOpID("3"); // 表示状态
		logPo.setsLogContent("维修项:"
				+ Utility.getName(repairsCostPo.getFrcname()) + "删除!");

		noticeMgr.deleteRepairsCost(repairsCostPo, logPo);

		this.clearMessages();
		this.addActionMessage(getText("struts.messages.delete.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);

		return SUCCESS;
	}

	/**
	 * 初始化查询维修项
	 */
	public String initRepairsCostSetSel() throws Exception {

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

		if (Utility.getName(permissionPo.getKeyd()).equals("1")) {
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

			if (!Utility.getName(systemParameterPo.getFspshowchange()).equals(
					"1")) {
				this.setIsFirstExec("1");
				return "repairsCostSetSel";
			}
		}

		return SUCCESS;
	}

	/**
	 * 查询维修项
	 */
	public String repairsCostSetSel() throws Exception {

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

		String rcid = Utility.getName(request.getParameter("rcid"));
		String rcname = Utility.getName(request.getParameter("rcname"));

		repairsCostPo = new RepairsCostPo();
		repairsCostPo.setFrcid(rcid);
		repairsCostPo.setFrcname(rcname);

		request.setAttribute("rcid", rcid);
		request.setAttribute("rcname", rcname);

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());

		int count = noticeMgr.getRepairsCostCount(repairsCostPo);
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
			repairsCostList = noticeMgr.getRepairsCostList(repairsCostPo, page
					.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			repairsCostList = null;
		}

		return SUCCESS;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public List<NoticePo> getNoticePos() {
		return noticePos;
	}

	public void setNoticePos(List<NoticePo> noticePos) {
		this.noticePos = noticePos;
	}

	public NoticePo getNoticePo() {
		return noticePo;
	}

	public void setNoticePo(NoticePo noticePo) {
		this.noticePo = noticePo;
	}

	public NoticeMgr getNoticeMgr() {
		return noticeMgr;
	}

	public void setNoticeMgr(NoticeMgr noticeMgr) {
		this.noticeMgr = noticeMgr;
	}

	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}

	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<PersonInfoPo> getPersonInfoPos() {
		return personInfoPos;
	}

	public void setPersonInfoPos(List<PersonInfoPo> personInfoPos) {
		this.personInfoPos = personInfoPos;
	}

	public List<StoresSalesPo> getStoresSalesList() {
		return storesSalesList;
	}

	public void setStoresSalesList(List<StoresSalesPo> storesSalesList) {
		this.storesSalesList = storesSalesList;
	}

	public List<AllocationPo> getAllocationListForApp() {
		return allocationListForApp;
	}

	public void setAllocationListForApp(List<AllocationPo> allocationListForApp) {
		this.allocationListForApp = allocationListForApp;
	}

	public WindowGoodsMgr getWindowGoodsMgr() {
		return windowGoodsMgr;
	}

	public void setWindowGoodsMgr(WindowGoodsMgr windowGoodsMgr) {
		this.windowGoodsMgr = windowGoodsMgr;
	}

	public PersonSetOptionMgr getPersonSetOptionMgr() {
		return personSetOptionMgr;
	}

	public void setPersonSetOptionMgr(PersonSetOptionMgr personSetOptionMgr) {
		this.personSetOptionMgr = personSetOptionMgr;
	}

	public ReminderWindowMgr getReminderWindowMgr() {
		return reminderWindowMgr;
	}

	public void setReminderWindowMgr(ReminderWindowMgr reminderWindowMgr) {
		this.reminderWindowMgr = reminderWindowMgr;
	}

	public ProcurementWaitMgr getProcurementWaitMgr() {
		return procurementWaitMgr;
	}

	public void setProcurementWaitMgr(ProcurementWaitMgr procurementWaitMgr) {
		this.procurementWaitMgr = procurementWaitMgr;
	}

	public List<ProcurementOrdersPo> getProcurementOrdersListForApp() {
		return procurementOrdersListForApp;
	}

	public void setProcurementOrdersListForApp(
			List<ProcurementOrdersPo> procurementOrdersListForApp) {
		this.procurementOrdersListForApp = procurementOrdersListForApp;
	}

	public DelaysReminderMgr getDelaysReminderMgr() {
		return delaysReminderMgr;
	}

	public void setDelaysReminderMgr(DelaysReminderMgr delaysReminderMgr) {
		this.delaysReminderMgr = delaysReminderMgr;
	}

	public List<DelaysReminderPo> getDelaysReminderListForApp() {
		return delaysReminderListForApp;
	}

	public void setDelaysReminderListForApp(
			List<DelaysReminderPo> delaysReminderListForApp) {
		this.delaysReminderListForApp = delaysReminderListForApp;
	}

}
