package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.CustomerTakeDao;
import com.pengsheng.eims.sales.dao.GuitarManagementDao;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.InTransitStorageEntryPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.InTransitDao;
import com.pengsheng.eims.storage.mgr.InTransitMgr;
import com.pengsheng.eims.system.dao.BillKeyDao;
import com.pengsheng.eims.system.dao.SystemParameterDao;
import com.pengsheng.eims.system.persistence.SystemParameterPo;
import com.pengsheng.eims.util.tools.Utility;

public class InTransitMgrImpl implements InTransitMgr {
	
	private InTransitDao inTransitDao;	
	private LogisticsLogDao logisticsLogDao;	
	private BillKeyDao billKeyDao;
	private GuitarManagementDao guitarManagementDao;
	private CustomerTakeDao customerTakeDao;
	private SystemParameterPo systemParameterPo;
	private SystemParameterDao systemParameterDao;
	
	public SystemParameterPo getSystemParameterPo() {
		return systemParameterPo;
	}

	public void setSystemParameterPo(SystemParameterPo systemParameterPo) {
		this.systemParameterPo = systemParameterPo;
	}

	public SystemParameterDao getSystemParameterDao() {
		return systemParameterDao;
	}

	public void setSystemParameterDao(SystemParameterDao systemParameterDao) {
		this.systemParameterDao = systemParameterDao;
	}

	public CustomerTakeDao getCustomerTakeDao() {
		return customerTakeDao;
	}

	public void setCustomerTakeDao(CustomerTakeDao customerTakeDao) {
		this.customerTakeDao = customerTakeDao;
	}

	public GuitarManagementDao getGuitarManagementDao() {
		return guitarManagementDao;
	}

	public void setGuitarManagementDao(GuitarManagementDao guitarManagementDao) {
		this.guitarManagementDao = guitarManagementDao;
	}

	public BillKeyDao getBillKeyDao() {
		return billKeyDao;
	}

	public void setBillKeyDao(BillKeyDao billKeyDao) {
		this.billKeyDao = billKeyDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	public InTransitDao getInTransitDao() {
		return inTransitDao;
	}

	public void setInTransitDao(InTransitDao inTransitDao) {
		this.inTransitDao = inTransitDao;
	}

	/**
	 * 查询所有部门信息
	 */
	public List<DepartmentsPo> getDepartmentsList(DepartmentsPo departmentsPo) {
		
		return inTransitDao.getDepartmentsList(departmentsPo);
	}

	/**
	 * 查询在途状态数量
	 */
	public int getInTransitCount(SalesBasicPo po) {
		
		return inTransitDao.getInTransitCount(po);
	}

	/**
	 * 分页
	 */
	public List<SalesBasicPo> getInTransitList(SalesBasicPo po, int start,
			int size) {
		
		return inTransitDao.getInTransitList(po, start, size);
	}
	/**
	 * 查询在途状态
	 * @param po
	 * @return
	 */
	public SalesBasicPo getInTransit(SalesBasicPo po){
		return inTransitDao.getInTransit(po);
	}
	/**
	 * 修改在途状态
	 * @param po
	 * @return
	 */
	public void updateInTransit(SystemParameterPo systemParameterPo,InTransitPo inTransitPo,List<InTransitPo> inTransitList,LogisticsLogPo logPo){
		//销售主表在途状态调整
		inTransitDao.updateSalesBasicInTransit(inTransitPo);
		
		//在途状态插入
		int istake = 0;
        for(InTransitPo transitPo:inTransitList){
			istake = billKeyDao.selectProcurementOrderForType(transitPo.getSseitstate(),transitPo.getSseitsalesid());
			if(istake == 0){
				inTransitDao.insertInTransit(transitPo);
			} 
			
			if ((Utility.getName(transitPo.getSseitstate()).equals("13") && Utility.getName(inTransitPo.getSseitidordetype()).equals("4")) || !Utility.getName(inTransitPo.getSseitidordetype()).equals("4")){
				InTransitStorageEntryPo opo = new InTransitStorageEntryPo();
				opo.setCshtsebillid(transitPo.getSseitsalesid());		
				guitarManagementDao.deleteInTransitStroge(opo);
			}

			if (Utility.getName(transitPo.getSseitstate()).equals("13") && Utility.getName(systemParameterPo.getFspsplitsalesdataflag()).equals("1")){			
				// 将配镜单送至已完结的表中
				customerTakeDao.insertSalesBasicFinished(transitPo.getSseitsalesid());
				customerTakeDao.insertSalesDetailFinished(transitPo.getSseitsalesid());
				customerTakeDao.deleteSalesBasic(transitPo.getSseitsalesid());
				customerTakeDao.deleteSalesDetail(transitPo.getSseitsalesid());
			}
			
        }
		//日志处理
		logisticsLogDao.insertLog(logPo); //添加日志
	}
	
	/**
	 * 查询在途Po
	 * @param po
	 * @return
	 */
	public InTransitPo getInTransitPo(InTransitPo po){
		return inTransitDao.getInTransitPo(po);
	}

	/**
	 * 微信中定制类型待取镜配镜单数量
	 * @param po
	 * @return
	 */
	public int getWeiXinDingzhiDaiqujingCount(String customID){
		return inTransitDao.getWeiXinDingzhiDaiqujingCount(customID);
	}
}
