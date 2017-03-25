package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.CardPo;
import com.pengsheng.eims.sales.persistence.CardRecordPo;
import com.pengsheng.eims.sales.persistence.FeePo;
import com.pengsheng.eims.sales.persistence.RechargeRecordPo;

public interface CreditCardAccountFeesMgr {

	/**
	 * 修改检查充值卡信息和新增充值卡消费记录信息
	 * 
	 * @param po
	 */
	public void updateCard(CardPo cardPo,RechargeRecordPo po);

	/**
	 * 新增顾客信息
	 * 
	 * @param po
	 */
	public void insertCustomerInfo(CustomerInfoPo customerInfoPo, CardPo cardPo, RechargeRecordPo rechargeRecordPo);

	/**
	 * 新增消费充值卡记录表信息
	 * 
	 * @param po
	 */
	public void insertRechargeRecord(RechargeRecordPo po);

	/**
	 * 检查充值卡清零信息
	 * 
	 * @param po
	 */
	public void updateCardClear(CardPo po,RechargeRecordPo rechargeRecordPo);
	

	/**
	 * 新增检查充值卡信息
	 * 
	 * @param po
	 */
	public void insertCard(CardPo po);
	

	/**
	 * 查询检查充值卡号数量
	 * 
	 * @param po
	 */
	public int getCardCount(String cardid);
	
	/**
	 * 查询检查充值卡充值
	 * @param po
	 * @return
	 */
	public CardPo getCard(CardPo po);
	
	/**
	 * 查询充值卡补卡顾客基本资料
	 * @param po
	 * @return
	 */
	public CustomerInfoPo selectCustomerInfo(CustomerInfoPo po);
	
	/**
	 * 新增补卡，补卡记录表信息、检查充值卡表信息、充值卡消费记录表信息
	 * @param po
	 */
	public void insertCardRecordUpCard(CardPo oldcardPo, CardPo cardPo,CardRecordPo cardRecordPo,String ssecrrecharge);
	
	/**
	 * 新建检查充值卡--查询新建检查充值卡顾客基本资料
	 * @param po
	 * @return
	 */
	public CustomerInfoPo selectCustomerInfoNew(CustomerInfoPo po);
	
	/**
	 *  新建检查充值卡--新增检查充值卡信息、新增充值卡消费记录信息
	 * @param cardPo
	 * @param rechargeRecordPo
	 */
	public void insertCardAndRechargeRecordNew(CardPo cardPo,RechargeRecordPo rechargeRecordPo);
	
	/**
	 * 新建检查充值卡--查询新建检查充值卡号数量
	 * @param po
	 */
	public int getCardNewCount(String memberid);
	
	/**
	 * 提取工本费
	 */
	public FeePo getFee();
}
