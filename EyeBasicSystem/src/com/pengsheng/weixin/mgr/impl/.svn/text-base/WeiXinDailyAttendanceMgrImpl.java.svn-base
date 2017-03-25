package com.pengsheng.weixin.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import rtx.RTXSvrApi;

import com.pengsheng.eims.basic.dao.WarehouseDao;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.persistence.IntegralExchangePo;
import com.pengsheng.eims.storage.dao.ProcurementOrdersDao;
import com.pengsheng.eims.system.dao.DepartmentsDao;
import com.pengsheng.eims.system.dao.PersonInfoDao;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.mgr.DepartmentsMgr;
import com.pengsheng.eims.system.persistence.BrankCardPo;
import com.pengsheng.eims.system.persistence.FuctionTreeNode;
import com.pengsheng.eims.system.persistence.PersonInfoPo;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.bean.UUIDHexGenerator;
import com.pengsheng.eims.util.tools.Utility;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.weixin.dao.WeiXinDailyAttendanceDao;
import com.pengsheng.weixin.dao.WeiXinDepartmentsDao;
import com.pengsheng.weixin.mgr.WeiXinDailyAttendanceMgr;
import com.pengsheng.weixin.mgr.WeiXinDepartmentsMgr;
import com.pengsheng.weixin.persistence.DailyAttendance;

public class WeiXinDailyAttendanceMgrImpl implements  WeiXinDailyAttendanceMgr {
	 private WeiXinDailyAttendanceDao weiXinDailyAttendanceDao;
	 private GuitarManagementDao guitarManagementDao;
		
		public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
	}

	public void setGuitarManagementDao(GuitarManagementDao guitarManagementDao) {
		this.guitarManagementDao = guitarManagementDao;
	}

		public WeiXinDailyAttendanceDao getWeiXinDailyAttendanceDao() {
		return weiXinDailyAttendanceDao;
	}
	
	public void setWeiXinDailyAttendanceDao(
			WeiXinDailyAttendanceDao weiXinDailyAttendanceDao) {
		this.weiXinDailyAttendanceDao = weiXinDailyAttendanceDao;
	}

	public void deleteDailyAttendancePo(DailyAttendance po){
		weiXinDailyAttendanceDao.deleteDailyAttendancePo(po);
	}
	
	public void insertDailyAttendancePo(DailyAttendance po){
		weiXinDailyAttendanceDao.deleteDailyAttendancePo(po);
		weiXinDailyAttendanceDao.insertDailyAttendancePo(po);
	}
	
	public DailyAttendance selectDailyAttendancePo(DailyAttendance po){
		return weiXinDailyAttendanceDao.selectDailyAttendancePo(po);
	}
	
	public void insertDailyAttendanceLogPo(DailyAttendance po,IntegralExchangePo integralExchangePo){
		BigDecimal bg4 = new BigDecimal(integralExchangePo.getFilintegralsum()); // 原有积分
		BigDecimal bg3 = new BigDecimal(po.getWdlintegral().toString()); 
		integralExchangePo.setFilintegralCount(po.getWdlintegral());
		integralExchangePo.setFilintegralsum(bg4.add(bg3).toString());
		
		guitarManagementDao.insertIntegralExchange(integralExchangePo);
		guitarManagementDao.updateCustomerIntegrals(po.getWdlopenid(),"-"+po.getWdlintegral());
		weiXinDailyAttendanceDao.insertDailyAttendanceLogPo(po);
	}
	
	public int getDailyAttendanceLogPo(String openId){
		return weiXinDailyAttendanceDao.getDailyAttendanceLogPo(openId);
	}
	
	public List<DailyAttendance> getDailyAttendanceSelectList(String openID, int start,int size){
		return weiXinDailyAttendanceDao.getDailyAttendanceSelectList(openID, start, size);
	}
	
	public int getWeiXinIntegralSelectCount(String openID){
		return weiXinDailyAttendanceDao.getWeiXinIntegralSelectCount(openID);
	} 
}
