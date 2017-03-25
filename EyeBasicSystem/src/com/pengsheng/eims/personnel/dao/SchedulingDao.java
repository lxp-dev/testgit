package com.pengsheng.eims.personnel.dao;

import java.util.List;

import com.pengsheng.eims.personnel.persistence.SchedulingDayPo;
import com.pengsheng.eims.personnel.persistence.SchedulingMonthPo;
import com.pengsheng.eims.personnel.persistence.SchedulingPersonDayPo;
import com.pengsheng.eims.personnel.persistence.SchedulingPersonPo;
import com.pengsheng.eims.personnel.persistence.ShiftMaintainPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface SchedulingDao 
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
	 * 查询出具体班次
	 * @return
	 */
	public ShiftMaintainPo getShiftMaintainPo(String id);
	/**
	 * 新增月总排班
	 */
	public void insertSchedulingMonthPo(SchedulingMonthPo po) ;
	public SchedulingMonthPo getSchedulingMonthPoById(String id);
	public SchedulingMonthPo getSchedulingMonthPoByMonth(SchedulingMonthPo po);
	public int getSchedulingMonthPoRepeat(SchedulingMonthPo po) ;
	public int getSchedulingDayPoRepeat(SchedulingMonthPo po) ;
	public int getSchedulingDayPoUpdate(SchedulingDayPo po) ;
	public int getSchedulingPersonPoRepeat(SchedulingPersonPo po) ;
	public void deleteSchedulingPersonDay(SchedulingPersonDayPo po) ;
	/**
	 * 得到当月所有人员整月对应的班次
	 * @return
	 */
	public List<SchedulingPersonDayPo> getSchedulingPersonDays(String id,int mm);
	/**
	 * 得到日排班人员
	 * @return
	 */
	public SchedulingPersonPo getSchedulingPersonByDate(SchedulingPersonPo po);
	/**
	 * 新增日排班
	 */
	public void insertSchedulingDayPo(SchedulingDayPo po) ;
	/**
	 * 更新日排班
	 * 
	 * @param 
	 */
	public void updateSchedulingDayPo(SchedulingDayPo po) ;
	/**
	 * 新增人员排班
	 */
	public void insertSchedulingPersonPo(SchedulingPersonPo po) ;
	/**
	 * 根据id得到排班人员
	 * @return
	 */
	public SchedulingPersonPo getSchedulingPersonById(String id);
	/**
	 * 删除人员排班
	 * 
	 * @param 
	 */
	public void deleteSchedulingPersons(String id) ;
	/**
	 * 删除月总工资
	 * 
	 * @param 
	 */
	public void delSchedulingPersonDay(String id) ;
	/**
	 * 删除工资（月总工资对应的）
	 * 
	 * @param 
	 */
	public void deleteSchedulingMonthPo(String id) ;
	/**
	 * 得到日排班
	 * @return
	 */
	public SchedulingDayPo selectSchedulingDayPo(String id);
	/**
	 * 得到人员排班
	 * @return
	 */
	public List<SchedulingPersonPo> getSchedulingPersons(String id);
	/**
	 * 得到日排班
	 * @return
	 */
	public SchedulingDayPo getSchedulingDayByDate(String month,String day);
	/**
	 * 删除日排班总
	 * 
	 * @param 
	 */
	public void deleteSchedulingDays(String id) ;
	/**
	 * 得到日排班总
	 * @return
	 */
	public List<SchedulingDayPo> getSchedulingDays(String id);
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
	public void updateSchedulingDayPoWithExamine(SchedulingDayPo po);
	
	/**
	 * 更新日排班外键
	 * @param 
	 */
	public void updateSchedulingDayPoWithMsdsmuuid(SchedulingDayPo po);
	
	
	/**
	 * 新增日排班班次
	 */
	public void insertSchedulingPersonDayPo(SchedulingPersonDayPo po) ;
	
	/**
	 * 更新月排班审核状态
	 * 
	 * @param 
	 */
	public void updateSchedulingMonthPoWithExamine(SchedulingMonthPo po);
	
	/**
	 * 清空日排班中月排班外键
	 * 
	 * @param 
	 */
	public void updateSchedulingDayPoWithMsdsmuuid(String id);
	
	/**
	 * 查询月排班Po
	 * 
	 * @param 
	 * @return
	 */
	public SchedulingMonthPo getSchedulingMonthPo(String id);
	public void delSchedulingDayByMonthid(String id); 
	
	public void delSchedulingPersonByMonthid(String id) ;

	public void delSchedulingPersonDayByMonthid(String id) ;
	/**
	 * 新增日排班班次
	 */
	public void insertSchedulingPersonDayPos(List<SchedulingPersonDayPo> pos) ;
	/**
	 * 得到日排班id
	 * @return
	 */
	public SchedulingDayPo getSchedulingDayIdByDate(String month,String day);
	/**
	 * 得到日排班人员id
	 * @return
	 */
	public SchedulingPersonPo getSchedulingPersonIdByDate(SchedulingPersonPo po);
	/**
	 * 新增日排班s
	 */
	public void insertSchedulingDayPos(List<SchedulingDayPo> pos);
	/**
	 * 新增人员排班s
	 */
	public void insertSchedulingPersonPos(List<SchedulingPersonPo> pos) ;
	
}
