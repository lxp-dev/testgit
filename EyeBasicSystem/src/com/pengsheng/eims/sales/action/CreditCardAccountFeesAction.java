package com.pengsheng.eims.sales.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.member.mgr.CustomerInfoMgr;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.CreditCardAccountFeesMgr;
import com.pengsheng.eims.sales.persistence.CardPo;
import com.pengsheng.eims.sales.persistence.CardRecordPo;
import com.pengsheng.eims.sales.persistence.FeePo;
import com.pengsheng.eims.sales.persistence.RechargeRecordPo;
import com.pengsheng.eims.system.mgr.PersonPermissionMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.PersonPermissionPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

public class CreditCardAccountFeesAction extends BaseAction {
	
	private CustomerInfoPo customerInfoPo;
	
	private RechargeRecordPo po;

	private CardPo cardPo;
	
	private CardPo oldcardPo;
	
	private CardRecordPo cardRecordPo;
	
	private CreditCardAccountFeesMgr creditCardAccountFeesMgr;
	
	private RechargeRecordPo rechargeRecordPo;

	private List<CustomerInfoPo> customerInfoList; // 顾客基本资料列表List

	private CustomerInfoMgr customerInfoMgr;
	
	private PersonPermissionMgr personPermissionMgr;
	
	public PersonPermissionMgr getPersonPermissionMgr() {
		return personPermissionMgr;
	}

	public void setPersonPermissionMgr(PersonPermissionMgr personPermissionMgr) {
		this.personPermissionMgr = personPermissionMgr;
	}

	public CardRecordPo getCardRecordPo() {
		return cardRecordPo;
	}

	public void setCardRecordPo(CardRecordPo cardRecordPo) {
		this.cardRecordPo = cardRecordPo;
	}

	public RechargeRecordPo getRechargeRecordPo() {
		return rechargeRecordPo;
	}

	public void setRechargeRecordPo(RechargeRecordPo rechargeRecordPo) {
		this.rechargeRecordPo = rechargeRecordPo;
	}

	public CardPo getCardPo() {
		return cardPo;
	}

	public void setCardPo(CardPo cardPo) {
		this.cardPo = cardPo;
	}
	
	
	public RechargeRecordPo getPo() {
		return po;
	}

	public void setPo(RechargeRecordPo po) {
		this.po = po;
	}

	
	
	public CreditCardAccountFeesMgr getCreditCardAccountFeesMgr() {
		return creditCardAccountFeesMgr;
	}

	public void setCreditCardAccountFeesMgr(
			CreditCardAccountFeesMgr creditCardAccountFeesMgr) {
		this.creditCardAccountFeesMgr = creditCardAccountFeesMgr;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}

	
	/**
	 * 新建检查充值卡--初始化新建检查充值卡
	 * @return
	 * @throws Exception
	 */
	public String initCardAndRechargeRecordNew()throws Exception{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		customerInfoPo = new CustomerInfoPo();
		return SUCCESS;
	}
	
	/**
	 * 新建检查充值卡--查询顾客基本资料信息
	 */
	public String selectCardAndRechargeRecordNew()throws Exception{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		 // 扫描会员卡得到信息
		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo = creditCardAccountFeesMgr.selectCustomerInfoNew(customerInfoPo);
			if(customerInfoPo.getSmecimemberid()!=null){
			//判断检查充值卡是否存在
			int count=creditCardAccountFeesMgr.getCardNewCount(customerInfoPo.getSmecimemberid());
			if(count > 0 ){
				customerInfoPo=new CustomerInfoPo();
				this.clearMessages();
				this.addActionMessage(getText("检查充值卡号已存在，请重新输入卡号！"));
				
			   }
			}else{
				this.clearMessages();
				this.addActionMessage(getText("此会员卡号不存在，请核对！"));
			}
		}
		return SUCCESS;
	}

	/**
	 * 新建检查充值卡--查询新建检查充值卡顾客基本资料
	 * @return
	 * @throws Exception
	 */
	public String insertCardAndRechargeRecordNew()throws Exception{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		String smecimemberid=Utility.getName(request.getParameter("customerInfoPo.smecimemberid"));//会员卡号
		String sserrcardid=Utility.getName(request.getParameter("sserrcardid"));//检查充值卡
		String ssecrcustomerid=Utility.getName(request.getParameter("smecicustomerid"));//顾客号
		String ssecrrecharge=Utility.getName(request.getParameter("ssecrrecharge"));//充值金额
		String smeciavailableamount=Utility.getName(request.getParameter("smeciavailableamount"));//可用金额
		

			cardPo=new CardPo();
			cardPo.setSseccardid(sserrcardid);
			cardPo.setSseccustomerid(ssecrcustomerid);
			cardPo.setSsecamount(ssecrrecharge);
			cardPo.setSsecavailableamount(smeciavailableamount);
			
			po=new RechargeRecordPo();
			po.setSserramount(ssecrrecharge);
			po.setSserrflag("1");
			po.setSserrcardid(sserrcardid);
			po.setSserrcustomerid(ssecrcustomerid);
			PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
			po.setSserrshopcode(personInfoPo.getDepartmentID());
			po.setSserrcreateperson(personInfoPo.getId());
			po.setSserrsourceid(personInfoPo.getId());
			creditCardAccountFeesMgr.insertCardAndRechargeRecordNew(cardPo,po);//新建检查充值卡信息
		
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag",GlobalConstants.INSERT);
			request.setAttribute("url", "'initCardAndRechargeRecordNew.action?moduleID="+moduleID+"'");

		
		return SUCCESS;
	
	}
	/**
	 * 新增新建检查充值卡
	 * @return
	 * @throws Exception
	 */
	public String creditCardAccountFeesNewInsert()throws Exception{
		
		customerInfoPo = new CustomerInfoPo();
		return SUCCESS;
	}
	/**
	 * 初始化会员新增
	 * @return
	 * @throws Exception
	 */
	public String initCreditCardAccountFeesInsert()throws Exception{
		
		customerInfoPo = new CustomerInfoPo();
		return SUCCESS;
	}
	/**
	 * 会员新增
	 * @return
	 * @throws Exception
	 */
	public String insertCreditCardAccountFees()throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String smecicustomerid=Utility.getName(request.getParameter("smecicustomerid"));
		String smecicardid=Utility.getName(request.getParameter("smecicardid"));//检查充值卡号
		String smeciamount=Utility.getName(request.getParameter("smeciamount"));//获得检查充值卡的充值金额
		String smeciavailableamount=Utility.getName(request.getParameter("smeciavailableamount"));//获得检查充值卡的卡内金额
		
		
		
		customerInfoPo.setSmeciintegral("0");
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		customerInfoPo.setSmecishopcode(personInfoPo.getDepartmentID());
		
		cardPo=new CardPo();
		cardPo.setSseccardid(smecicardid);
		cardPo.setSseccustomerid(smecicustomerid);
		cardPo.setSsecamount(smeciamount);
		cardPo.setSsecavailableamount(smeciavailableamount);
		//判断检查充值卡号是否存在
		int count=creditCardAccountFeesMgr.getCardCount("smecicardid");
		if(count>0){
			this.clearMessages();
			this.addActionMessage(getText("检查充值卡号已存在，请重新输入卡号！"));
			request.setAttribute("flag", GlobalConstants.OPENUPDATE);
			request.setAttribute("url", "'initCardAndRechargeRecordNew.action?moduleID="+moduleID+"'");
		}else{
			rechargeRecordPo=new RechargeRecordPo();
			rechargeRecordPo.setSserrflag("1");
			rechargeRecordPo.setSserrsourceid(personInfoPo.getId());
			rechargeRecordPo.setSserrcardid(smecicardid);
			rechargeRecordPo.setSserrshopcode(personInfoPo.getDepartmentID());
			rechargeRecordPo.setSserrcreateperson(personInfoPo.getId());
			rechargeRecordPo.setSserrcustomerid(smecicustomerid);
			rechargeRecordPo.setSserramount(smeciamount);
			
			creditCardAccountFeesMgr.insertCustomerInfo(customerInfoPo, cardPo, rechargeRecordPo);//新增会员信息
			
			this.clearMessages();
			this.addActionMessage(getText("struts.messages.insert.sucess"));
			request.setAttribute("flag", GlobalConstants.UPADTE);
			request.setAttribute("url", "'initCreditCardAccountFeesInsert.action?moduleID="+moduleID+"'");
		}
		return SUCCESS;
	}
	

	/**
	 * 初始化检查充值卡充值信息
	 */
	public String initCreditCardAccountFeesSel()throws Exception{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		return SUCCESS;
	}
	/**
	 * 查询检查充值卡充值信息
	 */
	public String selCreditCardAccountFees()throws Exception{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
	      // 扫描检查充值卡得到信息
		if (cardPo != null
				&& StringUtils.isNotEmpty(cardPo.getSseccardid())) {
			cardPo.setSseccustomerid("");
			cardPo = creditCardAccountFeesMgr.getCard(cardPo);
		}
		
		return SUCCESS;
	}

	/**
	 * 修改检查充值卡信息并新增充值卡消费记录表
	 */
	public String updateCardAndProcurementReceiptInsert()throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String sseccustomerid=Utility.getName(request.getParameter("sseccustomerid"));
		String ssecrecharge=Utility.getName(request.getParameter("ssecrecharge"));
		String sseccardid=Utility.getName(request.getParameter("cardPo.sseccardid"));
		String ssecamount=Utility.getName(request.getParameter("ssecamount"));//原卡内金额
		String ssecavailableamount=Utility.getName(request.getParameter("ssecavailableamount"));//原卡可用金额
		
		BigDecimal newssecamount=new BigDecimal("0");//新卡内金额 
		BigDecimal newableamount=new BigDecimal("0"); //新可用金额
		
		BigDecimal oldamount = new BigDecimal(ssecamount);//老卡内金额
		BigDecimal oldavailableamount = new BigDecimal(ssecavailableamount);//老可用金额
		
		BigDecimal newssecrrecharge = new BigDecimal(Utility.getName(ssecrecharge));//充值金额
		BigDecimal one = new BigDecimal("1");
		newssecamount=oldamount.add(newssecrrecharge);//新卡内金额的计算
		newssecamount=newssecamount.divide(one, 2, BigDecimal.ROUND_HALF_UP);
		
		newableamount=oldavailableamount.add(newssecrrecharge);//新可用金额的计算
		newableamount=newableamount.divide(one, 2, BigDecimal.ROUND_HALF_UP);
		cardPo=new CardPo();
		cardPo.setSseccardid(sseccardid);
		cardPo.setSseccustomerid(sseccustomerid);
		cardPo.setSsecamount(newssecamount.toString());
		cardPo.setSsecavailableamount(newableamount.toString());
		po=new RechargeRecordPo();
		po.setSserramount(ssecrecharge);
		po.setSserrflag("1");
		po.setSserrcardid(sseccardid);
		po.setSserrcustomerid(sseccustomerid);
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		po.setSserrshopcode(personInfoPo.getDepartmentID());
		po.setSserrcreateperson(personInfoPo.getId());
		po.setSserrsourceid(personInfoPo.getId());
		creditCardAccountFeesMgr.updateCard(cardPo, po);
	
		this.clearMessages();
		List valueList = new ArrayList();
		valueList.add(sseccardid+"卡内充值"+newssecrrecharge+"元,现卡内金额"+newssecamount+"元");
		
		this.addActionMessage(getText("struts.messages.recharge.sucess",valueList));
		request.setAttribute("flag",GlobalConstants.INSERT);
		request.setAttribute("url", "'selCreditCardAccountFees.action?moduleID="+moduleID+"'");
		
		return SUCCESS;
	}
	
	/**
	 * 检查充值卡清零查询
	 * @return
	 * @throws Exception
	 */
	public String selCreditCardAccountFeesClear()throws Exception{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		  // 扫描检查充值卡得到信息
		if (cardPo != null
				&& StringUtils.isNotEmpty(cardPo.getSseccardid())) {
			cardPo.setSseccustomerid("");
			cardPo = creditCardAccountFeesMgr.getCard(cardPo);
		}
		return SUCCESS;
	}
	/**
	 * 检查充值卡清零信息
	 * @return
	 * @throws Exception
	 */
	public String creditCardAccountFeesClear()throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		String sseccardid=Utility.getName(request.getParameter("cardPo.sseccardid"));
		String sseccustomerid=Utility.getName(request.getParameter("sseccustomerid"));
		String ssecamount=Utility.getName(request.getParameter("ssecamount"));
		cardPo=new CardPo();
		cardPo.setSseccustomerid(sseccustomerid);
		cardPo.setSseccardid(sseccardid);
		rechargeRecordPo=new RechargeRecordPo();
		rechargeRecordPo.setSserramount("-"+ssecamount);
		rechargeRecordPo.setSserrflag("4");
		rechargeRecordPo.setSserrcardid(sseccardid);
		rechargeRecordPo.setSserrcustomerid(sseccustomerid);
		PersonInfoPo personInfoPo=(PersonInfoPo)session.get("person");
		rechargeRecordPo.setSserrshopcode(personInfoPo.getDepartmentID());
		rechargeRecordPo.setSserrcreateperson(personInfoPo.getId());
		rechargeRecordPo.setSserrsourceid(personInfoPo.getId());
		creditCardAccountFeesMgr.updateCardClear(cardPo,rechargeRecordPo);
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.cleared.sucess"));
		request.setAttribute("flag", GlobalConstants.UPADTE);
		request.setAttribute("url", "'selCreditCardAccountFeesClear.action?moduleID="+moduleID+"'");
		return SUCCESS;
	}

	
	/**
	 * 初始化检查充值卡补卡信息
	 */
	public String initCreditCardAccountFeesRechargeUpCaed()throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		return SUCCESS;
	}
	/**
	 * 查询检查充值卡补卡信息
	 */
	public String initCreditCardAccountFeesRecharge()throws Exception{
		
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		// 扫描检查充值卡得到信息
		if (customerInfoPo != null
				&& StringUtils.isNotEmpty(customerInfoPo.getSmecimemberid())) {
			customerInfoPo.setSmecicustomerid("");
			customerInfoPo = creditCardAccountFeesMgr.selectCustomerInfo(customerInfoPo);
		}
		return SUCCESS;
	}
	/**
	 * 检查充值卡补卡信息
	 */
	public String insertCreditCardAccountFeesRecharge()throws Exception{
		/** ********************** 权限设置 ***************************** */
		String moduleID = Utility.getName(request.getParameter("moduleID"));
		request.setAttribute("moduleID", moduleID);
		PersonInfoPo personInfoPo1 = (PersonInfoPo) session.get("person");
		String createPerson = personInfoPo1.getId();

		PersonPermissionPo personPermissionPo = new PersonPermissionPo();
		personPermissionPo.setApplicationID("1");
		personPermissionPo.setModuleID(moduleID);
		personPermissionPo.setPersonID(createPerson);

		PersonPermissionPo permissionPo = personPermissionMgr
				.getPersonPermission(personPermissionPo);// 模块权限获取

		request.setAttribute("permissionPo", permissionPo);
		/** ********************** 权限设置 ***************************** */
		
		
		String ssecroldcardid=Utility.getName(request.getParameter("smecicardid"));//原充值卡号
		String ssecrcardid=Utility.getName(request.getParameter("ssecrcardid"));//新充值卡号
		String ssecrcustomerid=Utility.getName(request.getParameter("smecicustomerid"));//顾客号
		String ssecramount=Utility.getName(request.getParameter("smeciamount"));//原卡内金额
		String ssecridcard=Utility.getName(request.getParameter("ssecridcard"));//身份证号
		String ssecrrecharge=Utility.getName(request.getParameter("ssecrrecharge"));//充值金额
		String smeciavailableamount=Utility.getName(request.getParameter("smeciavailableamount"));//原卡可用金额

		int count=creditCardAccountFeesMgr.getCardCount(ssecrcardid);//判断检查充值卡是否存在
		if(count>0){
			this.clearMessages();			
			this.addActionMessage(getText("新充值卡号已存在，请重新输入卡号！"));
			request.setAttribute("flag",GlobalConstants.INSERT);
			request.setAttribute("url", "'initCardAndRechargeRecordNew.action?moduleID="+moduleID+"'");
		}else{
			BigDecimal newssecamount=new BigDecimal("0");//新卡内金额 
			BigDecimal newableamount=new BigDecimal("0"); //新可用金额
			
			BigDecimal oldamount = new BigDecimal(ssecramount);//老卡内金额
			BigDecimal oldavailableamount = new BigDecimal(smeciavailableamount);//老可用金额
			
			BigDecimal newssecrrecharge = new BigDecimal(Utility.getNameNum(ssecrrecharge));//充值金额
			BigDecimal one = new BigDecimal("1");
			FeePo feePo=creditCardAccountFeesMgr.getFee();
			newssecamount=oldamount.add(newssecrrecharge).subtract(new BigDecimal(feePo.getSseffee()));//新卡内金额的计算
			newssecamount=newssecamount.divide(one, 2, BigDecimal.ROUND_HALF_UP);
			
	
			newableamount=newssecamount.subtract(new BigDecimal(feePo.getSseffee()));//新可用金额的计算
			newableamount=newableamount.divide(one, 2, BigDecimal.ROUND_HALF_UP);
			
			PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
			cardRecordPo=new CardRecordPo();
			cardRecordPo.setSsecroldcardid(ssecroldcardid);
			cardRecordPo.setSsecrcardid(ssecrcardid);
			cardRecordPo.setSsecrcustomerid(ssecrcustomerid);
			cardRecordPo.setSsecramount(newssecamount.toString());
			cardRecordPo.setSsecridcard(ssecridcard);
	//	cardRecordPo.setSsecrrecharge(ssecrrecharge);
			cardRecordPo.setSsecrcreatePersonid(personInfoPo.getId());
			
	
			cardPo=new CardPo();//新卡
			cardPo.setSseccardid(ssecrcardid);//新检查充值卡
			cardPo.setSseccustomerid(ssecrcustomerid);//新顾客号
			cardPo.setSsecamount(newssecamount.toString());//新卡内金额
			cardPo.setSsecavailableamount(newableamount.toString());//新可用金额
			cardPo.setShopcode(personInfoPo.getDepartmentID());//部门ID
			cardPo.setSourceid(personInfoPo.getId());//计费源
	
			oldcardPo=new CardPo();//老卡
			oldcardPo.setSseccardid(ssecroldcardid);//老检查充值卡
			oldcardPo.setSseccustomerid(ssecrcustomerid);//老顾客号
			oldcardPo.setSsecamount(ssecramount);//老卡内金额
			oldcardPo.setSsecavailableamount(smeciavailableamount);//老可用金额
			oldcardPo.setShopcode(personInfoPo.getDepartmentID());//部门ID
			oldcardPo.setSourceid(personInfoPo.getId());//计费源
			
			
			creditCardAccountFeesMgr.insertCardRecordUpCard( oldcardPo, cardPo,cardRecordPo,ssecrrecharge);//补卡信息
			
			
			this.clearMessages();
			List valueList = new ArrayList();
			valueList.add("补卡,收取工本费"+feePo.getSseffee()+"元");
			
			this.addActionMessage(getText("struts.messages.recharge.sucess",valueList));
			request.setAttribute("flag",GlobalConstants.INSERT);
			request.setAttribute("url", "'initCreditCardAccountFeesRechargeUpCaed.action?moduleID="+moduleID+"'");
		
		}
		return SUCCESS;
	}
	
}
