/**
 * 
 */
package com.pengsheng.eims.sales.mgr;

import java.util.List;

import com.pengsheng.eims.basic.persistence.ChuzhikaPo;
import com.pengsheng.eims.logistics.persistence.LogisticsLogPo;
import com.pengsheng.eims.sales.persistence.CashCouponPo;
import com.pengsheng.eims.sales.persistence.RegisteredDetailsPo;
import com.pengsheng.eims.sales.persistence.SalesBasicPo;
import com.pengsheng.eims.sales.persistence.SalesLogPo;
import com.pengsheng.eims.system.persistence.RegisteredCategoryPo;

/**
 * @author Liuqian
 * 
 */
public interface RegisteredMgr {

	/**
	 * 按条件检索检查费用项目进行管理
	 * 
	 * @param flag
	 *            启用停用标示位 1:启用 0：停用
	 * @param feeType
	 *            收费类型 1:缴费 2：退费
	 * @return List
	 */
	public List<RegisteredCategoryPo> getSelValue(String flag, String feeType);
	
	/**
	 * 查询所有收费项目
	 */
	public List<RegisteredCategoryPo> getRepairsCostList();

	/**
	 * 检索当天顾客挂号未结款所有挂号费用
	 * 
	 * @param customerid
	 * @return
	 */
	public List<RegisteredDetailsPo> getRegisteredDetails(String customerid);

	/**
	 * 检索当天顾客挂号未结款所有挂号费用
	 * 
	 * @param customerid
	 * @param typeFlag:1:挂号;2:退挂号；
	 * @return
	 */
	public List<RegisteredDetailsPo> getRegisteredDetails(String customerid,String typeFlag);
	
	/**
	 * 新增挂号明细表信息
	 * 
	 * @param detailsPos
	 */
	public void insertRegisteredDetails(List<RegisteredDetailsPo> detailsPos, SalesBasicPo salesBasicPo, List<SalesLogPo> salesLogPos ,List<ChuzhikaPo> czklist ,List<CashCouponPo> djqlist, LogisticsLogPo logPo);
	/**
	 * 新增挂号明细表信息
	 * 
	 * @param detailsPos
	 */
	public void insertRegisteredDetails2(List<RegisteredDetailsPo> detailsPos, SalesBasicPo salesBasicPo, List<SalesLogPo> salesLogPos ,List<ChuzhikaPo> czklist ,List<CashCouponPo> djqlist, LogisticsLogPo logPo);

	/**
	 * 新增维修明细表信息
	 * 
	 * @param detailsPos
	 */
	public void insertRepairsCostDetails(List<RegisteredDetailsPo> detailsPos, SalesBasicPo salesBasicPo, List<SalesLogPo> salesLogPos ,List<ChuzhikaPo> czklist ,List<CashCouponPo> djqlist, LogisticsLogPo logPo);
	/**
	 * 新增维修明细表信息
	 * 
	 * @param detailsPos
	 */
	public void insertRepairsCostDetails2(List<RegisteredDetailsPo> detailsPos, SalesBasicPo salesBasicPo, List<SalesLogPo> salesLogPos ,List<ChuzhikaPo> czklist ,List<CashCouponPo> djqlist, LogisticsLogPo logPo);
	/**
	 * 查询当日个人挂号金额汇总
	 */
	public RegisteredDetailsPo getRegisteredPersonSumToday(String departmentID,String personID);
}
