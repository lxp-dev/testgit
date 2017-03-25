/**
 * 
 */
package com.pengsheng.eims.sales.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.mgr.ChuzhikaMgr;
import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.ArrearsMgr;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangeEntryPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangePo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.mgr.SalesReturnMgr;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.system.mgr.AdditionalCostsMgr;
import com.pengsheng.eims.system.mgr.BrankCardMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.AdditionalCostsPo;
import com.pengsheng.eims.system.persistence.BrankCardPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.GenerateNumber;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.weixin.mgr.WeiXinIntegralSelectMgr;
import com.pengsheng.weixin.persistence.WeiXinIntegralSelectPo;

public class IntegralExchangeManagementAction extends BaseAction {
	
	private IntegralExchangePo integralExchangePo;	
	private PersonPermissionMgr personPermissionMgr;
	private List<IntegralExchangePo> integralExchangeList;
	private List<IntegralExchangeEntryPo> integralExchangeEntryList;
	private String isFirstExec;
	private WarehouseConfigurationMgr warehouseConfigurationMgr;
	private IntegralExchangeEntryPo integralExchangeEntryPo;
	private List<IntegralExchangeEntryPo> integralExchangeEntryPolist;
	private GuitarManagementMgr guitarManagementMgr;
	private CustomerInfoMgr customerInfoMgr;
	private CustomerInfoPo customerInfoPo;
	private List<SalesBasicPo> salesBasicPos;	
	private ChuzhikaPo chuzhikaPo;	
	private ChuzhikaMgr chuzhikaMgr;	
	private SalesBasicPo salesBasicPo;	
	private ArrearsMgr arrearsMgr;	
	private List<BrankCardPo> brankCardPos;	
	private BrankCardMgr brankCardMgr;	
	private SystemParameterMgr systemParameterMgr;	
	private SystemParameterPo systemParameterPo;
	private GoodsInfoTempPo goodsInfoTempPo;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private PersonInfoMgr personInfoMgr;
	private AdditionalCostsMgr additionalCostsMgr;
	private List<AdditionalCostsPo> additionalCostsList;
	private AdditionalCDetailPo additionalCDetailPo;
	private AdditionalCostsPo additionalCostsPo;
	private List<WeiXinIntegralSelectPo> weiXinIntegralSelectPoList;
	public List<WeiXinIntegralSelectPo> getWeiXinIntegralSelectPoList() {
		return weiXinIntegralSelectPoList;
	}
	public void setWeiXinIntegralSelectPoList(
			List<WeiXinIntegralSelectPo> weiXinIntegralSelectPoList) {
		this.weiXinIntegralSelectPoList = weiXinIntegralSelectPoList;
	}
	public WeiXinIntegralSelectPo getWeiXinIntegralSelectPo() {
		return weiXinIntegralSelectPo;
	}
	public void setWeiXinIntegralSelectPo(
			WeiXinIntegralSelectPo weiXinIntegralSelectPo) {
		this.weiXinIntegralSelectPo = weiXinIntegralSelectPo;
	}
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}
	public List<WarehousePo> getWarehouseList() {
		return warehouseList;
	}
	public void setWarehouseList(List<WarehousePo> warehouseList) {
		this.warehouseList = warehouseList;
	}
	public List<DepartmentsPo> getDepartmentsList() {
		return departmentsList;
	}
	public void setDepartmentsList(List<DepartmentsPo> departmentsList) {
		this.departmentsList = departmentsList;
	}

	private WeiXinIntegralSelectPo weiXinIntegralSelectPo;
	private WarehouseMgr warehouseMgr;
	private DepartmentsMgr departmentsMgr;
	private List<WarehousePo> warehouseList;
	private List<DepartmentsPo> departmentsList;
	public AdditionalCostsPo getAdditionalCostsPo() {
		return additionalCostsPo;
	}
	public void setAdditionalCostsPo(AdditionalCostsPo additionalCostsPo) {
		this.additionalCostsPo = additionalCostsPo;
	}
	public AdditionalCDetailPo getAdditionalCDetailPo() {
		return additionalCDetailPo;
	}
	public void setAdditionalCDetailPo(AdditionalCDetailPo additionalCDetailPo) {
		this.additionalCDetailPo = additionalCDetailPo;
	}
	public AdditionalCostsMgr getAdditionalCostsMgr() {
		return additionalCostsMgr;
	}
	public void setAdditionalCostsMgr(AdditionalCostsMgr additionalCostsMgr) {
		this.additionalCostsMgr = additionalCostsMgr;
	}
	public List<AdditionalCostsPo> getAdditionalCostsList() {
		return additionalCostsList;
	}
	public void setAdditionalCostsList(List<AdditionalCostsPo> additionalCostsList) {
		this.additionalCostsList = additionalCostsList;
	}
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}
	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	private List<PersonInfoPo> personInfoPos;
	
	public List<PersonInfoPo> getPersonInfoPos() {
		return personInfoPos;
	}
	public void setPersonInfoPos(List<PersonInfoPo> personInfoPos) {
		this.personInfoPos = personInfoPos;
	}
	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}
	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
	}
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}	
	public List<IntegralExchangeEntryPo> getIntegralExchangeEntryList() {
		return integralExchangeEntryList;
	}
	public void setIntegralExchangeEntryList(
			List<IntegralExchangeEntryPo> integralExchangeEntryList) {
		this.integralExchangeEntryList = integralExchangeEntryList;
	}	
	public List<IntegralExchangePo> getIntegralExchangeList() {
		return integralExchangeList;
	}
	public void setIntegralExchangeList(
			List<IntegralExchangePo> integralExchangeList) {
		this.integralExchangeList = integralExchangeList;
	}
	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}	
	public String getIsFirstExec() {
		return isFirstExec;
	}
	public void setIsFirstExec(String isFirstExec) {
		this.isFirstExec = isFirstExec;
	}	
	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}
	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
	}	
	public IntegralExchangeEntryPo getIntegralExchangeEntryPo() {
		return integralExchangeEntryPo;
	}
	public void setIntegralExchangeEntryPo(
			IntegralExchangeEntryPo integralExchangeEntryPo) {
		this.integralExchangeEntryPo = integralExchangeEntryPo;
	}
	public IntegralExchangePo getIntegralExchangePo() {
		return integralExchangePo;
	}	
	public List<IntegralExchangeEntryPo> getIntegralExchangeEntryPolist() {
		return integralExchangeEntryPolist;
	}
	public void setIntegralExchangeEntryPolist(
			List<IntegralExchangeEntryPo> integralExchangeEntryPolist) {
		this.integralExchangeEntryPolist = integralExchangeEntryPolist;
	}
	public void setIntegralExchangePo(IntegralExchangePo integralExchangePo) {
		this.integralExchangePo = integralExchangePo;
	}
	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}
	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
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

	public List<BrankCardPo> getBrankCardPos() {
		return brankCardPos;
	}

	public void setBrankCardPos(List<BrankCardPo> brankCardPos) {
		this.brankCardPos = brankCardPos;
	}

	public BrankCardMgr getBrankCardMgr() {
		return brankCardMgr;
	}

	public void setBrankCardMgr(BrankCardMgr brankCardMgr) {
		this.brankCardMgr = brankCardMgr;
	}

	public ArrearsMgr getArrearsMgr() {
		return arrearsMgr;
	}

	public void setArrearsMgr(ArrearsMgr arrearsMgr) {
		this.arrearsMgr = arrearsMgr;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public ChuzhikaPo getChuzhikaPo() {
		return chuzhikaPo;
	}

	public void setChuzhikaPo(ChuzhikaPo chuzhikaPo) {
		this.chuzhikaPo = chuzhikaPo;
	}

	public ChuzhikaMgr getChuzhikaMgr() {
		return chuzhikaMgr;
	}

	public void setChuzhikaMgr(ChuzhikaMgr chuzhikaMgr) {
		this.chuzhikaMgr = chuzhikaMgr;
	}

	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}

	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public List<SalesBasicPo> getSalesBasicPos() {
		return salesBasicPos;
	}

	public void setSalesBasicPos(List<SalesBasicPo> salesBasicPos) {
		this.salesBasicPos = salesBasicPos;
	}
	
	/**
	 * 初始化积分兑换查询
	 */
	public String initIntegralExchangeManagementSel() throws Exception {

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
		personInfoPos = personInfoMgr.getModulePersoninfoPoList(moduleID,personInfoPo.getDepartmentID());
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "selIntegralExchangeManagementList";
		}
		return SUCCESS;
	}

	/**
	 * 查询积分兑换查询
	 */
	public String selIntegralExchangeManagementList() throws Exception {
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
		personInfoPos = personInfoMgr.getModulePersoninfoPoList(moduleID,personInfoPo.getDepartmentID());
		String memberid = Utility.getName(request.getParameter("memberid"));
		String customername = Utility.getName(request.getParameter("customername"));
		String startTime = Utility.getName(request.getParameter("startTime"));
		String endTime = Utility.getName(request.getParameter("endTime"));
		String goodsID = Utility.getName(request.getParameter("goodsID"));
		String goodsName = Utility.getName(request.getParameter("goodsName"));
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		IntegralExchangePo po = new IntegralExchangePo();
		po.setFilmemberid(memberid);
		po.setFilcustomername(customername);
		po.setFilstartdatetime(startTime);
		po.setFilenddatetime(endTime);
		po.setFilgoodsID(goodsID);
		po.setFilgoodsName(goodsName);		
		po.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
		
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
		
		
		int count = guitarManagementMgr.getIntegralExchangeCount(po);
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
			integralExchangeList = guitarManagementMgr.getIntegralExchangeList(po, page.getStart(),page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			integralExchangeList = null;
		}

		request.setAttribute("memberid", memberid);
		request.setAttribute("customername", customername);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("goodsID", goodsID);
		request.setAttribute("goodsName", goodsName);
		
		return SUCCESS;
	}
	
	/**
	 * 查询积分兑换查询
	 */
	public String selIntegralExchangeManagementDetail() throws Exception {
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

		IntegralExchangePo po = new IntegralExchangePo();
		po.setFiluuid(hid);
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		integralExchangePo = guitarManagementMgr.getIntegralExchangeDetail(po);
		
		integralExchangeEntryList = guitarManagementMgr.getIntegralExchangeDetailEntry(po);

		String goodsID = Utility.getName(request.getParameter("goodsID"));//库存综合查询，流水里面的单据明细，商品重点显示。
		request.setAttribute("goodsID", goodsID);	
		
		return SUCCESS;
	}


	public String initIntegralExchangeManagement() {
		// 得到当前登录人的部门 根据部门取出仓位
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		SalesBasicPo salesBasicPotemp = new SalesBasicPo();
		salesBasicPotemp.setSsesbposid(personInfoPo.getId());
		salesBasicPotemp.setSsesbshopcode(personInfoPo.getDepartmentID());
		
		salesBasicPo = arrearsMgr.getArrearsValues(salesBasicPotemp); 
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		return SUCCESS;
	}

	public String selIntegralExchangeManagement() {
		
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
		
		// 得到当前登录人的部门 根据部门取出仓位
		personInfoPos = personInfoMgr.getModulePersoninfoPoList(moduleID,personInfoPo.getDepartmentID());
		SalesBasicPo salesBasicPotemp = new SalesBasicPo();
		salesBasicPotemp.setSsesbposid(personInfoPo.getId());
		salesBasicPotemp.setSsesbshopcode(personInfoPo.getDepartmentID());
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		salesBasicPo = arrearsMgr.getArrearsValues(salesBasicPotemp); 
		
		String memberId = Utility.getName(request.getParameter("smecimemberid"));
		String salesid  = Utility.getName(request.getParameter("fmmsalesid"));

		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecimemberid(memberId);
		customerInfoPo.setFmmsalesid(salesid);
		customerInfoPo.setSmeciflag("1");
		customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
		
		request.setAttribute("smecimemberid", memberId);
		request.setAttribute("fmmsalesid", salesid);

		if (StringUtils.isNotEmpty(salesid)) {
			// 按配镜单号查询顾客信息
			customerInfoPo = guitarManagementMgr.getCustmorInfo(customerInfoPo);
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday().substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}

			request.setAttribute("salesID", Utility.getName(request.getParameter("salesID")));			

		} else if (StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			// 查询顾客信息
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			// 年龄
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}
		}
		
		return SUCCESS;
	}
	
	public String insertIntegralExchangeManagement() {
		
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
		
		String smecimemberid = Utility.getName(request.getParameter("smecimemberid"));
		String smecicustomerid = Utility.getName(request.getParameter("smecicustomerid"));
		String uuid = "DH"+GenerateNumber.getInstance().getGenerageNumber();

		int lenth = goodsInfoTempPo.getGoodsid().length;
		integralExchangePo = new IntegralExchangePo();
		integralExchangePo.setFiluuid(uuid);
		integralExchangePo.setFilcustomername(smecicustomerid);
		integralExchangePo.setFilmemberid(Utility.getName(smecimemberid));
		integralExchangePo.setFildepartmentid(Utility.getName(personInfoPo.getDepartmentID()));
		integralExchangePo.setFilpersonid(Utility.getName(personInfoPo.getId()));
		integralExchangePo.setFilintegralsum(Utility.getName(request.getParameter("jifen")));   //会员原有积分
		integralExchangePo.setFilrefundflag("0");  //标识积分兑换(没有退货的)
		
		WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
		tempWarehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		WarehouseConfigurationPo warehouseConfigurationPo = warehouseConfigurationMgr.getWarehouseConfiguration(tempWarehouseConfigurationPo);
		integralExchangePo.setFilstock(Utility.getName(warehouseConfigurationPo.getBwcstockid14()));   //积分兑换仓位
		
		integralExchangeEntryPolist = new ArrayList<IntegralExchangeEntryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		BigDecimal sNum = null;
		BigDecimal dNum = null;
		int count = 1;    // 负库存验证标记
		
		for (int i = 0; i < lenth; i++) {
			
			IntegralExchangeEntryPo integralExchangeEntryPo = new IntegralExchangeEntryPo();
			integralExchangeEntryPo.setFilegoodsid(goodsInfoTempPo.getGoodsid()[i]);
			integralExchangeEntryPo.setFilegoodsname(goodsInfoTempPo.getGoodsname()[i]);
			integralExchangeEntryPo.setFilegoodsnumber("1");
			integralExchangeEntryPo.setFilegoodscode(goodsInfoTempPo.getGoodsbarcode()[i]);
			integralExchangeEntryPo.setFileintegralCount(goodsInfoTempPo.getIntegralCount()[i]);
			integralExchangeEntryPo.setFileuuid(uuid);			
	
			integralExchangeEntryPolist.add(integralExchangeEntryPo);
		}
		
		if (Utility.getName(systemParameterPo.getFspsalestype()).equals("0")){ //不允许负库存销售
			
			for (int i = 0; i < integralExchangeEntryPolist.size(); i++){ 
				if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //按商品代码和商品条码及数量合并镜片
					
					BigDecimal t1 = new BigDecimal(integralExchangeEntryPolist.get(i).getFilegoodsnumber());  //累计
					for (int j = i + 1; j < integralExchangeEntryPolist.size(); j++){ 
						if (integralExchangeEntryPolist.get(i).getFilegoodsid().equals(integralExchangeEntryPolist.get(j).getFilegoodsid()) && integralExchangeEntryPolist.get(i).getFilegoodscode().equals(integralExchangeEntryPolist.get(j).getFilegoodscode())){
							t1 = t1.add(new BigDecimal(integralExchangeEntryPolist.get(j).getFilegoodsnumber()));
						}
					}
					
					int tcount = 0;
					for (int k = 0; k < inventoryEntryList.size(); k++){
						if (inventoryEntryList.get(k).getCstiegoodsid().equals(integralExchangeEntryPolist.get(i).getFilegoodsid()) && inventoryEntryList.get(k).getCstiebarcode().equals(integralExchangeEntryPolist.get(i).getFilegoodscode())){
							tcount++;
							break;
						}
					}
					if (tcount == 0){
						
						InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();			
						inventoryEntryPo.setCstiegoodsid(integralExchangeEntryPolist.get(i).getFilegoodsid());
						inventoryEntryPo.setCstiebarcode(integralExchangeEntryPolist.get(i).getFilegoodscode());
						inventoryEntryPo.setCstieoutstockid(Utility.getName(integralExchangePo.getFilstock()));
						inventoryEntryPo.setCstiegoodsquantity(t1.toString());
						
						inventoryEntryList.add(inventoryEntryPo);
					}
					
				}
				
				if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //按商品代码和数量合并镜片
					
					BigDecimal t1 = new BigDecimal(integralExchangeEntryPolist.get(i).getFilegoodsnumber());  //累计
					for (int j = i + 1; j < integralExchangeEntryPolist.size(); j++){ 
						if (integralExchangeEntryPolist.get(i).getFilegoodsid().equals(integralExchangeEntryPolist.get(j).getFilegoodsid())){
							t1 = t1.add(new BigDecimal(integralExchangeEntryPolist.get(j).getFilegoodsnumber()));
						}
					}
					
					int tcount = 0;
					for (int k = 0; k < inventoryEntryList.size(); k++){
						if (inventoryEntryList.get(k).getCstiegoodsid().equals(integralExchangeEntryPolist.get(i).getFilegoodsid())){
							tcount++;
							break;
						}
					}
					if (tcount == 0){
						
						InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();			
						inventoryEntryPo.setCstiegoodsid(integralExchangeEntryPolist.get(i).getFilegoodsid());
						inventoryEntryPo.setCstiebarcode(integralExchangeEntryPolist.get(i).getFilegoodscode());
						inventoryEntryPo.setCstieoutstockid(Utility.getName(integralExchangePo.getFilstock()));
						inventoryEntryPo.setCstiegoodsquantity(t1.toString());
						
						inventoryEntryList.add(inventoryEntryPo);
					}
					
				}
				
			}
			
			for (int i = 0; i < inventoryEntryList.size(); i++) {   //验证负库存	
			
				if (Utility.getName(systemParameterPo.getFspsalestype()).equals("0")){ //不允许负库存销售
					int goodsNums = 0;
					if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //使用条码
						
						inventoryEntryList.get(i).setCstiebarcode(inventoryEntryList.get(i).getCstiebarcode());   //补充条码
						if (Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") || (!inventoryEntryList.get(i).getCstiegoodsid().substring(0,1).equals("4") && !inventoryEntryList.get(i).getCstiegoodsid().substring(0,1).equals("5"))){ //不用批号
							goodsNums = inTransitDetailsMgr.getStorageNumByNotBatch(inventoryEntryList.get(i));
						}
						if (!Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") && (inventoryEntryList.get(i).getCstiegoodsid().substring(0,1).equals("4") || inventoryEntryList.get(i).getCstiegoodsid().substring(0,1).equals("5"))){ //使用批号
							goodsNums = inTransitDetailsMgr.getStorageNumByBatch(inventoryEntryList.get(i));
						}
					}
					if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //不使用条码
						goodsNums = inTransitDetailsMgr.getStorageNumByGoodsID(inventoryEntryList.get(i));
					}
					
					sNum = new BigDecimal(goodsNums);
					dNum = new BigDecimal(inventoryEntryList.get(i).getCstiegoodsquantity());
					sNum = sNum.subtract(dNum);
					
					if (sNum.intValue() < 0){
						count = 0;
						break;
					}					
					
					sNum = null;
					dNum = null;
				}
			}
			
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    //新增
		logPo.setsLogContent("会员卡号为："+smecimemberid+" 兑换商品!");

		if (count > 0){
			guitarManagementMgr.insertIntegralExchange(systemParameterPo,integralExchangePo,integralExchangeEntryPolist,logPo);
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
		}else{
			this.clearMessages();
			this.addActionMessage(getText("部分商品库存不足,未能兑换!"));
		}

		String url = "'initIntegralExchangeManagement.action?moduleID="+moduleID+"'";
		request.setAttribute("url", url);
		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		return SUCCESS;
	}
	public String initWeiXinIntegralMSelectSel(){
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
		if (!Utility.getName(systemParameterPo.getFspshowchange()).equals("1")){
			this.setIsFirstExec("1");
			return "weiXinIntegralMSelectSel";
		}

		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo);
		
		return SUCCESS;
	}
	
	public String weiXinIntegralMSelectSel(){
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
		departmentsList = this.getDepartmentListByCompany(systemParameterPo,personInfoPo);
		
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
		if(null==weiXinIntegralSelectPo){
			weiXinIntegralSelectPo=new WeiXinIntegralSelectPo();
		}
		weiXinIntegralSelectPo.setWiedepartmentid(personInfoPo.getDepartmentID());
		weiXinIntegralSelectPo.setSmecishoplist(departmentsList);
		
		int count=guitarManagementMgr.getWeiXinIntegralSelectCount(weiXinIntegralSelectPo);
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
	    weiXinIntegralSelectPoList=guitarManagementMgr.getWeiXinIntegralSelectList(weiXinIntegralSelectPo,page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			weiXinIntegralSelectPoList = null;
		}
		return SUCCESS;
	}
	public String initWeiXinIntegralUpdate(){
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
		String wieid=request.getParameter("hid");
		weiXinIntegralSelectPo=new WeiXinIntegralSelectPo();
		weiXinIntegralSelectPo.setWieid(wieid);
		weiXinIntegralSelectPo=guitarManagementMgr.getWeiXinIntegralSelectList(weiXinIntegralSelectPo).get(0);
		return SUCCESS;
	}
	
	public String updateWeiXinIntegral(){
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
		
		weiXinIntegralSelectPo=new WeiXinIntegralSelectPo();
		weiXinIntegralSelectPo.setWieid(request.getParameter("hid"));
		weiXinIntegralSelectPo=guitarManagementMgr.getWeiXinIntegralSelectList(weiXinIntegralSelectPo).get(0);
		weiXinIntegralSelectPo.setWiepersonid(personInfoPo.getId());
		weiXinIntegralSelectPo.setWiedepartmentid(personInfoPo.getDepartmentID());
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    //新增
		logPo.setsLogContent("会员卡号为："+weiXinIntegralSelectPo.getWiememberid()+" 兑换商品!");
		
		String uuid = "DH"+GenerateNumber.getInstance().getGenerageNumber();
		integralExchangePo = new IntegralExchangePo();
		integralExchangePo.setFiluuid(uuid);
		integralExchangePo.setFilcustomername(weiXinIntegralSelectPo.getWiecustomerid());
		integralExchangePo.setFilmemberid(Utility.getName(weiXinIntegralSelectPo.getWiememberid()));
		integralExchangePo.setFildepartmentid(Utility.getName(personInfoPo.getDepartmentID()));
		integralExchangePo.setFilpersonid(Utility.getName(personInfoPo.getId()));
		integralExchangePo.setFilintegralsum(Utility.getName(weiXinIntegralSelectPo.getWieintegral()));   //会员原有积分
		integralExchangePo.setFilrefundflag("0");  //标识积分兑换(没有退货的)
		
		
		WarehouseConfigurationPo tempWarehouseConfigurationPo = new WarehouseConfigurationPo();
		tempWarehouseConfigurationPo.setBwcdeptid(personInfoPo.getDepartmentID());
		WarehouseConfigurationPo warehouseConfigurationPo = warehouseConfigurationMgr.getWarehouseConfiguration(tempWarehouseConfigurationPo);
		integralExchangePo.setFilstock(Utility.getName(warehouseConfigurationPo.getBwcstockid14()));   //积分兑换仓位
		
		
		
		BigDecimal subjf1 = new BigDecimal(weiXinIntegralSelectPo.getWiegoodsnumber());
		integralExchangeEntryPolist = new ArrayList<IntegralExchangeEntryPo>();
		List<InventoryEntryPo> inventoryEntryList = new ArrayList<InventoryEntryPo>();
		BigDecimal sNum = null;
		BigDecimal dNum = null;
		int count = 1;    // 负库存验证标记
			
			IntegralExchangeEntryPo integralExchangeEntryPo = new IntegralExchangeEntryPo();
			integralExchangeEntryPo.setFilegoodsid(weiXinIntegralSelectPo.getWiegoodsid());
			integralExchangeEntryPo.setFilegoodsname(weiXinIntegralSelectPo.getWiegoodname());
			integralExchangeEntryPo.setFilegoodsnumber(weiXinIntegralSelectPo.getWiegoodsnumber());
			integralExchangeEntryPo.setFilegoodscode(weiXinIntegralSelectPo.getWiegoodsbarcode());
			integralExchangeEntryPo.setFileintegralCount(subjf1.multiply(new BigDecimal(weiXinIntegralSelectPo.getWieintegral())).toString());
			integralExchangeEntryPo.setFileuuid(uuid);			
	
			integralExchangeEntryPolist.add(integralExchangeEntryPo);
		
		if (Utility.getName(systemParameterPo.getFspsalestype()).equals("0")){ //不允许负库存销售
			
			for (int i = 0; i < integralExchangeEntryPolist.size(); i++){ 
				if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //按商品代码和商品条码及数量合并镜片
					
					BigDecimal t1 = new BigDecimal(integralExchangeEntryPolist.get(i).getFilegoodsnumber());  //累计
					for (int j = i + 1; j < integralExchangeEntryPolist.size(); j++){ 
						if (integralExchangeEntryPolist.get(i).getFilegoodsid().equals(integralExchangeEntryPolist.get(j).getFilegoodsid()) && integralExchangeEntryPolist.get(i).getFilegoodscode().equals(integralExchangeEntryPolist.get(j).getFilegoodscode())){
							t1 = t1.add(new BigDecimal(integralExchangeEntryPolist.get(j).getFilegoodsnumber()));
						}
					}
					
					int tcount = 0;
					for (int k = 0; k < inventoryEntryList.size(); k++){
						if (inventoryEntryList.get(k).getCstiegoodsid().equals(integralExchangeEntryPolist.get(i).getFilegoodsid()) && inventoryEntryList.get(k).getCstiebarcode().equals(integralExchangeEntryPolist.get(i).getFilegoodscode())){
							tcount++;
							break;
						}
					}
					if (tcount == 0){
						
						InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();			
						inventoryEntryPo.setCstiegoodsid(integralExchangeEntryPolist.get(i).getFilegoodsid());
						inventoryEntryPo.setCstiebarcode(integralExchangeEntryPolist.get(i).getFilegoodscode());
						inventoryEntryPo.setCstieoutstockid(Utility.getName(integralExchangePo.getFilstock()));
						inventoryEntryPo.setCstiegoodsquantity(t1.toString());
						
						inventoryEntryList.add(inventoryEntryPo);
					}
					
				}
				
				if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //按商品代码和数量合并镜片
					
					BigDecimal t1 = new BigDecimal(integralExchangeEntryPolist.get(i).getFilegoodsnumber());  //累计
					for (int j = i + 1; j < integralExchangeEntryPolist.size(); j++){ 
						if (integralExchangeEntryPolist.get(i).getFilegoodsid().equals(integralExchangeEntryPolist.get(j).getFilegoodsid())){
							t1 = t1.add(new BigDecimal(integralExchangeEntryPolist.get(j).getFilegoodsnumber()));
						}
					}
					
					int tcount = 0;
					for (int k = 0; k < inventoryEntryList.size(); k++){
						if (inventoryEntryList.get(k).getCstiegoodsid().equals(integralExchangeEntryPolist.get(i).getFilegoodsid())){
							tcount++;
							break;
						}
					}
					if (tcount == 0){
						
						InventoryEntryPo inventoryEntryPo = new InventoryEntryPo();			
						inventoryEntryPo.setCstiegoodsid(integralExchangeEntryPolist.get(i).getFilegoodsid());
						inventoryEntryPo.setCstiebarcode(integralExchangeEntryPolist.get(i).getFilegoodscode());
						inventoryEntryPo.setCstieoutstockid(Utility.getName(integralExchangePo.getFilstock()));
						inventoryEntryPo.setCstiegoodsquantity(t1.toString());
						
						inventoryEntryList.add(inventoryEntryPo);
					}
					
				}
				
			}
			
			for (int i = 0; i < inventoryEntryList.size(); i++) {   //验证负库存	
			
				if (Utility.getName(systemParameterPo.getFspsalestype()).equals("0")){ //不允许负库存销售
					int goodsNums = 0;
					if (!Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3") ){ //使用条码
						
						inventoryEntryList.get(i).setCstiebarcode(inventoryEntryList.get(i).getCstiebarcode()+"00000000");   //补充条码
						if (Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") || (!inventoryEntryList.get(i).getCstiegoodsid().substring(0,1).equals("4") && !inventoryEntryList.get(i).getCstiegoodsid().substring(0,1).equals("5"))){ //不用批号
							goodsNums = inTransitDetailsMgr.getStorageNumByNotBatch(inventoryEntryList.get(i));
						}
						if (!Utility.getName(systemParameterPo.getFspstealtheffective()).equals("0") && (inventoryEntryList.get(i).getCstiegoodsid().substring(0,1).equals("4") || inventoryEntryList.get(i).getCstiegoodsid().substring(0,1).equals("5"))){ //使用批号
							goodsNums = inTransitDetailsMgr.getStorageNumByBatch(inventoryEntryList.get(i));
						}
					}
					if (Utility.getName(systemParameterPo.getFspbarcodetype()).equals("3")){ //不使用条码
						goodsNums = inTransitDetailsMgr.getStorageNumByGoodsID(inventoryEntryList.get(i));
					}
					
					sNum = new BigDecimal(goodsNums);
					dNum = new BigDecimal(inventoryEntryList.get(i).getCstiegoodsquantity());
					sNum = sNum.subtract(dNum);
					
					if (sNum.intValue() < 0){
						count = 0;
						break;
					}					
					
					sNum = null;
					dNum = null;
				}
			}
			
		}
		if (count > 0){
			
			guitarManagementMgr.insertWieIntegralExchange(weiXinIntegralSelectPo ,integralExchangePo, integralExchangeEntryPolist, logPo);
			this.clearMessages();
			this.addActionMessage(getText("兑换成功!"));
		}else{
			this.clearMessages();
			this.addActionMessage(getText("部分商品库存不足,未能兑换!"));
		}

		request.setAttribute("flag", GlobalConstants.OPENUPDATE);	
		return SUCCESS;
	}
}
