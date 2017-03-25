package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.SalesAreaPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface SalesAreaMgr {
	/**
	 * 查询所有价格区间
	 * @return
	 */
	public List<SalesAreaPo> selectSalesAreaListAll(String moduleid);
	public List<SalesAreaPo> selectSalesAreaListAllByCategoryIDOrSalesType(String[] goodsCategoryID, String[] salesType);
	public List<SalesAreaPo> selectSalesAreaListAllByCategoryIDOrSalesType(String[] goodsCategoryID, String[] salesType, int start, int size);
	public int selectSalesAreaListAllByCategoryIDOrSalesTypeCount(String[] goodsCategoryID, String[] salesType);
	/**
	 * 删除价格区间
	 */
	public void deleteSalesAreaPo(String id,LogisticsLogPo logPo);
	
	/**
	 * 插入价格区间
	 * @param po
	 */
	public void insertSalesAreaPo(List<SalesAreaPo> salesAreaList,LogisticsLogPo logPo);
	
	/**
	 * 查询价格区间PO
	 * @return
	 */
	public SalesAreaPo selectSalesAreaPo(String id);

	public List<SalesAreaPo> selectSalesAreaListAllByGoodsCategoryID(String goodsCategoryID);
	
	/**
	 * 确认新增的价格段区间与之前新建的没有重复
	 */
	public int getSalesAreaBeforeCount(SalesAreaPo po);
	
}
