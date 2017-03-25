package com.pengsheng.eims.storage.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.DepartmentsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.storage.persistence.WorkingCheckPo;

public interface PrintWorkingCheckMgr {

	/**
	 * 得到打印检验单信息数量
	 * @param salesBasicPo
	 * @return
	 */
	public int getPrintWorkingCheckCount(SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo);
	
	/**
	 * 查询打印检验单信息
	 * @param salesBasicPo
	 * @param start
	 * @param size
	 * @return
	 */
	public List<WorkingCheckPo> selectPrintWorkingCheck(SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo , int start , int size);
	
	/**
	 * 得到部门列表
	 * @param departmentsPo
	 * @return
	 */
	public List<DepartmentsPo> getdepartment(DepartmentsPo departmentsPo);
	
	public int getSampledCheckCount(SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo);
	
	public List<WorkingCheckPo> selectSampledCheck(SalesBasicPo salesBasicPo , WorkingCheckPo workingCheckPo, int start, int size);
	
	/**
	 * 得到抽检记录
	 * @param salesid
	 * @return WorkingCheckPo
	 */
	public WorkingCheckPo getSampledCheckPo(String salesid);
}
