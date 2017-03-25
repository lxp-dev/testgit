package com.pengsheng.eims.components.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesDetailPo;

public interface WindowNonconformingSaleOrderDao {
	
	/**
	 * 得到销售单中商品信息的数量
	 * @return
	 */
	public int getNonconformingSaleCount(SalesDetailPo salesDetailPo);
	public int getNonconformingSaleCountFinished(SalesDetailPo salesDetailPo);
	
	/**
	 * 得到销售单中详细商品信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesDetailPo> getNonconformingSaleList(SalesDetailPo salesDetailPo , int start, int size);
	public List<SalesDetailPo> getNonconformingSaleListFinished(SalesDetailPo salesDetailPo , int start, int size);
	
	/**
	 * 得到顾客信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getCustmorInfo(SalesBasicPo salesBasicPo);
	public SalesBasicPo getCustmorInfoFinished(SalesBasicPo salesBasicPo);
	
	/**
	 * 得到销售号
	 * @param salesBasicPo
	 * @return
	 */
	public  List<SalesBasicPo> getSaleOrderList(SalesBasicPo salesBasicPo, int start, int size);
	
	/**
	 * 得到销售单个数
	 * @param salesBasicPo
	 * @return
	 */
	public int getSaleOrderCount(SalesBasicPo salesBasicPo);

}
