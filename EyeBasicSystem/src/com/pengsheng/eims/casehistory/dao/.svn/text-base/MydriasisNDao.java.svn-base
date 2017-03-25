package com.pengsheng.eims.casehistory.dao;

import java.util.List;

import com.pengsheng.eims.casehistory.persistence.MydriasisPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.RegisteredPrintDetailsPo;

public interface MydriasisNDao {

	
	public int getMydriasisCount(MydriasisPo po);
	
	public List<MydriasisPo> getMydriasisList(MydriasisPo po,int start, int size);

	public void insertMydriasis(MydriasisPo po);
	
	public MydriasisPo getMydriasis(MydriasisPo po);
	
	/**
	 * 新增明细表信息
	 * @param po
	 */
	public void insertRegisteredDetails(RegisteredDetailsPo po);
	/**
	 * 查询费用提交数量
	 * @param po
	 * @return
	 */
	public int getChargePutCount(RegisteredCategoryPo po);
	
	/**
	 * 显示费用提交信息并分页
	 * @param po
	 * @param start
	 * @param size
	 * @return
	 */
	public List<RegisteredCategoryPo> getChargePutList(RegisteredCategoryPo po,int start, int size);
	/**
	 * 根据条件查询
	 * @param po
	 * @return
	 */
	public RegisteredCategoryPo getChargePut(RegisteredCategoryPo po);
	/**
	 * 修改挂号类别表
	 * @param po
	 */
	public void updateRegisteredCategory(RegisteredCategoryPo po);
	/**
	 * 修改挂号明细表
	 * @param po
	 */
	public void urpateRegisteredPrintDetails(RegisteredPrintDetailsPo po);
}
