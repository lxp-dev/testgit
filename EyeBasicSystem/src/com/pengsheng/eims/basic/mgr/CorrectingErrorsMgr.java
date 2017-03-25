package com.pengsheng.eims.basic.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.CorrectingErrorsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.storage.persistence.InventoryEntryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;

public interface CorrectingErrorsMgr {

	/**
	 * 获取库存差异查询总数
	 */
	public int getInventoryDifferenceCount(CorrectingErrorsPo po);
	
	/**
	 * 获取库存差异查询列表
	 */
	public List<CorrectingErrorsPo> getInventoryDifferenceList(CorrectingErrorsPo po,int start,int size);
	
	/**
	 * 获取单据数量与库存的
	 */
	public List<InventoryEntryPo> getInventoryDifferenceBillEntryDetail(CorrectingErrorsPo po);
	
	/**
	 * 获取错误条码总数
	 */
	public int getErrorsGoodsBarCodeCount(CorrectingErrorsPo po);
	
	/**
	 * 获取错误条码查询列表
	 */
	public List<CorrectingErrorsPo> getErrorsGoodsBarCodeList(CorrectingErrorsPo po,int start,int size);
	
	/**
	 * 获取异常单据总数
	 */
	public int getBillDifferenceCount(CorrectingErrorsPo po);
	
	/**
	 * 获取异常单据列表
	 */
	public List<CorrectingErrorsPo> getBillDifferenceList(CorrectingErrorsPo po,int start,int size);
	
	/**
	 * 获取在途库存商品总数
	 */
	public int getGoodsTransitStorageCount(CorrectingErrorsPo po,PersonInfoPo personInfoPo);
	
	/**
	 * 获取在途库存商品列表
	 */
	public List<CorrectingErrorsPo> getGoodsTransitStorageList(CorrectingErrorsPo po,PersonInfoPo personInfoPo,int start,int size);
		
	/**
	 * 获取未完结单据总数
	 */
	public int getNotAuditBillCount(CorrectingErrorsPo po);
	
	/**
	 * 获取未完结单据列表
	 */
	public List<CorrectingErrorsPo> getNotAuditBillList(CorrectingErrorsPo po,int start,int size);
	
	/**
	 * 删除未完结单据总数
	 */
	public void deleteNotAuditBill(CorrectingErrorsPo po,LogisticsLogPo logPo);
	
	/**
	 * 处理配镜单
	 */
	public void updateSalesBillInTransit(SystemParameterPo systemParameterPo,CorrectingErrorsPo po,LogisticsLogPo logPo);
	
	/**
	 * 重新转在途库存
	 */
	public void deleteGoodsTransitStorage(CorrectingErrorsPo correctingErrorsPo,LogisticsLogPo logPo);

}
