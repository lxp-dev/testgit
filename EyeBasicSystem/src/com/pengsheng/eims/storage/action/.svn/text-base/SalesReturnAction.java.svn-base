package com.pengsheng.eims.storage.action;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.mgr.ChuzhikaMgr;
import com.pengsheng.eims.basic.mgr.CustomerMgr;
import com.pengsheng.eims.basic.mgr.UnitMgr;
import com.pengsheng.eims.basic.mgr.WarehouseConfigurationMgr;
import com.pengsheng.eims.basic.mgr.WarehouseMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.basic.persistence.GoodsInfoTempPo;
import com.pengsheng.eims.basic.persistence.RefractiveSetPo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.components.mgr.SellMirrorFrameMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.mgr.AdditionalCDetailMgr;
import com.pengsheng.eims.sales.mgr.ArrearsMgr;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangeEntryPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangePo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.storage.mgr.SalesOutMgr;
import com.pengsheng.eims.storage.mgr.SalesReturnMgr;
import com.pengsheng.eims.system.mgr.AdditionalCostsMgr;
import com.pengsheng.eims.system.mgr.BrankCardMgr;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.AdditionalCostsPo;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.BrankCardPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class SalesReturnAction extends BaseAction{
	private SalesOutMgr salesOutMgr;	
	private WarehouseMgr warehouseMgr;	
	private CustomerMgr customerMgr;	
	private DepartmentsMgr departmentsMgr;	
    private SystemParameterMgr systemParameterMgr;	
	private SystemParameterPo systemParameterPo;	
	private String isFirstExec;
	private InTransitDetailsMgr inTransitDetailsMgr;
	private SalesReturnMgr salesReturnMgr;
	private List<PersonInfoPo> personInfoPos;
	private GoodsInfoTempPo goodsInfoTempPo;
	private AdditionalCostsMgr additionalCostsMgr;
	private List<AdditionalCostsPo> additionalCostsList;
	private AdditionalCDetailPo additionalCDetailPo;
	private AdditionalCDetailMgr additionalCDetailMgr;
	private AdditionalCostsPo additionalCostsPo;
	private SalesBasicPo salesBasicPo;
	private List<BankPo> bankPos; 
	private SellMirrorFrameMgr sellMirrorFrameMgr;
	private List<GoodsInfoPo> goodsList;
	private IntegralExchangePo integralExchangePo;	
	private List<IntegralExchangePo> integralExchangeList;
	private List<IntegralExchangeEntryPo> integralExchangeEntryList;
	private WarehouseConfigurationMgr warehouseConfigurationMgr;
	private IntegralExchangeEntryPo integralExchangeEntryPo;
	private List<IntegralExchangeEntryPo> integralExchangeEntryPolist;
	private GuitarManagementMgr guitarManagementMgr;
	private CustomerInfoMgr customerInfoMgr;
	private CustomerInfoPo customerInfoPo;
	private List<SalesBasicPo> salesBasicPos;	
	private ChuzhikaPo chuzhikaPo;	
	private ChuzhikaMgr chuzhikaMgr;	
	private ArrearsMgr arrearsMgr;	
	private List<BrankCardPo> brankCardPos;	
	private BrankCardMgr brankCardMgr;	
	private UnitMgr unitMgr;
	private List<BankPo> otherbankPos;
	private List<RefractiveSetPo> refractiveSetPos;
	
	
	public List<BankPo> getOtherbankPos() {
		return otherbankPos;
	}
	public void setOtherbankPos(List<BankPo> otherbankPos) {
		this.otherbankPos = otherbankPos;
	}
	public SellMirrorFrameMgr getSellMirrorFrameMgr() {
		return sellMirrorFrameMgr;
	}
	public void setSellMirrorFrameMgr(SellMirrorFrameMgr sellMirrorFrameMgr) {
		this.sellMirrorFrameMgr = sellMirrorFrameMgr;
	}
	public List<GoodsInfoPo> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsInfoPo> goodsList) {
		this.goodsList = goodsList;
	}
	public UnitMgr getUnitMgr() {
		return unitMgr;
	}
	public void setUnitMgr(UnitMgr unitMgr) {
		this.unitMgr = unitMgr;
	}
	public List<RefractiveSetPo> getRefractiveSetPos() {
		return refractiveSetPos;
	}
	public void setRefractiveSetPos(List<RefractiveSetPo> refractiveSetPos) {
		this.refractiveSetPos = refractiveSetPos;
	}
	public IntegralExchangePo getIntegralExchangePo() {
		return integralExchangePo;
	}
	public List<BankPo> getBankPos() {
		return bankPos;
	}

	public void setBankPos(List<BankPo> bankPos) {
		this.bankPos = bankPos;
	}

	public void setIntegralExchangePo(IntegralExchangePo integralExchangePo) {
		this.integralExchangePo = integralExchangePo;
	}
	public List<IntegralExchangePo> getIntegralExchangeList() {
		return integralExchangeList;
	}
	public void setIntegralExchangeList(
			List<IntegralExchangePo> integralExchangeList) {
		this.integralExchangeList = integralExchangeList;
	}
	public List<IntegralExchangeEntryPo> getIntegralExchangeEntryList() {
		return integralExchangeEntryList;
	}
	public void setIntegralExchangeEntryList(
			List<IntegralExchangeEntryPo> integralExchangeEntryList) {
		this.integralExchangeEntryList = integralExchangeEntryList;
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
	public List<IntegralExchangeEntryPo> getIntegralExchangeEntryPolist() {
		return integralExchangeEntryPolist;
	}
	public void setIntegralExchangeEntryPolist(
			List<IntegralExchangeEntryPo> integralExchangeEntryPolist) {
		this.integralExchangeEntryPolist = integralExchangeEntryPolist;
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
	public ArrearsMgr getArrearsMgr() {
		return arrearsMgr;
	}
	public void setArrearsMgr(ArrearsMgr arrearsMgr) {
		this.arrearsMgr = arrearsMgr;
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
	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}
	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}
	public AdditionalCostsPo getAdditionalCostsPo() {
		return additionalCostsPo;
	}
	public void setAdditionalCostsPo(AdditionalCostsPo additionalCostsPo) {
		this.additionalCostsPo = additionalCostsPo;
	}
	public AdditionalCDetailMgr getAdditionalCDetailMgr() {
		return additionalCDetailMgr;
	}
	public void setAdditionalCDetailMgr(AdditionalCDetailMgr additionalCDetailMgr) {
		this.additionalCDetailMgr = additionalCDetailMgr;
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
	public GoodsInfoTempPo getGoodsInfoTempPo() {
		return goodsInfoTempPo;
	}
	public void setGoodsInfoTempPo(GoodsInfoTempPo goodsInfoTempPo) {
		this.goodsInfoTempPo = goodsInfoTempPo;
	}
	public List<PersonInfoPo> getPersonInfoPos() {
		return personInfoPos;
	}
	public void setPersonInfoPos(List<PersonInfoPo> personInfoPos) {
		this.personInfoPos = personInfoPos;
	}
	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}
	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}
	private PersonInfoMgr personInfoMgr;
	public SalesReturnMgr getSalesReturnMgr() {
		return salesReturnMgr;
	}
	public void setSalesReturnMgr(SalesReturnMgr salesReturnMgr) {
		this.salesReturnMgr = salesReturnMgr;
	}
	private List<DepartmentsPo> departmentsList;
	
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
	private PersonPermissionMgr personPermissionMgr;
	public SalesOutMgr getSalesOutMgr() {
		return salesOutMgr;
	}
	public void setSalesOutMgr(SalesOutMgr salesOutMgr) {
		this.salesOutMgr = salesOutMgr;
	}
	public WarehouseMgr getWarehouseMgr() {
		return warehouseMgr;
	}
	public void setWarehouseMgr(WarehouseMgr warehouseMgr) {
		this.warehouseMgr = warehouseMgr;
	}
	public CustomerMgr getCustomerMgr() {
		return customerMgr;
	}
	public void setCustomerMgr(CustomerMgr customerMgr) {
		this.customerMgr = customerMgr;
	}
	public DepartmentsMgr getDepartmentsMgr() {
		return departmentsMgr;
	}
	public void setDepartmentsMgr(DepartmentsMgr departmentsMgr) {
		this.departmentsMgr = departmentsMgr;
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
	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}
	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
	}
	
	/**
	 * 退款新增初始化
	 * @return
	 */
	public String initSalesReturnGoodsInsert(){
		
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
		personInfoPos = personInfoMgr.getPersoninfoPoListByJobType("1",personInfoPo.getDepartmentID(),systemParameterPo);
		
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,personInfoPo.getDepartmentID());		
		
		bankPos = brankCardMgr.getOnlyBankList();
		
		otherbankPos=brankCardMgr.getOtherBankList();
		//附加费填充
		additionalCostsList=additionalCostsMgr.getAdditionalCostsList();
		return SUCCESS;
	}
	/**
	 * 新增退款
	 * @return
	 */
	public String insertSalesReturnGoods(){
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
		
		//附加费填充
		additionalCostsList=additionalCostsMgr.getAdditionalCostsList();
		personInfoPos = personInfoMgr.getPersoninfoPoListByJobType("1",personInfoPo.getDepartmentID(),systemParameterPo);
		
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,personInfoPo.getDepartmentID());
		
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
		String salseID = "X" + personInfoPo.getDepartmentID() + personInfoPo.getMachinery() + numHeadFormat.format(new Date());
		String salesType = Utility.getName(request.getParameter("cstpgoodscategory"));		
		
		SalesBasicPo salesBasicPo =new SalesBasicPo();
		salesBasicPo.setSsesbcustomerid(Utility.getName(request.getParameter("smecicustomerid")));
		salesBasicPo.setSsesbsalesid(Utility.getName(salseID));
		salesBasicPo.setSsesbsalerid(Utility.getName(request.getParameter("ssesbsalerid")));
		salesBasicPo.setSsesbsalesvalue(Utility.getName(request.getParameter("rpriceOrFjSum")));
		salesBasicPo.setSsesbpricesum(Utility.getName(request.getParameter("rpriceOrFjSum")));
		salesBasicPo.setSsesbwithdrawpersonid(Utility.getName(personInfoPo.getId()));
		salesBasicPo.setSsesbshopcode(personInfoPo.getDepartmentID());
		salesBasicPo.setSsesbcustomerid( salesReturnMgr.getCustomerId(request.getParameter("smecimemberid")).getSsesbcustomerid());
		salesBasicPo.setSsesblocation(personInfoPo.getDepartmentID());
		salesBasicPo.setSsesbdepartmentid(personInfoPo.getDepartmentID());		
		salesBasicPo.setSsesbvalueflag("1");
		salesBasicPo.setSsesbcheckoutflag("0");
		salesBasicPo.setSsesbarrearsvalue("0");
		salesBasicPo.setSsesbpsalsvalue(Utility.getName(salesBasicPo.getSsesbsalesvalue()));
		salesBasicPo.setSsesbpaycash(Utility.getName(salesBasicPo.getSsesbsalesvalue()));
		salesBasicPo.setSsesblryid(Utility.getName(personInfoPo.getId()));
		salesBasicPo.setSsesbsalesremark("门店直接退款");
		salesBasicPo.setSsesbsalestype("2");
		salesBasicPo.setSsesbrecipetype(Utility.getName(request.getParameter("recipetype")));  //处方类型		

		List<SalesDetailPo> salesDetailPoList=new ArrayList<SalesDetailPo>();
		if(goodsInfoTempPo != null){
			for(int i=0;i<goodsInfoTempPo.getGoodsid().length;i++ ){
				
				SalesDetailPo salesDetailPo=new SalesDetailPo();
				salesDetailPo.setFspstealtheffective(systemParameterPo.getFspstealtheffective());
				salesDetailPo.setSsesdsalesid(Utility.getName(salseID));
				salesDetailPo.setSsesdsalesitemid(Utility.getName(goodsInfoTempPo.getGoodsid()[i]));
				salesDetailPo.setSsesditemid(Utility.getName(goodsInfoTempPo.getPcbarcode()[i]));
				salesDetailPo.setSsesdsalesitemname(Utility.getName(goodsInfoTempPo.getGoodsname()[i]));
				salesDetailPo.setSsesdsprice(Utility.getName(goodsInfoTempPo.getRetailprice()[i]));
				salesDetailPo.setSsesdnumber(Utility.getName(goodsInfoTempPo.getGoodsquantity()[i]));
				salesDetailPo.setSsesdunitprice(Utility.getName(goodsInfoTempPo.getNottaxrate()[i]));
				salesDetailPo.setSsesdcostsprive(Utility.getName(goodsInfoTempPo.getCostprice()[i]));
				salesDetailPo.setSsesdpricesum(Utility.getName(goodsInfoTempPo.getRetailpriceamount()[i]));
				salesDetailPo.setSsesdsalesvalue(Utility.getName(goodsInfoTempPo.getRetailpriceamount()[i]));
				salesDetailPo.setSsesdcommoditiesflag(Utility.getName(goodsInfoTempPo.getGoodsid()[i].substring(0,1)));
				salesDetailPo.setSsesdglassflag(Utility.getName(request.getParameterValues("eyeLeftOrRights")[i]));
				if(systemParameterPo.getFspstealtheffective().equals("2")||systemParameterPo.getFspstealtheffective().equals("1")){
					salesDetailPo.setSsesdguaranteeperiod(Utility.getName(goodsInfoTempPo.getGuaranteeperiod()[i]));
					salesDetailPo.setSsesdbatch(Utility.getName(goodsInfoTempPo.getBatch()[i]));
				}
	
				salesDetailPo.setSalseType(salesType);
				salesDetailPoList.add(salesDetailPo);
			}
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("23");    // 退款
		logPo.setsLogContent("配镜单:" + salseID + "直接退款!");
		
		InTransitPo inTransitPo = new InTransitPo();
		inTransitPo.setSseitsalesid(salseID);
		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		inTransitPo.setSseitstate("14");
				
		//附加费用插入
		List<AdditionalCDetailPo> additionalCDetailPoList=new ArrayList<AdditionalCDetailPo>();
		String[] sseadditionalid=additionalCDetailPo.getSseadditionalid().split(",");
		String[] ssenumber = additionalCDetailPo.getSsenumber().split(",");
		for(int i=1;i<sseadditionalid.length;i++){
			AdditionalCDetailPo temp = new AdditionalCDetailPo();
			temp.setSsesalesid(salseID);
			temp.setSseadditionalid(sseadditionalid[i].trim());
			temp.setSsenumber(ssenumber[i].trim());
			additionalCDetailPoList.add(temp);
		}
		
		salesBasicPo.setSsesbposid(personInfoPo.getId());

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
			salesLogPo.setSseslsalesid(salseID);
			salesLogPo.setSseslpaymenttype("5");
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
		salesBasicPo.setSsesbpaycash(bigd.toString());
		
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
			salesLogPo.setSseslsalesid(salseID);
			salesLogPo.setSseslpaymenttype("5");
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
		salesBasicPo.setNowintegral(jftotal.toString());
		salesBasicPo.setSsesbintegralprice(jfdktotal.multiply(jftotal).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		
		BigDecimal yhktotal = new BigDecimal("0.00");
		//银行卡
		if(yhkvs == null){
			yhkvs = new String[0];
		}		
		for(int i=0; i<yhkvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(yhkvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salseID);
			salesLogPo.setSseslpaymenttype("5");
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
			salesLogPo.setSseslsalesid(salseID);
			salesLogPo.setSseslpaymenttype("5");
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
			salesLogPo.setSseslsalesid(salseID);
			salesLogPo.setSseslpaymenttype("5");
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
		salesBasicPo.setSsesbbankcard(yhktotal.toString());
		
		BigDecimal czktotal = new BigDecimal("0.00");
		if(czkvs == null){
			czkvs = new String[0];
		}
		for(int i=0; i<czkvs.length; i++){
			if("".equals(Utility.getName(czkvs[i]))){
				czkvs[i]="0.00";
			}
			BigDecimal bigd2 = new BigDecimal(czkvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salseID);
			salesLogPo.setSseslpaymenttype("5");
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
		salesBasicPo.setSsesbstoredcard(czktotal.toString());
		
		//现金合计 = 现金 - 找零
		bigd = bigd.setScale(2, BigDecimal.ROUND_HALF_UP);
		salesBasicPo.setSsesbpaycash(bigd.toString());
			
		List<ChuzhikaPo> czklist = new ArrayList<ChuzhikaPo>();
		for(int i=0; i<czkvs.length; i++){
			if(Float.parseFloat(czkvs[i]) > 0){
				ChuzhikaPo po = new ChuzhikaPo();
				po.setCstczkchongzhijine("-"+czkvs[i]);
				po.setCstczkjiankaren(personInfoPo.getId());
				po.setCstczkjine(czkyes[i]);
				po.setCstczkid(czkids[i]);
				po.setCstczkllinkbillid(salseID);
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
	
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		
		String newsalseID = salesReturnMgr.insertSalesReturnProcess(systemParameterPo,salesDetailPoList,salesBasicPo,inTransitPo,salesLogPos, czklist,djqlist,logPo,additionalCDetailPoList);
		
		String url = "''initSalesReturnGoodsInsert.action?moduleID={0}''"; 
		List<String> params = new ArrayList<String>(); 
		params.add(moduleID); 
		request.setAttribute("url", MessageFormat.format(url, params.toArray()));
		
		String msg = "配镜单退款失败!";
		if (!newsalseID.equals("")){
			request.setAttribute("print","1");
			request.setAttribute("salseID",newsalseID);
			msg = "配镜单号：" + salseID + ",退款成功!";
		}
		
		if(salesType.equals("1")){
			request.setAttribute("ssesborderstype", "1");
		}if(salesType.equals("2")){
			request.setAttribute("ssesborderstype", "3");
		}else{
			request.setAttribute("ssesborderstype", "5");
		}
		
		this.clearMessages();
		this.addActionMessage(getText(msg));
		request.setAttribute("flag", GlobalConstants.INSERT);
		
		return SUCCESS;
	}
	//客户信息查询
	public String selSalesReturnManagement() {
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
		// 得到当前登录人的部门 根据部门取出仓位
		personInfoPos = personInfoMgr.getPersoninfoPoListByJobType("1",personInfoPo.getDepartmentID(),systemParameterPo);
		
		SalesBasicPo salesBasicPotemp = new SalesBasicPo();
		salesBasicPotemp.setSsesbposid(personInfoPo.getId());
		salesBasicPotemp.setSsesbshopcode(personInfoPo.getDepartmentID());
		
		salesBasicPo = arrearsMgr.getArrearsValues(salesBasicPotemp); 
		
		bankPos = brankCardMgr.getOnlyBankList();		
		otherbankPos=brankCardMgr.getOtherBankList();
		
		String memberId = Utility.getName(request.getParameter("smecimemberid"));
		String salesid = Utility.getName(request.getParameter("fmmsalesid"));

		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecimemberid(memberId);
		customerInfoPo.setFmmsalesid(salesid);
		customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
		
		request.setAttribute("smecimemberid", memberId);
		request.setAttribute("fmmsalesid", salesid);

		if (StringUtils.isNotEmpty(salesid)) {
			// 按配镜单号查询顾客信息
			customerInfoPo = guitarManagementMgr.getCustmorInfo(customerInfoPo);
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday()
						.substring(0, 4);
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
		//附加费填充
		additionalCostsList=additionalCostsMgr.getAdditionalCostsList();

		return SUCCESS;
	}
	
	
	/**
	 * 查询商品条码信息(All)
	 */
	public String selectSellMirrorFrameAlls() throws Exception {
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
	
		String goodsname = Utility.getName(request.getParameter("goodsname"));
		String goodsid = Utility.getName(request.getParameter("goodsid"));
		String supplierName = Utility.getName(request.getParameter("supplierName"));
		String supplierID = Utility.getName(request.getParameter("supplierID"));
		String brandName = Utility.getName(request.getParameter("brandName"));
		String brandID = Utility.getName(request.getParameter("brandID"));
		String istakeframe = Utility.getName(request.getParameter("istakeframe"));		
		String goodscategory = Utility.getName(request.getParameter("goodscategory"));
		String accessoryType = Utility.getName(request.getParameter("accessoryType"));
		String oneselfframe = Utility.getName(request.getParameter("oneselfframe"));
		String iscustomize = Utility.getName(request.getParameter("iscustomize"));
		String materialType = Utility.getName(request.getParameter("materialType"));// 镜片材质，玻璃树脂
		String glassFlag= Utility.getName(request.getParameter("glassFlag"));
		String recipeType= Utility.getName(request.getParameter("recipeType"));
		String ismutiluminosity= Utility.getName(request.getParameter("ismutiluminosity"));
		String other = Utility.getName(request.getParameter("other"));
		String othergoodscategory = Utility.getName(request.getParameter("othergoodscategory"));
		String accessoriestype = Utility.getName(request.getParameter("accessoriestype")); 
		String kucun = Utility.getName(request.getParameter("kucun"));
		String pricedown = Utility.getName(request.getParameter("pricedown"));
		String priceup = Utility.getName(request.getParameter("priceup"));
		String refractive = Utility.getName(request.getParameter("refractive"));
		String whichretail=Utility.getName(request.getParameter("whichretail"));
		request.setAttribute("whichretail", whichretail);
		String select_retail=Utility.getName(request.getParameter("select_retail"));
		request.setAttribute("select_retail", select_retail);
		
		refractiveSetPos = unitMgr.getRefractiveSetList();
		
		String[] sphs = request.getParameterValues("sph");
		String rsph = Utility.getName(request.getParameter("rsph"));
		String lsph = Utility.getName(request.getParameter("lsph"));
		
		if(sphs != null){
			if("".equals(rsph)){
				rsph = sphs[0];
			}
			if("".equals(lsph)){
				lsph = sphs[1];
			}
		}
		
		String[] cyls = request.getParameterValues("cyl");
		String rcyl = Utility.getName(request.getParameter("rcyl"));
		String lcyl = Utility.getName(request.getParameter("lcyl"));
		if("".equals(rcyl)&&"".equals(other)){
			if("".equals(Utility.getName(cyls[0]))){
				rcyl = "0.00";
			}else{
				rcyl = cyls[0];
			}
		}
		if("".equals(lcyl)&&"".equals(other)){
			if("".equals(Utility.getName(cyls[1]))){
				lcyl = "0.00";
			}else{
				lcyl = cyls[1];
			}
			
		}
		String[] adds = request.getParameterValues("add");	
		String radd = Utility.getName(request.getParameter("radd"));
		String ladd = Utility.getName(request.getParameter("ladd"));
		if("".equals(radd) && adds != null && "".equals(other)){
			radd = adds[0];
		}
		if("".equals(ladd) && adds != null && "".equals(other)){
			ladd = adds[1];
		}
		
		String rl = "";
        if (goodscategory.equals("3") || goodscategory.equals("4")){
        	rl = "".equals(Utility.getName(request.getParameter("rl"))) ? "R":Utility.getName(request.getParameter("rl"));
        }else if (goodscategory.equals("1")){
        	rl = "F";
        }
			
		GoodsInfoPo po = new GoodsInfoPo();
		po.setBgirefractive(refractive);
		po.setBgigoodsname(goodsname);
		po.setBgigoodsname(goodsname);
		po.setBgiretailbeginprice(pricedown);
		po.setBgiretailendprice(priceup);
		po.setBgigoodsid(goodsid);
		po.setBgisupplierid("ZZ".equals(oneselfframe) ? oneselfframe:supplierID);
		po.setBgiunitid(oneselfframe);
		po.setBgibrandid(brandID);
		po.setBgiwhichretail(whichretail);
		po.setBgiismendretail(select_retail);
		DepartmentsPo tdpo = new DepartmentsPo();
		tdpo.setBdpdepartmentid(personInfoPo.getDepartmentID());
		DepartmentsPo dpo = departmentsMgr.getDepartment(tdpo);
		
		po.setBgiwhichretail(dpo.getBdpwhichretail());
        if (goodscategory.equals("2")){
        	po.setBgiaccessoriestype(accessoryType);
        }
        if(!"".equals(other)){
        	if(!"".equals(goodscategory)){
        		goodscategory = "";
        	}
        	po.setBgigoodscategoryid(othergoodscategory);
        	po.setBgiaccessoriestype(accessoriestype);
        }else{
        	po.setBgigoodscategoryid(goodscategory);
        }
        if(!"ZZ".equals(oneselfframe)){
        	po.setBgiother(other);
            po.setBgiiscustomize(iscustomize);        
            if("R".equals(rl)||"".equals(rl)){
    			po.setBgisph(rsph);
    			po.setBgicyl(rcyl);
    			po.setBgibelowplusluminosity(radd);
    			po.setBgiflag("R");
    		}else if("L".equals(rl)){
    			po.setBgisph(lsph);
    			po.setBgicyl(lcyl);
    			po.setBgibelowplusluminosity(ladd);
    			po.setBgiflag("L");
    		}
    		po.setBgieyeglassmaterialtype(materialType);     
    		po.setBgiismutiluminosity(ismutiluminosity);
        }
        po.setBgigoodsquantity(kucun);
		po.setBgiwarehouseid(personInfoPo.getDepartmentID());
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		
		po.setQueryType(Utility.getName(systemParameterPo.getFspsalestype()));   //判断是否允许负库存
		po.setSystemparameterlevel(systemParameterPo.getFspisusegoodslevel());
		
		int count = 0;
		if("".equals(othergoodscategory)&&!"".equals(other)){
			count = 0;
		}else{
			count = sellMirrorFrameMgr.getSellMirrorFrameCountAll(po);
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
			goodsList = sellMirrorFrameMgr.getSellMirrorFrameListAll(po, page.getStart(), page.getPageSize());
			request.setAttribute(Pagination.PAGINATION, page);
		} else {
			goodsList = null;
		}
		
		request.setAttribute("refractive",refractive);
		request.setAttribute("kucun",kucun);
		request.setAttribute("oneselfframe",oneselfframe);
		request.setAttribute("accessoriestype", accessoriestype);
		request.setAttribute("othergoodscategory", othergoodscategory);
		request.setAttribute("goodscategory", goodscategory);
		request.setAttribute("accessoryType", accessoryType);
		request.setAttribute("goodsname", goodsname);
		request.setAttribute("goodsid", goodsid);
		request.setAttribute("supplierName", supplierName);
		request.setAttribute("supplierID", supplierID);
		request.setAttribute("brandName", brandName);
		request.setAttribute("brandID", brandID);
		request.setAttribute("istakeframe", istakeframe);
		request.setAttribute("rl",rl);
		request.setAttribute("rsph",rsph);
		request.setAttribute("rcyl",rcyl);
		request.setAttribute("radd",radd);
		request.setAttribute("lsph",lsph);
		request.setAttribute("lcyl",lcyl);
		request.setAttribute("ladd",ladd);
		request.setAttribute("materialType",materialType );
		request.setAttribute("glassFlag",glassFlag );
		request.setAttribute("recipeType",recipeType );
		request.setAttribute("iscustomize",iscustomize);
		request.setAttribute("ismutiluminosity",ismutiluminosity);
		request.setAttribute("oneselfframe",oneselfframe );
		request.setAttribute("other",other);
		request.setAttribute("pricedown",pricedown);
		request.setAttribute("priceup",priceup);
		
		return SUCCESS;
	}
}
