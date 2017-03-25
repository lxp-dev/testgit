package com.pengsheng.eims.bjtrhistory.mgr;

import java.util.List;

import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.bjtrhistory.persistence.MydriasisPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;
import com.pengsheng.eims.system.persistence.RegisteredPrintDetailsPo;

public interface MydriasisBjtrMgr {
	
	public int getMydriasisCount(MydriasisPo po);
	
	public List<MydriasisPo> getMydriasisList(MydriasisPo po,int start, int size);
	
	/**
	 * 新增散瞳检查
	 * @param po
	 */
	public void insertMydriasis(MydriasisPo po,LogisticsLogPo logPo);
	
	public MydriasisPo getMydriasis(MydriasisPo po);
	
	
	/**
	 * 新增挂号明细表信息
	 * @param po
	 */
	public void insertRegisteredDetails(RegisteredDetailsPo po,LogisticsLogPo logPo);
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
	 * 修改费用提交
	 * @param po
	 */
	public void updateRegisteredCategory(RegisteredCategoryPo po,List<RegisteredPrintDetailsPo> list);
	
	/**
	 * 修改挂号明细表
	 * @param po
	 */
	public void urpateRegisteredPrintDetails(RegisteredPrintDetailsPo po);
}
