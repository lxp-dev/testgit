package com.pengsheng.eims.personnel.mgr.impl;

import java.text.DecimalFormat;
import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.dao.CompensationTemplateDao;
import com.pengsheng.eims.personnel.mgr.CompensationTemplateMgr;
import com.pengsheng.eims.personnel.persistence.CompensationTemplatePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public class CompensationTemplateMgrImpl implements CompensationTemplateMgr
{
	private CompensationTemplateDao compensationTemplateDao;
	private LogisticsLogDao logisticsLogDao;
	
	public CompensationTemplateDao getCompensationTemplateDao() {
		return compensationTemplateDao;
	}
	public void setCompensationTemplateDao(
			CompensationTemplateDao compensationTemplateDao) {
		this.compensationTemplateDao = compensationTemplateDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	/**
	 * 查询所有员工薪酬(查询条件)
	 * 
	 * @param 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<CompensationTemplatePo> getCompensationTemplates(CompensationTemplatePo po,int start, int size)
	{
		return compensationTemplateDao.getCompensationTemplates(po, start, size);
	}
	/**
	 * 查询所有员工薪酬总数
	 * 
	 * @param 
	 * @return
	 */
	public int getCompensationTemplateCount(CompensationTemplatePo po)
	{
		return compensationTemplateDao.getCompensationTemplateCount(po);
	}
	
	/**
	 * 新增员工薪酬模板
	 */
	public void insertCompensationTemplatePo(CompensationTemplatePo po,LogisticsLogPo logPo)
	{
		logisticsLogDao.insertLog(logPo);	
//		DecimalFormat df = new DecimalFormat("########.00");
//		double mm=0;
//		if(null!=po.getMctbasicsalary() && !"".equals(po.getMctbasicsalary()))
//		{
//			mm+=Double.parseDouble(po.getMctbasicsalary());
//		}
//		if(null!=po.getMctattendanceaward() && !"".equals(po.getMctattendanceaward()))
//		{
//			mm+=Double.parseDouble(po.getMctattendanceaward());
//		}
//		if(null!=po.getMctdutyallowance() && !"".equals(po.getMctdutyallowance()))
//		{
//			mm+=Double.parseDouble(po.getMctdutyallowance());
//		}
//		if(null!=po.getMctsubsidy() && !"".equals(po.getMctsubsidy()))
//		{
//			mm+=Double.parseDouble(po.getMctsubsidy());
//		}
//		if(null!=po.getMcthousingreserve() && !"".equals(po.getMcthousingreserve()))
//		{
//			mm-=Double.parseDouble(po.getMcthousingreserve());
//		}
//		if(null!=po.getMctpersonalsecurity() && !"".equals(po.getMctpersonalsecurity()))
//		{
//			mm-=Double.parseDouble(po.getMctpersonalsecurity());
//		}
//		po.setMctmonthsalary(df.format(mm).toString());

		compensationTemplateDao.insertCompensationTemplatePo(po);
	}
	/**
	 * 更新员工薪酬模板
	 * 
	 * @param personInfoPo
	 */
	public void updateCompensationTemplatePo(CompensationTemplatePo po,LogisticsLogPo logPo)
	{
		logisticsLogDao.insertLog(logPo);
//		DecimalFormat df = new DecimalFormat("########.00");
//		double mm=0;
//		if(null!=po.getMctbasicsalary() && !"".equals(po.getMctbasicsalary()))
//		{
//			mm+=Double.parseDouble(po.getMctbasicsalary());
//		}
//		if(null!=po.getMctattendanceaward() && !"".equals(po.getMctattendanceaward()))
//		{
//			mm+=Double.parseDouble(po.getMctattendanceaward());
//		}
//		if(null!=po.getMctdutyallowance() && !"".equals(po.getMctdutyallowance()))
//		{
//			mm+=Double.parseDouble(po.getMctdutyallowance());
//		}
//		if(null!=po.getMctsubsidy() && !"".equals(po.getMctsubsidy()))
//		{
//			mm+=Double.parseDouble(po.getMctsubsidy());
//		}
//		if(null!=po.getMcthousingreserve() && !"".equals(po.getMcthousingreserve()))
//		{
//			mm-=Double.parseDouble(po.getMcthousingreserve());
//		}
//		if(null!=po.getMctpersonalsecurity() && !"".equals(po.getMctpersonalsecurity()))
//		{
//			mm-=Double.parseDouble(po.getMctpersonalsecurity());
//		}
//		po.setMctmonthsalary(df.format(mm).toString());
//		
		compensationTemplateDao.updateCompensationTemplatePo(po);		
	}
	
	/**
	 * 删除员工薪酬模板
	 * 
	 * @param 
	 */
	public void deleteCompensationTemplatePo(CompensationTemplatePo po,LogisticsLogPo logPo)
	{
		logisticsLogDao.insertLog(logPo);
		compensationTemplateDao.deleteCompensationTemplatePo(po);
	}

	/**
	 * 得到员工薪酬模板
	 * @return
	 */
	public CompensationTemplatePo selectCompensationTemplatePo(String id)
	{
		return compensationTemplateDao.selectCompensationTemplatePo(id);
	}
	
	/**
	 * 判断员工薪酬模板是否重复
	 * 
	 * @param 
	 * @return
	 */
	public int getCompensationTemplateRepeat(String id )
	{
		return compensationTemplateDao.getCompensationTemplateRepeat(id);
	}
	/**
	 * 查询出人员
	 * 
	 * @param 
	 * @return
	 */
	public PersonInfoPo getPersonByid(String id ) 
	{
		return compensationTemplateDao.getPersonByid(id ); 
	}
	
}
