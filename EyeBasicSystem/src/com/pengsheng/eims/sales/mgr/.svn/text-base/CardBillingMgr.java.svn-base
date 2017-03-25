/**
 * 
 */
package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.basic.persistence.GiftsPo;
import com.pengsheng.eims.basic.persistence.RolePo;
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
public interface CardBillingMgr {

	public List<RegisteredCategoryPo> getRcList(int start , int size);
	
	public int getRcCount();
	
	public void insertRegisteredDetails(RegisteredDetailsPo po);
	
	public List<RegisteredDetailsPo> getRcdList(String customerID);
	
	/*
	 * 更新顾客卡内余额。
	 */
	public void updateAmount(CardPo cardPo);
	
	/*
	 * 插入充值卡流水
	 */
	public void insertRecord(RechargeRecordPo rechargeRecordPo);
	
	/*
	 * 
	 */
	public void updateRegistered(String registeredID,String casher,String uuid);
	
	public List<RegisteredCategoryPo> getOpto(String agr0);
	
	public RolePo getRole(String personID) ;
	
	public CardPo selCard(CardPo cardPo);
	
	public void doBusiness(CardPo cardPo,RechargeRecordPo rechargeRecordPo,String[] sourceID,String[] registereds,String[] isOpto,String[] amounts,PersonInfoPo personInfoPo,CustomerInfoPo customerInfoPo,String uuid,String mobanLength);
	
	
}
