package com.pengsheng.eims.casehistory.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.casehistory.persistence.EyesCheckPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;

public interface EyesCheckNMgr {

	public int getEyesCheckCount(EyesCheckPo po);
	
	public List<EyesCheckPo> getEyesCheckList(EyesCheckPo po,int start, int size);
	
	public void insertEyesCheck(EyesCheckPo po,LogisticsLogPo logPo);
	
	public EyesCheckPo getEyesCheck(EyesCheckPo po);
	/**
	 * 查询费用提交数量
	 * @param po
	 * @return
	 */
	public int getEyesChargePutCount(RegisteredCategoryPo po);
	
	/**
	 * 显示费用提交信息并分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<RegisteredCategoryPo> getEyesChargePutList(RegisteredCategoryPo po,int start, int size);

}
