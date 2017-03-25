package com.pengsheng.eims.sales.dao;

import java.util.List;

import com.pengsheng.eims.basic.persistence.GoodsInfoPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.TakeMsgPo;

public interface CustomerTakeDao {

	/**
	 * 得到顾客取镜信息数量
	 * 
	 * @param salesBasicPo
	 * @return
	 */
	public int getCustomerTakeCount(SalesBasicPo salesBasicPo);

	/**
	 * 得到顾客取镜信息
	 * 
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectCustomerTake(SalesBasicPo salesBasicPo,
			int start, int size);

	public int getTakeMsgCount(TakeMsgPo takeMsgPo);
	public List<TakeMsgPo> selectTakeMsgList(TakeMsgPo takeMsgPo , int start , int size);
	
	/**
	 * 更新销售基表中的在途信息
	 * 
	 * @param salesBasicPo
	 */
	public void updateCustInTransit(SalesBasicPo salesBasicPo);

	/**
	 * 配镜单信息插入在途表中
	 * 
	 * @param inTransitPo
	 */
	public void insertCustInTransit(InTransitPo inTransitPo);

	/**
	 * 关联销售明细表查询商品信息
	 * 
	 * @param salesDetailPo
	 * @return
	 */
	public List<SalesDetailPo> getGoodsDetailInfo(SalesDetailPo salesDetailPo);

	/**
	 * 得到销售结帐基表对象
	 */
	public SalesBasicPo getSalesBasicPo(String salesID);
	/**
	 * 得到商品信息表
	 */
	public GoodsInfoPo getGoodsInfoPo(String id) ;
	
	/**
	 * 将配镜单送至已完结的表中
	 */
	public void insertSalesBasicFinished(String salesID);
	
	/**
	 * 将配镜单明细送至已完结的表中
	 */
	public void insertSalesDetailFinished(String salesID);
	
	/**
	 * 将配镜单送至已完结的表中
	 */
	public void deleteSalesBasic(String salesID);
	
	/**
	 * 将配镜单明细送至已完结的表中
	 */
	public void deleteSalesDetail(String salesID);
	
	public void insertTakeMsg(TakeMsgPo takeMsgPo);
}
