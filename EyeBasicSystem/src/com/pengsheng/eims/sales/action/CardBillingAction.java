/**
 * 
 */
package com.pengsheng.eims.sales.action;

import java.util.List;

import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.mgr.CardBillingMgr;
import com.pengsheng.eims.sales.mgr.FrameSalesMgr;
import com.pengsheng.eims.sales.persistence.CardPo;
import com.pengsheng.eims.sales.persistence.RechargeRecordPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.system.mgr.SystemParameterMgr;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.GlobalConstants;
import com.pengsheng.eims.util.basicaction.BaseAction;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.util.web.Pagination;

/**
 * @author canying123
 * 
 */
public class CardBillingAction extends BaseAction {


	private CustomerInfoPo customerInfoPo;
	
	private FrameSalesMgr frameSalesMgr;
	
	private CardBillingMgr cardBillingMgr;
	
	private List<RegisteredCategoryPo> rCList; //类别list
	
	private List<RegisteredDetailsPo> rcdList;//明细list
	
	private List<RegisteredCategoryPo> opList;//验光费list
	
	private CardPo cardPo;
	private SystemParameterMgr systemParameterMgr;
	private SystemParameterPo systemParameterPo;
	
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
	
	public CardPo getCardPo() {
		return cardPo;
	}

	public void setCardPo(CardPo cardPo) {
		this.cardPo = cardPo;
	}

	public List<RegisteredCategoryPo> getOpList() {
		return opList;
	}

	public void setOpList(List<RegisteredCategoryPo> opList) {
		this.opList = opList;
	}

	private RechargeRecordPo rechargeRecordPo;
	
	public RechargeRecordPo getRechargeRecordPo() {
		return rechargeRecordPo;
	}

	public void setRechargeRecordPo(RechargeRecordPo rechargeRecordPo) {
		this.rechargeRecordPo = rechargeRecordPo;
	}

	public List<RegisteredDetailsPo> getRcdList() {
		return rcdList;
	}

	public void setRcdList(List<RegisteredDetailsPo> rcdList) {
		this.rcdList = rcdList;
	}

	private RegisteredDetailsPo registeredDetailsPo;
	
	public RegisteredDetailsPo getRegisteredDetailsPo() {
		return registeredDetailsPo;
	}

	public void setRegisteredDetailsPo(RegisteredDetailsPo registeredDetailsPo) {
		this.registeredDetailsPo = registeredDetailsPo;
	}

	public List<RegisteredCategoryPo> getrCList() {
		return rCList;
	}

	public void setrCList(List<RegisteredCategoryPo> rCList) {
		this.rCList = rCList;
	}

	public CardBillingMgr getCardBillingMgr() {
		return cardBillingMgr;
	}

	public void setCardBillingMgr(CardBillingMgr cardBillingMgr) {
		this.cardBillingMgr = cardBillingMgr;
	}

	public FrameSalesMgr getFrameSalesMgr() {
		return frameSalesMgr;
	}

	public void setFrameSalesMgr(FrameSalesMgr frameSalesMgr) {
		this.frameSalesMgr = frameSalesMgr;
	}

	public CustomerInfoPo getCustomerInfoPo() {
		return customerInfoPo;
	}

	public void setCustomerInfoPo(CustomerInfoPo customerInfoPo) {
		this.customerInfoPo = customerInfoPo;
	}
	
	/*
	 * 初始化进入收取检查费
	 */
	public String initCardBillingNormal(){
		String customerID=Utility.getName(request.getParameter("customerID"));
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		RolePo rolePo=cardBillingMgr.getRole(personInfoPo.getId());
		
		if(rolePo.getRolename().indexOf("高级") != -1){
			opList=cardBillingMgr.getOpto("高级");
		}else if(rolePo.getRolename().indexOf("主任") != -1){
			opList=cardBillingMgr.getOpto("主任");
		}else{
			opList=cardBillingMgr.getOpto("普通");
		}
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecicustomerid(customerID);
		customerInfoPo = frameSalesMgr.getCustomerInfo(customerInfoPo);
		rcdList=cardBillingMgr.getRcdList(customerID);
		
		
		return SUCCESS;
	}
	/*
	 * 初始化进入收取特殊检查费用
	 */
	public String initCardBillingSpecial(){
		String customerID=Utility.getName(request.getParameter("customerID"));
		customerInfoPo = new CustomerInfoPo();
		customerInfoPo.setSmecicustomerid(customerID);
		customerInfoPo = frameSalesMgr.getCustomerInfo(customerInfoPo);
		return SUCCESS;
		
	}
	/*
	 * 特殊检查费用调教
	 */
	public String cardBillingSpecial(){
		String uuid = UUIDHexGenerator.getInstance().generate();
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
			
			String[] registerID=registeredDetailsPo.getScrrdregisterid().split(",");
			for(int i=1;i<registerID.length;i++){
				RegisteredDetailsPo po = new RegisteredDetailsPo();
				po.setScrrddetailsid(uuid);
				po.setScrrdcustomerid(customerInfoPo.getSmecicustomerid());
				po.setScrrdregister(personInfoPo.getId());
				po.setScrrdshopcode(personInfoPo.getDepartmentID());
				po.setScrrdregisterid(registerID[i].trim());
				po.setScrrdflag("0");
				cardBillingMgr.insertRegisteredDetails(po);
			}
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	/*
	 * 收取检查费纱卡计费
	 */
	public String cardBillingNormal(){
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		String uuid = UUIDHexGenerator.getInstance().generate();
		
		/*
		 * 插入消费明细
		 */
		String[] sourceID=rechargeRecordPo.getSserrsourceid().split(",");
		String[] registereds =registeredDetailsPo.getScrrdid().split(",");
		String[] isOpto=request.getParameterValues("isOpto"); //判断是验光费还是特殊检查费用，1 验光费 2特殊检查
		String[] amounts = rechargeRecordPo.getSserramount().split(",");
//		for(int i=0;i<sourceID.length;i++){
//			/*
//			 * 更新挂号表收费标识
//			 */
//			if("0".equals(isOpto[i].trim())){  //特使费用更新收费标识
//				cardBillingMgr.updateRegistered(registereds[i].trim(),personInfoPo.getId(),uuid);
//			}else{//验光需插入完整挂号明细单子。
//					RegisteredDetailsPo po = new RegisteredDetailsPo();
//					po.setScrrddetailsid(uuid);
//					po.setScrrdcustomerid(customerInfoPo.getSmecicustomerid());
//					po.setScrrdregister(personInfoPo.getId());
//					po.setScrrdshopcode(personInfoPo.getDepartmentID());
//					po.setScrrdcasher(personInfoPo.getId());
//					po.setScrrdregisterid(registereds[i].trim());
//					po.setScrrdflag("1");
//					cardBillingMgr.insertRegisteredDetails(po);
//			}
//			
//			RechargeRecordPo temp = new RechargeRecordPo();
//			temp.setSserrcustomerid(customerInfoPo.getSmecicustomerid());
//			temp.setSserrcreateperson(personInfoPo.getId());
//			temp.setSserrshopcode(personInfoPo.getDepartmentID());
//			temp.setSserramount(rechargeRecordPo.getSserramount());
//			temp.setSserrsourceid(sourceID[i].trim());
//			temp.setSserrcardid(cardPo.getSseccardid());
//			temp.setSserramount(amounts[i].trim());
//			cardBillingMgr.insertRecord(temp);
//		}
		cardBillingMgr.doBusiness(cardPo, rechargeRecordPo, sourceID, registereds, isOpto, amounts,personInfoPo,customerInfoPo,uuid,request.getParameter("mobanLength"));
		
		this.clearMessages();
		this.addActionMessage(getText("struts.messages.insert.sucess"));
		request.setAttribute("flag", GlobalConstants.OPENUPDATE);
		return SUCCESS;
	}
	/*
	 * 选择特殊费用开窗
	 */
	public String cardBillingSpecialOpen()
	{
		systemParameterPo = (SystemParameterPo) session.get("systemParameterPo");
		int fsppageno = Integer.valueOf(systemParameterPo.getFsppageno());
		int count=cardBillingMgr.getRcCount();
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
	    rCList=cardBillingMgr.getRcList(page.getStart(),page.getPageSize());
		request.setAttribute(Pagination.PAGINATION, page);
		}else{
			rCList = null;
		}
		
		return SUCCESS;
	}
	/*
	 * 顾客刷检查卡。
	 */
	public String selCard(){
		
		PersonInfoPo personInfoPo = (PersonInfoPo) session.get("person");
		RolePo rolePo=cardBillingMgr.getRole(personInfoPo.getId());
		
		if(rolePo.getRolename().indexOf("高级") != -1){
			opList=cardBillingMgr.getOpto("高级");
		}else if(rolePo.getRolename().indexOf("主任") != -1){
			opList=cardBillingMgr.getOpto("主任");
		}else{
			opList=cardBillingMgr.getOpto("普通");
		}
		cardPo.setSseccardid(cardPo.getSseccardid().split(",")[0]);
		cardPo=cardBillingMgr.selCard(cardPo);
		customerInfoPo = frameSalesMgr.getCustomerInfo(customerInfoPo);
		rcdList=cardBillingMgr.getRcdList(customerInfoPo.getSmecicustomerid());
		
		
		return SUCCESS;
		
	}

	
}
