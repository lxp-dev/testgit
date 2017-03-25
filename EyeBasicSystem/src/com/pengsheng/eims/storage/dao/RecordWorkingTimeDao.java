package com.pengsheng.eims.storage.dao;

import java.util.ArrayList;
import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.FirstCheckPo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.util.tools.Utility;

public interface RecordWorkingTimeDao {

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
	 * 根据销售单号更新销售基表中在途点
	 * @param salesBasicPo
	 */
	public void updateSalesBasicInTranit(SalesBasicPo salesBasicPo);
	
	/**
	 * 根据销售单号将信息插入在途明细表中
	 * @param inTransitPo
	 */
	public void insertInTranit(InTransitPo inTransitPo);
	
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
	 * 插入初检信息
	 * @param firstCheckPo
	 */
	public void insertFirstCheckPo(WorkingCheckPo workingCheckPo);
	
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
	 * 根据加工师加工在途点更新销售基表
	 * @param salesBasicPo
	 */
	public void updateSalesBasicInTranitStartWorking(SalesBasicPo salesBasicPo);
	
	/**
	 * 根据销售单号将信息插入在途明细表中
	 * @param inTransitPo
	 */
	public void insertStartWorkingInTranit(InTransitPo inTransitPo);
}
