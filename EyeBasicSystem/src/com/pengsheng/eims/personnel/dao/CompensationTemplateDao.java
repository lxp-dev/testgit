package com.pengsheng.eims.personnel.dao;

import java.util.List;

import com.pengsheng.eims.personnel.persistence.CompensationTemplatePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface CompensationTemplateDao 
{
	/**
	 * 查询所有员工薪酬(查询条件)
	 * 
	 * @param 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CompensationTemplatePo> getCompensationTemplates(CompensationTemplatePo po,int start, int size) ;
	
	/**
	 * 查询所有员工薪酬总数
	 * 
	 * @param 
	 * @return
	 */
	public int getCompensationTemplateCount(CompensationTemplatePo po) ;
	
	/**
	 * 新增员工薪酬模板
	 */
	public void insertCompensationTemplatePo(CompensationTemplatePo po) ;
	
	/**
	 * 更新员工薪酬模板
	 * 
	 * @param personInfoPo
	 */
	public void updateCompensationTemplatePo(CompensationTemplatePo po) ;
	
	/**
	 * 删除员工薪酬模板
	 * 
	 * @param 
	 */
	public void deleteCompensationTemplatePo(CompensationTemplatePo po);
	
	/**
	 * 得到员工薪酬模板
	 * @return
	 */
	public CompensationTemplatePo selectCompensationTemplatePo(String id);
	
	/**
	 * 判断员工薪酬模板是否重复
	 * 
	 * @param 
	 * @return
	 */
	public int getCompensationTemplateRepeat(String id ) ;
	/**
	 * 查询出人员
	 * 
	 * @param 
	 * @return
	 */
	public PersonInfoPo getPersonByid(String id ) ;
}
