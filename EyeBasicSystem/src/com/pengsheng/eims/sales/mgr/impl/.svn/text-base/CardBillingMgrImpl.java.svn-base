/**
 * 
 */
package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.basic.persistence.RolePo;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.AccSalesDao;
import com.pengsheng.eims.sales.dao.CardBillingDao;
import com.pengsheng.eims.sales.dao.ConSalesDao;
import com.pengsheng.eims.sales.mgr.AccSalesMgr;
import com.pengsheng.eims.sales.mgr.CardBillingMgr;
import com.pengsheng.eims.sales.mgr.ConSalesMgr;
import com.pengsheng.eims.sales.persistence.CardPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InspectionPo;
import com.pengsheng.eims.sales.persistence.RechargeRecordPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;

/**
 * @author Liuqian
 * 
 */
public class CardBillingMgrImpl implements CardBillingMgr {

	private CardBillingDao cardBillingDao;
	
	public CardBillingDao getCardBillingDao() {
		return cardBillingDao;
	}
	public void setCardBillingDao(CardBillingDao cardBillingDao) {
		this.cardBillingDao = cardBillingDao;
	}

	public List<RegisteredCategoryPo> getRcList(int start , int size) {
		// TODO Auto-generated method stub
		return cardBillingDao.getRcList(start,size);
	}
	


	public void insertRegisteredDetails(RegisteredDetailsPo po) {
		// TODO Auto-generated method stub
		cardBillingDao.insertRegisteredDetails(po);
	}

	public List<RegisteredDetailsPo> getRcdList(String customerID) {
		// TODO Auto-generated method stub
		return cardBillingDao.getRcdList(customerID);
	}

	public void insertRecord(RechargeRecordPo rechargeRecordPo) {
		// TODO Auto-generated method stub
		cardBillingDao.insertRecord(rechargeRecordPo);
	}
	
	public void updateAmount(CardPo cardPo) {
		// TODO Auto-generated method stub
		cardBillingDao.updateAmount(cardPo);
	}
	
	public void updateRegistered(String registeredID,String casher,String uuid){
		cardBillingDao.updateRegistered(registeredID,casher,uuid);
	}
	
	public List<RegisteredCategoryPo> getOpto(String agr0){
		return cardBillingDao.getOpto(agr0);
	}
	
	public RolePo getRole(String personID) {
		return cardBillingDao.getRole(personID);
	}
	
	public int getRcCount() {
		// TODO Auto-generated method stub
		return cardBillingDao.getRcCount();
	}

	public CardPo selCard(CardPo cardPo) {
		// TODO Auto-generated method stub
		return cardBillingDao.selCard(cardPo);
	}

	public void doBusiness(CardPo cardPo, RechargeRecordPo rechargeRecordPo,
			String[] sourceID, String[] registereds, String[] isOpto,
			String[] amounts,PersonInfoPo personInfoPo , CustomerInfoPo customerInfoPo,String uuid,String mobanLength) {
		// TODO Auto-generated method stub
		
		for(int i=Integer.parseInt(mobanLength);i<sourceID.length;i++){
		/*
		 * 更新挂号表收费标识
		 */
		if("0".equals(isOpto[i].trim())){  //特使费用更新收费标识
			cardBillingDao.updateRegistered(registereds[i].trim(),personInfoPo.getId(),uuid);
		}else{//验光需插入完整挂号明细单子。
				RegisteredDetailsPo po = new RegisteredDetailsPo();
				po.setScrrddetailsid(uuid);
				po.setScrrdcustomerid(customerInfoPo.getSmecicustomerid());
				po.setScrrdregister(personInfoPo.getId());
				po.setScrrdshopcode(personInfoPo.getDepartmentID());
				po.setScrrdcasher(personInfoPo.getId());
				po.setScrrdregisterid(registereds[i].trim());
				po.setScrrdflag("1");
				cardBillingDao.insertRegisteredDetails(po);
		}
		
		RechargeRecordPo temp = new RechargeRecordPo();
		temp.setSserrcustomerid(cardPo.getSseccustomerid());
		temp.setSserrcreateperson(personInfoPo.getId());
		temp.setSserrshopcode(personInfoPo.getDepartmentID());
		temp.setSserramount(rechargeRecordPo.getSserramount());
		temp.setSserrsourceid(sourceID[i].trim());
		temp.setSserrcardid(cardPo.getSseccardid().split(",")[1]);
		temp.setSserramount(amounts[i].trim());
		
		cardBillingDao.insertRecord(temp);
		cardBillingDao.updateAmount(cardPo);
	}
		
	}
}
