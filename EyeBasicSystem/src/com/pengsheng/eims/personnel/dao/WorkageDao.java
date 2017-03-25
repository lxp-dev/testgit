package com.pengsheng.eims.personnel.dao;

import java.util.List;

import com.pengsheng.eims.personnel.persistence.EducationPo;
import com.pengsheng.eims.personnel.persistence.WorkagePo;

public interface WorkageDao {
	
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
	public void insertWorkage(WorkagePo workagePo);

	/**
	 * 更新工龄
	 * 
	 * @param workagePo
	 *            工龄参数集
	 */
	public void updateWorkage(WorkagePo workagePo);

	/**
	 * 删除工龄
	 * 
	 * @param workagePo
	 *            工龄参数集
	 */
	public void deleteWorkage(WorkagePo workagePo);
	
	public int getWorkageName(WorkagePo po) ;
	
	public int getWorkageNameUpdate(WorkagePo po) ;	
}
