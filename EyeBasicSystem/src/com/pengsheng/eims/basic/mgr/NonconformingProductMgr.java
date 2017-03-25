package com.pengsheng.eims.basic.mgr;

import java.util.List;
import com.pengsheng.eims.basic.persistence.NonconformingProductPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;

public interface NonconformingProductMgr {
	
	/**
	 * 取不合格品原因List
	 * @return
	 */
	public List<NonconformingProductPo> getNonconformingProductMaxList() ;
	
	/**
	 * 取不合格品原因List
	 * @return
	 */
	public List<NonconformingProductPo> getNonconformingProductList(NonconformingProductPo po,int start, int size);
	
	/**
	 * 取不合格品数量
	 * @return
	 */
	public int getNonconformingProductCount(NonconformingProductPo po)  ;
	
	/**
	 * 取不合格品现象List
	 * 
	 * @param nonconformingProductPo
	 *            所属原因Po 
	 * @return
	 */
	public List<NonconformingProductPo> getNonconformingProductMinList(NonconformingProductPo nonconformingProductPo);	

	/**
	 * 取指定不合格品原因/现象
	 * @return
	 */
	public NonconformingProductPo getNonconformingProduct(NonconformingProductPo nonconformingProductPo);

	/**
	 * 插入不合格品原因/现象
	 * 
	 * @param nonconformingProductPo
	 *           不合格品原因/现象参数集
	 */
	public void insertNonconformingProduct(NonconformingProductPo nonconformingProductPo,LogisticsLogPo logPo);

	/**
	 * 更新不合格品原因/现象
	 * 
	 * @param nonconformingProductPo
	 *            不合格品原因/现象参数集
	 */
	public void updateNonconformingProduct(NonconformingProductPo nonconformingProductPo,LogisticsLogPo logPo);

	/**
	 * 删除不合格品原因/现象
	 * 
	 * @param nonconformingProductPo
	 *            不合格品原因/现象参数集
	 */
	public void deleteNonconformingProduct(NonconformingProductPo nonconformingProductPo,LogisticsLogPo logPo);
	/**
	 * 添加时判断不合格品现象名称 是否重复
	 * @return
	 */
	public int getNonconformingProductName(NonconformingProductPo nonconformingProductPo);
	/**
	 * 修改时判断不合格品现象名称 是否重复
	 * @return
	 */
	public int getNonconformingProductNameUpdate(NonconformingProductPo nonconformingProductPo) ;
}
