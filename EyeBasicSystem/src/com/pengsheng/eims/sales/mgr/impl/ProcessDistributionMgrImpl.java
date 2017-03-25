package com.pengsheng.eims.sales.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.basic.persistence.WarehousePo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.DoorStoreDeliveryDao;
import com.pengsheng.eims.sales.dao.ProcessDistributionDao;
import com.pengsheng.eims.sales.mgr.ProcessDistributionMgr;
import com.pengsheng.eims.sales.persistence.DistributionEntryPo;
import com.pengsheng.eims.sales.persistence.DistributionPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;

public class ProcessDistributionMgrImpl implements ProcessDistributionMgr{
	private LogisticsLogDao logisticsLogDao;
	
	private DoorStoreDeliveryDao doorStoreDeliveryDao;
	
	public DoorStoreDeliveryDao getDoorStoreDeliveryDao() {
		return doorStoreDeliveryDao;
	}

	public void setDoorStoreDeliveryDao(DoorStoreDeliveryDao doorStoreDeliveryDao) {
		this.doorStoreDeliveryDao = doorStoreDeliveryDao;
	}

	public LogisticsLogDao getLogisticsLogDao() {
		return logisticsLogDao;
	}

	public void setLogisticsLogDao(LogisticsLogDao logisticsLogDao) {
		this.logisticsLogDao = logisticsLogDao;
	}

	private ProcessDistributionDao processDistributionDao;

	public SalesBasicPo salesBasicPo;
	
	public SalesBasicPo getSalesBasicPo() {
		return salesBasicPo;
	}

	public void setSalesBasicPo(SalesBasicPo salesBasicPo) {
		this.salesBasicPo = salesBasicPo;
	}

	public ProcessDistributionDao getProcessDistributionDao() {
		return processDistributionDao;
	}

	public void setProcessDistributionDao(
			ProcessDistributionDao processDistributionDao) {
		this.processDistributionDao = processDistributionDao;
	}

	/** 
	 * 查询隐形订做片配送信息
	 * @return
	 */
	public List<SalesBasicPo> getSalesBasicPos(SalesBasicPo salesBasicPo) {
		return processDistributionDao.getSalesBasicPos(salesBasicPo);
	}

	/**
	 * 获取门店
	 * @param po
	 * @return
	 */
	public List<WarehousePo> getWarehouseList(DepartmentsPo po) {
		return processDistributionDao.getWarehouseList(po);
	}
	public List<WarehousePo> getWarehouseList(SalesBasicPo po){
		return processDistributionDao.getWarehouseList(po);
	}

	/**
	 * 新增配送记录主表
	 * @param po
	 */
	public void insertDistribution(DistributionPo distributionPo) {

		processDistributionDao.insertDistribution(distributionPo);
	}

	/**
	 * 新增配送记录明细表
	 * @param po
	 */
	public void insertDistributionEntry(DistributionEntryPo distributionEntryPo) {
		
	}

	/**
	 * 新增在途查询明细表信息
	 * @param po
	 */
	public void insertInTransit(InTransitPo inTransitPo) {
		processDistributionDao.insertInTransit(inTransitPo);
	}

	/**
	 * 修改加工配送在途状态
	 * @return
	 */
	public void updateSalesBasicPos(String[] ssesbsalesid,InTransitPo inTransitPo, DistributionPo distributionPo,LogisticsLogPo logPo) 
	{
		salesBasicPo=new SalesBasicPo();
		DistributionEntryPo distributionEntryPo=new DistributionEntryPo();
		String id=processDistributionDao.insertDistribution(distributionPo);
		for(int i=0;i<ssesbsalesid.length;i++)
		{
			salesBasicPo.setSsesbsalesid(ssesbsalesid[i]);
			InTransitPo inTransitPo1 =new InTransitPo();
			inTransitPo1.setSseitsalesid(ssesbsalesid[i]);
			inTransitPo1 = doorStoreDeliveryDao.selectInTransit(inTransitPo1);
			if(Integer.parseInt(inTransitPo1.getSseitstate())<10)
			{
				processDistributionDao.updateSalesBasicPos(salesBasicPo);
				inTransitPo.setSseitsalesid(ssesbsalesid[i]);
				processDistributionDao.insertInTransit(inTransitPo);
				distributionEntryPo.setSdndesalesid(ssesbsalesid[i]);
				distributionEntryPo.setSdndedistributionid(id);
				distributionEntryPo.setSdndeorderstype(ssesbsalesid[i]);
				logPo.setsLogContent(ssesbsalesid[i]);
				logisticsLogDao.insertLog(logPo);  //新增日志
				processDistributionDao.insertDistributionEntry(distributionPo,distributionEntryPo);
			}
		}
		
	}

}
