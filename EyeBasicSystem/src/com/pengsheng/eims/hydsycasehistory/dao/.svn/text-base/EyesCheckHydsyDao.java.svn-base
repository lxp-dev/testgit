package com.pengsheng.eims.hydsycasehistory.dao;

import java.util.List;

import com.pengsheng.eims.hydsycasehistory.persistence.EyesCheckPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;

public interface EyesCheckHydsyDao {

	public int getEyesCheckCount(EyesCheckPo po);
	
	public List<EyesCheckPo> getEyesCheckList(EyesCheckPo po,int start, int size);
	
	public void insertEyesCheck(EyesCheckPo po);
	
	public EyesCheckPo getEyesCheck(EyesCheckPo po);
	/**
	 * 查询费用提交数量
	 * @param po
	 * @return
	 */
	public int getEyecChargePutCount(RegisteredCategoryPo po);
	
	/**
	 * 显示费用提交信息并分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<RegisteredCategoryPo> getEyesChargePutList(RegisteredCategoryPo po,int start, int size);
}
