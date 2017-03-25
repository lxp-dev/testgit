package com.pengsheng.eims.personnel.mgr.impl;

import java.util.List;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.personnel.dao.AttendanceManageDao;
import com.pengsheng.eims.personnel.dao.MPersonInfoDao;
import com.pengsheng.eims.personnel.mgr.AttendanceManageMgr;
import com.pengsheng.eims.personnel.persistence.AttendanceManagePo;
import com.pengsheng.eims.system.persistence.PersonDepartmentsPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public class AttendanceManageMgrImpl implements AttendanceManageMgr
{
	private AttendanceManageDao attendanceManageDao;
	private LogisticsLogDao logisticsLogDao;
	private List<PersonDepartmentsPo> personDepartments;
	private MPersonInfoDao mpersonInfoDao;
	
	public List<PersonDepartmentsPo> getPersonDepartments() {
		return personDepartments;
	}
	public void setPersonDepartments(List<PersonDepartmentsPo> personDepartments) {
		this.personDepartments = personDepartments;
	}

	public MPersonInfoDao getMpersonInfoDao() {
		return mpersonInfoDao;
	}
	public void setMpersonInfoDao(MPersonInfoDao mpersonInfoDao) {
		this.mpersonInfoDao = mpersonInfoDao;
	}
	public AttendanceManageDao getAttendanceManageDao() {
		return attendanceManageDao;
	}
	public void setAttendanceManageDao(
			AttendanceManageDao attendanceManageDao) {
		this.attendanceManageDao = attendanceManageDao;
	}
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	/**
	 * 查询所有员工考勤(查询条件)
	 * 
	 * @param 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<AttendanceManagePo> getAttendanceManages(AttendanceManagePo po,int start, int size)
	{
		return attendanceManageDao.getAttendanceManages(po, start, size);
	}
	/**
	 * 查询所有员工考勤总数
	 * 
	 * @param 
	 * @return
	 */
	public int getAttendanceManageCount(AttendanceManagePo po)
	{
		return attendanceManageDao.getAttendanceManageCount(po);
	}
	
	/**
	 * 新增员工考勤
	 */
	public void insertAttendanceManagePo(AttendanceManagePo po,LogisticsLogPo logPo)
	{
		String stringarray[]=po.getMampersonid().split(",");   
		for(int i=0;i<stringarray.length;i++){   
			logisticsLogDao.insertLog(logPo);	
			po.setMampersonid(stringarray[i]);
			attendanceManageDao.insertAttendanceManagePo(po);
		}
	}
	/**
	 * 更新员工考勤
	 * 
	 * @param personInfoPo
	 */
	public void updateAttendanceManagePo(AttendanceManagePo po,LogisticsLogPo logPo)
	{
		logisticsLogDao.insertLog(logPo);
		attendanceManageDao.updateAttendanceManagePo(po);		
	}
	
	/**
	 * 删除员工考勤
	 * 
	 * @param 
	 */
	public void deleteAttendanceManagePo(AttendanceManagePo po,LogisticsLogPo logPo)
	{
		logisticsLogDao.insertLog(logPo);
		attendanceManageDao.deleteAttendanceManagePo(po);
	}
	
	/**
	 * 得到员工考勤
	 * @return
	 */
	public AttendanceManagePo selectAttendanceManagePo(String id)
	{
		return attendanceManageDao.selectAttendanceManagePo(id);
	}
	
	/**
	 * 判断员工考勤是否重复
	 * 
	 * @param 
	 * @return
	 */
	public int getAttendanceManageRepeat(AttendanceManagePo po)
	{
		return attendanceManageDao.getAttendanceManageRepeat(po);
	}
	/**
	 * 查询出人员
	 * 
	 * @param 
	 * @return
	 */
	public AttendanceManagePo getPersonByid(String id ) 
	{
		return attendanceManageDao.getPersonByid(id ); 
	}
}
