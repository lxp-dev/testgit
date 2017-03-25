package com.pengsheng.eims.personnel.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.persistence.EducationPo;
import com.pengsheng.eims.personnel.persistence.WorkagePo;

public interface WorkageMgr {
	
	/**
	 * 取工龄List
	 * @return
	 */
	public List<WorkagePo> getWorkageList();
	
	/**
	 * 取工龄数量
	 * @return
	 */
	public int getWorkageCount() ;

	/**
	 * 取工龄List
	 * @return
	 */
	public List<WorkagePo> getWorkagesList(int start, int size) ;

	/**
	 * 取指定工龄
	 * 
	 * @param workagePo
	 *            工龄参数集
	 * @return
	 */
	public WorkagePo getWorkage(WorkagePo workagePo);

	/**
	 * 插入工龄
	 * 
	 * @param workagePo
	 *            工龄参数集
	 */
	public void insertWorkage(WorkagePo workagePo,LogisticsLogPo logPo);

	/**
	 * 更新工龄
	 * 
	 * @param workagePo
	 *            工龄参数集
	 */
	public void updateWorkage(WorkagePo workagePo,LogisticsLogPo logPo);

	/**
	 * 删除仓位
	 * 
	 * @param workagePo
	 *            工龄参数集
	 */
	public void deleteWorkage(WorkagePo workagePo,LogisticsLogPo logPo);
	public int getWorkageName(WorkagePo po) ;
	public int getWorkageNameUpdate(WorkagePo po) ;	
}
