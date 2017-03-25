package com.pengsheng.eims.personnel.mgr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.persistence.SchedulingDayPo;
import com.pengsheng.eims.personnel.persistence.SchedulingMonthPo;
import com.pengsheng.eims.personnel.persistence.SchedulingPersonDayPo;
import com.pengsheng.eims.personnel.persistence.SchedulingPersonPo;
import com.pengsheng.eims.personnel.persistence.ShiftMaintainPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface SchedulingMgr 
{
	/**
	 * 查询所有月排班
	 * 
	 * @param 
	 * @return
	 */
	public List<SchedulingMonthPo> getSchedulingMonths(SchedulingMonthPo po,int start, int size) ;
	
	/**
	 * 查询所有月排班总数
	 * 
	 * @param 
	 * @return
	 */
	public int getSchedulingMonthCount(SchedulingMonthPo po) ;

	/**
	 * 查询所有日排班
	 * 
	 * @param 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SchedulingPersonPo> getSchedulingPersonPos(SchedulingPersonPo po,int start, int size) ;
	
	/**
	 * 查询所有日排班总数
	 * 
	 * @param 
	 * @return
	 */
	public int getSchedulingPersonPoCount(SchedulingPersonPo po) ;
	
	/**
	 * 新增月总排班
	 */
	public void insertSchedulingMonthPo(SchedulingMonthPo po,LogisticsLogPo logPo);
	
	public SchedulingMonthPo getSchedulingMonthPoById(String id);

	public SchedulingMonthPo getSchedulingMonthPoByMonth(SchedulingMonthPo po);
	/**
	 * 得到当月所有人员整月对应的班次
	 * @return
	 */
	public List<SchedulingPersonDayPo> getSchedulingPersonDays(String id,int mm);

	public int getSchedulingMonthPoRepeat(SchedulingMonthPo po) ;
	
	public int getSchedulingDayPoRepeat(SchedulingMonthPo po) ;

	public int getSchedulingDayPoUpdate(SchedulingDayPo po);
	/**
	 * 根据id得到排班人员
	 * @return
	 */
	public SchedulingPersonPo getSchedulingPersonById(String id);
	/**
	 * 查询出具体班次
	 * @return
	 */
	public ShiftMaintainPo getShiftMaintainPo(String id);
	/**
	 * 更新排班
	 */
	public void updateSchedulingPersonDay(List<SchedulingPersonDayPo> schedulingPersonDayPos,LogisticsLogPo logPo) 	;

	/**
	 * 新增排班
	 */
	public void insertSchedulingDayPo(SchedulingDayPo schedulingDayPo,List<SchedulingPersonPo> schedulingPersonPos,List<SchedulingPersonDayPo> schedulingPersonDayPos,LogisticsLogPo logPo) ;	

	/**
	 * 更新工资
	 * 
	 * @param 
	 */
	public void updateSchedulingDayPo(SchedulingDayPo schedulingDayPo,List<SchedulingPersonPo> schedulingPersonPos,LogisticsLogPo logPo) ;	

	/**
	 * 删除月排班
	 * 
	 * @param 
	 */
	public void deleteSchedulingMonthPo(String id,LogisticsLogPo logPo) ;
	
	/**
	 * 删除日排班
	 * 
	 * @param 
	 */
	public void deleteSchedulingDayPo(String id,LogisticsLogPo logPo) ;

	/**
	 * 得到人员排班
	 * @return
	 */
	public List<SchedulingPersonPo> getSchedulingPersons(String id);

	
	/**
	 * 得到日排班总
	 * @return
	 */
	public List<SchedulingDayPo> getSchedulingDays(String id);
	
	/**
	 * 得到日排班
	 * @return
	 */
	public SchedulingDayPo selectSchedulingDayPo(String id);
	/**
	 * 根据部门id得到此部门下的人员
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfoByDept(String id);
	/**
	 * 查询出所有班次
	 * @return
	 */
	public List<ShiftMaintainPo> getShiftMaintainPos();
	
	/**
	 * 审核当日班次
	 * @param po
	 */
	public void updateSchedulingDayPoWithExamine(SchedulingDayPo po,LogisticsLogPo logPo);
	
	/**
	 * 新增月排班更新日排班外键
	 * @param 
	 */
	public void insertSchedulingMonthPo(SchedulingMonthPo mpo,List<SchedulingDayPo> dpos,LogisticsLogPo logPo);
	
	/**
	 * 更新月排班审核状态
	 * 
	 * @param 
	 */
	public void updateSchedulingMonthPoWithExamine(SchedulingMonthPo po,LogisticsLogPo logPo);
	
	/**
	 * 查询月排班Po
	 * 
	 * @param 
	 * @return
	 */
	public SchedulingMonthPo getSchedulingMonthPo(String id);
	
}
