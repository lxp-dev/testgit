package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import org.omg.CORBA.Request;

import com.pengsheng.eims.member.dao.CustomerInfoDao;
import com.pengsheng.eims.member.persistence.CustomerInfoPo;
import com.pengsheng.eims.sales.dao.CreditCardAccountFeesDao;
import com.pengsheng.eims.sales.mgr.CreditCardAccountFeesMgr;
import com.pengsheng.eims.sales.persistence.CardPo;
import com.pengsheng.eims.sales.persistence.CardRecordPo;
import com.pengsheng.eims.sales.persistence.FeePo;
import com.pengsheng.eims.sales.persistence.RechargeRecordPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.tools.Utility;

public class CreditCardAccountFeesMgrImpl implements CreditCardAccountFeesMgr {

	private CreditCardAccountFeesDao creditCardAccountFeesDao;

	private CustomerInfoDao customerInfoDao;
	
	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	public CreditCardAccountFeesDao getCreditCardAccountFeesDao() {
		return creditCardAccountFeesDao;
	}

	public void setCreditCardAccountFeesDao(
			CreditCardAccountFeesDao creditCardAccountFeesDao) {
		this.creditCardAccountFeesDao = creditCardAccountFeesDao;
	}

	/**
	 * 修改会员信息
	 */
	public void updateCard(CardPo cardPo,RechargeRecordPo po) {
		// 修改会员卡信息
		creditCardAccountFeesDao.updateCard(cardPo);
		// 新增充值卡消费记录表信息
		creditCardAccountFeesDao.insertRechargeRecord(po);

	}

	/**
	 * 新增顾客信息
	 */
	public void insertCustomerInfo(CustomerInfoPo customerInfoPo, CardPo cardPo,  RechargeRecordPo rechargeRecordPo) {

		creditCardAccountFeesDao.insertCustomerInfo(customerInfoPo);// 插入顾客基本资料
		
		cardPo.setSseccustomerid(customerInfoPo.getSmecicustomerid());
		creditCardAccountFeesDao.insertCard(cardPo);// 插入充值卡
		
		rechargeRecordPo.setSserrcustomerid(customerInfoPo.getSmecicustomerid());
		creditCardAccountFeesDao.insertRechargeRecord(rechargeRecordPo);//新增充值卡消费记录信息
	}

	/**
	 * 修改会员卡清零信息并新增充值卡消费记录
	 */
	public void updateCardClear(CardPo po,RechargeRecordPo rechargeRecordPo) {

		creditCardAccountFeesDao.updateCardClear(po);
		creditCardAccountFeesDao.insertRechargeRecord(rechargeRecordPo);
	}

	/**
	 * 新增检查充值卡信息
	 */
	public void insertCard(CardPo po) {

		creditCardAccountFeesDao.insertCard(po);

	}

	/**
	 * 查询检查充值卡号数量
	 */
	public int getCardCount(String cardid) {
		return creditCardAccountFeesDao.getCardCount(cardid);
	}

	/**
	 * 新增消费充值卡记录表信息
	 */
	public void insertRechargeRecord(RechargeRecordPo po) {

		creditCardAccountFeesDao.insertRechargeRecord(po);

	}

	/**
	 * 查询检查充值卡充值
	 */
	public CardPo getCard(CardPo po) {
		
		return creditCardAccountFeesDao.getCard(po);
	}

	/**
	 * 查询充值卡补卡顾客基本资料
	 */
	public CustomerInfoPo selectCustomerInfo(CustomerInfoPo po) {
		
		return creditCardAccountFeesDao.selectCustomerInfo(po);
	}

	/**
	 * 新增补卡，补卡记录表信息、检查充值卡表信息、充值卡消费记录表信息
	 */
	public void insertCardRecordUpCard(CardPo oldcardPo, CardPo cardPo,CardRecordPo cardRecordPo,String ssecrrecharge) {
		
		creditCardAccountFeesDao.updateCardUpCard(cardPo);//修改检查充值卡里的信息

		creditCardAccountFeesDao.insertCardRecordUpCard(cardRecordPo);// 插入补卡记录表
		
		RechargeRecordPo rechargeRecordPo=new RechargeRecordPo();

		rechargeRecordPo.setSserrcustomerid(cardRecordPo.getSsecrcustomerid());
		rechargeRecordPo.setSserrcreateperson(cardRecordPo.getSsecrcreatePersonid());
		rechargeRecordPo.setSserrshopcode(oldcardPo.getShopcode());
		rechargeRecordPo.setSserrsourceid(oldcardPo.getSourceid());
		//新增补卡，充值卡消费表信息--新增退费清零信息		
		rechargeRecordPo.setSserrflag("4");
		rechargeRecordPo.setSserrcardid(oldcardPo.getSseccardid());
		rechargeRecordPo.setSserramount("-"+oldcardPo.getSsecamount());
		creditCardAccountFeesDao.insertRechargeRecordUpCardClear(rechargeRecordPo);
		//新增补卡，充值卡消费表信息--新增充值信息
		rechargeRecordPo.setSserrflag("1");
		rechargeRecordPo.setSserrcardid(cardPo.getSseccardid());
		rechargeRecordPo.setSserramount(oldcardPo.getSsecamount());
		creditCardAccountFeesDao.insertRechargeRecordUpCardInsert(rechargeRecordPo);
		
		//补卡时金额充值
		rechargeRecordPo.setSserrflag("1");
		rechargeRecordPo.setSserrcardid(cardPo.getSseccardid());
		rechargeRecordPo.setSserramount(ssecrrecharge);
		creditCardAccountFeesDao.insertRechargeRecordUpCardInsert(rechargeRecordPo);
		
		//新增补卡，充值卡消费表信息--新增工本费信息
		rechargeRecordPo.setSserrflag("5");
		rechargeRecordPo.setSserrcardid(cardPo.getSseccardid());
		FeePo feePo=creditCardAccountFeesDao.getFee();
		rechargeRecordPo.setSserramount("-"+feePo.getSseffee());
		creditCardAccountFeesDao.insertRechargeRecordUpCardFee(rechargeRecordPo);
	}

	/**
	 *  新建检查充值卡--查询新建检查充值卡顾客基本资料
	 */
	public CustomerInfoPo selectCustomerInfoNew(CustomerInfoPo po) {
		
		return creditCardAccountFeesDao.selectCustomerInfoNew(po);
	}

	/**
	 * 新建检查充值卡--新增检查充值卡信息、新增充值卡消费记录信息
	 */
	public void insertCardAndRechargeRecordNew(CardPo cardPo,RechargeRecordPo rechargeRecordPo) {
		
		creditCardAccountFeesDao.insertCardNewInsert(cardPo);//新增检查充值卡信息
		creditCardAccountFeesDao.insertRechargeRecordNewInsert(rechargeRecordPo);//新增充值卡消费记录
	}
	/**
	 * 新建检查充值卡--查询新建检查充值卡号数量
	 */
	public int getCardNewCount(String memberid) {
		
		return creditCardAccountFeesDao.getCardNewCount(memberid);
	}
	/**
	 * 提取工本费
	 */
	public FeePo getFee(){
		return creditCardAccountFeesDao.getFee();
	}

	

}
