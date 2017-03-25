package com.pengsheng.eims.storage.mgr.impl;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.dao.LogisticsLogDao;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.dao.DoorStoreDeliveryDao;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.dao.RecordWorkingTimeDao;
import com.pengsheng.eims.storage.mgr.RecordWorkingTimeMgr;
import com.pengsheng.eims.storage.persistence.FirstCheckPo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;

public class RecordWorkingTimeMgrImpl implements RecordWorkingTimeMgr {
	private LogisticsLogDao logisticsLogDao;
	
	public DoorStoreDeliveryDao doorStoreDeliveryDao;
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

	
	private RecordWorkingTimeDao recordWorkingTimeDao;
	
	public RecordWorkingTimeDao getRecordWorkingTimeDao() {
		return recordWorkingTimeDao;
	}

	public void setRecordWorkingTimeDao(RecordWorkingTimeDao recordWorkingTimeDao) {
		this.recordWorkingTimeDao = recordWorkingTimeDao;
	}

	/**
	 * 得到记录加工时间信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getRecordWorkingTimeCount(SalesBasicPo salesBasicPo) {
		return recordWorkingTimeDao.getRecordWorkingTimeCount(salesBasicPo);
	}

	/**
	 * 得到记录加工时间信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectRecordWorkingTime(
			SalesBasicPo salesBasicPo, int start, int size) {
		return recordWorkingTimeDao.selectRecordWorkingTime(salesBasicPo, start, size);
	}

	/**
	 * 得到部门列表
	 * @param departmentsPo
	 * @return
	 */
	public List<DepartmentsPo> getdepartment(DepartmentsPo departmentsPo) {
		return recordWorkingTimeDao.getdepartment(departmentsPo);
	}

	/**
	 * 新增记录加工时间信息
	 * @param salesPo
	 * @param inTransitPo
	 */
	public void insertRecordWorkingTime(SalesBasicPo salesPo,
			InTransitPo inTransitPo,WorkingCheckPo workingCheckPo,LogisticsLogPo logPo) {
		
		InTransitPo inTransitPo1 =new InTransitPo();
		inTransitPo1.setSseitsalesid(salesPo.getSsesbsalesid());
		inTransitPo1 = doorStoreDeliveryDao.selectInTransit(inTransitPo1);
		if(Integer.parseInt(inTransitPo1.getSseitstate())<7)
		{
			logisticsLogDao.insertLog(logPo);  //新增日志
			
			recordWorkingTimeDao.insertFirstCheckPo(workingCheckPo);
			
			recordWorkingTimeDao.updateSalesBasicInTranit(salesPo);
			
			recordWorkingTimeDao.insertInTranit(inTransitPo);
		}
	}
	
	/**
	 * 新增记录加工时间信息old
	 * @param salesPo
	 * @param inTransitPo
	 */
	public void insertRecordWorkingTimeEasy(SalesBasicPo salesPo,
			InTransitPo inTransitPo,LogisticsLogPo logPo) {
		
		InTransitPo inTransitPo1 =new InTransitPo();
		inTransitPo1.setSseitsalesid(salesPo.getSsesbsalesid());
		inTransitPo1 = doorStoreDeliveryDao.selectInTransit(inTransitPo1);
		if(Integer.parseInt(inTransitPo1.getSseitstate())<7)
		{
			logisticsLogDao.insertLog(logPo);  //新增日志
			
			recordWorkingTimeDao.updateSalesBasicInTranit(salesPo);
			
			recordWorkingTimeDao.insertInTranit(inTransitPo);
		}
	}

	/**
	 * 初检新增数据加载
	 * @param salesid
	 * @return
	 */
	public List<FirstCheckPo> getFirstChecks(String salesid){
		return recordWorkingTimeDao.getFirstChecks(salesid);
	}
	
	/**
	 * 得到初检记录数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getRecordWorkingCheckCount(SalesBasicPo salesBasicPo) {
		return recordWorkingTimeDao.getRecordWorkingCheckCount(salesBasicPo);
	}

	/**
	 * 得到初检记录信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectRecordWorkingCheck(SalesBasicPo salesBasicPo, int start, int size){
		return recordWorkingTimeDao.selectRecordWorkingCheck(salesBasicPo, start, size);
	}
	
	/**
	 * 初检记录数据加载
	 * @param salesid
	 * @return
	 */
	public WorkingCheckPo getFirstChecksDetails(String salesid){
		return recordWorkingTimeDao.getFirstChecksDetails(salesid);
	}
	
	/**
	 * 加工师加工Count
	 * @param salesBasicPo
	 * @return
	 */
	public int selectStartWorkingCount(SalesBasicPo salesBasicPo){
		return recordWorkingTimeDao.selectStartWorkingCount(salesBasicPo);
	}

	/**
	 * 加工师加工List
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectStartWorkingList(SalesBasicPo salesBasicPo, int start, int size){
		return recordWorkingTimeDao.selectStartWorkingList(salesBasicPo, start, size);
	}
	
	/**
	 * 加工师加工在途信息插入及更新
	 * @param salesPo
	 * @param inTransitPo
	 */
	public void updateStartWorkingState(SalesBasicPo salesPo,InTransitPo inTransitPo,LogisticsLogPo logPo) {
		
		InTransitPo inTransitPo1 =new InTransitPo();
		inTransitPo1.setSseitsalesid(salesPo.getSsesbsalesid());
		inTransitPo1 = doorStoreDeliveryDao.selectInTransit(inTransitPo1);
		if(Integer.parseInt(inTransitPo1.getSseitstate())<8)
		{
			logisticsLogDao.insertLog(logPo);  //新增日志
			
			recordWorkingTimeDao.updateSalesBasicInTranitStartWorking(salesPo);
			
			recordWorkingTimeDao.insertStartWorkingInTranit(inTransitPo);
		}
	}

}
