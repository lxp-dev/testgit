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
import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.components.mgr.InTransitDetailsMgr;
import com.pengsheng.eims.his.mgr.HisMgr;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.ArrearsMgr;
import com.pengsheng.eims.sales.mgr.GuitarManagementMgr;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.system.mgr.BrankCardMgr;
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
import com.pengsheng.weixin.persistence.ConfigurationPo;
import com.pengsheng.weixin.persistence.WeixinInviteFriendLogPo;

public class ArrearsAction extends BaseAction {
	
	private PersonPermissionMgr personPermissionMgr;

	private CustomerInfoPo customerInfoPo;
	
	private List<BankPo> otherbankPos;

	private SalesBasicPo salesBasicPo;

	private ArrearsMgr arrearsMgr;

	private CustomerInfoMgr customerInfoMgr;

	private List<SalesBasicPo> arrearsList;
	
	private List<BrankCardPo> brankCardPos;
	
	private ChuzhikaMgr chuzhikaMgr;
	
	private SystemParameterPo systemParameterPo;
	
	private SystemParameterMgr systemParameterMgr;
	
	private GuitarManagementMgr guitarManagementMgr;
	
	private List<BankPo> bankPos;
	
	private InTransitDetailsMgr inTransitDetailsMgr;
	
	private List<SalesDetailPo> salesDetailPos;
	
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

	public InTransitDetailsMgr getInTransitDetailsMgr() {
		return inTransitDetailsMgr;
	}

	public void setInTransitDetailsMgr(InTransitDetailsMgr inTransitDetailsMgr) {
		this.inTransitDetailsMgr = inTransitDetailsMgr;
	}

	public List<SalesDetailPo> getSalesDetailPos() {
		return salesDetailPos;
	}

	public void setSalesDetailPos(List<SalesDetailPo> salesDetailPos) {
		this.salesDetailPos = salesDetailPos;
	}

	public List<BankPo> getBankPos() {
		return bankPos;
	}

	public void setBankPos(List<BankPo> bankPos) {
		this.bankPos = bankPos;
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

	public GuitarManagementMgr getGuitarManagementMgr() {
		return guitarManagementMgr;
	}

	public void setGuitarManagementMgr(GuitarManagementMgr guitarManagementMgr) {
		this.guitarManagementMgr = guitarManagementMgr;
	}

	public ChuzhikaMgr getChuzhikaMgr() {
		return chuzhikaMgr;
	}

	public void setChuzhikaMgr(ChuzhikaMgr chuzhikaMgr) {
		this.chuzhikaMgr = chuzhikaMgr;
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

	private BrankCardMgr brankCardMgr;

	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public List<SalesBasicPo> getArrearsList() {
		return arrearsList;
	}

	public void setArrearsList(List<SalesBasicPo> arrearsList) {
		this.arrearsList = arrearsList;
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

	public ArrearsMgr getArrearsMgr() {
		return arrearsMgr;
	}

	public void setArrearsMgr(ArrearsMgr arrearsMgr) {
		this.arrearsMgr = arrearsMgr;
	}

	public CustomerInfoMgr getCustomerInfoMgr() {
		return customerInfoMgr;
	}

	public void setCustomerInfoMgr(CustomerInfoMgr customerInfoMgr) {
		this.customerInfoMgr = customerInfoMgr;
	}

	/*
	 * 
	 * 初始化欠费管理
	 */
	public String initArrearsFirst() throws Exception {
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
		//将该部门对应的配镜单模版赋值到systemParameterPo
		systemParameterPo = systemParameterMgr.getSystemParameterPoDepartmentBillTemplate(systemParameterPo,personInfoPo.getDepartmentID());	
		
		request.setAttribute("orderType", request.getParameter("orderType"));
		request.setAttribute("departmentID", personInfoPo.getDepartmentID());	
		request.setAttribute("printSalesbill", request.getParameter("printSalesbill"));
		request.setAttribute("salesid", request.getParameter("salesid"));
		return SUCCESS;
	}
	/*
	 * 
	 * 初始化欠费管理
	 */
	public String initArrears() throws Exception {
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
		
		// 初始化直接进入空页面
		if (customerInfoPo == null) {
			return SUCCESS;
		}
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		String salesID = Utility.getName(request.getParameter("salesID"));
		if (StringUtils.isNotEmpty(salesID)) {
			customerInfoPo.setFmmsalesid(salesID);
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
			customerInfoPo = arrearsMgr.getCustomerInfo(customerInfoPo);

			request.setAttribute("salesID", Utility.getName(request.getParameter("salesID")));

		} else if (StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			// 查询顾客信息
			customerInfoPo.setSmecishoplist(this.getDepartmentListByCompany(systemParameterPo,personInfoPo));
			customerInfoPo = customerInfoMgr.getCustomerInfo(customerInfoPo);
			// 年龄
			if (StringUtils.isNotEmpty(customerInfoPo.getSmecibirthday())) {
				String birthdayYear = customerInfoPo.getSmecibirthday().substring(0, 4);
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
			temp.setSsesbsalesid(Utility.getName(request
					.getParameter("salesID")));
			temp.setSsesbcustomerid(customerInfoPo.getSmecicustomerid());
			temp.setSsesbshopcode(((PersonInfoPo)session.get("person")).getDepartmentID());
			arrearsList = arrearsMgr.getArrears(temp);
		}
		
		
		return SUCCESS;
	}

	/*
	 * 初始化补齐欠款开窗
	 */
	public String initArrearsOpen() throws Exception {
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
		
		String ssesbsalesid = Utility.getName(request.getParameter("ssesbsalesid"));
		
		String allsalesvalues = customerInfoMgr.getALLsalesvalues(ssesbsalesid).getSmeciconsumptionprice();
		
		request.setAttribute("allsalesvalues",allsalesvalues);
		
		CustomerInfoPo cpo = new CustomerInfoPo();
		cpo.setFmmsalesid(ssesbsalesid);

		request.setAttribute("ssesbsalesid", ssesbsalesid);
		
		customerInfoPo = guitarManagementMgr.getCustmorInfo(cpo);
		
	    bankPos = brankCardMgr.getOnlyBankList();
		
		otherbankPos=brankCardMgr.getOtherBankList();
		
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		
		SalesDetailPo salesDetailPo = new SalesDetailPo();
		salesDetailPo.setSsesdsalesid(ssesbsalesid);

		if("2".equals(systemParameterPo.getFspupdatecredittype())){
			salesDetailPos = inTransitDetailsMgr.getGoodsInfo(salesDetailPo);
		}
		
		return SUCCESS;
	}

	/*
	 * 补齐欠款asdasd
	 */
	public String arrearsPay() throws Exception {
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

		String salesID = Utility.getName(request.getParameter("salesID"));
		String ssesbjfamount = Utility.getName(request.getParameter("ssesbjfamount"));
		String smecimemberid = Utility.getName(request.getParameter("smecimemberid"));
		
		LogisticsLogPo logPo = new LogisticsLogPo();
		logPo.setsLogName(personInfoPo.getId());
		logPo.setsLogIP(request.getRemoteAddr());
		logPo.setsLogResult(moduleID); // 模块ID
		logPo.setsLogOpID("3");    // 修改
		logPo.setsLogContent("配镜单号："+salesID+" 补齐欠款!");
		
		SalesBasicPo po = new SalesBasicPo();
		po.setSsesbsalesid(salesID);
		po.setSsesbsalerid(personInfoPo.getId());
		po.setSsesbposid(personInfoPo.getId());
		po.setSsesbjfamount(ssesbjfamount);
		
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
		
		BigDecimal xjvtotal = new BigDecimal("0.00");		
		for(int i=0; i<xjvs.length; i++){
			BigDecimal bigd2 = new BigDecimal(xjvs[i]);
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("3");
			salesLogPo.setSseslconsumptionid("1");
			salesLogPo.setSseslsourceid("");
			salesLogPo.setSseslprice(xjvs[i]);
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			salesLogPos.add(salesLogPo);
			
			xjvtotal = xjvtotal.add(bigd2);
		}		
		po.setSsesbpaycash(xjvtotal.toString());
		
		BigDecimal jftotal = new BigDecimal("0");
		BigDecimal jfdktotal = null;
		if (!"".equals(Utility.getName(systemParameterPo.getFspexchangeintegral()).trim())){
			jfdktotal = new BigDecimal(Utility.getName(systemParameterPo.getFspexchangeintegral()));
		}else{
			jfdktotal = new BigDecimal("0.00");
		}
		if(jfvs != null){
			for(int i=0; i<jfvs.length; i++){
				BigDecimal bigd2 = new BigDecimal(jfvs[i]);
				SalesLogPo salesLogPo = new SalesLogPo();
				salesLogPo.setSseslsalesid(salesID);
				salesLogPo.setSseslpaymenttype("3");
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
			
			po.setNowintegral(jftotal.toString());
			po.setSsesbintegralprice(jfdktotal.multiply(jftotal).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		}else{
			po.setNowintegral("");
		}
		
		
		
		//银行卡
		BigDecimal yhktotal = new BigDecimal("0.00");	
		if(yhkvs != null){
			for(int i=0; i<yhkvs.length; i++){
				BigDecimal bigd2 = new BigDecimal(yhkvs[i]);
				SalesLogPo salesLogPo = new SalesLogPo();
				salesLogPo.setSseslsalesid(salesID);
				salesLogPo.setSseslpaymenttype("3");
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

		}else{
			po.setSsesbbankcard("");
		}
		//其他
		if(qtvs != null){
			for(int i=0; i<qtvs.length; i++){
				BigDecimal bigd2 = new BigDecimal(qtvs[i]);
				SalesLogPo salesLogPo = new SalesLogPo();
				salesLogPo.setSseslsalesid(salesID);
				salesLogPo.setSseslpaymenttype("3");
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

		}else{
			po.setSsesbbankcard("");
		}

		
		BigDecimal czktotal = new BigDecimal("0.00");	
		if(czkvs != null){
			for(int i=0; i<czkvs.length; i++){
				BigDecimal bigd2 = new BigDecimal(czkvs[i]);
				SalesLogPo salesLogPo = new SalesLogPo();
				salesLogPo.setSseslsalesid(salesID);
				salesLogPo.setSseslpaymenttype("3");
				salesLogPo.setSseslconsumptionid("4");
				salesLogPo.setSseslsourceid(czkids[i]);
				salesLogPo.setSseslprice(czkvs[i]);
				salesLogPo.setSseslperson(personInfoPo.getId());
				salesLogPo.setSseslorderby("");
				salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
				salesLogPo.setSsesltype("1");
				
				salesLogPos.add(salesLogPo);
				
				yhktotal = yhktotal.add(bigd2);
			}
			
			po.setSsesbstoredcard(czktotal.toString());
		}else{
			po.setSsesbstoredcard("");
		}
		//代金券
		if(djqvs == null){
			djqvs = new String[0];
		}
		if(djqvs != null){
			for(int i=0; i<djqvs.length; i++){
				BigDecimal bigd2 = new BigDecimal(djqvs[i]);
				SalesLogPo salesLogPo = new SalesLogPo();
				salesLogPo.setSseslsalesid(salesID);
				salesLogPo.setSseslpaymenttype("3");
				salesLogPo.setSseslconsumptionid("7");
				salesLogPo.setSseslsourceid(djqids[i]);
				salesLogPo.setSseslprice(djqvs[i]);
				salesLogPo.setSseslperson(personInfoPo.getId());
				salesLogPo.setSseslorderby("");
				salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
				salesLogPo.setSsesltype("1");
				
				salesLogPos.add(salesLogPo);
				
				czktotal = czktotal.add(bigd2);
			}
			
			po.setSsesbstoredcard(czktotal.toString());
		}else{
			po.setSsesbbankcard("");
		}
		
		po.setSsesbbankcard(yhktotal.toString());
		
		po.setSsesbsalesvalue(Utility.getName(request.getParameter("salseValue")));		
		
		//找零
		if (!"".equals(Utility.getName(request.getParameter("zl")))){
			SalesLogPo salesLogPo = new SalesLogPo();
			salesLogPo.setSseslsalesid(salesID);
			salesLogPo.setSseslpaymenttype("3");
			salesLogPo.setSseslconsumptionid("5");   // 找零
			salesLogPo.setSseslprice(Utility.getName(request.getParameter("zl")));
			salesLogPo.setSseslperson(personInfoPo.getId());
			salesLogPo.setSseslorderby("");
			salesLogPo.setSseslshopcode(personInfoPo.getDepartmentID());
			salesLogPo.setSsesltype("1");
			
			salesLogPos.add(salesLogPo);
		}
		
		//现金合计 = 现金 - 找零
		BigDecimal zltotal = new BigDecimal(Utility.getName(request.getParameter("zl")).equals("") ? "0.00" : Utility.getName(request.getParameter("zl")));
		xjvtotal = xjvtotal.subtract(zltotal);
		xjvtotal = xjvtotal.setScale(2, BigDecimal.ROUND_HALF_UP);
		po.setSsesbpaycash(xjvtotal.toString());
		
		List<ChuzhikaPo> czklist = new ArrayList<ChuzhikaPo>();
		if(czkvs != null){
			for(int i=0; i<czkvs.length; i++){
				if(Float.parseFloat(czkvs[i]) > 0){
					ChuzhikaPo czkpo = new ChuzhikaPo();
					czkpo.setCstczkchongzhijine("-"+czkvs[i]);
					czkpo.setCstczkjiankaren(personInfoPo.getId());
					czkpo.setCstczkjine(czkyes[i]);
					czkpo.setCstczkid(czkids[i]);
					czkpo.setCstczkllinkbillid(salesID);
					czkpo.setCstczklyue(czkyes[i]);
					czkpo.setCstczksalesamount(Utility.getName(czkvs[i]).equals("") ? "0.00" : Utility.getName(czkvs[i]));
					czkpo.setCstczksalesstore(personInfoPo.getDepartmentID());
					czkpo.setCstczksalesdate("1");
					
					czklist.add(czkpo);
				}
			}
		}
		CustomerInfoPo customerInfoPo=new CustomerInfoPo();
		customerInfoPo.setSmecimemberid(smecimemberid);
		CustomerInfoPo customerPo=customerInfoMgr.getCustomerInfo(customerInfoPo);
		//代金券
		List<CashCouponPo> djqlist = new ArrayList<CashCouponPo>();
		for(int i=0; i<djqvs.length; i++){
			if(Float.parseFloat(djqvs[i]) > 0){
				CashCouponPo couponPo=new CashCouponPo();

				couponPo.setBcccard(djqids[i]);
				couponPo.setBccuseperson(personInfoPo.getId());
				couponPo.setBccuseflag("1");
				couponPo.setBccuseamount(djqvs[i]);
				couponPo.setBcccustomer(customerPo.getSmecicustomerid());
				
				djqlist.add(couponPo);
			}
		}
		
		ConfigurationPo weixin = (ConfigurationPo)session.get("weixin");
		WeixinInviteFriendLogPo weixinpo = new WeixinInviteFriendLogPo();
		if("1".equals(weixin.getWcryqhysjftype())){
			String cname = Utility.getName(request.getParameter("cname"));
			String cphone = Utility.getName(request.getParameter("cphone"));
			weixinpo.setWifltousername(cname);
			weixinpo.setWifltouserphone(cphone);
		}
		this.arrearsMgr.updateArrears(po,salesLogPos,czklist,djqlist,logPo,weixinpo,systemParameterPo);
		
		this.clearMessages();
		this.addActionMessage(getText("pay.arrears.success"));
			
		request.setAttribute("url", "'initArrearsFirst.action?orderType="+ request.getParameter("orderType") +"&salesid="+ salesID +"&printSalesbill="+ systemParameterPo.getFspprintsalesbillatbukuanflag() +"&moduleID="+moduleID+"'");
		request.setAttribute("flag", GlobalConstants.OPENUPDATE3);
		return SUCCESS;
	}
	
	/**
	 * 初始化向HIS系统提交补齐待退费信息
	 */
	public String initArrearNotChargeInfoToHisInsert() {
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
		
		List<SalesDetailPo> sdpList = hisMgr.getSalesDetailNotSetPayFeeList(hid);
		String errorMsg = "";
		
		if (sdpList.size() > 0){
			for (SalesDetailPo sdpo : sdpList){
				errorMsg = errorMsg + Utility.getName(sdpo.getSsesdsalesitemid()) + "  " + Utility.getName(sdpo.getSsesdsalesitemname()) + "\\n";
			}
		}
		
		if (!errorMsg.equals("")){
			errorMsg = "以下商品未设置收费项目：\\n" + errorMsg;            
		}
		request.setAttribute("errorMsg",errorMsg);
		
		return SUCCESS;
	}
	
	/**
	 * 向HIS系统提交补齐待退费信息
	 */
	public String insertArrearNotChargeInfoToHis() {
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
		logPo.setsLogContent("配镜单：【" + Utility.getName(salesBasicPo.getSsesbsalesid()) + "】向HIS系统提交补齐待交费信息！");
		logPo.setsLogDepartmentID(personInfoPo.getDepartmentID());
		
		hisMgr.insertSalesNotChargeInfoToHis(Utility.getName(salesBasicPo.getSsesbsalesid()), "1", "3",personInfoPo,logPo);
	
		this.clearMessages();
		this.addActionMessage(getText("提交成功！"));
		request.setAttribute("flag",GlobalConstants.OPENUPDATE);
		
		return SUCCESS;
	}

}
