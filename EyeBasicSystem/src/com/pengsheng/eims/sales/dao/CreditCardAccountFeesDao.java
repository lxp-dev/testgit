package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.persistence.CardPo;
import com.pengsheng.eims.sales.persistence.CardRecordPo;
import com.pengsheng.eims.sales.persistence.FeePo;
import com.pengsheng.eims.sales.persistence.RechargeRecordPo;

public interface CreditCardAccountFeesDao {

	
	/**
	 * 新增会员信息
	 * @param po
	 */
	public void insertCustomerInfo(CustomerInfoPo po);
	
	/**
	 * 新建检查充值卡--查询新建检查充值卡顾客基本资料
	 * @param po
	 * @return
	 */
	public CustomerInfoPo selectCustomerInfoNew(CustomerInfoPo po);
	
	/**
	 * 检查充值卡充值--查询检查充值卡充值信息
	 * @param po
	 * @return
	 */
	public CardPo getCard(CardPo po);
	
	/**
	 * 检查充值卡充值--新增检查充值卡充值信息
	 * @param po
	 */
	public void insertCard (CardPo po);
	
	/**
	 * 检查充值卡充值--修改检查充值卡充值信息
	 * @param po
	 */
	public void updateCard(CardPo po);

	/**
	 * 检查充值卡充值--查询检查充值卡充值号数量
	 * @param po
	 */
	public int getCardCount(String cardid);
	
	/**
	 * 检查充值卡充值--检查充值卡清零信息
	 * @param po
	 */
	public void updateCardClear(CardPo po);
	/**
	 * 消费充值卡记录--新增消费充值卡记录表信息
	 * @param po
	 */
	public void insertRechargeRecord(RechargeRecordPo po);
	
	/**
	 * 查询充值卡补卡顾客基本资料
	 * @param po
	 * @return
	 */
	public CustomerInfoPo selectCustomerInfo(CustomerInfoPo po);
	

	
	/**
	 * 新建检查充值卡--新增充值卡消费表信息
	 */
	public void insertRechargeRecordNewInsert(RechargeRecordPo rechargeRecordPo);
	
	/**
	 * 新建检查充值卡--新增检查充值卡信息
	 * @param po
	 */
	public void insertCardNewInsert(CardPo po);
	
	/**
	 * 新建检查充值卡--查询新建检查充值卡号数量
	 * @param po
	 */
	public int getCardNewCount(String memberid);
	
	/**
	 * 新增补卡，补卡记录表信息
	 * @param po
	 */
	public void insertCardRecordUpCard(CardRecordPo cardRecordPo);
	
	/**
	 * 修改检查充值卡里的信息
	 * @param po
	 */
	public void updateCardUpCard(CardPo cardPo);
	
//	/**
//	 * 修改检查充值卡里的信息
//	 * @param po
//	 */
//	public void updateRechargeRecordUpCard(RechargeRecordPo rechargeRecordPo);
	
	/**
	 * 新增补卡，充值卡消费表信息--新增退费清零信息
	 */
	public void insertRechargeRecordUpCardClear(RechargeRecordPo rechargeRecordPo);
	
	/**
	 * 新增补卡，充值卡消费表信息--新增充值信息
	 */
	public void insertRechargeRecordUpCardInsert(RechargeRecordPo rechargeRecordPo);
	
	/**
	 * 新增补卡，充值卡消费表信息--新增工本费信息
	 */
	public void insertRechargeRecordUpCardFee(RechargeRecordPo rechargeRecordPo);
	
	/**
	 * 提取工本费
	 * @param feePo
	 * @return
	 */
	public FeePo getFee();
	
}
