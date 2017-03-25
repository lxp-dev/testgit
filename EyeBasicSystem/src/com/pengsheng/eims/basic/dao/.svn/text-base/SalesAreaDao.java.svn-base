package com.pengsheng.eims.basic.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.SalesAreaPo;

public interface SalesAreaDao {
	/**
	 * 查询所有价格区间
	 * @return
	 */
	public List<SalesAreaPo> selectSalesAreaListAll(String moduleid);
	public List<SalesAreaPo> selectSalesAreaListAllByCategoryIDOrSalesType(String[] goodsCategoryID, String[] salesType);
	public List<SalesAreaPo> selectSalesAreaListAllByCategoryIDOrSalesType(String[] goodsCategoryID, String[] salesType, int start, int size);
	public int selectSalesAreaListAllByCategoryIDOrSalesTypeCount(String[] goodsCategoryID, String[] salesType);
	/**
	 * 查询价格区间PO
	 * @return
	 */
	public SalesAreaPo selectSalesAreaPo(String id);
	
	/**
	 * 删除价格区间
	 */
	public void deleteSalesAreaPo(String id);
	
	/**
	 * 插入价格区间
	 * @param po
	 */
	public void insertSalesAreaPo(SalesAreaPo po);

	public List<SalesAreaPo> selectSalesAreaListAllByGoodsCategoryID(String goodsCategoryID);
	
	/**
	 * 确认新增的价格段区间与之前新建的没有重复
	 */
	public int getSalesAreaBeforeCount(SalesAreaPo po);
	
	/**
	 * 确认新增的价格段区间与之前新建的没有重复
	 */
	public int getSalesTypeAreaBeforeCount(SalesAreaPo po);
	
}
