/**
 * 
 */
package com.pengsheng.eims.sales.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.mgr.FittingTemplateTypeMgr;
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.basic.persistence.FittingTemplateTypePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.member.persistence.SmsRecordPo;
import com.pengsheng.eims.sales.mgr.CashCouponMgr;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.mgr.RegisteredMgr;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.system.mgr.BrankCardMgr;
import com.pengsheng.eims.system.mgr.PersonInfoMgr;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Tools;
import com.pengsheng.eims.util.tools.Utility;

/**
 * @author Liuqian
 * 
 */
public class RegisteredAction extends BaseAction {

	private PersonPermissionMgr personPermissionMgr;

	private RegisteredMgr registeredMgr;

	private CustomerInfoMgr customerInfoMgr;

	private CustomerInfoPo customerInfoPo;

	private List<RegisteredCategoryPo> registeredPayments; // 付费挂号费

	private List<RegisteredCategoryPo> registeredRefunds; // 退费挂号类别

	private List<RegisteredDetailsPo> registeredDetailsPoList; // 当天顾客挂号未结款挂号费用
	private List<RegisteredDetailsPo> registeredDetailsPoRefundsList; // 当天顾客挂号未结款退费用

	private List<RegisteredDetailsPo> registereds;
	
	private SystemParameterPo systemParameterPo;
	
	private SystemParameterMgr systemParameterMgr;
	
	private FittingTemplateTypeMgr fittingTemplateTypeMgr = null;	
	
	private List<BankPo> bankPos;
	
	private BrankCardMgr brankCardMgr;	
	
	private GuitarManagementMgr guitarManagementMgr;
	
	private List<PersonInfoPo> optometryPersonInfoPos;
	
	private PersonInfoMgr personInfoMgr;
	
	private CashCouponMgr cashCouponMgr;
	
	private CashCouponPo cashCouponPo;
	
	private List<BankPo> otherbankPos;
	
	private RegisteredDetailsPo registeredDetailsPo;
	
	public RegisteredDetailsPo getRegisteredDetailsPo() {
		return registeredDetailsPo;
	}

	public void setRegisteredDetailsPo(RegisteredDetailsPo registeredDetailsPo) {
		this.registeredDetailsPo = registeredDetailsPo;
	}

	public CashCouponMgr getCashCouponMgr() {
		return cashCouponMgr;
	}

	public void setCashCouponMgr(CashCouponMgr cashCouponMgr) {
		this.cashCouponMgr = cashCouponMgr;
	}

	public CashCouponPo getCashCouponPo() {
		return cashCouponPo;
	}

	public void setCashCouponPo(CashCouponPo cashCouponPo) {
		this.cashCouponPo = cashCouponPo;
	}

	public List<BankPo> getOtherbankPos() {
		return otherbankPos;
	}

	public void setOtherbankPos(List<BankPo> otherbankPos) {
		this.otherbankPos = otherbankPos;
	}

	public List<PersonInfoPo> getOptometryPersonInfoPos() {
		return optometryPersonInfoPos;
	}

	public void setOptometryPersonInfoPos(List<PersonInfoPo> optometryPersonInfoPos) {
		this.optometryPersonInfoPos = optometryPersonInfoPos;
	}

	public PersonInfoMgr getPersonInfoMgr() {
		return personInfoMgr;
	}

	public void setPersonInfoMgr(PersonInfoMgr personInfoMgr) {
		this.personInfoMgr = personInfoMgr;
	}

	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}

	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}

	public List<BankPo> getBankPos() {
		return bankPos;
	}

	public void setBankPos(List<BankPo> bankPos) {
		this.bankPos = bankPos;
	}

	public BrankCardMgr getBrankCardMgr() {
		return brankCardMgr;
	}

	public void setBrankCardMgr(BrankCardMgr brankCardMgr) {
		this.brankCardMgr = brankCardMgr;
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

	public RegisteredMgr getRegisteredMgr() {
		return registeredMgr;
	}

	public void setRegisteredMgr(RegisteredMgr registeredMgr) {
		this.registeredMgr = registeredMgr;
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

	public List<RegisteredCategoryPo> getRegisteredPayments() {
		return registeredPayments;
	}

	public void setRegisteredPayments(
			List<RegisteredCategoryPo> registeredPayments) {
		this.registeredPayments = registeredPayments;
	}

	public List<RegisteredCategoryPo> getRegisteredRefunds() {
		return registeredRefunds;
	}

	public void setRegisteredRefunds(
			List<RegisteredCategoryPo> registeredRefunds) {
		this.registeredRefunds = registeredRefunds;
	}

	public List<RegisteredDetailsPo> getRegisteredDetailsPoList() {
		return registeredDetailsPoList;
	}

	public void setRegisteredDetailsPoList(
			List<RegisteredDetailsPo> registeredDetailsPoList) {
		this.registeredDetailsPoList = registeredDetailsPoList;
	}

	public List<RegisteredDetailsPo> getRegistereds() {
		return registereds;
	}

	public void setRegistereds(List<RegisteredDetailsPo> registereds) {
		this.registereds = registereds;
	}

	public String initRegistered() {
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo)session.get("person");
		
		request.setAttribute("arg0", request.getParameter("arg0"));
		if (!"".equals(Utility.getName(request.getParameter("regMemberID")))) {
			request.setAttribute("regMemberID", request.getParameter("regMemberID"));
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,loginPersonInfoPo.getDepartmentID());		
		
		optometryPersonInfoPos = personInfoMgr.getModulePersoninfoPoList("S0203",loginPersonInfoPo.getDepartmentID());
		
		List<BankPo> bankList = brankCardMgr.getNonCashBankList();
		bankPos = new ArrayList<BankPo>();
		otherbankPos = new ArrayList<BankPo>();
		
		for (int i = 0; i < bankList.size(); i++){
			if (bankList.get(i) != null){
				if (Utility.getName(bankList.get(i).getBbtype()).equals("2")){
					bankPos.add(bankList.get(i));
				}else{
					otherbankPos.add(bankList.get(i));
				}	
			}
		}
		
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		
		request.setAttribute("departmentID", loginPersonInfoPo.getDepartmentID());
		request.setAttribute("tid", loginPersonInfoPo.getId());
		request.setAttribute("moduleID", moduleID);

		//获得打印结算单信息----------------------------
		String actionTypeID = "36";
		FittingTemplateTypePo fittingTemplateTypePo = new FittingTemplateTypePo();
		fittingTemplateTypePo = fittingTemplateTypeMgr.getFittingTemplateTypePo(actionTypeID);
		
		request.setAttribute("fittingTemplateTypePo", fittingTemplateTypePo);
		//获得打印结算单信息----------------------------
		
		return SUCCESS;
	}

	public String initRegisteredSel() {
		PersonInfoPo loginPersonInfoPo = (PersonInfoPo)session.get("person");
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		List<BankPo> bankList = brankCardMgr.getNonCashBankList();
		bankPos = new ArrayList<BankPo>();
		otherbankPos = new ArrayList<BankPo>();
		
		for (int i = 0; i < bankList.size(); i++){
			if (bankList.get(i) != null){
				if (Utility.getName(bankList.get(i).getBbtype()).equals("2")){
					bankPos.add(bankList.get(i));
				}else{
					otherbankPos.add(bankList.get(i));
				}	
			}
		}
		
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);

		if (!Utility.getName(request.getParameter("memberID")).equals("")) {
			if (customerInfoPo == null) {
				customerInfoPo = new CustomerInfoPo();
			}
			customerInfoPo.setSmecimemberid(request.getParameter("memberID"));
		}
		customerInfoPo.setSmecicustomerid("");
		customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,loginPersonInfoPo));
		customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
		
		optometryPersonInfoPos = personInfoMgr.getPersoninfoPoListByJobType("3",loginPersonInfoPo.getDepartmentID(),systemParameterPo);
		
		if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
			// 取付费挂号费
			registeredPayments = registeredMgr.getSelValue("1", "1");
			// 取退费挂号费
			registeredRefunds = registeredMgr.getSelValue("1", "2");

			// 取当天顾客未结款费用
			registeredDetailsPoList = registeredMgr.getRegisteredDetails(customerInfoPo.getSmecicustomerid(),"1");
			registeredDetailsPoRefundsList = registeredMgr.getRegisteredDetails(customerInfoPo.getSmecicustomerid(),"2");
		}
		
		request.setAttribute("departmentID", loginPersonInfoPo.getDepartmentID());
		request.setAttribute("tid", loginPersonInfoPo.getId());

		return SUCCESS;
	}

	public String insertRegistered() throws Exception {
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		String uuid = UUIDHexGenerator.getInstance().generate();
		String registeredType = Utility.getName(request.getParameter("registeredType"));
		String paytype = "";
		if("0".equals(registeredType)){
			paytype = "6";
		}else if("1".equals(registeredType)){
			paytype = "7";
		}
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		registereds = new ArrayList<RegisteredDetailsPo>();
		for (int i=0; i<registeredDetailsPo.getScrrdids().length; i++) {
			if(registeredDetailsPo.getScrrdids()[i] != null){
				RegisteredDetailsPo rpo = new RegisteredDetailsPo();
				rpo.setScrrddetailsid(!"".equals(Utility.getName(registeredDetailsPo.getScrrddetailsid())) ? registeredDetailsPo.getScrrddetailsid() : uuid);
				rpo.setScrrdcustomerid(customerInfoPo.getSmecicustomerid());
				rpo.setScrrdregister(personInfoPo.getId());
				rpo.setScrrdshopcode(personInfoPo.getDepartmentID());
				rpo.setScrrdcasher(personInfoPo.getId());
				rpo.setScrrdid(registeredDetailsPo.getScrrdids()[i]);
				rpo.setScrrdregisterid(registeredDetailsPo.getScrrdregisterids()[i]);
				rpo.setScrrdamounttype(registeredDetailsPo.getScrrdamounttypes()[i]);
				rpo.setScrrdcheckperson(registeredDetailsPo.getScrrdcheckpersons()[i]);
				
				registereds.add(rpo);
			}
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    //新增
		logPo.setsLogContent("中心挂号会员卡号："+customerInfoPo.getSmecimemberid()+" 新增");
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String orderType = request.getParameter("ssesborderstype");
		String checkoutFlag = Utility.getName(request.getParameter("checkoutFlag"));
		String sseslpaymenttype = Utility.getName(request.getParameter("sseslpaymenttype"));
		String returnvalue = Utility.getName(request.getParameter("return"));
		
		if(returnvalue.equals("")){
			sseslpaymenttype = "6";
		}else{
			sseslpaymenttype = "7";
		}
		
		SalesBasicPo sales = new SalesBasicPo();
		sales.setSsesbsalesid(request.getParameter("salseID"));
		sales.setSsesborderstype(orderType);
		sales.setSsesbcheckoutflag(checkoutFlag);
		sales.setSsesbposid(personInfoPo.getId());
		sales.setSseslpaymenttype(sseslpaymenttype);
		sales.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());

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
		
		List<SalesLogPo> salesLogPos = new ArrayList<SalesLogPo>();
		
		BigDecimal bigd = new BigDecimal("0.00");
		if(xjvs == null){
			xjvs = new String[0];
		}
		for(int i=0; i<xjvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(xjvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(request.getParameter("salseID"));
			salesLogPo.setSseslpaymenttype(paytype);
			salesLogPo.setSseslconsumptionid("1");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(xjvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("2");
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
			salesLogPo.setSseslsalesid(request.getParameter("salseID"));
			salesLogPo.setSseslpaymenttype(paytype);
			salesLogPo.setSseslconsumptionid("2");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(jfvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslintegralprice(jfdktotal.multiply(bigd2).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("2");
			
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
			salesLogPo.setSseslsalesid(request.getParameter("salseID"));
			salesLogPo.setSseslpaymenttype(paytype);
			salesLogPo.setSseslconsumptionid("3");
			salesLogPo.setSseslsourceid(yhkts[i]);
			salesLogPo.setSseslprice(yhkvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("2");
			
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
			salesLogPo.setSseslsalesid(request.getParameter("salseID"));
			salesLogPo.setSseslpaymenttype(paytype);
			salesLogPo.setSseslconsumptionid("6");
			salesLogPo.setSseslsourceid(qtts[i]);
			salesLogPo.setSseslprice(qtvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("2");
			
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
			salesLogPo.setSseslsalesid(request.getParameter("salseID"));
			salesLogPo.setSseslpaymenttype(paytype);
			salesLogPo.setSseslconsumptionid("7");
			salesLogPo.setSseslsourceid(djqids[i]);
			salesLogPo.setSseslprice(djqvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("2");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}
		sales.setSsesbbankcard(yhktotal.toString());
		
		BigDecimal czktotal = new BigDecimal("0.00");
		if(czkvs == null){
			czkvs = new String[0];
		}
		for(int i=0; i<czkvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(czkvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(request.getParameter("salseID"));
			salesLogPo.setSseslpaymenttype(paytype);
			salesLogPo.setSseslconsumptionid("4");
			salesLogPo.setSseslsourceid(czkids[i]);
			salesLogPo.setSseslprice(czkvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("2");
			
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
			}else if(Float.parseFloat(czkvs[i]) < 0){
				ChuzhikaPo po = new ChuzhikaPo();
				po.setCstczkchongzhijine(Float.parseFloat(czkvs[i])*-1+"");
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
		
		if("0".equals(registeredType)){
			for(int i=0; i<djqvs.length; i++){
				if(Float.parseFloat(djqvs[i]) > 0){
					CashCouponPo couponPo=new CashCouponPo();

					couponPo.setBcccard(djqids[i]);
					couponPo.setBccuseperson(personInfoPo.getId());
					couponPo.setBccuseflag("1");
					couponPo.setBccuseamount(djqvs[i]);
					couponPo.setBcccustomer(customerInfoPo.getSmecicustomerid());
					
					djqlist.add(couponPo);
				}
			}
		}else if("1".equals(registeredType)){
			for(int i=0; i<djqvs.length; i++){
				if(Float.parseFloat(djqvs[i]) < 0){
					CashCouponPo couponPo=new CashCouponPo();

					couponPo.setBcccard(djqids[i]);
					couponPo.setBccuseperson(personInfoPo.getId());
					couponPo.setBccuseflag("0");
					couponPo.setBccuseamount(djqvs[i]);
					couponPo.setBcccustomer(customerInfoPo.getSmecicustomerid());
					
					djqlist.add(couponPo);
				}
			}
		}

		sales.setSsesbsalesvalue(Utility.getName(request.getParameter("salseValue")));		
		
		InTransitPo inTransitPo = new InTransitPo();
		inTransitPo.setSseitsalesid(sales.getSsesbsalesid());
		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		
		String content = Utility.getName(request.getParameter("content"));
		SmsRecordPo smsRecordPo=new SmsRecordPo();
		smsRecordPo.setFsrsendcontext(content);
		if("0".equals(registeredType)){
			registeredMgr.insertRegisteredDetails(registereds,sales,salesLogPos,czklist,djqlist,logPo);
		}else if("1".equals(registeredType)){
			registeredMgr.insertRegisteredDetails2(registereds,sales,salesLogPos,czklist,djqlist,logPo);
		}


		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		String url = "'initRegistered.action?customer="
				+ customerInfoPo.getSmecicustomerid() + "&caicer="
				+ Tools.GBK2Unicode(personInfoPo.getPersonName())
				+ "&DetailsID=" + (!"".equals(Utility.getName(registeredDetailsPo.getScrrddetailsid())) ? registeredDetailsPo.getScrrddetailsid() : uuid) + "'";
		request.setAttribute("url", url);

		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		

		return SUCCESS;
	}
	

	public String initRepairsCostSel() {
		
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
		
		request.setAttribute("arg0", request.getParameter("arg0"));
		if (!"".equals(Utility.getName(request.getParameter("regMemberID")))) {
			request.setAttribute("regMemberID", request.getParameter("regMemberID"));
		}
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");

		bankPos = brankCardMgr.getOnlyBankList();
		
		otherbankPos=brankCardMgr.getOtherBankList();
	
		return SUCCESS;
	}

	public String queryRepairsCost() {
		
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
		bankPos = brankCardMgr.getOnlyBankList();
		
		otherbankPos=brankCardMgr.getOtherBankList();

		if (!Utility.getName(request.getParameter("memberID")).equals("")) {
			if (customerInfoPo == null) {
				customerInfoPo = new CustomerInfoPo();
			}
			customerInfoPo.setSmecimemberid(request.getParameter("memberID"));
		}
		customerInfoPo.setSmecicustomerid("");
		customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
		customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);

		if (StringUtils.isNotEmpty(customerInfoPo.getSmecicustomerid())) {
			registeredPayments = registeredMgr.getRepairsCostList();
			registeredRefunds = registeredMgr.getRepairsCostList();
		}

		return SUCCESS;
	}

	public String insertRepairsCost() throws Exception {
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		
		SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String uuid = "WX" + personInfoPo.getDepartmentID() + personInfoPo.getMachinery() + numHeadFormat.format(new Date());
		String paytype = "";
		String registeredType = Utility.getName(request.getParameter("registeredType"));
		String registeredType2 = Utility.getName(request.getParameter("registeredType2"));
		if("0".equals(registeredType2)){
			paytype = "8";
		}else if("1".equals(registeredType2)){
			paytype = "10";
		}

		for (RegisteredDetailsPo po : registereds) {
			if(po != null){
				po.setScrrddetailsid(uuid);
				po.setScrrdcustomerid(customerInfoPo.getSmecicustomerid());
				po.setScrrdregister(personInfoPo.getId());
				po.setScrrdshopcode(personInfoPo.getDepartmentID());
				po.setScrrdcasher(personInfoPo.getId());				
				po.setScrrdflag(registeredType);
//				po.setScrrdmoney("");		
			}
		}
		
		for (int i=0; i<registereds.size(); i++) {
			if(registereds.get(i) != null){
				registereds.get(i).setScrrddetailsid(uuid);
				registereds.get(i).setScrrdcustomerid(customerInfoPo.getSmecicustomerid());
				registereds.get(i).setScrrdregister(personInfoPo.getId());
				registereds.get(i).setScrrdshopcode(personInfoPo.getDepartmentID());
				registereds.get(i).setScrrdcasher(personInfoPo.getId());				
				registereds.get(i).setScrrdflag(registeredType);
			}else{
				registereds.remove(i);
				i=i-1;
			}
		}
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("1");    //新增
		logPo.setsLogContent("维修费会员卡号："+customerInfoPo.getSmecimemberid()+" 新增");
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String orderType = request.getParameter("ssesborderstype");
		String checkoutFlag = Utility.getName(request.getParameter("checkoutFlag"));
		String sseslpaymenttype = Utility.getName(request.getParameter("sseslpaymenttype"));
		
		SalesBasicPo sales = new SalesBasicPo();
		sales.setSsesbsalesid(request.getParameter("salseID"));
		sales.setSsesborderstype(orderType);
		sales.setSsesbcheckoutflag(checkoutFlag);
		sales.setSsesbposid(personInfoPo.getId());
		sales.setSseslpaymenttype(sseslpaymenttype);
		sales.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());

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
			salesLogPo.setSseslsalesid(uuid);
			salesLogPo.setSseslpaymenttype(paytype);
			salesLogPo.setSseslconsumptionid("1");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(xjvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("3");
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
			salesLogPo.setSseslsalesid(uuid);
			salesLogPo.setSseslpaymenttype(paytype);
			salesLogPo.setSseslconsumptionid("2");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(jfvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslintegralprice(jfdktotal.multiply(bigd2).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("3");
			
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
			salesLogPo.setSseslsalesid(uuid);
			salesLogPo.setSseslpaymenttype(paytype);
			salesLogPo.setSseslconsumptionid("3");
			salesLogPo.setSseslsourceid(yhkts[i]);
			salesLogPo.setSseslprice(yhkvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("3");
			
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
			salesLogPo.setSseslsalesid(uuid);
			salesLogPo.setSseslpaymenttype(paytype);
			salesLogPo.setSseslconsumptionid("6");
			salesLogPo.setSseslsourceid(qtts[i]);
			salesLogPo.setSseslprice(qtvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("3");
			
			salesLogPos.add(salesLogPo);
			yhktotal = yhktotal.add(bigd2);
		}		
	    //代金券
		if(djqvs == null){
			djqvs = new String[0];
		}
		for(int i=0; i<djqvs.length; i++){
			if(!"".equals(djqvs[i])){
				BigDecimal bigd2 = new BigDecimal(djqvs[i]);
				SalesLogPo salesLogPo = new SalesLogPo();
				salesLogPo.setSseslsalesid(uuid);
				salesLogPo.setSseslpaymenttype(paytype);
				salesLogPo.setSseslconsumptionid("7");
				salesLogPo.setSseslsourceid(djqids[i]);
				salesLogPo.setSseslprice(djqvs[i]);
				salesLogPo.setSseslperson(personInfoPo.getId());
				salesLogPo.setSseslorderby("");
				salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
				salesLogPo.setSsesltype("3");
				
				salesLogPos.add(salesLogPo);
				yhktotal = yhktotal.add(bigd2);
			}
		}
		sales.setSsesbbankcard(yhktotal.toString());
		
		BigDecimal czktotal = new BigDecimal("0.00");
		if(czkvs == null){
			czkvs = new String[0];
		}
		for(int i=0; i<czkvs.length; i++){
			if(!"".equals(czkvs[i])){
				BigDecimal bigd2 = new BigDecimal(czkvs[i]);
				SalesLogPo salesLogPo = new SalesLogPo();
				salesLogPo.setSseslsalesid(uuid);
				salesLogPo.setSseslpaymenttype(paytype);
				salesLogPo.setSseslconsumptionid("4");
				salesLogPo.setSseslsourceid(czkids[i]);
				salesLogPo.setSseslprice(czkvs[i]);
				salesLogPo.setSseslperson(personInfoPo.getId());
				salesLogPo.setSseslorderby("");
				salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
				salesLogPo.setSsesltype("3");
				
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
			if(!"".equals(czkvs[i])){
				if(Float.parseFloat(czkvs[i]) > 0){
					ChuzhikaPo po = new ChuzhikaPo();
					po.setCstczkchongzhijine("-"+czkvs[i]);
					po.setCstczkjiankaren(personInfoPo.getId());
					po.setCstczkjine(czkyes[i]);
					po.setCstczkid(czkids[i]);
					po.setCstczkllinkbillid(uuid);
					po.setCstczklyue(czkyes[i]);
					
					po.setCstczksalesamount(Utility.getName(czkvs[i]).equals("") ? "0.00" : Utility.getName(czkvs[i]));
					po.setCstczksalesstore(personInfoPo.getDepartmentID());
					po.setCstczksalesdate("1");
					
					czklist.add(po);
				}else if(Float.parseFloat(czkvs[i]) < 0){
					ChuzhikaPo po = new ChuzhikaPo();
					po.setCstczkchongzhijine(czkvs[i]);
					po.setCstczkjiankaren(personInfoPo.getId());
					po.setCstczkjine(czkyes[i]);
					po.setCstczkid(czkids[i]);
					po.setCstczkllinkbillid(uuid);
					po.setCstczklyue(czkyes[i]);
					
					po.setCstczksalesamount(Utility.getName(czkvs[i]).equals("") ? "0.00" : Utility.getName(czkvs[i]));
					po.setCstczksalesstore(personInfoPo.getDepartmentID());
					po.setCstczksalesdate("1");
					
					czklist.add(po);
				}
			}
		}
		//代金券
		List<CashCouponPo> djqlist = new ArrayList<CashCouponPo>();
		if("0".equals(registeredType2)){
		  for(int i=0; i<djqvs.length; i++){
			  if(!"".equals(czkvs[i])){
				  if(Float.parseFloat(djqvs[i]) > 0){
						CashCouponPo couponPo=new CashCouponPo();
		
						couponPo.setBcccard(djqids[i]);
						couponPo.setBccuseperson(personInfoPo.getId());
						couponPo.setBccuseflag("1");
						couponPo.setBccuseamount(djqvs[i]);
						couponPo.setBcccustomer(customerInfoPo.getSmecicustomerid());
						
						djqlist.add(couponPo);
				  }
			  }
		  }
		}else if("1".equals(registeredType)){
			for(int i=0; i<djqvs.length; i++){
				if(!"".equals(djqids[i])){
					if(Float.parseFloat(djqvs[i]) < 0){
						CashCouponPo couponPo=new CashCouponPo();
	
						couponPo.setBcccard(djqids[i]);
						couponPo.setBccuseperson(personInfoPo.getId());
						couponPo.setBccuseflag("0");
						couponPo.setBccuseamount(djqvs[i]);
						couponPo.setBcccustomer(customerInfoPo.getSmecicustomerid());
						
						djqlist.add(couponPo);
					}
				}
			}
		}
		sales.setSsesbsalesvalue(Utility.getName(request.getParameter("salseValue")));		
		
		InTransitPo inTransitPo = new InTransitPo();
		inTransitPo.setSseitsalesid(sales.getSsesbsalesid());
		inTransitPo.setSseitdepartment(personInfoPo.getDepartmentID());
		inTransitPo.setSseitcreateperson(personInfoPo.getId());
		
		if("0".equals(registeredType2)){
			registeredMgr.insertRepairsCostDetails(registereds,sales,salesLogPos,czklist,djqlist,logPo);
		}else if("1".equals(registeredType2)){
			registeredMgr.insertRepairsCostDetails2(registereds,sales,salesLogPos,czklist,djqlist,logPo);
		}
		


		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));

		String url = "'initRepairsCostSel.action?customer="
				+ customerInfoPo.getSmecicustomerid() + "&caicer="
				+ Tools.GBK2Unicode(personInfoPo.getPersonName())
				+ "&DetailsID=" + uuid + "'";
		request.setAttribute("url", url);

		request.setAttribute("flag", GlobalConstants.UPADTE);
		
		

		return SUCCESS;
	}
	
	public void getRegisteredValuesToo() throws Exception {
		String tid = Utility.getName(request.getParameter("tid"));
		String tdptid = Utility.getName(request.getParameter("tdptid"));
		
		PrintWriter out;
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		out = response.getWriter();
		
		if(tid.equals("")){
			out.println("您个人当日挂号收银累计实收金额：0.00 ");
		}else{
			
			RegisteredDetailsPo rdpo = new RegisteredDetailsPo();
			rdpo = registeredMgr.getRegisteredPersonSumToday(tdptid,tid);

			out.println("您个人当日挂号收银累计实收金额：" + (Utility.getName(rdpo.getScrrdpersonsumtoday()).equals("") ? "0.00" : Utility.getName(rdpo.getScrrdpersonsumtoday())));
		}
		
		out.close();			
	}

	public FittingTemplateTypeMgr getFittingTemplateTypeMgr() {
		return fittingTemplateTypeMgr;
	}

	public void setFittingTemplateTypeMgr(
			FittingTemplateTypeMgr fittingTemplateTypeMgr) {
		this.fittingTemplateTypeMgr = fittingTemplateTypeMgr;
	}

	public List<RegisteredDetailsPo> getRegisteredDetailsPoRefundsList() {
		return registeredDetailsPoRefundsList;
	}

	public void setRegisteredDetailsPoRefundsList(
			List<RegisteredDetailsPo> registeredDetailsPoRefundsList) {
		this.registeredDetailsPoRefundsList = registeredDetailsPoRefundsList;
	}
	
}
