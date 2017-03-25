package com.pengsheng.eims.personnel.dao;

import java.util.List;
import com.pengsheng.eims.personnel.persistence.EducationPo;

public interface EducationDao {
	
	/**
	 * 取学历List
	 * @return
	 */
	public List<EducationPo> getEducationList();
	
	/**
	 * 取学历数量
	 * @return
	 */
	public int getEducationCount() ;

	/**
	 * 取学历List
	 * @return
	 */
	public List<EducationPo> getEducationsList(int start, int size) ;
	

	/**
	 * 取指定学历
	 * 
	 * @param educationPo
	 *            学历参数集
	 * @return
	 */
	public EducationPo getEducation(EducationPo educationPo);

	/**
	 * 插入学历
	 * 
	 * @param educationPo
	 *            学历参数集
	 */
	public void insertEducation(EducationPo educationPo);

	/**
	 * 更新学历
	 * 
	 * @param educationPo
	 *            学历参数集
	 */
	public void updateEducation(EducationPo educationPo);

	/**
	 * 删除学历
	 * 
	 * @param educationPo
	 *            学历参数集
	 */
	public void deleteEducation(EducationPo educationPo);
	
	public int getEducationName(EducationPo po) ;
	
	public int getEducationNameUpdate(EducationPo po) ;
	/**
	 * 判断是否有人员使用该学历
	 * @return
	 */
	public int getBeUsed(EducationPo po);	
}
