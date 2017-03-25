package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.AdditionalCDetailPo;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface SalesReturnMgr {
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
	
	public String insertSalesReturnProcess(SystemParameterPo systemParameterPo,List<SalesDetailPo> salesDetailPoList,SalesBasicPo salesBasicPo,InTransitPo inTransitPo,List<SalesLogPo> salesLogPos ,List<ChuzhikaPo> czklist ,List<CashCouponPo> djqlist,LogisticsLogPo logPo,List<AdditionalCDetailPo> additionalCDetailPoList);
	
	public SalesBasicPo getCustomerId(String cid);
	
}
