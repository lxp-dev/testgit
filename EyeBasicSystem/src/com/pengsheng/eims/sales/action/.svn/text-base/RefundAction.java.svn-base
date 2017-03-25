/**
 * 
 */
package com.pengsheng.eims.sales.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.his.mgr.HisMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.mgr.RefundMgr;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.sales.persistence.SpecialPDetailPo;
import com.pengsheng.eims.system.mgr.BrankCardMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.BrankCardPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;
import com.pengsheng.weixin.persistence.ConfigurationPo;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

/**
 * 退款管理
 * @author Administrator
 *
 */
public class RefundAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;
	private CustomerInfoMgr customerInfoMgr;
	private RefundMgr refundMgr;
	private CustomerInfoPo customerInfoPo;
	private SalesBasicPo salesBasicPo;
	private List<SalesBasicPo> refundList;	
	private static String salseID;	
	private static String print;	
	private static String checkFlag;	
	private static String ordersType;	
	private List<BrankCardPo> brankCardPos;	
	private BrankCardMgr brankCardMgr;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	private WarehouseConfigurationPo warehouseConfigurationPo;
	private WarehouseConfigurationMgr warehouseConfigurationMgr;	
	private SalesBasicPo salesODPo;
	private SalesBasicPo salesOSPo;
	private List<SalesDetailPo> goodsInfoList;
	private List<AdditionalCDetailPo> addititonalCDetailList;
	private List<SpecialPDetailPo> specialPDetailList;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private DepartmentsMgr departmentsMgr;
	private SalesDetailPo salesDetailPo;
	private List<BankPo> bankPos;
	private List<SalesBasicPo> salesBasicPos;
	private GuitarManagementMgr guitarManagementMgr;
	private List<BankPo> otherbankPos;
	private HisMgr hisMgr;
		
	public HisMgr getHisMgr() {
		return hisMgr;
	}

	public void setHisMgr(HisMgr hisMgr) {
		this.hisMgr = hisMgr;
	}

	public List<BankPo> getOtherbankPos() {
		return otherbankPos;
	}

	public void setOtherbankPos(List<BankPo> otherbankPos) {
		this.otherbankPos = otherbankPos;
	}

	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}

	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}

	public List<SalesBasicPo> getSalesBasicPos() {
		return salesBasicPos;
	}

	public void setSalesBasicPos(List<SalesBasicPo> salesBasicPos) {
		this.salesBasicPos = salesBasicPos;
	}

	public List<BankPo> getBankPos() {
		return bankPos;
	}

	public void setBankPos(List<BankPo> bankPos) {
		this.bankPos = bankPos;
	}

	public SalesDetailPo getSalesDetailPo() {
		return salesDetailPo;
	}

	public void setSalesDetailPo(SalesDetailPo salesDetailPo) {
		this.salesDetailPo = salesDetailPo;
	}

	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}

	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
	}

	public SalesBasicPo getSalesODPo() {
		return salesODPo;
	}

	public void setSalesODPo(SalesBasicPo salesODPo) {
		this.salesODPo = salesODPo;
	}

	public SalesBasicPo getSalesOSPo() {
		return salesOSPo;
	}

	public void setSalesOSPo(SalesBasicPo salesOSPo) {
		this.salesOSPo = salesOSPo;
	}

	public List<SalesDetailPo> getGoodsInfoList() {
		return goodsInfoList;
	}

	public void setGoodsInfoList(List<SalesDetailPo> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}

	public List<AdditionalCDetailPo> getAddititonalCDetailList() {
		return addititonalCDetailList;
	}

	public void setAddititonalCDetailList(
			List<AdditionalCDetailPo> addititonalCDetailList) {
		this.addititonalCDetailList = addititonalCDetailList;
	}

	public List<SpecialPDetailPo> getSpecialPDetailList() {
		return specialPDetailList;
	}

	public void setSpecialPDetailList(List<SpecialPDetailPo> specialPDetailList) {
		this.specialPDetailList = specialPDetailList;
	}

	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}

	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
	}

	public WarehouseConfigurationPo getWarehouseConfigurationPo() {
		return warehouseConfigurationPo;
	}

	public void setWarehouseConfigurationPo(
			WarehouseConfigurationPo warehouseConfigurationPo) {
		this.warehouseConfigurationPo = warehouseConfigurationPo;
	}

	public WarehouseConfigurationMgr getWarehouseConfigurationMgr() {
		return warehouseConfigurationMgr;
	}

	public void setWarehouseConfigurationMgr(
			WarehouseConfigurationMgr warehouseConfigurationMgr) {
		this.warehouseConfigurationMgr = warehouseConfigurationMgr;
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

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	public RefundMgr getRefundMgr() {
		return refundMgr;
	}

	public void setRefundMgr(RefundMgr refundMgr) {
		this.refundMgr = refundMgr;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public List<SalesBasicPo> getRefundList() {
		return refundList;
	}

	public void setRefundList(List<SalesBasicPo> refundList) {
		this.refundList = refundList;
	}

	/*
	 * 
	 * 初始化退款管理
	 */
	public String initRefundSel() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,personInfoPo.getDepartmentID());
		
		if (!Utility.getName(permissionPo.getKeya()).equals("1")){
			if (Utility.getName(permissionPo.getKeyb()).equals("1")){
				return "initPartRefundSel";
			}
			if (Utility.getName(permissionPo.getKeyc()).equals("1")){
				return "initPartSwapGoodsSel";
			}
		}		
		
		WarehouseConfigurationPo wpo = new WarehouseConfigurationPo();
		wpo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = warehouseConfigurationMgr.getInWarehouseConfiguration(wpo);
		
		request.setAttribute("bwcflag", Utility.getName(warehouseConfigurationPo.getBwcdeptid()));
		
		// 初始化直接进入空页面
		if (customerInfoPo == null) {
			return SUCCESS;
		}

		String salesID = Utility.getName(request.getParameter("salesID"));
		
		if (StringUtils.isNotEmpty(salesID)) {
			customerInfoPo.setFmmsalesid(salesID);
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
			customerInfoPo = refundMgr.getCustomerInfo(customerInfoPo);

			request.setAttribute("salesID", Utility.getName(request
					.getParameter("salesID")));

		} else if (StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			// 查询顾客信息
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
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

		if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
			String birthdayYear = customerInfoPo.getSmecibirthday().substring(
					0, 4);
			int age = Calendar.getInstance().get(Calendar.YEAR)
					- Integer.parseInt(birthdayYear);
			customerInfoPo.setFmmage(Integer.toString(age));
		}

		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
			SalesBasicPo temp = new SalesBasicPo();
			temp.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
			request.setAttribute("salesID", Utility.getName(request.getParameter("salesID")));

			SalesBasicPo salesBasicPo = new SalesBasicPo();
			salesBasicPo.setSsesbsalesid(Utility.getName(request.getParameter("salesID")));
			salesBasicPo.setSsesbshopcode(personInfoPo.getDepartmentID());
			salesBasicPo.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
							
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
			
			int count = refundMgr.getSalesBasicsCount(salesBasicPo,systemParameterPo);
			if (count > 0) {
				int perPage = 0;
				if (request.getParameter("perPage") != null) {
					perPage = new Integer((String) request
							.getParameter("perPage")).intValue();
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
				refundList = refundMgr.getSalesBasics(salesBasicPo,systemParameterPo, page.getStart(), page
								.getPageSize());
				request.setAttribute(Pagination.PAGINATION, page);
			} else {
				refundList = null;
			}
		}

		request.setAttribute("print", RefundAction.print);
		request.setAttribute("checkoutFlag", RefundAction.checkFlag);
		request.setAttribute("ssesborderstype", RefundAction.ordersType);
		request.setAttribute("salseID", RefundAction.salseID);
		request.setAttribute("departmentID", personInfoPo.getDepartmentID());		
		RefundAction.print="";
		RefundAction.checkFlag="";
		RefundAction.ordersType="";
		RefundAction.salseID="";
		return SUCCESS;
	}

	/**
	 * 初始化退款开窗
	 * 
	 * @return
	 */
	public String initRefundOpen() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");		
		
		SalesBasicPo salesBasicPo = new SalesBasicPo();
		salesBasicPo.setSsesbsalesid(Utility.getName(request.getParameter("salesID")));
		salesBasicPo.setSsesbcheckoutflag("1");
		
		salesBasicPos = guitarManagementMgr.getSalesBasics(salesBasicPo);
		
		bankPos = brankCardMgr.getOnlyBankList();
		
		otherbankPos=brankCardMgr.getOtherBankList();
		request.setAttribute("arg0", request.getParameter("arg0"));
		
		/**
		 * 获取现金金额
		 * @param po
		 */
		List<SalesLogPo> saleslogcash =  guitarManagementMgr.selectCash(salesBasicPo);
		
		request.setAttribute("saleslogcash", saleslogcash);
		
		/**
		 * 获取积分
		 * @param po
		 */
		List<SalesLogPo> saleslogcredit = guitarManagementMgr.selectCredit(salesBasicPo);
		
		request.setAttribute("saleslogcredit", saleslogcredit);
		
		/**
		 * 获取银行卡
		 * @param po
		 */
		List<SalesLogPo> saleslogbankcard = guitarManagementMgr.selectBankCard(salesBasicPo);
		
		request.setAttribute("saleslogbankcard", saleslogbankcard);
		
		/**
		 * 获取储值卡
		 * @param po
		 */
		List<SalesLogPo> saleslogprecard = guitarManagementMgr.selectPreCard(salesBasicPo);
		
		request.setAttribute("saleslogprecard", saleslogprecard);
		/**
		 * 获取代金券
		 * @param po
		 */
		List<SalesLogPo> salesdjq = guitarManagementMgr.selectDjq(salesBasicPo);
		
		request.setAttribute("salesdjq", salesdjq);
		/**
		 * 获取其他
		 * @param po
		 */
		List<SalesLogPo> salesQt = guitarManagementMgr.selectQt(salesBasicPo);
		
		request.setAttribute("salesQt", salesQt);
		return SUCCESS;
	}

	/*
	 * 退款
	 */
	public String refundSales() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */
		
		String salesID = Utility.getName(request.getParameter("salesID"));
		String intraint=refundMgr.getSalesBasicPo(salesID).getSsesbintransit();

		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		if(Utility.getName(systemParameterPo.getFspshopdistributionrefund()).equals("0") && !"2".equals(intraint) && !"12".equals(intraint) && !"13".equals(intraint)){
			this.clearMessages();
			this.addActionMessage(getText("该配镜单暂不可退款!"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;    
		}
		if(Utility.getName(systemParameterPo.getFspshopdistributionrefund()).equals("1") && !"2".equals(intraint) &&  !"3".equals(intraint) && !"12".equals(intraint) && !"13".equals(intraint)){
			this.clearMessages();
			this.addActionMessage(getText("该配镜单暂不可退款!"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;    
		}

		SalesBasicPo sales = new SalesBasicPo();
		sales.setSsesbsalesid(salesID);
		sales.setSsesbintransit("14");
		sales.setSsesbwithdrawpersonid(personInfoPo.getId());
		sales.setSsesbdepartmentid(personInfoPo.getDepartmentID());
		
		String psalsvalue = Utility.getName(request.getParameter("psalsvalue"));
		sales.setSsesbpsalsvalue(psalsvalue);

		InTransitPo inTransitPo = new InTransitPo();
		inTransitPo.setSseitsalesid(sales.getSsesbsalesid());
		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		inTransitPo.setSseitstate("14");
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("23");    // 退款
		logPo.setsLogContent("配镜单:" + salesID + "退款!");		
				
		String orderType = request.getParameter("ssesborderstype");
		String checkoutFlag = Utility.getName(request.getParameter("checkoutFlag"));
		String sseslpaymenttype = Utility.getName(request.getParameter("sseslpaymenttype"));
		
		sales.setSsesborderstype(orderType);
		sales.setSsesbcheckoutflag(checkoutFlag);
		sales.setSsesbposid(personInfoPo.getId());
		sales.setSseslpaymenttype(sseslpaymenttype);

		String[] xjvs = request.getParameterValues("xjv");
		String[] jfvs = request.getParameterValues("jfv");
		String[] yhkvs = request.getParameterValues("yhkv");
		String[] yhkts = request.getParameterValues("yhkt");
		String[] czkvs = request.getParameterValues("czkv");
		String[] czkids = request.getParameterValues("czkid");
		String[] czkyes = request.getParameterValues("czkye");
		
		String[] qtvs = request.getParameterValues("qtv");
		String[] qtts = request.getParameterValues("qtt");
		
		String[] djqvs = request.getParameterValues("djqv");
		String[] djqids = request.getParameterValues("djqid");
		String[] djqyes = request.getParameterValues("djqye");
		
		List<SalesLogPo> salesLogPos = new ArrayList<SalesLogPo>();
		
		BigDecimal bigd = new BigDecimal("0.00");
		if(xjvs == null){
			xjvs = new String[0];
		}
		for(int i=0; i<xjvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(xjvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("1");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(xjvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			salesLogPos.add(salesLogPo);
			
			bigd = bigd.add(bigd2);
		}		
		sales.setSsesbpaycash(bigd.toString());
		
		BigDecimal jftotal = new BigDecimal("0");
		if(jfvs == null){
			jfvs = new String[0];
		}
		BigDecimal jfdktotal = null;
		if (!"".equals(Utility.getName(systemParameterPo.getFspexchangeintegral()).trim())){
			jfdktotal = new BigDecimal(Utility.getName(systemParameterPo.getFspexchangeintegral()));
		}else{
			jfdktotal = new BigDecimal("0.00");
		}
		for(int i=0; i<jfvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(jfvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("2");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(jfvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslintegralprice(jfdktotal.multiply(bigd2).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			
			jftotal = jftotal.add(bigd2);
		}
		sales.setNowintegral(jftotal.toString());
		sales.setSsesbintegralprice(jfdktotal.multiply(jftotal).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		
		BigDecimal yhktotal = new BigDecimal("0.00");
		//银行卡
		if(yhkvs == null){
			yhkvs = new String[0];
		}		
		for(int i=0; i<yhkvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(yhkvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("3");
			salesLogPo.setSseslsourceid(yhkts[i]);
			salesLogPo.setSseslprice(yhkvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}	
		
		//其他
		if(qtvs == null){
			qtvs = new String[0];
		}		
		for(int i=0; i<qtvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(qtvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("6");
			salesLogPo.setSseslsourceid(qtts[i]);
			salesLogPo.setSseslprice(qtvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}
	    //代金券
		if(djqvs == null){
			djqvs = new String[0];
		}
		for(int i=0; i<djqvs.length; i++){
			if("".equals(djqvs[i])){
				djqvs[i]="0.00";
			}
			BigDecimal bigd2 = new BigDecimal(djqvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("7");
			salesLogPo.setSseslsourceid(djqids[i]);
			salesLogPo.setSseslprice(djqvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}
		
		sales.setSsesbbankcard(yhktotal.toString());

		
		BigDecimal czktotal = new BigDecimal("0.00");
		if(czkvs == null){
			czkvs = new String[0];
		}
		for(int i=0; i<czkvs.length; i++){
			if("".equals(czkvs[i])){
				czkvs[i]="0.00";
			}
			BigDecimal bigd2 = new BigDecimal(czkvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("4");
			salesLogPo.setSseslsourceid(czkids[i]);
			salesLogPo.setSseslprice(czkvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			czktotal = czktotal.add(bigd2);
		}
		sales.setSsesbstoredcard(czktotal.toString());
		
		//现金合计 = 现金 - 找零
		bigd = bigd.setScale(2, BigDecimal.ROUND_HALF_UP);
		sales.setSsesbpaycash(bigd.toString());
		
		List<ChuzhikaPo> czklist = new ArrayList<ChuzhikaPo>();
		for(int i=0; i<czkvs.length; i++){
			if(Float.parseFloat(czkvs[i]) > 0){
				ChuzhikaPo po = new ChuzhikaPo();
				po.setCstczkchongzhijine("-"+czkvs[i]);
				po.setCstczkjiankaren(personInfoPo.getId());
				po.setCstczkjine(czkyes[i]);
				po.setCstczkid(czkids[i]);
				po.setCstczkllinkbillid(request.getParameter("salseID"));
				po.setCstczklyue(czkyes[i]);
				
				po.setCstczksalesamount(Utility.getName(czkvs[i]).equals("") ? "0.00" : Utility.getName(czkvs[i]));
				po.setCstczksalesstore(personInfoPo.getDepartmentID());
				po.setCstczksalesdate("1");
				
				czklist.add(po);
			}
		}
		//代金券
		List<CashCouponPo> djqlist = new ArrayList<CashCouponPo>();
		for(int i=0; i<djqvs.length; i++){
			if(Float.parseFloat(djqvs[i]) > 0){
				CashCouponPo couponPo=new CashCouponPo();

				couponPo.setBcccard(djqids[i]);
				couponPo.setBccuseperson(personInfoPo.getId());
				couponPo.setBccuseflag("0");
				couponPo.setBccuseamount(djqvs[i]);
				
				djqlist.add(couponPo);
			}
		}
		sales.setSsesbsalesvalue(Utility.getName(request.getParameter("salseValue")));		
		
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		
		ConfigurationPo weixin = (ConfigurationPo)session.get("weixin");
		WeixinInviteFriendLogPo weixinpo = new WeixinInviteFriendLogPo();
		if("1".equals(weixin.getWcryqhysjftype())){
			String cname = "1";
			weixinpo.setWifltousername(cname);
		}
		refundMgr.insertSalesGutiar(sales, inTransitPo, salesLogPos,czklist,djqlist, logPo, weixinpo, systemParameterPo);
		
		RefundAction.print="1";
		RefundAction.checkFlag=request.getParameter("checkFlag");
		RefundAction.salseID=request.getParameter("salesID");
		
		CustomerInfoPo cpo = new CustomerInfoPo();
		cpo.setFmmsalesid(salesID);
		cpo = refundMgr.getCustomerInfo(cpo);
		
		RefundAction.ordersType = Utility.getName(cpo.getFmmsalesorderid());
		
		this.clearMessages();
		this.addActionMessage(getText("sales.refund.success"));		
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

	/**
	 * 
	 * 初始化部分退款管理
	 */
	public String initPartRefundSel() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */

		WarehouseConfigurationPo wpo = new WarehouseConfigurationPo();
		wpo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = warehouseConfigurationMgr.getInWarehouseConfiguration(wpo);
		
		request.setAttribute("bwcflag", Utility.getName(warehouseConfigurationPo.getBwcdeptid()));
		
		// 初始化直接进入空页面
		if (customerInfoPo == null) {
			return SUCCESS;
		}

		String salesID = Utility.getName(request.getParameter("salesID"));
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		if (StringUtils.isNotEmpty(salesID)) {
			customerInfoPo.setFmmsalesid(salesID);
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
			customerInfoPo = refundMgr.getCustomerInfo(customerInfoPo);

			request.setAttribute("salesID", Utility.getName(request.getParameter("salesID")));

		} else if (StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			// 查询顾客信息
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			// 年龄
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday().substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)	- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}
		}

		if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
			String birthdayYear = customerInfoPo.getSmecibirthday().substring(0, 4);
			int age = Calendar.getInstance().get(Calendar.YEAR)	- Integer.parseInt(birthdayYear);
			customerInfoPo.setFmmage(Integer.toString(age));
		}

		if (customerInfoPo != null && StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
			SalesBasicPo temp = new SalesBasicPo();
			temp.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
			request.setAttribute("salesID", Utility.getName(request.getParameter("salesID")));

			SalesBasicPo salesBasicPo = new SalesBasicPo();
			salesBasicPo.setSsesbsalesid(Utility.getName(request.getParameter("salesID")));
			salesBasicPo.setSsesbshopcode(personInfoPo.getDepartmentID());
			salesBasicPo.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
			salesBasicPo.setSsesbintransit2("13");
			salesBasicPo.setSsesbcheckoutflag("0");
			
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
			
			int count = refundMgr.getSalesBasicsCount(salesBasicPo,systemParameterPo);
			if (count > 0) {
				int perPage = 0;
				if (request.getParameter("perPage") != null) {
					perPage = new Integer((String) request
							.getParameter("perPage")).intValue();
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
				refundList = refundMgr.getSalesBasics(salesBasicPo,systemParameterPo, page.getStart(), page.getPageSize());
				request.setAttribute(Pagination.PAGINATION, page);
			} else {
				refundList = null;
			}
		}
		
		return SUCCESS;
	}

	/**
	 * 部分退款开窗
	 * 
	 * @return
	 */
	public String initPartRefundOpen() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */
	
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		bankPos = brankCardMgr.getOnlyBankList();
		
		otherbankPos=brankCardMgr.getOtherBankList();
		String salesId = Utility.getName(request.getParameter("hid"));
		request.setAttribute("ssesbsalesid", salesId);
		SalesBasicPo salesPo = new SalesBasicPo();
		// 顾客详细信息
		salesPo.setSsesbsalesid(salesId);
		salesBasicPo = inTransitDetailsMgr.getCustomerInfo(salesPo);

		SalesBasicPo ODPo = new SalesBasicPo();
		ODPo.setSsesbsalesid(salesId);

		SalesBasicPo OSPo = new SalesBasicPo();
		OSPo.setSsesbsalesid(salesId);

		// 右眼信息
		salesODPo = new SalesBasicPo();
		salesODPo = inTransitDetailsMgr.getODDetailInfo(ODPo);

		// 左眼信息
		salesOSPo = new SalesBasicPo();
		salesOSPo = inTransitDetailsMgr.getOSDetailInfo(OSPo);

		// 商品详细信息List
		SalesDetailPo salesDetailPo = new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(salesId);
		goodsInfoList = inTransitDetailsMgr.getGoodsInfo(salesDetailPo);

		// 附加费用List
		AdditionalCDetailPo additionalCDetailPo = new AdditionalCDetailPo();
		additionalCDetailPo.setSsesalesid(salesId);
		addititonalCDetailList = inTransitDetailsMgr.getAddititonalCDetail(additionalCDetailPo);

		// 特殊加工要求List
		SpecialPDetailPo specialPDetailPo = new SpecialPDetailPo();
		specialPDetailPo.setSsesdsalesid(salesId);
		specialPDetailList = inTransitDetailsMgr.getSpecialPDetail(specialPDetailPo);
		
		List<SalesLogPo> salesdjq = guitarManagementMgr.selectDjq(salesBasicPo);
		
		request.setAttribute("salesdjq", salesdjq);
		
		return SUCCESS;
	}

	/**
	 * 部分退款
	 */
	public String partRefundSales() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */
		
		String salesID = Utility.getName(request.getParameter("salesID"));
		String ids = Utility.getName(request.getParameter("ids"));
		String goodtype = Utility.getName(request.getParameter("goodtype"));
		String[] idArray = ids.split(",");
		String[] goodtypeArray =  goodtype.split(",");
		
		String intraint = refundMgr.getSalesBasicPo(salesID).getSsesbintransit();

		if(!"13".equals(intraint)){
			this.clearMessages();
			this.addActionMessage(getText("配镜单中商品不能退款!"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}
		
		SalesBasicPo sales = new SalesBasicPo();
		String psalsvalue = Utility.getName(request.getParameter("psalsvalue"));
		sales.setSsesbpsalsvalue(psalsvalue);		
		sales.setSsesbsalesid(salesID);
		sales.setSsesbintransit("14");
		sales.setSsesbwithdrawpersonid(personInfoPo.getId());
		sales.setSsesbdepartmentid(personInfoPo.getDepartmentID());

		InTransitPo inTransitPo = new InTransitPo();
		inTransitPo.setSseitsalesid(sales.getSsesbsalesid());
		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		inTransitPo.setSseitstate("14");
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("23");    // 退款
		logPo.setsLogContent("配镜单:" + salesID + ",商品退款!");
		
		List<SalesDetailPo> salesDetailList = new ArrayList<SalesDetailPo>();
		for (int i = 0; i < idArray.length; i++){			
			if (!idArray[i].equals("")){
				SalesDetailPo po = new SalesDetailPo();
				po.setSsesdid(idArray[i]);
				po.setSsesdcommoditiesflag(goodtypeArray[i]);
				po.setSsesdwithdrawperson(personInfoPo.getId());
				
				salesDetailList.add(po);
			}
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String orderType = Utility.getName(request.getParameter("ssesborderstype"));
		String checkoutFlag = Utility.getName(request.getParameter("checkoutFlag"));
		String sseslpaymenttype = Utility.getName(request.getParameter("sseslpaymenttype"));
		
		sales.setSsesborderstype(orderType);
		sales.setSsesbcheckoutflag(checkoutFlag);
		sales.setSsesbposid(personInfoPo.getId());
		sales.setSseslpaymenttype(sseslpaymenttype);

		String[] xjvs = request.getParameterValues("xjv");
		String[] jfvs = request.getParameterValues("jfv");
		String[] yhkvs = request.getParameterValues("yhkv");
		String[] yhkts = request.getParameterValues("yhkt");
		String[] czkvs = request.getParameterValues("czkv");
		String[] czkids = request.getParameterValues("czkid");
		String[] czkyes = request.getParameterValues("czkye");
		
		String[] qtvs = request.getParameterValues("qtv");
		String[] qtts = request.getParameterValues("qtt");
		
		String[] djqvs = request.getParameterValues("djqv");
		String[] djqids = request.getParameterValues("djqid");
		String[] djqyes = request.getParameterValues("djqye");
		
		List<SalesLogPo> salesLogPos = new ArrayList<SalesLogPo>();
		
		BigDecimal bigd = new BigDecimal("0.00");
		if(xjvs == null){
			xjvs = new String[0];
		}
		for(int i=0; i<xjvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(xjvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("1");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(xjvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			salesLogPos.add(salesLogPo);
			
			bigd = bigd.add(bigd2);
		}		
		sales.setSsesbpaycash(bigd.toString());
		
		BigDecimal jftotal = new BigDecimal("0");
		if(jfvs == null){
			jfvs = new String[0];
		}
		BigDecimal jfdktotal = null;
		if (!"".equals(Utility.getName(systemParameterPo.getFspexchangeintegral()).trim())){
			jfdktotal = new BigDecimal(Utility.getName(systemParameterPo.getFspexchangeintegral()));
		}else{
			jfdktotal = new BigDecimal("0.00");
		}
		for(int i=0; i<jfvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(jfvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("2");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(jfvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslintegralprice(jfdktotal.multiply(bigd2).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			
			jftotal = jftotal.add(bigd2);
		}
		sales.setNowintegral(jftotal.toString());
		sales.setSsesbintegralprice(jfdktotal.multiply(jftotal).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		
		BigDecimal yhktotal = new BigDecimal("0.00");
		//银行卡
		if(yhkvs == null){
			yhkvs = new String[0];
		}		
		for(int i=0; i<yhkvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(yhkvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("3");
			salesLogPo.setSseslsourceid(yhkts[i]);
			salesLogPo.setSseslprice(yhkvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}
		//其他
		if(qtvs == null){
			qtvs = new String[0];
		}		
		for(int i=0; i<qtvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(qtvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("6");
			salesLogPo.setSseslsourceid(qtts[i]);
			salesLogPo.setSseslprice(qtvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}		
	    //代金券
		if(djqvs == null){
			djqvs = new String[0];
		}
		for(int i=0; i<djqvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(djqvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("7");
			salesLogPo.setSseslsourceid(djqids[i]);
			salesLogPo.setSseslprice(djqvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}
		sales.setSsesbbankcard(yhktotal.toString());
		
		BigDecimal czktotal = new BigDecimal("0.00");
		if(czkvs == null){
			czkvs = new String[0];
		}
		for(int i=0; i<czkvs.length; i++){
			if(!czkids[i].equals("") && (new BigDecimal(czkvs[i]).doubleValue() != 0)){
				BigDecimal bigd2 = new BigDecimal(czkvs[i]);
				SalesLogPo salesLogPo = new SalesLogPo();
				salesLogPo.setSseslsalesid(salesID);
				salesLogPo.setSseslpaymenttype("4");
				salesLogPo.setSseslconsumptionid("4");
				salesLogPo.setSseslsourceid(czkids[i]);
				salesLogPo.setSseslprice(czkvs[i]);
				salesLogPo.setSseslperson(personInfoPo.getId());
				salesLogPo.setSseslorderby("");
				salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
				salesLogPo.setSsesltype("1");
				
				salesLogPos.add(salesLogPo);
				czktotal = czktotal.add(bigd2);
			}
		}
		sales.setSsesbstoredcard(czktotal.toString());
		
		//现金合计 = 现金 - 找零
		bigd = bigd.setScale(2, BigDecimal.ROUND_HALF_UP);
		sales.setSsesbpaycash(bigd.toString());
			
		List<ChuzhikaPo> czklist = new ArrayList<ChuzhikaPo>();
		for(int i=0; i<czkvs.length; i++){
			if(!czkids[i].equals("") && (new BigDecimal(czkvs[i]).doubleValue() != 0)){
				ChuzhikaPo po = new ChuzhikaPo();
				po.setCstczkchongzhijine("-"+czkvs[i]);
				po.setCstczkjiankaren(personInfoPo.getId());
				po.setCstczkjine(czkyes[i]);
				po.setCstczkid(czkids[i]);
				po.setCstczkllinkbillid(salesID);
				po.setCstczklyue(czkyes[i]);
				
				po.setCstczksalesamount(Utility.getName(czkvs[i]).equals("") ? "0.00" : Utility.getName(czkvs[i]));
				po.setCstczksalesstore(personInfoPo.getDepartmentID());
				po.setCstczksalesdate("1");
				
				czklist.add(po);
			}
		}
		//代金券
		List<CashCouponPo> djqlist = new ArrayList<CashCouponPo>();
		for(int i=0; i<djqvs.length; i++){
			if(Float.parseFloat(djqvs[i]) > 0){
				CashCouponPo couponPo=new CashCouponPo();

				couponPo.setBcccard(djqids[i]);
				couponPo.setBccuseperson(personInfoPo.getId());
				couponPo.setBccuseflag("0");
				couponPo.setBccuseamount(djqvs[i]);
				
				djqlist.add(couponPo);
			}
		}
		
		sales.setSsesbsalesvalue(Utility.getName(request.getParameter("salseValue")));		
		
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		
		String newBillID = refundMgr.insertPartSalesGutiar(sales, inTransitPo, personInfoPo, salesDetailList, salesLogPos, czklist,djqlist, logPo);
		
		salesBasicPo = inTransitDetailsMgr.getCustomerInfo(sales);
		if("1".equals(Utility.getName(permissionPo.getKeyd())) && !systemParameterPo.getFsphisflag().equals("2") && Utility.getName(personInfoPo.getBdplinkhisflag()).equals("0")){
			String salseSuccessMsg="顾客:"+salesBasicPo.getSsesbpersonName()+"  销售单"+newBillID+"提交成功!";
			request.setAttribute("url", "'selGuitarManagementOpen.action?moduleID="+moduleID+"&hid="+newBillID+"&autopay=2&memberId="+salesBasicPo.getSsesbMemberId()+"&ssesborderstype="+salesBasicPo.getSsesborderstype()+"&returnUrl=initPartRefundSel.action"+"'");
			this.clearMessages();
			this.addActionMessage(getText(salseSuccessMsg));
			request.setAttribute("flag", GlobalConstants.MOVE);
		}else{
			String salseSuccessMsg="顾客:"+salesBasicPo.getSsesbpersonName()+"  销售单"+newBillID+"提交成功!";
			request.setAttribute("url", "'initPartRefundSel.action?moduleID="+moduleID+"'");
			this.clearMessages();
			this.addActionMessage(getText(salseSuccessMsg));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}
		
		return SUCCESS;
	}

	/**
	 * 
	 * 初始化部分换货管理
	 */
	public String initPartSwapGoodsSel() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */

		WarehouseConfigurationPo wpo = new WarehouseConfigurationPo();
		wpo.setBwcdeptid(personInfoPo.getDepartmentID());
		warehouseConfigurationPo = warehouseConfigurationMgr.getInWarehouseConfiguration(wpo);
		
		request.setAttribute("bwcflag", Utility.getName(warehouseConfigurationPo.getBwcdeptid()));
		
		// 初始化直接进入空页面
		if (customerInfoPo == null) {
			return SUCCESS;
		}

		String salesID = Utility.getName(request.getParameter("salesID"));
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		if (StringUtils.isNotEmpty(salesID)) {
			customerInfoPo.setFmmsalesid(salesID);
			customerInfoPo.setFmmsalesorderid("3");
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
			customerInfoPo = refundMgr.getCustomerInfo(customerInfoPo);

			request.setAttribute("salesID", Utility.getName(request.getParameter("salesID")));

		} else if (StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			// 查询顾客信息
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			// 年龄
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday().substring(0, 4);
				int age = Calendar.getInstance().get(Calendar.YEAR)	- Integer.parseInt(birthdayYear);
				customerInfoPo.setFmmage(Integer.toString(age));
			}
		}

		if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
			String birthdayYear = customerInfoPo.getSmecibirthday().substring(0, 4);
			int age = Calendar.getInstance().get(Calendar.YEAR)	- Integer.parseInt(birthdayYear);
			customerInfoPo.setFmmage(Integer.toString(age));
		}

		if (customerInfoPo != null && StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
			SalesBasicPo temp = new SalesBasicPo();
			temp.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
			request.setAttribute("salesID", Utility.getName(request.getParameter("salesID")));

			SalesBasicPo salesBasicPo = new SalesBasicPo();
			salesBasicPo.setSsesbsalesid(Utility.getName(request.getParameter("salesID")));
			salesBasicPo.setSsesbshopcode(personInfoPo.getDepartmentID());
			salesBasicPo.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
			salesBasicPo.setSsesborderstype("3");
			salesBasicPo.setSsesbintransit2("13");
			salesBasicPo.setSsesbcheckoutflag("0");
			
			systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
			int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());	
			
			int count = refundMgr.getSalesBasicsCount(salesBasicPo,systemParameterPo);
			if (count > 0) {
				int perPage = 0;
				if (request.getParameter("perPage") != null) {
					perPage = new Integer((String) request
							.getParameter("perPage")).intValue();
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
				refundList = refundMgr.getSalesBasics(salesBasicPo,systemParameterPo, page.getStart(), page.getPageSize());
				request.setAttribute(Pagination.PAGINATION, page);
			} else {
				refundList = null;
			}
		}
		
		return SUCCESS;
	}

	/**
	 * 部分换货开窗
	 * 
	 * @return
	 */
	public String initPartSwapGoodsOpen() {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");	
		
		String salesId = Utility.getName(request.getParameter("hid"));
		request.setAttribute("ssesbsalesid", salesId);
		SalesBasicPo salesPo = new SalesBasicPo();
		// 顾客详细信息
		salesPo.setSsesbsalesid(salesId);
		salesBasicPo = inTransitDetailsMgr.getCustomerInfo(salesPo);

		SalesBasicPo ODPo = new SalesBasicPo();
		ODPo.setSsesbsalesid(salesId);

		SalesBasicPo OSPo = new SalesBasicPo();
		OSPo.setSsesbsalesid(salesId);

		// 右眼信息
		salesODPo = new SalesBasicPo();
		salesODPo = inTransitDetailsMgr.getODDetailInfo(ODPo);

		// 左眼信息
		salesOSPo = new SalesBasicPo();
		salesOSPo = inTransitDetailsMgr.getOSDetailInfo(OSPo);

		// 商品详细信息List
		SalesDetailPo salesDetailPo = new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(salesId);
		goodsInfoList = inTransitDetailsMgr.getGoodsInfo(salesDetailPo);

		// 附加费用List
		AdditionalCDetailPo additionalCDetailPo = new AdditionalCDetailPo();
		additionalCDetailPo.setSsesalesid(salesId);
		addititonalCDetailList = inTransitDetailsMgr.getAddititonalCDetail(additionalCDetailPo);

		// 特殊加工要求List
		SpecialPDetailPo specialPDetailPo = new SpecialPDetailPo();
		specialPDetailPo.setSsesdsalesid(salesId);
		specialPDetailList = inTransitDetailsMgr.getSpecialPDetail(specialPDetailPo);
		
		return SUCCESS;
	}

	/**
	 * 部分换货
	 */
	public String partSwapGoodsSales() throws Exception {
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo.getId();
		
		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		request.setAttribute("moduleID", moduleID);
		/** ********************** 权限设置 ***************************** */
		
		String salesID = Utility.getName(request.getParameter("salesID"));
		String ids = Utility.getName(request.getParameter("ids"));
		String[] idArray = ids.split(",");
		
		String intraint = refundMgr.getSalesBasicPo(salesID).getSsesbintransit();

		if(!"13".equals(intraint)){
			this.clearMessages();
			this.addActionMessage(getText("配镜单中商品不能换取其他商品!"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			return SUCCESS;
		}
		
		SalesBasicPo sales = new SalesBasicPo();
		sales.setSsesbsalesid(salesID);
		sales.setSsesbintransit("14");
		sales.setSsesbwithdrawpersonid(personInfoPo.getId());
		sales.setSsesbdepartmentid(personInfoPo.getDepartmentID());
		sales.setSsesbsalesvalue(Utility.getName(request.getParameter("arrearssalesvalue")));

		sales.setSsesbpsalsvalue(Utility.getName(request.getParameter("arrearssalesvalue")));
		sales.setSsesbcheckoutflag(salesBasicPo.getSsesbcheckoutflag());
		sales.setSsesbshopcode(personInfoPo.getDepartmentID());

		InTransitPo inTransitPo = new InTransitPo();
		inTransitPo.setSseitsalesid(sales.getSsesbsalesid());
		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		inTransitPo.setSseitstate("14");
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("23");    // 退款
		logPo.setsLogContent("配镜单:" + salesID + ",换取商品!");
		
		List<SalesDetailPo> salesDetailList = new ArrayList<SalesDetailPo>();
		for (int i = 0; i < idArray.length; i++){			
			if (!idArray[i].equals("")){
				SalesDetailPo po = new SalesDetailPo();
				po.setSsesdid(idArray[i]);
				po.setSsesdwithdrawperson(personInfoPo.getId());
				
				salesDetailList.add(po);
			}
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String orderType = request.getParameter("ssesborderstype");
		String checkoutFlag = Utility.getName(request.getParameter("checkoutFlag"));
		String sseslpaymenttype = Utility.getName(request.getParameter("sseslpaymenttype"));
		
		sales.setSsesborderstype(orderType);
		sales.setSsesbcheckoutflag(checkoutFlag);
		sales.setSsesbposid(personInfoPo.getId());
		sales.setSseslpaymenttype(sseslpaymenttype);

//		String[] xjvs = request.getParameterValues("xjv");
//		String[] jfvs = request.getParameterValues("jfv");
//		String[] yhkvs = request.getParameterValues("yhkv");
//		String[] yhkts = request.getParameterValues("yhkt");
//		String[] czkvs = request.getParameterValues("czkv");
//		String[] czkids = request.getParameterValues("czkid");
//		String[] czkyes = request.getParameterValues("czkye");
//		
//		String[] qtvs = request.getParameterValues("qtv");
//		String[] qtts = request.getParameterValues("qtt");
//		
//		String[] djqvs = request.getParameterValues("djqv");
//		String[] djqids = request.getParameterValues("djqid");
//		String[] djqyes = request.getParameterValues("djqye");
		

		
		List<SalesLogPo> salesLogPos = new ArrayList<SalesLogPo>();
		
		SalesLogPo slPo=new SalesLogPo();
		
		slPo.setSseslsalesid(sales.getSsesbsalesid());
		slPo.setSseslconsumptionid("1");
		
		List<SalesLogPo> xjlist=refundMgr.getSalesLogList(slPo);
		
		BigDecimal bigd = new BigDecimal("0.00");
//		if(xjvs == null){
//			xjvs = new String[0];
//		}
		for(int i=0; i<xjlist.size(); i++){
			BigDecimal bigd2 = new BigDecimal(xjlist.get(i).getSseslprice());
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(sales.getSsesbsalesid());
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("1");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(xjlist.get(i).getSseslprice());
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			salesLogPos.add(salesLogPo);
			
			bigd = bigd.add(bigd2);
		}		
		sales.setSsesbpaycash(bigd.toString());
		
		
		
		slPo.setSseslsalesid(sales.getSsesbsalesid());
		slPo.setSseslconsumptionid("2");
		
		List<SalesLogPo> jflist=refundMgr.getSalesLogList(slPo);
		
		BigDecimal jftotal = new BigDecimal("0");
//		if(jfvs == null){
//			jfvs = new String[0];
//		}
		BigDecimal jfdktotal = null;
		if (!"".equals(Utility.getName(systemParameterPo.getFspexchangeintegral()).trim())){
			jfdktotal = new BigDecimal(Utility.getName(systemParameterPo.getFspexchangeintegral()));
		}else{
			jfdktotal = new BigDecimal("0.00");
		}
		for(int i=0; i<jflist.size(); i++){
			BigDecimal bigd2 = new BigDecimal(jflist.get(i).getSseslprice());
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(sales.getSsesbsalesid());
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("2");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(jflist.get(i).getSseslprice());
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslintegralprice(jflist.get(i).getSseslintegralprice());
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			
			jftotal = jftotal.add(bigd2);
		}
		sales.setNowintegral(jftotal.toString());
		sales.setSsesbintegralprice(jfdktotal.multiply(jftotal).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		
		BigDecimal yhktotal = new BigDecimal("0.00");
		//银行卡
		slPo.setSseslsalesid(sales.getSsesbsalesid());
		slPo.setSseslconsumptionid("3");
		
		List<SalesLogPo> yhklist=refundMgr.getSalesLogList(slPo);
		
//		if(yhkvs == null){
//			yhkvs = new String[0];
//		}		
		for(int i=0; i<yhklist.size(); i++){
			BigDecimal bigd2 = new BigDecimal(yhklist.get(i).getSseslprice());
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(sales.getSsesbsalesid());
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("3");
			salesLogPo.setSseslsourceid(yhklist.get(i).getSseslsourceid());
			salesLogPo.setSseslprice(yhklist.get(i).getSseslprice());
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}	
		//其他
		slPo.setSseslsalesid(sales.getSsesbsalesid());
		slPo.setSseslconsumptionid("6");
		
		List<SalesLogPo> qtlist=refundMgr.getSalesLogList(slPo);
//		if(qtvs == null){
//			qtvs = new String[0];
//		}		
		for(int i=0; i<qtlist.size(); i++){
			BigDecimal bigd2 = new BigDecimal(qtlist.get(i).getSseslprice());
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(sales.getSsesbsalesid());
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("6");
			salesLogPo.setSseslsourceid(qtlist.get(i).getSseslsourceid());
			salesLogPo.setSseslprice(qtlist.get(i).getSseslprice());
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}		
	    //代金券
		slPo.setSseslsalesid(sales.getSsesbsalesid());
		slPo.setSseslconsumptionid("7");
		
		List<SalesLogPo> djqlist2=refundMgr.getSalesLogList(slPo);
//		if(djqvs == null){
//			djqvs = new String[0];
//		}
		for(int i=0; i<djqlist2.size(); i++){
			BigDecimal bigd2 = new BigDecimal(djqlist2.get(i).getSseslprice());
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(sales.getSsesbsalesid());
			salesLogPo.setSseslpaymenttype("4");
			salesLogPo.setSseslconsumptionid("7");
			salesLogPo.setSseslsourceid(djqlist2.get(i).getSseslsourceid());
			salesLogPo.setSseslprice(djqlist2.get(i).getSseslprice());
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}
		sales.setSsesbbankcard(yhktotal.toString());
		
		BigDecimal czktotal = new BigDecimal("0.00");
		slPo.setSseslsalesid(sales.getSsesbsalesid());
		slPo.setSseslconsumptionid("4");
		
		List<SalesLogPo> czklist2=refundMgr.getSalesLogList(slPo);
		
//		if(czkvs == null){
//			czkvs = new String[0];
//		}
		for(int i=0; i<czklist2.size(); i++){
			if(Float.parseFloat(czklist2.get(i).getSseslprice()) > 0){
				BigDecimal bigd2 = new BigDecimal(czklist2.get(i).getSseslprice());
				SalesLogPo salesLogPo = new SalesLogPo();
				salesLogPo.setSseslsalesid(sales.getSsesbsalesid());
				salesLogPo.setSseslpaymenttype("4");
				salesLogPo.setSseslconsumptionid("4");
				salesLogPo.setSseslsourceid(czklist2.get(i).getSseslsourceid());
				salesLogPo.setSseslprice(czklist2.get(i).getSseslprice());
				salesLogPo.setSseslperson(personInfoPo.getId());
				salesLogPo.setSseslorderby("");
				salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
				salesLogPo.setSsesltype("1");
				
				salesLogPos.add(salesLogPo);
				czktotal = czktotal.add(bigd2);
			}
		}
		sales.setSsesbstoredcard(czktotal.toString());
		
		//现金合计 = 现金 - 找零
		bigd = bigd.setScale(2, BigDecimal.ROUND_HALF_UP);
		sales.setSsesbpaycash(bigd.toString());
			
		List<ChuzhikaPo> czklist = new ArrayList<ChuzhikaPo>();
		for(int i=0; i<czklist2.size(); i++){
			if(Float.parseFloat(czklist2.get(i).getSseslprice()) > 0){
				ChuzhikaPo po = new ChuzhikaPo();
				po.setCstczkchongzhijine("-"+czklist2.get(i).getSseslprice());
				po.setCstczkjiankaren(personInfoPo.getId());
				po.setCstczkjine(czklist2.get(i).getCzkye());
				po.setCstczkid(czklist2.get(i).getSseslsourceid());
				po.setCstczkllinkbillid(sales.getSsesbsalesid());
				po.setCstczklyue(czklist2.get(i).getCzkye());
				
				po.setCstczksalesamount(Utility.getName(czklist2.get(i).getSseslprice().equals("") ? "0.00" : Utility.getName(czklist2.get(i).getSseslprice())));
				po.setCstczksalesstore(personInfoPo.getDepartmentID());
				po.setCstczksalesdate("1");
				
				czklist.add(po);
			}
		}
		//代金券
		List<CashCouponPo> djqlist = new ArrayList<CashCouponPo>();
		for(int i=0; i<djqlist2.size(); i++){
			if(Float.parseFloat(djqlist2.get(i).getSseslprice()) > 0){
				CashCouponPo couponPo=new CashCouponPo();

				couponPo.setBcccard(djqlist2.get(i).getSseslsourceid());
				couponPo.setBccuseperson(personInfoPo.getId());
				couponPo.setBccuseflag("0");
				couponPo.setBccuseamount(djqlist2.get(i).getSseslprice());
				
				djqlist.add(couponPo);
			}
		}
	
		
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		
		String newBillID = refundMgr.insertPartSwapGoodsSalesGutiar(sales, inTransitPo,personInfoPo,salesDetailList,salesDetailPo, salesLogPos, czklist,djqlist,logPo);

		salesBasicPo = inTransitDetailsMgr.getCustomerInfo(sales);
		if("1".equals(Utility.getName(permissionPo.getKeye())) && !systemParameterPo.getFsphisflag().equals("2") && Utility.getName(personInfoPo.getBdplinkhisflag()).equals("0")){
			String salseSuccessMsg="顾客:"+salesBasicPo.getSsesbpersonName()+"  销售单"+newBillID+"提交成功";
			request.setAttribute("url", "'selGuitarManagementOpen.action?moduleID="+moduleID+"&hid="+newBillID+"&autopay=2&memberId="+salesBasicPo.getSsesbMemberId()+"&ssesborderstype="+salesBasicPo.getSsesborderstype()+"&returnUrl=initPartSwapGoodsSel.action"+"'");
			this.clearMessages();
			this.addActionMessage(getText(salseSuccessMsg));
			request.setAttribute("flag", GlobalConstants.MOVE);
		}else{
			String salseSuccessMsg="顾客:"+salesBasicPo.getSsesbpersonName()+"  销售单"+newBillID+"提交成功";
			request.setAttribute("url", "'initPartSwapGoodsSel.action?moduleID="+moduleID+"'");
			this.clearMessages();
			this.addActionMessage(getText(salseSuccessMsg));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		}
				
		return SUCCESS;
	}
	
	/**
	 * 初始化向HIS系统提交待退费信息
	 */
	public String initRefundNotChargeInfoToHisInsert() {
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
	 * 向HIS系统提交待退费信息
	 */
	public String insertRefundNotChargeInfoToHis() {
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
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    // 1 新增
		logPo.setsLogContent("配镜单：【" + Utility.getName(salesBasicPo.getSsesbsalesid()) + "】向HIS系统提交待退费信息！");
		logPo.setsLogDepartmentID(personInfoPo.getDepartmentID());
		
		hisMgr.insertSalesNotChargeInfoToHis(Utility.getName(salesBasicPo.getSsesbsalesid()), "2", "4",personInfoPo,logPo);
	
		this.clearMessages();
		this.addActionMessage(getText("提交成功！"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}
	
	
}
