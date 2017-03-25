package com.pengsheng.eims.system.mgr.impl;

import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.system.dao.BrankCardDao;
import com.pengsheng.eims.system.mgr.BrankCardMgr;
import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.BrankCardPo;

/**
 * BrankCardMgr 银行卡Mgr
 * 
 * @author GuanZiGang
 * @version 1.0
 * @see BrankCardMgr
 */
public class BrankCardMgrImpl implements BrankCardMgr {

	//银行卡Dao
	public BrankCardDao brankCardDao;
	private LogisticsLogDao logisticsLogDao = null;

	

	public BrankCardDao getBrankCardDao() {
		return brankCardDao;
	}

	public void setBrankCardDao(BrankCardDao brankCardDao) {
		this.brankCardDao = brankCardDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	/**
	 * 删除银行卡
	 * 
	 * @param po 银行卡po
	 * @return void
	 */
	public void deleteBrankCard(BrankCardPo po,LogisticsLogPo logPo) {
		brankCardDao.deleteBrankCard(po);		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 银行卡数量
	 */
	public int getBrankCardCount(BrankCardPo po) {
		return brankCardDao.getBrankCardCount(po);
	}

	/**
	 * 查询银行卡ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardId(BrankCardPo po) {
		return brankCardDao.getBrankCardId(po);
	}
	
	/**
	 * 查询银行卡名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardName(BrankCardPo po) 
	{
		return brankCardDao.getBrankCardName(po);
	}
	
	/**
	 * 查询银行卡卡号是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardCardid(BrankCardPo po) 
	{
		return brankCardDao.getBrankCardCardid(po);
	}
	
	/**
	 * 修改时查询银行卡名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardNameUpdate(BrankCardPo po) 
	{
		return brankCardDao.getBrankCardNameUpdate(po);
	}
	
	/**
	 * 修改时查询银行卡卡号是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardCardidUpdate(BrankCardPo po) 
	{
		return brankCardDao.getBrankCardCardidUpdate(po);
	}
	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 银行卡结果集
	 */
	public List getBrankCardList(BrankCardPo po, int start, int size) {
		return brankCardDao.getBrankCardList(po, start, size);
	}

	/**
	 * 新增银行卡
	 * 
	 * @param po 银行卡po
	 * @return void
	 */
	public void insertBrankCard(BrankCardPo po,LogisticsLogPo logPo) {
		brankCardDao.insertBrankCard(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 修改银行卡
	 * 
	 * @param po 银行卡po
	 * @return void
	 */
	public void updateBrankCard(BrankCardPo po,LogisticsLogPo logPo) {
		brankCardDao.updateBrankCard(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 查询银行卡在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardWithGoods(BrankCardPo po){
		return brankCardDao.getBrankCardWithGoods(po);
	}

	
	/**
	 * 查询银行卡的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 银行卡详细信息
	 */
	public BrankCardPo getBrankCardPo(BrankCardPo po) {
		return brankCardDao.getBrankCardPo(po);
	}
   
	public List getBrankCardList() {
		
		return brankCardDao.getBrankCardList();
	}
	
	
	
	public void deleteBankPo(BankPo po,LogisticsLogPo logPo) {
		brankCardDao.deleteBankPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	
	public void insertBankPo(BankPo po,LogisticsLogPo logPo) {
		brankCardDao.insertBankPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	
	public int selectBankCount(BankPo po) {
		return brankCardDao.selectBankCount(po);
	}
	public int getBankPoId(BankPo po){
		return brankCardDao.getBankPoId(po);
	}
	
	
	public int getBankPoName(BankPo po){
		return brankCardDao.getBankPoName(po);
	}
	public int getBankPoIdUpdate(BankPo po)
	{
		return brankCardDao.getBankPoIdUpdate(po);
	}
	
	public int getBankPoNameUpdate(BankPo po)
	{
		return brankCardDao.getBankPoNameUpdate(po);
	}
	
	public List<BankPo> selectBankList(BankPo po, int start, int size) 
	{
		
		return brankCardDao.selectBankList(po, start, size);
	}

	
	public BankPo selectBankPo(BankPo po) {
		
		return brankCardDao.selectBankPo(po);
	}

	
	public void updateBankPo(BankPo po,LogisticsLogPo logPo) {
		brankCardDao.updateBankPo(po);
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 查询银行卡在部门表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardDepartment(BrankCardPo po)
	{
		return brankCardDao.getBrankCardDepartment(po);
	}
	
	public List getBankList(){
		return brankCardDao.getBankList();
	}
	
	public List getOnlyBankList() {
		
		return brankCardDao.getOnlyBankList();
	}
	
	
	public List getOtherBankList() {
		
		return 	brankCardDao.getOtherBankList();
	}
	
	public List<BankPo> getNonCashBankList(){
		return 	brankCardDao.getNonCashBankList();
	}
	
}
