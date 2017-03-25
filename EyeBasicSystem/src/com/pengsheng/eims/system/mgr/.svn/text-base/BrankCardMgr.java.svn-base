package com.pengsheng.eims.system.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

import com.pengsheng.eims.system.persistence.BankPo;
import com.pengsheng.eims.system.persistence.BrankCardPo;

/**
 * BrankCardMgr 银行卡Mgr
 * 
 * @author GuanZiGang
 * @version 1.0
 */
public interface BrankCardMgr {

	/**
	 * 根据查询条件返回相应的结果集数量
	 * 
	 * @param po 查询条件
	 * @return int 银行卡数量
	 */
	public int getBrankCardCount(BrankCardPo po);

	/**
	 * 根据查询条件返回相应的结果集
	 * 
	 * @param po 查询条件 start 开始数量  size 每页显示数量
	 * @return List 银行卡结果集
	 */
	public List<BrankCardPo> getBrankCardList(BrankCardPo po,int start, int size);

	/**
	 * 查询银行卡的详细信息
	 * 
	 * @param po 查询条件
	 * @return po 银行卡详细信息
	 */
	public BrankCardPo getBrankCardPo(BrankCardPo po);
	
	/**
	 * 查询银行卡ID是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardId(BrankCardPo po);
	
	
	/**
	 * 查询银行卡在goods表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardWithGoods(BrankCardPo po);
	
	
	/**
	 * 新增银行卡
	 * 
	 * @param po 银行卡po
	 * @return void
	 */
	public void insertBrankCard(BrankCardPo po,LogisticsLogPo logPo);
	
	/**
	 * 修改银行卡
	 * 
	 * @param po 银行卡po
	 * @return void
	 */
	public void updateBrankCard(BrankCardPo po,LogisticsLogPo logPo);
	
	/**
	 * 删除银行卡
	 * 
	 * @param po 银行卡po
	 * @return void
	 */
	public void deleteBrankCard(BrankCardPo po,LogisticsLogPo logPo);
	
	/**
	 * 根据返回相应的结果集
	 * 
	 */
	public List getBrankCardList();
	
	
	
	
	/**
	 * 插入银行Po
	 * @param po
	 */
	public void insertBankPo(BankPo po,LogisticsLogPo logPo);
	
	/**
	 * 
	 * 添加时判断银行编号是否存在
	 * @return
	 */
	public int getBankPoId(BankPo po);
	
	
	/**
	 * 添加时查询银行卡名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardName(BrankCardPo po) ;
	
	/**
	 * 添加时查询银行卡卡号是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardCardid(BrankCardPo po) ;
	
	/**
	 * 修改时查询银行卡名称是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardNameUpdate(BrankCardPo po) ;
	/**
	 * 修改时查询银行卡卡号是否存在
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardCardidUpdate(BrankCardPo po) ;
	
	
	/**
	 * 
	 * 判断银行名称是否存在
	 * @return
	 */
	public int getBankPoName(BankPo po);
	
	/**
	 * 
	 * 更新时判断银行编号是否存在
	 * @return
	 */
	public int getBankPoIdUpdate(BankPo po);
	
	/**
	 * 
	 * 更新时判断银行名称是否存在
	 * @return
	 */
	public int getBankPoNameUpdate(BankPo po);
	/**
	 * 删除银行Po
	 * @param po
	 */
	public void deleteBankPo(BankPo po,LogisticsLogPo logPo);
	
	/**
	 * 更新银行卡o
	 * @param po
	 */
	public void updateBankPo(BankPo po,LogisticsLogPo logPo);
	
	/**
	 * 查询银行Po
	 * @param po
	 */
	public BankPo selectBankPo(BankPo po);
	
	/**
	 * 查询银行Count
	 * @param po
	 */
	public int selectBankCount(BankPo po);
	
	/**
	 * 查询银行List
	 * @param po
	 */
	public List<BankPo> selectBankList(BankPo po, int start, int size);
	/**
	 * 查询银行卡在部门表中是否已经使用
	 * 
	 * @param po 查询条件
	 * @return int 0:不存在 其他为存在
	 */
	public int getBrankCardDepartment(BrankCardPo po);
	
	public List getBankList();
	
	public List getOnlyBankList();
	
	public List getOtherBankList();
	
	public List<BankPo> getNonCashBankList();
}
