package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.InTransitPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.MistakePo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;
import com.pengsheng.eims.system.persistence.PersonInfoPo;

public interface SamplingCheckMgr {

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
	
	/**
	 * 取出销售单中右眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getODDetailInfo(SalesBasicPo salesBasicPo);
	
	/**
	 * 取出销售单中左眼镜片信息
	 * @param salesBasicPo
	 * @return
	 */
	public SalesBasicPo getOSDetailInfo(SalesBasicPo salesBasicPo);
	
	/**
	 * 新增检验信息
	 * @param inTransitPo
	 * @param salesPo
	 * @param workingCheckPo
	 */
	public void insertWorkingCheck(InTransitPo inTransitPo , SalesBasicPo salesPo , WorkingCheckPo workingCheckPo,LogisticsLogPo logPo);
	
	/**
	 * 取加工师下拉列表
	 * @param personInfoPo
	 * @return
	 */
	public List<PersonInfoPo> getWorkingChenkPerson(PersonInfoPo personInfoPo);
	
	/**
	 * 得到允差
	 * 
	 */
	public MistakePo getMistakeODPo(SalesBasicPo salesBasicPo);
	
	public MistakePo getMistakeOSPo(SalesBasicPo salesBasicPo);
	
	/**
	 * 获取上次检验记录
	 * @param salesBasicPo
	 * @return WorkingCheckPo
	 */
	public WorkingCheckPo getLastWorkingCheckPo(SalesBasicPo salesBasicPo);
	
	/**
	 * 检验单详细
	 * @param salesBasicPo
	 * @return
	 */
	public WorkingCheckPo getWorkingCheckPo(String salesid);
	
	/**
	 * 更新检验单抽检状态
	 * @param salesid
	 */
	public void updateWorkingCheckIsSampled(String salesid);
}
