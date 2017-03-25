package com.pengsheng.weixin.dao;

import java.util.List;
import com.pengsheng.weixin.persistence.DailyAttendance;

public interface WeiXinDailyAttendanceDao {

	public void deleteDailyAttendancePo(DailyAttendance po);
	
	public void insertDailyAttendancePo(DailyAttendance po) ;
	
	public DailyAttendance selectDailyAttendancePo(DailyAttendance po);
	
	public void insertDailyAttendanceLogPo(DailyAttendance po);
	
	public int getDailyAttendanceLogPo(String openId);
	
	public List<DailyAttendance> getDailyAttendanceSelectList(String openID, int start,int size);
	
	public int getWeiXinIntegralSelectCount(String openID);
	
}
