package com.pengsheng.eims.personnel.mgr.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.dao.SchedulingDao;
import com.pengsheng.eims.personnel.mgr.SchedulingMgr;
import com.pengsheng.eims.personnel.persistence.MonthWagePo;
import com.pengsheng.eims.personnel.persistence.SchedulingDayPo;
import com.pengsheng.eims.personnel.persistence.SchedulingMonthPo;
import com.pengsheng.eims.personnel.persistence.SchedulingPersonDayPo;
import com.pengsheng.eims.personnel.persistence.SchedulingPersonPo;
import com.pengsheng.eims.personnel.persistence.ShiftMaintainPo;
import com.pengsheng.eims.personnel.persistence.WagePo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;

public class SchedulingMgrImpl implements SchedulingMgr
{
	private LogisticsLogDao logisticsLogDao;
	private SchedulingDao schedulingDao;
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	public SchedulingDao getSchedulingDao() {
		return schedulingDao;
	}
	public void setSchedulingDao(SchedulingDao schedulingDao) {
		this.schedulingDao = schedulingDao;
	}
	
	
	
	
	/**
	 * 查询所有月排班
	 * 
	 * @param 
	 * @return
	 */
	public List<SchedulingMonthPo> getSchedulingMonths(SchedulingMonthPo po,int start, int size) 
	{
		return schedulingDao.getSchedulingMonths(po, start, size);
	}
	/**
	 * 查询所有月排班总数
	 * 
	 * @param 
	 * @return
	 */
	public int getSchedulingMonthCount(SchedulingMonthPo po) 
	{
		return schedulingDao.getSchedulingMonthCount(po);
	}
	/**
	 * 查询所有日排班
	 * 
	 * @param 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SchedulingPersonPo> getSchedulingPersonPos(SchedulingPersonPo po,int start, int size) 
	{
		return schedulingDao.getSchedulingPersonPos(po, start, size);
	}
	/**
	 * 查询所有日排班总数
	 * 
	 * @param 
	 * @return
	 */
	public int getSchedulingPersonPoCount(SchedulingPersonPo po) 
	{
		return schedulingDao.getSchedulingPersonPoCount(po);
	}
	/**
	 * 新增月总排班
	 */
	public void insertSchedulingMonthPo(SchedulingMonthPo po,LogisticsLogPo logPo)
	{
		schedulingDao.insertSchedulingMonthPo(po);
		logisticsLogDao.insertLog(logPo);
	}
	public SchedulingMonthPo getSchedulingMonthPoById(String id)
	{
		return schedulingDao.getSchedulingMonthPoById(id);
	}
	public SchedulingMonthPo getSchedulingMonthPoByMonth(SchedulingMonthPo po)
	{
		return schedulingDao.getSchedulingMonthPoByMonth(po);
	}
	public int getSchedulingMonthPoRepeat(SchedulingMonthPo po) 
	{
		return schedulingDao.getSchedulingMonthPoRepeat(po);
	}
	public int getSchedulingDayPoRepeat(SchedulingMonthPo po) 
	{
		return schedulingDao.getSchedulingDayPoRepeat(po);
	}
	public int getSchedulingDayPoUpdate(SchedulingDayPo po)
	{
		return schedulingDao.getSchedulingDayPoUpdate(po);
	}
	

	/**
	 * 新增排班
	 */
	public void insertSchedulingDayPo(SchedulingDayPo schedulingDayPo,List<SchedulingPersonPo> schedulingPersonPos,List<SchedulingPersonDayPo> schedulingPersonDayPos,LogisticsLogPo logPo) 	
	{

		SchedulingMonthPo schedulingMonthPo=new SchedulingMonthPo();
		
		schedulingMonthPo.setMsmyear(schedulingDayPo.getMsdyear());
		schedulingMonthPo.setMsmmonth(schedulingDayPo.getMsdmonth());
		schedulingMonthPo.setMsmdepartmentid(schedulingDayPo.getMsddepartmentid());
		SimpleDateFormat headFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		int tem=schedulingDao.getSchedulingMonthPoRepeat(schedulingMonthPo);
		if(tem<=0)
		{
			SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
			String temp= numHeadFormat.format(new Date());
			schedulingMonthPo.setMsmnumber("PB"+temp);
			schedulingMonthPo.setMsmcreatepersonid(schedulingDayPo.getMsdcreatepersonid());
			schedulingMonthPo.setMsmexaminestate("0");			
			schedulingMonthPo.setMsmcreatedate(headFormat.format(new Date()));			
			schedulingDao.insertSchedulingMonthPo(schedulingMonthPo);
		}
		SchedulingMonthPo smp=new SchedulingMonthPo();
		smp=schedulingDao.getSchedulingMonthPoByMonth(schedulingMonthPo);

		//根据年月判断日子是否插入schedulingDayPo
		int days=schedulingDao.getSchedulingDayPoRepeat(smp);
		List<SchedulingDayPo> daypos=new ArrayList<SchedulingDayPo>();
		if(days<=0)
		{
			int year=Integer.parseInt(schedulingDayPo.getMsdyear());
			int month=Integer.parseInt(schedulingDayPo.getMsdmonth());
			Calendar  a = Calendar.getInstance();  
	        a.set(Calendar.YEAR, year);  
	        a.set(Calendar.MONTH, month - 1);  
	        a.set(Calendar.DATE, 1);  
	        a.roll(Calendar.DATE, -1);  
	        int maxDate = a.get(Calendar.DATE); 
	        for(int i=1;i<=maxDate;i++)
	        {	
	        	SchedulingDayPo sdy=new SchedulingDayPo();
	        	sdy.setMsdcreatepersonid(schedulingDayPo.getMsdcreatepersonid());
	        	sdy.setMsdcreatedate(schedulingDayPo.getMsdcreatedate());
	        	sdy.setMsdnumber(schedulingDayPo.getMsdnumber());
	        	
	        	sdy.setMsdsmuuid(smp.getMsmuuid());
	        	sdy.setMsdcreatedate(headFormat.format(new Date()));
	        	sdy.setMsdschedulingdate(i+"");
	        	daypos.add(sdy);
	        }
		}
		schedulingDao.insertSchedulingDayPos(daypos);

		//根据年月插入人员表
		List<SchedulingPersonPo> perpos=new ArrayList<SchedulingPersonPo>();
		if(null!=schedulingPersonPos && schedulingPersonPos.size()>0)
		{
			Iterator<SchedulingPersonPo> sp = schedulingPersonPos.iterator();
			while (sp.hasNext()) 
			{
				SchedulingPersonPo schedulingPersonPo = sp.next();
				schedulingPersonPo.setMspsmuuid(smp.getMsmuuid());
				int com=schedulingDao.getSchedulingPersonPoRepeat(schedulingPersonPo);
				if(com<=0)
				{
					perpos.add(schedulingPersonPo);
				}
			}
		}
		schedulingDao.insertSchedulingPersonPos(perpos);
	
		//插入人员日期排班的中间表
		List<SchedulingPersonDayPo> pos=new ArrayList<SchedulingPersonDayPo>();
		if(null!=schedulingPersonDayPos && schedulingPersonDayPos.size()>0)
		{
			int tm=schedulingPersonDayPos.size();
			for(int i=0;i<tm;i++)
			{
	
				SchedulingPersonDayPo schedulingPersonDayPo=schedulingPersonDayPos.get(i);
				schedulingPersonDayPo.setMspdsmuuid(smp.getMsmuuid());
				//根据日子查询出SchedulingDayPo的主键
				SchedulingDayPo sdpo=schedulingDao.getSchedulingDayIdByDate(schedulingPersonDayPo.getMspdsmuuid(), schedulingPersonDayPo.getMspdsduuid());
				//根据人员查询出SchedulingPersonPo的主键
				SchedulingPersonPo temp1=new SchedulingPersonPo();
				temp1.setMspsmuuid(smp.getMsmuuid());
				temp1.setMsppersonid(schedulingPersonDayPo.getMspdspuuid());
				SchedulingPersonPo spdo=schedulingDao.getSchedulingPersonIdByDate(temp1);
				//为schedulingPersonDayPo赋值
				schedulingPersonDayPo.setMspdspuuid(spdo.getMspuuid());
				schedulingPersonDayPo.setMspdsduuid(sdpo.getMsduuid());		
				pos.add(schedulingPersonDayPo);
//				schedulingDao.deleteSchedulingPersonDay(schedulingPersonDayPo);				
//				schedulingDao.insertSchedulingPersonDayPo(schedulingPersonDayPo);				
			}
		}
		schedulingDao.insertSchedulingPersonDayPos(pos);
		
		
		
		logisticsLogDao.insertLog(logPo);
	}

	/**
	 * 更新排班
	 */
	public void updateSchedulingPersonDay(List<SchedulingPersonDayPo> schedulingPersonDayPos,LogisticsLogPo logPo) 	
	{
		
		//插入人员日期排班的中间表
		if(null!=schedulingPersonDayPos && schedulingPersonDayPos.size()>0)
		{
			int tm=schedulingPersonDayPos.size();
			for(int i=0;i<tm;i++)
			{
				SchedulingPersonDayPo schedulingPersonDayPo=schedulingPersonDayPos.get(i);								
				schedulingDao.deleteSchedulingPersonDay(schedulingPersonDayPo);				
				schedulingDao.insertSchedulingPersonDayPo(schedulingPersonDayPo);
				
			}
		}
						
		logisticsLogDao.insertLog(logPo);
	}
	/**
	 * 更新工资
	 * 
	 * @param 
	 */
	public void updateSchedulingDayPo(SchedulingDayPo schedulingDayPo,List<SchedulingPersonPo> schedulingPersonPos,LogisticsLogPo logPo) 	
	{
		SchedulingMonthPo schedulingMonthPo=new SchedulingMonthPo();
		String[] mm=schedulingDayPo.getMsdschedulingdate().split("-");
		schedulingMonthPo.setMsmyear(mm[0]);
		schedulingMonthPo.setMsmmonth(mm[1]);
		schedulingMonthPo.setMsmdepartmentid(schedulingDayPo.getMsddepartmentid());
		SimpleDateFormat headFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		int tem=schedulingDao.getSchedulingMonthPoRepeat(schedulingMonthPo);
		if(tem<=0)
		{
			SimpleDateFormat numHeadFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
			String temp= numHeadFormat.format(new Date());
			schedulingMonthPo.setMsmnumber("PB"+temp);
			schedulingMonthPo.setMsmcreatepersonid(schedulingDayPo.getMsdcreatepersonid());
			schedulingMonthPo.setMsmexaminestate("0");			
			schedulingMonthPo.setMsmcreatedate(headFormat.format(new Date()));
			
			schedulingDao.insertSchedulingMonthPo(schedulingMonthPo);
		}
		SchedulingMonthPo smp=new SchedulingMonthPo();
		smp=schedulingDao.getSchedulingMonthPoByMonth(schedulingMonthPo);
		
		schedulingDayPo.setMsdsmuuid(smp.getMsmuuid());
		schedulingDao.updateSchedulingDayPo(schedulingDayPo);
		
		schedulingDao.deleteSchedulingPersons(schedulingDayPo.getMsduuid());
		
		if(null!=schedulingPersonPos && schedulingPersonPos.size()>0)
		{
			Iterator<SchedulingPersonPo> sp = schedulingPersonPos.iterator();
			while (sp.hasNext()) 
			{
				SchedulingPersonPo schedulingPersonPo = sp.next();
				schedulingPersonPo.setMspsduuid(schedulingDayPo.getMsduuid());
				schedulingPersonPo.setMspexaminestate("0");
				schedulingDao.insertSchedulingPersonPo(schedulingPersonPo);
			}
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	/**
	 * 删除月排班
	 * 
	 * @param 
	 
	public void deleteSchedulingMonthPo(String id,LogisticsLogPo logPo) 
	{
		List<SchedulingDayPo> schedulingDayPos=schedulingDao.getSchedulingDays(id);
		if(null!=schedulingDayPos && schedulingDayPos.size()>0)
		{
			int mm=schedulingDayPos.size();
			for(int i=0;i<mm;i++)
			{
				SchedulingDayPo sp=schedulingDayPos.get(i);
				schedulingDao.deleteSchedulingPersons(sp.getMsduuid());
			}
		}
		schedulingDao.deleteSchedulingDays(id);
		schedulingDao.deleteSchedulingMonthPo(id);
		
		logisticsLogDao.insertLog(logPo);
	}*/
	
	
	/**
	 * 删除日排班
	 * 
	 * @param 
	 */
	public void deleteSchedulingDayPo(String id,LogisticsLogPo logPo) 
	{
		schedulingDao.deleteSchedulingPersons(id);
		schedulingDao.delSchedulingPersonDay(id);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 得到人员排班
	 * @return
	 */
	public List<SchedulingPersonPo> getSchedulingPersons(String id)
	{
		return schedulingDao.getSchedulingPersons(id);
	}
	
	/**
	 * 得到日排班总
	 * @return
	 */
	public List<SchedulingDayPo> getSchedulingDays(String id)
	{
		return schedulingDao.getSchedulingDays(id);
	}
	/**
	 * 查询出具体班次
	 * @return
	 */
	public ShiftMaintainPo getShiftMaintainPo(String id)
	{
		return schedulingDao.getShiftMaintainPo(id);
	}
	/**
	 * 得到当月所有人员整月对应的班次
	 * @return
	 */
	public List<SchedulingPersonDayPo> getSchedulingPersonDays(String id,int mm)
	{		
		return schedulingDao.getSchedulingPersonDays(id,mm);
	}
	
	/**
	 * 得到日排班
	 * @return
	 */
	public SchedulingDayPo selectSchedulingDayPo(String id)
	{
		return schedulingDao.selectSchedulingDayPo(id);
	}
	/**
	 * 根据部门id得到此部门下的人员
	 * @return
	 */
	public List<PersonInfoPo> getPersonInfoByDept(String id)
	{
		return schedulingDao.getPersonInfoByDept(id);
	}
	/**
	 * 查询出所有班次
	 * @return
	 */
	public List<ShiftMaintainPo> getShiftMaintainPos()
	{
		return schedulingDao.getShiftMaintainPos();
	}
	
	/**
	 * 审核当日班次
	 * @param po
	 */
	public void updateSchedulingDayPoWithExamine(SchedulingDayPo po,LogisticsLogPo logPo){
		schedulingDao.updateSchedulingDayPoWithExamine(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 新增月排班更新日排班外键
	 * @param 
	 */
	public void insertSchedulingMonthPo(SchedulingMonthPo mpo,List<SchedulingDayPo> dpos,LogisticsLogPo logPo){
		mpo.setMsmuuid(UUIDHexGenerator.getInstance().generate());
		schedulingDao.insertSchedulingMonthPo(mpo);
		
		for(int i=0; i<dpos.size(); i++){
			dpos.get(i).setMsdsmuuid(mpo.getMsmuuid());
			schedulingDao.updateSchedulingDayPoWithMsdsmuuid(dpos.get(i));
		}
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 更新月排班审核状态
	 * 
	 * @param 
	 */
	public void updateSchedulingMonthPoWithExamine(SchedulingMonthPo po,LogisticsLogPo logPo){
		schedulingDao.updateSchedulingMonthPoWithExamine(po);
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 删除月排班
	 * 
	 * @param 
	 */
	public void deleteSchedulingMonthPo(String id,LogisticsLogPo logPo){
		
		schedulingDao.delSchedulingPersonDayByMonthid(id);
		schedulingDao.delSchedulingPersonByMonthid(id) ;
		schedulingDao.delSchedulingDayByMonthid(id);
		schedulingDao.deleteSchedulingMonthPo(id);
		
		logisticsLogDao.insertLog(logPo);
	}
	
	/**
	 * 查询月排班Po
	 * 
	 * @param 
	 * @return
	 */
	public SchedulingMonthPo getSchedulingMonthPo(String id){
		return schedulingDao.getSchedulingMonthPo(id);
	}
	/**
	 * 根据id得到排班人员
	 * @return
	 */
	public SchedulingPersonPo getSchedulingPersonById(String id)
	{
		return schedulingDao.getSchedulingPersonById(id);
	}
}
