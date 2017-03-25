package com.pengsheng.weixin.mgr;

import java.io.File;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.IntegralExchangePo;
import com.pengsheng.eims.system.persistence.BrankCardPo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.weixin.persistence.DailyAttendance;

public interface WeiXinDailyAttendanceMgr {

	public void deleteDailyAttendancePo(DailyAttendance po);
	
	public void insertDailyAttendancePo(DailyAttendance po) ;
	
	public DailyAttendance selectDailyAttendancePo(DailyAttendance po);
	
	public void insertDailyAttendanceLogPo(DailyAttendance po,IntegralExchangePo integralExchangePo);
	
	public int getDailyAttendanceLogPo(String openId);
	
	public List<DailyAttendance> getDailyAttendanceSelectList(String openID, int start,int size);
	
	public int getWeiXinIntegralSelectCount(String openID);
}
