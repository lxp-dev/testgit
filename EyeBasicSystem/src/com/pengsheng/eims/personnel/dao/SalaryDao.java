package com.pengsheng.eims.personnel.dao;

import java.util.List;

import com.pengsheng.eims.personnel.persistence.SalaryPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface SalaryDao 
{
	/**
	 * 查询所有员工薪酬(查询条件)
	 * 
	 * @param 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalaryPo> getSalarys(SalaryPo po,int start, int size) ;
	
	/**
	 * 查询所有员工薪酬总数
	 * 
	 * @param 
	 * @return
	 */
	public int getSalaryCount(SalaryPo po) ;
	
	/**
	 * 新增员工工资
	 */
	public void insertSalaryPo(SalaryPo po) ;
	
	/**
	 * 更新员工工资
	 * 
	 * @param personInfoPo
	 */
	public void updateSalaryPo(SalaryPo po) ;
	
	/**
	 * 删除员工工资
	 * 
	 * @param 
	 */
	public void deleteSalaryPo(SalaryPo po);

	/**
	 * 得到员工工资模版
	 * @return
	 */
	public SalaryPo selectCompensationTemplatePo(String id);
	
	/**
	 * 得到员工工资
	 * @return
	 */
	public SalaryPo selectSalaryPo(String id);
	
	/**
	 * 判断员工工资是否重复
	 * 
	 * @param 
	 * @return
	 */
	public int getSalaryRepeat(SalaryPo po);
	/**
	 * 查询出人员
	 * 
	 * @param 
	 * @return
	 */
	public PersonInfoPo getPersonByid(String id ) ;
	
	/**
	 * 导出工资
	 * 
	 * @param SalaryPo
	 */
	public List<SalaryPo> bulidSalaryExcel(SalaryPo po);
}
