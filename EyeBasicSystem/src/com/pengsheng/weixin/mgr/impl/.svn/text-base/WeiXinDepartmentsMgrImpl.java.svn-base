package com.pengsheng.weixin.mgr.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import rtx.RTXSvrApi;

import com.pengsheng.eims.basic.dao.WarehouseDao;
import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.StatusModulePo;
import com.pengsheng.eims.basic.persistence.WarehouseConfigurationPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
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
import com.pengsheng.weixin.dao.WeiXinDepartmentsDao;
import com.pengsheng.weixin.mgr.WeiXinDepartmentsMgr;
import com.pengsheng.weixin.persistence.WeiXinDepartmentPicPo;

public class WeiXinDepartmentsMgrImpl implements WeiXinDepartmentsMgr {
	
	private LogisticsLogDao logisticsLogDao;	

	private WeiXinDepartmentsDao weiXinDepartmentsDao;
	
	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}
	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}
	
	public WeiXinDepartmentsDao getWeiXinDepartmentsDao() {
		return weiXinDepartmentsDao;
	}
	public void setWeiXinDepartmentsDao(WeiXinDepartmentsDao weiXinDepartmentsDao) {
		this.weiXinDepartmentsDao = weiXinDepartmentsDao;
	}
	/**
	 * 查询部门
	 */
	public DepartmentsPo getDepartment(DepartmentsPo departmentsPo) {
		DepartmentsPo returnDepartmentsPo = weiXinDepartmentsDao.getDepartment(departmentsPo);
		if(!Utility.getName(returnDepartmentsPo.getBdppicurl()).equals("")){
			returnDepartmentsPo.setBdppicurl2(returnDepartmentsPo.getBdppicurl()+",");			
		}
		return returnDepartmentsPo;
	}
	
	/**
	 * 修改部门
	 */
	public void updateDepartment(DepartmentsPo departmentsPo,LogisticsLogPo logPo) {

		weiXinDepartmentsDao.updateDepartment(departmentsPo);
		logisticsLogDao.insertLog(logPo); //添加日志
	}

	


	
	/**
	 * 查询部门的数量
	 * 
	 * @param po
	 * @return
	 */
	public int getDepartmentCount(DepartmentsPo po){
		return weiXinDepartmentsDao.getDepartmentCount(po);
	}
	
	/**
	 * 查询部门列表
	 * 
	 * @param po
	 * @return
	 */
	public List<DepartmentsPo> getDepartmentList(DepartmentsPo po,int start,int size){
		return weiXinDepartmentsDao.getDepartmentList(po,start,size);
	}
	
	/**
	 * 查询部门列表
	 */
	public List<DepartmentsPo> getDepartmentsList(DepartmentsPo po){
		return weiXinDepartmentsDao.getDepartmentsList(po);
	}
	
	/**
	 * 更新门店是否为微信可见的状态
	 * 
	 * @param departmentsPo
	 */
    public void updateSeeDepartment(DepartmentsPo departmentsPo) {
	
    	weiXinDepartmentsDao.updateSeeDepartment(departmentsPo);
    }
    
	/**
	 * 更新门店是否为微信可预约的状态
	 * 
	 * @param departmentsPo
	 */
	public void updateOptometryAppointmentDepartment(DepartmentsPo departmentsPo) {
	
    	weiXinDepartmentsDao.updateOptometryAppointmentDepartment(departmentsPo);
    }
	
	/**
	 * 获取门店实景图List
	 * 
	 * @param departmentID
	 */
	public List<WeiXinDepartmentPicPo> getDepartmentPicList(String departmentID) {
		return weiXinDepartmentsDao.getDepartmentPicList(departmentID);
	}
	
	/**
	 * 更新门店实景图
	 * 
	 * @param departmentsPo
	 */
	public void updateDepartmentPic(DepartmentsPo departmentsPo,LogisticsLogPo logPo){
		String departmentPicurls = "";
		weiXinDepartmentsDao.deleteWeiXinDepartmentPic(departmentsPo.getBdpdepartmentid());
		if(!departmentsPo.getBdppicurls().equals("")){
			String stringarray[]=departmentsPo.getBdppicurls().split(",");  
			WeiXinDepartmentPicPo weiXinDepartmentPicPo = new WeiXinDepartmentPicPo();
			weiXinDepartmentPicPo.setDepartmentID(departmentsPo.getBdpdepartmentid());
			for(String stemp:stringarray){  
				weiXinDepartmentPicPo.setPicUrl(stemp);
				weiXinDepartmentsDao.insertWeiXinDepartmentPic(weiXinDepartmentPicPo);
			}  
		}
		logisticsLogDao.insertLog(logPo); //添加日志
	}
}
