package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.storage.persistence.StrogeChangePo;

public interface SalesReturnDao {
	/*
	 * 退款新增
	 */
	public void insertSalesReturn(SalesBasicPo salesBasicPo);
	/*
	 * 当天退款新增
	 */
	public void insertSalesReturnToday(SalesBasicPo salesBasicPo);
	/**
	 * 退款单详细新增
	 */
	public void insertSalesReturnDetail(SalesDetailPo salesDetailPo);
	/**
	 * 当天退款单详细新增
	 */
	public void insertSalesReturnDetailToday(SalesDetailPo salesDetailPo);
	public SalesDetailPo getGoodsIsCustomize(String goodsId);
	public SalesBasicPo getCustomerId(String cid);
	/**
	 * 退款流水新增
	 */
	public void insertSalesLog(SalesBasicPo salesBasicPo);
	/**
	 * 退款商品库存插入
	 */
	public void insertStrogeChanges(SalesBasicPo salesBasicPo);
	/**
	 * 退款商品库存插入log表
	 */
	public void insertStrogeLog(SalesBasicPo salesBasicPo);
	/**
	 * 查询
	 */
	public List<StrogeChangePo> selectStrogeLogTemp(SalesBasicPo salesBasicPo);
}
