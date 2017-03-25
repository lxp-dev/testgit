package com.pengsheng.eims.personnel.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.persistence.EducationPo;

public interface EducationMgr {
	
	/**
	 * 取商品学历List
	 * @return
	 */
	public List<EducationPo> getEducationList();
	
	/**
	 * 取商品学历数量
	 * @return
	 */
	public int getEducationCount() ;

	/**
	 * 取商品学历List
	 * @return
	 */
	public List<EducationPo> getEducationsList(int start, int size) ;

	/**
	 * 取指定商品学历
	 * 
	 * @param educationPo
	 *            商品学历参数集
	 * @return
	 */
	public EducationPo getEducation(EducationPo educationPo);

	/**
	 * 插入商品学历
	 * 
	 * @param educationPo
	 *            商品学历参数集
	 */
	public void insertEducation(EducationPo educationPo,LogisticsLogPo logPo);

	/**
	 * 更新商品学历
	 * 
	 * @param educationPo
	 *            商品学历参数集
	 */
	public void updateEducation(EducationPo educationPo,LogisticsLogPo logPo);

	/**
	 * 删除仓位
	 * 
	 * @param educationPo
	 *            商品学历参数集
	 */
	public void deleteEducation(EducationPo educationPo,LogisticsLogPo logPo);
	public int getEducationName(EducationPo po) ;
	public int getEducationNameUpdate(EducationPo po) ;
	
	/**
	 * 判断是否有人员使用该学历
	 * @return
	 */
	public int getBeUsed(EducationPo po);
}
