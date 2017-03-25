package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.FirstCheckPo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;

public interface RecordWorkingTimeMgr {

	/**
	 * 得到记录加工时间信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getRecordWorkingTimeCount(SalesBasicPo salesBasicPo);
	
	/**
	 * 得到记录加工时间信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectRecordWorkingTime(SalesBasicPo salesBasicPo , int start , int size);
	
	/**
	 * 新增记录加工时间信息
	 * @param salesPo
	 * @param inTransitPo
	 */
	public void insertRecordWorkingTime(SalesBasicPo salesPo,InTransitPo inTransitPo,WorkingCheckPo workingCheckPo,LogisticsLogPo logPo);
	
	/**
	 * 得到部门列表
	 * @param departmentsPo
	 * @return
	 */
	public List<DepartmentsPo> getdepartment(DepartmentsPo departmentsPo);
	
	/**
	 * 初检新增数据加载
	 * @param salesid
	 * @return
	 */
	public List<FirstCheckPo> getFirstChecks(String salesid);
	
	/**
	 * 得到初检记录数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getRecordWorkingCheckCount(SalesBasicPo salesBasicPo) ;

	/**
	 * 得到初检记录信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectRecordWorkingCheck(SalesBasicPo salesBasicPo, int start, int size);
	
	/**
	 * 初检记录数据加载
	 * @param salesid
	 * @return
	 */
	public WorkingCheckPo getFirstChecksDetails(String salesid);
	
	/**
	 * 新增记录加工时间信息old
	 * @param salesPo
	 * @param inTransitPo
	 */
	public void insertRecordWorkingTimeEasy(SalesBasicPo salesPo,
			InTransitPo inTransitPo,LogisticsLogPo logPo);
	
	/**
	 * 加工师加工Count
	 * @param salesBasicPo
	 * @return
	 */
	public int selectStartWorkingCount(SalesBasicPo salesBasicPo);

	/**
	 * 加工师加工List
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectStartWorkingList(SalesBasicPo salesBasicPo, int start, int size);
	
	/**
	 * 加工师加工在途信息插入及更新
	 * @param salesPo
	 * @param inTransitPo
	 */
	public void updateStartWorkingState(SalesBasicPo salesPo,InTransitPo inTransitPo,LogisticsLogPo logPo);
}
