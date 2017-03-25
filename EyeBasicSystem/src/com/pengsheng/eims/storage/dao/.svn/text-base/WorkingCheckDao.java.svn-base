package com.pengsheng.eims.storage.dao;

import java.util.List;

import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.MistakePo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface WorkingCheckDao {
	
	/**
	 * 得到检验信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getWorkingCheckCount(SalesBasicPo salesBasicPo);
	
	/**
	 * 得到检验信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<SalesBasicPo> selectWorkingCheck(SalesBasicPo salesBasicPo , int start , int size);
	
	/**
	 * 得到顾客信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getCustomerInfo(SalesBasicPo salesBasicPo);
	public SalesBasicPo getCustomerInfoFinished(SalesBasicPo salesBasicPo);
	
	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo);
	public SalesBasicPo getODDetailInfoFinished(SalesBasicPo salesBasicPo);
	
	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo);
	public SalesBasicPo getOSDetailInfoFinished(SalesBasicPo salesBasicPo);
	
	/**
	 * 更新销售基表中的在途点
	 * @param salesDetailPo
	 */
	public void updateWorkingCheckInTransit(SalesBasicPo salesBasicPo);
	
	/**
	 * 根据销售单号将信息插入在途明细表中
	 * @param inTransitPo
	 */
	public void insertIntrnsitInfo(InTransitPo inTransitPo);
	
	/**
	 * 取加工师下拉列表
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonInfoPo> getWorkingChenkPerson(PersonInfoPo personInfoPo);
	
	/**
	 * 插入加工检验表 
	 * @param workingCheckPo
	 */
	public void insertWorkingCheck(WorkingCheckPo workingCheckPo);
	/*
	 * 得到允差
	 */
	public MistakePo getMistakeSphPo(SalesBasicPo salesBasicPo,String type);
	
	public MistakePo getMistakeCylPo(SalesBasicPo salesBasicPo,String type);
	
	public MistakePo getMistakeAxesODPo(SalesBasicPo salesBasicPo,String type);
	
	public MistakePo getMistakeAxesOSPo(SalesBasicPo salesBasicPo,String type);
	
	public MistakePo getMistakeAddODPo(SalesBasicPo salesBasicPo,String type);
	
	public MistakePo getMistakeAddOSPo(SalesBasicPo salesBasicPo,String type);
	
	public MistakePo getMistakeTjPo(SalesBasicPo salesBasicPo,String type);
	
	public MistakePo getMistakeSCPo(SalesBasicPo salesBasicPo,String type) ;
	
	/**
	 * 等到上次检验记录
	 * @param salesBasicPo
	 * @return
	 */
	public WorkingCheckPo getLastWorkingCheckPo(SalesBasicPo salesBasicPo);
	
	/**
	 * 检验单详细
	 * @param salesBasicPo
	 * @return
	 */
	public WorkingCheckPo getWorkingCheckPo(String salesid);
	
	/**
	 * 取出销售单镜架信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getFrameDetailInfo(SalesBasicPo salesBasicPo);
	public SalesBasicPo getFrameDetailInfoFinished(SalesBasicPo salesBasicPo);
	
}
